// JavaLine 1 ==> SourceLine 98
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:04:25 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12$Warehouse$Van$AnvanceQueue extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=98, lastLine=105, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 99
    Docking$PBLK12$Warehouse$Van v=null;
    int n=0;
    // Normal Constructor
    public Docking$PBLK12$Warehouse$Van$AnvanceQueue(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("AnvanceQueue",99);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Docking$PBLK12$Warehouse$Van$AnvanceQueue STM$() {
        TRACE_BEGIN_STM$("AnvanceQueue",99);
        // JavaLine 26 ==> SourceLine 100
        v=((Docking$PBLK12$Warehouse$Van)(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).Waiting.first()));
        // JavaLine 28 ==> SourceLine 101
        while((v!=(null))) {
            // JavaLine 30 ==> SourceLine 102
            {
                TRACE_BEGIN_STM$("CompoundStatement102",102);
                v.vanShape.instantMoveTo(((double)((((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).qPos+(((n*(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).vanHeight))*(2)))))),((double)(((Docking$PBLK12$Warehouse)(CUR$.SL$.SL$)).qLine)));
                // JavaLine 34 ==> SourceLine 103
                n=(n+(1));
                v=((Docking$PBLK12$Warehouse$Van)(v.suc()));
                TRACE_END_STM$("CompoundStatement102",103);
            }
        }
        TRACE_END_STM$("AnvanceQueue",103);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure AnvanceQueue",1,98,11,99,26,100,28,101,30,102,34,103,43,105);
}
