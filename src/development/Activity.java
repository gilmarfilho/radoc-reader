/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package development;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jorge
 */
public class Activity {
    private String description;
    private float activityHours;
    private Date startDate;
    private Date endDate;
    
   
    public Activity(String description, Date startDate, Date endDate){
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        
        //Calcula e atribui o numero de horas da atividade
        this.activityHours = calcActivityHours(startDate,endDate);
    }
    public Activity(String description, Date startDate, Date endDate,float activityHours){
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.activityHours = activityHours;
    }
     
    /**
     * Retora uma string dos atributos
     * @return Retorna uma string contendo os atributos de uma atividade
     */
    public String toString() {  
	return "descricao atividade: " + description + " CHA: " + activityHours + " data de inicio: " + startDate.toString() + "data de termino: " + endDate;  
}
    
    /**
     * Dado duas datas, calcula a quantidade de dias passado entre as duas
     * e multiplica por 8 para obter a quantidade de horas gastas na atividade
     * @param startDate Data de inicio da atividade
     * @param endDate Data do termino da atividade
     * @return A quantidade de horas que a atividade vale
     */
    private float calcActivityHours(Date startDate, Date endDate){
        long diferenca;
        int miliSecDay = 1000 * 60 * 60 * 24; //Quantidade de milisegundos em um dia
        float hoursSpent;
        int maxDayWork = 8;
        Calendar initDate = Calendar.getInstance();
                
        Calendar finalDate = Calendar.getInstance();
        
        initDate.set(Calendar.YEAR, startDate.getYear());
        initDate.set(Calendar.MONTH, startDate.getMonth());
        initDate.set(Calendar.DAY_OF_MONTH, startDate.getMonth());

        finalDate.set(Calendar.YEAR, endDate.getYear());
        finalDate.set(Calendar.MONTH, endDate.getMonth());
        finalDate.set(Calendar.DAY_OF_MONTH, endDate.getMonth());
        
        //Calcula a quandidade de milisegundos entre as duas datas e divide pela quantidade de milisegundos contidos em um dia, 
        //para descobrir quantos dias se passaram
        diferenca = (finalDate.getTimeInMillis() - initDate.getTimeInMillis()) / miliSecDay;
        
        hoursSpent = diferenca * maxDayWork;
        
        
        return hoursSpent;
    }
    
}
