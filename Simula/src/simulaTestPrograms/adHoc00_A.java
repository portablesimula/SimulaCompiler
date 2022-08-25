// JavaLine 1 <== SourceLine 3
package simulaTestPrograms;
// Simula-2.0 Compiled at Sun Aug 21 11:59:30 CEST 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class adHoc00_A extends _Process {
    // ClassDeclaration: Kind=Class, BlockLevel=2, PrefixLevel=3, firstLine=3, lastLine=9, hasLocalClasses=false, System=false, detachUsed=false
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public int p3_i;
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 4
    public boolean b_3=false;
    // Normal Constructor
    public adHoc00_A(_RTObject staticLink,int sp3_i) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3_i = sp3_i;
        // Declaration Code
    }
    // Class Statements
    public adHoc00_A _STM() {
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // Class Process: Code before inner
        // JavaLine 26 <== SourceLine 1
        detach();
        // Class A: Code before inner
        // JavaLine 29 <== SourceLine 5
        sysout().outtext(new _TXT(" sub"));
        ;
        // JavaLine 32 <== SourceLine 8
        // Class A: Code after inner
        // JavaLine 34 <== SourceLine 6
        ;
        // JavaLine 36 <== SourceLine 7
        if(_VALUE((p3_i>(4)))) {
            ;
        } else
        sysout().outtext(new _TXT("if-1"));
        ;
        // JavaLine 42 <== SourceLine 8
        while((p3_i<(100))) {
            p3_i=Math.addExact(p3_i,1);
        }
        ;
        // Class Process: Code after inner
        // JavaLine 48 <== SourceLine 1
        terminate();
        // JavaLine 50 <== SourceLine 8
        EBLK();
        return(this);
    } // End of Class Statements
    public static _PROGINFO INFO_=new _PROGINFO("adHoc00.sim","Class A",1,3,12,4,26,1,29,5,32,8,34,6,36,7,42,8,48,1,50,8,53,9);
} // End of Class
