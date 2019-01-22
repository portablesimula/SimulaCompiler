// JavaLine 1 ==> SourceLine 80
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:06:08 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK13$Warehouse$Van$AnvanceQueue extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=80, lastLine=87, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 81
    Docking$PBLK13$Warehouse$Van v=null;
    int n=0;
    // Normal Constructor
    public Docking$PBLK13$Warehouse$Van$AnvanceQueue(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("AnvanceQueue",81);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Docking$PBLK13$Warehouse$Van$AnvanceQueue STM$() {
        TRACE_BEGIN_STM$("AnvanceQueue",81);
        // JavaLine 26 ==> SourceLine 82
        v=((Docking$PBLK13$Warehouse$Van)(((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).Waiting.first()));
        // JavaLine 28 ==> SourceLine 83
        while((v!=(null))) {
            // JavaLine 30 ==> SourceLine 84
            {
                TRACE_BEGIN_STM$("CompoundStatement84",84);
                v.vanShape.instantMoveTo(((double)((((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).qPos+(((n*(((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).vanHeight))*(2)))))),((double)(((Docking$PBLK13$Warehouse)(CUR$.SL$.SL$)).qLine)));
                // JavaLine 34 ==> SourceLine 85
                n=(n+(1));
                v=((Docking$PBLK13$Warehouse$Van)(v.suc()));
                TRACE_END_STM$("CompoundStatement84",85);
            }
        }
        TRACE_END_STM$("AnvanceQueue",85);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure AnvanceQueue",1,80,11,81,26,82,28,83,30,84,34,85,43,87);
}
