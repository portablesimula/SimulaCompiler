package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 22 12:24:09 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst76$PBLK69 extends Simset$ {
    public boolean isQPSystemBlock() { return(true); }
    simtst76$$simtst76$PBLK69$A x$1=null;
    public simtst76$PBLK69(RTObject$ staticLink) {
        super(staticLink);
    }
    public simtst76$PBLK69 STM$() {
        x$1=((simtst76$$simtst76$PBLK69$A)new simtst76$$simtst76$PBLK69$A(((simtst76$PBLK69)(CUR$))).START$());
        new simtst76$$Print(((simtst76$)(CUR$.SL$)),copy(new TXT$("B")));
        resume(x$1);
        new simtst76$$Print(((simtst76$)(CUR$.SL$)),copy(new TXT$("G")));
        resume(x$1);
        new simtst76$$Print(((simtst76$)(CUR$.SL$)),copy(new TXT$("K")));
        resume(x$1);
        new simtst76$$Print(((simtst76$)(CUR$.SL$)),copy(new TXT$("M")));
        ((simtst76$)(CUR$.SL$)).t=copy(copy(TXT$.strip(sysout().image)));
        sysout().setpos(1);
        ASGTXT$(sysout().image,null);
        if(VALUE$(TXTREL$EQ(((simtst76$)(CUR$.SL$)).t,new TXT$("ABCDEFGHIJKLM")))) {
        } else
        {
            sysout().outtext(new TXT$("*** error : Detach - resume (2)."));
            sysout().outimage();
            sysout().outtext(new TXT$("             Erroneus sequencing: "));
            sysout().outtext(((simtst76$)(CUR$.SL$)).t);
            sysout().outimage();
            sysout().outimage();
            ((simtst76$)(CUR$.SL$)).found_error=true;
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst76.sim","PrefixedBlock simtst76$PBLK69",1,69,13,94,15,95,18,96,21,97,24,98,26,102,28,103,30,104,32,107,35,109,38,110,40,111,42,112,44,113,47,114,52,116);
}
