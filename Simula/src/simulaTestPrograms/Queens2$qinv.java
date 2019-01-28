// JavaLine 1 ==> SourceLine 52
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Jan 23 17:07:34 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Queens2$qinv extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=52, lastLine=56, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$i;
    // Declare local labels
    // JavaLine 15 ==> SourceLine 55
    final LABQNT$ EX=new LABQNT$(this,0,1); // Local Label #1=EX
    // Declare locals as attributes
    // JavaLine 18 ==> SourceLine 53
    int j=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Queens2$qinv setPar(Object param) {
        //Util.BREAK("CALL Queens2$qinv.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public Queens2$qinv(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Queens2$qinv(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("qinv",53);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Queens2$qinv STM$() {
        TRACE_BEGIN_STM$("qinv",53);
        Queens2$qinv THIS$=(Queens2$qinv)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 53 ==> SourceLine 54
                for(boolean CB$54:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){j=(int)x$; return(x$);};  public Number get(){return((Number)j); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(8); }})
                   )) { if(!CB$54) continue;
                if((((Queens2)(CUR$.SL$)).q.Elt[j-((Queens2)(CUR$.SL$)).q.LB[0]]==(p$i))) {
                    GOTO$(EX); // GOTO EVALUATED LABEL
                }
            }
            // JavaLine 61 ==> SourceLine 55
            LABEL$(1); // EX
            RESULT$=j;
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
    TRACE_END_STM$("qinv",55);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("Queens2.sim","Procedure qinv",1,52,15,55,18,53,53,54,61,55,80,56);
}
