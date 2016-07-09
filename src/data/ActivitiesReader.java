/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Gilmar
 */
public class ActivitiesReader {
    public String extractActivities(String radoc, String firstActivity, String secondActivity) {
        int initalPos = radoc.indexOf(firstActivity);
        int endPos = radoc.indexOf(secondActivity);
        String activities = radoc.substring(initalPos, endPos);
        activities = this.removeFooterHeader(activities);
        
        return activities;
    }
    
    public String extractData(String activities, String tag1, String tag2){
        int initialPos = activities.indexOf(tag1);
        int endPos = activities.indexOf(tag2);

        String data = activities.substring(initialPos + tag1.length(), endPos -1);
        return data;
    }
    
    public String deleteData(String activities, String tag){{
        activities = activities.replaceFirst(tag, "extraido");
        return activities;
    }
    }

    private String removeFooterHeader(String sessionActivities){
        while(sessionActivities.indexOf("Data: ") != -1){
            sessionActivities = sessionActivities.replaceFirst("Data: (.*)\n", "");
        }
        while(sessionActivities.indexOf("UNIVERSIDADE FEDERAL DE GOIÁS\n" +
"SISTEMA DE CADASTRO DE ATIVIDADES DOCENTES\n" +
"EXTRATO DAS ATIVIDADES") != -1){
            sessionActivities = sessionActivities.replaceFirst("UNIVERSIDADE FEDERAL DE GOIÁS\n" +
"SISTEMA DE CADASTRO DE ATIVIDADES DOCENTES\n" +
"EXTRATO DAS ATIVIDADES(.*)\n", "");
        }
        
        return sessionActivities;
    }
}