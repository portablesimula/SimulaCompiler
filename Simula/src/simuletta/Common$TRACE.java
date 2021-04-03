// JavaLine 1 <== SourceLine 337
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$TRACE extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=337, lastLine=346, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public TXT$ p$id;
    public int p$lno;
    public TXT$ p$msg;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$TRACE setPar(Object param) {
        //Util.BREAK("CALL Common$TRACE.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 3: p$id=(TXT$)objectValue(param); break;
                case 2: p$lno=intValue(param); break;
                case 1: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$TRACE(RTObject$ SL$) {
        super(SL$,3); // Expecting 3 parameters
    }
    // Normal Constructor
    public Common$TRACE(RTObject$ SL$,TXT$ sp$id,int sp$lno,TXT$ sp$msg) {
        super(SL$);
        // Parameter assignment to locals
        this.p$id = sp$id;
        this.p$lno = sp$lno;
        this.p$msg = sp$msg;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$TRACE STM$() {
        // JavaLine 44 <== SourceLine 338
        if(VALUE$((((Common)(CUR$.SL$)).DO_TRACING$1>(0)))) {
            // JavaLine 46 <== SourceLine 339
            {
                if(VALUE$((((Common)(CUR$.SL$)).curline$1>(0)))) {
                    sysout().outtext(CONC(CONC(new TXT$("LINE "),new Common$leftint(((Common)(CUR$.SL$)),((Common)(CUR$.SL$)).curline$1).RESULT$),new TXT$("  ")));
                }
                ;
                // JavaLine 52 <== SourceLine 340
                sysout().outtext(p$id);
                ;
                sysout().outtext(new TXT$("("));
                ;
                // JavaLine 57 <== SourceLine 341
                sysout().outint(p$lno,0);
                ;
                sysout().outtext(new TXT$(")  "));
                ;
                // JavaLine 62 <== SourceLine 342
                sysout().outtext(p$msg);
                ;
                // JavaLine 65 <== SourceLine 344
                sysout().breakoutimage();
                ;
                sysin().inimage();
                ;
            }
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure TRACE",1,337,44,338,46,339,52,340,57,341,62,342,65,344,75,346);
} // End of Procedure
