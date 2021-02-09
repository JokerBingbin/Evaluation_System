package com.XS.service;

import com.XS.pojo.*;

import java.util.List;

public interface TestService {
    //增加一个班级
    int addClass(Classinfo classinfo);

    //根据班级id查询班级
    Classinfo queryClassById(int id);

    //根据班级名称查询班级
    Classinfo queryClassByName(String className);

    //根据班级id删除班级
    int deleteClassById(int id);

    //根据班级名称删除班级
    int deleteClassByName(String className);

    //更新班级
    int updateClass(Classinfo classinfo);

    //查询所有班级 返回list合集
    List<Classinfo> queryAllClass();

    List<Student> ClassStudent(int classid);

    List<Exam> ClassExam(int classid);

    int addExam(Exam exam);

    List<QuestionInfo> getQuestion(int examId);
}
