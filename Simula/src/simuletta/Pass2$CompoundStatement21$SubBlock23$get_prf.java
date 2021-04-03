// JavaLine 1 <== SourceLine 76
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:53 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$get_prf extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=76, lastLine=88, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public Common$profile RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 78
    Common$symbolbox inspect$77$148=null;
    // JavaLine 16 <== SourceLine 84
    Common$profile inspect$84$149=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$get_prf setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$get_prf.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public Pass2$CompoundStatement21$SubBlock23$get_prf(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$get_prf(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$get_prf STM$() {
        // JavaLine 45 <== SourceLine 77
        {
            // BEGIN INSPECTION 
            inspect$77$148=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[p$i-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]];
            if(inspect$77$148!=null) // INSPECT inspect$77$148
            // JavaLine 50 <== SourceLine 81
            {
                // JavaLine 52 <== SourceLine 83
                new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,(((inspect$77$148.curmeaning==(null)))?(CONC(new TXT$("No declaration of profile: "),inspect$77$148.symbol)):(CONC(inspect$77$148.symbol,new TXT$(" is not a profile")))));
                ;
                // JavaLine 55 <== SourceLine 84
                {
                    // BEGIN INSPECTION 
                    inspect$84$149=new Common$profile(((Pass2)(CUR$.SL$.SL$)).inspect$20$141).STM$();
                    if(inspect$84$149!=null) // INSPECT inspect$84$149
                    // JavaLine 60 <== SourceLine 85
                    {
                        RESULT$=((Common$profile)inspect$84$149);
                        ;
                        // JavaLine 64 <== SourceLine 86
                        inspect$84$149.symb$2=((Common$symbolbox)inspect$77$148);
                        ;
                    }
                }
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure get_prf",1,76,14,78,16,84,45,77,50,81,52,83,55,84,60,85,64,86,74,88);
} // End of Procedure
