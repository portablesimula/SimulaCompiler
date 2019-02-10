// JavaLine 1 ==> SourceLine 1729
package sportFEC;
// Simula-Beta-0.3 Compiled at Fri Feb 08 20:41:33 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$L2Coder$chainVis extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1729, lastLine=1736, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public boolean p$hidp;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 1731
    COMMON$idpack inspect$1731$13=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public SCANNER$L2Coder$chainVis setPar(Object param) {
        //Util.BREAK("CALL SCANNER$L2Coder$chainVis.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$hidp=(boolean)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public SCANNER$L2Coder$chainVis(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public SCANNER$L2Coder$chainVis(RTObject$ SL$,boolean sp$hidp) {
        super(SL$);
        // Parameter assignment to locals
        this.p$hidp = sp$hidp;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("chainVis",1731);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$L2Coder$chainVis STM$() {
        TRACE_BEGIN_STM$("chainVis",1731);
        {
            // BEGIN INSPECTION 
            inspect$1731$13=((p$hidp)?(new COMMON$idpack(((SCANNER)(CUR$.SL$.SL$))).STM$()):(new SCANNER$protpack(((SCANNER)(CUR$.SL$.SL$))).STM$()));
            if(inspect$1731$13!=null) //INSPECT inspect$1731$13
            // JavaLine 47 ==> SourceLine 1732
            {
                TRACE_BEGIN_STM$("CompoundStatement1732",1732);
                inspect$1731$13.line=((SCANNER)(CUR$.SL$.SL$)).linenr;
                inspect$1731$13.idhi=((SCANNER)(CUR$.SL$.SL$)).opdhi;
                inspect$1731$13.idlo=((SCANNER)(CUR$.SL$.SL$)).opdlo;
                // JavaLine 53 ==> SourceLine 1733
                if(VALUE$((((SCANNER$L2Coder)(CUR$.SL$)).cbrec.hidlist==(null)))) {
                    // JavaLine 55 ==> SourceLine 1734
                    ((SCANNER$L2Coder)(CUR$.SL$)).cvispack=((SCANNER$L2Coder)(CUR$.SL$)).cbrec.hidlist=((COMMON$idpack)inspect$1731$13);
                } else
                // JavaLine 58 ==> SourceLine 1735
                ((SCANNER$L2Coder)(CUR$.SL$)).cvispack=((SCANNER$L2Coder)(CUR$.SL$)).cvispack.next=((COMMON$idpack)inspect$1731$13);
                TRACE_END_STM$("CompoundStatement1732",1735);
            }
        }
        TRACE_END_STM$("chainVis",1735);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure chainVis",1,1729,12,1731,47,1732,53,1733,55,1734,58,1735,66,1736);
}
