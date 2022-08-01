// JavaLine 1 <== SourceLine 16
package simulaTestPrograms;
// Simula-1.0 Compiled at Tue Oct 01 13:02:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Assignments$$F extends PROC$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=16, lastLine=17, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public float p$x;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Assignments$$F setPar(Object param) {
        //Util.BREAK("CALL Assignments$$F.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$x=floatValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Assignments$$F(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Assignments$$F(RTObject$ SL$,float sp$x) {
        super(SL$);
        // Parameter assignment to locals
        this.p$x = sp$x;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Assignments$$F STM$() {
        // JavaLine 41 <== SourceLine 17
        RESULT$=(int)Math.round((((float)(4))*(p$x)));
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Assignments.sim","Procedure F",1,16,41,17,45,17);
} // End of Procedure
