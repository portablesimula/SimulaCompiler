// JavaLine 1 ==> SourceLine 119
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Mar 18 11:16:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst106$simtst106$PBLK76$townpoint$write extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=119, lastLine=128, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public simtst106$simtst106$PBLK76$townpoint$write(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("write",119);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst106$simtst106$PBLK76$townpoint$write STM$() {
        TRACE_BEGIN_STM$("write",119);
        // JavaLine 23 ==> SourceLine 120
        if(VALUE$(IS$(((simtst106$simtst106$PBLK76$townpoint)(CUR$.SL$)).suc(),simtst106$simtst106$PBLK76$townpoint.class))) {
            // JavaLine 25 ==> SourceLine 121
            {
                TRACE_BEGIN_STM$("CompoundStatement121",121);
                if(VALUE$((sysout().pos()>((100-(TXT$.length(((simtst106$simtst106$PBLK76$townpoint)(CUR$.SL$)).p2$t.p2$nam_))))))) {
                    new simtst106$simtst106$PBLK76$Outimage(((simtst106$PBLK76)(CUR$.SL$.SL$)));
                }
                // JavaLine 31 ==> SourceLine 122
                sysout().outtext(((simtst106$simtst106$PBLK76$townpoint)(CUR$.SL$)).p2$t.p2$nam_);
                sysout().outtext(new TXT$(", "));
                // JavaLine 34 ==> SourceLine 123
                new simtst106$simtst106$PBLK76$townpoint$write(((simtst106$simtst106$PBLK76$townpoint)(((simtst106$simtst106$PBLK76$townpoint)(CUR$.SL$)).suc())));
                TRACE_END_STM$("CompoundStatement121",123);
            }
        } else
        // JavaLine 39 ==> SourceLine 125
        {
            TRACE_BEGIN_STM$("CompoundStatement125",125);
            sysout().setpos((sysout().pos()-(2)));
            // JavaLine 43 ==> SourceLine 126
            sysout().outchar('.');
            // JavaLine 45 ==> SourceLine 127
            new simtst106$simtst106$PBLK76$Outimage(((simtst106$PBLK76)(CUR$.SL$.SL$)));
            TRACE_END_STM$("CompoundStatement125",127);
        }
        TRACE_END_STM$("write",127);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst106.sim","Procedure write",1,119,23,120,25,121,31,122,34,123,39,125,43,126,45,127,52,128);
}
