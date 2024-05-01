package com.allan.tasks.taskslist.Repositories;

import com.allan.tasks.taskslist.Domain.Task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, String> {
    List<Task> findByTitleContainingIgnoreCase(String substring);
}
