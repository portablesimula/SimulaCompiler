// JavaLine 1 <== SourceLine 11
package simulaTestPrograms;
// Simula-2.0 Compiled at Tue Sep 28 13:18:15 CEST 2021
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc01$$doOutbyte extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=11, lastLine=14, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$b;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public adHoc01$$doOutbyte setPar(Object param) {
        //Util.BREAK("CALL adHoc01$$doOutbyte.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public adHoc01$$doOutbyte(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public adHoc01$$doOutbyte(RTObject$ SL$,int sp$b) {
        super(SL$);
        // Parameter assignment to locals
        this.p$b = sp$b;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public adHoc01$$doOutbyte STM$() {
        // JavaLine 38 <== SourceLine 12
        ((adHoc01$)(CUR$.SL$)).oupt.outbyte(p$b);
        ;
        // JavaLine 41 <== SourceLine 13
        sysout().outtext(CONC(new TXT$("Outbyte: "),ENVIRONMENT$.edit(p$b)));
        ;
        sysout().outimage();
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc01.sim","Procedure doOutbyte",1,11,38,12,41,13,48,14);
} // End of Procedure
