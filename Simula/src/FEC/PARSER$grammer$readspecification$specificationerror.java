// JavaLine 1 ==> SourceLine 508
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$readspecification$specificationerror extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=508, lastLine=518, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$errno;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 510
    final LABQNT$ searchagain=new LABQNT$(this,0,1); // Local Label #1=searchagain
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public PARSER$grammer$readspecification$specificationerror setPar(Object param) {
        //Util.BREAK("CALL PARSER$grammer$readspecification$specificationerror.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public PARSER$grammer$readspecification$specificationerror(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public PARSER$grammer$readspecification$specificationerror(RTObject$ SL$,int sp$errno) {
        super(SL$);
        // Parameter assignment to locals
        this.p$errno = sp$errno;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("specificationerror",510);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$readspecification$specificationerror STM$() {
        TRACE_BEGIN_STM$("specificationerror",510);
        PARSER$grammer$readspecification$specificationerror THIS$=(PARSER$grammer$readspecification$specificationerror)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 48 ==> SourceLine 509
                new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$.SL$)),p$errno);
                // JavaLine 50 ==> SourceLine 510
                LABEL$(1); // searchagain
                new PARSER$grammer$search(((PARSER$grammer)(CUR$.SL$.SL$)));
                // JavaLine 53 ==> SourceLine 511
                if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IEND))) {
                    // JavaLine 55 ==> SourceLine 512
                    {
                        TRACE_BEGIN_STM$("CompoundStatement512",512);
                        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        GOTO$(searchagain); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement512",512);
                    }
                }
                // JavaLine 63 ==> SourceLine 513
                if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).ICOMA))) {
                    GOTO$(((PARSER$grammer$readspecification)(CUR$.SL$)).P3); // GOTO EVALUATED LABEL
                }
                // JavaLine 67 ==> SourceLine 514
                if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).ISMCL))) {
                    // JavaLine 69 ==> SourceLine 515
                    {
                        TRACE_BEGIN_STM$("CompoundStatement515",515);
                        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        GOTO$(((PARSER$grammer$readspecification)(CUR$.SL$)).spes); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement515",515);
                    }
                }
                // JavaLine 77 ==> SourceLine 516
                if((((PARSER$grammer)(CUR$.SL$.SL$)).symboltype.Elt[rank(((PARSER$grammer)(CUR$.SL$.SL$)).cs)-((PARSER$grammer)(CUR$.SL$.SL$)).symboltype.LB[0]]==(((PARSER$grammer)(CUR$.SL$.SL$)).declsymbol))) {
                    GOTO$(((PARSER$grammer$readspecification)(CUR$.SL$)).spes); // GOTO EVALUATED LABEL
                }
                // JavaLine 81 ==> SourceLine 517
                GOTO$(((PARSER$grammer$readspecification)(CUR$.SL$)).readspecificationexit); // GOTO EVALUATED LABEL
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
        TRACE_END_STM$("specificationerror",517);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure specificationerror",1,508,12,510,48,509,50,510,53,511,55,512,63,513,67,514,69,515,77,516,81,517,99,518);
}
