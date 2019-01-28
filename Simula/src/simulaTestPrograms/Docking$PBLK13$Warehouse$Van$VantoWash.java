// JavaLine 1 ==> SourceLine 109
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Jan 27 17:13:52 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK13$Warehouse$Van$VantoWash extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=109, lastLine=112, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Docking$PBLK13$Warehouse$Van$VantoWash(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("VantoWash",109);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Docking$PBLK13$Warehouse$Van$VantoWash STM$() {
        TRACE_BEGIN_STM$("VantoWash",109);
        // JavaLine 23 ==> SourceLine 110
        ((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).vanShape.moveTo(((double)(((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).wPos)),((double)(((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).dLine)),((double)(((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).speed)));
        // JavaLine 25 ==> SourceLine 111
        new Docking$PBLK13$trace(((Docking$PBLK13)(CUR$.SL$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is washing")));
        TRACE_END_STM$("VantoWash",111);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure VantoWash",1,109,23,110,25,111,30,112);
}
