package com.XS.service;

import com.XS.pojo.QuestionAbility;
import com.XS.pojo.QuestionDifficulty;
import com.XS.pojo.QuestionScope;
import com.XS.pojo.QuestionType;

import java.util.List;

public interface QuestionService {
    List<QuestionAbility> queryQuestionAbility(int subjectId,int gradeId);

    List<QuestionDifficulty> queryQuestionDiff(int subjectId,int gradeId);

    List<QuestionScope> queryQuestionScope(int subjectId,int gradeId);

    List<QuestionType> queryQuestionType(int subjectId,int gradeId);
}
