package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Apr 13 09:06:30 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst98$outerout extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public simtst98$outerout(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public simtst98$outerout STM$() {
        new simtst98$outattr(((simtst98)(CUR$.SL$)),309,new TXT$("outer: i="),((simtst98)(CUR$.SL$)).i,((simtst98)(CUR$.SL$)).globali);
        new simtst98$outattr(((simtst98)(CUR$.SL$)),310,new TXT$("       j="),((simtst98)(CUR$.SL$)).j,((simtst98)(CUR$.SL$)).globalj);
        new simtst98$outattr(((simtst98)(CUR$.SL$)),311,new TXT$("       k="),((simtst98)(CUR$.SL$)).k,((simtst98)(CUR$.SL$)).globalk);
        new simtst98$outim(((simtst98)(CUR$.SL$)));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst98.sim","Procedure outerout",1,308,14,309,16,310,18,311,23,312);
}
