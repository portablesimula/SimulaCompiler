// JavaLine 1 ==> SourceLine 81
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$MaybeConvert extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=81, lastLine=88, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$typ1;
    public char p$typ2;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public CHECKER1$semchecker1$MaybeConvert setPar(Object param) {
        //Util.BREAK("CALL CHECKER1$semchecker1$MaybeConvert.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$typ1=(char)objectValue(param); break;
                case 1: p$typ2=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public CHECKER1$semchecker1$MaybeConvert(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public CHECKER1$semchecker1$MaybeConvert(RTObject$ SL$,char sp$typ1,char sp$typ2) {
        super(SL$);
        // Parameter assignment to locals
        this.p$typ1 = sp$typ1;
        this.p$typ2 = sp$typ2;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("MaybeConvert",81);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$MaybeConvert STM$() {
        TRACE_BEGIN_STM$("MaybeConvert",81);
        // JavaLine 44 ==> SourceLine 84
        if(VALUE$((p$typ1==(((CHECKER1)(CUR$.SL$.SL$)).ISHOR)))) {
            p$typ1=((CHECKER1)(CUR$.SL$.SL$)).IINTG;
        }
        // JavaLine 48 ==> SourceLine 85
        if(VALUE$((p$typ2==(((CHECKER1)(CUR$.SL$.SL$)).ISHOR)))) {
            p$typ2=((CHECKER1)(CUR$.SL$.SL$)).IINTG;
        }
        // JavaLine 52 ==> SourceLine 86
        if(VALUE$((p$typ1!=(p$typ2)))) {
            // JavaLine 54 ==> SourceLine 87
            {
                TRACE_BEGIN_STM$("CompoundStatement87",87);
                ((CHECKER1$semchecker1)(CUR$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$)).IPRHI;
                ((CHECKER1$semchecker1)(CUR$.SL$)).opt=p$typ1;
                // JavaLine 59 ==> SourceLine 88
                call(((CHECKER1)(CUR$.SL$.SL$)).coder);
                TRACE_END_STM$("CompoundStatement87",88);
            }
        }
        TRACE_END_STM$("MaybeConvert",88);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure MaybeConvert",1,81,44,84,48,85,52,86,54,87,59,88,67,88);
}
