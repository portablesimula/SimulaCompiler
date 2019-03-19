// JavaLine 1 ==> SourceLine 78
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 18:27:05 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst107$PBLK12$getime extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=78, lastLine=81, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public float RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simtst107$PBLK12$getime(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("getime",78);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst107$PBLK12$getime STM$() {
        TRACE_BEGIN_STM$("getime",78);
        // JavaLine 26 ==> SourceLine 79
        RESULT$=((float)(TXT$.getreal(((simtst107$PBLK12)(CUR$.SL$)).actime)));
        // JavaLine 28 ==> SourceLine 80
        ((simtst107$PBLK12)(CUR$.SL$)).actime=TXT$.sub(((simtst107$PBLK12)(CUR$.SL$)).actime,TXT$.pos(((simtst107$PBLK12)(CUR$.SL$)).actime),((TXT$.length(((simtst107$PBLK12)(CUR$.SL$)).actime)-(TXT$.pos(((simtst107$PBLK12)(CUR$.SL$)).actime)))+(1)));
        TRACE_END_STM$("getime",80);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst107.sim","Procedure getime",1,78,26,79,28,80,33,81);
}
