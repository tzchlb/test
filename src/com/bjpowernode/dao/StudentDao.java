package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

public interface StudentDao {
    Student getById(String id);
    void save(Student student);

    List<Student> getAll();
}
