/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package development;

import java.io.IOException;

/**
 *
 * @author Gilmar
 */
public class ExtrairAtividades {
    public static void main(String[] args) throws IOException {
        PDFManager pdfManager = new PDFManager();
        pdfManager.setFilePath("C:\\Users\\Gilmar\\Documents\\radoc-reader\\Trabalho-3-Exemplos-Radoc\\Radoc-2011-Final.pdf");
        System.out.println(pdfManager.ToText());       
    }  
}
