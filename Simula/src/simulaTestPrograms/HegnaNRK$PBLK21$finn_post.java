// JavaLine 1 ==> SourceLine 678
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:32:37 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$finn_post extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=678, lastLine=705, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$start;
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 680
    int i=0;
    int j=0;
    int pnr=0;
    boolean funnet=false;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$finn_post setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$finn_post.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public HegnaNRK$PBLK21$finn_post(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$finn_post(RTObject$ SL$,int sp$start) {
        super(SL$);
        // Parameter assignment to locals
        this.p$start = sp$start;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("finn_post",680);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$finn_post STM$() {
        TRACE_BEGIN_STM$("finn_post",680);
        // JavaLine 49 ==> SourceLine 681
        i=0;
        pnr=p$start;
        // JavaLine 52 ==> SourceLine 682
        funnet=false;
        // JavaLine 54 ==> SourceLine 683
        while((((!(funnet))&((i<(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster))))&((pnr<(((HegnaNRK$PBLK21)(CUR$.SL$)).max_antall_poster))))) {
            // JavaLine 56 ==> SourceLine 686
            {
                TRACE_BEGIN_STM$("CompoundStatement686",686);
                i=(i+(1));
                // JavaLine 60 ==> SourceLine 687
                pnr=(pnr+(1));
                // JavaLine 62 ==> SourceLine 688
                while(((((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.Elt[pnr-((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.LB[0]]==(null))&((pnr<(((HegnaNRK$PBLK21)(CUR$.SL$)).max_antall_poster))))) {
                    // JavaLine 64 ==> SourceLine 689
                    pnr=(pnr+(1));
                }
                // JavaLine 67 ==> SourceLine 690
                if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.Elt[pnr-((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.LB[0]]!=(null)))) {
                    // JavaLine 69 ==> SourceLine 692
                    {
                        TRACE_BEGIN_STM$("CompoundStatement692",692);
                        j=1;
                        // JavaLine 73 ==> SourceLine 693
                        if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).finne_regel_antall==(0)))) {
                            // JavaLine 75 ==> SourceLine 694
                            funnet=true;
                        } else
                        // JavaLine 78 ==> SourceLine 696
                        funnet=new HegnaNRK$PBLK21$finn_post_felt(((HegnaNRK$PBLK21)(CUR$.SL$)),pnr,j).RESULT$;
                        // JavaLine 80 ==> SourceLine 697
                        while((funnet&((j<(((HegnaNRK$PBLK21)(CUR$.SL$)).finne_regel_antall))))) {
                            // JavaLine 82 ==> SourceLine 699
                            {
                                TRACE_BEGIN_STM$("CompoundStatement699",699);
                                j=(j+(1));
                                // JavaLine 86 ==> SourceLine 700
                                funnet=new HegnaNRK$PBLK21$finn_post_felt(((HegnaNRK$PBLK21)(CUR$.SL$)),pnr,j).RESULT$;
                                TRACE_END_STM$("CompoundStatement699",700);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement692",700);
                    }
                }
                TRACE_END_STM$("CompoundStatement686",700);
            }
        }
        // JavaLine 97 ==> SourceLine 704
        RESULT$=((funnet)?(pnr):(0));
        TRACE_END_STM$("finn_post",704);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn_post",1,678,15,680,49,681,52,682,54,683,56,686,60,687,62,688,64,689,67,690,69,692,73,693,75,694,78,696,80,697,82,699,86,700,97,704,102,705);
}
