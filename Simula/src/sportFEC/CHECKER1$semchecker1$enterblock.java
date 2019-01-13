// JavaLine 1 ==> SourceLine 2618
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$enterblock extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=2618, lastLine=2634, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 2621
    COMMON$brctab2 inspect$2621$102=null;
    // JavaLine 13 ==> SourceLine 2622
    COMMON$brecord inspect$2622$103=null;
    // Normal Constructor
    public CHECKER1$semchecker1$enterblock(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("enterblock",2622);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$enterblock STM$() {
        TRACE_BEGIN_STM$("enterblock",2622);
        // JavaLine 27 ==> SourceLine 2619
        ((CHECKER1)(CUR$.SL$.SL$)).cblev=char$((rank(((CHECKER1)(CUR$.SL$.SL$)).cblev)+(1)));
        ((CHECKER1)(CUR$.SL$.SL$)).crtblev=char$((rank(((CHECKER1)(CUR$.SL$.SL$)).crtblev)+(1)));
        // JavaLine 30 ==> SourceLine 2620
        if((rank(((CHECKER1)(CUR$.SL$.SL$)).cblev)>(((CHECKER1)(CUR$.SL$.SL$)).maxblev))) {
            new ERRMSG$fatal0(((CHECKER1)(CUR$.SL$.SL$)),299);
        }
        // JavaLine 34 ==> SourceLine 2621
        {
            // BEGIN INSPECTION 
            inspect$2621$102=((CHECKER1)(CUR$.SL$.SL$)).brctab.Elt[rank(((CHECKER1$semchecker1)(CUR$.SL$)).lastblhi)-((CHECKER1)(CUR$.SL$.SL$)).brctab.LB[0]];
            if(inspect$2621$102!=null) //INSPECT inspect$2621$102
            // JavaLine 39 ==> SourceLine 2622
            {
                TRACE_BEGIN_STM$("CompoundStatement2622",2622);
                {
                    // BEGIN INSPECTION 
                    inspect$2622$103=inspect$2621$102.val.Elt[rank(((CHECKER1$semchecker1)(CUR$.SL$)).lastbllo)-inspect$2621$102.val.LB[0]];
                    if(inspect$2622$103!=null) //INSPECT inspect$2622$103
                    // JavaLine 46 ==> SourceLine 2623
                    {
                        TRACE_BEGIN_STM$("CompoundStatement2623",2623);
                        if((inspect$2622$103.kind==(((CHECKER1)(CUR$.SL$.SL$)).K_class))) {
                            // JavaLine 50 ==> SourceLine 2624
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2624",2624);
                                if((inspect$2622$103.declquant.plev>(((CHECKER1)(CUR$.SL$.SL$)).one))) {
                                    // JavaLine 54 ==> SourceLine 2625
                                    new BUILDER1$precheck0$hide(((CHECKER1$semchecker1)(CUR$.SL$)),inspect$2622$103.declquant.prefqual,false);
                                }
                                // JavaLine 57 ==> SourceLine 2626
                                new BUILDER1$precheck0$unprotect(((CHECKER1$semchecker1)(CUR$.SL$)),inspect$2622$103.declquant);
                                TRACE_END_STM$("CompoundStatement2624",2626);
                            }
                        } else
                        // JavaLine 62 ==> SourceLine 2628
                        if((inspect$2622$103.kind==(((CHECKER1)(CUR$.SL$.SL$)).K_prefbl))) {
                            new BUILDER1$precheck0$hide(((CHECKER1$semchecker1)(CUR$.SL$)),inspect$2622$103.declquant.prefqual,false);
                        }
                        // JavaLine 66 ==> SourceLine 2629
                        new BUILDER1$precheck0$makevisblock(((CHECKER1$semchecker1)(CUR$.SL$)),((COMMON$brecord)inspect$2622$103));
                        TRACE_END_STM$("CompoundStatement2623",2629);
                    }
                }
                // JavaLine 71 ==> SourceLine 2631
                inspect$2621$102.val.Elt[rank(((CHECKER1$semchecker1)(CUR$.SL$)).lastbllo)-inspect$2621$102.val.LB[0]]=null;
                TRACE_END_STM$("CompoundStatement2622",2631);
            }
        }
        TRACE_END_STM$("enterblock",2631);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure enterblock",1,2618,11,2621,13,2622,27,2619,30,2620,34,2621,39,2622,46,2623,50,2624,54,2625,57,2626,62,2628,66,2629,71,2631,79,2634);
}
