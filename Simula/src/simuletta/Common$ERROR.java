// JavaLine 1 <== SourceLine 322
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$ERROR extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=322, lastLine=329, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public TXT$ p$msg;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$ERROR setPar(Object param) {
        //Util.BREAK("CALL Common$ERROR.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public Common$ERROR(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Common$ERROR(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        // Parameter assignment to locals
        this.p$msg = sp$msg;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$ERROR STM$() {
        // JavaLine 38 <== SourceLine 324
        sysout().outimage();
        ;
        // JavaLine 41 <== SourceLine 325
        if(VALUE$((((Common)(CUR$.SL$)).curline$1>(0)))) {
            sysout().outtext(CONC(CONC(new TXT$("LINE "),new Common$leftint(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).curline$1).RESULT$),new TXT$("  ")));
        }
        ;
        // JavaLine 46 <== SourceLine 326
        sysout().outtext(CONC(new TXT$("ERROR: "),p$msg));
        ;
        ((Common)(CUR$.SL$)).nerr$1=Math.addExact(((Common)(CUR$.SL$)).nerr$1,1);
        ;
        sysout().outimage();
        ;
        // JavaLine 53 <== SourceLine 327
        ((Common)(CUR$.SL$)).DO_TRACING$1=4;
        ;
        new Common$TRACE(((Common)(CUR$.SL$)),new TXT$("COMMON.ERROR"),327,new TXT$("Continue ?"));
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure ERROR",1,322,38,324,41,325,46,326,53,327,60,329);
} // End of Procedure
