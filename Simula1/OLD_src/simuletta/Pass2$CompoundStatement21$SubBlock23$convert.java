// JavaLine 1 <== SourceLine 1758
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$convert extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=1758, lastLine=1762, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$t1;
    public int p$t2;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$convert setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$convert.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public Pass2$CompoundStatement21$SubBlock23$convert(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$convert(RTObject$ SL$,int sp$t1,int sp$t2) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t1 = sp$t1;
        this.p$t2 = sp$t2;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$convert STM$() {
        // JavaLine 41 <== SourceLine 1759
        if(VALUE$(new Pass2$CompoundStatement21$SubBlock23$type_check(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),p$t1,p$t2).RESULT$)) {
            // JavaLine 43 <== SourceLine 1760
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_CONVERT$1);
                ;
                new Pass2$CompoundStatement21$SubBlock23$outtype(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),p$t2);
                ;
                // JavaLine 49 <== SourceLine 1761
                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                }
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure convert",1,1758,41,1759,43,1760,49,1761,58,1762);
} // End of Procedure
