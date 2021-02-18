package com.XS.service;

import com.XS.dao.StudentScoreWriteMapper;
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

    Student queryStudent(String name,int classId);

    int addStudent(Student student);

    int addStudentWrite(StudentScoreWrite write);

    List<Exam> ClassExam(int classid);

    int addExam(Exam exam);

    List<QuestionInfo> getQuestion(int examId);

    List<QuestionAbility> getAbility(int classId);

    List<StudentScore> getStudentScore(int examId,int studentId);

    StudentScoreWrite isScoreWrite(int examId,int studentId);

    Student queryStudentById(int id);

    Exam queryExamById(int id);

    int addStudentScore(StudentScore score);

    int updateStudentScoreWrite(int examId,int studentId);

    List<ExamAbility> queryExamAbilityById(int examId);

    List<ExamDiff> queryExamDiffById(int examId);

    List<ExamScope> queryExamScopeById(int examId);

    List<ExamType> queryExamTypeById(int examId);

    int addStudentAbility(StudentAbility studentAbility);

    int addStudentDiff(StudentDiff studentDiff);

    int addStudentScope(StudentScope studentScope);

    int addStudentType(StudentType studentType);


}
