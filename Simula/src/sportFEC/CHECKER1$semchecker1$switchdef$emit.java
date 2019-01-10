// JavaLine 1 ==> SourceLine 2545
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$switchdef$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=2545, lastLine=2559, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 2546
    CHECKER1$semchecker1$switchelement swel=null;
    // Normal Constructor
    public CHECKER1$semchecker1$switchdef$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",2546);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$switchdef$emit STM$() {
        TRACE_BEGIN_STM$("emit",2546);
        // JavaLine 25 ==> SourceLine 2547
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ISWIT;
        // JavaLine 27 ==> SourceLine 2548
        ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((((((CHECKER1$semchecker1$switchdef)(CUR$.SL$)).sw.categ==(((CHECKER1)(CUR$.SL$.SL$.SL$)).C_virt))&&((((CHECKER1$semchecker1$switchdef)(CUR$.SL$)).sw.match!=(null)))))?(((CHECKER1$semchecker1$switchdef)(CUR$.SL$)).sw.match):(((CHECKER1$semchecker1$switchdef)(CUR$.SL$)).sw));
        // JavaLine 29 ==> SourceLine 2550
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=((((CHECKER1$semchecker1$switchdef)(CUR$.SL$)).plain)?(((char)1)):(((char)2)));
        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        // JavaLine 32 ==> SourceLine 2551
        swel=((CHECKER1$semchecker1$switchdef)(CUR$.SL$)).elements;
        // JavaLine 34 ==> SourceLine 2552
        while((swel!=(null))) {
            // JavaLine 36 ==> SourceLine 2553
            {
                TRACE_BEGIN_STM$("CompoundStatement2553",2553);
                new CHECKER1$semchecker1$switchelement$emit(swel);
                // JavaLine 40 ==> SourceLine 2554
                ((CHECKER1)(CUR$.SL$.SL$.SL$)).notinconditional=true;
                // JavaLine 42 ==> SourceLine 2555
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ISWEE;
                // JavaLine 44 ==> SourceLine 2556
                swel=swel.next;
                TRACE_END_STM$("CompoundStatement2553",2556);
            }
        }
        // JavaLine 49 ==> SourceLine 2558
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ISWDE;
        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        TRACE_END_STM$("emit",2558);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,2545,11,2546,25,2547,27,2548,29,2550,32,2551,34,2552,36,2553,40,2554,42,2555,44,2556,49,2558,55,2559);
}
