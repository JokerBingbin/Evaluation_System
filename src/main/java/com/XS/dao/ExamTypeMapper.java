package com.XS.dao;

import com.XS.pojo.ExamType;
import com.XS.pojo.ExamTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamTypeMapper {
    long countByExample(ExamTypeExample example);

    int deleteByExample(ExamTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExamType record);

    int insertSelective(ExamType record);

    List<ExamType> selectByExample(ExamTypeExample example);

    ExamType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExamType record, @Param("example") ExamTypeExample example);

    int updateByExample(@Param("record") ExamType record, @Param("example") ExamTypeExample example);

    int updateByPrimaryKeySelective(ExamType record);

    int updateByPrimaryKey(ExamType record);
}