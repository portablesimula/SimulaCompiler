// JavaLine 1 <== SourceLine 810
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$hent_post extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=810, lastLine=823, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$pnr;
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 812
    int i=0;
    // JavaLine 14 <== SourceLine 813
    HegnaNRK$PBLK21$post inspect$813$3=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$hent_post setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$hent_post.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$pnr=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HegnaNRK$PBLK21$hent_post(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$hent_post(RTObject$ SL$,int sp$pnr) {
        super(SL$);
        // Parameter assignment to locals
        this.p$pnr = sp$pnr;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("hent_post",813);
        STM$();
    }
    // Procedure Statements
    public HegnaNRK$PBLK21$hent_post STM$() {
        TRACE_BEGIN_STM$("hent_post",813);
        {
            // BEGIN INSPECTION 
            inspect$813$3=((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.Elt[p$pnr-((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.LB[0]];
            if(inspect$813$3!=null) // INSPECT inspect$813$3
            // JavaLine 49 <== SourceLine 815
            {
                TRACE_BEGIN_STM$("CompoundStatement815",815);
                ((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall$1=inspect$813$3.p$antall;
                // JavaLine 53 <== SourceLine 816
                for(boolean CB$816:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall$1); }})
                   )) { if(!CB$816) continue;
                // JavaLine 57 <== SourceLine 818
                {
                    TRACE_BEGIN_STM$("CompoundStatement818",818);
                    ((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.LB[0]]=inspect$813$3.feltnr.Elt[i-inspect$813$3.feltnr.LB[0]];
                    // JavaLine 61 <== SourceLine 819
                    ((HegnaNRK$PBLK21)(CUR$.SL$)).intern_felt.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_felt.LB[0]]=new HegnaNRK$PBLK21$felt_kopi(((HegnaNRK$PBLK21)(CUR$.SL$)),inspect$813$3.felt.Elt[i-inspect$813$3.felt.LB[0]]).RESULT$;
                    TRACE_END_STM$("CompoundStatement818",819);
                }
            }
            // JavaLine 66 <== SourceLine 821
            ((HegnaNRK$PBLK21)(CUR$.SL$)).aktuell$1=p$pnr;
            TRACE_END_STM$("CompoundStatement815",821);
        }
    }
    TRACE_END_STM$("hent_post",821);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure hent_post",1,810,12,812,14,813,49,815,53,816,57,818,61,819,66,821,74,823);
} // End of Procedure
