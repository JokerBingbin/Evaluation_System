package com.XS.controller;

import com.XS.pojo.*;
import com.XS.service.ClassService;
import com.XS.service.QuestionService;
import com.XS.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("Class")
public class ClassController {


    private ClassService testService;
    private ScoreService scoreService;
    private QuestionService questionService;
    @Autowired
    public void setTestService(ClassService testService) {
        this.testService = testService;
    }

    @Autowired
    public void setScoreService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
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
    public String AddExam(String name,String time,Integer classId,Integer number,Model model){
        Exam exam = new Exam();
        List<Exam> exams = testService.allExam();
        exam.setId(exams.get(exams.size()-1).getId()+1);
        exam.setName(name);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(time);
            exam.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "allClass";
        }
        exam.setClassid(classId);
        Classinfo classinfo = testService.queryClassById(classId);
        Grade grade = testService.queryGradeByName(classinfo.getGrade());
        Subject subject = testService.querySubjectByName(classinfo.getSubject());
        List<QuestionAbility> questionAbilities = questionService.queryQuestionAbility(subject.getId(), grade.getId());
        List<QuestionDifficulty> questionDifficulties = questionService.queryQuestionDiff(subject.getId(), grade.getId());
        List<QuestionScope> questionScopes = questionService.queryQuestionScope(subject.getId(), grade.getId());
        List<QuestionType> questionTypes = questionService.queryQuestionType(subject.getId(), grade.getId());

