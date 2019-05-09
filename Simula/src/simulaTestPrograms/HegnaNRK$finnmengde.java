package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$finnmengde extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    int antall=0;
    int funn=0;
    HegnaNRK$liste_element lise=null;
    Head$ liste_mengde=null;
    public HegnaNRK$finnmengde(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$finnmengde STM$() {
        antall=0;
        new HegnaNRK$les_finne_regel(((HegnaNRK)(CUR$.SL$)));
        liste_mengde=new Head$(((HegnaNRK)(CUR$.SL$))).STM$();
        funn=new HegnaNRK$finn_post(((HegnaNRK)(CUR$.SL$)),0).RESULT$;
        while((funn!=(0))) {
            {
                antall=(antall+(1));
                new HegnaNRK$liste_element(((HegnaNRK)(CUR$.SL$)),funn).STM$().into(liste_mengde);
                funn=new HegnaNRK$finn_post(((HegnaNRK)(CUR$.SL$)),funn).RESULT$;
            }
        }
        sysout().outtext(new TXT$("Antall poster i mengden:"));
        sysout().outint(antall,5);
        sysout().outimage();
        if(VALUE$((antall==(0)))) {
            ((HegnaNRK)(CUR$.SL$)).mengde$1=null;
        } else
        {
            ((HegnaNRK)(CUR$.SL$)).mengde$1=new HegnaNRK$tabell_mengde(((HegnaNRK)(CUR$.SL$)),antall).STM$();
            for(boolean CB$1367:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(antall); }})
               )) { if(!CB$1367) continue;
            {
                lise=((HegnaNRK$liste_element)(liste_mengde.first()));
                lise.out();
                ((ARRAY$<int[]>)((HegnaNRK)(CUR$.SL$)).mengde$1.tabell).Elt[i-((HegnaNRK)(CUR$.SL$)).mengde$1.tabell.LB[0]]=lise.p2$nr;
            }
        }
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finnmengde",1,1346,8,1348,12,1349,14,1350,22,1351,24,1352,26,1353,28,1354,30,1355,32,1357,35,1358,37,1359,41,1361,44,1362,46,1363,50,1366,53,1367,57,1369,60,1370,62,1371,69,1374);
}
