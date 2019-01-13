// JavaLine 1 ==> SourceLine 662
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$textconc$insert extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=662, lastLine=674, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 663
    CHECKER1$semchecker1$exp op=null;
    // Normal Constructor
    public CHECKER1$semchecker1$textconc$insert(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("insert",663);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$textconc$insert STM$() {
        TRACE_BEGIN_STM$("insert",663);
        op=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).exptop;
        // JavaLine 26 ==> SourceLine 664
        while((op.p$ch==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IRGPA))) {
            // JavaLine 28 ==> SourceLine 665
            op=((CHECKER1$semchecker1$expinparantes)(op)).p1$right;
        }
        // JavaLine 31 ==> SourceLine 666
        if((op.p$ch==(((CHECKER1)(CUR$.SL$.SL$.SL$)).ICONC))) {
            // JavaLine 33 ==> SourceLine 667
            {
                TRACE_BEGIN_STM$("CompoundStatement667",667);
                ((CHECKER1$semchecker1$textconc)(CUR$.SL$)).ntext=(((CHECKER1$semchecker1$textconc)(CUR$.SL$)).ntext+(((CHECKER1$semchecker1$textconc)(op)).ntext));
                // JavaLine 37 ==> SourceLine 668
                ((CHECKER1$semchecker1$textconc)(CUR$.SL$)).last.next=((CHECKER1$semchecker1$textconc)(op)).first;
                // JavaLine 39 ==> SourceLine 669
                ((CHECKER1$semchecker1$textconc)(CUR$.SL$)).last=((CHECKER1$semchecker1$textconc)(op)).last;
                TRACE_END_STM$("CompoundStatement667",669);
            }
        } else
        // JavaLine 44 ==> SourceLine 671
        {
            TRACE_BEGIN_STM$("CompoundStatement671",671);
            ((CHECKER1$semchecker1$textconc)(CUR$.SL$)).ntext=(((CHECKER1$semchecker1$textconc)(CUR$.SL$)).ntext+(1));
            // JavaLine 48 ==> SourceLine 672
            ((CHECKER1$semchecker1$textconc)(CUR$.SL$)).last=((CHECKER1$semchecker1$textconc)(CUR$.SL$)).last.next=new CHECKER1$semchecker1$textoperand(((CHECKER1$semchecker1)(CUR$.SL$.SL$)),op).STM$();
            TRACE_END_STM$("CompoundStatement671",672);
        }
        TRACE_END_STM$("insert",672);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure insert",1,662,11,663,26,664,28,665,31,666,33,667,37,668,39,669,44,671,48,672,55,674);
}
