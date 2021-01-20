package com.personal.dcso.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.personal.dcso.util.JSFUtils;
import com.personal.dcso.view.model.Industry;
import com.personal.dcso.view.model.QuestionnaireQuestion;
import com.personal.dcso.view.model.RaciQuestion;

@Named
@SessionScoped
public class Dcso implements Serializable {
    // Section 1 properties
    private String clientName;
    private String clientCountry;
    private String industry;
    private String clientOverview;
    private String clientBusinessChallenge;
    private String accentureOfferingAndValueProposition;
    private List<String> availableCountries;
    private List<Industry> availableIndustries;
    private Date serviceWindowStartTime;
    private Date serviceWindowEndTime;
    private boolean onCall;
    private boolean SLAs;
    private List<QuestionnaireQuestion> questionnaireQuestions = new ArrayList<>();
    private List<String> sections;
    private List<RaciQuestion> raciQuestions = new ArrayList<>();


    public List<String> getSections() {
        return sections;
    }

    public void setSections(List<String> sections) {
        this.sections = sections;
    }

    public List<QuestionnaireQuestion> getQuestionnaireQuestions() {
        return questionnaireQuestions;
    }

    public List<QuestionnaireQuestion> getQuestionnaireQuestions(String sectionNumber) {
        return questionnaireQuestions.stream()
                .filter(question -> question.getId().startsWith(sectionNumber))
                .collect(Collectors.toCollection(ArrayList<QuestionnaireQuestion>::new));
    }

    public List<QuestionnaireQuestion> getQuestionnaireQuestions(int sectionNumber) {
        return this.getQuestionnaireQuestions(String.valueOf(sectionNumber));
    }

    public List<RaciQuestion> getRaciQuestions(String raciSection){
        if(raciSection != null) {
            return raciQuestions.stream()
                    .filter(q -> q.getId().toLowerCase().startsWith(raciSection.trim().toLowerCase()))
                    .collect(Collectors.toCollection(ArrayList<RaciQuestion>::new));
        }
        return new ArrayList<>();
    }

    public void setQuestionnaireQuestions(List questionnaireQuestions) {
        this.questionnaireQuestions = questionnaireQuestions;
    }

    public boolean isOnCall() {
        return onCall;
    }

    public void setOnCall(boolean onCall) {
        this.onCall = onCall;
    }

    public boolean isSLAs() {
        return SLAs;
    }

    public void setSLAs(boolean SLAs) {
        this.SLAs = SLAs;
    }

    public Date getServiceWindowStartTime() {
        return serviceWindowStartTime;
    }

    public void setServiceWindowStartTime(Date serviceWindowStartTime) {
        this.serviceWindowStartTime = serviceWindowStartTime;
    }

    public Date getServiceWindowEndTime() {
        return serviceWindowEndTime;
    }

    public void setServiceWindowEndTime(Date serviceWindowEndTime) {
        this.serviceWindowEndTime = serviceWindowEndTime;
    }

    @PostConstruct
    public void init() {
        // available countries
        try (BufferedReader bin = new BufferedReader(
                new InputStreamReader(JSFUtils.getResourceStream("data/countries.txt")))) {
            availableCountries = new ArrayList<String>();
            while (bin.ready())
                availableCountries.add(bin.readLine().trim());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Questionnaire question map
        Gson gson = new Gson();
        questionnaireQuestions = new ArrayList<>();
        try (BufferedReader bin = new BufferedReader(
                new InputStreamReader(JSFUtils.getResourceStream("data/questions.json")))) {
            questionnaireQuestions = gson.fromJson(bin, new TypeToken<List<QuestionnaireQuestion>>(){}.getType());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        raciQuestions = new ArrayList<>();
        try (BufferedReader bin = new BufferedReader(
                new InputStreamReader(JSFUtils.getResourceStream("data/raci_questions.json")))) {
            raciQuestions = gson.fromJson(bin, new TypeToken<List<RaciQuestion>>(){}.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        availableIndustries = new ArrayList<>();
        availableIndustries.add(new Industry("PRD", "Products"));
        availableIndustries.add(new Industry("FS", "Financial Services"));
        availableIndustries.add(new Industry("CMT", "CMT"));
        availableIndustries.add(new Industry("HPS", "Health & Public Services"));
        availableIndustries.add(new Industry("RES", "Resources"));
        availableIndustries.add(new Industry("Other", "Other"));

        String[] sectionsArr = new String[]{"1 - CLIENT EXPECTATIONS/CONTEXT", "2 - OPPORTUNITY DETAILS & MILESTONES",
                "3 - OPPORTUNITY KEY CONTACTS & GOVERNANCE", "4 - TECHNOLOGY CENTER SCOPE & DEAL COMPLEXITY",
                "5 - HIGH LEVEL TALENT/SKILLS REQUIREMENTS", "6 - LOCATION & TRAVEL REQUIREMENTS",
                "7 - METHODOLOGY & TOOLS REQUIREMENTS", "8 - STAFFING PROCESS REQUIREMENTS",
                "9 - WORK ENVIRONMENT REQUIREMENTS", "10 - COMPLIANCE AND SECURITY REQUIREMENTS"};
        sections = Arrays.asList(sectionsArr);

    }

    public List<String> completeCountry(String input) {
        return availableCountries.stream().filter(c -> c.toLowerCase().contains(input.trim())).collect(Collectors.toList());
    }

    public List<Industry> getAvailableIndustries() {
        return availableIndustries;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientCountry() {
        return clientCountry;
    }

    public void setClientCountry(String clientCountry) {
        this.clientCountry = clientCountry;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getClientOverview() {
        return clientOverview;
    }

    public void setClientOverview(String clientOverview) {
        this.clientOverview = clientOverview;
    }

    public String getClientBusinessChallenge() {
        return clientBusinessChallenge;
    }

    public void setClientBusinessChallenge(String clientBusinessChallenge) {
        this.clientBusinessChallenge = clientBusinessChallenge;
    }

    public String getAccentureOfferingAndValueProposition() {
        return accentureOfferingAndValueProposition;
    }

    public void setAccentureOfferingAndValueProposition(String accentureOfferingAndValueProposition) {
        this.accentureOfferingAndValueProposition = accentureOfferingAndValueProposition;
    }

    public void submit() {

    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
