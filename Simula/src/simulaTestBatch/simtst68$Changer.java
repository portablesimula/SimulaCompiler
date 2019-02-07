// JavaLine 1 ==> SourceLine 95
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Wed Feb 06 20:31:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst68$Changer extends simtst68$Coroutine {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=95, lastLine=114, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simtst68$Changer(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("Changer",95);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("Changer",95,inner);
                // JavaLine 22 ==> SourceLine 97
                call(((simtst68)(CUR$.SL$)).r);
                // JavaLine 24 ==> SourceLine 98
                while(true) {
                    // JavaLine 26 ==> SourceLine 100
                    {
                        TRACE_BEGIN_STM$("CompoundStatement100",100);
                        if(VALUE$((((simtst68)(CUR$.SL$)).c1==('*')))) {
                            // JavaLine 30 ==> SourceLine 102
                            {
                                TRACE_BEGIN_STM$("CompoundStatement102",102);
                                call(((simtst68)(CUR$.SL$)).r);
                                // JavaLine 34 ==> SourceLine 103
                                if(VALUE$((((simtst68)(CUR$.SL$)).c1==('*')))) {
                                    // JavaLine 36 ==> SourceLine 104
                                    ((simtst68)(CUR$.SL$)).c2='$';
                                } else
                                // JavaLine 39 ==> SourceLine 107
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement107",107);
                                    ((simtst68)(CUR$.SL$)).c2='*';
                                    // JavaLine 43 ==> SourceLine 108
                                    resume(((simtst68)(CUR$.SL$)).w);
                                    // JavaLine 45 ==> SourceLine 109
                                    ((simtst68)(CUR$.SL$)).c2=((simtst68)(CUR$.SL$)).c1;
                                    TRACE_END_STM$("CompoundStatement107",109);
                                }
                                TRACE_END_STM$("CompoundStatement102",109);
                            }
                        } else
                        // JavaLine 52 ==> SourceLine 111
                        ((simtst68)(CUR$.SL$)).c2=((simtst68)(CUR$.SL$)).c1;
                        // JavaLine 54 ==> SourceLine 112
                        resume(((simtst68)(CUR$.SL$)).w);
                        call(((simtst68)(CUR$.SL$)).r);
                        TRACE_END_STM$("CompoundStatement100",112);
                    }
                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                }
                // JavaLine 61 ==> SourceLine 97
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Changer",97);
                }
                TRACE_END_STM$("Changer",97);
            }
        };
    } // End of Constructor
    // Class Statements
    public simtst68$Changer STM$() { return((simtst68$Changer)CODE$.EXEC$()); }
    public simtst68$Changer START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst68.sim","Class Changer",1,95,22,97,24,98,26,100,30,102,34,103,36,104,39,107,43,108,45,109,52,111,54,112,61,97,72,114);
}
