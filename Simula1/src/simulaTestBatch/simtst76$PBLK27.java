package simulaTestBatch;
// Simula-2.0 Compiled at Tue Jun 14 15:26:58 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst76$PBLK27 extends Simset$ {
    public boolean isQPSystemBlock() { return(true); }
    public simtst76$$simtst76$PBLK27$A x$1=null;
    public simtst76$PBLK27(RTObject$ staticLink) {
        super(staticLink);
    }
    public simtst76$PBLK27 STM$() {
        new simtst76$$Print((CUR$.SL$),copy(new TXT$("AA")));
        ;
        x$1=new simtst76$$simtst76$PBLK27$A((CUR$)).STM$();
        ;
        new simtst76$$Print((CUR$.SL$),copy(new TXT$("AB")));
        ;
        ((simtst76$)(CUR$.SL$)).t=ENVIRONMENT$.copy(copy(TXT$.strip(sysout().image)));
        ;
        sysout().setpos(1);
        ;
        ASGTXT$(sysout().image,null);
        ;
        if(VALUE$(TXTREL$EQ(((simtst76$)(CUR$.SL$)).t,new TXT$("AAABCDEFGAB")))) {
            {
                if(VALUE$(false)) {
                    {
                        sysout().outtext(new TXT$("--- NO ERRORS IN PART 1"));
                        ;
                        sysout().outimage();
                        ;
                    }
                }
            }
        } else
        {
            sysout().outtext(new TXT$("*** error : Detach - resume (1)."));
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst76.sim","PrefixedBlock simtst76$PBLK27",1,27,13,46,16,47,19,48,22,50,25,51,28,52,31,54,33,56,45,59,49,60,52,61,55,62,58,63,63,64,69,66);
}
