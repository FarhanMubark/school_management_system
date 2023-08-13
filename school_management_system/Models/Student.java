package com.example.school_management_system.Models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotNull(message = "Id Should not be empty")
    @Min(2)
    private Integer id;
    @NotEmpty(message = "name Should not be empty")
    private String name;
    @NotEmpty(message = "major Should not be empty")
    private String major;
}
