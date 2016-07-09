/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package development;

import java.util.ArrayList;

/**
 *
 * @author Gilmar
 */
public class ActivitiesReader {
    public String extractActivities(String radoc, String firstActivity, String secondActivity) {
        int initalPos = radoc.indexOf(firstActivity);
        int endPos = radoc.indexOf(secondActivity);
        String ativities = radoc.substring(initalPos, endPos);
        
        return ativities;
    }

    public ArrayList<Activity> extractActivity(String sessionActivities){
        ArrayList<Activity> activities = new ArrayList<>();
        
        while(sessionActivities.indexOf("Título do trabalho:") != -1){
            Activity activity = new Activity();
            int initialPos;
            int endPos;
            //Descrição
            initialPos = sessionActivities.indexOf("Título do trabalho:");
            endPos = sessionActivities.indexOf("Tabela:");

            String description = sessionActivities.substring(initialPos + 20, endPos -1);
            sessionActivities = sessionActivities.replaceFirst("Título do trabalho", "extraido");
            sessionActivities = sessionActivities.replaceFirst("Tabela:", "extraido");
            //CHA
            initialPos = sessionActivities.indexOf("CHA:");
            endPos = sessionActivities.indexOf("Data início:");
            String cha = sessionActivities.substring(initialPos + 4, endPos -1);
            sessionActivities = sessionActivities.replaceFirst("CHA:", "extraido");
            //Data de início
            initialPos = sessionActivities.indexOf("Data início:");
            endPos = sessionActivities.indexOf("Data término:");
               
            String startDate = sessionActivities.substring(initialPos + 12, endPos -1);
            sessionActivities = sessionActivities.replaceFirst("Data início:", "extraido");
            
            //Data de término
            initialPos = sessionActivities.indexOf("Data término:");
            endPos = sessionActivities.indexOf("Tipo Orientação:");

            String endDate = sessionActivities.substring(initialPos + 13, endPos - 1);
            sessionActivities = sessionActivities.replaceFirst("Data término:", "extraido");
            sessionActivities = sessionActivities.replaceFirst("Tipo Orientação:", "extraido");
            
            activity.setDescription(description);
            activity.setActivityHours(cha);
            activity.setStartDate(startDate);
            activity.setEndDate(endDate);
            
            activities.add(activity);
        }
        
        return activities;
    }
    
    public ArrayList<Activity> extensãoActivities(String sessionActivities){
        ArrayList<Activity> activities = new ArrayList<>();
        
        while(sessionActivities.indexOf("Descrição da atividade:") != -1){
            Activity activity = new Activity();
            int initialPos;
            int endPos;
            //Descrição
            initialPos = sessionActivities.indexOf("Descrição da atividade:");
            endPos = sessionActivities.indexOf("Descrição da clientela");

            String description = sessionActivities.substring("Descrição da atividade:".length(), endPos -1);
            //CHA
            initialPos = sessionActivities.indexOf("CHA:");
            endPos = sessionActivities.indexOf("Data início:");
            String cha = sessionActivities.substring(initialPos + "CHA:".length(), endPos -1);
            sessionActivities = sessionActivities.replaceFirst("CHA:", "extraido");
            //Data de início
            initialPos = sessionActivities.indexOf("Data início:");
            endPos = sessionActivities.indexOf("Data término:");
               
            String startDate = sessionActivities.substring(initialPos + "Data início:".length(), endPos -1);
            sessionActivities = sessionActivities.replaceFirst("Data início:", "extraido");
            
            //Data de término
            initialPos = sessionActivities.indexOf("Data término:");
            endPos = sessionActivities.indexOf("Descrição da atividade:");

            String endDate = sessionActivities.substring(initialPos + "Data término:".length(), endPos - 1);
            sessionActivities = sessionActivities.replaceFirst("Data término:", "extraido");
            sessionActivities = sessionActivities.replaceFirst("Descrição da atividade:", "extraido");
            
            activity.setDescription(description);
            activity.setActivityHours(cha);
            activity.setStartDate(startDate);
            activity.setEndDate(endDate);
            
            activities.add(activity);
        }
        
        return activities;
    }
}
