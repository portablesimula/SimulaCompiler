// JavaLine 1 <== SourceLine 1795
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$type_check$msg extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=1795, lastLine=1796, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public TXT$ p$s;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$type_check$msg setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$type_check$msg.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$s=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$type_check$msg(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$type_check$msg(RTObject$ SL$,TXT$ sp$s) {
        super(SL$);
        // Parameter assignment to locals
        this.p$s = sp$s;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$type_check$msg STM$() {
        // JavaLine 41 <== SourceLine 1796
        RESULT$=CONC(CONC(CONC(p$s,new Common$edtype(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,((Pass2$CompoundStatement21$SubBlock23$type_check)(CUR$.SL$)).p$t1).RESULT$),new TXT$("  -->  ")),new Common$edtype(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141,((Pass2$CompoundStatement21$SubBlock23$type_check)(CUR$.SL$)).p$t2).RESULT$);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure msg",1,1795,41,1796,45,1796);
} // End of Procedure
