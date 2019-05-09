package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$ledig_post_plass extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    final LABQNT$ out=new LABQNT$(this,1,"out");
    int i=0;
    int nr=0;
    public HegnaNRK$ledig_post_plass(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HegnaNRK$ledig_post_plass STM$() {
        HegnaNRK$ledig_post_plass THIS$=(HegnaNRK$ledig_post_plass)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                nr=0;
                if(VALUE$(((((HegnaNRK)(CUR$.SL$)).antall_poster$1<(((HegnaNRK)(CUR$.SL$)).max_antall_poster$1))&((((HegnaNRK)(CUR$.SL$)).post_peker.Elt[(((HegnaNRK)(CUR$.SL$)).antall_poster$1+(1))-((HegnaNRK)(CUR$.SL$)).post_peker.LB[0]]==(null)))))) {
                    nr=(((HegnaNRK)(CUR$.SL$)).antall_poster$1+(1));
                } else
                for(boolean CB$889:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK)(CUR$.SL$)).max_antall_poster$1); }})
                   )) { if(!CB$889) continue;
                if(VALUE$((((HegnaNRK)(CUR$.SL$)).post_peker.Elt[i-((HegnaNRK)(CUR$.SL$)).post_peker.LB[0]]==(null)))) {
                    {
                        nr=i;
                        GOTO$(out);
                    }
                }
            }
            LABEL$(1,"out");
            if(VALUE$((nr==(0)))) {
                new HegnaNRK$feil(((HegnaNRK)(CUR$.SL$)),4);
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
