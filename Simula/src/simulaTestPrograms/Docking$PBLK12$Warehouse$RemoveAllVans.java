// JavaLine 1 ==> SourceLine 39
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:04:25 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12$Warehouse$RemoveAllVans extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=39, lastLine=52, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 40
    Link$ elt=null;
    Link$ next=null;
    // JavaLine 14 ==> SourceLine 45
    Link$ inspect$45$13=null;
    // Normal Constructor
    public Docking$PBLK12$Warehouse$RemoveAllVans(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("RemoveAllVans",45);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Docking$PBLK12$Warehouse$RemoveAllVans STM$() {
        TRACE_BEGIN_STM$("RemoveAllVans",45);
        // JavaLine 28 ==> SourceLine 42
        elt=((Docking$PBLK12)(CUR$.SL$.SL$)).renderingSet().first();
        // JavaLine 30 ==> SourceLine 43
        while((elt!=(null))) {
            // JavaLine 32 ==> SourceLine 44
            {
                TRACE_BEGIN_STM$("CompoundStatement44",44);
                next=elt.suc();
                // JavaLine 36 ==> SourceLine 45
                {
                    // BEGIN INSPECTION 
                    inspect$45$13=elt;
                    //INSPECT inspect$45$13
                    if(inspect$45$13 instanceof ShapeElement$) // WHEN ShapeElement$ DO 
                    // JavaLine 42 ==> SourceLine 46
                    {
                        TRACE_BEGIN_STM$("CompoundStatement46",46);
                        ((ShapeElement$)inspect$45$13).instantMoveTo(((double)(5000)),((double)(5000)));
                        // JavaLine 46 ==> SourceLine 48
                        ((ShapeElement$)inspect$45$13).out();
                        TRACE_END_STM$("CompoundStatement46",48);
                    }
                }
                // JavaLine 51 ==> SourceLine 50
                elt=next;
                TRACE_END_STM$("CompoundStatement44",50);
            }
        }
        TRACE_END_STM$("RemoveAllVans",50);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure RemoveAllVans",1,39,11,40,14,45,28,42,30,43,32,44,36,45,42,46,46,48,51,50,59,52);
}
