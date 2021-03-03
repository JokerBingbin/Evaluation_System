package com.XS.dao;

import com.XS.pojo.StudentScope;
import com.XS.pojo.StudentScopeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentScopeMapper {
    long countByExample(StudentScopeExample example);

    int deleteByExample(StudentScopeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentScope record);

    int insertSelective(StudentScope record);

    List<StudentScope> selectByExample(StudentScopeExample example);

    StudentScope selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentScope record, @Param("example") StudentScopeExample example);

    int updateByExample(@Param("record") StudentScope record, @Param("example") StudentScopeExample example);

    int updateByPrimaryKeySelective(StudentScope record);

    int updateByPrimaryKey(StudentScope record);
}