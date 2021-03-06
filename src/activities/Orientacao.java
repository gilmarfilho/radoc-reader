/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activities;

import data.ActivitiesReader;
import java.text.ParseException;
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
    
    public ArrayList<Activity> extractActivities() throws ParseException{
        ArrayList<Activity> activities = new ArrayList<>();
        
        while(this.activities.contains("Título do trabalho:")){
            //Descrição
            String description = this.activitiesReader.extractData(this.activities, "Título do trabalho:", "Tabela:");
            //CHA
            String cha = this.activitiesReader.extractData(this.activities, "CHA:", "Data início:");
            //Data de início
            String startDate = this.activitiesReader.extractData(this.activities, "Data início:", "Data término:");
            //Data de término
            String endDate = this.activitiesReader.extractData(this.activities, "Data término:", "Tipo Orientação:");
            //Removendo a atividade 1 da lista de atividades sem formatação
            this.activities = this.activitiesReader.deleteData(this.activities, "Título do trabalho:");
            this.activities = this.activitiesReader.deleteData(this.activities, "Tabela:");
            this.activities = this.activitiesReader.deleteData(this.activities, "CHA:");
            this.activities = this.activitiesReader.deleteData(this.activities, "Data início:");
            this.activities = this.activitiesReader.deleteData(this.activities, "Data término:");
            this.activities = this.activitiesReader.deleteData(this.activities, "Tipo Orientação:");
            //Adicionando a atividade na lista de atividades com formatação
            Activity activity = new Activity(description, cha, startDate, endDate);
            activities.add(activity);
        }
        
        return activities;
    }
}
