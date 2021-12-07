import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
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

            //Paragrafos Centralizado
            Paragraph paragraph1 = new Paragraph("Arquivo PDF gerado via iText em Java",
                    FontFactory.getFont(FontFactory.TIMES_BOLD, 20));
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph1);

            //Paragrafo Comum
            document.add(new Paragraph("Gerando meu primeiro PDF atraves do iText com Java.",
                    FontFactory.getFont(FontFactory.COURIER_OBLIQUE, 18)));

            //Adição de imagem
            Image jpg = Image.getInstance("/home/arieltintel/Imagens/java.jpeg");
            jpg.setAlignment(Element.ALIGN_CENTER);
            document.add(jpg);

            //Tabelas
            PdfPTable pdfPTable = new PdfPTable(3);
            //Espaçamento ANTES da tabela.
            pdfPTable.setSpacingBefore(20);
            
            PdfPCell tituloTabela = new PdfPCell(new Paragraph("Time da Seleção Brasileira"));
            tituloTabela.setColspan(3);
            pdfPTable.addCell(tituloTabela);
            pdfPTable.addCell("Gabriel Barbosa");
            pdfPTable.addCell("Daniel Alves");
            pdfPTable.addCell("Alex Sandro");
            pdfPTable.addCell("Richarlison");
            pdfPTable.addCell("Fabinho");
            pdfPTable.addCell("Raphinha");
            document.add(pdfPTable);

        } catch (DocumentException documentException) {
            System.err.println(documentException.getMessage());
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        } document.close();
    }
}
