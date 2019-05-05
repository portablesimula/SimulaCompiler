// JavaLine 1 <== SourceLine 28
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:22:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HexDump$InByte extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=28, lastLine=29, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public HexDump$InByte(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("InByte",28);
        STM$();
    }
    // Procedure Statements
    public HexDump$InByte STM$() {
        TRACE_BEGIN_STM$("InByte",28);
        // JavaLine 26 <== SourceLine 29
        RESULT$=((HexDump)(CUR$.SL$)).Inpt.inbyte();
        ((HexDump)(CUR$.SL$)).Sequ=(((HexDump)(CUR$.SL$)).Sequ+(1));
        TRACE_END_STM$("InByte",29);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HexDump.sim","Procedure InByte",1,28,26,29,32,29);
} // End of Procedure
