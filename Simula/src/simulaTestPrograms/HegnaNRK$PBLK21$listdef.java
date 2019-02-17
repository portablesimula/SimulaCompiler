// JavaLine 1 ==> SourceLine 445
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 17 15:04:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$listdef extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=445, lastLine=460, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 447
    int i=0;
    int j=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$listdef(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("listdef",447);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$listdef STM$() {
        TRACE_BEGIN_STM$("listdef",447);
        // JavaLine 26 ==> SourceLine 448
        for(boolean CB$448:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(2); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_felt_def); }})
           )) { if(!CB$448) continue;
        // JavaLine 30 ==> SourceLine 450
        {
            TRACE_BEGIN_STM$("CompoundStatement450",450);
            j=((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.LB[0]];
            // JavaLine 34 ==> SourceLine 451
            sysout().outtext(((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn_tabell.LB[0]]);
            // JavaLine 36 ==> SourceLine 452
            sysout().outchar(((char)32));
            sysout().outchar(((HegnaNRK$PBLK21)(CUR$.SL$)).type_tabell.Elt[j-((HegnaNRK$PBLK21)(CUR$.SL$)).type_tabell.LB[0]]);
            // JavaLine 39 ==> SourceLine 453
            sysout().outimage();
            TRACE_END_STM$("CompoundStatement450",453);
        }
    }
    // JavaLine 44 ==> SourceLine 455
    for(boolean CB$455:new ForList(
        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_format_def); }})
       )) { if(!CB$455) continue;
    // JavaLine 48 ==> SourceLine 457
    {
        TRACE_BEGIN_STM$("CompoundStatement457",457);
        sysout().outtext(((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn_tabell.LB[0]]);
        // JavaLine 52 ==> SourceLine 458
        sysout().outimage();
        TRACE_END_STM$("CompoundStatement457",458);
    }
}
TRACE_END_STM$("listdef",458);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure listdef",1,445,11,447,26,448,30,450,34,451,36,452,39,453,44,455,48,457,52,458,60,460);
}
