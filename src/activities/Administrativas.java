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
public class Administrativas {
    private ActivitiesReader activitiesReader = new ActivitiesReader();
    private String activities;
    
    public Administrativas(String radoc){
        this.activities = activitiesReader.extractActivities(radoc, "Atividades administrativas", "Produtos");
    }
    public ArrayList<Activity> extractActivities() throws ParseException{
        ArrayList<Activity> activities = new ArrayList<>();
        
        while(this.activities.contains("Descrição:")){
            //Descrição
            String description = this.activitiesReader.extractData(this.activities, "Descrição:", "Órgão emissor");
            //CHA
            String cha = this.activitiesReader.extractData(this.activities, "CHA:", "Data início:");
            //Data de início
            String startDate = this.activitiesReader.extractDateField(this.activities, "Data início:");
            //Data de término
            String endDate = this.activitiesReader.extractDateField(this.activities, "Data término:");
            //Removendo a atividade 1 da lista de atividades sem formatação
            this.activities = this.activitiesReader.deleteData(this.activities, "Descrição:");
            this.activities = this.activitiesReader.deleteData(this.activities, "Órgão emissor");
            this.activities = this.activitiesReader.deleteData(this.activities, "CHA:");
            this.activities = this.activitiesReader.deleteData(this.activities, "Data início:");
            this.activities = this.activitiesReader.deleteData(this.activities, "Data término:");

            //Adicionando a atividade na lista de atividades com formatação
            Activity activity = new Activity(description, cha, startDate, endDate);
            activities.add(activity);
        }
        
        return activities;
    }

}
