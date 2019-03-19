// JavaLine 1 ==> SourceLine 132
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:04:25 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12$Warehouse$Van$VanFinished extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=132, lastLine=137, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Docking$PBLK12$Warehouse$Van$VanFinished(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("VanFinished",132);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Docking$PBLK12$Warehouse$Van$VanFinished STM$() {
        TRACE_BEGIN_STM$("VanFinished",132);
        // JavaLine 23 ==> SourceLine 133
        ((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).vanShape.setColor(((Docking$PBLK12)(CUR$.SL$.SL$.SL$)).lightGray);
        // JavaLine 25 ==> SourceLine 134
        ((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).vanShape.moveTo(((double)(700)),((double)(((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).dLine)),((double)(((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).speed)));
        // JavaLine 27 ==> SourceLine 135
        new Docking$PBLK12$trace(((Docking$PBLK12)(CUR$.SL$.SL$.SL$)),CONC(CONC(new TXT$("Van["),objectTraceIdentifier()),new TXT$("] is leaving")));
        // JavaLine 29 ==> SourceLine 136
        ((Docking$PBLK12$Warehouse$Van)(CUR$.SL$)).vanShape.out();
        TRACE_END_STM$("VanFinished",136);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure VanFinished",1,132,23,133,25,134,27,135,29,136,34,137);
}
