package com.XS.service;

import com.XS.pojo.Subject;

import java.util.List;

public interface SubjectService {
    //增加一个科目
    int addSubject(Subject subject);

    //根据科目id查询科目
    Subject querySubjectById(int id);

    //根据科目名称查询科目
    Subject querySubjectByName(String name);

    //根据科目id删除科目
    int deleteSubjectById(int id);

    //根据科目名称删除科目
    int deleteSubjectByName(String name);

    //更新科目
    int updateSubject(Subject subject);

    //查询所有科目 返回list合集
    List<Subject> queryAllSubject();
}
