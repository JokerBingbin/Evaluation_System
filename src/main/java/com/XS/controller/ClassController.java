package com.XS.controller;

import com.XS.pojo.*;
import com.XS.service.ScoreService;
import com.XS.service.TestService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("Class")
public class ClassController {


    private TestService testService;
    private ScoreService scoreService;


    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @Autowired
    public void setScoreService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    //显示所有班级
    @RequestMapping("allClass")
    public String list(Model model){
        List<Classinfo> classinfo = testService.queryAllClass();
        model.addAttribute("classlist",classinfo);
        return "allClass";
    }

    //显示班级具体信息：学生、考试列表
    @RequestMapping("ClassInfo")
    public String showClassInfo(int id,Model model){
        List<Student> students = testService.ClassStudent(id);
        model.addAttribute("students",students);
        List<Exam> exams = testService.ClassExam(id);
        model.addAttribute("exam",exams);
        model.addAttribute( "classId",id);
        return"ClassInfo";
    }

    //跳转到添加考试页面
    @RequestMapping("ToAddExam")
    public String ToAddExam(Integer classId,Model model){
        model.addAttribute("classId",classId);
        return "addExam";
    }

    //添加考试
    @RequestMapping("addExam")
    public String AddExam(Exam exam){
        System.out.println(exam.getTime().toString());
        testService.addExam(exam);
        return "addSuccess";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //显示考试题目具体信息
    @RequestMapping("examInfo")
    public String ExamInfo(Integer examId,Model model){
        List<QuestionInfo> questionInfos;
        questionInfos = testService.getQuestion(examId);
        //System.out.println(questionInfos.get(0).toString());
        model.addAttribute("question",questionInfos);
        return "examInfo";
    }

    //显示考试能力
    @RequestMapping("ability")
    public String showAbility(Integer classId,Model model){
        List<QuestionAbility> list = testService.getAbility(classId);
        model.addAttribute("ability",list);
        return "ability";
    }


    //显示本次考试学生情况
    @RequestMapping("score")
    public String showStudent(Integer classId,Integer examId,Model model){
        List<Student> students = testService.ClassStudent(classId);
        List<StudentScoreWrite> scoreWrites = new ArrayList<StudentScoreWrite>();
        for (int i = 0; i < students.size(); i++) {
            Student student =  students.get(i);
            scoreWrites.add(testService.isScoreWrite(examId,student.getId()));
        }
        model.addAttribute("student",students);
        model.addAttribute("score",scoreWrites);
        model.addAttribute("examId",examId);
        return "score";
    }


    //导入成绩
    @RequestMapping("writeScore")
    public String writeScore(Integer examId,Integer studentId,Model model){
        List<QuestionInfo> questionInfos = testService.getQuestion(examId);
        model.addAttribute("question",questionInfos);
        Student student = testService.queryStudentById(studentId);
        model.addAttribute("student",student);
        model.addAttribute("exam",testService.queryExamById(examId));

        model.addAttribute("classInfo",testService.queryClassById(student.getClassid()));


        return "writeScore";
    }

    //将成绩写入数据库
    @RequestMapping(value = "write")
    public String write(StudentScoreList list){
        List<StudentScore> studentScores = list.getList();
        List<String> diffList = list.getDiff();
        List<String> abilityList = list.getAbility();
        List<String> scopeList = list.getScope();
        List<String> typeList = list.getType();

        int examId = studentScores.get(0).getExamid();
        int studentId = studentScores.get(0).getStudentid();
        List<QuestionInfo> infos = testService.getQuestion(examId);

        List<ExamAbility> abilities = testService.queryExamAbilityById(examId);
        StudentAbility ability = new StudentAbility();
        ability.setExamid(examId);
        ability.setStudentid(studentId);
        ability.setScore((float) 0);
        for(int i=0;i<abilities.size();i++){
            ability.setName(abilities.get(i).getName());
            testService.addStudentAbility(ability);
        }

        List<ExamDiff> diffs = testService.queryExamDiffById(examId);
        StudentDiff diff = new StudentDiff();
        diff.setExamid(examId);
        diff.setStudentid(studentId);
        diff.setScore((float) 0);
        for(int i=0;i<diffs.size();i++){
            diff.setName(diffs.get(i).getName());
            testService.addStudentDiff(diff);
        }

        List<ExamScope> scopes = testService.queryExamScopeById(examId);
        StudentScope scope = new StudentScope();
        scope.setExamid(examId);
        scope.setStudentid(studentId);
        scope.setScore((float) 0);
        for(int i=0;i<scopes.size();i++){
            scope.setName(scopes.get(i).getName());
            testService.addStudentScope(scope);
        }

        List<ExamType> types = testService.queryExamTypeById(examId);
        StudentType type = new StudentType();
        type.setExamid(examId);
        type.setStudentid(studentId);
        type.setScore((float) 0);
        for(int i=0;i<types.size();i++){
            type.setName(types.get(i).getName());
            testService.addStudentType(type);
        }


        for (int i = 0; i < studentScores.size(); i++) {
            StudentScore studentScore =  studentScores.get(i);
            float score = studentScore.getScore();
            String diffName = diffList.get(i);
            System.out.print(diffName+"  ");
            String abilityName = abilityList.get(i);
            System.out.print(abilityName+"  ");
            String scopeName = scopeList.get(i);
            System.out.print(scopeName +"  ");
            String typeName =typeList.get(i);
            System.out.print(typeName + "  ");
            //更新难易程度的得分情况
            StudentDiff studentDiff = scoreService.queryStudentDiffByName(examId,studentId,diffName);
            studentDiff.setScore(studentDiff.getScore() + score);
            scoreService.updateStudentDiff(examId,studentId,diffName,studentDiff);
            //更新核心能力的得分情况
            StudentAbility studentAbility = scoreService.queryStudentAbilityByName(examId,studentId,abilityName);
            studentAbility.setScore(studentAbility.getScore() + score);
            scoreService.updateStudentAbility(examId,studentId,abilityName,studentAbility);
            //更新知识范围的得分情况
            StudentScope studentScope = scoreService.queryStudentScopeByName(examId,studentId,scopeName);
            studentScope.setScore(studentScope.getScore() + score);
            scoreService.updateStudentScope(examId,studentId,scopeName,studentScope);
            //更新题型的得分情况
            StudentType studentType = scoreService.queryStudentTypeByName(examId,studentId,typeName);
            studentType.setScore(studentType.getScore() + score);
            scoreService.updateStudentType(examId,studentId,typeName,studentType);

            testService.addStudentScore(studentScore);
        }
        testService.updateStudentScoreWrite(studentScores.get(0).getExamid(),studentScores.get(0).getStudentid());
        return "redirect:/Class/allClass";
    }

    //学生成绩评测页面
    @RequestMapping("showScore")
    public String write(Integer examId,Integer studentId,Model model){
        //查询学生本次考试所有题目的分数
        List<StudentScore> studentScores = testService.getStudentScore(examId,studentId);
        //本次考试题目的详情
        List<QuestionInfo> questionInfos = testService.getQuestion(examId);
        //本次考试的信息
        Exam exam = testService.queryExamById(examId);
        //班级的信息
        Classinfo classinfo = testService.queryClassById(exam.getClassid());
        //学生信息
        Student student = testService.queryStudentById(studentId);
        //
        List<ExamAbility> abilities = testService.queryExamAbilityById(examId);
        List<ExamDiff> diffs = testService.queryExamDiffById(examId);
        List<ExamScope> scopes = testService.queryExamScopeById(examId);
        List<ExamType> types = testService.queryExamTypeById(examId);

        List<StudentAbility> studentAbilities = scoreService.queryStudentAbilityByExamId(examId,studentId);
        List<StudentDiff> studentDiffs = scoreService.queryStudentDiffByExamId(examId,studentId);
        List<StudentScope> studentScopes = scoreService.queryStudentScopeByExamId(examId,studentId);
        List<StudentType> studentTypes = scoreService.queryStudentTypeByExamId(examId,studentId);


        //学生总分
        float sum = 0;
        for(int i=0;i<studentScores.size();i++){
            sum += studentScores.get(i).getScore();
        }
        //考试总分
        float examSum = 0;
        for(QuestionInfo questionInfo : questionInfos){
            examSum += questionInfo.getScore();
        }
        model.addAttribute("studentScore",studentScores);
        model.addAttribute("questionInfos",questionInfos);
        model.addAttribute("exam",exam);
        model.addAttribute("classinfo",classinfo);
        model.addAttribute("student",student);
        model.addAttribute("sum",sum);
        model.addAttribute("examSum",examSum);
        model.addAttribute("abilities",abilities);
        model.addAttribute("diffs",diffs);
        model.addAttribute("scopes",scopes);
        model.addAttribute("types",types);
        model.addAttribute("studentAbilities",studentAbilities);
        model.addAttribute("studentDiffs",studentDiffs);
        model.addAttribute("studentScope",studentScopes);
        model.addAttribute("studentType",studentTypes);

        return "showScore";

    }


    @RequestMapping("toAddStudent")
    public String toAddStudent(Integer classId,Model model){
        model.addAttribute("classId",classId);
        return "addStudent";
    }

    @RequestMapping("addStudent")
    public String addStudent(Student student,Integer classid){

        testService.addStudent(student);
        student = testService.queryStudent(student.getName(),student.getClassid());
        List<Exam> exams = testService.ClassExam(classid);
        StudentScoreWrite write = new StudentScoreWrite();
        write.setIswrite(0);
        write.setStudentid(student.getId());
        for (int i = 0; i < exams.size(); i++) {
            Exam exam =  exams.get(i);
            write.setExamid(exam.getId());
            testService.addStudentWrite(write);
        }
        return "redirect:/Class/allClass";
    }

    @RequestMapping("toAddClass")
    public String toAddClass(){
        return "addClass";
    }

    @RequestMapping("addClass")
    public String addClass(Classinfo classinfo){
        testService.addClass(classinfo);
        return "redirect:/Class/allClass";
    }
}
