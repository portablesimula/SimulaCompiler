// JavaLine 1 <== SourceLine 22
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 11:18:13 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class GotoSample2$p$GotoSample2$PBLK20$Car extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=4, PrefixLevel=3, firstLine=22, lastLine=32, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public TXT$ p3$pname;
    // Declare locals as attributes
    // Normal Constructor
    public GotoSample2$p$GotoSample2$PBLK20$Car(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3$pname = sp3$pname;
        // Declaration Code
        TRACE_BEGIN_DCL$("Car",22);
    }
    // Class Statements
    public GotoSample2$p$GotoSample2$PBLK20$Car STM$() {
        TRACE_BEGIN_STM$("Car",22);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class Process: Code before inner
        // JavaLine 27 <== SourceLine 1
        detach();
        // JavaLine 29 <== SourceLine 24
        // Class Car: Code before inner
        new GotoSample2$trace(((GotoSample2)(CUR$.SL$.SL$.SL$)),copy(CONC(p3$pname,new TXT$(" is initiating"))));
        // JavaLine 32 <== SourceLine 25
        while(true) {
            // JavaLine 34 <== SourceLine 27
            {
                TRACE_BEGIN_STM$("CompoundStatement27",27);
                new GotoSample2$trace(((GotoSample2)(CUR$.SL$.SL$.SL$)),copy(CONC(p3$pname,new TXT$(" is active 1"))));
                // JavaLine 38 <== SourceLine 28
                ((GotoSample2$PBLK20)(CUR$.SL$)).hold(((double)(4)));
                // JavaLine 40 <== SourceLine 29
                new GotoSample2$trace(((GotoSample2)(CUR$.SL$.SL$.SL$)),copy(CONC(p3$pname,new TXT$(" is active 2"))));
                // JavaLine 42 <== SourceLine 30
                GOTO$(((GotoSample2$PBLK20)(CUR$.SL$)).EXIT_LABEL); // GOTO EVALUATED LABEL
                TRACE_END_STM$("CompoundStatement27",30);
            }
            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
        }
        // JavaLine 48 <== SourceLine 24
        // Class Car: Code after inner
        // Class Process: Code after inner
        // JavaLine 51 <== SourceLine 1
        terminate();
        // JavaLine 53 <== SourceLine 24
        TRACE_END_STM$("Car",24);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("GotoSample2.sim","Class Car",1,22,27,1,29,24,32,25,34,27,38,28,40,29,42,30,48,24,51,1,53,24,57,32);
} // End of Class
