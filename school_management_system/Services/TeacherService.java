package com.example.school_management_system.Services;


import com.example.school_management_system.Models.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeachers(Teacher teacher){
        teachers.add(teacher);
    }

    public Boolean updateTeachers(int id, Teacher teacher){
        for (int i =0; i<teachers.size();i++){
            if (teachers.get(i).getId()==id){
                teachers.set(i, teacher);

                return true;
            }
        }
        return false;
    }

    public  Boolean deleteTeachers(int id){
        for (int i=0;i<teachers.size();i++){
            if (teachers.get(i).getId()==id){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }



    public Teacher searchById(int id){
        for (int i=0;i<teachers.size();i++){
            if (teachers.get(i).getId()==id){
                return teachers.get(i);
            }
        }

        return new Teacher(0,"null",0);
    }


}
