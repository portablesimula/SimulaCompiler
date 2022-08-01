// JavaLine 1 <== SourceLine 95
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$setopt extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=95, lastLine=97, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public char p$ch;
    public int p$val;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$setopt setPar(Object param) {
        //Util.BREAK("CALL Common$setopt.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 2: p$ch=(char)objectValue(param); break;
                case 1: p$val=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$setopt(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public Common$setopt(RTObject$ SL$,char sp$ch,int sp$val) {
        super(SL$);
        // Parameter assignment to locals
        this.p$ch = sp$ch;
        this.p$val = sp$val;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$setopt STM$() {
        // JavaLine 41 <== SourceLine 96
        ((Common)(CUR$.SL$)).option.Elt[rank(p$ch)-((Common)(CUR$.SL$)).option.LB[0]]=p$val;
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure setopt",1,95,41,96,46,97);
} // End of Procedure
