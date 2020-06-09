package com.example.student.service;

import com.example.student.data.Student;

import java.util.List;

public interface StudentService extends AbstractService<Student> {

    Student findByFullName(String fullName);
    List<Student> findByGroup(String groupName);
    List<Student> findByGroupId(Long groupId);
}
