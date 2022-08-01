// JavaLine 1 <== SourceLine 555
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$macro_param$dump extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=555, lastLine=557, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public Common$macro_param$dump(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$macro_param$dump STM$() {
        // JavaLine 20 <== SourceLine 556
        sysout().outtext(new TXT$(" MacroParam#"));
        ;
        sysout().outint(((Common$macro_param)(CUR$.SL$)).p2$n,0);
        ;
        // JavaLine 25 <== SourceLine 557
        sysout().outchar(((char)32));
        ;
        sysout().outimage();
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure dump",1,555,20,556,25,557,32,557);
} // End of Procedure
