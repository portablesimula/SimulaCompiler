// JavaLine 1 ==> SourceLine 466
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:31 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$precheck0$resethide$reprtct extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=466, lastLine=474, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$quantity p$q;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 467
    COMMON$quantity qty=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$precheck0$resethide$reprtct setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$precheck0$resethide$reprtct.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$q=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER1$precheck0$resethide$reprtct(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$precheck0$resethide$reprtct(RTObject$ SL$,COMMON$quantity sp$q) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("reprtct",467);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$precheck0$resethide$reprtct STM$() {
        TRACE_BEGIN_STM$("reprtct",467);
        // JavaLine 43 ==> SourceLine 468
        qty=p$q.descr.fpar;
        // JavaLine 45 ==> SourceLine 469
        while((qty!=(null))) {
            // JavaLine 47 ==> SourceLine 470
            {
                TRACE_BEGIN_STM$("CompoundStatement470",470);
                if((qty.kind==(((BUILDER1)(CUR$.SL$.SL$.SL$)).K_class))) {
                    new BUILDER1$precheck0$resethide$reprtct(((BUILDER1$precheck0$resethide)(CUR$.SL$)),qty);
                }
                // JavaLine 53 ==> SourceLine 471
                qty=((COMMON$quantity)(qty.next));
                TRACE_END_STM$("CompoundStatement470",471);
            }
        }
        // JavaLine 58 ==> SourceLine 473
        new BUILDER1$precheck0$protect(((BUILDER1$precheck0)(CUR$.SL$.SL$)),p$q);
        TRACE_END_STM$("reprtct",473);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure reprtct",1,466,12,467,43,468,45,469,47,470,53,471,58,473,63,474);
}
