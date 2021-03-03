package com.XS.service.Impl;

import com.XS.dao.*;
import com.XS.pojo.*;
import com.XS.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    private ClassinfoMapper classinfoMapper;
    private StudentMapper studentMapper;
    private ExamMapper examMapper;
    private QuestionInfoMapper questionInfoMapper;
    private QuestionAbilityMapper questionAbilityMapper;
    private GradeMapper gradeMapper;
    private SubjectMapper subjectMapper;
    private StudentScoreMapper studentScoreMapper;
    private StudentScoreWriteMapper studentScoreWriteMapper;
    private ExamAbilityMapper examAbilityMapper;
    private ExamDiffMapper examDiffMapper;
    private ExamScopeMapper examScopeMapper;
    private ExamTypeMapper examTypeMapper;
    private StudentAbilityMapper studentAbilityMapper;
    private StudentDiffMapper studentDiffMapper;
    private StudentScopeMapper studentScopeMapper;
    private StudentTypeMapper studentTypeMapper;


    @Autowired
    public void setClassinfoMapper(ClassinfoMapper classinfoMapper) {
        this.classinfoMapper = classinfoMapper;
    }


    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Autowired
    public void setExamMapper(ExamMapper examMapper) {
        this.examMapper = examMapper;
    }

    @Autowired
    public void setQuestionInfoMapper(QuestionInfoMapper questionInfoMapper) { this.questionInfoMapper = questionInfoMapper; }

    @Autowired
    public void setQuestionAbilityMapper(QuestionAbilityMapper questionAbilityMapper) {
        this.questionAbilityMapper = questionAbilityMapper;
    }

    @Autowired
    public void setGradeMapper(GradeMapper gradeMapper) {
        this.gradeMapper = gradeMapper;
    }

    @Autowired
    public void setSubjectMapper(SubjectMapper subjectMapper) {
        this.subjectMapper = subjectMapper;
    }

    @Autowired
    public void setStudentScoreMapper(StudentScoreMapper studentScoreMapper) {
        this.studentScoreMapper = studentScoreMapper;
    }

    @Autowired
    public void setStudentScoreWriteMapper(StudentScoreWriteMapper studentScoreWriteMapper) {
        this.studentScoreWriteMapper = studentScoreWriteMapper;
    }

    @Autowired
    public void setExamAbilityMapper(ExamAbilityMapper examAbilityMapper) {
        this.examAbilityMapper = examAbilityMapper;
    }

    @Autowired
    public void setExamDiffMapper(ExamDiffMapper examDiffMapper) {
        this.examDiffMapper = examDiffMapper;
    }

    @Autowired
    public void setExamScopeMapper(ExamScopeMapper examScopeMapper) {
        this.examScopeMapper = examScopeMapper;
    }

    @Autowired
    public void setExamTypeMapper(ExamTypeMapper examTypeMapper) {
        this.examTypeMapper = examTypeMapper;
    }

    @Autowired
    public void setStudentAbilityMapper(StudentAbilityMapper studentAbilityMapper) {
        this.studentAbilityMapper = studentAbilityMapper;
    }

    @Autowired
    public void setStudentDiffMapper(StudentDiffMapper studentDiffMapper) {
        this.studentDiffMapper = studentDiffMapper;
    }

    @Autowired
    public void setStudentScopeMapper(StudentScopeMapper studentScopeMapper) {
        this.studentScopeMapper = studentScopeMapper;
    }

    @Autowired
    public void setStudentTypeMapper(StudentTypeMapper studentTypeMapper) {
        this.studentTypeMapper = studentTypeMapper;
    }

    public int addClass(Classinfo classinfo) {

        return classinfoMapper.insert(classinfo);
    }

    public Classinfo queryClassById(int id) {
        return classinfoMapper.selectByPrimaryKey(id);
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
        ClassinfoExample example = new ClassinfoExample();
        ClassinfoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(classinfo.getId());
        return classinfoMapper.updateByExample(classinfo,example);
    }

    public List<Classinfo> queryAllClass() {
        ClassinfoExample example = new ClassinfoExample();
        List<Classinfo> list = classinfoMapper.selectByExample(example);
        return list;
    }

    public List<Student> ClassStudent(int classid){
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andClassidEqualTo(classid);
        List<Student> students = studentMapper.selectByExample(studentExample);
        return students;
    }

    public Student queryStudent(String name,int classId){
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andClassidEqualTo(classId);
        criteria.andNameEqualTo(name);
        List<Student> students = studentMapper.selectByExample(example);
        return students.get(0);
    }
    public int addStudent(Student student){

        return studentMapper.insert(student);
    }

    public int addStudentWrite(StudentScoreWrite write){
       return studentScoreWriteMapper.insert(write);
    }

    public List<Exam> ClassExam(int classid){
        ExamExample examExample = new ExamExample();
        ExamExample.Criteria criteria = examExample.createCriteria();
        criteria.andClassidEqualTo(classid);
        List<Exam> exams = examMapper.selectByExample(examExample);
        return exams;
    }

    public List<Exam> allExam(){
        ExamExample examExample = new ExamExample();
        return examMapper.selectByExample(examExample);
    }

    public int addExam(Exam exam){ return examMapper.insert(exam); }


    public List<QuestionInfo> getQuestion(int examId){
        QuestionInfoExample example = new QuestionInfoExample();
        QuestionInfoExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        try {
            List<QuestionInfo> list =  questionInfoMapper.selectByExample(example);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public List<QuestionAbility> getAbility(int classID){
        //根据id取出班级
        ClassinfoExample classinfoExample = new ClassinfoExample();
        ClassinfoExample.Criteria criteria = classinfoExample.createCriteria();
        criteria.andIdEqualTo(classID);
        List<Classinfo> classInfos = classinfoMapper.selectByExample(classinfoExample);
        Classinfo classInfo = classInfos.get(0);

        GradeExample gradeExample = new GradeExample();
        GradeExample.Criteria criteria1 = gradeExample.createCriteria();
        criteria1.andNameEqualTo(classInfo.getGrade());
        List<Grade> grades = gradeMapper.selectByExample(gradeExample);
        Grade grade = grades.get(0);

        SubjectExample subjectExample = new SubjectExample();
        SubjectExample.Criteria criteria2 = subjectExample.createCriteria();
        criteria2.andNameEqualTo(classInfo.getSubject());
        List<Subject> subjects = subjectMapper.selectByExample(subjectExample);
        Subject subject = subjects.get(0);

        QuestionAbilityExample example = new QuestionAbilityExample();
        QuestionAbilityExample.Criteria criteria3 = example.createCriteria();
        criteria3.andSubjectidEqualTo(subject.getId());
        criteria3.andGradeidEqualTo(grade.getId());
        return questionAbilityMapper.selectByExample(example);

    }

    public List<StudentScore> getStudentScore(int examId,int studentId){
        StudentScoreExample example = new StudentScoreExample();
        StudentScoreExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andStudentidEqualTo(studentId);
        return studentScoreMapper.selectByExample(example);
    }

    public StudentScoreWrite isScoreWrite(int examId,int studentId){
        StudentScoreWriteExample example = new StudentScoreWriteExample();
        StudentScoreWriteExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andStudentidEqualTo(studentId);
        return studentScoreWriteMapper.selectByExample(example).get(0);
    }

    public Student queryStudentById(int id){
        return studentMapper.selectByPrimaryKey(id);
    }

    public Exam queryExamById(int id){
        return examMapper.selectByPrimaryKey(id);
    }

    public int addStudentScore(StudentScore score){
        return studentScoreMapper.insert(score);
    }

    public int updateStudentScoreWrite(int examId,int studentId){
        StudentScoreWriteExample example = new StudentScoreWriteExample();
        StudentScoreWriteExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andStudentidEqualTo(studentId);
        List<StudentScoreWrite> writes = studentScoreWriteMapper.selectByExample(example);
        StudentScoreWrite write = writes.get(0);
        write.setIswrite(1);
        return studentScoreWriteMapper.updateByExample(write,example);
    }

    public List<ExamAbility> queryExamAbilityById(int examId) {
        ExamAbilityExample example = new ExamAbilityExample();
        ExamAbilityExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        return examAbilityMapper.selectByExample(example);
    }

    public List<ExamDiff> queryExamDiffById(int examId) {
        ExamDiffExample example = new ExamDiffExample();
        ExamDiffExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        return examDiffMapper.selectByExample(example);
    }

    public List<ExamScope> queryExamScopeById(int examId) {
        ExamScopeExample example = new ExamScopeExample();
        ExamScopeExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        return examScopeMapper.selectByExample(example);
    }

    public List<ExamType> queryExamTypeById(int examId) {
        ExamTypeExample example = new ExamTypeExample();
        ExamTypeExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        return examTypeMapper.selectByExample(example);
    }

    public int addStudentAbility(StudentAbility studentAbility) {
        return studentAbilityMapper.insert(studentAbility);
    }

    public int addStudentDiff(StudentDiff studentDiff) {
        return studentDiffMapper.insert(studentDiff);
    }

    public int addStudentScope(StudentScope studentScope) {
        return studentScopeMapper.insert(studentScope);
    }

    public int addStudentType(StudentType studentType) {
        return studentTypeMapper.insert(studentType);
    }

    public int addQuestionInfo(QuestionInfo info){
        return questionInfoMapper.insert(info);
    }

    public Grade queryGradeByName(String name){
        GradeExample example = new GradeExample();
        GradeExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        return gradeMapper.selectByExample(example).get(0);
    }

    public Subject querySubjectByName(String name){
        SubjectExample example = new SubjectExample();
        SubjectExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        return subjectMapper.selectByExample(example).get(0);
    }
}
