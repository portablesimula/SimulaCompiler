// JavaLine 1 ==> SourceLine 4
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:44:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SCANNER extends ERRMSG {
    // ClassDeclaration: BlockKind=Class, BlockLevel=1, PrefixLevel=2, firstLine=4, lastLine=2433, hasLocalClasses=true, System=false, detachUsed=true
    public int prefixLevel() { return(2); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 58
    public final char EOL=((char)7);
    // JavaLine 14 ==> SourceLine 59
    public final int upcorr=32;
    // JavaLine 16 ==> SourceLine 63
    public final char Skip_cl=((char)9);
    // JavaLine 18 ==> SourceLine 64
    public final char Illegal_cl=((char)8);
    // JavaLine 20 ==> SourceLine 65
    public final char Graphic_cl=((char)7);
    // JavaLine 22 ==> SourceLine 66
    public final char Format_cl=((char)6);
    // JavaLine 24 ==> SourceLine 67
    public final char Exclam_cl=((char)5);
    // JavaLine 26 ==> SourceLine 68
    public final char Basic_cl=((char)4);
    // JavaLine 28 ==> SourceLine 69
    public final char Uscore_cl=((char)3);
    // JavaLine 30 ==> SourceLine 70
    public final char Digit_cl=((char)2);
    // JavaLine 32 ==> SourceLine 71
    public final char LetterC_cl=((char)1);
    // JavaLine 34 ==> SourceLine 72
    public final char Letter_cl=((char)0);
    // JavaLine 36 ==> SourceLine 77
    public int extid=0;
    // JavaLine 38 ==> SourceLine 78
    public int repcount=0;
    // JavaLine 40 ==> SourceLine 79
    public SCANNER$recognizer lexScanner=null;
    // JavaLine 42 ==> SourceLine 502
    public boolean incrlnr=false;
    // JavaLine 44 ==> SourceLine 503
    public SCANNER$input cursource=null;
    // JavaLine 46 ==> SourceLine 504
    public boolean dummygen=false;
    // JavaLine 48 ==> SourceLine 506
    public ARRAY$<boolean[]>selector=null;
    public SCANNER$L2Coder P1coder=null;
    // Normal Constructor
    public SCANNER(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("SCANNER",2430);
        // JavaLine 57 ==> SourceLine 506
        int[] selector$LB=new int[1]; int[] selector$UB=new int[1];
        selector$LB[0]=0; selector$UB[0]=127;
        BOUND_CHECK$(selector$LB[0],selector$UB[0]);
        selector=new ARRAY$<boolean[]>(new boolean[selector$UB[0]-selector$LB[0]+1],selector$LB,selector$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("SCANNER",506,inner);
                // JavaLine 66 ==> SourceLine 2433
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("SCANNER",2433);
                }
                TRACE_END_STM$("SCANNER",2433);
            }
        };
    } // End of Constructor
    // Class Statements
    public SCANNER STM$() { return((SCANNER)CODE$.EXEC$()); }
    public SCANNER START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Class SCANNER",1,4,12,58,14,59,16,63,18,64,20,65,22,66,24,67,26,68,28,69,30,70,32,71,34,72,36,77,38,78,40,79,42,502,44,503,46,504,48,506,57,506,66,2433,77,2433);
}
