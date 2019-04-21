package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:32:50 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12$Warehouse$FillSquare extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public double p$line;
    public double p$pos;
    public double p$b;
    public double p$h;
    private int $npar=0; // Number of actual parameters transmitted.
    public Docking$PBLK12$Warehouse$FillSquare setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$line=doubleValue(param); break;
                case 1: p$pos=doubleValue(param); break;
                case 2: p$b=doubleValue(param); break;
                case 3: p$h=doubleValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public Docking$PBLK12$Warehouse$FillSquare(RTObject$ SL$)
    { super(SL$); }
    public Docking$PBLK12$Warehouse$FillSquare(RTObject$ SL$,double sp$line,double sp$pos,double sp$b,double sp$h) {
        super(SL$);
        this.p$line = sp$line;
        this.p$pos = sp$pos;
        this.p$b = sp$b;
        this.p$h = sp$h;
        BBLK();
        STM$();
    }
    public Docking$PBLK12$Warehouse$FillSquare STM$() {
        new ShapeElement$(((Docking$PBLK12)(CUR$.SL$.SL$))).STM$().fillRectangle(p$pos,p$line,p$h,p$b);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure FillSquare",1,55,38,56,42,56);
}
