package com.XS.dao;

import com.XS.pojo.QuestionScope;
import com.XS.pojo.QuestionScopeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionScopeMapper {
    long countByExample(QuestionScopeExample example);

    int deleteByExample(QuestionScopeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QuestionScope record);

    int insertSelective(QuestionScope record);

    List<QuestionScope> selectByExample(QuestionScopeExample example);

    QuestionScope selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QuestionScope record, @Param("example") QuestionScopeExample example);

    int updateByExample(@Param("record") QuestionScope record, @Param("example") QuestionScopeExample example);

    int updateByPrimaryKeySelective(QuestionScope record);

    int updateByPrimaryKey(QuestionScope record);
}