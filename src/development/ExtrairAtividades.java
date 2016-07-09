/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package development;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Gilmar
 */
public class ExtrairAtividades {
    public static void main(String[] args) throws IOException {
        PDFManager pdfManager = new PDFManager();
        ActivitiesReader activitiesReader = new ActivitiesReader();
        
        pdfManager.setFilePath("Radoc-2011-Final.pdf");
        String radoc = pdfManager.ToText();
        
        ArrayList<Activity> activities = new ArrayList<Activity>();
        //transformar essas atividades em enum
        String atividadesEnsino = activitiesReader.extractActivities(radoc, "Atividades de ensino", "Atividades de orientação");
        String atividadesOrientacao = activitiesReader.extractActivities(radoc, "Atividades de orientação", "Atividades em projetos");
        String atividadesProjeto = activitiesReader.extractActivities(radoc, "Atividades em projetos", "Atividades de extensão");
        String atividadesExtensao = activitiesReader.extractActivities(radoc, "Atividades de extensão", "Atividades de qualificação");
        String atividadesQualificacao = activitiesReader.extractActivities(radoc, "Atividades de qualificação", "Atividades acadêmicas especiais");
        String atividadesEspeciais = activitiesReader.extractActivities(radoc, "Atividades acadêmicas especiais", "Atividades administrativas");
        String atividadesAdministrativas = activitiesReader.extractActivities(radoc, "Atividades administrativas", "Produtos");
        
        activities.addAll(activitiesReader.extractActivity(atividadesOrientacao));
        activities.addAll(activitiesReader.extensãoActivities(atividadesExtensao));
        activities.addAll(activitiesReader.qualificacaoActivities(atividadesQualificacao));
        
        for (Activity activity :activities) {
            System.out.println(activity.toString());;
        }
        
    }  
}
