// JavaLine 1 ==> SourceLine 240
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:26 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$precheck0$invischain extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=240, lastLine=255, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$quantity p$q;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 243
    COMMON$identsymbol inspect$243$3=null;
    // JavaLine 14 ==> SourceLine 245
    COMMON$sembox inspect$245$4=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$precheck0$invischain setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$precheck0$invischain.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public BUILDER1$precheck0$invischain(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$precheck0$invischain(RTObject$ SL$,COMMON$quantity sp$q) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("invischain",245);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$precheck0$invischain STM$() {
        TRACE_BEGIN_STM$("invischain",245);
        // JavaLine 45 ==> SourceLine 242
        while((p$q!=(null))) {
            // JavaLine 47 ==> SourceLine 243
            {
                TRACE_BEGIN_STM$("CompoundStatement243",243);
                {
                    // BEGIN INSPECTION 
                    inspect$243$3=((COMMON$identsymbol)(p$q.symb));
                    if(inspect$243$3!=null) //INSPECT inspect$243$3
                    // JavaLine 54 ==> SourceLine 244
                    {
                        TRACE_BEGIN_STM$("CompoundStatement244",244);
                        if((inspect$243$3.curmeaning==(p$q))) {
                            // JavaLine 58 ==> SourceLine 245
                            {
                                TRACE_BEGIN_STM$("CompoundStatement245",245);
                                {
                                    // BEGIN INSPECTION 
                                    inspect$245$4=inspect$243$3.curmeaning.prevmeaning;
                                    if(inspect$245$4!=null) //INSPECT inspect$245$4
                                    // JavaLine 65 ==> SourceLine 246
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement246",246);
                                        inspect$243$3.curmeaning.prevmeaning=inspect$245$4.prevmeaning;
                                        // JavaLine 69 ==> SourceLine 247
                                        inspect$243$3.curmeaning=inspect$245$4.next;
                                        TRACE_END_STM$("CompoundStatement246",247);
                                    }
                                    else // OTHERWISE 
                                    // JavaLine 74 ==> SourceLine 249
                                    inspect$243$3.curmeaning=null;
                                }
                                TRACE_END_STM$("CompoundStatement245",249);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement244",249);
                    }
                }
                // JavaLine 83 ==> SourceLine 252
                p$q=((COMMON$quantity)(p$q.next));
                TRACE_END_STM$("CompoundStatement243",252);
            }
        }
        TRACE_END_STM$("invischain",252);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure invischain",1,240,12,243,14,245,45,242,47,243,54,244,58,245,65,246,69,247,74,249,83,252,91,255);
}
