package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:12:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Docking$Warehouse$Generator extends Process$ {
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    public int arrInterval$3=0;
    public ARRAY$<float[]>arrivals=null;
    public ARRAY$<float[]>AvrgLoad=null;
    public Docking$Warehouse$Generator(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("Generator",171);
        int[] arrivals$LB=new int[1]; int[] arrivals$UB=new int[1];
        arrivals$LB[0]=1; arrivals$UB[0]=9;
        BOUND_CHECK$(arrivals$LB[0],arrivals$UB[0]);
        arrivals=new ARRAY$<float[]>(new float[arrivals$UB[0]-arrivals$LB[0]+1],arrivals$LB,arrivals$UB);
        int[] AvrgLoad$LB=new int[1]; int[] AvrgLoad$UB=new int[1];
        AvrgLoad$LB[0]=4; AvrgLoad$UB[0]=24;
        BOUND_CHECK$(AvrgLoad$LB[0],AvrgLoad$UB[0]);
        AvrgLoad=new ARRAY$<float[]>(new float[AvrgLoad$UB[0]-AvrgLoad$LB[0]+1],AvrgLoad$LB,AvrgLoad$UB);
    }
    public Docking$Warehouse$Generator STM$() {
        detach();
        arrivals.Elt[1-arrivals.LB[0]]=((float)(59));
        arrivals.Elt[2-arrivals.LB[0]]=((float)(19));
        arrivals.Elt[3-arrivals.LB[0]]=((float)(13));
        arrivals.Elt[4-arrivals.LB[0]]=((float)(4));
        arrivals.Elt[5-arrivals.LB[0]]=((float)(1));
        arrivals.Elt[6-arrivals.LB[0]]=((float)(1));
        arrivals.Elt[7-arrivals.LB[0]]=((float)(1));
        arrivals.Elt[8-arrivals.LB[0]]=((float)(1));
        arrivals.Elt[9-arrivals.LB[0]]=((float)(1));
        AvrgLoad.Elt[4-AvrgLoad.LB[0]]=((float)(9));
        AvrgLoad.Elt[6-AvrgLoad.LB[0]]=((float)(20));
        AvrgLoad.Elt[8-AvrgLoad.LB[0]]=((float)(22));
        AvrgLoad.Elt[10-AvrgLoad.LB[0]]=((float)(14));
        AvrgLoad.Elt[12-AvrgLoad.LB[0]]=((float)(9));
        AvrgLoad.Elt[14-AvrgLoad.LB[0]]=((float)(3));
        AvrgLoad.Elt[16-AvrgLoad.LB[0]]=((float)(2));
        AvrgLoad.Elt[18-AvrgLoad.LB[0]]=((float)(9));
        AvrgLoad.Elt[20-AvrgLoad.LB[0]]=((float)(4));
        AvrgLoad.Elt[22-AvrgLoad.LB[0]]=((float)(6));
        AvrgLoad.Elt[24-AvrgLoad.LB[0]]=((float)(2));
        while(true) {
            {
                arrInterval$3=histd(arrivals,((Docking)(CUR$.SL$.SL$)).U1$2);
                ((Docking$Warehouse)(CUR$.SL$)).hold(((double)(((arrInterval$3*(10))-(5)))));
                ((Docking$Warehouse)(CUR$.SL$)).Totnr$2=(((Docking$Warehouse)(CUR$.SL$)).Totnr$2+(1));
                ((Docking$Warehouse)(CUR$.SL$)).ActivateDirect(false,((Docking$Warehouse$Van)new Docking$Warehouse$Van(((Docking$Warehouse)(CUR$.SL$)),histd(AvrgLoad,((Docking)(CUR$.SL$.SL$)).U2$2)).START$()));
            }
            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
        }
        terminate();
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Class Generator",1,169,9,170,11,171,27,1,29,172,33,173,37,174,41,175,46,176,51,177,55,178,57,179,60,180,62,181,64,182,69,1,71,172,74,184);
}
