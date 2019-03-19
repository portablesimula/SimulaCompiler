// JavaLine 1 ==> SourceLine 21
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 18:03:32 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst102$p$simtst102$PBLK19$Car extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=4, PrefixLevel=3, firstLine=21, lastLine=31, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public TXT$ p3$pname;
    // Declare locals as attributes
    // Normal Constructor
    public simtst102$p$simtst102$PBLK19$Car(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3$pname = sp3$pname;
        // Declaration Code
        TRACE_BEGIN_DCL$("Car",21);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("Car",21,inner);
                // JavaLine 24 ==> SourceLine 23
                new simtst102$trace(((simtst102)(CUR$.SL$.SL$.SL$)),copy(CONC(p3$pname,new TXT$(" is initiating"))));
                // JavaLine 26 ==> SourceLine 24
                while(true) {
                    // JavaLine 28 ==> SourceLine 26
                    {
                        TRACE_BEGIN_STM$("CompoundStatement26",26);
                        new simtst102$trace(((simtst102)(CUR$.SL$.SL$.SL$)),copy(CONC(p3$pname,new TXT$(" is active 1"))));
                        // JavaLine 32 ==> SourceLine 27
                        ((simtst102$PBLK19)(CUR$.SL$)).hold(((double)(4)));
                        // JavaLine 34 ==> SourceLine 28
                        new simtst102$trace(((simtst102)(CUR$.SL$.SL$.SL$)),copy(CONC(p3$pname,new TXT$(" is active 2"))));
                        // JavaLine 36 ==> SourceLine 29
                        GOTO$(((simtst102)(CUR$.SL$.SL$.SL$)).EXIT_LABEL); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement26",29);
                    }
                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                }
                // JavaLine 42 ==> SourceLine 23
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Car",23);
                }
                TRACE_END_STM$("Car",23);
            }
        };
    } // End of Constructor
    // Class Statements
    public simtst102$p$simtst102$PBLK19$Car STM$() { return((simtst102$p$simtst102$PBLK19$Car)CODE$.EXEC$()); }
    public simtst102$p$simtst102$PBLK19$Car START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst102.sim","Class Car",1,21,24,23,26,24,28,26,32,27,34,28,36,29,42,23,53,31);
}
