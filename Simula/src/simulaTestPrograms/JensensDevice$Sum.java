package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:13:52 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class JensensDevice$Sum extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=10, lastLine=25, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public double RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public NAME$<Integer> p$k;
    public int p$lower;
    public int p$upper;
    public NAME$<Double> p$ak;
    // Declare locals as attributes
    // JavaLine 17 ==> SourceLine 15
    double s=0.0d;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public JensensDevice$Sum setPar(Object param) {
        //Util.BREAK("CALL JensensDevice$Sum.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$k=(NAME$<Integer>)param; break;
                case 1: p$lower=intValue(param); break;
                case 2: p$upper=intValue(param); break;
                case 3: p$ak=(NAME$<Double>)param; break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public JensensDevice$Sum(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public JensensDevice$Sum(RTObject$ SL$,NAME$<Integer> sp$k,int sp$lower,int sp$upper,NAME$<Double> sp$ak) {
        super(SL$);
        // Parameter assignment to locals
        this.p$k = sp$k;
        this.p$lower = sp$lower;
        this.p$upper = sp$upper;
        this.p$ak = sp$ak;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Sum",15);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public JensensDevice$Sum STM$() {
        TRACE_BEGIN_STM$("Sum",15);
        // JavaLine 54 ==> SourceLine 16
        s=((double)(0.0f));
        // JavaLine 56 ==> SourceLine 18
        p$k.put(p$lower);
        // JavaLine 58 ==> SourceLine 19
        while((p$k.get()<=(p$upper))) {
            // JavaLine 60 ==> SourceLine 21
            {
                TRACE_BEGIN_STM$("CompoundStatement21",21);
                s=(s+(p$ak.get()));
                // JavaLine 64 ==> SourceLine 22
                p$k.put((p$k.get()+(1)));
                TRACE_END_STM$("CompoundStatement21",22);
            }
        }
        // JavaLine 69 ==> SourceLine 24
        RESULT$=s;
        TRACE_END_STM$("Sum",24);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("JensensDevice.sim","Procedure Sum",17,15,54,16,56,18,58,19,60,21,64,22,69,24,74,25);
}
