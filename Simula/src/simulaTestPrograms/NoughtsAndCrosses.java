// JavaLine 1 ==> SourceLine 2
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Feb 23 10:10:58 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class NoughtsAndCrosses extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=2, lastLine=79, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    int count=0;
    // JavaLine 12 ==> SourceLine 3
    char null$=0;
    // JavaLine 14 ==> SourceLine 4
    public ARRAY$<char[][]>board=null;
    // JavaLine 16 ==> SourceLine 5
    NoughtsAndCrosses$Crosser Cross_Player=null;
    // JavaLine 18 ==> SourceLine 6
    NoughtsAndCrosses$Noughter Nought_Player=null;
    // Normal Constructor
    public NoughtsAndCrosses(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("NoughtsAndCrosses");
        // Declaration Code
        TRACE_BEGIN_DCL$("NoughtsAndCrosses",70);
        // JavaLine 27 ==> SourceLine 4
        int[] board$LB=new int[2]; int[] board$UB=new int[2];
        board$LB[0]=1; board$UB[0]=3;
        BOUND_CHECK$(board$LB[0],board$UB[0]);
        board$LB[1]=1; board$UB[1]=3;
        BOUND_CHECK$(board$LB[1],board$UB[1]);
        board=new ARRAY$<char[][]>(new char[board$UB[0]-board$LB[0]+1][board$UB[1]-board$LB[1]+1],board$LB,board$UB);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("NoughtsAndCrosses",4);
        // JavaLine 38 ==> SourceLine 72
        Cross_Player=new NoughtsAndCrosses$Crosser(((NoughtsAndCrosses)CUR$),'X').START();
        // JavaLine 40 ==> SourceLine 73
        Nought_Player=new NoughtsAndCrosses$Noughter(((NoughtsAndCrosses)CUR$),'O').START();
        // JavaLine 42 ==> SourceLine 74
        Cross_Player.oponent=Nought_Player;
        // JavaLine 44 ==> SourceLine 75
        Nought_Player.oponent=Cross_Player;
        // JavaLine 46 ==> SourceLine 77
        resume(Cross_Player);
        TRACE_END_STM$("NoughtsAndCrosses",77);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new NoughtsAndCrosses(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("NoughtsAndCrosses.sim","SimulaProgram NoughtsAndCrosses",1,2,12,3,14,4,16,5,18,6,27,4,38,72,40,73,42,74,44,75,46,77,57,79);
}
