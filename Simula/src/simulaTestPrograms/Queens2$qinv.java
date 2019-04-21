package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:26:23 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Queens2$qinv extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$i;
    final LABQNT$ EX=new LABQNT$(this,1,"EX");
    int j=0;
    private int $npar=0; // Number of actual parameters transmitted.
    public Queens2$qinv setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Queens2$qinv(RTObject$ SL$)
    { super(SL$); }
    public Queens2$qinv(RTObject$ SL$,int sp$i) {
        super(SL$);
        this.p$i = sp$i;
        BBLK();
        STM$();
    }
    public Queens2$qinv STM$() {
        Queens2$qinv THIS$=(Queens2$qinv)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                for(boolean CB$54:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(8); }})
                   )) { if(!CB$54) continue;
                if(VALUE$((((Queens2)(CUR$.SL$)).q.Elt[j-((Queens2)(CUR$.SL$)).q.LB[0]]==(p$i)))) {
                    GOTO$(EX);
                }
            }
            LABEL$(1,"EX");
            RESULT$=j;
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
public static PROGINFO$ INFO$=new PROGINFO$("Queens2.sim","Procedure qinv",1,52,11,55,13,53,39,54,47,55,63,56);
}
