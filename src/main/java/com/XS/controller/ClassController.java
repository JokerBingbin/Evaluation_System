package com.XS.controller;

import com.XS.pojo.Classinfo;
import com.XS.pojo.Exam;
import com.XS.pojo.Student;
import com.XS.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("Class")
public class ClassController {

    @Qualifier("testServiceImpl")
    private TestService testService;

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping("allClass")
    public String list(Model model){
        List<Classinfo> classinfo = testService.queryAllClass();
        model.addAttribute("classlist",classinfo);
        return "allClass";
    }

    @RequestMapping("ClassInfo")
    public String showClassInfo(int id,Model model){
        List<Student> students = testService.ClassStudent(id);
        model.addAttribute("student",students);
        List<Exam> exams = testService.ClassExam(id);
        model.addAttribute("exam",exams);
        model.addAttribute("classId",id);
        return"ClassInfo";
    }

    @RequestMapping("ToAddExam")
    public String ToAddExam(Integer classId,Model model){
        model.addAttribute("classId",classId);
        return "addExam";
    }

    @RequestMapping("addExam")
    public String AddExam(Exam exam){
        System.out.println(exam.getTime().toString());
        testService.addExam(exam);
        return "addSuccess";
    }

    @RequestMapping("examInfo")
    public String showExamInfo(Integer examId,Model model){
        List<QuestionInfo> list = testService.getQuestion(examId);
        model.addAttribute("question",list);
        return "examInfo";
    }

}
