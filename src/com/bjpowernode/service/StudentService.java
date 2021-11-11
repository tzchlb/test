package com.bjpowernode.service;

import com.bjpowernode.domain.Student;

import java.util.List;

public interface StudentService {
    Student getById(String id);
    void save(Student student);

    List<Student> getAll();
}
