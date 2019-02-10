// JavaLine 1 ==> SourceLine 168
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:51 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class BUILDER1$dummygenerator extends BUILDER1$visiblegenerator {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=6, firstLine=168, lastLine=184, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(6); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public BUILDER1$dummygenerator(RTObject$ staticLink,TXT$ sFILENAME$) {
        super(staticLink,sFILENAME$);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("dummygenerator",172);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,6) {
            public void STM$() {
                TRACE_BEGIN_STM$("dummygenerator",172,inner);
                // JavaLine 21 ==> SourceLine 173
                while(true) {
                    // JavaLine 23 ==> SourceLine 175
                    {
                        TRACE_BEGIN_STM$("CompoundStatement175",175);
                        ((BUILDER1)(CUR$.SL$)).detach();
                        // JavaLine 27 ==> SourceLine 177
                        if(VALUE$((SCF!=(null)))) {
                            {
                                TRACE_BEGIN_STM$("CompoundStatement177",177);
                                SCF.close();
                                SCF=null;
                                TRACE_END_STM$("CompoundStatement177",177);
                            }
                        }
                        // JavaLine 36 ==> SourceLine 180
                        opq=null;
                        // JavaLine 38 ==> SourceLine 182
                        ((BUILDER1)(CUR$.SL$)).checker0.opihi=((BUILDER1)(CUR$.SL$)).checker0.opilo=((BUILDER1)(CUR$.SL$)).NUL;
                        TRACE_END_STM$("CompoundStatement175",182);
                    }
                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                }
                // JavaLine 44 ==> SourceLine 173
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("dummygenerator",173);
                }
                TRACE_END_STM$("dummygenerator",173);
            }
        };
    } // End of Constructor
    // Class Statements
    public BUILDER1$dummygenerator STM$() { return((BUILDER1$dummygenerator)CODE$.EXEC$()); }
    public BUILDER1$dummygenerator START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Class dummygenerator",1,168,21,173,23,175,27,177,36,180,38,182,44,173,55,184);
}
