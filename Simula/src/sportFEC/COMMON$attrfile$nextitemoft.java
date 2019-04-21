package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Apr 14 09:36:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$attrfile$nextitemoft extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    final LABQNT$ ubl=new LABQNT$(this,1,"ubl");
    final LABQNT$ bl=new LABQNT$(this,2,"bl");
    final LABQNT$ E=new LABQNT$(this,3,"E");
    int i=0;
    int j=0;
    public COMMON$attrfile$nextitemoft(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public COMMON$attrfile$nextitemoft STM$() {
        COMMON$attrfile$nextitemoft THIS$=(COMMON$attrfile$nextitemoft)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                while(TXT$.more(((COMMON)(CUR$.SL$.SL$)).permt)) {
                    if(VALUE$((TXT$.getchar(((COMMON)(CUR$.SL$.SL$)).permt)!=(((char)32))))) {
                        GOTO$(ubl);
                    }
                }
                RESULT$=null;
                GOTO$(E);
                LABEL$(1,"ubl");
                i=(TXT$.pos(((COMMON)(CUR$.SL$.SL$)).permt)-(1));
                j=1;
                while(TXT$.more(((COMMON)(CUR$.SL$.SL$)).permt)) {
                    if(VALUE$((TXT$.getchar(((COMMON)(CUR$.SL$.SL$)).permt)==(((char)32))))) {
                        GOTO$(bl);
                    } else
                    j=(j+(1));
                }
                LABEL$(2,"bl");
                RESULT$=TXT$.sub(((COMMON)(CUR$.SL$.SL$)).permt,i,j);
                if(VALUE$(TXTREL$EQ(TXT$.sub(((COMMON)(CUR$.SL$.SL$)).permt,i,j),new TXT$("*")))) {
                    RESULT$=null;
                }
                LABEL$(3,"E");
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
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure nextitemoft",1,1358,10,1362,12,1365,14,1367,16,1359,29,1360,35,1361,38,1362,42,1363,44,1364,50,1365,53,1366,57,1367,72,1367);
}
