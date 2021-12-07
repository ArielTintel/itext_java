import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class GeradorPDF {

    public static void main(String[] args) {

        Document document = new Document();

        //Novo Arquivo
        try {

            //Criação
            PdfWriter.getInstance(document, new FileOutputStream("/home/arieltintel/projetos/DocumentoTeste.pdf"));
            document.open();

            //Paragrafos
            document.add(new Paragraph("Arquivo PDF gerado via iText em Java",
                    FontFactory.getFont(FontFactory.TIMES_BOLD, 20)));
            document.add(new Paragraph("Gerando meu primeiro PDF atraves do iText com Java",
                    FontFactory.getFont(FontFactory.COURIER_OBLIQUE, 18)));

        } catch (DocumentException documentException) {
            System.err.println(documentException.getMessage());
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        } document.close();
    }
}
