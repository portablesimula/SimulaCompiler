// JavaLine 1 <== SourceLine 5
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1 extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=1, firstLine=5, lastLine=1959, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common p$comn;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 28
    Common inspect$28$62=null;
    // JavaLine 13 <== SourceLine 30
    OuptFile inspect$29$63=null;
    // JavaLine 15 <== SourceLine 1950
    Pass1$SubBlock32$getsymb inspect$1950$113=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass1 setPar(Object param) {
        //Util.BREAK("CALL Pass1.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$comn=(Common)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass1(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass1(RTObject$ SL$,Common sp$comn) {
        super(SL$);
        // Parameter assignment to locals
        this.p$comn = sp$comn;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1 STM$() {
        // JavaLine 44 <== SourceLine 28
        {
            // BEGIN INSPECTION 
            inspect$28$62=p$comn;
            if(inspect$28$62!=null) // INSPECT inspect$28$62
            // JavaLine 49 <== SourceLine 29
            {
                // BEGIN INSPECTION 
                inspect$29$63=new OuptFile(((BASICIO$)CTX$),inspect$28$62.L2name$1,p$comn).STM$();
                if(inspect$29$63!=null) // INSPECT inspect$29$63
                // JavaLine 54 <== SourceLine 1959
                new Pass1$SubBlock32((CUR$)).STM$();
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure Pass1",1,5,11,28,13,30,15,1950,44,28,49,29,54,1959,60,1959);
} // End of Procedure
