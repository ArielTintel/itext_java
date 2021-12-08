import com.itextpdf.awt.geom.misc.HashCode;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TabelaCampanhaPDF {

    public static void main(String[] args) throws DocumentException, IOException {

        TabelaCampanhaPDF tabelaCampanhaPDF = new TabelaCampanhaPDF();
        tabelaCampanhaPDF.createPdf("/home/arieltintel/projetos/DocumentoTeste.pdf");

    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();

        PdfPCell cellBackgroundGREEN = new PdfPCell();
        cellBackgroundGREEN.setBackgroundColor(BaseColor.GREEN);

        Paragraph paragraph1 = new Paragraph("Dados da Campanha",
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18));
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        paragraph1.setSpacingAfter(10);
        document.add(paragraph1);

        // Cabeçalho
        PdfPTable table = new PdfPTable(2);
        table.setWidths(new int[]{60, 40});

        // Primeira Celula
        PdfPTable table1 = new PdfPTable(2);
        table1.getDefaultCell().setBorder(Rectangle.NO_BORDER | Rectangle.NO_BORDER);
        table1.getDefaultCell().setMinimumHeight(25);

        table1.addCell(setCellGreen("Nome da Campanha"));
        table1.addCell("Campanha Teste");
        table1.addCell(setCellGreen("Data:"));
        table1.addCell("06/12/2021 á 06/12/2021");
        table1.addCell(setCellGreen("Qtd. de Indicadores"));

        int size = getIndicadores().size();
        table1.addCell(String.valueOf(size));

        table.addCell(new PdfPCell(table1));

        // TABELA 2 de cima
        PdfPTable table2 = new PdfPTable(2);
        table2.getDefaultCell().setBorder(Rectangle.NO_BORDER | Rectangle.NO_BORDER);
        table2.getDefaultCell().setMinimumHeight(28);
        table2.addCell("");
        table2.addCell("");
        table2.addCell(setCellGreen("Status:"));
        table2.addCell("CRIADO");
        table2.addCell(setCellGreen("Qtd. de Times:"));
        table2.addCell("0");

        table.addCell(new PdfPCell(table2));

        //ESPAÇAMENTO
        PdfPCell cell = new PdfPCell(new Paragraph("Indicadores",
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
        cell.setColspan(2);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setMinimumHeight(30);
        table.addCell(cell);
        document.add(table);

        // TABELA DE BAIXOOOOOOOOO
        table = new PdfPTable(4);
        table.setWidths(new int[]{2, 2, 3, 3});
        table.addCell(setCellGreen("Nome do Indicador"));
        table.addCell(setCellGreen("Objetivo"));
        table.addCell(setCellGreen("Tipo"));
        table.addCell(setCellGreen("Tipo da Premiação"));

        table.setHeaderRows(1);

        for (Indicador indicador : getIndicadores()){
            table.getDefaultCell().setMinimumHeight(16);
            table.addCell(indicador.getNomeIndicador());
            table.addCell(indicador.getObjetivo().toString());
            table.addCell(indicador.getTipo());
            table.addCell(indicador.getTipoPremiacao());
        }
        table.getDefaultCell().setFixedHeight(3);
        table.getDefaultCell().setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
        table.addCell("");
        document.add(table);
        document.close();

        System.out.println("SUCESSO!!");
    }

    private PdfPCell setCellGreen(String texto) {
        PdfPCell cell = new PdfPCell(new Phrase(texto));
        cell.setBackgroundColor(BaseColor.GREEN);
        return cell;
    }

    private Produto getProduto(){
        return new Produto(new HashCode().append(1234775377L),2L,"Produto Especifico");
    }

    private List<Indicador> getIndicadores() {
        Indicador indicador = new Indicador("Indicador 3", 4566L, "Bateu Levou", "Monetária");
        Indicador indicador2 = new Indicador("Indicador 2", 4567L, "Bateu Levou 2", "Monetária");
        Indicador indicador3 = new Indicador("Indicador 1", 4566L, "Bateu Levou 3", "Monetária");
        Indicador indicador4 = new Indicador("Indicador 4", 4566L, "Bateu Levou 4", "Monetária");
        return Arrays.asList(indicador, indicador2, indicador3, indicador4);
    }
}