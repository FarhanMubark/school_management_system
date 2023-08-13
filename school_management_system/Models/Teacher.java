package com.example.school_management_system.Models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotNull(message = "Id Should not be empty")
    private Integer id;
    @NotEmpty(message = "name Should not be empty")
    private String name;
    @NotNull(message = "salary Should not be empty")
    private Integer salary;
}
