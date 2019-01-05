// JavaLine 1 ==> SourceLine 213
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:51 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$COMMONerror extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=213, lastLine=244, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$EXC_NUMBER;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$COMMONerror setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$COMMONerror.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$EXC_NUMBER=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$COMMONerror(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$COMMONerror(RTObject$ SL$,int sp$EXC_NUMBER) {
        super(SL$);
        // Parameter assignment to locals
        this.p$EXC_NUMBER = sp$EXC_NUMBER;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("COMMONerror",213);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$COMMONerror STM$() {
        TRACE_BEGIN_STM$("COMMONerror",213);
        // JavaLine 41 ==> SourceLine 215
        if((p$EXC_NUMBER>(0))) {
            // JavaLine 43 ==> SourceLine 216
            new ERRMSG$fatal0(((ERRMSG)(CUR$.SL$)),p$EXC_NUMBER);
        } else
        {
            TRACE_BEGIN_STM$("CompoundStatement216",216);
            p$EXC_NUMBER=(-(p$EXC_NUMBER));
            // JavaLine 49 ==> SourceLine 217
            if((p$EXC_NUMBER==(106))) {
                // JavaLine 51 ==> SourceLine 219
                {
                    TRACE_BEGIN_STM$("CompoundStatement219",219);
                    sysout().outtext(new TXT$("*** NO MORE DISK or FILE SPACE ***"));
                    TRACE_END_STM$("CompoundStatement219",219);
                }
            } else
            // JavaLine 58 ==> SourceLine 222
            {
                TRACE_BEGIN_STM$("CompoundStatement222",222);
                if((p$EXC_NUMBER==(11))) {
                    // JavaLine 62 ==> SourceLine 223
                    {
                        TRACE_BEGIN_STM$("CompoundStatement223",223);
                        sysout().outtext(new TXT$("*** COMPILATION KILLED"));
                        TRACE_END_STM$("CompoundStatement223",223);
                    }
                } else
                // JavaLine 69 ==> SourceLine 226
                {
                    TRACE_BEGIN_STM$("CompoundStatement226",226);
                    if((((ERRMSG)(CUR$.SL$)).numerrfound==(0))) {
                        // JavaLine 73 ==> SourceLine 227
                        {
                            TRACE_BEGIN_STM$("CompoundStatement227",227);
                            sysout().outtext(new TXT$("*** INTERNAL ERROR (RTS error #"));
                            // JavaLine 77 ==> SourceLine 228
                            sysout().outint(p$EXC_NUMBER,0);
                            sysout().outtext(new TXT$(")"));
                            TRACE_END_STM$("CompoundStatement227",228);
                        }
                    } else
                    // JavaLine 83 ==> SourceLine 230
                    sysout().outtext(new TXT$("*** Compiler cannot recover, ABORT"));
                    // JavaLine 85 ==> SourceLine 231
                    if((((ERRMSG)(CUR$.SL$)).linenr>(0))) {
                        // JavaLine 87 ==> SourceLine 232
                        {
                            TRACE_BEGIN_STM$("CompoundStatement232",232);
                            sysout().outtext(new TXT$(" at source line "));
                            sysout().outint(((ERRMSG)(CUR$.SL$)).linenr,0);
                            TRACE_END_STM$("CompoundStatement232",232);
                        }
                    }
                    // JavaLine 95 ==> SourceLine 235
                    sysout().outtext((((((ERRMSG)(CUR$.SL$)).currentpass==('1')))?(new TXT$(" (Pass1) ***")):(new TXT$(" (Pass2) ***"))));
                    TRACE_END_STM$("CompoundStatement226",235);
                }
                // JavaLine 99 ==> SourceLine 237
                if(((((ERRMSG)(CUR$.SL$)).listfile!=(null))&&((((ERRMSG)(CUR$.SL$)).listfile!=(sysout()))))) {
                    // JavaLine 101 ==> SourceLine 238
                    {
                        TRACE_BEGIN_STM$("CompoundStatement238",238);
                        ((ERRMSG)(CUR$.SL$)).listfile.outtext(TXT$.strip(sysout().image));
                        ((ERRMSG)(CUR$.SL$)).listfile.outimage();
                        TRACE_END_STM$("CompoundStatement238",238);
                    }
                }
                TRACE_END_STM$("CompoundStatement222",238);
            }
            // JavaLine 111 ==> SourceLine 241
            sysout().outimage();
            // JavaLine 113 ==> SourceLine 242
            rts_utility(1,0);
            // JavaLine 115 ==> SourceLine 243
            ((ERRMSG)(CUR$.SL$)).ENDCOMP$0().CPF();
            TRACE_END_STM$("CompoundStatement216",243);
        }
        TRACE_END_STM$("COMMONerror",243);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure COMMONerror",1,213,41,215,43,216,49,217,51,219,58,222,62,223,69,226,73,227,77,228,83,230,85,231,87,232,95,235,99,237,101,238,111,241,113,242,115,243,122,244);
}
