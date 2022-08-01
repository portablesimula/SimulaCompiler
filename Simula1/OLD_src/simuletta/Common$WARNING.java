// JavaLine 1 <== SourceLine 331
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$WARNING extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=331, lastLine=334, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public TXT$ p$msg;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$WARNING setPar(Object param) {
        //Util.BREAK("CALL Common$WARNING.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public Common$WARNING(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Common$WARNING(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        // Parameter assignment to locals
        this.p$msg = sp$msg;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$WARNING STM$() {
        // JavaLine 38 <== SourceLine 332
        if(VALUE$((((Common)(CUR$.SL$)).curline$1>(0)))) {
            sysout().outtext(CONC(CONC(new TXT$("LINE "),new Common$leftint(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).curline$1).RESULT$),new TXT$("  ")));
        }
        ;
        // JavaLine 43 <== SourceLine 333
        sysout().outtext(CONC(new TXT$(" NOTE: "),p$msg));
        ;
        sysout().outimage();
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure WARNING",1,331,38,332,43,333,50,334);
} // End of Procedure
