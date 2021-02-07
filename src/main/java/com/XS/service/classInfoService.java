package com.XS.service;

import com.XS.pojo.Classinfo;

import java.util.List;

public interface classInfoService {
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

}
