package com.example.student.service.impl;

import com.example.student.data.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.repository.impl.StudentRepositoryImpl;
import com.example.student.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository = new StudentRepositoryImpl();

    public Student findByFullName(String fullName) {
        return studentRepository.findByFullName(fullName);
    }

    public List<Student> findByGroup(String groupName) {
        return studentRepository.findByGroup(groupName);
    }

    public List<Student> findByGroupId(Long groupId) {
        return studentRepository.findByGroupId(groupId);
    }

    public void saveOrUpdate(Student student) {
        if (student.getId() == null) {
            long id = findAll().size();
            student.setId(++id);
            studentRepository.save(student);
        } else {
            studentRepository.update(student);
        }
    }

    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void remove(Long id) {
        studentRepository.remove(id);
    }
}
