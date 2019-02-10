// JavaLine 1 ==> SourceLine 186
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 10 12:42:17 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12$Warehouse$UpdateReport extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=186, lastLine=198, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Docking$PBLK12$Warehouse$UpdateReport(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("UpdateReport",186);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Docking$PBLK12$Warehouse$UpdateReport STM$() {
        TRACE_BEGIN_STM$("UpdateReport",186);
        // JavaLine 23 ==> SourceLine 187
        sysout().outtext(new TXT$("Simulated Time: "));
        sysout().outfix(((Docking$PBLK12$Warehouse)(CUR$.SL$)).time(),2,8);
        // JavaLine 26 ==> SourceLine 188
        sysout().outtext(new TXT$("   Docks: "));
        sysout().outint(((Docking$PBLK12$Warehouse)(CUR$.SL$)).p2$nDocks,3);
        // JavaLine 29 ==> SourceLine 189
        sysout().outtext(new TXT$("   Waiting: "));
        sysout().outfix(((Docking$PBLK12$Warehouse)(CUR$.SL$)).accWait,2,8);
        // JavaLine 32 ==> SourceLine 190
        sysout().outtext(new TXT$("   nVans: "));
        sysout().outint(((Docking$PBLK12$Warehouse)(CUR$.SL$)).Totnr,3);
        // JavaLine 35 ==> SourceLine 191
        if(VALUE$((((Docking$PBLK12$Warehouse)(CUR$.SL$)).report==(null)))) {
            // JavaLine 37 ==> SourceLine 193
            {
                TRACE_BEGIN_STM$("CompoundStatement193",193);
                ((Docking$PBLK12)(CUR$.SL$.SL$)).setFontStyleBold();
                // JavaLine 41 ==> SourceLine 194
                ((Docking$PBLK12)(CUR$.SL$.SL$)).setDrawColor(((Docking$PBLK12)(CUR$.SL$.SL$)).black);
                // JavaLine 43 ==> SourceLine 195
                ((Docking$PBLK12$Warehouse)(CUR$.SL$)).report=new TextElement$(((Docking$PBLK12)(CUR$.SL$.SL$)),TXT$.strip(sysout().image),((double)(50)),((double)((200+((((Docking$PBLK12)(CUR$.SL$.SL$)).cnt*(15))))))).STM$();
                TRACE_END_STM$("CompoundStatement193",195);
            }
        } else
        // JavaLine 48 ==> SourceLine 196
        ((Docking$PBLK12$Warehouse)(CUR$.SL$)).report.setText(TXT$.strip(sysout().image));
        // JavaLine 50 ==> SourceLine 197
        sysout().outimage();
        TRACE_END_STM$("UpdateReport",197);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure UpdateReport",1,186,23,187,26,188,29,189,32,190,35,191,37,193,41,194,43,195,48,196,50,197,55,198);
}
