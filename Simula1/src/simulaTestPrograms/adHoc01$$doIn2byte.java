// JavaLine 1 <== SourceLine 16
package simulaTestPrograms;
// Simula-2.0 Compiled at Tue Sep 28 13:18:15 CEST 2021
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc01$$doIn2byte extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=16, lastLine=20, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 17
    public int b=0;
    // Normal Constructor
    public adHoc01$$doIn2byte(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public adHoc01$$doIn2byte STM$() {
        // JavaLine 22 <== SourceLine 18
        b=((adHoc01$)(CUR$.SL$)).inpt.in2byte();
        ;
        // JavaLine 25 <== SourceLine 19
        sysout().outtext(CONC(new TXT$("In2byte: "),ENVIRONMENT$.edit(b)));
        ;
        sysout().outimage();
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc01.sim","Procedure doIn2byte",1,16,10,17,22,18,25,19,32,20);
} // End of Procedure
