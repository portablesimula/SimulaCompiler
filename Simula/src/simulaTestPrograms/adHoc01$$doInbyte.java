// JavaLine 1 <== SourceLine 5
package simulaTestPrograms;
// Simula-2.0 Compiled at Tue Sep 28 13:18:15 CEST 2021
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class adHoc01$$doInbyte extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=5, lastLine=9, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 6
    public int b=0;
    // Normal Constructor
    public adHoc01$$doInbyte(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public adHoc01$$doInbyte STM$() {
        // JavaLine 22 <== SourceLine 7
        b=((adHoc01$)(CUR$.SL$)).inpt.inbyte();
        ;
        // JavaLine 25 <== SourceLine 8
        sysout().outtext(CONC(new TXT$("Inbyte: "),ENVIRONMENT$.edit(b)));
        ;
        sysout().outimage();
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc01.sim","Procedure doInbyte",1,5,10,6,22,7,25,8,32,9);
} // End of Procedure
