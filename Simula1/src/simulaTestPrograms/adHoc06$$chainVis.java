package simulaTestPrograms;
// Simula-2.0 Compiled at Sat Jun 11 10:29:57 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc06$$chainVis extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=10, lastLine=13, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public boolean p$hidp;
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 11
    public adHoc06$$idpack2 inspect$11$0=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public adHoc06$$chainVis setPar(Object param) {
        //Util.BREAK("CALL adHoc06$$chainVis.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$hidp=(boolean)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public adHoc06$$chainVis(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public adHoc06$$chainVis(RTObject$ SL$,boolean sp$hidp) {
        super(SL$);
        // Parameter assignment to locals
        this.p$hidp = sp$hidp;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public adHoc06$$chainVis STM$() {
        {
            // BEGIN INSPECTION 
            inspect$11$0=((p$hidp)?(new adHoc06$$idpack2(((adHoc06$)(CUR$.SL$))).STM$()):(new adHoc06$$protpack2(((adHoc06$)(CUR$.SL$))).STM$()));
            if(inspect$11$0!=null) // INSPECT inspect$11$0
            // JavaLine 43 <== SourceLine 12
            {
                // JavaLine 45 <== SourceLine 13
                {
                }
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc06.sim","Procedure chainVis",10,11,43,12,45,13,52,13);
} // End of Procedure
