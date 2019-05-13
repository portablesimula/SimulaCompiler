package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun May 12 15:12:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SubSep$PP extends BASICIO$ {
    public int prefixLevel() { return(0); }
    int i=0;
    SubSep$PP$SubSep2 xx=null;
    public SubSep$PP(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public SubSep$PP STM$() {
        xx=new SubSep$PP$SubSep2(((SubSep$PP)CUR$),15).STM$();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ExternalClass2.sim","Procedure PP",1,7,8,8,10,9,18,16,22,17);
}
