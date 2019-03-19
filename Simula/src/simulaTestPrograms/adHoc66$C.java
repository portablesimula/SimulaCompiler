// JavaLine 1 ==> SourceLine 6
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Mar 17 12:43:09 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class adHoc66$C extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=6, lastLine=15, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public TXT$ p$ident;
    // Declare locals as attributes
    // JavaLine 13 ==> SourceLine 8
    public adHoc66$C neste=null;
    // Normal Constructor
    public adHoc66$C(RTObject$ staticLink,TXT$ sp$ident) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$ident = sp$ident;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("C",8);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("C",8,inner);
                // JavaLine 27 ==> SourceLine 9
                sysout().outtext(CONC(new TXT$("INIT "),p$ident));
                sysout().outimage();
                // JavaLine 30 ==> SourceLine 10
                detach();
                // JavaLine 32 ==> SourceLine 11
                sysout().outtext(CONC(new TXT$("SESS "),p$ident));
                sysout().outimage();
                // JavaLine 35 ==> SourceLine 12
                resume(neste);
                // JavaLine 37 ==> SourceLine 13
                new adHoc66$P(((adHoc66)(CUR$.SL$)));
                // JavaLine 39 ==> SourceLine 14
                sysout().outtext(CONC(new TXT$("ENDE "),p$ident));
                sysout().outimage();
                // JavaLine 42 ==> SourceLine 9
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("C",9);
                }
                TRACE_END_STM$("C",9);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public adHoc66$C STM$() { return((adHoc66$C)CODE$.EXEC$()); }
    public adHoc66$C START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("adHoc66.sim","Class C",1,6,13,8,27,9,30,10,32,11,35,12,37,13,39,14,42,9,54,15);
}
