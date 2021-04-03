// JavaLine 1 <== SourceLine 114
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:45 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class OuptFile$outcode extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=114, lastLine=119, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 115
    PrintFile$ inspect$115$29=null;
    // Normal Constructor
    public OuptFile$outcode(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public OuptFile$outcode STM$() {
        if(VALUE$((TXT$.pos(((OuptFile)(CUR$.SL$)).TRCBUFF$3)>(1)))) {
            {
                // BEGIN INSPECTION 
                inspect$115$29=sysout();
                if(inspect$115$29!=null) // INSPECT inspect$115$29
                // JavaLine 27 <== SourceLine 116
                {
                    inspect$115$29.outtext(new TXT$("Output:"));
                    ;
                    // JavaLine 31 <== SourceLine 117
                    inspect$115$29.setpos(25);
                    ;
                    inspect$115$29.outtext(TXT$.strip(((OuptFile)(CUR$.SL$)).TRCBUFF$3));
                    ;
                    // JavaLine 36 <== SourceLine 118
                    inspect$115$29.outimage();
                    ;
                    ASGTXT$(((OuptFile)(CUR$.SL$)).TRCBUFF$3,null);
                    ;
                    TXT$.setpos(((OuptFile)(CUR$.SL$)).TRCBUFF$3,1);
                    ;
                }
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("OUPTFILE.sim","Procedure outcode",1,114,10,115,27,116,31,117,36,118,48,119);
} // End of Procedure
