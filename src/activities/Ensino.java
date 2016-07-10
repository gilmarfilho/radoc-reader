/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activities;

import data.ActivitiesReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Gilmar
 */
public class Ensino {
    private ActivitiesReader activitiesReader = new ActivitiesReader();
    private String activities;
    
    public Ensino(String radoc){
        this.activities = activitiesReader.extractActivities(radoc, "Atividades de ensino", "Atividades de orientação");
    }

    public ArrayList<Activity> extractActivities() throws ParseException{
        ArrayList<Activity> activities = new ArrayList<>();
     
        return activities;
    }
}
