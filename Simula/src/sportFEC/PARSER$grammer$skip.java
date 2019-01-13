// JavaLine 1 ==> SourceLine 276
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:24 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$skip extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=276, lastLine=282, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$err;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 280
    final LABQNT$ REP=new LABQNT$(this,0,1); // Local Label #1=REP
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public PARSER$grammer$skip setPar(Object param) {
        //Util.BREAK("CALL PARSER$grammer$skip.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$err=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public PARSER$grammer$skip(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public PARSER$grammer$skip(RTObject$ SL$,int sp$err) {
        super(SL$);
        // Parameter assignment to locals
        this.p$err = sp$err;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("skip",280);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$skip STM$() {
        TRACE_BEGIN_STM$("skip",280);
        PARSER$grammer$skip THIS$=(PARSER$grammer$skip)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 48 ==> SourceLine 279
                if((p$err!=(0))) {
                    new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$)),p$err);
                }
                // JavaLine 52 ==> SourceLine 280
                LABEL$(1); // REP
                new PARSER$grammer$search(((PARSER$grammer)(CUR$.SL$)));
                // JavaLine 55 ==> SourceLine 281
                if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ISMCL))) {
                    new PARSER$grammer$NEXTSYMBOL(((PARSER$grammer)(CUR$.SL$)));
                }
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$ || q.prefixLevel!=0) {
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("skip",281);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure skip",1,276,12,280,48,279,52,280,55,281,75,282);
}
