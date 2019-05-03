package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$finn_intern_feltnr extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$feltnr;
    final LABQNT$ out=new LABQNT$(this,1,"out");
    int i=0;
    int nr=0;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$finn_intern_feltnr setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$feltnr=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$PBLK21$finn_intern_feltnr(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$PBLK21$finn_intern_feltnr(RTObject$ SL$,int sp$feltnr) {
        super(SL$);
        this.p$feltnr = sp$feltnr;
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$finn_intern_feltnr STM$() {
        HegnaNRK$PBLK21$finn_intern_feltnr THIS$=(HegnaNRK$PBLK21$finn_intern_feltnr)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                nr=0;
                for(boolean CB$872:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall$1); }})
                   )) { if(!CB$872) continue;
                if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.LB[0]]==(p$feltnr)))) {
                    {
                        nr=i;
                        GOTO$(out);
                    }
                }
            }
            LABEL$(1,"out");
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
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn_intern_feltnr",1,869,11,878,13,870,40,871,42,872,46,873,48,875,51,876,56,878,72,879);
}
