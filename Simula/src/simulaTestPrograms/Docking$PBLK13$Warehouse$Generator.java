// JavaLine 1 ==> SourceLine 151
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Jan 27 17:13:52 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Docking$PBLK13$Warehouse$Generator extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=3, firstLine=151, lastLine=166, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 152
    public int arrInterval=0;
    // JavaLine 14 ==> SourceLine 153
    public ARRAY$<float[]>arrivals=null;
    public ARRAY$<float[]>AvrgLoad=null;
    // Normal Constructor
    public Docking$PBLK13$Warehouse$Generator(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("Generator",153);
        int[] arrivals$LB=new int[1]; int[] arrivals$UB=new int[1];
        arrivals$LB[0]=1; arrivals$UB[0]=9;
        BOUND_CHECK$(arrivals$LB[0],arrivals$UB[0]);
        arrivals=new ARRAY$<float[]>(new float[arrivals$UB[0]-arrivals$LB[0]+1],arrivals$LB,arrivals$UB);
        int[] AvrgLoad$LB=new int[1]; int[] AvrgLoad$UB=new int[1];
        AvrgLoad$LB[0]=4; AvrgLoad$UB[0]=24;
        BOUND_CHECK$(AvrgLoad$LB[0],AvrgLoad$UB[0]);
        AvrgLoad=new ARRAY$<float[]>(new float[AvrgLoad$UB[0]-AvrgLoad$LB[0]+1],AvrgLoad$LB,AvrgLoad$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("Generator",153,inner);
                // JavaLine 35 ==> SourceLine 154
                arrivals.Elt[1-arrivals.LB[0]]=((float)(59));
                arrivals.Elt[2-arrivals.LB[0]]=((float)(19));
                arrivals.Elt[3-arrivals.LB[0]]=((float)(13));
                // JavaLine 39 ==> SourceLine 155
                arrivals.Elt[4-arrivals.LB[0]]=((float)(4));
                arrivals.Elt[5-arrivals.LB[0]]=((float)(1));
                arrivals.Elt[6-arrivals.LB[0]]=((float)(1));
                // JavaLine 43 ==> SourceLine 156
                arrivals.Elt[7-arrivals.LB[0]]=((float)(1));
                arrivals.Elt[8-arrivals.LB[0]]=((float)(1));
                arrivals.Elt[9-arrivals.LB[0]]=((float)(1));
                // JavaLine 47 ==> SourceLine 157
                AvrgLoad.Elt[4-AvrgLoad.LB[0]]=((float)(9));
                AvrgLoad.Elt[6-AvrgLoad.LB[0]]=((float)(20));
                AvrgLoad.Elt[8-AvrgLoad.LB[0]]=((float)(22));
                AvrgLoad.Elt[10-AvrgLoad.LB[0]]=((float)(14));
                // JavaLine 52 ==> SourceLine 158
                AvrgLoad.Elt[12-AvrgLoad.LB[0]]=((float)(9));
                AvrgLoad.Elt[14-AvrgLoad.LB[0]]=((float)(3));
                AvrgLoad.Elt[16-AvrgLoad.LB[0]]=((float)(2));
                AvrgLoad.Elt[18-AvrgLoad.LB[0]]=((float)(9));
                // JavaLine 57 ==> SourceLine 159
                AvrgLoad.Elt[20-AvrgLoad.LB[0]]=((float)(4));
                AvrgLoad.Elt[22-AvrgLoad.LB[0]]=((float)(6));
                AvrgLoad.Elt[24-AvrgLoad.LB[0]]=((float)(2));
                // JavaLine 61 ==> SourceLine 160
                while(true) {
                    // JavaLine 63 ==> SourceLine 161
                    {
                        TRACE_BEGIN_STM$("CompoundStatement161",161);
                        arrInterval=histd(arrivals,new NAME$<Integer>(){ public Integer get() { return(((Docking$PBLK13)(CUR$.SL$.SL$)).U1); } public Integer put(Integer x$) { return(((Docking$PBLK13)(CUR$.SL$.SL$)).U1=(int)x$); } });
                        // JavaLine 67 ==> SourceLine 162
                        ((Docking$PBLK13$Warehouse)(CUR$.SL$)).hold(((double)(((arrInterval*(10))-(5)))));
                        // JavaLine 69 ==> SourceLine 163
                        ((Docking$PBLK13$Warehouse)(CUR$.SL$)).Totnr=(((Docking$PBLK13$Warehouse)(CUR$.SL$)).Totnr+(1));
                        // JavaLine 71 ==> SourceLine 164
                        ((Docking$PBLK13$Warehouse)(CUR$.SL$)).ActivateDirect(false,new Docking$PBLK13$Warehouse$Van(((Docking$PBLK13$Warehouse)(CUR$.SL$)),histd(AvrgLoad,new NAME$<Integer>(){ public Integer get() { return(((Docking$PBLK13)(CUR$.SL$.SL$)).U2); } public Integer put(Integer x$) { return(((Docking$PBLK13)(CUR$.SL$.SL$)).U2=(int)x$); } })).START());
                        TRACE_END_STM$("CompoundStatement161",164);
                    }
                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                }
                // JavaLine 77 ==> SourceLine 154
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Generator",154);
                }
                TRACE_END_STM$("Generator",154);
            }
        };
    } // End of Constructor
    // Class Statements
    public Docking$PBLK13$Warehouse$Generator STM$() { return((Docking$PBLK13$Warehouse$Generator)CODE$.EXEC$()); }
    public Docking$PBLK13$Warehouse$Generator START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Class Generator",1,151,12,152,14,153,35,154,39,155,43,156,47,157,52,158,57,159,61,160,63,161,67,162,69,163,71,164,77,154,88,166);
}
