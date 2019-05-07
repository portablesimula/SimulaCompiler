package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 12:03:20 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst118 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    TXT$ t=null;
    int nA=0;
    int nB=0;
    simtst118$A x=null;
    simtst118$B y=null;
    public simtst118(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst118");
    }
    public RTObject$ STM$() {
        new simtst118$Print(((simtst118)CUR$),new TXT$("--- Test resume and detach."));
        nA=0;
        nB=0;
        new simtst118$Print(((simtst118)CUR$),new TXT$("Event 1: Just Before New A"));
        x=((simtst118$A)new simtst118$A(((simtst118)CUR$)).START$());
        new simtst118$Print(((simtst118)CUR$),new TXT$("Event 2: Just Before New B(1)"));
        y=((simtst118$B)new simtst118$B(((simtst118)CUR$)).START$());
        new simtst118$Print(((simtst118)CUR$),new TXT$("Event 1: Just Before New B(2)"));
        y=((simtst118$B)new simtst118$B(((simtst118)CUR$)).START$());
        x=null;
        x=((simtst118$A)new simtst118$A(((simtst118)CUR$)).START$());
        new simtst118$Print(((simtst118)CUR$),new TXT$("Event 1: Just Before Resume(y)"));
        resume(y);
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst118(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst118.sim","SimulaProgram simtst118",1,2,10,3,13,14,15,15,23,64,25,65,28,67,30,68,32,69,34,70,36,71,38,72,40,73,43,74,45,75,54,77);
}
