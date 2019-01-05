// JavaLine 1 ==> SourceLine 355
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:46:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$readprocpar$procparerror extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=355, lastLine=367, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$errno;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 357
    final LABQNT$ searchagain=new LABQNT$(this,0,1); // Local Label #1=searchagain
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public PARSER$grammer$readprocpar$procparerror setPar(Object param) {
        //Util.BREAK("CALL PARSER$grammer$readprocpar$procparerror.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public PARSER$grammer$readprocpar$procparerror(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public PARSER$grammer$readprocpar$procparerror(RTObject$ SL$,int sp$errno) {
        super(SL$);
        // Parameter assignment to locals
        this.p$errno = sp$errno;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("procparerror",357);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$readprocpar$procparerror STM$() {
        TRACE_BEGIN_STM$("procparerror",357);
        PARSER$grammer$readprocpar$procparerror THIS$=(PARSER$grammer$readprocpar$procparerror)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 48 ==> SourceLine 356
                new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$.SL$)),p$errno);
                // JavaLine 50 ==> SourceLine 357
                LABEL$(1); // searchagain
                new PARSER$grammer$search(((PARSER$grammer)(CUR$.SL$.SL$)));
                // JavaLine 53 ==> SourceLine 358
                if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IEND))) {
                    // JavaLine 55 ==> SourceLine 359
                    {
                        TRACE_BEGIN_STM$("CompoundStatement359",359);
                        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        GOTO$(searchagain); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement359",359);
                    }
                }
                // JavaLine 63 ==> SourceLine 360
                if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).ICOMA))) {
                    GOTO$(((PARSER$grammer$readprocpar)(CUR$.SL$)).P1); // GOTO EVALUATED LABEL
                }
                // JavaLine 67 ==> SourceLine 361
                if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).ISMCL))) {
                    // JavaLine 69 ==> SourceLine 362
                    {
                        TRACE_BEGIN_STM$("CompoundStatement362",362);
                        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        GOTO$(((PARSER$grammer$readprocpar)(CUR$.SL$)).namevaluepart); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement362",362);
                    }
                }
                // JavaLine 77 ==> SourceLine 363
                if(((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).INAME))||((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IVALU))))) {
                    GOTO$(((PARSER$grammer$readprocpar)(CUR$.SL$)).namevaluepart); // GOTO EVALUATED LABEL
                }
                // JavaLine 81 ==> SourceLine 364
                if((((PARSER$grammer)(CUR$.SL$.SL$)).symboltype.Elt[rank(((PARSER$grammer)(CUR$.SL$.SL$)).cs)-((PARSER$grammer)(CUR$.SL$.SL$)).symboltype.LB[0]]==(((PARSER$grammer)(CUR$.SL$.SL$)).declsymbol))) {
                    // JavaLine 83 ==> SourceLine 365
                    GOTO$(((PARSER$grammer$readprocpar)(CUR$.SL$)).specification); // GOTO EVALUATED LABEL
                }
                // JavaLine 86 ==> SourceLine 366
                GOTO$(((PARSER$grammer$readprocpar)(CUR$.SL$)).readprocparexit); // GOTO EVALUATED LABEL
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
        TRACE_END_STM$("procparerror",366);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure procparerror",1,355,12,357,48,356,50,357,53,358,55,359,63,360,67,361,69,362,77,363,81,364,83,365,86,366,104,367);
}
