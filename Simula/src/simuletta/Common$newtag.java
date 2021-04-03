// JavaLine 1 <== SourceLine 301
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$newtag extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=301, lastLine=304, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$symbolbox p$box;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$newtag setPar(Object param) {
        //Util.BREAK("CALL Common$newtag.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$box=(Common$symbolbox)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$newtag(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Common$newtag(RTObject$ SL$,Common$symbolbox sp$box) {
        super(SL$);
        // Parameter assignment to locals
        this.p$box = sp$box;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$newtag STM$() {
        // JavaLine 38 <== SourceLine 302
        ((Common)(CUR$.SL$)).ntag$1=Math.addExact(((Common)(CUR$.SL$)).ntag$1,1);
        ;
        // JavaLine 41 <== SourceLine 303
        ((Common)(CUR$.SL$)).tagtab.Elt[((Common)(CUR$.SL$)).ntag$1-((Common)(CUR$.SL$)).tagtab.LB[0]]=p$box;
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure newtag",1,301,38,302,41,303,46,304);
} // End of Procedure
