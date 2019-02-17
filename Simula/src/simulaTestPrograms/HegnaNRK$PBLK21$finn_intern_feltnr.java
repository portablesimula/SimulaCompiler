// JavaLine 1 ==> SourceLine 869
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 17 15:04:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$finn_intern_feltnr extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=869, lastLine=879, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$feltnr;
    // Declare local labels
    // JavaLine 15 ==> SourceLine 878
    final LABQNT$ out=new LABQNT$(this,0,1); // Local Label #1=out
    // Declare locals as attributes
    // JavaLine 18 ==> SourceLine 870
    int i=0;
    int nr=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$finn_intern_feltnr setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$finn_intern_feltnr.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$feltnr=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HegnaNRK$PBLK21$finn_intern_feltnr(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$finn_intern_feltnr(RTObject$ SL$,int sp$feltnr) {
        super(SL$);
        // Parameter assignment to locals
        this.p$feltnr = sp$feltnr;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("finn_intern_feltnr",870);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$finn_intern_feltnr STM$() {
        TRACE_BEGIN_STM$("finn_intern_feltnr",870);
        HegnaNRK$PBLK21$finn_intern_feltnr THIS$=(HegnaNRK$PBLK21$finn_intern_feltnr)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 54 ==> SourceLine 871
                nr=0;
                // JavaLine 56 ==> SourceLine 872
                for(boolean CB$872:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall); }})
                   )) { if(!CB$872) continue;
                // JavaLine 60 ==> SourceLine 873
                if(VALUE$((((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.Elt[i-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.LB[0]]==(p$feltnr)))) {
                    // JavaLine 62 ==> SourceLine 875
                    {
                        TRACE_BEGIN_STM$("CompoundStatement875",875);
                        nr=i;
                        // JavaLine 66 ==> SourceLine 876
                        GOTO$(out); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement875",876);
                    }
                }
            }
            // JavaLine 72 ==> SourceLine 878
            LABEL$(1,"out");
            RESULT$=nr;
            break LOOP$;
        }
        catch(LABQNT$ q) {
            CUR$=THIS$;
            if(q.SL$!=CUR$ || q.prefixLevel!=0) {
                CUR$.STATE$=OperationalState.terminated;
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                throw(q);
            }
            if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
            JTX$=q.index; continue LOOP$; // EG. GOTO Lx
        }
    }
    TRACE_END_STM$("finn_intern_feltnr",878);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn_intern_feltnr",1,869,15,878,18,870,54,871,56,872,60,873,62,875,66,876,72,878,91,879);
}
