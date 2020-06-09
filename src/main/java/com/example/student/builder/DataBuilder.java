package com.example.student.builder;

import com.example.student.config.ApplicationEnvironment;
import com.example.student.data.Group;
import com.example.student.data.Student;
import com.example.student.service.GroupService;
import com.example.student.service.StudentService;
import com.example.student.service.impl.GroupServiceImpl;
import com.example.student.service.impl.StudentServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DataBuilder implements AbstractBuilder {

    private final StudentService studentService = new StudentServiceImpl();
    private final GroupService groupService = new GroupServiceImpl();

    @Override
    public void buildDataList() {

        for (Map.Entry<String, String> entry : getKeyValueMapByBundleProperties(ApplicationEnvironment.getPropertyLang()).entrySet()) {

            Student student = new Student();
            String studentNameProperties = String.join(" ", entry.getKey().split("_"));
            student.setFullName(studentNameProperties);

            List<Group> groupList = new ArrayList<>();
            if (entry.getValue().contains(";")) {
                List<String> groupNamePropertiesList = Arrays.asList(entry.getValue().split(";"));
                groupNamePropertiesList.forEach(groupName -> {
                    Group group = new Group();
                    group.setGroupName(groupName);
                    groupService.saveOrUpdate(group);
                    groupList.add(groupService.findByGroupName(groupName));
                });
            } else {
                Group group = new Group();
                String groupName = entry.getValue();
                group.setGroupName(groupName);
                groupService.saveOrUpdate(group);
                groupList.add(groupService.findByGroupName(groupName));
            }

            student.setGroupList(groupList);
            studentService.saveOrUpdate(student);
        }

        groupService.findAll().forEach(group -> {
            List<Student> students = studentService.findByGroup(group.getGroupName());
            students.forEach(student -> {
                group.setStudent(student);
                groupService.saveOrUpdate(group);
            });
        });

    }

    public StudentService getStudentService() {
        return studentService;
    }

    public GroupService getGroupService() {
        return groupService;
    }
}
