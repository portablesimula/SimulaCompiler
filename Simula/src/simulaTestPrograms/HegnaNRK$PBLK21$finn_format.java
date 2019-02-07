// JavaLine 1 ==> SourceLine 967
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Feb 06 21:32:37 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$finn_format extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=967, lastLine=978, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public TXT$ p$form;
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 969
    int i=0;
    int nr=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$finn_format setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$finn_format.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$form=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HegnaNRK$PBLK21$finn_format(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$finn_format(RTObject$ SL$,TXT$ sp$form) {
        super(SL$);
        // Parameter assignment to locals
        this.p$form = sp$form;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("finn_format",969);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$finn_format STM$() {
        TRACE_BEGIN_STM$("finn_format",969);
        // JavaLine 47 ==> SourceLine 970
        i=nr=0;
        // JavaLine 49 ==> SourceLine 971
        while(((nr==(0))&((i<(((HegnaNRK$PBLK21)(CUR$.SL$)).antall_format_def))))) {
            // JavaLine 51 ==> SourceLine 973
            {
                TRACE_BEGIN_STM$("CompoundStatement973",973);
                i=(i+(1));
                // JavaLine 55 ==> SourceLine 974
                if(VALUE$(TXTREL$EQ(p$form,((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).formatnavn_tabell.LB[0]]))) {
                    // JavaLine 57 ==> SourceLine 975
                    nr=i;
                }
                TRACE_END_STM$("CompoundStatement973",975);
            }
        }
        // JavaLine 63 ==> SourceLine 977
        RESULT$=nr;
        TRACE_END_STM$("finn_format",977);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn_format",1,967,15,969,47,970,49,971,51,973,55,974,57,975,63,977,68,978);
}
