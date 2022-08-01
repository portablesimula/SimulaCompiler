// JavaLine 1 <== SourceLine 1025
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$arith_type extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=1025, lastLine=1032, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$t;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$arith_type setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$arith_type.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$t=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$arith_type(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$arith_type(RTObject$ SL$,int sp$t) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t = sp$t;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$arith_type STM$() {
        // JavaLine 41 <== SourceLine 1026
        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[p$t-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.integerTypes$1)))) {
            // JavaLine 43 <== SourceLine 1027
            RESULT$=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_INT$1;
        } else
        // JavaLine 46 <== SourceLine 1028
        if(VALUE$((p$t==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REAL$1)))) {
            RESULT$=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REAL$1;
        } else
        // JavaLine 50 <== SourceLine 1029
        if(VALUE$((p$t==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_LREAL$1)))) {
            RESULT$=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_LREAL$1;
        } else
        // JavaLine 54 <== SourceLine 1031
        {
            if(VALUE$((p$t!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_INT$1)))) {
                new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),p$t,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_INT$1);
            }
            ;
            RESULT$=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_INT$1;
            ;
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure arith_type",1,1025,41,1026,43,1027,46,1028,50,1029,54,1031,65,1032);
} // End of Procedure
