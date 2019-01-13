// JavaLine 1 ==> SourceLine 369
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:19 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$removeVis extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=369, lastLine=379, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$brecord p$brc;
    public COMMON$idpack p$visp;
    public int p$err;
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 372
    COMMON$idpack prev=null;
    COMMON$idpack cur=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$removeVis setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$removeVis.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$brc=(COMMON$brecord)objectValue(param); break;
                case 1: p$visp=(COMMON$idpack)objectValue(param); break;
                case 2: p$err=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$removeVis(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$removeVis(RTObject$ SL$,COMMON$brecord sp$brc,COMMON$idpack sp$visp,int sp$err) {
        super(SL$);
        // Parameter assignment to locals
        this.p$brc = sp$brc;
        this.p$visp = sp$visp;
        this.p$err = sp$err;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("removeVis",372);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$removeVis STM$() {
        TRACE_BEGIN_STM$("removeVis",372);
        // JavaLine 50 ==> SourceLine 373
        ((ERRMSG)(CUR$.SL$)).messageLinenr=p$visp.line;
        // JavaLine 52 ==> SourceLine 374
        ((ERRMSG)(CUR$.SL$)).diag.Elt[0-((ERRMSG)(CUR$.SL$)).diag.LB[0]]=new COMMON$boxof(((ERRMSG)(CUR$.SL$)),p$visp.idhi,p$visp.idlo).RESULT$.symbol;
        new ERRMSG$error0(((ERRMSG)(CUR$.SL$)),(-(p$err)));
        // JavaLine 55 ==> SourceLine 375
        cur=p$brc.hidlist;
        // JavaLine 57 ==> SourceLine 376
        while((cur!=(p$visp))) {
            {
                TRACE_BEGIN_STM$("CompoundStatement376",376);
                prev=cur;
                cur=cur.next;
                TRACE_END_STM$("CompoundStatement376",376);
            }
        }
        // JavaLine 66 ==> SourceLine 377
        if((prev==(null))) {
            p$brc.hidlist=p$visp.next;
        } else
        // JavaLine 70 ==> SourceLine 378
        prev.next=p$visp.next;
        TRACE_END_STM$("removeVis",378);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure removeVis",1,369,14,372,50,373,52,374,55,375,57,376,66,377,70,378,75,379);
}
