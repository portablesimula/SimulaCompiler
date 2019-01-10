// JavaLine 1 ==> SourceLine 1206
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$textconst$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1206, lastLine=1227, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$textconst$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",1206);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$textconst$emit STM$() {
        TRACE_BEGIN_STM$("emit",1206);
        // JavaLine 23 ==> SourceLine 1217
        if((((CHECKER1$semchecker1$textconst)(CUR$.SL$)).ixhi==(((CHECKER1)(CUR$.SL$.SL$.SL$)).NUL))) {
            // JavaLine 25 ==> SourceLine 1218
            {
                TRACE_BEGIN_STM$("CompoundStatement1218",1218);
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ITEXT;
                TRACE_END_STM$("CompoundStatement1218",1218);
            }
        } else
        // JavaLine 32 ==> SourceLine 1221
        if((((CHECKER1$semchecker1$textconst)(CUR$.SL$)).id==(null))) {
            // JavaLine 34 ==> SourceLine 1223
            {
                TRACE_BEGIN_STM$("CompoundStatement1223",1223);
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IEXNM;
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opihi=((CHECKER1$semchecker1$textconst)(CUR$.SL$)).ixhi;
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=((CHECKER1$semchecker1$textconst)(CUR$.SL$)).ixlo;
                TRACE_END_STM$("CompoundStatement1223",1223);
            }
        } else
        // JavaLine 43 ==> SourceLine 1225
        {
            TRACE_BEGIN_STM$("CompoundStatement1225",1225);
            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IDENO;
            ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$textconst)(CUR$.SL$)).id.meaning;
            TRACE_END_STM$("CompoundStatement1225",1225);
        }
        // JavaLine 50 ==> SourceLine 1226
        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        TRACE_END_STM$("emit",1226);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,1206,23,1217,25,1218,32,1221,34,1223,43,1225,50,1226,55,1227);
}
