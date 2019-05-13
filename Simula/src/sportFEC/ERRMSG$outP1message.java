package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:37 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$outP1message extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$where;
    public int p$message;
    public char p$code;
    final LABQNT$ NOMESS=new LABQNT$(this,1,"NOMESS");
    TXT$ marker=null;
    TXT$ utlin=null;
    int tabcor=0;
    final char ISOtab=(char)(((char)9));
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$outP1message setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$where=intValue(param); break;
                case 1: p$message=intValue(param); break;
                case 2: p$code=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$outP1message(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$outP1message(RTObject$ SL$,int sp$where,int sp$message,char sp$code) {
        super(SL$);
        this.p$where = sp$where;
        this.p$message = sp$message;
        this.p$code = sp$code;
        BBLK();
        STM$();
    }
    public ERRMSG$outP1message STM$() {
        ERRMSG$outP1message THIS$=(ERRMSG$outP1message)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                if(VALUE$(((((ERRMSG)(CUR$.SL$)).lasterrline$1==(((ERRMSG)(CUR$.SL$)).linenr))&&(((((ERRMSG)(CUR$.SL$)).lasterrpos$1>=(p$where))|((((ERRMSG)(CUR$.SL$)).lasterrmess$1==(p$message)))))))) {
                    {
                        ((ERRMSG)(CUR$.SL$)).errloop$1=(((ERRMSG)(CUR$.SL$)).errloop$1+(1));
                        if(VALUE$((((ERRMSG)(CUR$.SL$)).errloop$1>(4)))) {
                            new ERRMSG$fatal0(((ERRMSG)(CUR$.SL$)),0);
                        }
                        GOTO$(NOMESS);
                    }
                }
                ((ERRMSG)(CUR$.SL$)).errloop$1=0;
                ((ERRMSG)(CUR$.SL$)).lasterrmess$1=p$message;
                utlin=((ERRMSG)(CUR$.SL$)).line;
                if(VALUE$((((ERRMSG)(CUR$.SL$)).lasterrline$1!=(((ERRMSG)(CUR$.SL$)).linenr)))) {
                    {
                        if(VALUE$(((!(((ERRMSG)(CUR$.SL$)).listingon))||((((ERRMSG)(CUR$.SL$)).listfile!=(sysout())))))) {
                            {
                                sysout().outint(((ERRMSG)(CUR$.SL$)).linenr,6);
                                sysout().outtext(new TXT$(": "));
                                sysout().outtext(utlin);
                                sysout().outimage();
                            }
                        }
                    }
                }
                if(VALUE$(((((ERRMSG)(CUR$.SL$)).lasterrpos$1!=(p$where))|((((ERRMSG)(CUR$.SL$)).lasterrline$1!=(((ERRMSG)(CUR$.SL$)).linenr)))))) {
                    {
                        tabcor=(p$where+(7));
                        TXT$.setpos(utlin,1);
                        while(TXT$.more(utlin)) {
                            if(VALUE$((TXT$.getchar(utlin)==(ISOtab)))) {
                                tabcor=((tabcor+(8))-(rem(7,TXT$.pos(utlin))));
                            }
                        }
                        marker=blanks(tabcor);
                        TXT$.setpos(marker,9);
                        while((TXT$.pos(marker)<(tabcor))) {
                            TXT$.putchar(marker,'=');
                        }
                        TXT$.putchar(marker,'I');
                        new ERRMSG$printDiag(((ERRMSG)(CUR$.SL$)),marker);
                    }
                }
                ((ERRMSG)(CUR$.SL$)).lasterrline$1=((ERRMSG)(CUR$.SL$)).linenr;
                ((ERRMSG)(CUR$.SL$)).lasterrpos$1=p$where;
                new ERRMSG$GiveMessage(((ERRMSG)(CUR$.SL$)),p$code,p$message);
                LABEL$(1,"NOMESS");
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
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure outP1message",1,168,11,205,13,170,17,171,47,172,49,175,52,176,56,178,60,180,62,181,64,184,66,185,68,186,71,188,76,189,82,192,84,193,88,195,91,196,95,197,97,198,99,199,103,200,108,202,111,203,113,205,128,205);
}
