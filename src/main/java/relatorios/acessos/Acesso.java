package relatorios;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Acesso {
    public static void main(String[] args) {

        Document document = new Document(PageSize.A4);
        BaseColor azulEscuro = new BaseColor(25,25,112);

        try {

            PdfWriter.getInstance(document, new FileOutputStream("/home/arieltintel/sellers_Java_JR/atividades/relatorios/Acessos.pdf"));
            document.open();

            //Logo Marca
            Image logomarca = Image.getInstance("/home/arieltintel/sellers_Java_JR/logoRelatorioAcesso.jpeg");
            logomarca.setAlignment(Element.PARAGRAPH);
            document.add(logomarca);

            //Primeiro Paragrafo
            Paragraph tituloParagraph = new Paragraph("Relatório de Acessos",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20,azulEscuro));
            tituloParagraph.setSpacingAfter(30);
            document.add(tituloParagraph);

            //Segundo Paragrafo
            Paragraph paragraphEmpresa = new Paragraph("Empresa: {nomeEmpresa}",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12,azulEscuro));
            paragraphEmpresa.setAlignment(Element.ALIGN_CENTER);
            paragraphEmpresa.setSpacingAfter(5);
            document.add(paragraphEmpresa);

            //TABELA
            PdfPTable tabela1 = new PdfPTable(3);
            PdfPCell celula1 = new PdfPCell();
            tabela1.setSpacingBefore(5);
            tabela1.setSpacingAfter(5);
            celula1.setBorderColor(new BaseColor(199,21,133)); //Adiciona cor na linha da borda

            tabela1.setWidths(new int[] {20,15,13});
            tabela1.getDefaultCell().setBorder(Rectangle.NO_BORDER);
            celula1.setColspan(3);
            tabela1.addCell(celula1);
            tabela1.addCell("Nome");
            tabela1.addCell("Ultimo acesso APP");
            tabela1.addCell("Ultimo acesso WEB");
            document.add(tabela1);

            PdfPTable tabela2 = new PdfPTable(3);
            tabela2.getDefaultCell().setMinimumHeight(25);

            PdfPCell celula2 = new PdfPCell();
            celula2.setBorderColor(new BaseColor(199,21,133));

            tabela2.setWidths(new int[] {20,15,13});
            tabela2.getDefaultCell().setBorderColor(new BaseColor(255,0,255));
            tabela2.getDefaultCell().setBorder(Rectangle.NO_BORDER);
            celula2.setColspan(20);
            tabela2.addCell(celula2);
            List<String> list = new ArrayList<String>();
            list.add("{NomeFuncionario}");
            list.add("{DataEHora}");
            list.add("{DataEHora}");
            list.add("{NomeFuncionario}");
            list.add("{DataEHora}");
            list.add("{DataEHora}");
            list.add("{NomeFuncionario}");
            list.add("{DataEHora}");
            list.add("{DataEHora}");
            for (String conteudoCelula : list) {
                tabela2.addCell(conteudoCelula);
            }
            document.add(tabela2);

        } catch (DocumentException documentException) {
            System.err.println(documentException.getMessage());
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
        document.close();

        System.out.println("GERADO COM SUCESSO");
    }
}
