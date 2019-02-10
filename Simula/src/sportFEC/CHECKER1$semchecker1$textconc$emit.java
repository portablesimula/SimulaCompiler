// JavaLine 1 ==> SourceLine 676
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$textconc$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=676, lastLine=686, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 680
    final LABQNT$ NXT=new LABQNT$(this,0,1); // Local Label #1=NXT
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$textconc$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",680);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$textconc$emit STM$() {
        TRACE_BEGIN_STM$("emit",680);
        CHECKER1$semchecker1$textconc$emit THIS$=(CHECKER1$semchecker1$textconc$emit)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 30 ==> SourceLine 677
                if(VALUE$((((CHECKER1$semchecker1$textconc)(CUR$.SL$)).ntext>(0)))) {
                    // JavaLine 32 ==> SourceLine 678
                    {
                        TRACE_BEGIN_STM$("CompoundStatement678",678);
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ICONC;
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opihi=char$(((CHECKER1$semchecker1$textconc)(CUR$.SL$)).ntext);
                        // JavaLine 37 ==> SourceLine 679
                        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                        // JavaLine 39 ==> SourceLine 680
                        LABEL$(1,"NXT");
                        new CHECKER1$semchecker1$textoperand$emit(((CHECKER1$semchecker1$textconc)(CUR$.SL$)).first);
                        ((CHECKER1$semchecker1$textconc)(CUR$.SL$)).first=((CHECKER1$semchecker1$textconc)(CUR$.SL$)).first.next;
                        // JavaLine 43 ==> SourceLine 681
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ICONC;
                        // JavaLine 45 ==> SourceLine 682
                        if(VALUE$((((CHECKER1$semchecker1$textconc)(CUR$.SL$)).first!=(null)))) {
                            // JavaLine 47 ==> SourceLine 683
                            {
                                TRACE_BEGIN_STM$("CompoundStatement683",683);
                                call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                                GOTO$(NXT); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement683",683);
                            }
                        }
                        // JavaLine 55 ==> SourceLine 684
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=((char)1);
                        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                        TRACE_END_STM$("CompoundStatement678",684);
                    }
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
        TRACE_END_STM$("emit",684);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,676,11,680,30,677,32,678,37,679,39,680,43,681,45,682,47,683,55,684,77,686);
}
