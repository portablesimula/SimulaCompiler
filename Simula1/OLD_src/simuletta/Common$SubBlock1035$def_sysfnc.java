// JavaLine 1 <== SourceLine 1037
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 17:55:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$SubBlock1035$def_sysfnc extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=1037, lastLine=1042, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$istr;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 1038
    Common$system_descr inspect$1038$18=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$SubBlock1035$def_sysfnc setPar(Object param) {
        //Util.BREAK("CALL Common$SubBlock1035$def_sysfnc.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public Common$SubBlock1035$def_sysfnc(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Common$SubBlock1035$def_sysfnc(RTObject$ SL$,int sp$istr) {
        super(SL$);
        // Parameter assignment to locals
        this.p$istr = sp$istr;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$SubBlock1035$def_sysfnc STM$() {
        {
            // BEGIN INSPECTION 
            inspect$1038$18=new Common$system_descr(((Common)(CUR$.SL$.SL$))).STM$();
            if(inspect$1038$18!=null) // INSPECT inspect$1038$18
            // JavaLine 44 <== SourceLine 1039
            {
                inspect$1038$18.instr$3=p$istr;
                ;
                // JavaLine 48 <== SourceLine 1040
                new Common$DEFIDENT(((Common)(CUR$.SL$.SL$)));
                ;
                inspect$1038$18.symb$2=((Common)(CUR$.SL$.SL$)).symtab.Elt[((Common)(CUR$.SL$.SL$)).hash$1-((Common)(CUR$.SL$.SL$)).symtab.LB[0]];
                ;
                // JavaLine 53 <== SourceLine 1041
                inspect$1038$18.symb$2.curmeaning=((Common$system_descr)inspect$1038$18);
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure def_sysfnc",1,1037,11,1038,44,1039,48,1040,53,1041,60,1042);
} // End of Procedure
