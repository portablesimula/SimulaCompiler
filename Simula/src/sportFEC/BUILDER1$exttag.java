// JavaLine 1 ==> SourceLine 623
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:31 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$exttag extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=623, lastLine=667, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public COMMON$quantity p$q;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$exttag setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$exttag.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public BUILDER1$exttag(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$exttag(RTObject$ SL$,COMMON$quantity sp$q) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("exttag",623);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$exttag STM$() {
        TRACE_BEGIN_STM$("exttag",623);
        // JavaLine 44 ==> SourceLine 627
        if(((p$q.visible==(((BUILDER1)(CUR$.SL$)).NUL))||((p$q.protect==(((char)1)))))) {
            // JavaLine 46 ==> SourceLine 634
            {
                TRACE_BEGIN_STM$("CompoundStatement634",634);
                RESULT$=((BUILDER1)(CUR$.SL$)).nextexttag;
                // JavaLine 50 ==> SourceLine 636
                if((p$q.categ==(((BUILDER1)(CUR$.SL$)).C_virt))) {
                    RESULT$=-1;
                } else
                // JavaLine 54 ==> SourceLine 637
                if((p$q.categ==(((BUILDER1)(CUR$.SL$)).C_extnal))) {
                    // JavaLine 56 ==> SourceLine 638
                    {
                        TRACE_BEGIN_STM$("CompoundStatement638",638);
                        if(IS$(p$q.descr,COMMON$extbrecord.class)) {
                            RESULT$=-1;
                        } else
                        // JavaLine 62 ==> SourceLine 640
                        ((BUILDER1)(CUR$.SL$)).nextexttag=(((BUILDER1)(CUR$.SL$)).nextexttag+(2));
                        TRACE_END_STM$("CompoundStatement638",640);
                    }
                } else
                // JavaLine 67 ==> SourceLine 642
                if((IS$(p$q,COMMON$extquantity.class)&&((((COMMON$extquantity)(p$q)).clf==(((BUILDER1)(CUR$.SL$)).Clf002))))) {
                    // JavaLine 69 ==> SourceLine 644
                    RESULT$=-1;
                } else
                // JavaLine 72 ==> SourceLine 645
                if(((p$q.special>(((char)1)))&&((p$q.type!=(((BUILDER1)(CUR$.SL$)).ITEXT))))) {
                    // JavaLine 74 ==> SourceLine 649
                    RESULT$=-1;
                } else
                // JavaLine 77 ==> SourceLine 650
                if(((p$q.kind==(((BUILDER1)(CUR$.SL$)).K_class))&&((p$q.categ==(((BUILDER1)(CUR$.SL$)).C_local))))) {
                    // JavaLine 79 ==> SourceLine 651
                    ((BUILDER1)(CUR$.SL$)).nextexttag=(((BUILDER1)(CUR$.SL$)).nextexttag+((((p$q.descr.inrtag!=(((BUILDER1)(CUR$.SL$)).NUL)))?(3):(2))));
                } else
                // JavaLine 82 ==> SourceLine 653
                if(((p$q.kind==(((BUILDER1)(CUR$.SL$)).K_proc))&&((p$q.categ==(((BUILDER1)(CUR$.SL$)).C_local))))) {
                    // JavaLine 84 ==> SourceLine 654
                    ((BUILDER1)(CUR$.SL$)).nextexttag=(((BUILDER1)(CUR$.SL$)).nextexttag+(2));
                } else
                // JavaLine 87 ==> SourceLine 656
                if((p$q.encl.declquant.categ==(((BUILDER1)(CUR$.SL$)).C_virt))) {
                    // JavaLine 89 ==> SourceLine 658
                    RESULT$=-1;
                } else
                // JavaLine 92 ==> SourceLine 659
                ((BUILDER1)(CUR$.SL$)).nextexttag=(((BUILDER1)(CUR$.SL$)).nextexttag+((((p$q.categ==(((BUILDER1)(CUR$.SL$)).C_name)))?(2):(1))));
                TRACE_END_STM$("CompoundStatement634",659);
            }
        } else
        // JavaLine 97 ==> SourceLine 661
        RESULT$=-2;
        TRACE_END_STM$("exttag",661);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure exttag",1,623,44,627,46,634,50,636,54,637,56,638,62,640,67,642,69,644,72,645,74,649,77,650,79,651,82,653,84,654,87,656,89,658,92,659,97,661,102,667);
}
