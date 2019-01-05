// JavaLine 1 ==> SourceLine 126
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:41:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$getBox extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=126, lastLine=129, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public COMMON$symbolbox RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public COMMON$getBox setPar(Object param) {
        //Util.BREAK("CALL COMMON$getBox.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public COMMON$getBox(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public COMMON$getBox(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("getBox",126);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public COMMON$getBox STM$() {
        TRACE_BEGIN_STM$("getBox",126);
        // JavaLine 44 ==> SourceLine 128
        RESULT$=((ARRAY$<COMMON$symbolbox[]>)((COMMON)(CUR$.SL$)).symtab.Elt[(p$i/(256))-((COMMON)(CUR$.SL$)).symtab.LB[0]].val).Elt[rem(p$i,256)-((COMMON)(CUR$.SL$)).symtab.Elt[(p$i/(256))-((COMMON)(CUR$.SL$)).symtab.LB[0]].val.LB[0]];
        TRACE_END_STM$("getBox",128);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure getBox",1,126,44,128,49,129);
}
