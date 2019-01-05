// JavaLine 1 ==> SourceLine 1702
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PARSER$grammer$inspectstat extends PARSER$grammer$statement {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=1702, lastLine=1791, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 1718
    final LABQNT$ REUSE=new LABQNT$(this,1,1); // Local Label #1=REUSE
    // JavaLine 14 ==> SourceLine 1722
    final LABQNT$ S0=new LABQNT$(this,1,2); // Local Label #2=S0
    // JavaLine 16 ==> SourceLine 1736
    final LABQNT$ PARSE=new LABQNT$(this,1,3); // Local Label #3=PARSE
    // JavaLine 18 ==> SourceLine 1745
    final LABQNT$ S1=new LABQNT$(this,1,4); // Local Label #4=S1
    // JavaLine 20 ==> SourceLine 1762
    final LABQNT$ S2=new LABQNT$(this,1,5); // Local Label #5=S2
    // JavaLine 22 ==> SourceLine 1769
    final LABQNT$ S3=new LABQNT$(this,1,6); // Local Label #6=S3
    // JavaLine 24 ==> SourceLine 1774
    final LABQNT$ ENDINSP=new LABQNT$(this,1,7); // Local Label #7=ENDINSP
    // Declare locals as attributes
    // JavaLine 27 ==> SourceLine 1704
    public boolean firstwhen=false;
    public boolean iothwsent=false;
    public boolean enclgen=false;
    public PRCQNT$ recover$0() { return(new PRCQNT$(this,PARSER$grammer$inspectstat$recover.class)); }
    // Normal Constructor
    public PARSER$grammer$inspectstat(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("inspectstat",1712);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("inspectstat",1712,inner);
                PARSER$grammer$inspectstat THIS$=(PARSER$grammer$inspectstat)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 46 ==> SourceLine 1715
                        detach();
                        // JavaLine 48 ==> SourceLine 1720
                        LABEL$(1); // REUSE
                        // JavaLine 50 ==> SourceLine 1718
                        if(((((PARSER$grammer)(CUR$.SL$)).blockfound==(0))&&((((PARSER)(CUR$.SL$.SL$)).dummygen|((!(((PARSER)(CUR$.SL$.SL$)).separatecomp))))))) {
                            // JavaLine 52 ==> SourceLine 1719
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1719",1719);
                                enclgen=true;
                                ((PARSER$grammer)(CUR$.SL$)).blockfound=1;
                                // JavaLine 57 ==> SourceLine 1720
                                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IBLKB;
                                call(((PARSER)(CUR$.SL$.SL$)).coder);
                                TRACE_END_STM$("CompoundStatement1719",1720);
                            }
                        }
                        // JavaLine 63 ==> SourceLine 1722
                        LABEL$(2); // S0
                        caller.stmttype=((PARSER$grammer)(CUR$.SL$)).openstmt;
                        // JavaLine 66 ==> SourceLine 1723
                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IINSP;
                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                        // JavaLine 69 ==> SourceLine 1724
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        // JavaLine 71 ==> SourceLine 1725
                        call(((PARSER$grammer)(CUR$.SL$)).ex);
                        // JavaLine 73 ==> SourceLine 1726
                        if(((PARSER$grammer)(CUR$.SL$)).ex.wasNotexpr) {
                            // JavaLine 75 ==> SourceLine 1727
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1727",1727);
                                errorno=1;
                                new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$)),205);
                                GOTO$(PARSE); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1727",1727);
                            }
                        }
                        // JavaLine 84 ==> SourceLine 1728
                        if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IWHEN))) {
                            firstwhen=true;
                        } else
                        // JavaLine 88 ==> SourceLine 1730
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1730",1730);
                            if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IDO))) {
                                // JavaLine 92 ==> SourceLine 1731
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1731",1731);
                                    ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).ICONB;
                                    call(((PARSER)(CUR$.SL$.SL$)).coder);
                                    // JavaLine 97 ==> SourceLine 1732
                                    ((PARSER$grammer)(CUR$.SL$)).detach();
                                    // JavaLine 99 ==> SourceLine 1733
                                    stmtreq=((PARSER$grammer)(CUR$.SL$)).allstmt;
                                    rp=((char)2);
                                    TRACE_END_STM$("CompoundStatement1731",1733);
                                }
                            } else
                            // JavaLine 105 ==> SourceLine 1734
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1734",1734);
                                errorno=2;
                                new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$)),211);
                                TRACE_END_STM$("CompoundStatement1734",1734);
                            }
                            // JavaLine 112 ==> SourceLine 1736
                            LABEL$(3); // PARSE
                            detach();
                            // JavaLine 115 ==> SourceLine 1738
                            switch(rp) { // BEGIN SWITCH STATEMENT
                            case 0: 
                            // JavaLine 118 ==> SourceLine 1739
                            GOTO$(S0); // GOTO EVALUATED LABEL
                            case 2: 
                            // JavaLine 121 ==> SourceLine 1740
                            GOTO$(S2); // GOTO EVALUATED LABEL
                            case 3: 
                            // JavaLine 124 ==> SourceLine 1741
                            GOTO$(S3); // GOTO EVALUATED LABEL
                        } // END SWITCH STATEMENT
                        TRACE_END_STM$("CompoundStatement1730",1741);
                    }
                    // JavaLine 129 ==> SourceLine 1759
                    LABEL$(4); // S1
                    // JavaLine 131 ==> SourceLine 1745
                    while((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IWHEN))) {
                        // JavaLine 133 ==> SourceLine 1746
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1746",1746);
                            ((PARSER$grammer)(CUR$.SL$)).detach();
                            // JavaLine 137 ==> SourceLine 1747
                            if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IIDN))) {
                                // JavaLine 139 ==> SourceLine 1748
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1748",1748);
                                    errorno=3;
                                    new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$)),185);
                                    GOTO$(PARSE); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1748",1748);
                                }
                            }
                            // JavaLine 148 ==> SourceLine 1749
                            if(firstwhen) {
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1749",1749);
                                    ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IFWHN;
                                    firstwhen=false;
                                    TRACE_END_STM$("CompoundStatement1749",1749);
                                }
                            } else
                            // JavaLine 157 ==> SourceLine 1750
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IWHEN;
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            // JavaLine 160 ==> SourceLine 1751
                            if((((PARSER)(CUR$.SL$.SL$)).opt!=(((PARSER)(CUR$.SL$.SL$)).IDO))) {
                                // JavaLine 162 ==> SourceLine 1752
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1752",1752);
                                    ((PARSER$grammer)(CUR$.SL$)).getopt=false;
                                    ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).opt;
                                    // JavaLine 167 ==> SourceLine 1753
                                    errorno=4;
                                    new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$)),206);
                                    TRACE_END_STM$("CompoundStatement1752",1753);
                                }
                            } else
                            // JavaLine 173 ==> SourceLine 1755
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1755",1755);
                                ((PARSER$grammer)(CUR$.SL$)).detach();
                                // JavaLine 177 ==> SourceLine 1756
                                stmtreq=((PARSER$grammer)(CUR$.SL$)).allstmt;
                                rp=((char)1);
                                TRACE_END_STM$("CompoundStatement1755",1756);
                            }
                            // JavaLine 182 ==> SourceLine 1758
                            GOTO$(PARSE); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1746",1758);
                        }
                    }
                    // JavaLine 187 ==> SourceLine 1771
                    LABEL$(5); // S2
                    // JavaLine 189 ==> SourceLine 1762
                    if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IOTHW))) {
                        // JavaLine 191 ==> SourceLine 1763
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1763",1763);
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IOTHW;
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            // JavaLine 196 ==> SourceLine 1764
                            ((PARSER$grammer)(CUR$.SL$)).detach();
                            // JavaLine 198 ==> SourceLine 1765
                            iothwsent=true;
                            // JavaLine 200 ==> SourceLine 1766
                            stmtreq=((PARSER$grammer)(CUR$.SL$)).allstmt;
                            rp=((char)3);
                            GOTO$(PARSE); // GOTO EVALUATED LABEL
                            // JavaLine 204 ==> SourceLine 1769
                            LABEL$(6); // S3
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IOTHE;
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            // JavaLine 208 ==> SourceLine 1770
                            GOTO$(ENDINSP); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1763",1770);
                        }
                    }
                    // JavaLine 213 ==> SourceLine 1773
                    ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).ICONE;
                    call(((PARSER)(CUR$.SL$.SL$)).coder);
                    // JavaLine 216 ==> SourceLine 1775
                    LABEL$(7); // ENDINSP
                    // JavaLine 218 ==> SourceLine 1774
                    if(enclgen) {
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1774",1774);
                            enclgen=false;
                            // JavaLine 223 ==> SourceLine 1775
                            ((PARSER$grammer)(CUR$.SL$)).blockfound=0;
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IEND;
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            TRACE_END_STM$("CompoundStatement1774",1775);
                        }
                    }
                    // JavaLine 230 ==> SourceLine 1778
                    caller.next=null;
                    ((PARSER$grammer)(CUR$.SL$)).last=caller;
                    // JavaLine 233 ==> SourceLine 1779
                    ((PARSER$grammer)(CUR$.SL$)).itList=((PARSER$grammer$statement)CUR$);
                    // JavaLine 235 ==> SourceLine 1781
                    detach();
                    // JavaLine 237 ==> SourceLine 1784
                    ((PARSER$grammer)(CUR$.SL$)).itList=null;
                    // JavaLine 239 ==> SourceLine 1785
                    errorno=0;
                    // JavaLine 241 ==> SourceLine 1786
                    firstwhen=iothwsent=enclgen=recovered=isblocklike=false;
                    // JavaLine 243 ==> SourceLine 1788
                    rp=blockstatus=stmtreq=stmttype=((PARSER)(CUR$.SL$.SL$)).NUL;
                    // JavaLine 245 ==> SourceLine 1789
                    GOTO$(REUSE); // GOTO EVALUATED LABEL
                    // JavaLine 247 ==> SourceLine 1715
                    if(inner!=null) {
                        inner.STM$();
                        TRACE_BEGIN_STM_AFTER_INNER$("inspectstat",1715);
                    }
                    break LOOP$;
                }
                catch(LABQNT$ q) {
                    CUR$=THIS$;
                    if(q.SL$!=CUR$ || q.prefixLevel!=1) {
                        CUR$.STATE$=OperationalState.terminated;
                        if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                        throw(q);
                    }
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                    JTX$=q.index; continue LOOP$; // EG. GOTO Lx
                }
            }
            TRACE_END_STM$("inspectstat",1715);
        }
    };
} // End of Constructor
// Class Statements
public PARSER$grammer$inspectstat STM$() { return((PARSER$grammer$inspectstat)CODE$.EXEC$()); }
public PARSER$grammer$inspectstat START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Class inspectstat",1,1702,12,1718,14,1722,16,1736,18,1745,20,1762,22,1769,24,1774,27,1704,46,1715,48,1720,50,1718,52,1719,57,1720,63,1722,66,1723,69,1724,71,1725,73,1726,75,1727,84,1728,88,1730,92,1731,97,1732,99,1733,105,1734,112,1736,115,1738,118,1739,121,1740,124,1741,129,1759,131,1745,133,1746,137,1747,139,1748,148,1749,157,1750,160,1751,162,1752,167,1753,173,1755,177,1756,182,1758,187,1771,189,1762,191,1763,196,1764,198,1765,200,1766,204,1769,208,1770,213,1773,216,1775,218,1774,223,1775,230,1778,233,1779,235,1781,237,1784,239,1785,241,1786,243,1788,245,1789,247,1715,271,1791);
}
