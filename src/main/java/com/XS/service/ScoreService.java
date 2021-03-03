package com.XS.service;

import com.XS.pojo.*;

import java.util.List;

public interface ScoreService {
    List<StudentScore> queryScoreById(int examId,int studentId);

    List<StudentScore> queryScoreByDiff(int examId,int studentId,String diff);

    List<StudentScore> queryScoreByAbility(int examId,int studentId,String ability);

    List<StudentScore> queryScoreByScope(int examId,int studentId,String scope);

    List<StudentScore> queryScoreByType(int examId,int studentId,String type);




    int addExamDiff(ExamDiff examDiff);

    int updateExamDiffById(int id,ExamDiff examDiff);

    int updateExamDiff(int examId,String name,ExamDiff examDiff);

    List<ExamDiff> queryExamDiffByExamId(int examId);

    List<ExamDiff> queryExamDiffByName(int examId, String name);

    int addExamScope(ExamScope examScope);

    int updateExamScopeById(int id,ExamScope examScope);

    int updateExamScope(int examId,String name,ExamScope examScope);

    List<ExamScope> queryExamScopeByExamId(int examId);

    List<ExamScope> queryExamScopeByName(int examId,String name);

    int addExamType(ExamType examType);

    int updateExamTypeById(int id,ExamType examType);

    int updateExamType(int examId,String name,ExamType examType);

    List<ExamType> queryExamTypeByExamId(int examId);

    List<ExamType> queryExamTypeByName(int examId,String name);

    int addExamAbility(ExamAbility examAbility);

    int updateExamAbilityById(int id,ExamAbility examAbility);

    int updateExamAbility(int examId,String name,ExamAbility examAbility);

    List<ExamAbility> queryExamAbilityByExamId(int examId);

    List<ExamAbility> queryExamAbilityByName(int examId,String name);





    int addStudentDiff(StudentDiff diff);

    int updateStudentDiffById(int id,StudentDiff studentDiff);

    int updateStudentDiff(int examId,int studentId,String name,StudentDiff studentDiff);

    List<StudentDiff> queryStudentDiffByExamId(int examIdm,int studentId);

    StudentDiff queryStudentDiffByName(int examId,int studentId, String name);

    int addStudentScope(StudentScope scope);

    int updateStudentScopeById(int id,int studentId,StudentScope studentScope);

    int updateStudentScope(int examId,int studentId,String name,StudentScope studentScope);

    List<StudentScope> queryStudentScopeByExamId(int examId,int studentId);

    StudentScope queryStudentScopeByName(int examId,int studentId,String name);

    int addStudentType(StudentType type);

    int updateStudentTypeById(int id,int studentId,StudentType studentType);

    int updateStudentType(int examId,int studentId,String name,StudentType studentType);

    List<StudentType> queryStudentTypeByExamId(int examId,int studentId);

    StudentType queryStudentTypeByName(int examId,int studentId,String name);

    int addStudentAbility(StudentAbility ability);

    int updateStudentAbilityById(int id,int studentId,StudentAbility studentAbility);

    int updateStudentAbility(int examId,int studentId,String name,StudentAbility studentAbility);

    List<StudentAbility> queryStudentAbilityByExamId(int examId,int studentId);

    StudentAbility queryStudentAbilityByName(int examId,int studentId,String name);

    StudentScope queryStudentScopeScore(int studentId,int examId,String scope);

    StudentAbility queryStudentAbilityScore(int studentId,int examId,String ability);

    List<StudentScoreWrite> queryWriteStudent(int examId);

    List<StudentScoreWrite> queryStudentExamScoreWrite(int studentId);

    float queryQuestionScore(int studentId,int examId,int questionId);
}
