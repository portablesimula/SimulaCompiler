// JavaLine 1 ==> SourceLine 131
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Mar 18 11:16:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst106$simtst106$PBLK76$town extends Link$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=131, lastLine=140, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    public TXT$ p2$nam_;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 132
    public Head$ cars=null;
    // JavaLine 14 ==> SourceLine 137
    public boolean gone=false;
    // Normal Constructor
    public simtst106$simtst106$PBLK76$town(RTObject$ staticLink,TXT$ sp2$nam_) {
        super(staticLink);
        // Parameter assignment to locals
        this.p2$nam_ = sp2$nam_;
        // Declaration Code
        TRACE_BEGIN_DCL$("town",137);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("town",137,inner);
                // JavaLine 27 ==> SourceLine 138
                cars=new Head$(((simtst106$PBLK76)(CUR$.SL$))).STM$();
                // JavaLine 29 ==> SourceLine 139
                into(((simtst106$PBLK76)(CUR$.SL$)).towns);
                // JavaLine 31 ==> SourceLine 138
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("town",138);
                }
                TRACE_END_STM$("town",138);
            }
        };
    } // End of Constructor
    // Class Statements
    public simtst106$simtst106$PBLK76$town STM$() { return((simtst106$simtst106$PBLK76$town)CODE$.EXEC$()); }
    public simtst106$simtst106$PBLK76$town START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst106.sim","Class town",1,131,12,132,14,137,27,138,29,139,31,138,42,140);
}
