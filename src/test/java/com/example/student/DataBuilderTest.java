package com.example.student;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.example.student.builder.DataBuilder;
import com.example.student.config.ApplicationEnvironment;
import com.example.student.data.Student;
import com.example.student.data.Group;
import com.example.student.service.StudentService;
import com.example.student.service.GroupService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataBuilderTest {

    @BeforeAll
    public static void setEnv() {
        ApplicationEnvironment.setPropertyLang("en");
    }

    @Test
    public void build() {

        DataBuilder dataBuilder = new DataBuilder();
        GroupService groupService = dataBuilder.getGroupService();
        StudentService studentService = dataBuilder.getStudentService();
        dataBuilder.buildDataList();

        List<Group> allGroups = groupService.findAll();
        List<Student> allStudents = studentService.findAll();

        Student student = new Student();
        String studentFullName = "John Quincy Adams";
        student.setFullName(studentFullName);

        List<Group> groupList = new ArrayList<>();
        String groupName = "Basketball";

        Group group = new Group();
        group.setGroupName(groupName);
        groupService.saveOrUpdate(group);
        groupList.add(groupService.findByGroupName(groupName));

        student.setGroupList(groupList);
        studentService.saveOrUpdate(student);

        groupService.findAll().forEach(currentGroup -> {
            List<Student> students = studentService.findByGroup(currentGroup.getGroupName());
            students.forEach(currentStudent -> {
                group.setStudent(currentStudent);
                groupService.saveOrUpdate(currentGroup);
            });
        });

        //Group Service
        assertEquals(group, groupService.findByStudent("John Quincy Adams"));
        assertEquals(group, groupService.findByGroupName("Basketball"));
        assertEquals(group, groupService.findByStudentId(student.getId()));
        group.setGroupName("Rugby");
        groupService.saveOrUpdate(group);
        assertEquals(group, groupService.findByGroupName("Rugby"));
        assertEquals(group, groupService.findById(group.getId()));
        assertEquals(allGroups, groupService.findAll());
        assertEquals(10, groupService.findAll().size());
        groupService.remove((long) 1);
        assertEquals(9, groupService.findAll().size());


        //Student Service
        assertEquals(student, studentService.findByFullName("John Quincy Adams"));
        //assertEquals(student, studentService.findByGroup(group.getGroupName())); // Unnecessary square brackets are displayed
        //assertEquals(student, studentService.findByGroupId(group.getId())); // Unnecessary square brackets are displayed
        student.setFullName("Andrew Jackson");
        studentService.saveOrUpdate(student);
        assertEquals(student, studentService.findByFullName("Andrew Jackson"));
        assertEquals(student, studentService.findById(student.getId()));
        assertEquals(allStudents, studentService.findAll());
        assertEquals(6, studentService.findAll().size());
        studentService.remove((long) 1);
        assertEquals(5, studentService.findAll().size());


    }
}
