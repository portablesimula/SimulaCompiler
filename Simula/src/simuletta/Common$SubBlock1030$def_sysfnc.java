// JavaLine 1 <== SourceLine 1032
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:26:02 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$SubBlock1030$def_sysfnc extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=1032, lastLine=1037, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$istr;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 1033
    Common$system_descr inspect$1033$18=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$SubBlock1030$def_sysfnc setPar(Object param) {
        //Util.BREAK("CALL Common$SubBlock1030$def_sysfnc.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$istr=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$SubBlock1030$def_sysfnc(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Common$SubBlock1030$def_sysfnc(RTObject$ SL$,int sp$istr) {
        super(SL$);
        // Parameter assignment to locals
        this.p$istr = sp$istr;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$SubBlock1030$def_sysfnc STM$() {
        {
            // BEGIN INSPECTION 
            inspect$1033$18=new Common$system_descr(((Common)(CUR$.SL$.SL$))).STM$();
            if(inspect$1033$18!=null) // INSPECT inspect$1033$18
            // JavaLine 44 <== SourceLine 1034
            {
                inspect$1033$18.instr$3=p$istr;
                ;
                // JavaLine 48 <== SourceLine 1035
                new Common$DEFIDENT(((Common)(CUR$.SL$.SL$)));
                ;
                inspect$1033$18.symb$2=((Common)(CUR$.SL$.SL$)).symtab.Elt[((Common)(CUR$.SL$.SL$)).hash$1-((Common)(CUR$.SL$.SL$)).symtab.LB[0]];
                ;
                // JavaLine 53 <== SourceLine 1036
                inspect$1033$18.symb$2.curmeaning=((Common$system_descr)inspect$1033$18);
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure def_sysfnc",1,1032,11,1033,44,1034,48,1035,53,1036,60,1037);
} // End of Procedure
