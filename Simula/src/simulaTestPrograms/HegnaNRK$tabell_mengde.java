package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class HegnaNRK$tabell_mengde extends CLASS$ {
    public int prefixLevel() { return(0); }
    public int p$antall;
    public ARRAY$<int[]>tabell=null;
    public HegnaNRK$tabell_mengde(RTObject$ staticLink,int sp$antall) {
        super(staticLink);
        this.p$antall = sp$antall;
        BBLK(); // Iff no prefix
        TRACE_BEGIN_DCL$("tabell_mengde",219);
        int[] tabell$LB=new int[1]; int[] tabell$UB=new int[1];
        tabell$LB[0]=1; tabell$UB[0]=p$antall;
        BOUND_CHECK$(tabell$LB[0],tabell$UB[0]);
        tabell=new ARRAY$<int[]>(new int[tabell$UB[0]-tabell$LB[0]+1],tabell$LB,tabell$UB);
    }
    public HegnaNRK$tabell_mengde STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Class tabell_mengde",1,217,9,219,22,220,25,220);
}
