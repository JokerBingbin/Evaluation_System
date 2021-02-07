package com.XS.service;

import com.XS.pojo.QuestionDifficulty;

import java.util.List;

public interface QuestionDifficultyService {
    //增加一个题目难度
    int addDifficulty(QuestionDifficulty difficulty);

    //根据题目难度id查询题目难度
    QuestionDifficulty queryDifficultyById(int id);

    //根据题目难度名称查询题目难度
    QuestionDifficulty queryDifficultyByName(String Name);

    //根据题目难度id删除题目难度
    int deleteDifficultyById(int id);

    //根据题目难度名称删除题目难度
    int deleteDifficultyByName(String Name);

    //更新题目难度
    int updateDifficulty(QuestionDifficulty difficulty);

    //查询所有题目难度 返回list合集
    List<QuestionDifficulty> queryAllDifficulty();
}
