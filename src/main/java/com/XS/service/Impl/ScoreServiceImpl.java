package com.XS.service.Impl;

import com.XS.dao.*;
import com.XS.pojo.*;
import com.XS.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    StudentScoreMapper studentScoreMapper;
    ExamDiffMapper examdiffMapper;
    ExamTypeMapper examTypeMapper;
    ExamAbilityMapper examAbilityMapper;
    ExamScopeMapper examScopeMapper;
    StudentDiffMapper studentDiffMapper;
    StudentAbilityMapper studentAbilityMapper;
    StudentScopeMapper studentScopeMapper;
    StudentTypeMapper studentTypeMapper;
    StudentScoreWriteMapper studentScoreWriteMapper;
    StudentMapper studentMapper;
    ExamMapper examMapper;

    @Autowired
    public void setStudentScoreMapper(StudentScoreMapper studentScoreMapper) {
        this.studentScoreMapper = studentScoreMapper;
    }

    @Autowired
    public void setExamdiffMapper(ExamDiffMapper examdiffMapper) {
        this.examdiffMapper = examdiffMapper;
    }

    @Autowired
    public void setExamTypeMapper(ExamTypeMapper examTypeMapper) {
        this.examTypeMapper = examTypeMapper;
    }

    @Autowired
    public void setExamAbilityMapper(ExamAbilityMapper examAbilityMapper) {
        this.examAbilityMapper = examAbilityMapper;
    }

    @Autowired
    public void setExamScopeMapper(ExamScopeMapper examScopeMapper) {
        this.examScopeMapper = examScopeMapper;
    }

    @Autowired
    public void setStudentDiffMapper(StudentDiffMapper studentDiffMapper) {
        this.studentDiffMapper = studentDiffMapper;
    }

    @Autowired
    public void setStudentAbilityMapper(StudentAbilityMapper studentAbilityMapper) {
        this.studentAbilityMapper = studentAbilityMapper;
    }

    @Autowired
    public void setStudentScopeMapper(StudentScopeMapper studentScopeMapper) {
        this.studentScopeMapper = studentScopeMapper;
    }

    @Autowired
    public void setStudentTypeMapper(StudentTypeMapper studentTypeMapper) {
        this.studentTypeMapper = studentTypeMapper;
    }

    @Autowired
    public void setStudentScoreWriteMapper(StudentScoreWriteMapper studentScoreWriteMapper) {
        this.studentScoreWriteMapper = studentScoreWriteMapper;
    }

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }
    @Autowired
    public void setExamMapper(ExamMapper examMapper) {
        this.examMapper = examMapper;
    }



    public int addExamDiff(ExamDiff examDiff) {
        return examdiffMapper.insert(examDiff);
    }

    public int updateExamDiffById(int id, ExamDiff examDiff) {
        ExamDiffExample example = new ExamDiffExample();
        ExamDiffExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return examdiffMapper.updateByExample(examDiff,example);

    }

    public int updateExamDiff(int examId, String name, ExamDiff examDiff) {
        ExamDiffExample example = new ExamDiffExample();
        ExamDiffExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andNameEqualTo(name);
        return examdiffMapper.updateByExample(examDiff,example);

    }


    public List<ExamDiff> queryExamDiffByExamId(int examId) {
        ExamDiffExample example = new ExamDiffExample();
        ExamDiffExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        return examdiffMapper.selectByExample(example);
    }

    public List<ExamDiff> queryExamDiffByName(int examId, String name) {
        ExamDiffExample example = new ExamDiffExample();
        ExamDiffExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andNameEqualTo(name);
        return examdiffMapper.selectByExample(example);
    }

    public int addExamScope(ExamScope examScope) {
        return examScopeMapper.insert(examScope);
    }

    public int updateExamScopeById(int id, ExamScope examScope) {
        ExamScopeExample example = new ExamScopeExample();
        ExamScopeExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return examScopeMapper.updateByExample(examScope,example);
    }

    public int updateExamScope(int examId, String name, ExamScope examScope) {
        ExamScopeExample example = new ExamScopeExample();
        ExamScopeExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andNameEqualTo(name);
        return examScopeMapper.updateByExample(examScope,example);
    }

    public List<ExamScope> queryExamScopeByExamId(int examId) {
        ExamScopeExample example = new ExamScopeExample();
        ExamScopeExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        return examScopeMapper.selectByExample(example);
    }

    public List<ExamScope> queryExamScopeByName(int examId, String name) {
        ExamScopeExample example = new ExamScopeExample();
        ExamScopeExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andNameEqualTo(name);
        return examScopeMapper.selectByExample(example);
    }

    public int addExamType(ExamType examType) {
        return examTypeMapper.insert(examType);
    }

    public int updateExamTypeById(int id, ExamType examType) {
        ExamTypeExample example = new ExamTypeExample();
        ExamTypeExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return examTypeMapper.updateByExample(examType,example);
    }

    public int updateExamType(int examId, String name, ExamType examType) {
        ExamTypeExample example = new ExamTypeExample();
        ExamTypeExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andNameEqualTo(name);
        return examTypeMapper.updateByExample(examType,example);
    }

    public List<ExamType> queryExamTypeByExamId(int examId) {
        ExamTypeExample example = new ExamTypeExample();
        ExamTypeExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        return examTypeMapper.selectByExample(example);
    }

    public List<ExamType> queryExamTypeByName(int examId, String name) {
        ExamTypeExample example = new ExamTypeExample();
        ExamTypeExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andNameEqualTo(name);
        return examTypeMapper.selectByExample(example);
    }

    public int addExamAbility(ExamAbility examAbility) {
        return examAbilityMapper.insert(examAbility);
    }

    public int updateExamAbilityById(int id, ExamAbility examAbility) {
        ExamAbilityExample example = new ExamAbilityExample();
        ExamAbilityExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return examAbilityMapper.updateByExample(examAbility,example);
    }

    public int updateExamAbility(int examId, String name, ExamAbility examAbility) {
        ExamAbilityExample example = new ExamAbilityExample();
        ExamAbilityExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andNameEqualTo(name);
        return examAbilityMapper.updateByExample(examAbility,example);
    }

    public List<ExamAbility> queryExamAbilityByExamId(int examId) {
        ExamAbilityExample example = new ExamAbilityExample();
        ExamAbilityExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        return examAbilityMapper.selectByExample(example);
    }

    public List<ExamAbility> queryExamAbilityByName(int examId, String name) {
        ExamAbilityExample example = new ExamAbilityExample();
        ExamAbilityExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andNameEqualTo(name);
        return examAbilityMapper.selectByExample(example);
    }



    public int addStudentDiff(StudentDiff diff) {
        return studentDiffMapper.insert(diff);
    }

    public int updateStudentDiffById(int id, StudentDiff studentDiff) {
        StudentDiffExample example = new StudentDiffExample();
        StudentDiffExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return studentDiffMapper.updateByExample(studentDiff,example);
    }

    public int updateStudentDiff(int examId, int studentId,String name, StudentDiff studentDiff) {
        StudentDiffExample example = new StudentDiffExample();
        StudentDiffExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andStudentidEqualTo(studentId);
        criteria.andNameEqualTo(name);
        return studentDiffMapper.updateByExample(studentDiff,example);
    }

    public List<StudentDiff> queryStudentDiffByExamId(int examId, int studentId) {
        StudentDiffExample example = new StudentDiffExample();
        StudentDiffExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andStudentidEqualTo(studentId);
        return studentDiffMapper.selectByExample(example);
    }

    public StudentDiff queryStudentDiffByName(int examId, int studentId, String name) {
        StudentDiffExample example = new StudentDiffExample();
        StudentDiffExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andStudentidEqualTo(studentId);
        criteria.andNameEqualTo(name);
        return studentDiffMapper.selectByExample(example).get(0);
    }

    public int addStudentScope(StudentScope scope) {
        return studentScopeMapper.insert(scope);
    }

    public int updateStudentScopeById(int id, int studentId, StudentScope studentScope) {
        StudentScopeExample example = new StudentScopeExample();
        StudentScopeExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return studentScopeMapper.updateByExample(studentScope,example);
    }

    public int updateStudentScope(int examId, int studentId,String name, StudentScope studentScope) {
        StudentScopeExample example = new StudentScopeExample();
        StudentScopeExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andStudentidEqualTo(studentId);
        criteria.andNameEqualTo(name);
        return studentScopeMapper.updateByExample(studentScope,example);
    }

    public List<StudentScope> queryStudentScopeByExamId(int examId, int studentId) {
        StudentScopeExample example = new StudentScopeExample();
        StudentScopeExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andStudentidEqualTo(studentId);
        return studentScopeMapper.selectByExample(example);
    }

    public StudentScope queryStudentScopeByName(int examId, int studentId, String name) {
        StudentScopeExample example = new StudentScopeExample();
        StudentScopeExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andStudentidEqualTo(studentId);
        criteria.andNameEqualTo(name);
        return studentScopeMapper.selectByExample(example).get(0);
    }

    public int addStudentType(StudentType type) {
        return studentTypeMapper.insert(type);
    }

    public int updateStudentTypeById(int id, int studentId, StudentType studentType) {
        StudentTypeExample example = new StudentTypeExample();
        StudentTypeExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return studentTypeMapper.updateByExample(studentType,example);
    }

    public int updateStudentType(int examId, int studentId,String name, StudentType studentType) {
        StudentTypeExample example = new StudentTypeExample();
        StudentTypeExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andStudentidEqualTo(studentId);
        criteria.andNameEqualTo(name);
        return studentTypeMapper.updateByExample(studentType,example);
    }

    public List<StudentType> queryStudentTypeByExamId(int examId, int studentId) {
        StudentTypeExample example = new StudentTypeExample();
        StudentTypeExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andStudentidEqualTo(studentId);
        return studentTypeMapper.selectByExample(example);
    }

    public StudentType queryStudentTypeByName(int examId, int studentId, String name) {
        StudentTypeExample example = new StudentTypeExample();
        StudentTypeExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andStudentidEqualTo(studentId);
        criteria.andNameEqualTo(name);
        return studentTypeMapper.selectByExample(example).get(0);
    }

    public int addStudentAbility(StudentAbility ability) {
        return studentAbilityMapper.insert(ability);
    }

    public int updateStudentAbilityById(int id, int studentId, StudentAbility studentAbility) {
        StudentAbilityExample example = new StudentAbilityExample();
        StudentAbilityExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return studentAbilityMapper.updateByExample(studentAbility,example);
    }

    public int updateStudentAbility(int examId, int studentId,String name, StudentAbility studentAbility) {
        StudentAbilityExample example = new StudentAbilityExample();
        StudentAbilityExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andStudentidEqualTo(studentId);
        criteria.andNameEqualTo(name);
        return studentAbilityMapper.updateByExample(studentAbility,example);
    }

    public List<StudentAbility> queryStudentAbilityByExamId(int examId, int studentId) {
        StudentAbilityExample example = new StudentAbilityExample();
        StudentAbilityExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andStudentidEqualTo(studentId);
        return studentAbilityMapper.selectByExample(example);
    }

    public StudentAbility queryStudentAbilityByName(int examId, int studentId, String name) {
        StudentAbilityExample example = new StudentAbilityExample();
        StudentAbilityExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andStudentidEqualTo(studentId);
        criteria.andNameEqualTo(name);
        return studentAbilityMapper.selectByExample(example).get(0);
    }




    public List<StudentScore> queryScoreById(int examId, int studentId) {
        StudentScoreExample example = new StudentScoreExample();
        StudentScoreExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andStudentidEqualTo(studentId);
        return studentScoreMapper.selectByExample(example);
    }

    public List<StudentScore> queryScoreByDiff(int examId, int studentId, String diff) {
        return null;
    }

    public List<StudentScore> queryScoreByAbility(int examId, int studentId, String ability) {
        return null;
    }

    public List<StudentScore> queryScoreByScope(int examId, int studentId, String scope) {
        return null;
    }

    public List<StudentScore> queryScoreByType(int examId, int studentId, String type) {
        return null;
    }


    public StudentScope queryStudentScopeScore(int studentId,int examId,String scope){
        StudentScopeExample example = new StudentScopeExample();
        StudentScopeExample.Criteria criteria = example.createCriteria();
        criteria.andStudentidEqualTo(studentId);
        criteria.andExamidEqualTo(examId);
        criteria.andNameEqualTo(scope);
        return studentScopeMapper.selectByExample(example).get(0);
    }

    public StudentAbility queryStudentAbilityScore(int studentId,int examId,String ability){
        StudentAbilityExample example = new StudentAbilityExample();
        StudentAbilityExample.Criteria criteria = example.createCriteria();
        criteria.andStudentidEqualTo(studentId);
        criteria.andExamidEqualTo(examId);
        criteria.andNameEqualTo(ability);
        return studentAbilityMapper.selectByExample(example).get(0);
    }

    public List<StudentScoreWrite> queryWriteStudent(int examId){
        StudentScoreWriteExample example = new StudentScoreWriteExample();
        StudentScoreWriteExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andIswriteEqualTo(1);
        return studentScoreWriteMapper.selectByExample(example);
    }

    public List<StudentScoreWrite> queryStudentExamScoreWrite(int studentId){
        Student student = studentMapper.selectByPrimaryKey(studentId);
        ExamExample examExample = new ExamExample();
        ExamExample.Criteria criteria = examExample.createCriteria();
        criteria.andClassidEqualTo(student.getClassid());
        List<Exam> exams = examMapper.selectByExample(examExample);
        StudentScoreWriteExample studentScoreWriteExample = new StudentScoreWriteExample();
        StudentScoreWriteExample.Criteria criteria1 = studentScoreWriteExample.createCriteria();
        criteria1.andStudentidEqualTo(studentId);
        List<StudentScoreWrite> list = new ArrayList<StudentScoreWrite>();
        for(Exam exam:exams){
            criteria1.andExamidEqualTo(exam.getId());
            list.add(studentScoreWriteMapper.selectByExample(studentScoreWriteExample).get(0));
        }
        return list;
    }

    //查询某一学生某一考试某一题目的得分
    public float queryQuestionScore(int studentId,int examId,int questionId){
        StudentScoreExample example = new StudentScoreExample();
        StudentScoreExample.Criteria criteria = example.createCriteria();
        criteria.andExamidEqualTo(examId);
        criteria.andStudentidEqualTo(studentId);
        criteria.andQuestionnumEqualTo(questionId);
        return studentScoreMapper.selectByExample(example).get(0).getScore();
    }
}
