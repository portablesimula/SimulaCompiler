package simula.runtime;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.io.Writer;
import java.util.Vector;

import javax.print.PrintService;
import javax.swing.JOptionPane;

public class PageWriter extends Writer {
	// ===========================================================================================================
	//
	//   Page oriented Print Service
	//
	// ===========================================================================================================
	// Paper size: http://en.wikipedia.org/wiki/ISO_216
	// 
	// Stående A4: Width:  8.3  inches = 210 mm =  595 pixels
	//             Height: 11.7 inches = 297 mm =  842 pixels.
	//
	// Stående A3: Width:  11.7 inches = 297 mm =  842 pixels
	//             Height: 16.5 inches = 420 mm = 1191 pixels.
	// ===========================================================================================================
	private static final double inch=0.02540; // 1 inch == 0.02540 meter
	private static final int printerDPI=72;   // DPI = Dots Per Inch
	private static final double pixelsPerMeter=((double)printerDPI)/inch;
	private static final double pixelsPerMilli=pixelsPerMeter/1000.0d;

	private String fileName;
	private PrinterJob printerJob;
	private Book book;
	private Sheet currentSheet;
	private PageFormat pageFormat;
	private float lineGap; // 
	private int linesPerSheet;
	
	private Font font;
	private int orientation;
	private boolean ask;
	private double left, right, top, bot;
	private StringBuilder currentLine;
	
	public PageWriter(String fileName) {
		this.fileName=fileName;
	}
	
	public void setFont(Font font,int orientation,boolean ask) {
		this.font=font; this.orientation=orientation; this.ask=ask;
	}
	
	public void setMargins(double top, double left, double bot, double right) {
		this.left=left; this.right=right; this.top=top; this.bot=bot;
	}

	public void open() {
		if(font==null) {
			this.font=new Font(Font.MONOSPACED, Font.PLAIN, 12);
			orientation=PageFormat.PORTRAIT;
		}
		printerJob=PrinterJob.getPrinterJob();
		book=new Book();
		printerJob.setPageable(book);

		pageFormat=printerJob.defaultPage();
		pageFormat.setOrientation(orientation);
		setMargins(pageFormat,top,left,bot,right);
		if(ask) pageFormat=printerJob.pageDialog(pageFormat);
		lineGap=this.font.getSize2D()*1.25f;
		linesPerSheet=(int) (pageFormat.getImageableHeight()/(double)lineGap);
		currentLine=new StringBuilder();
	}

	@Override
	public void close() throws IOException {
		print();
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		for(int i=0;i<len;i++) addChar(cbuf[off+i]);
	}

	@Override
	public void flush() throws IOException {}

	public void newPage(int n) {
		currentSheet=new Sheet(this,n,1);
		book.append(currentSheet,pageFormat);
	}

	public int getLinesPerSheet() {
		return(linesPerSheet);
	}

	private void addChar(char c) {
		if(c == '\n') newLine();
		else currentLine.append(c); 
	}
	
	private void newLine() {
		if(currentSheet.nLines() >= linesPerSheet) {
			int page=currentSheet.pageNumber;
			int sheet=currentSheet.sheetNumber;
			currentSheet=new Sheet(this,page,sheet+1);
			book.append(currentSheet,pageFormat);
		}
		currentSheet.addLine(currentLine.toString());
		currentLine=new StringBuilder();
	}

	private void setMargins(final PageFormat sheet, double top, double left, double bot, double right) {
		if(sheet.getOrientation()==PageFormat.LANDSCAPE) {
			double ll=left; left=right; right=ll; // Swap  left  <==>  right
		}
		double X = left * pixelsPerMilli;
		double Y = top * pixelsPerMilli;
		double width = sheet.getWidth() - (left + right) * pixelsPerMilli;
		double height = sheet.getHeight() - (top + bot) * pixelsPerMilli;

		Paper paper=pageFormat.getPaper();
		if(sheet.getOrientation()==PageFormat.PORTRAIT)
			 paper.setImageableArea(X,Y,width,height);			
		else paper.setImageableArea(Y,X,height,width);
		
		pageFormat.setPaper(paper);
	}
	
	private boolean isBookEmpty() {
		int n=book.getNumberOfPages();
		for(int i=0;i<n;i++) {
			Sheet page=(Sheet) book.getPrintable(i);
			if(page.nLines() > 0) return(false);
		}
		return(true);
	}

	private void print() {
		if(isBookEmpty()) return; // Nothing to print
		boolean ok=false;
		PrintService printService=lookupPrintService();
		if(printService != null) {
			try { printerJob.setPrintService(printService); ok=true;
			} catch (PrinterException e) {}
		} else ok=printerJob.printDialog();
		if(ok) while(tryPrint());
	}

	private boolean tryPrint() {
		try { printerJob.print(); } catch(PrinterException e) {
			//if(commandLine) throw new _SimulaRuntimeError(e.getMessage());
			PrintService printService=printerJob.getPrintService();
			String msg1; msg1=(printService==null)?"":"to "+printService;
			String msg2=e.getMessage(); msg2=(msg2==null)?"":"\n"+msg2;
			int res=_RT.optionDialog("Attempt to print "+msg1+" - FAILED"+msg2
					+"\nDo you want to retry ?","Error",JOptionPane.YES_NO_OPTION
					, JOptionPane.ERROR_MESSAGE, "Yes", "No");
			if(res==JOptionPane.YES_OPTION) return(true);
		}
		return(false);
	}

	private PrintService lookupPrintService() {
		PrintService[] printServices=PrinterJob.lookupPrintServices();
		for(PrintService printService:printServices) {
			if(printService.getName().equalsIgnoreCase(fileName)) return(printService);			
		}
		return(null);
	}


	// ********************************************************************
	// *** CLASS: Sheet
	// ********************************************************************
	private class Sheet implements Printable {
		private PageWriter printer;
		public int pageNumber;
		public int sheetNumber;
		private Vector<String> lines=new Vector<String>();
		public int nLines() { return(lines.size()); }

		public Sheet(PageWriter printer,int pageNumber,int sheetNumber) {
			this.printer=printer;
			this.pageNumber=pageNumber;
			this.sheetNumber=sheetNumber;
		}

		public void addLine(String text) { lines.add(text); }

		public int print(Graphics g,PageFormat pageFormat,int pageIndex) throws PrinterException {
			Graphics2D g2=(Graphics2D) g;
			g2.setFont(printer.font);
			float x=(float) printer.pageFormat.getImageableX();
			float y=(float) printer.pageFormat.getImageableY();
			y=y+printer.font.getSize();
			for(int i=0;i<lines.size();i++) {
				String line=lines.get(i);
				if(line!=null) g2.drawString(line,x,y);
				y=y+printer.lineGap;
			}
			return(Printable.PAGE_EXISTS); // The page is rendered successfully.
		}

	}

}
