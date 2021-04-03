// JavaLine 1 <== SourceLine 534
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$macro$dump extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=534, lastLine=541, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$symbolbox p$bx;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 535
    Link$ ms=null;
    // JavaLine 13 <== SourceLine 539
    Link$ inspect$539$3=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$macro$dump setPar(Object param) {
        //Util.BREAK("CALL Common$macro$dump.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$bx=(Common$symbolbox)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$macro$dump(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Common$macro$dump(RTObject$ SL$,Common$symbolbox sp$bx) {
        super(SL$);
        // Parameter assignment to locals
        this.p$bx = sp$bx;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$macro$dump STM$() {
        // JavaLine 42 <== SourceLine 536
        sysout().outtext(CONC(CONC(new TXT$(" Macro "),p$bx.symbol),new TXT$(":")));
        ;
        sysout().outimage();
        ;
        // JavaLine 47 <== SourceLine 537
        ms=((Common$macro)(CUR$.SL$)).first();
        ;
        // JavaLine 50 <== SourceLine 538
        while((ms!=(null))) {
            {
                // JavaLine 53 <== SourceLine 539
                {
                    // BEGIN INSPECTION 
                    inspect$539$3=ms;
                    //INSPECT inspect$539$3
                    if(inspect$539$3 instanceof Common$macro_symbol) // WHEN Common$macro_symbol DO 
                    new Common$macro_symbol$dump(((Common$macro_symbol)(inspect$539$3)));
                    else if(inspect$539$3 instanceof Common$macro_param) // WHEN Common$macro_param DO 
                    new Common$macro_param$dump(((Common$macro_param)(inspect$539$3)));
                }
                ;
                // JavaLine 64 <== SourceLine 540
                ms=ms.suc();
                ;
            }
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure dump",1,534,11,535,13,539,42,536,47,537,50,538,53,539,64,540,72,541);
} // End of Procedure
