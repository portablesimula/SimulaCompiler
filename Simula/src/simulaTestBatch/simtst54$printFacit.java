package simulaTestBatch;
// Simula-1.0 Compiled at Sat Jun 15 10:11:34 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst54$printFacit extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    public simtst54$printFacit(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst54$printFacit STM$() {
        for(boolean CB$29:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(0); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(11); }})
           )) { if(!CB$29) continue;
        {
            sysout().outtext(((simtst54)(CUR$.SL$)).facit.Elt[i-((simtst54)(CUR$.SL$)).facit.LB[0]]);
            sysout().outimage();
        }
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("simtst54.sim","Procedure printFacit",1,27,8,28,16,29,20,30,28,32);
}
