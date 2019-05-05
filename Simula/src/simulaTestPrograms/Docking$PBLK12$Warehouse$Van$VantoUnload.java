// JavaLine 1 <== SourceLine 121
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:36:39 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12$Warehouse$Van$VantoUnload extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=121, lastLine=125, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Docking$PBLK12$Warehouse$Van$VantoUnload(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("VantoUnload",121);
        STM$();
    }
    // Procedure Statements
    public Docking$PBLK12$Warehouse$Van$VantoUnload STM$() {
        TRACE_BEGIN_STM$("VantoUnload",121);
        // JavaLine 23 <== SourceLine 122
        ((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).vanShape$3.setColor(((Docking$PBLK12)(CUR$.SL$.SL$.SL$)).green$1);
        // JavaLine 25 <== SourceLine 123
        ((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).vanShape$3.moveTo(((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).uPos$2)),((double)(((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).dLine$3)),((double)(((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).speed$3)));
        // JavaLine 27 <== SourceLine 124
        new Docking$PBLK12$trace(((Docking$PBLK12)(CUR$.SL$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is unloading")));
        TRACE_END_STM$("VantoUnload",124);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure VantoUnload",1,121,23,122,25,123,27,124,32,125);
} // End of Procedure
