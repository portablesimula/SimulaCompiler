// JavaLine 1 ==> SourceLine 1185
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:35 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$prechecker$allocate$alloc2$setprefix extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=5, firstLine=1185, lastLine=1241, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$quantity p$subq;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 1219
    final LABQNT$ PrefErr=new LABQNT$(this,0,1); // Local Label #1=PrefErr
    // JavaLine 14 ==> SourceLine 1230
    final LABQNT$ setPref=new LABQNT$(this,0,2); // Local Label #2=setPref
    // JavaLine 16 ==> SourceLine 1239
    final LABQNT$ out=new LABQNT$(this,0,3); // Local Label #3=out
    // Declare locals as attributes
    // JavaLine 19 ==> SourceLine 1191
    COMMON$quantity PQ=null;
    COMMON$quantity smlblk=null;
    // JavaLine 22 ==> SourceLine 1192
    COMMON$symbolbox symx=null;
    int i=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER2$prechecker$allocate$alloc2$setprefix setPar(Object param) {
        //Util.BREAK("CALL BUILDER2$prechecker$allocate$alloc2$setprefix.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$subq=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER2$prechecker$allocate$alloc2$setprefix(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER2$prechecker$allocate$alloc2$setprefix(RTObject$ SL$,COMMON$quantity sp$subq) {
        super(SL$);
        // Parameter assignment to locals
        this.p$subq = sp$subq;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("setprefix",1192);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$prechecker$allocate$alloc2$setprefix STM$() {
        TRACE_BEGIN_STM$("setprefix",1192);
        BUILDER2$prechecker$allocate$alloc2$setprefix THIS$=(BUILDER2$prechecker$allocate$alloc2$setprefix)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 58 ==> SourceLine 1198
                {
                    TRACE_BEGIN_STM$("CompoundStatement1198",1198);
                    p$subq.match=((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).setprefgoing;
                    // JavaLine 62 ==> SourceLine 1199
                    if((p$subq.line<(0))) {
                        // JavaLine 64 ==> SourceLine 1200
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1200",1200);
                            i=(-(p$subq.line));
                            p$subq.line=0;
                            TRACE_END_STM$("CompoundStatement1200",1200);
                        }
                    } else
                    // JavaLine 72 ==> SourceLine 1201
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1201",1201);
                        i=(-(p$subq.ftag));
                        p$subq.ftag=0;
                        TRACE_END_STM$("CompoundStatement1201",1201);
                    }
                    // JavaLine 79 ==> SourceLine 1202
                    symx=new COMMON$getBox(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)),i).RESULT$;
                    PQ=new BUILDER1$meaningof(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)),symx).RESULT$;
                    // JavaLine 82 ==> SourceLine 1203
                    if((PQ==(null))) {
                        PQ=new ERRMSG$newnotseen(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)),symx).RESULT$;
                    }
                    // JavaLine 86 ==> SourceLine 1204
                    if(((PQ.categ==(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).C_unknwn))|(((PQ.kind!=(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).K_class))&((PQ.kind!=(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).K_record))))))) {
                        // JavaLine 88 ==> SourceLine 1207
                        new ERRMSG$errQTN(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)),p$subq,409,PQ);
                    } else
                    if((PQ.encl.blev!=(p$subq.encl.blev))) {
                        // JavaLine 92 ==> SourceLine 1210
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1210",1210);
                            if(IS$(PQ,COMMON$quantity.class)) {
                                GOTO$(PrefErr); // GOTO EVALUATED LABEL
                            }
                            // JavaLine 98 ==> SourceLine 1211
                            if((((COMMON$extquantity)(PQ)).clf==(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).Clf009))) {
                                // JavaLine 100 ==> SourceLine 1214
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1214",1214);
                                    smlblk=p$subq.encl.declquant;
                                    // JavaLine 104 ==> SourceLine 1215
                                    while((smlblk.plev>(2))) {
                                        smlblk=smlblk.prefqual;
                                    }
                                    // JavaLine 108 ==> SourceLine 1216
                                    if((smlblk.symb!=(null))) {
                                        // JavaLine 110 ==> SourceLine 1217
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1217",1217);
                                            if(TXTREL$EQ(smlblk.symb.symbol,new TXT$("simulation"))) {
                                                // JavaLine 114 ==> SourceLine 1218
                                                GOTO$(setPref); // GOTO EVALUATED LABEL
                                            }
                                            TRACE_END_STM$("CompoundStatement1217",1218);
                                        }
                                    }
                                    // JavaLine 120 ==> SourceLine 1219
                                    LABEL$(1); // PrefErr
                                    new ERRMSG$errQTN(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)),p$subq,410,PQ);
                                    TRACE_END_STM$("CompoundStatement1214",1219);
                                }
                            } else
                            // JavaLine 126 ==> SourceLine 1221
                            if((((COMMON$extquantity)(PQ)).clf!=(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).Clf004))) {
                                // JavaLine 128 ==> SourceLine 1223
                                GOTO$(PrefErr); // GOTO EVALUATED LABEL
                            }
                            // JavaLine 131 ==> SourceLine 1224
                            GOTO$(setPref); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1210",1224);
                        }
                    } else
                    // JavaLine 136 ==> SourceLine 1227
                    if((PQ.match==(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).setprefgoing))) {
                        // JavaLine 138 ==> SourceLine 1229
                        new ERRMSG$errQT(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)),p$subq,318);
                    } else
                    // JavaLine 141 ==> SourceLine 1230
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1230",1230);
                        // JavaLine 144 ==> SourceLine 1232
                        LABEL$(2); // setPref
                        // JavaLine 146 ==> SourceLine 1230
                        if((PQ.prefqual==(null))) {
                            // JavaLine 148 ==> SourceLine 1231
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1231",1231);
                                if(((PQ.ftag<(0))|((PQ.line<(0))))) {
                                    // JavaLine 152 ==> SourceLine 1232
                                    new BUILDER2$prechecker$allocate$alloc2$setprefix(((BUILDER2$prechecker$allocate$alloc2)(CUR$.SL$)),PQ);
                                }
                                TRACE_END_STM$("CompoundStatement1231",1232);
                            }
                        }
                        // JavaLine 158 ==> SourceLine 1233
                        p$subq.prefqual=PQ;
                        p$subq.plev=(PQ.plev+(1));
                        // JavaLine 161 ==> SourceLine 1234
                        GOTO$(out); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement1230",1234);
                    }
                    // JavaLine 165 ==> SourceLine 1237
                    p$subq.prefqual=null;
                    // JavaLine 167 ==> SourceLine 1238
                    p$subq.plev=(((p$subq.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).K_class)))?(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).one):(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).zero));
                    // JavaLine 169 ==> SourceLine 1239
                    LABEL$(3); // out
                    p$subq.match=null;
                    TRACE_END_STM$("CompoundStatement1198",1239);
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
        TRACE_END_STM$("setprefix",1239);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure setprefix",1,1185,12,1219,14,1230,16,1239,19,1191,22,1192,58,1198,62,1199,64,1200,72,1201,79,1202,82,1203,86,1204,88,1207,92,1210,98,1211,100,1214,104,1215,108,1216,110,1217,114,1218,120,1219,126,1221,128,1223,131,1224,136,1227,138,1229,141,1230,144,1232,146,1230,148,1231,152,1232,158,1233,161,1234,165,1237,167,1238,169,1239,190,1241);
}
