// JavaLine 1 ==> SourceLine 201
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:26 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$meaningof extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=201, lastLine=202, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public COMMON$quantity RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public COMMON$symbolbox p$symb;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$meaningof setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$meaningof.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$symb=(COMMON$symbolbox)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER1$meaningof(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$meaningof(RTObject$ SL$,COMMON$symbolbox sp$symb) {
        super(SL$);
        // Parameter assignment to locals
        this.p$symb = sp$symb;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("meaningof",201);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$meaningof STM$() {
        TRACE_BEGIN_STM$("meaningof",201);
        // JavaLine 44 ==> SourceLine 202
        RESULT$=((COMMON$quantity)(((COMMON$identsymbol)(p$symb)).curmeaning));
        TRACE_END_STM$("meaningof",202);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure meaningof",1,201,44,202,49,202);
}
