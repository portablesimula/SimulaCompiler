// JavaLine 1 ==> SourceLine 676
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$textconc$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=676, lastLine=686, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$textconc$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",676);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$textconc$emit STM$() {
        TRACE_BEGIN_STM$("emit",676);
        // JavaLine 23 ==> SourceLine 677
        if((((CHECKER1$semchecker1$textconc)(CUR$.SL$)).ntext>(0))) {
            // JavaLine 25 ==> SourceLine 678
            {
                TRACE_BEGIN_STM$("CompoundStatement678",678);
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ICONC;
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opihi=char$(((CHECKER1$semchecker1$textconc)(CUR$.SL$)).ntext);
                // JavaLine 30 ==> SourceLine 679
                call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                // JavaLine 32 ==> SourceLine 680
                LABEL$(1); // NXT
                new CHECKER1$semchecker1$textoperand$emit(((CHECKER1$semchecker1$textconc)(CUR$.SL$)).first);
                ((CHECKER1$semchecker1$textconc)(CUR$.SL$)).first=((CHECKER1$semchecker1$textconc)(CUR$.SL$)).first.next;
                // JavaLine 36 ==> SourceLine 681
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ICONC;
                // JavaLine 38 ==> SourceLine 682
                if((((CHECKER1$semchecker1$textconc)(CUR$.SL$)).first!=(null))) {
                    // JavaLine 40 ==> SourceLine 683
                    {
                        TRACE_BEGIN_STM$("CompoundStatement683",683);
                        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                        GOTO$(((CHECKER1$semchecker1$textconc)(CUR$.SL$)).NXT); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement683",683);
                    }
                }
                // JavaLine 48 ==> SourceLine 684
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=((char)1);
                call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                TRACE_END_STM$("CompoundStatement678",684);
            }
        }
        TRACE_END_STM$("emit",684);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,676,23,677,25,678,30,679,32,680,36,681,38,682,40,683,48,684,57,686);
}
