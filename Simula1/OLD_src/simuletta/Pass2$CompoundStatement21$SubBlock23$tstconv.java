// JavaLine 1 <== SourceLine 1764
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$tstconv extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=1764, lastLine=1769, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$t1;
    public int p$t2;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$tstconv setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$tstconv.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 2: p$t1=intValue(param); break;
                case 1: p$t2=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$tstconv(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$tstconv(RTObject$ SL$,int sp$t1,int sp$t2) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t1 = sp$t1;
        this.p$t2 = sp$t2;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$tstconv STM$() {
        // JavaLine 41 <== SourceLine 1766
        if(VALUE$(new Pass2$CompoundStatement21$SubBlock23$type_check(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),p$t1,p$t2).RESULT$)) {
            // JavaLine 43 <== SourceLine 1768
            new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,CONC(CONC(CONC(new TXT$("Missing type conversion: "),new Common$edtype(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,p$t1).RESULT$),new TXT$(" => ")),new Common$edtype(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,p$t2).RESULT$));
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure tstconv",1,1764,41,1766,43,1768,49,1769);
} // End of Procedure
