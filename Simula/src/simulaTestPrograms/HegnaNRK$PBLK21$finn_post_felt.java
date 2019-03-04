// JavaLine 1 ==> SourceLine 726
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 04 20:15:38 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$finn_post_felt extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=726, lastLine=745, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$pnr;
    public int p$finr;
    // Declare locals as attributes
    // JavaLine 16 ==> SourceLine 728
    int i=0;
    int fnr=0;
    HegnaNRK$PBLK21$verdi pverdi=null;
    // JavaLine 20 ==> SourceLine 729
    boolean funnet=false;
    boolean likhet=false;
    // JavaLine 23 ==> SourceLine 734
    HegnaNRK$PBLK21$post inspect$734$0=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$finn_post_felt setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$finn_post_felt.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$pnr=intValue(param); break;
                case 1: p$finr=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HegnaNRK$PBLK21$finn_post_felt(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$finn_post_felt(RTObject$ SL$,int sp$pnr,int sp$finr) {
        super(SL$);
        // Parameter assignment to locals
        this.p$pnr = sp$pnr;
        this.p$finr = sp$finr;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("finn_post_felt",734);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$finn_post_felt STM$() {
        TRACE_BEGIN_STM$("finn_post_felt",734);
        // JavaLine 56 ==> SourceLine 730
        i=0;
        // JavaLine 58 ==> SourceLine 731
        funnet=likhet=false;
        // JavaLine 60 ==> SourceLine 732
        fnr=((HegnaNRK$PBLK21)(CUR$.SL$)).finnefeltnr.Elt[p$finr-((HegnaNRK$PBLK21)(CUR$.SL$)).finnefeltnr.LB[0]];
        // JavaLine 62 ==> SourceLine 733
        pverdi=((HegnaNRK$PBLK21)(CUR$.SL$)).finnefeltpeker.Elt[p$finr-((HegnaNRK$PBLK21)(CUR$.SL$)).finnefeltpeker.LB[0]];
        // JavaLine 64 ==> SourceLine 734
        {
            // BEGIN INSPECTION 
            inspect$734$0=((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.Elt[p$pnr-((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.LB[0]];
            if(inspect$734$0!=null) //INSPECT inspect$734$0
            // JavaLine 69 ==> SourceLine 735
            while(((!(funnet))&((i<(inspect$734$0.p$antall))))) {
                // JavaLine 71 ==> SourceLine 737
                {
                    TRACE_BEGIN_STM$("CompoundStatement737",737);
                    i=(i+(1));
                    // JavaLine 75 ==> SourceLine 738
                    if(VALUE$((fnr==(inspect$734$0.feltnr.Elt[i-inspect$734$0.feltnr.LB[0]])))) {
                        // JavaLine 77 ==> SourceLine 740
                        {
                            TRACE_BEGIN_STM$("CompoundStatement740",740);
                            funnet=true;
                            // JavaLine 81 ==> SourceLine 741
                            likhet=((boolean)(pverdi.test_verdilikhet$0().CPF().setPar(new NAME$<HegnaNRK$PBLK21$verdi>(){ public HegnaNRK$PBLK21$verdi get() { return(inspect$734$0.felt.Elt[i-inspect$734$0.felt.LB[0]]); } public HegnaNRK$PBLK21$verdi put(HegnaNRK$PBLK21$verdi x$) { return(inspect$734$0.felt.Elt[i-inspect$734$0.felt.LB[0]]=(HegnaNRK$PBLK21$verdi)x$); } }).ENT$().RESULT$()));
                            TRACE_END_STM$("CompoundStatement740",741);
                        }
                    }
                    TRACE_END_STM$("CompoundStatement737",741);
                }
            }
        }
        // JavaLine 90 ==> SourceLine 744
        RESULT$=likhet;
        TRACE_END_STM$("finn_post_felt",744);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn_post_felt",1,726,16,728,20,729,23,734,56,730,58,731,60,732,62,733,64,734,69,735,71,737,75,738,77,740,81,741,90,744,95,745);
}
