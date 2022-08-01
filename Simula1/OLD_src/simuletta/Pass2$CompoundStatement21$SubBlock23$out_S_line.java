// JavaLine 1 <== SourceLine 39
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:53 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$out_S_line extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=39, lastLine=43, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$out_S_line(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$out_S_line STM$() {
        // JavaLine 20 <== SourceLine 40
        ((Pass2)(CUR$.SL$.SL$)).inspect$20$141.curline$1=new InptFile$innumber(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
        ;
        // JavaLine 23 <== SourceLine 41
        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_LINE$1);
        ;
        new OuptFile$outnumber(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.curline$1);
        ;
        // JavaLine 28 <== SourceLine 42
        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure out_S_line",1,39,20,40,23,41,28,42,35,43);
} // End of Procedure
