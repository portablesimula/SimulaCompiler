// JavaLine 1 ==> SourceLine 168
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:51 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$outP1message extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=168, lastLine=205, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$where;
    public int p$message;
    public char p$code;
    // Declare local labels
    // JavaLine 14 ==> SourceLine 205
    final LABQNT$ NOMESS=new LABQNT$(this,0,1); // Local Label #1=NOMESS
    // Declare locals as attributes
    // JavaLine 17 ==> SourceLine 170
    TXT$ marker=null;
    TXT$ utlin=null;
    int tabcor=0;
    // JavaLine 21 ==> SourceLine 171
    final char ISOtab=((char)9);
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$outP1message setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$outP1message.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$outP1message(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$outP1message(RTObject$ SL$,int sp$where,int sp$message,char sp$code) {
        super(SL$);
        // Parameter assignment to locals
        this.p$where = sp$where;
        this.p$message = sp$message;
        this.p$code = sp$code;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("outP1message",171);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$outP1message STM$() {
        TRACE_BEGIN_STM$("outP1message",171);
        ERRMSG$outP1message THIS$=(ERRMSG$outP1message)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 60 ==> SourceLine 172
                if(((((ERRMSG)(CUR$.SL$)).lasterrline==(((ERRMSG)(CUR$.SL$)).linenr))&&(((((ERRMSG)(CUR$.SL$)).lasterrpos>=(p$where))|((((ERRMSG)(CUR$.SL$)).lasterrmess==(p$message))))))) {
                    // JavaLine 62 ==> SourceLine 175
                    {
                        TRACE_BEGIN_STM$("CompoundStatement175",175);
                        ((ERRMSG)(CUR$.SL$)).errloop=(((ERRMSG)(CUR$.SL$)).errloop+(1));
                        // JavaLine 66 ==> SourceLine 176
                        if((((ERRMSG)(CUR$.SL$)).errloop>(4))) {
                            new ERRMSG$fatal0(((ERRMSG)(CUR$.SL$)),0);
                        }
                        // JavaLine 70 ==> SourceLine 178
                        GOTO$(NOMESS); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement175",178);
                    }
                }
                // JavaLine 75 ==> SourceLine 180
                ((ERRMSG)(CUR$.SL$)).errloop=0;
                // JavaLine 77 ==> SourceLine 181
                ((ERRMSG)(CUR$.SL$)).lasterrmess=p$message;
                // JavaLine 79 ==> SourceLine 184
                utlin=((ERRMSG)(CUR$.SL$)).line;
                // JavaLine 81 ==> SourceLine 185
                if((((ERRMSG)(CUR$.SL$)).lasterrline!=(((ERRMSG)(CUR$.SL$)).linenr))) {
                    // JavaLine 83 ==> SourceLine 186
                    {
                        TRACE_BEGIN_STM$("CompoundStatement186",186);
                        if(((!(((ERRMSG)(CUR$.SL$)).listingon))||((((ERRMSG)(CUR$.SL$)).listfile!=(sysout()))))) {
                            // JavaLine 87 ==> SourceLine 188
                            {
                                TRACE_BEGIN_STM$("CompoundStatement188",188);
                                sysout().outint(((ERRMSG)(CUR$.SL$)).linenr,6);
                                sysout().outtext(new TXT$(": "));
                                sysout().outtext(utlin);
                                // JavaLine 93 ==> SourceLine 189
                                sysout().outimage();
                                TRACE_END_STM$("CompoundStatement188",189);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement186",189);
                    }
                }
                // JavaLine 101 ==> SourceLine 192
                if(((((ERRMSG)(CUR$.SL$)).lasterrpos!=(p$where))|((((ERRMSG)(CUR$.SL$)).lasterrline!=(((ERRMSG)(CUR$.SL$)).linenr))))) {
                    // JavaLine 103 ==> SourceLine 193
                    {
                        TRACE_BEGIN_STM$("CompoundStatement193",193);
                        tabcor=(p$where+(7));
                        TXT$.setpos(utlin,1);
                        // JavaLine 108 ==> SourceLine 195
                        while(TXT$.more(utlin)) {
                            if((TXT$.getchar(utlin)==(ISOtab))) {
                                // JavaLine 111 ==> SourceLine 196
                                tabcor=((tabcor+(8))-(rem(7,TXT$.pos(utlin))));
                            }
                        }
                        // JavaLine 115 ==> SourceLine 197
                        marker=blanks(tabcor);
                        // JavaLine 117 ==> SourceLine 198
                        TXT$.setpos(marker,9);
                        // JavaLine 119 ==> SourceLine 199
                        while((TXT$.pos(marker)<(tabcor))) {
                            TXT$.putchar(marker,'=');
                        }
                        // JavaLine 123 ==> SourceLine 200
                        TXT$.putchar(marker,'I');
                        new ERRMSG$printDiag(((ERRMSG)(CUR$.SL$)),marker);
                        TRACE_END_STM$("CompoundStatement193",200);
                    }
                }
                // JavaLine 129 ==> SourceLine 202
                ((ERRMSG)(CUR$.SL$)).lasterrline=((ERRMSG)(CUR$.SL$)).linenr;
                ((ERRMSG)(CUR$.SL$)).lasterrpos=p$where;
                // JavaLine 132 ==> SourceLine 203
                new ERRMSG$GiveMessage(((ERRMSG)(CUR$.SL$)),p$code,p$message);
                // JavaLine 134 ==> SourceLine 205
                LABEL$(1); // NOMESS
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$ || q.prefixLevel!=0) {
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("outP1message",205);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure outP1message",1,168,14,205,17,170,21,171,60,172,62,175,66,176,70,178,75,180,77,181,79,184,81,185,83,186,87,188,93,189,101,192,103,193,108,195,111,196,115,197,117,198,119,199,123,200,129,202,132,203,134,205,152,205);
}
