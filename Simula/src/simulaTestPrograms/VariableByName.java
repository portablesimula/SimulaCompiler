package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:07:26 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class VariableByName extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    double v=0.0d;
    double x=0.0d;
    TXT$ tt=null;
    TXT$ uu=null;
    TXT$ zz=null;
    VariableByName$A aa=null;
    VariableByName$A bb=null;
    public VariableByName(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("VariableByName");
    }
    public RTObject$ STM$() {
        v=((double)(4.0f));
        x=((double)(5.0f));
        new VariableByName$F(((VariableByName)CUR$),new NAME$<Boolean>(){ public Boolean get() { return(true); } },new NAME$<Double>(){ public Double get() { return(v); } public Double put(Double x$) { return(v=(double)x$); } });
        new VariableByName$F(((VariableByName)CUR$),new NAME$<Boolean>(){ public Boolean get() { return((x<(v))); } },new NAME$<Double>(){ public Double get() { return((x+(((double)(4.5f))))); } });
        new VariableByName$G(((VariableByName)CUR$),new NAME$<VariableByName$A>(){ public VariableByName$A get() { return(aa); } public VariableByName$A put(VariableByName$A x$) { return(aa=(VariableByName$A)x$); } },bb);
        new VariableByName$W(((VariableByName)CUR$),copy(tt),new NAME$<TXT$>(){ public TXT$ get() { return(uu); } public TXT$ put(TXT$ x$) { return(uu=(TXT$)x$); } },zz);
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new VariableByName(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VariableByName.sim","SimulaProgram VariableByName",1,3,10,4,12,5,16,6,25,27,27,28,29,29,31,30,33,32,35,34,44,36);
}
