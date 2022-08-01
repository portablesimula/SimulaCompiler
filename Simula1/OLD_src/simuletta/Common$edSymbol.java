// JavaLine 1 <== SourceLine 33
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$edSymbol extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=33, lastLine=36, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$s;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$edSymbol setPar(Object param) {
        //Util.BREAK("CALL Common$edSymbol.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$s=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$edSymbol(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Common$edSymbol(RTObject$ SL$,int sp$s) {
        super(SL$);
        // Parameter assignment to locals
        this.p$s = sp$s;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$edSymbol STM$() {
        // JavaLine 41 <== SourceLine 35
        RESULT$=((Common)(CUR$.SL$)).symtab.Elt[p$s-((Common)(CUR$.SL$)).symtab.LB[0]].symbol;
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure edSymbol",1,33,41,35,46,36);
} // End of Procedure
