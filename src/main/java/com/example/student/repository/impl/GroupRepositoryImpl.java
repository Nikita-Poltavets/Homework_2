package com.example.student.repository.impl;

import com.example.student.data.Group;
import com.example.student.repository.GroupRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupRepositoryImpl implements GroupRepository {

    private final List<Group> groupList = new ArrayList<>();

    public Group findByGroupName(String groupName) {
        for (Group group: groupList) {
            if (group.getGroupName().equals(groupName))
                return group;
        }
        return null;
    }

    public Group findByStudent(String studentName) {
        for (Group group: groupList) {
            if (group.getStudent().getFullName().equals(studentName))
                return group;
        }
        return null;
    }

    public Group findByStudentId(Long studentId) {
        for (Group group: groupList) {
            if (group.getStudent().getId().equals(studentId))
                return group;
        }
        return null;
    }

    @Override
    public Group findByUq(String uq) {
        for (Group group: groupList) {
            if (group.getUq().equals(uq))
                return group;
        }
        return null;
    }

    public void save(Group group) {
        groupList.add(group);
    }

    public Group findById(Long id) {
        for (Group group: groupList) {
            if (group.getId().equals(id))
                return group;
        }
        return null;
    }

    public List<Group> findAll() {
        return groupList;
    }

    public void update(Group group) {
        for (Group currentGroup : groupList) {
            if (group.getId().equals(currentGroup.getId())) {
                currentGroup.setStudent(group.getStudent());
                currentGroup.setGroupName(group.getGroupName());
            }
        }
    }

    public void remove(Long id) {
        Iterator<Group> it = groupList.iterator();

        while (it.hasNext()) {
            Group group = it.next();
            if (group.getId().equals(id))
                it.remove();
        }
    }
}
