// JavaLine 1 <== SourceLine 390
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$leftint extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=390, lastLine=394, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$leftint setPar(Object param) {
        //Util.BREAK("CALL Common$leftint.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public Common$leftint(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Common$leftint(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$leftint STM$() {
        // JavaLine 41 <== SourceLine 391
        TXT$.putint(((Common)(CUR$.SL$)).leftintbuf$1,p$i);
        ;
        p$i=11;
        ;
        // JavaLine 46 <== SourceLine 392
        while((loadChar(((Common)(CUR$.SL$)).leftintbuf$1,p$i)!=(((char)32)))) {
            p$i=Math.subtractExact(p$i,1);
        }
        ;
        // JavaLine 51 <== SourceLine 393
        RESULT$=TXT$.sub(((Common)(CUR$.SL$)).leftintbuf$1,Math.addExact(p$i,2),Math.subtractExact(11,p$i));
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure leftint",1,390,41,391,46,392,51,393,56,394);
} // End of Procedure
