package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:37 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$errmsg extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$i;
    final LABQNT$ SETNUM=new LABQNT$(this,1,"SETNUM");
    TXT$ t=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$errmsg setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$errmsg(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$errmsg(RTObject$ SL$,int sp$i) {
        super(SL$);
        this.p$i = sp$i;
        BBLK();
        STM$();
    }
    public ERRMSG$errmsg STM$() {
        ERRMSG$errmsg THIS$=(ERRMSG$errmsg)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                if(VALUE$((p$i==(0)))) {
                } else
                if(VALUE$(((ERRMSG)(CUR$.SL$)).ERRnotopen$1)) {
                    {
                        LABEL$(1,"SETNUM");
                        RESULT$=t=copy(copy(new TXT$(" ERROR ... ")));
                        TXT$.putint(TXT$.sub(t,8,3),p$i);
                    }
                } else
                if(VALUE$(((p$i>(0))&&((p$i<=(((ERRMSG)(CUR$.SL$)).uplim$1)))))) {
                    {
                        if(VALUE$((((ERRMSG)(CUR$.SL$)).ERRORFILE$1==(null)))) {
                            {
                                t=getTextInfo(22);
                                if(VALUE$(TRF_EQ(t,null))) {
                                    t=new TXT$("FECERROR");
                                }
                                ((ERRMSG)(CUR$.SL$)).ERRORFILE$1=new DirectFile$(((BASICIO$)CTX$),t).STM$();
                                ((ERRMSG)(CUR$.SL$)).ERRORFILE$1.setaccess(new TXT$("READONLY"));
                            }
                        }
                        if(VALUE$((!(((ERRMSG)(CUR$.SL$)).ERRnotopen$1)))) {
                            {
                                t=blanks(50);
                                if(VALUE$((!(((ERRMSG)(CUR$.SL$)).ERRORFILE$1.open(t))))) {
                                    {
                                        new ERRMSG$printDiag(((ERRMSG)(CUR$.SL$)),new TXT$("*** CAN'T OPEN DIAGNOSTICS FILE ***"));
                                        ((ERRMSG)(CUR$.SL$)).ERRnotopen$1=true;
                                        GOTO$(SETNUM);
                                    }
                                }
                                ((ERRMSG)(CUR$.SL$)).ERRORFILE$1.locate(p$i);
                                ((ERRMSG)(CUR$.SL$)).ERRORFILE$1.inimage();
                                if(VALUE$(((ERRMSG)(CUR$.SL$)).ERRORFILE$1.endfile())) {
                                    {
                                        new ERRMSG$printDiag(((ERRMSG)(CUR$.SL$)),new TXT$("*** INCOMPATIBLE DIAGNOSTICS FILE ***"));
                                        GOTO$(SETNUM);
                                    }
                                }
                                RESULT$=copy(copy(TXT$.strip(((ERRMSG)(CUR$.SL$)).ERRORFILE$1.image)));
                                ((ERRMSG)(CUR$.SL$)).ERRORFILE$1.close();
                            }
                        }
                    }
                } else
                {
                    RESULT$=t=copy(copy(new TXT$("*** DIAGNOSTIC ERROR: .....")));
                    TXT$.putint(TXT$.sub(t,23,5),p$i);
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
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure errmsg",1,123,11,127,13,124,39,125,42,126,44,127,51,129,53,130,56,131,59,132,63,136,65,137,69,139,71,140,74,141,76,142,79,143,84,150,87,151,89,152,92,153,96,155,98,156,104,159,107,160,123,161);
}
