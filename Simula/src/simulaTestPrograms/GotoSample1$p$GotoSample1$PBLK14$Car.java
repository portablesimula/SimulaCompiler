// JavaLine 1 ==> SourceLine 16
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Mar 17 17:53:27 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class GotoSample1$p$GotoSample1$PBLK14$Car extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=4, PrefixLevel=3, firstLine=16, lastLine=26, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public TXT$ p3$pname;
    // Declare locals as attributes
    // Normal Constructor
    public GotoSample1$p$GotoSample1$PBLK14$Car(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3$pname = sp3$pname;
        // Declaration Code
        TRACE_BEGIN_DCL$("Car",16);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("Car",16,inner);
                // JavaLine 24 ==> SourceLine 18
                new GotoSample1$trace(((GotoSample1)(CUR$.SL$.SL$.SL$)),copy(CONC(p3$pname,new TXT$(" is initiating"))));
                // JavaLine 26 ==> SourceLine 19
                while(true) {
                    // JavaLine 28 ==> SourceLine 21
                    {
                        TRACE_BEGIN_STM$("CompoundStatement21",21);
                        new GotoSample1$trace(((GotoSample1)(CUR$.SL$.SL$.SL$)),copy(CONC(p3$pname,new TXT$(" is active 1"))));
                        // JavaLine 32 ==> SourceLine 22
                        ((GotoSample1$PBLK14)(CUR$.SL$)).hold(((double)(4)));
                        // JavaLine 34 ==> SourceLine 23
                        new GotoSample1$trace(((GotoSample1)(CUR$.SL$.SL$.SL$)),copy(CONC(p3$pname,new TXT$(" is active 2"))));
                        // JavaLine 36 ==> SourceLine 24
                        GOTO$(((GotoSample1)(CUR$.SL$.SL$.SL$)).EXIT_LABEL); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement21",24);
                    }
                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                }
                // JavaLine 42 ==> SourceLine 18
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Car",18);
                }
                TRACE_END_STM$("Car",18);
            }
        };
    } // End of Constructor
    // Class Statements
    public GotoSample1$p$GotoSample1$PBLK14$Car STM$() { return((GotoSample1$p$GotoSample1$PBLK14$Car)CODE$.EXEC$()); }
    public GotoSample1$p$GotoSample1$PBLK14$Car START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("GotoSample1.sim","Class Car",1,16,24,18,26,19,28,21,32,22,34,23,36,24,42,18,53,26);
}
