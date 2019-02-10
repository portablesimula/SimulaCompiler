// JavaLine 1 ==> SourceLine 1
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri Feb 08 21:46:43 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class A extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=1, PrefixLevel=0, firstLine=1, lastLine=21, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 13
    final LABQNT$ T1=new LABQNT$(this,0,1); // Local Label #1=T1
    // JavaLine 13 ==> SourceLine 16
    final LABQNT$ L2=new LABQNT$(this,0,2); // Local Label #2=L2
    // JavaLine 15 ==> SourceLine 19
    final LABQNT$ L3=new LABQNT$(this,0,3); // Local Label #3=L3
    final LABQNT$ L4=new LABQNT$(this,0,4); // Local Label #4=L4
    // JavaLine 18 ==> SourceLine 20
    final LABQNT$ L5=new LABQNT$(this,0,5); // Local Label #5=L5
    final LABQNT$ EXIT=new LABQNT$(this,0,6); // Local Label #6=EXIT
    // Declare locals as attributes
    // JavaLine 22 ==> SourceLine 3
    public int i=0;
    // Normal Constructor
    public A(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("A",10);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("A",10,inner);
                A THIS$=(A)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 39 ==> SourceLine 13
                        LABEL$(1,"T1");
                        sysout().outtext(new TXT$("AT T1 -- Should GOTO L2"));
                        sysout().outimage();
                        // JavaLine 43 ==> SourceLine 14
                        GOTO$(L2); // GOTO EVALUATED LABEL
                        // JavaLine 45 ==> SourceLine 15
                        i=78;
                        // JavaLine 47 ==> SourceLine 16
                        LABEL$(2,"L2");
                        sysout().outtext(new TXT$("AT L2 -- Should GOTO EXIT"));
                        sysout().outimage();
                        // JavaLine 51 ==> SourceLine 17
                        GOTO$(EXIT); // GOTO EVALUATED LABEL
                        // JavaLine 53 ==> SourceLine 18
                        i=(i+(1));
                        // JavaLine 55 ==> SourceLine 20
                        LABEL$(3,"L3");
                        LABEL$(4,"L4");
                        LABEL$(5,"L5");
                        LABEL$(6,"EXIT");
                        sysout().outint(i,0);
                        // JavaLine 61 ==> SourceLine 13
                        if(inner!=null) {
                            inner.STM$();
                            TRACE_BEGIN_STM_AFTER_INNER$("A",13);
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
                TRACE_END_STM$("A",13);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public A STM$() { return((A)CODE$.EXEC$()); }
    public A START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc00.sim","Class A",1,1,11,13,13,16,15,19,18,20,22,3,39,13,43,14,45,15,47,16,51,17,53,18,55,20,61,13,86,21);
}
