// JavaLine 1 ==> SourceLine 1301
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 15:03:20 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$attrfile$gettext extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1301, lastLine=1330, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 1303
    final LABQNT$ REP=new LABQNT$(this,0,1); // Local Label #1=REP
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 1302
    int tlength=0;
    // JavaLine 16 ==> SourceLine 1322
    InbyteFile$ inspect$1322$4=null;
    // Normal Constructor
    public COMMON$attrfile$gettext(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("gettext",1322);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public COMMON$attrfile$gettext STM$() {
        TRACE_BEGIN_STM$("gettext",1322);
        COMMON$attrfile$gettext THIS$=(COMMON$attrfile$gettext)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 34 ==> SourceLine 1303
                LABEL$(1); // REP
                new COMMON$attrfile$nextKey(((COMMON$attrfile)(CUR$.SL$)));
                // JavaLine 37 ==> SourceLine 1304
                if((((COMMON$attrfile)(CUR$.SL$)).key<(((COMMON$attrfile)(CUR$.SL$)).lowKey))) {
                    // JavaLine 39 ==> SourceLine 1305
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1305",1305);
                        ((COMMON)(CUR$.SL$.SL$)).simsymbol=TXT$.sub(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,(((COMMON$attrfile)(CUR$.SL$)).p+(1)),rank(((COMMON$attrfile)(CUR$.SL$)).key));
                        // JavaLine 43 ==> SourceLine 1306
                        ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(rank(((COMMON$attrfile)(CUR$.SL$)).key)));
                        TRACE_END_STM$("CompoundStatement1305",1306);
                    }
                } else
                // JavaLine 48 ==> SourceLine 1314
                {
                    TRACE_BEGIN_STM$("CompoundStatement1314",1314);
                    if((((COMMON$attrfile)(CUR$.SL$)).key==(((COMMON$attrfile)(CUR$.SL$)).longText))) {
                        // JavaLine 52 ==> SourceLine 1315
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1315",1315);
                            tlength=new COMMON$attrfile$nextNumber(((COMMON$attrfile)(CUR$.SL$))).RESULT$;
                            // JavaLine 56 ==> SourceLine 1316
                            ((COMMON)(CUR$.SL$.SL$)).simsymbol=TXT$.sub(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,(((COMMON$attrfile)(CUR$.SL$)).p+(1)),tlength);
                            // JavaLine 58 ==> SourceLine 1317
                            ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(tlength));
                            TRACE_END_STM$("CompoundStatement1315",1317);
                        }
                    } else
                    // JavaLine 63 ==> SourceLine 1320
                    if((((COMMON$attrfile)(CUR$.SL$)).key==(((COMMON$attrfile)(CUR$.SL$)).longSwap))) {
                        // JavaLine 65 ==> SourceLine 1322
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1322",1322);
                            {
                                // BEGIN INSPECTION 
                                inspect$1322$4=((COMMON$attrfile)(CUR$.SL$)).CURF;
                                if(inspect$1322$4!=null) //INSPECT inspect$1322$4
                                // JavaLine 72 ==> SourceLine 1323
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1323",1323);
                                    tlength=new COMMON$attrfile$nextNumber(((COMMON$attrfile)(CUR$.SL$))).RESULT$;
                                    ((COMMON)(CUR$.SL$.SL$)).simsymbol=blanks(tlength);
                                    // JavaLine 77 ==> SourceLine 1324
                                    ((COMMON)(CUR$.SL$.SL$)).simsymbol=inspect$1322$4.intext(((COMMON)(CUR$.SL$.SL$)).simsymbol);
                                    // JavaLine 79 ==> SourceLine 1325
                                    tlength=((inspect$1322$4.inbyte()*(256))+(inspect$1322$4.inbyte()));
                                    // JavaLine 81 ==> SourceLine 1326
                                    inspect$1322$4.intext(TXT$.sub(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,1,tlength));
                                    ((COMMON$attrfile)(CUR$.SL$)).p=0;
                                    TRACE_END_STM$("CompoundStatement1323",1326);
                                }
                            }
                            TRACE_END_STM$("CompoundStatement1322",1326);
                        }
                    } else
                    // JavaLine 90 ==> SourceLine 1328
                    new COMMON$attrfile$wrongLayout(((COMMON$attrfile)(CUR$.SL$)));
                    TRACE_END_STM$("CompoundStatement1314",1328);
                }
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
        TRACE_END_STM$("gettext",1328);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure gettext",1,1301,11,1303,14,1302,16,1322,34,1303,37,1304,39,1305,43,1306,48,1314,52,1315,56,1316,58,1317,63,1320,65,1322,72,1323,77,1324,79,1325,81,1326,90,1328,110,1330);
}
