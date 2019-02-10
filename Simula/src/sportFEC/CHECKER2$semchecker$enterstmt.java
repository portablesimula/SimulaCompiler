// JavaLine 1 ==> SourceLine 64
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:52:33 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER2$semchecker$enterstmt extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=64, lastLine=74, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 69
    COMMON$brecord inspect$69$0=null;
    // Normal Constructor
    public CHECKER2$semchecker$enterstmt(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("enterstmt",69);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER2$semchecker$enterstmt STM$() {
        TRACE_BEGIN_STM$("enterstmt",69);
        // JavaLine 25 ==> SourceLine 67
        new BUILDER2$prechecker$allocate(((CHECKER2$semchecker)(CUR$.SL$)));
        // JavaLine 27 ==> SourceLine 69
        {
            // BEGIN INSPECTION 
            inspect$69$0=new COMMON$getBrc(((CHECKER2)(CUR$.SL$.SL$)),((CHECKER2$semchecker)(CUR$.SL$)).lastblhi,((CHECKER2$semchecker)(CUR$.SL$)).lastbllo).RESULT$;
            if(inspect$69$0!=null) //INSPECT inspect$69$0
            // JavaLine 32 ==> SourceLine 70
            {
                TRACE_BEGIN_STM$("CompoundStatement70",70);
                ((CHECKER2)(CUR$.SL$.SL$)).display.Elt[rank(((CHECKER2)(CUR$.SL$.SL$)).cblev)-((CHECKER2)(CUR$.SL$.SL$)).display.LB[0]]=((COMMON$brecord)inspect$69$0);
                // JavaLine 36 ==> SourceLine 71
                ((ARRAY$<COMMON$brecord[]>)((CHECKER2)(CUR$.SL$.SL$)).brctab.Elt[rank(((CHECKER2$semchecker)(CUR$.SL$)).lastblhi)-((CHECKER2)(CUR$.SL$.SL$)).brctab.LB[0]].val).Elt[rank(((CHECKER2$semchecker)(CUR$.SL$)).lastbllo)-((CHECKER2)(CUR$.SL$.SL$)).brctab.Elt[rank(((CHECKER2$semchecker)(CUR$.SL$)).lastblhi)-((CHECKER2)(CUR$.SL$.SL$)).brctab.LB[0]].val.LB[0]]=null;
                // JavaLine 38 ==> SourceLine 72
                new BUILDER1$precheck0$vischain(((CHECKER2$semchecker)(CUR$.SL$)),inspect$69$0.fpar,((CHECKER2$semchecker)(CUR$.SL$)).visq);
                TRACE_END_STM$("CompoundStatement70",72);
            }
        }
        TRACE_END_STM$("enterstmt",72);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Procedure enterstmt",1,64,11,69,25,67,27,69,32,70,36,71,38,72,46,74);
}
