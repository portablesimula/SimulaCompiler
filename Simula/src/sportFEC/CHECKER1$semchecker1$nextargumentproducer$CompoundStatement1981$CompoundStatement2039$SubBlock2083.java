// JavaLine 1 ==> SourceLine 2083
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$nextargumentproducer$CompoundStatement1981$CompoundStatement2039$SubBlock2083 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=4, firstLine=2083, lastLine=2094, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    CHECKER1$semchecker1$argument curarg=null;
    CHECKER1$semchecker1$argument arglist=null;
    // Normal Constructor
    public CHECKER1$semchecker1$nextargumentproducer$CompoundStatement1981$CompoundStatement2039$SubBlock2083(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock2083",2083);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock2083",2083);
        // JavaLine 22 ==> SourceLine 2084
        arglist=((CHECKER1$semchecker1$nextargumentproducer)(CUR$.SL$)).lastarg;
        // JavaLine 24 ==> SourceLine 2085
        while((((CHECKER1$semchecker1$nextargumentproducer)(CUR$.SL$)).lastarg!=(((CHECKER1$semchecker1$nextargumentproducer)(CUR$.SL$)).firstarg))) {
            // JavaLine 26 ==> SourceLine 2086
            {
                TRACE_BEGIN_STM$("CompoundStatement2086",2086);
                curarg=((CHECKER1$semchecker1$nextargumentproducer)(CUR$.SL$)).firstarg;
                // JavaLine 30 ==> SourceLine 2087
                while((curarg.nextarg!=(((CHECKER1$semchecker1$nextargumentproducer)(CUR$.SL$)).lastarg))) {
                    // JavaLine 32 ==> SourceLine 2088
                    curarg=curarg.nextarg;
                }
                // JavaLine 35 ==> SourceLine 2089
                ((CHECKER1$semchecker1$nextargumentproducer)(CUR$.SL$)).lastarg.nextarg=(((curarg!=(((CHECKER1$semchecker1$nextargumentproducer)(CUR$.SL$)).firstarg)))?(curarg):(null));
                // JavaLine 37 ==> SourceLine 2091
                ((CHECKER1$semchecker1$nextargumentproducer)(CUR$.SL$)).lastarg=curarg;
                TRACE_END_STM$("CompoundStatement2086",2091);
            }
        }
        // JavaLine 42 ==> SourceLine 2093
        ((CHECKER1$semchecker1$nextargumentproducer)(CUR$.SL$)).firstarg.nextarg=arglist;
        TRACE_END_STM$("SubBlock2083",2093);
        EBLK();
        return(null);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","SubBlock SubBlock2083",1,2083,22,2084,24,2085,26,2086,30,2087,32,2088,35,2089,37,2091,42,2093,47,2094);
}
