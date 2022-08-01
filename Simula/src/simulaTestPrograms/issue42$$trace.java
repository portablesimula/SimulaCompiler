package simulaTestPrograms;
// Simula-2.0 Compiled at Fri Sep 10 10:56:34 CEST 2021
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue42$$trace extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=3, lastLine=5, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public TXT$ p$message;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public issue42$$trace setPar(Object param) {
        //Util.BREAK("CALL issue42$$trace.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$message=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public issue42$$trace(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public issue42$$trace(RTObject$ SL$,TXT$ sp$message) {
        super(SL$);
        // Parameter assignment to locals
        this.p$message = sp$message;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public issue42$$trace STM$() {
        // JavaLine 37 <== SourceLine 4
        sysout().outtext(p$message);
        ;
        sysout().outimage();
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("issue42.sim","Procedure trace",37,4,44,5);
} // End of Procedure
