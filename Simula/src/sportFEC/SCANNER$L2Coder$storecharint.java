// JavaLine 1 ==> SourceLine 1738
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:44:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$L2Coder$storecharint extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1738, lastLine=1740, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$ch;
    public int p$int$;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public SCANNER$L2Coder$storecharint setPar(Object param) {
        //Util.BREAK("CALL SCANNER$L2Coder$storecharint.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$ch=(char)objectValue(param); break;
                case 1: p$int$=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public SCANNER$L2Coder$storecharint(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public SCANNER$L2Coder$storecharint(RTObject$ SL$,char sp$ch,int sp$int$) {
        super(SL$);
        // Parameter assignment to locals
        this.p$ch = sp$ch;
        this.p$int$ = sp$int$;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("storecharint",1738);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$L2Coder$storecharint STM$() {
        TRACE_BEGIN_STM$("storecharint",1738);
        // JavaLine 44 ==> SourceLine 1740
        new SCANNER$L2Coder$store3chars(((SCANNER$L2Coder)(CUR$.SL$)),p$ch,char$((p$int$/(256))),char$(rem(p$int$,256)));
        TRACE_END_STM$("storecharint",1740);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure storecharint",1,1738,44,1740,49,1740);
}
