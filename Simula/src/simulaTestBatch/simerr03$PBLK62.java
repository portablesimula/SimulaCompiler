package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Thu May 16 17:11:35 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr03$PBLK62 extends SeparatClass {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public simerr03$PBLK62(RTObject$ staticLink,int sp$i) {
        super(staticLink,sp$i);
    }
    public simerr03$PBLK62 STM$() {
        x=new SeparatClass$A(((simerr03$PBLK62)CUR$)).STM$();
        new SeparatClass$A$proc1(x);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr03.sim","PrefixedBlock simerr03$PBLK62",1,62,13,62,15,63,19,64);
}
