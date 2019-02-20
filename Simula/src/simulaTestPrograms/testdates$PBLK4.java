// JavaLine 1 ==> SourceLine 4
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:45:54 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class testdates$PBLK4 extends Dates {
    // PrefixedBlockDeclaration: BlockKind=PrefixedBlock, BlockLevel=1, firstLine=4, lastLine=25, hasLocalClasses=false, System=true, detachUsed=false
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    Dates$Date TD=null;
    Dates$Date P=null;
    Dates$Date KrH=null;
    Dates$Date M1=null;
    Dates$Date M17=null;
    // Normal Constructor
    public testdates$PBLK4(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BPRG("testdates$PBLK4");
        // Declaration Code
        TRACE_BEGIN_DCL$("testdates$PBLK4",4);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("testdates$PBLK4",4,inner);
                // JavaLine 28 ==> SourceLine 6
                TD=new Dates$Today(((testdates$PBLK4)CUR$)).RESULT$;
                // JavaLine 30 ==> SourceLine 7
                sysout().outtext(CONC(CONC(new TXT$("I dag er det "),new Dates$Date$Image(TD).RESULT$),new TXT$(".")));
                sysout().outimage();
                // JavaLine 33 ==> SourceLine 9
                P=new Dates$Easter(((testdates$PBLK4)CUR$),TD.p$Y).RESULT$;
                // JavaLine 35 ==> SourceLine 10
                sysout().outtext(CONC(new TXT$("1. påskedag er "),new Dates$Date$Image(P).RESULT$));
                sysout().outimage();
                // JavaLine 38 ==> SourceLine 12
                KrH=new Dates$Date$Plus(P,39).RESULT$;
                // JavaLine 40 ==> SourceLine 13
                sysout().outtext(CONC(CONC(CONC(new Dates$Date$Weekday_norsk(KrH).RESULT$,new TXT$(" ")),new Dates$Date$Image(KrH).RESULT$),new TXT$(" er Kristi Himmelfartsdag")));
                // JavaLine 42 ==> SourceLine 14
                sysout().outimage();
                // JavaLine 44 ==> SourceLine 16
                M1=new Dates$Date(((testdates$PBLK4)CUR$),1,5,TD.p$Y).STM$();
                M17=new Dates$Date(((testdates$PBLK4)CUR$),17,5,TD.p$Y).STM$();
                // JavaLine 47 ==> SourceLine 17
                sysout().outtext(CONC(CONC(CONC(new Dates$Date$Image(M1).RESULT$,new TXT$(" er en ")),new Dates$Date$Weekday_norsk(M1).RESULT$),new TXT$(" og er ")));
                // JavaLine 49 ==> SourceLine 18
                if(VALUE$((!(new Dates$Date$Is_weekend(M1).RESULT$)))) {
                    sysout().outtext(new TXT$("ikke "));
                }
                // JavaLine 53 ==> SourceLine 19
                sysout().outtext(new TXT$("helg."));
                sysout().outimage();
                // JavaLine 56 ==> SourceLine 21
                sysout().outtext(CONC(CONC(CONC(new Dates$Date$Image(M17).RESULT$,new TXT$(" er en ")),new Dates$Date$Weekday_english(M17).RESULT$),new TXT$(" og er ")));
                // JavaLine 58 ==> SourceLine 22
                if(VALUE$((!(new Dates$Date$Is_weekend(M17).RESULT$)))) {
                    sysout().outtext(new TXT$("ikke "));
                }
                // JavaLine 62 ==> SourceLine 23
                sysout().outtext(new TXT$("helg."));
                sysout().outimage();
                TRACE_END_STM$("testdates$PBLK4",23);
            }
        };
    } // End of Constructor
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new testdates$PBLK4(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("testdates.sim","PrefixedBlock testdates$PBLK4",1,4,28,6,30,7,33,9,35,10,38,12,40,13,42,14,44,16,47,17,49,18,53,19,56,21,58,22,62,23,74,25);
}
