package com.XS.dao;

import java.util.List;

import com.XS.pojo.QuestionInfo;
import com.XS.pojo.QuestionInfoExample;
import org.apache.ibatis.annotations.Param;

public interface QuestionInfoMapper {
    long countByExample(QuestionInfoExample example);

    int deleteByExample(QuestionInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QuestionInfo record);

    int insertSelective(QuestionInfo record);

    List<QuestionInfo> selectByExample(QuestionInfoExample example);

    QuestionInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QuestionInfo record, @Param("example") QuestionInfoExample example);

    int updateByExample(@Param("record") QuestionInfo record, @Param("example") QuestionInfoExample example);

    int updateByPrimaryKeySelective(QuestionInfo record);

    int updateByPrimaryKey(QuestionInfo record);
}