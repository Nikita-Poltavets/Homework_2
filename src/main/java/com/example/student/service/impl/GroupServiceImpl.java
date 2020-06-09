package com.example.student.service.impl;

import com.example.student.data.Group;
import com.example.student.repository.GroupRepository;
import com.example.student.repository.impl.GroupRepositoryImpl;
import com.example.student.service.GroupService;

import java.util.List;
import java.util.UUID;

public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository = new GroupRepositoryImpl();

    public Group findByGroupName(String groupName) {
        return groupRepository.findByGroupName(groupName);
    }

    public Group findByStudent(String studentName) {
        return groupRepository.findByStudent(studentName);
    }

    public Group findByStudentId(Long studentId) {
        return groupRepository.findByStudentId(studentId);
    }

    public void saveOrUpdate(Group group) {
        if (group.getId() == null) {
            long id = findAll().size();
            group.setId(++id);
            group.setUq(generateUq(UUID.randomUUID().toString()));
            groupRepository.save(group);
        } else {
            groupRepository.update(group);
        }
    }

    public Group findById(Long id) {
        return groupRepository.findById(id);
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public void remove(Long id) {
        groupRepository.remove(id);
    }

    private String generateUq(String token) {
        Group b = groupRepository.findByUq(token);
        if (b == null) {
            return token;
        } else {
            return generateUq(UUID.randomUUID().toString());
        }
    }
}
