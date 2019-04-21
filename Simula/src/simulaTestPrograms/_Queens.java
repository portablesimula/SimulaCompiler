package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:25:47 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class _Queens extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    public _Queens(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("_Queens");
    }
    public RTObject$ STM$() {
        sysout().outtext(new TXT$(" A  B  C  D  E  F  G  H"));
        for(boolean CB$7:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(3); }},new NAME$<Number>() { public Number get(){return(3); }},new NAME$<Number>() { public Number get(){return(24); }})
           )) { if(!CB$7) continue;
        new _Queens$SubBlock8(CUR$).STM$();
    }
    EBLK();
    return(null);
}

public static void main(String[] args) {
    RT.setRuntimeOptions(args);
    new _Queens(CTX$).STM$();
}
public static PROGINFO$ INFO$=new PROGINFO$("8Queens.sim","SimulaProgram _Queens",1,6,16,7,20,18,30,19);
}
