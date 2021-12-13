import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class Campanha {




    public static void main(String[] args) {

        Document document = new Document(PageSize.A4.rotate());

        BaseColor corTurqueza = new BaseColor(0,206,209);
        BaseColor corTurquezaEscuro = new BaseColor(0,128,128);


        try{

            //===========//===========//===========//===========//===========//===========//===========//===========//

            PdfWriter.getInstance(document,new FileOutputStream("/home/arieltintel/projetos/Campanha.pdf"));
            document.open();

            Paragraph paragraph1 = new Paragraph("Dados da campanha",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,corTurquezaEscuro));
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            paragraph1.setSpacingAfter(10);
            document.add(paragraph1);

            //===========//===========//===========//===========//===========//===========//===========//===========//

            //tabela INTERNA 1
            //Tabela dentro de outra Tabela
            PdfPTable tabelaInterna1 = new PdfPTable(2);
            PdfPCell celulaInterna1 = new PdfPCell();
            tabelaInterna1.getDefaultCell().setBorder(Rectangle.NO_BORDER); //Remove a borda, exceto a de cima
            celulaInterna1.setBorder(Rectangle.NO_BORDER); //Em conjunto, remove todas as bordas.
            celulaInterna1.setColspan(3); //Quantidade de linhas de uma celula
            tabelaInterna1.addCell(celulaInterna1);
            tabelaInterna1.addCell(setCellTuqueza("Nome da campanha:"));
            tabelaInterna1.addCell("Campanha Teste");
            tabelaInterna1.addCell(setCellTuqueza("Datas:"));
            tabelaInterna1.addCell("06/12/2021 à 06/12/2021");
            tabelaInterna1.addCell(setCellTuqueza("Qtd. de indicadores:"));
            tabelaInterna1.addCell("1");
            //A TABELA "INTERNA", DEVE SER ADICIONADO NA TABELA EXTERNA
            //document.add(tabelaInterna1);

            //===========//===========//===========//===========//===========//===========//===========//===========//

            //tabela INTERNA 2
            PdfPTable tabelaInterna2 = new PdfPTable(2);
            PdfPCell celulaInterna2 = new PdfPCell();
            tabelaInterna2.getDefaultCell().setBorder(Rectangle.NO_BORDER); //Remove a borda, deixando a de cima
            celulaInterna2.setBorder(Rectangle.NO_BORDER); //Em conjunto, remove todas as bordas.
            celulaInterna2.setColspan(2);
            tabelaInterna2.addCell(celulaInterna2);
            tabelaInterna2.addCell(" ");
            tabelaInterna2.addCell(" ");
            tabelaInterna2.addCell(setCellTuqueza("Status:"));
            tabelaInterna2.addCell("Criado");
            tabelaInterna2.addCell(setCellTuqueza("Qtd. times"));
            tabelaInterna2.addCell("0");
            //document.add(tabelaInterna2); <--- DEVE SER ADICIONADO NA TABELA EXTERNA

            //===========//===========//===========//===========//===========//===========//===========//===========//

            // tabela EXTERNA
            PdfPTable tabelaSuperior = new PdfPTable(2);
            tabelaSuperior.getDefaultCell().setBorder(Rectangle.NO_BORDER);
            tabelaSuperior.addCell(tabelaInterna1);
            tabelaSuperior.addCell(tabelaInterna2);
            document.add(tabelaSuperior);

            //===========//===========//===========//===========//===========//===========//===========//===========//

            Paragraph paragraph2 = new Paragraph("Indicadores",FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,corTurquezaEscuro));
            paragraph2.setAlignment(Element.ALIGN_CENTER);
            paragraph2.setSpacingBefore(20);
            paragraph2.setSpacingAfter(10);
            document.add(paragraph2);

            //===========//===========//===========//===========//===========//===========//===========//===========//

            PdfPTable tabelaInferior = new PdfPTable(4);
            tabelaInferior.setWidths(new int[] {25,25,25,25});
            PdfPCell celula = new PdfPCell();

            tabelaInferior.getDefaultCell().setBorder(Rectangle.NO_BORDER);
            celula.setBorder(Rectangle.NO_BORDER);
            tabelaInferior.getDefaultCell().setMinimumHeight(20);

            celula.setColspan(5);
            tabelaInferior.addCell(celula);
            tabelaInferior.addCell(setCellTuquezaInferio("Nome do Indicador"));
            tabelaInferior.addCell(setCellTuquezaInferioAlignment("Objetivo"));
            tabelaInferior.addCell(setCellTuquezaInferio("Tipo"));
            tabelaInferior.addCell(setCellTuquezaInferio("Tipo da premiação"));
            tabelaInferior.addCell("Indicator");
            tabelaInferior.addCell(setCellAlignment("4566"));
            tabelaInferior.addCell("Bateu Levou");
            tabelaInferior.addCell("Monetario");
            tabelaInferior.addCell(" ");
            tabelaInferior.addCell(" ");
            tabelaInferior.addCell(setCellTuquezaInferio("Hierarquia"));
            tabelaInferior.addCell(setCellTuquezaInferioAlignment("Valor da premiação"));
            tabelaInferior.addCell(" ");
            tabelaInferior.addCell(setCellTuquezaInferio("Produto"));
            tabelaInferior.addCell(setCellTuquezaInferio("Qtd.Mínima"));
            tabelaInferior.addCell(setCellTuquezaInferioAlignment("Tipo"));
            tabelaInferior.addCell(" ");
            tabelaInferior.addCell("AGUARDANDO CODIGO DO PRODUTO");
            tabelaInferior.addCell("2");
            tabelaInferior.addCell("Produto específico");
            document.add(tabelaInferior);

            //===========//===========//===========//===========//===========//===========//===========//===========//

        } catch (DocumentException documentException) {
            System.err.println(documentException.getMessage());
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
        document.close();
    }

    // MÉTODOS PARA ADICIONAR COR NO FUNDO DO TITULO DA CELULA, E CONFIGURAR O ALINHAMENTO DO MESMO.
    private static PdfPCell setCellTuqueza(String texto) {
        PdfPCell cell = new PdfPCell(new Phrase(texto));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBackgroundColor(new BaseColor(0,206,209));
        return cell;
    }

    private static PdfPCell setCellTuquezaInferio(String texto) {
        PdfPCell cell = new PdfPCell(new Phrase(texto));
        //cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBackgroundColor(new BaseColor(0,206,209));
        return cell;
    }

    private static PdfPCell setCellTuquezaInferioAlignment(String texto) {
        PdfPCell cell = new PdfPCell(new Phrase(texto));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBackgroundColor(new BaseColor(0,206,209));
        return cell;
    }

    private static PdfPCell setCellAlignment(String texto) {
        PdfPCell cell = new PdfPCell(new Phrase(texto));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(Rectangle.NO_BORDER);
        //cell.setBackgroundColor(new BaseColor(0,206,209));
        return cell;
    }

}
