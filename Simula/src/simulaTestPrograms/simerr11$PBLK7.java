package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:18:13 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simerr11$PBLK7 extends SeparatClass {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    public simerr11$PBLK7(RTObject$ staticLink,int sp$i) {
        super(staticLink,sp$i);
    }
    public simerr11$PBLK7 STM$() {
        x=new SeparatClass$A(((simerr11$PBLK7)CUR$)).STM$();
        new SeparatClass$A$proc1(x);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simerr11.sim","PrefixedBlock simerr11$PBLK7",1,7,13,7,15,8,19,10);
}
