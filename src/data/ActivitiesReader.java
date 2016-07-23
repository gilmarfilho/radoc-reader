/*
 * Classe responsavel por extrair as atividades dp radoc
 */
package data;

/**
 *
 * @author Gilmar
 */
public class ActivitiesReader {
    public String extractActivities(String radoc, String firstActivity, String secondActivity) {
        int initalPos = radoc.indexOf(firstActivity);
        int endPos = radoc.indexOf(secondActivity);
        String activities = radoc.substring(initalPos, endPos);
        activities = this.removeFooterHeaderReturn(activities);
        
        return activities;
    }
    /**
     * Extrai um bloco de texto entre duas tags
     * @param activities String contendo todas as atividades
     * @param tag1 Padrão de inicio
     * @param tag2 Padrão de termino
     * @return Bloco de texto entre tag1 e tag2
     */
    public String extractData(String activities, String tag1, String tag2){
        int initialPos = activities.indexOf(tag1);
        int endPos = activities.indexOf(tag2);

        String data = activities.substring(initialPos + tag1.length(), endPos -1);
        return data;
    }
    
    /**
     * Extrai uma data de uma string
     * @param activities String contendo a atividade
     * @param tag Padrão de inicio
     * @return String contendo uma data
     */
    public String extractDateField(String activities, String tag){
        int initialPos = activities.indexOf(tag) + tag.length();
        int endPos = initialPos + 11;

        String date = activities.substring(initialPos , endPos);
        return date;
    }
    
    /**
     * Remove um campo de uma string
     * @param activities String da atividade
     * @param tag padrão a ser removido
     * @return String da atividade sem o parão
     */
    public String deleteData(String activities, String tag){
        activities = activities.replaceFirst(tag, "extraido");
        return activities;
    }

    /**
     * Remove o header e o footer do pdf e quebras de linha
     * @param sessionActivities String da atividade
     * @return String da atividade Sem footer, header e quebra de linha
     */
    private String removeFooterHeaderReturn(String sessionActivities){
        
        while(sessionActivities.contains("\r\n")){
            sessionActivities = sessionActivities.replaceFirst("\r\n", " ");
        }
        while(sessionActivities.contains("\n")){
            sessionActivities = sessionActivities.replaceFirst("\n", " ");
        }
        
        while(sessionActivities.contains("Data:")){
            sessionActivities = sessionActivities.replaceFirst("Data: [0-9]+/[0-9]+/[0-9]+ [0-9]+:[0-9]+:[0-9]+                                                  JULIANO LOPES DE OLIVEIRA Página  [0-9]+ / [0-9]+", " ");
        }
        while(sessionActivities.contains("UNIVERSIDADE FEDERAL DE GOIÁS " +
                "SISTEMA DE CADASTRO DE ATIVIDADES DOCENTES " +
                "EXTRATO DAS ATIVIDADES")){
            sessionActivities = sessionActivities.replaceFirst("UNIVERSIDADE FEDERAL DE GOIÁS " +
"SISTEMA DE CADASTRO DE ATIVIDADES DOCENTES " +
"EXTRATO DAS ATIVIDADES - ANO BASE: 201[0-9]+", " ");
        }
        
        return sessionActivities;
    }
}
