// JavaLine 1 <== SourceLine 547
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$macro_symbol$dump extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=547, lastLine=550, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Common$macro_symbol$dump(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$macro_symbol$dump STM$() {
        // JavaLine 20 <== SourceLine 550
        sysout().outtext(CONC(CONC(CONC(CONC(CONC(new TXT$(" MacroSymbol: "),new Common$edSymbol(((Common)(CUR$.SL$.SL$)),((Common$macro_symbol)(CUR$.SL$)).p2$s).RESULT$),new TXT$("/")),((Common$macro_symbol)(CUR$.SL$)).p2$box.symbol),new TXT$("/")),((Common$macro_symbol)(CUR$.SL$)).p2$v));
        ;
        sysout().outimage();
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure dump",1,547,20,550,27,550);
} // End of Procedure
