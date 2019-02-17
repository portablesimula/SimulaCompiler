// JavaLine 1 ==> SourceLine 118
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Feb 17 13:27:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst85$SubBlock23$SubBlock118 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=3, firstLine=118, lastLine=138, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    public ARRAY$<TXT$[]>t=null;
    // Normal Constructor
    public simtst85$SubBlock23$SubBlock118(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock118",118);
        int[] t$LB=new int[1]; int[] t$UB=new int[1];
        t$LB[0]=1; t$UB[0]=5;
        BOUND_CHECK$(t$LB[0],t$UB[0]);
        t=new ARRAY$<TXT$[]>(new TXT$[t$UB[0]-t$LB[0]+1],t$LB,t$UB);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock118",118);
        // JavaLine 25 ==> SourceLine 119
        t.Elt[1-t.LB[0]]=new TXT$("1A1B1C1D1E1F");
        // JavaLine 27 ==> SourceLine 120
        t.Elt[2-t.LB[0]]=new TXT$("2A2B2C2D2E2F");
        // JavaLine 29 ==> SourceLine 121
        t.Elt[3-t.LB[0]]=new TXT$("3A3B3C3D3E3F");
        // JavaLine 31 ==> SourceLine 122
        t.Elt[4-t.LB[0]]=new TXT$("4A4B4C4D4E4F");
        // JavaLine 33 ==> SourceLine 123
        t.Elt[5-t.LB[0]]=new TXT$("5A5B5C5D5E5F");
        // JavaLine 35 ==> SourceLine 125
        ((simtst85)(CUR$.SL$.SL$)).inspect$21$0.locate(1);
        // JavaLine 37 ==> SourceLine 126
        for(boolean CB$126:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){((simtst85$SubBlock23)(CUR$.SL$)).i=(int)x$; return(x$);};  public Number get(){return((Number)((simtst85$SubBlock23)(CUR$.SL$)).i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(5); }})
           )) { if(!CB$126) continue;
        // JavaLine 41 ==> SourceLine 128
        {
            TRACE_BEGIN_STM$("CompoundStatement128",128);
            ASGTXT$(((simtst85)(CUR$.SL$.SL$)).inspect$21$0.image,t.Elt[((simtst85$SubBlock23)(CUR$.SL$)).i-t.LB[0]]);
            // JavaLine 45 ==> SourceLine 129
            ((simtst85)(CUR$.SL$.SL$)).inspect$21$0.outimage();
            TRACE_END_STM$("CompoundStatement128",129);
        }
    }
    // JavaLine 50 ==> SourceLine 132
    ((simtst85)(CUR$.SL$.SL$)).inspect$21$0.locate(1);
    // JavaLine 52 ==> SourceLine 133
    ((simtst85)(CUR$.SL$.SL$)).inspect$21$0.inimage();
    // JavaLine 54 ==> SourceLine 134
    sysout().outtext(((simtst85)(CUR$.SL$.SL$)).inspect$21$0.intext(60));
    // JavaLine 56 ==> SourceLine 137
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)(CUR$.SL$)),new TXT$("1A1B1C1D1E1F2A2B2C2D2E2F3A3B3C3D3E3F4A4B4C4D4E4F5A5B5C5D5E5F"),new TXT$("OUTIMAGE and INTEXT"),60);
    TRACE_END_STM$("SubBlock118",137);
    EBLK();
    return(null);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("simtst85.sim","SubBlock SubBlock118",1,118,25,119,27,120,29,121,31,122,33,123,35,125,37,126,41,128,45,129,50,132,52,133,54,134,56,137,61,138);
}
