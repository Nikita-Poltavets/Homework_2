package com.example.student.repository;

import com.example.student.data.Group;

public interface GroupRepository extends AbstractRepository<Group> {

    Group findByGroupName(String groupName);
    Group findByStudent(String studentName);
    Group findByStudentId(Long id);
    Group findByUq(String uq);
}
