// JavaLine 1 ==> SourceLine 3
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:26 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class BUILDER1 extends PAS1INIT {
    // ClassDeclaration: BlockKind=Class, BlockLevel=1, PrefixLevel=6, firstLine=3, lastLine=695, hasLocalClasses=true, System=false, detachUsed=true
    public int prefixLevel() { return(6); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 46
    public boolean BoundCheck=false;
    public boolean NoneCheck=false;
    public boolean QuaCheck=false;
    public boolean ReuseProc=false;
    // JavaLine 17 ==> SourceLine 47
    public boolean ingotostmt=false;
    // JavaLine 19 ==> SourceLine 48
    public boolean inswitchdecl=false;
    // JavaLine 21 ==> SourceLine 49
    public boolean generalgoto=false;
    // JavaLine 23 ==> SourceLine 50
    public boolean notinconditional=false;
    // JavaLine 25 ==> SourceLine 55
    public char cblev=0;
    // JavaLine 27 ==> SourceLine 56
    public char crtblev=0;
    // JavaLine 29 ==> SourceLine 58
    public char qblev=0;
    // JavaLine 31 ==> SourceLine 60
    public char stepfasthi=0;
    public char stepfastlo=0;
    // JavaLine 34 ==> SourceLine 62
    public int ssnuma=0;
    // JavaLine 36 ==> SourceLine 63
    public int lastusedtag=0;
    // JavaLine 38 ==> SourceLine 64
    public int noofextmodules=0;
    // JavaLine 40 ==> SourceLine 66
    public BUILDER1$extmodule firstextmodule=null;
    // JavaLine 42 ==> SourceLine 67
    public BUILDER1$casedescr curcase=null;
    // JavaLine 44 ==> SourceLine 206
    public BUILDER1$precheck0 checker0=null;
    // JavaLine 46 ==> SourceLine 621
    public int nextexttag=0;
    // Normal Constructor
    public BUILDER1(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("BUILDER1",692);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,6) {
            public void STM$() {
                TRACE_BEGIN_STM$("BUILDER1",692,inner);
                // JavaLine 58 ==> SourceLine 695
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("BUILDER1",695);
                }
                TRACE_END_STM$("BUILDER1",695);
            }
        };
    } // End of Constructor
    // Class Statements
    public BUILDER1 STM$() { return((BUILDER1)CODE$.EXEC$()); }
    public BUILDER1 START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Class BUILDER1",1,3,12,46,17,47,19,48,21,49,23,50,25,55,27,56,29,58,31,60,34,62,36,63,38,64,40,66,42,67,44,206,46,621,58,695,69,695);
}
