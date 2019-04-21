package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:08:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class VirtualLabel3$ENTITY$REPEAT extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public VirtualLabel3$ENTITY$REPEAT(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public VirtualLabel3$ENTITY$REPEAT STM$() {
        ((VirtualLabel3$ENTITY)(CUR$.SL$)).CYCLE=(((VirtualLabel3$ENTITY)(CUR$.SL$)).CYCLE+(1));
        GOTO$(((VirtualLabel3$ENTITY)(CUR$.SL$)).LOOP$0());
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("VirtualLabel3.sim","Procedure REPEAT",1,10,14,11,16,12,20,13);
}
