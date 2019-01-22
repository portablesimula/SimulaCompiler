// JavaLine 1 ==> SourceLine 168
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:06:08 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK13$Warehouse$UpdateReport extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=168, lastLine=180, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Docking$PBLK13$Warehouse$UpdateReport(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("UpdateReport",168);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Docking$PBLK13$Warehouse$UpdateReport STM$() {
        TRACE_BEGIN_STM$("UpdateReport",168);
        // JavaLine 23 ==> SourceLine 169
        sysout().outtext(new TXT$("Simulated Time: "));
        sysout().outfix(((Docking$PBLK13$Warehouse)(CUR$.SL$)).time(),2,8);
        // JavaLine 26 ==> SourceLine 170
        sysout().outtext(new TXT$("   Docks: "));
        sysout().outint(((Docking$PBLK13$Warehouse)(CUR$.SL$)).p2$nDocks,3);
        // JavaLine 29 ==> SourceLine 171
        sysout().outtext(new TXT$("   Waiting: "));
        sysout().outfix(((Docking$PBLK13$Warehouse)(CUR$.SL$)).accWait,2,8);
        // JavaLine 32 ==> SourceLine 172
        sysout().outtext(new TXT$("   nVans: "));
        sysout().outint(((Docking$PBLK13$Warehouse)(CUR$.SL$)).Totnr,3);
        // JavaLine 35 ==> SourceLine 173
        if((((Docking$PBLK13$Warehouse)(CUR$.SL$)).report==(null))) {
            // JavaLine 37 ==> SourceLine 175
            {
                TRACE_BEGIN_STM$("CompoundStatement175",175);
                ((Docking$PBLK13)(CUR$.SL$.SL$)).setFontStyleBold();
                // JavaLine 41 ==> SourceLine 176
                ((Docking$PBLK13)(CUR$.SL$.SL$)).setDrawColor(((Docking$PBLK13)(CUR$.SL$.SL$)).black);
                // JavaLine 43 ==> SourceLine 177
                ((Docking$PBLK13$Warehouse)(CUR$.SL$)).report=new TextElement$(((Docking$PBLK13)(CUR$.SL$.SL$)),TXT$.strip(sysout().image),((double)(50)),((double)(250))).STM$();
                TRACE_END_STM$("CompoundStatement175",177);
            }
        } else
        // JavaLine 48 ==> SourceLine 178
        ((Docking$PBLK13$Warehouse)(CUR$.SL$)).report.setText(TXT$.strip(sysout().image));
        // JavaLine 50 ==> SourceLine 179
        sysout().outimage();
        TRACE_END_STM$("UpdateReport",179);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure UpdateReport",1,168,23,169,26,170,29,171,32,172,35,173,37,175,41,176,43,177,48,178,50,179,55,180);
}
