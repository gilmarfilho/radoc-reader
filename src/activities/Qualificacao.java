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
public class Qualificacao {
    private ActivitiesReader activitiesReader = new ActivitiesReader();
    private String activities;
    
    public Qualificacao(String radoc){
        this.activities = activitiesReader.extractActivities(radoc, "Atividades de qualificação", "Atividades acadêmicas especiais");
    }
    public ArrayList<Activity> extractActivities(String sessionActivities){
        ArrayList<Activity> activities = new ArrayList<>();
        
        while(sessionActivities.indexOf("Tabela:") != -1){
            Activity activity = new Activity();
            int initialPos;
            int endPos;
            
            //Descrição
            initialPos = sessionActivities.indexOf("Tabela:");
            endPos = sessionActivities.indexOf("Descrição:");

            String description = sessionActivities.substring(initialPos + 7, endPos -1);
            sessionActivities = sessionActivities.replaceFirst("Tabela:", "extraido");
            sessionActivities = sessionActivities.replaceFirst("Descrição:", "extraido");
            //CHA
            initialPos = sessionActivities.indexOf("CHA:");
            endPos = sessionActivities.indexOf("Data de início:");
            String cha = sessionActivities.substring(initialPos + 4, endPos -1);
            sessionActivities = sessionActivities.replaceFirst("CHA:", "extraido");
            //Data de início
            initialPos = sessionActivities.indexOf("Data de início:");
            endPos = sessionActivities.indexOf("Data de término:");
               
            String startDate = sessionActivities.substring(initialPos + 16, endPos -1);
            sessionActivities = sessionActivities.replaceFirst("Data de início:", "extraido");
            
            //Data de término
            initialPos = sessionActivities.indexOf("Data de término:");
            endPos = sessionActivities.indexOf("Data de término:") + 28;

            String endDate = sessionActivities.substring(initialPos + 17, endPos - 1);
            sessionActivities = sessionActivities.replaceFirst("Data de término:", "extraido");
            
            activity.setDescription(description);
            activity.setActivityHours(cha);
            activity.setStartDate(startDate);
            activity.setEndDate(endDate);
            
            activities.add(activity);
        }
        
        return activities;
    }
}
