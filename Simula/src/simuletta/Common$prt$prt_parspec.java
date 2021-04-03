// JavaLine 1 <== SourceLine 777
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$prt_parspec extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=777, lastLine=793, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$parspec p$p;
    public int p$pos;
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 779
    Common$parspec inspect$778$14=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$prt$prt_parspec setPar(Object param) {
        //Util.BREAK("CALL Common$prt$prt_parspec.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 2: p$p=(Common$parspec)objectValue(param); break;
                case 1: p$pos=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$prt$prt_parspec(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public Common$prt$prt_parspec(RTObject$ SL$,Common$parspec sp$p,int sp$pos) {
        super(SL$);
        // Parameter assignment to locals
        this.p$p = sp$p;
        this.p$pos = sp$pos;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$prt$prt_parspec STM$() {
        // JavaLine 43 <== SourceLine 778
        {
            // BEGIN INSPECTION 
            inspect$778$14=p$p;
            if(inspect$778$14!=null) // INSPECT inspect$778$14
            // JavaLine 48 <== SourceLine 793
            new Common$prt$prt_parspec$SubBlock779((CUR$)).STM$();
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure prt_parspec",1,777,12,779,43,778,48,793,53,793);
} // End of Procedure
