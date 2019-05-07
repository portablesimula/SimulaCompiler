package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 12:03:18 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst117 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    simtst117$A x=null;
    simtst117$A y=null;
    public simtst117(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst117");
    }
    public RTObject$ STM$() {
        new simtst117$Print(((simtst117)CUR$),new TXT$("--------------------------------------"));
        new simtst117$Print(((simtst117)CUR$),new TXT$("--- Test resume and detach."));
        new simtst117$Print(((simtst117)CUR$),new TXT$("--------------------------------------"));
        new simtst117$Print(((simtst117)CUR$),new TXT$("Expected Output:"));
        new simtst117$Print(((simtst117)CUR$),new TXT$("--------------------------------------"));
        new simtst117$Print(((simtst117)CUR$),new TXT$("Event 1: Just Before x:-New A"));
        new simtst117$Print(((simtst117)CUR$),new TXT$("Event A(x)-1: Just Before First Detach"));
        new simtst117$Print(((simtst117)CUR$),new TXT$("Event 2: Just Before y:-New A"));
        new simtst117$Print(((simtst117)CUR$),new TXT$("Event A(y)-1: Just Before First Detach"));
        new simtst117$Print(((simtst117)CUR$),new TXT$("Event 3: Just Before first Resume(x)"));
        new simtst117$Print(((simtst117)CUR$),new TXT$("Event A(x)-2: Just Before Second Detach"));
        new simtst117$Print(((simtst117)CUR$),new TXT$("Event 4: Just Before second Resume(x)"));
        new simtst117$Print(((simtst117)CUR$),new TXT$("Event A(x)-3: Just Before Resume(y)"));
        new simtst117$Print(((simtst117)CUR$),new TXT$("Event A(y)-2: Just Before Second Detach"));
        new simtst117$Print(((simtst117)CUR$),new TXT$("Event x: Just Before final END"));
        new simtst117$Print(((simtst117)CUR$),new TXT$("--------------------------------------"));
        new simtst117$Print(((simtst117)CUR$),new TXT$("Actual Output:"));
        new simtst117$Print(((simtst117)CUR$),new TXT$("--------------------------------------"));
        new simtst117$Print(((simtst117)CUR$),new TXT$("Event 1: Just Before x:-New A"));
        x=((simtst117$A)new simtst117$A(((simtst117)CUR$),new TXT$("x")).START$());
        new simtst117$Print(((simtst117)CUR$),new TXT$("Event 2: Just Before y:-New A"));
        y=((simtst117$A)new simtst117$A(((simtst117)CUR$),new TXT$("y")).START$());
        new simtst117$Print(((simtst117)CUR$),new TXT$("Event 3: Just Before first Resume(x)"));
        resume(x);
        new simtst117$Print(((simtst117)CUR$),new TXT$("Event 4: Just Before second Resume(x)"));
        resume(x);
        new simtst117$Print(((simtst117)CUR$),new TXT$("Event x: Just Before final END"));
        new simtst117$Print(((simtst117)CUR$),new TXT$("--------------------------------------"));
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst117(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst117.sim","SimulaProgram simtst117",1,3,9,6,18,22,20,23,22,24,24,25,26,26,28,27,30,28,32,29,34,30,36,31,38,32,40,33,42,34,44,35,46,36,48,37,50,38,52,39,54,43,56,44,58,45,60,46,62,47,64,48,66,49,68,50,70,51,72,52,81,54);
}
