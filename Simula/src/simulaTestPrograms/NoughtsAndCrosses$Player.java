// JavaLine 1 ==> SourceLine 8
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Feb 23 10:10:58 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class NoughtsAndCrosses$Player extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=0, firstLine=8, lastLine=48, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public char p$symb;
    // Declare locals as attributes
    // JavaLine 13 ==> SourceLine 10
    public int i=0;
    public int j=0;
    public NoughtsAndCrosses$Player oponent=null;
    public PRCQNT$ Move$0() { throw new RuntimeException("No Virtual Match"); }
    // Normal Constructor
    public NoughtsAndCrosses$Player(RTObject$ staticLink,char sp$symb) {
        super(staticLink);
        // Parameter assignment to locals
        this.p$symb = sp$symb;
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("Player",35);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("Player",35,inner);
                // JavaLine 30 ==> SourceLine 39
                detach();
                // JavaLine 32 ==> SourceLine 40
                while((!(new NoughtsAndCrosses$Player$Done(((NoughtsAndCrosses$Player)CUR$)).RESULT$))) {
                    // JavaLine 34 ==> SourceLine 41
                    {
                        TRACE_BEGIN_STM$("CompoundStatement41",41);
                        ((NoughtsAndCrosses$Player)CUR$).Move$0().CPF();
                        // JavaLine 38 ==> SourceLine 42
                        ((NoughtsAndCrosses)(CUR$.SL$)).board.Elt[i-((NoughtsAndCrosses)(CUR$.SL$)).board.LB[0]][j-((NoughtsAndCrosses)(CUR$.SL$)).board.LB[1]]=p$symb;
                        // JavaLine 40 ==> SourceLine 43
                        new NoughtsAndCrosses$Player$Print(((NoughtsAndCrosses$Player)CUR$));
                        // JavaLine 42 ==> SourceLine 44
                        ((NoughtsAndCrosses)(CUR$.SL$)).count=(((NoughtsAndCrosses)(CUR$.SL$)).count+(1));
                        // JavaLine 44 ==> SourceLine 45
                        if(VALUE$((((NoughtsAndCrosses)(CUR$.SL$)).count<(9)))) {
                            // JavaLine 46 ==> SourceLine 46
                            resume(oponent);
                        } else
                        {
                            TRACE_BEGIN_STM$("CompoundStatement46",46);
                            sysout().outtext(new TXT$("No winner..."));
                            detach();
                            TRACE_END_STM$("CompoundStatement46",46);
                        }
                        TRACE_END_STM$("CompoundStatement41",46);
                    }
                }
                // JavaLine 58 ==> SourceLine 39
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Player",39);
                }
                TRACE_END_STM$("Player",39);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public NoughtsAndCrosses$Player STM$() { return((NoughtsAndCrosses$Player)CODE$.EXEC$()); }
    public NoughtsAndCrosses$Player START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("NoughtsAndCrosses.sim","Class Player",1,8,13,10,30,39,32,40,34,41,38,42,40,43,42,44,44,45,46,46,58,39,70,48);
}
