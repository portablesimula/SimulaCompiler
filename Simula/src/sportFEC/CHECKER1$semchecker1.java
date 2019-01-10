// JavaLine 1 ==> SourceLine 37
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1 extends BUILDER2$prechecker {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=2, firstLine=37, lastLine=2636, hasLocalClasses=true, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 216
    final LABQNT$ CR=new LABQNT$(this,2,1); // Local Label #1=CR
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 40
    public boolean inarraybound=false;
    // JavaLine 16 ==> SourceLine 42
    public boolean implNone=false;
    // JavaLine 18 ==> SourceLine 43
    public char fkind=0;
    public char ftype=0;
    public char actualkind=0;
    // JavaLine 22 ==> SourceLine 44
    public int c=0;
    // JavaLine 24 ==> SourceLine 45
    public int t=0;
    // JavaLine 26 ==> SourceLine 48
    public int opttop=0;
    // JavaLine 28 ==> SourceLine 49
    public final int NargUnknown=1000;
    // JavaLine 30 ==> SourceLine 51
    public CHECKER1$semchecker1$exp exptop=null;
    // JavaLine 32 ==> SourceLine 52
    public CHECKER1$semchecker1$exp expv=null;
    // JavaLine 34 ==> SourceLine 53
    public CHECKER1$semchecker1$nextargumentproducer lastnap=null;
    // JavaLine 36 ==> SourceLine 54
    public COMMON$quantity textclass=null;
    // JavaLine 38 ==> SourceLine 56
    public COMMON$quantity cquant=null;
    // JavaLine 40 ==> SourceLine 57
    public COMMON$quantity readonly=null;
    // JavaLine 42 ==> SourceLine 58
    public COMMON$quantity actqty=null;
    // JavaLine 44 ==> SourceLine 59
    public COMMON$brecord cbrec=null;
    // JavaLine 46 ==> SourceLine 60
    public COMMON$quantity q=null;
    // JavaLine 48 ==> SourceLine 62
    public COMMON$symbolbox opdSymb=null;
    public COMMON$symbolbox stepfastSymb=null;
    // JavaLine 51 ==> SourceLine 63
    public CHECKER1$semchecker1$boolconst true_const=null;
    public CHECKER1$semchecker1$boolconst false_const=null;
    // JavaLine 54 ==> SourceLine 64
    public CHECKER1$semchecker1$textconst notext_const=null;
    // JavaLine 56 ==> SourceLine 65
    public CHECKER1$semchecker1$valassign valassList=null;
    // JavaLine 58 ==> SourceLine 66
    public CHECKER1$semchecker1$refassign refassList=null;
    // JavaLine 60 ==> SourceLine 67
    public CHECKER1$semchecker1$simpleIdent simpleList=null;
    // JavaLine 62 ==> SourceLine 68
    public CHECKER1$semchecker1$valuerel valrelList=null;
    // JavaLine 64 ==> SourceLine 69
    public CHECKER1$semchecker1$arithconst aconstList=null;
    // JavaLine 66 ==> SourceLine 71
    public TXT$ etxt1=null;
    public TXT$ etxt2=null;
    // JavaLine 69 ==> SourceLine 94
    public final char IEEXPcl=((char)1);
    // JavaLine 71 ==> SourceLine 95
    public final char IIFcl=((char)2);
    // JavaLine 73 ==> SourceLine 96
    public final char IIFSBcl=((char)3);
    // JavaLine 75 ==> SourceLine 97
    public final char ITOcl=((char)4);
    // JavaLine 77 ==> SourceLine 98
    public final char IACTEcl=((char)5);
    // JavaLine 79 ==> SourceLine 99
    public final char ITEXTcl=((char)6);
    // JavaLine 81 ==> SourceLine 101
    public final char IMXMXcl=((char)6);
    // JavaLine 83 ==> SourceLine 704
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
                CHECKER1$semchecker1 THIS$=(CHECKER1$semchecker1)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 99 ==> SourceLine 2636
                        if(inner!=null) {
                            inner.STM$();
                            TRACE_BEGIN_STM_AFTER_INNER$("semchecker1",2636);
                        }
                        break LOOP$;
                    }
                    catch(LABQNT$ q) {
                        CUR$=THIS$;
                        if(q.SL$!=CUR$ || q.prefixLevel!=2) {
                            CUR$.STATE$=OperationalState.terminated;
                            if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                            throw(q);
                        }
                        if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                        JTX$=q.index; continue LOOP$; // EG. GOTO Lx
                    }
                }
                TRACE_END_STM$("semchecker1",2636);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1 STM$() { return((CHECKER1$semchecker1)CODE$.EXEC$()); }
    public CHECKER1$semchecker1 START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class semchecker1",1,37,11,216,14,40,16,42,18,43,22,44,24,45,26,48,28,49,30,51,32,52,34,53,36,54,38,56,40,57,42,58,44,59,46,60,48,62,51,63,54,64,56,65,58,66,60,67,62,68,64,69,66,71,69,94,71,95,73,96,75,97,77,98,79,99,81,101,83,704,99,2636,123,2636);
}
