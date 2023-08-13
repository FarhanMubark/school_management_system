package com.example.school_management_system.Controllers;

import com.example.school_management_system.ApiResponse.ApiResponse;
import com.example.school_management_system.Models.Teacher;
import com.example.school_management_system.Services.TeacherService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    final private TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeachers(){
        ArrayList<Teacher> teachers = teacherService.getTeachers();
        return ResponseEntity.status(200).body(teachers);
    }

    @PostMapping("/add")
    public ResponseEntity addTeachers(@RequestBody @Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

        teacherService.addTeachers(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher is added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeachers(@PathVariable int id, @RequestBody @Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

        boolean isfound = teacherService.updateTeachers(id, teacher);
        if (isfound) {
            return ResponseEntity.status(200).body(new ApiResponse("Teacher is updated"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Id not found"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id){
        boolean isFound = teacherService.deleteTeachers(id);
        if (isFound){
            return ResponseEntity.status(200).body(new ApiResponse("Teacher is Deleted !"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Id not found"));
    }

    @GetMapping("/get-byid/{id}")
    public ResponseEntity searchbyId(@PathVariable int id){
        Teacher isFound = teacherService.searchById(id);

        if (isFound.getId()<1){
            return ResponseEntity.status(400).body(new ApiResponse("Teacher not found"));
    }
        return ResponseEntity.status(200).body(isFound);
    }

}
