// JavaLine 1 <== SourceLine 1897
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 18:09:19 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$SubBlock1897 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=1897, lastLine=1944, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 1928
    final LABQNT$ SKIP=new LABQNT$(this,1,"SKIP"); // Local Label #1=SKIP
    // JavaLine 11 <== SourceLine 1933
    final LABQNT$ E=new LABQNT$(this,2,"E"); // Local Label #2=E
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 1897
    final TXT$ smlid=(TXT$)(new TXT$("S-PORT SIMULETTA"));
    // JavaLine 16 <== SourceLine 1899
    TXT$ listid=null;
    // JavaLine 18 <== SourceLine 1900
    TXT$ s=null;
    TXT$ select=null;
    // JavaLine 21 <== SourceLine 1901
    int n=0;
    char ch=0;
    boolean inOpt=false;
    // Normal Constructor
    public Pass1$SubBlock32$SubBlock1897(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Pass1$SubBlock32$SubBlock1897 THIS$=(Pass1$SubBlock32$SubBlock1897)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 37 <== SourceLine 1903
                ((Pass1$SubBlock32)(CUR$.SL$)).source_file=getTextInfo(1);
                ;
                // JavaLine 40 <== SourceLine 1904
                listid=getTextInfo(2);
                ;
                // JavaLine 43 <== SourceLine 1905
                ((Pass1)(CUR$.SL$.SL$)).inspect$28$0.L2name$1=getTextInfo(7);
                ;
                // JavaLine 46 <== SourceLine 1906
                ((Pass1)(CUR$.SL$.SL$)).inspect$28$0.nscodename$1=getTextInfo(4);
                ;
                // JavaLine 49 <== SourceLine 1907
                select=getTextInfo(16);
                ;
                // JavaLine 52 <== SourceLine 1909
                if(VALUE$(TRF_EQ(listid,null))) {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$28$0.ListFile$1=null;
                } else
                // JavaLine 56 <== SourceLine 1910
                if(VALUE$(TXTREL$EQ(lowcase(copy(copy(listid))),new TXT$("sysout")))) {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$28$0.ListFile$1=sysout();
                } else
                // JavaLine 60 <== SourceLine 1912
                {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$28$0.ListFile$1=new PrintFile$(((BASICIO$)CTX$),listid).STM$();
                    ;
                    // JavaLine 64 <== SourceLine 1913
                    if(VALUE$((!(((Pass1)(CUR$.SL$.SL$)).inspect$28$0.ListFile$1.open(blanks(132)))))) {
                        // JavaLine 66 <== SourceLine 1914
                        {
                            // JavaLine 68 <== SourceLine 1915
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$1.outtext(CONC(CONC(new TXT$("*** NB: Cannot open listing file"),listid),new TXT$(" - listing deleted ***")));
                            ;
                            // JavaLine 71 <== SourceLine 1916
                            sysout().outimage();
                            ;
                            ((Pass1)(CUR$.SL$.SL$)).inspect$28$0.ListFile$1=null;
                            ;
                        }
                    }
                    ;
                }
                ;
                // JavaLine 81 <== SourceLine 1919
                while(TXT$.more(select)) {
                    // JavaLine 83 <== SourceLine 1920
                    {
                        ch=TXT$.getchar(select);
                        ;
                        // JavaLine 87 <== SourceLine 1921
                        if(VALUE$((ch>('Z')))) {
                            // JavaLine 89 <== SourceLine 1922
                            {
                                if(VALUE$((ch>('z')))) {
                                    GOTO$(SKIP); // GOTO EVALUATED LABEL
                                }
                                ;
                                // JavaLine 95 <== SourceLine 1923
                                ch=char$(Math.subtractExact(rank(ch),90));
                            }
                        }
                        ;
                        // JavaLine 100 <== SourceLine 1924
                        if(VALUE$((ch==(':')))) {
                            inOpt=true;
                        } else
                        // JavaLine 104 <== SourceLine 1925
                        if(VALUE$((ch==(((char)32))))) {
                            // JavaLine 106 <== SourceLine 1926
                            GOTO$(E); // GOTO EVALUATED LABEL
                        } else
                        if(VALUE$(inOpt)) {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$28$0.option.Elt[rank(ch)-((Pass1)(CUR$.SL$.SL$)).inspect$28$0.option.LB[0]]=1;
                        } else
                        // JavaLine 112 <== SourceLine 1927
                        ((Pass1)(CUR$.SL$.SL$)).inspect$28$0.Selector.Elt[rank(ch)-((Pass1)(CUR$.SL$.SL$)).inspect$28$0.Selector.LB[0]]=true;
                        ;
                        // JavaLine 115 <== SourceLine 1928
                        LABEL$(1,"SKIP");
                        ;
                    }
                }
                ;
                // JavaLine 121 <== SourceLine 1943
                LABEL$(2,"E");
                // JavaLine 123 <== SourceLine 1933
                {
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$1.outtext(smlid);
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$1.outtext(new TXT$(" (trace)"));
                    ;
                    // JavaLine 129 <== SourceLine 1934
                    sysout().outimage();
                    ;
                    // JavaLine 132 <== SourceLine 1935
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$1.outtext(new TXT$("Source file:  "));
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$1.outtext(((Pass1$SubBlock32)(CUR$.SL$)).source_file);
                    ;
                    sysout().outimage();
                    ;
                    // JavaLine 139 <== SourceLine 1936
                    if(VALUE$(TRF_NE(select,null))) {
                        // JavaLine 141 <== SourceLine 1937
                        {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$1.outtext(new TXT$("Selection:    "));
                            ;
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$1.outtext(select);
                            ;
                            sysout().outimage();
                        }
                    }
                    ;
                    // JavaLine 151 <== SourceLine 1938
                    if(VALUE$(TRF_NE(listid,null))) {
                        // JavaLine 153 <== SourceLine 1939
                        {
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$1.outtext(new TXT$("  listing file: "));
                            ;
                            ((Pass1)(CUR$.SL$.SL$)).inspect$29$1.outtext(listid);
                            ;
                        }
                    }
                    ;
                    // JavaLine 162 <== SourceLine 1940
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$1.outtext(new TXT$("   S-Code file: "));
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$1.outtext(((Pass1)(CUR$.SL$.SL$)).inspect$28$0.nscodename$1);
                    ;
                    // JavaLine 167 <== SourceLine 1941
                    sysout().outimage();
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$1.outtext(new TXT$("Scratch file: "));
                    ;
                    ((Pass1)(CUR$.SL$.SL$)).inspect$29$1.outtext(((Pass1)(CUR$.SL$.SL$)).inspect$28$0.L2name$1);
                    ;
                    sysout().outimage();
                    ;
                    // JavaLine 176 <== SourceLine 1942
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
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1897:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1897:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1897:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","SubBlock SubBlock1897",1,1897,9,1928,11,1933,14,1897,16,1899,18,1900,21,1901,37,1903,40,1904,43,1905,46,1906,49,1907,52,1909,56,1910,60,1912,64,1913,66,1914,68,1915,71,1916,81,1919,83,1920,87,1921,89,1922,95,1923,100,1924,104,1925,106,1926,112,1927,115,1928,121,1943,123,1933,129,1934,132,1935,139,1936,141,1937,151,1938,153,1939,162,1940,167,1941,176,1942,199,1944);
} // End of SubBlock
