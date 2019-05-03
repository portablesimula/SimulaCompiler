package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$listdef extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    int j=0;
    public HegnaNRK$PBLK21$listdef(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$listdef STM$() {
        for(boolean CB$448:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(2); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_felt_def$1); }})
           )) { if(!CB$448) continue;
        {
            j=((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).felttype_tabell.LB[0]];
            sysout().outtext(((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).feltnavn_tabell.LB[0]]);
            sysout().outchar(((char)32));
            sysout().outchar(((HegnaNRK$PBLK21)(CUR$.SL$)).type_tabell.Elt[j-((HegnaNRK$PBLK21)(CUR$.SL$)).type_tabell.LB[0]]);
            sysout().outimage();
        }
    }
    for(boolean CB$455:new ForList(
        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_format_def$1); }})
       )) { if(!CB$455) continue;
    {
        sysout().outtext(((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn_tabell.LB[0]]);
        sysout().outimage();
    }
}
EBLK();
return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure listdef",1,445,8,447,17,448,21,450,24,451,26,452,29,453,33,455,37,457,40,458,46,460);
}
