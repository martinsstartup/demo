package com.personal.dcso.service;

import com.personal.dcso.model.Question;
import com.personal.dcso.view.model.QuestionnaireQuestion;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

@Stateless
public class QuestionHelperService {

    public List<String> getSuggestClientTeamResponse(Question question, Object thinkOnOtherParams){
            return null;
    }

    public List<String> gSuggestATCResponse(Question question, Object thinkOnOtherParams){
        return  null;
    }

    public Map<String, Map<String, QuestionnaireQuestion>> questionnaireQuestions(){
        /*
        read JSON of questions;
         */
        return null;
    }
}
