package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Apr 30 11:34:14 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class MultiAssignments extends BASICIO$ {
    public int prefixLevel() { return(0); }
    double r=0.0d;
    int n=0;
    public MultiAssignments(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("MultiAssignments");
    }
    public RTObject$ STM$() {
        new MultiAssignments$P(((MultiAssignments)CUR$),new TXT$("case 1"),new NAME$<Double>(){ public Double get() { return(r); } public Double put(Double x$) { return(r=(double)x$); } },((double)(3.14f)),new TXT$("Facit: X=3.0000, i=3, Y=3.1400, F=3.1400"));
        new MultiAssignments$P(((MultiAssignments)CUR$),new TXT$("case 1"),new NAME$<Double>(){ public Double get() { return(r); } public Double put(Double x$) { return(r=(double)x$); } },((double)(3.54f)),new TXT$("Facit: X=4.0000, i=4, Y=3.5400, F=3.5400"));
        new MultiAssignments$P(((MultiAssignments)CUR$),new TXT$("case 2"),new NAME$<Double>(){ public Double get() { return(((double)(n))); } public Double put(Double x$){ double y=x$; n=(int)Math.round(y);return(y); } },((double)(4.01f)),new TXT$("Facit: X=4.0000, i=4, Y=4.0100, F=4.0000"));
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new MultiAssignments(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("MultiAssignments.sim","SimulaProgram MultiAssignments",1,11,8,26,10,27,18,28,20,29,22,30,31,33);
}
