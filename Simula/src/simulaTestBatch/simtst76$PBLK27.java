package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 22 12:24:09 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst76$PBLK27 extends Simset$ {
    public boolean isQPSystemBlock() { return(true); }
    simtst76$$simtst76$PBLK27$A x$1=null;
    public simtst76$PBLK27(RTObject$ staticLink) {
        super(staticLink);
    }
    public simtst76$PBLK27 STM$() {
        new simtst76$$Print(((simtst76$)(CUR$.SL$)),copy(new TXT$("AA")));
        x$1=new simtst76$$simtst76$PBLK27$A(((simtst76$PBLK27)(CUR$))).STM$();
        new simtst76$$Print(((simtst76$)(CUR$.SL$)),copy(new TXT$("AB")));
        ((simtst76$)(CUR$.SL$)).t=copy(copy(TXT$.strip(sysout().image)));
        sysout().setpos(1);
        ASGTXT$(sysout().image,null);
        if(VALUE$(TXTREL$EQ(((simtst76$)(CUR$.SL$)).t,new TXT$("AAABCDEFGAB")))) {
            {
                if(VALUE$(((simtst76$)(CUR$.SL$)).verbose)) {
                    {
                        sysout().outtext(new TXT$("--- NO ERRORS IN PART 1"));
                        sysout().outimage();
                    }
                }
            }
        } else
        {
            sysout().outtext(new TXT$("*** error : Detach - resume (1)."));
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst76.sim","PrefixedBlock simtst76$PBLK27",1,27,13,46,15,47,17,48,19,50,21,51,23,52,25,54,27,56,37,59,40,60,42,61,44,62,46,63,49,64,54,66);
}
