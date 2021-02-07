package com.XS.service;

import com.XS.pojo.QuestionType;

import java.util.List;

public interface QuestionTypeService {
    //增加一个题目类型
    int addType(QuestionType type);

    //根据题目类型id查询题目类型
    QuestionType queryTypeById(int id);

    //根据题目类型名称查询题目类型
    QuestionType queryTypeByName(String Name);

    //根据题目类型id删除题目类型
    int deleteTypeById(int id);

    //根据题目类型名称删除题目类型
    int deleteTypeByName(String Name);

    //更新题目类型
    int updateType(QuestionType type);

    //查询所有题目类型 返回list合集
    List<QuestionType> queryAllType();
}
