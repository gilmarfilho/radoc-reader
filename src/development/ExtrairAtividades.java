/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package development;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Gilmar
 */
public class ExtrairAtividades {
    public static void main(String[] args) throws IOException {
        PDFManager pdfManager = new PDFManager();
        pdfManager.setFilePath("Radoc-2011-Final.pdf");
        PrintWriter out = new PrintWriter("filename.txt");
        out.println(pdfManager.ToText());
        //System.out.println(pdfManager.ToText());       
    }  
}
