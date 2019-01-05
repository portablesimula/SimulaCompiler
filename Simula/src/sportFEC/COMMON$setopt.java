// JavaLine 1 ==> SourceLine 276
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:41:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$setopt extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=276, lastLine=280, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$ch;
    public char p$val;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public COMMON$setopt setPar(Object param) {
        //Util.BREAK("CALL COMMON$setopt.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$ch=(char)objectValue(param); break;
                case 1: p$val=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public COMMON$setopt(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public COMMON$setopt(RTObject$ SL$,char sp$ch,char sp$val) {
        super(SL$);
        // Parameter assignment to locals
        this.p$ch = sp$ch;
        this.p$val = sp$val;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("setopt",276);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public COMMON$setopt STM$() {
        TRACE_BEGIN_STM$("setopt",276);
        // JavaLine 44 ==> SourceLine 277
        if((p$ch<(((char)128)))) {
            // JavaLine 46 ==> SourceLine 278
            {
                TRACE_BEGIN_STM$("CompoundStatement278",278);
                if((p$ch>('_'))) {
                    p$ch=char$((rank(p$ch)-(32)));
                }
                // JavaLine 52 ==> SourceLine 279
                ((COMMON)(CUR$.SL$)).option.Elt[rank(p$ch)-((COMMON)(CUR$.SL$)).option.LB[0]]=p$val;
                TRACE_END_STM$("CompoundStatement278",279);
            }
        }
        TRACE_END_STM$("setopt",279);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure setopt",1,276,44,277,46,278,52,279,60,280);
}
