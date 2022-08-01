// JavaLine 1 <== SourceLine 73
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:45 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class OuptFile$outtagid extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=73, lastLine=84, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 74
    Common inspect$74$26=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public OuptFile$outtagid setPar(Object param) {
        //Util.BREAK("CALL OuptFile$outtagid.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$i=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public OuptFile$outtagid(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public OuptFile$outtagid(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public OuptFile$outtagid STM$() {
        {
            // BEGIN INSPECTION 
            inspect$74$26=((OuptFile)(CUR$.SL$)).p3$comn;
            if(inspect$74$26!=null) // INSPECT inspect$74$26
            // JavaLine 44 <== SourceLine 84
            new OuptFile$outtagid$SubBlock75((CUR$)).STM$();
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("OUPTFILE.sim","Procedure outtagid",1,73,11,74,44,84,49,84);
} // End of Procedure
