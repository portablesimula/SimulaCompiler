package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 17 15:04:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class HegnaNRK$PBLK21$heltallverdi extends HegnaNRK$PBLK21$verdi {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=64, lastLine=104, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 ==> SourceLine 65
    public int tall=0;
    public PRCQNT$ skriv$0() { return(new PRCQNT$(this,HegnaNRK$PBLK21$heltallverdi$skriv.class)); }
    public PRCQNT$ kopi$0() { return(new PRCQNT$(this,HegnaNRK$PBLK21$heltallverdi$kopi.class)); }
    public PRCQNT$ test_verdilikhet$0() { return(new PRCQNT$(this,HegnaNRK$PBLK21$heltallverdi$test_verdilikhet.class)); }
    public PRCQNT$ test_verdi_mindre$0() { return(new PRCQNT$(this,HegnaNRK$PBLK21$heltallverdi$test_verdi_mindre.class)); }
    public PRCQNT$ les$0() { return(new PRCQNT$(this,HegnaNRK$PBLK21$heltallverdi$les.class)); }
    // Normal Constructor
    public HegnaNRK$PBLK21$heltallverdi(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("heltallverdi",101);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("heltallverdi",101,inner);
                // JavaLine 27 ==> SourceLine 104
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("heltallverdi",104);
                }
                TRACE_END_STM$("heltallverdi",104);
            }
        };
    } // End of Constructor
    // Class Statements
    public HegnaNRK$PBLK21$heltallverdi STM$() { return((HegnaNRK$PBLK21$heltallverdi)CODE$.EXEC$()); }
    public HegnaNRK$PBLK21$heltallverdi START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Class heltallverdi",10,65,27,104,38,104);
}
