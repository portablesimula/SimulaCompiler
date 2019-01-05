// JavaLine 1 ==> SourceLine 1243
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$prechecker$allocate$alloc2$setprefqual extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=5, firstLine=1243, lastLine=1284, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public COMMON$quantity RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public COMMON$quantity p$Q;
    public boolean p$param;
    // Declare local labels
    // JavaLine 16 ==> SourceLine 1283
    final LABQNT$ out=new LABQNT$(this,0,1); // Local Label #1=out
    // Declare locals as attributes
    // JavaLine 19 ==> SourceLine 1245
    COMMON$quantity QX=null;
    COMMON$symbolbox symx=null;
    // JavaLine 22 ==> SourceLine 1246
    int i=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER2$prechecker$allocate$alloc2$setprefqual setPar(Object param) {
        //Util.BREAK("CALL BUILDER2$prechecker$allocate$alloc2$setprefqual.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$Q=(COMMON$quantity)objectValue(param); break;
                case 1: p$param=(boolean)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER2$prechecker$allocate$alloc2$setprefqual(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER2$prechecker$allocate$alloc2$setprefqual(RTObject$ SL$,COMMON$quantity sp$Q,boolean sp$param) {
        super(SL$);
        // Parameter assignment to locals
        this.p$Q = sp$Q;
        this.p$param = sp$param;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("setprefqual",1246);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$prechecker$allocate$alloc2$setprefqual STM$() {
        TRACE_BEGIN_STM$("setprefqual",1246);
        BUILDER2$prechecker$allocate$alloc2$setprefqual THIS$=(BUILDER2$prechecker$allocate$alloc2$setprefqual)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 59 ==> SourceLine 1248
                while((p$Q!=(null))) {
                    // JavaLine 61 ==> SourceLine 1249
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1249",1249);
                        if(p$param) {
                            // JavaLine 65 ==> SourceLine 1250
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1250",1250);
                                if((p$Q.categ==(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).C_local))) {
                                    GOTO$(out); // GOTO EVALUATED LABEL
                                }
                                // JavaLine 71 ==> SourceLine 1251
                                if((p$Q.categ==(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).C_extnal))) {
                                    GOTO$(out); // GOTO EVALUATED LABEL
                                }
                                TRACE_END_STM$("CompoundStatement1250",1251);
                            }
                        }
                        // JavaLine 78 ==> SourceLine 1252
                        if((p$Q.type==(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).IREF))) {
                            // JavaLine 80 ==> SourceLine 1254
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1254",1254);
                                if((p$Q.line<(0))) {
                                    // JavaLine 84 ==> SourceLine 1255
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1255",1255);
                                        i=(-(p$Q.line));
                                        p$Q.line=0;
                                        TRACE_END_STM$("CompoundStatement1255",1255);
                                    }
                                } else
                                // JavaLine 92 ==> SourceLine 1256
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1256",1256);
                                    i=(-(p$Q.ftag));
                                    p$Q.ftag=0;
                                    TRACE_END_STM$("CompoundStatement1256",1256);
                                }
                                // JavaLine 99 ==> SourceLine 1257
                                symx=new COMMON$getBox(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)),i).RESULT$;
                                // JavaLine 101 ==> SourceLine 1258
                                QX=new BUILDER1$meaningof(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)),symx).RESULT$;
                                // JavaLine 103 ==> SourceLine 1259
                                if((QX==(null))) {
                                    QX=new ERRMSG$newnotseen(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)),symx).RESULT$;
                                }
                                // JavaLine 107 ==> SourceLine 1260
                                if((QX.categ==(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).C_unknwn))) {
                                    // JavaLine 109 ==> SourceLine 1262
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1262",1262);
                                        if(IS$(p$Q,COMMON$quantity.class)) {
                                            // JavaLine 113 ==> SourceLine 1263
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1263",1263);
                                                new ERRMSG$errQTN(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)),p$Q,412,QX);
                                                p$Q.type=((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).IELSE;
                                                TRACE_END_STM$("CompoundStatement1263",1263);
                                            }
                                        } else
                                        // JavaLine 121 ==> SourceLine 1264
                                        if((QX.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).K_record))) {
                                            p$Q.type=((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).IPTR;
                                        }
                                        // JavaLine 125 ==> SourceLine 1265
                                        p$Q.prefqual=QX;
                                        TRACE_END_STM$("CompoundStatement1262",1265);
                                    }
                                } else
                                // JavaLine 130 ==> SourceLine 1267
                                if((QX.kind!=(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).K_class))) {
                                    // JavaLine 132 ==> SourceLine 1268
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1268",1268);
                                        if((QX.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).K_record))) {
                                            // JavaLine 136 ==> SourceLine 1269
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1269",1269);
                                                p$Q.prefqual=QX;
                                                p$Q.type=((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).IPTR;
                                                TRACE_END_STM$("CompoundStatement1269",1269);
                                            }
                                        } else
                                        // JavaLine 144 ==> SourceLine 1270
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1270",1270);
                                            new ERRMSG$errQTN(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)),p$Q,413,QX);
                                            p$Q.type=((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).IELSE;
                                            TRACE_END_STM$("CompoundStatement1270",1270);
                                        }
                                        TRACE_END_STM$("CompoundStatement1268",1270);
                                    }
                                } else
                                // JavaLine 154 ==> SourceLine 1272
                                p$Q.prefqual=QX;
                                // JavaLine 156 ==> SourceLine 1273
                                p$Q.plev=((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).one;
                                TRACE_END_STM$("CompoundStatement1254",1273);
                            }
                        }
                        // JavaLine 161 ==> SourceLine 1276
                        if(((p$Q.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).K_class))||((p$Q.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).K_record))))) {
                            // JavaLine 163 ==> SourceLine 1278
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1278",1278);
                                if((p$Q.prefqual==(null))) {
                                    // JavaLine 167 ==> SourceLine 1279
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1279",1279);
                                        if(((p$Q.ftag<(0))|((p$Q.line<(0))))) {
                                            new BUILDER2$prechecker$allocate$alloc2$setprefix(((BUILDER2$prechecker$allocate$alloc2)(CUR$.SL$)),p$Q);
                                        }
                                        TRACE_END_STM$("CompoundStatement1279",1279);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement1278",1279);
                            }
                        }
                        // JavaLine 179 ==> SourceLine 1281
                        p$Q=((COMMON$quantity)(p$Q.next));
                        TRACE_END_STM$("CompoundStatement1249",1281);
                    }
                }
                // JavaLine 184 ==> SourceLine 1283
                LABEL$(1); // out
                RESULT$=p$Q;
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
        TRACE_END_STM$("setprefqual",1283);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure setprefqual",1,1243,16,1283,19,1245,22,1246,59,1248,61,1249,65,1250,71,1251,78,1252,80,1254,84,1255,92,1256,99,1257,101,1258,103,1259,107,1260,109,1262,113,1263,121,1264,125,1265,130,1267,132,1268,136,1269,144,1270,154,1272,156,1273,161,1276,163,1278,167,1279,179,1281,184,1283,203,1284);
}
