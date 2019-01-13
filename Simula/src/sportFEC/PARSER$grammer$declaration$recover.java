// JavaLine 1 ==> SourceLine 776
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:25 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$declaration$recover extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=776, lastLine=785, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$declaration$recover(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("recover",776);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$declaration$recover STM$() {
        TRACE_BEGIN_STM$("recover",776);
        // JavaLine 26 ==> SourceLine 777
        if((((PARSER$grammer$declaration)(CUR$.SL$)).errorno==(2))) {
            // JavaLine 28 ==> SourceLine 780
            {
                TRACE_BEGIN_STM$("CompoundStatement780",780);
                if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IEOP))) {
                    // JavaLine 32 ==> SourceLine 781
                    {
                        TRACE_BEGIN_STM$("CompoundStatement781",781);
                        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((((((PARSER$grammer$declaration)(CUR$.SL$)).rp<=(((char)1)))||(((((PARSER$grammer$declaration)(CUR$.SL$)).rp==(((char)2)))&(((PARSER$grammer$declaration)(CUR$.SL$)).innerseen)))))?(((PARSER)(CUR$.SL$.SL$.SL$)).IEND):(((PARSER)(CUR$.SL$.SL$.SL$)).IECWI));
                        // JavaLine 36 ==> SourceLine 783
                        ((PARSER)(CUR$.SL$.SL$.SL$)).opdlo=((char)1);
                        call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                        ((PARSER$grammer)(CUR$.SL$.SL$)).blockfound=(((PARSER$grammer)(CUR$.SL$.SL$)).blockfound-(1));
                        TRACE_END_STM$("CompoundStatement781",783);
                    }
                } else
                // JavaLine 43 ==> SourceLine 784
                ((PARSER$grammer$declaration)(CUR$.SL$)).recovered=RESULT$=true;
                TRACE_END_STM$("CompoundStatement780",784);
            }
        }
        TRACE_END_STM$("recover",784);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure recover",1,776,26,777,28,780,32,781,36,783,43,784,51,785);
}
