package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Tue Apr 30 12:21:21 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst105$P extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public TXT$ p$Case$;
    public NAME$<Double> p$F;
    public double p$val;
    public TXT$ p$Facit;
    int i=0;
    double X=0.0d;
    double Y=0.0d;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst105$P setPar(Object param) {
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
    public simtst105$P(RTObject$ SL$)
    { super(SL$); }
    public simtst105$P(RTObject$ SL$,TXT$ sp$Case$,NAME$<Double> sp$F,double sp$val,TXT$ sp$Facit) {
        super(SL$);
        this.p$Case$ = sp$Case$;
        this.p$F = sp$F;
        this.p$val = sp$val;
        this.p$Facit = sp$Facit;
        BBLK();
        STM$();
    }
    public simtst105$P STM$() {
        X=((double)(i=((int)((int)Math.round(Y=p$F.put(p$val))))));
        ((simtst105)(CUR$.SL$)).result=blanks(80);
        ASGSTR$(new simtst105$FIELD(((simtst105)(CUR$.SL$)),11).RESULT$,"Results: X=");
        TXT$.putfix(new simtst105$FIELD(((simtst105)(CUR$.SL$)),6).RESULT$,X,4);
        ASGSTR$(new simtst105$FIELD(((simtst105)(CUR$.SL$)),4).RESULT$,", i=");
        TXT$.putint(new simtst105$FIELD(((simtst105)(CUR$.SL$)),1).RESULT$,i);
        ASGSTR$(new simtst105$FIELD(((simtst105)(CUR$.SL$)),4).RESULT$,", Y=");
        TXT$.putfix(new simtst105$FIELD(((simtst105)(CUR$.SL$)),6).RESULT$,Y,4);
        ASGSTR$(new simtst105$FIELD(((simtst105)(CUR$.SL$)),4).RESULT$,", F=");
        TXT$.putfix(new simtst105$FIELD(((simtst105)(CUR$.SL$)),6).RESULT$,p$F.get(),4);
        sysout().outtext(CONC(new TXT$("RESULT: "),((simtst105)(CUR$.SL$)).result));
        sysout().outimage();
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst105.sim","Procedure P",1,29,12,31,14,32,43,34,45,36,47,37,50,38,53,39,56,40,59,41,62,43,65,44,68,45,71,46,74,47,76,48,82,49);
}
