package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$deftag extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=279, lastLine=284, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$descr p$d;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$deftag setPar(Object param) {
        //Util.BREAK("CALL Common$deftag.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$d=(Common$descr)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$deftag(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Common$deftag(RTObject$ SL$,Common$descr sp$d) {
        super(SL$);
        // Parameter assignment to locals
        this.p$d = sp$d;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$deftag STM$() {
        // JavaLine 37 <== SourceLine 280
        if(VALUE$((p$d.xtag$2==(0)))) {
            // JavaLine 39 <== SourceLine 281
            {
                new Common$newtag(((Common)(CUR$.SL$)),p$d.symb$2);
                ;
                p$d.tag$2=((Common)(CUR$.SL$)).ntag$1;
                ;
            }
        } else
        // JavaLine 47 <== SourceLine 283
        {
            p$d.tag$2=p$d.xtag$2;
            ;
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure deftag",37,280,39,281,47,283,54,284);
} // End of Procedure
