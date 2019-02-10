// JavaLine 1 ==> SourceLine 813
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$declaration$externalItem extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=813, lastLine=830, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 827
    final LABQNT$ NoSpec=new LABQNT$(this,0,1); // Local Label #1=NoSpec
    // Declare locals as attributes
    // Normal Constructor
    public PARSER$grammer$declaration$externalItem(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("externalItem",827);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$declaration$externalItem STM$() {
        TRACE_BEGIN_STM$("externalItem",827);
        PARSER$grammer$declaration$externalItem THIS$=(PARSER$grammer$declaration$externalItem)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 30 ==> SourceLine 814
                ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                // JavaLine 32 ==> SourceLine 815
                if(VALUE$((((PARSER$grammer)(CUR$.SL$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$.SL$)).IIDN)))) {
                    new PARSER$grammer$declaration$declError(((PARSER$grammer$declaration)(CUR$.SL$)),185);
                }
                // JavaLine 36 ==> SourceLine 816
                ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IEXTR;
                call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                // JavaLine 39 ==> SourceLine 817
                ((PARSER$grammer)(CUR$.SL$.SL$)).getopt=false;
                ((PARSER$grammer)(CUR$.SL$.SL$)).cs=((PARSER)(CUR$.SL$.SL$.SL$)).opt;
                // JavaLine 42 ==> SourceLine 818
                if(VALUE$((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IEQ)))) {
                    // JavaLine 44 ==> SourceLine 819
                    {
                        TRACE_BEGIN_STM$("CompoundStatement819",819);
                        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        // JavaLine 48 ==> SourceLine 820
                        if(VALUE$(((((PARSER$grammer)(CUR$.SL$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$.SL$)).ICONS))|((((PARSER)(CUR$.SL$.SL$.SL$)).optx!=(((PARSER)(CUR$.SL$.SL$.SL$)).ITEXT)))))) {
                            // JavaLine 50 ==> SourceLine 821
                            {
                                TRACE_BEGIN_STM$("CompoundStatement821",821);
                                new PARSER$grammer$skip(((PARSER$grammer)(CUR$.SL$.SL$)),193);
                                GOTO$(NoSpec); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement821",821);
                            }
                        }
                        // JavaLine 58 ==> SourceLine 822
                        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IEXNM;
                        call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                        // JavaLine 61 ==> SourceLine 823
                        ((PARSER$grammer)(CUR$.SL$.SL$)).getopt=false;
                        ((PARSER$grammer)(CUR$.SL$.SL$)).cs=((PARSER)(CUR$.SL$.SL$.SL$)).opt;
                        TRACE_END_STM$("CompoundStatement819",823);
                    }
                } else
                // JavaLine 67 ==> SourceLine 827
                {
                    TRACE_BEGIN_STM$("CompoundStatement827",827);
                    LABEL$(1,"NoSpec");
                    ((PARSER)(CUR$.SL$.SL$.SL$)).opdhi=((PARSER)(CUR$.SL$.SL$.SL$)).opdlo=((PARSER)(CUR$.SL$.SL$.SL$)).NUL;
                    // JavaLine 72 ==> SourceLine 828
                    ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IEXNM;
                    call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                    TRACE_END_STM$("CompoundStatement827",828);
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
        TRACE_END_STM$("externalItem",828);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure externalItem",1,813,11,827,30,814,32,815,36,816,39,817,42,818,44,819,48,820,50,821,58,822,61,823,67,827,72,828,93,830);
}
