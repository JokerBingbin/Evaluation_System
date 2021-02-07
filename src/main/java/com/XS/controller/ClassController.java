package com.XS.controller;

import com.XS.pojo.Classinfo;
import com.XS.service.classInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("Class")
public class ClassController {
    @Autowired
    @Qualifier("classInfoServiceImpl")
    private classInfoService classInfoService;

    @RequestMapping("allClass")
    public String list(Model model){
        List<Classinfo> classinfo = classInfoService.queryAllClass();
        model.addAttribute("classlist",classinfo);
        return "allClass";

    }
}