        System.out.println("classId"+classId);
        System.out.println(exam.getClassid());
        model.addAttribute("exam",exam);
        model.addAttribute("number",number);
        model.addAttribute("questionAbilities",questionAbilities);
        model.addAttribute("questionDiffs",questionDifficulties);
        model.addAttribute("questionScopes",questionScopes);
        model.addAttribute("questionTypes",questionTypes);
//        System.out.println(exam.getTime());
        return "addQuestion";
    }

    @RequestMapping("addExamFinal")
    public String addExamFinal(Exam exam,QuestionInfoList questionInfoList){
//        testService.addExam(exam);                                 //写入操作
//        System.out.println(exam.toString());
        List<QuestionInfo> list = questionInfoList.getList();
        List<ExamDiff> diffs = new ArrayList<ExamDiff>();
        List<ExamAbility> abilities = new ArrayList<ExamAbility>();
        List<ExamScope> scopes = new ArrayList<ExamScope>();
        List<ExamType> types = new ArrayList<ExamType>();
        int i = 1;
        for(QuestionInfo info : list){
            info.setExamid(exam.getId());
            info.setQustionid(i);
            i++;
            int flag = 0;
            for(ExamDiff diff : diffs){
                if(info.getDifficulty().equals(diff.getName())){
                    flag = 1;
                    diff.setScore(diff.getScore()+info.getScore());
                }
            }
            if(flag == 0){
                ExamDiff diff = new ExamDiff();
                diff.setExamid(exam.getId());
                diff.setName(info.getDifficulty());
                diff.setScore(info.getScore());
                diffs.add(diff);
            }
            flag = 0;
            for(ExamAbility ability:abilities){
                if(info.getAbility().equals(ability.getName())){
                    flag = 1;
                    ability.setScore(ability.getScore()+info.getScore());
                }
            }
            if(flag == 0){
                ExamAbility ability = new ExamAbility();
                ability.setExamid(exam.getId());
                ability.setName(info.getAbility());
                ability.setScore(info.getScore());
                abilities.add(ability);
            }
            flag = 0;
            for(ExamScope scope : scopes){
                if(info.getScope().equals(scope.getName())){
                    flag = 1;
                    scope.setScore(scope.getScore()+info.getScore());
                }
            }
            if(flag == 0){
                ExamScope scope = new ExamScope();
                scope.setExamid(exam.getId());
                scope.setName(info.getScope());
                scope.setScore(info.getScore());
                scopes.add(scope);
            }
            flag = 0;
            for(ExamType type : types){
                if(info.getType().equals(type.getName())){
                    flag = 1;
                    type.setScore(type.getScore()+info.getScore());
                }
            }
            if(flag == 0){
                ExamType type = new ExamType();
                type.setExamid(exam.getId());
                type.setName(info.getType());
                type.setScore(info.getScore());
                types.add(type);
            }
            System.out.println(info.toString());
//            testService.addQuestionInfo(info);            //写入操作
        }
//        System.out.println("难度");
        for(ExamDiff diff:diffs){
            System.out.println(diff.getName()+":"+diff.getScore());
//            scoreService.addExamDiff(diff);                //写入操作
        }
//        System.out.println("能力");
        for(ExamAbility ability:abilities){
//            scoreService.addExamAbility(ability);         //写入操作
            System.out.println(ability.getName()+":"+ability.getScore());
        }
//        System.out.println("知识范围");
        for(ExamScope scope:scopes){
//            scoreService.addExamScope(scope);           //写入操作
            System.out.println(scope.getName()+":"+scope.getScore());
        }
//        System.out.println("题型");
        for(ExamType type:types){
//            scoreService.addExamType(type);              //写入操作
            System.out.println(type.getName()+":"+type.getScore());
        }
        List<Student> students = testService.ClassStudent(exam.getClassid());
        StudentScoreWrite write = new StudentScoreWrite();
        write.setExamid(exam.getId());
        write.setIswrite(0);
        for(Student student:students){
            write.setStudentid(student.getId());
//            testService.addStudentWrite(write);//写入操作
        }
        return "addSuccess";
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

        //计算知识范围的平均得分
        List<StudentScoreWrite> scoreWrites = scoreService.queryWriteStudent(examId);
        for (int i = 0; i < scoreWrites.size(); i++) {
            StudentScoreWrite write =  scoreWrites.get(i);
        }
        float[] scopeAverage = new float[studentScopes.size()];
        float[] abilityAverage = new float[studentAbilities.size()];
        for(StudentScoreWrite student1 : scoreWrites){
            for(int i = 0;i<studentScopes.size();i++){
                StudentScope scope = studentScopes.get(i);
                scopeAverage[i] += scoreService.queryStudentScopeScore(student1.getStudentid(),examId,scope.getName()).getScore();
            }
            for(int i = 0;i<studentAbilities.size();i++){
                StudentAbility ability = studentAbilities.get(i);
                abilityAverage[i] += scoreService.queryStudentAbilityScore(student1.getStudentid(),examId,ability.getName()).getScore();
            }
        }
        for(int i = 0;i<scopeAverage.length;i++){
            scopeAverage[i] /= scoreWrites.size();
        }
        for(int i = 0;i<abilityAverage.length;i++){
            abilityAverage[i] /= scoreWrites.size();
        }

        java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");

        //每一题的平均分
        float averageSum = 0;
        float[] average = new float[questionInfos.size()];
        for(int i=0;i<questionInfos.size();i++){
            for(StudentScoreWrite scoreWrite : scoreWrites){
                average[i] += scoreService.queryQuestionScore(scoreWrite.getStudentid(),examId,i+1);
            }
            average[i] /= scoreWrites.size();
            df.format(average[i]);
            averageSum += average[i];
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
        model.addAttribute("scopeAverage",scopeAverage);
        model.addAttribute("abilityAverage",abilityAverage);
        model.addAttribute("average",average);
        model.addAttribute("averageSum",averageSum);
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

    @RequestMapping("studentExam")
    public String studentExam(Integer studentId,Integer classId,Model model){
        List<Exam>  exams= testService.ClassExam(classId);
        List<StudentScoreWrite> list = scoreService.queryStudentExamScoreWrite(studentId);
        model.addAttribute("exams",exams);
        model.addAttribute("scoreWrite",list);
        return "studentExam";
    }

    @RequestMapping("toUpdateClass")
    public String toUpdateClass(Integer classId,Model model){
        Classinfo classInfo = testService.queryClassById(classId);
        model.addAttribute("classInfo",classInfo);
        return "updateClass";
    }

    @RequestMapping("updateClass")
    public String updateClass(Classinfo classinfo){
        testService.updateClass(classinfo);
        return "redirect:/Class/allClass";
    }
}
