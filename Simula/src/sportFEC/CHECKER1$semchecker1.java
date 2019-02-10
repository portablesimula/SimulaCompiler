// JavaLine 1 ==> SourceLine 37
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1 extends BUILDER2$prechecker {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=2, firstLine=37, lastLine=2636, hasLocalClasses=true, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 40
    public boolean inarraybound=false;
    // JavaLine 13 ==> SourceLine 42
    public boolean implNone=false;
    // JavaLine 15 ==> SourceLine 43
    public char fkind=0;
    public char ftype=0;
    public char actualkind=0;
    // JavaLine 19 ==> SourceLine 44
    public int c=0;
    // JavaLine 21 ==> SourceLine 45
    public int t=0;
    // JavaLine 23 ==> SourceLine 48
    public int opttop=0;
    // JavaLine 25 ==> SourceLine 49
    public final int NargUnknown=1000;
    // JavaLine 27 ==> SourceLine 51
    public CHECKER1$semchecker1$exp exptop=null;
    // JavaLine 29 ==> SourceLine 52
    public CHECKER1$semchecker1$exp expv=null;
    // JavaLine 31 ==> SourceLine 53
    public CHECKER1$semchecker1$nextargumentproducer lastnap=null;
    // JavaLine 33 ==> SourceLine 54
    public COMMON$quantity textclass=null;
    // JavaLine 35 ==> SourceLine 56
    public COMMON$quantity cquant=null;
    // JavaLine 37 ==> SourceLine 57
    public COMMON$quantity readonly=null;
    // JavaLine 39 ==> SourceLine 58
    public COMMON$quantity actqty=null;
    // JavaLine 41 ==> SourceLine 59
    public COMMON$brecord cbrec=null;
    // JavaLine 43 ==> SourceLine 60
    public COMMON$quantity q=null;
    // JavaLine 45 ==> SourceLine 62
    public COMMON$symbolbox opdSymb=null;
    public COMMON$symbolbox stepfastSymb=null;
    // JavaLine 48 ==> SourceLine 63
    public CHECKER1$semchecker1$boolconst true_const=null;
    public CHECKER1$semchecker1$boolconst false_const=null;
    // JavaLine 51 ==> SourceLine 64
    public CHECKER1$semchecker1$textconst notext_const=null;
    // JavaLine 53 ==> SourceLine 65
    public CHECKER1$semchecker1$valassign valassList=null;
    // JavaLine 55 ==> SourceLine 66
    public CHECKER1$semchecker1$refassign refassList=null;
    // JavaLine 57 ==> SourceLine 67
    public CHECKER1$semchecker1$simpleIdent simpleList=null;
    // JavaLine 59 ==> SourceLine 68
    public CHECKER1$semchecker1$valuerel valrelList=null;
    // JavaLine 61 ==> SourceLine 69
    public CHECKER1$semchecker1$arithconst aconstList=null;
    // JavaLine 63 ==> SourceLine 71
    public TXT$ etxt1=null;
    public TXT$ etxt2=null;
    // JavaLine 66 ==> SourceLine 94
    public final char IEEXPcl=((char)1);
    // JavaLine 68 ==> SourceLine 95
    public final char IIFcl=((char)2);
    // JavaLine 70 ==> SourceLine 96
    public final char IIFSBcl=((char)3);
    // JavaLine 72 ==> SourceLine 97
    public final char ITOcl=((char)4);
    // JavaLine 74 ==> SourceLine 98
    public final char IACTEcl=((char)5);
    // JavaLine 76 ==> SourceLine 99
    public final char ITEXTcl=((char)6);
    // JavaLine 78 ==> SourceLine 101
    public final char IMXMXcl=((char)6);
    // JavaLine 80 ==> SourceLine 704
    public CHECKER1$semchecker1$textoperand dummytxtop=null;
    // Normal Constructor
    public CHECKER1$semchecker1(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("semchecker1",2631);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("semchecker1",2631,inner);
                // JavaLine 92 ==> SourceLine 2636
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("semchecker1",2636);
                }
                TRACE_END_STM$("semchecker1",2636);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1 STM$() { return((CHECKER1$semchecker1)CODE$.EXEC$()); }
    public CHECKER1$semchecker1 START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class semchecker1",1,37,11,40,13,42,15,43,19,44,21,45,23,48,25,49,27,51,29,52,31,53,33,54,35,56,37,57,39,58,41,59,43,60,45,62,48,63,51,64,53,65,55,66,57,67,59,68,61,69,63,71,66,94,68,95,70,96,72,97,74,98,76,99,78,101,80,704,92,2636,103,2636);
}
