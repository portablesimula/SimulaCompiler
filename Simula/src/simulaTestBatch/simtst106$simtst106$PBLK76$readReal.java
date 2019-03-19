// JavaLine 1 ==> SourceLine 154
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Mon Mar 18 11:16:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst106$simtst106$PBLK76$readReal extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=154, lastLine=159, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public float RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 155
    float r=0.0f;
    // Normal Constructor
    public simtst106$simtst106$PBLK76$readReal(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("readReal",155);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst106$simtst106$PBLK76$readReal STM$() {
        TRACE_BEGIN_STM$("readReal",155);
        // JavaLine 28 ==> SourceLine 156
        r=((float)(((simtst106)(CUR$.SL$.SL$)).inspect$20$0.inint()));
        // JavaLine 30 ==> SourceLine 157
        sysout().outtext(new TXT$("REAL: "));
        sysout().outreal(r,4,18);
        new simtst106$simtst106$PBLK76$Outimage(((simtst106$PBLK76)(CUR$.SL$)));
        // JavaLine 34 ==> SourceLine 158
        RESULT$=r;
        TRACE_END_STM$("readReal",158);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst106.sim","Procedure readReal",1,154,14,155,28,156,30,157,34,158,39,159);
}
