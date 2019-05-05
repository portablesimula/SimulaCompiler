// JavaLine 1 <== SourceLine 17
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:22:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HexDump$InputFile extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=17, lastLine=25, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 18
    TXT$ F=null;
    // Normal Constructor
    public HexDump$InputFile(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("InputFile",18);
        STM$();
    }
    // Procedure Statements
    public HexDump$InputFile STM$() {
        TRACE_BEGIN_STM$("InputFile",18);
        // JavaLine 25 <== SourceLine 19
        ((HexDump)(CUR$.SL$)).Inpt=new InbyteFile$(((BASICIO$)CTX$),new TXT$("File")).STM$();
        // JavaLine 27 <== SourceLine 20
        if(VALUE$((!(((HexDump)(CUR$.SL$)).Inpt.open())))) {
            // JavaLine 29 <== SourceLine 21
            {
                TRACE_BEGIN_STM$("CompoundStatement21",21);
                sysout().outimage();
                sysout().outtext(new TXT$("The File \""));
                sysout().outtext(F);
                // JavaLine 35 <== SourceLine 22
                sysout().outtext(new TXT$("\" does not exist or is not accessible"));
                // JavaLine 37 <== SourceLine 23
                sysout().outimage();
                sysout().outimage();
                terminate_program();
                TRACE_END_STM$("CompoundStatement21",23);
            }
        }
        TRACE_END_STM$("InputFile",23);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HexDump.sim","Procedure InputFile",1,17,11,18,25,19,27,20,29,21,35,22,37,23,47,25);
} // End of Procedure
