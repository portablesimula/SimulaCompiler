// JavaLine 1 <== SourceLine 1891
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 15:02:31 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$SubBlock1891 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=1891, lastLine=1938, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 1922
    final LABQNT$ SKIP=new LABQNT$(this,1,"SKIP"); // Local Label #1=SKIP
    // JavaLine 11 <== SourceLine 1927
    final LABQNT$ E=new LABQNT$(this,2,"E"); // Local Label #2=E
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 1891
    final TXT$ smlid=(TXT$)(new TXT$("S-PORT SIMULETTA"));
    // JavaLine 16 <== SourceLine 1893
    TXT$ listid=null;
    // JavaLine 18 <== SourceLine 1894
    TXT$ s=null;
    TXT$ select=null;
    // JavaLine 21 <== SourceLine 1895
    int n=0;
    char ch=0;
    boolean inOpt=false;
    // Normal Constructor
    public Pass1$SubBlock32$SubBlock1891(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Pass1$SubBlock32$SubBlock1891 THIS$=(Pass1$SubBlock32$SubBlock1891)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 37 <== SourceLine 1897
                ((Pass1$SubBlock32)(CUR$.SL$)).source_file=getTextInfo(1);
                ;
                // JavaLine 40 <== SourceLine 1898
                listid=getTextInfo(2);
                ;
                // JavaLine 43 <== SourceLine 1899
                ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.L2name$1=getTextInfo(7);
                ;
                // JavaLine 46 <== SourceLine 1900
                ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.nscodename$1=getTextInfo(4);
                ;
                // JavaLine 49 <== SourceLine 1901
                select=getTextInfo(16);
                ;
                // JavaLine 52 <== SourceLine 1903
                if(VALUE$(TRF_EQ(listid,null))) {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=null;
                } else
                // JavaLine 56 <== SourceLine 1904
                if(VALUE$(TXTREL$EQ(lowcase(copy(copy(listid))),new TXT$("sysout")))) {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=sysout();
                } else
                // JavaLine 60 <== SourceLine 1906
                {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=new PrintFile$(((BASICIO$)CTX$),listid).STM$();
                    ;
                    // JavaLine 64 <== SourceLine 1907
                    if(VALUE$((!(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1.open(blanks(132)))))) {
                        // JavaLine 66 <== SourceLine 1908
                        {
                            // JavaLine 68 <== SourceLine 1909
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(CONC(CONC(new TXT$("*** NB: Cannot open listing file"),listid),new TXT$(" - listing deleted ***")));
                            ;
                            // JavaLine 71 <== SourceLine 1910
                            sysout().outimage();
                            ;
                            ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=null;
                            ;
                        }
                    }
                    ;
                }
                ;
                // JavaLine 81 <== SourceLine 1913
                while(TXT$.more(select)) {
                    // JavaLine 83 <== SourceLine 1914
                    {
                        ch=TXT$.getchar(select);
                        ;
                        // JavaLine 87 <== SourceLine 1915
                        if(VALUE$((ch>('Z')))) {
                            // JavaLine 89 <== SourceLine 1916
                            {
                                if(VALUE$((ch>('z')))) {
                                    GOTO$(SKIP); // GOTO EVALUATED LABEL
                                }
                                ;
                                // JavaLine 95 <== SourceLine 1917
                                ch=char$(Math.subtractExact(rank(ch),90));
                            }
                        }
                        ;
                        // JavaLine 100 <== SourceLine 1918
                        if(VALUE$((ch==(':')))) {
                            inOpt=true;
                        } else
                        // JavaLine 104 <== SourceLine 1919
                        if(VALUE$((ch==(((char)32))))) {
                            // JavaLine 106 <== SourceLine 1920
                            GOTO$(E); // GOTO EVALUATED LABEL
                        } else
                        if(VALUE$(inOpt)) {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.option.Elt[rank(ch)-((Pass1)(CUR$.SL$.SL$)).inspect$28$62.option.LB[0]]=1;
                        } else
                        // JavaLine 112 <== SourceLine 1921
                        ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.Selector.Elt[rank(ch)-((Pass1)(CUR$.SL$.SL$)).inspect$28$62.Selector.LB[0]]=true;
                        ;
                        // JavaLine 115 <== SourceLine 1922
                        LABEL$(1,"SKIP");
                        ;
                    }
                }
                ;
                // JavaLine 121 <== SourceLine 1937
                LABEL$(2,"E");
                // JavaLine 123 <== SourceLine 1927
                {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(smlid);
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$(" (trace)"));
                    ;
                    // JavaLine 129 <== SourceLine 1928
                    sysout().outimage();
                    ;
                    // JavaLine 132 <== SourceLine 1929
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("Source file:  "));
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(((Pass1$SubBlock32)(CUR$.SL$)).source_file);
                    ;
                    sysout().outimage();
                    ;
                    // JavaLine 139 <== SourceLine 1930
                    if(VALUE$(TRF_NE(select,null))) {
                        // JavaLine 141 <== SourceLine 1931
                        {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("Selection:    "));
                            ;
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(select);
                            ;
                            sysout().outimage();
                        }
                    }
                    ;
                    // JavaLine 151 <== SourceLine 1932
                    if(VALUE$(TRF_NE(listid,null))) {
                        // JavaLine 153 <== SourceLine 1933
                        {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("  listing file: "));
                            ;
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(listid);
                            ;
                        }
                    }
                    ;
                    // JavaLine 162 <== SourceLine 1934
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("   S-Code file: "));
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.nscodename$1);
                    ;
                    // JavaLine 167 <== SourceLine 1935
                    sysout().outimage();
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("Scratch file: "));
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.L2name$1);
                    ;
                    sysout().outimage();
                    ;
                    // JavaLine 176 <== SourceLine 1936
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
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1891:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1891:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1891:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","SubBlock SubBlock1891",1,1891,9,1922,11,1927,14,1891,16,1893,18,1894,21,1895,37,1897,40,1898,43,1899,46,1900,49,1901,52,1903,56,1904,60,1906,64,1907,66,1908,68,1909,71,1910,81,1913,83,1914,87,1915,89,1916,95,1917,100,1918,104,1919,106,1920,112,1921,115,1922,121,1937,123,1927,129,1928,132,1929,139,1930,141,1931,151,1932,153,1933,162,1934,167,1935,176,1936,199,1938);
} // End of SubBlock
