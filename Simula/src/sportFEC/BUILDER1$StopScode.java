// JavaLine 1 ==> SourceLine 35
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:51 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$StopScode extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=35, lastLine=42, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 36
    COMMON$outcodefile inspect$36$0=null;
    // Normal Constructor
    public BUILDER1$StopScode(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("StopScode",36);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$StopScode STM$() {
        TRACE_BEGIN_STM$("StopScode",36);
        {
            // BEGIN INSPECTION 
            inspect$36$0=((BUILDER1)(CUR$.SL$)).coder;
            //INSPECT inspect$36$0
            if(inspect$36$0 instanceof BUILDER1$visiblegenerator) // WHEN BUILDER1$visiblegenerator DO 
            // JavaLine 30 ==> SourceLine 37
            {
                TRACE_BEGIN_STM$("CompoundStatement37",37);
                ((BUILDER1)(CUR$.SL$)).coder=new BUILDER1$dummygenerator(((BUILDER1)(CUR$.SL$)),new TXT$("$dum$")).STM$();
                // JavaLine 34 ==> SourceLine 38
                ((BUILDER1$visiblegenerator)(((BUILDER1)(CUR$.SL$)).coder)).SCF=((BUILDER1$visiblegenerator)(inspect$36$0)).SCF;
                TRACE_END_STM$("CompoundStatement37",38);
            }
        }
        // JavaLine 39 ==> SourceLine 41
        ((BUILDER1)(CUR$.SL$)).termstatus=((char)6);
        TRACE_END_STM$("StopScode",41);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure StopScode",1,35,11,36,30,37,34,38,39,41,44,42);
}
