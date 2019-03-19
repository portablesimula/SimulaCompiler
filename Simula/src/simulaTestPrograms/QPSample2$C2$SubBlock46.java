// JavaLine 1 ==> SourceLine 46
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Mar 16 11:38:03 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class QPSample2$C2$SubBlock46 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=3, firstLine=46, lastLine=56, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    QPSample2$C2$SubBlock46$C3 X3=null;
    // Normal Constructor
    public QPSample2$C2$SubBlock46(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock46",48);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock46",48);
        // JavaLine 22 ==> SourceLine 53
        X3=new QPSample2$C2$SubBlock46$C3(((QPSample2$C2$SubBlock46)CUR$)).START();
        // JavaLine 24 ==> SourceLine 54
        new QPSample2$note(((QPSample2)(CUR$.SL$.SL$)),new TXT$("After  Detach C3 - see fig. 7.4"));
        // JavaLine 26 ==> SourceLine 56
        resume(X3);
        TRACE_END_STM$("SubBlock46",56);
        EBLK();
        return(null);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("QPSample2.sim","SubBlock SubBlock46",1,46,22,53,24,54,26,56,31,56);
}
