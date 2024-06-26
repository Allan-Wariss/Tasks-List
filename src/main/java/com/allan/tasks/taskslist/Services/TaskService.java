package com.allan.tasks.taskslist.Services;

import com.allan.tasks.taskslist.Domain.Task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.allan.tasks.taskslist.Repositories.TaskRepository;
import com.allan.tasks.taskslist.Repositories.TaskRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public ResponseEntity<String> addTask(TaskRequestDTO taskRequestDTO){
        Task task = new Task (taskRequestDTO.title(),
                taskRequestDTO.description(),
                taskRequestDTO.date(),
                taskRequestDTO.duration()
        );
        taskRepository.save(task);
        return new ResponseEntity<>("Tarefa adicionada com sucesso", HttpStatus.OK);
    }

    public List<Task> findTaskByTitle(String title){
        return taskRepository.findByTitleContainingIgnoreCase(title);
    }

    public Optional<Task> searchTask(String id){
        return taskRepository.findById(id);
    }

    public ResponseEntity<String> editTask(String id, TaskRequestDTO task){
        Optional<Task> taskOptional = searchTask(id);
        if(taskOptional.isPresent()){
            Task taskForEdit = taskOptional.get();
            if(task.title() != null) taskForEdit.setTitle(task.title());
            if(task.description() != null) taskForEdit.setDescription(task.description());
            if(task.date() != null) taskForEdit.setDate(task.date());
            if(task.duration() != null) taskForEdit.setDuration(task.duration());
            taskRepository.save(taskForEdit);
            return new ResponseEntity<>("Tarefa alterada com sucesso", HttpStatus.OK);
        }
        return new ResponseEntity<>("Tarefa não encontrada", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deleteTask(String id){
        Optional<Task> taskForDelete = searchTask(id);
        if(taskForDelete.isPresent()){
            taskRepository.delete(taskForDelete.get());
            return new ResponseEntity<>("Tarefa excluída com sucesso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tarefa não encontrada", HttpStatus.NOT_FOUND);
        }
    }
}
