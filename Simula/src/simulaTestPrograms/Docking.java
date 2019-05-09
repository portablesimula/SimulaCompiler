package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:12:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking extends Drawing$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final boolean DEBUG$2=(boolean)(false);
    final boolean verbose$2=(boolean)(false);
    int cnt$2=0;
    int U1$2=0;
    int U2$2=0;
    public Docking(RTObject$ staticLink,TXT$ sp1$Title,int sp1$width,int sp1$height) {
        super(staticLink,sp1$Title,sp1$width,sp1$height);
        BPRG("Docking");
    }
    public Docking STM$() {
        U1$2=455470314;
        U2$2=950423827;
        for(boolean CB$235:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){cnt$2=(int)x$; return(x$);};  public Number get(){return((Number)cnt$2); }	},new NAME$<Number>() { public Number get(){return(2); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(6); }})
           )) { if(!CB$235) continue;
        new Docking$PBLK237(CUR$,cnt$2).START$();
    }
    sysout().outtext(new TXT$("End of Simulation"));
    sysout().outimage();
    while(true) {
        {
        }
        if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
    }
    EBLK();
    return(this);
}

public static void main(String[] args) {
    RT.setRuntimeOptions(args);
    new Docking(CTX$,new TXT$("Warehouse Simulation"),500,300).STM$();
}
public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","PrefixedBlock Docking",1,12,10,13,12,225,14,227,22,233,25,235,29,239,31,238,33,240,36,242,49,244);
}
