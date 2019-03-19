// JavaLine 1 ==> SourceLine 17
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 18:27:05 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst107$PBLK12$outimage extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=17, lastLine=21, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simtst107$PBLK12$outimage(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("outimage",17);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst107$PBLK12$outimage STM$() {
        TRACE_BEGIN_STM$("outimage",17);
        // JavaLine 23 ==> SourceLine 18
        ((simtst107$PBLK12)(CUR$.SL$)).utno=(((simtst107$PBLK12)(CUR$.SL$)).utno+(1));
        ((simtst107$PBLK12)(CUR$.SL$)).ut.Elt[((simtst107$PBLK12)(CUR$.SL$)).utno-((simtst107$PBLK12)(CUR$.SL$)).ut.LB[0]]=copy(copy(TXT$.strip(sysout().image)));
        // JavaLine 26 ==> SourceLine 19
        ASGTXT$(sysout().image,null);
        // JavaLine 28 ==> SourceLine 20
        sysout().setpos(1);
        TRACE_END_STM$("outimage",20);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst107.sim","Procedure outimage",1,17,23,18,26,19,28,20,33,21);
}
