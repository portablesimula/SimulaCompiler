// JavaLine 1 ==> SourceLine 349
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$valuerel$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=349, lastLine=374, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$valuerel$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",349);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$valuerel$emit STM$() {
        TRACE_BEGIN_STM$("emit",349);
        // JavaLine 23 ==> SourceLine 350
        ((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).p1$left.cl=((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).p1$right.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
        // JavaLine 25 ==> SourceLine 351
        if(VALUE$((((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).opttype==(((CHECKER1)(CUR$.SL$.SL$.SL$)).ITEXT)))) {
            // JavaLine 27 ==> SourceLine 353
            {
                TRACE_BEGIN_STM$("CompoundStatement353",353);
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).p$ch;
                // JavaLine 31 ==> SourceLine 354
                ((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).p1$left.emit$0().CPF();
                // JavaLine 33 ==> SourceLine 356
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ICL;
                call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                // JavaLine 36 ==> SourceLine 357
                ((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).p1$right.emit$0().CPF();
                // JavaLine 38 ==> SourceLine 359
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ISMCL;
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opihi=((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).p$ch;
                TRACE_END_STM$("CompoundStatement353",359);
            }
        } else
        // JavaLine 44 ==> SourceLine 362
        {
            TRACE_BEGIN_STM$("CompoundStatement362",362);
            ((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).p1$left.emit$0().CPF();
            // JavaLine 48 ==> SourceLine 363
            if(VALUE$((((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).opttype!=(((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).p1$left.type)))) {
                // JavaLine 50 ==> SourceLine 364
                new CHECKER1$semchecker1$MaybeConvert(((CHECKER1$semchecker1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).opttype,((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).p1$left.type);
            }
            // JavaLine 53 ==> SourceLine 365
            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).p$ch;
            // JavaLine 55 ==> SourceLine 366
            ((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).p1$right.emit$0().CPF();
            // JavaLine 57 ==> SourceLine 367
            if(VALUE$((((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).opttype!=(((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).p1$right.type)))) {
                // JavaLine 59 ==> SourceLine 368
                new CHECKER1$semchecker1$MaybeConvert(((CHECKER1$semchecker1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).opttype,((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).p1$right.type);
            }
            // JavaLine 62 ==> SourceLine 370
            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).p$ch;
            TRACE_END_STM$("CompoundStatement362",370);
        }
        // JavaLine 66 ==> SourceLine 372
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=((CHECKER1$semchecker1$valuerel)(CUR$.SL$)).cl;
        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
        // JavaLine 69 ==> SourceLine 373
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).valrelList=((CHECKER1$semchecker1$valuerel)(CUR$.SL$));
        TRACE_END_STM$("emit",373);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,349,23,350,25,351,27,353,31,354,33,356,36,357,38,359,44,362,48,363,50,364,53,365,55,366,57,367,59,368,62,370,66,372,69,373,74,374);
}
