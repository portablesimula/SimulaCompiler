// JavaLine 1 ==> SourceLine 1598
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:44:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SCANNER$L2Coder extends COMMON$outcodefile {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=5, firstLine=1598, lastLine=2420, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(5); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 1828
    final LABQNT$ OPNOUT=new LABQNT$(this,5,1); // Local Label #1=OPNOUT
    // JavaLine 13 ==> SourceLine 1836
    final LABQNT$ OPDOUT=new LABQNT$(this,5,2); // Local Label #2=OPDOUT
    // JavaLine 15 ==> SourceLine 1889
    final LABQNT$ SINGLE=new LABQNT$(this,5,3); // Local Label #3=SINGLE
    // JavaLine 17 ==> SourceLine 1910
    final LABQNT$ SetQual=new LABQNT$(this,5,4); // Local Label #4=SetQual
    // JavaLine 19 ==> SourceLine 1938
    final LABQNT$ BLOCKOUT=new LABQNT$(this,5,5); // Local Label #5=BLOCKOUT
    // JavaLine 21 ==> SourceLine 1977
    final LABQNT$ NXTVIRT=new LABQNT$(this,5,6); // Local Label #6=NXTVIRT
    // JavaLine 23 ==> SourceLine 1988
    final LABQNT$ L1=new LABQNT$(this,5,7); // Local Label #7=L1
    // JavaLine 25 ==> SourceLine 2021
    final LABQNT$ FOUND=new LABQNT$(this,5,8); // Local Label #8=FOUND
    // JavaLine 27 ==> SourceLine 1980
    final LABQNT$ EXvloop=new LABQNT$(this,5,9); // Local Label #9=EXvloop
    // JavaLine 29 ==> SourceLine 2040
    final LABQNT$ btout=new LABQNT$(this,5,10); // Local Label #10=btout
    // JavaLine 31 ==> SourceLine 2063
    final LABQNT$ Qfound=new LABQNT$(this,5,11); // Local Label #11=Qfound
    // JavaLine 33 ==> SourceLine 2076
    final LABQNT$ genlab=new LABQNT$(this,5,12); // Local Label #12=genlab
    // JavaLine 35 ==> SourceLine 2153
    final LABQNT$ lidclp=new LABQNT$(this,5,13); // Local Label #13=lidclp
    // JavaLine 37 ==> SourceLine 2155
    final LABQNT$ genbrc=new LABQNT$(this,5,14); // Local Label #14=genbrc
    // JavaLine 39 ==> SourceLine 2249
    final LABQNT$ Nspec=new LABQNT$(this,5,15); // Local Label #15=Nspec
    // JavaLine 41 ==> SourceLine 2273
    final LABQNT$ LIFWHN=new LABQNT$(this,5,16); // Local Label #16=LIFWHN
    // JavaLine 43 ==> SourceLine 2292
    final LABQNT$ QBLOCKOUT=new LABQNT$(this,5,17); // Local Label #17=QBLOCKOUT
    // JavaLine 45 ==> SourceLine 2406
    final LABQNT$ NonLoc=new LABQNT$(this,5,18); // Local Label #18=NonLoc
    // JavaLine 47 ==> SourceLine 1783
    final LABQNT$ NEXTOPN=new LABQNT$(this,5,19); // Local Label #19=NEXTOPN
    // JavaLine 49 ==> SourceLine 1793
    final LABQNT$ CheckNxt=new LABQNT$(this,5,20); // Local Label #20=CheckNxt
    // JavaLine 51 ==> SourceLine 2370
    final LABQNT$ LIHIDD=new LABQNT$(this,5,21); // Local Label #21=LIHIDD
    // Declare locals as attributes
    // JavaLine 54 ==> SourceLine 1606
    public boolean notok=false;
    public boolean locals=false;
    // JavaLine 57 ==> SourceLine 1607
    public char ctype=0;
    public char ckind=0;
    // JavaLine 60 ==> SourceLine 1608
    public char iihi=0;
    public char iilo=0;
    // JavaLine 63 ==> SourceLine 1609
    public char lanhi=0;
    public char lanlo=0;
    // JavaLine 66 ==> SourceLine 1610
    public int L2p=0;
    // JavaLine 68 ==> SourceLine 1611
    public final int L2max=256;
    // JavaLine 70 ==> SourceLine 1613
    public final int L2limit=249;
    // JavaLine 72 ==> SourceLine 1614
    public int cqual=0;
    // JavaLine 74 ==> SourceLine 1615
    public int cswa=0;
    public int cswb=0;
    // JavaLine 77 ==> SourceLine 1616
    public int dimcount=0;
    // JavaLine 79 ==> SourceLine 1617
    public int iii=0;
    public int jjj=0;
    public int lastlinenr=0;
    // JavaLine 83 ==> SourceLine 1618
    public COMMON$symbolbox symx=null;
    // JavaLine 85 ==> SourceLine 1619
    public COMMON$quantity firstarr=null;
    // JavaLine 87 ==> SourceLine 1620
    public COMMON$idpack fvis=null;
    public COMMON$idpack x=null;
    // JavaLine 90 ==> SourceLine 1621
    public COMMON$quantity pq=null;
    public COMMON$quantity virq=null;
    // JavaLine 93 ==> SourceLine 1622
    public COMMON$brecord cbrec=null;
    public COMMON$brecord xbrec=null;
    public COMMON$brecord forbrec=null;
    // JavaLine 97 ==> SourceLine 1623
    public COMMON$quantity cquant=null;
    public COMMON$quantity vquant=null;
    public COMMON$quantity xquant=null;
    // JavaLine 101 ==> SourceLine 1627
    public COMMON$quantity p_or_c_qt=null;
    // JavaLine 103 ==> SourceLine 1636
    public COMMON$idpack cvispack=null;
    public COMMON$brecord lastBrec=null;
    public TXT$ L2buf=null;
    // JavaLine 107 ==> SourceLine 1945
    public COMMON$brecord inspect$1945$14=null;
    // JavaLine 109 ==> SourceLine 1947
    public COMMON$quantity inspect$1947$15=null;
    // JavaLine 111 ==> SourceLine 1968
    public COMMON$idpack inspect$1968$16=null;
    // JavaLine 113 ==> SourceLine 2016
    public COMMON$idpack inspect$2015$17=null;
    // JavaLine 115 ==> SourceLine 2116
    public COMMON$symbolbox inspect$2116$18=null;
    // JavaLine 117 ==> SourceLine 2130
    public COMMON$quantity inspect$2130$19=null;
    // JavaLine 119 ==> SourceLine 2168
    public COMMON$quantity inspect$2168$20=null;
    // JavaLine 121 ==> SourceLine 2208
    public COMMON$quantity inspect$2208$21=null;
    // JavaLine 123 ==> SourceLine 2227
    public COMMON$idpack inspect$2227$22=null;
    // Normal Constructor
    public SCANNER$L2Coder(RTObject$ staticLink,TXT$ sFILENAME$) {
        super(staticLink,sFILENAME$);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("L2Coder",2227);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,5) {
            public void STM$() {
                TRACE_BEGIN_STM$("L2Coder",2227,inner);
                SCANNER$L2Coder THIS$=(SCANNER$L2Coder)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 139 ==> SourceLine 1776
                        ((SCANNER)(CUR$.SL$)).detach();
                        // JavaLine 141 ==> SourceLine 1777
                        ((SCANNER)(CUR$.SL$)).L2codebuffer=L2buf=blanks(L2max);
                        GOTO$(CheckNxt); // GOTO EVALUATED LABEL
                        // JavaLine 144 ==> SourceLine 1780
                        while(true) {
                            // JavaLine 146 ==> SourceLine 1782
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1782",1782);
                                // JavaLine 149 ==> SourceLine 1786
                                LABEL$(19); // NEXTOPN
                                // JavaLine 151 ==> SourceLine 1783
                                if((lastlinenr<(((SCANNER)(CUR$.SL$)).linenr))) {
                                    // JavaLine 153 ==> SourceLine 1784
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1784",1784);
                                        if((L2p>(252))) {
                                            new SCANNER$L2Coder$outbuffer(((SCANNER$L2Coder)CUR$));
                                        }
                                        // JavaLine 159 ==> SourceLine 1785
                                        lastlinenr=((SCANNER)(CUR$.SL$)).linenr;
                                        new SCANNER$L2Coder$storecharint(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).ILINE,lastlinenr);
                                        TRACE_END_STM$("CompoundStatement1784",1785);
                                    }
                                }
                                // JavaLine 165 ==> SourceLine 1789
                                ((SCANNER)(CUR$.SL$)).detach();
                                // JavaLine 167 ==> SourceLine 1793
                                LABEL$(20); // CheckNxt
                                if((L2p>(L2limit))) {
                                    new SCANNER$L2Coder$outbuffer(((SCANNER$L2Coder)CUR$));
                                }
                                // JavaLine 172 ==> SourceLine 1815
                                switch(((SCANNER)(CUR$.SL$)).opn) { // BEGIN SWITCH STATEMENT
                                case 102: 
                                case 111: 
                                case 80: 
                                case 81: 
                                case 23: 
                                case 49: 
                                case 15: 
                                case 116: 
                                case 70: 
                                case 71: 
                                case 73: 
                                case 72: 
                                case 75: 
                                case 74: 
                                case 58: 
                                case 61: 
                                case 62: 
                                case 60: 
                                case 59: 
                                case 57: 
                                case 45: 
                                case 17: 
                                case 24: 
                                case 36: 
                                case 68: 
                                case 69: 
                                case 146: 
                                case 35: 
                                case 96: 
                                case 130: 
                                case 27: 
                                case 145: 
                                case 128: 
                                case 119: 
                                case 131: 
                                case 82: 
                                case 83: 
                                case 66: 
                                case 67: 
                                case 28: 
                                case 125: 
                                case 52: 
                                case 100: 
                                case 78: 
                                case 98: 
                                case 104: 
                                case 122: 
                                case 135: 
                                case 84: 
                                case 85: 
                                case 86: 
                                case 79: 
                                // JavaLine 226 ==> SourceLine 1828
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1828",1828);
                                    LABEL$(1); // OPNOUT
                                    storeChar(((SCANNER)(CUR$.SL$)).opn,L2buf,L2p);
                                    L2p=(L2p+(1));
                                    // JavaLine 232 ==> SourceLine 1829
                                    GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1828",1829);
                                }
                                case 139: 
                                case 90: 
                                case 129: 
                                case 76: 
                                case 115: 
                                case 34: 
                                case 134: 
                                case 46: 
                                case 25: 
                                case 29: 
                                case 41: 
                                case 50: 
                                case 118: 
                                // JavaLine 249 ==> SourceLine 1836
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1836",1836);
                                    LABEL$(2); // OPDOUT
                                    storeChar(((SCANNER)(CUR$.SL$)).opn,L2buf,L2p);
                                    // JavaLine 254 ==> SourceLine 1837
                                    storeChar(((SCANNER)(CUR$.SL$)).opdhi,L2buf,(L2p+(1)));
                                    // JavaLine 256 ==> SourceLine 1838
                                    storeChar(((SCANNER)(CUR$.SL$)).opdlo,L2buf,(L2p+(2)));
                                    // JavaLine 258 ==> SourceLine 1839
                                    L2p=(L2p+(3));
                                    // JavaLine 260 ==> SourceLine 1840
                                    GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1836",1840);
                                }
                                case 63: 
                                case 89: 
                                // JavaLine 266 ==> SourceLine 1846
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1846",1846);
                                    lastlinenr=((SCANNER)(CUR$.SL$)).linenr;
                                    new SCANNER$L2Coder$storecharint(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).opn,lastlinenr);
                                    // JavaLine 271 ==> SourceLine 1847
                                    GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1846",1847);
                                }
                                case 14: 
                                case 4: 
                                case 5: 
                                case 6: 
                                case 3: 
                                case 1: 
                                case 2: 
                                case 8: 
                                // JavaLine 283 ==> SourceLine 1853
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1853",1853);
                                    ctype=((SCANNER)(CUR$.SL$)).opn;
                                    ckind=((SCANNER)(CUR$.SL$)).K_ident;
                                    // JavaLine 288 ==> SourceLine 1854
                                    cqual=0;
                                    // JavaLine 290 ==> SourceLine 1855
                                    GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1853",1855);
                                }
                                case 13: 
                                // JavaLine 295 ==> SourceLine 1858
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1858",1858);
                                    ckind=((SCANNER)(CUR$.SL$)).K_array;
                                    // JavaLine 299 ==> SourceLine 1859
                                    GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1858",1859);
                                }
                                case 12: 
                                // JavaLine 304 ==> SourceLine 1861
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1861",1861);
                                    ckind=((SCANNER)(CUR$.SL$)).K_proc;
                                    // JavaLine 308 ==> SourceLine 1862
                                    GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1861",1862);
                                }
                                case 30: 
                                // JavaLine 313 ==> SourceLine 1865
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1865",1865);
                                    ckind=((SCANNER)(CUR$.SL$)).K_class;
                                    // JavaLine 317 ==> SourceLine 1866
                                    GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1865",1866);
                                }
                                case 31: 
                                // JavaLine 322 ==> SourceLine 1869
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1869",1869);
                                    ckind=((SCANNER)(CUR$.SL$)).K_record;
                                    // JavaLine 326 ==> SourceLine 1870
                                    GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1869",1870);
                                }
                                case 138: 
                                case 91: 
                                // JavaLine 332 ==> SourceLine 1882
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1882",1882);
                                    storeChar(((SCANNER)(CUR$.SL$)).optx,L2buf,L2p);
                                    // JavaLine 336 ==> SourceLine 1883
                                    switch(((SCANNER)(CUR$.SL$)).optx) { // BEGIN SWITCH STATEMENT
                                    case 1: 
                                    case 2: 
                                    // JavaLine 340 ==> SourceLine 1885
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1885",1885);
                                        storeChar(((SCANNER)(CUR$.SL$)).opdlo,L2buf,(L2p+(1)));
                                        L2p=(L2p+(2));
                                        // JavaLine 345 ==> SourceLine 1886
                                        GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1885",1886);
                                    }
                                    case 3: 
                                    case 4: 
                                    case 5: 
                                    case 6: 
                                    case 8: 
                                    // JavaLine 354 ==> SourceLine 1888
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1888",1888);
                                        storeChar(((SCANNER)(CUR$.SL$)).opdhi,L2buf,(L2p+(1)));
                                        // JavaLine 358 ==> SourceLine 1889
                                        LABEL$(3); // SINGLE
                                        storeChar(((SCANNER)(CUR$.SL$)).opdlo,L2buf,(L2p+(2)));
                                        L2p=(L2p+(3));
                                        // JavaLine 362 ==> SourceLine 1890
                                        GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1888",1890);
                                    }
                                    default:
                                    // JavaLine 367 ==> SourceLine 1892
                                    L2p=(L2p+(1));
                                } // END SWITCH STATEMENT
                                // JavaLine 370 ==> SourceLine 1894
                                GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1882",1894);
                            }
                            case 47: 
                            case 11: 
                            // JavaLine 376 ==> SourceLine 1898
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1898",1898);
                                ctype=((SCANNER)(CUR$.SL$)).ILABE;
                                // JavaLine 380 ==> SourceLine 1899
                                ckind=(((((SCANNER)(CUR$.SL$)).opn==(((SCANNER)(CUR$.SL$)).ILABE)))?(((SCANNER)(CUR$.SL$)).K_label):(((SCANNER)(CUR$.SL$)).K_switch));
                                // JavaLine 382 ==> SourceLine 1900
                                cqual=0;
                                // JavaLine 384 ==> SourceLine 1901
                                GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1898",1901);
                            }
                            case 107: 
                            // JavaLine 389 ==> SourceLine 1905
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1905",1905);
                                GOTO$(SetQual); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1905",1905);
                            }
                            case 7: 
                            // JavaLine 396 ==> SourceLine 1908
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1908",1908);
                                ctype=((SCANNER)(CUR$.SL$)).IREF;
                                ckind=((SCANNER)(CUR$.SL$)).K_ident;
                                // JavaLine 401 ==> SourceLine 1910
                                LABEL$(4); // SetQual
                                cqual=((rank(((SCANNER)(CUR$.SL$)).opdhi)*(256))+(rank(((SCANNER)(CUR$.SL$)).opdlo)));
                                // JavaLine 404 ==> SourceLine 1911
                                GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1908",1911);
                            }
                            case 132: 
                            // JavaLine 409 ==> SourceLine 1914
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1914",1914);
                                lanhi=((SCANNER)(CUR$.SL$)).opdhi;
                                lanlo=((SCANNER)(CUR$.SL$)).opdlo;
                                // JavaLine 414 ==> SourceLine 1915
                                GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1914",1915);
                            }
                            case 110: 
                            case 42: 
                            // JavaLine 420 ==> SourceLine 1919
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1919",1919);
                                ckind=(((((SCANNER)(CUR$.SL$)).opn==(((SCANNER)(CUR$.SL$)).IDCLC)))?(((SCANNER)(CUR$.SL$)).K_class):(((SCANNER)(CUR$.SL$)).K_record));
                                // JavaLine 424 ==> SourceLine 1920
                                ctype=((SCANNER)(CUR$.SL$)).INOTY;
                                new SCANNER$L2Coder$NewQuant(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).C_local);
                                // JavaLine 427 ==> SourceLine 1922
                                p_or_c_qt=cquant;
                                // JavaLine 429 ==> SourceLine 1924
                                new SCANNER$L2Coder$brecinit(((SCANNER$L2Coder)CUR$),ckind);
                                // JavaLine 431 ==> SourceLine 1925
                                p_or_c_qt.descr=cbrec;
                                // JavaLine 433 ==> SourceLine 1926
                                if((ckind==(((SCANNER)(CUR$.SL$)).K_record))) {
                                    cbrec.declquant=p_or_c_qt;
                                }
                                // JavaLine 437 ==> SourceLine 1927
                                p_or_c_qt.ftag=(-(cqual));
                                // JavaLine 439 ==> SourceLine 1928
                                GOTO$(BLOCKOUT); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1919",1928);
                            }
                            case 32: 
                            // JavaLine 444 ==> SourceLine 1932
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1932",1932);
                                new SCANNER$L2Coder$brecinit(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).K_prefbl);
                                cbrec.stmtag=cbrec.inrtag=((char)2);
                                // JavaLine 449 ==> SourceLine 1933
                                GOTO$(BLOCKOUT); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1932",1933);
                            }
                            case 92: 
                            // JavaLine 454 ==> SourceLine 1937
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1937",1937);
                                new SCANNER$L2Coder$brecinit(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).K_subbl);
                                // JavaLine 458 ==> SourceLine 1938
                                LABEL$(5); // BLOCKOUT
                                new SCANNER$L2Coder$store3chars(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).opn,cbrec.blnohi,cbrec.blnolo);
                                // JavaLine 461 ==> SourceLine 1939
                                GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1937",1939);
                            }
                            case 117: 
                            case 16: 
                            // JavaLine 467 ==> SourceLine 1943
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1943",1943);
                                if((cbrec.kind==(((SCANNER)(CUR$.SL$)).K_class))) {
                                    // JavaLine 471 ==> SourceLine 1945
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1945",1945);
                                        {
                                            // BEGIN INSPECTION 
                                            inspect$1945$14=cbrec;
                                            if(inspect$1945$14!=null) //INSPECT inspect$1945$14
                                            // JavaLine 478 ==> SourceLine 1946
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1946",1946);
                                                virq=inspect$1945$14.favirt;
                                                // JavaLine 482 ==> SourceLine 1947
                                                while(true) {
                                                    {
                                                        // BEGIN INSPECTION 
                                                        inspect$1947$15=virq;
                                                        if(inspect$1947$15!=null) //INSPECT inspect$1947$15
                                                        // JavaLine 488 ==> SourceLine 1950
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement1950",1950);
                                                            if((inspect$1947$15.kind!=(((SCANNER)(CUR$.SL$)).K_proc))) {
                                                                GOTO$(NXTVIRT); // GOTO EVALUATED LABEL
                                                            }
                                                            // JavaLine 494 ==> SourceLine 1951
                                                            pq=((COMMON$quantity)(inspect$1945$14.fpar.next));
                                                            // JavaLine 496 ==> SourceLine 1952
                                                            while((pq!=(null))) {
                                                                // JavaLine 498 ==> SourceLine 1953
                                                                {
                                                                    TRACE_BEGIN_STM$("CompoundStatement1953",1953);
                                                                    if((pq.symb==(inspect$1947$15.symb))) {
                                                                        // JavaLine 502 ==> SourceLine 1954
                                                                        GOTO$(NXTVIRT); // GOTO EVALUATED LABEL
                                                                    }
                                                                    // JavaLine 505 ==> SourceLine 1955
                                                                    pq=((COMMON$quantity)(pq.next));
                                                                    TRACE_END_STM$("CompoundStatement1953",1955);
                                                                }
                                                            }
                                                            // JavaLine 510 ==> SourceLine 1956
                                                            ctype=inspect$1947$15.type;
                                                            ckind=((SCANNER)(CUR$.SL$)).K_proc;
                                                            // JavaLine 513 ==> SourceLine 1957
                                                            new SCANNER$L2Coder$NewQuant(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).C_local);
                                                            // JavaLine 515 ==> SourceLine 1958
                                                            cquant.line=inspect$1947$15.line;
                                                            cquant.ftag=inspect$1947$15.ftag;
                                                            // JavaLine 518 ==> SourceLine 1959
                                                            cquant.symb=inspect$1947$15.symb;
                                                            // JavaLine 520 ==> SourceLine 1960
                                                            cquant.dim=78;
                                                            // JavaLine 522 ==> SourceLine 1961
                                                            xquant=cquant;
                                                            // JavaLine 524 ==> SourceLine 1962
                                                            new SCANNER$L2Coder$brecinit(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).K_proc);
                                                            xquant.descr=cbrec;
                                                            // JavaLine 527 ==> SourceLine 1963
                                                            if((inspect$1947$15.descr!=(null))) {
                                                                // JavaLine 529 ==> SourceLine 1964
                                                                cbrec.fpar.next=inspect$1947$15.descr.fpar;
                                                            }
                                                            // JavaLine 532 ==> SourceLine 1966
                                                            xbrec=cbrec;
                                                            cbrec.line1=inspect$1947$15.line;
                                                            new SCANNER$L2Coder$brecterm(((SCANNER$L2Coder)CUR$));
                                                            // JavaLine 536 ==> SourceLine 1967
                                                            new SCANNER$L2Coder$brecinit(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).K_proc);
                                                            cbrec.line1=inspect$1947$15.line;
                                                            // JavaLine 539 ==> SourceLine 1968
                                                            {
                                                                // BEGIN INSPECTION 
                                                                inspect$1968$16=new COMMON$idpack(((SCANNER)(CUR$.SL$))).STM$();
                                                                if(inspect$1968$16!=null) //INSPECT inspect$1968$16
                                                                // JavaLine 544 ==> SourceLine 1970
                                                                {
                                                                    TRACE_BEGIN_STM$("CompoundStatement1970",1970);
                                                                    cbrec.hidlist=((COMMON$idpack)inspect$1968$16);
                                                                    // JavaLine 548 ==> SourceLine 1971
                                                                    inspect$1968$16.idhi=xbrec.blnohi;
                                                                    inspect$1968$16.idlo=xbrec.blnolo;
                                                                    TRACE_END_STM$("CompoundStatement1970",1971);
                                                                }
                                                            }
                                                            // JavaLine 554 ==> SourceLine 1973
                                                            new SCANNER$L2Coder$store3chars(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).IBREC,cbrec.blnohi,cbrec.blnolo);
                                                            // JavaLine 556 ==> SourceLine 1974
                                                            new SCANNER$L2Coder$brecterm(((SCANNER$L2Coder)CUR$));
                                                            // JavaLine 558 ==> SourceLine 1975
                                                            storeChar(((SCANNER)(CUR$.SL$)).IEREC,L2buf,L2p);
                                                            L2p=(L2p+(1));
                                                            // JavaLine 561 ==> SourceLine 1976
                                                            if((L2p>(L2limit))) {
                                                                new SCANNER$L2Coder$outbuffer(((SCANNER$L2Coder)CUR$));
                                                            }
                                                            // JavaLine 565 ==> SourceLine 1977
                                                            LABEL$(6); // NXTVIRT
                                                            virq=((COMMON$quantity)(inspect$1947$15.next));
                                                            TRACE_END_STM$("CompoundStatement1950",1977);
                                                        }
                                                        else // OTHERWISE 
                                                        // JavaLine 571 ==> SourceLine 1978
                                                        GOTO$(EXvloop); // GOTO EVALUATED LABEL
                                                    }
                                                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                                                }
                                                // JavaLine 576 ==> SourceLine 1980
                                                LABEL$(9); // EXvloop
                                                fvis=inspect$1945$14.hidlist;
                                                inspect$1945$14.hidlist=x=null;
                                                // JavaLine 580 ==> SourceLine 1981
                                                while((fvis!=(null))) {
                                                    // JavaLine 582 ==> SourceLine 1983
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement1983",1983);
                                                        if(IS$(fvis,SCANNER$protpack.class)) {
                                                            // JavaLine 586 ==> SourceLine 1985
                                                            {
                                                                TRACE_BEGIN_STM$("CompoundStatement1985",1985);
                                                                iihi=fvis.idhi;
                                                                iilo=fvis.idlo;
                                                                // JavaLine 591 ==> SourceLine 1986
                                                                locals=false;
                                                                notok=true;
                                                                // JavaLine 594 ==> SourceLine 1987
                                                                pq=inspect$1945$14.favirt;
                                                                // JavaLine 596 ==> SourceLine 1996
                                                                LABEL$(7); // L1
                                                                // JavaLine 598 ==> SourceLine 1988
                                                                while((pq!=(null))) {
                                                                    // JavaLine 600 ==> SourceLine 1989
                                                                    {
                                                                        TRACE_BEGIN_STM$("CompoundStatement1989",1989);
                                                                        if(((pq.symb==(new COMMON$boxof(((SCANNER)(CUR$.SL$)),iihi,iilo).RESULT$))&&(((pq.protect==(((char)0)))||((pq.type==(((SCANNER)(CUR$.SL$)).ILABE))))))) {
                                                                            // JavaLine 604 ==> SourceLine 1991
                                                                            {
                                                                                TRACE_BEGIN_STM$("CompoundStatement1991",1991);
                                                                                pq.protect=((char)1);
                                                                                // JavaLine 608 ==> SourceLine 1992
                                                                                if(locals) {
                                                                                    GOTO$(FOUND); // GOTO EVALUATED LABEL
                                                                                }
                                                                                // JavaLine 612 ==> SourceLine 1994
                                                                                notok=false;
                                                                                TRACE_END_STM$("CompoundStatement1991",1994);
                                                                            }
                                                                        }
                                                                        // JavaLine 617 ==> SourceLine 1995
                                                                        pq=((COMMON$quantity)(pq.next));
                                                                        TRACE_END_STM$("CompoundStatement1989",1995);
                                                                    }
                                                                }
                                                                // JavaLine 622 ==> SourceLine 1997
                                                                if((!(locals))) {
                                                                    // JavaLine 624 ==> SourceLine 1998
                                                                    {
                                                                        TRACE_BEGIN_STM$("CompoundStatement1998",1998);
                                                                        locals=true;
                                                                        pq=((COMMON$quantity)(inspect$1945$14.fpar.next));
                                                                        GOTO$(L1); // GOTO EVALUATED LABEL
                                                                        TRACE_END_STM$("CompoundStatement1998",1998);
                                                                    }
                                                                }
                                                                // JavaLine 633 ==> SourceLine 2012
                                                                if(notok) {
                                                                    // JavaLine 635 ==> SourceLine 2013
                                                                    {
                                                                        TRACE_BEGIN_STM$("CompoundStatement2013",2013);
                                                                        new ERRMSG$error1id(((SCANNER)(CUR$.SL$)),(-(290)),new COMMON$boxof(((SCANNER)(CUR$.SL$)),iihi,iilo).RESULT$);
                                                                        // JavaLine 639 ==> SourceLine 2015
                                                                        {
                                                                            // BEGIN INSPECTION 
                                                                            inspect$2015$17=fvis.next;
                                                                            if(inspect$2015$17!=null) //INSPECT inspect$2015$17
                                                                            // JavaLine 644 ==> SourceLine 2016
                                                                            if((((inspect$2015$17.idlo==(iilo))&&((inspect$2015$17.idhi==(iihi))))&&(IS$(((COMMON$idpack)inspect$2015$17),COMMON$idpack.class)))) {
                                                                                // JavaLine 646 ==> SourceLine 2018
                                                                                fvis=fvis.next;
                                                                            }
                                                                        }
                                                                        TRACE_END_STM$("CompoundStatement2013",2018);
                                                                    }
                                                                }
                                                                // JavaLine 653 ==> SourceLine 2021
                                                                LABEL$(8); // FOUND
                                                                TRACE_END_STM$("CompoundStatement1985",2021);
                                                            }
                                                        } else
                                                        // JavaLine 658 ==> SourceLine 2022
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement2022",2022);
                                                            if((x==(null))) {
                                                                x=inspect$1945$14.hidlist=fvis;
                                                            } else
                                                            // JavaLine 664 ==> SourceLine 2023
                                                            x=x.next=fvis;
                                                            TRACE_END_STM$("CompoundStatement2022",2023);
                                                        }
                                                        // JavaLine 668 ==> SourceLine 2025
                                                        fvis=fvis.next;
                                                        TRACE_END_STM$("CompoundStatement1983",2025);
                                                    }
                                                }
                                                // JavaLine 673 ==> SourceLine 2027
                                                if((x!=(null))) {
                                                    x.next=null;
                                                }
                                                TRACE_END_STM$("CompoundStatement1946",2027);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement1945",2027);
                                    }
                                }
                                // JavaLine 683 ==> SourceLine 2031
                                if((((SCANNER)(CUR$.SL$)).opdlo!=(((SCANNER)(CUR$.SL$)).NUL))) {
                                    // JavaLine 685 ==> SourceLine 2032
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement2032",2032);
                                        cbrec.stmtag=((char)2);
                                        TRACE_END_STM$("CompoundStatement2032",2032);
                                    }
                                }
                                // JavaLine 692 ==> SourceLine 2035
                                lastlinenr=((SCANNER)(CUR$.SL$)).linenr;
                                new SCANNER$L2Coder$storecharint(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).IROPD,lastlinenr);
                                // JavaLine 695 ==> SourceLine 2036
                                GOTO$(btout); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1943",2036);
                            }
                            case 126: 
                            case 106: 
                            case 37: 
                            case 53: 
                            // JavaLine 703 ==> SourceLine 2040
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2040",2040);
                                LABEL$(10); // btout
                                new SCANNER$L2Coder$brecterm(((SCANNER$L2Coder)CUR$));
                                GOTO$(OPNOUT); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2040",2040);
                            }
                            case 26: 
                            // JavaLine 712 ==> SourceLine 2044
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2044",2044);
                                if((((SCANNER)(CUR$.SL$)).opdlo!=(((SCANNER)(CUR$.SL$)).NUL))) {
                                    // JavaLine 716 ==> SourceLine 2045
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement2045",2045);
                                        cbrec.stmtag=((char)2);
                                        TRACE_END_STM$("CompoundStatement2045",2045);
                                    }
                                }
                                // JavaLine 723 ==> SourceLine 2048
                                cbrec.inrtag=((char)2);
                                GOTO$(OPNOUT); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2044",2048);
                            }
                            case 56: 
                            // JavaLine 729 ==> SourceLine 2052
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2052",2052);
                                ctype=((SCANNER)(CUR$.SL$)).optx;
                                ckind=((SCANNER)(CUR$.SL$)).K_ident;
                                cqual=0;
                                // JavaLine 735 ==> SourceLine 2053
                                xbrec=cbrec;
                                xquant=cquant;
                                // JavaLine 738 ==> SourceLine 2054
                                while((cbrec.kind==(((SCANNER)(CUR$.SL$)).K_labbl))) {
                                    cbrec=cbrec.fpar.encl;
                                }
                                // JavaLine 742 ==> SourceLine 2055
                                cquant=cbrec.fpar;
                                // JavaLine 744 ==> SourceLine 2056
                                while((cquant.next!=(null))) {
                                    // JavaLine 746 ==> SourceLine 2057
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement2057",2057);
                                        cquant=((COMMON$quantity)(cquant.next));
                                        // JavaLine 750 ==> SourceLine 2058
                                        if((cquant.symb==(new COMMON$boxof(((SCANNER)(CUR$.SL$)),((SCANNER)(CUR$.SL$)).opdhi,((SCANNER)(CUR$.SL$)).opdlo).RESULT$))) {
                                            GOTO$(Qfound); // GOTO EVALUATED LABEL
                                        }
                                        TRACE_END_STM$("CompoundStatement2057",2058);
                                    }
                                }
                                // JavaLine 757 ==> SourceLine 2060
                                new SCANNER$L2Coder$NewQuant(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).C_local);
                                // JavaLine 759 ==> SourceLine 2061
                                if((ctype==(((SCANNER)(CUR$.SL$)).ILABE))) {
                                    // JavaLine 761 ==> SourceLine 2062
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement2062",2062);
                                        cquant.kind=((SCANNER)(CUR$.SL$)).K_label;
                                        cquant.dim=1;
                                        TRACE_END_STM$("CompoundStatement2062",2062);
                                    }
                                }
                                // JavaLine 769 ==> SourceLine 2063
                                LABEL$(11); // Qfound
                                cbrec=xbrec;
                                cquant=xquant;
                                // JavaLine 773 ==> SourceLine 2064
                                if((ctype==(((SCANNER)(CUR$.SL$)).ILABE))) {
                                    GOTO$(OPDOUT); // GOTO EVALUATED LABEL
                                }
                                // JavaLine 777 ==> SourceLine 2065
                                GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2052",2065);
                            }
                            case 113: 
                            // JavaLine 782 ==> SourceLine 2069
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2069",2069);
                                cbrec.dcltag=((char)2);
                                // JavaLine 786 ==> SourceLine 2070
                                dimcount=0;
                                // JavaLine 788 ==> SourceLine 2071
                                ckind=((SCANNER)(CUR$.SL$)).K_switch;
                                GOTO$(genlab); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2069",2071);
                            }
                            case 77: 
                            // JavaLine 794 ==> SourceLine 2075
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2075",2075);
                                ckind=((SCANNER)(CUR$.SL$)).K_label;
                                // JavaLine 798 ==> SourceLine 2076
                                LABEL$(12); // genlab
                                ctype=((SCANNER)(CUR$.SL$)).ILABE;
                                // JavaLine 801 ==> SourceLine 2077
                                cqual=0;
                                // JavaLine 803 ==> SourceLine 2078
                                new SCANNER$L2Coder$NewQuant(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).C_local);
                                // JavaLine 805 ==> SourceLine 2079
                                cquant.protect=((char)1);
                                // JavaLine 807 ==> SourceLine 2080
                                if((((SCANNER)(CUR$.SL$)).opn==(((SCANNER)(CUR$.SL$)).IWHIL))) {
                                    cquant.dim=1;
                                }
                                // JavaLine 811 ==> SourceLine 2081
                                GOTO$(OPDOUT); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2075",2081);
                            }
                            case 94: 
                            // JavaLine 816 ==> SourceLine 2085
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2085",2085);
                                ckind=((SCANNER)(CUR$.SL$)).K_ident;
                                new SCANNER$L2Coder$NewQuant(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).C_local);
                                // JavaLine 821 ==> SourceLine 2086
                                GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2085",2086);
                            }
                            case 144: 
                            case 114: 
                            // JavaLine 827 ==> SourceLine 2096
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2096",2096);
                                dimcount=(dimcount+(1));
                                GOTO$(OPNOUT); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2096",2096);
                            }
                            case 143: 
                            // JavaLine 835 ==> SourceLine 2100
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2100",2100);
                                cquant.dim=dimcount;
                                // JavaLine 839 ==> SourceLine 2101
                                GOTO$(OPNOUT); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2100",2101);
                            }
                            case 140: 
                            // JavaLine 844 ==> SourceLine 2105
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2105",2105);
                                cquant.kind=((SCANNER)(CUR$.SL$)).K_rep;
                                cquant.dim=1;
                                cquant.encl=cbrec;
                                // JavaLine 850 ==> SourceLine 2106
                                xquant=cquant;
                                new SCANNER$L2Coder$brecinit(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).K_rep);
                                // JavaLine 853 ==> SourceLine 2107
                                xquant.descr=cbrec;
                                cbrec.declquant=xquant;
                                // JavaLine 856 ==> SourceLine 2108
                                cbrec.line1=((SCANNER)(CUR$.SL$)).repcount;
                                // JavaLine 858 ==> SourceLine 2109
                                new SCANNER$L2Coder$brecterm(((SCANNER$L2Coder)CUR$));
                                GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2105",2109);
                            }
                            case 97: 
                            // JavaLine 864 ==> SourceLine 2113
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2113",2113);
                                cquant.kind=((SCANNER)(CUR$.SL$)).K_array;
                                // JavaLine 868 ==> SourceLine 2114
                                dimcount=0;
                                if((firstarr==(null))) {
                                    firstarr=cquant;
                                }
                                // JavaLine 873 ==> SourceLine 2115
                                cbrec.dcltag=((char)2);
                                // JavaLine 875 ==> SourceLine 2116
                                {
                                    // BEGIN INSPECTION 
                                    inspect$2116$18=cquant.symb;
                                    if(inspect$2116$18!=null) //INSPECT inspect$2116$18
                                    new SCANNER$L2Coder$store3chars(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).IDCLA,inspect$2116$18.idhi,inspect$2116$18.idlo);
                                }
                                // JavaLine 882 ==> SourceLine 2117
                                new SCANNER$L2Coder$store3chars(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).IINTG,((SCANNER)(CUR$.SL$)).zerohi,((SCANNER)(CUR$.SL$)).zerolo);
                                // JavaLine 884 ==> SourceLine 2118
                                ((SCANNER)(CUR$.SL$)).opn=((SCANNER)(CUR$.SL$)).IBNDE;
                                GOTO$(OPNOUT); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2113",2118);
                            }
                            case 109: 
                            // JavaLine 890 ==> SourceLine 2122
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2122",2122);
                                ckind=((SCANNER)(CUR$.SL$)).K_array;
                                new SCANNER$L2Coder$NewQuant(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).C_local);
                                // JavaLine 895 ==> SourceLine 2123
                                dimcount=0;
                                if((firstarr==(null))) {
                                    firstarr=cquant;
                                }
                                // JavaLine 900 ==> SourceLine 2124
                                cbrec.dcltag=((char)2);
                                // JavaLine 902 ==> SourceLine 2125
                                GOTO$(OPDOUT); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2122",2125);
                            }
                            case 99: 
                            // JavaLine 907 ==> SourceLine 2129
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2129",2129);
                                dimcount=(dimcount+(1));
                                // JavaLine 911 ==> SourceLine 2130
                                while(true) {
                                    {
                                        // BEGIN INSPECTION 
                                        inspect$2130$19=firstarr;
                                        if(inspect$2130$19!=null) //INSPECT inspect$2130$19
                                        // JavaLine 917 ==> SourceLine 2131
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2131",2131);
                                            inspect$2130$19.dim=dimcount;
                                            firstarr=((COMMON$quantity)(inspect$2130$19.next));
                                            TRACE_END_STM$("CompoundStatement2131",2131);
                                        }
                                        else // OTHERWISE 
                                        // JavaLine 925 ==> SourceLine 2132
                                        GOTO$(OPNOUT); // GOTO EVALUATED LABEL
                                    }
                                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                                }
                                TRACE_END_STM$("CompoundStatement2129",2132);
                            }
                            case 64: 
                            // JavaLine 933 ==> SourceLine 2138
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2138",2138);
                                GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2138",2138);
                            }
                            case 65: 
                            // JavaLine 940 ==> SourceLine 2144
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2144",2144);
                                if((cquant.virtno==(0))) {
                                    // JavaLine 944 ==> SourceLine 2145
                                    cquant.virtno=((rank(cquant.symb.idhi)*(256))+(rank(cquant.symb.idlo)));
                                }
                                // JavaLine 947 ==> SourceLine 2147
                                cquant.symb=new COMMON$boxof(((SCANNER)(CUR$.SL$)),((SCANNER)(CUR$.SL$)).opdhi,((SCANNER)(CUR$.SL$)).opdlo).RESULT$;
                                cquant.type=ctype;
                                // JavaLine 950 ==> SourceLine 2148
                                cquant.ftag=(-(cqual));
                                // JavaLine 952 ==> SourceLine 2149
                                GOTO$(genbrc); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2144",2149);
                            }
                            case 112: 
                            // JavaLine 957 ==> SourceLine 2153
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2153",2153);
                                LABEL$(13); // lidclp
                                ckind=((SCANNER)(CUR$.SL$)).K_proc;
                                new SCANNER$L2Coder$NewQuant(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).C_local);
                                // JavaLine 963 ==> SourceLine 2155
                                LABEL$(14); // genbrc
                                p_or_c_qt=cquant;
                                // JavaLine 966 ==> SourceLine 2157
                                new SCANNER$L2Coder$brecinit(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).K_proc);
                                p_or_c_qt.descr=cbrec;
                                // JavaLine 969 ==> SourceLine 2159
                                new SCANNER$L2Coder$store3chars(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).opn,((SCANNER)(CUR$.SL$)).nextblhi,((SCANNER)(CUR$.SL$)).nextbllo);
                                // JavaLine 971 ==> SourceLine 2161
                                GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2153",2161);
                            }
                            case 103: 
                            // JavaLine 976 ==> SourceLine 2168
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2168",2168);
                                {
                                    // BEGIN INSPECTION 
                                    inspect$2168$20=vquant;
                                    if(inspect$2168$20!=null) //INSPECT inspect$2168$20
                                    // JavaLine 983 ==> SourceLine 2169
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement2169",2169);
                                        if((inspect$2168$20.type!=(((SCANNER)(CUR$.SL$)).INOTY))) {
                                            new ERRMSG$error1id(((SCANNER)(CUR$.SL$)),(-(444)),inspect$2168$20.symb);
                                        }
                                        // JavaLine 989 ==> SourceLine 2171
                                        inspect$2168$20.symb=new COMMON$boxof(((SCANNER)(CUR$.SL$)),((SCANNER)(CUR$.SL$)).opdhi,((SCANNER)(CUR$.SL$)).opdlo).RESULT$;
                                        inspect$2168$20.type=ctype;
                                        // JavaLine 992 ==> SourceLine 2172
                                        inspect$2168$20.ftag=(-(cqual));
                                        // JavaLine 994 ==> SourceLine 2173
                                        new SCANNER$L2Coder$brecinit(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).K_proc);
                                        inspect$2168$20.descr=cbrec;
                                        TRACE_END_STM$("CompoundStatement2169",2173);
                                    }
                                }
                                // JavaLine 1000 ==> SourceLine 2175
                                GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2168",2175);
                            }
                            case 121: 
                            // JavaLine 1005 ==> SourceLine 2179
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2179",2179);
                                new SCANNER$L2Coder$brecterm(((SCANNER$L2Coder)CUR$));
                                // JavaLine 1009 ==> SourceLine 2180
                                GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2179",2180);
                            }
                            case 95: 
                            // JavaLine 1014 ==> SourceLine 2184
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2184",2184);
                                ctype=((SCANNER)(CUR$.SL$)).IELSE;
                                ckind=((SCANNER)(CUR$.SL$)).K_unknwn;
                                // JavaLine 1019 ==> SourceLine 2185
                                cqual=0;
                                // JavaLine 1021 ==> SourceLine 2186
                                new SCANNER$L2Coder$NewQuant(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).C_unspec);
                                // JavaLine 1023 ==> SourceLine 2187
                                GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2184",2187);
                            }
                            case 10: 
                            case 33: 
                            // JavaLine 1029 ==> SourceLine 2191
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2191",2191);
                                xquant=cbrec.fpar;
                                // JavaLine 1033 ==> SourceLine 2192
                                while(((xquant.symb!=(new COMMON$boxof(((SCANNER)(CUR$.SL$)),((SCANNER)(CUR$.SL$)).opdhi,((SCANNER)(CUR$.SL$)).opdlo).RESULT$))&&((xquant.next!=(null))))) {
                                    // JavaLine 1035 ==> SourceLine 2194
                                    xquant=((COMMON$quantity)(xquant.next));
                                }
                                // JavaLine 1038 ==> SourceLine 2195
                                if(((xquant.symb.idhi!=(((SCANNER)(CUR$.SL$)).opdhi))||((xquant.symb.idlo!=(((SCANNER)(CUR$.SL$)).opdlo))))) {
                                    // JavaLine 1040 ==> SourceLine 2197
                                    new SCANNER$L2Coder$specErr(((SCANNER$L2Coder)CUR$),223);
                                } else
                                if((xquant.categ!=(((SCANNER)(CUR$.SL$)).C_unspec))) {
                                    // JavaLine 1044 ==> SourceLine 2198
                                    new SCANNER$L2Coder$specErr(((SCANNER$L2Coder)CUR$),224);
                                } else
                                xquant.categ=(((((SCANNER)(CUR$.SL$)).opn==(((SCANNER)(CUR$.SL$)).IVALU)))?(((SCANNER)(CUR$.SL$)).C_value):(((SCANNER)(CUR$.SL$)).C_name));
                                // JavaLine 1048 ==> SourceLine 2199
                                GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2191",2199);
                            }
                            case 137: 
                            case 108: 
                            // JavaLine 1054 ==> SourceLine 2203
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2203",2203);
                                xquant=cbrec.fpar;
                                // JavaLine 1058 ==> SourceLine 2204
                                while(((xquant.symb!=(new COMMON$boxof(((SCANNER)(CUR$.SL$)),((SCANNER)(CUR$.SL$)).opdhi,((SCANNER)(CUR$.SL$)).opdlo).RESULT$))&&((xquant.next!=(null))))) {
                                    // JavaLine 1060 ==> SourceLine 2206
                                    xquant=((COMMON$quantity)(xquant.next));
                                }
                                // JavaLine 1063 ==> SourceLine 2208
                                {
                                    // BEGIN INSPECTION 
                                    inspect$2208$21=xquant;
                                    if(inspect$2208$21!=null) //INSPECT inspect$2208$21
                                    // JavaLine 1068 ==> SourceLine 2209
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement2209",2209);
                                        if(((inspect$2208$21.symb.idhi!=(((SCANNER)(CUR$.SL$)).opdhi))||((inspect$2208$21.symb.idlo!=(((SCANNER)(CUR$.SL$)).opdlo))))) {
                                            // JavaLine 1072 ==> SourceLine 2211
                                            new SCANNER$L2Coder$specErr(((SCANNER$L2Coder)CUR$),223);
                                        } else
                                        if((inspect$2208$21.kind!=(((SCANNER)(CUR$.SL$)).K_unknwn))) {
                                            // JavaLine 1076 ==> SourceLine 2212
                                            new SCANNER$L2Coder$specErr(((SCANNER$L2Coder)CUR$),224);
                                        } else
                                        // JavaLine 1079 ==> SourceLine 2213
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2213",2213);
                                            inspect$2208$21.type=ctype;
                                            inspect$2208$21.kind=ckind;
                                            // JavaLine 1084 ==> SourceLine 2214
                                            inspect$2208$21.ftag=(-(cqual));
                                            TRACE_END_STM$("CompoundStatement2213",2214);
                                        }
                                        TRACE_END_STM$("CompoundStatement2209",2214);
                                    }
                                }
                                // JavaLine 1091 ==> SourceLine 2217
                                GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2203",2217);
                            }
                            case 120: 
                            // JavaLine 1096 ==> SourceLine 2221
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2221",2221);
                                if((cbrec.kind==(((SCANNER)(CUR$.SL$)).K_proc))) {
                                    // JavaLine 1100 ==> SourceLine 2224
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement2224",2224);
                                        xbrec=cbrec;
                                        new SCANNER$L2Coder$brecterm(((SCANNER$L2Coder)CUR$));
                                        // JavaLine 1105 ==> SourceLine 2225
                                        if((cquant.categ!=(((SCANNER)(CUR$.SL$)).C_extnal))) {
                                            // JavaLine 1107 ==> SourceLine 2226
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement2226",2226);
                                                new SCANNER$L2Coder$brecinit(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).K_proc);
                                                // JavaLine 1111 ==> SourceLine 2227
                                                {
                                                    // BEGIN INSPECTION 
                                                    inspect$2227$22=new COMMON$idpack(((SCANNER)(CUR$.SL$))).STM$();
                                                    if(inspect$2227$22!=null) //INSPECT inspect$2227$22
                                                    // JavaLine 1116 ==> SourceLine 2229
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement2229",2229);
                                                        cbrec.hidlist=((COMMON$idpack)inspect$2227$22);
                                                        // JavaLine 1120 ==> SourceLine 2230
                                                        inspect$2227$22.idhi=xbrec.blnohi;
                                                        inspect$2227$22.idlo=xbrec.blnolo;
                                                        TRACE_END_STM$("CompoundStatement2229",2230);
                                                    }
                                                }
                                                // JavaLine 1126 ==> SourceLine 2232
                                                cbrec.line1=xbrec.line1;
                                                TRACE_END_STM$("CompoundStatement2226",2232);
                                            }
                                        } else
                                        // JavaLine 1131 ==> SourceLine 2234
                                        if(((cquant.dim==(rank(((SCANNER)(CUR$.SL$)).Cindex)))||((cquant.dim==(rank(((SCANNER)(CUR$.SL$)).Pascalindex)))))) {
                                            // JavaLine 1133 ==> SourceLine 2237
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement2237",2237);
                                                pq=xbrec.fpar;
                                                // JavaLine 1137 ==> SourceLine 2238
                                                while((pq!=(null))) {
                                                    // JavaLine 1139 ==> SourceLine 2239
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement2239",2239);
                                                        if((pq.kind==(((SCANNER)(CUR$.SL$)).K_proc))) {
                                                            // JavaLine 1143 ==> SourceLine 2240
                                                            {
                                                                TRACE_BEGIN_STM$("CompoundStatement2240",2240);
                                                                if((pq.categ!=(((SCANNER)(CUR$.SL$)).C_name))) {
                                                                    GOTO$(Nspec); // GOTO EVALUATED LABEL
                                                                }
                                                                TRACE_END_STM$("CompoundStatement2240",2240);
                                                            }
                                                        } else
                                                        // JavaLine 1152 ==> SourceLine 2241
                                                        if((pq.categ==(((SCANNER)(CUR$.SL$)).C_unspec))) {
                                                            // JavaLine 1154 ==> SourceLine 2242
                                                            {
                                                                TRACE_BEGIN_STM$("CompoundStatement2242",2242);
                                                                if((pq.kind==(((SCANNER)(CUR$.SL$)).K_array))) {
                                                                    GOTO$(Nspec); // GOTO EVALUATED LABEL
                                                                }
                                                                // JavaLine 1160 ==> SourceLine 2243
                                                                switch(pq.type) { // BEGIN SWITCH STATEMENT
                                                                case 1: 
                                                                case 2: 
                                                                case 3: 
                                                                case 4: 
                                                                case 5: 
                                                                case 6: 
                                                                case 9: 
                                                                // JavaLine 1169 ==> SourceLine 2246
                                                                {
                                                                    TRACE_BEGIN_STM$("CompoundStatement2246",2246);
                                                                    pq.categ=((SCANNER)(CUR$.SL$)).C_value;
                                                                    iii=244;
                                                                    TRACE_END_STM$("CompoundStatement2246",2246);
                                                                }
                                                                default:
                                                                // JavaLine 1177 ==> SourceLine 2249
                                                                {
                                                                    TRACE_BEGIN_STM$("CompoundStatement2249",2249);
                                                                    LABEL$(15); // Nspec
                                                                    pq.categ=((SCANNER)(CUR$.SL$)).C_name;
                                                                    iii=248;
                                                                    TRACE_END_STM$("CompoundStatement2249",2249);
                                                                }
                                                            } // END SWITCH STATEMENT
                                                            // JavaLine 1186 ==> SourceLine 2252
                                                            ((SCANNER)(CUR$.SL$)).diag.Elt[0-((SCANNER)(CUR$.SL$)).diag.LB[0]]=pq.symb.symbol;
                                                            // JavaLine 1188 ==> SourceLine 2253
                                                            ((SCANNER)(CUR$.SL$)).diag.Elt[1-((SCANNER)(CUR$.SL$)).diag.LB[0]]=cquant.symb.symbol;
                                                            // JavaLine 1190 ==> SourceLine 2254
                                                            new SCANNER$P1warn(((SCANNER)(CUR$.SL$)),iii);
                                                            TRACE_END_STM$("CompoundStatement2242",2254);
                                                        }
                                                    }
                                                    // JavaLine 1195 ==> SourceLine 2256
                                                    pq=((COMMON$quantity)(pq.next));
                                                    TRACE_END_STM$("CompoundStatement2239",2256);
                                                }
                                            }
                                            TRACE_END_STM$("CompoundStatement2237",2256);
                                        }
                                    }
                                    TRACE_END_STM$("CompoundStatement2224",2256);
                                }
                            }
                            // JavaLine 1206 ==> SourceLine 2260
                            GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement2221",2260);
                        }
                        case 148: 
                        // JavaLine 1211 ==> SourceLine 2264
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2264",2264);
                            new SCANNER$L2Coder$NewQuant(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).C_virt);
                            // JavaLine 1215 ==> SourceLine 2265
                            GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement2264",2265);
                        }
                        case 55: 
                        // JavaLine 1220 ==> SourceLine 2269
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2269",2269);
                            new SCANNER$L2Coder$brecterm(((SCANNER$L2Coder)CUR$));
                            GOTO$(LIFWHN); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement2269",2269);
                        }
                        case 105: 
                        case 127: 
                        // JavaLine 1229 ==> SourceLine 2273
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2273",2273);
                            LABEL$(16); // LIFWHN
                            new SCANNER$L2Coder$brecinit(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).K_labbl);
                            // JavaLine 1234 ==> SourceLine 2277
                            jjj=1;
                            // JavaLine 1236 ==> SourceLine 2278
                            xbrec=cbrec.fpar.encl;
                            // JavaLine 1238 ==> SourceLine 2279
                            while((xbrec.kind==(((SCANNER)(CUR$.SL$)).K_labbl))) {
                                // JavaLine 1240 ==> SourceLine 2280
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement2280",2280);
                                    if((xbrec.connests!=(0))) {
                                        jjj=(jjj+(1));
                                    }
                                    // JavaLine 1246 ==> SourceLine 2282
                                    xbrec=xbrec.fpar.encl;
                                    TRACE_END_STM$("CompoundStatement2280",2282);
                                }
                            }
                            // JavaLine 1251 ==> SourceLine 2285
                            if((xbrec.kind==(((SCANNER)(CUR$.SL$)).K_proc))) {
                                // JavaLine 1253 ==> SourceLine 2286
                                xbrec=new COMMON$getBrc(((SCANNER)(CUR$.SL$)),xbrec.hidlist.idhi,xbrec.hidlist.idlo).RESULT$;
                            }
                            // JavaLine 1256 ==> SourceLine 2289
                            cbrec.connests=jjj;
                            // JavaLine 1258 ==> SourceLine 2290
                            if((xbrec.connests<(jjj))) {
                                xbrec.connests=jjj;
                            }
                            // JavaLine 1262 ==> SourceLine 2291
                            if((((SCANNER)(CUR$.SL$)).opn==(((SCANNER)(CUR$.SL$)).ICONB))) {
                                GOTO$(BLOCKOUT); // GOTO EVALUATED LABEL
                            }
                            // JavaLine 1266 ==> SourceLine 2292
                            LABEL$(17); // QBLOCKOUT
                            new SCANNER$L2Coder$store3chars(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).opn,cbrec.blnohi,cbrec.blnolo);
                            // JavaLine 1269 ==> SourceLine 2293
                            storeChar(((SCANNER)(CUR$.SL$)).opdhi,L2buf,L2p);
                            // JavaLine 1271 ==> SourceLine 2294
                            storeChar(((SCANNER)(CUR$.SL$)).opdlo,L2buf,(L2p+(1)));
                            L2p=(L2p+(2));
                            // JavaLine 1274 ==> SourceLine 2295
                            GOTO$(NEXTOPN); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement2273",2295);
                        }
                        case 19: 
                        // JavaLine 1279 ==> SourceLine 2299
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2299",2299);
                            new SCANNER$L2Coder$brecinit(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).K_labbl);
                            GOTO$(QBLOCKOUT); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement2299",2299);
                        }
                        case 93: 
                        // JavaLine 1287 ==> SourceLine 2303
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2303",2303);
                            new SCANNER$L2Coder$brecinit(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).K_prefbl);
                            cbrec.stmtag=cbrec.inrtag=((char)2);
                            // JavaLine 1292 ==> SourceLine 2304
                            GOTO$(QBLOCKOUT); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement2303",2304);
                        }
                        case 88: 
                        // JavaLine 1297 ==> SourceLine 2309
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2309",2309);
                            while((cbrec!=(null))) {
                                new SCANNER$L2Coder$brecterm(((SCANNER$L2Coder)CUR$));
                            }
                            // JavaLine 1303 ==> SourceLine 2310
                            storeChar(((SCANNER)(CUR$.SL$)).IEOP,L2buf,L2p);
                            storeChar(((SCANNER)(CUR$.SL$)).IEOP,L2buf,(L2p+(1)));
                            // JavaLine 1306 ==> SourceLine 2311
                            TXT$.setpos(((SCANNER)(CUR$.SL$)).L2codebuffer,(L2p+(2)));
                            // JavaLine 1308 ==> SourceLine 2312
                            while(true) {
                                ((SCANNER)(CUR$.SL$)).detach();
                                   if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                            }
                            TRACE_END_STM$("CompoundStatement2309",2312);
                        }
                        case 18: 
                        // JavaLine 1316 ==> SourceLine 2317
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2317",2317);
                            new SCANNER$L2Coder$NewQuant(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).C_extnal);
                            // JavaLine 1320 ==> SourceLine 2318
                            if((ckind==(((SCANNER)(CUR$.SL$)).K_proc))) {
                                // JavaLine 1322 ==> SourceLine 2319
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement2319",2319);
                                    cquant.dim=((rank(lanhi)*(256))+(rank(lanlo)));
                                    // JavaLine 1326 ==> SourceLine 2320
                                    lanhi=lanlo=((SCANNER)(CUR$.SL$)).NUL;
                                    TRACE_END_STM$("CompoundStatement2319",2320);
                                }
                            }
                            TRACE_END_STM$("CompoundStatement2317",2320);
                        }
                        case 123: 
                        // JavaLine 1334 ==> SourceLine 2326
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2326",2326);
                            if((cquant.categ==(((SCANNER)(CUR$.SL$)).C_unknwn))) {
                                // JavaLine 1338 ==> SourceLine 2327
                                p_or_c_qt.virtno=((rank(((SCANNER)(CUR$.SL$)).opdhi)*(256))+(rank(((SCANNER)(CUR$.SL$)).opdlo)));
                            } else
                            // JavaLine 1341 ==> SourceLine 2328
                            cquant.virtno=((rank(((SCANNER)(CUR$.SL$)).opdhi)*(256))+(rank(((SCANNER)(CUR$.SL$)).opdlo)));
                            TRACE_END_STM$("CompoundStatement2326",2328);
                        }
                        case 87: 
                        // JavaLine 1346 ==> SourceLine 2346
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2346",2346);
                            if((((SCANNER)(CUR$.SL$)).opdlo!=(((SCANNER)(CUR$.SL$)).NUL))) {
                                ((SCANNER)(CUR$.SL$)).opn=((SCANNER)(CUR$.SL$)).opdlo;
                            }
                            GOTO$(OPNOUT); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement2346",2346);
                        }
                        case 51: 
                        // JavaLine 1356 ==> SourceLine 2350
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2350",2350);
                            cquant.special=((char)3);
                            // JavaLine 1360 ==> SourceLine 2351
                            if((cquant.type==(((SCANNER)(CUR$.SL$)).ISHOR))) {
                                cquant.type=((SCANNER)(CUR$.SL$)).IINTG;
                            }
                            // JavaLine 1364 ==> SourceLine 2352
                            ((SCANNER)(CUR$.SL$)).opdhi=cquant.symb.idhi;
                            ((SCANNER)(CUR$.SL$)).opdlo=cquant.symb.idlo;
                            // JavaLine 1367 ==> SourceLine 2353
                            GOTO$(OPDOUT); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement2350",2353);
                        }
                        case 124: 
                        // JavaLine 1372 ==> SourceLine 2357
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2357",2357);
                            cquant.protect=((char)2);
                            cbrec.dcltag=((char)2);
                            // JavaLine 1377 ==> SourceLine 2358
                            storeChar(((SCANNER)(CUR$.SL$)).IFASG,L2buf,L2p);
                            L2p=(L2p+(1));
                            // JavaLine 1380 ==> SourceLine 2359
                            ((SCANNER)(CUR$.SL$)).opn=((SCANNER)(CUR$.SL$)).opdlo;
                            GOTO$(OPNOUT); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement2357",2359);
                        }
                        case 136: 
                        case 40: 
                        // JavaLine 1387 ==> SourceLine 2363
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2363",2363);
                            new SCANNER$L2Coder$chainVis(((SCANNER$L2Coder)CUR$),false);
                            // JavaLine 1391 ==> SourceLine 2364
                            if((((SCANNER)(CUR$.SL$)).opn==(((SCANNER)(CUR$.SL$)).IPRHI))) {
                                GOTO$(LIHIDD); // GOTO EVALUATED LABEL
                            }
                            TRACE_END_STM$("CompoundStatement2363",2364);
                        }
                        case 22: 
                        // JavaLine 1398 ==> SourceLine 2371
                        LABEL$(21); // LIHIDD
                        // JavaLine 1400 ==> SourceLine 2370
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2370",2370);
                            new SCANNER$L2Coder$chainVis(((SCANNER$L2Coder)CUR$),true);
                            TRACE_END_STM$("CompoundStatement2370",2370);
                        }
                        case 141: 
                        // JavaLine 1407 ==> SourceLine 2376
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2376",2376);
                            new SCANNER$L2Coder$storecharint(((SCANNER$L2Coder)CUR$),((SCANNER)(CUR$.SL$)).ISSWA,cswa);
                            // JavaLine 1411 ==> SourceLine 2377
                            storeChar(char$((cswb/(256))),L2buf,L2p);
                            // JavaLine 1413 ==> SourceLine 2378
                            storeChar(char$(rem(cswb,256)),L2buf,(L2p+(1)));
                            L2p=(L2p+(2));
                            TRACE_END_STM$("CompoundStatement2376",2378);
                        }
                        case 21: 
                        // JavaLine 1419 ==> SourceLine 2386
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2386",2386);
                            storeChar(((SCANNER)(CUR$.SL$)).IGOTO,L2buf,L2p);
                            L2p=(L2p+(1));
                            // JavaLine 1424 ==> SourceLine 2388
                            ((SCANNER)(CUR$.SL$)).detach();
                            // JavaLine 1426 ==> SourceLine 2390
                            if((((SCANNER)(CUR$.SL$)).opn==(((SCANNER)(CUR$.SL$)).ISIDN))) {
                                // JavaLine 1428 ==> SourceLine 2391
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement2391",2391);
                                    symx=new COMMON$boxof(((SCANNER)(CUR$.SL$)),((SCANNER)(CUR$.SL$)).opdhi,((SCANNER)(CUR$.SL$)).opdlo).RESULT$;
                                    // JavaLine 1432 ==> SourceLine 2392
                                    pq=cbrec.favirt;
                                    // JavaLine 1434 ==> SourceLine 2393
                                    while((pq!=(null))) {
                                        // JavaLine 1436 ==> SourceLine 2394
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2394",2394);
                                            if((pq.symb==(symx))) {
                                                GOTO$(OPDOUT); // GOTO EVALUATED LABEL
                                            }
                                            // JavaLine 1442 ==> SourceLine 2395
                                            pq=((COMMON$quantity)(pq.next));
                                            TRACE_END_STM$("CompoundStatement2394",2395);
                                        }
                                    }
                                    // JavaLine 1447 ==> SourceLine 2396
                                    pq=((COMMON$quantity)(cbrec.fpar.next));
                                    // JavaLine 1449 ==> SourceLine 2397
                                    while((pq!=(null))) {
                                        // JavaLine 1451 ==> SourceLine 2398
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2398",2398);
                                            if(((pq.symb==(symx))&&((pq.kind==(((SCANNER)(CUR$.SL$)).K_label))))) {
                                                // JavaLine 1455 ==> SourceLine 2399
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement2399",2399);
                                                    if((pq.plev<(200))) {
                                                        pq.plev=(pq.plev+(1));
                                                    }
                                                    // JavaLine 1461 ==> SourceLine 2401
                                                    GOTO$(OPDOUT); // GOTO EVALUATED LABEL
                                                    TRACE_END_STM$("CompoundStatement2399",2401);
                                                }
                                            }
                                            // JavaLine 1466 ==> SourceLine 2402
                                            pq=((COMMON$quantity)(pq.next));
                                            TRACE_END_STM$("CompoundStatement2398",2402);
                                        }
                                    }
                                    TRACE_END_STM$("CompoundStatement2391",2402);
                                }
                            }
                            // JavaLine 1474 ==> SourceLine 2406
                            LABEL$(18); // NonLoc
                            GOTO$(CheckNxt); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement2386",2406);
                        }
                        default:
                    } // END SWITCH STATEMENT
                    TRACE_END_STM$("CompoundStatement1782",2406);
                }
                   if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
            }
            // JavaLine 1485 ==> SourceLine 1776
            if(inner!=null) {
                inner.STM$();
                TRACE_BEGIN_STM_AFTER_INNER$("L2Coder",1776);
            }
            break LOOP$;
        }
        catch(LABQNT$ q) {
            CUR$=THIS$;
            if(q.SL$!=CUR$ || q.prefixLevel!=5) {
                CUR$.STATE$=OperationalState.terminated;
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                throw(q);
            }
            if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
            JTX$=q.index; continue LOOP$; // EG. GOTO Lx
        }
    }
    TRACE_END_STM$("L2Coder",1776);
}
};
} // End of Constructor
// Class Statements
public SCANNER$L2Coder STM$() { return((SCANNER$L2Coder)CODE$.EXEC$()); }
public SCANNER$L2Coder START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Class L2Coder",1,1598,11,1828,13,1836,15,1889,17,1910,19,1938,21,1977,23,1988,25,2021,27,1980,29,2040,31,2063,33,2076,35,2153,37,2155,39,2249,41,2273,43,2292,45,2406,47,1783,49,1793,51,2370,54,1606,57,1607,60,1608,63,1609,66,1610,68,1611,70,1613,72,1614,74,1615,77,1616,79,1617,83,1618,85,1619,87,1620,90,1621,93,1622,97,1623,101,1627,103,1636,107,1945,109,1947,111,1968,113,2016,115,2116,117,2130,119,2168,121,2208,123,2227,139,1776,141,1777,144,1780,146,1782,149,1786,151,1783,153,1784,159,1785,165,1789,167,1793,172,1815,226,1828,232,1829,249,1836,254,1837,256,1838,258,1839,260,1840,266,1846,271,1847,283,1853,288,1854,290,1855,295,1858,299,1859,304,1861,308,1862,313,1865,317,1866,322,1869,326,1870,332,1882,336,1883,340,1885,345,1886,354,1888,358,1889,362,1890,367,1892,370,1894,376,1898,380,1899,382,1900,384,1901,389,1905,396,1908,401,1910,404,1911,409,1914,414,1915,420,1919,424,1920,427,1922,429,1924,431,1925,433,1926,437,1927,439,1928,444,1932,449,1933,454,1937,458,1938,461,1939,467,1943,471,1945,478,1946,482,1947,488,1950,494,1951,496,1952,498,1953,502,1954,505,1955,510,1956,513,1957,515,1958,518,1959,520,1960,522,1961,524,1962,527,1963,529,1964,532,1966,536,1967,539,1968,544,1970,548,1971,554,1973,556,1974,558,1975,561,1976,565,1977,571,1978,576,1980,580,1981,582,1983,586,1985,591,1986,594,1987,596,1996,598,1988,600,1989,604,1991,608,1992,612,1994,617,1995,622,1997,624,1998,633,2012,635,2013,639,2015,644,2016,646,2018,653,2021,658,2022,664,2023,668,2025,673,2027,683,2031,685,2032,692,2035,695,2036,703,2040,712,2044,716,2045,723,2048,729,2052,735,2053,738,2054,742,2055,744,2056,746,2057,750,2058,757,2060,759,2061,761,2062,769,2063,773,2064,777,2065,782,2069,786,2070,788,2071,794,2075,798,2076,801,2077,803,2078,805,2079,807,2080,811,2081,816,2085,821,2086,827,2096,835,2100,839,2101,844,2105,850,2106,853,2107,856,2108,858,2109,864,2113,868,2114,873,2115,875,2116,882,2117,884,2118,890,2122,895,2123,900,2124,902,2125,907,2129,911,2130,917,2131,925,2132,933,2138,940,2144,944,2145,947,2147,950,2148,952,2149,957,2153,963,2155,966,2157,969,2159,971,2161,976,2168,983,2169,989,2171,992,2172,994,2173,1000,2175,1005,2179,1009,2180,1014,2184,1019,2185,1021,2186,1023,2187,1029,2191,1033,2192,1035,2194,1038,2195,1040,2197,1044,2198,1048,2199,1054,2203,1058,2204,1060,2206,1063,2208,1068,2209,1072,2211,1076,2212,1079,2213,1084,2214,1091,2217,1096,2221,1100,2224,1105,2225,1107,2226,1111,2227,1116,2229,1120,2230,1126,2232,1131,2234,1133,2237,1137,2238,1139,2239,1143,2240,1152,2241,1154,2242,1160,2243,1169,2246,1177,2249,1186,2252,1188,2253,1190,2254,1195,2256,1206,2260,1211,2264,1215,2265,1220,2269,1229,2273,1234,2277,1236,2278,1238,2279,1240,2280,1246,2282,1251,2285,1253,2286,1256,2289,1258,2290,1262,2291,1266,2292,1269,2293,1271,2294,1274,2295,1279,2299,1287,2303,1292,2304,1297,2309,1303,2310,1306,2311,1308,2312,1316,2317,1320,2318,1322,2319,1326,2320,1334,2326,1338,2327,1341,2328,1346,2346,1356,2350,1360,2351,1364,2352,1367,2353,1372,2357,1377,2358,1380,2359,1387,2363,1391,2364,1398,2371,1400,2370,1407,2376,1411,2377,1413,2378,1419,2386,1424,2388,1426,2390,1428,2391,1432,2392,1434,2393,1436,2394,1442,2395,1447,2396,1449,2397,1451,2398,1455,2399,1461,2401,1466,2402,1474,2406,1485,1776,1509,2420);
}
