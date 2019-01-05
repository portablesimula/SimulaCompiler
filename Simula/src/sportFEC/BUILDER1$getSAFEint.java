// JavaLine 1 ==> SourceLine 189
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:26 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$getSAFEint extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=189, lastLine=198, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public char p$hi;
    public char p$lo;
    // Declare local labels
    // JavaLine 16 ==> SourceLine 195
    final LABQNT$ IOFLO=new LABQNT$(this,0,1); // Local Label #1=IOFLO
    // Declare locals as attributes
    // JavaLine 19 ==> SourceLine 190
    int EXC_NUMBER=0;
    COMMON$symbolbox symx=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$getSAFEint setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$getSAFEint.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$hi=(char)objectValue(param); break;
                case 1: p$lo=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER1$getSAFEint(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$getSAFEint(RTObject$ SL$,char sp$hi,char sp$lo) {
        super(SL$);
        // Parameter assignment to locals
        this.p$hi = sp$hi;
        this.p$lo = sp$lo;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("getSAFEint",190);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$getSAFEint STM$() {
        TRACE_BEGIN_STM$("getSAFEint",190);
        BUILDER1$getSAFEint THIS$=(BUILDER1$getSAFEint)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 57 ==> SourceLine 192
                DEFEXCEPTION(IOFLO,new NAME$<Integer>(){ public Integer get() { return(EXC_NUMBER); } public Integer put(Integer x$) { return(EXC_NUMBER=(int)x$); } });
                // JavaLine 59 ==> SourceLine 193
                symx=new COMMON$boxof(((BUILDER1)(CUR$.SL$)),p$hi,p$lo).RESULT$;
                // JavaLine 61 ==> SourceLine 194
                RESULT$=TXT$.getint(symx.symbol);
                // JavaLine 63 ==> SourceLine 195
                if(false) {
                    LABEL$(1); // IOFLO
                    new ERRMSG$error1id(((BUILDER1)(CUR$.SL$)),398,symx);
                }
                // JavaLine 68 ==> SourceLine 196
                new COMMON$StandardException(((BUILDER1)(CUR$.SL$)));
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
        TRACE_END_STM$("getSAFEint",196);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure getSAFEint",1,189,16,195,19,190,57,192,59,193,61,194,63,195,68,196,86,198);
}
