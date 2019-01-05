// JavaLine 1 ==> SourceLine 1968
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$expression$exp extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1968, lastLine=2200, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public boolean p$sr;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 1994
    final LABQNT$ restart=new LABQNT$(this,0,1); // Local Label #1=restart
    // JavaLine 14 ==> SourceLine 2022
    final LABQNT$ RPARout=new LABQNT$(this,0,2); // Local Label #2=RPARout
    // JavaLine 16 ==> SourceLine 2027
    final LABQNT$ prefix=new LABQNT$(this,0,3); // Local Label #3=prefix
    // JavaLine 18 ==> SourceLine 2028
    final LABQNT$ relopout=new LABQNT$(this,0,4); // Local Label #4=relopout
    // JavaLine 20 ==> SourceLine 2048
    final LABQNT$ arithopout=new LABQNT$(this,0,5); // Local Label #5=arithopout
    // JavaLine 22 ==> SourceLine 2060
    final LABQNT$ constout=new LABQNT$(this,0,6); // Local Label #6=constout
    // JavaLine 24 ==> SourceLine 2103
    final LABQNT$ param=new LABQNT$(this,0,7); // Local Label #7=param
    // JavaLine 26 ==> SourceLine 2119
    final LABQNT$ comarecover=new LABQNT$(this,0,8); // Local Label #8=comarecover
    // JavaLine 28 ==> SourceLine 2122
    final LABQNT$ rgpaerror=new LABQNT$(this,0,9); // Local Label #9=rgpaerror
    // JavaLine 30 ==> SourceLine 2113
    final LABQNT$ paramexp=new LABQNT$(this,0,10); // Local Label #10=paramexp
    // JavaLine 32 ==> SourceLine 2124
    final LABQNT$ rgparecover=new LABQNT$(this,0,11); // Local Label #11=rgparecover
    // JavaLine 34 ==> SourceLine 2136
    final LABQNT$ postfix=new LABQNT$(this,0,12); // Local Label #12=postfix
    // JavaLine 36 ==> SourceLine 2163
    final LABQNT$ E185=new LABQNT$(this,0,13); // Local Label #13=E185
    // JavaLine 38 ==> SourceLine 2164
    final LABQNT$ Eabte=new LABQNT$(this,0,14); // Local Label #14=Eabte
    // JavaLine 40 ==> SourceLine 2165
    final LABQNT$ Eset=new LABQNT$(this,0,15); // Local Label #15=Eset
    // JavaLine 42 ==> SourceLine 2177
    final LABQNT$ operator=new LABQNT$(this,0,16); // Local Label #16=operator
    // JavaLine 44 ==> SourceLine 2200
    final LABQNT$ expexit=new LABQNT$(this,0,17); // Local Label #17=expexit
    // Declare locals as attributes
    // JavaLine 47 ==> SourceLine 1972
    int parnum=0;
    // JavaLine 49 ==> SourceLine 2039
    COMMON$symbolbox inspect$2039$45=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public PARSER$grammer$expression$exp setPar(Object param) {
        //Util.BREAK("CALL PARSER$grammer$expression$exp.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$sr=(boolean)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public PARSER$grammer$expression$exp(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public PARSER$grammer$expression$exp(RTObject$ SL$,boolean sp$sr) {
        super(SL$);
        // Parameter assignment to locals
        this.p$sr = sp$sr;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("exp",2039);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$expression$exp STM$() {
        TRACE_BEGIN_STM$("exp",2039);
        PARSER$grammer$expression$exp THIS$=(PARSER$grammer$expression$exp)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 84 ==> SourceLine 2026
                LABEL$(1); // restart
                // JavaLine 86 ==> SourceLine 1994
                if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IIF))) {
                    // JavaLine 88 ==> SourceLine 1995
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1995",1995);
                        if((p$sr&&((parnum==(0))))) {
                            // JavaLine 92 ==> SourceLine 1998
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1998",1998);
                                ((PARSER$grammer)(CUR$.SL$.SL$)).experrorno=225;
                                GOTO$(Eabte); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1998",1998);
                            }
                        }
                        // JavaLine 100 ==> SourceLine 1999
                        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IIF;
                        call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                        // JavaLine 103 ==> SourceLine 2000
                        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        // JavaLine 105 ==> SourceLine 2001
                        if((((PARSER$grammer$expression)(CUR$.SL$)).ex==(null))) {
                            ((PARSER$grammer$expression)(CUR$.SL$)).ex=new PARSER$grammer$expression(((PARSER$grammer)(CUR$.SL$.SL$))).START();
                        }
                        // JavaLine 109 ==> SourceLine 2002
                        call(((PARSER$grammer$expression)(CUR$.SL$)).ex);
                        // JavaLine 111 ==> SourceLine 2003
                        if(((PARSER$grammer$expression)(CUR$.SL$)).ex.wasNotexpr) {
                            GOTO$(Eset); // GOTO EVALUATED LABEL
                        }
                        // JavaLine 115 ==> SourceLine 2004
                        if((((PARSER$grammer)(CUR$.SL$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$.SL$)).ITHEN))) {
                            // JavaLine 117 ==> SourceLine 2007
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2007",2007);
                                ((PARSER$grammer)(CUR$.SL$.SL$)).experrorno=207;
                                GOTO$(Eabte); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2007",2007);
                            }
                        }
                        // JavaLine 125 ==> SourceLine 2008
                        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).ITHEN;
                        call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                        // JavaLine 128 ==> SourceLine 2009
                        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        // JavaLine 130 ==> SourceLine 2010
                        new PARSER$grammer$expression$exp(((PARSER$grammer$expression)(CUR$.SL$)),true);
                        // JavaLine 132 ==> SourceLine 2011
                        if((((PARSER$grammer)(CUR$.SL$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$.SL$)).IELSE))) {
                            // JavaLine 134 ==> SourceLine 2014
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2014",2014);
                                ((PARSER$grammer)(CUR$.SL$.SL$)).experrorno=226;
                                GOTO$(Eabte); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2014",2014);
                            }
                        }
                        // JavaLine 142 ==> SourceLine 2015
                        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IELSE;
                        call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                        // JavaLine 145 ==> SourceLine 2016
                        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        // JavaLine 147 ==> SourceLine 2017
                        new PARSER$grammer$expression$exp(((PARSER$grammer$expression)(CUR$.SL$)),false);
                        // JavaLine 149 ==> SourceLine 2018
                        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IEEXP;
                        call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                        // JavaLine 152 ==> SourceLine 2019
                        if((parnum==(0))) {
                            // JavaLine 154 ==> SourceLine 2020
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2020",2020);
                                ((PARSER$grammer$expression)(CUR$.SL$)).NOTblockprefix=((PARSER$grammer$expression)(CUR$.SL$)).NOTlhsassig=((PARSER$grammer$expression)(CUR$.SL$)).NOTrefexpr=true;
                                // JavaLine 158 ==> SourceLine 2021
                                ((PARSER$grammer$expression)(CUR$.SL$)).lastsymb=((PARSER)(CUR$.SL$.SL$.SL$)).INOTY;
                                GOTO$(expexit); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2020",2021);
                            }
                        }
                        // JavaLine 164 ==> SourceLine 2022
                        LABEL$(2); // RPARout
                        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IRGPA;
                        call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                        // JavaLine 168 ==> SourceLine 2023
                        if((((PARSER$grammer)(CUR$.SL$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$.SL$)).IRGPA))) {
                            // JavaLine 170 ==> SourceLine 2024
                            new PARSER$grammer$ParsWarn(((PARSER$grammer)(CUR$.SL$.SL$)),285);
                        } else
                        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        // JavaLine 174 ==> SourceLine 2025
                        ((PARSER$grammer$expression)(CUR$.SL$)).lastsymb=((PARSER)(CUR$.SL$.SL$.SL$)).IRGPA;
                        parnum=(parnum-(1));
                        GOTO$(postfix); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement1995",2025);
                    }
                }
                // JavaLine 181 ==> SourceLine 2032
                LABEL$(3); // prefix
                // JavaLine 183 ==> SourceLine 2027
                if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).INOT))) {
                    // JavaLine 185 ==> SourceLine 2028
                    {
                        TRACE_BEGIN_STM$("CompoundStatement2028",2028);
                        LABEL$(4); // relopout
                        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER$grammer)(CUR$.SL$.SL$)).cs;
                        // JavaLine 190 ==> SourceLine 2029
                        ((PARSER$grammer$expression)(CUR$.SL$)).NOTblockprefix=((PARSER$grammer$expression)(CUR$.SL$)).NOTdesig=((PARSER$grammer$expression)(CUR$.SL$)).NOTlhsassig=((PARSER$grammer$expression)(CUR$.SL$)).NOTrefexpr=true;
                        // JavaLine 192 ==> SourceLine 2031
                        call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                        // JavaLine 194 ==> SourceLine 2032
                        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        TRACE_END_STM$("CompoundStatement2028",2032);
                    }
                }
                // JavaLine 199 ==> SourceLine 2034
                if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IMINU))) {
                    // JavaLine 201 ==> SourceLine 2035
                    {
                        TRACE_BEGIN_STM$("CompoundStatement2035",2035);
                        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        // JavaLine 205 ==> SourceLine 2036
                        if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).ICONS))) {
                            // JavaLine 207 ==> SourceLine 2039
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2039",2039);
                                {
                                    // BEGIN INSPECTION 
                                    inspect$2039$45=new COMMON$boxof(((PARSER)(CUR$.SL$.SL$.SL$)),((PARSER)(CUR$.SL$.SL$.SL$)).opdhi,((PARSER)(CUR$.SL$.SL$.SL$)).opdlo).RESULT$;
                                    if(inspect$2039$45!=null) //INSPECT inspect$2039$45
                                    // JavaLine 214 ==> SourceLine 2040
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement2040",2040);
                                        if(digit(loadChar(inspect$2039$45.symbol,0))) {
                                            // JavaLine 218 ==> SourceLine 2041
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement2041",2041);
                                                ((PARSER)(CUR$.SL$.SL$.SL$)).simsymbol=CONC(new TXT$("-"),inspect$2039$45.symbol);
                                                // JavaLine 222 ==> SourceLine 2042
                                                new COMMON$DEFCONST(((PARSER)(CUR$.SL$.SL$.SL$)));
                                                ((PARSER)(CUR$.SL$.SL$.SL$)).opdhi=((PARSER)(CUR$.SL$.SL$.SL$)).hashhi;
                                                ((PARSER)(CUR$.SL$.SL$.SL$)).opdlo=((PARSER)(CUR$.SL$.SL$.SL$)).hashlo;
                                                // JavaLine 226 ==> SourceLine 2043
                                                GOTO$(constout); // GOTO EVALUATED LABEL
                                                TRACE_END_STM$("CompoundStatement2041",2043);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement2040",2043);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement2039",2043);
                            }
                        }
                        // JavaLine 237 ==> SourceLine 2047
                        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IUMNS;
                        // JavaLine 239 ==> SourceLine 2048
                        LABEL$(5); // arithopout
                        call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                        // JavaLine 242 ==> SourceLine 2049
                        if((((PARSER)(CUR$.SL$.SL$.SL$)).opn!=(((PARSER)(CUR$.SL$.SL$.SL$)).IUMNS))) {
                            // JavaLine 244 ==> SourceLine 2050
                            ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        }
                        // JavaLine 247 ==> SourceLine 2051
                        ((PARSER$grammer$expression)(CUR$.SL$)).NOTblockprefix=((PARSER$grammer$expression)(CUR$.SL$)).NOTdesig=((PARSER$grammer$expression)(CUR$.SL$)).NOTlhsassig=((PARSER$grammer$expression)(CUR$.SL$)).NOTrefexpr=true;
                        TRACE_END_STM$("CompoundStatement2035",2051);
                    }
                } else
                // JavaLine 252 ==> SourceLine 2054
                if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IPLUS))) {
                    // JavaLine 254 ==> SourceLine 2055
                    {
                        TRACE_BEGIN_STM$("CompoundStatement2055",2055);
                        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        // JavaLine 258 ==> SourceLine 2056
                        ((PARSER$grammer$expression)(CUR$.SL$)).NOTblockprefix=((PARSER$grammer$expression)(CUR$.SL$)).NOTdesig=((PARSER$grammer$expression)(CUR$.SL$)).NOTlhsassig=((PARSER$grammer$expression)(CUR$.SL$)).NOTrefexpr=true;
                        TRACE_END_STM$("CompoundStatement2055",2056);
                    }
                }
                // JavaLine 263 ==> SourceLine 2060
                LABEL$(6); // constout
                ((PARSER$grammer$expression)(CUR$.SL$)).lastsymb=((PARSER)(CUR$.SL$.SL$.SL$)).INOTY;
                // JavaLine 266 ==> SourceLine 2061
                if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IIDN))) {
                    ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IIDN;
                } else
                // JavaLine 270 ==> SourceLine 2063
                {
                    TRACE_BEGIN_STM$("CompoundStatement2063",2063);
                    ((PARSER$grammer$expression)(CUR$.SL$)).NOTblockprefix=true;
                    // JavaLine 274 ==> SourceLine 2064
                    if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).ICONS))) {
                        // JavaLine 276 ==> SourceLine 2065
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2065",2065);
                            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).ICONS;
                            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                            // JavaLine 281 ==> SourceLine 2066
                            ((PARSER$grammer)(CUR$.SL$.SL$)).getopt=false;
                            ((PARSER$grammer)(CUR$.SL$.SL$)).cs=((PARSER)(CUR$.SL$.SL$.SL$)).opt;
                            // JavaLine 284 ==> SourceLine 2067
                            ((PARSER$grammer$expression)(CUR$.SL$)).NOTdesig=true;
                            // JavaLine 286 ==> SourceLine 2068
                            if(((((PARSER)(CUR$.SL$.SL$.SL$)).opdhi==(((PARSER)(CUR$.SL$.SL$.SL$)).NUL))&&((((PARSER)(CUR$.SL$.SL$.SL$)).opdlo==(((PARSER)(CUR$.SL$.SL$.SL$)).INOTE))))) {
                                // JavaLine 288 ==> SourceLine 2070
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement2070",2070);
                                    GOTO$(postfix); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement2070",2070);
                                }
                            }
                            // JavaLine 295 ==> SourceLine 2071
                            ((PARSER$grammer$expression)(CUR$.SL$)).NOTlhsassig=((PARSER$grammer$expression)(CUR$.SL$)).NOTrefexpr=true;
                            // JavaLine 297 ==> SourceLine 2072
                            GOTO$(operator); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement2065",2072);
                        }
                    }
                    // JavaLine 302 ==> SourceLine 2074
                    if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).ILFPA))) {
                        // JavaLine 304 ==> SourceLine 2075
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2075",2075);
                            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).ILFPA;
                            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                            // JavaLine 309 ==> SourceLine 2076
                            ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                            // JavaLine 311 ==> SourceLine 2077
                            parnum=(parnum+(1));
                            GOTO$(restart); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement2075",2077);
                        }
                    }
                    // JavaLine 317 ==> SourceLine 2079
                    ((PARSER$grammer$expression)(CUR$.SL$)).NOTdesig=true;
                    // JavaLine 319 ==> SourceLine 2080
                    if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).ITHIS))) {
                        // JavaLine 321 ==> SourceLine 2081
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2081",2081);
                            ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                            // JavaLine 325 ==> SourceLine 2083
                            if((((PARSER$grammer)(CUR$.SL$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$.SL$)).IIDN))) {
                                GOTO$(E185); // GOTO EVALUATED LABEL
                            }
                            // JavaLine 329 ==> SourceLine 2084
                            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).ITHIS;
                            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                            // JavaLine 332 ==> SourceLine 2085
                            ((PARSER$grammer)(CUR$.SL$.SL$)).getopt=false;
                            ((PARSER$grammer)(CUR$.SL$.SL$)).cs=((PARSER)(CUR$.SL$.SL$.SL$)).opt;
                            // JavaLine 335 ==> SourceLine 2086
                            GOTO$(postfix); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement2081",2086);
                        }
                    }
                    // JavaLine 340 ==> SourceLine 2088
                    if((((PARSER$grammer)(CUR$.SL$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$.SL$)).INEW))) {
                        // JavaLine 342 ==> SourceLine 2094
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2094",2094);
                            ((PARSER$grammer)(CUR$.SL$.SL$)).experrorno=(((((PARSER$grammer)(CUR$.SL$.SL$)).symboltype.Elt[rank(((PARSER$grammer)(CUR$.SL$.SL$)).cs)-((PARSER$grammer)(CUR$.SL$.SL$)).symboltype.LB[0]]==(((PARSER$grammer)(CUR$.SL$.SL$)).exprtermin)))?(229):(228));
                            // JavaLine 346 ==> SourceLine 2096
                            GOTO$(Eabte); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement2094",2096);
                        }
                    } else
                    // JavaLine 351 ==> SourceLine 2098
                    ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                    // JavaLine 353 ==> SourceLine 2099
                    ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).INEW;
                    // JavaLine 355 ==> SourceLine 2103
                    LABEL$(7); // param
                    if((((PARSER$grammer)(CUR$.SL$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$.SL$)).IIDN))) {
                        GOTO$(E185); // GOTO EVALUATED LABEL
                    }
                    TRACE_END_STM$("CompoundStatement2063",2103);
                }
                // JavaLine 362 ==> SourceLine 2108
                ((PARSER$grammer)(CUR$.SL$.SL$)).getopt=false;
                ((PARSER$grammer)(CUR$.SL$.SL$)).cs=((PARSER)(CUR$.SL$.SL$.SL$)).opt;
                // JavaLine 365 ==> SourceLine 2109
                if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).ILFPA))) {
                    // JavaLine 367 ==> SourceLine 2110
                    {
                        TRACE_BEGIN_STM$("CompoundStatement2110",2110);
                        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER$grammer$expression)(CUR$.SL$)).opnx=(((((PARSER)(CUR$.SL$.SL$.SL$)).opn==(((PARSER)(CUR$.SL$.SL$.SL$)).INEW)))?(((PARSER)(CUR$.SL$.SL$.SL$)).INEWP):((((((PARSER)(CUR$.SL$.SL$.SL$)).opn==(((PARSER)(CUR$.SL$.SL$.SL$)).IIDN)))?(((PARSER)(CUR$.SL$.SL$.SL$)).IIDNP):(((PARSER)(CUR$.SL$.SL$.SL$)).IDOTP))));
                        // JavaLine 371 ==> SourceLine 2112
                        call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                        // JavaLine 373 ==> SourceLine 2113
                        LABEL$(10); // paramexp
                        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        // JavaLine 376 ==> SourceLine 2114
                        if((((PARSER$grammer$expression)(CUR$.SL$)).ex==(null))) {
                            ((PARSER$grammer$expression)(CUR$.SL$)).ex=new PARSER$grammer$expression(((PARSER$grammer)(CUR$.SL$.SL$))).START();
                        }
                        // JavaLine 380 ==> SourceLine 2115
                        call(((PARSER$grammer$expression)(CUR$.SL$)).ex);
                        // JavaLine 382 ==> SourceLine 2116
                        if(((PARSER$grammer$expression)(CUR$.SL$)).ex.wasNotexpr) {
                            // JavaLine 384 ==> SourceLine 2117
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2117",2117);
                                new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$.SL$)),205);
                                new PARSER$grammer$expression$exp$parexprecover(((PARSER$grammer$expression$exp)CUR$));
                                TRACE_END_STM$("CompoundStatement2117",2117);
                            }
                        }
                        // JavaLine 392 ==> SourceLine 2118
                        if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).ICOMA))) {
                            // JavaLine 394 ==> SourceLine 2119
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2119",2119);
                                LABEL$(8); // comarecover
                                ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).ICOMA;
                                call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                                GOTO$(paramexp); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2119",2119);
                            }
                        }
                        // JavaLine 404 ==> SourceLine 2120
                        if((((PARSER$grammer)(CUR$.SL$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$.SL$)).IRGPA))) {
                            // JavaLine 406 ==> SourceLine 2121
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2121",2121);
                                // JavaLine 409 ==> SourceLine 2122
                                LABEL$(9); // rgpaerror
                                new PARSER$grammer$ParsWarn(((PARSER$grammer)(CUR$.SL$.SL$)),285);
                                TRACE_END_STM$("CompoundStatement2121",2122);
                            }
                        } else
                        // JavaLine 415 ==> SourceLine 2124
                        LABEL$(11); // rgparecover
                        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        // JavaLine 418 ==> SourceLine 2125
                        if(((((PARSER$grammer)(CUR$.SL$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$.SL$)).IBEGI))||((!(((PARSER$grammer$expression)(CUR$.SL$)).startexprstmt))))) {
                            // JavaLine 420 ==> SourceLine 2126
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2126",2126);
                                ((PARSER)(CUR$.SL$.SL$.SL$)).opn=(((((PARSER$grammer$expression)(CUR$.SL$)).opnx==(((PARSER)(CUR$.SL$.SL$.SL$)).INEWP)))?(((PARSER)(CUR$.SL$.SL$.SL$)).ICAPE):(((PARSER)(CUR$.SL$.SL$.SL$)).IARGE));
                                // JavaLine 424 ==> SourceLine 2127
                                call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                                TRACE_END_STM$("CompoundStatement2126",2127);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement2110",2127);
                    }
                } else
                // JavaLine 432 ==> SourceLine 2130
                if(((((PARSER$grammer)(CUR$.SL$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$.SL$)).IBEGI))||((!(((PARSER$grammer$expression)(CUR$.SL$)).startexprstmt))))) {
                    // JavaLine 434 ==> SourceLine 2131
                    call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                }
                // JavaLine 437 ==> SourceLine 2140
                LABEL$(12); // postfix
                // JavaLine 439 ==> SourceLine 2136
                if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IDOT))) {
                    // JavaLine 441 ==> SourceLine 2137
                    {
                        TRACE_BEGIN_STM$("CompoundStatement2137",2137);
                        ((PARSER$grammer$expression)(CUR$.SL$)).NOTblockprefix=((PARSER$grammer$expression)(CUR$.SL$)).NOTdesig=true;
                        // JavaLine 445 ==> SourceLine 2138
                        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IDOT;
                        // JavaLine 448 ==> SourceLine 2139
                        ((PARSER$grammer$expression)(CUR$.SL$)).lastsymb=((PARSER)(CUR$.SL$.SL$.SL$)).INOTY;
                        GOTO$(param); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement2137",2139);
                    }
                }
                // JavaLine 454 ==> SourceLine 2143
                if((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IQUA))) {
                    // JavaLine 456 ==> SourceLine 2144
                    {
                        TRACE_BEGIN_STM$("CompoundStatement2144",2144);
                        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        // JavaLine 460 ==> SourceLine 2146
                        if((((PARSER$grammer)(CUR$.SL$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$.SL$)).IIDN))) {
                            GOTO$(E185); // GOTO EVALUATED LABEL
                        }
                        // JavaLine 464 ==> SourceLine 2147
                        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IQUA;
                        call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                        // JavaLine 467 ==> SourceLine 2148
                        ((PARSER$grammer)(CUR$.SL$.SL$)).getopt=false;
                        ((PARSER$grammer)(CUR$.SL$.SL$)).cs=((PARSER)(CUR$.SL$.SL$.SL$)).opt;
                        // JavaLine 470 ==> SourceLine 2149
                        ((PARSER$grammer$expression)(CUR$.SL$)).NOTblockprefix=((PARSER$grammer$expression)(CUR$.SL$)).NOTdesig=true;
                        // JavaLine 472 ==> SourceLine 2150
                        ((PARSER$grammer$expression)(CUR$.SL$)).lastsymb=((PARSER)(CUR$.SL$.SL$.SL$)).IQUA;
                        GOTO$(postfix); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement2144",2150);
                    }
                }
                // JavaLine 478 ==> SourceLine 2154
                if(((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IIS))||((((PARSER$grammer)(CUR$.SL$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$.SL$)).IIN))))) {
                    // JavaLine 480 ==> SourceLine 2155
                    {
                        TRACE_BEGIN_STM$("CompoundStatement2155",2155);
                        ((PARSER$grammer$expression)(CUR$.SL$)).NOTblockprefix=((PARSER$grammer$expression)(CUR$.SL$)).NOTdesig=((PARSER$grammer$expression)(CUR$.SL$)).NOTlhsassig=((PARSER$grammer$expression)(CUR$.SL$)).NOTrefexpr=true;
                        // JavaLine 484 ==> SourceLine 2157
                        ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER$grammer)(CUR$.SL$.SL$)).cs;
                        // JavaLine 486 ==> SourceLine 2158
                        ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                        // JavaLine 488 ==> SourceLine 2159
                        if((((PARSER$grammer)(CUR$.SL$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$.SL$)).IIDN))) {
                            // JavaLine 490 ==> SourceLine 2160
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2160",2160);
                                // JavaLine 493 ==> SourceLine 2163
                                LABEL$(13); // E185
                                ((PARSER$grammer)(CUR$.SL$.SL$)).experrorno=185;
                                // JavaLine 496 ==> SourceLine 2164
                                LABEL$(14); // Eabte
                                ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IABTE;
                                call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                                // JavaLine 500 ==> SourceLine 2166
                                LABEL$(15); // Eset
                                // JavaLine 502 ==> SourceLine 2165
                                ((PARSER$grammer$expression)(CUR$.SL$)).wasNotexpr=((PARSER$grammer$expression)(CUR$.SL$)).NOTblockprefix=((PARSER$grammer$expression)(CUR$.SL$)).NOTdesig=((PARSER$grammer$expression)(CUR$.SL$)).NOTlhsassig=((PARSER$grammer$expression)(CUR$.SL$)).NOTrefexpr=true;
                                // JavaLine 504 ==> SourceLine 2167
                                if((((PARSER$grammer)(CUR$.SL$.SL$)).symboltype.Elt[rank(((PARSER$grammer)(CUR$.SL$.SL$)).cs)-((PARSER$grammer)(CUR$.SL$.SL$)).symboltype.LB[0]]==(((PARSER$grammer)(CUR$.SL$.SL$)).exprtermin))) {
                                    // JavaLine 506 ==> SourceLine 2168
                                    ((PARSER$grammer)(CUR$.SL$.SL$)).getopt=true;
                                }
                                // JavaLine 509 ==> SourceLine 2169
                                GOTO$(expexit); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement2160",2169);
                            }
                        }
                        // JavaLine 514 ==> SourceLine 2171
                        call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                        ((PARSER$grammer$expression)(CUR$.SL$)).lastsymb=((PARSER)(CUR$.SL$.SL$.SL$)).INOTY;
                        // JavaLine 517 ==> SourceLine 2172
                        ((PARSER$grammer)(CUR$.SL$.SL$)).getopt=false;
                        ((PARSER$grammer)(CUR$.SL$.SL$)).cs=((PARSER)(CUR$.SL$.SL$.SL$)).opt;
                        TRACE_END_STM$("CompoundStatement2155",2172);
                    }
                }
                // JavaLine 523 ==> SourceLine 2186
                LABEL$(16); // operator
                // JavaLine 525 ==> SourceLine 2177
                switch(((PARSER$grammer)(CUR$.SL$.SL$)).symboltype.Elt[rank(((PARSER$grammer)(CUR$.SL$.SL$)).cs)-((PARSER$grammer)(CUR$.SL$.SL$)).symboltype.LB[0]]) { // BEGIN SWITCH STATEMENT
                case 4: 
                // JavaLine 528 ==> SourceLine 2178
                GOTO$(relopout); // GOTO EVALUATED LABEL
                case 3: 
                // JavaLine 531 ==> SourceLine 2179
                {
                    TRACE_BEGIN_STM$("CompoundStatement2179",2179);
                    ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER$grammer)(CUR$.SL$.SL$)).cs;
                    GOTO$(arithopout); // GOTO EVALUATED LABEL
                    TRACE_END_STM$("CompoundStatement2179",2179);
                }
                case 5: 
                // JavaLine 539 ==> SourceLine 2181
                {
                    TRACE_BEGIN_STM$("CompoundStatement2181",2181);
                    ((PARSER$grammer$expression)(CUR$.SL$)).NOTblockprefix=((PARSER$grammer$expression)(CUR$.SL$)).NOTdesig=((PARSER$grammer$expression)(CUR$.SL$)).NOTlhsassig=((PARSER$grammer$expression)(CUR$.SL$)).NOTrefexpr=true;
                    // JavaLine 543 ==> SourceLine 2183
                    ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER$grammer)(CUR$.SL$.SL$)).cs;
                    call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                    // JavaLine 546 ==> SourceLine 2184
                    ((PARSER$grammer)(CUR$.SL$.SL$)).detach();
                    // JavaLine 548 ==> SourceLine 2185
                    GOTO$(prefix); // GOTO EVALUATED LABEL
                    TRACE_END_STM$("CompoundStatement2181",2185);
                }
            } // END SWITCH STATEMENT
            // JavaLine 553 ==> SourceLine 2189
            if((parnum!=(0))) {
                GOTO$(RPARout); // GOTO EVALUATED LABEL
            }
            // JavaLine 557 ==> SourceLine 2200
            LABEL$(17); // expexit
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
    TRACE_END_STM$("exp",2200);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure exp",1,1968,12,1994,14,2022,16,2027,18,2028,20,2048,22,2060,24,2103,26,2119,28,2122,30,2113,32,2124,34,2136,36,2163,38,2164,40,2165,42,2177,44,2200,47,1972,49,2039,84,2026,86,1994,88,1995,92,1998,100,1999,103,2000,105,2001,109,2002,111,2003,115,2004,117,2007,125,2008,128,2009,130,2010,132,2011,134,2014,142,2015,145,2016,147,2017,149,2018,152,2019,154,2020,158,2021,164,2022,168,2023,170,2024,174,2025,181,2032,183,2027,185,2028,190,2029,192,2031,194,2032,199,2034,201,2035,205,2036,207,2039,214,2040,218,2041,222,2042,226,2043,237,2047,239,2048,242,2049,244,2050,247,2051,252,2054,254,2055,258,2056,263,2060,266,2061,270,2063,274,2064,276,2065,281,2066,284,2067,286,2068,288,2070,295,2071,297,2072,302,2074,304,2075,309,2076,311,2077,317,2079,319,2080,321,2081,325,2083,329,2084,332,2085,335,2086,340,2088,342,2094,346,2096,351,2098,353,2099,355,2103,362,2108,365,2109,367,2110,371,2112,373,2113,376,2114,380,2115,382,2116,384,2117,392,2118,394,2119,404,2120,406,2121,409,2122,415,2124,418,2125,420,2126,424,2127,432,2130,434,2131,437,2140,439,2136,441,2137,445,2138,448,2139,454,2143,456,2144,460,2146,464,2147,467,2148,470,2149,472,2150,478,2154,480,2155,484,2157,486,2158,488,2159,490,2160,493,2163,496,2164,500,2166,502,2165,504,2167,506,2168,509,2169,514,2171,517,2172,523,2186,525,2177,528,2178,531,2179,539,2181,543,2183,546,2184,548,2185,553,2189,557,2200,575,2200);
}
