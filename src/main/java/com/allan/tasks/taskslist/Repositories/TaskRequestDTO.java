package com.allan.tasks.taskslist.Repositories;

import java.time.Duration;
import java.time.LocalDateTime;

public record TaskRequestDTO(String title, String description, LocalDateTime date, Duration duration) {
}
