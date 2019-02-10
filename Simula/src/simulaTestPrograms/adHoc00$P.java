// JavaLine 1 ==> SourceLine 4
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:36:51 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc00$P extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=4, lastLine=21, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 9
    final LABQNT$ N=new LABQNT$(this,0,1); // Local Label #1=N
    // JavaLine 13 ==> SourceLine 13
    final LABQNT$ T1=new LABQNT$(this,0,2); // Local Label #2=T1
    // JavaLine 15 ==> SourceLine 16
    final LABQNT$ L2=new LABQNT$(this,0,3); // Local Label #3=L2
    // JavaLine 17 ==> SourceLine 19
    final LABQNT$ L3=new LABQNT$(this,0,4); // Local Label #4=L3
    final LABQNT$ L4=new LABQNT$(this,0,5); // Local Label #5=L4
    // JavaLine 20 ==> SourceLine 20
    final LABQNT$ L5=new LABQNT$(this,0,6); // Local Label #6=L5
    final LABQNT$ EXIT=new LABQNT$(this,0,7); // Local Label #7=EXIT
    // Declare locals as attributes
    // Normal Constructor
    public adHoc00$P(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("P",20);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public adHoc00$P STM$() {
        TRACE_BEGIN_STM$("P",20);
        adHoc00$P THIS$=(adHoc00$P)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 40 ==> SourceLine 6
                if(VALUE$((((adHoc00)(CUR$.SL$)).i<(44)))) {
                    GOTO$(N); // GOTO EVALUATED LABEL
                }
                // JavaLine 44 ==> SourceLine 8
                {
                    TRACE_BEGIN_STM$("CompoundStatement8",8);
                    ((adHoc00)(CUR$.SL$)).i=65;
                    // JavaLine 48 ==> SourceLine 9
                    LABEL$(1,"N");
                    ((adHoc00)(CUR$.SL$)).j=44;
                    TRACE_END_STM$("CompoundStatement8",9);
                }
                // JavaLine 53 ==> SourceLine 13
                LABEL$(2,"T1");
                sysout().outtext(new TXT$("AT T1 -- Should GOTO L2"));
                sysout().outimage();
                // JavaLine 57 ==> SourceLine 14
                GOTO$(L2); // GOTO EVALUATED LABEL
                // JavaLine 59 ==> SourceLine 15
                ((adHoc00)(CUR$.SL$)).i=78;
                // JavaLine 61 ==> SourceLine 16
                LABEL$(3,"L2");
                sysout().outtext(new TXT$("AT L2 -- Should GOTO EXIT"));
                sysout().outimage();
                // JavaLine 65 ==> SourceLine 17
                GOTO$(EXIT); // GOTO EVALUATED LABEL
                // JavaLine 67 ==> SourceLine 18
                ((adHoc00)(CUR$.SL$)).i=(((adHoc00)(CUR$.SL$)).i+(1));
                // JavaLine 69 ==> SourceLine 20
                LABEL$(4,"L3");
                LABEL$(5,"L4");
                LABEL$(6,"L5");
                LABEL$(7,"EXIT");
                sysout().outint(((adHoc00)(CUR$.SL$)).i,0);
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
        TRACE_END_STM$("P",20);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc00.sim","Procedure P",1,4,11,9,13,13,15,16,17,19,20,20,40,6,44,8,48,9,53,13,57,14,59,15,61,16,65,17,67,18,69,20,91,21);
}
