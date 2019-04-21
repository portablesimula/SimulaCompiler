package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:31:17 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class JensensDevice extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    int j=0;
    int m=0;
    int n=0;
    public ARRAY$<double[]>A=null;
    double result=0.0d;
    public JensensDevice(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("JensensDevice");
        int[] A$LB=new int[1]; int[] A$UB=new int[1];
        A$LB[0]=0; A$UB[0]=99;
        BOUND_CHECK$(A$LB[0],A$UB[0]);
        A=new ARRAY$<double[]>(new double[A$UB[0]-A$LB[0]+1],A$LB,A$UB);
    }
    public RTObject$ STM$() {
        for(boolean CB$31:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(10); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(60); }})
           )) { if(!CB$31) continue;
        A.Elt[j-A.LB[0]]=((double)(j));
    }
    sysout().outtext(new TXT$("-------------------------------------------------------------------"));
    sysout().outimage();
    sysout().outtext(new TXT$("Sample Simula Program: Jensen's Device"));
    sysout().outimage();
    sysout().outtext(new TXT$("First call on 'Sum' - Expected result: Sum=1785"));
    sysout().outimage();
    result=new JensensDevice$Sum(((JensensDevice)CUR$),new NAME$<Integer>(){ public Integer get() { return(i); } public Integer put(Integer x$) { return(i=(int)x$); } },10,60,new NAME$<Double>(){ public Double get() { return(A.Elt[i-A.LB[0]]); } public Double put(Double x$) { return(A.Elt[i-A.LB[0]]=(double)x$); } }).RESULT$;
    sysout().outtext(new TXT$("-------------------------------------------------------------------"));
    sysout().outimage();
    sysout().outtext(new TXT$("End JensensDevice sample 1, Sum="));
    sysout().outint(((int)((int)Math.round(result))),6);
    sysout().outimage();
    sysout().outtext(new TXT$("-------------------------------------------------------------------"));
    sysout().outimage();
    sysout().outtext(new TXT$("Next line should be Runtime Error: Name Parameter is not a Variable"));
    sysout().outimage();
    sysout().outtext(new TXT$("-------------------------------------------------------------------"));
    sysout().outimage();
    result=new JensensDevice$Sum(((JensensDevice)CUR$),new NAME$<Integer>(){ public Integer get() { return((j+((m*(n))))); } },10,20,new NAME$<Double>(){ public Double get() { return(A.Elt[i-A.LB[0]]); } public Double put(Double x$) { return(A.Elt[i-A.LB[0]]=(double)x$); } }).RESULT$;
    EBLK();
    return(null);
}

public static void main(String[] args) {
    RT.setRuntimeOptions(args);
    new JensensDevice(CTX$).STM$();
}
public static PROGINFO$ INFO$=new PROGINFO$("JensensDevice.sim","SimulaProgram JensensDevice",1,10,8,27,10,28,14,29,16,30,22,29,29,31,35,33,38,34,41,35,44,36,46,37,49,38,53,40,56,41,59,42,62,43,71,45);
}
