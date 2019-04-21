package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:27:56 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class TQueens$p extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$r;
    public int p$c;
    public ARRAY$<?> p$q;
    public ARRAY$<?> p$u;
    public ARRAY$<?> p$d;
    private int $npar=0; // Number of actual parameters transmitted.
    public TQueens$p setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$r=intValue(param); break;
                case 1: p$c=intValue(param); break;
                case 2: p$q=arrayValue(param).COPY(); break;
                case 3: p$u=arrayValue(param).COPY(); break;
                case 4: p$d=arrayValue(param).COPY(); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public TQueens$p(RTObject$ SL$)
    { super(SL$); }
    public TQueens$p(RTObject$ SL$,int sp$r,int sp$c,ARRAY$<?> sp$q,ARRAY$<?> sp$u,ARRAY$<?> sp$d) {
        super(SL$);
        this.p$r = sp$r;
        this.p$c = sp$c;
        this.p$q = sp$q;
        this.p$u = sp$u;
        this.p$d = sp$d;
        BBLK();
        STM$();
    }
    public TQueens$p STM$() {
        if(VALUE$((((((ARRAY$<int[]>)p$q).Elt[p$c-p$q.LB[0]]+(((ARRAY$<int[]>)p$u).Elt[(p$r-(p$c))-p$u.LB[0]]))+(((ARRAY$<int[]>)p$d).Elt[(p$r+(p$c))-p$d.LB[0]]))==(0)))) {
            {
                ((ARRAY$<int[]>)p$q).Elt[p$c-p$q.LB[0]]=((ARRAY$<int[]>)p$u).Elt[(p$r-(p$c))-p$u.LB[0]]=((ARRAY$<int[]>)p$d).Elt[(p$r+(p$c))-p$d.LB[0]]=p$r;
                for(boolean CB$11:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){p$c=(int)x$; return(x$);};  public Number get(){return((Number)p$c); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(8); }})
                   )) { if(!CB$11) continue;
                if(VALUE$((p$r<(8)))) {
                    new TQueens$p(((TQueens)(CUR$.SL$)),(p$r+(1)),p$c,p$q.COPY(),p$u.COPY(),p$d.COPY());
                } else
                {
                    sysout().outchar(char$(((((ARRAY$<int[]>)p$q).Elt[p$c-p$q.LB[0]]+(rank('A')))-(1))));
                    sysout().outint(p$c,1);
                    sysout().outchar(((char)32));
                    if(VALUE$((p$c==(8)))) {
                        sysout().outimage();
                    }
                }
            }
        }
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("TQueens.sim","Procedure p",1,7,41,9,43,10,46,11,53,12,57,13,68,15);
}
