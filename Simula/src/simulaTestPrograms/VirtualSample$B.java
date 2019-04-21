package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:08:12 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class VirtualSample$B extends VirtualSample$A {
    public int prefixLevel() { return(1); }
    public PRCQNT$ P$0() { return(new PRCQNT$(this,VirtualSample$B$P.class)); }
    public PRCQNT$ Q$0() { return(new PRCQNT$(this,VirtualSample$B$Q.class)); }
    public VirtualSample$B(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("B",21);
    }
    public VirtualSample$B STM$() {
        VirtualSample$B THIS$=(VirtualSample$B)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                LABEL$(1,"L1");
                ((VirtualSample$A)CUR$).P$0().CPF().setPar(new NAME$<VirtualSample$B>(){ public VirtualSample$B get() { return(new VirtualSample$B(((VirtualSample)(CUR$.SL$))).STM$()); } }).setPar(new NAME$<Integer>(){ public Integer get() { return(11); } }).setPar(new NAME$<Float>(){ public Float get() { return(7.9f); } }).ENT$();
                LABEL$(2,"L2");
                ((VirtualSample$A)CUR$).Q$0().CPF().setPar(new NAME$<Float>(){ public Float get() { return((((VirtualSample)(CUR$.SL$)).x+(y))); } }).ENT$();
                GOTO$(new VirtualSample$A$S(((VirtualSample$A)CUR$),2).RESULT$);
                GOTO$(new VirtualSample$B$T(((VirtualSample$B)CUR$),2).RESULT$);
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
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualSample.sim","Class B",1,16,19,11,22,12,25,13,41,23);
}
