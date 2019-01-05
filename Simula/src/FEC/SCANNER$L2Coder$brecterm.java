// JavaLine 1 ==> SourceLine 1693
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:53 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$L2Coder$brecterm extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1693, lastLine=1726, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 1694
    COMMON$brecord inspect$1694$21=null;
    // Normal Constructor
    public SCANNER$L2Coder$brecterm(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("brecterm",1694);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$L2Coder$brecterm STM$() {
        TRACE_BEGIN_STM$("brecterm",1694);
        {
            // BEGIN INSPECTION 
            inspect$1694$21=((SCANNER$L2Coder)(CUR$.SL$)).cbrec;
            if(inspect$1694$21!=null) //INSPECT inspect$1694$21
            // JavaLine 29 ==> SourceLine 1702
            {
                TRACE_BEGIN_STM$("CompoundStatement1702",1702);
                ((SCANNER$L2Coder)(CUR$.SL$)).xquant=inspect$1694$21.fpar;
                // JavaLine 33 ==> SourceLine 1703
                inspect$1694$21.fpar=((COMMON$quantity)(inspect$1694$21.fpar.next));
                // JavaLine 35 ==> SourceLine 1704
                if((((SCANNER$L2Coder)(CUR$.SL$)).xquant.encl==(null))) {
                    // JavaLine 37 ==> SourceLine 1705
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1705",1705);
                        ((SCANNER$L2Coder)(CUR$.SL$)).cquant=null;
                        ((SCANNER$L2Coder)(CUR$.SL$)).cbrec=null;
                        TRACE_END_STM$("CompoundStatement1705",1705);
                    }
                } else
                // JavaLine 45 ==> SourceLine 1707
                {
                    TRACE_BEGIN_STM$("CompoundStatement1707",1707);
                    ((SCANNER$L2Coder)(CUR$.SL$)).cbrec=((SCANNER$L2Coder)(CUR$.SL$)).xquant.encl;
                    // JavaLine 49 ==> SourceLine 1708
                    ((SCANNER$L2Coder)(CUR$.SL$)).cquant=((SCANNER$L2Coder)(CUR$.SL$)).cbrec.fpar;
                    // JavaLine 51 ==> SourceLine 1709
                    while((((SCANNER$L2Coder)(CUR$.SL$)).cquant.next!=(null))) {
                        ((SCANNER$L2Coder)(CUR$.SL$)).cquant=((COMMON$quantity)(((SCANNER$L2Coder)(CUR$.SL$)).cquant.next));
                    }
                    // JavaLine 55 ==> SourceLine 1710
                    ((SCANNER$L2Coder)(CUR$.SL$)).vquant=((SCANNER$L2Coder)(CUR$.SL$)).cbrec.favirt;
                    // JavaLine 57 ==> SourceLine 1711
                    if((((SCANNER$L2Coder)(CUR$.SL$)).vquant!=(null))) {
                        // JavaLine 59 ==> SourceLine 1712
                        while((((SCANNER$L2Coder)(CUR$.SL$)).vquant.next!=(null))) {
                            ((SCANNER$L2Coder)(CUR$.SL$)).vquant=((COMMON$quantity)(((SCANNER$L2Coder)(CUR$.SL$)).vquant.next));
                        }
                    }
                    TRACE_END_STM$("CompoundStatement1707",1712);
                }
                // JavaLine 66 ==> SourceLine 1715
                if((((inspect$1694$21.stmtag!=(((SCANNER)(CUR$.SL$.SL$)).NUL))||((inspect$1694$21.dcltag!=(((SCANNER)(CUR$.SL$.SL$)).NUL))))||((inspect$1694$21.inrtag!=(((SCANNER)(CUR$.SL$.SL$)).NUL))))) {
                    // JavaLine 68 ==> SourceLine 1717
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1717",1717);
                        inspect$1694$21.hasCode=true;
                        // JavaLine 72 ==> SourceLine 1718
                        if(((inspect$1694$21.stmtag!=(((SCANNER)(CUR$.SL$.SL$)).NUL))&&((inspect$1694$21.dcltag!=(((SCANNER)(CUR$.SL$.SL$)).NUL))))) {
                            // JavaLine 74 ==> SourceLine 1719
                            inspect$1694$21.stmtag=((char)3);
                        }
                        // JavaLine 77 ==> SourceLine 1720
                        if((inspect$1694$21.inrtag!=(((SCANNER)(CUR$.SL$.SL$)).NUL))) {
                            // JavaLine 79 ==> SourceLine 1721
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1721",1721);
                                if((inspect$1694$21.stmtag!=(((SCANNER)(CUR$.SL$.SL$)).NUL))) {
                                    // JavaLine 83 ==> SourceLine 1722
                                    inspect$1694$21.inrtag=char$((rank(inspect$1694$21.stmtag)+(1)));
                                } else
                                // JavaLine 86 ==> SourceLine 1723
                                if((inspect$1694$21.dcltag!=(((SCANNER)(CUR$.SL$.SL$)).NUL))) {
                                    inspect$1694$21.inrtag=((char)3);
                                }
                                TRACE_END_STM$("CompoundStatement1721",1723);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement1717",1723);
                    }
                }
                TRACE_END_STM$("CompoundStatement1702",1723);
            }
        }
        TRACE_END_STM$("brecterm",1723);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure brecterm",1,1693,11,1694,29,1702,33,1703,35,1704,37,1705,45,1707,49,1708,51,1709,55,1710,57,1711,59,1712,66,1715,68,1717,72,1718,74,1719,77,1720,79,1721,83,1722,86,1723,102,1726);
}
