// JavaLine 1 <== SourceLine 1170
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$statement extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=1170, lastLine=1373, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 10 <== SourceLine 1232
    final LABQNT$ NXT=new LABQNT$(this,1,"NXT"); // Local Label #1=NXT
    // JavaLine 12 <== SourceLine 1253
    final LABQNT$ L=new LABQNT$(this,2,"L"); // Local Label #2=L
    // JavaLine 14 <== SourceLine 1314
    final LABQNT$ ASG=new LABQNT$(this,3,"ASG"); // Local Label #3=ASG
    // JavaLine 16 <== SourceLine 1373
    final LABQNT$ XIT=new LABQNT$(this,4,"XIT"); // Local Label #4=XIT
    // Declare locals as attributes
    // JavaLine 19 <== SourceLine 1171
    Common$designator d=null;
    Common$expr dx=null;
    Common$expr x=null;
    int n=0;
    // JavaLine 24 <== SourceLine 1233
    Link$ inspect$1233$92=null;
    // JavaLine 26 <== SourceLine 1310
    PrintFile$ inspect$1309$93=null;
    // JavaLine 28 <== SourceLine 1319
    PrintFile$ inspect$1318$94=null;
    // JavaLine 30 <== SourceLine 1341
    Link$ inspect$1341$95=null;
    // JavaLine 32 <== SourceLine 1345
    Common$dest_descr inspect$1345$96=null;
    // JavaLine 34 <== SourceLine 1350
    Common$label_descr inspect$1350$97=null;
    // Normal Constructor
    public Pass1$SubBlock32$grammar$statement(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$grammar$statement STM$() {
        Pass1$SubBlock32$grammar$statement THIS$=(Pass1$SubBlock32$grammar$statement)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 50 <== SourceLine 1231
                while(true) {
                    // JavaLine 52 <== SourceLine 1232
                    {
                        // JavaLine 54 <== SourceLine 1242
                        LABEL$(1,"NXT");
                        // JavaLine 56 <== SourceLine 1232
                        while((!(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.TRC_info$1.empty()))) {
                            // JavaLine 58 <== SourceLine 1233
                            {
                                {
                                    // BEGIN INSPECTION 
                                    inspect$1233$92=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.TRC_info$1.first();
                                    //INSPECT inspect$1233$92
                                    if(inspect$1233$92 instanceof Common$trace_item) // WHEN Common$trace_item DO 
                                    // JavaLine 65 <== SourceLine 1234
                                    {
                                        new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_TRACE$1);
                                        ;
                                        ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.out2byte(((Common$trace_item)(inspect$1233$92)).p2$s);
                                        ;
                                        ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.out2byte(((Common$trace_item)(inspect$1233$92)).p2$v);
                                        ;
                                        // JavaLine 73 <== SourceLine 1235
                                        if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                            new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                                        }
                                        ;
                                    }
                                    else if(inspect$1233$92 instanceof Common$info_item) // WHEN Common$info_item DO 
                                    // JavaLine 80 <== SourceLine 1238
                                    {
                                        new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INFO$1);
                                        ;
                                        new OuptFile$outstring(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$info_item)(inspect$1233$92)).p2$v);
                                        ;
                                        // JavaLine 86 <== SourceLine 1239
                                        if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                            new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                                        }
                                        ;
                                    }
                                    else // OTHERWISE 
                                    // JavaLine 93 <== SourceLine 1241
                                    new Common$IERR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62);
                                }
                                ;
                                ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.TRC_info$1.first().out();
                                ;
                            }
                        }
                        ;
                        // JavaLine 102 <== SourceLine 1244
                        if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.curline$1>(((Pass1$SubBlock32$grammar)(CUR$.SL$)).outline$1)))) {
                            // JavaLine 104 <== SourceLine 1245
                            {
                                new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LINE$1);
                                ;
                                // JavaLine 108 <== SourceLine 1246
                                ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.out2byte(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.curline$1);
                                ;
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).outline$1=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.curline$1;
                                ;
                                // JavaLine 113 <== SourceLine 1247
                                if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                                }
                                ;
                            }
                        }
                        ;
                        // JavaLine 121 <== SourceLine 1250
                        switch(((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol) { // BEGIN SWITCH STATEMENT
                        case 63: 
                        // JavaLine 124 <== SourceLine 1253
                        {
                            LABEL$(2,"L");
                            n=Math.addExact(n,1);
                            ;
                            // JavaLine 129 <== SourceLine 1254
                            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IF$1);
                            ;
                            // JavaLine 132 <== SourceLine 1255
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 135 <== SourceLine 1256
                            new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$);
                            ;
                            // JavaLine 138 <== SourceLine 1257
                            if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                            }
                            ;
                            // JavaLine 143 <== SourceLine 1258
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_THEN$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1258,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_THEN$1);
                            }
                            ;
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 150 <== SourceLine 1259
                            new Pass1$SubBlock32$grammar$statement(((Pass1$SubBlock32$grammar)(CUR$.SL$)));
                            ;
                            // JavaLine 153 <== SourceLine 1260
                            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ELSE$1);
                            ;
                            // JavaLine 156 <== SourceLine 1261
                            if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                            }
                            ;
                            // JavaLine 161 <== SourceLine 1262
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ELSIF$1)))) {
                                GOTO$(L); // GOTO EVALUATED LABEL
                            }
                            ;
                            // JavaLine 166 <== SourceLine 1263
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ELSE$1)))) {
                                {
                                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                    ;
                                    // JavaLine 171 <== SourceLine 1264
                                    new Pass1$SubBlock32$grammar$statement(((Pass1$SubBlock32$grammar)(CUR$.SL$)));
                                }
                            }
                            ;
                            // JavaLine 176 <== SourceLine 1265
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ENDIF$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1265,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ENDIF$1);
                            }
                            ;
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 183 <== SourceLine 1266
                            while((n!=(0))) {
                                {
                                    new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ENDIF$1);
                                    ;
                                    // JavaLine 188 <== SourceLine 1267
                                    n=Math.subtractExact(n,1);
                                    ;
                                    // JavaLine 191 <== SourceLine 1268
                                    if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                        new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                                    }
                                    ;
                                }
                            }
                            ;
                        }
                        break;
                        case 188: 
                        // JavaLine 202 <== SourceLine 1273
                        {
                            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_SKIPIF$1);
                            ;
                            // JavaLine 206 <== SourceLine 1274
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$);
                            ;
                            // JavaLine 211 <== SourceLine 1275
                            if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                            }
                            ;
                            // JavaLine 216 <== SourceLine 1276
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_SKIP$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1276,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_SKIP$1);
                            }
                            ;
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 223 <== SourceLine 1277
                            new Pass1$SubBlock32$grammar$statement(((Pass1$SubBlock32$grammar)(CUR$.SL$)));
                            ;
                            // JavaLine 226 <== SourceLine 1278
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ENDSKIP$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1278,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ENDSKIP$1);
                            }
                            ;
                            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ENDSKIP$1);
                            ;
                            // JavaLine 233 <== SourceLine 1279
                            if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                            }
                            ;
                            // JavaLine 238 <== SourceLine 1280
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                        }
                        break;
                        case 177: 
                        // JavaLine 244 <== SourceLine 1284
                        {
                            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_REPEAT$1);
                            ;
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 250 <== SourceLine 1285
                            if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                            }
                            ;
                            // JavaLine 255 <== SourceLine 1286
                            new Pass1$SubBlock32$grammar$statement(((Pass1$SubBlock32$grammar)(CUR$.SL$)));
                            ;
                            // JavaLine 258 <== SourceLine 1287
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_WHILE$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1287,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_WHILE$1);
                            }
                            ;
                            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_WHILE$1);
                            ;
                            // JavaLine 265 <== SourceLine 1288
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$);
                            ;
                            // JavaLine 270 <== SourceLine 1289
                            if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                            }
                            ;
                            // JavaLine 275 <== SourceLine 1290
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_DO$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1290,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_DO$1);
                            }
                            ;
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 282 <== SourceLine 1291
                            new Pass1$SubBlock32$grammar$statement(((Pass1$SubBlock32$grammar)(CUR$.SL$)));
                            ;
                            // JavaLine 285 <== SourceLine 1292
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ENDREPEAT$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1292,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ENDREPEAT$1);
                            }
                            ;
                            // JavaLine 290 <== SourceLine 1293
                            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ENDREPEAT$1);
                            ;
                            // JavaLine 293 <== SourceLine 1294
                            if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                            }
                            ;
                            // JavaLine 298 <== SourceLine 1295
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                        }
                        break;
                        case 183: 
                        // JavaLine 304 <== SourceLine 1299
                        new Pass1$SubBlock32$grammar$statement$case_stat(((Pass1$SubBlock32$grammar$statement)(CUR$)));
                        break;
                        case 94: 
                        // JavaLine 308 <== SourceLine 1302
                        {
                            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_GOTO$1);
                            ;
                            // JavaLine 312 <== SourceLine 1303
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$);
                            ;
                            // JavaLine 317 <== SourceLine 1304
                            if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                            }
                            ;
                        }
                        break;
                        case 176: 
                        case 70: 
                        case 216: 
                        // JavaLine 327 <== SourceLine 1308
                        {
                            dx=new Pass1$SubBlock32$grammar$indesignator(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$;
                            ;
                            // JavaLine 331 <== SourceLine 1309
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).tracemode>(2)))) {
                                {
                                    // BEGIN INSPECTION 
                                    inspect$1309$93=sysout();
                                    if(inspect$1309$93!=null) // INSPECT inspect$1309$93
                                    // JavaLine 337 <== SourceLine 1310
                                    {
                                        inspect$1309$93.outtext(new TXT$("Expr: "));
                                        ;
                                        new Common$prt(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,dx,10);
                                        ;
                                        inspect$1309$93.outimage();
                                    }
                                }
                            }
                            ;
                            // JavaLine 348 <== SourceLine 1311
                            if(VALUE$(IS$(dx,Common$designator.class))) {
                                d=((Common$designator)(dx));
                            } else
                            // JavaLine 352 <== SourceLine 1312
                            {
                                new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Misplaced qua"));
                                ;
                                d=((Common$designator)(((Common$quaopr)(dx)).p3$x));
                            }
                            ;
                            // JavaLine 359 <== SourceLine 1313
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ASSIGN$1)))) {
                                // JavaLine 361 <== SourceLine 1314
                                {
                                    LABEL$(3,"ASG");
                                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).target.Elt[n-((Pass1$SubBlock32$grammar)(CUR$.SL$)).target.LB[0]]=d;
                                    ;
                                    n=Math.addExact(n,1);
                                    ;
                                    // JavaLine 368 <== SourceLine 1315
                                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                    ;
                                    // JavaLine 371 <== SourceLine 1316
                                    if(VALUE$(((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1))||((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_VAR$1)))))) {
                                        // JavaLine 373 <== SourceLine 1317
                                        {
                                            dx=new Pass1$SubBlock32$grammar$indesignator(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$;
                                            ;
                                            // JavaLine 377 <== SourceLine 1318
                                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).tracemode>(2)))) {
                                                {
                                                    // BEGIN INSPECTION 
                                                    inspect$1318$94=sysout();
                                                    if(inspect$1318$94!=null) // INSPECT inspect$1318$94
                                                    // JavaLine 383 <== SourceLine 1319
                                                    {
                                                        inspect$1318$94.outtext(new TXT$("Expr: "));
                                                        ;
                                                        // JavaLine 387 <== SourceLine 1320
                                                        new Common$prt(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,dx,10);
                                                        ;
                                                        inspect$1318$94.outimage();
                                                        ;
                                                    }
                                                }
                                            }
                                            ;
                                            // JavaLine 396 <== SourceLine 1322
                                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ASSIGN$1)))) {
                                                // JavaLine 398 <== SourceLine 1323
                                                {
                                                    if(VALUE$(IS$(dx,Common$designator.class))) {
                                                        d=((Common$designator)(dx));
                                                    } else
                                                    // JavaLine 403 <== SourceLine 1324
                                                    {
                                                        new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Misplaced qua"));
                                                        ;
                                                        // JavaLine 407 <== SourceLine 1325
                                                        d=((Common$designator)(((Common$quaopr)(dx)).p3$x));
                                                        ;
                                                    }
                                                    ;
                                                    // JavaLine 412 <== SourceLine 1327
                                                    GOTO$(ASG); // GOTO EVALUATED LABEL
                                                    ;
                                                }
                                            }
                                            ;
                                            // JavaLine 418 <== SourceLine 1329
                                            x=new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),dx).RESULT$;
                                            ;
                                        }
                                    } else
                                    // JavaLine 423 <== SourceLine 1330
                                    x=new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$;
                                    ;
                                    // JavaLine 426 <== SourceLine 1331
                                    new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ASSIGN$1);
                                    ;
                                    new OuptFile$outbyt(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,n);
                                    ;
                                    new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),x);
                                    ;
                                    // JavaLine 433 <== SourceLine 1332
                                    while((n!=(0))) {
                                        // JavaLine 435 <== SourceLine 1333
                                        {
                                            n=Math.subtractExact(n,1);
                                            ;
                                            new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),((Pass1$SubBlock32$grammar)(CUR$.SL$)).target.Elt[n-((Pass1$SubBlock32$grammar)(CUR$.SL$)).target.LB[0]]);
                                            ;
                                            // JavaLine 441 <== SourceLine 1334
                                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).target.Elt[n-((Pass1$SubBlock32$grammar)(CUR$.SL$)).target.LB[0]]=null;
                                            ;
                                        }
                                    }
                                    ;
                                    // JavaLine 447 <== SourceLine 1336
                                    if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                        new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                                    }
                                    ;
                                }
                            } else
                            // JavaLine 454 <== SourceLine 1338
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COLON$1)))) {
                                // JavaLine 456 <== SourceLine 1341
                                {
                                    {
                                        // BEGIN INSPECTION 
                                        inspect$1341$95=d.p3$varset.first();
                                        //INSPECT inspect$1341$95
                                        if(inspect$1341$95 instanceof Common$variable) // WHEN Common$variable DO 
                                        // JavaLine 463 <== SourceLine 1342
                                        {
                                            if(VALUE$(((((Common$variable)(inspect$1341$95)).argset$2!=(null))||((((Common$variable)inspect$1341$95).suc()!=(null)))))) {
                                                // JavaLine 466 <== SourceLine 1343
                                                new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Illegal label identifier"));
                                            }
                                            ;
                                            // JavaLine 470 <== SourceLine 1344
                                            if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.rutlev$1>(0)))) {
                                                // JavaLine 472 <== SourceLine 1345
                                                {
                                                    {
                                                        // BEGIN INSPECTION 
                                                        inspect$1345$96=new Common$dest_descr(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                                                        if(inspect$1345$96!=null) // INSPECT inspect$1345$96
                                                        // JavaLine 478 <== SourceLine 1346
                                                        {
                                                            inspect$1345$96.symb$2=((Common$variable)(inspect$1341$95)).varbox$2;
                                                            ;
                                                            // JavaLine 482 <== SourceLine 1349
                                                            inspect$1345$96.into(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.localdecl$1);
                                                        }
                                                    }
                                                }
                                            } else
                                            // JavaLine 488 <== SourceLine 1350
                                            {
                                                {
                                                    // BEGIN INSPECTION 
                                                    inspect$1350$97=new Common$label_descr(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                                                    if(inspect$1350$97!=null) // INSPECT inspect$1350$97
                                                    // JavaLine 494 <== SourceLine 1351
                                                    {
                                                        inspect$1350$97.symb$2=((Common$variable)(inspect$1341$95)).varbox$2;
                                                        ;
                                                        // JavaLine 498 <== SourceLine 1352
                                                        inspect$1350$97.visible$2=((Pass1$SubBlock32)(CUR$.SL$.SL$)).all_visible;
                                                        ;
                                                        inspect$1350$97.into(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.qntset$1);
                                                        ;
                                                    }
                                                }
                                                ;
                                            }
                                            ;
                                            // JavaLine 508 <== SourceLine 1355
                                            new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_DEFLAB$1);
                                            ;
                                            // JavaLine 511 <== SourceLine 1356
                                            new OuptFile$outident(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Common$variable)(inspect$1341$95)).varbox$2.id);
                                            ;
                                            // JavaLine 514 <== SourceLine 1357
                                            if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                                new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                                            }
                                            ;
                                        }
                                        else // OTHERWISE 
                                        // JavaLine 521 <== SourceLine 1358
                                        new Common$IERR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62);
                                    }
                                    ;
                                    // JavaLine 525 <== SourceLine 1359
                                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                    ;
                                    // JavaLine 528 <== SourceLine 1360
                                    GOTO$(NXT); // GOTO EVALUATED LABEL
                                    ;
                                }
                            } else
                            // JavaLine 533 <== SourceLine 1363
                            {
                                new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_CALL$1);
                                ;
                                new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),d);
                                ;
                                // JavaLine 539 <== SourceLine 1364
                                if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                                }
                                ;
                            }
                        }
                        break;
                        default:
                        // JavaLine 548 <== SourceLine 1369
                        GOTO$(XIT); // GOTO EVALUATED LABEL
                        break;
                    } // END SWITCH STATEMENT
                    ;
                }
                if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
            }
            ;
            // JavaLine 557 <== SourceLine 1373
            LABEL$(4,"XIT");
            ;
            break LOOP$;
        }
        catch(LABQNT$ q) {
            CUR$=THIS$;
            if(q.SL$!=CUR$) {
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("statement:NON-LOCAL",q);
                CUR$.STATE$=OperationalState.terminated;
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("statement:RE-THROW",q);
                throw(q);
            }
            if(RT.Option.GOTO_TRACING) TRACE_GOTO("statement:LOCAL",q);
            JTX$=q.index; continue LOOP$; // EG. GOTO Lx
        }
    }
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure statement",1,1170,10,1232,12,1253,14,1314,16,1373,19,1171,24,1233,26,1310,28,1319,30,1341,32,1345,34,1350,50,1231,52,1232,54,1242,56,1232,58,1233,65,1234,73,1235,80,1238,86,1239,93,1241,102,1244,104,1245,108,1246,113,1247,121,1250,124,1253,129,1254,132,1255,135,1256,138,1257,143,1258,150,1259,153,1260,156,1261,161,1262,166,1263,171,1264,176,1265,183,1266,188,1267,191,1268,202,1273,206,1274,211,1275,216,1276,223,1277,226,1278,233,1279,238,1280,244,1284,250,1285,255,1286,258,1287,265,1288,270,1289,275,1290,282,1291,285,1292,290,1293,293,1294,298,1295,304,1299,308,1302,312,1303,317,1304,327,1308,331,1309,337,1310,348,1311,352,1312,359,1313,361,1314,368,1315,371,1316,373,1317,377,1318,383,1319,387,1320,396,1322,398,1323,403,1324,407,1325,412,1327,418,1329,423,1330,426,1331,433,1332,435,1333,441,1334,447,1336,454,1338,456,1341,463,1342,466,1343,470,1344,472,1345,478,1346,482,1349,488,1350,494,1351,498,1352,508,1355,511,1356,514,1357,521,1358,525,1359,528,1360,533,1363,539,1364,548,1369,557,1373,576,1373);
} // End of Procedure
