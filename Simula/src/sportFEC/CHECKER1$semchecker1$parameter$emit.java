// JavaLine 1 ==> SourceLine 2182
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$parameter$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=2182, lastLine=2278, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 2277
    final LABQNT$ NxtArg=new LABQNT$(this,0,1); // Local Label #1=NxtArg
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 2184
    CHECKER1$semchecker1$exp inspect$2184$17=null;
    // Normal Constructor
    public CHECKER1$semchecker1$parameter$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",2184);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$parameter$emit STM$() {
        TRACE_BEGIN_STM$("emit",2184);
        CHECKER1$semchecker1$parameter$emit THIS$=(CHECKER1$semchecker1$parameter$emit)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                {
                    // BEGIN INSPECTION 
                    inspect$2184$17=((CHECKER1$semchecker1$parameter)(CUR$.SL$)).p$actual;
                    if(inspect$2184$17!=null) //INSPECT inspect$2184$17
                    // JavaLine 36 ==> SourceLine 2185
                    {
                        TRACE_BEGIN_STM$("CompoundStatement2185",2185);
                        ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$parameter)(CUR$.SL$)).p1$formal;
                        // JavaLine 40 ==> SourceLine 2186
                        if(((((CHECKER1$semchecker1$parameter)(CUR$.SL$)).p1$formal==(null))||((((CHECKER1$semchecker1$parameter)(CUR$.SL$)).p1$formal.categ==(((CHECKER1)(CUR$.SL$.SL$.SL$)).C_name))))) {
                            // JavaLine 42 ==> SourceLine 2189
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2189",2189);
                                if((inspect$2184$17.meaning!=(null))) {
                                    // JavaLine 46 ==> SourceLine 2190
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement2190",2190);
                                        if((inspect$2184$17.meaning.protect==(((char)2)))) {
                                            // JavaLine 50 ==> SourceLine 2191
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement2191",2191);
                                                if((inspect$2184$17.ctype==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDN))) {
                                                    // JavaLine 54 ==> SourceLine 2193
                                                    new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(((CHECKER1$semchecker1$parameter)(CUR$.SL$)).p$actual)),253);
                                                } else
                                                if((inspect$2184$17.ctype==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDNP))) {
                                                    // JavaLine 58 ==> SourceLine 2195
                                                    new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$argumented)(((CHECKER1$semchecker1$parameter)(CUR$.SL$)).p$actual)).p1$ident,253);
                                                }
                                                TRACE_END_STM$("CompoundStatement2191",2195);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement2190",2195);
                                    }
                                }
                                // JavaLine 67 ==> SourceLine 2204
                                if(((inspect$2184$17.p$ch==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDN))&&((inspect$2184$17.cl!=(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl))))) {
                                    // JavaLine 69 ==> SourceLine 2206
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement2206",2206);
                                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IDCLS;
                                        // JavaLine 73 ==> SourceLine 2207
                                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).actqty=inspect$2184$17.meaning;
                                        TRACE_END_STM$("CompoundStatement2206",2207);
                                    }
                                } else
                                // JavaLine 78 ==> SourceLine 2209
                                if((inspect$2184$17.p$ch==(((CHECKER1)(CUR$.SL$.SL$.SL$)).ICONS))) {
                                    // JavaLine 80 ==> SourceLine 2210
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement2210",2210);
                                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IDCLS;
                                        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                                        // JavaLine 85 ==> SourceLine 2211
                                        inspect$2184$17.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
                                        // JavaLine 87 ==> SourceLine 2212
                                        switch(inspect$2184$17.type) { // BEGIN SWITCH STATEMENT
                                        case 1: 
                                        case 2: 
                                        case 7: 
                                        // JavaLine 92 ==> SourceLine 2214
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2214",2214);
                                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ISCST;
                                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opt=inspect$2184$17.type;
                                            // JavaLine 97 ==> SourceLine 2215
                                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=((CHECKER1$semchecker1$const$)(((CHECKER1$semchecker1$exp)inspect$2184$17))).ixlo;
                                            // JavaLine 99 ==> SourceLine 2216
                                            call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                                            GOTO$(NxtArg); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement2214",2216);
                                        }
                                        case 8: 
                                        // JavaLine 105 ==> SourceLine 2219
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2219",2219);
                                            if((((CHECKER1$semchecker1$const$)(((CHECKER1$semchecker1$exp)inspect$2184$17))).ixhi==(((CHECKER1)(CUR$.SL$.SL$.SL$)).NUL))) {
                                                // JavaLine 109 ==> SourceLine 2221
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement2221",2221);
                                                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opt=((CHECKER1)(CUR$.SL$.SL$.SL$)).ITEXT;
                                                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ISCST;
                                                    TRACE_END_STM$("CompoundStatement2221",2221);
                                                }
                                            } else
                                            // JavaLine 117 ==> SourceLine 2223
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement2223",2223);
                                                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ICONS;
                                                // JavaLine 121 ==> SourceLine 2226
                                                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opihi=((CHECKER1$semchecker1$const$)(((CHECKER1$semchecker1$exp)inspect$2184$17))).ixhi;
                                                // JavaLine 123 ==> SourceLine 2227
                                                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=((CHECKER1$semchecker1$const$)(((CHECKER1$semchecker1$exp)inspect$2184$17))).ixlo;
                                                TRACE_END_STM$("CompoundStatement2223",2227);
                                            }
                                            // JavaLine 127 ==> SourceLine 2229
                                            call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                                            GOTO$(NxtArg); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement2219",2229);
                                        }
                                        case 3: 
                                        case 4: 
                                        case 5: 
                                        case 6: 
                                        // JavaLine 136 ==> SourceLine 2232
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2232",2232);
                                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ISCST;
                                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opt=inspect$2184$17.type;
                                            // JavaLine 141 ==> SourceLine 2235
                                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opihi=((CHECKER1$semchecker1$const$)(((CHECKER1$semchecker1$exp)inspect$2184$17))).ixhi;
                                            // JavaLine 143 ==> SourceLine 2236
                                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=((CHECKER1$semchecker1$const$)(((CHECKER1$semchecker1$exp)inspect$2184$17))).ixlo;
                                            // JavaLine 145 ==> SourceLine 2237
                                            call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                                            GOTO$(NxtArg); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement2232",2237);
                                        }
                                    } // END SWITCH STATEMENT
                                    // JavaLine 151 ==> SourceLine 2240
                                    GOTO$(NxtArg); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement2210",2240);
                                }
                            } else
                            // JavaLine 156 ==> SourceLine 2243
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IDCLI;
                            // JavaLine 158 ==> SourceLine 2244
                            call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                            // JavaLine 160 ==> SourceLine 2245
                            inspect$2184$17.cl=(((((inspect$2184$17.ctype==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDN))||((inspect$2184$17.ctype==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDNP))))&&((inspect$2184$17.cl!=(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl)))))?(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IACTEcl):(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl));
                            // JavaLine 162 ==> SourceLine 2249
                            inspect$2184$17.emit$0().CPF();
                            // JavaLine 164 ==> SourceLine 2250
                            if((((inspect$2184$17.ctype==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDN))||((inspect$2184$17.ctype==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDNP))))&&((inspect$2184$17.cl==(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IACTEcl))))) {
                            } else
                            // JavaLine 167 ==> SourceLine 2255
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2255",2255);
                                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IRGPA;
                                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opt=inspect$2184$17.type;
                                // JavaLine 172 ==> SourceLine 2256
                                if((((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opt==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IREF))) {
                                    ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=inspect$2184$17.qual;
                                }
                                // JavaLine 176 ==> SourceLine 2257
                                call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                                TRACE_END_STM$("CompoundStatement2255",2257);
                            }
                            TRACE_END_STM$("CompoundStatement2189",2257);
                        }
                    } else
                    // JavaLine 183 ==> SourceLine 2262
                    {
                        TRACE_BEGIN_STM$("CompoundStatement2262",2262);
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IFRMP;
                        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                        // JavaLine 188 ==> SourceLine 2263
                        if((inspect$2184$17.ctype==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDN))) {
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2263",2263);
                                if((inspect$2184$17.cl!=(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IACTEcl))) {
                                    // JavaLine 193 ==> SourceLine 2264
                                    inspect$2184$17.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
                                }
                                TRACE_END_STM$("CompoundStatement2263",2264);
                            }
                        }
                        // JavaLine 199 ==> SourceLine 2265
                        inspect$2184$17.emit$0().CPF();
                        // JavaLine 201 ==> SourceLine 2266
                        if((((CHECKER1$semchecker1$parameter)(CUR$.SL$)).p1$formal.kind==(((CHECKER1)(CUR$.SL$.SL$.SL$)).K_ident))) {
                            // JavaLine 203 ==> SourceLine 2267
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2267",2267);
                                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).ftype=((CHECKER1$semchecker1$parameter)(CUR$.SL$)).p1$formal.type;
                                // JavaLine 207 ==> SourceLine 2268
                                if((((CHECKER1$semchecker1$parameter)(CUR$.SL$)).p1$formal.type!=(inspect$2184$17.type))) {
                                    // JavaLine 209 ==> SourceLine 2270
                                    new CHECKER1$semchecker1$MaybeConvert(((CHECKER1$semchecker1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$parameter)(CUR$.SL$)).p1$formal.type,inspect$2184$17.type);
                                } else
                                if(((CHECKER1$semchecker1$parameter)(CUR$.SL$)).implqua) {
                                    // JavaLine 213 ==> SourceLine 2272
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement2272",2272);
                                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).INONE;
                                        // JavaLine 217 ==> SourceLine 2273
                                        ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$parameter)(CUR$.SL$)).p1$formal.prefqual;
                                        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                                        TRACE_END_STM$("CompoundStatement2272",2273);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement2267",2273);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement2262",2273);
                    }
                    // JavaLine 228 ==> SourceLine 2277
                    LABEL$(1); // NxtArg
                    if((((CHECKER1$semchecker1$parameter)(CUR$.SL$)).nextarg!=(null))) {
                        ((CHECKER1$semchecker1$parameter)(CUR$.SL$)).nextarg.emit$0().CPF();
                    }
                    TRACE_END_STM$("CompoundStatement2185",2277);
                }
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
    TRACE_END_STM$("emit",2277);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,2182,11,2277,14,2184,36,2185,40,2186,42,2189,46,2190,50,2191,54,2193,58,2195,67,2204,69,2206,73,2207,78,2209,80,2210,85,2211,87,2212,92,2214,97,2215,99,2216,105,2219,109,2221,117,2223,121,2226,123,2227,127,2229,136,2232,141,2235,143,2236,145,2237,151,2240,156,2243,158,2244,160,2245,162,2249,164,2250,167,2255,172,2256,176,2257,183,2262,188,2263,193,2264,199,2265,201,2266,203,2267,207,2268,209,2270,213,2272,217,2273,228,2277,252,2278);
}
