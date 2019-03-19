// JavaLine 1 ==> SourceLine 1072
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:03:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$rapporter extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1072, lastLine=1089, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 1074
    boolean mer=false;
    int funn=0;
    // Normal Constructor
    public HegnaNRK$PBLK21$rapporter(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("rapporter",1074);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$rapporter STM$() {
        TRACE_BEGIN_STM$("rapporter",1074);
        // JavaLine 26 ==> SourceLine 1075
        ((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn=new HegnaNRK$PBLK21$les_formatnavn(((HegnaNRK$PBLK21)(CUR$.SL$))).RESULT$;
        // JavaLine 28 ==> SourceLine 1076
        new HegnaNRK$PBLK21$les_finne_regel(((HegnaNRK$PBLK21)(CUR$.SL$)));
        // JavaLine 30 ==> SourceLine 1077
        sysout().outimage();
        // JavaLine 32 ==> SourceLine 1078
        mer=true;
        funn=0;
        // JavaLine 35 ==> SourceLine 1079
        while(mer) {
            // JavaLine 37 ==> SourceLine 1081
            {
                TRACE_BEGIN_STM$("CompoundStatement1081",1081);
                funn=new HegnaNRK$PBLK21$finn_post(((HegnaNRK$PBLK21)(CUR$.SL$)),funn).RESULT$;
                // JavaLine 41 ==> SourceLine 1082
                if(VALUE$((funn!=(0)))) {
                    // JavaLine 43 ==> SourceLine 1084
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1084",1084);
                        new HegnaNRK$PBLK21$hent_post(((HegnaNRK$PBLK21)(CUR$.SL$)),funn);
                        // JavaLine 47 ==> SourceLine 1085
                        new HegnaNRK$PBLK21$trykk_rapport(((HegnaNRK$PBLK21)(CUR$.SL$)),((HegnaNRK$PBLK21)(CUR$.SL$)).formatnr);
                        TRACE_END_STM$("CompoundStatement1084",1085);
                    }
                }
                // JavaLine 52 ==> SourceLine 1087
                mer=(funn!=(0));
                TRACE_END_STM$("CompoundStatement1081",1087);
            }
        }
        TRACE_END_STM$("rapporter",1087);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure rapporter",1,1072,11,1074,26,1075,28,1076,30,1077,32,1078,35,1079,37,1081,41,1082,43,1084,47,1085,52,1087,60,1089);
}
