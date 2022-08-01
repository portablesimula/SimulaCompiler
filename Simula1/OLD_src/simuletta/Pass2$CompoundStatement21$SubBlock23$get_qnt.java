// JavaLine 1 <== SourceLine 47
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:53 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$get_qnt extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=47, lastLine=59, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public Common$quant RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 49
    Common$symbolbox inspect$48$144=null;
    // JavaLine 16 <== SourceLine 55
    Common$quant inspect$55$145=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$get_qnt setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$get_qnt.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public Pass2$CompoundStatement21$SubBlock23$get_qnt(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$get_qnt(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$get_qnt STM$() {
        // JavaLine 45 <== SourceLine 48
        {
            // BEGIN INSPECTION 
            inspect$48$144=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[p$i-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]];
            if(inspect$48$144!=null) // INSPECT inspect$48$144
            // JavaLine 50 <== SourceLine 52
            {
                // JavaLine 52 <== SourceLine 54
                new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,(((inspect$48$144.curmeaning==(null)))?(CONC(new TXT$("No declaration of var: "),inspect$48$144.symbol)):(CONC(inspect$48$144.symbol,new TXT$(" is not a variable")))));
                ;
                // JavaLine 55 <== SourceLine 55
                {
                    // BEGIN INSPECTION 
                    inspect$55$145=new Common$quant(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_UNDEF$1).STM$();
                    if(inspect$55$145!=null) // INSPECT inspect$55$145
                    // JavaLine 60 <== SourceLine 56
                    {
                        RESULT$=((Common$quant)inspect$55$145);
                        ;
                        // JavaLine 64 <== SourceLine 57
                        inspect$55$145.symb$2=((Common$symbolbox)inspect$48$144);
                        ;
                    }
                }
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure get_qnt",1,47,14,49,16,55,45,48,50,52,52,54,55,55,60,56,64,57,74,59);
} // End of Procedure
