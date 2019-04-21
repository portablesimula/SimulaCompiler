package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Apr 14 09:36:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$LOOKUPid extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    final LABQNT$ F=new LABQNT$(this,1,"F");
    char idlen=0;
    COMMON$symbolbox cursym=null;
    public COMMON$LOOKUPid(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public COMMON$LOOKUPid STM$() {
        COMMON$LOOKUPid THIS$=(COMMON$LOOKUPid)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                if(VALUE$(TRF_EQ(((COMMON)(CUR$.SL$)).simsymbol,null))) {
                    {
                        RESULT$=true;
                        ((COMMON)(CUR$.SL$)).hashhi=((COMMON)(CUR$.SL$)).hashlo=((COMMON)(CUR$.SL$)).NUL;
                    }
                } else
                {
                    ((COMMON)(CUR$.SL$)).hashlo=char$(hash(lowcase(((COMMON)(CUR$.SL$)).simsymbol)));
                    cursym=((COMMON)(CUR$.SL$)).hashtab.Elt[rank(((COMMON)(CUR$.SL$)).hashlo)-((COMMON)(CUR$.SL$)).hashtab.LB[0]];
                    if(VALUE$((cursym!=(null)))) {
                        {
                            while(TXTREL$NE(cursym.symbol,((COMMON)(CUR$.SL$)).simsymbol)) {
                                {
                                    if(VALUE$((cursym.next==(null)))) {
                                        GOTO$(F);
                                    }
                                    cursym=cursym.next;
                                }
                            }
                            ((COMMON)(CUR$.SL$)).hashhi=cursym.idhi;
                            ((COMMON)(CUR$.SL$)).hashlo=cursym.idlo;
                            RESULT$=true;
                        }
                    } else
                    LABEL$(1,"F");
                    {
                        ((COMMON)(CUR$.SL$)).hashhi=((COMMON)(CUR$.SL$)).NUL;
                        RESULT$=false;
                    }
                }
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
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure LOOKUPid",1,138,10,157,12,139,25,140,27,141,33,145,36,146,38,147,40,148,42,149,44,151,49,152,53,154,56,155,60,157,80,159);
}
