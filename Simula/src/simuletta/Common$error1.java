// JavaLine 1 <== SourceLine 309
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$error1 extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=309, lastLine=310, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$n;
    public TXT$ p$t;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$error1 setPar(Object param) {
        //Util.BREAK("CALL Common$error1.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 2: p$n=intValue(param); break;
                case 1: p$t=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$error1(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public Common$error1(RTObject$ SL$,int sp$n,TXT$ sp$t) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        this.p$t = sp$t;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$error1 STM$() {
        // JavaLine 41 <== SourceLine 310
        new Common$WARNING(((Common)(CUR$.SL$)),CONC(CONC(new TXT$("Can't open "),p$t),new TXT$(" - no listing")));
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure error1",1,309,41,310,45,310);
} // End of Procedure
