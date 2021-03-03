package com.XS.dao;

import com.XS.pojo.ExamDiff;
import com.XS.pojo.ExamDiffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamDiffMapper {
    long countByExample(ExamDiffExample example);

    int deleteByExample(ExamDiffExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExamDiff record);

    int insertSelective(ExamDiff record);

    List<ExamDiff> selectByExample(ExamDiffExample example);

    ExamDiff selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExamDiff record, @Param("example") ExamDiffExample example);

    int updateByExample(@Param("record") ExamDiff record, @Param("example") ExamDiffExample example);

    int updateByPrimaryKeySelective(ExamDiff record);

    int updateByPrimaryKey(ExamDiff record);
}