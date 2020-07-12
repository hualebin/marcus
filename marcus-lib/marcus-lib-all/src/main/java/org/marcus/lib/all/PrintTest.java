package org.marcus.lib.all;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.*;
import javax.swing.*;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author marcus
 * 2018/6/26
 */
public class PrintTest {

	public void drawImage(String fileName, int count) {
		try {
			DocFlavor dof = null;
			if (fileName.endsWith(".gif")) {
				dof = DocFlavor.INPUT_STREAM.GIF;
			} else if (fileName.endsWith(".jpg")) {
				dof = DocFlavor.INPUT_STREAM.JPEG;
			} else if (fileName.endsWith(".png")) {
				dof = DocFlavor.INPUT_STREAM.PNG;
			}

			PrintService ps = PrintServiceLookup.lookupDefaultPrintService();

			PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
			pras.add(OrientationRequested.PORTRAIT);

			pras.add(new Copies(count));
			pras.add(PrintQuality.HIGH);
			pras.add(Chromaticity.COLOR);
			//pras.add(Fidelity.FIDELITY_FALSE);
			// pras.add(MediaSizeName.JAPANESE_POSTCARD);


			//pras.add(MediaSizeName.JAPANESE_POSTCARD);
			DocAttributeSet das = new HashDocAttributeSet();
				// 设置打印纸张的大小（以毫米为单位）
			//das.add(new MediaPrintableArea(0, 0, 89, 119, MediaPrintableArea.MM));

			FileInputStream fin = new FileInputStream(fileName);

			Doc doc = new SimpleDoc(fin, dof, das);

			DocPrintJob job = ps.createPrintJob();

			job.print(doc, pras);
			fin.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (PrintException pe) {
			pe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new PrintTest().drawImage("/Users/marcus/Documents/upload/text.png", 1);
	}
}