package com.XS.service;

import com.XS.pojo.Grade;

import java.util.List;

public interface GradeService {
    //增加一个年级
    int addGrade(Grade grade);

    //根据年级id查询年级
    Grade queryGradeById(int id);

    //根据年级名称查询年级
    Grade queryGradeByName(String GradeName);

    //根据年级id删除年级
    int deleteGradeById(int id);

    //根据年级名称删除年级
    int deleteGradeByName(String GradeName);

    //更新年级
    int updateGrade(Grade grade);

    //查询所有年级 返回list合集
    List<Grade> queryAllGrade();
}
