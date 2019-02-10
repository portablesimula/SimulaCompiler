// JavaLine 1 ==> SourceLine 431
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$arithop$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=431, lastLine=443, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 432
    CHECKER1$semchecker1$exp inspect$432$2=null;
    // Normal Constructor
    public CHECKER1$semchecker1$arithop$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",432);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$arithop$emit STM$() {
        TRACE_BEGIN_STM$("emit",432);
        {
            // BEGIN INSPECTION 
            inspect$432$2=((CHECKER1$semchecker1$arithop)(CUR$.SL$)).p1$left;
            if(inspect$432$2!=null) //INSPECT inspect$432$2
            // JavaLine 29 ==> SourceLine 433
            {
                TRACE_BEGIN_STM$("CompoundStatement433",433);
                inspect$432$2.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
                inspect$432$2.emit$0().CPF();
                // JavaLine 34 ==> SourceLine 434
                if(VALUE$((((CHECKER1$semchecker1$arithop)(CUR$.SL$)).type!=(inspect$432$2.type)))) {
                    // JavaLine 36 ==> SourceLine 435
                    new CHECKER1$semchecker1$MaybeConvert(((CHECKER1$semchecker1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$arithop)(CUR$.SL$)).type,inspect$432$2.type);
                }
                TRACE_END_STM$("CompoundStatement433",435);
            }
        }
        // JavaLine 42 ==> SourceLine 438
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1$semchecker1$arithop)(CUR$.SL$)).p$ch;
        // JavaLine 44 ==> SourceLine 439
        ((CHECKER1$semchecker1$arithop)(CUR$.SL$)).p1$right.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
        ((CHECKER1$semchecker1$arithop)(CUR$.SL$)).p1$right.emit$0().CPF();
        // JavaLine 47 ==> SourceLine 440
        if(VALUE$((((CHECKER1$semchecker1$arithop)(CUR$.SL$)).type!=(((CHECKER1$semchecker1$arithop)(CUR$.SL$)).p1$right.type)))) {
            new CHECKER1$semchecker1$MaybeConvert(((CHECKER1$semchecker1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$arithop)(CUR$.SL$)).type,((CHECKER1$semchecker1$arithop)(CUR$.SL$)).p1$right.type);
        }
        // JavaLine 51 ==> SourceLine 442
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1$semchecker1$arithop)(CUR$.SL$)).p$ch;
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opt=((CHECKER1$semchecker1$arithop)(CUR$.SL$)).type;
        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        TRACE_END_STM$("emit",442);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,431,11,432,29,433,34,434,36,435,42,438,44,439,47,440,51,442,58,443);
}
