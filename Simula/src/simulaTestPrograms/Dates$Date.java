package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed May 08 17:45:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Dates$Date extends CLASS$ {
    public int prefixLevel() { return(0); }
    public int p$D;
    public int p$M;
    public int p$Y;
    public Dates$Date(RTObject$ staticLink,int sp$D,int sp$M,int sp$Y) {
        super(staticLink);
        this.p$D = sp$D;
        this.p$M = sp$M;
        this.p$Y = sp$Y;
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("Date",192);
    }
    public Dates$Date STM$() {
        while((p$M<(1))) {
            {
                p$M=(p$M+(12));
                p$Y=(p$Y-(1));
            }
        }
        while((p$M>(12))) {
            {
                p$M=(p$M-(12));
                p$Y=(p$Y+(1));
            }
        }
        while((p$D<(1))) {
            {
                p$M=(p$M-(1));
                if(VALUE$((p$M==(0)))) {
                    {
                        p$M=12;
                        p$Y=(p$Y-(1));
                    }
                }
                p$D=(p$D+(new Dates$M_leng(((Dates)(CUR$.SL$)),p$M,p$Y).RESULT$));
            }
        }
        while((p$D>(new Dates$M_leng(((Dates)(CUR$.SL$)),p$M,p$Y).RESULT$))) {
            {
                p$D=(p$D-(new Dates$M_leng(((Dates)(CUR$.SL$)),p$M,p$Y).RESULT$));
                p$M=(p$M+(1));
                if(VALUE$((p$M==(13)))) {
                    {
                        p$M=1;
                        p$Y=(p$Y+(1));
                    }
                }
            }
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Class Date",1,12,20,198,22,199,28,201,30,202,36,205,38,206,41,207,48,208,52,210,54,211,57,212,59,213,68,198,71,215);
}
