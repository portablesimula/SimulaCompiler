// JavaLine 1 ==> SourceLine 23
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 05 13:15:10 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class ClassGlyph$Line extends ClassGlyph$Glyph {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=23, lastLine=40, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    public ARRAY$<?> p1$elements;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 37
    public int i=0;
    public PRCQNT$ print$0() { return(new PRCQNT$(this,ClassGlyph$Line$print.class)); }
    // Normal Constructor
    public ClassGlyph$Line(RTObject$ staticLink,ARRAY$<?> sp1$elements) {
        super(staticLink);
        // Parameter assignment to locals
        this.p1$elements = sp1$elements;
        // Declaration Code
        TRACE_BEGIN_DCL$("Line",37);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("Line",37,inner);
                // JavaLine 26 ==> SourceLine 38
                ((ClassGlyph$Line)CUR$).print$0().CPF();
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Line",38);
                }
                TRACE_END_STM$("Line",38);
            }
        };
    } // End of Constructor
    // Class Statements
    public ClassGlyph$Line STM$() { return((ClassGlyph$Line)CODE$.EXEC$()); }
    public ClassGlyph$Line START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("ClassGlyph.sim","Class Line",1,23,12,37,26,38,38,40);
}
