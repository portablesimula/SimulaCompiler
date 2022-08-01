// JavaLine 1 <== SourceLine 5
package simulaTestPrograms;
// Simula-2.0 Compiled at Tue Jan 18 09:46:00 CET 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class IBMQuine$$OUTEXT extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=5, lastLine=10, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public TXT$ p$T;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 6
    public int J=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public IBMQuine$$OUTEXT setPar(Object param) {
        //Util.BREAK("CALL IBMQuine$$OUTEXT.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$T=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public IBMQuine$$OUTEXT(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public IBMQuine$$OUTEXT(RTObject$ SL$,TXT$ sp$T) {
        super(SL$);
        // Parameter assignment to locals
        this.p$T = sp$T;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public IBMQuine$$OUTEXT STM$() {
        J=1;
        ;
        // JavaLine 42 <== SourceLine 7
        while((Math.addExact(J,71)<=(TXT$.length(p$T)))) {
            // JavaLine 44 <== SourceLine 8
            {
                sysout().outtext(TXT$.sub(p$T,J,72));
                ;
                J=Math.addExact(J,72);
                ;
            }
        }
        ;
        // JavaLine 53 <== SourceLine 9
        sysout().outtext(TXT$.sub(p$T,J,Math.addExact(Math.subtractExact(TXT$.length(p$T),J),1)));
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("IBMQuine.sim","Procedure OUTEXT",1,5,11,6,42,7,44,8,53,9,58,10);
} // End of Procedure
