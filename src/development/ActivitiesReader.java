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
    
    public ArrayList<Activity> qualificacaoActivities(String sessionActivities){
        ArrayList<Activity> activities = new ArrayList<>();
        
        while(sessionActivities.indexOf("Tabela:") != -1){
            Activity activity = new Activity();
            int initialPos;
            int endPos;
            
            //Remove Footer
            sessionActivities = removeFooterHeader(sessionActivities);
            
            
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
