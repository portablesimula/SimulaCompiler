// JavaLine 1 ==> SourceLine 368
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 04 20:15:38 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$finn_felt extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=368, lastLine=379, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public TXT$ p$felt;
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 370
    int i=0;
    int nr=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$finn_felt setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$finn_felt.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$felt=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HegnaNRK$PBLK21$finn_felt(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$finn_felt(RTObject$ SL$,TXT$ sp$felt) {
        super(SL$);
        // Parameter assignment to locals
        this.p$felt = sp$felt;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("finn_felt",370);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$finn_felt STM$() {
        TRACE_BEGIN_STM$("finn_felt",370);
        // JavaLine 47 ==> SourceLine 371
        i=nr=0;
        // JavaLine 49 ==> SourceLine 372
        while(((nr==(0))&((i<(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_felt_def))))) {
            // JavaLine 51 ==> SourceLine 374
            {
                TRACE_BEGIN_STM$("CompoundStatement374",374);
                i=(i+(1));
                // JavaLine 55 ==> SourceLine 375
                if(VALUE$(TXTREL$EQ(p$felt,((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn_tabell.LB[0]]))) {
                    // JavaLine 57 ==> SourceLine 376
                    nr=i;
                }
                TRACE_END_STM$("CompoundStatement374",376);
            }
        }
        // JavaLine 63 ==> SourceLine 378
        RESULT$=nr;
        TRACE_END_STM$("finn_felt",378);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn_felt",1,368,15,370,47,371,49,372,51,374,55,375,57,376,63,378,68,379);
}
