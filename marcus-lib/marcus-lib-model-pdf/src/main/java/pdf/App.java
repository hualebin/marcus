package pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Document document = new Document();  
    	try {
    		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("d:/Helloworld.PDF"));
    		writer.setPdfVersion(PdfWriter.PDF_VERSION_1_7);
    		document.addCreationDate();
    		document.addCreator("admin");
    		document.addTitle("helloworld pdf");
    		document.addKeywords("helloworld");
    		document.addSubject("admin export pdf");
		    document.open();
		   /* FontSelector selector = new FontSelector(); 
		    selector.addFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12));
		    selector.addFont(FontFactory.getFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED));  
		    Phrase phrase = selector.process("HelloWord！你好。\u4fdd\u5b58"); 
		    document.add(new Paragraph(phrase)); 
		    Phrase phrase1 = selector.process("你好");
		    document.add(new Paragraph(phrase1));
		    document.add(new Paragraph("中文"));*/
			BaseFont baseFont = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			Font font = new Font(baseFont);
			document.add(new Paragraph("中文", font));
		    document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
}
