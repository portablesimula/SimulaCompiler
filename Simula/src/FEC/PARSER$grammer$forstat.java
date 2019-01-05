// JavaLine 1 ==> SourceLine 1434
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PARSER$grammer$forstat extends PARSER$grammer$statement {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=1434, lastLine=1698, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 1514
    final LABQNT$ REUSE=new LABQNT$(this,1,1); // Local Label #1=REUSE
    // JavaLine 14 ==> SourceLine 1621
    final LABQNT$ exprErr=new LABQNT$(this,1,2); // Local Label #2=exprErr
    // JavaLine 16 ==> SourceLine 1665
    final LABQNT$ PARSE=new LABQNT$(this,1,3); // Local Label #3=PARSE
    // JavaLine 18 ==> SourceLine 1517
    final LABQNT$ S0=new LABQNT$(this,1,4); // Local Label #4=S0
    // JavaLine 20 ==> SourceLine 1532
    final LABQNT$ forelem=new LABQNT$(this,1,5); // Local Label #5=forelem
    // JavaLine 22 ==> SourceLine 1674
    final LABQNT$ S1=new LABQNT$(this,1,6); // Local Label #6=S1
    // Declare locals as attributes
    // JavaLine 25 ==> SourceLine 1435
    public boolean enclgen=false;
    // JavaLine 27 ==> SourceLine 1436
    public boolean commaSeen=false;
    // JavaLine 29 ==> SourceLine 1437
    public char ftype=0;
    // JavaLine 31 ==> SourceLine 1438
    public char forass=0;
    // JavaLine 33 ==> SourceLine 1439
    public int oldUniq=0;
    // JavaLine 35 ==> SourceLine 1440
    public PARSER$codebuffer forcoder=null;
    // JavaLine 37 ==> SourceLine 1514
    public PARSER$codebuffer inspect$1514$40=null;
    // JavaLine 39 ==> SourceLine 1551
    public PARSER$codebuffer$elt inspect$1551$41=null;
    // JavaLine 41 ==> SourceLine 1570
    public PARSER$codebuffer$elt inspect$1570$42=null;
    // JavaLine 43 ==> SourceLine 1594
    public PARSER$codebuffer$elt inspect$1594$43=null;
    // JavaLine 45 ==> SourceLine 1645
    public PARSER$codebuffer$elt inspect$1645$44=null;
    public PRCQNT$ recover$0() { return(new PRCQNT$(this,PARSER$grammer$forstat$recover.class)); }
    // Normal Constructor
    public PARSER$grammer$forstat(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("forstat",1645);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("forstat",1645,inner);
                PARSER$grammer$forstat THIS$=(PARSER$grammer$forstat)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 62 ==> SourceLine 1508
                        detach();
                        // JavaLine 64 ==> SourceLine 1509
                        forcoder=new PARSER$codebuffer(((PARSER)(CUR$.SL$.SL$)),new TXT$("$for$")).STM$();
                        // JavaLine 66 ==> SourceLine 1684
                        LABEL$(1); // REUSE
                        // JavaLine 68 ==> SourceLine 1514
                        {
                            // BEGIN INSPECTION 
                            inspect$1514$40=forcoder;
                            if(inspect$1514$40!=null) //INSPECT inspect$1514$40
                            // JavaLine 73 ==> SourceLine 1517
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1517",1517);
                                LABEL$(4); // S0
                                caller.stmttype=((PARSER$grammer)(CUR$.SL$)).openstmt;
                                // JavaLine 78 ==> SourceLine 1518
                                ((PARSER$grammer)(CUR$.SL$)).detach();
                                // JavaLine 80 ==> SourceLine 1519
                                if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IIDN))) {
                                    // JavaLine 82 ==> SourceLine 1521
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1521",1521);
                                        errorno=185;
                                        GOTO$(PARSE); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1521",1521);
                                    }
                                }
                                // JavaLine 90 ==> SourceLine 1522
                                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IFOR;
                                call(forcoder);
                                // JavaLine 93 ==> SourceLine 1523
                                inspect$1514$40.wheeler=inspect$1514$40.curelt;
                                // JavaLine 95 ==> SourceLine 1524
                                if(((((PARSER)(CUR$.SL$.SL$)).opt!=(((PARSER)(CUR$.SL$.SL$)).IASSG))&&((((PARSER)(CUR$.SL$.SL$)).opt!=(((PARSER)(CUR$.SL$.SL$)).IDENO))))) {
                                    // JavaLine 97 ==> SourceLine 1525
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1525",1525);
                                        ((PARSER$grammer)(CUR$.SL$)).getopt=false;
                                        ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).opt;
                                        // JavaLine 102 ==> SourceLine 1527
                                        errorno=209;
                                        GOTO$(PARSE); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1525",1527);
                                    }
                                }
                                // JavaLine 108 ==> SourceLine 1528
                                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IIDN;
                                call(forcoder);
                                inspect$1514$40.cvar=inspect$1514$40.curelt;
                                // JavaLine 112 ==> SourceLine 1529
                                forass=((PARSER)(CUR$.SL$.SL$)).opt;
                                // JavaLine 114 ==> SourceLine 1530
                                ((PARSER$grammer)(CUR$.SL$)).detach();
                                // JavaLine 116 ==> SourceLine 1532
                                LABEL$(5); // forelem
                                new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),forass);
                                // JavaLine 119 ==> SourceLine 1533
                                call(((PARSER$grammer)(CUR$.SL$)).ex);
                                // JavaLine 121 ==> SourceLine 1534
                                new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).IASGE);
                                // JavaLine 123 ==> SourceLine 1535
                                if(((PARSER$grammer)(CUR$.SL$)).ex.wasNotexpr) {
                                    // JavaLine 125 ==> SourceLine 1537
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1537",1537);
                                        errorno=205;
                                        GOTO$(PARSE); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1537",1537);
                                    }
                                }
                                // JavaLine 133 ==> SourceLine 1538
                                if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ISTEP))) {
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1538",1538);
                                        ftype=((char)1);
                                        // JavaLine 138 ==> SourceLine 1539
                                        inspect$1514$40.forvar=inspect$1514$40.curelt;
                                        // JavaLine 140 ==> SourceLine 1540
                                        new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).ITRUE);
                                        new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).IIFSB);
                                        inspect$1514$40.stepexpr=inspect$1514$40.curelt;
                                        // JavaLine 144 ==> SourceLine 1542
                                        ((PARSER$grammer)(CUR$.SL$)).detach();
                                        // JavaLine 146 ==> SourceLine 1543
                                        call(((PARSER$grammer)(CUR$.SL$)).ex);
                                        // JavaLine 148 ==> SourceLine 1544
                                        if(((PARSER$grammer)(CUR$.SL$)).ex.wasNotexpr) {
                                            // JavaLine 150 ==> SourceLine 1546
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1546",1546);
                                                GOTO$(exprErr); // GOTO EVALUATED LABEL
                                                TRACE_END_STM$("CompoundStatement1546",1546);
                                            }
                                        }
                                        // JavaLine 157 ==> SourceLine 1547
                                        if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IUNTI))) {
                                            // JavaLine 159 ==> SourceLine 1549
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1549",1549);
                                                errorno=210;
                                                GOTO$(PARSE); // GOTO EVALUATED LABEL
                                                TRACE_END_STM$("CompoundStatement1549",1549);
                                            }
                                        }
                                        // JavaLine 167 ==> SourceLine 1551
                                        {
                                            // BEGIN INSPECTION 
                                            inspect$1551$41=inspect$1514$40.stepexpr.next;
                                            if(inspect$1551$41!=null) //INSPECT inspect$1551$41
                                            // JavaLine 172 ==> SourceLine 1552
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1552",1552);
                                                if(((inspect$1514$40.curelt!=(((PARSER$codebuffer$elt)inspect$1551$41)))||(((inspect$1551$41.opnn!=(((PARSER)(CUR$.SL$.SL$)).ISCST))&&((inspect$1551$41.opnn!=(((PARSER)(CUR$.SL$.SL$)).ICONS))))))) {
                                                    // JavaLine 176 ==> SourceLine 1555
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement1555",1555);
                                                        ftype=((char)4);
                                                        inspect$1514$40.curelt=inspect$1514$40.stepexpr;
                                                        inspect$1514$40.curelt.next=null;
                                                        TRACE_END_STM$("CompoundStatement1555",1555);
                                                    }
                                                } else
                                                // JavaLine 185 ==> SourceLine 1556
                                                inspect$1514$40.curelt=inspect$1514$40.stepexpr;
                                                // JavaLine 187 ==> SourceLine 1557
                                                inspect$1514$40.stepexpr=((PARSER$codebuffer$elt)inspect$1551$41);
                                                TRACE_END_STM$("CompoundStatement1552",1557);
                                            }
                                        }
                                        // JavaLine 192 ==> SourceLine 1559
                                        if((ftype==(((char)4)))) {
                                            // JavaLine 194 ==> SourceLine 1560
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1560",1560);
                                                if((inspect$1514$40.deltavar==(null))) {
                                                    // JavaLine 198 ==> SourceLine 1561
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement1561",1561);
                                                        if((((PARSER$grammer)(CUR$.SL$)).blockfound==(0))) {
                                                            // JavaLine 202 ==> SourceLine 1562
                                                            {
                                                                TRACE_BEGIN_STM$("CompoundStatement1562",1562);
                                                                inspect$1514$40.curelt=inspect$1514$40.firstelt;
                                                                // JavaLine 206 ==> SourceLine 1563
                                                                new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).IBLKB);
                                                                new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).IDCLE);
                                                                // JavaLine 209 ==> SourceLine 1564
                                                                ((PARSER$grammer)(CUR$.SL$)).blockfound=1;
                                                                enclgen=true;
                                                                TRACE_END_STM$("CompoundStatement1562",1564);
                                                            }
                                                        }
                                                        // JavaLine 215 ==> SourceLine 1566
                                                        inspect$1514$40.curelt=inspect$1514$40.firstelt.next;
                                                        // JavaLine 217 ==> SourceLine 1567
                                                        ((PARSER)(CUR$.SL$.SL$)).simsymbol=new COMMON$leftint(((PARSER)(CUR$.SL$.SL$)),((PARSER$grammer)(CUR$.SL$)).uniqueindex).RESULT$;
                                                        // JavaLine 219 ==> SourceLine 1568
                                                        ((PARSER)(CUR$.SL$.SL$)).simsymbol=CONC(new TXT$("$int"),((PARSER)(CUR$.SL$.SL$)).simsymbol);
                                                        new COMMON$DEFIDENT(((PARSER)(CUR$.SL$.SL$)));
                                                        // JavaLine 222 ==> SourceLine 1569
                                                        ((PARSER$grammer)(CUR$.SL$)).uniqueindex=(((PARSER$grammer)(CUR$.SL$)).uniqueindex+(1));
                                                        // JavaLine 224 ==> SourceLine 1570
                                                        {
                                                            // BEGIN INSPECTION 
                                                            inspect$1570$42=new PARSER$codebuffer$elt(inspect$1514$40).STM$();
                                                            if(inspect$1570$42!=null) //INSPECT inspect$1570$42
                                                            // JavaLine 229 ==> SourceLine 1571
                                                            {
                                                                TRACE_BEGIN_STM$("CompoundStatement1571",1571);
                                                                inspect$1514$40.deltavar=((PARSER$codebuffer$elt)inspect$1570$42);
                                                                // JavaLine 233 ==> SourceLine 1572
                                                                inspect$1570$42.opdhii=((PARSER)(CUR$.SL$.SL$)).hashhi;
                                                                inspect$1570$42.opdloo=((PARSER)(CUR$.SL$.SL$)).hashlo;
                                                                // JavaLine 236 ==> SourceLine 1573
                                                                inspect$1570$42.opnn=((PARSER)(CUR$.SL$.SL$)).IWHIL;
                                                                inspect$1570$42.optxx=((PARSER)(CUR$.SL$.SL$)).IINTG;
                                                                TRACE_END_STM$("CompoundStatement1571",1573);
                                                            }
                                                        }
                                                        // JavaLine 242 ==> SourceLine 1575
                                                        new PARSER$codebuffer$elt$emit(inspect$1514$40.deltavar);
                                                        // JavaLine 244 ==> SourceLine 1576
                                                        inspect$1514$40.deltavar.opnn=((PARSER)(CUR$.SL$.SL$)).IIDN;
                                                        // JavaLine 246 ==> SourceLine 1577
                                                        ASGSTR$(TXT$.sub(((PARSER)(CUR$.SL$.SL$)).simsymbol,2,3),"lrl");
                                                        new COMMON$DEFIDENT(((PARSER)(CUR$.SL$.SL$)));
                                                        // JavaLine 249 ==> SourceLine 1578
                                                        ((PARSER)(CUR$.SL$.SL$)).opdhi=((PARSER)(CUR$.SL$.SL$)).hashhi;
                                                        ((PARSER)(CUR$.SL$.SL$)).opdlo=((PARSER)(CUR$.SL$.SL$)).hashlo;
                                                        // JavaLine 252 ==> SourceLine 1579
                                                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IWHIL;
                                                        ((PARSER)(CUR$.SL$.SL$)).optx=((PARSER)(CUR$.SL$.SL$)).ILONG;
                                                        call(forcoder);
                                                        TRACE_END_STM$("CompoundStatement1561",1579);
                                                    }
                                                }
                                                // JavaLine 259 ==> SourceLine 1581
                                                inspect$1514$40.curelt=inspect$1514$40.forvar;
                                                // JavaLine 261 ==> SourceLine 1582
                                                new PARSER$codebuffer$elt$emit(inspect$1514$40.deltavar);
                                                // JavaLine 263 ==> SourceLine 1583
                                                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IASSG;
                                                call(forcoder);
                                                // JavaLine 266 ==> SourceLine 1584
                                                new PARSER$codebuffer$copyexpr(inspect$1514$40,inspect$1514$40.stepexpr);
                                                // JavaLine 268 ==> SourceLine 1586
                                                new PARSER$codebuffer$elt$emit(inspect$1514$40.deltavar);
                                                inspect$1514$40.curelt.opnn=((PARSER)(CUR$.SL$.SL$)).ISTEP;
                                                // JavaLine 271 ==> SourceLine 1587
                                                inspect$1514$40.curelt=inspect$1514$40.curelt.next.next;
                                                // JavaLine 273 ==> SourceLine 1588
                                                new PARSER$codebuffer$elt$emit(inspect$1514$40.deltavar);
                                                // JavaLine 275 ==> SourceLine 1589
                                                new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).IMULT);
                                                new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).ILFPA);
                                                // JavaLine 278 ==> SourceLine 1590
                                                new PARSER$codebuffer$elt$emit(inspect$1514$40.cvar);
                                                // JavaLine 280 ==> SourceLine 1591
                                                new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).IMINU);
                                                new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).ILFPA);
                                                TRACE_END_STM$("CompoundStatement1560",1591);
                                            }
                                        } else
                                        // JavaLine 286 ==> SourceLine 1594
                                        {
                                            // BEGIN INSPECTION 
                                            inspect$1594$43=inspect$1514$40.stepexpr;
                                            if(inspect$1594$43!=null) //INSPECT inspect$1594$43
                                            // JavaLine 291 ==> SourceLine 1595
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1595",1595);
                                                new PARSER$codebuffer$elt$emit(inspect$1514$40.cvar);
                                                // JavaLine 295 ==> SourceLine 1597
                                                new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),(((loadChar(new COMMON$nameof(((PARSER)(CUR$.SL$.SL$)),inspect$1594$43.opdhii,inspect$1594$43.opdloo).RESULT$,0)==('-')))?(((PARSER)(CUR$.SL$.SL$)).IGE):(((PARSER)(CUR$.SL$.SL$)).ILE)));
                                                TRACE_END_STM$("CompoundStatement1595",1597);
                                            }
                                        }
                                        // JavaLine 300 ==> SourceLine 1599
                                        ((PARSER$grammer)(CUR$.SL$)).detach();
                                        // JavaLine 302 ==> SourceLine 1600
                                        call(((PARSER$grammer)(CUR$.SL$)).ex);
                                        // JavaLine 304 ==> SourceLine 1601
                                        if(((PARSER$grammer)(CUR$.SL$)).ex.wasNotexpr) {
                                            // JavaLine 306 ==> SourceLine 1603
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1603",1603);
                                                GOTO$(exprErr); // GOTO EVALUATED LABEL
                                                TRACE_END_STM$("CompoundStatement1603",1603);
                                            }
                                        }
                                        // JavaLine 313 ==> SourceLine 1604
                                        if((ftype==(((char)4)))) {
                                            // JavaLine 315 ==> SourceLine 1605
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1605",1605);
                                                new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).IRGPA);
                                                new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).IRGPA);
                                                // JavaLine 320 ==> SourceLine 1606
                                                new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).ILE);
                                                // JavaLine 322 ==> SourceLine 1607
                                                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).ISCST;
                                                ((PARSER)(CUR$.SL$.SL$)).opdhi=((PARSER)(CUR$.SL$.SL$)).zerohi;
                                                ((PARSER)(CUR$.SL$.SL$)).opdlo=((PARSER)(CUR$.SL$.SL$)).zerolo;
                                                ((PARSER)(CUR$.SL$.SL$)).optx=((PARSER)(CUR$.SL$.SL$)).IINTG;
                                                // JavaLine 327 ==> SourceLine 1608
                                                call(forcoder);
                                                TRACE_END_STM$("CompoundStatement1605",1608);
                                            }
                                        }
                                        // JavaLine 332 ==> SourceLine 1610
                                        new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).ITHSB);
                                        TRACE_END_STM$("CompoundStatement1538",1610);
                                    }
                                } else
                                // JavaLine 337 ==> SourceLine 1613
                                if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IWHIL))) {
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1613",1613);
                                        ftype=((char)2);
                                        // JavaLine 342 ==> SourceLine 1614
                                        new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).IIFSB);
                                        // JavaLine 344 ==> SourceLine 1615
                                        inspect$1514$40.forvar=inspect$1514$40.curelt;
                                        // JavaLine 346 ==> SourceLine 1616
                                        inspect$1514$40.curelt=inspect$1514$40.wheeler;
                                        new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).ITRUE);
                                        inspect$1514$40.curelt=inspect$1514$40.forvar;
                                        // JavaLine 350 ==> SourceLine 1617
                                        ((PARSER$grammer)(CUR$.SL$)).detach();
                                        // JavaLine 352 ==> SourceLine 1618
                                        call(((PARSER$grammer)(CUR$.SL$)).ex);
                                        // JavaLine 354 ==> SourceLine 1619
                                        if(((PARSER$grammer)(CUR$.SL$)).ex.wasNotexpr) {
                                            // JavaLine 356 ==> SourceLine 1621
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1621",1621);
                                                LABEL$(2); // exprErr
                                                errorno=205;
                                                GOTO$(PARSE); // GOTO EVALUATED LABEL
                                                TRACE_END_STM$("CompoundStatement1621",1621);
                                            }
                                        }
                                        // JavaLine 365 ==> SourceLine 1622
                                        new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).ITHSB);
                                        TRACE_END_STM$("CompoundStatement1613",1622);
                                    }
                                } else
                                // JavaLine 370 ==> SourceLine 1624
                                ftype=((char)3);
                                // JavaLine 372 ==> SourceLine 1625
                                if(((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ICOMA))||(commaSeen))) {
                                    // JavaLine 374 ==> SourceLine 1626
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1626",1626);
                                        if((!(commaSeen))) {
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1626",1626);
                                                commaSeen=true;
                                                // JavaLine 381 ==> SourceLine 1627
                                                inspect$1514$40.statlabel=inspect$1514$40.curelt;
                                                // JavaLine 383 ==> SourceLine 1628
                                                inspect$1514$40.curelt=inspect$1514$40.firstelt;
                                                // JavaLine 385 ==> SourceLine 1629
                                                if((((PARSER$grammer)(CUR$.SL$)).blockfound==(0))) {
                                                    // JavaLine 387 ==> SourceLine 1630
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement1630",1630);
                                                        new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).IBLKB);
                                                        new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).IDCLE);
                                                        // JavaLine 392 ==> SourceLine 1631
                                                        ((PARSER$grammer)(CUR$.SL$)).blockfound=1;
                                                        enclgen=true;
                                                        // JavaLine 395 ==> SourceLine 1632
                                                        inspect$1514$40.curelt=inspect$1514$40.firstelt.next;
                                                        TRACE_END_STM$("CompoundStatement1630",1632);
                                                    }
                                                } else
                                                // JavaLine 400 ==> SourceLine 1634
                                                while((inspect$1514$40.curelt.next.opnn!=(((enclgen)?(((PARSER)(CUR$.SL$.SL$)).IDCLE):(((PARSER)(CUR$.SL$.SL$)).IFOR))))) {
                                                    // JavaLine 402 ==> SourceLine 1637
                                                    inspect$1514$40.curelt=inspect$1514$40.curelt.next;
                                                }
                                                // JavaLine 405 ==> SourceLine 1638
                                                ((PARSER)(CUR$.SL$.SL$)).simsymbol=new COMMON$leftint(((PARSER)(CUR$.SL$.SL$)),((PARSER$grammer)(CUR$.SL$)).fornests).RESULT$;
                                                // JavaLine 407 ==> SourceLine 1639
                                                ((PARSER)(CUR$.SL$.SL$)).simsymbol=CONC(new TXT$("$for"),((PARSER)(CUR$.SL$.SL$)).simsymbol);
                                                new COMMON$DEFIDENT(((PARSER)(CUR$.SL$.SL$)));
                                                // JavaLine 410 ==> SourceLine 1640
                                                ((PARSER$grammer)(CUR$.SL$)).fornests=(((PARSER$grammer)(CUR$.SL$)).fornests+(1));
                                                // JavaLine 412 ==> SourceLine 1641
                                                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IWHIL;
                                                ((PARSER)(CUR$.SL$.SL$)).opdhi=((PARSER)(CUR$.SL$.SL$)).hashhi;
                                                ((PARSER)(CUR$.SL$.SL$)).opdlo=((PARSER)(CUR$.SL$.SL$)).hashlo;
                                                ((PARSER)(CUR$.SL$.SL$)).optx=((PARSER)(CUR$.SL$.SL$)).ILABE;
                                                // JavaLine 417 ==> SourceLine 1642
                                                call(forcoder);
                                                // JavaLine 419 ==> SourceLine 1643
                                                inspect$1514$40.curelt=inspect$1514$40.statlabel;
                                                // JavaLine 421 ==> SourceLine 1644
                                                ASGSTR$(TXT$.sub(((PARSER)(CUR$.SL$.SL$)).simsymbol,2,3),"stm");
                                                new COMMON$DEFIDENT(((PARSER)(CUR$.SL$.SL$)));
                                                // JavaLine 424 ==> SourceLine 1645
                                                {
                                                    // BEGIN INSPECTION 
                                                    inspect$1645$44=new PARSER$codebuffer$elt(inspect$1514$40).STM$();
                                                    if(inspect$1645$44!=null) //INSPECT inspect$1645$44
                                                    // JavaLine 429 ==> SourceLine 1646
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement1646",1646);
                                                        inspect$1514$40.statlabel=((PARSER$codebuffer$elt)inspect$1645$44);
                                                        // JavaLine 433 ==> SourceLine 1647
                                                        inspect$1645$44.opdhii=((PARSER)(CUR$.SL$.SL$)).hashhi;
                                                        inspect$1645$44.opdloo=((PARSER)(CUR$.SL$.SL$)).hashlo;
                                                        inspect$1645$44.opnn=((PARSER)(CUR$.SL$.SL$)).IELME;
                                                        TRACE_END_STM$("CompoundStatement1646",1647);
                                                    }
                                                }
                                                TRACE_END_STM$("CompoundStatement1626",1647);
                                            }
                                        }
                                        // JavaLine 443 ==> SourceLine 1649
                                        new PARSER$codebuffer$elt$emit(inspect$1514$40.statlabel);
                                        new PARSER$grammer$forstat$terminateForelt(((PARSER$grammer$forstat)CUR$));
                                        // JavaLine 446 ==> SourceLine 1650
                                        if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ICOMA))) {
                                            // JavaLine 448 ==> SourceLine 1651
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1651",1651);
                                                inspect$1514$40.wheeler=inspect$1514$40.curelt;
                                                // JavaLine 452 ==> SourceLine 1652
                                                new PARSER$codebuffer$elt$emit(inspect$1514$40.cvar);
                                                // JavaLine 454 ==> SourceLine 1653
                                                ((PARSER$grammer)(CUR$.SL$)).detach();
                                                GOTO$(forelem); // GOTO EVALUATED LABEL
                                                TRACE_END_STM$("CompoundStatement1651",1653);
                                            }
                                        }
                                        // JavaLine 460 ==> SourceLine 1654
                                        new PARSER$grammer$forstat$new_elt(((PARSER$grammer$forstat)CUR$),((PARSER)(CUR$.SL$.SL$)).IDO);
                                        // JavaLine 462 ==> SourceLine 1655
                                        new PARSER$codebuffer$elt$emit(inspect$1514$40.statlabel);
                                        inspect$1514$40.curelt.opnn=((PARSER)(CUR$.SL$.SL$)).ICL;
                                        TRACE_END_STM$("CompoundStatement1626",1655);
                                    }
                                }
                                // JavaLine 468 ==> SourceLine 1657
                                if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IDO))) {
                                    // JavaLine 470 ==> SourceLine 1658
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1658",1658);
                                        new PARSER$codebuffer$terminate(inspect$1514$40);
                                        // JavaLine 474 ==> SourceLine 1659
                                        ((PARSER$grammer)(CUR$.SL$)).detach();
                                        // JavaLine 476 ==> SourceLine 1660
                                        stmtreq=((PARSER$grammer)(CUR$.SL$)).allstmt;
                                        rp=((char)1);
                                        TRACE_END_STM$("CompoundStatement1658",1660);
                                    }
                                } else
                                // JavaLine 482 ==> SourceLine 1664
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1664",1664);
                                    errorno=206;
                                    // JavaLine 486 ==> SourceLine 1665
                                    LABEL$(3); // PARSE
                                    inspect$1514$40.firstelt.next=null;
                                    ftype=((PARSER)(CUR$.SL$.SL$)).NUL;
                                    // JavaLine 490 ==> SourceLine 1666
                                    new PARSER$codebuffer$terminate(inspect$1514$40);
                                    // JavaLine 492 ==> SourceLine 1667
                                    new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$)),errorno);
                                    TRACE_END_STM$("CompoundStatement1664",1667);
                                }
                                // JavaLine 496 ==> SourceLine 1670
                                ((PARSER$grammer$forstat)CUR$).detach();
                                // JavaLine 498 ==> SourceLine 1672
                                if((rp==(((PARSER)(CUR$.SL$.SL$)).NUL))) {
                                    GOTO$(S0); // GOTO EVALUATED LABEL
                                }
                                // JavaLine 502 ==> SourceLine 1678
                                LABEL$(6); // S1
                                // JavaLine 504 ==> SourceLine 1674
                                if(commaSeen) {
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1674",1674);
                                        commaSeen=false;
                                        // JavaLine 509 ==> SourceLine 1675
                                        ((PARSER$grammer)(CUR$.SL$)).fornests=(((PARSER$grammer)(CUR$.SL$)).fornests-(1));
                                        // JavaLine 511 ==> SourceLine 1676
                                        inspect$1514$40.statlabel.opnn=((PARSER)(CUR$.SL$.SL$)).IUNTI;
                                        new PARSER$codebuffer$elt$emit(inspect$1514$40.statlabel);
                                        TRACE_END_STM$("CompoundStatement1674",1676);
                                    }
                                } else
                                // JavaLine 517 ==> SourceLine 1678
                                new PARSER$grammer$forstat$terminateForelt(((PARSER$grammer$forstat)CUR$));
                                // JavaLine 519 ==> SourceLine 1679
                                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IFORE;
                                call(((PARSER)(CUR$.SL$.SL$)).coder);
                                // JavaLine 522 ==> SourceLine 1680
                                if(enclgen) {
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1680",1680);
                                        enclgen=false;
                                        // JavaLine 527 ==> SourceLine 1681
                                        ((PARSER$grammer)(CUR$.SL$)).blockfound=(((PARSER$grammer)(CUR$.SL$)).blockfound-(1));
                                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IEND;
                                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                                        TRACE_END_STM$("CompoundStatement1680",1681);
                                    }
                                }
                                // JavaLine 534 ==> SourceLine 1683
                                inspect$1514$40.statlabel=inspect$1514$40.deltavar=inspect$1514$40.forvar=inspect$1514$40.wheeler=inspect$1514$40.cvar=null;
                                TRACE_END_STM$("CompoundStatement1517",1683);
                            }
                        }
                        // JavaLine 539 ==> SourceLine 1687
                        caller.next=null;
                        ((PARSER$grammer)(CUR$.SL$)).last=caller;
                        // JavaLine 542 ==> SourceLine 1688
                        ((PARSER$grammer)(CUR$.SL$)).foList=((PARSER$grammer$statement)CUR$);
                        // JavaLine 544 ==> SourceLine 1689
                        detach();
                        // JavaLine 546 ==> SourceLine 1691
                        ((PARSER$grammer)(CUR$.SL$)).foList=null;
                        // JavaLine 548 ==> SourceLine 1692
                        forcoder.prev=((PARSER)(CUR$.SL$.SL$)).coder;
                        ((PARSER)(CUR$.SL$.SL$)).coder=forcoder;
                        // JavaLine 551 ==> SourceLine 1693
                        errorno=0;
                        // JavaLine 553 ==> SourceLine 1694
                        recovered=isblocklike=false;
                        // JavaLine 555 ==> SourceLine 1695
                        rp=blockstatus=stmtreq=stmttype=((PARSER)(CUR$.SL$.SL$)).NUL;
                        // JavaLine 557 ==> SourceLine 1696
                        GOTO$(REUSE); // GOTO EVALUATED LABEL
                        // JavaLine 559 ==> SourceLine 1508
                        if(inner!=null) {
                            inner.STM$();
                            TRACE_BEGIN_STM_AFTER_INNER$("forstat",1508);
                        }
                        break LOOP$;
                    }
                    catch(LABQNT$ q) {
                        CUR$=THIS$;
                        if(q.SL$!=CUR$ || q.prefixLevel!=1) {
                            CUR$.STATE$=OperationalState.terminated;
                            if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                            throw(q);
                        }
                        if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                        JTX$=q.index; continue LOOP$; // EG. GOTO Lx
                    }
                }
                TRACE_END_STM$("forstat",1508);
            }
        };
    } // End of Constructor
    // Class Statements
    public PARSER$grammer$forstat STM$() { return((PARSER$grammer$forstat)CODE$.EXEC$()); }
    public PARSER$grammer$forstat START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Class forstat",1,1434,12,1514,14,1621,16,1665,18,1517,20,1532,22,1674,25,1435,27,1436,29,1437,31,1438,33,1439,35,1440,37,1514,39,1551,41,1570,43,1594,45,1645,62,1508,64,1509,66,1684,68,1514,73,1517,78,1518,80,1519,82,1521,90,1522,93,1523,95,1524,97,1525,102,1527,108,1528,112,1529,114,1530,116,1532,119,1533,121,1534,123,1535,125,1537,133,1538,138,1539,140,1540,144,1542,146,1543,148,1544,150,1546,157,1547,159,1549,167,1551,172,1552,176,1555,185,1556,187,1557,192,1559,194,1560,198,1561,202,1562,206,1563,209,1564,215,1566,217,1567,219,1568,222,1569,224,1570,229,1571,233,1572,236,1573,242,1575,244,1576,246,1577,249,1578,252,1579,259,1581,261,1582,263,1583,266,1584,268,1586,271,1587,273,1588,275,1589,278,1590,280,1591,286,1594,291,1595,295,1597,300,1599,302,1600,304,1601,306,1603,313,1604,315,1605,320,1606,322,1607,327,1608,332,1610,337,1613,342,1614,344,1615,346,1616,350,1617,352,1618,354,1619,356,1621,365,1622,370,1624,372,1625,374,1626,381,1627,383,1628,385,1629,387,1630,392,1631,395,1632,400,1634,402,1637,405,1638,407,1639,410,1640,412,1641,417,1642,419,1643,421,1644,424,1645,429,1646,433,1647,443,1649,446,1650,448,1651,452,1652,454,1653,460,1654,462,1655,468,1657,470,1658,474,1659,476,1660,482,1664,486,1665,490,1666,492,1667,496,1670,498,1672,502,1678,504,1674,509,1675,511,1676,517,1678,519,1679,522,1680,527,1681,534,1683,539,1687,542,1688,544,1689,546,1691,548,1692,551,1693,553,1694,555,1695,557,1696,559,1508,583,1698);
}
