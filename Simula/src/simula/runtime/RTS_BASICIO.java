/*
 * (CC) This work is licensed under a Creative Commons
 * Attribution 4.0 International License.
 *
 * You find a copy of the License on the following
 * page: https://creativecommons.org/licenses/by/4.0/
 */
package simula.runtime;

/**
 * System class BASICIO.
 * <p>
 * The standard I/O facilities are contained by the class "BASICIO". They
 * are available to the program through block prefixing as described below.
 * <p>
 * Note: The use of upper case letters indicates that this identifier is
 * inaccessible to the user program (cf 1.10).
 * <p>
 * The user's main program acts as if it were embedded as follows:
 * 
 * <pre>
 *             BASICIO (inlength, outlength) begin  ! prefixed block;
 *                   inspect SYSIN do
 *                   inspect SYSOUT do
 *                   begin  &lt;external-head&gt; &lt;program&gt;  end
 *             end prefixed block
 * </pre>
 * 
 * In any program execution the unique instance of this prefixed block
 * constitutes the system head of the outermost quasi-parallel system (see 7.2).
 * <p>
 * The values of inlength and outlength are implementation-defined; they
 * normally depend upon the actual device(s) associated with SYSIN and SYSOUT
 * (the standard input and output files).
 * <p>
 * SYSIN and SYSOUT may represent the input and output features of an
 * interactive terminal, in which case inlength and outlength are probably
 * equal. In other cases, for example batch runs, SYSIN may represent
 * record-oriented input and SYSOUT may represent line printer oriented output.
 * Typical values of inlength and outlength would then be 80 and 132, resp.
 * <p>
 * A program may refer to the corresponding file objects through sysin and
 * sysout respectively. Most attributes of these file objects are directly
 * available as the result of the connection blocks enclosing the program.
 * <p>
 * Note: Within this chapter the term "file object" refers to an instance of one
 * of the classes "in(byte)file", "out(byte)file" and "direct(byte)file" or of a
 * subclass of one of these.
 * <p>
 * The overall organization of "BASICIO" is as follows:
 * 
 * <pre>
 *  ENVIRONMENT class BASICIO (INPUT_LINELENGTH, OUTPUT_LINELENGTH);
 *                     integer INPUT_LINELENGTH, OUTPUT_LINELENGTH;
 *              begin ref (infile) SYSIN; ref (printfile) SYSOUT;
 *                 ref (infile)    procedure sysin;   sysin  :- SYSIN;
 *                 ref (printfile) procedure sysout;  sysout :- SYSOUT;
 * 
 *                 procedure terminate_program;
 *                 begin ... ;  goto STOP  end terminate_program;
 * 
 *                      class file ............................ 10.1 ;
 *                 file class imagefile ....................... 10.3 ;
 *                 file class bytefile ........................ 10.8 ;
 *            imagefile class infile .......................... 10.4 ;
 *            imagefile class outfile ......................... 10.5 ;
 *            imagefile class directfile ...................... 10.6 ;
 *              outfile class printfile ....................... 10.7 ;
 *             bytefile class inbytefile ...................... 10.9 ;
 *             bytefile class outbytefile ..................... 10.10 ;
 *             bytefile class directbytefile .................. 10.11 ;
 * 
 *                 SYSIN  :- new infile("...");    ! Implementation-defined
 *                 SYSOUT :- new printfile("..."); ! files names;
 *                 SYSIN.open(blanks(INPUT_LINELENGTH));
 *                 SYSOUT.open(blanks(OUTPUT_LINELENGTH));
 *                 inner;
 *           STOP: SYSIN.close;
 *                 SYSOUT.close
 *           end BASICIO;
 * </pre>
 * <p>
 * Note: The files SYSIN and SYSOUT are opened and (if not done explicitly prior
 * to program termination) closed within "BASICIO", i.e. outside the program
 * itself.
 * <p>
 * The class file and its predefined subclasses are available at any block level
 * of a program (but see (2) of 5.5.1). An implementation may restrict, in any
 * way, the use of these classes for class or block prefixing. An implementation
 * may provide additional subclasses of class file.
 * <p>
 * Within a program, an object of a subclass of file may represent an external
 * file. The effect of several such file objects representing the same external
 * file is implementation-defined.
 * <p>
 * The procedure "terminate_program" terminates program execution. It closes
 * SYSIN and SYSOUT. It is implementation-dependent with respect to whether or
 * not other open files are also closed.
 * <p>
 * Link to GitHub: <a href="https://github.com/portablesimula/SimulaCompiler/blob/master/Simula/src/simula/runtime/RTS_BASICIO.java"><b>Source File</b></a>.
 * 
 * @author SIMULA Standards Group
 * @author Øystein Myhre Andersen
 *
 */
public class RTS_BASICIO extends RTS_ENVIRONMENT {

	/**
	 * Constructor
	 * 
	 * @param staticLink pointer to enclosing block
	 */
	public RTS_BASICIO(final RTS_RTObject staticLink) {
		super(staticLink);
	}

//	procedure terminate_program;
//	begin ... ;  goto STOP  end terminate_program;
//	DEFINED IN _RTObject	

	@Override
	public String toString() {
		return ("Simula " + this.getClass().getSimpleName());
	}

}