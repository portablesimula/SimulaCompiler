// JavaLine 1 ==> SourceLine 55
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 10 12:42:17 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK12$Warehouse$FillSquare extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=55, lastLine=56, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public double p$line;
    public double p$pos;
    public double p$b;
    public double p$h;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Docking$PBLK12$Warehouse$FillSquare setPar(Object param) {
        //Util.BREAK("CALL Docking$PBLK12$Warehouse$FillSquare.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    // Constructor in case of Formal/Virtual Procedure Call
    public Docking$PBLK12$Warehouse$FillSquare(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Docking$PBLK12$Warehouse$FillSquare(RTObject$ SL$,double sp$line,double sp$pos,double sp$b,double sp$h) {
        super(SL$);
        // Parameter assignment to locals
        this.p$line = sp$line;
        this.p$pos = sp$pos;
        this.p$b = sp$b;
        this.p$h = sp$h;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("FillSquare",55);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Docking$PBLK12$Warehouse$FillSquare STM$() {
        TRACE_BEGIN_STM$("FillSquare",55);
        // JavaLine 50 ==> SourceLine 56
        new ShapeElement$(((Docking$PBLK12)(CUR$.SL$.SL$))).STM$().fillRectangle(p$pos,p$line,p$h,p$b);
        TRACE_END_STM$("FillSquare",56);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure FillSquare",1,55,50,56,55,56);
}
