package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Jan 26 17:56:49 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class ClassGlyph$Glyph extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=7, lastLine=10, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    public PRCQNT$ print$0() { throw new RuntimeException("No Virtual Match"); }
    // Normal Constructor
    public ClassGlyph$Glyph(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("Glyph",7);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("Glyph",7,inner);
                // JavaLine 22 ==> SourceLine 10
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Glyph",10);
                }
                TRACE_END_STM$("Glyph",10);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public ClassGlyph$Glyph STM$() { return((ClassGlyph$Glyph)CODE$.EXEC$()); }
    public ClassGlyph$Glyph START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("ClassGlyph.sim","Class Glyph",22,10,34,10);
}
