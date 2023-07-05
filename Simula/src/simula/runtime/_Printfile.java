/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * The Class PrintFile.
 * <p>
 * The class "printfile" defines a class for line printer oriented output.
 * 
 * <pre>
 * class printfile;
 * begin integer   LINE, LINES_PER_PAGE, SPACING, PAGE;
 *       integer procedure line;  line := LINE;
 *       integer procedure page;  page := PAGE;
 *       Boolean procedure open(fileimage);  text fileimage; 
 *       Boolean procedure close; 
 *       procedure linesperpage(n); integer n; 
 *       procedure spacing(n); integer n; 
 *       procedure eject(n);  integer n; 
 *       procedure outimage; 
 *       procedure outrecord; 
 * 
 *       SPACING := 1;
 *       LINES_PER_PAGE := ... ;
 *          ...
 * end printfile;
 * </pre>
 * <p>
 * An object of the class "printfile" is used to represent a line printer
 * oriented output file. The class is a subclass of "outfile". A file image
 * normally represents a line on a printed page.
 * <p>
 * It is a property of this class that "outfile" attributes, which are
 * redeclared at "printfile" level, are not accessible to the user's program
 * through explicit qualification (qua). Thus these "outfile" procedures
 * ("open", "close", "outimage", "outrecord") may be envisaged as including the
 * following initial code:
 * 
 * <pre>
 *               procedure X...;
 *               inspect this outfile
 *                  when printfile do X...
 *                  otherwise ...;
 * </pre>
 * <p>
 * Note: Consequently, possible implicit calls of outimage from outchar, close
 * and the item-oriented output procedures are understood to invoke
 * "printfile.outimage".
 * <p>
 * The variable LINE indicates the ordinal number of the next line to be printed
 * (on the current page), provided that no implicit or explicit "eject"
 * statement occurs. Its value is accessible through the procedure "line". Note
 * that the value of LINE may be greater than LINES_PER_PAGE (see 10.7.5).
 * <p>
 * The variable PAGE indicates the ordinal number of the current page. Its value
 * may be retrieved by means of procedure "page".
 * <p>
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class _Printfile extends _Outfile {
	private int _DEFAULT_LINES_PER_PAGE=66;
	public int _LINES_PER_PAGE=66;
	private int _SPACING=1;
	private int _LINE;
	private int _PAGE;
	
	// Constructor
    public _Printfile(final _RTObject staticLink,final _TXT FILENAME) {
    	super(staticLink,FILENAME);
    }
    
    // Class Statements
	@Override
    public _Printfile _STM() {
        EBLK();
        return(this);
    }

	public int line() { return (_LINE); }

	public int page() { return (_PAGE); }
	
	/**
	 * <pre>
	 * Boolean procedure open(fileimage);  text fileimage;
	 * if ... then
	 * begin ... 
	 *    image :- fileimage;
	 *    PAGE  := 0;
	 *    LINE  := 1;
	 *    setpos(1);
	 *    eject(1);
	 *    open  := OPEN := true;
	 * end open;
	 * </pre>
	 * <p>
	 * Procedure "open" establishes the association with an external file (as
	 * identified by FILENAME), checks the access modes and causes corresponding
	 * opening actions on the external file. If the external file is closed, it
	 * is opened. *
	 * 
	 * @param image
	 * @return true if successful, otherwise false.
	 */
	@Override
	public boolean open(final _TXT image) {
		String fileName=FILE_NAME.edText();
		if(_RT.Option.VERBOSE) TRACE_OPEN("Open PrintFile");
		if (_OPEN) return (false); // File already opened
		_PAGE = 0;
		_LINE = 1;
		_OPEN = true;
		this.image = image;
		setpos(1);
		//_RT.BREAK("PrintFile.open: Filename=" + FILE_NAME);
		if (FILE_NAME.edText().equalsIgnoreCase("#sysout")) {
			if(_RT.console!=null) writer=_RT.console.getWriter();
			else writer = new PrintWriter(System.out,true,_CHARSET);
		} else if(fileName.toUpperCase().startsWith("CONSOLE: ")) {
			_RTConsolePanel console = new _RTConsolePanel();
			String title=fileName.substring(9);
			console.popup(title);
			writer=console.getWriter();
		} else {
			PageWriter pageWriter = new PageWriter(fileName);
			pageWriter.setFont(_FONT,_ORIENTATION,_ASK_PAPER);
			pageWriter.setMargins(_TOP_MARGIN, _LEFT_MARGIN, _BOT_MARGIN, _RIGHT_MARGIN);
			pageWriter.open();
			_DEFAULT_LINES_PER_PAGE = _LINES_PER_PAGE = pageWriter.getLinesPerSheet();
			writer=pageWriter;
		}
		eject(1);
		return (true);
	}

	/**
	 * <pre>
	 * Boolean procedure close;
	 * if OPEN then
	 * begin ... ! 
	 *    if pos <> 1 then outimage;
	 *    
	 *    eject(LINES_PER_PAGE);
	 *    PAGE := ... ;
	 *    LINE := 0;
	 *    SPACING := 1;
	 *    LINES_PER_PAGE:= ... ;
	 *    
	 *    
	 *    image :- notext;
	 *    ... ; ! perform closing actions on external file;
	 *    OPEN  := false;
	 *    close := true;
	 * end close;
	 * </pre>
	 * <p>
	 * Procedure "close" causes closing actions on the external file, as
	 * specified by the access modes. In addition, the association between the
	 * file object and the external file is dissolved. If possible, the external
	 * file is closed.
	 * <p>
	 * The procedure "close" calls "outimage" if the position indicator is not
	 * equal to 1.
	 * <p>
	 * If successful, "close" returns true. In addition, PAGE, LINE, SPACING,
	 * LINES_PER_PAGE, OPEN and "image" are reinitiated.
	 * 
	 * @return true if successful, otherwise false.
	 */
	@Override
	public boolean close() {
		if(_RT.Option.VERBOSE) TRACE_OPEN("Close PrintFile");
		if (!_OPEN)
			return (false); // File not opened
		if (pos() != 1)
			outimage();
		_SPACING = 1;
		//eject(_LINES_PER_PAGE);
		_LINES_PER_PAGE = 0;
		_LINE = 0;
		image = null; // image :- NOTEXT;
		if (!FILE_NAME.edText().equalsIgnoreCase("#sysout")) {
			try {
				writer.flush();
				writer.close();
			} catch (IOException e1) {
				if(_RT.Option.VERBOSE) e1.printStackTrace();
				return (false);
			} //else console.close();
		}
		_OPEN = false;
		doPurgeAction();
		return (true);
	}

	/**
	 * <pre>
	 * integer procedure linesperpage(n); integer n;
	 *    begin
	 *       linesperpage := LINES_PER_PAGE;
	 *       LINES_PER_PAGE:= if n > 0 then n
	 *                         else if n < 0 then maxint
	 *                          else  ... ; ! default value;
	 * </pre>
	 * <p>
	 * The variable LINES_PER_PAGE indicates the maximum number of physical
	 * lines that may be printed on each page, including intervening blank
	 * lines. An implementation-defined value is assigned to the variable at the
	 * time of object generation, and when the printfile is closed. The value of
	 * the variable may be retreived by a call on "linesperpage"; in addition
	 * the variable is givan a new value as follows.
	 * <p>
	 * If the parameter to "linesperpage" is zero, LINES_PER_PAGE is reset to
	 * the original value (assigned at object generation). A parameter value
	 * less than zero may be used to indicate an "infinite" value of
	 * LINES_PER_PAGE, thus avoiding any automatic calls on "eject".
	 * 
	 * @param n
	 */
	public int linesperpage(final int n) {
		int prev=_LINES_PER_PAGE;
		if(n >0 ) _LINES_PER_PAGE=n;
		else if(n < 0) _LINES_PER_PAGE=maxint;
		else _LINES_PER_PAGE=_DEFAULT_LINES_PER_PAGE;
		return(prev);
	}

	/**
	 * <pre>
	 * procedure spacing(n); integer n;
	 *            if  0<=n and n<=LINES_PER_PAGE  then SPACING := n
	 *            else  error("..." ! Parameter out of range; );
	 * </pre>
	 * <p>
	 * The variable SPACING represents the value by which the variable LINE is
	 * incremented after the next printing operation. Its value may be changed
	 * by the procedure "spacing". A call on the procedure "spacing" with a
	 * parameter less than zero or greater than LINES_PER_PAGE constitutes an
	 * error. The effect of a a parameter to "spacing" which is equal to zero
	 * may be defined as forcing successive printing operations on the same
	 * physical line. Note, however, that on some physical media this may not be
	 * possible, in which case spacing(0) has the same effect as spacing(1)
	 * (i.e. no overprinting).
	 * 
	 * @param n
	 */
	public void spacing(final int n) {
		if (n < 0 || n > _LINES_PER_PAGE)
			throw new _SimulaRuntimeError("Spacing("+n+") - Parameter out of range");
		_SPACING = (n==0)?1:n; // spacing(0) has the same effect as spacing(1)
	}

	/**
	 * <pre>
	 * procedure eject(n); integer n;
	 *   if not OPEN then error("..." ! file closed;)
	 *   else if n <= 0 then error("..." ! Parameter out of range;)
	 *   else begin
	 *      if n > LINES_PER_PAGE then n := 1;
	 *      if n <= LINE then
	 *      begin
	 *         ... ; ! change to new page on external file;
	 *         PAGE := PAGE + 1
	 *      end;
	 *      ... ; ! move to line "n" on current (external) page;
	 *      LINE := n
	 * end eject;
	 * </pre>
	 * <p>
	 * The procedure "eject" is used to position to a certain line identified by
	 * the parameter, n. The variable "PAGE" is incremented by one each time an
	 * explicit or implicit "eject" implies a new page.
	 * <p>
	 * The following cases can be distinguished:
	 * 
	 * <pre>
	 *      n <= 0                 : error
	 *      n >  LINES_PER_PAGE    : Equivalent to eject (1)
	 *      n <= LINE              : Position to line number n on the next page
	 *      n >  LINE              : Position to line number n on the current page
	 * </pre>
	 * 
	 * The tests above are performed in the given sequence.
	 * 
	 * @param n
	 */
	public void eject(int n) {
		if (!_OPEN) throw new _SimulaRuntimeError("File not opened");
		if (n <= 0) throw new _SimulaRuntimeError("Parameter out of range: eject "+n);
		if (n > _LINES_PER_PAGE) n = 1;
		try {
			if(n <= _LINE) {
				_PAGE = _PAGE + 1;
				if(writer instanceof PageWriter pageWriter) {
					pageWriter.newPage(_PAGE);
					for(int i=1;i<n;i++) writer.write("\n");
				}
			} else {
				int diff= n - _LINE;
				for(int i=0;i<diff;i++) writer.write("\n");
			}
		} catch (IOException e) { throw new _SimulaRuntimeError("Eject failed", e); }
		_LINE=n;
	}
	
	@Override
	protected void writeImage(String ident,String img,boolean blank) {
		// Used by  Outimage, OutRecord and BreakOutimage in Outfile
		if (!_OPEN) throw new _SimulaRuntimeError("File not opened");
		if (_LINE > _LINES_PER_PAGE) eject(1);
		try { //String line=(image==null)?nl:(image.edStripedText()+nl);
			  writer.write(img);
			  if(_SPACING > 1) { for(int i=1;i<_SPACING;i++) writer.write("\n"); }
			  writer.flush();
		} catch (IOException e) { throw new _SimulaRuntimeError(ident+" failed", e); }
		_LINE = _LINE + _SPACING;
		if(blank) _ASGTXT(image,null); // image := NOTEXT;
		setpos(1);
	}


}