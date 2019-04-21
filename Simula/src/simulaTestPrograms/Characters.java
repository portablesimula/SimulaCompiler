package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:26:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Characters extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    public Characters(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("Characters");
    }
    public RTObject$ STM$() {
        for(boolean CB$4:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(128); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(256); }})
           )) { if(!CB$4) continue;
        {
            sysout().outtext(new TXT$("   Character #"));
            sysout().outint(i,0);
            sysout().outtext(new TXT$(" = '"));
            sysout().outchar(char$(i));
            sysout().outtext(new TXT$("'"));
            sysout().outimage();
        }
    }
    EBLK();
    return(null);
}

public static void main(String[] args) {
    RT.setRuntimeOptions(args);
    new Characters(CTX$).STM$();
}
public static PROGINFO$ INFO$=new PROGINFO$("Characters.sim","SimulaProgram Characters",1,3,15,4,19,6,23,7,27,8,38,10);
}
