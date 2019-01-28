// JavaLine 1 ==> SourceLine 15
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Jan 26 17:56:49 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ClassGlyph$Char$$print extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=15, lastLine=18, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public ClassGlyph$Char$$print(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("print",15);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ClassGlyph$Char$$print STM$() {
        TRACE_BEGIN_STM$("print",15);
        // JavaLine 23 ==> SourceLine 16
        sysout().outtext(new TXT$("***************  Char.print  "));
        sysout().outimage();
        // JavaLine 26 ==> SourceLine 17
        sysout().outchar(((ClassGlyph$Char$)(CUR$.SL$)).p1$c);
        sysout().outimage();
        TRACE_END_STM$("print",17);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("ClassGlyph.sim","Procedure print",1,15,23,16,26,17,32,18);
}
