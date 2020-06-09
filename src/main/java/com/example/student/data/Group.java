package com.example.student.data;

import java.util.List;

public class Group extends AbstractData<Group> {

    private String groupName;
    private Student student;
    private String uq;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getUq() {
        return uq;
    }

    public void setUq(String uq) {
        this.uq = uq;
    }
}
