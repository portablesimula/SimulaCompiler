package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:37 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$GiveMessage extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public char p$ec;
    public int p$index;
    int i=0;
    TXT$ t=null;
    TXT$ tout=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$GiveMessage setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$ec=(char)objectValue(param); break;
                case 1: p$index=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public ERRMSG$GiveMessage(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$GiveMessage(RTObject$ SL$,char sp$ec,int sp$index) {
        super(SL$);
        this.p$ec = sp$ec;
        this.p$index = sp$index;
        BBLK();
        STM$();
    }
    public ERRMSG$GiveMessage STM$() {
        if(VALUE$((((ERRMSG)(CUR$.SL$)).messageLinenr<=(0)))) {
            ((ERRMSG)(CUR$.SL$)).messageLinenr=((ERRMSG)(CUR$.SL$)).linenr;
        }
        t=(((p$ec==(((ERRMSG)(CUR$.SL$)).NUL)))?(new TXT$("Note!: ")):((((p$ec==(((char)1))))?(new TXT$("Warn.: ")):((((p$ec==(((char)2))))?(new TXT$("ERROR: ")):(new TXT$("FATAL: ")))))));
        if(VALUE$((((((ERRMSG)(CUR$.SL$)).currentpass>('1'))|((p$ec>=(((char)3)))))&&((((ERRMSG)(CUR$.SL$)).messageLinenr>(0)))))) {
            {
                tout=new COMMON$leftint(((ERRMSG)(CUR$.SL$)),((ERRMSG)(CUR$.SL$)).messageLinenr).RESULT$;
                t=CONC(CONC(CONC(t,new TXT$("(l. ")),tout),new TXT$(") "));
            }
        }
        ((ERRMSG)(CUR$.SL$)).messageLinenr=0;
        i=(TXT$.length(t)+(1));
        tout=new ERRMSG$diagmerge(((ERRMSG)(CUR$.SL$)),p$index).RESULT$;
        t=CONC(t,tout);
        while((TXT$.length(t)>(78))) {
            {
                TXT$.setpos(t,79);
                while((TXT$.getchar(t)!=(((char)32)))) {
                    TXT$.setpos(t,(TXT$.pos(t)-(2)));
                }
                tout=TXT$.sub(t,1,(TXT$.pos(t)-(2)));
                t=TXT$.sub(t,TXT$.pos(t),((TXT$.length(t)-(TXT$.pos(t)))+(1)));
                new ERRMSG$printDiag(((ERRMSG)(CUR$.SL$)),tout);
            }
        }
        new ERRMSG$printDiag(((ERRMSG)(CUR$.SL$)),t);
        if(VALUE$((p$ec==(((char)1))))) {
            ((ERRMSG)(CUR$.SL$)).numwarnfound$1=(((ERRMSG)(CUR$.SL$)).numwarnfound$1+(1));
        }
        if(VALUE$((p$ec==(((char)2))))) {
            {
                ((ERRMSG)(CUR$.SL$)).numerrfound=(((ERRMSG)(CUR$.SL$)).numerrfound+(1));
                if(VALUE$((((ERRMSG)(CUR$.SL$)).termstatus<('5')))) {
                    ((ERRMSG)(CUR$.SL$)).termstatus='5';
                }
            }
        }
        rts_utility(1,0);
        if(VALUE$(((((ERRMSG)(CUR$.SL$)).numerrfound>(((ERRMSG)(CUR$.SL$)).maxerrno$1))|((p$ec>(((char)2))))))) {
            new ERRMSG$AbortCompilation(((ERRMSG)(CUR$.SL$)));
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure GiveMessage",1,60,10,61,36,62,40,63,42,65,44,67,50,69,53,71,56,73,58,74,61,75,65,76,68,77,72,80,74,81,78,82,80,83,83,84,89,87,91,88,97,89);
}
