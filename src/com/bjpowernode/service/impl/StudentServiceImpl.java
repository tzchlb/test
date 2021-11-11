package com.bjpowernode.service.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.util.SqlSessionUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);

    @Override
    public Student getById(String id) {
        Student student = studentDao.getById(id);
        return student;
    }

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = studentDao.getAll();
        return students;
    }
}
