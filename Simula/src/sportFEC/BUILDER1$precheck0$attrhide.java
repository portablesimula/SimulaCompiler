// JavaLine 1 ==> SourceLine 486
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:51 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$precheck0$attrhide extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=486, lastLine=501, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$quantity p$qty;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 487
    BUILDER1$precheck0$ignore ignp=null;
    // JavaLine 14 ==> SourceLine 488
    BUILDER1$precheck0$ignore curp=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$precheck0$attrhide setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$precheck0$attrhide.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$qty=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER1$precheck0$attrhide(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$precheck0$attrhide(RTObject$ SL$,COMMON$quantity sp$qty) {
        super(SL$);
        // Parameter assignment to locals
        this.p$qty = sp$qty;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("attrhide",488);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$precheck0$attrhide STM$() {
        TRACE_BEGIN_STM$("attrhide",488);
        curp=((BUILDER1$precheck0)(CUR$.SL$)).curhp;
        // JavaLine 46 ==> SourceLine 489
        new BUILDER1$precheck0$hide(((BUILDER1$precheck0)(CUR$.SL$)),p$qty,true);
        // JavaLine 48 ==> SourceLine 490
        ignp=((BUILDER1$precheck0)(CUR$.SL$)).curhp;
        while((ignp!=(curp))) {
            // JavaLine 51 ==> SourceLine 492
            {
                TRACE_BEGIN_STM$("CompoundStatement492",492);
                ignp.p$hp.line=(-(ignp.p$hp.line));
                // JavaLine 55 ==> SourceLine 495
                ignp=ignp.prev;
                TRACE_END_STM$("CompoundStatement492",495);
            }
        }
        // JavaLine 60 ==> SourceLine 496
        p$qty=p$qty.descr.fpar;
        // JavaLine 62 ==> SourceLine 497
        while((p$qty!=(null))) {
            // JavaLine 64 ==> SourceLine 498
            {
                TRACE_BEGIN_STM$("CompoundStatement498",498);
                if(VALUE$((p$qty.kind==(((BUILDER1)(CUR$.SL$.SL$)).K_class)))) {
                    new BUILDER1$precheck0$attrhide(((BUILDER1$precheck0)(CUR$.SL$)),p$qty);
                }
                // JavaLine 70 ==> SourceLine 499
                p$qty=((COMMON$quantity)(p$qty.next));
                TRACE_END_STM$("CompoundStatement498",499);
            }
        }
        TRACE_END_STM$("attrhide",499);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure attrhide",1,486,12,487,14,488,46,489,48,490,51,492,55,495,60,496,62,497,64,498,70,499,78,501);
}
