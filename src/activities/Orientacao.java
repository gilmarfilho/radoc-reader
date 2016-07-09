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
public class Orientacao {
    private ActivitiesReader activitiesReader = new ActivitiesReader();
    private String activities;
    
    public Orientacao(String radoc){
        this.activities = activitiesReader.extractActivities(radoc, "Atividades de orientação", "Atividades em projetos");
    }
    
    public ArrayList<Activity> extractActivities(String sessionActivities){
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
}
