/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package development;

import activities.Activity;
import activities.*;
import data.PDFManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Gilmar
 */
public class ExtrairAtividades {
    public static void main(String[] args) throws IOException, ParseException {

        
        PDFManager pdfManager = new PDFManager();
        //Abre o pdf com o nome passado com parametro
        pdfManager.setFilePath(args[0]);
        //Recebe o conteudo do radoc como string
        String radoc = pdfManager.ToText();
        ArrayList<Activity> activities = new ArrayList<Activity>();
        
        //Cria e passa o radoc para cada atividade
        Administrativas administrativas = new Administrativas(radoc);
        Ensino ensino = new Ensino(radoc);
        Especiais especiais = new Especiais(radoc);
        Extensao extensao = new Extensao(radoc);
        Orientacao orientacao = new Orientacao(radoc);
        Projeto projeto = new Projeto(radoc);
        Qualificacao qualificacao = new Qualificacao(radoc);
        PrintWriter writer = new PrintWriter("atividades.txt");
        int contador = 1;
        
        //Extrai as atividades
        activities.addAll(administrativas.extractActivities());
        activities.addAll(ensino.extractActivities());
        activities.addAll(especiais.extractActivities());
        activities.addAll(extensao.extractActivities());
        activities.addAll(orientacao.extractActivities());
        activities.addAll(projeto.extractActivities());
        activities.addAll(qualificacao.extractActivities());
        
        //Imprime o conteudo extraido das atividades para um atquivo txt
        for (Activity activity :activities) {
            writer.println(contador + "\t" + activity.toString() + "\n");
            System.out.println(contador + "\t" + activity.toString());
            contador++;
        }
        
        writer.close();
    }  
}
