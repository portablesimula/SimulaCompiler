package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$DEFKEYWORD extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=47, lastLine=57, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public int p$code;
    public TXT$ p$ident;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 50
    Common$identsymbol symb=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$DEFKEYWORD setPar(Object param) {
        //Util.BREAK("CALL Common$DEFKEYWORD.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 2: p$code=intValue(param); break;
                case 1: p$ident=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$DEFKEYWORD(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public Common$DEFKEYWORD(RTObject$ SL$,int sp$code,TXT$ sp$ident) {
        super(SL$);
        // Parameter assignment to locals
        this.p$code = sp$code;
        this.p$ident = sp$ident;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$DEFKEYWORD STM$() {
        // JavaLine 42 <== SourceLine 51
        symb=new Common$identsymbol(((Common)(CUR$.SL$))).STM$();
        ;
        symb.symbol=lowcase(copy(copy(p$ident)));
        ;
        // JavaLine 47 <== SourceLine 52
        if(VALUE$((((Common)(CUR$.SL$)).symtab.Elt[p$code-((Common)(CUR$.SL$)).symtab.LB[0]]!=(null)))) {
            // JavaLine 49 <== SourceLine 53
            {
                new Common$TRACE(((Common)(CUR$.SL$)),new TXT$("COMMON.DEFKEYWORD"),53,CONC(CONC(CONC(new TXT$("ALREADY DEFINED: "),new Common$edSymbol(((Common)(CUR$.SL$)),p$code).RESULT$),new TXT$("  ")),p$ident));
                ;
            }
        }
        ;
        // JavaLine 56 <== SourceLine 55
        ((Common)(CUR$.SL$)).symtab.Elt[p$code-((Common)(CUR$.SL$)).symtab.LB[0]]=symb;
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure DEFKEYWORD",11,50,42,51,47,52,49,53,56,55,61,57);
} // End of Procedure
