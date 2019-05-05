// JavaLine 1 <== SourceLine 792
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$skriv_intern_post extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=792, lastLine=808, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 794
    int i=0;
    int post_fri=0;
    // JavaLine 14 <== SourceLine 799
    HegnaNRK$PBLK21$post inspect$799$2=null;
    // Normal Constructor
    public HegnaNRK$PBLK21$skriv_intern_post(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("skriv_intern_post",799);
        STM$();
    }
    // Procedure Statements
    public HegnaNRK$PBLK21$skriv_intern_post STM$() {
        TRACE_BEGIN_STM$("skriv_intern_post",799);
        // JavaLine 28 <== SourceLine 795
        post_fri=new HegnaNRK$PBLK21$ledig_post_plass(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 30 <== SourceLine 796
        if(VALUE$((post_fri!=(0)))) {
            // JavaLine 32 <== SourceLine 798
            {
                TRACE_BEGIN_STM$("CompoundStatement798",798);
                ((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.Elt[post_fri-((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.LB[0]]=new HegnaNRK$PBLK21$post(((HegnaNRK$PBLK21)(CUR$.SL$)),((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall$1).STM$();
                // JavaLine 36 <== SourceLine 799
                {
                    // BEGIN INSPECTION 
                    inspect$799$2=((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.Elt[post_fri-((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.LB[0]];
                    if(inspect$799$2!=null) // INSPECT inspect$799$2
                    // JavaLine 41 <== SourceLine 800
                    for(boolean CB$800:new ForList(
                        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall$1); }})
                       )) { if(!CB$800) continue;
                    // JavaLine 45 <== SourceLine 802
                    {
                        TRACE_BEGIN_STM$("CompoundStatement802",802);
                        inspect$799$2.feltnr.Elt[i-inspect$799$2.feltnr.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.LB[0]];
                        // JavaLine 49 <== SourceLine 803
                        inspect$799$2.felt.Elt[i-inspect$799$2.felt.LB[0]]=new HegnaNRK$PBLK21$felt_kopi(((HegnaNRK$PBLK21)(CUR$.SL$)),((HegnaNRK$PBLK21)(CUR$.SL$)).intern_felt.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_felt.LB[0]]).RESULT$;
                        TRACE_END_STM$("CompoundStatement802",803);
                    }
                }
            }
            // JavaLine 55 <== SourceLine 805
            ((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster$1=(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster$1+(1));
            // JavaLine 57 <== SourceLine 806
            ((HegnaNRK$PBLK21)(CUR$.SL$)).aktuell$1=post_fri;
            TRACE_END_STM$("CompoundStatement798",806);
        }
    }
    TRACE_END_STM$("skriv_intern_post",806);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure skriv_intern_post",1,792,11,794,14,799,28,795,30,796,32,798,36,799,41,800,45,802,49,803,55,805,57,806,65,808);
} // End of Procedure
