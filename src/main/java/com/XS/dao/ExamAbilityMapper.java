package com.XS.dao;

import com.XS.pojo.ExamAbility;
import com.XS.pojo.ExamAbilityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamAbilityMapper {
    long countByExample(ExamAbilityExample example);

    int deleteByExample(ExamAbilityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExamAbility record);

    int insertSelective(ExamAbility record);

    List<ExamAbility> selectByExample(ExamAbilityExample example);

    ExamAbility selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExamAbility record, @Param("example") ExamAbilityExample example);

    int updateByExample(@Param("record") ExamAbility record, @Param("example") ExamAbilityExample example);

    int updateByPrimaryKeySelective(ExamAbility record);

    int updateByPrimaryKey(ExamAbility record);
}