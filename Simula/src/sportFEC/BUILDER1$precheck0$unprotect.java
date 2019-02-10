// JavaLine 1 ==> SourceLine 605
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:51 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$precheck0$unprotect extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=605, lastLine=616, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$quantity p$q;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 608
    COMMON$brecord inspect$608$10=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$precheck0$unprotect setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$precheck0$unprotect.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public BUILDER1$precheck0$unprotect(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$precheck0$unprotect(RTObject$ SL$,COMMON$quantity sp$q) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("unprotect",608);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$precheck0$unprotect STM$() {
        TRACE_BEGIN_STM$("unprotect",608);
        {
            // BEGIN INSPECTION 
            inspect$608$10=p$q.descr;
            if(inspect$608$10!=null) //INSPECT inspect$608$10
            // JavaLine 47 ==> SourceLine 610
            {
                TRACE_BEGIN_STM$("CompoundStatement610",610);
                p$q=inspect$608$10.favirt;
                // JavaLine 51 ==> SourceLine 611
                while((p$q!=(null))) {
                    // JavaLine 53 ==> SourceLine 612
                    {
                        TRACE_BEGIN_STM$("CompoundStatement612",612);
                        if(VALUE$((p$q.dim==(1)))) {
                            p$q.visible=((BUILDER1)(CUR$.SL$.SL$)).NUL;
                        }
                        p$q=((COMMON$quantity)(p$q.next));
                        TRACE_END_STM$("CompoundStatement612",612);
                    }
                }
                // JavaLine 63 ==> SourceLine 613
                p$q=inspect$608$10.fpar;
                // JavaLine 65 ==> SourceLine 614
                while((p$q!=(null))) {
                    {
                        TRACE_BEGIN_STM$("CompoundStatement614",614);
                        p$q.visible=((BUILDER1)(CUR$.SL$.SL$)).NUL;
                        p$q=((COMMON$quantity)(p$q.next));
                        TRACE_END_STM$("CompoundStatement614",614);
                    }
                }
                TRACE_END_STM$("CompoundStatement610",614);
            }
        }
        TRACE_END_STM$("unprotect",614);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure unprotect",1,605,12,608,47,610,51,611,53,612,63,613,65,614,80,616);
}
