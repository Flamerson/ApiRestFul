package com.todo.task.Dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record TodoRecordDto(@NotBlank String name,@NotBlank String description) {
}
