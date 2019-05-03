package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 09:15:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Declarations extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final LABQNT$ L=new LABQNT$(this,1,"L");
    int I=0;
    public Declarations(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("Declarations");
    }
    public RTObject$ STM$() {
        Declarations THIS$=(Declarations)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                LABEL$(1,"L");
                new Declarations$P(((Declarations)CUR$),I,L,new PRCQNT$(((Declarations)CUR$),Declarations$OK.class));
                new Declarations$C(((Declarations)CUR$),I,L,new Declarations$OK(((Declarations)CUR$))).STM$();
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
        new Declarations(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Declarations.sim","SimulaProgram Declarations",1,1,9,11,11,1,23,11,26,12,46,14);
}
