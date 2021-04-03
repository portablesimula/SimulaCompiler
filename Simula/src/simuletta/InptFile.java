// JavaLine 1 <== SourceLine 3
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:46 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class InptFile extends InbyteFile$ {
    // ClassDeclaration: Kind=Class, BlockLevel=1, PrefixLevel=3, firstLine=3, lastLine=101, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    public Common p3$comn;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 17
    public int Bias$3=0;
    // JavaLine 13 <== SourceLine 18
    public TXT$ TRCBUFF$3=null;
    public int input_trace$3=0;
    // JavaLine 16 <== SourceLine 95
    public Common inspect$95$41$3=null;
    // Normal Constructor
    public InptFile(RTObject$ staticLink,TXT$ sFILENAME$,Common sp3$comn) {
        super(staticLink,sFILENAME$);
        // Parameter assignment to locals
        this.p3$comn = sp3$comn;
        // Declaration Code
    }
    // Class Statements
    public InptFile STM$() {
        // Class FILE: Code before inner
        // Class ByteFile: Code before inner
        // Class InbyteFile: Code before inner
        // JavaLine 30 <== SourceLine 95
        // Class InptFile: Code before inner
        {
            // BEGIN INSPECTION 
            inspect$95$41$3=p3$comn;
            if(inspect$95$41$3!=null) // INSPECT inspect$95$41
            // JavaLine 36 <== SourceLine 96
            {
                if(VALUE$((!(open())))) {
                    new Common$openerror(inspect$95$41$3,filename());
                }
                ;
                // JavaLine 42 <== SourceLine 97
                TRCBUFF$3=blanks(80);
                ;
                // JavaLine 45 <== SourceLine 99
                Bias$3=inspect$95$41$3.ntag$1;
                ;
            }
        }
        ;
        // JavaLine 51 <== SourceLine 95
        // Class InptFile: Code after inner
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("INPTFILE.sim","Class InptFile",1,3,11,17,13,18,16,95,30,95,36,96,42,97,45,99,51,95,55,101);
} // End of Class
