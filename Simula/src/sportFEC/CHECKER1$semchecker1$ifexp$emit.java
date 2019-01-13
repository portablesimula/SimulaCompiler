// JavaLine 1 ==> SourceLine 1098
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$ifexp$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1098, lastLine=1118, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$ifexp$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",1098);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$ifexp$emit STM$() {
        TRACE_BEGIN_STM$("emit",1098);
        // JavaLine 23 ==> SourceLine 1100
        ((CHECKER1)(CUR$.SL$.SL$.SL$)).notinconditional=false;
        ((CHECKER1)(CUR$.SL$.SL$.SL$)).generalgoto=((CHECKER1)(CUR$.SL$.SL$.SL$)).ingotostmt;
        // JavaLine 26 ==> SourceLine 1101
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IIF;
        // JavaLine 28 ==> SourceLine 1102
        ((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).p2$testexp.cl=(((((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).p2$testexp.ctype==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IEQ)))?(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IIFcl):(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl));
        // JavaLine 30 ==> SourceLine 1106
        ((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).p2$testexp.emit$0().CPF();
        // JavaLine 32 ==> SourceLine 1107
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ITHEN;
        // JavaLine 34 ==> SourceLine 1109
        if((((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).p2$testexp.ctype!=(((CHECKER1)(CUR$.SL$.SL$.SL$)).IEQ))) {
            call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        }
        // JavaLine 38 ==> SourceLine 1110
        ((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).p1$left.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
        ((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).p1$left.emit$0().CPF();
        // JavaLine 41 ==> SourceLine 1111
        if((((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).type!=(((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).p1$left.type))) {
            // JavaLine 43 ==> SourceLine 1112
            new CHECKER1$semchecker1$MaybeConvert(((CHECKER1$semchecker1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).type,((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).p1$left.type);
        }
        // JavaLine 46 ==> SourceLine 1113
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IELSE;
        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        // JavaLine 49 ==> SourceLine 1114
        ((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).p1$right.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
        ((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).p1$right.emit$0().CPF();
        // JavaLine 52 ==> SourceLine 1115
        if((((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).type!=(((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).p1$right.type))) {
            // JavaLine 54 ==> SourceLine 1116
            new CHECKER1$semchecker1$MaybeConvert(((CHECKER1$semchecker1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).type,((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).p1$right.type);
        }
        // JavaLine 57 ==> SourceLine 1117
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IEEXP;
        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        TRACE_END_STM$("emit",1117);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,1098,23,1100,26,1101,28,1102,30,1106,32,1107,34,1109,38,1110,41,1111,43,1112,46,1113,49,1114,52,1115,54,1116,57,1117,63,1118);
}
