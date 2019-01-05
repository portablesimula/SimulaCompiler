// JavaLine 1 ==> SourceLine 1802
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PARSER$grammer$casestat extends PARSER$grammer$statement {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=1802, lastLine=1908, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 1832
    final LABQNT$ REUSE=new LABQNT$(this,1,1); // Local Label #1=REUSE
    final LABQNT$ S0=new LABQNT$(this,1,2); // Local Label #2=S0
    // JavaLine 15 ==> SourceLine 1848
    final LABQNT$ NXTL=new LABQNT$(this,1,3); // Local Label #3=NXTL
    // JavaLine 17 ==> SourceLine 1863
    final LABQNT$ PARSE=new LABQNT$(this,1,4); // Local Label #4=PARSE
    // JavaLine 19 ==> SourceLine 1883
    final LABQNT$ S2=new LABQNT$(this,1,5); // Local Label #5=S2
    // JavaLine 21 ==> SourceLine 1892
    final LABQNT$ S3=new LABQNT$(this,1,6); // Local Label #6=S3
    // Declare locals as attributes
    // JavaLine 24 ==> SourceLine 1804
    public boolean nocolon=false;
    public PRCQNT$ recover$0() { return(new PRCQNT$(this,PARSER$grammer$casestat$recover.class)); }
    // Normal Constructor
    public PARSER$grammer$casestat(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("casestat",1826);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("casestat",1826,inner);
                PARSER$grammer$casestat THIS$=(PARSER$grammer$casestat)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 41 ==> SourceLine 1828
                        detach();
                        // JavaLine 43 ==> SourceLine 1832
                        LABEL$(1); // REUSE
                        LABEL$(2); // S0
                        caller.stmttype=((PARSER$grammer)(CUR$.SL$)).openstmt;
                        // JavaLine 47 ==> SourceLine 1833
                        new PARSER$grammer$casestat$L2output(((PARSER$grammer$casestat)CUR$),((PARSER)(CUR$.SL$.SL$)).NUL);
                        // JavaLine 49 ==> SourceLine 1834
                        errorno=new PARSER$grammer$notBoundPair(((PARSER$grammer)(CUR$.SL$)),((PARSER)(CUR$.SL$.SL$)).IPSPC).RESULT$;
                        if((errorno!=(0))) {
                            GOTO$(PARSE); // GOTO EVALUATED LABEL
                        }
                        // JavaLine 54 ==> SourceLine 1835
                        new PARSER$grammer$casestat$L2output(((PARSER$grammer$casestat)CUR$),((PARSER)(CUR$.SL$.SL$)).IVSPC);
                        // JavaLine 56 ==> SourceLine 1836
                        if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IRGPA))) {
                            // JavaLine 58 ==> SourceLine 1837
                            new PARSER$grammer$ParsWarn(((PARSER$grammer)(CUR$.SL$)),285);
                        } else
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        // JavaLine 62 ==> SourceLine 1838
                        call(((PARSER$grammer)(CUR$.SL$)).ex);
                        // JavaLine 64 ==> SourceLine 1839
                        if(((PARSER$grammer)(CUR$.SL$)).ex.wasNotexpr) {
                            // JavaLine 66 ==> SourceLine 1840
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1840",1840);
                                errorno=1;
                                new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$)),230);
                                GOTO$(PARSE); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1840",1840);
                            }
                        }
                        // JavaLine 75 ==> SourceLine 1841
                        new PARSER$grammer$casestat$L2output(((PARSER$grammer$casestat)CUR$),((PARSER)(CUR$.SL$.SL$)).ICSPC);
                        // JavaLine 77 ==> SourceLine 1842
                        if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IBEGI))) {
                            // JavaLine 79 ==> SourceLine 1843
                            new PARSER$grammer$ParsWarn(((PARSER$grammer)(CUR$.SL$)),435);
                        } else
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        // JavaLine 83 ==> SourceLine 1844
                        while((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IWHEN))) {
                            // JavaLine 85 ==> SourceLine 1845
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1845",1845);
                                ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).ICOMA;
                                // JavaLine 89 ==> SourceLine 1846
                                while((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ICOMA))) {
                                    // JavaLine 91 ==> SourceLine 1847
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1847",1847);
                                        new PARSER$grammer$casestat$L2output(((PARSER$grammer$casestat)CUR$),((PARSER)(CUR$.SL$.SL$)).ILABE);
                                        nocolon=true;
                                        // JavaLine 96 ==> SourceLine 1848
                                        LABEL$(3); // NXTL
                                        ((PARSER$grammer)(CUR$.SL$)).detach();
                                        call(((PARSER$grammer)(CUR$.SL$)).ex);
                                        // JavaLine 100 ==> SourceLine 1849
                                        if(((PARSER$grammer)(CUR$.SL$)).ex.wasNotexpr) {
                                            // JavaLine 102 ==> SourceLine 1850
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1850",1850);
                                                errorno=2;
                                                new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$)),231);
                                                GOTO$(PARSE); // GOTO EVALUATED LABEL
                                                TRACE_END_STM$("CompoundStatement1850",1850);
                                            }
                                        }
                                        // JavaLine 111 ==> SourceLine 1851
                                        if(((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ICL))&&(nocolon))) {
                                            // JavaLine 113 ==> SourceLine 1852
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1852",1852);
                                                new PARSER$grammer$casestat$L2output(((PARSER$grammer$casestat)CUR$),((PARSER)(CUR$.SL$.SL$)).IFRMP);
                                                nocolon=false;
                                                GOTO$(NXTL); // GOTO EVALUATED LABEL
                                                TRACE_END_STM$("CompoundStatement1852",1852);
                                            }
                                        }
                                        // JavaLine 122 ==> SourceLine 1853
                                        new PARSER$grammer$casestat$L2output(((PARSER$grammer$casestat)CUR$),((PARSER)(CUR$.SL$.SL$)).ICPRF);
                                        TRACE_END_STM$("CompoundStatement1847",1853);
                                    }
                                }
                                // JavaLine 127 ==> SourceLine 1855
                                if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IDO))) {
                                    // JavaLine 129 ==> SourceLine 1856
                                    new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$)),206);
                                } else
                                ((PARSER$grammer)(CUR$.SL$)).detach();
                                // JavaLine 133 ==> SourceLine 1857
                                stmtreq=((PARSER$grammer)(CUR$.SL$)).allstmt;
                                rp=((char)1);
                                // JavaLine 136 ==> SourceLine 1859
                                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IROPD;
                                call(((PARSER)(CUR$.SL$.SL$)).coder);
                                // JavaLine 139 ==> SourceLine 1863
                                LABEL$(4); // PARSE
                                detach();
                                // JavaLine 142 ==> SourceLine 1865
                                if((rp!=(((char)1)))) {
                                    // JavaLine 144 ==> SourceLine 1866
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1866",1866);
                                        if((rp==(((PARSER)(CUR$.SL$.SL$)).NUL))) {
                                            GOTO$(S0); // GOTO EVALUATED LABEL
                                        }
                                        // JavaLine 150 ==> SourceLine 1867
                                        if((rp==(((char)3)))) {
                                            GOTO$(S3); // GOTO EVALUATED LABEL
                                        }
                                        TRACE_END_STM$("CompoundStatement1866",1867);
                                    }
                                }
                                // JavaLine 157 ==> SourceLine 1870
                                new PARSER$grammer$casestat$L2output(((PARSER$grammer$casestat)CUR$),((PARSER)(CUR$.SL$.SL$)).ISWIT);
                                // JavaLine 159 ==> SourceLine 1871
                                if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).ISMCL))) {
                                    // JavaLine 161 ==> SourceLine 1872
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1872",1872);
                                        errorno=3;
                                        new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$)),286);
                                        GOTO$(PARSE); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1872",1872);
                                    }
                                }
                                // JavaLine 170 ==> SourceLine 1873
                                ((PARSER$grammer)(CUR$.SL$)).detach();
                                // JavaLine 172 ==> SourceLine 1874
                                if((rp==(((char)2)))) {
                                    GOTO$(S2); // GOTO EVALUATED LABEL
                                }
                                TRACE_END_STM$("CompoundStatement1845",1874);
                            }
                        }
                        // JavaLine 179 ==> SourceLine 1876
                        if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IUPLS))) {
                            // JavaLine 181 ==> SourceLine 1877
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1877",1877);
                                new PARSER$grammer$casestat$L2output(((PARSER$grammer$casestat)CUR$),((PARSER)(CUR$.SL$.SL$)).INONE);
                                // JavaLine 185 ==> SourceLine 1878
                                ((PARSER$grammer)(CUR$.SL$)).detach();
                                // JavaLine 187 ==> SourceLine 1879
                                if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IDO))) {
                                    // JavaLine 189 ==> SourceLine 1880
                                    new PARSER$grammer$ParsWarn(((PARSER$grammer)(CUR$.SL$)),206);
                                } else
                                ((PARSER$grammer)(CUR$.SL$)).detach();
                                // JavaLine 193 ==> SourceLine 1881
                                stmtreq=((PARSER$grammer)(CUR$.SL$)).allstmt;
                                rp=((char)2);
                                GOTO$(PARSE); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1877",1881);
                            }
                        }
                        // JavaLine 200 ==> SourceLine 1883
                        LABEL$(5); // S2
                        while((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ISMCL))) {
                            ((PARSER$grammer)(CUR$.SL$)).detach();
                        }
                        // JavaLine 205 ==> SourceLine 1885
                        if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IEND))) {
                            // JavaLine 207 ==> SourceLine 1886
                            new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$)),436);
                        } else
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        // JavaLine 211 ==> SourceLine 1887
                        if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IOTHW))) {
                            // JavaLine 213 ==> SourceLine 1888
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1888",1888);
                                new PARSER$grammer$casestat$L2output(((PARSER$grammer$casestat)CUR$),((PARSER)(CUR$.SL$.SL$)).IVALU);
                                // JavaLine 217 ==> SourceLine 1889
                                ((PARSER$grammer)(CUR$.SL$)).detach();
                                // JavaLine 219 ==> SourceLine 1890
                                stmtreq=((PARSER$grammer)(CUR$.SL$)).allstmt;
                                rp=((char)3);
                                GOTO$(PARSE); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1888",1890);
                            }
                        }
                        // JavaLine 226 ==> SourceLine 1892
                        LABEL$(6); // S3
                        new PARSER$grammer$casestat$L2output(((PARSER$grammer$casestat)CUR$),((PARSER)(CUR$.SL$.SL$)).IEPRM);
                        // JavaLine 229 ==> SourceLine 1895
                        caller.next=null;
                        ((PARSER$grammer)(CUR$.SL$)).last=caller;
                        // JavaLine 232 ==> SourceLine 1898
                        detach();
                        // JavaLine 234 ==> SourceLine 1828
                        if(inner!=null) {
                            inner.STM$();
                            TRACE_BEGIN_STM_AFTER_INNER$("casestat",1828);
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
                TRACE_END_STM$("casestat",1828);
            }
        };
    } // End of Constructor
    // Class Statements
    public PARSER$grammer$casestat STM$() { return((PARSER$grammer$casestat)CODE$.EXEC$()); }
    public PARSER$grammer$casestat START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Class casestat",1,1802,12,1832,15,1848,17,1863,19,1883,21,1892,24,1804,41,1828,43,1832,47,1833,49,1834,54,1835,56,1836,58,1837,62,1838,64,1839,66,1840,75,1841,77,1842,79,1843,83,1844,85,1845,89,1846,91,1847,96,1848,100,1849,102,1850,111,1851,113,1852,122,1853,127,1855,129,1856,133,1857,136,1859,139,1863,142,1865,144,1866,150,1867,157,1870,159,1871,161,1872,170,1873,172,1874,179,1876,181,1877,185,1878,187,1879,189,1880,193,1881,200,1883,205,1885,207,1886,211,1887,213,1888,217,1889,219,1890,226,1892,229,1895,232,1898,234,1828,258,1908);
}
