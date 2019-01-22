// JavaLine 1 ==> SourceLine 428
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:13:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$list extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=428, lastLine=443, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 430
    int i=0;
    int pnr=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$list(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("list",430);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$list STM$() {
        TRACE_BEGIN_STM$("list",430);
        // JavaLine 26 ==> SourceLine 431
        sysout().outimage();
        // JavaLine 28 ==> SourceLine 432
        pnr=1;
        // JavaLine 30 ==> SourceLine 433
        for(boolean CB$433:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster); }})
           )) { if(!CB$433) continue;
        // JavaLine 34 ==> SourceLine 435
        {
            TRACE_BEGIN_STM$("CompoundStatement435",435);
            while((((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.Elt[pnr-((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.LB[0]]==(null))) {
                pnr=(pnr+(1));
            }
            // JavaLine 40 ==> SourceLine 436
            sysout().outtext(new TXT$("Post nr."));
            sysout().outint(pnr,4);
            sysout().outimage();
            // JavaLine 44 ==> SourceLine 437
            new HegnaNRK$PBLK21$hent_post(((HegnaNRK$PBLK21)(CUR$.SL$)),pnr);
            // JavaLine 46 ==> SourceLine 438
            new HegnaNRK$PBLK21$skjerm_intern_post(((HegnaNRK$PBLK21)(CUR$.SL$)));
            // JavaLine 48 ==> SourceLine 439
            pnr=(pnr+(1));
            TRACE_END_STM$("CompoundStatement435",439);
        }
    }
    // JavaLine 53 ==> SourceLine 441
    sysout().outtext(new TXT$("Totalt antall poster er"));
    // JavaLine 55 ==> SourceLine 442
    sysout().outint(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster,4);
    sysout().outimage();
    TRACE_END_STM$("list",442);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure list",1,428,11,430,26,431,28,432,30,433,34,435,40,436,44,437,46,438,48,439,53,441,55,442,61,443);
}
