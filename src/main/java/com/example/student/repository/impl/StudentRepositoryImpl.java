package com.example.student.repository.impl;

import com.example.student.data.Group;
import com.example.student.data.Student;
import com.example.student.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    private final List<Student> studentList = new ArrayList<>();

    public Student findByFullName(final String fullName) {
        for (Student student: studentList) {
            if (student.getFullName().equals(fullName))
                return student;
        }
        return null;
    }

    public List<Student> findByGroup(String groupName) {
        List<Student> students = new ArrayList<>();

        for (Student student: studentList) {
            for (Group group : student.getGroupList()) {
                if ((group.getGroupName().equals(groupName))) {
                    students.add(student);
                }
            }
        }
        return students;
    }

    public List<Student> findByGroupId(Long groupId) {
        List<Student> students = new ArrayList<>();

        for (Student student: studentList) {
            for (Group group : student.getGroupList()) {
                if ((group.getId().equals(groupId)))
                    students.add(student);
            }
        }
        return students;
    }

    public void save(Student student) {
        studentList.add(student);
    }

    public Student findById(Long id) {
        for (Student student: studentList) {
            if (student.getId().equals(id))
                return student;
        }
        return null;
    }

    public List<Student> findAll() {
        return studentList;
    }

    public void update(Student student) {
        for (Student currentStudent : studentList) {
            if (student.getId().equals(currentStudent.getId())) {
                currentStudent.setGroupList(student.getGroupList());
                currentStudent.setFullName(student.getFullName());
            }
        }
    }

    public void remove(Long id) {
        Iterator<Student> it = studentList.iterator();

        while (it.hasNext()) {
            Student student = it.next();
            if (student.getId().equals(id))
                it.remove();
        }
    }
}
