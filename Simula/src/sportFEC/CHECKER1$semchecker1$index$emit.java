// JavaLine 1 ==> SourceLine 2144
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$index$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=2144, lastLine=2152, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$index$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",2144);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$index$emit STM$() {
        TRACE_BEGIN_STM$("emit",2144);
        // JavaLine 23 ==> SourceLine 2145
        ((CHECKER1$semchecker1$index)(CUR$.SL$)).p$actual.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
        ((CHECKER1$semchecker1$index)(CUR$.SL$)).p$actual.emit$0().CPF();
        // JavaLine 26 ==> SourceLine 2146
        if((((CHECKER1$semchecker1$index)(CUR$.SL$)).p$actual.type!=(((CHECKER1)(CUR$.SL$.SL$.SL$)).IINTG))) {
            // JavaLine 28 ==> SourceLine 2147
            new CHECKER1$semchecker1$MaybeConvert(((CHECKER1$semchecker1)(CUR$.SL$.SL$)),((CHECKER1)(CUR$.SL$.SL$.SL$)).IINTG,((CHECKER1$semchecker1$index)(CUR$.SL$)).p$actual.type);
        }
        // JavaLine 31 ==> SourceLine 2148
        if((((CHECKER1$semchecker1$index)(CUR$.SL$)).nextarg!=(null))) {
            // JavaLine 33 ==> SourceLine 2149
            {
                TRACE_BEGIN_STM$("CompoundStatement2149",2149);
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ICOMA;
                call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                // JavaLine 38 ==> SourceLine 2150
                ((CHECKER1$semchecker1$index)(CUR$.SL$)).nextarg.emit$0().CPF();
                TRACE_END_STM$("CompoundStatement2149",2150);
            }
        }
        TRACE_END_STM$("emit",2150);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,2144,23,2145,26,2146,28,2147,31,2148,33,2149,38,2150,46,2152);
}
