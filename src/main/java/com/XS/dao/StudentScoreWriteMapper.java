package com.XS.dao;

import com.XS.pojo.StudentScoreWrite;
import com.XS.pojo.StudentScoreWriteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentScoreWriteMapper {
    long countByExample(StudentScoreWriteExample example);

    int deleteByExample(StudentScoreWriteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentScoreWrite record);

    int insertSelective(StudentScoreWrite record);

    List<StudentScoreWrite> selectByExample(StudentScoreWriteExample example);

    StudentScoreWrite selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentScoreWrite record, @Param("example") StudentScoreWriteExample example);

    int updateByExample(@Param("record") StudentScoreWrite record, @Param("example") StudentScoreWriteExample example);

    int updateByPrimaryKeySelective(StudentScoreWrite record);

    int updateByPrimaryKey(StudentScoreWrite record);
}