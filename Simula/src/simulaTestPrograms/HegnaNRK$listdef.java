package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$listdef extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    int j=0;
    public HegnaNRK$listdef(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$listdef STM$() {
        for(boolean CB$448:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(2); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK)(CUR$.SL$)).antall_felt_def$1); }})
           )) { if(!CB$448) continue;
        {
            j=((HegnaNRK)(CUR$.SL$)).felttype_tabell.Elt[i-((HegnaNRK)(CUR$.SL$)).felttype_tabell.LB[0]];
            sysout().outtext(((HegnaNRK)(CUR$.SL$)).feltnavn_tabell.Elt[i-((HegnaNRK)(CUR$.SL$)).feltnavn_tabell.LB[0]]);
            sysout().outchar(((char)32));
            sysout().outchar(((HegnaNRK)(CUR$.SL$)).type_tabell.Elt[j-((HegnaNRK)(CUR$.SL$)).type_tabell.LB[0]]);
            sysout().outimage();
        }
    }
    for(boolean CB$455:new ForList(
        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK)(CUR$.SL$)).antall_format_def$1); }})
       )) { if(!CB$455) continue;
    {
        sysout().outtext(((HegnaNRK)(CUR$.SL$)).formatnavn_tabell.Elt[i-((HegnaNRK)(CUR$.SL$)).formatnavn_tabell.LB[0]]);
        sysout().outimage();
    }
}
EBLK();
return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure listdef",1,445,8,447,17,448,21,450,24,451,26,452,29,453,33,455,37,457,40,458,46,460);
}
