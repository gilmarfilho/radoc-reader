/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Gilmar
 */
public class ActivitiesReader {
    public String extractActivities(String radoc, String firstActivity, String secondActivity) {
        int initalPos = radoc.indexOf(firstActivity);
        int endPos = radoc.indexOf(secondActivity);
        String activities = radoc.substring(initalPos, endPos);
        activities = this.removeFooterHeaderReturn(activities);
        
        return activities;
    }
    
    public String extractData(String activities, String tag1, String tag2){
        int initialPos = activities.indexOf(tag1);
        int endPos = activities.indexOf(tag2);

        String data = activities.substring(initialPos + tag1.length(), endPos -1);
        return data;
    }
    
    public String extractDateField(String activities, String tag){
        int initialPos = activities.indexOf(tag) + tag.length();
        int endPos = initialPos + 11;

        String date = activities.substring(initialPos , endPos);
        return date;
    }
    
    public String deleteData(String activities, String tag){
        activities = activities.replaceFirst(tag, "extraido");
        return activities;
    }

    private String removeFooterHeaderReturn(String sessionActivities){
        
        while(sessionActivities.contains("\r\n")){
            sessionActivities = sessionActivities.replaceFirst("\r\n", " ");
        }
        while(sessionActivities.contains("\n")){
            sessionActivities = sessionActivities.replaceFirst("\n", " ");
        }
        
        while(sessionActivities.contains("Data:")){
            sessionActivities = sessionActivities.replaceFirst("Data: [0-9]+/[0-9]+/[0-9]+ [0-9]+:[0-9]+:[0-9]+                                                  JULIANO LOPES DE OLIVEIRA Página  [0-9]+ / [0-9]+", " ");
        }
        while(sessionActivities.contains("UNIVERSIDADE FEDERAL DE GOIÁS " +
                "SISTEMA DE CADASTRO DE ATIVIDADES DOCENTES " +
                "EXTRATO DAS ATIVIDADES")){
            sessionActivities = sessionActivities.replaceFirst("UNIVERSIDADE FEDERAL DE GOIÁS " +
"SISTEMA DE CADASTRO DE ATIVIDADES DOCENTES " +
"EXTRATO DAS ATIVIDADES - ANO BASE: 201[0-9]+", " ");
        }
        
        return sessionActivities;
    }
}
