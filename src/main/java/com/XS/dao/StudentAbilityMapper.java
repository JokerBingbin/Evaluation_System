package com.XS.dao;

import com.XS.pojo.StudentAbility;
import com.XS.pojo.StudentAbilityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentAbilityMapper {
    long countByExample(StudentAbilityExample example);

    int deleteByExample(StudentAbilityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentAbility record);

    int insertSelective(StudentAbility record);

    List<StudentAbility> selectByExample(StudentAbilityExample example);

    StudentAbility selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentAbility record, @Param("example") StudentAbilityExample example);

    int updateByExample(@Param("record") StudentAbility record, @Param("example") StudentAbilityExample example);

    int updateByPrimaryKeySelective(StudentAbility record);

    int updateByPrimaryKey(StudentAbility record);
}