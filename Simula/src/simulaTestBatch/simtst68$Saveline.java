// JavaLine 1 ==> SourceLine 16
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Feb 10 12:24:00 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst68$Saveline extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=16, lastLine=22, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simtst68$Saveline(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Saveline",16);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst68$Saveline STM$() {
        TRACE_BEGIN_STM$("Saveline",16);
        // JavaLine 23 ==> SourceLine 18
        ((simtst68)(CUR$.SL$)).lnr=(((simtst68)(CUR$.SL$)).lnr+(1));
        // JavaLine 25 ==> SourceLine 19
        ((simtst68)(CUR$.SL$)).lines.Elt[((simtst68)(CUR$.SL$)).lnr-((simtst68)(CUR$.SL$)).lines.LB[0]]=copy(copy(TXT$.strip(sysout().image)));
        // JavaLine 27 ==> SourceLine 20
        TXT$.setpos(sysout().image,1);
        // JavaLine 29 ==> SourceLine 21
        ASGTXT$(sysout().image,null);
        TRACE_END_STM$("Saveline",21);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst68.sim","Procedure Saveline",1,16,23,18,25,19,27,20,29,21,34,22);
}
