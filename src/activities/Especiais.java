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
public class Especiais {
    private ActivitiesReader activitiesReader = new ActivitiesReader();
    private String activities;
    
    public Especiais(String radoc){
        this.activities = activitiesReader.extractActivities(radoc, "Atividades acadêmicas especiais", "Atividades administrativas");
    }
}
