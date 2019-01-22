// JavaLine 1 ==> SourceLine 356
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:13:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$finn_kommando extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=356, lastLine=366, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public TXT$ p$kommando;
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 358
    int i=0;
    int nr=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$finn_kommando setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$finn_kommando.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$kommando=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HegnaNRK$PBLK21$finn_kommando(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$finn_kommando(RTObject$ SL$,TXT$ sp$kommando) {
        super(SL$);
        // Parameter assignment to locals
        this.p$kommando = sp$kommando;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("finn_kommando",358);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$finn_kommando STM$() {
        TRACE_BEGIN_STM$("finn_kommando",358);
        // JavaLine 47 ==> SourceLine 359
        i=nr=0;
        // JavaLine 49 ==> SourceLine 360
        while(((nr==(0))&((i<(((HegnaNRK$PBLK21)(CUR$.SL$)).max_kommando))))) {
            // JavaLine 51 ==> SourceLine 362
            {
                TRACE_BEGIN_STM$("CompoundStatement362",362);
                i=(i+(1));
                // JavaLine 55 ==> SourceLine 363
                if(TXTREL$EQ(p$kommando,((HegnaNRK$PBLK21)(CUR$.SL$)).kommando_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).kommando_tabell.LB[0]])) {
                    nr=i;
                }
                TRACE_END_STM$("CompoundStatement362",363);
            }
        }
        // JavaLine 62 ==> SourceLine 365
        RESULT$=nr;
        TRACE_END_STM$("finn_kommando",365);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn_kommando",1,356,15,358,47,359,49,360,51,362,55,363,62,365,67,366);
}
