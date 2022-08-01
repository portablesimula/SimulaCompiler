// JavaLine 1 <== SourceLine 107
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:53 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$get_lab extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=107, lastLine=119, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public Common$label_descr RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 109
    Common$symbolbox inspect$108$152=null;
    // JavaLine 16 <== SourceLine 115
    Common$label_descr inspect$115$153=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$get_lab setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$get_lab.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public Pass2$CompoundStatement21$SubBlock23$get_lab(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$get_lab(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$get_lab STM$() {
        // JavaLine 45 <== SourceLine 108
        {
            // BEGIN INSPECTION 
            inspect$108$152=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[p$i-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]];
            if(inspect$108$152!=null) // INSPECT inspect$108$152
            // JavaLine 50 <== SourceLine 112
            {
                // JavaLine 52 <== SourceLine 114
                new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,(((inspect$108$152.curmeaning==(null)))?(CONC(new TXT$("No declaration of label: "),inspect$108$152.symbol)):(CONC(inspect$108$152.symbol,new TXT$(" is not a label")))));
                ;
                // JavaLine 55 <== SourceLine 115
                {
                    // BEGIN INSPECTION 
                    inspect$115$153=new Common$label_descr(((Pass2)(CUR$.SL$.SL$)).inspect$20$141).STM$();
                    if(inspect$115$153!=null) // INSPECT inspect$115$153
                    // JavaLine 60 <== SourceLine 116
                    {
                        RESULT$=((Common$label_descr)inspect$115$153);
                        ;
                        // JavaLine 64 <== SourceLine 117
                        inspect$115$153.symb$2=((Common$symbolbox)inspect$108$152);
                        ;
                    }
                }
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure get_lab",1,107,14,109,16,115,45,108,50,112,52,114,55,115,60,116,64,117,74,119);
} // End of Procedure
