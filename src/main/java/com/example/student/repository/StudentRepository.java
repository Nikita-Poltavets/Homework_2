package com.example.student.repository;

import com.example.student.data.Student;

import java.util.List;

public interface StudentRepository extends AbstractRepository<Student> {

    Student findByFullName(String fullName);
    List<Student> findByGroup(String groupName);
    List<Student> findByGroupId(Long groupId);
}
