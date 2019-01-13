// JavaLine 1 ==> SourceLine 60
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:19 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$GiveMessage extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=60, lastLine=89, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$ec;
    public int p$index;
    // Declare locals as attributes
    // JavaLine 13 ==> SourceLine 61
    int i=0;
    TXT$ t=null;
    TXT$ tout=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$GiveMessage setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$GiveMessage.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$GiveMessage(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$GiveMessage(RTObject$ SL$,char sp$ec,int sp$index) {
        super(SL$);
        // Parameter assignment to locals
        this.p$ec = sp$ec;
        this.p$index = sp$index;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("GiveMessage",61);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$GiveMessage STM$() {
        TRACE_BEGIN_STM$("GiveMessage",61);
        // JavaLine 48 ==> SourceLine 62
        if((((ERRMSG)(CUR$.SL$)).messageLinenr<=(0))) {
            ((ERRMSG)(CUR$.SL$)).messageLinenr=((ERRMSG)(CUR$.SL$)).linenr;
        }
        // JavaLine 52 ==> SourceLine 63
        t=(((p$ec==(((ERRMSG)(CUR$.SL$)).NUL)))?(new TXT$("Note!: ")):((((p$ec==(((char)1))))?(new TXT$("Warn.: ")):((((p$ec==(((char)2))))?(new TXT$("ERROR: ")):(new TXT$("FATAL: ")))))));
        // JavaLine 54 ==> SourceLine 65
        if((((((ERRMSG)(CUR$.SL$)).currentpass>('1'))|((p$ec>=(((char)3)))))&&((((ERRMSG)(CUR$.SL$)).messageLinenr>(0))))) {
            // JavaLine 56 ==> SourceLine 67
            {
                TRACE_BEGIN_STM$("CompoundStatement67",67);
                tout=new COMMON$leftint(((ERRMSG)(CUR$.SL$)),((ERRMSG)(CUR$.SL$)).messageLinenr).RESULT$;
                t=CONC(CONC(CONC(t,new TXT$("(l. ")),tout),new TXT$(") "));
                TRACE_END_STM$("CompoundStatement67",67);
            }
        }
        // JavaLine 64 ==> SourceLine 69
        ((ERRMSG)(CUR$.SL$)).messageLinenr=0;
        i=(TXT$.length(t)+(1));
        // JavaLine 67 ==> SourceLine 71
        tout=new ERRMSG$diagmerge(((ERRMSG)(CUR$.SL$)),p$index).RESULT$;
        t=CONC(t,tout);
        // JavaLine 70 ==> SourceLine 73
        while((TXT$.length(t)>(78))) {
            // JavaLine 72 ==> SourceLine 74
            {
                TRACE_BEGIN_STM$("CompoundStatement74",74);
                TXT$.setpos(t,79);
                // JavaLine 76 ==> SourceLine 75
                while((TXT$.getchar(t)!=(((char)32)))) {
                    TXT$.setpos(t,(TXT$.pos(t)-(2)));
                }
                // JavaLine 80 ==> SourceLine 76
                tout=TXT$.sub(t,1,(TXT$.pos(t)-(2)));
                t=TXT$.sub(t,TXT$.pos(t),((TXT$.length(t)-(TXT$.pos(t)))+(1)));
                // JavaLine 83 ==> SourceLine 77
                new ERRMSG$printDiag(((ERRMSG)(CUR$.SL$)),tout);
                TRACE_END_STM$("CompoundStatement74",77);
            }
        }
        // JavaLine 88 ==> SourceLine 80
        new ERRMSG$printDiag(((ERRMSG)(CUR$.SL$)),t);
        // JavaLine 90 ==> SourceLine 81
        if((p$ec==(((char)1)))) {
            ((ERRMSG)(CUR$.SL$)).numwarnfound=(((ERRMSG)(CUR$.SL$)).numwarnfound+(1));
        }
        // JavaLine 94 ==> SourceLine 82
        if((p$ec==(((char)2)))) {
            // JavaLine 96 ==> SourceLine 83
            {
                TRACE_BEGIN_STM$("CompoundStatement83",83);
                ((ERRMSG)(CUR$.SL$)).numerrfound=(((ERRMSG)(CUR$.SL$)).numerrfound+(1));
                // JavaLine 100 ==> SourceLine 84
                if((((ERRMSG)(CUR$.SL$)).termstatus<('5'))) {
                    ((ERRMSG)(CUR$.SL$)).termstatus='5';
                }
                TRACE_END_STM$("CompoundStatement83",84);
            }
        }
        // JavaLine 107 ==> SourceLine 87
        rts_utility(1,0);
        // JavaLine 109 ==> SourceLine 88
        if(((((ERRMSG)(CUR$.SL$)).numerrfound>(((ERRMSG)(CUR$.SL$)).maxerrno))|((p$ec>(((char)2)))))) {
            new ERRMSG$AbortCompilation(((ERRMSG)(CUR$.SL$)));
        }
        TRACE_END_STM$("GiveMessage",88);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure GiveMessage",1,60,13,61,48,62,52,63,54,65,56,67,64,69,67,71,70,73,72,74,76,75,80,76,83,77,88,80,90,81,94,82,96,83,100,84,107,87,109,88,116,89);
}
