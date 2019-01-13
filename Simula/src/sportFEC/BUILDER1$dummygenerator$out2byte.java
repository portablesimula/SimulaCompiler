// JavaLine 1 ==> SourceLine 171
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:31 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$dummygenerator$out2byte extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=171, lastLine=172, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$dummygenerator$out2byte setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$dummygenerator$out2byte.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER1$dummygenerator$out2byte(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$dummygenerator$out2byte(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("out2byte",171);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$dummygenerator$out2byte STM$() {
        TRACE_BEGIN_STM$("out2byte",171);
        TRACE_END_STM$("out2byte",171);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure out2byte",1,171,44,172);
}
