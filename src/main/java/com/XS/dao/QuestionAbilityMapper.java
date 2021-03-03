package com.XS.dao;

import com.XS.pojo.QuestionAbility;
import com.XS.pojo.QuestionAbilityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionAbilityMapper {
    long countByExample(QuestionAbilityExample example);

    int deleteByExample(QuestionAbilityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QuestionAbility record);

    int insertSelective(QuestionAbility record);

    List<QuestionAbility> selectByExample(QuestionAbilityExample example);

    QuestionAbility selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QuestionAbility record, @Param("example") QuestionAbilityExample example);

    int updateByExample(@Param("record") QuestionAbility record, @Param("example") QuestionAbilityExample example);

    int updateByPrimaryKeySelective(QuestionAbility record);

    int updateByPrimaryKey(QuestionAbility record);
}