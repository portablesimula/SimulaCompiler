// JavaLine 1 ==> SourceLine 86
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Feb 10 12:24:00 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst68$Reader extends simtst68$Coroutine {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=86, lastLine=93, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simtst68$Reader(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("Reader",86);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("Reader",86,inner);
                // JavaLine 22 ==> SourceLine 87
                while(true) {
                    // JavaLine 24 ==> SourceLine 89
                    {
                        TRACE_BEGIN_STM$("CompoundStatement89",89);
                        ((simtst68)(CUR$.SL$)).c1=sysin().inchar();
                        // JavaLine 28 ==> SourceLine 90
                        new simtst68$trace(((simtst68)(CUR$.SL$)),new TXT$("In Reader: Just before Detach"));
                        // JavaLine 30 ==> SourceLine 91
                        detach();
                        // JavaLine 32 ==> SourceLine 92
                        new simtst68$trace(((simtst68)(CUR$.SL$)),new TXT$("In Reader: Just after Detach"));
                        TRACE_END_STM$("CompoundStatement89",92);
                    }
                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                }
                // JavaLine 38 ==> SourceLine 93
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Reader",93);
                }
                TRACE_END_STM$("Reader",93);
            }
        };
    } // End of Constructor
    // Class Statements
    public simtst68$Reader STM$() { return((simtst68$Reader)CODE$.EXEC$()); }
    public simtst68$Reader START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst68.sim","Class Reader",1,86,22,87,24,89,28,90,30,91,32,92,38,93,49,93);
}
