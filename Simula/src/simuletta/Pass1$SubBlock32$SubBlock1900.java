// JavaLine 1 <== SourceLine 1900
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$SubBlock1900 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=1900, lastLine=1947, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 1931
    final LABQNT$ SKIP=new LABQNT$(this,1,"SKIP"); // Local Label #1=SKIP
    // JavaLine 11 <== SourceLine 1936
    final LABQNT$ E=new LABQNT$(this,2,"E"); // Local Label #2=E
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 1900
    final TXT$ smlid=(TXT$)(new TXT$("S-PORT SIMULETTA"));
    // JavaLine 16 <== SourceLine 1902
    TXT$ listid=null;
    // JavaLine 18 <== SourceLine 1903
    TXT$ s=null;
    TXT$ select=null;
    // JavaLine 21 <== SourceLine 1904
    int n=0;
    char ch=0;
    boolean inOpt=false;
    // Normal Constructor
    public Pass1$SubBlock32$SubBlock1900(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Pass1$SubBlock32$SubBlock1900 THIS$=(Pass1$SubBlock32$SubBlock1900)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 37 <== SourceLine 1906
                ((Pass1$SubBlock32)(CUR$.SL$)).source_file=getTextInfo(1);
                ;
                // JavaLine 40 <== SourceLine 1907
                listid=getTextInfo(2);
                ;
                // JavaLine 43 <== SourceLine 1908
                ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.L2name$1=getTextInfo(7);
                ;
                // JavaLine 46 <== SourceLine 1909
                ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.nscodename$1=getTextInfo(4);
                ;
                // JavaLine 49 <== SourceLine 1910
                select=getTextInfo(16);
                ;
                // JavaLine 52 <== SourceLine 1912
                if(VALUE$(TRF_EQ(listid,null))) {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=null;
                } else
                // JavaLine 56 <== SourceLine 1913
                if(VALUE$(TXTREL$EQ(lowcase(copy(copy(listid))),new TXT$("sysout")))) {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=sysout();
                } else
                // JavaLine 60 <== SourceLine 1915
                {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=new PrintFile$(((BASICIO$)CTX$),listid).STM$();
                    ;
                    // JavaLine 64 <== SourceLine 1916
                    if(VALUE$((!(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1.open(blanks(132)))))) {
                        // JavaLine 66 <== SourceLine 1917
                        {
                            // JavaLine 68 <== SourceLine 1918
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(CONC(CONC(new TXT$("*** NB: Cannot open listing file"),listid),new TXT$(" - listing deleted ***")));
                            ;
                            // JavaLine 71 <== SourceLine 1919
                            sysout().outimage();
                            ;
                            ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.ListFile$1=null;
                            ;
                        }
                    }
                    ;
                }
                ;
                // JavaLine 81 <== SourceLine 1922
                while(TXT$.more(select)) {
                    // JavaLine 83 <== SourceLine 1923
                    {
                        ch=TXT$.getchar(select);
                        ;
                        // JavaLine 87 <== SourceLine 1924
                        if(VALUE$((ch>('Z')))) {
                            // JavaLine 89 <== SourceLine 1925
                            {
                                if(VALUE$((ch>('z')))) {
                                    GOTO$(SKIP); // GOTO EVALUATED LABEL
                                }
                                ;
                                // JavaLine 95 <== SourceLine 1926
                                ch=char$(Math.subtractExact(rank(ch),90));
                            }
                        }
                        ;
                        // JavaLine 100 <== SourceLine 1927
                        if(VALUE$((ch==(':')))) {
                            inOpt=true;
                        } else
                        // JavaLine 104 <== SourceLine 1928
                        if(VALUE$((ch==(((char)32))))) {
                            // JavaLine 106 <== SourceLine 1929
                            GOTO$(E); // GOTO EVALUATED LABEL
                        } else
                        if(VALUE$(inOpt)) {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.option.Elt[rank(ch)-((Pass1)(CUR$.SL$.SL$)).inspect$28$62.option.LB[0]]=1;
                        } else
                        // JavaLine 112 <== SourceLine 1930
                        ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.Selector.Elt[rank(ch)-((Pass1)(CUR$.SL$.SL$)).inspect$28$62.Selector.LB[0]]=true;
                        ;
                        // JavaLine 115 <== SourceLine 1931
                        LABEL$(1,"SKIP");
                        ;
                    }
                }
                ;
                // JavaLine 121 <== SourceLine 1946
                LABEL$(2,"E");
                // JavaLine 123 <== SourceLine 1936
                {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(smlid);
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$(" (trace)"));
                    ;
                    // JavaLine 129 <== SourceLine 1937
                    sysout().outimage();
                    ;
                    // JavaLine 132 <== SourceLine 1938
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("Source file:  "));
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(((Pass1$SubBlock32)(CUR$.SL$)).source_file);
                    ;
                    sysout().outimage();
                    ;
                    // JavaLine 139 <== SourceLine 1939
                    if(VALUE$(TRF_NE(select,null))) {
                        // JavaLine 141 <== SourceLine 1940
                        {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("Selection:    "));
                            ;
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(select);
                            ;
                            sysout().outimage();
                        }
                    }
                    ;
                    // JavaLine 151 <== SourceLine 1941
                    if(VALUE$(TRF_NE(listid,null))) {
                        // JavaLine 153 <== SourceLine 1942
                        {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("  listing file: "));
                            ;
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(listid);
                            ;
                        }
                    }
                    ;
                    // JavaLine 162 <== SourceLine 1943
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("   S-Code file: "));
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.nscodename$1);
                    ;
                    // JavaLine 167 <== SourceLine 1944
                    sysout().outimage();
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(new TXT$("Scratch file: "));
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$63.outtext(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.L2name$1);
                    ;
                    sysout().outimage();
                    ;
                    // JavaLine 176 <== SourceLine 1945
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
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1900:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1900:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1900:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","SubBlock SubBlock1900",1,1900,9,1931,11,1936,14,1900,16,1902,18,1903,21,1904,37,1906,40,1907,43,1908,46,1909,49,1910,52,1912,56,1913,60,1915,64,1916,66,1917,68,1918,71,1919,81,1922,83,1923,87,1924,89,1925,95,1926,100,1927,104,1928,106,1929,112,1930,115,1931,121,1946,123,1936,129,1937,132,1938,139,1939,141,1940,151,1941,153,1942,162,1943,167,1944,176,1945,199,1947);
} // End of SubBlock
