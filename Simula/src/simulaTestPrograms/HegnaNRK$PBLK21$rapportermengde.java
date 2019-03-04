// JavaLine 1 ==> SourceLine 1440
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 04 20:15:39 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$rapportermengde extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1440, lastLine=1449, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 1442
    int i=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$rapportermengde(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("rapportermengde",1442);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$rapportermengde STM$() {
        TRACE_BEGIN_STM$("rapportermengde",1442);
        // JavaLine 25 ==> SourceLine 1443
        ((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn=new HegnaNRK$PBLK21$les_formatnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 27 ==> SourceLine 1444
        for(boolean CB$1444:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$)).mengde.p$antall); }})
           )) { if(!CB$1444) continue;
        // JavaLine 31 ==> SourceLine 1446
        {
            TRACE_BEGIN_STM$("CompoundStatement1446",1446);
            new HegnaNRK$PBLK21$hent_post(((HegnaNRK$PBLK21)(CUR$.SL$)),((ARRAY$<int[]>)((HegnaNRK$PBLK21)(CUR$.SL$)).mengde.tabell).Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).mengde.tabell.LB[0]]);
            // JavaLine 35 ==> SourceLine 1447
            new HegnaNRK$PBLK21$trykk_rapport(((HegnaNRK$PBLK21)(CUR$.SL$)),((HegnaNRK$PBLK21)(CUR$.SL$)).formatnr);
            TRACE_END_STM$("CompoundStatement1446",1447);
        }
    }
    TRACE_END_STM$("rapportermengde",1447);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure rapportermengde",1,1440,11,1442,25,1443,27,1444,31,1446,35,1447,43,1449);
}
