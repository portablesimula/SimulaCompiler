package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri Apr 26 11:57:49 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HexDump$InByte extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public HexDump$InByte(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public HexDump$InByte STM$() {
        RESULT$=((HexDump)(CUR$.SL$)).Inpt.inbyte();
        ((HexDump)(CUR$.SL$)).Sequ=(((HexDump)(CUR$.SL$)).Sequ+(1));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HexDump.sim","Procedure InByte",1,34,16,35,21,35);
}
