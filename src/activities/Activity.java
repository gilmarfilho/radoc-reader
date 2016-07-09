/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jorge
 */
public class Activity {
    private String description;
    private Date startDate; 
    private Date endDate;
    private Float activityHours;

    public Activity(String description, String activityHours, String startDate, String endDate) throws ParseException{
        this.description = description;
        
        //conversão da string startDate para o tipo date
        SimpleDateFormat formatoS = new SimpleDateFormat("dd/MM/yyyy");
        this.startDate = formatoS.parse(startDate);
        
        //conversão da String endDate para o tipo date
        SimpleDateFormat formatoEnd = new SimpleDateFormat("dd/MM/yyyy");
        this.endDate = formatoEnd.parse(endDate);
        
        //conversão da String activityHours para Float
        Float horasAtividades = Float.valueOf(activityHours);
        
        if(horasAtividades == 1){
        //Calcula e atribui o numero de horas da atividade
        this.activityHours = calcActivityHours(this.startDate,this.endDate);
        
        }else{
                
        this.activityHours = horasAtividades;
        }  
    }

    /**
     * Retora uma string dos atributos
     * @return Retorna uma string contendo os atributos de uma atividade
     */
    public String toString() {  
	return "Descricao da Atividade:\t" + description + "\tCHA:\t" + activityHours.toString() + "\tData de Início:\t" + startDate + "\tData de Término:" + endDate; 
    } 
    
    /**
     * Dado duas datas, calcula a quantidade de dias passado entre as duas
     * e multiplica por 8 para obter a quantidade de horas gastas na atividade
     * @param startDate Data de inicio da atividade
     * @param endDate Data do termino da atividade
     * @return A quantidade de horas que a atividade vale
     */
    private float calcActivityHours(Date startDate, Date endDate){
        long difference;
        int miliSecDay = 1000 * 60 * 60 * 24; //Quantidade de milisegundos em um dia
        float hoursSpent;
        int maxDayWork = 8;// Numero maxido de horas permitidas
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
        difference = (finalDate.getTimeInMillis() - initDate.getTimeInMillis()) / miliSecDay;
        
        //Calculo para descobrir o numero de horas trabalhadas
        hoursSpent = difference * maxDayWork;
        
        
        return hoursSpent;
    }

    public String getDescription() {
        return description;
    }


    public Float getActivityHours() {
        return activityHours;
    }


    public Date getStartDate() {
        return startDate;
    }


    public Date getEndDate() {
        return endDate;
    }
}
