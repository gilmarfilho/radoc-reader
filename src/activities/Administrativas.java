/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activities;

import data.ActivitiesReader;

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


}
