// JavaLine 1 ==> SourceLine 2563
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$switchelement extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=0, firstLine=2563, lastLine=2583, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public CHECKER1$semchecker1$exp p$labelexp;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 2565
    public char blocklevel=0;
    // JavaLine 14 ==> SourceLine 2571
    public CHECKER1$semchecker1$switchelement next=null;
    // Normal Constructor
    public CHECKER1$semchecker1$switchelement(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$labelexp) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$labelexp = sp$labelexp;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("switchelement",2574);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("switchelement",2574,inner);
                // JavaLine 28 ==> SourceLine 2576
                if(VALUE$((p$labelexp.type!=(((CHECKER1)(CUR$.SL$.SL$)).ILABE)))) {
                    {
                        TRACE_BEGIN_STM$("CompoundStatement2576",2576);
                        if(VALUE$((p$labelexp.type!=(((CHECKER1)(CUR$.SL$.SL$)).IELSE)))) {
                            // JavaLine 33 ==> SourceLine 2577
                            new ERRMSG$error0(((CHECKER1)(CUR$.SL$.SL$)),164);
                        }
                        TRACE_END_STM$("CompoundStatement2576",2577);
                    }
                }
                // JavaLine 39 ==> SourceLine 2578
                if(VALUE$((p$labelexp.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN)))) {
                    // JavaLine 41 ==> SourceLine 2579
                    {
                        TRACE_BEGIN_STM$("CompoundStatement2579",2579);
                        new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p$labelexp)));
                        // JavaLine 45 ==> SourceLine 2580
                        if(VALUE$((p$labelexp.meaning.categ==(((CHECKER1)(CUR$.SL$.SL$)).C_local)))) {
                            // JavaLine 47 ==> SourceLine 2581
                            blocklevel=p$labelexp.meaning.encl.blev;
                        }
                        TRACE_END_STM$("CompoundStatement2579",2581);
                    }
                }
                // JavaLine 53 ==> SourceLine 2576
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("switchelement",2576);
                }
                TRACE_END_STM$("switchelement",2576);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$switchelement STM$() { return((CHECKER1$semchecker1$switchelement)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$switchelement START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class switchelement",1,2563,12,2565,14,2571,28,2576,33,2577,39,2578,41,2579,45,2580,47,2581,53,2576,65,2583);
}
