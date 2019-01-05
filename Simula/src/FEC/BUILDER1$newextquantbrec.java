// JavaLine 1 ==> SourceLine 672
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:59:08 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$newextquantbrec extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=672, lastLine=683, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public COMMON$extquantity RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public char p$blv;
    public char p$rtblv;
    public char p$stat;
    public COMMON$extquantity p$caus;
    // Declare locals as attributes
    // JavaLine 18 ==> SourceLine 675
    COMMON$extquantity qe=null;
    // JavaLine 20 ==> SourceLine 677
    COMMON$extbrecord inspect$677$66=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$newextquantbrec setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$newextquantbrec.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$blv=(char)objectValue(param); break;
                case 1: p$rtblv=(char)objectValue(param); break;
                case 2: p$stat=(char)objectValue(param); break;
                case 3: p$caus=(COMMON$extquantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER1$newextquantbrec(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$newextquantbrec(RTObject$ SL$,char sp$blv,char sp$rtblv,char sp$stat,COMMON$extquantity sp$caus) {
        super(SL$);
        // Parameter assignment to locals
        this.p$blv = sp$blv;
        this.p$rtblv = sp$rtblv;
        this.p$stat = sp$stat;
        this.p$caus = sp$caus;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("newextquantbrec",677);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$newextquantbrec STM$() {
        TRACE_BEGIN_STM$("newextquantbrec",677);
        {
            // BEGIN INSPECTION 
            inspect$677$66=new COMMON$extbrecord(((BUILDER1)(CUR$.SL$))).STM$();
            if(inspect$677$66!=null) //INSPECT inspect$677$66
            // JavaLine 61 ==> SourceLine 678
            {
                TRACE_BEGIN_STM$("CompoundStatement678",678);
                inspect$677$66.blev=char$((rank(p$blv)+(1)));
                inspect$677$66.rtblev=char$((rank(p$rtblv)+(1)));
                // JavaLine 66 ==> SourceLine 679
                RESULT$=qe=new COMMON$extquantity(((BUILDER1)(CUR$.SL$)),((COMMON$extbrecord)inspect$677$66)).STM$();
                // JavaLine 68 ==> SourceLine 680
                qe.descr=((COMMON$extbrecord)inspect$677$66);
                // JavaLine 70 ==> SourceLine 681
                inspect$677$66.declquant=qe;
                inspect$677$66.status=p$stat;
                inspect$677$66.cause=p$caus;
                TRACE_END_STM$("CompoundStatement678",681);
            }
        }
        TRACE_END_STM$("newextquantbrec",681);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure newextquantbrec",1,672,18,675,20,677,61,678,66,679,68,680,70,681,80,683);
}
