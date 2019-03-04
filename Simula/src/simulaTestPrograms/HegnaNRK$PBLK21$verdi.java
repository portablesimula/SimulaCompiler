// JavaLine 1 ==> SourceLine 56
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 04 20:15:38 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class HegnaNRK$PBLK21$verdi extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=56, lastLine=64, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    public PRCQNT$ skriv$0() { throw new RuntimeException("No Virtual Match"); }
    public PRCQNT$ les$0() { throw new RuntimeException("No Virtual Match"); }
    public PRCQNT$ test_verdilikhet$0() { throw new RuntimeException("No Virtual Match"); }
    public PRCQNT$ test_verdi_mindre$0() { throw new RuntimeException("No Virtual Match"); }
    public PRCQNT$ kopi$0() { throw new RuntimeException("No Virtual Match"); }
    // Normal Constructor
    public HegnaNRK$PBLK21$verdi(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("verdi",56);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("verdi",56,inner);
                // JavaLine 27 ==> SourceLine 64
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("verdi",64);
                }
                TRACE_END_STM$("verdi",64);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public HegnaNRK$PBLK21$verdi STM$() { return((HegnaNRK$PBLK21$verdi)CODE$.EXEC$()); }
    public HegnaNRK$PBLK21$verdi START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Class verdi",1,56,27,64,39,64);
}
