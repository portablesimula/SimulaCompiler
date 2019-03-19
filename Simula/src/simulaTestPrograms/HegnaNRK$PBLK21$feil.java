// JavaLine 1 ==> SourceLine 258
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:03:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$feil extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=258, lastLine=263, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$feil setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$feil.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HegnaNRK$PBLK21$feil(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$feil(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("feil",258);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$feil STM$() {
        TRACE_BEGIN_STM$("feil",258);
        // JavaLine 41 ==> SourceLine 261
        sysout().outtext(new TXT$("Feilmelding nr.:"));
        // JavaLine 43 ==> SourceLine 262
        sysout().outint(p$i,4);
        sysout().outimage();
        TRACE_END_STM$("feil",262);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure feil",1,258,41,261,43,262,49,263);
}
