// JavaLine 1 <== SourceLine 479
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Common$TypeNotice extends Link$ {
    // ClassDeclaration: Kind=Class, BlockLevel=2, PrefixLevel=2, firstLine=479, lastLine=486, hasLocalClasses=false, System=false, detachUsed=false
    // Declare parameters as attributes
    public Common$TypeSet p2$set;
    public int p2$qual;
    public int p2$info1;
    public int p2$info2;
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 481
    public int code$2=0;
    // Normal Constructor
    public Common$TypeNotice(RTObject$ staticLink,Common$TypeSet sp2$set,int sp2$qual,int sp2$info1,int sp2$info2) {
        super(staticLink);
        // Parameter assignment to locals
        this.p2$set = sp2$set;
        this.p2$qual = sp2$qual;
        this.p2$info1 = sp2$info1;
        this.p2$info2 = sp2$info2;
        // Declaration Code
    }
    // Class Statements
    public Common$TypeNotice STM$() {
        // Class Linkage: Code before inner
        // Class Link: Code before inner
        // JavaLine 30 <== SourceLine 482
        // Class TypeNotice: Code before inner
        if(VALUE$((((Common)(CUR$.SL$)).nTypes$1>=(((Common)(CUR$.SL$)).maxTypes$1)))) {
            new Common$FATAL_ERROR(((Common)(CUR$.SL$)),new TXT$("Too many different types"));
        }
        ;
        // JavaLine 36 <== SourceLine 483
        code$2=((Common)(CUR$.SL$)).nTypes$1=Math.addExact(((Common)(CUR$.SL$)).nTypes$1,1);
        ;
        // JavaLine 39 <== SourceLine 484
        ((Common)(CUR$.SL$)).typeTable.Elt[code$2-((Common)(CUR$.SL$)).typeTable.LB[0]]=((Common$TypeNotice)(CUR$));
        ;
        // JavaLine 42 <== SourceLine 485
        ((Common$TypeNotice)(CUR$)).into(p2$set);
        ;
        // JavaLine 45 <== SourceLine 482
        // Class TypeNotice: Code after inner
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Class TypeNotice",1,479,14,481,30,482,36,483,39,484,42,485,45,482,49,486);
} // End of Class
