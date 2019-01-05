// JavaLine 1 ==> SourceLine 170
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:26 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$dummygenerator$outbyte extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=170, lastLine=171, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$dummygenerator$outbyte setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$dummygenerator$outbyte.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public BUILDER1$dummygenerator$outbyte(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$dummygenerator$outbyte(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("outbyte",170);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$dummygenerator$outbyte STM$() {
        TRACE_BEGIN_STM$("outbyte",170);
        TRACE_END_STM$("outbyte",170);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure outbyte",1,170,44,171);
}
