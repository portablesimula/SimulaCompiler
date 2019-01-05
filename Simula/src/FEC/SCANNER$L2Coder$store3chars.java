// JavaLine 1 ==> SourceLine 1743
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:53 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$L2Coder$store3chars extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1743, lastLine=1749, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$ch1;
    public char p$ch2;
    public char p$ch3;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public SCANNER$L2Coder$store3chars setPar(Object param) {
        //Util.BREAK("CALL SCANNER$L2Coder$store3chars.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$ch1=(char)objectValue(param); break;
                case 1: p$ch2=(char)objectValue(param); break;
                case 2: p$ch3=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public SCANNER$L2Coder$store3chars(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public SCANNER$L2Coder$store3chars(RTObject$ SL$,char sp$ch1,char sp$ch2,char sp$ch3) {
        super(SL$);
        // Parameter assignment to locals
        this.p$ch1 = sp$ch1;
        this.p$ch2 = sp$ch2;
        this.p$ch3 = sp$ch3;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("store3chars",1743);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$L2Coder$store3chars STM$() {
        TRACE_BEGIN_STM$("store3chars",1743);
        // JavaLine 47 ==> SourceLine 1745
        storeChar(p$ch1,((SCANNER$L2Coder)(CUR$.SL$)).L2buf,((SCANNER$L2Coder)(CUR$.SL$)).L2p);
        // JavaLine 49 ==> SourceLine 1746
        storeChar(p$ch2,((SCANNER$L2Coder)(CUR$.SL$)).L2buf,(((SCANNER$L2Coder)(CUR$.SL$)).L2p+(1)));
        // JavaLine 51 ==> SourceLine 1747
        storeChar(p$ch3,((SCANNER$L2Coder)(CUR$.SL$)).L2buf,(((SCANNER$L2Coder)(CUR$.SL$)).L2p+(2)));
        ((SCANNER$L2Coder)(CUR$.SL$)).L2p=(((SCANNER$L2Coder)(CUR$.SL$)).L2p+(3));
        TRACE_END_STM$("store3chars",1747);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure store3chars",1,1743,47,1745,49,1746,51,1747,57,1749);
}
