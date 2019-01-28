// JavaLine 1 ==> SourceLine 1
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Wed Jan 23 17:07:34 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Queens2 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=1, lastLine=110, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare local labels
    // JavaLine 10 ==> SourceLine 109
    final LABQNT$ EXIT=new LABQNT$(this,0,1); // Local Label #1=EXIT
    // Declare locals as attributes
    // JavaLine 13 ==> SourceLine 1
    public ARRAY$<int[]>q=null;
    public ARRAY$<int[]>u=null;
    public ARRAY$<int[]>d=null;
    // JavaLine 17 ==> SourceLine 2
    TXT$ OUTPOS=null;
    TXT$ th=null;
    int i=0;
    int j=0;
    int nr=0;
    boolean nochk=false;
    boolean all=false;
    // JavaLine 25 ==> SourceLine 3
    char ch=0;
    // Normal Constructor
    public Queens2(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("Queens2");
        // Declaration Code
        TRACE_BEGIN_DCL$("Queens2",92);
        // JavaLine 34 ==> SourceLine 1
        int[] q$LB=new int[1]; int[] q$UB=new int[1];
        q$LB[0]=-17; q$UB[0]=17;
        BOUND_CHECK$(q$LB[0],q$UB[0]);
        q=new ARRAY$<int[]>(new int[q$UB[0]-q$LB[0]+1],q$LB,q$UB);
        int[] u$LB=new int[1]; int[] u$UB=new int[1];
        u$LB[0]=-17; u$UB[0]=17;
        BOUND_CHECK$(u$LB[0],u$UB[0]);
        u=new ARRAY$<int[]>(new int[u$UB[0]-u$LB[0]+1],u$LB,u$UB);
        int[] d$LB=new int[1]; int[] d$UB=new int[1];
        d$LB[0]=-17; d$UB[0]=17;
        BOUND_CHECK$(d$LB[0],d$UB[0]);
        d=new ARRAY$<int[]>(new int[d$UB[0]-d$LB[0]+1],d$LB,d$UB);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("Queens2",1);
        Queens2 THIS$=(Queens2)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 55 ==> SourceLine 96
                OUTPOS=copy(copy(new TXT$("[01;01H")));
                // JavaLine 57 ==> SourceLine 97
                sysout().outtext(new TXT$("[2J"));
                sysout().breakoutimage();
                new Queens2$drawboard(((Queens2)CUR$));
                // JavaLine 61 ==> SourceLine 98
                sysout().outtext(new TXT$("[33m"));
                sysout().breakoutimage();
                // JavaLine 64 ==> SourceLine 99
                new Queens2$Setpos(((Queens2)CUR$),1,1);
                sysout().outtext(new TXT$("      Take a Chessboard, place 8 queens on it"));
                // JavaLine 67 ==> SourceLine 100
                sysout().outtext(new TXT$(" without any of them"));
                // JavaLine 69 ==> SourceLine 101
                new Queens2$Setpos(((Queens2)CUR$),2,1);
                sysout().outtext(new TXT$("      able to strike another."));
                // JavaLine 72 ==> SourceLine 105
                new Queens2$drawboard(((Queens2)CUR$));
                // JavaLine 74 ==> SourceLine 106
                sysout().outtext(new TXT$("[31m"));
                sysout().breakoutimage();
                // JavaLine 77 ==> SourceLine 107
                new Queens2$p(((Queens2)CUR$),0,17,q.COPY(),u.COPY(),d.COPY());
                // JavaLine 79 ==> SourceLine 109
                LABEL$(1); // EXIT
                new Queens2$Setpos(((Queens2)CUR$),24,1);
                sysout().outtext(new TXT$("[0m"));
                sysout().breakoutimage();
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$ || q.prefixLevel!=0) {
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("Queens2",109);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new Queens2(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Queens2.sim","SimulaProgram Queens2",1,1,10,109,13,1,17,2,25,3,34,1,55,96,57,97,61,98,64,99,67,100,69,101,72,105,74,106,77,107,79,109,106,110);
}
