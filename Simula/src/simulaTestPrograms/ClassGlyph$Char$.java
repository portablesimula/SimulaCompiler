// JavaLine 1 ==> SourceLine 12
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 05 13:15:10 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class ClassGlyph$Char$ extends ClassGlyph$Glyph {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=12, lastLine=21, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    public char p1$c;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 19
    public int i=0;
    public PRCQNT$ print$0() { return(new PRCQNT$(this,ClassGlyph$Char$$print.class)); }
    // Normal Constructor
    public ClassGlyph$Char$(RTObject$ staticLink,char sp1$c) {
        super(staticLink);
        // Parameter assignment to locals
        this.p1$c = sp1$c;
        // Declaration Code
        TRACE_BEGIN_DCL$("Char$",19);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("Char$",19,inner);
                // JavaLine 26 ==> SourceLine 20
                ((ClassGlyph$Char$)CUR$).print$0().CPF();
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Char$",20);
                }
                TRACE_END_STM$("Char$",20);
            }
        };
    } // End of Constructor
    // Class Statements
    public ClassGlyph$Char$ STM$() { return((ClassGlyph$Char$)CODE$.EXEC$()); }
    public ClassGlyph$Char$ START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("ClassGlyph.sim","Class Char$",1,12,12,19,26,20,38,21);
}
