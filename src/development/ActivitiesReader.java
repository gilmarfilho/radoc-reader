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
            sessionActivities.replace("Título do trabalho:", "");
            sessionActivities.replaceFirst("Tabela:", "");
            //CHA
            initialPos = sessionActivities.indexOf("CHA:");
            endPos = sessionActivities.indexOf("Data início:");
            String cha = sessionActivities.substring(initialPos + 4, endPos -1);
            sessionActivities.replaceFirst("CHA:", "");
            //Data de início
            initialPos = sessionActivities.indexOf("Data início:");
            endPos = sessionActivities.indexOf("Data término:");
               
            String startDate = sessionActivities.substring(initialPos + 12, endPos -1);
            sessionActivities.replaceFirst("Data início:", "");
            
            //Data de término
            initialPos = sessionActivities.indexOf("Data término:");
            endPos = sessionActivities.indexOf("Tipo Orientação:");

            String endDate = sessionActivities.substring(initialPos + 13, endPos - 1);
            sessionActivities.replaceFirst("Data término:", "");
            sessionActivities.replaceFirst("Tipo Orientação:", "");
            
            activity.setDescription(description);
            activity.setActivityHours(cha);
            activity.setStartDate(startDate);
            activity.setEndDate(endDate);
            
            activities.add(activity);
        }
        
        return activities;
    }
}
