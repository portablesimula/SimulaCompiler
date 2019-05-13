package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 10 10:23:05 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class DatesTest extends Dates {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    Dates$Date TD$1=null;
    Dates$Date P$1=null;
    Dates$Date KrH$1=null;
    Dates$Date M1$1=null;
    Dates$Date M17$1=null;
    public DatesTest(RTObject$ staticLink) {
        super(staticLink);
        BPRG("DatesTest");
    }
    public DatesTest STM$() {
        M_tab.Elt[1-M_tab.LB[0]]=M_tab.Elt[3-M_tab.LB[0]]=M_tab.Elt[5-M_tab.LB[0]]=M_tab.Elt[7-M_tab.LB[0]]=31;
        M_tab.Elt[8-M_tab.LB[0]]=M_tab.Elt[10-M_tab.LB[0]]=M_tab.Elt[12-M_tab.LB[0]]=31;
        M_tab.Elt[4-M_tab.LB[0]]=M_tab.Elt[6-M_tab.LB[0]]=M_tab.Elt[9-M_tab.LB[0]]=M_tab.Elt[11-M_tab.LB[0]]=30;
        M_tab.Elt[2-M_tab.LB[0]]=28;
        WE_tab.Elt[0-WE_tab.LB[0]]=new TXT$("Sunday");
        WN_tab.Elt[0-WN_tab.LB[0]]=new TXT$("søndag");
        WE_tab.Elt[1-WE_tab.LB[0]]=new TXT$("Monday");
        WN_tab.Elt[1-WN_tab.LB[0]]=new TXT$("mandag");
        WE_tab.Elt[2-WE_tab.LB[0]]=new TXT$("Tuesday");
        WN_tab.Elt[2-WN_tab.LB[0]]=new TXT$("tirsdag");
        WE_tab.Elt[3-WE_tab.LB[0]]=new TXT$("Wednesday");
        WN_tab.Elt[3-WN_tab.LB[0]]=new TXT$("onsdag");
        WE_tab.Elt[4-WE_tab.LB[0]]=new TXT$("Thursday");
        WN_tab.Elt[4-WN_tab.LB[0]]=new TXT$("torsdag");
        WE_tab.Elt[5-WE_tab.LB[0]]=new TXT$("Friday");
        WN_tab.Elt[5-WN_tab.LB[0]]=new TXT$("fredag");
        WE_tab.Elt[6-WE_tab.LB[0]]=new TXT$("Saturday");
        WN_tab.Elt[6-WN_tab.LB[0]]=new TXT$("lørdag");
        TD$1=new Dates$Today(((DatesTest)CUR$)).RESULT$;
        sysout().outtext(CONC(CONC(new TXT$("I dag er det "),new Dates$Date$Image(TD$1).RESULT$),new TXT$(".")));
        sysout().outimage();
        P$1=new Dates$Easter(((DatesTest)CUR$),TD$1.p$Y).RESULT$;
        sysout().outtext(CONC(new TXT$("1. påskedag er "),new Dates$Date$Image(P$1).RESULT$));
        sysout().outimage();
        KrH$1=new Dates$Date$Plus(P$1,39).RESULT$;
        sysout().outtext(CONC(CONC(CONC(new Dates$Date$Weekday_norsk(KrH$1).RESULT$,new TXT$(" ")),new Dates$Date$Image(KrH$1).RESULT$),new TXT$(" er Kristi Himmelfartsdag")));
        sysout().outimage();
        M1$1=new Dates$Date(((DatesTest)CUR$),1,5,TD$1.p$Y).STM$();
        M17$1=new Dates$Date(((DatesTest)CUR$),17,5,TD$1.p$Y).STM$();
        sysout().outtext(CONC(CONC(CONC(new Dates$Date$Image(M1$1).RESULT$,new TXT$(" er en ")),new Dates$Date$Weekday_norsk(M1$1).RESULT$),new TXT$(" og er ")));
        if(VALUE$((!(new Dates$Date$Is_weekend(M1$1).RESULT$)))) {
            sysout().outtext(new TXT$("ikke "));
        }
        sysout().outtext(new TXT$("helg."));
        sysout().outimage();
        sysout().outtext(CONC(CONC(CONC(new Dates$Date$Image(M17$1).RESULT$,new TXT$(" er en ")),new Dates$Date$Weekday_english(M17$1).RESULT$),new TXT$(" og er ")));
        if(VALUE$((!(new Dates$Date$Is_weekend(M17$1).RESULT$)))) {
            sysout().outtext(new TXT$("ikke "));
        }
        sysout().outtext(new TXT$("helg."));
        sysout().outimage();
        EBLK();
        return(this);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new DatesTest(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("DatesTest.sim","PrefixedBlock DatesTest",1,4,19,265,21,266,23,267,25,268,27,270,30,271,33,272,36,273,39,274,42,275,45,276,48,6,50,7,53,9,55,10,58,12,60,13,62,14,64,16,67,17,69,18,73,19,76,21,78,22,82,23,92,26);
}
