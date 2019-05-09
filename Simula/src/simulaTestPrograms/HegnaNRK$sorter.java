package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$sorter extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public ARRAY$<?> p$tabell;
    public ARRAY$<?> p$key;
    public int p$antall;
    final LABQNT$ overogut=new LABQNT$(this,1,"overogut");
    final LABQNT$ igjen=new LABQNT$(this,2,"igjen");
    public ARRAY$<int[]>hs=null;
    int t=0;
    int j=0;
    int h=0;
    int i=0;
    int l=0;
    int h1=0;
    int n=0;
    boolean bool=false;
    HegnaNRK$verdi k=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$sorter setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$tabell=arrayValue(param); break;
                case 1: p$key=arrayValue(param); break;
                case 2: p$antall=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$sorter(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$sorter(RTObject$ SL$,ARRAY$<?> sp$tabell,ARRAY$<?> sp$key,int sp$antall) {
        super(SL$);
        this.p$tabell = sp$tabell;
        this.p$key = sp$key;
        this.p$antall = sp$antall;
        BBLK();
        int[] hs$LB=new int[1]; int[] hs$UB=new int[1];
        hs$LB[0]=1; hs$UB[0]=7;
        BOUND_CHECK$(hs$LB[0],hs$UB[0]);
        hs=new ARRAY$<int[]>(new int[hs$UB[0]-hs$LB[0]+1],hs$LB,hs$UB);
        STM$();
    }
    public HegnaNRK$sorter STM$() {
        HegnaNRK$sorter THIS$=(HegnaNRK$sorter)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                i=1;
                for(boolean CB$1406:new ForList(
                    new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }})
                   ,new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(4); }})
                   ,new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(13); }})
                   ,new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(40); }})
                   ,new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(121); }})
                   ,new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(364); }})
                   ,new SingleElt<Number>(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1093); }})
                   )) { if(!CB$1406) continue;
                {
                    hs.Elt[i-hs.LB[0]]=j;
                    i=(i+(1));
                }
            }
            for(boolean CB$1411:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(2); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(7); }})
               )) { if(!CB$1411) continue;
            if(VALUE$((hs.Elt[i-hs.LB[0]]>(p$antall)))) {
                GOTO$(overogut);
            }
        }
        i=8;
        LABEL$(1,"overogut");
        t=(i-(1));
        for(boolean CB$1416:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){l=(int)x$; return(x$);};  public Number get(){return((Number)l); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(t); }})
           )) { if(!CB$1416) continue;
        {
            h=hs.Elt[((t+(1))-(l))-hs.LB[0]];
            h1=(h+(1));
            for(boolean CB$1420:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(h1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(p$antall); }})
               )) { if(!CB$1420) continue;
            {
                i=(j-(h));
                k=((ARRAY$<HegnaNRK$verdi[]>)p$key).Elt[j-p$key.LB[0]];
                n=((ARRAY$<int[]>)p$tabell).Elt[j-p$tabell.LB[0]];
                LABEL$(2,"igjen");
                if(VALUE$((k==(null)))) {
                    bool=true;
                } else
                bool=((boolean)(k.test_verdi_mindre$0().CPF().setPar(new NAME$<HegnaNRK$verdi>(){ public HegnaNRK$verdi get() { return(((ARRAY$<HegnaNRK$verdi[]>)p$key).Elt[i-p$key.LB[0]]); } public HegnaNRK$verdi put(HegnaNRK$verdi x$) { return(((ARRAY$<HegnaNRK$verdi[]>)p$key).Elt[i-p$key.LB[0]]=(HegnaNRK$verdi)x$); } }).ENT$().RESULT$()));
                if(VALUE$(bool)) {
                    {
                        ((ARRAY$<HegnaNRK$verdi[]>)p$key).Elt[(i+(h))-p$key.LB[0]]=((ARRAY$<HegnaNRK$verdi[]>)p$key).Elt[i-p$key.LB[0]];
                        ((ARRAY$<int[]>)p$tabell).Elt[(i+(h))-p$tabell.LB[0]]=((ARRAY$<int[]>)p$tabell).Elt[i-p$tabell.LB[0]];
                        i=(i-(h));
                        if(VALUE$((i>(0)))) {
                            GOTO$(igjen);
                        }
                    }
                }
                ((ARRAY$<HegnaNRK$verdi[]>)p$key).Elt[(i+(h))-p$key.LB[0]]=k;
                ((ARRAY$<int[]>)p$tabell).Elt[(i+(h))-p$tabell.LB[0]]=n;
            }
        }
    }
}
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
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure sorter",1,1396,11,1415,13,1425,15,1402,17,1403,26,1404,49,1402,61,1405,63,1406,73,1408,76,1409,80,1411,84,1412,89,1413,91,1415,94,1416,98,1418,101,1419,103,1420,107,1422,110,1423,112,1424,114,1426,116,1425,120,1426,122,1427,124,1429,127,1430,129,1431,131,1432,137,1434,139,1435,158,1438);
}
