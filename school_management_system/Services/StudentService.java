package com.example.school_management_system.Services;

import com.example.school_management_system.Models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudents(Student student){
        students.add(student);
    }

    public Boolean updateStudent(int id, Student student){
        for (int i=0;i<students.size();i++){
            if (students.get(i).getId()==id){
                students.set(i,student);
                return true;
            }
        }
        return false;
    }

    public Boolean deleteStduent(int id){
        for (int i=0;i<students.size();i++){
            if (students.get(i).getId()==id){
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student searchbyname(String name){
        for (int i=0; i<students.size();i++){
            if (students.get(i).getName().equalsIgnoreCase(name)){
                return students.get(i);
            }
        }
        return new Student(0,"null","null");
    }



}
