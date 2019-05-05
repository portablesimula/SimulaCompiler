// JavaLine 1 <== SourceLine 92
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:36:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12$Warehouse$Van$VantoQueue extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=92, lastLine=96, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Docking$PBLK12$Warehouse$Van$VantoQueue(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("VantoQueue",92);
        STM$();
    }
    // Procedure Statements
    public Docking$PBLK12$Warehouse$Van$VantoQueue STM$() {
        TRACE_BEGIN_STM$("VantoQueue",92);
        // JavaLine 23 <== SourceLine 93
        ((Docking$PBLK12)(CUR$.SL$.SL$.SL$)).setFillColor(((Docking$PBLK12)(CUR$.SL$.SL$.SL$)).red$1);
        // JavaLine 25 <== SourceLine 94
        ((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).vanShape$3.fillRectangle(((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).qPos$2+(((((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).qLength$2*(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).vanHeight$2))*(2)))))),((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).qLine$2)),((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).vanWidth$2)),((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).vanHeight$2)));
        // JavaLine 27 <== SourceLine 95
        ((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).qLength$2=(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).qLength$2+(1));
        TRACE_END_STM$("VantoQueue",95);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure VantoQueue",1,92,23,93,25,94,27,95,32,96);
} // End of Procedure
