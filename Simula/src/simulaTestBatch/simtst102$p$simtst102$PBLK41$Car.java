// JavaLine 1 ==> SourceLine 43
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 18:17:08 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst102$p$simtst102$PBLK41$Car extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=4, PrefixLevel=3, firstLine=43, lastLine=53, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public TXT$ p3$pname;
    // Declare locals as attributes
    // Normal Constructor
    public simtst102$p$simtst102$PBLK41$Car(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3$pname = sp3$pname;
        // Declaration Code
        TRACE_BEGIN_DCL$("Car",43);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("Car",43,inner);
                // JavaLine 24 ==> SourceLine 45
                new simtst102$trace(((simtst102)(CUR$.SL$.SL$.SL$)),45,CONC(p3$pname,new TXT$(" is initiating")));
                // JavaLine 26 ==> SourceLine 46
                while(true) {
                    // JavaLine 28 ==> SourceLine 48
                    {
                        TRACE_BEGIN_STM$("CompoundStatement48",48);
                        new simtst102$trace(((simtst102)(CUR$.SL$.SL$.SL$)),48,CONC(p3$pname,new TXT$(" is active 1")));
                        // JavaLine 32 ==> SourceLine 49
                        ((simtst102$PBLK41)(CUR$.SL$)).hold(((double)(4)));
                        // JavaLine 34 ==> SourceLine 50
                        new simtst102$trace(((simtst102)(CUR$.SL$.SL$.SL$)),50,CONC(p3$pname,new TXT$(" is active 2")));
                        // JavaLine 36 ==> SourceLine 51
                        GOTO$(((simtst102)(CUR$.SL$.SL$.SL$)).EXIT_LABEL); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement48",51);
                    }
                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                }
                // JavaLine 42 ==> SourceLine 45
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Car",45);
                }
                TRACE_END_STM$("Car",45);
            }
        };
    } // End of Constructor
    // Class Statements
    public simtst102$p$simtst102$PBLK41$Car STM$() { return((simtst102$p$simtst102$PBLK41$Car)CODE$.EXEC$()); }
    public simtst102$p$simtst102$PBLK41$Car START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst102.sim","Class Car",1,43,24,45,26,46,28,48,32,49,34,50,36,51,42,45,53,53);
}
