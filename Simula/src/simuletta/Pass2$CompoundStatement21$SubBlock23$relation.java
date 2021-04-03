// JavaLine 1 <== SourceLine 1608
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$relation extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=1608, lastLine=1612, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$b;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$relation setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$relation.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$b=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$relation(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$relation(RTObject$ SL$,int sp$b) {
        super(SL$);
        // Parameter assignment to locals
        this.p$b = sp$b;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$relation STM$() {
        // JavaLine 41 <== SourceLine 1609
        RESULT$=(((p$b==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_LT$1)))?(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).K_LT):((((p$b==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_LE$1)))?(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).K_LE):((((p$b==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_EQ$1)))?(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).K_EQ):((((p$b==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_GT$1)))?(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).K_GT):((((p$b==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_GE$1)))?(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).K_GE):((((p$b==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_NE$1)))?(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).K_NE):(0))))))))))));
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure relation",1,1608,41,1609,45,1612);
} // End of Procedure
