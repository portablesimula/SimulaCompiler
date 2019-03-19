// JavaLine 1 ==> SourceLine 14
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri Mar 15 09:22:39 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue13$A$P extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=14, lastLine=27, hasLocalClasses=true, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 16
    int i=0;
    // JavaLine 13 ==> SourceLine 24
    issue13$A rA=null;
    // Normal Constructor
    public issue13$A$P(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("P",24);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public issue13$A$P STM$() {
        TRACE_BEGIN_STM$("P",24);
        // JavaLine 27 ==> SourceLine 25
        rA=new issue13$A$P$C(((issue13$A$P)CUR$)).STM$();
        // JavaLine 29 ==> SourceLine 26
        sysout().outint(((issue13$A$P$C)(rA)).j,9);
        sysout().outimage();
        TRACE_END_STM$("P",26);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("issue13.sim","Procedure P",1,14,11,16,13,24,27,25,29,26,35,27);
}
