package com.example.student.service;

import com.example.student.data.Group;

public interface GroupService extends AbstractService<Group> {

    Group findByGroupName(String groupName);
    Group findByStudent(String StudentName);
    Group findByStudentId(Long StudentId);
}
