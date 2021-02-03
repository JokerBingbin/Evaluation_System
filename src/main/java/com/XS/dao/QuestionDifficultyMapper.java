package com.XS.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.XS.pojo.QuestionDifficulty;
import com.XS.pojo.QuestionDifficultyExample;

public interface QuestionDifficultyMapper {
    long countByExample(QuestionDifficultyExample example);

    int deleteByExample(QuestionDifficultyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QuestionDifficulty record);

    int insertSelective(QuestionDifficulty record);

    List<QuestionDifficulty> selectByExample(QuestionDifficultyExample example);

    QuestionDifficulty selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QuestionDifficulty record, @Param("example") QuestionDifficultyExample example);

    int updateByExample(@Param("record") QuestionDifficulty record, @Param("example") QuestionDifficultyExample example);

    int updateByPrimaryKeySelective(QuestionDifficulty record);

    int updateByPrimaryKey(QuestionDifficulty record);
}