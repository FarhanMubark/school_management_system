package com.example.school_management_system.Controllers;

import com.example.school_management_system.ApiResponse.ApiResponse;
import com.example.school_management_system.Models.Student;
import com.example.school_management_system.Services.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    final private StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudent(){
        ArrayList<Student> students = studentService.getStudents();

        return ResponseEntity.status(200).body(students);
    }


    @PostMapping("/add")
    public ResponseEntity addStudents(@RequestBody @Valid Student student, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudents(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student is Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @RequestBody @Valid Student student, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

        studentService.updateStudent(id,student);
        return ResponseEntity.status(200).body(new ApiResponse("Student is updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStduent(@PathVariable int id){
        boolean isFound = studentService.deleteStduent(id);
        if (isFound){
            return ResponseEntity.status(200).body(new ApiResponse("Student is Deleted !"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Id not found"));
    }

    @GetMapping("/get-byname/{name}")
    public ResponseEntity searchByName(@PathVariable String name){
        Student isFound = studentService.searchbyname(name);
        if (isFound.getId()<1){
            return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
        }
        return ResponseEntity.status(200).body(isFound);
    }

}

