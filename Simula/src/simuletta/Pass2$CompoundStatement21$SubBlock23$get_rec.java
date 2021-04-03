// JavaLine 1 <== SourceLine 61
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:53 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$get_rec extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=61, lastLine=74, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public Common$record RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 63
    Common$symbolbox inspect$62$146=null;
    // JavaLine 16 <== SourceLine 69
    Common$record inspect$69$147=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$get_rec setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$get_rec.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public Pass2$CompoundStatement21$SubBlock23$get_rec(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$get_rec(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$get_rec STM$() {
        // JavaLine 45 <== SourceLine 62
        {
            // BEGIN INSPECTION 
            inspect$62$146=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[p$i-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]];
            if(inspect$62$146!=null) // INSPECT inspect$62$146
            // JavaLine 50 <== SourceLine 66
            {
                // JavaLine 52 <== SourceLine 68
                new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,(((inspect$62$146.curmeaning==(null)))?(CONC(new TXT$("No declaration of record: "),inspect$62$146.symbol)):(CONC(inspect$62$146.symbol,new TXT$(" is not a record")))));
                ;
                // JavaLine 55 <== SourceLine 69
                {
                    // BEGIN INSPECTION 
                    inspect$69$147=new Common$record(((Pass2)(CUR$.SL$.SL$)).inspect$20$141).STM$();
                    if(inspect$69$147!=null) // INSPECT inspect$69$147
                    // JavaLine 60 <== SourceLine 70
                    {
                        inspect$69$147.atrset$3=new Head$(((Pass2)(CUR$.SL$.SL$)).inspect$20$141).STM$();
                        ;
                        inspect$69$147.variantset$3=new Head$(((Pass2)(CUR$.SL$.SL$)).inspect$20$141).STM$();
                        ;
                        // JavaLine 66 <== SourceLine 71
                        RESULT$=((Common$record)inspect$69$147);
                        ;
                        // JavaLine 69 <== SourceLine 72
                        inspect$69$147.symb$2=((Common$symbolbox)inspect$62$146);
                        ;
                    }
                }
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure get_rec",1,61,14,63,16,69,45,62,50,66,52,68,55,69,60,70,66,71,69,72,79,74);
} // End of Procedure
