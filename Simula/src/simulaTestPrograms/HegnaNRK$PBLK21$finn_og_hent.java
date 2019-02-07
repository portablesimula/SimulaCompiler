// JavaLine 1 ==> SourceLine 663
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:32:37 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$finn_og_hent extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=663, lastLine=676, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$start;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 665
    int funn=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$finn_og_hent setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$finn_og_hent.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$start=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HegnaNRK$PBLK21$finn_og_hent(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$finn_og_hent(RTObject$ SL$,int sp$start) {
        super(SL$);
        // Parameter assignment to locals
        this.p$start = sp$start;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("finn_og_hent",665);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$finn_og_hent STM$() {
        TRACE_BEGIN_STM$("finn_og_hent",665);
        // JavaLine 43 ==> SourceLine 666
        new HegnaNRK$PBLK21$stryk_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
        // JavaLine 45 ==> SourceLine 667
        funn=new HegnaNRK$PBLK21$finn_post(((HegnaNRK$PBLK21)(CUR$.SL$)),p$start).RESULT$;
        // JavaLine 47 ==> SourceLine 668
        if(VALUE$((funn!=(0)))) {
            // JavaLine 49 ==> SourceLine 670
            {
                TRACE_BEGIN_STM$("CompoundStatement670",670);
                new HegnaNRK$PBLK21$hent_post(((HegnaNRK$PBLK21)(CUR$.SL$)),funn);
                // JavaLine 53 ==> SourceLine 671
                sysout().outimage();
                // JavaLine 55 ==> SourceLine 672
                new HegnaNRK$PBLK21$skjerm_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
                TRACE_END_STM$("CompoundStatement670",672);
            }
        } else
        // JavaLine 60 ==> SourceLine 675
        new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),5);
        TRACE_END_STM$("finn_og_hent",675);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn_og_hent",1,663,12,665,43,666,45,667,47,668,49,670,53,671,55,672,60,675,65,676);
}
