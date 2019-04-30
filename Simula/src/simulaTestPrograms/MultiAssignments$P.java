package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Apr 30 11:34:14 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class MultiAssignments$P extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$Case$;
    public NAME$<Double> p$F;
    public double p$val;
    public TXT$ p$Facit;
    int i=0;
    double X=0.0d;
    double Y=0.0d;
    private int $npar=0; // Number of actual parameters transmitted.
    public MultiAssignments$P setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$Case$=(TXT$)objectValue(param); break;
                case 1: p$F=(NAME$<Double>)param; break;
                case 2: p$val=doubleValue(param); break;
                case 3: p$Facit=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public MultiAssignments$P(RTObject$ SL$)
    { super(SL$); }
    public MultiAssignments$P(RTObject$ SL$,TXT$ sp$Case$,NAME$<Double> sp$F,double sp$val,TXT$ sp$Facit) {
        super(SL$);
        this.p$Case$ = sp$Case$;
        this.p$F = sp$F;
        this.p$val = sp$val;
        this.p$Facit = sp$Facit;
        BBLK();
        STM$();
    }
    public MultiAssignments$P STM$() {
        X=((double)(i=((int)((int)Math.round(Y=p$F.put(p$val))))));
        sysout().outtext(CONC(CONC(new TXT$("Test "),p$Case$),new TXT$(": results: X=")));
        sysout().outfix(X,4,6);
        sysout().outtext(new TXT$(", i="));
        sysout().outint(i,0);
        sysout().outtext(new TXT$(", Y="));
        sysout().outfix(Y,4,6);
        sysout().outtext(new TXT$(", F="));
        sysout().outfix(p$F.get(),4,6);
        sysout().outimage();
        sysout().outtext(CONC(new TXT$("               "),p$Facit));
        sysout().outimage();
        sysout().outimage();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("MultiAssignments.sim","Procedure P",11,13,13,14,42,16,44,18,47,19,50,20,53,21,56,22,58,23,64,24);
}
