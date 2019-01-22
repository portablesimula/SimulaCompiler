// JavaLine 1 ==> SourceLine 41
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 18:06:08 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Docking$PBLK13$Warehouse$drawText extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=41, lastLine=42, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$str;
    public double p$pos;
    public double p$line;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Docking$PBLK13$Warehouse$drawText setPar(Object param) {
        //Util.BREAK("CALL Docking$PBLK13$Warehouse$drawText.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$str=(TXT$)objectValue(param); break;
                case 1: p$pos=doubleValue(param); break;
                case 2: p$line=doubleValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Docking$PBLK13$Warehouse$drawText(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Docking$PBLK13$Warehouse$drawText(RTObject$ SL$,TXT$ sp$str,double sp$pos,double sp$line) {
        super(SL$);
        // Parameter assignment to locals
        this.p$str = sp$str;
        this.p$pos = sp$pos;
        this.p$line = sp$line;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("drawText",41);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Docking$PBLK13$Warehouse$drawText STM$() {
        TRACE_BEGIN_STM$("drawText",41);
        // JavaLine 47 ==> SourceLine 42
        new TextElement$(((Docking$PBLK13)(CUR$.SL$.SL$)),p$str,p$pos,p$line).STM$();
        TRACE_END_STM$("drawText",42);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Procedure drawText",1,41,47,42,52,42);
}
