/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activities;

import data.ActivitiesReader;
import development.*;
import java.util.ArrayList;

/**
 *
 * @author Gilmar
 */
public class Extensao {
    private ActivitiesReader activitiesReader = new ActivitiesReader();
    private String activities;
    
    public Extensao(String radoc){
        this.activities = activitiesReader.extractActivities(radoc, "Atividades de extensão", "Atividades de qualificação");
    }
    public ArrayList<Activity> extractActivities(String sessionActivities){
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
