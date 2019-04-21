package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:26:04 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Queens extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    public Queens(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("Queens");
    }
    public RTObject$ STM$() {
        sysout().outtext(new TXT$(" A  B  C  D  E  F  G  H"));
        for(boolean CB$7:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(3); }},new NAME$<Number>() { public Number get(){return(3); }},new NAME$<Number>() { public Number get(){return(24); }})
           )) { if(!CB$7) continue;
        new Queens$SubBlock8(CUR$).STM$();
    }
    EBLK();
    return(null);
}

public static void main(String[] args) {
    RT.setRuntimeOptions(args);
    new Queens(CTX$).STM$();
}
public static PROGINFO$ INFO$=new PROGINFO$("Queens.sim","SimulaProgram Queens",1,6,16,7,20,18,30,19);
}
