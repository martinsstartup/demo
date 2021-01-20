package com.personal.dcso.view.model;

import com.personal.dcso.service.QuestionHelperService;

import javax.inject.Inject;

public class QuestionnaireQuestion {
    private String id; //DCSO Questionnaire Ref. # in tab
    private String riskAssessmentCategory;
    private String riskAssessmentReference;
    private String text;
    private String optionsCommentsOnImpact;
    private int excelRowNumber;

    public int getExcelRowNumber() {
        return excelRowNumber;
    }

    public void setExcelRowNumber(int excelRowNumber) {
        this.excelRowNumber = excelRowNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String sectionNum(){
        if(id != null){
            return id.trim().substring(0, id.trim().indexOf("."));
        }
        return null;
    }

    public String getRiskAssessmentCategory() {
        return riskAssessmentCategory;
    }

    public void setRiskAssessmentCategory(String riskAssessmentCategory) {
        this.riskAssessmentCategory = riskAssessmentCategory;
    }

    public String getRiskAssessmentReference() {
        return riskAssessmentReference;
    }

    public void setRiskAssessmentReference(String riskAssessmentReference) {
        this.riskAssessmentReference = riskAssessmentReference;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOptionsCommentsOnImpact() {
        return optionsCommentsOnImpact;
    }

    public void setOptionsCommentsOnImpact(String optionsCommentsOnImpact) {
        this.optionsCommentsOnImpact = optionsCommentsOnImpact;
    }
}
