package com.XS.service.Impl;

import com.XS.dao.QuestionAbilityMapper;
import com.XS.dao.QuestionDifficultyMapper;
import com.XS.dao.QuestionScopeMapper;
import com.XS.dao.QuestionTypeMapper;
import com.XS.pojo.*;
import com.XS.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    QuestionAbilityMapper questionAbilityMapper;
    QuestionDifficultyMapper questionDifficultyMapper;
    QuestionScopeMapper questionScopeMapper;
    QuestionTypeMapper questionTypeMapper;

    @Autowired
    public void setQuestionAbilityMapper(QuestionAbilityMapper questionAbilityMapper) {
        this.questionAbilityMapper = questionAbilityMapper;
    }

    @Autowired
    public void setQuestionDifficultyMapper(QuestionDifficultyMapper questionDifficultyMapper) {
        this.questionDifficultyMapper = questionDifficultyMapper;
    }

    @Autowired
    public void setQuestionScopeMapper(QuestionScopeMapper questionScopeMapper) {
        this.questionScopeMapper = questionScopeMapper;
    }

    @Autowired
    public void setQuestionTypeMapper(QuestionTypeMapper questionTypeMapper) {
        this.questionTypeMapper = questionTypeMapper;
    }

    public List<QuestionAbility> queryQuestionAbility(int subjectId, int gradeId) {
        QuestionAbilityExample example = new QuestionAbilityExample();
        QuestionAbilityExample.Criteria criteria = example.createCriteria();
        criteria.andSubjectidEqualTo(subjectId);
        criteria.andGradeidEqualTo(gradeId);
        return questionAbilityMapper.selectByExample(example);
    }

    public List<QuestionDifficulty> queryQuestionDiff(int subjectId, int gradeId) {
        QuestionDifficultyExample example = new QuestionDifficultyExample();
        QuestionDifficultyExample.Criteria criteria = example.createCriteria();
        criteria.andSubjectidEqualTo(subjectId);
        criteria.andGradeidEqualTo(gradeId);
        return questionDifficultyMapper.selectByExample(example);
    }

    public List<QuestionScope> queryQuestionScope(int subjectId, int gradeId) {
        QuestionScopeExample example = new QuestionScopeExample();
        QuestionScopeExample.Criteria criteria = example.createCriteria();
        criteria.andSubjectidEqualTo(subjectId);
        criteria.andGradeidEqualTo(gradeId);
        return questionScopeMapper.selectByExample(example);
    }

    public List<QuestionType> queryQuestionType(int subjectId, int gradeId) {
        QuestionTypeExample example = new QuestionTypeExample();
        QuestionTypeExample.Criteria criteria = example.createCriteria();
        criteria.andSujectidEqualTo(subjectId);
        criteria.andGradeidEqualTo(gradeId);
        return questionTypeMapper.selectByExample(example);
    }
}
