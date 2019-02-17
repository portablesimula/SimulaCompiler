// JavaLine 1 ==> SourceLine 1381
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 17 15:04:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$sortermengde$SubBlock1381 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=3, firstLine=1381, lastLine=1393, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int fnr=0;
    int i=0;
    int j=0;
    // JavaLine 13 ==> SourceLine 1382
    public ARRAY$<HegnaNRK$PBLK21$verdi[]>key=null;
    // Normal Constructor
    public HegnaNRK$PBLK21$sortermengde$SubBlock1381(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock1381",1382);
        int[] key$LB=new int[1]; int[] key$UB=new int[1];
        key$LB[0]=1; key$UB[0]=((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).mengde.p$antall;
        BOUND_CHECK$(key$LB[0],key$UB[0]);
        key=new ARRAY$<HegnaNRK$PBLK21$verdi[]>(new HegnaNRK$PBLK21$verdi[key$UB[0]-key$LB[0]+1],key$LB,key$UB);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock1381",1382);
        // JavaLine 29 ==> SourceLine 1383
        ((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnavn=new HegnaNRK$PBLK21$les_feltnavn(((HegnaNRK$PBLK21)(CUR$.SL$.SL$))).RESULT$;
        // JavaLine 31 ==> SourceLine 1384
        fnr=((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).feltnr;
        // JavaLine 33 ==> SourceLine 1385
        for(boolean CB$1385:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).mengde.p$antall); }})
           )) { if(!CB$1385) continue;
        // JavaLine 37 ==> SourceLine 1387
        {
            TRACE_BEGIN_STM$("CompoundStatement1387",1387);
            new HegnaNRK$PBLK21$hent_post(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)),((ARRAY$<int[]>)((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).mengde.tabell).Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).mengde.tabell.LB[0]]);
            // JavaLine 41 ==> SourceLine 1388
            j=new HegnaNRK$PBLK21$finn_intern_feltnr(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)),fnr).RESULT$;
            // JavaLine 43 ==> SourceLine 1389
            if(VALUE$((j!=(0)))) {
                key.Elt[i-key.LB[0]]=((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).intern_felt.Elt[j-((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).intern_felt.LB[0]];
            } else
            // JavaLine 47 ==> SourceLine 1390
            key.Elt[i-key.LB[0]]=null;
            TRACE_END_STM$("CompoundStatement1387",1390);
        }
    }
    // JavaLine 52 ==> SourceLine 1392
    new HegnaNRK$PBLK21$sorter(((HegnaNRK$PBLK21)(CUR$.SL$.SL$)),((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).mengde.tabell,key,((HegnaNRK$PBLK21)(CUR$.SL$.SL$)).mengde.p$antall);
    TRACE_END_STM$("SubBlock1381",1392);
    EBLK();
    return(null);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","SubBlock SubBlock1381",1,1381,13,1382,29,1383,31,1384,33,1385,37,1387,41,1388,43,1389,47,1390,52,1392,57,1393);
}
