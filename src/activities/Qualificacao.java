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
public class Qualificacao {
    private ActivitiesReader activitiesReader = new ActivitiesReader();
    private String activities;
    
    public Qualificacao(String radoc){
        this.activities = activitiesReader.extractActivities(radoc, "Atividades de qualificação", "Atividades acadêmicas especiais");
    }
    
    public ArrayList<Activity> extractActivities() throws ParseException{
        ArrayList<Activity> activities = new ArrayList<>();
        
        while(this.activities.contains("Tabela:")){
            //Descrição
            String description = this.activitiesReader.extractData(this.activities, "Tabela:", "Descrição:");
            //CHA
            String cha = this.activitiesReader.extractData(this.activities, "CHA:", "Data de início:");
            //Data de início
            String startDate = this.activitiesReader.extractData(this.activities, "Data de início:", "Data de término:");
            //Data de término
            String endDate = this.activitiesReader.extractDateField(this.activities, "Data de término:");
            //Removendo a atividade 1 da lista de atividades sem formatação
            this.activities = this.activitiesReader.deleteData(this.activities, "Tabela:");
            this.activities = this.activitiesReader.deleteData(this.activities, "Descrição:");
            this.activities = this.activitiesReader.deleteData(this.activities, "CHA:");
            this.activities = this.activitiesReader.deleteData(this.activities, "Data de início:");
            this.activities = this.activitiesReader.deleteData(this.activities, "Data de término:");
            //Adicionando a atividade na lista de atividades com formatação
            Activity activity = new Activity(description, cha, startDate, endDate);
            activities.add(activity);
        }
        
        return activities;
    }
}
