package simula.runtime;

import java.awt.Font;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

// ***************************************************************************
// *** CLASS: _Printing
// ***************************************************************************
// http://docs.oracle.com/javase/7/docs/api/java/awt/print/package-summary.html
// http://docs.oracle.com/javase/tutorial/2d/printing/index.html
public class _Printer {

	// -----------------------------------------------------------------------------
	// Paper size: http://en.wikipedia.org/wiki/ISO_216
	// 
	// Stående A4: Width:  8.3  inches = 210 mm =  595 pixels
	//             Height: 11.7 inches = 297 mm =  842 pixels.
	//
	// Stående A3: Width:  11.7 inches = 297 mm =  842 pixels
	//             Height: 16.5 inches = 420 mm = 1191 pixels.
	// -----------------------------------------------------------------------------
	private static final double inch=0.02540; // 1 inch == 0.02540 meter
	private static final int printerDPI=72; // DPI = Dots Per Inch
	private static final double pixelsPerMeter=((double)printerDPI)/inch;
	private static final double pixelsPerMilli=pixelsPerMeter/1000.0d;
	
	public static final boolean DEBUG=false;//true;

	private PrinterJob printerJob;
	PageFormat pageFormat;
	private Book book;
	private _PrintPage currentPrintPage;
	public Font font;
	public float lineGap; // 
	public int linesPerSheet;

	public _Printer(final String jobName,final Font font,int orientation,boolean ask,double left, double right, double top, double bot) {
		this.font=font;
		if(font==null) {
			this.font=new Font(Font.MONOSPACED, Font.PLAIN, 12);
			orientation=PageFormat.PORTRAIT;
//			ask=true;
		}
		printerJob=PrinterJob.getPrinterJob();
		book=new Book();
		printerJob.setPageable(book);
		printerJob.setJobName(jobName);

		pageFormat=printerJob.defaultPage();
		pageFormat.setOrientation(orientation);
		setMargins(pageFormat,left,right,top,bot);
		if(ask) pageFormat=printerJob.pageDialog(pageFormat);
		lineGap=this.font.getSize2D()*1.25f;
		linesPerSheet=(int) (pageFormat.getImageableHeight()/(double)lineGap);
		
		if(DEBUG) {
			System.out.println("NEW _Printer: pageFormat.getHeight="+pageFormat.getHeight()+", pageFormat.getWidth="+pageFormat.getWidth());
			System.out.println("NEW _Printer: pageFormat.getImageableHeight="+pageFormat.getImageableHeight()+", pageFormat.getImageableWidth="+pageFormat.getImageableWidth());
			System.out.println("NEW _Printer: pageFormat.getImageableX="+pageFormat.getImageableX()+", pageFormat.getImageableY="+pageFormat.getImageableY());
			logPageFormat("_Printer: "+" normal",pageFormat);
			System.out.println("NEW _Printer: currentFont="+font);
			System.out.println("NEW _Printer: lineGap="+lineGap+", linesPerSheet="+linesPerSheet);
		}
	}

	public void setMargins(final PageFormat sheet,double left, double right, double top, double bot) {
		if(sheet.getOrientation()==PageFormat.LANDSCAPE) {
			double ll=left; left=right; right=ll; 
		}
//		dumpPaper(pageFormat.getPaper(), right * pixelsPerMilli, bot * pixelsPerMilli);
		double X = left * pixelsPerMilli;
		double Y = top * pixelsPerMilli;
		double width = sheet.getWidth() - (left + right) * pixelsPerMilli;
		double height = sheet.getHeight() - (top + bot) * pixelsPerMilli;
		
//		System.out.println("_Printer.setMargins: X = "+X);
//		System.out.println("_Printer.setMargins: Y = "+Y);
//		System.out.println("_Printer.setMargins: width = "+width);
//		System.out.println("_Printer.setMargins: height = "+height);

		Paper paper=pageFormat.getPaper();
		if(sheet.getOrientation()==PageFormat.PORTRAIT)
			 paper.setImageableArea(X,Y,width,height);			
		else paper.setImageableArea(Y,X,height,width);
		
		pageFormat.setPaper(paper);
//		dumpPaper(pageFormat.getPaper(), right * pixelsPerMilli, bot * pixelsPerMilli);
	}
	
	private void dumpPaper(Paper paper,double right,double bot) {
		System.out.println("\n_Printer.dumpPaper: width = "+paper.getWidth());
		System.out.println("_Printer.dumpPaper: height = "+paper.getHeight());
		System.out.println("_Printer.dumpPaper: X = "+paper.getImageableX());
		System.out.println("_Printer.dumpPaper: Y = "+paper.getImageableY());
		System.out.println("_Printer.dumpPaper: clipWidth = "+paper.getImageableWidth());
		System.out.println("_Printer.dumpPaper: clipHeight = "+paper.getImageableHeight());
		System.out.println("_Printer.dumpPaper: calcWidth = "+(paper.getImageableX()+paper.getImageableWidth()+right));
		System.out.println("_Printer.dumpPaper: clipHeight = "+(paper.getImageableY()+paper.getImageableHeight()+bot));
		
	}
	
	private boolean isBookEmpty() {
		int n=book.getNumberOfPages();
		for(int i=0;i<n;i++) {
			_PrintPage page=(_PrintPage) book.getPrintable(i);
			if(page.nLines() > 0) return(false);
		}
		return(true);
	}

		
	public void dumpBook(String title) {
		int n=book.getNumberOfPages();
		System.out.println("====================== "+title+", nPages="+n+" ======================");
		for(int i=0;i<n;i++) {
			_PrintPage page=(_PrintPage) book.getPrintable(i);
			page.dump("Index "+i);
		}
	}
	
	public void newPage(int n) {
		currentPrintPage=new _PrintPage(this,n,1);
		book.append(currentPrintPage,pageFormat);
	}

	public void addLine(String text) {
		if(currentPrintPage.nLines() >= linesPerSheet) {
			int page=currentPrintPage.pageNumber;
			int sheet=currentPrintPage.sheetNumber;
			currentPrintPage=new _PrintPage(this,page,sheet+1);
			book.append(currentPrintPage,pageFormat);
		}
		currentPrintPage.addLine(text);
	}

	public void print() {
		if(DEBUG) dumpBook("_Printing.print: isBookEmpty="+isBookEmpty());
		if(isBookEmpty()) return; // Nothing tp print
		boolean ok=printerJob.printDialog();
		if(DEBUG) System.out.println("_Printing.print: ok="+ok+", book="+book+", numberOfPages="+book.getNumberOfPages());
		if(ok) try { printerJob.print(); } catch(PrinterException e) { e.printStackTrace(); }
	}

	private void logPageFormat(String title,PageFormat pageFormat) {
		String orientation="UNKNOWN";
		if(pageFormat.getOrientation()==PageFormat.LANDSCAPE) orientation="LANDSCAPE";
		if(pageFormat.getOrientation()==PageFormat.PORTRAIT) orientation="PORTRAIT";
		if(pageFormat.getOrientation()==PageFormat.REVERSE_LANDSCAPE) orientation="REVERSE_LANDSCAPE";
		Paper paper=pageFormat.getPaper();
		System.out.println("_Printing.logPageFormat: "+title+"  "+"PageFormat: "+orientation+", Paper: width="+paper.getWidth()+", height="+paper.getHeight());
	}


}
