// JavaLine 1 <== SourceLine 68
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$heltallverdi$kopi extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=68, lastLine=73, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public HegnaNRK$PBLK21$verdi RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 69
    HegnaNRK$PBLK21$heltallverdi k=null;
    // Normal Constructor
    public HegnaNRK$PBLK21$heltallverdi$kopi(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("kopi",69);
        STM$();
    }
    // Procedure Statements
    public HegnaNRK$PBLK21$heltallverdi$kopi STM$() {
        TRACE_BEGIN_STM$("kopi",69);
        // JavaLine 28 <== SourceLine 70
        k=new HegnaNRK$PBLK21$heltallverdi(((HegnaNRK$PBLK21)(CUR$.SL$.SL$))).STM$();
        // JavaLine 30 <== SourceLine 71
        k.tall$1=((HegnaNRK$PBLK21$heltallverdi)(CUR$.SL$)).tall$1;
        // JavaLine 32 <== SourceLine 72
        RESULT$=k;
        TRACE_END_STM$("kopi",72);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure kopi",1,68,14,69,28,70,30,71,32,72,37,73);
} // End of Procedure
