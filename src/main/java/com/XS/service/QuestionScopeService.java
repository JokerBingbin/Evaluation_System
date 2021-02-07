package com.XS.service;

import com.XS.pojo.QuestionScope;

import java.util.List;

public interface QuestionScopeService {
    //增加一个知识范围
    int addScope(QuestionScope scope);

    //根据知识范围id查询知识范围
    QuestionScope queryScopeById(int id);

    //根据知识范围名称查询知识范围
    QuestionScope queryScopeByName(String Name);

    //根据知识范围id删除知识范围
    int deleteScopeById(int id);

    //根据知识范围名称删除知识范围
    int deleteScopeByName(String Name);

    //更新知识范围
    int updateScope(QuestionScope scope);

    //查询所有知识范围 返回list合集
    List<QuestionScope> queryAllScope();
}
