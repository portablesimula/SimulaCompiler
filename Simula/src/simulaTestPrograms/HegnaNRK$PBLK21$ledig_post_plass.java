package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$ledig_post_plass extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    final LABQNT$ out=new LABQNT$(this,1,"out");
    int i=0;
    int nr=0;
    public HegnaNRK$PBLK21$ledig_post_plass(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$ledig_post_plass STM$() {
        HegnaNRK$PBLK21$ledig_post_plass THIS$=(HegnaNRK$PBLK21$ledig_post_plass)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                nr=0;
                if(VALUE$(((((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster$1<(((HegnaNRK$PBLK21)(CUR$.SL$)).max_antall_poster$1))&((((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.Elt[(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster$1+(1))-((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.LB[0]]==(null)))))) {
                    nr=(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_poster$1+(1));
                } else
                for(boolean CB$889:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$)).max_antall_poster$1); }})
                   )) { if(!CB$889) continue;
                if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).post_peker.LB[0]]==(null)))) {
                    {
                        nr=i;
                        GOTO$(out);
                    }
                }
            }
            LABEL$(1,"out");
            if(VALUE$((nr==(0)))) {
                new HegnaNRK$PBLK21$feil(((HegnaNRK$PBLK21)(CUR$.SL$)),4);
            }
            RESULT$=nr;
            break LOOP$;
        }
        catch(LABQNT$ q) {
            CUR$=THIS$;
            if(q.SL$!=CUR$) {
                CUR$.STATE$=OperationalState.terminated;
                throw(q);
            }
            JTX$=q.index; continue LOOP$;
        }
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure ledig_post_plass",1,881,10,895,12,883,25,884,27,885,29,887,32,889,36,890,38,892,41,893,46,895,51,896,66,897);
}
