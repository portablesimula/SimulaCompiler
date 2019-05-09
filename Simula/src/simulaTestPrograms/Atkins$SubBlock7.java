package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed May 08 17:47:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Atkins$SubBlock7 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public ARRAY$<boolean[]>bArray=null;
    int k=0;
    int n=0;
    int n2=0;
    int x=0;
    int y=0;
    int s=0;
    double t=0.0d;
    public Atkins$SubBlock7(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        int[] bArray$LB=new int[1]; int[] bArray$UB=new int[1];
        bArray$LB[0]=0; bArray$UB[0]=((Atkins)(CUR$.SL$)).MAX;
        BOUND_CHECK$(bArray$LB[0],bArray$UB[0]);
        bArray=new ARRAY$<boolean[]>(new boolean[bArray$UB[0]-bArray$LB[0]+1],bArray$LB,bArray$UB);
    }
    public RTObject$ STM$() {
        t=cputime();
        for(boolean CB$11:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){x=(int)x$; return(x$);};  public Number get(){return((Number)x); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((Atkins)(CUR$.SL$)).SQRT_MAX); }})
           )) { if(!CB$11) continue;
        for(boolean CB$12:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){y=(int)x$; return(x$);};  public Number get(){return((Number)y); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((Atkins)(CUR$.SL$)).SQRT_MAX); }})
           )) { if(!CB$12) continue;
        {
            k=(((4*(x))*(x))+((y*(y))));
            if(VALUE$(((k<(((Atkins)(CUR$.SL$)).MAX))&(((mod(k,12)==(1))|((mod(k,12)==(5)))))))) {
                bArray.Elt[k-bArray.LB[0]]=(!(bArray.Elt[k-bArray.LB[0]]));
            }
            k=(((3*(x))*(x))+((y*(y))));
            if(VALUE$(((k<(((Atkins)(CUR$.SL$)).MAX))&((mod(k,12)==(7)))))) {
                bArray.Elt[k-bArray.LB[0]]=(!(bArray.Elt[k-bArray.LB[0]]));
            }
            if(VALUE$((x>(y)))) {
                {
                    k=(((3*(x))*(x))-((y*(y))));
                    if(VALUE$(((k<(((Atkins)(CUR$.SL$)).MAX))&((mod(k,12)==(11)))))) {
                        bArray.Elt[k-bArray.LB[0]]=(!(bArray.Elt[k-bArray.LB[0]]));
                    }
                }
            }
        }
    }
}
bArray.Elt[2-bArray.LB[0]]=bArray.Elt[3-bArray.LB[0]]=true;
for(boolean CB$28:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){n=(int)x$; return(x$);};  public Number get(){return((Number)n); }	},new NAME$<Number>() { public Number get(){return(5); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return((((Atkins)(CUR$.SL$)).SQRT_MAX+(1))); }})
   )) { if(!CB$28) continue;
if(VALUE$(bArray.Elt[n-bArray.LB[0]])) {
    {
        n2=(n*(n));
        for(boolean CB$31:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){k=(int)x$; return(x$);};  public Number get(){return((Number)k); }	},new NAME$<Number>() { public Number get(){return(n2); }},new NAME$<Number>() { public Number get(){return(n2); }},new NAME$<Number>() { public Number get(){return(((Atkins)(CUR$.SL$)).MAX); }})
           )) { if(!CB$31) continue;
        {
            if(VALUE$(((k<(4))|((k>((((Atkins)(CUR$.SL$)).MAX-(4)))))))) {
                {
                    sysout().outtext(new TXT$("n="));
                    sysout().outint(n,0);
                    sysout().outtext(new TXT$(", n2="));
                    sysout().outint(n2,0);
                    sysout().outtext(new TXT$(", k="));
                    sysout().outint(k,0);
                    sysout().outimage();
                }
            }
            bArray.Elt[k-bArray.LB[0]]=false;
        }
    }
}
}
}
for(boolean CB$43:new ForList(
    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){k=(int)x$; return(x$);};  public Number get(){return((Number)k); }	},new NAME$<Number>() { public Number get(){return(0); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((Atkins)(CUR$.SL$)).MAX); }})
   )) { if(!CB$43) continue;
if(VALUE$(bArray.Elt[k-bArray.LB[0]])) {
s=(s+(1));
}
}
sysout().outint(s,7);
sysout().outtext(new TXT$(" primes, according to Atkin."));
sysout().outimage();
sysout().outimage();
sysout().outtext(new TXT$(" CPU time used :"));
sysout().outfix((cputime()-(t)),4,7);
sysout().outtext(new TXT$(" sec."));
EBLK();
return(null);
}
public static PROGINFO$ INFO$=new PROGINFO$("Atkins.sim","SubBlock SubBlock7",1,7,9,8,20,7,27,10,29,11,33,12,37,13,40,14,42,15,45,16,47,17,49,18,52,19,54,20,57,21,59,22,67,26,69,28,73,29,75,30,78,31,82,33,85,35,89,36,92,37,98,39,105,43,109,44,111,45,115,47,120,48,126,49);
}
