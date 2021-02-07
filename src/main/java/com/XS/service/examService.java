package com.XS.service;

import com.XS.pojo.Exam;

import java.util.List;

public interface examService {
    //增加一个考试
    int addExam(Exam exam);

    //根据考试id查询考试
    Exam queryExamById(int id);

    //根据考试名称查询考试
    Exam queryExamByName(String ExamName);

    //根据考试id删除考试
    int deleteExamById(int id);

    //根据考试名称删除考试
    int deleteExamByName(String ExamName);

    //更新考试
    int updateExam(Exam exam);

    //查询所有考试 返回list合集
    List<Exam> queryAllExam();
    
}
