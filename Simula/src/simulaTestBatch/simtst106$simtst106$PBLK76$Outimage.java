// JavaLine 1 ==> SourceLine 78
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Mar 18 11:16:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst106$simtst106$PBLK76$Outimage extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=78, lastLine=82, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simtst106$simtst106$PBLK76$Outimage(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Outimage",78);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst106$simtst106$PBLK76$Outimage STM$() {
        TRACE_BEGIN_STM$("Outimage",78);
        // JavaLine 23 ==> SourceLine 79
        ((simtst106$PBLK76)(CUR$.SL$)).utnr=(((simtst106$PBLK76)(CUR$.SL$)).utnr+(1));
        // JavaLine 25 ==> SourceLine 80
        ((simtst106$PBLK76)(CUR$.SL$)).ut.Elt[((simtst106$PBLK76)(CUR$.SL$)).utnr-((simtst106$PBLK76)(CUR$.SL$)).ut.LB[0]]=copy(copy(TXT$.strip(sysout().image)));
        // JavaLine 27 ==> SourceLine 81
        ASGTXT$(sysout().image,null);
        sysout().setpos(1);
        TRACE_END_STM$("Outimage",81);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst106.sim","Procedure Outimage",1,78,23,79,25,80,27,81,33,82);
}
