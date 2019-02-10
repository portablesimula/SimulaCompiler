// JavaLine 1 ==> SourceLine 431
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:51 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$precheck0$makeequalto extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=431, lastLine=453, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$quantity p$q;
    public COMMON$quantity p$qnt;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$precheck0$makeequalto setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$precheck0$makeequalto.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$q=(COMMON$quantity)objectValue(param); break;
                case 1: p$qnt=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER1$precheck0$makeequalto(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$precheck0$makeequalto(RTObject$ SL$,COMMON$quantity sp$q,COMMON$quantity sp$qnt) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        this.p$qnt = sp$qnt;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("makeequalto",431);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$precheck0$makeequalto STM$() {
        TRACE_BEGIN_STM$("makeequalto",431);
        // JavaLine 44 ==> SourceLine 432
        p$qnt.symb=p$q.symb;
        // JavaLine 46 ==> SourceLine 433
        p$qnt.encl=p$q.encl;
        p$qnt.descr=p$q.descr;
        // JavaLine 49 ==> SourceLine 434
        p$qnt.type=p$q.type;
        p$qnt.kind=p$q.kind;
        // JavaLine 52 ==> SourceLine 435
        p$qnt.categ=p$q.categ;
        p$qnt.prefqual=p$q.prefqual;
        // JavaLine 55 ==> SourceLine 436
        p$qnt.plev=p$q.plev;
        p$qnt.dim=p$q.dim;
        // JavaLine 58 ==> SourceLine 437
        p$qnt.protect=p$q.protect;
        p$qnt.visible=p$q.visible;
        // JavaLine 61 ==> SourceLine 438
        if(VALUE$((p$qnt.visible!=(((BUILDER1)(CUR$.SL$.SL$)).NUL)))) {
            p$qnt.visible=((char)1);
        }
        // JavaLine 65 ==> SourceLine 439
        p$qnt.virtno=p$q.virtno;
        p$qnt.match=p$q.match;
        // JavaLine 68 ==> SourceLine 440
        p$qnt.special=p$q.special;
        // JavaLine 70 ==> SourceLine 443
        if(VALUE$(((p$q.line<(0))&&(IS$(p$qnt,COMMON$quantity.class))))) {
            p$qnt.ftag=p$q.line;
        } else
        // JavaLine 74 ==> SourceLine 444
        {
            TRACE_BEGIN_STM$("CompoundStatement444",444);
            p$qnt.line=p$q.line;
            p$qnt.ftag=p$q.ftag;
            TRACE_END_STM$("CompoundStatement444",444);
        }
        // JavaLine 81 ==> SourceLine 445
        if(VALUE$(IS$(p$qnt,COMMON$extquantity.class))) {
            // JavaLine 83 ==> SourceLine 446
            {
                TRACE_BEGIN_STM$("CompoundStatement446",446);
                if(VALUE$((p$q.ftag<(0)))) {
                    {
                        TRACE_BEGIN_STM$("CompoundStatement446",446);
                        p$qnt.line=p$q.ftag;
                        p$qnt.ftag=0;
                        TRACE_END_STM$("CompoundStatement446",446);
                    }
                }
                // JavaLine 94 ==> SourceLine 447
                ((COMMON$extquantity)(p$qnt)).p2$module=((COMMON$extquantity)(p$q)).p2$module;
                // JavaLine 96 ==> SourceLine 448
                ((COMMON$extquantity)(p$qnt)).clf=((COMMON$extquantity)(p$q)).clf;
                // JavaLine 98 ==> SourceLine 449
                ((COMMON$extquantity)(p$qnt)).longindic=((COMMON$extquantity)(p$q)).longindic;
                TRACE_END_STM$("CompoundStatement446",449);
            }
        }
        TRACE_END_STM$("makeequalto",449);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure makeequalto",1,431,44,432,46,433,49,434,52,435,55,436,58,437,61,438,65,439,68,440,70,443,74,444,81,445,83,446,94,447,96,448,98,449,106,453);
}
