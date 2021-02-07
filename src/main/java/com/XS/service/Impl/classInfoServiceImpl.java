package com.XS.service.Impl;

import com.XS.dao.ClassinfoMapper;
import com.XS.pojo.Classinfo;
import com.XS.pojo.ClassinfoExample;
import com.XS.service.classInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class classInfoServiceImpl implements classInfoService {

    private ClassinfoMapper classinfoMapper;

    @Autowired
    public void setClassinfoMapper(ClassinfoMapper classinfoMapper) {
        this.classinfoMapper = classinfoMapper;
    }


    public int addClass(Classinfo classinfo) {

        return 0;
    }

    public Classinfo queryClassById(int id) {
        return null;
    }

    public Classinfo queryClassByName(String className) {
        return null;
    }

    public int deleteClassById(int id) {
        return 0;
    }

    public int deleteClassByName(String className) {
        return 0;
    }

    public int updateClass(Classinfo classinfo) {
        return 0;
    }

    public List<Classinfo> queryAllClass() {
        ClassinfoExample example = new ClassinfoExample();
        List<Classinfo> list = classinfoMapper.selectByExample(example);
        return list;
    }
}
