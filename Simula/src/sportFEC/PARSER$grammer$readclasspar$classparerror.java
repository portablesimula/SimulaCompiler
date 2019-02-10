// JavaLine 1 ==> SourceLine 437
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$readclasspar$classparerror extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=437, lastLine=448, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$errno;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 439
    final LABQNT$ srchagain=new LABQNT$(this,0,1); // Local Label #1=srchagain
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public PARSER$grammer$readclasspar$classparerror setPar(Object param) {
        //Util.BREAK("CALL PARSER$grammer$readclasspar$classparerror.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$errno=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public PARSER$grammer$readclasspar$classparerror(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public PARSER$grammer$readclasspar$classparerror(RTObject$ SL$,int sp$errno) {
        super(SL$);
        // Parameter assignment to locals
        this.p$errno = sp$errno;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("classparerror",439);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$readclasspar$classparerror STM$() {
        TRACE_BEGIN_STM$("classparerror",439);
        PARSER$grammer$readclasspar$classparerror THIS$=(PARSER$grammer$readclasspar$classparerror)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 48 ==> SourceLine 438
                new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$.SL$)),p$errno);
                // JavaLine 50 ==> SourceLine 439
                LABEL$(1,"srchagain");
                new PARSER$grammer$search(((PARSER$grammer)(CUR$.SL$.SL$)));
                // JavaLine 53 ==> SourceLine 440
                if(VALUE$((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IEND)))) {
                    // JavaLine 55 ==> SourceLine 441
                    {
                        TRACE_BEGIN_STM$("CompoundStatement441",441);
                        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        GOTO$(srchagain); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement441",441);
                    }
                }
                // JavaLine 63 ==> SourceLine 442
                if(VALUE$((((PARSER$grammer)(CUR$.SL$.SL$)).symboltype.Elt[rank(((PARSER$grammer)(CUR$.SL$.SL$)).cs)-((PARSER$grammer)(CUR$.SL$.SL$)).symboltype.LB[0]]==(((PARSER$grammer)(CUR$.SL$.SL$)).declsymbol)))) {
                    // JavaLine 65 ==> SourceLine 443
                    GOTO$(((PARSER$grammer$readclasspar)(CUR$.SL$)).specification); // GOTO EVALUATED LABEL
                }
                // JavaLine 68 ==> SourceLine 444
                if(VALUE$((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IVIRT)))) {
                    GOTO$(((PARSER$grammer$readclasspar)(CUR$.SL$)).virtualspec); // GOTO EVALUATED LABEL
                }
                // JavaLine 72 ==> SourceLine 445
                if(VALUE$((((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IHIDD))|((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IPRTC))))|((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).ITO)))))) {
                    // JavaLine 74 ==> SourceLine 446
                    GOTO$(((PARSER$grammer$readclasspar)(CUR$.SL$)).hiddenprotected); // GOTO EVALUATED LABEL
                }
                // JavaLine 77 ==> SourceLine 447
                GOTO$(((PARSER$grammer$readclasspar)(CUR$.SL$)).readclassparexit); // GOTO EVALUATED LABEL
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
        TRACE_END_STM$("classparerror",447);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure classparerror",1,437,12,439,48,438,50,439,53,440,55,441,63,442,65,443,68,444,72,445,74,446,77,447,95,448);
}
