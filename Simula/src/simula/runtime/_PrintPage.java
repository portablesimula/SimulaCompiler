package simula.runtime;

import java.util.Vector;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

// ********************************************************************
// *** CLASS: _PrintPage
// ********************************************************************
public class _PrintPage implements Printable {
	private _PrintFile printer;
	public int pageNumber;
	public int sheetNumber;
	private Vector<String> lines=new Vector<String>();
	public int nLines() { return(lines.size()); }

	// ******************************************************************
	// *** CONSTRUCTOR: _PrintPage
	// ******************************************************************
	public _PrintPage(_PrintFile printer,int pageNumber,int sheetNumber) {
		this.printer=printer;
		this.pageNumber=pageNumber;
		this.sheetNumber=sheetNumber;
	}

	// *************************************************************************
	// *** METHOD: addLine
	// *************************************************************************
	public void addLine(String text) {
		lines.add(text);
	}

	// *************************************************************************
	// *** METHOD: print
	// *************************************************************************
	public int print(Graphics g,PageFormat pageFormat,int pageIndex) throws PrinterException {
		Graphics2D g2=(Graphics2D) g;
		g2.setFont(printer._FONT);
		float x=(float) printer.pageFormat.getImageableX();
		float y=(float) printer.pageFormat.getImageableY();
		y=y+printer._FONT.getSize();
		for(int i=0;i<lines.size();i++) {
			String line=lines.get(i);
			if(line!=null) g2.drawString(line,x,y);
			y=y+printer.lineGap;
		}
		return(Printable.PAGE_EXISTS); // The page is rendered successfully.
	}

}
