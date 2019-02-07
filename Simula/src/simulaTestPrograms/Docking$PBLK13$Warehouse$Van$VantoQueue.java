// JavaLine 1 ==> SourceLine 74
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:37:33 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK13$Warehouse$Van$VantoQueue extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=74, lastLine=78, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Docking$PBLK13$Warehouse$Van$VantoQueue(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("VantoQueue",74);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Docking$PBLK13$Warehouse$Van$VantoQueue STM$() {
        TRACE_BEGIN_STM$("VantoQueue",74);
        // JavaLine 23 ==> SourceLine 75
        ((Docking$PBLK13)(CUR$.SL$.SL$.SL$)).setFillColor(((Docking$PBLK13)(CUR$.SL$.SL$.SL$)).red);
        // JavaLine 25 ==> SourceLine 76
        ((Docking$PBLK13$Warehouse$Van)(CUR$.SL$)).vanShape.fillRectangle(((double)((((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).qPos+(((((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).qLength*(((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).vanHeight))*(2)))))),((double)(((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).qLine)),((double)(((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).vanWidth)),((double)(((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).vanHeight)));
        // JavaLine 27 ==> SourceLine 77
        ((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).qLength=(((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).qLength+(1));
        TRACE_END_STM$("VantoQueue",77);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure VantoQueue",1,74,23,75,25,76,27,77,32,78);
}
