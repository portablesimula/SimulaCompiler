// JavaLine 1 <== SourceLine 3
package simulaTestPrograms;
// Simula-2.0 Compiled at Tue Jan 18 09:46:00 CET 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class IBMQuine$ extends BASICIO$ {
    // SubBlock: Kind=SimulaProgram, BlockLevel=1, firstLine=3, lastLine=47, hasLocalClasses=false, System=false
    // Declare locals as attributes
    // Normal Constructor
    public IBMQuine$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("IBMQuine$");
        // Declaration Code
    }
    // SimulaProgram Statements
    public RTObject$ STM$() {
        // JavaLine 18 <== SourceLine 20
        sysout().image=TXT$.sub(sysout().image,1,72);
        ;
        // JavaLine 21 <== SourceLine 46
        new IBMQuine$$WRITE(((IBMQuine$)(CUR$)),copy(new TXT$("  \\nBEGIN   COMMENT THIS IS A SELF-REPRODUCIBLE PROGRAM , HURAAH !         ; \\n   \\n      PROCEDURE OUTQUOTE; OUTCHAR(CHAR(127));  \\n  \\n      PROCEDURE OUTEXT(T); TEXT T;  \\n      BEGIN INTEGER J; J:=1;  \\n            WHILE J+71 <= T.LENGTH DO  \\n            BEGIN OUTTEXT(T.SUB(J,72)); J:=J+72; END;  \\n            OUTTEXT(T.SUB(J,T.LENGTH-J+1));  \\n      END;  \\n  \\n      PROCEDURE WRITE(HEAD,TAIL); VALUE HEAD,TAIL; TEXT HEAD,TAIL;  \\n      BEGIN OUTEXT(HEAD); OUTQUOTE; OUTEXT(HEAD);  \\n            OUTQUOTE; OUTIMAGE; SETPOS(13);  \\n            OUTCHAR(','); SETPOS(72); OUTQUOTE;  \\n            OUTEXT(TAIL); OUTQUOTE; OUTEXT(TAIL);  \\n      END;  \\n  \\n  \\n      IMAGE:-IMAGE.SUB(1,72);  \\n      WRITE(                                                           ")),copy(new TXT$("  \\n                                                                      );  \\nEND                                                                    ")));
        ;
        EBLK();
        return(this);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new IBMQuine$(CTX$).STM$();
    } // End of main
    public static PROGINFO$ INFO$=new PROGINFO$("IBMQuine.sim","SimulaProgram IBMQuine$",1,3,18,20,21,46,32,47);
} // End of SubBlock
