package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Tue Apr 30 12:21:21 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst105 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final boolean verbose=(boolean)(false);
    boolean found_error=false;
    double r=0.0d;
    int n=0;
    TXT$ result=null;
    public simtst105(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst105");
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START SIMULA TEST 105"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Multiple Assignments"));
                sysout().outimage();
                sysout().outimage();
            }
        }
        new simtst105$P(((simtst105)CUR$),new TXT$("case 1"),new NAME$<Double>(){ public Double get() { return(r); } public Double put(Double x$) { return(r=(double)x$); } },((double)(3.14f)),new TXT$("Facit: X=3.0000, i=3, Y=3.1400, F=3.1400"));
        new simtst105$P(((simtst105)CUR$),new TXT$("case 2"),new NAME$<Double>(){ public Double get() { return(((double)(n))); } public Double put(Double x$){ double y=x$; n=(int)Math.round(y);return(y); } },((double)(3.14f)),new TXT$("Facit: X=3.0000, i=3, Y=3.1400, F=3.0000"));
        new simtst105$P(((simtst105)CUR$),new TXT$("case 3"),new NAME$<Double>(){ public Double get() { return(r); } public Double put(Double x$) { return(r=(double)x$); } },((double)(3.54f)),new TXT$("Facit: X=4.0000, i=4, Y=3.5400, F=3.5400"));
        new simtst105$P(((simtst105)CUR$),new TXT$("case 4"),new NAME$<Double>(){ public Double get() { return(((double)(n))); } public Double put(Double x$){ double y=x$; n=(int)Math.round(y);return(y); } },((double)(4.01f)),new TXT$("Facit: X=4.0000, i=4, Y=4.0100, F=4.0000"));
        if(VALUE$(found_error)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 105"));
        }
        if(VALUE$(verbose)) {
            {
                sysout().outimage();
                sysout().outtext(new TXT$("--- END SIMULA TEST 105"));
                sysout().outimage();
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst105(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst105.sim","SimulaProgram simtst105",1,16,9,17,11,19,13,20,15,21,23,51,25,52,29,53,31,54,36,57,38,58,40,59,42,60,44,63,47,66,51,69,53,70,56,71,58,72,69,74);
}
