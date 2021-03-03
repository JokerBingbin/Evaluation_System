package com.XS.dao;

import com.XS.pojo.Test1;
import com.XS.pojo.Test1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Test1Mapper {
    long countByExample(Test1Example example);

    int deleteByExample(Test1Example example);

    int insert(Test1 record);

    int insertSelective(Test1 record);

    List<Test1> selectByExample(Test1Example example);

    int updateByExampleSelective(@Param("record") Test1 record, @Param("example") Test1Example example);

    int updateByExample(@Param("record") Test1 record, @Param("example") Test1Example example);
}