// JavaLine 1 <== SourceLine 3
package simulaTestPrograms;
// Simula-1.0 Compiled at Sun Aug 18 14:07:26 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class NormalSwitch$$S extends PROC$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=3, lastLine=0, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public LABQNT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$$SW;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public NormalSwitch$$S setPar(Object param) {
        //Util.BREAK("CALL NormalSwitch$$S.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$$SW=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public NormalSwitch$$S(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public NormalSwitch$$S(RTObject$ SL$,int sp$$SW) {
        super(SL$);
        // Parameter assignment to locals
        this.p$$SW = sp$$SW;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Switch Body
    public NormalSwitch$$S STM$() {
        switch(p$$SW-1) {
            case 0: RESULT$=((NormalSwitch$)(CUR$.SL$)).L1; break;
            case 1: RESULT$=((NormalSwitch$)(CUR$.SL$)).L2; break;
            default: throw new RuntimeException("Illegal switch index: "+p$$SW);
        }
        EBLK();
        return(this);
    } // End of Switch BODY
    public static PROGINFO$ INFO$=new PROGINFO$("NormalSwitch.sim","Procedure S",1,3,48,0);
} // End of Procedure
