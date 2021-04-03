// JavaLine 1 <== SourceLine 80
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:46 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InptFile$TRC extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=80, lastLine=93, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public TXT$ p$m;
    public TXT$ p$v;
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 81
    Common inspect$81$39=null;
    // JavaLine 14 <== SourceLine 83
    PrintFile$ inspect$83$40=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public InptFile$TRC setPar(Object param) {
        //Util.BREAK("CALL InptFile$TRC.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 2: p$m=(TXT$)objectValue(param); break;
                case 1: p$v=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public InptFile$TRC(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public InptFile$TRC(RTObject$ SL$,TXT$ sp$m,TXT$ sp$v) {
        super(SL$);
        // Parameter assignment to locals
        this.p$m = sp$m;
        this.p$v = sp$v;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public InptFile$TRC STM$() {
        // JavaLine 45 <== SourceLine 81
        {
            // BEGIN INSPECTION 
            inspect$81$39=((InptFile)(CUR$.SL$)).p3$comn;
            if(inspect$81$39!=null) // INSPECT inspect$81$39
            // JavaLine 50 <== SourceLine 93
            new InptFile$TRC$SubBlock82((CUR$)).STM$();
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("INPTFILE.sim","Procedure TRC",1,80,12,81,14,83,45,81,50,93,55,93);
} // End of Procedure
