// JavaLine 1 ==> SourceLine 10
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:32:05 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class JensensDevice extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=10, lastLine=45, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    // JavaLine 10 ==> SourceLine 27
    int i=0;
    // JavaLine 12 ==> SourceLine 28
    int j=0;
    int m=0;
    int n=0;
    // JavaLine 16 ==> SourceLine 29
    public ARRAY$<double[]>A=null;
    // JavaLine 18 ==> SourceLine 30
    double result=0.0d;
    // Normal Constructor
    public JensensDevice(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("JensensDevice");
        // Declaration Code
        TRACE_BEGIN_DCL$("JensensDevice",30);
        // JavaLine 27 ==> SourceLine 29
        int[] A$LB=new int[1]; int[] A$UB=new int[1];
        A$LB[0]=0; A$UB[0]=99;
        BOUND_CHECK$(A$LB[0],A$UB[0]);
        A=new ARRAY$<double[]>(new double[A$UB[0]-A$LB[0]+1],A$LB,A$UB);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("JensensDevice",29);
        // JavaLine 36 ==> SourceLine 31
        for(boolean CB$31:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(10); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(60); }})
           )) { if(!CB$31) continue;
        A.Elt[j-A.LB[0]]=((double)(j));
    }
    // JavaLine 42 ==> SourceLine 33
    sysout().outtext(new TXT$("-------------------------------------------------------------------"));
    sysout().outimage();
    // JavaLine 45 ==> SourceLine 34
    sysout().outtext(new TXT$("Sample Simula Program: Jensen's Device"));
    sysout().outimage();
    // JavaLine 48 ==> SourceLine 35
    sysout().outtext(new TXT$("First call on 'Sum' - Expected result: Sum=1785"));
    sysout().outimage();
    // JavaLine 51 ==> SourceLine 36
    result=new JensensDevice$Sum(((JensensDevice)CUR$),new NAME$<Integer>(){ public Integer get() { return(i); } public Integer put(Integer x$) { return(i=(int)x$); } },10,60,new NAME$<Double>(){ public Double get() { return(A.Elt[i-A.LB[0]]); } public Double put(Double x$) { return(A.Elt[i-A.LB[0]]=(double)x$); } }).RESULT$;
    // JavaLine 53 ==> SourceLine 37
    sysout().outtext(new TXT$("-------------------------------------------------------------------"));
    sysout().outimage();
    // JavaLine 56 ==> SourceLine 38
    sysout().outtext(new TXT$("End JensensDevice sample 1, Sum="));
    sysout().outint(((int)((int)Math.round(result))),6);
    sysout().outimage();
    // JavaLine 60 ==> SourceLine 40
    sysout().outtext(new TXT$("-------------------------------------------------------------------"));
    sysout().outimage();
    // JavaLine 63 ==> SourceLine 41
    sysout().outtext(new TXT$("Next line should be Runtime Error: Name Parameter is not a Variable"));
    sysout().outimage();
    // JavaLine 66 ==> SourceLine 42
    sysout().outtext(new TXT$("-------------------------------------------------------------------"));
    sysout().outimage();
    // JavaLine 69 ==> SourceLine 43
    result=new JensensDevice$Sum(((JensensDevice)CUR$),new NAME$<Integer>(){ public Integer get() { return((j+((m*(n))))); } },10,20,new NAME$<Double>(){ public Double get() { return(A.Elt[i-A.LB[0]]); } public Double put(Double x$) { return(A.Elt[i-A.LB[0]]=(double)x$); } }).RESULT$;
    TRACE_END_STM$("JensensDevice",43);
    EBLK();
    return(null);
} // End of SimulaProgram Statements

public static void main(String[] args) {
    //System.setProperty("file.encoding","UTF-8");
    RT.setRuntimeOptions(args);
    new JensensDevice(CTX$).STM$();
}
public static PROGINFO$ INFO$=new PROGINFO$("JensensDevice.sim","SimulaProgram JensensDevice",1,10,10,27,12,28,16,29,18,30,27,29,36,31,42,33,45,34,48,35,51,36,53,37,56,38,60,40,63,41,66,42,69,43,80,45);
}
