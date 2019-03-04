// JavaLine 1 ==> SourceLine 418
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 04 20:15:38 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$hjelp extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=418, lastLine=426, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 420
    int i=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$hjelp(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("hjelp",420);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$hjelp STM$() {
        TRACE_BEGIN_STM$("hjelp",420);
        // JavaLine 25 ==> SourceLine 421
        sysout().outimage();
        // JavaLine 27 ==> SourceLine 422
        for(boolean CB$422:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$)).max_kommando); }})
           )) { if(!CB$422) continue;
        // JavaLine 31 ==> SourceLine 424
        {
            TRACE_BEGIN_STM$("CompoundStatement424",424);
            sysout().outtext(((HegnaNRK$PBLK21)(CUR$.SL$)).kommando_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).kommando_tabell.LB[0]]);
            sysout().outimage();
            TRACE_END_STM$("CompoundStatement424",424);
        }
    }
    TRACE_END_STM$("hjelp",424);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure hjelp",1,418,11,420,25,421,27,422,31,424,42,426);
}
