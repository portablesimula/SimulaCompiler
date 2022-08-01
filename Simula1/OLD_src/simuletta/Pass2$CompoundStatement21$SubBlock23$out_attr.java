// JavaLine 1 <== SourceLine 148
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:53 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$out_attr extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=148, lastLine=156, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$quant p$q;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 149
    Common$quant inspect$149$158=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$out_attr setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$out_attr.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$q=(Common$quant)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$out_attr(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$out_attr(RTObject$ SL$,Common$quant sp$q) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$out_attr STM$() {
        {
            // BEGIN INSPECTION 
            inspect$149$158=p$q;
            if(inspect$149$158!=null) // INSPECT inspect$149$158
            // JavaLine 44 <== SourceLine 150
            {
                if(VALUE$((!(inspect$149$158.preped$3)))) {
                    new Common$FATAL_ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("out_attr, nonprep'd"));
                }
                ;
                // JavaLine 50 <== SourceLine 151
                if(VALUE$((inspect$149$158.initval$3!=(null)))) {
                    // JavaLine 52 <== SourceLine 152
                    new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Initial value for attribute"));
                }
                ;
                // JavaLine 56 <== SourceLine 153
                new Common$deftag(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$descr)inspect$149$158));
                ;
                // JavaLine 59 <== SourceLine 154
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ATTR$1);
                ;
                new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$149$158.tag$2);
                ;
                new Pass2$CompoundStatement21$SubBlock23$outquant(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$quant)inspect$149$158));
                ;
                // JavaLine 66 <== SourceLine 155
                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                }
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure out_attr",1,148,11,149,44,150,50,151,52,152,56,153,59,154,66,155,75,156);
} // End of Procedure
