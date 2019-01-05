// JavaLine 1 ==> SourceLine 1332
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 15:03:20 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$attrfile$swapIbuffer extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1332, lastLine=1343, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 1333
    int bufsize=0;
    // JavaLine 13 ==> SourceLine 1337
    InbyteFile$ inspect$1337$5=null;
    // Normal Constructor
    public COMMON$attrfile$swapIbuffer(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("swapIbuffer",1337);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public COMMON$attrfile$swapIbuffer STM$() {
        TRACE_BEGIN_STM$("swapIbuffer",1337);
        // JavaLine 27 ==> SourceLine 1334
        ((COMMON$attrfile)(CUR$.SL$)).xidentstring=copy(copy(((COMMON$attrfile)(CUR$.SL$)).xidentstring));
        // JavaLine 29 ==> SourceLine 1337
        {
            // BEGIN INSPECTION 
            inspect$1337$5=((COMMON$attrfile)(CUR$.SL$)).CURF;
            if(inspect$1337$5!=null) //INSPECT inspect$1337$5
            // JavaLine 34 ==> SourceLine 1338
            {
                TRACE_BEGIN_STM$("CompoundStatement1338",1338);
                if(inspect$1337$5.endfile()) {
                    // JavaLine 38 ==> SourceLine 1339
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1339",1339);
                        ((COMMON)(CUR$.SL$.SL$)).diag.Elt[0-((COMMON)(CUR$.SL$.SL$)).diag.LB[0]]=inspect$1337$5.filename();
                        ((COMMON)(CUR$.SL$.SL$)).COMMONerror$0().CPF().setPar(307).ENT$();
                        TRACE_END_STM$("CompoundStatement1339",1339);
                    }
                }
                // JavaLine 46 ==> SourceLine 1340
                bufsize=new COMMON$attrfile$nextNumber(((COMMON$attrfile)(CUR$.SL$))).RESULT$;
                // JavaLine 48 ==> SourceLine 1341
                inspect$1337$5.intext(TXT$.sub(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,1,bufsize));
                ((COMMON$attrfile)(CUR$.SL$)).p=0;
                TRACE_END_STM$("CompoundStatement1338",1341);
            }
        }
        TRACE_END_STM$("swapIbuffer",1341);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure swapIbuffer",1,1332,11,1333,13,1337,27,1334,29,1337,34,1338,38,1339,46,1340,48,1341,57,1343);
}
