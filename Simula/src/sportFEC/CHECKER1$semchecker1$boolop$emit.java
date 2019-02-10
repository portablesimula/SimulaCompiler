// JavaLine 1 ==> SourceLine 249
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$boolop$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=249, lastLine=256, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$boolop$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",249);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$boolop$emit STM$() {
        TRACE_BEGIN_STM$("emit",249);
        // JavaLine 23 ==> SourceLine 250
        ((CHECKER1$semchecker1$boolop)(CUR$.SL$)).p1$left.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
        ((CHECKER1$semchecker1$boolop)(CUR$.SL$)).p1$left.emit$0().CPF();
        // JavaLine 26 ==> SourceLine 252
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1$semchecker1$boolop)(CUR$.SL$)).p$ch;
        // JavaLine 28 ==> SourceLine 253
        ((CHECKER1$semchecker1$boolop)(CUR$.SL$)).p1$right.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
        ((CHECKER1$semchecker1$boolop)(CUR$.SL$)).p1$right.emit$0().CPF();
        // JavaLine 31 ==> SourceLine 255
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1$semchecker1$boolop)(CUR$.SL$)).p$ch;
        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        TRACE_END_STM$("emit",255);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,249,23,250,26,252,28,253,31,255,37,256);
}
