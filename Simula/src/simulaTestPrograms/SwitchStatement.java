package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:06:03 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SwitchStatement extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final LABQNT$ BREAK$=new LABQNT$(this,1,"BREAK$");
    final int lowKey=(int)(0);
    final int hiKey=(int)(5);
    final int case1=(int)(1);
    final int case2=(int)(2);
    int key=0;
    public SwitchStatement(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("SwitchStatement");
    }
    public RTObject$ STM$() {
        SwitchStatement THIS$=(SwitchStatement)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                key=2;
                {
                    switch(key) { // BEGIN SWITCH STATEMENT
                    case 1: 
                    {
                        GOTO$(BREAK$);
                    }
                    case 2: 
                    {
                        GOTO$(BREAK$);
                    }
                    case 3: 
                    {
                        GOTO$(BREAK$);
                    }
                    default:
                } // END SWITCH STATEMENT
                LABEL$(1,"BREAK$");
            }
            break LOOP$;
        }
        catch(LABQNT$ q) {
            CUR$=THIS$;
            if(q.SL$!=CUR$) {
                CUR$.STATE$=OperationalState.terminated;
                throw(q);
            }
            JTX$=q.index; continue LOOP$;
        }
    }
    EBLK();
    return(null);
}

public static void main(String[] args) {
    RT.setRuntimeOptions(args);
    new SwitchStatement(CTX$).STM$();
}
public static PROGINFO$ INFO$=new PROGINFO$("SwitchStatement.sim","SimulaProgram SwitchStatement",1,2,8,31,10,2,12,3,14,4,16,5,18,6,30,8,32,10,36,14,41,19,46,24,52,31,73,32);
}
