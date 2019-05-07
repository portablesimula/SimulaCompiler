package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 16:21:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst116$P extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public simtst116$P(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst116$P STM$() {
        ((simtst116)(CUR$.SL$)).x=((simtst116$C)new simtst116$C(((simtst116)(CUR$.SL$))).START$());
        new simtst116$trace(((simtst116)(CUR$.SL$)),new TXT$("In Procedure P - Just Before first Resume(x)"));
        resume(((simtst116)(CUR$.SL$)).x);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst116.sim","Procedure P",1,28,14,30,16,32,18,33,22,34);
}
