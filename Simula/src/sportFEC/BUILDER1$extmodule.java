// JavaLine 1 ==> SourceLine 685
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:26 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class BUILDER1$extmodule extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=685, lastLine=692, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 686
    public COMMON$quantity qty=null;
    // JavaLine 13 ==> SourceLine 687
    public BUILDER1$extmodule next=null;
    // JavaLine 15 ==> SourceLine 688
    public int pptag=0;
    // JavaLine 17 ==> SourceLine 689
    public int attrlayout=0;
    // JavaLine 19 ==> SourceLine 690
    public char checkhi=0;
    // JavaLine 21 ==> SourceLine 691
    public char checklo=0;
    // Normal Constructor
    public BUILDER1$extmodule(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("extmodule",691);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("extmodule",691,inner);
                // JavaLine 34 ==> SourceLine 692
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("extmodule",692);
                }
                TRACE_END_STM$("extmodule",692);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public BUILDER1$extmodule STM$() { return((BUILDER1$extmodule)CODE$.EXEC$()); }
    public BUILDER1$extmodule START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Class extmodule",1,685,11,686,13,687,15,688,17,689,19,690,21,691,34,692,46,692);
}
