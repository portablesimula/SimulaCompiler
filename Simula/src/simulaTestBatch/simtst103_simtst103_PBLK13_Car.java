// JavaLine 1 <== SourceLine 38
package simulaTestBatch;
// Simula-2.0 Compiled at Mon Aug 22 09:22:47 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst103_simtst103_PBLK13_Car extends _Process {
    // ClassDeclaration: Kind=Class, BlockLevel=3, PrefixLevel=3, firstLine=38, lastLine=45, hasLocalClasses=false, System=false, detachUsed=false
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public _TXT p3_id;
    // Declare locals as attributes
    // Normal Constructor
    public simtst103_simtst103_PBLK13_Car(_RTObject staticLink,_TXT sp3_id) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3_id = sp3_id;
        // Declaration Code
    }
    // Class Statements
    public simtst103_simtst103_PBLK13_Car _STM() {
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class Process: Code before inner
        // JavaLine 24 <== SourceLine 1
        detach();
        // JavaLine 26 <== SourceLine 45
        // Class Car: Code before inner
        // JavaLine 28 <== SourceLine 40
        new simtst103_simtst103_PBLK13_trace((_CUR._SL),CONC(p3_id,new _TXT(": Run Fase-1")));
        ;
        // JavaLine 31 <== SourceLine 41
        ((simtst103_PBLK13)(_CUR._SL)).hold(4.0d);
        ;
        // JavaLine 34 <== SourceLine 42
        new simtst103_simtst103_PBLK13_trace((_CUR._SL),CONC(p3_id,new _TXT(": Run Fase-2")));
        ;
        // JavaLine 37 <== SourceLine 43
        ((simtst103_PBLK13)(_CUR._SL)).hold(12.0d);
        ;
        // JavaLine 40 <== SourceLine 44
        new simtst103_simtst103_PBLK13_trace((_CUR._SL),CONC(p3_id,new _TXT(": Terminates")));
        ;
        // JavaLine 43 <== SourceLine 45
        // Class Car: Code after inner
        // Class Process: Code after inner
        // JavaLine 46 <== SourceLine 1
        terminate();
        // JavaLine 48 <== SourceLine 45
        EBLK();
        return(this);
    } // End of Class Statements
    public static _PROGINFO INFO_=new _PROGINFO("simtst103.sim","Class Car",1,38,24,1,26,45,28,40,31,41,34,42,37,43,40,44,43,45,46,1,48,45,51,45);
} // End of Class
