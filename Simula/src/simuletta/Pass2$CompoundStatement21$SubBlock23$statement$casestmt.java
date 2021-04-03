// JavaLine 1 <== SourceLine 499
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$statement$casestmt extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=499, lastLine=551, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 500
    int lb=0;
    int ub=0;
    // JavaLine 13 <== SourceLine 533
    Pass2$CompoundStatement21$SubBlock23$program_point inspect$533$175=null;
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$statement$casestmt(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$statement$casestmt STM$() {
        // JavaLine 25 <== SourceLine 500
        lb=new InptFile$innumber(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$;
        ;
        ub=new InptFile$innumber(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$;
        ;
        // JavaLine 30 <== SourceLine 550
        new Pass2$CompoundStatement21$SubBlock23$statement$casestmt$SubBlock501((CUR$)).STM$();
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure casestmt",1,499,10,500,13,533,25,500,30,550,35,551);
} // End of Procedure
