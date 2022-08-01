package simulaTestBatch;
// Simula-2.0 Compiled at Tue Jun 14 15:26:58 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst76$PBLK69 extends Simset$ {
    public boolean isQPSystemBlock() { return(true); }
    public simtst76$$simtst76$PBLK69$A x$1=null;
    public simtst76$PBLK69(RTObject$ staticLink) {
        super(staticLink);
    }
    public simtst76$PBLK69 STM$() {
        x$1=((simtst76$$simtst76$PBLK69$A)new simtst76$$simtst76$PBLK69$A((CUR$)).START$());
        ;
        new simtst76$$Print((CUR$.SL$),copy(new TXT$("B")));
        ;
        resume(x$1,92);
        ;
        new simtst76$$Print((CUR$.SL$),copy(new TXT$("G")));
        ;
        resume(x$1,93);
        ;
        new simtst76$$Print((CUR$.SL$),copy(new TXT$("K")));
        ;
        resume(x$1,94);
        ;
        new simtst76$$Print((CUR$.SL$),copy(new TXT$("M")));
        ;
        ((simtst76$)(CUR$.SL$)).t=ENVIRONMENT$.copy(copy(TXT$.strip(sysout().image)));
        ;
        sysout().setpos(1);
        ;
        ASGTXT$(sysout().image,null);
        ;
        if(VALUE$(TXTREL$EQ(((simtst76$)(CUR$.SL$)).t,new TXT$("ABCDEFGHIJKLM")))) {
            ;
        } else
        {
            sysout().outtext(new TXT$("*** error : Detach - resume (2)."));
            ;
            sysout().outimage();
            ;
            sysout().outtext(new TXT$("             Erroneus sequencing: "));
            ;
            sysout().outtext(((simtst76$)(CUR$.SL$)).t);
            ;
            sysout().outimage();
            ;
            sysout().outimage();
            ;
            ((simtst76$)(CUR$.SL$)).found_error=true;
        }
        ;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst76.sim","PrefixedBlock simtst76$PBLK69",1,69,13,91,16,92,21,93,26,94,31,95,34,97,37,98,40,99,43,101,47,103,51,104,54,105,57,106,60,107,65,108,71,110);
}
