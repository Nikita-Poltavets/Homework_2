package com.example.student.data;

import java.util.List;

public class Student extends AbstractData<Student> {

    private String fullName;
    private List<Group> groupList;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", groupList=" + groupList +
                '}';
    }
}
