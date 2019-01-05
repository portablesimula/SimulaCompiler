// JavaLine 1 ==> SourceLine 1378
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:41:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$attrfile$fetchquant extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=1378, lastLine=1561, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 14 ==> SourceLine 1438
    final LABQNT$ SETID=new LABQNT$(this,0,1); // Local Label #1=SETID
    // JavaLine 16 ==> SourceLine 1442
    final LABQNT$ SETDID=new LABQNT$(this,0,2); // Local Label #2=SETDID
    // JavaLine 18 ==> SourceLine 1444
    final LABQNT$ CHCKMARK=new LABQNT$(this,0,3); // Local Label #3=CHCKMARK
    // JavaLine 20 ==> SourceLine 1478
    final LABQNT$ GETARR=new LABQNT$(this,0,4); // Local Label #4=GETARR
    // JavaLine 22 ==> SourceLine 1491
    final LABQNT$ xyMark=new LABQNT$(this,0,5); // Local Label #5=xyMark
    // JavaLine 24 ==> SourceLine 1561
    final LABQNT$ NOMORE=new LABQNT$(this,0,6); // Local Label #6=NOMORE
    // Declare locals as attributes
    // JavaLine 27 ==> SourceLine 1379
    boolean seen=false;
    // JavaLine 29 ==> SourceLine 1381
    char nxtc=0;
    // JavaLine 31 ==> SourceLine 1382
    char t0=0;
    char tn=0;
    // JavaLine 34 ==> SourceLine 1383
    COMMON$idpack cvis=null;
    // JavaLine 36 ==> SourceLine 1384
    TXT$ t=null;
    // Normal Constructor
    public COMMON$attrfile$fetchquant(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("fetchquant",1384);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public COMMON$attrfile$fetchquant STM$() {
        TRACE_BEGIN_STM$("fetchquant",1384);
        COMMON$attrfile$fetchquant THIS$=(COMMON$attrfile$fetchquant)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 54 ==> SourceLine 1388
                RESULT$=((COMMON$attrfile)(CUR$.SL$)).xthisused=((COMMON$attrfile)(CUR$.SL$)).xhascode=false;
                // JavaLine 56 ==> SourceLine 1389
                ((COMMON$attrfile)(CUR$.SL$)).xftag=((COMMON$attrfile)(CUR$.SL$)).xdim=((COMMON$attrfile)(CUR$.SL$)).xlanguage=((COMMON$attrfile)(CUR$.SL$)).xextident=0;
                // JavaLine 58 ==> SourceLine 1390
                ((COMMON$attrfile)(CUR$.SL$)).xprotect=((COMMON$attrfile)(CUR$.SL$)).xspecial=((COMMON$attrfile)(CUR$.SL$)).xconnests=((COMMON$attrfile)(CUR$.SL$)).xarrhi=((COMMON$attrfile)(CUR$.SL$)).xarrlo=((COMMON$attrfile)(CUR$.SL$)).xcheckhi=((COMMON$attrfile)(CUR$.SL$)).xchecklo=((COMMON$attrfile)(CUR$.SL$)).xmodulhi=((COMMON$attrfile)(CUR$.SL$)).xmodullo=((COMMON$attrfile)(CUR$.SL$)).xprefqhi=((COMMON$attrfile)(CUR$.SL$)).xprefqlo=((COMMON$attrfile)(CUR$.SL$)).xinrtag=((COMMON$attrfile)(CUR$.SL$)).xlongindic=((COMMON)(CUR$.SL$.SL$)).NUL;
                // JavaLine 60 ==> SourceLine 1395
                ((COMMON$attrfile)(CUR$.SL$)).xhidlist=null;
                // JavaLine 62 ==> SourceLine 1398
                ((COMMON$attrfile)(CUR$.SL$)).xcateg=((COMMON$attrfile)(CUR$.SL$)).key;
                // JavaLine 64 ==> SourceLine 1399
                if((((COMMON$attrfile)(CUR$.SL$)).xcateg>=(((char)8)))) {
                    // JavaLine 66 ==> SourceLine 1400
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1400",1400);
                        ((COMMON$attrfile)(CUR$.SL$)).xkind=char$((rank(((COMMON$attrfile)(CUR$.SL$)).key)/(8)));
                        // JavaLine 70 ==> SourceLine 1401
                        ((COMMON$attrfile)(CUR$.SL$)).xcateg=char$(mod(rank(((COMMON$attrfile)(CUR$.SL$)).key),8));
                        TRACE_END_STM$("CompoundStatement1400",1401);
                    }
                } else
                // JavaLine 75 ==> SourceLine 1402
                ((COMMON$attrfile)(CUR$.SL$)).xkind=((COMMON)(CUR$.SL$.SL$)).NUL;
                // JavaLine 77 ==> SourceLine 1404
                ((COMMON$attrfile)(CUR$.SL$)).xtype=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                // JavaLine 80 ==> SourceLine 1405
                if((((COMMON$attrfile)(CUR$.SL$)).xtype>=(((char)128)))) {
                    // JavaLine 82 ==> SourceLine 1406
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1406",1406);
                        ((COMMON$attrfile)(CUR$.SL$)).xtype=char$((rank(((COMMON$attrfile)(CUR$.SL$)).xtype)-(128)));
                        // JavaLine 86 ==> SourceLine 1407
                        ((COMMON$attrfile)(CUR$.SL$)).key=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                        // JavaLine 88 ==> SourceLine 1408
                        ((COMMON)(CUR$.SL$.SL$)).simsymbol=TXT$.sub(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,(((COMMON$attrfile)(CUR$.SL$)).p+(2)),rank(((COMMON$attrfile)(CUR$.SL$)).key));
                        new COMMON$DEFIDENT(((COMMON)(CUR$.SL$.SL$)));
                        // JavaLine 91 ==> SourceLine 1409
                        ((COMMON$attrfile)(CUR$.SL$)).p=((((COMMON$attrfile)(CUR$.SL$)).p+(1))+(rank(((COMMON$attrfile)(CUR$.SL$)).key)));
                        // JavaLine 93 ==> SourceLine 1410
                        ((COMMON$attrfile)(CUR$.SL$)).xprefqhi=((COMMON)(CUR$.SL$.SL$)).hashhi;
                        ((COMMON$attrfile)(CUR$.SL$)).xprefqlo=((COMMON)(CUR$.SL$.SL$)).hashlo;
                        TRACE_END_STM$("CompoundStatement1406",1410);
                    }
                }
                // JavaLine 99 ==> SourceLine 1413
                ((COMMON$attrfile)(CUR$.SL$)).xclf=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                // JavaLine 102 ==> SourceLine 1415
                if((((COMMON$attrfile)(CUR$.SL$)).xclf>=(((char)128)))) {
                    // JavaLine 104 ==> SourceLine 1417
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1417",1417);
                        RESULT$=true;
                        // JavaLine 108 ==> SourceLine 1418
                        ((COMMON$attrfile)(CUR$.SL$)).xclf=char$((rank(((COMMON$attrfile)(CUR$.SL$)).xclf)-(128)));
                        // JavaLine 110 ==> SourceLine 1419
                        if(((COMMON$attrfile)(CUR$.SL$)).sysattrfile) {
                        } else
                        // JavaLine 113 ==> SourceLine 1420
                        ((COMMON$attrfile)(CUR$.SL$)).xftag=(new COMMON$attrfile$nextNumber(((COMMON$attrfile)(CUR$.SL$))).RESULT$-(1));
                        // JavaLine 115 ==> SourceLine 1421
                        GOTO$(SETDID); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement1417",1421);
                    }
                }
                // JavaLine 120 ==> SourceLine 1424
                ((COMMON$attrfile)(CUR$.SL$)).xftag=(new COMMON$attrfile$nextNumber(((COMMON$attrfile)(CUR$.SL$))).RESULT$-(1));
                // JavaLine 122 ==> SourceLine 1426
                ((COMMON$attrfile)(CUR$.SL$)).key=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                // JavaLine 125 ==> SourceLine 1427
                if((((COMMON$attrfile)(CUR$.SL$)).key!=(((COMMON)(CUR$.SL$.SL$)).NUL))) {
                    // JavaLine 127 ==> SourceLine 1428
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1428",1428);
                        ((COMMON)(CUR$.SL$.SL$)).simsymbol=((COMMON$attrfile)(CUR$.SL$)).xidentstring=TXT$.sub(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,(((COMMON$attrfile)(CUR$.SL$)).p+(1)),rank(((COMMON$attrfile)(CUR$.SL$)).key));
                        // JavaLine 131 ==> SourceLine 1429
                        ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(rank(((COMMON$attrfile)(CUR$.SL$)).key)));
                        // JavaLine 133 ==> SourceLine 1430
                        if((((COMMON$attrfile)(CUR$.SL$)).xkind==(((COMMON)(CUR$.SL$.SL$)).K_class))) {
                            // JavaLine 135 ==> SourceLine 1431
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1431",1431);
                                if(((((COMMON$attrfile)(CUR$.SL$)).xclf==(((COMMON)(CUR$.SL$.SL$)).Clf004))|((((COMMON$attrfile)(CUR$.SL$)).xclf==(((COMMON)(CUR$.SL$.SL$)).Clf009))))) {
                                    ((COMMON$attrfile)(CUR$.SL$)).xhascode=true;
                                }
                                // JavaLine 141 ==> SourceLine 1434
                                new COMMON$DEFIDENT(((COMMON)(CUR$.SL$.SL$)));
                                GOTO$(SETID); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1431",1434);
                            }
                        }
                        // JavaLine 147 ==> SourceLine 1435
                        if(new COMMON$LOOKUPid(((COMMON)(CUR$.SL$.SL$))).RESULT$) {
                            // JavaLine 149 ==> SourceLine 1438
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1438",1438);
                                LABEL$(1); // SETID
                                RESULT$=true;
                                ((COMMON$attrfile)(CUR$.SL$)).xident=new COMMON$boxof(((COMMON)(CUR$.SL$.SL$)),((COMMON)(CUR$.SL$.SL$)).hashhi,((COMMON)(CUR$.SL$.SL$)).hashlo).RESULT$;
                                TRACE_END_STM$("CompoundStatement1438",1438);
                            }
                        } else
                        // JavaLine 158 ==> SourceLine 1440
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1440",1440);
                            ((COMMON$attrfile)(CUR$.SL$)).xident=null;
                            TRACE_END_STM$("CompoundStatement1440",1440);
                        }
                        TRACE_END_STM$("CompoundStatement1428",1440);
                    }
                } else
                // JavaLine 167 ==> SourceLine 1442
                LABEL$(2); // SETDID
                ((COMMON$attrfile)(CUR$.SL$)).xident=((COMMON)(CUR$.SL$.SL$)).dummyBox;
                // JavaLine 170 ==> SourceLine 1444
                LABEL$(3); // CHCKMARK
                ((COMMON$attrfile)(CUR$.SL$)).key=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                // JavaLine 174 ==> SourceLine 1445
                if((((COMMON$attrfile)(CUR$.SL$)).key>=(((COMMON$attrfile)(CUR$.SL$)).lowKey))) {
                    // JavaLine 176 ==> SourceLine 1446
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1446",1446);
                        switch(((COMMON$attrfile)(CUR$.SL$)).key) { // BEGIN SWITCH STATEMENT
                        case 241: 
                        // JavaLine 181 ==> SourceLine 1449
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1449",1449);
                            RESULT$=true;
                            // JavaLine 185 ==> SourceLine 1450
                            GOTO$(CHCKMARK); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1449",1450);
                        }
                        case 249: 
                        // JavaLine 190 ==> SourceLine 1454
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1454",1454);
                            ((COMMON$attrfile)(CUR$.SL$)).xprotect=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                            ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                            // JavaLine 195 ==> SourceLine 1455
                            GOTO$(CHCKMARK); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1454",1455);
                        }
                        case 242: 
                        // JavaLine 200 ==> SourceLine 1459
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1459",1459);
                            ((COMMON$attrfile)(CUR$.SL$)).xdim=rank(loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p));
                            ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                            // JavaLine 205 ==> SourceLine 1460
                            GOTO$(CHCKMARK); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1459",1460);
                        }
                        case 243: 
                        // JavaLine 210 ==> SourceLine 1464
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1464",1464);
                            ((COMMON$attrfile)(CUR$.SL$)).xlongindic=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                            ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                            // JavaLine 215 ==> SourceLine 1465
                            GOTO$(CHCKMARK); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1464",1465);
                        }
                        case 244: 
                        // JavaLine 220 ==> SourceLine 1469
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1469",1469);
                            if((((COMMON$attrfile)(CUR$.SL$)).xkind==(((COMMON)(CUR$.SL$.SL$)).K_rep))) {
                                // JavaLine 224 ==> SourceLine 1470
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1470",1470);
                                    ((COMMON$attrfile)(CUR$.SL$)).xlanguage=new COMMON$attrfile$nextNumber(((COMMON$attrfile)(CUR$.SL$))).RESULT$;
                                    ((COMMON$attrfile)(CUR$.SL$)).xextident=new COMMON$attrfile$nextNumber(((COMMON$attrfile)(CUR$.SL$))).RESULT$;
                                    // JavaLine 229 ==> SourceLine 1471
                                    GOTO$(CHCKMARK); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1470",1471);
                                }
                            }
                            // JavaLine 234 ==> SourceLine 1473
                            ((COMMON$attrfile)(CUR$.SL$)).xspecial=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                            ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                            // JavaLine 237 ==> SourceLine 1474
                            if((((COMMON$attrfile)(CUR$.SL$)).xspecial>(((char)128)))) {
                                // JavaLine 239 ==> SourceLine 1475
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1475",1475);
                                    ((COMMON$attrfile)(CUR$.SL$)).xspecial=char$((rank(((COMMON$attrfile)(CUR$.SL$)).xspecial)-(128)));
                                    // JavaLine 243 ==> SourceLine 1476
                                    ((COMMON$attrfile)(CUR$.SL$)).xarrlo=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                                    ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                                    TRACE_END_STM$("CompoundStatement1475",1476);
                                }
                            } else
                            // JavaLine 249 ==> SourceLine 1478
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1478",1478);
                                LABEL$(4); // GETARR
                                new COMMON$attrfile$gettext(((COMMON$attrfile)(CUR$.SL$)));
                                new COMMON$DEFCONST(((COMMON)(CUR$.SL$.SL$)));
                                // JavaLine 255 ==> SourceLine 1479
                                ((COMMON$attrfile)(CUR$.SL$)).xarrhi=((COMMON)(CUR$.SL$.SL$)).hashhi;
                                ((COMMON$attrfile)(CUR$.SL$)).xarrlo=((COMMON)(CUR$.SL$.SL$)).hashlo;
                                TRACE_END_STM$("CompoundStatement1478",1479);
                            }
                            // JavaLine 260 ==> SourceLine 1480
                            GOTO$(CHCKMARK); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1469",1480);
                        }
                        case 246: 
                        // JavaLine 265 ==> SourceLine 1485
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1485",1485);
                            new COMMON$attrfile$gettext(((COMMON$attrfile)(CUR$.SL$)));
                            new COMMON$DEFCONST(((COMMON)(CUR$.SL$.SL$)));
                            // JavaLine 270 ==> SourceLine 1486
                            ((COMMON$attrfile)(CUR$.SL$)).xmodulhi=((COMMON)(CUR$.SL$.SL$)).hashhi;
                            ((COMMON$attrfile)(CUR$.SL$)).xmodullo=((COMMON)(CUR$.SL$.SL$)).hashlo;
                            // JavaLine 273 ==> SourceLine 1488
                            new COMMON$attrfile$gettext(((COMMON$attrfile)(CUR$.SL$)));
                            new COMMON$DEFCONST(((COMMON)(CUR$.SL$.SL$)));
                            // JavaLine 276 ==> SourceLine 1489
                            ((COMMON$attrfile)(CUR$.SL$)).xcheckhi=((COMMON)(CUR$.SL$.SL$)).hashhi;
                            ((COMMON$attrfile)(CUR$.SL$)).xchecklo=((COMMON)(CUR$.SL$.SL$)).hashlo;
                            // JavaLine 279 ==> SourceLine 1491
                            LABEL$(5); // xyMark
                            new COMMON$attrfile$gettext(((COMMON$attrfile)(CUR$.SL$)));
                            new COMMON$DEFIDENT(((COMMON)(CUR$.SL$.SL$)));
                            // JavaLine 283 ==> SourceLine 1492
                            ((COMMON$attrfile)(CUR$.SL$)).xlanguage=((rank(((COMMON)(CUR$.SL$.SL$)).hashhi)*(256))+(rank(((COMMON)(CUR$.SL$.SL$)).hashlo)));
                            // JavaLine 285 ==> SourceLine 1494
                            new COMMON$attrfile$gettext(((COMMON$attrfile)(CUR$.SL$)));
                            new COMMON$DEFCONST(((COMMON)(CUR$.SL$.SL$)));
                            // JavaLine 288 ==> SourceLine 1495
                            ((COMMON$attrfile)(CUR$.SL$)).xextident=((rank(((COMMON)(CUR$.SL$.SL$)).hashhi)*(256))+(rank(((COMMON)(CUR$.SL$.SL$)).hashlo)));
                            // JavaLine 290 ==> SourceLine 1496
                            GOTO$(CHCKMARK); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1485",1496);
                        }
                        case 245: 
                        // JavaLine 295 ==> SourceLine 1500
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1500",1500);
                            GOTO$(xyMark); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1500",1500);
                        }
                        case 247: 
                        // JavaLine 302 ==> SourceLine 1504
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1504",1504);
                            ((COMMON$attrfile)(CUR$.SL$)).xconnests=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                            ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                            // JavaLine 307 ==> SourceLine 1505
                            GOTO$(CHCKMARK); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1504",1505);
                        }
                        case 240: 
                        // JavaLine 312 ==> SourceLine 1509
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1509",1509);
                            nxtc=loadChar(((COMMON$attrfile)(CUR$.SL$)).attrbuffer,((COMMON$attrfile)(CUR$.SL$)).p);
                            ((COMMON$attrfile)(CUR$.SL$)).p=(((COMMON$attrfile)(CUR$.SL$)).p+(1));
                            // JavaLine 317 ==> SourceLine 1510
                            if((nxtc>=('@'))) {
                                // JavaLine 319 ==> SourceLine 1511
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1511",1511);
                                    ((COMMON$attrfile)(CUR$.SL$)).xthisused=true;
                                    nxtc=char$((rank(nxtc)-(64)));
                                    TRACE_END_STM$("CompoundStatement1511",1511);
                                }
                            }
                            // JavaLine 327 ==> SourceLine 1512
                            if((nxtc>=(((char)32)))) {
                                // JavaLine 329 ==> SourceLine 1513
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1513",1513);
                                    ((COMMON$attrfile)(CUR$.SL$)).xhascode=true;
                                    nxtc=char$((rank(nxtc)-(32)));
                                    TRACE_END_STM$("CompoundStatement1513",1513);
                                }
                            }
                            // JavaLine 337 ==> SourceLine 1515
                            ((COMMON$attrfile)(CUR$.SL$)).xinrtag=nxtc;
                            // JavaLine 339 ==> SourceLine 1516
                            GOTO$(CHCKMARK); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1509",1516);
                        }
                        case 254: 
                        // JavaLine 344 ==> SourceLine 1520
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1520",1520);
                            new COMMON$attrfile$swapIbuffer(((COMMON$attrfile)(CUR$.SL$)));
                            GOTO$(CHCKMARK); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1520",1520);
                        }
                        case 248: 
                        // JavaLine 352 ==> SourceLine 1524
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1524",1524);
                            cvis=((COMMON$attrfile)(CUR$.SL$)).xhidlist=new COMMON$idpack(((COMMON)(CUR$.SL$.SL$))).STM$();
                            // JavaLine 356 ==> SourceLine 1525
                            while((((COMMON$attrfile)(CUR$.SL$)).key==(((COMMON$attrfile)(CUR$.SL$)).hidMark))) {
                                // JavaLine 358 ==> SourceLine 1526
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1526",1526);
                                    cvis=cvis.next=new COMMON$idpack(((COMMON)(CUR$.SL$.SL$))).STM$();
                                    // JavaLine 362 ==> SourceLine 1527
                                    new COMMON$attrfile$gettext(((COMMON$attrfile)(CUR$.SL$)));
                                    new COMMON$DEFIDENT(((COMMON)(CUR$.SL$.SL$)));
                                    // JavaLine 365 ==> SourceLine 1528
                                    cvis.idhi=((COMMON)(CUR$.SL$.SL$)).hashhi;
                                    cvis.idlo=((COMMON)(CUR$.SL$.SL$)).hashlo;
                                    // JavaLine 368 ==> SourceLine 1529
                                    cvis.line=1;
                                    // JavaLine 370 ==> SourceLine 1530
                                    new COMMON$attrfile$nextKey(((COMMON$attrfile)(CUR$.SL$)));
                                    TRACE_END_STM$("CompoundStatement1526",1530);
                                }
                            }
                            // JavaLine 375 ==> SourceLine 1532
                            ((COMMON$attrfile)(CUR$.SL$)).xhidlist=((COMMON$attrfile)(CUR$.SL$)).xhidlist.next;
                            TRACE_END_STM$("CompoundStatement1524",1532);
                        }
                        default:
                    } // END SWITCH STATEMENT
                    TRACE_END_STM$("CompoundStatement1446",1532);
                }
            }
            // JavaLine 384 ==> SourceLine 1561
            LABEL$(6); // NOMORE
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
    TRACE_END_STM$("fetchquant",1561);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure fetchquant",1,1378,14,1438,16,1442,18,1444,20,1478,22,1491,24,1561,27,1379,29,1381,31,1382,34,1383,36,1384,54,1388,56,1389,58,1390,60,1395,62,1398,64,1399,66,1400,70,1401,75,1402,77,1404,80,1405,82,1406,86,1407,88,1408,91,1409,93,1410,99,1413,102,1415,104,1417,108,1418,110,1419,113,1420,115,1421,120,1424,122,1426,125,1427,127,1428,131,1429,133,1430,135,1431,141,1434,147,1435,149,1438,158,1440,167,1442,170,1444,174,1445,176,1446,181,1449,185,1450,190,1454,195,1455,200,1459,205,1460,210,1464,215,1465,220,1469,224,1470,229,1471,234,1473,237,1474,239,1475,243,1476,249,1478,255,1479,260,1480,265,1485,270,1486,273,1488,276,1489,279,1491,283,1492,285,1494,288,1495,290,1496,295,1500,302,1504,307,1505,312,1509,317,1510,319,1511,327,1512,329,1513,337,1515,339,1516,344,1520,352,1524,356,1525,358,1526,362,1527,365,1528,368,1529,370,1530,375,1532,384,1561,402,1561);
}
