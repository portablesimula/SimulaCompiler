package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:08:22 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Easter extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public Dates$Date RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$Y;
    int G=0;
    int C=0;
    int X=0;
    int Z=0;
    int D=0;
    int E=0;
    int N=0;
    private int $npar=0; // Number of actual parameters transmitted.
    public Dates$Easter setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$Y=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Dates$Easter(RTObject$ SL$)
    { super(SL$); }
    public Dates$Easter(RTObject$ SL$,int sp$Y) {
        super(SL$);
        this.p$Y = sp$Y;
        BBLK();
        STM$();
    }
    public Dates$Easter STM$() {
        G=(mod(p$Y,19)+(1));
        C=((p$Y/(100))+(1));
        X=(((3*(C))/(4))-(12));
        Z=((((8*(C))+(5))/(25))-(5));
        D=((((5*(p$Y))/(4))-(X))-(10));
        E=mod(((((11*(G))+(20))+(Z))-(X)),30);
        if(VALUE$((((E==(25))&((G>(11))))|((E==(24)))))) {
            E=(E+(1));
        }
        N=(44-(E));
        if(VALUE$((N<(21)))) {
            N=(N+(30));
        }
        N=((N+(7))-(mod((D+(N)),7)));
        RESULT$=new Dates$Date(((Dates)(CUR$.SL$)),N,3,p$Y).STM$();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Dates.sim","Procedure Easter",1,243,11,246,39,248,41,249,43,250,45,251,47,252,49,253,51,254,55,255,57,256,61,257,63,259,67,260);
}
