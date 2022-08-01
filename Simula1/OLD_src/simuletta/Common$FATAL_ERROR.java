// JavaLine 1 <== SourceLine 312
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$FATAL_ERROR extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=312, lastLine=320, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public TXT$ p$msg;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$FATAL_ERROR setPar(Object param) {
        //Util.BREAK("CALL Common$FATAL_ERROR.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$FATAL_ERROR(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Common$FATAL_ERROR(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        // Parameter assignment to locals
        this.p$msg = sp$msg;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$FATAL_ERROR STM$() {
        // JavaLine 38 <== SourceLine 314
        if(VALUE$((((Common)(CUR$.SL$)).curline$1>(0)))) {
            sysout().outtext(CONC(CONC(new TXT$("LINE "),new Common$leftint(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).curline$1).RESULT$),new TXT$("  ")));
        }
        ;
        // JavaLine 43 <== SourceLine 315
        sysout().outtext(new TXT$("*** FATAL ERROR *** "));
        ;
        sysout().outtext(p$msg);
        ;
        sysout().outimage();
        ;
        // JavaLine 50 <== SourceLine 316
        ((Common)(CUR$.SL$)).nerr$1=Math.addExact(((Common)(CUR$.SL$)).nerr$1,1);
        ;
        // JavaLine 53 <== SourceLine 317
        ((Common)(CUR$.SL$)).DO_TRACING$1=4;
        ;
        new Common$TRACE(((Common)(CUR$.SL$)),new TXT$("COMMON.FATAL_ERROR"),317,new TXT$("Continue ?"));
        ;
        // JavaLine 58 <== SourceLine 319
        terminate_program();
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure FATAL_ERROR",1,312,38,314,43,315,50,316,53,317,58,319,63,320);
} // End of Procedure
