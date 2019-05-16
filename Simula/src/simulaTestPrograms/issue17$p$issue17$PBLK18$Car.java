// JavaLine 1 <== SourceLine 20
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 16 17:22:40 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class issue17$p$issue17$PBLK18$Car extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=4, PrefixLevel=3, firstLine=20, lastLine=30, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public TXT$ p3$pname;
    // Declare locals as attributes
    // Normal Constructor
    public issue17$p$issue17$PBLK18$Car(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3$pname = sp3$pname;
        // Declaration Code
        TRACE_BEGIN_DCL$("Car",20);
    }
    // Class Statements
    public issue17$p$issue17$PBLK18$Car STM$() {
        TRACE_BEGIN_STM$("Car",20);
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class Process: Code before inner
        // JavaLine 27 <== SourceLine 1
        detach();
        // JavaLine 29 <== SourceLine 22
        // Class Car: Code before inner
        new issue17$trace(((issue17)(CUR$.SL$.SL$.SL$)),copy(CONC(p3$pname,new TXT$(" is initiating"))));
        // JavaLine 32 <== SourceLine 23
        while(true) {
            // JavaLine 34 <== SourceLine 25
            {
                TRACE_BEGIN_STM$("CompoundStatement25",25);
                new issue17$trace(((issue17)(CUR$.SL$.SL$.SL$)),copy(CONC(p3$pname,new TXT$(" is active 1"))));
                // JavaLine 38 <== SourceLine 26
                ((issue17$PBLK18)(CUR$.SL$)).hold(((double)(4)));
                // JavaLine 40 <== SourceLine 27
                new issue17$trace(((issue17)(CUR$.SL$.SL$.SL$)),copy(CONC(p3$pname,new TXT$(" is active 2"))));
                // JavaLine 42 <== SourceLine 28
                GOTO$(((issue17$PBLK18)(CUR$.SL$)).EXIT_LABEL); // GOTO EVALUATED LABEL
                TRACE_END_STM$("CompoundStatement25",28);
            }
            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
        }
        // JavaLine 48 <== SourceLine 22
        // Class Car: Code after inner
        // Class Process: Code after inner
        // JavaLine 51 <== SourceLine 1
        terminate();
        // JavaLine 53 <== SourceLine 22
        TRACE_END_STM$("Car",22);
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("issue17.sim","Class Car",1,20,27,1,29,22,32,23,34,25,38,26,40,27,42,28,48,22,51,1,53,22,57,30);
} // End of Class
