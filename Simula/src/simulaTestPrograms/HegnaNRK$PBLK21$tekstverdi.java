// JavaLine 1 ==> SourceLine 106
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:13:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class HegnaNRK$PBLK21$tekstverdi extends HegnaNRK$PBLK21$verdi {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=106, lastLine=213, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 107
    public TXT$ tekst=null;
    public PRCQNT$ kopi$0() { return(new PRCQNT$(this,HegnaNRK$PBLK21$tekstverdi$kopi.class)); }
    public PRCQNT$ les$0() { return(new PRCQNT$(this,HegnaNRK$PBLK21$tekstverdi$les.class)); }
    public PRCQNT$ test_verdilikhet$0() { return(new PRCQNT$(this,HegnaNRK$PBLK21$tekstverdi$test_verdilikhet.class)); }
    public PRCQNT$ test_verdi_mindre$0() { return(new PRCQNT$(this,HegnaNRK$PBLK21$tekstverdi$test_verdi_mindre.class)); }
    public PRCQNT$ skriv$0() { return(new PRCQNT$(this,HegnaNRK$PBLK21$tekstverdi$skriv.class)); }
    // Normal Constructor
    public HegnaNRK$PBLK21$tekstverdi(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("tekstverdi",210);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("tekstverdi",210,inner);
                // JavaLine 28 ==> SourceLine 213
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("tekstverdi",213);
                }
                TRACE_END_STM$("tekstverdi",213);
            }
        };
    } // End of Constructor
    // Class Statements
    public HegnaNRK$PBLK21$tekstverdi STM$() { return((HegnaNRK$PBLK21$tekstverdi)CODE$.EXEC$()); }
    public HegnaNRK$PBLK21$tekstverdi START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Class tekstverdi",1,106,11,107,28,213,39,213);
}
