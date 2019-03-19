// JavaLine 1 ==> SourceLine 323
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:03:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$lede_tekst extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=323, lastLine=331, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$tekst;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$lede_tekst setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$lede_tekst.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$tekst=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HegnaNRK$PBLK21$lede_tekst(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$lede_tekst(RTObject$ SL$,TXT$ sp$tekst) {
        super(SL$);
        // Parameter assignment to locals
        this.p$tekst = sp$tekst;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("lede_tekst",323);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$lede_tekst STM$() {
        TRACE_BEGIN_STM$("lede_tekst",323);
        // JavaLine 41 ==> SourceLine 326
        if(VALUE$((TXT$.length(TXT$.strip(sysin().image))<(TXT$.pos(sysin().image))))) {
            // JavaLine 43 ==> SourceLine 328
            {
                TRACE_BEGIN_STM$("CompoundStatement328",328);
                sysout().outtext(p$tekst);
                // JavaLine 47 ==> SourceLine 329
                sysout().breakoutimage();
                TRACE_END_STM$("CompoundStatement328",329);
            }
        }
        TRACE_END_STM$("lede_tekst",329);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure lede_tekst",1,323,41,326,43,328,47,329,55,331);
}
