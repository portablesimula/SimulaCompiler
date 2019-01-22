// JavaLine 1 ==> SourceLine 381
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:13:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$finn_type extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=381, lastLine=391, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public char p$type;
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 383
    int i=0;
    int nr=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$finn_type setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$finn_type.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$type=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HegnaNRK$PBLK21$finn_type(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$finn_type(RTObject$ SL$,char sp$type) {
        super(SL$);
        // Parameter assignment to locals
        this.p$type = sp$type;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("finn_type",383);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$finn_type STM$() {
        TRACE_BEGIN_STM$("finn_type",383);
        // JavaLine 47 ==> SourceLine 384
        i=nr=0;
        // JavaLine 49 ==> SourceLine 385
        while(((nr==(0))&((i<(((HegnaNRK$PBLK21)(CUR$.SL$)).max_type))))) {
            // JavaLine 51 ==> SourceLine 387
            {
                TRACE_BEGIN_STM$("CompoundStatement387",387);
                i=(i+(1));
                // JavaLine 55 ==> SourceLine 388
                if((p$type==(((HegnaNRK$PBLK21)(CUR$.SL$)).type_tabell.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).type_tabell.LB[0]]))) {
                    nr=i;
                }
                TRACE_END_STM$("CompoundStatement387",388);
            }
        }
        // JavaLine 62 ==> SourceLine 390
        RESULT$=nr;
        TRACE_END_STM$("finn_type",390);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn_type",1,381,15,383,47,384,49,385,51,387,55,388,62,390,67,391);
}
