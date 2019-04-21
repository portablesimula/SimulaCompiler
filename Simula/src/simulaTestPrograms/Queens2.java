package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 21:26:23 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Queens2 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final LABQNT$ EXIT=new LABQNT$(this,1,"EXIT");
    public ARRAY$<int[]>q=null;
    public ARRAY$<int[]>u=null;
    public ARRAY$<int[]>d=null;
    TXT$ OUTPOS=null;
    TXT$ th=null;
    int i=0;
    int j=0;
    int nr=0;
    boolean nochk=false;
    boolean all=false;
    char ch=0;
    public Queens2(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("Queens2");
        int[] q$LB=new int[1]; int[] q$UB=new int[1];
        q$LB[0]=(-(17)); q$UB[0]=17;
        BOUND_CHECK$(q$LB[0],q$UB[0]);
        q=new ARRAY$<int[]>(new int[q$UB[0]-q$LB[0]+1],q$LB,q$UB);
        int[] u$LB=new int[1]; int[] u$UB=new int[1];
        u$LB[0]=(-(17)); u$UB[0]=17;
        BOUND_CHECK$(u$LB[0],u$UB[0]);
        u=new ARRAY$<int[]>(new int[u$UB[0]-u$LB[0]+1],u$LB,u$UB);
        int[] d$LB=new int[1]; int[] d$UB=new int[1];
        d$LB[0]=(-(17)); d$UB[0]=17;
        BOUND_CHECK$(d$LB[0],d$UB[0]);
        d=new ARRAY$<int[]>(new int[d$UB[0]-d$LB[0]+1],d$LB,d$UB);
    }
    public RTObject$ STM$() {
        Queens2 THIS$=(Queens2)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                OUTPOS=copy(copy(new TXT$("[01;01H")));
                sysout().outtext(new TXT$("[2J"));
                sysout().breakoutimage();
                new Queens2$drawboard(((Queens2)CUR$));
                sysout().outtext(new TXT$("[33m"));
                sysout().breakoutimage();
                new Queens2$Setpos(((Queens2)CUR$),1,1);
                sysout().outtext(new TXT$("      Take a Chessboard, place 8 queens on it"));
                sysout().outtext(new TXT$(" without any of them"));
                new Queens2$Setpos(((Queens2)CUR$),2,1);
                sysout().outtext(new TXT$("      able to strike another."));
                new Queens2$drawboard(((Queens2)CUR$));
                sysout().outtext(new TXT$("[31m"));
                sysout().breakoutimage();
                new Queens2$p(((Queens2)CUR$),0,17,q.COPY(),u.COPY(),d.COPY());
                LABEL$(1,"EXIT");
                new Queens2$Setpos(((Queens2)CUR$),24,1);
                sysout().outtext(new TXT$("[0m"));
                sysout().breakoutimage();
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    CUR$.STATE$=OperationalState.terminated;
                    throw(q);
                }
                JTX$=q.index; continue LOOP$;
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new Queens2(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Queens2.sim","SimulaProgram Queens2",1,1,8,109,10,1,14,2,22,3,28,1,47,96,49,97,53,98,56,99,59,100,61,101,64,105,66,106,69,107,71,109,94,110);
}
