// JavaLine 1 <== SourceLine 1619
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$sysfnc$invalue extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=1619, lastLine=1628, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$type;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 1620
    int t2=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$sysfnc$invalue setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$sysfnc$invalue.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$type=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$sysfnc$invalue(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$sysfnc$invalue(RTObject$ SL$,int sp$type) {
        super(SL$);
        // Parameter assignment to locals
        this.p$type = sp$type;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$sysfnc$invalue STM$() {
        // JavaLine 40 <== SourceLine 1621
        ((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$.SL$)).apar=Math.subtractExact(((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$.SL$)).apar,1);
        ;
        // JavaLine 43 <== SourceLine 1622
        if(VALUE$((((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$.SL$)).apar>=(0)))) {
            // JavaLine 45 <== SourceLine 1623
            {
                t2=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                ;
                // JavaLine 49 <== SourceLine 1624
                if(VALUE$((t2!=(p$type)))) {
                    new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),t2,p$type);
                }
                ;
            }
        } else
        // JavaLine 56 <== SourceLine 1627
        {
            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
            ;
            new Pass2$CompoundStatement21$SubBlock23$outdefault(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),p$type);
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure invalue",1,1619,11,1620,40,1621,43,1622,45,1623,49,1624,56,1627,65,1628);
} // End of Procedure
