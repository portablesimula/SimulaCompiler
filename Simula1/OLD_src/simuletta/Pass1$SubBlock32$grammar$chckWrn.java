// JavaLine 1 <== SourceLine 1853
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$chckWrn extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=1853, lastLine=1859, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$line;
    public int p$s;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass1$SubBlock32$grammar$chckWrn setPar(Object param) {
        //Util.BREAK("CALL Pass1$SubBlock32$grammar$chckWrn.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 2: p$line=intValue(param); break;
                case 1: p$s=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass1$SubBlock32$grammar$chckWrn(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public Pass1$SubBlock32$grammar$chckWrn(RTObject$ SL$,int sp$line,int sp$s) {
        super(SL$);
        // Parameter assignment to locals
        this.p$line = sp$line;
        this.p$s = sp$s;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$grammar$chckWrn STM$() {
        // JavaLine 41 <== SourceLine 1855
        new Common$TRACE(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.WARNING"),1855,CONC(new TXT$("s="),new Common$leftint(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,p$s).RESULT$));
        ;
        // JavaLine 44 <== SourceLine 1858
        new Common$WARNING(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,CONC(CONC(CONC(CONC(CONC(new TXT$("Pass1("),new Common$leftint(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,p$line).RESULT$),new TXT$(") Syntax Error -- Expecting: ")),new Common$edSymbol(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,p$s).RESULT$),new TXT$(", got: ")),new Common$edSymbol(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol).RESULT$));
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure chckWrn",1,1853,41,1855,44,1858,49,1859);
} // End of Procedure
