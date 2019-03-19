// JavaLine 1 ==> SourceLine 169
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Mar 19 10:04:25 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Docking$PBLK12$Warehouse$Generator extends Process$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=3, firstLine=169, lastLine=184, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 170
    public int arrInterval=0;
    // JavaLine 14 ==> SourceLine 171
    public ARRAY$<float[]>arrivals=null;
    public ARRAY$<float[]>AvrgLoad=null;
    // Normal Constructor
    public Docking$PBLK12$Warehouse$Generator(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("Generator",171);
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
                TRACE_BEGIN_STM$("Generator",171,inner);
                // JavaLine 35 ==> SourceLine 172
                arrivals.Elt[1-arrivals.LB[0]]=((float)(59));
                arrivals.Elt[2-arrivals.LB[0]]=((float)(19));
                arrivals.Elt[3-arrivals.LB[0]]=((float)(13));
                // JavaLine 39 ==> SourceLine 173
                arrivals.Elt[4-arrivals.LB[0]]=((float)(4));
                arrivals.Elt[5-arrivals.LB[0]]=((float)(1));
                arrivals.Elt[6-arrivals.LB[0]]=((float)(1));
                // JavaLine 43 ==> SourceLine 174
                arrivals.Elt[7-arrivals.LB[0]]=((float)(1));
                arrivals.Elt[8-arrivals.LB[0]]=((float)(1));
                arrivals.Elt[9-arrivals.LB[0]]=((float)(1));
                // JavaLine 47 ==> SourceLine 175
                AvrgLoad.Elt[4-AvrgLoad.LB[0]]=((float)(9));
                AvrgLoad.Elt[6-AvrgLoad.LB[0]]=((float)(20));
                AvrgLoad.Elt[8-AvrgLoad.LB[0]]=((float)(22));
                AvrgLoad.Elt[10-AvrgLoad.LB[0]]=((float)(14));
                // JavaLine 52 ==> SourceLine 176
                AvrgLoad.Elt[12-AvrgLoad.LB[0]]=((float)(9));
                AvrgLoad.Elt[14-AvrgLoad.LB[0]]=((float)(3));
                AvrgLoad.Elt[16-AvrgLoad.LB[0]]=((float)(2));
                AvrgLoad.Elt[18-AvrgLoad.LB[0]]=((float)(9));
                // JavaLine 57 ==> SourceLine 177
                AvrgLoad.Elt[20-AvrgLoad.LB[0]]=((float)(4));
                AvrgLoad.Elt[22-AvrgLoad.LB[0]]=((float)(6));
                AvrgLoad.Elt[24-AvrgLoad.LB[0]]=((float)(2));
                // JavaLine 61 ==> SourceLine 178
                while(true) {
                    // JavaLine 63 ==> SourceLine 179
                    {
                        TRACE_BEGIN_STM$("CompoundStatement179",179);
                        arrInterval=histd(arrivals,new NAME$<Integer>(){ public Integer get() { return(((Docking$PBLK12)(CUR$.SL$.SL$)).U1); } public Integer put(Integer x$) { return(((Docking$PBLK12)(CUR$.SL$.SL$)).U1=(int)x$); } });
                        // JavaLine 67 ==> SourceLine 180
                        ((Docking$PBLK12$Warehouse)(CUR$.SL$)).hold(((double)(((arrInterval*(10))-(5)))));
                        // JavaLine 69 ==> SourceLine 181
                        ((Docking$PBLK12$Warehouse)(CUR$.SL$)).Totnr=(((Docking$PBLK12$Warehouse)(CUR$.SL$)).Totnr+(1));
                        // JavaLine 71 ==> SourceLine 182
                        ((Docking$PBLK12$Warehouse)(CUR$.SL$)).ActivateDirect(false,new Docking$PBLK12$Warehouse$Van(((Docking$PBLK12$Warehouse)(CUR$.SL$)),histd(AvrgLoad,new NAME$<Integer>(){ public Integer get() { return(((Docking$PBLK12)(CUR$.SL$.SL$)).U2); } public Integer put(Integer x$) { return(((Docking$PBLK12)(CUR$.SL$.SL$)).U2=(int)x$); } })).START());
                        TRACE_END_STM$("CompoundStatement179",182);
                    }
                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                }
                // JavaLine 77 ==> SourceLine 172
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("Generator",172);
                }
                TRACE_END_STM$("Generator",172);
            }
        };
    } // End of Constructor
    // Class Statements
    public Docking$PBLK12$Warehouse$Generator STM$() { return((Docking$PBLK12$Warehouse$Generator)CODE$.EXEC$()); }
    public Docking$PBLK12$Warehouse$Generator START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("Docking.sim","Class Generator",1,169,12,170,14,171,35,172,39,173,43,174,47,175,52,176,57,177,61,178,63,179,67,180,69,181,71,182,77,172,88,184);
}
