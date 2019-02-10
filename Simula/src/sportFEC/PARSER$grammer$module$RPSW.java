// JavaLine 1 ==> SourceLine 735
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$module$RPSW extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=735, lastLine=0, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public LABQNT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$$SW;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public PARSER$grammer$module$RPSW setPar(Object param) {
        //Util.BREAK("CALL PARSER$grammer$module$RPSW.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$$SW=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public PARSER$grammer$module$RPSW(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public PARSER$grammer$module$RPSW(RTObject$ SL$,int sp$$SW) {
        super(SL$);
        // Parameter assignment to locals
        this.p$$SW = sp$$SW;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("RPSW",735);
        STM$();
    } // End of Constructor
    // Switch Body
    public PARSER$grammer$module$RPSW STM$() {
        switch(p$$SW-1) {
            case 0: RESULT$=((PARSER$grammer$module)(CUR$.SL$)).S0; break;
            case 1: RESULT$=((PARSER$grammer$module)(CUR$.SL$)).S1; break;
            case 2: RESULT$=((PARSER$grammer$module)(CUR$.SL$)).S2; break;
            case 3: RESULT$=((PARSER$grammer$module)(CUR$.SL$)).RECOVER1; break;
            case 4: RESULT$=((PARSER$grammer$module)(CUR$.SL$)).RECOVER2; break;
            case 5: RESULT$=((PARSER$grammer$module)(CUR$.SL$)).RECOVER3; break;
            case 6: RESULT$=((PARSER$grammer$module)(CUR$.SL$)).RECOVER4; break;
            default: throw new RuntimeException("Illegal switch index: "+p$$SW);
        }
        EBLK();
        return(this);
    } // End of Switch BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure RPSW",1,735,55,0);
}
