// JavaLine 1 ==> SourceLine 1954
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$nextargumentproducer extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=0, firstLine=1954, lastLine=2111, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 2007
    final LABQNT$ dummy=new LABQNT$(this,0,1); // Local Label #1=dummy
    // JavaLine 14 ==> SourceLine 2023
    final LABQNT$ GENINDEX=new LABQNT$(this,0,2); // Local Label #2=GENINDEX
    // JavaLine 16 ==> SourceLine 2067
    final LABQNT$ enter=new LABQNT$(this,0,3); // Local Label #3=enter
    // Declare locals as attributes
    // JavaLine 19 ==> SourceLine 1956
    public boolean inuse=false;
    // JavaLine 21 ==> SourceLine 1957
    public char kind=0;
    // JavaLine 23 ==> SourceLine 1958
    public int count=0;
    // JavaLine 25 ==> SourceLine 1963
    public int noofexpargs=0;
    // JavaLine 27 ==> SourceLine 1964
    public int argno=0;
    // JavaLine 29 ==> SourceLine 1965
    public int preflvl=0;
    // JavaLine 31 ==> SourceLine 1966
    public CHECKER1$semchecker1$nextargumentproducer pred=null;
    public CHECKER1$semchecker1$nextargumentproducer suc=null;
    // JavaLine 34 ==> SourceLine 1967
    public CHECKER1$semchecker1$identifier ident=null;
    // JavaLine 36 ==> SourceLine 1968
    public CHECKER1$semchecker1$argument firstarg=null;
    public CHECKER1$semchecker1$argument lastarg=null;
    // JavaLine 39 ==> SourceLine 1969
    public COMMON$quantity testquant=null;
    // JavaLine 41 ==> SourceLine 1971
    public CHECKER1$semchecker1$parameter newpar=null;
    public CHECKER1$semchecker1$index newindex=null;
    // JavaLine 44 ==> SourceLine 1972
    public COMMON$quantity cquant=null;
    public COMMON$brecord cbrec=null;
    // JavaLine 47 ==> SourceLine 1973
    public ARRAY$<COMMON$quantity[]>prefixChain=null;
    // Normal Constructor
    public CHECKER1$semchecker1$nextargumentproducer(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("nextargumentproducer",1973);
        int[] prefixChain$LB=new int[1]; int[] prefixChain$UB=new int[1];
        prefixChain$LB[0]=0; prefixChain$UB[0]=64;
        BOUND_CHECK$(prefixChain$LB[0],prefixChain$UB[0]);
        prefixChain=new ARRAY$<COMMON$quantity[]>(new COMMON$quantity[prefixChain$UB[0]-prefixChain$LB[0]+1],prefixChain$LB,prefixChain$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("nextargumentproducer",1973,inner);
                CHECKER1$semchecker1$nextargumentproducer THIS$=(CHECKER1$semchecker1$nextargumentproducer)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 68 ==> SourceLine 1976
                        pred=((CHECKER1$semchecker1)(CUR$.SL$)).lastnap;
                        // JavaLine 70 ==> SourceLine 1977
                        firstarg=new CHECKER1$semchecker1$argument(((CHECKER1$semchecker1)(CUR$.SL$)),0,null).STM$();
                        // JavaLine 72 ==> SourceLine 1980
                        while(true) {
                            // JavaLine 74 ==> SourceLine 1981
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1981",1981);
                                detach();
                                // JavaLine 78 ==> SourceLine 1982
                                ident=((CHECKER1$semchecker1$identifier)(((CHECKER1$semchecker1)(CUR$.SL$)).exptop));
                                kind=ident.kind;
                                inuse=true;
                                // JavaLine 82 ==> SourceLine 1983
                                lastarg=firstarg;
                                firstarg.nextarg=null;
                                // JavaLine 85 ==> SourceLine 1984
                                noofexpargs=argno=0;
                                // JavaLine 87 ==> SourceLine 1989
                                if((((kind==(((CHECKER1)(CUR$.SL$.SL$)).K_ident))||((kind==(((CHECKER1)(CUR$.SL$.SL$)).K_label))))||((kind==(((CHECKER1)(CUR$.SL$.SL$)).K_error))))) {
                                } else
                                // JavaLine 90 ==> SourceLine 1992
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1992",1992);
                                    if((((((ident.meaning.categ==(((CHECKER1)(CUR$.SL$.SL$)).C_local))||((ident.meaning.categ==(((CHECKER1)(CUR$.SL$.SL$)).C_extnal))))||((kind==(((CHECKER1)(CUR$.SL$.SL$)).K_array))))||((kind==(((CHECKER1)(CUR$.SL$.SL$)).K_rep))))||((kind==(((CHECKER1)(CUR$.SL$.SL$)).K_switch))))) {
                                        // JavaLine 94 ==> SourceLine 1995
                                        testquant=ident.meaning;
                                    } else
                                    // JavaLine 97 ==> SourceLine 1996
                                    if(((ident.meaning.categ==(((CHECKER1)(CUR$.SL$.SL$)).C_virt))&((ident.meaning.descr!=(null))))) {
                                        // JavaLine 99 ==> SourceLine 1997
                                        testquant=ident.meaning.match;
                                    }
                                    TRACE_END_STM$("CompoundStatement1992",1997);
                                }
                                // JavaLine 104 ==> SourceLine 2000
                                detach();
                                // JavaLine 106 ==> SourceLine 2002
                                if((testquant==(null))) {
                                    // JavaLine 108 ==> SourceLine 2005
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement2005",2005);
                                        noofexpargs=((CHECKER1$semchecker1)(CUR$.SL$)).NargUnknown;
                                        // JavaLine 112 ==> SourceLine 2013
                                        LABEL$(1); // dummy
                                        // JavaLine 114 ==> SourceLine 2007
                                        while(inuse) {
                                            // JavaLine 116 ==> SourceLine 2008
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement2008",2008);
                                                argno=(argno+(1));
                                                // JavaLine 120 ==> SourceLine 2009
                                                newpar=new CHECKER1$semchecker1$parameter(((CHECKER1$semchecker1)(CUR$.SL$)),argno,((CHECKER1$semchecker1)(CUR$.SL$)).exptop,null).STM$();
                                                // JavaLine 122 ==> SourceLine 2010
                                                lastarg=lastarg.nextarg=newpar;
                                                newpar=null;
                                                // JavaLine 125 ==> SourceLine 2011
                                                new CHECKER1$semchecker1$popExpStack(((CHECKER1$semchecker1)(CUR$.SL$)));
                                                // JavaLine 127 ==> SourceLine 2012
                                                detach();
                                                TRACE_END_STM$("CompoundStatement2008",2012);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement2005",2012);
                                    }
                                } else
                                // JavaLine 135 ==> SourceLine 2017
                                switch(testquant.kind) { // BEGIN SWITCH STATEMENT
                                case 2: 
                                case 6: 
                                // JavaLine 139 ==> SourceLine 2019
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement2019",2019);
                                    noofexpargs=((((testquant.categ==(((CHECKER1)(CUR$.SL$.SL$)).C_local))||((testquant.categ==(((CHECKER1)(CUR$.SL$.SL$)).C_extnal)))))?(testquant.dim):(((CHECKER1$semchecker1)(CUR$.SL$)).NargUnknown));
                                    // JavaLine 143 ==> SourceLine 2031
                                    LABEL$(2); // GENINDEX
                                    // JavaLine 145 ==> SourceLine 2023
                                    while(inuse) {
                                        // JavaLine 147 ==> SourceLine 2024
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2024",2024);
                                            argno=(argno+(1));
                                            // JavaLine 151 ==> SourceLine 2025
                                            newindex=new CHECKER1$semchecker1$index(((CHECKER1$semchecker1)(CUR$.SL$)),argno,((CHECKER1$semchecker1)(CUR$.SL$)).exptop).STM$();
                                            // JavaLine 153 ==> SourceLine 2026
                                            lastarg=lastarg.nextarg=newindex;
                                            newindex=null;
                                            // JavaLine 156 ==> SourceLine 2027
                                            new CHECKER1$semchecker1$popExpStack(((CHECKER1$semchecker1)(CUR$.SL$)));
                                            // JavaLine 158 ==> SourceLine 2029
                                            detach();
                                            TRACE_END_STM$("CompoundStatement2024",2029);
                                        }
                                    }
                                    TRACE_END_STM$("CompoundStatement2019",2029);
                                }
                                case 4: 
                                // JavaLine 166 ==> SourceLine 2036
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement2036",2036);
                                    noofexpargs=1;
                                    GOTO$(GENINDEX); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement2036",2036);
                                }
                                default:
                                // JavaLine 174 ==> SourceLine 2039
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement2039",2039);
                                    cbrec=testquant.descr;
                                    // JavaLine 178 ==> SourceLine 2040
                                    preflvl=1;
                                    prefixChain.Elt[1-prefixChain.LB[0]]=cbrec.fpar;
                                    // JavaLine 181 ==> SourceLine 2046
                                    while((cbrec.declquant.plev>(((CHECKER1)(CUR$.SL$.SL$)).one))) {
                                        // JavaLine 183 ==> SourceLine 2047
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2047",2047);
                                            cbrec=cbrec.declquant.prefqual.descr;
                                            // JavaLine 187 ==> SourceLine 2048
                                            preflvl=(preflvl+(1));
                                            prefixChain.Elt[preflvl-prefixChain.LB[0]]=cbrec.fpar;
                                            TRACE_END_STM$("CompoundStatement2047",2048);
                                        }
                                    }
                                    // JavaLine 193 ==> SourceLine 2050
                                    cbrec=null;
                                    // JavaLine 195 ==> SourceLine 2052
                                    noofexpargs=count=testquant.descr.npar;
                                    // JavaLine 197 ==> SourceLine 2053
                                    while((((count>(0))&&((preflvl!=(0))))&&(inuse))) {
                                        // JavaLine 199 ==> SourceLine 2055
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2055",2055);
                                            cquant=prefixChain.Elt[preflvl-prefixChain.LB[0]];
                                            // JavaLine 203 ==> SourceLine 2056
                                            prefixChain.Elt[preflvl-prefixChain.LB[0]]=null;
                                            preflvl=(preflvl-(1));
                                            // JavaLine 206 ==> SourceLine 2057
                                            GOTO$(enter); // GOTO EVALUATED LABEL
                                            // JavaLine 208 ==> SourceLine 2058
                                            while(((cquant!=(null))&&(inuse))) {
                                                // JavaLine 210 ==> SourceLine 2059
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement2059",2059);
                                                    count=(count-(1));
                                                    argno=(argno+(1));
                                                    // JavaLine 215 ==> SourceLine 2060
                                                    newpar=new CHECKER1$semchecker1$parameter(((CHECKER1$semchecker1)(CUR$.SL$)),argno,((CHECKER1$semchecker1)(CUR$.SL$)).exptop,cquant).STM$();
                                                    // JavaLine 217 ==> SourceLine 2061
                                                    if((((CHECKER1$semchecker1)(CUR$.SL$)).exptop.p$ch==(((CHECKER1)(CUR$.SL$.SL$)).ICONS))) {
                                                    } else
                                                    // JavaLine 220 ==> SourceLine 2062
                                                    ident.issimple=0;
                                                    // JavaLine 222 ==> SourceLine 2063
                                                    lastarg=lastarg.nextarg=newpar;
                                                    newpar=null;
                                                    // JavaLine 225 ==> SourceLine 2064
                                                    new CHECKER1$semchecker1$popExpStack(((CHECKER1$semchecker1)(CUR$.SL$)));
                                                    // JavaLine 227 ==> SourceLine 2065
                                                    detach();
                                                    // JavaLine 229 ==> SourceLine 2066
                                                    cquant=((COMMON$quantity)(cquant.next));
                                                    // JavaLine 231 ==> SourceLine 2070
                                                    LABEL$(3); // enter
                                                    // JavaLine 233 ==> SourceLine 2067
                                                    if((cquant!=(null))) {
                                                        // JavaLine 235 ==> SourceLine 2068
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement2068",2068);
                                                            if(((cquant.categ==(((CHECKER1)(CUR$.SL$.SL$)).C_local))||((cquant.categ==(((CHECKER1)(CUR$.SL$.SL$)).C_extnal))))) {
                                                                // JavaLine 239 ==> SourceLine 2070
                                                                cquant=null;
                                                            }
                                                            TRACE_END_STM$("CompoundStatement2068",2070);
                                                        }
                                                    }
                                                    TRACE_END_STM$("CompoundStatement2059",2070);
                                                }
                                            }
                                            TRACE_END_STM$("CompoundStatement2055",2070);
                                        }
                                    }
                                    // JavaLine 251 ==> SourceLine 2074
                                    cquant=null;
                                    // JavaLine 253 ==> SourceLine 2075
                                    while((preflvl!=(0))) {
                                        // JavaLine 255 ==> SourceLine 2076
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2076",2076);
                                            prefixChain.Elt[preflvl-prefixChain.LB[0]]=null;
                                            preflvl=(preflvl-(1));
                                            TRACE_END_STM$("CompoundStatement2076",2076);
                                        }
                                    }
                                    // JavaLine 263 ==> SourceLine 2078
                                    if(inuse) {
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2078",2078);
                                            if((count==(0))) {
                                                GOTO$(dummy); // GOTO EVALUATED LABEL
                                            }
                                            TRACE_END_STM$("CompoundStatement2078",2078);
                                        }
                                    }
                                    // JavaLine 273 ==> SourceLine 2081
                                    if(((testquant.kind==(((CHECKER1)(CUR$.SL$.SL$)).K_proc))&&((testquant.dim==(rank(((CHECKER1)(CUR$.SL$.SL$)).Cindex)))))) {
                                        // JavaLine 275 ==> SourceLine 2094
                                        new CHECKER1$semchecker1$nextargumentproducer$CompoundStatement1981$CompoundStatement2039$SubBlock2083(CUR$).STM$();
                                    }
                                    TRACE_END_STM$("CompoundStatement2039",2093);
                                }
                            } // END SWITCH STATEMENT
                            // JavaLine 281 ==> SourceLine 2100
                            if((noofexpargs==(((CHECKER1$semchecker1)(CUR$.SL$)).NargUnknown))) {
                                // JavaLine 283 ==> SourceLine 2104
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement2104",2104);
                                    noofexpargs=argno;
                                    TRACE_END_STM$("CompoundStatement2104",2104);
                                }
                            }
                            // JavaLine 290 ==> SourceLine 2107
                            testquant=null;
                            TRACE_END_STM$("CompoundStatement1981",2107);
                        }
                           if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                    }
                    // JavaLine 296 ==> SourceLine 1976
                    if(inner!=null) {
                        inner.STM$();
                        TRACE_BEGIN_STM_AFTER_INNER$("nextargumentproducer",1976);
                    }
                    break LOOP$;
                }
                catch(LABQNT$ q) {
                    CUR$=THIS$;
                    if(q.SL$!=CUR$ || q.prefixLevel!=0) {
                        CUR$.STATE$=OperationalState.terminated;
                        if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                        throw(q);
                    }
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                    JTX$=q.index; continue LOOP$; // EG. GOTO Lx
                }
            }
            TRACE_END_STM$("nextargumentproducer",1976);
            EBLK(); // Iff no prefix
        }
    };
} // End of Constructor
// Class Statements
public CHECKER1$semchecker1$nextargumentproducer STM$() { return((CHECKER1$semchecker1$nextargumentproducer)CODE$.EXEC$()); }
public CHECKER1$semchecker1$nextargumentproducer START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class nextargumentproducer",1,1954,12,2007,14,2023,16,2067,19,1956,21,1957,23,1958,25,1963,27,1964,29,1965,31,1966,34,1967,36,1968,39,1969,41,1971,44,1972,47,1973,68,1976,70,1977,72,1980,74,1981,78,1982,82,1983,85,1984,87,1989,90,1992,94,1995,97,1996,99,1997,104,2000,106,2002,108,2005,112,2013,114,2007,116,2008,120,2009,122,2010,125,2011,127,2012,135,2017,139,2019,143,2031,145,2023,147,2024,151,2025,153,2026,156,2027,158,2029,166,2036,174,2039,178,2040,181,2046,183,2047,187,2048,193,2050,195,2052,197,2053,199,2055,203,2056,206,2057,208,2058,210,2059,215,2060,217,2061,220,2062,222,2063,225,2064,227,2065,229,2066,231,2070,233,2067,235,2068,239,2070,251,2074,253,2075,255,2076,263,2078,273,2081,275,2094,281,2100,283,2104,290,2107,296,1976,321,2111);
}
