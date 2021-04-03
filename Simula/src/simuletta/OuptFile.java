// JavaLine 1 <== SourceLine 3
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:45 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class OuptFile extends OutbyteFile$ {
    // ClassDeclaration: Kind=Class, BlockLevel=1, PrefixLevel=3, firstLine=3, lastLine=142, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    public Common p3$comn;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 29
    public TXT$ TRCBUFF$3=null;
    // JavaLine 13 <== SourceLine 30
    public int output_trace$3=0;
    // JavaLine 15 <== SourceLine 31
    public boolean lowercase$3=false;
    // JavaLine 17 <== SourceLine 139
    public Common inspect$139$32$3=null;
    // Normal Constructor
    public OuptFile(RTObject$ staticLink,TXT$ sFILENAME$,Common sp3$comn) {
        super(staticLink,sFILENAME$);
        // Parameter assignment to locals
        this.p3$comn = sp3$comn;
        // Declaration Code
    }
    // Class Statements
    public OuptFile STM$() {
        // Class FILE: Code before inner
        // Class ByteFile: Code before inner
        // Class OutbyteFile: Code before inner
        // JavaLine 31 <== SourceLine 139
        // Class OuptFile: Code before inner
        if(VALUE$((!(open())))) {
            {
                // BEGIN INSPECTION 
                inspect$139$32$3=p3$comn;
                if(inspect$139$32$3!=null) // INSPECT inspect$139$32
                new Common$openerror(inspect$139$32$3,filename());
            }
        }
        ;
        // JavaLine 42 <== SourceLine 140
        TRCBUFF$3=blanks(80);
        ;
        // JavaLine 45 <== SourceLine 139
        // Class OuptFile: Code after inner
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("OUPTFILE.sim","Class OuptFile",1,3,11,29,13,30,15,31,17,139,31,139,42,140,45,139,49,142);
} // End of Class
