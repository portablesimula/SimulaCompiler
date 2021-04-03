// JavaLine 1 <== SourceLine 382
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$eddouble extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=382, lastLine=388, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 383
    TXT$ t=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$eddouble setPar(Object param) {
        //Util.BREAK("CALL Common$eddouble.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public Common$eddouble(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Common$eddouble(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$eddouble STM$() {
        // JavaLine 43 <== SourceLine 384
        RESULT$=t=blanks((((p$i>(99)))?((((p$i<(1000)))?(3):((((p$i>(9999)))?(5):(4))))):((((p$i>(9)))?(2):(1)))));
        ;
        // JavaLine 46 <== SourceLine 387
        TXT$.putint(t,p$i);
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure eddouble",1,382,14,383,43,384,46,387,51,388);
} // End of Procedure
