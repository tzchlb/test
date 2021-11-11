package com.bjpowernode.test;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.service.impl.StudentServiceImpl;
import com.bjpowernode.util.ServiceFactory;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        //创建代理类对象
        StudentService service = (StudentService) ServiceFactory.getService(new StudentServiceImpl());//转业务处理,不是直接调用dao包
//        Student student = new Student();
//        student.setId("A0007");
//        student.setName("wkshizhu");
//        student.setAge(80);
//        service.save(student);
        List<Student> students = service.getAll();
        students.forEach(student -> System.out.println(student));
    }
}
