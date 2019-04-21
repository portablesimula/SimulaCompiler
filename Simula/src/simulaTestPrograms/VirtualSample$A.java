package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:08:12 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class VirtualSample$A extends CLASS$ {
    public int prefixLevel() { return(0); }
    final LABQNT$ L1=new LABQNT$(this,1,"L1");
    final LABQNT$ L2=new LABQNT$(this,2,"L2");
    public float y=0.0f;
    public PRCQNT$ Q$0(){ throw new RuntimeException("No Virtual Match: Q"); }
    public PRCQNT$ P$0() { return(new PRCQNT$(this,VirtualSample$A$P.class)); }
    public VirtualSample$A(RTObject$ staticLink) {
        super(staticLink);
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("A",8);
    }
    public VirtualSample$A STM$() {
        VirtualSample$A THIS$=(VirtualSample$A)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                LABEL$(1,"L1");
                ((VirtualSample$A)CUR$).P$0().CPF().setPar(new NAME$<VirtualSample$B>(){ public VirtualSample$B get() { return(new VirtualSample$B(((VirtualSample)(CUR$.SL$))).STM$()); } }).setPar(new NAME$<Integer>(){ public Integer get() { return(11); } }).setPar(new NAME$<Float>(){ public Float get() { return(7.9f); } }).ENT$();
                LABEL$(2,"L2");
                ((VirtualSample$A)CUR$).Q$0().CPF().setPar(new NAME$<Float>(){ public Float get() { return((((VirtualSample)(CUR$.SL$)).x+(y))); } }).ENT$();
                GOTO$(new VirtualSample$A$S(((VirtualSample$A)CUR$),2).RESULT$);
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
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualSample.sim","Class A",1,4,8,11,10,12,12,7,26,11,29,12,32,13,34,11,48,14);
}
