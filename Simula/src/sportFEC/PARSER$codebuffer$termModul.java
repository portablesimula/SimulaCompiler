// JavaLine 1 ==> SourceLine 76
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:46:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$codebuffer$termModul extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=76, lastLine=87, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 77
    char optxp=0;
    char opdhip=0;
    char opdlop=0;
    // Normal Constructor
    public PARSER$codebuffer$termModul(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("termModul",77);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$codebuffer$termModul STM$() {
        TRACE_BEGIN_STM$("termModul",77);
        // JavaLine 27 ==> SourceLine 78
        opdhip=((PARSER)(CUR$.SL$.SL$)).opdhi;
        opdlop=((PARSER)(CUR$.SL$.SL$)).opdlo;
        optxp=((PARSER)(CUR$.SL$.SL$)).optx;
        // JavaLine 31 ==> SourceLine 79
        if(((PARSER)(CUR$.SL$.SL$)).separatecomp) {
        } else
        // JavaLine 34 ==> SourceLine 81
        {
            TRACE_BEGIN_STM$("CompoundStatement81",81);
            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IDCLE;
            call(((PARSER$codebuffer)(CUR$.SL$)).prev);
            // JavaLine 39 ==> SourceLine 82
            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IBLKB;
            call(((PARSER$codebuffer)(CUR$.SL$)).prev);
            // JavaLine 42 ==> SourceLine 83
            ((PARSER$grammer)(((PARSER)(CUR$.SL$.SL$)).parser)).blockfound=1;
            TRACE_END_STM$("CompoundStatement81",83);
        }
        // JavaLine 46 ==> SourceLine 85
        new PARSER$codebuffer$terminate(((PARSER$codebuffer)(CUR$.SL$)));
        // JavaLine 48 ==> SourceLine 86
        ((PARSER)(CUR$.SL$.SL$)).opdhi=opdhip;
        ((PARSER)(CUR$.SL$.SL$)).opdlo=opdlop;
        ((PARSER)(CUR$.SL$.SL$)).optx=optxp;
        TRACE_END_STM$("termModul",86);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure termModul",1,76,11,77,27,78,31,79,34,81,39,82,42,83,46,85,48,86,55,87);
}
