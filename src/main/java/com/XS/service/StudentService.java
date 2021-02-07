package com.XS.service;

import com.XS.pojo.Student;

import java.util.List;

public interface StudentService {
    //增加一个学生
    int addStudent(Student student);

    //根据学生id查询学生
    Student queryStudentById(int id);

    //根据学生姓名查询学生
    Student queryStudentByName(String name);

    //根据班级id查询学生，返回一个班级的学生合集list
    List<Student> queryStudentByClassId(int classId);

    //根据班级名称查询学生，返回一个班级的学生合集list
    List<Student> queryStudentByClassName(String className);

    //根据学生id删除学生
    int deleteStudentById(int id);

    //根据学生名称和班级删除学生
    int deleteStudentByName(String name, int classId);

}
