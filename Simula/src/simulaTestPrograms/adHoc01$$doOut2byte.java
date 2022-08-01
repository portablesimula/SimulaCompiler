// JavaLine 1 <== SourceLine 22
package simulaTestPrograms;
// Simula-2.0 Compiled at Tue Sep 28 13:18:15 CEST 2021
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc01$$doOut2byte extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=22, lastLine=25, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$b;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public adHoc01$$doOut2byte setPar(Object param) {
        //Util.BREAK("CALL adHoc01$$doOut2byte.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$b=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public adHoc01$$doOut2byte(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public adHoc01$$doOut2byte(RTObject$ SL$,int sp$b) {
        super(SL$);
        // Parameter assignment to locals
        this.p$b = sp$b;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public adHoc01$$doOut2byte STM$() {
        // JavaLine 38 <== SourceLine 23
        ((adHoc01$)(CUR$.SL$)).oupt.out2byte(p$b);
        ;
        // JavaLine 41 <== SourceLine 24
        sysout().outtext(CONC(new TXT$("Out2byte: "),ENVIRONMENT$.edit(p$b)));
        ;
        sysout().outimage();
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc01.sim","Procedure doOut2byte",1,22,38,23,41,24,48,25);
} // End of Procedure
