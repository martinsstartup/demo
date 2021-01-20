package com.personal.dcso.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.personal.dcso.view.model.QuestionnaireQuestion;
import com.personal.dcso.view.model.RaciQuestion;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sandbox {

    public static void main(String[] args) throws Exception{
        RaciQuestion q1 = new RaciQuestion();
        q1.setId("ad1");
        q1.setText("Release Planning");
        q1.setHelpText("more info in <a href=\"https://methodology.accenture.com/ppsm/home/ppsm?url=/publish.ppsm/domains/Release%20Management_A4DB6A90.html\" target=\"_blank\">ADM</a>");

        List<RaciQuestion> raciQuestions = new ArrayList<>();
        raciQuestions.add(q1);

//        List<QuestionnaireQuestion> questionnaireQuestions = new ArrayList<>();
//        FileReader fileReader = new FileReader("c:/tmp/questions.json");
//        Gson gson = new GsonBuilder().create();
//        questionnaireQuestions = gson.fromJson(fileReader, new TypeToken<List<QuestionnaireQuestion>>(){}.getType());
//        System.out.println(questionnaireQuestions);

//        QuestionnaireQuestion q1 = new QuestionnaireQuestion();
//        q1.setId("6.1");
//        q1.setRiskAssessmentCategory("Delivery Location");
//        q1.setRiskAssessmentReference("CP.03");
//        q1.setText("Please specify any client location requirements (e.g. city, resources Working in client's captive Centre)?");
//        q1.setOptionsCommentsOnImpact("Note that the ATC reserves the right to make the final decision on location within the ATC, taking into account resource availability and lead times as well as client location requirements / preferences. Change of location may have a material impact on resource availability.");
//        QuestionnaireQuestion q2 = new QuestionnaireQuestion();
//        q2.setId("7.2");
//        q2.setRiskAssessmentCategory("Complexity");
//        q2.setRiskAssessmentReference("SP.04");
//        q2.setText("Has the relevant up-to-date ADM estimator(s) been used to develop the estimate included in the Solution Plan?\n" +
//                "\n" +
//                "If Yes please state which ADM estimator and version was used, if No please state why the ADM estimator was not used.");
//        q2.setOptionsCommentsOnImpact("If Yes, please specify the ADM Estimator that you are planning to use for your project.\n" +
//                " \n" +
//                "If No,  please provide the following:\n" +
//                "  (1) Engagement senior executives approval\n" +
//                "  (2) Policy 11 Compliance checklist\n" +
//                "  (3) Copy of the non-ADM estimator\n" +
//                "  (4) Gap analysis between the chosen estimator and ADM Estimator, and identify any necessary remediation to ensure the Company’s quality requirements are met. \n" +
//                "\n" +
//                "As per Accenture global policy 11, all engagements are required to use the Accenture Delivery Methods and Estimators to plan, manage and execute the work. This encompasses any Consulting or Outsourcing work.");
//
//        questionnaireQuestions.add(q1);
//        questionnaireQuestions.add(q2);
//
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fw = new FileWriter("C:/tmp/raci_questions.json");
        gson.toJson(raciQuestions, fw);
        fw.flush();
        fw.close();
    }

/*
6.1	Delivery Location	CP.03	Please specify any client location requirements (e.g. city, resources Working in client's captive Centre)?	"Note that the ATC reserves the right to make the final decision on location within the ATC, taking into account resource availability and lead times as well as client location requirements / preferences. Change of location may have a material impact on resource availability.
"
6.2	Industry / Geography	CP.02	"Is there a need for Technology Center resources to travel to client location/s? Please specify the location/s, number of travelers, indicative dates and approximate duration to account for overall lead times associated with potential hiring and visa processing.
"	Higher risk is for those locations that ATC needs to acquire visas and work permits, and has significant cultural differences.
6.3	Alignment - Solution Plan and Capability 	AL.03	"Have you taken into account RMS (Relocation Management Solutions) procedures and timelines, and have you consulted with RMS regarding appropriate visas to use?
"
6.4	Alignment - Solution Plan and Capability 	AL.03	"Is there a need for the onshore SME to visit the ATC as part of the knowledge transfer plan? If so, please provide details.

Please be aware that this will result in additional costs.
"

 */
}
