// JavaLine 1 ==> SourceLine 464
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:31 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$precheck0$resethide extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=464, lastLine=484, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$quantity p$q;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 478
    BUILDER1$precheck0$ignore inspect$478$64=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$precheck0$resethide setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$precheck0$resethide.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$q=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER1$precheck0$resethide(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$precheck0$resethide(RTObject$ SL$,COMMON$quantity sp$q) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("resethide",478);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$precheck0$resethide STM$() {
        TRACE_BEGIN_STM$("resethide",478);
        // JavaLine 43 ==> SourceLine 476
        while((((BUILDER1$precheck0)(CUR$.SL$)).curhp!=(null))) {
            // JavaLine 45 ==> SourceLine 478
            {
                // BEGIN INSPECTION 
                inspect$478$64=((BUILDER1$precheck0)(CUR$.SL$)).curhp;
                if(inspect$478$64!=null) //INSPECT inspect$478$64
                // JavaLine 50 ==> SourceLine 479
                {
                    TRACE_BEGIN_STM$("CompoundStatement479",479);
                    inspect$478$64.p$q.protect=((char)1);
                    inspect$478$64.p$q.visible=((BUILDER1)(CUR$.SL$.SL$)).NUL;
                    // JavaLine 55 ==> SourceLine 480
                    inspect$478$64.p$hp.line=(-(inspect$478$64.p$hp.line));
                    // JavaLine 57 ==> SourceLine 481
                    ((BUILDER1$precheck0)(CUR$.SL$)).curhp=inspect$478$64.prev;
                    TRACE_END_STM$("CompoundStatement479",481);
                }
            }
        }
        // JavaLine 63 ==> SourceLine 483
        new BUILDER1$precheck0$resethide$reprtct(((BUILDER1$precheck0$resethide)CUR$),p$q);
        TRACE_END_STM$("resethide",483);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure resethide",1,464,12,478,43,476,45,478,50,479,55,480,57,481,63,483,68,484);
}
