// JavaLine 1 <== SourceLine 348
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$IERR extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=348, lastLine=356, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Common$IERR(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$IERR STM$() {
        // JavaLine 20 <== SourceLine 350
        sysout().outimage();
        ;
        // JavaLine 23 <== SourceLine 351
        if(VALUE$((((Common)(CUR$.SL$)).curline$1>(0)))) {
            sysout().outtext(CONC(CONC(new TXT$("LINE "),new Common$leftint(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).curline$1).RESULT$),new TXT$("  ")));
        }
        ;
        // JavaLine 28 <== SourceLine 352
        new Common$ERROR(((Common)(CUR$.SL$)),new TXT$("***Internal error***"));
        ;
        // JavaLine 31 <== SourceLine 353
        ((Common)(CUR$.SL$)).DO_TRACING$1=4;
        ;
        new Common$TRACE(((Common)(CUR$.SL$)),new TXT$("COMMON.IERR"),353,new TXT$("Continue ?"));
        ;
        // JavaLine 36 <== SourceLine 355
        terminate_program();
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure IERR",1,348,20,350,23,351,28,352,31,353,36,355,41,356);
} // End of Procedure
