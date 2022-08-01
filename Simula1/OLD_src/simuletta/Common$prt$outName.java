// JavaLine 1 <== SourceLine 795
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$prt$outName extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=795, lastLine=800, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public TXT$ p$t;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 796
    Common$descr inspect$796$15=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$prt$outName setPar(Object param) {
        //Util.BREAK("CALL Common$prt$outName.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$t=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$prt$outName(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Common$prt$outName(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t = sp$t;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$prt$outName STM$() {
        {
            // BEGIN INSPECTION 
            inspect$796$15=((Common$descr)(((Common$prt)(CUR$.SL$)).p$d));
            if(inspect$796$15!=null) // INSPECT inspect$796$15
            {
                sysout().outtext(p$t);
                ;
                // JavaLine 47 <== SourceLine 797
                if(VALUE$((inspect$796$15.xtag$2!=(0)))) {
                    // JavaLine 49 <== SourceLine 798
                    sysout().outtext(CONC(new TXT$("X"),new Common$leftint(((Common)(CUR$.SL$.SL$)),inspect$796$15.xtag$2).RESULT$));
                }
                ;
                // JavaLine 53 <== SourceLine 799
                sysout().outtext(CONC(CONC(CONC(new TXT$("T"),new Common$leftint(((Common)(CUR$.SL$.SL$)),inspect$796$15.tag$2).RESULT$),new TXT$(":")),inspect$796$15.symb$2.symbol));
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure outName",1,795,11,796,47,797,49,798,53,799,60,800);
} // End of Procedure
