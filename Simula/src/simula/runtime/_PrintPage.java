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
	static final long serialVersionUID=0; // AD'HOC
	private _Printer printer;
	public int pageNumber;
	public int sheetNumber;
	private Vector<String> lines=new Vector<String>();
	public int nLines() { return(lines.size()); }

	// ******************************************************************
	// *** CONSTRUCTOR: _PrintPage
	// ******************************************************************
	public _PrintPage(_Printer printer,int pageNumber,int sheetNumber) {
		this.printer=printer;
		this.pageNumber=pageNumber;
		this.sheetNumber=sheetNumber;
//		System.out.println("NEW _PrintPage: "+pageNumber+", sheet "+sheetNumber+"   lines.size="+lines.size());
	}

	// *************************************************************************
	// *** METHOD: addLine
	// *************************************************************************
	public void addLine(String text) {
//		System.out.println("_PrintPage: Page: "+pageNumber+", sheet "+sheetNumber+", Line "+lines.size()+", lineCount="+lines.size()+" \""+text+'"');
		lines.add(text);
//		dump("addLine");
	}

	// *************************************************************************
	// *** METHOD: print
	// *************************************************************************
	public int print(Graphics g,PageFormat pageFormat,int pageIndex) throws PrinterException {
		if(_Printer.DEBUG) {
			System.out.println("_PrintPage.print: +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Page: "+pageNumber+", sheet "+sheetNumber+" ===>  pageIndex="+pageIndex);
			System.out.println("_PrintPage.print: Font="+g.getFont());
		}
		Graphics2D g2=(Graphics2D) g;
		//		if (pageIndex > 0) return(Printable.NO_SUCH_PAGE);
		g2.setFont(printer.font);
		float x=(float) printer.pageFormat.getImageableX();
		float y=(float) printer.pageFormat.getImageableY();
		y=y+printer.font.getSize();
		for(int i=0;i<lines.size();i++) {
			String line=lines.get(i);
//			System.out.println("_PrintPage.print: Render Line("+i+','+x+','+y+"): \""+line+'"');
			if(line!=null) g2.drawString(line,x,y);
			y=y+printer.lineGap;
		}
		if(_Printer.DEBUG)
			System.out.println("_PrintPage.print: ++++++++++++++++++++++++++++++PAGE_EXISTS+++++++++++++++++++++++++++++++++++++++++ Page: "+pageNumber+", sheet "+sheetNumber+" ===>  pageIndex="+pageIndex);
		return(Printable.PAGE_EXISTS); // The page is rendered successfully.
	}

	// *************************************************************************
	// *** METHOD: dump
	// *************************************************************************
	public void dump(String title) {
		System.out.println("====================== Page: "+pageNumber+", sheet "+sheetNumber+": "+title+" ======================");
		for(int i=0;i<lines.size();i++)
			System.out.println("Line: "+i+": "+lines.get(i));
		System.out.println("=====================================================");
	}

}
