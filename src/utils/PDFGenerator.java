/**
 * 
 */
package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import model.Pizza;

/**
 * @author GOBERT Guillaume
 *
 */
public class PDFGenerator {
	
	/** Creer les PDF du menu de la pizzaria apartir de la liste des pizzas
	 * @param pizzas
	 */
	public static void creatorPDF(List<Pizza> pizzas){
		Document document = new Document();

        try {
            PdfWriter.getInstance(document,
                new FileOutputStream("Menu pizzeria.pdf"));

            document.open();
            for(Pizza p : pizzas){
            	document.add(new Paragraph(p.toString()));
            }            
            document.close(); // no need to close PDFwriter?

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
}
