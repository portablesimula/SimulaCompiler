// JavaLine 1 ==> SourceLine 127
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:04:25 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12$Warehouse$Van$VantoWash extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=127, lastLine=130, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Docking$PBLK12$Warehouse$Van$VantoWash(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("VantoWash",127);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Docking$PBLK12$Warehouse$Van$VantoWash STM$() {
        TRACE_BEGIN_STM$("VantoWash",127);
        // JavaLine 23 ==> SourceLine 128
        ((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).vanShape.moveTo(((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).wPos)),((double)(((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).dLine)),((double)(((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).speed)));
        // JavaLine 25 ==> SourceLine 129
        new Docking$PBLK12$trace(((Docking$PBLK12)(CUR$.SL$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is washing")));
        TRACE_END_STM$("VantoWash",129);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure VantoWash",1,127,23,128,25,129,30,130);
}
