// JavaLine 1 <== SourceLine 1895
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 17:46:07 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$SubBlock1895 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=1895, lastLine=1942, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 1926
    final LABQNT$ SKIP=new LABQNT$(this,1,"SKIP"); // Local Label #1=SKIP
    // JavaLine 11 <== SourceLine 1931
    final LABQNT$ E=new LABQNT$(this,2,"E"); // Local Label #2=E
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 1895
    final TXT$ smlid=(TXT$)(new TXT$("S-PORT SIMULETTA"));
    // JavaLine 16 <== SourceLine 1897
    TXT$ listid=null;
    // JavaLine 18 <== SourceLine 1898
    TXT$ s=null;
    TXT$ select=null;
    // JavaLine 21 <== SourceLine 1899
    int n=0;
    char ch=0;
    boolean inOpt=false;
    // Normal Constructor
    public Pass1$SubBlock32$SubBlock1895(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Pass1$SubBlock32$SubBlock1895 THIS$=(Pass1$SubBlock32$SubBlock1895)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 37 <== SourceLine 1901
                ((Pass1$SubBlock32)(CUR$.SL$)).source_file=getTextInfo(1);
                ;
                // JavaLine 40 <== SourceLine 1902
                listid=getTextInfo(2);
                ;
                // JavaLine 43 <== SourceLine 1903
                ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.L2name$1=getTextInfo(7);
                ;
                // JavaLine 46 <== SourceLine 1904
                ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.nscodename$1=getTextInfo(4);
                ;
                // JavaLine 49 <== SourceLine 1905
                select=getTextInfo(16);
                ;
                // JavaLine 52 <== SourceLine 1907
                if(VALUE$(TRF_EQ(listid,null))) {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=null;
                } else
                // JavaLine 56 <== SourceLine 1908
                if(VALUE$(TXTREL$EQ(lowcase(copy(copy(listid))),new TXT$("sysout")))) {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=sysout();
                } else
                // JavaLine 60 <== SourceLine 1910
                {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=new PrintFile$(((BASICIO$)CTX$),listid).STM$();
                    ;
                    // JavaLine 64 <== SourceLine 1911
                    if(VALUE$((!(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1.open(blanks(132)))))) {
                        // JavaLine 66 <== SourceLine 1912
                        {
                            // JavaLine 68 <== SourceLine 1913
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(CONC(CONC(new TXT$("*** NB: Cannot open listing file"),listid),new TXT$(" - listing deleted ***")));
                            ;
                            // JavaLine 71 <== SourceLine 1914
                            sysout().outimage();
                            ;
                            ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=null;
                            ;
                        }
                    }
                    ;
                }
                ;
                // JavaLine 81 <== SourceLine 1917
                while(TXT$.more(select)) {
                    // JavaLine 83 <== SourceLine 1918
                    {
                        ch=TXT$.getchar(select);
                        ;
                        // JavaLine 87 <== SourceLine 1919
                        if(VALUE$((ch>('Z')))) {
                            // JavaLine 89 <== SourceLine 1920
                            {
                                if(VALUE$((ch>('z')))) {
                                    GOTO$(SKIP); // GOTO EVALUATED LABEL
                                }
                                ;
                                // JavaLine 95 <== SourceLine 1921
                                ch=char$(Math.subtractExact(rank(ch),90));
                            }
                        }
                        ;
                        // JavaLine 100 <== SourceLine 1922
                        if(VALUE$((ch==(':')))) {
                            inOpt=true;
                        } else
                        // JavaLine 104 <== SourceLine 1923
                        if(VALUE$((ch==(((char)32))))) {
                            // JavaLine 106 <== SourceLine 1924
                            GOTO$(E); // GOTO EVALUATED LABEL
                        } else
                        if(VALUE$(inOpt)) {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.option.Elt[rank(ch)-((Pass1)(CUR$.SL$.SL$)).inspect$28$62.option.LB[0]]=1;
                        } else
                        // JavaLine 112 <== SourceLine 1925
                        ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.Selector.Elt[rank(ch)-((Pass1)(CUR$.SL$.SL$)).inspect$28$62.Selector.LB[0]]=true;
                        ;
                        // JavaLine 115 <== SourceLine 1926
                        LABEL$(1,"SKIP");
                        ;
                    }
                }
                ;
                // JavaLine 121 <== SourceLine 1941
                LABEL$(2,"E");
                // JavaLine 123 <== SourceLine 1931
                {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(smlid);
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$(" (trace)"));
                    ;
                    // JavaLine 129 <== SourceLine 1932
                    sysout().outimage();
                    ;
                    // JavaLine 132 <== SourceLine 1933
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("Source file:  "));
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(((Pass1$SubBlock32)(CUR$.SL$)).source_file);
                    ;
                    sysout().outimage();
                    ;
                    // JavaLine 139 <== SourceLine 1934
                    if(VALUE$(TRF_NE(select,null))) {
                        // JavaLine 141 <== SourceLine 1935
                        {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("Selection:    "));
                            ;
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(select);
                            ;
                            sysout().outimage();
                        }
                    }
                    ;
                    // JavaLine 151 <== SourceLine 1936
                    if(VALUE$(TRF_NE(listid,null))) {
                        // JavaLine 153 <== SourceLine 1937
                        {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("  listing file: "));
                            ;
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(listid);
                            ;
                        }
                    }
                    ;
                    // JavaLine 162 <== SourceLine 1938
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("   S-Code file: "));
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.nscodename$1);
                    ;
                    // JavaLine 167 <== SourceLine 1939
                    sysout().outimage();
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("Scratch file: "));
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.L2name$1);
                    ;
                    sysout().outimage();
                    ;
                    // JavaLine 176 <== SourceLine 1940
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
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1895:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1895:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1895:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","SubBlock SubBlock1895",1,1895,9,1926,11,1931,14,1895,16,1897,18,1898,21,1899,37,1901,40,1902,43,1903,46,1904,49,1905,52,1907,56,1908,60,1910,64,1911,66,1912,68,1913,71,1914,81,1917,83,1918,87,1919,89,1920,95,1921,100,1922,104,1923,106,1924,112,1925,115,1926,121,1941,123,1931,129,1932,132,1933,139,1934,141,1935,151,1936,153,1937,162,1938,167,1939,176,1940,199,1942);
} // End of SubBlock
