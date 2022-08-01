// JavaLine 1 <== SourceLine 376
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$edchar extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=376, lastLine=380, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public char p$c;
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 377
    TXT$ t=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$edchar setPar(Object param) {
        //Util.BREAK("CALL Common$edchar.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$c=(char)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$edchar(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Common$edchar(RTObject$ SL$,char sp$c) {
        super(SL$);
        // Parameter assignment to locals
        this.p$c = sp$c;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$edchar STM$() {
        // JavaLine 43 <== SourceLine 378
        RESULT$=t=blanks(1);
        ;
        // JavaLine 46 <== SourceLine 379
        TXT$.putchar(t,p$c);
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure edchar",1,376,14,377,43,378,46,379,51,380);
} // End of Procedure
