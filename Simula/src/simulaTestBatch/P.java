package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon May 06 14:57:46 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class P extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public P(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public P STM$() {
        ((simtst116)(CUR$.SL$)).x=((C)new C(((simtst116)(CUR$.SL$))).START$());
        new trace(((simtst116)(CUR$.SL$)),new TXT$("In Procedure P - Just Before first Resume(x)"));
        resume(((simtst116)(CUR$.SL$)).x);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst116.sim","Procedure P",1,33,14,35,16,37,18,38,22,39);
}
