// JavaLine 1 ==> SourceLine 43
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Feb 10 12:41:56 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class FittingRoom$PBLK6$Person extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=3, firstLine=43, lastLine=53, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public TXT$ p3$pname;
    // Declare locals as attributes
    // Normal Constructor
    public FittingRoom$PBLK6$Person(RTObject$ staticLink,TXT$ sp3$pname) {
        super(staticLink);
        // Parameter assignment to locals
        this.p3$pname = sp3$pname;
        // Declaration Code
        TRACE_BEGIN_DCL$("Person",43);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("Person",43,inner);
                // JavaLine 24 ==> SourceLine 44
                while(true) {
                    // JavaLine 26 ==> SourceLine 45
                    {
                        TRACE_BEGIN_STM$("CompoundStatement45",45);
                        ((FittingRoom$PBLK6)(CUR$.SL$)).hold(normal(((double)(12)),((double)(4)),new NAME$<Integer>(){ public Integer get() { return(((FittingRoom$PBLK6)(CUR$.SL$)).u); } public Integer put(Integer x$) { return(((FittingRoom$PBLK6)(CUR$.SL$)).u=(int)x$); } }));
                        // JavaLine 30 ==> SourceLine 46
                        new FittingRoom$PBLK6$report(((FittingRoom$PBLK6)(CUR$.SL$)),CONC(p3$pname,new TXT$(" is requesting the fitting room")));
                        // JavaLine 32 ==> SourceLine 47
                        new FittingRoom$PBLK6$FittingRoom$request(((FittingRoom$PBLK6)(CUR$.SL$)).fittingRoom1);
                        // JavaLine 34 ==> SourceLine 48
                        new FittingRoom$PBLK6$report(((FittingRoom$PBLK6)(CUR$.SL$)),CONC(p3$pname,new TXT$(" has entered the fitting room")));
                        // JavaLine 36 ==> SourceLine 49
                        ((FittingRoom$PBLK6)(CUR$.SL$)).hold(normal(((double)(3)),((double)(1)),new NAME$<Integer>(){ public Integer get() { return(((FittingRoom$PBLK6)(CUR$.SL$)).u); } public Integer put(Integer x$) { return(((FittingRoom$PBLK6)(CUR$.SL$)).u=(int)x$); } }));
                        // JavaLine 38 ==> SourceLine 50
                        new FittingRoom$PBLK6$FittingRoom$leave(((FittingRoom$PBLK6)(CUR$.SL$)).fittingRoom1);
                        // JavaLine 40 ==> SourceLine 51
                        new FittingRoom$PBLK6$report(((FittingRoom$PBLK6)(CUR$.SL$)),CONC(p3$pname,new TXT$(" has left the fitting room")));
                        TRACE_END_STM$("CompoundStatement45",51);
                    }
                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                }
                // JavaLine 46 ==> SourceLine 44
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Person",44);
                }
                TRACE_END_STM$("Person",44);
            }
        };
    } // End of Constructor
    // Class Statements
    public FittingRoom$PBLK6$Person STM$() { return((FittingRoom$PBLK6$Person)CODE$.EXEC$()); }
    public FittingRoom$PBLK6$Person START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("FittingRoom.sim","Class Person",1,43,24,44,26,45,30,46,32,47,34,48,36,49,38,50,40,51,46,44,57,53);
}
