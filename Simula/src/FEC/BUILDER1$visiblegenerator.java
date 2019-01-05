// JavaLine 1 ==> SourceLine 98
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:59:08 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class BUILDER1$visiblegenerator extends COMMON$outcodefile {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=5, firstLine=98, lastLine=166, hasLocalClasses=true, System=false, detachUsed=false
    public int prefixLevel() { return(5); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 100
    public int asd=0;
    public int curasd=0;
    // JavaLine 14 ==> SourceLine 101
    public int curjump=0;
    public int saveindex=0;
    // JavaLine 17 ==> SourceLine 103
    public ARRAY$<boolean[]>saveemitted=null;
    // JavaLine 19 ==> SourceLine 109
    public OutbyteFile$ SCF=null;
    // JavaLine 21 ==> SourceLine 111
    public ARRAY$<BUILDER1$visiblegenerator$module[]>moduletab=null;
    // Normal Constructor
    public BUILDER1$visiblegenerator(RTObject$ staticLink,TXT$ sFILENAME$) {
        super(staticLink,sFILENAME$);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("visiblegenerator",127);
        // JavaLine 29 ==> SourceLine 103
        int[] saveemitted$LB=new int[1]; int[] saveemitted$UB=new int[1];
        saveemitted$LB[0]=0; saveemitted$UB[0]=50;
        BOUND_CHECK$(saveemitted$LB[0],saveemitted$UB[0]);
        saveemitted=new ARRAY$<boolean[]>(new boolean[saveemitted$UB[0]-saveemitted$LB[0]+1],saveemitted$LB,saveemitted$UB);
        // JavaLine 34 ==> SourceLine 111
        int[] moduletab$LB=new int[1]; int[] moduletab$UB=new int[1];
        moduletab$LB[0]=0; moduletab$UB[0]=20;
        BOUND_CHECK$(moduletab$LB[0],moduletab$UB[0]);
        moduletab=new ARRAY$<BUILDER1$visiblegenerator$module[]>(new BUILDER1$visiblegenerator$module[moduletab$UB[0]-moduletab$LB[0]+1],moduletab$LB,moduletab$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,5) {
            public void STM$() {
                TRACE_BEGIN_STM$("visiblegenerator",111,inner);
                // JavaLine 43 ==> SourceLine 166
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("visiblegenerator",166);
                }
                TRACE_END_STM$("visiblegenerator",166);
            }
        };
    } // End of Constructor
    // Class Statements
    public BUILDER1$visiblegenerator STM$() { return((BUILDER1$visiblegenerator)CODE$.EXEC$()); }
    public BUILDER1$visiblegenerator START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Class visiblegenerator",1,98,11,100,14,101,17,103,19,109,21,111,29,103,34,111,43,166,54,166);
}
