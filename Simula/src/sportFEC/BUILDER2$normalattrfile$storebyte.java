// JavaLine 1 ==> SourceLine 485
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$normalattrfile$storebyte extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=485, lastLine=486, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$ch;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER2$normalattrfile$storebyte setPar(Object param) {
        //Util.BREAK("CALL BUILDER2$normalattrfile$storebyte.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$ch=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER2$normalattrfile$storebyte(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER2$normalattrfile$storebyte(RTObject$ SL$,char sp$ch) {
        super(SL$);
        // Parameter assignment to locals
        this.p$ch = sp$ch;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("storebyte",485);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$normalattrfile$storebyte STM$() {
        TRACE_BEGIN_STM$("storebyte",485);
        // JavaLine 41 ==> SourceLine 486
        storeChar(p$ch,((BUILDER2$normalattrfile)(CUR$.SL$)).attrbuffer,((BUILDER2$normalattrfile)(CUR$.SL$)).p);
        ((BUILDER2$normalattrfile)(CUR$.SL$)).p=(((BUILDER2$normalattrfile)(CUR$.SL$)).p+(1));
        TRACE_END_STM$("storebyte",486);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure storebyte",1,485,41,486,47,486);
}
