// JavaLine 1 <== SourceLine 107
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:45 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class OuptFile$outlongstring extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=107, lastLine=112, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public TXT$ p$t;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public OuptFile$outlongstring setPar(Object param) {
        //Util.BREAK("CALL OuptFile$outlongstring.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$t=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public OuptFile$outlongstring(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public OuptFile$outlongstring(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t = sp$t;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public OuptFile$outlongstring STM$() {
        // JavaLine 38 <== SourceLine 109
        if(VALUE$((((OuptFile)(CUR$.SL$)).output_trace$3>(0)))) {
            // JavaLine 40 <== SourceLine 110
            new OuptFile$TRC(((OuptFile)(CUR$.SL$)),copy(new TXT$("Outlongstring")),CONC(CONC(new TXT$("\""),p$t),new TXT$("\"")));
        }
        ;
        // JavaLine 44 <== SourceLine 111
        ((OuptFile)(CUR$.SL$)).out2byte(TXT$.length(p$t));
        ;
        ((OuptFile)(CUR$.SL$)).outtext(p$t);
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("OUPTFILE.sim","Procedure outlongstring",1,107,38,109,40,110,44,111,51,112);
} // End of Procedure
