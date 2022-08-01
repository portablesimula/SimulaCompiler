// JavaLine 1 <== SourceLine 90
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:53 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$get_ent extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=90, lastLine=105, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public Common$descr RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 92
    Common$symbolbox inspect$91$150=null;
    // JavaLine 16 <== SourceLine 99
    Common$routine inspect$99$151=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$get_ent setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$get_ent.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public Pass2$CompoundStatement21$SubBlock23$get_ent(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$get_ent(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$get_ent STM$() {
        // JavaLine 45 <== SourceLine 91
        {
            // BEGIN INSPECTION 
            inspect$91$150=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[p$i-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]];
            if(inspect$91$150!=null) // INSPECT inspect$91$150
            // JavaLine 50 <== SourceLine 96
            {
                // JavaLine 52 <== SourceLine 98
                new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,(((inspect$91$150.curmeaning==(null)))?(CONC(new TXT$("No declaration of routine: "),inspect$91$150.symbol)):(CONC(inspect$91$150.symbol,new TXT$(" is not a routine")))));
                ;
                // JavaLine 55 <== SourceLine 99
                {
                    // BEGIN INSPECTION 
                    inspect$99$151=new Common$routine(((Pass2)(CUR$.SL$.SL$)).inspect$20$141).STM$();
                    if(inspect$99$151!=null) // INSPECT inspect$99$151
                    // JavaLine 60 <== SourceLine 100
                    {
                        ((Pass2)(CUR$.SL$.SL$)).inspect$20$141.simsymbol$1=new TXT$("*dummy*");
                        ;
                        new Common$DEFIDENT(((Pass2)(CUR$.SL$.SL$)).inspect$20$141);
                        ;
                        // JavaLine 66 <== SourceLine 101
                        inspect$99$151.profbox$3=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[((Pass2)(CUR$.SL$.SL$)).inspect$20$141.hash$1-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]];
                        ;
                        // JavaLine 69 <== SourceLine 102
                        RESULT$=((Common$routine)inspect$99$151);
                        ;
                        // JavaLine 72 <== SourceLine 103
                        inspect$99$151.symb$2=((Common$symbolbox)inspect$91$150);
                        ;
                    }
                }
                ;
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure get_ent",1,90,14,92,16,99,45,91,50,96,52,98,55,99,60,100,66,101,69,102,72,103,82,105);
} // End of Procedure
