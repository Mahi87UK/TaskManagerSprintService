package com.example.controller;

import com.example.model.ParentTask;
import com.example.model.Task;
import com.example.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/taskInfo")
@CrossOrigin(value = "*")
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;


    @RequestMapping(value = "allTasks", method = RequestMethod.GET)
    public ResponseEntity<Object> getTasks() {
        return new ResponseEntity<>(taskRepo.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "viewTask/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<Object> viewTask(@PathVariable(value = "taskId") Integer id) {
        return new ResponseEntity<>(taskRepo.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "addTask")
    public ResponseEntity<Object> addTask(@Valid @RequestBody Task task) {
        ParentTask parentTask = taskRepo.findParentTaskByName(task.getParentTask().getParentTaskName());
        if (parentTask != null) {
            task.setParentTask(parentTask);
        }
        return new ResponseEntity<>(taskRepo.save(task), HttpStatus.OK);
    }

    @RequestMapping(value = "updateTask/{taskId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateTask(@PathVariable(value = "taskId") Integer id, @RequestBody Task task) {
        Task taskData = taskRepo.findById(id).orElse(null);
        if (taskData != null) {
            return new ResponseEntity<>(taskRepo.save(task), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
