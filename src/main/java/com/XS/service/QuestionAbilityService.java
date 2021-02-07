package com.XS.service;

import com.XS.pojo.QuestionAbility;

import java.util.List;

public interface QuestionAbilityService {
    //增加一个核心能力
    int addAbility(QuestionAbility ability);

    //根据核心能力id查询核心能力
    QuestionAbility queryAbilityById(int id);

    //根据核心能力名称查询核心能力
    QuestionAbility queryAbilityByName(String Name);

    //根据核心能力id删除核心能力
    int deleteAbilityById(int id);

    //根据核心能力名称删除核心能力
    int deleteAbilityByName(String Name);

    //更新核心能力
    int updateAbility(QuestionAbility ability);

    //查询所有核心能力 返回list合集
    List<QuestionAbility> queryAllAbility();
}
