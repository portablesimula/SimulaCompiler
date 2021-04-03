// JavaLine 1 <== SourceLine 1894
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 15:04:59 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$SubBlock1894 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=1894, lastLine=1941, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 1925
    final LABQNT$ SKIP=new LABQNT$(this,1,"SKIP"); // Local Label #1=SKIP
    // JavaLine 11 <== SourceLine 1930
    final LABQNT$ E=new LABQNT$(this,2,"E"); // Local Label #2=E
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 1894
    final TXT$ smlid=(TXT$)(new TXT$("S-PORT SIMULETTA"));
    // JavaLine 16 <== SourceLine 1896
    TXT$ listid=null;
    // JavaLine 18 <== SourceLine 1897
    TXT$ s=null;
    TXT$ select=null;
    // JavaLine 21 <== SourceLine 1898
    int n=0;
    char ch=0;
    boolean inOpt=false;
    // Normal Constructor
    public Pass1$SubBlock32$SubBlock1894(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Pass1$SubBlock32$SubBlock1894 THIS$=(Pass1$SubBlock32$SubBlock1894)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 37 <== SourceLine 1900
                ((Pass1$SubBlock32)(CUR$.SL$)).source_file=getTextInfo(1);
                ;
                // JavaLine 40 <== SourceLine 1901
                listid=getTextInfo(2);
                ;
                // JavaLine 43 <== SourceLine 1902
                ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.L2name$1=getTextInfo(7);
                ;
                // JavaLine 46 <== SourceLine 1903
                ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.nscodename$1=getTextInfo(4);
                ;
                // JavaLine 49 <== SourceLine 1904
                select=getTextInfo(16);
                ;
                // JavaLine 52 <== SourceLine 1906
                if(VALUE$(TRF_EQ(listid,null))) {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=null;
                } else
                // JavaLine 56 <== SourceLine 1907
                if(VALUE$(TXTREL$EQ(lowcase(copy(copy(listid))),new TXT$("sysout")))) {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=sysout();
                } else
                // JavaLine 60 <== SourceLine 1909
                {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=new PrintFile$(((BASICIO$)CTX$),listid).STM$();
                    ;
                    // JavaLine 64 <== SourceLine 1910
                    if(VALUE$((!(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1.open(blanks(132)))))) {
                        // JavaLine 66 <== SourceLine 1911
                        {
                            // JavaLine 68 <== SourceLine 1912
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(CONC(CONC(new TXT$("*** NB: Cannot open listing file"),listid),new TXT$(" - listing deleted ***")));
                            ;
                            // JavaLine 71 <== SourceLine 1913
                            sysout().outimage();
                            ;
                            ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=null;
                            ;
                        }
                    }
                    ;
                }
                ;
                // JavaLine 81 <== SourceLine 1916
                while(TXT$.more(select)) {
                    // JavaLine 83 <== SourceLine 1917
                    {
                        ch=TXT$.getchar(select);
                        ;
                        // JavaLine 87 <== SourceLine 1918
                        if(VALUE$((ch>('Z')))) {
                            // JavaLine 89 <== SourceLine 1919
                            {
                                if(VALUE$((ch>('z')))) {
                                    GOTO$(SKIP); // GOTO EVALUATED LABEL
                                }
                                ;
                                // JavaLine 95 <== SourceLine 1920
                                ch=char$(Math.subtractExact(rank(ch),90));
                            }
                        }
                        ;
                        // JavaLine 100 <== SourceLine 1921
                        if(VALUE$((ch==(':')))) {
                            inOpt=true;
                        } else
                        // JavaLine 104 <== SourceLine 1922
                        if(VALUE$((ch==(((char)32))))) {
                            // JavaLine 106 <== SourceLine 1923
                            GOTO$(E); // GOTO EVALUATED LABEL
                        } else
                        if(VALUE$(inOpt)) {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.option.Elt[rank(ch)-((Pass1)(CUR$.SL$.SL$)).inspect$28$62.option.LB[0]]=1;
                        } else
                        // JavaLine 112 <== SourceLine 1924
                        ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.Selector.Elt[rank(ch)-((Pass1)(CUR$.SL$.SL$)).inspect$28$62.Selector.LB[0]]=true;
                        ;
                        // JavaLine 115 <== SourceLine 1925
                        LABEL$(1,"SKIP");
                        ;
                    }
                }
                ;
                // JavaLine 121 <== SourceLine 1940
                LABEL$(2,"E");
                // JavaLine 123 <== SourceLine 1930
                {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(smlid);
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$(" (trace)"));
                    ;
                    // JavaLine 129 <== SourceLine 1931
                    sysout().outimage();
                    ;
                    // JavaLine 132 <== SourceLine 1932
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("Source file:  "));
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(((Pass1$SubBlock32)(CUR$.SL$)).source_file);
                    ;
                    sysout().outimage();
                    ;
                    // JavaLine 139 <== SourceLine 1933
                    if(VALUE$(TRF_NE(select,null))) {
                        // JavaLine 141 <== SourceLine 1934
                        {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("Selection:    "));
                            ;
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(select);
                            ;
                            sysout().outimage();
                        }
                    }
                    ;
                    // JavaLine 151 <== SourceLine 1935
                    if(VALUE$(TRF_NE(listid,null))) {
                        // JavaLine 153 <== SourceLine 1936
                        {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("  listing file: "));
                            ;
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(listid);
                            ;
                        }
                    }
                    ;
                    // JavaLine 162 <== SourceLine 1937
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("   S-Code file: "));
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.nscodename$1);
                    ;
                    // JavaLine 167 <== SourceLine 1938
                    sysout().outimage();
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("Scratch file: "));
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.L2name$1);
                    ;
                    sysout().outimage();
                    ;
                    // JavaLine 176 <== SourceLine 1939
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
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1894:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1894:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1894:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","SubBlock SubBlock1894",1,1894,9,1925,11,1930,14,1894,16,1896,18,1897,21,1898,37,1900,40,1901,43,1902,46,1903,49,1904,52,1906,56,1907,60,1909,64,1910,66,1911,68,1912,71,1913,81,1916,83,1917,87,1918,89,1919,95,1920,100,1921,104,1922,106,1923,112,1924,115,1925,121,1940,123,1930,129,1931,132,1932,139,1933,141,1934,151,1935,153,1936,162,1937,167,1938,176,1939,199,1941);
} // End of SubBlock
