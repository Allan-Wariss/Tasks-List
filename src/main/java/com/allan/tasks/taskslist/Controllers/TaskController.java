package com.allan.tasks.taskslist.Controllers;

import com.allan.tasks.taskslist.Domain.Task.Task;
import com.allan.tasks.taskslist.Repositories.TaskRepository;
import com.allan.tasks.taskslist.Repositories.TaskRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.allan.tasks.taskslist.Services.TaskService;

import java.util.List;


@RestController
@RequestMapping("tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;


    @PostMapping("/add")
    public ResponseEntity<String> addTask(@RequestBody TaskRequestDTO task){
        return taskService.addTask(task);
    }


    @PutMapping("/edit/{taskId}")
    public ResponseEntity<String> editTask(@PathVariable String taskId, @RequestBody TaskRequestDTO task){
        return taskService.editTask(taskId, task);
    }


    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable String taskId){
        return taskService.deleteTask(taskId);
    }

    @GetMapping("/find/{title}")
    public List<Task> findTaskByTitle(@PathVariable String title){
        return taskService.findTaskByTitle(title);
    }

    @GetMapping("/findAll")
    public List<Task> findAll(){
        return taskRepository.findAll();
    }
}
