// JavaLine 1 ==> SourceLine 1150
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$prechecker$allocate$alloc2 extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1150, lastLine=1511, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$brecord p$brc;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 1362
    final LABQNT$ NXTVA=new LABQNT$(this,0,1); // Local Label #1=NXTVA
    // JavaLine 14 ==> SourceLine 1461
    final LABQNT$ EXBIND=new LABQNT$(this,0,2); // Local Label #2=EXBIND
    // JavaLine 16 ==> SourceLine 1496
    final LABQNT$ CH=new LABQNT$(this,0,3); // Local Label #3=CH
    // JavaLine 18 ==> SourceLine 1509
    final LABQNT$ LBL=new LABQNT$(this,0,4); // Local Label #4=LBL
    // Declare locals as attributes
    // JavaLine 21 ==> SourceLine 1157
    COMMON$quantity Q=null;
    COMMON$quantity QX=null;
    COMMON$quantity VA=null;
    COMMON$quantity VB=null;
    COMMON$quantity VC=null;
    COMMON$brecord B=null;
    COMMON$idpack fvis=null;
    // JavaLine 29 ==> SourceLine 1158
    int VNO=0;
    // JavaLine 31 ==> SourceLine 1405
    COMMON$quantity inspect$1405$14=null;
    // JavaLine 33 ==> SourceLine 1419
    COMMON$brecord inspect$1419$15=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER2$prechecker$allocate$alloc2 setPar(Object param) {
        //Util.BREAK("CALL BUILDER2$prechecker$allocate$alloc2.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$brc=(COMMON$brecord)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER2$prechecker$allocate$alloc2(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER2$prechecker$allocate$alloc2(RTObject$ SL$,COMMON$brecord sp$brc) {
        super(SL$);
        // Parameter assignment to locals
        this.p$brc = sp$brc;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("alloc2",1419);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$prechecker$allocate$alloc2 STM$() {
        TRACE_BEGIN_STM$("alloc2",1419);
        BUILDER2$prechecker$allocate$alloc2 THIS$=(BUILDER2$prechecker$allocate$alloc2)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 68 ==> SourceLine 1289
                if(((p$brc.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_class))||((p$brc.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_record))))) {
                    // JavaLine 70 ==> SourceLine 1290
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1290",1290);
                        p$brc.declquant.match=((BUILDER2)(CUR$.SL$.SL$.SL$)).alloc2called;
                        // JavaLine 74 ==> SourceLine 1291
                        if((p$brc.declquant.plev>(((BUILDER2)(CUR$.SL$.SL$.SL$)).one))) {
                            // JavaLine 76 ==> SourceLine 1292
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1292",1292);
                                B=p$brc.declquant.prefqual.descr;
                                // JavaLine 80 ==> SourceLine 1293
                                if((B.declquant.match!=(((BUILDER2)(CUR$.SL$.SL$.SL$)).alloc2called))) {
                                    new BUILDER2$prechecker$allocate$alloc2(((BUILDER2$prechecker$allocate)(CUR$.SL$)),B);
                                }
                                // JavaLine 84 ==> SourceLine 1294
                                p$brc.localclasses=(p$brc.localclasses|(B.localclasses));
                                // JavaLine 86 ==> SourceLine 1295
                                p$brc.npar=(p$brc.npar+(B.npar));
                                TRACE_END_STM$("CompoundStatement1292",1295);
                            }
                        } else
                        // JavaLine 91 ==> SourceLine 1298
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1298",1298);
                            Q=new COMMON$quantity(((BUILDER2)(CUR$.SL$.SL$.SL$))).STM$();
                            // JavaLine 95 ==> SourceLine 1299
                            new BUILDER1$precheck0$makeequalto(((BUILDER2$prechecker)(CUR$.SL$.SL$)),p$brc.declquant,Q);
                            // JavaLine 97 ==> SourceLine 1301
                            Q.plev=((BUILDER2)(CUR$.SL$.SL$.SL$)).zero;
                            // JavaLine 99 ==> SourceLine 1302
                            p$brc.declquant.prefqual=Q;
                            // JavaLine 101 ==> SourceLine 1303
                            B=new COMMON$brecord(((BUILDER2)(CUR$.SL$.SL$.SL$))).STM$();
                            // JavaLine 103 ==> SourceLine 1304
                            Q.descr=B;
                            B.declquant=Q;
                            B.kind=p$brc.kind;
                            // JavaLine 107 ==> SourceLine 1305
                            B.blnohi=((BUILDER2$prechecker)(CUR$.SL$.SL$)).lastblhi;
                            B.blnolo=((BUILDER2$prechecker)(CUR$.SL$.SL$)).lastbllo;
                            // JavaLine 110 ==> SourceLine 1306
                            B.blev=p$brc.blev;
                            B.rtblev=p$brc.rtblev;
                            // JavaLine 113 ==> SourceLine 1307
                            B.hasCode=p$brc.declquant.descr.hasCode;
                            // JavaLine 115 ==> SourceLine 1309
                            if((((BUILDER2$prechecker)(CUR$.SL$.SL$)).detachquant!=(null))) {
                                // JavaLine 117 ==> SourceLine 1310
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1310",1310);
                                    if((p$brc.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_class))) {
                                        // JavaLine 121 ==> SourceLine 1311
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1311",1311);
                                            QX=new COMMON$extquantity(((BUILDER2)(CUR$.SL$.SL$.SL$)),null).STM$();
                                            // JavaLine 125 ==> SourceLine 1312
                                            new BUILDER1$precheck0$makeequalto(((BUILDER2$prechecker)(CUR$.SL$.SL$)),((BUILDER2$prechecker)(CUR$.SL$.SL$)).detachquant,QX);
                                            // JavaLine 127 ==> SourceLine 1313
                                            QX.plev=((BUILDER2)(CUR$.SL$.SL$.SL$)).zero;
                                            // JavaLine 129 ==> SourceLine 1314
                                            B.fpar=QX;
                                            QX.encl=B;
                                            TRACE_END_STM$("CompoundStatement1311",1314);
                                        }
                                    }
                                    TRACE_END_STM$("CompoundStatement1310",1314);
                                }
                            }
                            TRACE_END_STM$("CompoundStatement1298",1314);
                        }
                        TRACE_END_STM$("CompoundStatement1290",1314);
                    }
                }
                // JavaLine 143 ==> SourceLine 1320
                if((p$brc.fpar!=(null))) {
                    // JavaLine 145 ==> SourceLine 1321
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1321",1321);
                        new BUILDER2$normalattrfile$expandexternals(((BUILDER2)(CUR$.SL$.SL$.SL$)).Afile,p$brc);
                        TRACE_END_STM$("CompoundStatement1321",1321);
                    }
                }
                // JavaLine 152 ==> SourceLine 1327
                if(((p$brc.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_class))||((p$brc.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_prefbl))))) {
                    // JavaLine 154 ==> SourceLine 1328
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1328",1328);
                        if((p$brc.declquant.plev>(((BUILDER2)(CUR$.SL$.SL$.SL$)).one))) {
                            // JavaLine 158 ==> SourceLine 1331
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1331",1331);
                                if(p$brc.declquant.prefqual.descr.hasCode) {
                                    // JavaLine 162 ==> SourceLine 1332
                                    p$brc.hasCode=true;
                                }
                                // JavaLine 165 ==> SourceLine 1335
                                new BUILDER1$precheck0$hide(((BUILDER2$prechecker)(CUR$.SL$.SL$)),p$brc.declquant.prefqual,false);
                                // JavaLine 167 ==> SourceLine 1336
                                VC=p$brc.declquant.prefqual.descr.favirt;
                                // JavaLine 169 ==> SourceLine 1337
                                while((VC!=(null))) {
                                    // JavaLine 171 ==> SourceLine 1339
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1339",1339);
                                        QX=((IS$(VC,COMMON$quantity.class))?(new COMMON$quantity(((BUILDER2)(CUR$.SL$.SL$.SL$))).STM$()):(new COMMON$extquantity(((BUILDER2)(CUR$.SL$.SL$.SL$)),null).STM$()));
                                        // JavaLine 175 ==> SourceLine 1341
                                        if((VA==(null))) {
                                            VA=VB=QX;
                                        } else
                                        // JavaLine 179 ==> SourceLine 1342
                                        VB=((COMMON$quantity)(VB.next=QX));
                                        // JavaLine 181 ==> SourceLine 1343
                                        new BUILDER1$precheck0$makeequalto(((BUILDER2$prechecker)(CUR$.SL$.SL$)),VC,VB);
                                        // JavaLine 183 ==> SourceLine 1344
                                        VB.encl=p$brc;
                                        // JavaLine 185 ==> SourceLine 1345
                                        VB.dim=0;
                                        // JavaLine 187 ==> SourceLine 1346
                                        VC=((COMMON$quantity)(VC.next));
                                        TRACE_END_STM$("CompoundStatement1339",1346);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement1331",1346);
                            }
                        }
                        // JavaLine 195 ==> SourceLine 1349
                        QX=p$brc.favirt;
                        // JavaLine 197 ==> SourceLine 1350
                        if(((VA!=(null))||((QX!=(null))))) {
                            // JavaLine 199 ==> SourceLine 1351
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1351",1351);
                                VC=p$brc.favirt;
                                // JavaLine 203 ==> SourceLine 1352
                                if((VA!=(null))) {
                                    // JavaLine 205 ==> SourceLine 1353
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1353",1353);
                                        VB.next=p$brc.favirt;
                                        p$brc.favirt=VA;
                                        // JavaLine 210 ==> SourceLine 1354
                                        VNO=VB.virtno;
                                        TRACE_END_STM$("CompoundStatement1353",1354);
                                    }
                                } else
                                // JavaLine 215 ==> SourceLine 1355
                                VNO=0;
                                // JavaLine 217 ==> SourceLine 1358
                                while((VC!=(null))) {
                                    // JavaLine 219 ==> SourceLine 1360
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1360",1360);
                                        VA=p$brc.favirt;
                                        // JavaLine 223 ==> SourceLine 1361
                                        while(((VA!=(VC))&&((VA.symb!=(VC.symb))))) {
                                            // JavaLine 225 ==> SourceLine 1362
                                            LABEL$(1); // NXTVA
                                            VA=((COMMON$quantity)(VA.next));
                                        }
                                        // JavaLine 229 ==> SourceLine 1363
                                        if((VA!=(VC))) {
                                            // JavaLine 231 ==> SourceLine 1364
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1364",1364);
                                                if((VA.visible!=(((BUILDER2)(CUR$.SL$.SL$.SL$)).NUL))) {
                                                    GOTO$(NXTVA); // GOTO EVALUATED LABEL
                                                }
                                                // JavaLine 237 ==> SourceLine 1366
                                                new ERRMSG$errQTN(((BUILDER2)(CUR$.SL$.SL$.SL$)),VC,414,VA);
                                                // JavaLine 239 ==> SourceLine 1368
                                                while((VA.next!=(VC))) {
                                                    VA=((COMMON$quantity)(VA.next));
                                                }
                                                // JavaLine 243 ==> SourceLine 1369
                                                VA.next=VC.next;
                                                VC=VA;
                                                TRACE_END_STM$("CompoundStatement1364",1369);
                                            }
                                        } else
                                        // JavaLine 249 ==> SourceLine 1371
                                        if(((VC.kind!=(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_proc))&&((VC.type!=(((BUILDER2)(CUR$.SL$.SL$.SL$)).ILABE))))) {
                                            // JavaLine 251 ==> SourceLine 1373
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1373",1373);
                                                new ERRMSG$errQT(((BUILDER2)(CUR$.SL$.SL$.SL$)),VC,326);
                                                // JavaLine 255 ==> SourceLine 1374
                                                VC.type=((BUILDER2)(CUR$.SL$.SL$.SL$)).IELSE;
                                                VC.kind=((BUILDER2)(CUR$.SL$.SL$.SL$)).K_error;
                                                TRACE_END_STM$("CompoundStatement1373",1374);
                                            }
                                        }
                                        // JavaLine 261 ==> SourceLine 1376
                                        VNO=(VNO+(1));
                                        VC.virtno=VNO;
                                        // JavaLine 264 ==> SourceLine 1377
                                        VC.dim=1;
                                        // JavaLine 266 ==> SourceLine 1378
                                        VC=((COMMON$quantity)(VC.next));
                                        TRACE_END_STM$("CompoundStatement1360",1378);
                                    }
                                }
                                // JavaLine 271 ==> SourceLine 1380
                                p$brc.navirt=VNO;
                                TRACE_END_STM$("CompoundStatement1351",1380);
                            }
                        } else
                        // JavaLine 276 ==> SourceLine 1381
                        p$brc.navirt=0;
                        TRACE_END_STM$("CompoundStatement1328",1381);
                    }
                }
                // JavaLine 281 ==> SourceLine 1385
                Q=p$brc.fpar;
                // JavaLine 283 ==> SourceLine 1386
                if((Q!=(null))) {
                    // JavaLine 285 ==> SourceLine 1387
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1387",1387);
                        Q=new BUILDER2$prechecker$allocate$alloc2$setprefqual(((BUILDER2$prechecker$allocate$alloc2)CUR$),Q,true).RESULT$;
                        TRACE_END_STM$("CompoundStatement1387",1387);
                    }
                }
                // JavaLine 292 ==> SourceLine 1389
                if(((p$brc.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_labbl))||((p$brc.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_record))))) {
                    // JavaLine 294 ==> SourceLine 1392
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1392",1392);
                        new BUILDER1$precheck0$vischain(((BUILDER2$prechecker)(CUR$.SL$.SL$)),p$brc.fpar,VC);
                        TRACE_END_STM$("CompoundStatement1392",1392);
                    }
                } else
                // JavaLine 301 ==> SourceLine 1395
                {
                    TRACE_BEGIN_STM$("CompoundStatement1395",1395);
                    ((BUILDER2)(CUR$.SL$.SL$.SL$)).cblev=char$((rank(((BUILDER2)(CUR$.SL$.SL$.SL$)).cblev)+(1)));
                    ((BUILDER2)(CUR$.SL$.SL$.SL$)).crtblev=char$((rank(((BUILDER2)(CUR$.SL$.SL$.SL$)).crtblev)+(1)));
                    // JavaLine 306 ==> SourceLine 1396
                    if((rank(((BUILDER2)(CUR$.SL$.SL$.SL$)).cblev)>(((BUILDER2)(CUR$.SL$.SL$.SL$)).maxblev))) {
                        new ERRMSG$fatal0(((BUILDER2)(CUR$.SL$.SL$.SL$)),299);
                    }
                    // JavaLine 310 ==> SourceLine 1397
                    new BUILDER1$precheck0$makevisblock(((BUILDER2$prechecker)(CUR$.SL$.SL$)),p$brc);
                    TRACE_END_STM$("CompoundStatement1395",1397);
                }
                // JavaLine 314 ==> SourceLine 1400
                if((QX!=(null))) {
                    new BUILDER2$prechecker$allocate$alloc2$setprefqual(((BUILDER2$prechecker$allocate$alloc2)CUR$),QX,false);
                }
                // JavaLine 318 ==> SourceLine 1401
                if((Q!=(null))) {
                    new BUILDER2$prechecker$allocate$alloc2$setprefqual(((BUILDER2$prechecker$allocate$alloc2)CUR$),Q,false);
                }
                // JavaLine 322 ==> SourceLine 1404
                VC=p$brc.favirt;
                // JavaLine 324 ==> SourceLine 1405
                while(true) {
                    {
                        // BEGIN INSPECTION 
                        inspect$1405$14=VC;
                        if(inspect$1405$14!=null) //INSPECT inspect$1405$14
                        // JavaLine 330 ==> SourceLine 1406
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1406",1406);
                            if((inspect$1405$14.visible==(((BUILDER2)(CUR$.SL$.SL$.SL$)).NUL))) {
                                // JavaLine 334 ==> SourceLine 1407
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1407",1407);
                                    VA=p$brc.fpar;
                                    // JavaLine 338 ==> SourceLine 1408
                                    while(((VA!=(null))&&((VA.symb!=(inspect$1405$14.symb))))) {
                                        // JavaLine 340 ==> SourceLine 1409
                                        VA=((COMMON$quantity)(VA.next));
                                    }
                                    // JavaLine 343 ==> SourceLine 1410
                                    if((VA!=(null))) {
                                        // JavaLine 345 ==> SourceLine 1411
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1411",1411);
                                            if((((((inspect$1405$14.type==(((BUILDER2)(CUR$.SL$.SL$.SL$)).IELSE))&&(((VA.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_proc))||((VA.type==(((BUILDER2)(CUR$.SL$.SL$.SL$)).ILABE))))))||(((((inspect$1405$14.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_proc))&&((VA.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_proc))))&&((VA.categ!=(((BUILDER2)(CUR$.SL$.SL$.SL$)).C_extnal))))&&(new BUILDER1$precheck0$subordinate(((BUILDER2$prechecker)(CUR$.SL$.SL$)),VA,((COMMON$quantity)inspect$1405$14)).RESULT$))))||(((inspect$1405$14.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_label))&&((VA.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_label))))))||(((inspect$1405$14.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_switch))&&((VA.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_switch))))))) {
                                                // JavaLine 349 ==> SourceLine 1419
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement1419",1419);
                                                    {
                                                        // BEGIN INSPECTION 
                                                        inspect$1419$15=inspect$1405$14.descr;
                                                        if(inspect$1419$15!=null) //INSPECT inspect$1419$15
                                                        // JavaLine 356 ==> SourceLine 1446
                                                        new BUILDER2$prechecker$allocate$alloc2$CompoundStatement1406$CompoundStatement1407$CompoundStatement1411$CompoundStatement1419$SubBlock1421(CUR$).STM$();
                                                    }
                                                    // JavaLine 359 ==> SourceLine 1447
                                                    VA.match=((COMMON$quantity)inspect$1405$14);
                                                    inspect$1405$14.match=VA;
                                                    // JavaLine 362 ==> SourceLine 1449
                                                    inspect$1405$14.type=VA.type;
                                                    inspect$1405$14.prefqual=VA.prefqual;
                                                    // JavaLine 365 ==> SourceLine 1450
                                                    VA.protect=inspect$1405$14.protect;
                                                    TRACE_END_STM$("CompoundStatement1419",1450);
                                                }
                                            } else
                                            // JavaLine 370 ==> SourceLine 1451
                                            new ERRMSG$errQTN(((BUILDER2)(CUR$.SL$.SL$.SL$)),VA,415,((COMMON$quantity)inspect$1405$14));
                                            TRACE_END_STM$("CompoundStatement1411",1451);
                                        }
                                    }
                                    TRACE_END_STM$("CompoundStatement1407",1451);
                                }
                            }
                            // JavaLine 378 ==> SourceLine 1454
                            VC=((COMMON$quantity)(inspect$1405$14.next));
                            TRACE_END_STM$("CompoundStatement1406",1454);
                        }
                        else // OTHERWISE 
                        // JavaLine 383 ==> SourceLine 1456
                        GOTO$(EXBIND); // GOTO EVALUATED LABEL
                    }
                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                }
                // JavaLine 388 ==> SourceLine 1466
                LABEL$(2); // EXBIND
                // JavaLine 390 ==> SourceLine 1461
                if(((((BUILDER2$prechecker)(CUR$.SL$.SL$)).detachquant==(null))&&((p$brc.blev==(((char)2)))))) {
                    // JavaLine 392 ==> SourceLine 1462
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1462",1462);
                        ((BUILDER2$prechecker)(CUR$.SL$.SL$)).detachquant=((COMMON$quantity)(((COMMON$identsymbol)(new COMMON$boxof(((BUILDER2)(CUR$.SL$.SL$.SL$)),((BUILDER2)(CUR$.SL$.SL$.SL$)).NUL,((BUILDER2)(CUR$.SL$.SL$.SL$)).detachident).RESULT$)).curmeaning));
                        // JavaLine 396 ==> SourceLine 1464
                        if((((BUILDER2$prechecker)(CUR$.SL$.SL$)).detachquant==(null))) {
                            // JavaLine 398 ==> SourceLine 1465
                            ((BUILDER2$prechecker)(CUR$.SL$.SL$)).detachquant=new ERRMSG$newnotseen(((BUILDER2)(CUR$.SL$.SL$.SL$)),new COMMON$boxof(((BUILDER2)(CUR$.SL$.SL$.SL$)),((BUILDER2)(CUR$.SL$.SL$.SL$)).NUL,((BUILDER2)(CUR$.SL$.SL$.SL$)).detachident).RESULT$).RESULT$;
                        }
                        TRACE_END_STM$("CompoundStatement1462",1465);
                    }
                }
                // JavaLine 404 ==> SourceLine 1470
                Q=p$brc.fpar;
                // JavaLine 406 ==> SourceLine 1471
                while((Q!=(null))) {
                    // JavaLine 408 ==> SourceLine 1473
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1473",1473);
                        switch(Q.kind) { // BEGIN SWITCH STATEMENT
                        case 1: 
                        // JavaLine 413 ==> SourceLine 1475
                        if(((Q.categ==(((BUILDER2)(CUR$.SL$.SL$.SL$)).C_local))||((Q.categ==(((BUILDER2)(CUR$.SL$.SL$.SL$)).C_extnal))))) {
                            // JavaLine 415 ==> SourceLine 1476
                            new BUILDER2$prechecker$allocate$alloc2(((BUILDER2$prechecker$allocate)(CUR$.SL$)),Q.descr);
                        }
                        case 5: 
                        case 7: 
                        // JavaLine 420 ==> SourceLine 1478
                        if((Q.match!=(((BUILDER2)(CUR$.SL$.SL$.SL$)).alloc2called))) {
                            new BUILDER2$prechecker$allocate$alloc2(((BUILDER2$prechecker$allocate)(CUR$.SL$)),Q.descr);
                        }
                    } // END SWITCH STATEMENT
                    // JavaLine 425 ==> SourceLine 1480
                    Q=((COMMON$quantity)(Q.next));
                    TRACE_END_STM$("CompoundStatement1473",1480);
                }
            }
            // JavaLine 430 ==> SourceLine 1482
            switch(p$brc.kind) { // BEGIN SWITCH STATEMENT
            case 11: 
            case 7: 
            // JavaLine 434 ==> SourceLine 1490
            {
                TRACE_BEGIN_STM$("CompoundStatement1490",1490);
                Q=p$brc.fpar;
                new BUILDER1$precheck0$invischain(((BUILDER2$prechecker)(CUR$.SL$.SL$)),Q);
                TRACE_END_STM$("CompoundStatement1490",1490);
            }
            case 5: 
            // JavaLine 442 ==> SourceLine 1493
            {
                TRACE_BEGIN_STM$("CompoundStatement1493",1493);
                if((p$brc.hidlist!=(null))) {
                    // JavaLine 446 ==> SourceLine 1494
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1494",1494);
                        new BUILDER1$precheck0$unprotect(((BUILDER2$prechecker)(CUR$.SL$.SL$)),p$brc.declquant);
                        B=p$brc;
                        // JavaLine 451 ==> SourceLine 1495
                        new BUILDER2$prechecker$allocate$alloc2$checkhid(((BUILDER2$prechecker$allocate$alloc2)CUR$),p$brc.favirt);
                        // JavaLine 453 ==> SourceLine 1496
                        LABEL$(3); // CH
                        new BUILDER2$prechecker$allocate$alloc2$checkhid(((BUILDER2$prechecker$allocate$alloc2)CUR$),B.fpar);
                        // JavaLine 456 ==> SourceLine 1497
                        if((B.declquant.plev>(((BUILDER2)(CUR$.SL$.SL$.SL$)).one))) {
                            // JavaLine 458 ==> SourceLine 1498
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1498",1498);
                                B=B.declquant.prefqual.descr;
                                // JavaLine 462 ==> SourceLine 1499
                                new BUILDER1$precheck0$unprotect(((BUILDER2$prechecker)(CUR$.SL$.SL$)),B.declquant);
                                // JavaLine 464 ==> SourceLine 1500
                                GOTO$(CH); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1498",1500);
                            }
                        }
                        // JavaLine 469 ==> SourceLine 1501
                        fvis=p$brc.hidlist;
                        // JavaLine 471 ==> SourceLine 1502
                        while((fvis!=(null))) {
                            // JavaLine 473 ==> SourceLine 1503
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1503",1503);
                                if((fvis.line>(0))) {
                                    // JavaLine 477 ==> SourceLine 1504
                                    new ERRMSG$removeVis(((BUILDER2)(CUR$.SL$.SL$.SL$)),p$brc,fvis,368);
                                } else
                                fvis.line=(-(fvis.line));
                                // JavaLine 481 ==> SourceLine 1505
                                fvis=fvis.next;
                                TRACE_END_STM$("CompoundStatement1503",1505);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement1494",1505);
                    }
                }
                // JavaLine 489 ==> SourceLine 1508
                GOTO$(LBL); // GOTO EVALUATED LABEL
                TRACE_END_STM$("CompoundStatement1493",1508);
            }
            default:
            // JavaLine 494 ==> SourceLine 1509
            LABEL$(4); // LBL
            new BUILDER1$precheck0$leaveblock(((BUILDER2$prechecker)(CUR$.SL$.SL$)));
        } // END SWITCH STATEMENT
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
TRACE_END_STM$("alloc2",1509);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure alloc2",1,1150,12,1362,14,1461,16,1496,18,1509,21,1157,29,1158,31,1405,33,1419,68,1289,70,1290,74,1291,76,1292,80,1293,84,1294,86,1295,91,1298,95,1299,97,1301,99,1302,101,1303,103,1304,107,1305,110,1306,113,1307,115,1309,117,1310,121,1311,125,1312,127,1313,129,1314,143,1320,145,1321,152,1327,154,1328,158,1331,162,1332,165,1335,167,1336,169,1337,171,1339,175,1341,179,1342,181,1343,183,1344,185,1345,187,1346,195,1349,197,1350,199,1351,203,1352,205,1353,210,1354,215,1355,217,1358,219,1360,223,1361,225,1362,229,1363,231,1364,237,1366,239,1368,243,1369,249,1371,251,1373,255,1374,261,1376,264,1377,266,1378,271,1380,276,1381,281,1385,283,1386,285,1387,292,1389,294,1392,301,1395,306,1396,310,1397,314,1400,318,1401,322,1404,324,1405,330,1406,334,1407,338,1408,340,1409,343,1410,345,1411,349,1419,356,1446,359,1447,362,1449,365,1450,370,1451,378,1454,383,1456,388,1466,390,1461,392,1462,396,1464,398,1465,404,1470,406,1471,408,1473,413,1475,415,1476,420,1478,425,1480,430,1482,434,1490,442,1493,446,1494,451,1495,453,1496,456,1497,458,1498,462,1499,464,1500,469,1501,471,1502,473,1503,477,1504,481,1505,489,1508,494,1509,514,1511);
}
