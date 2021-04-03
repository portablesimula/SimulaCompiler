// JavaLine 1 <== SourceLine 656
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$settrace extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=656, lastLine=657, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$v;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass1$SubBlock32$grammar$settrace setPar(Object param) {
        //Util.BREAK("CALL Pass1$SubBlock32$grammar$settrace.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$v=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass1$SubBlock32$grammar$settrace(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass1$SubBlock32$grammar$settrace(RTObject$ SL$,int sp$v) {
        super(SL$);
        // Parameter assignment to locals
        this.p$v = sp$v;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$grammar$settrace STM$() {
        // JavaLine 38 <== SourceLine 657
        ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3=p$v;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure settrace",1,656,38,657,42,657);
} // End of Procedure
