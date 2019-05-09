package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:40:27 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class JensensDevice$Sum extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public double RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public NAME$<Integer> p$k;
    public int p$lower;
    public int p$upper;
    public NAME$<Double> p$ak;
    double s=0.0d;
    private int $npar=0; // Number of actual parameters transmitted.
    public JensensDevice$Sum setPar(Object param) {
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
    public JensensDevice$Sum(RTObject$ SL$)
    { super(SL$); }
    public JensensDevice$Sum(RTObject$ SL$,NAME$<Integer> sp$k,int sp$lower,int sp$upper,NAME$<Double> sp$ak) {
        super(SL$);
        this.p$k = sp$k;
        this.p$lower = sp$lower;
        this.p$upper = sp$upper;
        this.p$ak = sp$ak;
        BBLK();
        STM$();
    }
    public JensensDevice$Sum STM$() {
        s=((double)(0.0f));
        p$k.put(p$lower);
        while((p$k.get()<=(p$upper))) {
            {
                s=(s+(p$ak.get()));
                p$k.put((p$k.get()+(1)));
            }
        }
        RESULT$=s;
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("JensensDevice.sim","Procedure Sum",13,15,41,16,43,18,45,19,47,21,50,22,54,24,58,25);
}
