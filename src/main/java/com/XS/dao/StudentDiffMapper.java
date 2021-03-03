package com.XS.dao;

import com.XS.pojo.StudentDiff;
import com.XS.pojo.StudentDiffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentDiffMapper {
    long countByExample(StudentDiffExample example);

    int deleteByExample(StudentDiffExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentDiff record);

    int insertSelective(StudentDiff record);

    List<StudentDiff> selectByExample(StudentDiffExample example);

    StudentDiff selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentDiff record, @Param("example") StudentDiffExample example);

    int updateByExample(@Param("record") StudentDiff record, @Param("example") StudentDiffExample example);

    int updateByPrimaryKeySelective(StudentDiff record);

    int updateByPrimaryKey(StudentDiff record);
}