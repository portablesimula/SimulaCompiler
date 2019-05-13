package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:37 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class ERRMSG extends COMMON {
    public int prefixLevel() { return(1); }
    public int numwarnfound$1=0;
    public int maxerrno$1=0;
    public final int uplim$1=(int)(450);
    public DirectFile$ ERRORFILE$1=null;
    public boolean ERRnotopen$1=false;
    public final int messlength$1=(int)(50);
    public int lasterrpos$1=0;
    public int lasterrmess$1=0;
    public int errloop$1=0;
    public int lasterrline$1=0;
    public PRCQNT$ COMMONerror$0() { return(new PRCQNT$(this,ERRMSG$COMMONerror.class)); }
    public ERRMSG(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("ERRMSG",999);
    }
    public ERRMSG STM$() {
        ERRMSG THIS$=(ERRMSG)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                if(VALUE$(false)) {
                    {
                        LABEL$(1,"EXCEPTION_HANDLER");
                        sysout().outimage();
                        if(VALUE$((((EXC_NUMBER==(22))||((EXC_NUMBER==(31))))||((EXC_NUMBER==(32)))))) {
                            {
                                sysout().outtext(new TXT$("*** NOT ENOUGH STORAGE AVAILABLE ***"));
                                terminate_program();
                            }
                        }
                        ((COMMON)CUR$).COMMONerror$0().CPF().setPar((-(EXC_NUMBER))).ENT$();
                    }
                }
                giveIntInfo(1,6);
                new COMMON$StandardException(((COMMON)CUR$));
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    CUR$.STATE$=OperationalState.terminated;
                    throw(q);
                }
                JTX$=q.index; continue LOOP$;
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Class ERRMSG",1,6,8,40,10,41,12,42,14,44,17,46,19,164,23,165,35,1572,37,1573,39,1574,42,1575,44,1582,47,1583,51,1585,55,1588,57,1589,59,1002,73,1002);
}
