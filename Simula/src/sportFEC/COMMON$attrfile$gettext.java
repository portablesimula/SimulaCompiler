package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Apr 14 09:36:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$attrfile$gettext extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final LABQNT$ REP=new LABQNT$(this,1,"REP");
    int tlength=0;
    InbyteFile$ inspect$1322$4=null;
    public COMMON$attrfile$gettext(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public COMMON$attrfile$gettext STM$() {
        COMMON$attrfile$gettext THIS$=(COMMON$attrfile$gettext)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                LABEL$(1,"REP");
                new COMMON$attrfile$nextKey(((COMMON$attrfile)(CUR$.SL$)));
                if(VALUE$((((COMMON$attrfile)(CUR$.SL$)).key<(((COMMON$attrfile)(CUR$.SL$)).lowKey)))) {
                    {
                        ((COMMON)(CUR$.SL$.SL$)).simsymbol=TXT$.sub(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,(((COMMON$attrfile)(CUR$.SL$)).p+(1)),rank(((COMMON$attrfile)(CUR$.SL$)).key));
                        ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(rank(((COMMON$attrfile)(CUR$.SL$)).key)));
                    }
                } else
                {
                    if(VALUE$((((COMMON$attrfile)(CUR$.SL$)).key==(((COMMON$attrfile)(CUR$.SL$)).longText)))) {
                        {
                            tlength=new COMMON$attrfile$nextNumber(((COMMON$attrfile)(CUR$.SL$))).RESULT$;
                            ((COMMON)(CUR$.SL$.SL$)).simsymbol=TXT$.sub(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,(((COMMON$attrfile)(CUR$.SL$)).p+(1)),tlength);
                            ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(tlength));
                        }
                    } else
                    if(VALUE$((((COMMON$attrfile)(CUR$.SL$)).key==(((COMMON$attrfile)(CUR$.SL$)).longSwap)))) {
                        {
                            {
                                inspect$1322$4=((COMMON$attrfile)(CUR$.SL$)).CURF;
                                if(inspect$1322$4!=null)
                                {
                                    tlength=new COMMON$attrfile$nextNumber(((COMMON$attrfile)(CUR$.SL$))).RESULT$;
                                    ((COMMON)(CUR$.SL$.SL$)).simsymbol=blanks(tlength);
                                    ((COMMON)(CUR$.SL$.SL$)).simsymbol=inspect$1322$4.intext(((COMMON)(CUR$.SL$.SL$)).simsymbol);
                                    tlength=((inspect$1322$4.inbyte()*(256))+(inspect$1322$4.inbyte()));
                                    inspect$1322$4.intext(TXT$.sub(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,1,tlength));
                                    ((COMMON$attrfile)(CUR$.SL$)).p=0;
                                }
                            }
                        }
                    } else
                    new COMMON$attrfile$wrongLayout(((COMMON$attrfile)(CUR$.SL$)));
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
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure gettext",1,1301,8,1303,10,1302,12,1322,24,1303,27,1304,29,1305,32,1306,36,1314,39,1315,42,1316,44,1317,48,1320,50,1322,55,1323,59,1324,61,1325,63,1326,70,1328,86,1330);
}
