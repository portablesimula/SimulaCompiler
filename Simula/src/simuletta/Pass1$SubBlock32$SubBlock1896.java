// JavaLine 1 <== SourceLine 1896
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 17:50:19 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$SubBlock1896 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=1896, lastLine=1943, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 1927
    final LABQNT$ SKIP=new LABQNT$(this,1,"SKIP"); // Local Label #1=SKIP
    // JavaLine 11 <== SourceLine 1932
    final LABQNT$ E=new LABQNT$(this,2,"E"); // Local Label #2=E
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 1896
    final TXT$ smlid=(TXT$)(new TXT$("S-PORT SIMULETTA"));
    // JavaLine 16 <== SourceLine 1898
    TXT$ listid=null;
    // JavaLine 18 <== SourceLine 1899
    TXT$ s=null;
    TXT$ select=null;
    // JavaLine 21 <== SourceLine 1900
    int n=0;
    char ch=0;
    boolean inOpt=false;
    // Normal Constructor
    public Pass1$SubBlock32$SubBlock1896(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Pass1$SubBlock32$SubBlock1896 THIS$=(Pass1$SubBlock32$SubBlock1896)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 37 <== SourceLine 1902
                ((Pass1$SubBlock32)(CUR$.SL$)).source_file=getTextInfo(1);
                ;
                // JavaLine 40 <== SourceLine 1903
                listid=getTextInfo(2);
                ;
                // JavaLine 43 <== SourceLine 1904
                ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.L2name$1=getTextInfo(7);
                ;
                // JavaLine 46 <== SourceLine 1905
                ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.nscodename$1=getTextInfo(4);
                ;
                // JavaLine 49 <== SourceLine 1906
                select=getTextInfo(16);
                ;
                // JavaLine 52 <== SourceLine 1908
                if(VALUE$(TRF_EQ(listid,null))) {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=null;
                } else
                // JavaLine 56 <== SourceLine 1909
                if(VALUE$(TXTREL$EQ(lowcase(copy(copy(listid))),new TXT$("sysout")))) {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=sysout();
                } else
                // JavaLine 60 <== SourceLine 1911
                {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=new PrintFile$(((BASICIO$)CTX$),listid).STM$();
                    ;
                    // JavaLine 64 <== SourceLine 1912
                    if(VALUE$((!(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1.open(blanks(132)))))) {
                        // JavaLine 66 <== SourceLine 1913
                        {
                            // JavaLine 68 <== SourceLine 1914
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(CONC(CONC(new TXT$("*** NB: Cannot open listing file"),listid),new TXT$(" - listing deleted ***")));
                            ;
                            // JavaLine 71 <== SourceLine 1915
                            sysout().outimage();
                            ;
                            ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=null;
                            ;
                        }
                    }
                    ;
                }
                ;
                // JavaLine 81 <== SourceLine 1918
                while(TXT$.more(select)) {
                    // JavaLine 83 <== SourceLine 1919
                    {
                        ch=TXT$.getchar(select);
                        ;
                        // JavaLine 87 <== SourceLine 1920
                        if(VALUE$((ch>('Z')))) {
                            // JavaLine 89 <== SourceLine 1921
                            {
                                if(VALUE$((ch>('z')))) {
                                    GOTO$(SKIP); // GOTO EVALUATED LABEL
                                }
                                ;
                                // JavaLine 95 <== SourceLine 1922
                                ch=char$(Math.subtractExact(rank(ch),90));
                            }
                        }
                        ;
                        // JavaLine 100 <== SourceLine 1923
                        if(VALUE$((ch==(':')))) {
                            inOpt=true;
                        } else
                        // JavaLine 104 <== SourceLine 1924
                        if(VALUE$((ch==(((char)32))))) {
                            // JavaLine 106 <== SourceLine 1925
                            GOTO$(E); // GOTO EVALUATED LABEL
                        } else
                        if(VALUE$(inOpt)) {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.option.Elt[rank(ch)-((Pass1)(CUR$.SL$.SL$)).inspect$28$62.option.LB[0]]=1;
                        } else
                        // JavaLine 112 <== SourceLine 1926
                        ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.Selector.Elt[rank(ch)-((Pass1)(CUR$.SL$.SL$)).inspect$28$62.Selector.LB[0]]=true;
                        ;
                        // JavaLine 115 <== SourceLine 1927
                        LABEL$(1,"SKIP");
                        ;
                    }
                }
                ;
                // JavaLine 121 <== SourceLine 1942
                LABEL$(2,"E");
                // JavaLine 123 <== SourceLine 1932
                {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(smlid);
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$(" (trace)"));
                    ;
                    // JavaLine 129 <== SourceLine 1933
                    sysout().outimage();
                    ;
                    // JavaLine 132 <== SourceLine 1934
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("Source file:  "));
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(((Pass1$SubBlock32)(CUR$.SL$)).source_file);
                    ;
                    sysout().outimage();
                    ;
                    // JavaLine 139 <== SourceLine 1935
                    if(VALUE$(TRF_NE(select,null))) {
                        // JavaLine 141 <== SourceLine 1936
                        {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("Selection:    "));
                            ;
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(select);
                            ;
                            sysout().outimage();
                        }
                    }
                    ;
                    // JavaLine 151 <== SourceLine 1937
                    if(VALUE$(TRF_NE(listid,null))) {
                        // JavaLine 153 <== SourceLine 1938
                        {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("  listing file: "));
                            ;
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(listid);
                            ;
                        }
                    }
                    ;
                    // JavaLine 162 <== SourceLine 1939
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("   S-Code file: "));
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.nscodename$1);
                    ;
                    // JavaLine 167 <== SourceLine 1940
                    sysout().outimage();
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("Scratch file: "));
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.L2name$1);
                    ;
                    sysout().outimage();
                    ;
                    // JavaLine 176 <== SourceLine 1941
                    sysout().outimage();
                    ;
                    sysout().outimage();
                    ;
                }
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1896:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1896:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1896:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","SubBlock SubBlock1896",1,1896,9,1927,11,1932,14,1896,16,1898,18,1899,21,1900,37,1902,40,1903,43,1904,46,1905,49,1906,52,1908,56,1909,60,1911,64,1912,66,1913,68,1914,71,1915,81,1918,83,1919,87,1920,89,1921,95,1922,100,1923,104,1924,106,1925,112,1926,115,1927,121,1942,123,1932,129,1933,132,1934,139,1935,141,1936,151,1937,153,1938,162,1939,167,1940,176,1941,199,1943);
} // End of SubBlock
