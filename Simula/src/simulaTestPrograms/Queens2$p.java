package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:26:23 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Queens2$p extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$r;
    public int p$c;
    public ARRAY$<?> p$q;
    public ARRAY$<?> p$u;
    public ARRAY$<?> p$d;
    private int $npar=0; // Number of actual parameters transmitted.
    public Queens2$p setPar(Object param) {
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
    public Queens2$p(RTObject$ SL$)
    { super(SL$); }
    public Queens2$p(RTObject$ SL$,int sp$r,int sp$c,ARRAY$<?> sp$q,ARRAY$<?> sp$u,ARRAY$<?> sp$d) {
        super(SL$);
        this.p$r = sp$r;
        this.p$c = sp$c;
        this.p$q = sp$q;
        this.p$u = sp$u;
        this.p$d = sp$d;
        BBLK();
        STM$();
    }
    public Queens2$p STM$() {
        if(VALUE$((((((ARRAY$<int[]>)p$q).Elt[p$c-p$q.LB[0]]+(((ARRAY$<int[]>)p$u).Elt[(p$r-(p$c))-p$u.LB[0]]))+(((ARRAY$<int[]>)p$d).Elt[(p$r+(p$c))-p$d.LB[0]]))==(0)))) {
            {
                ((ARRAY$<int[]>)p$q).Elt[p$c-p$q.LB[0]]=((ARRAY$<int[]>)p$u).Elt[(p$r-(p$c))-p$u.LB[0]]=((ARRAY$<int[]>)p$d).Elt[(p$r+(p$c))-p$d.LB[0]]=p$r;
                for(boolean CB$80:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){p$c=(int)x$; return(x$);};  public Number get(){return((Number)p$c); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(8); }})
                   )) { if(!CB$80) continue;
                if(VALUE$((p$r<(8)))) {
                    new Queens2$p(((Queens2)(CUR$.SL$)),(p$r+(1)),p$c,p$q.COPY(),p$u.COPY(),p$d.COPY());
                } else
                {
                    if(VALUE$((p$c==(1)))) {
                        new Queens2$ClearBoard(((Queens2)(CUR$.SL$)));
                    }
                    if(VALUE$((((Queens2)(CUR$.SL$)).nochk||((!(new Queens2$Exclude(((Queens2)(CUR$.SL$)),p$q.COPY()).RESULT$)))))) {
                    } else
                    {
                        new Queens2$Setpos(((Queens2)(CUR$.SL$)),(4+((2*(p$c)))),(21+((4*(((ARRAY$<int[]>)p$q).Elt[p$c-p$q.LB[0]])))));
                        sysout().outchar('*');
                        sysout().breakoutimage();
                        if(VALUE$((p$c==(8)))) {
                            {
                                ((Queens2)(CUR$.SL$)).nr=(((Queens2)(CUR$.SL$)).nr+(1));
                                new Queens2$Setpos(((Queens2)(CUR$.SL$)),24,23);
                                sysout().outtext(new TXT$("Number: "));
                                sysout().outint(((Queens2)(CUR$.SL$)).nr,0);
                                new Queens2$Setpos(((Queens2)(CUR$.SL$)),24,45);
                                sysout().outtext(new TXT$("More? "));
                                sysout().breakoutimage();
                                if(VALUE$((!(((Queens2)(CUR$.SL$)).all)))) {
                                    {
                                        sysin().inimage();
                                        ((Queens2)(CUR$.SL$)).ch=sysin().inchar();
                                        if(VALUE$((((Queens2)(CUR$.SL$)).ch==('a')))) {
                                            ((Queens2)(CUR$.SL$)).all=true;
                                        } else
                                        if(VALUE$((rank(((Queens2)(CUR$.SL$)).ch)>(32)))) {
                                            GOTO$(((Queens2)(CUR$.SL$)).EXIT);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("Queens2.sim","Procedure p",1,76,41,78,43,79,46,80,53,81,58,82,61,83,66,84,68,85,71,86,75,87,78,88,80,89,82,90,86,91,90,92,105,94);
}
