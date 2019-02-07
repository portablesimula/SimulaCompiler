// JavaLine 1 ==> SourceLine 10
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Wed Feb 06 20:31:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst68 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=10, lastLine=191, hasLocalClasses=true, System=true
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    // Declare locals as attributes
    boolean found_error=false;
    // JavaLine 12 ==> SourceLine 11
    final boolean verbose=false;
    // JavaLine 14 ==> SourceLine 13
    public ARRAY$<TXT$[]>lines=null;
    public ARRAY$<TXT$[]>facit=null;
    // JavaLine 17 ==> SourceLine 14
    int lnr=0;
    // JavaLine 19 ==> SourceLine 66
    char c1=0;
    char c2=0;
    // JavaLine 22 ==> SourceLine 140
    simtst68$Coroutine r=null;
    simtst68$Coroutine c=null;
    simtst68$Coroutine w=null;
    // Normal Constructor
    public simtst68(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst68");
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst68",140);
        // JavaLine 33 ==> SourceLine 13
        int[] lines$LB=new int[1]; int[] lines$UB=new int[1];
        lines$LB[0]=1; lines$UB[0]=20;
        BOUND_CHECK$(lines$LB[0],lines$UB[0]);
        lines=new ARRAY$<TXT$[]>(new TXT$[lines$UB[0]-lines$LB[0]+1],lines$LB,lines$UB);
        int[] facit$LB=new int[1]; int[] facit$UB=new int[1];
        facit$LB[0]=1; facit$UB[0]=20;
        BOUND_CHECK$(facit$LB[0],facit$UB[0]);
        facit=new ARRAY$<TXT$[]>(new TXT$[facit$UB[0]-facit$LB[0]+1],facit$LB,facit$UB);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simtst68",13);
        // JavaLine 46 ==> SourceLine 142
        if(VALUE$(verbose)) {
            // JavaLine 48 ==> SourceLine 143
            {
                TRACE_BEGIN_STM$("CompoundStatement143",143);
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 68"));
                // JavaLine 52 ==> SourceLine 144
                sysout().outimage();
                // JavaLine 54 ==> SourceLine 145
                sysout().outtext(new TXT$("--- Test coroutines."));
                // JavaLine 56 ==> SourceLine 146
                sysout().outimage();
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement143",146);
            }
        }
        // JavaLine 62 ==> SourceLine 149
        new simtst68$trace(((simtst68)CUR$),new TXT$("Before new Reader"));
        // JavaLine 64 ==> SourceLine 150
        r=new simtst68$Reader(((simtst68)CUR$)).START();
        // JavaLine 66 ==> SourceLine 151
        new simtst68$trace(((simtst68)CUR$),new TXT$("Before new Changer"));
        // JavaLine 68 ==> SourceLine 152
        c=new simtst68$Changer(((simtst68)CUR$)).START();
        // JavaLine 70 ==> SourceLine 153
        new simtst68$trace(((simtst68)CUR$),new TXT$("Before new Write"));
        // JavaLine 72 ==> SourceLine 154
        w=new simtst68$Writer(((simtst68)CUR$)).START();
        // JavaLine 74 ==> SourceLine 156
        ASGSTR$(sysin().image,"|lhkjdfjg*fdgh*98dsgh**kjdk*sgjfhgh***kljhasdg*kfhgs!ksdf");
        // JavaLine 76 ==> SourceLine 157
        TXT$.setpos(sysin().image,1);
        // JavaLine 78 ==> SourceLine 159
        resume(c);
        // JavaLine 80 ==> SourceLine 161
        facit.Elt[1-facit.LB[0]]=new TXT$("|lhkjdfjg*fdgh*");
        // JavaLine 82 ==> SourceLine 162
        facit.Elt[2-facit.LB[0]]=new TXT$("98dsgh$kjdk*sgj");
        // JavaLine 84 ==> SourceLine 163
        facit.Elt[3-facit.LB[0]]=new TXT$("fhgh$*kljhasdg*");
        // JavaLine 86 ==> SourceLine 164
        facit.Elt[4-facit.LB[0]]=new TXT$("kfhgs");
        // JavaLine 88 ==> SourceLine 166
        new simtst68$Checklines(((simtst68)CUR$),4,1);
        // JavaLine 90 ==> SourceLine 168
        TXT$.setpos(sysin().image,1);
        // JavaLine 92 ==> SourceLine 169
        ASGSTR$(sysin().image,"hi*auer****5tp9a**e598yu5e*890u**yj89u***53pq**98790!");
        // JavaLine 94 ==> SourceLine 171
        resume(c);
        // JavaLine 96 ==> SourceLine 173
        facit.Elt[1-facit.LB[0]]=new TXT$("hi*auer$$5tp9a$");
        // JavaLine 98 ==> SourceLine 174
        facit.Elt[2-facit.LB[0]]=new TXT$("e598yu5e*890u$y");
        // JavaLine 100 ==> SourceLine 175
        facit.Elt[3-facit.LB[0]]=new TXT$("j89u$*53pq$9879");
        // JavaLine 102 ==> SourceLine 176
        facit.Elt[4-facit.LB[0]]=new TXT$("0");
        // JavaLine 104 ==> SourceLine 178
        new simtst68$Checklines(((simtst68)CUR$),4,2);
        // JavaLine 106 ==> SourceLine 180
        if(VALUE$(found_error)) {
        } else
        // JavaLine 109 ==> SourceLine 183
        {
            TRACE_BEGIN_STM$("CompoundStatement183",183);
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 68"));
            TRACE_END_STM$("CompoundStatement183",183);
        }
        // JavaLine 115 ==> SourceLine 186
        if(VALUE$(verbose)) {
            // JavaLine 117 ==> SourceLine 187
            {
                TRACE_BEGIN_STM$("CompoundStatement187",187);
                sysout().outtext(new TXT$("--- END Simula a.s. TEST 68"));
                // JavaLine 121 ==> SourceLine 191
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement187",191);
            }
        }
        TRACE_END_STM$("simtst68",191);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        //System.setProperty("file.encoding","UTF-8");
        RT.setRuntimeOptions(args);
        new simtst68(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst68.sim","SimulaProgram simtst68",1,10,12,11,14,13,17,14,19,66,22,140,33,13,46,142,48,143,52,144,54,145,56,146,62,149,64,150,66,151,68,152,70,153,72,154,74,156,76,157,78,159,80,161,82,162,84,163,86,164,88,166,90,168,92,169,94,171,96,173,98,174,100,175,102,176,104,178,106,180,109,183,115,186,117,187,121,191,135,191);
}
