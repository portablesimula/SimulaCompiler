// JavaLine 1 ==> SourceLine 103
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:37:33 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK13$Warehouse$Van$VantoUnload extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=103, lastLine=107, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Docking$PBLK13$Warehouse$Van$VantoUnload(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("VantoUnload",103);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Docking$PBLK13$Warehouse$Van$VantoUnload STM$() {
        TRACE_BEGIN_STM$("VantoUnload",103);
        // JavaLine 23 ==> SourceLine 104
        ((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).vanShape.setColor(((Docking$PBLK13)(CUR$.SL$.SL$.SL$)).green);
        // JavaLine 25 ==> SourceLine 105
        ((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).vanShape.moveTo(((double)(((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).uPos)),((double)(((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).dLine)),((double)(((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).speed)));
        // JavaLine 27 ==> SourceLine 106
        new Docking$PBLK13$trace(((Docking$PBLK13)(CUR$.SL$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is unloading")));
        TRACE_END_STM$("VantoUnload",106);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure VantoUnload",1,103,23,104,25,105,27,106,32,107);
}
