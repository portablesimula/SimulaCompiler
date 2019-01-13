// JavaLine 1 ==> SourceLine 1150
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$ifexp$CompoundStatement1147$CompoundStatement1148$SubBlock1150 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=4, firstLine=1150, lastLine=1158, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    COMMON$quantity qx=null;
    COMMON$quantity qy=null;
    // Normal Constructor
    public CHECKER1$semchecker1$ifexp$CompoundStatement1147$CompoundStatement1148$SubBlock1150(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock1150",1150);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock1150",1150);
        // JavaLine 22 ==> SourceLine 1151
        qx=((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).qual;
        qy=((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).p1$right.qual;
        // JavaLine 25 ==> SourceLine 1152
        while((qx.plev>(qy.plev))) {
            qx=qx.prefqual;
        }
        // JavaLine 29 ==> SourceLine 1153
        while((qy.plev>(qx.plev))) {
            qy=qy.prefqual;
        }
        // JavaLine 33 ==> SourceLine 1154
        while(((qx!=(qy))&&((qx.plev>(((CHECKER1)(CUR$.SL$.SL$.SL$)).one))))) {
            // JavaLine 35 ==> SourceLine 1155
            {
                TRACE_BEGIN_STM$("CompoundStatement1155",1155);
                qx=qx.prefqual;
                qy=qy.prefqual;
                TRACE_END_STM$("CompoundStatement1155",1155);
            }
        }
        // JavaLine 43 ==> SourceLine 1156
        if((qx==(qy))) {
            ((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).qual=qx;
        } else
        // JavaLine 47 ==> SourceLine 1158
        new ERRMSG$error2quants(((CHECKER1)(CUR$.SL$.SL$.SL$)),404,((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).p1$left.qual,((CHECKER1$semchecker1$ifexp)(CUR$.SL$)).p1$right.qual);
        TRACE_END_STM$("SubBlock1150",1158);
        EBLK();
        return(null);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","SubBlock SubBlock1150",1,1150,22,1151,25,1152,29,1153,33,1154,35,1155,43,1156,47,1158,52,1158);
}
