// JavaLine 1 ==> SourceLine 513
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:07 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$normalattrfile$putNumber extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=513, lastLine=516, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER2$normalattrfile$putNumber setPar(Object param) {
        //Util.BREAK("CALL BUILDER2$normalattrfile$putNumber.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER2$normalattrfile$putNumber(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER2$normalattrfile$putNumber(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("putNumber",513);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$normalattrfile$putNumber STM$() {
        TRACE_BEGIN_STM$("putNumber",513);
        // JavaLine 41 ==> SourceLine 514
        storeChar(char$((p$i/(256))),((BUILDER2$normalattrfile)(CUR$.SL$)).attrbuffer,((BUILDER2$normalattrfile)(CUR$.SL$)).p);
        // JavaLine 43 ==> SourceLine 515
        storeChar(char$(mod(p$i,256)),((BUILDER2$normalattrfile)(CUR$.SL$)).attrbuffer,(((BUILDER2$normalattrfile)(CUR$.SL$)).p+(1)));
        ((BUILDER2$normalattrfile)(CUR$.SL$)).p=(((BUILDER2$normalattrfile)(CUR$.SL$)).p+(2));
        TRACE_END_STM$("putNumber",515);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure putNumber",1,513,41,514,43,515,49,516);
}
