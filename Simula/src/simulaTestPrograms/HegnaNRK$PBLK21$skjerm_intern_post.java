// JavaLine 1 ==> SourceLine 837
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 17 15:04:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$skjerm_intern_post extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=837, lastLine=850, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 839
    int i=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$skjerm_intern_post(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("skjerm_intern_post",839);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$skjerm_intern_post STM$() {
        TRACE_BEGIN_STM$("skjerm_intern_post",839);
        // JavaLine 25 ==> SourceLine 840
        for(boolean CB$840:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall); }})
           )) { if(!CB$840) continue;
        // JavaLine 29 ==> SourceLine 842
        {
            TRACE_BEGIN_STM$("CompoundStatement842",842);
            ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr=((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.LB[0]];
            // JavaLine 33 ==> SourceLine 843
            ((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn=((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn_tabell.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr-((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn_tabell.LB[0]];
            // JavaLine 35 ==> SourceLine 844
            ((HegnaNRK$PBLK21)(CUR$.SL$)).felttype=((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.Elt[((HegnaNRK$PBLK21)(CUR$.SL$)).feltnr-((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.LB[0]];
            // JavaLine 37 ==> SourceLine 845
            sysout().outtext(((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn);
            sysout().outchar(':');
            // JavaLine 40 ==> SourceLine 846
            TXT$.setpos(sysout().image,(((HegnaNRK$PBLK21)(CUR$.SL$)).navne_lengde+(1)));
            // JavaLine 42 ==> SourceLine 847
            ((HegnaNRK$PBLK21)(CUR$.SL$)).intern_felt.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_felt.LB[0]].skriv$0().CPF();
            // JavaLine 44 ==> SourceLine 848
            sysout().outimage();
            TRACE_END_STM$("CompoundStatement842",848);
        }
    }
    TRACE_END_STM$("skjerm_intern_post",848);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure skjerm_intern_post",1,837,11,839,25,840,29,842,33,843,35,844,37,845,40,846,42,847,44,848,52,850);
}
