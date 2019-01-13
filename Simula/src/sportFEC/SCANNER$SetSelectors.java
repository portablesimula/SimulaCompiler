// JavaLine 1 ==> SourceLine 509
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:21 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$SetSelectors extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=509, lastLine=518, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$t;
    public int p$val;
    // Declare locals as attributes
    // JavaLine 13 ==> SourceLine 510
    int i=0;
    boolean b=false;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public SCANNER$SetSelectors setPar(Object param) {
        //Util.BREAK("CALL SCANNER$SetSelectors.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$t=(TXT$)objectValue(param); break;
                case 1: p$val=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public SCANNER$SetSelectors(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public SCANNER$SetSelectors(RTObject$ SL$,TXT$ sp$t,int sp$val) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t = sp$t;
        this.p$val = sp$val;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SetSelectors",510);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$SetSelectors STM$() {
        TRACE_BEGIN_STM$("SetSelectors",510);
        // JavaLine 47 ==> SourceLine 511
        if((p$val==(0))) {
            // JavaLine 49 ==> SourceLine 512
            for(boolean CB$512:new ForList(
                new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(47); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(127); }})
               )) { if(!CB$512) continue;
            ((SCANNER)(CUR$.SL$)).selector.Elt[i-((SCANNER)(CUR$.SL$)).selector.LB[0]]=false;
        }
    }
    // JavaLine 56 ==> SourceLine 513
    b=(p$val!=(2));
    TXT$.setpos(p$t,1);
    // JavaLine 59 ==> SourceLine 514
    while(TXT$.more(p$t)) {
        // JavaLine 61 ==> SourceLine 515
        {
            TRACE_BEGIN_STM$("CompoundStatement515",515);
            i=rank(TXT$.getchar(p$t));
            if((i>(127))) {
                i=(i-(128));
            }
            // JavaLine 68 ==> SourceLine 516
            if((i>(47))) {
                ((SCANNER)(CUR$.SL$)).selector.Elt[i-((SCANNER)(CUR$.SL$)).selector.LB[0]]=b;
            }
            TRACE_END_STM$("CompoundStatement515",516);
        }
    }
    TRACE_END_STM$("SetSelectors",516);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure SetSelectors",1,509,13,510,47,511,49,512,56,513,59,514,61,515,68,516,78,518);
}
