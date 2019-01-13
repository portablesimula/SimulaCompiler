// JavaLine 1 ==> SourceLine 42
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Jan 12 15:31:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst100$testputget$expcom extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=42, lastLine=50, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 43
    TXT$ t1=null;
    TXT$ t2=null;
    // Normal Constructor
    public simtst100$testputget$expcom(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("expcom",43);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst100$testputget$expcom STM$() {
        TRACE_BEGIN_STM$("expcom",43);
        TXT$.setpos(((simtst100)(CUR$.SL$.SL$)).t,1);
        TXT$.setpos(((simtst100)(CUR$.SL$.SL$)).prevt,1);
        // JavaLine 31 ==> SourceLine 44
        while((TXT$.getchar(((simtst100)(CUR$.SL$.SL$)).t)!=('&'))) {
        }
        // JavaLine 34 ==> SourceLine 45
        t1=TXT$.sub(((simtst100)(CUR$.SL$.SL$)).t,TXT$.pos(((simtst100)(CUR$.SL$.SL$)).t),((TXT$.length(((simtst100)(CUR$.SL$.SL$)).t)-(TXT$.pos(((simtst100)(CUR$.SL$.SL$)).t)))+(1)));
        // JavaLine 36 ==> SourceLine 46
        while((TXT$.getchar(((simtst100)(CUR$.SL$.SL$)).prevt)!=('&'))) {
        }
        // JavaLine 39 ==> SourceLine 47
        t2=TXT$.sub(((simtst100)(CUR$.SL$.SL$)).prevt,TXT$.pos(((simtst100)(CUR$.SL$.SL$)).prevt),((TXT$.length(((simtst100)(CUR$.SL$.SL$)).prevt)-(TXT$.pos(((simtst100)(CUR$.SL$.SL$)).prevt)))+(1)));
        // JavaLine 41 ==> SourceLine 48
        RESULT$=((((simtst100$testputget)(CUR$.SL$)).p$up)?((TXT$.getint(t1)<=(TXT$.getint(t2)))):((TXT$.getint(t1)>=(TXT$.getint(t2)))));
        TRACE_END_STM$("expcom",48);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst100.sim","Procedure expcom",1,42,14,43,31,44,34,45,36,46,39,47,41,48,46,50);
}
