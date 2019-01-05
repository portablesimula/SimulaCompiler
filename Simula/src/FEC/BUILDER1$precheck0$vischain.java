// JavaLine 1 ==> SourceLine 219
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:59:08 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$precheck0$vischain extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=219, lastLine=236, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$quantity p$q;
    public COMMON$quantity p$visq;
    // Declare locals as attributes
    // JavaLine 13 ==> SourceLine 224
    COMMON$identsymbol inspect$224$56=null;
    // JavaLine 15 ==> SourceLine 227
    COMMON$sembox inspect$227$57=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$precheck0$vischain setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$precheck0$vischain.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$q=(COMMON$quantity)objectValue(param); break;
                case 1: p$visq=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER1$precheck0$vischain(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$precheck0$vischain(RTObject$ SL$,COMMON$quantity sp$q,COMMON$quantity sp$visq) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        this.p$visq = sp$visq;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("vischain",227);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$precheck0$vischain STM$() {
        TRACE_BEGIN_STM$("vischain",227);
        // JavaLine 48 ==> SourceLine 221
        p$visq=p$q;
        // JavaLine 50 ==> SourceLine 222
        while((p$visq!=(null))) {
            // JavaLine 52 ==> SourceLine 223
            {
                TRACE_BEGIN_STM$("CompoundStatement223",223);
                if((p$visq.visible==(((BUILDER1)(CUR$.SL$.SL$)).NUL))) {
                    // JavaLine 56 ==> SourceLine 224
                    {
                        // BEGIN INSPECTION 
                        inspect$224$56=((COMMON$identsymbol)(p$visq.symb));
                        if(inspect$224$56!=null) //INSPECT inspect$224$56
                        // JavaLine 61 ==> SourceLine 226
                        {
                            TRACE_BEGIN_STM$("CompoundStatement226",226);
                            if(((inspect$224$56.curmeaning!=(null))||((p$visq==(inspect$224$56.curmeaning))))) {
                                // JavaLine 65 ==> SourceLine 227
                                {
                                    // BEGIN INSPECTION 
                                    inspect$227$57=new COMMON$sembox(((BUILDER1)(CUR$.SL$.SL$))).STM$();
                                    if(inspect$227$57!=null) //INSPECT inspect$227$57
                                    // JavaLine 70 ==> SourceLine 228
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement228",228);
                                        inspect$227$57.prevmeaning=p$visq.prevmeaning;
                                        inspect$227$57.next=inspect$224$56.curmeaning;
                                        // JavaLine 75 ==> SourceLine 229
                                        p$visq.prevmeaning=((COMMON$sembox)inspect$227$57);
                                        TRACE_END_STM$("CompoundStatement228",229);
                                    }
                                }
                            }
                            // JavaLine 81 ==> SourceLine 231
                            inspect$224$56.curmeaning=p$visq;
                            TRACE_END_STM$("CompoundStatement226",231);
                        }
                    }
                }
                // JavaLine 87 ==> SourceLine 233
                p$visq=((COMMON$quantity)(p$visq.next));
                TRACE_END_STM$("CompoundStatement223",233);
            }
        }
        TRACE_END_STM$("vischain",233);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure vischain",1,219,13,224,15,227,48,221,50,222,52,223,56,224,61,226,65,227,70,228,75,229,81,231,87,233,95,236);
}
