// JavaLine 1 ==> SourceLine 1751
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:44:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$L2Coder$outbuffer extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1751, lastLine=1771, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 1752
    TXT$ fname=null;
    // Normal Constructor
    public SCANNER$L2Coder$outbuffer(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("outbuffer",1752);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$L2Coder$outbuffer STM$() {
        TRACE_BEGIN_STM$("outbuffer",1752);
        // JavaLine 25 ==> SourceLine 1761
        storeChar(((SCANNER)(CUR$.SL$.SL$)).IEXNM,((SCANNER$L2Coder)(CUR$.SL$)).L2buf,((SCANNER$L2Coder)(CUR$.SL$)).L2p);
        // JavaLine 27 ==> SourceLine 1762
        if((((SCANNER)(CUR$.SL$.SL$)).L2OUPT==(null))) {
            // JavaLine 29 ==> SourceLine 1764
            {
                TRACE_BEGIN_STM$("CompoundStatement1764",1764);
                ((SCANNER$L2Coder)(CUR$.SL$)).setaccess(new TXT$("%NOBUFFER"));
                // JavaLine 33 ==> SourceLine 1765
                if((!(((SCANNER$L2Coder)(CUR$.SL$)).open()))) {
                    // JavaLine 35 ==> SourceLine 1766
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1766",1766);
                        fname=((SCANNER$L2Coder)(CUR$.SL$)).filename();
                        new ERRMSG$openerror(((SCANNER)(CUR$.SL$.SL$)),fname);
                        TRACE_END_STM$("CompoundStatement1766",1766);
                    }
                }
                // JavaLine 43 ==> SourceLine 1767
                ((SCANNER)(CUR$.SL$.SL$)).L2OUPT=((OutbyteFile$)CTX$);
                TRACE_END_STM$("CompoundStatement1764",1767);
            }
        }
        // JavaLine 48 ==> SourceLine 1769
        ((SCANNER$L2Coder)(CUR$.SL$)).outtext(((SCANNER$L2Coder)(CUR$.SL$)).L2buf);
        // JavaLine 50 ==> SourceLine 1770
        ((SCANNER$L2Coder)(CUR$.SL$)).L2p=0;
        TRACE_END_STM$("outbuffer",1770);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure outbuffer",1,1751,11,1752,25,1761,27,1762,29,1764,33,1765,35,1766,43,1767,48,1769,50,1770,55,1771);
}
