// JavaLine 1 <== SourceLine 1407
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$getprim extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=1407, lastLine=1604, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public Common$expr RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 13 <== SourceLine 1446
    final LABQNT$ strl4=new LABQNT$(this,1,"strl4"); // Local Label #1=strl4
    // JavaLine 15 <== SourceLine 1516
    final LABQNT$ SADDR=new LABQNT$(this,2,"SADDR"); // Local Label #2=SADDR
    // JavaLine 17 <== SourceLine 1550
    final LABQNT$ L=new LABQNT$(this,3,"L"); // Local Label #3=L
    // Declare locals as attributes
    // JavaLine 20 <== SourceLine 1408
    Common$expr x=null;
    Head$ exprset=null;
    Common$designator d=null;
    // JavaLine 24 <== SourceLine 1409
    TXT$ symbval=null;
    // JavaLine 26 <== SourceLine 1410
    Common$const$ e=null;
    Common$symbolbox cbox=null;
    // JavaLine 29 <== SourceLine 1482
    Common$offset_const inspect$1482$99=null;
    // JavaLine 31 <== SourceLine 1516
    Head$ inspect$1516$100=null;
    Link$ inspect$1516$101=null;
    // JavaLine 34 <== SourceLine 1541
    Common$structured_const inspect$1541$102=null;
    // JavaLine 36 <== SourceLine 1557
    Common$repeated_const inspect$1557$103=null;
    // JavaLine 38 <== SourceLine 1571
    Common$ifexpr inspect$1571$104=null;
    // Normal Constructor
    public Pass1$SubBlock32$grammar$getprim(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$grammar$getprim STM$() {
        Pass1$SubBlock32$grammar$getprim THIS$=(Pass1$SubBlock32$grammar$getprim)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 54 <== SourceLine 1412
                switch(((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol) { // BEGIN SWITCH STATEMENT
                case 216: 
                case 176: 
                case 70: 
                // JavaLine 59 <== SourceLine 1415
                RESULT$=new Pass1$SubBlock32$grammar$indesignator(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$;
                break;
                case 27: 
                // JavaLine 63 <== SourceLine 1418
                {
                    RESULT$=new Common$const$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_NOWHERE$1).STM$();
                    ;
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                }
                break;
                case 190: 
                // JavaLine 72 <== SourceLine 1421
                {
                    RESULT$=new Common$val_const(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_C_INT$1,((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval).STM$();
                    ;
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                }
                break;
                case 191: 
                // JavaLine 81 <== SourceLine 1424
                {
                    RESULT$=new Common$val_const(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_C_REAL$1,((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval).STM$();
                    ;
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                }
                break;
                case 192: 
                // JavaLine 90 <== SourceLine 1427
                {
                    RESULT$=new Common$val_const(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_C_LREAL$1,((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval).STM$();
                    ;
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                }
                break;
                case 28: 
                // JavaLine 99 <== SourceLine 1430
                {
                    RESULT$=new Common$const$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_TRUE$1).STM$();
                    ;
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                }
                break;
                case 29: 
                // JavaLine 108 <== SourceLine 1433
                {
                    RESULT$=new Common$const$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_FALSE$1).STM$();
                    ;
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                }
                break;
                case 200: 
                // JavaLine 117 <== SourceLine 1436
                {
                    symbval=((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval;
                    ;
                    // JavaLine 121 <== SourceLine 1437
                    RESULT$=(((TXT$.length(symbval)==(1)))?(new Common$val_const(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_C_CHAR$1,symbval).STM$()):(new Common$val_const(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_TEXT$1,symbval).STM$()));
                    ;
                    // JavaLine 124 <== SourceLine 1440
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                }
                break;
                case 193: 
                // JavaLine 130 <== SourceLine 1443
                {
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).nstring$1=Math.addExact(((Pass1$SubBlock32$grammar)(CUR$.SL$)).nstring$1,1);
                    ;
                    // JavaLine 134 <== SourceLine 1444
                    ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.simsymbol$1=CONC(new TXT$("string:"),new Common$leftint(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1$SubBlock32$grammar)(CUR$.SL$)).nstring$1).RESULT$);
                    ;
                    new Common$DEFIDENT(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62);
                    ;
                    // JavaLine 139 <== SourceLine 1445
                    cbox=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.LB[0]];
                    ;
                    // JavaLine 142 <== SourceLine 1446
                    symbval=((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval;
                    ;
                    LABEL$(1,"strl4");
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 148 <== SourceLine 1447
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_STRING$1)))) {
                        // JavaLine 150 <== SourceLine 1448
                        {
                            symbval=CONC(symbval,((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval);
                            ;
                            GOTO$(strl4); // GOTO EVALUATED LABEL
                        }
                    }
                    ;
                    // JavaLine 158 <== SourceLine 1449
                    RESULT$=new Pass1$SubBlock32$grammar$new_string(((Pass1$SubBlock32$grammar)(CUR$.SL$)),((Pass1$SubBlock32)(CUR$.SL$.SL$)).currentset,symbval,cbox).RESULT$;
                    ;
                }
                break;
                case 161: 
                // JavaLine 164 <== SourceLine 1453
                {
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1453,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                    }
                    ;
                    // JavaLine 172 <== SourceLine 1454
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1454,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                    }
                    ;
                    // JavaLine 179 <== SourceLine 1455
                    cbox=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.LB[0]];
                    ;
                    // JavaLine 182 <== SourceLine 1456
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 185 <== SourceLine 1457
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                        // JavaLine 187 <== SourceLine 1458
                        RESULT$=new Common$idn_const(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_C_SIZE$1,cbox).STM$();
                    } else
                    // JavaLine 190 <== SourceLine 1460
                    {
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COMMA$1)))) {
                            ;
                        } else
                        // JavaLine 195 <== SourceLine 1461
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COLON$1)))) {
                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1461,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COLON$1);
                        }
                        ;
                        // JavaLine 200 <== SourceLine 1462
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                        ;
                        // JavaLine 203 <== SourceLine 1463
                        RESULT$=new Common$dsize(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,cbox.id,new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$).STM$();
                        ;
                        // JavaLine 206 <== SourceLine 1464
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1464,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                        }
                        ;
                    }
                    ;
                    // JavaLine 213 <== SourceLine 1466
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                }
                break;
                case 139: 
                // JavaLine 219 <== SourceLine 1469
                {
                    RESULT$=new Common$const$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_NOSIZE$1).STM$();
                    ;
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                }
                break;
                case 165: 
                // JavaLine 228 <== SourceLine 1472
                {
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1472,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                    }
                    ;
                    // JavaLine 236 <== SourceLine 1473
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1473,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                    }
                    ;
                    // JavaLine 243 <== SourceLine 1474
                    RESULT$=new Common$idn_const(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_C_OADDR$1,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.LB[0]]).STM$();
                    ;
                    // JavaLine 246 <== SourceLine 1475
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1475,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                    }
                    ;
                    // JavaLine 253 <== SourceLine 1476
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                }
                break;
                case 170: 
                // JavaLine 259 <== SourceLine 1479
                {
                    RESULT$=new Common$const$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ONONE$1).STM$();
                    ;
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                }
                break;
                case 167: 
                // JavaLine 268 <== SourceLine 1482
                {
                    {
                        // BEGIN INSPECTION 
                        inspect$1482$99=new Common$offset_const(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_C_AADDR$1).STM$();
                        if(inspect$1482$99!=null) // INSPECT inspect$1482$99
                        // JavaLine 274 <== SourceLine 1483
                        {
                            RESULT$=((Common$offset_const)inspect$1482$99);
                            ;
                            // JavaLine 278 <== SourceLine 1484
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 281 <== SourceLine 1485
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1485,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                            }
                            ;
                            // JavaLine 286 <== SourceLine 1486
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 289 <== SourceLine 1487
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1487,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                            }
                            ;
                            // JavaLine 294 <== SourceLine 1488
                            inspect$1482$99.of$4=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1;
                            ;
                            // JavaLine 297 <== SourceLine 1489
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_DOT$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1489,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_DOT$1);
                            }
                            ;
                            // JavaLine 304 <== SourceLine 1490
                            while((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_DOT$1))) {
                                // JavaLine 306 <== SourceLine 1491
                                {
                                    inspect$1482$99.ndot$4=Math.addExact(inspect$1482$99.ndot$4,1);
                                    ;
                                    // JavaLine 310 <== SourceLine 1492
                                    if(VALUE$((inspect$1482$99.ndot$4>(5)))) {
                                        new Common$FATAL_ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("More than 5 dots"));
                                    }
                                    ;
                                    // JavaLine 315 <== SourceLine 1493
                                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                    ;
                                    // JavaLine 318 <== SourceLine 1494
                                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1494,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                                    }
                                    ;
                                    // JavaLine 323 <== SourceLine 1495
                                    inspect$1482$99.q.Elt[inspect$1482$99.ndot$4-inspect$1482$99.q.LB[0]]=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1;
                                    ;
                                    // JavaLine 326 <== SourceLine 1496
                                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                    ;
                                }
                            }
                            ;
                            // JavaLine 332 <== SourceLine 1498
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1498,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                            }
                            ;
                        }
                    }
                    ;
                    // JavaLine 340 <== SourceLine 1500
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                }
                break;
                case 172: 
                // JavaLine 346 <== SourceLine 1503
                {
                    RESULT$=new Common$const$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ANONE$1).STM$();
                    ;
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                }
                break;
                case 166: 
                // JavaLine 355 <== SourceLine 1506
                {
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 359 <== SourceLine 1507
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1507,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                    }
                    ;
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 366 <== SourceLine 1508
                    d=((Common$designator)(new Pass1$SubBlock32$grammar$indesignator(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$));
                    ;
                    // JavaLine 369 <== SourceLine 1509
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                        // JavaLine 371 <== SourceLine 1510
                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1510,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                    } else
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 376 <== SourceLine 1511
                    GOTO$(SADDR); // GOTO EVALUATED LABEL
                }
                break;
                case 199: 
                // JavaLine 381 <== SourceLine 1514
                {
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 385 <== SourceLine 1515
                    d=((Common$designator)(new Pass1$SubBlock32$grammar$indesignator(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$));
                    ;
                    // JavaLine 388 <== SourceLine 1517
                    LABEL$(2,"SADDR");
                    // JavaLine 390 <== SourceLine 1516
                    {
                        // BEGIN INSPECTION 
                        inspect$1516$100=d.p3$varset;
                        if(inspect$1516$100!=null) // INSPECT inspect$1516$100
                        {
                            // BEGIN INSPECTION 
                            inspect$1516$101=inspect$1516$100.first();
                            //INSPECT inspect$1516$101
                            if(inspect$1516$101 instanceof Common$variable) // WHEN Common$variable DO 
                            // JavaLine 400 <== SourceLine 1517
                            if(VALUE$(((((Common$variable)(inspect$1516$101)).argset$2==(null))&&((((Common$variable)inspect$1516$101).suc()==(null)))))) {
                                cbox=((Common$variable)(inspect$1516$101)).varbox$2;
                            }
                        }
                    }
                    ;
                    // JavaLine 407 <== SourceLine 1519
                    if(VALUE$((cbox==(null)))) {
                        RESULT$=new Common$unopr(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_NAME$1,d).STM$();
                    } else
                    // JavaLine 411 <== SourceLine 1520
                    RESULT$=new Common$idn_const(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_C_GADDR$1,cbox).STM$();
                    ;
                }
                break;
                case 171: 
                // JavaLine 417 <== SourceLine 1524
                {
                    RESULT$=new Common$const$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_GNONE$1).STM$();
                    ;
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                }
                break;
                case 169: 
                // JavaLine 426 <== SourceLine 1527
                {
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 430 <== SourceLine 1528
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1528,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                    }
                    ;
                    // JavaLine 435 <== SourceLine 1529
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 438 <== SourceLine 1530
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1530,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                    }
                    ;
                    // JavaLine 443 <== SourceLine 1531
                    RESULT$=new Common$idn_const(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_C_RADDR$1,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.LB[0]]).STM$();
                    ;
                    // JavaLine 446 <== SourceLine 1532
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    // JavaLine 449 <== SourceLine 1533
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1533,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                    }
                    ;
                    // JavaLine 454 <== SourceLine 1534
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                }
                break;
                case 23: 
                // JavaLine 460 <== SourceLine 1537
                {
                    RESULT$=new Common$const$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_NOBODY$1).STM$();
                    ;
                    // JavaLine 464 <== SourceLine 1538
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                }
                break;
                case 1: 
                // JavaLine 470 <== SourceLine 1541
                {
                    // BEGIN INSPECTION 
                    inspect$1541$102=new Common$structured_const(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_C_RECORD$1).STM$();
                    if(inspect$1541$102!=null) // INSPECT inspect$1541$102
                    // JavaLine 475 <== SourceLine 1542
                    {
                        RESULT$=((Common$structured_const)inspect$1541$102);
                        ;
                        inspect$1541$102.elt_set$4=new Head$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                        ;
                        // JavaLine 481 <== SourceLine 1543
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                        ;
                        // JavaLine 484 <== SourceLine 1544
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COLON$1)))) {
                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1544,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COLON$1);
                        }
                        ;
                        // JavaLine 489 <== SourceLine 1545
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                        ;
                        // JavaLine 492 <== SourceLine 1546
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1546,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                        }
                        ;
                        // JavaLine 497 <== SourceLine 1547
                        inspect$1541$102.str$4=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1;
                        ;
                        // JavaLine 500 <== SourceLine 1548
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                        ;
                        // JavaLine 503 <== SourceLine 1549
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1549,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                        }
                        ;
                        // JavaLine 508 <== SourceLine 1550
                        LABEL$(3,"L");
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                        ;
                        // JavaLine 512 <== SourceLine 1551
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1551,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                        }
                        ;
                        // JavaLine 517 <== SourceLine 1552
                        cbox=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.LB[0]];
                        ;
                        // JavaLine 520 <== SourceLine 1553
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                        ;
                        // JavaLine 523 <== SourceLine 1554
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_EQ$1)))) {
                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1554,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_EQ$1);
                        }
                        ;
                        // JavaLine 528 <== SourceLine 1555
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                        ;
                        // JavaLine 531 <== SourceLine 1556
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                            e=new Pass1$SubBlock32$grammar$make_const(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$;
                        } else
                        // JavaLine 535 <== SourceLine 1557
                        {
                            // BEGIN INSPECTION 
                            inspect$1557$103=new Common$repeated_const(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_NULL$1).STM$();
                            if(inspect$1557$103!=null) // INSPECT inspect$1557$103
                            // JavaLine 540 <== SourceLine 1558
                            {
                                e=((Common$repeated_const)inspect$1557$103);
                                ;
                                inspect$1557$103.elt_set$4=new Head$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                                ;
                                // JavaLine 546 <== SourceLine 1559
                                ((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COMMA$1;
                                ;
                                while((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COMMA$1))) {
                                    // JavaLine 550 <== SourceLine 1560
                                    {
                                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                        ;
                                        new Pass1$SubBlock32$grammar$make_const(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$.into(inspect$1557$103.elt_set$4);
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 559 <== SourceLine 1562
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                                    // JavaLine 561 <== SourceLine 1563
                                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1563,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                                } else
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                            }
                        }
                        ;
                        // JavaLine 569 <== SourceLine 1565
                        new Common$elt_notice(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,cbox,e).STM$().into(inspect$1541$102.elt_set$4);
                        ;
                        // JavaLine 572 <== SourceLine 1566
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COMMA$1)))) {
                            GOTO$(L); // GOTO EVALUATED LABEL
                        }
                        ;
                        // JavaLine 577 <== SourceLine 1567
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                            // JavaLine 579 <== SourceLine 1568
                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1568,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                        } else
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                        ;
                    }
                }
                break;
                case 63: 
                // JavaLine 588 <== SourceLine 1571
                {
                    {
                        // BEGIN INSPECTION 
                        inspect$1571$104=new Common$ifexpr(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                        if(inspect$1571$104!=null) // INSPECT inspect$1571$104
                        // JavaLine 594 <== SourceLine 1572
                        {
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            inspect$1571$104.cond$3=new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$;
                            ;
                            // JavaLine 600 <== SourceLine 1573
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_THEN$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1573,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_THEN$1);
                            }
                            ;
                            // JavaLine 605 <== SourceLine 1574
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            inspect$1571$104.x$3=new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$;
                            ;
                            // JavaLine 610 <== SourceLine 1575
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ELSE$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1575,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ELSE$1);
                            }
                            ;
                            // JavaLine 615 <== SourceLine 1576
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            inspect$1571$104.y$3=new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$;
                            ;
                            // JavaLine 620 <== SourceLine 1577
                            RESULT$=((Common$ifexpr)inspect$1571$104);
                            ;
                        }
                    }
                    ;
                }
                break;
                case 109: 
                // JavaLine 629 <== SourceLine 1581
                {
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    RESULT$=new Common$unopr(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_NOT$1,new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).STM$();
                    ;
                }
                break;
                case 99: 
                // JavaLine 638 <== SourceLine 1586
                {
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    RESULT$=new Common$unopr(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_NEG$1,new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).STM$();
                    ;
                }
                break;
                case 195: 
                // JavaLine 647 <== SourceLine 1589
                {
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    RESULT$=x=new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$;
                    ;
                    // JavaLine 653 <== SourceLine 1590
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COMMA$1)))) {
                        // JavaLine 655 <== SourceLine 1591
                        {
                            exprset=new Head$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                            ;
                            x.into(exprset);
                            ;
                            // JavaLine 661 <== SourceLine 1592
                            while((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COMMA$1))) {
                                // JavaLine 663 <== SourceLine 1593
                                {
                                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                    ;
                                    // JavaLine 667 <== SourceLine 1594
                                    new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$.into(exprset);
                                    ;
                                }
                            }
                            ;
                            // JavaLine 673 <== SourceLine 1595
                            RESULT$=new Common$repexpr(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,exprset).STM$();
                            ;
                        }
                    }
                    ;
                    // JavaLine 679 <== SourceLine 1597
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                        // JavaLine 681 <== SourceLine 1598
                        new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1598,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                    } else
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                }
                break;
                default:
                // JavaLine 689 <== SourceLine 1601
                {
                    new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,CONC(new TXT$("Getprim, symbol:"),new Common$leftint(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol).RESULT$));
                    ;
                    // JavaLine 693 <== SourceLine 1602
                    RESULT$=new Common$expr(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                }
                break;
            } // END SWITCH STATEMENT
            ;
            break LOOP$;
        }
        catch(LABQNT$ q) {
            CUR$=THIS$;
            if(q.SL$!=CUR$) {
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("getprim:NON-LOCAL",q);
                CUR$.STATE$=OperationalState.terminated;
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("getprim:RE-THROW",q);
                throw(q);
            }
            if(RT.Option.GOTO_TRACING) TRACE_GOTO("getprim:LOCAL",q);
            JTX$=q.index; continue LOOP$; // EG. GOTO Lx
        }
    }
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure getprim",1,1407,13,1446,15,1516,17,1550,20,1408,24,1409,26,1410,29,1482,31,1516,34,1541,36,1557,38,1571,54,1412,59,1415,63,1418,72,1421,81,1424,90,1427,99,1430,108,1433,117,1436,121,1437,124,1440,130,1443,134,1444,139,1445,142,1446,148,1447,150,1448,158,1449,164,1453,172,1454,179,1455,182,1456,185,1457,187,1458,190,1460,195,1461,200,1462,203,1463,206,1464,213,1466,219,1469,228,1472,236,1473,243,1474,246,1475,253,1476,259,1479,268,1482,274,1483,278,1484,281,1485,286,1486,289,1487,294,1488,297,1489,304,1490,306,1491,310,1492,315,1493,318,1494,323,1495,326,1496,332,1498,340,1500,346,1503,355,1506,359,1507,366,1508,369,1509,371,1510,376,1511,381,1514,385,1515,388,1517,390,1516,400,1517,407,1519,411,1520,417,1524,426,1527,430,1528,435,1529,438,1530,443,1531,446,1532,449,1533,454,1534,460,1537,464,1538,470,1541,475,1542,481,1543,484,1544,489,1545,492,1546,497,1547,500,1548,503,1549,508,1550,512,1551,517,1552,520,1553,523,1554,528,1555,531,1556,535,1557,540,1558,546,1559,550,1560,559,1562,561,1563,569,1565,572,1566,577,1567,579,1568,588,1571,594,1572,600,1573,605,1574,610,1575,615,1576,620,1577,629,1581,638,1586,647,1589,653,1590,655,1591,661,1592,663,1593,667,1594,673,1595,679,1597,681,1598,689,1601,693,1602,715,1604);
} // End of Procedure
