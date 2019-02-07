// JavaLine 1 ==> SourceLine 114
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:37:33 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK13$Warehouse$Van$VanFinished extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=114, lastLine=119, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Docking$PBLK13$Warehouse$Van$VanFinished(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("VanFinished",114);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Docking$PBLK13$Warehouse$Van$VanFinished STM$() {
        TRACE_BEGIN_STM$("VanFinished",114);
        // JavaLine 23 ==> SourceLine 115
        ((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).vanShape.setColor(((Docking$PBLK13)(CUR$.SL$.SL$.SL$)).lightGray);
        // JavaLine 25 ==> SourceLine 116
        ((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).vanShape.moveTo(((double)(700)),((double)(((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).dLine)),((double)(((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).speed)));
        // JavaLine 27 ==> SourceLine 117
        new Docking$PBLK13$trace(((Docking$PBLK13)(CUR$.SL$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is leaving")));
        // JavaLine 29 ==> SourceLine 118
        ((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).vanShape.out();
        TRACE_END_STM$("VanFinished",118);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure VanFinished",1,114,23,115,25,116,27,117,29,118,34,119);
}
