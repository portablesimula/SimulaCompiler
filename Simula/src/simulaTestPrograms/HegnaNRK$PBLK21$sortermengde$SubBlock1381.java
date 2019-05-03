package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$sortermengde$SubBlock1381 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int fnr=0;
    int i=0;
    int j=0;
    public ARRAY$<HegnaNRK$PBLK21$verdi[]>key=null;
    public HegnaNRK$PBLK21$sortermengde$SubBlock1381(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        int[] key$LB=new int[1]; int[] key$UB=new int[1];
        key$LB[0]=1; key$UB[0]=((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).mengde$1.p$antall;
        BOUND_CHECK$(key$LB[0],key$UB[0]);
        key=new ARRAY$<HegnaNRK$PBLK21$verdi[]>(new HegnaNRK$PBLK21$verdi[key$UB[0]-key$LB[0]+1],key$LB,key$UB);
    }
    public RTObject$ STM$() {
        ((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnavn$1=new HegnaNRK$PBLK21$les_feltnavn(((HegnaNRK$PBLK21)(CUR$.SL$.SL$))).RESULT$;
        fnr=((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnr$1;
        for(boolean CB$1385:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).mengde$1.p$antall); }})
           )) { if(!CB$1385) continue;
        {
            new HegnaNRK$PBLK21$hent_post(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)),((ARRAY$<int[]>)((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).mengde$1.tabell).Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).mengde$1.tabell.LB[0]]);
            j=new HegnaNRK$PBLK21$finn_intern_feltnr(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)),fnr).RESULT$;
            if(VALUE$((j!=(0)))) {
                key.Elt[i-key.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).intern_felt.Elt[j-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).intern_felt.LB[0]];
            } else
            key.Elt[i-key.LB[0]]=null;
        }
    }
    new HegnaNRK$PBLK21$sorter(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)),((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).mengde$1.tabell,key,((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).mengde$1.p$antall);
    EBLK();
    return(null);
}
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","SubBlock SubBlock1381",1,1381,11,1382,22,1383,24,1384,26,1385,30,1387,33,1388,35,1389,39,1390,43,1392,47,1393);
}
