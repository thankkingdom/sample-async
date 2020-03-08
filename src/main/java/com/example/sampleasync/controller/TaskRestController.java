package com.example.sampleasync.controller;

import com.example.sampleasync.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/tasks")
public class TaskRestController {
    private final TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean createNewTask() {
        taskService.heavyTask();
        return true;
    }

    @ExceptionHandler(TaskRejectedException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String handle() {
        return "too busy";
    }
}
