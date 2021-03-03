package com.XS.dao;

import com.XS.pojo.ExamScope;
import com.XS.pojo.ExamScopeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamScopeMapper {
    long countByExample(ExamScopeExample example);

    int deleteByExample(ExamScopeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExamScope record);

    int insertSelective(ExamScope record);

    List<ExamScope> selectByExample(ExamScopeExample example);

    ExamScope selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExamScope record, @Param("example") ExamScopeExample example);

    int updateByExample(@Param("record") ExamScope record, @Param("example") ExamScopeExample example);

    int updateByPrimaryKeySelective(ExamScope record);

    int updateByPrimaryKey(ExamScope record);
}