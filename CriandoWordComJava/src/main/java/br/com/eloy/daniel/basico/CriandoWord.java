package br.com.eloy.daniel.basico;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CriandoWord {
	
	private static String output = "HistoriaDoDia.docx";
	private static final String FONT_COURIER = "Arial";

	public static void main(String[] args) throws Exception {
		try (var document = new XWPFDocument()) {

			XWPFParagraph titulo = document.createParagraph();
			titulo.setAlignment(ParagraphAlignment.CENTER);//Orientação da linha 
			XWPFRun tituloRun = titulo.createRun();
			tituloRun.setText("Batatinha Quando Nasce");//Titulo
			tituloRun.setColor("6495ED");//Cor do titulo
			tituloRun.setBold(true);//Itálico
			tituloRun.setFontFamily(FONT_COURIER);//Fonte do titulo
			tituloRun.setFontSize(20);//Tamanho da fonte do titulo
			
			XWPFParagraph subTitulo = document.createParagraph();
			subTitulo.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun subTituloRun = subTitulo.createRun();
			subTituloRun.setText("Esta é uma história infantil");
			subTituloRun.setColor("00CC44");
			subTituloRun.setFontFamily(FONT_COURIER);
			subTituloRun.setFontSize(16);
			subTituloRun.setTextPosition(20);
			subTituloRun.setUnderline(UnderlinePatterns.DOT_DOT_DASH);//Sublinhado

			XWPFParagraph imagem = document.createParagraph();
			imagem.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun imagemRun = imagem.createRun();
			imagemRun.setTextPosition(20);
			
			var imagePath = Paths.get(ClassLoader.getSystemResource("batatinha.jpg").toURI());
			imagemRun.addPicture(Files.newInputStream(imagePath), Document.PICTURE_TYPE_PNG, 
			imagePath.getFileName().toString(), Units.toEMU(300), Units.toEMU(200));

			XWPFParagraph secao = document.createParagraph();
			secao.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun secaoRun = secao.createRun();
			secaoRun.setText("Segue a história.");
			secaoRun.setColor("00CC44");
			secaoRun.setBold(true);
			secaoRun.setFontFamily(FONT_COURIER);
			secaoRun.setItalic(true);
			
			XWPFParagraph paragrafo1 = document.createParagraph();
			paragrafo1.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun para1Run = paragrafo1.createRun();
			para1Run.setText("Batatinha");
			para1Run.setFontSize(16);

			XWPFParagraph paragrafo2 = document.createParagraph();
			paragrafo2.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun para2Run = paragrafo2.createRun();
			para2Run.setText("quando nasce");
			para2Run.setTextPosition(20);
			para2Run.setFontSize(14);

			XWPFParagraph paragrafo3 = document.createParagraph();
			paragrafo3.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun para3Run = paragrafo3.createRun();
			para3Run.setText("espalha a rama pelo chão. \n");
			para3Run.setFontSize(14);
			
			
			XWPFParagraph paragrafo4 = document.createParagraph();
			paragrafo4.setAlignment(ParagraphAlignment.RIGHT);
			XWPFRun para4Run = paragrafo4.createRun();
			para4Run.setText("Menininha");
			para4Run.setFontSize(16);
			
			XWPFParagraph paragrafo5 = document.createParagraph();
			paragrafo5.setAlignment(ParagraphAlignment.RIGHT);
			XWPFRun para5Run = paragrafo5.createRun();
			para5Run.setText("quando dorme");
			para5Run.setFontSize(14);
			
			XWPFParagraph paragrafo6 = document.createParagraph();
			paragrafo6.setAlignment(ParagraphAlignment.RIGHT);
			XWPFRun para6Run = paragrafo6.createRun();
			para6Run.setText("põe a mão no coração.");
			para6Run.setFontSize(14);
			
			try (var out = new FileOutputStream(output)) {
				document.write(out);
			}
		}
	}

}
