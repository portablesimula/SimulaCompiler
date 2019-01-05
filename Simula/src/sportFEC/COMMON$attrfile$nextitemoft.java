// JavaLine 1 ==> SourceLine 1358
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:41:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$attrfile$nextitemoft extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1358, lastLine=1367, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 14 ==> SourceLine 1362
    final LABQNT$ ubl=new LABQNT$(this,0,1); // Local Label #1=ubl
    // JavaLine 16 ==> SourceLine 1365
    final LABQNT$ bl=new LABQNT$(this,0,2); // Local Label #2=bl
    // JavaLine 18 ==> SourceLine 1367
    final LABQNT$ E=new LABQNT$(this,0,3); // Local Label #3=E
    // Declare locals as attributes
    // JavaLine 21 ==> SourceLine 1359
    int i=0;
    int j=0;
    // Normal Constructor
    public COMMON$attrfile$nextitemoft(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("nextitemoft",1359);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public COMMON$attrfile$nextitemoft STM$() {
        TRACE_BEGIN_STM$("nextitemoft",1359);
        COMMON$attrfile$nextitemoft THIS$=(COMMON$attrfile$nextitemoft)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 40 ==> SourceLine 1360
                while(TXT$.more(((COMMON)(CUR$.SL$.SL$)).permt)) {
                    if((TXT$.getchar(((COMMON)(CUR$.SL$.SL$)).permt)!=(((char)32)))) {
                        GOTO$(ubl); // GOTO EVALUATED LABEL
                    }
                }
                // JavaLine 46 ==> SourceLine 1361
                RESULT$=null;
                GOTO$(E); // GOTO EVALUATED LABEL
                // JavaLine 49 ==> SourceLine 1362
                LABEL$(1); // ubl
                i=(TXT$.pos(((COMMON)(CUR$.SL$.SL$)).permt)-(1));
                j=1;
                // JavaLine 53 ==> SourceLine 1363
                while(TXT$.more(((COMMON)(CUR$.SL$.SL$)).permt)) {
                    // JavaLine 55 ==> SourceLine 1364
                    if((TXT$.getchar(((COMMON)(CUR$.SL$.SL$)).permt)==(((char)32)))) {
                        GOTO$(bl); // GOTO EVALUATED LABEL
                    } else
                    j=(j+(1));
                }
                // JavaLine 61 ==> SourceLine 1365
                LABEL$(2); // bl
                RESULT$=TXT$.sub(((COMMON)(CUR$.SL$.SL$)).permt,i,j);
                // JavaLine 64 ==> SourceLine 1366
                if(TXTREL$EQ(TXT$.sub(((COMMON)(CUR$.SL$.SL$)).permt,i,j),new TXT$("*"))) {
                    RESULT$=null;
                }
                // JavaLine 68 ==> SourceLine 1367
                LABEL$(3); // E
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$ || q.prefixLevel!=0) {
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("nextitemoft",1367);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure nextitemoft",1,1358,14,1362,16,1365,18,1367,21,1359,40,1360,46,1361,49,1362,53,1363,55,1364,61,1365,64,1366,68,1367,86,1367);
}
