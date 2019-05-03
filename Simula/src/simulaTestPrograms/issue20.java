package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 11:14:51 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue20 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final LABQNT$ L=new LABQNT$(this,1,"L");
    int I=0;
    public issue20(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("issue20");
    }
    public RTObject$ STM$() {
        issue20 THIS$=(issue20)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                LABEL$(1,"L");
                new issue20$P(((issue20)CUR$),I,L,new PRCQNT$(((issue20)CUR$),issue20$OK.class));
                new issue20$C(((issue20)CUR$),I,L,new issue20$OK(((issue20)CUR$))).STM$();
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
        new issue20(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("issue20.sim","SimulaProgram issue20",1,1,9,11,11,1,23,11,26,12,46,14);
}
