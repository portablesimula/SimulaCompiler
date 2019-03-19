// JavaLine 1 ==> SourceLine 23
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Mar 17 18:27:05 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst107$PBLK12$p extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=3, firstLine=23, lastLine=29, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public int p3$i;
    // Declare locals as attributes
    // Normal Constructor
    public simtst107$PBLK12$p(RTObject$ staticLink,int sp3$i) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3$i = sp3$i;
        // Declaration Code
        TRACE_BEGIN_DCL$("p",23);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("p",23,inner);
                // JavaLine 24 ==> SourceLine 24
                sysout().outtext(new TXT$("p("));
                sysout().outint(p3$i,2);
                // JavaLine 27 ==> SourceLine 25
                sysout().outtext(new TXT$(") activated at time = "));
                sysout().outfix(((simtst107$PBLK12)(CUR$.SL$)).time(),3,8);
                new simtst107$PBLK12$outimage(((simtst107$PBLK12)(CUR$.SL$)));
                // JavaLine 31 ==> SourceLine 26
                ((simtst107$PBLK12)(CUR$.SL$)).passive.Elt[p3$i-((simtst107$PBLK12)(CUR$.SL$)).passive.LB[0]]=false;
                ((simtst107$PBLK12)(CUR$.SL$)).terminatd.Elt[p3$i-((simtst107$PBLK12)(CUR$.SL$)).terminatd.LB[0]]=false;
                ((simtst107$PBLK12)(CUR$.SL$)).active.Elt[p3$i-((simtst107$PBLK12)(CUR$.SL$)).active.LB[0]]=true;
                // JavaLine 35 ==> SourceLine 27
                new simtst107$PBLK12$outstate(((simtst107$PBLK12)(CUR$.SL$)),p3$i);
                // JavaLine 37 ==> SourceLine 28
                ((simtst107$PBLK12)(CUR$.SL$)).active.Elt[p3$i-((simtst107$PBLK12)(CUR$.SL$)).active.LB[0]]=false;
                ((simtst107$PBLK12)(CUR$.SL$)).terminatd.Elt[p3$i-((simtst107$PBLK12)(CUR$.SL$)).terminatd.LB[0]]=true;
                ((simtst107$PBLK12)(CUR$.SL$)).passive.Elt[p3$i-((simtst107$PBLK12)(CUR$.SL$)).passive.LB[0]]=false;
                // JavaLine 41 ==> SourceLine 24
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("p",24);
                }
                TRACE_END_STM$("p",24);
            }
        };
    } // End of Constructor
    // Class Statements
    public simtst107$PBLK12$p STM$() { return((simtst107$PBLK12$p)CODE$.EXEC$()); }
    public simtst107$PBLK12$p START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst107.sim","Class p",1,23,24,24,27,25,31,26,35,27,37,28,41,24,52,29);
}
