// JavaLine 1 <== SourceLine 91
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Pass1$SubBlock32$getsymb extends FILE$ {
    // ClassDeclaration: Kind=Class, BlockLevel=3, PrefixLevel=1, firstLine=91, lastLine=556, hasLocalClasses=false, System=false, detachUsed=true
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 <== SourceLine 359
    final LABQNT$ REPT=new LABQNT$(this,1,"REPT"); // Local Label #1=REPT
    // JavaLine 13 <== SourceLine 361
    final LABQNT$ NXT=new LABQNT$(this,2,"NXT"); // Local Label #2=NXT
    // JavaLine 15 <== SourceLine 363
    final LABQNT$ LOOP=new LABQNT$(this,3,"LOOP"); // Local Label #3=LOOP
    // JavaLine 17 <== SourceLine 384
    final LABQNT$ LNID=new LABQNT$(this,4,"LNID"); // Local Label #4=LNID
    // JavaLine 19 <== SourceLine 420
    final LABQNT$ DIG1=new LABQNT$(this,5,"DIG1"); // Local Label #5=DIG1
    // JavaLine 21 <== SourceLine 426
    final LABQNT$ NUMDOT=new LABQNT$(this,6,"NUMDOT"); // Local Label #6=NUMDOT
    // JavaLine 23 <== SourceLine 431
    final LABQNT$ LEXP=new LABQNT$(this,7,"LEXP"); // Local Label #7=LEXP
    // JavaLine 25 <== SourceLine 533
    final LABQNT$ LEOL=new LABQNT$(this,8,"LEOL"); // Local Label #8=LEOL
    // Declare locals as attributes
    // JavaLine 28 <== SourceLine 92
    public FILE$ prev$1=null;
    // JavaLine 30 <== SourceLine 93
    public InFile$ inpt$1=null;
    // JavaLine 32 <== SourceLine 94
    public char c$1=0;
    // JavaLine 34 <== SourceLine 95
    public int startpos$1=0;
    public int ampos$1=0;
    public int lng$1=0;
    public int s$1=0;
    public int n$1=0;
    public int v$1=0;
    // JavaLine 41 <== SourceLine 96
    public int impos$1=0;
    public int imlen$1=0;
    // JavaLine 44 <== SourceLine 97
    public TXT$ inim$1=null;
    // JavaLine 46 <== SourceLine 98
    public TXT$ t$1=null;
    public TXT$ id$1=null;
    // JavaLine 49 <== SourceLine 390
    public Linkage$ inspect$389$74$1=null;
    // JavaLine 51 <== SourceLine 397
    public Common$macro_symbol inspect$397$75$1=null;
    // JavaLine 53 <== SourceLine 545
    public PrintFile$ inspect$545$76$1=null;
    // Normal Constructor
    public Pass1$SubBlock32$getsymb(RTObject$ staticLink,TXT$ sFILENAME$) {
        super(staticLink,sFILENAME$);
        // Parameter assignment to locals
        // Declaration Code
    }
    // Class Statements
    public Pass1$SubBlock32$getsymb STM$() {
        Pass1$SubBlock32$getsymb THIS$=(Pass1$SubBlock32$getsymb)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // Class FILE: Code before inner
                // JavaLine 68 <== SourceLine 356
                // Class getsymb: Code before inner
                detach();
                ;
                GOTO$(NXT); // GOTO EVALUATED LABEL
                ;
                // JavaLine 74 <== SourceLine 359
                LABEL$(1,"REPT");
                call(((Pass1$SubBlock32)(CUR$.SL$)).parser);
                ;
                // JavaLine 78 <== SourceLine 361
                LABEL$(2,"NXT");
                ((Pass1$SubBlock32)(CUR$.SL$)).curval=null;
                ;
                ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.hash$1=0;
                ;
                // JavaLine 84 <== SourceLine 363
                LABEL$(3,"LOOP");
                c$1=loadChar(inim$1,impos$1);
                ;
                impos$1=Math.addExact(impos$1,1);
                ;
                // JavaLine 90 <== SourceLine 367
                switch(c$1) { // BEGIN SWITCH STATEMENT
                case 97: 
                case 98: 
                case 99: 
                case 100: 
                case 101: 
                case 102: 
                case 103: 
                case 104: 
                case 105: 
                case 106: 
                case 107: 
                case 108: 
                case 109: 
                case 110: 
                case 111: 
                case 112: 
                case 113: 
                case 114: 
                case 115: 
                case 116: 
                case 117: 
                case 118: 
                case 119: 
                case 120: 
                case 121: 
                case 122: 
                case 65: 
                case 66: 
                case 67: 
                case 68: 
                case 69: 
                case 70: 
                case 71: 
                case 72: 
                case 73: 
                case 74: 
                case 75: 
                case 76: 
                case 77: 
                case 78: 
                case 79: 
                case 80: 
                case 81: 
                case 82: 
                case 83: 
                case 84: 
                case 85: 
                case 86: 
                case 87: 
                case 88: 
                case 89: 
                case 90: 
                // JavaLine 144 <== SourceLine 370
                {
                    startpos$1=impos$1;
                    ;
                    // JavaLine 148 <== SourceLine 371
                    while(true) {
                        // JavaLine 150 <== SourceLine 372
                        {
                            c$1=loadChar(inim$1,impos$1);
                            ;
                            impos$1=Math.addExact(impos$1,1);
                            ;
                            // JavaLine 156 <== SourceLine 374
                            switch(c$1) { // BEGIN SWITCH STATEMENT
                            case 48: 
                            case 49: 
                            case 50: 
                            case 51: 
                            case 52: 
                            case 53: 
                            case 54: 
                            case 55: 
                            case 56: 
                            case 57: 
                            case 97: 
                            case 98: 
                            case 99: 
                            case 100: 
                            case 101: 
                            case 102: 
                            case 103: 
                            case 104: 
                            case 105: 
                            case 106: 
                            case 107: 
                            case 108: 
                            case 109: 
                            case 110: 
                            case 111: 
                            case 112: 
                            case 113: 
                            case 114: 
                            case 115: 
                            case 116: 
                            case 117: 
                            case 118: 
                            case 119: 
                            case 120: 
                            case 121: 
                            case 122: 
                            case 65: 
                            case 66: 
                            case 67: 
                            case 68: 
                            case 69: 
                            case 70: 
                            case 71: 
                            case 72: 
                            case 73: 
                            case 74: 
                            case 75: 
                            case 76: 
                            case 77: 
                            case 78: 
                            case 79: 
                            case 80: 
                            case 81: 
                            case 82: 
                            case 83: 
                            case 84: 
                            case 85: 
                            case 86: 
                            case 87: 
                            case 88: 
                            case 89: 
                            case 90: 
                            case 95: 
                            ;
                            break;
                            default:
                            // JavaLine 224 <== SourceLine 379
                            {
                                GOTO$(LNID); // GOTO EVALUATED LABEL
                                ;
                            }
                            break;
                        } // END SWITCH STATEMENT
                        ;
                    }
                    if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                }
                ;
                // JavaLine 236 <== SourceLine 384
                LABEL$(4,"LNID");
                ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.simsymbol$1=TXT$.sub(inim$1,startpos$1,Math.subtractExact(impos$1,startpos$1));
                ;
                // JavaLine 240 <== SourceLine 386
                new Common$DEFIDENT(((Pass1)(CUR$.SL$.SL$)).inspect$28$62);
                ;
                // JavaLine 243 <== SourceLine 387
                new Common$TRACE(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.GETSYMB LNID"),387,CONC(new TXT$("simsymbol="),new Common$edSymbol(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$)).inspect$28$62.hash$1).RESULT$));
                ;
                // JavaLine 246 <== SourceLine 388
                if(VALUE$((((Pass1)(CUR$.SL$.SL$)).inspect$28$62.hash$1>(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_MXMX$1)))) {
                    // JavaLine 248 <== SourceLine 389
                    {
                        {
                            // BEGIN INSPECTION 
                            inspect$389$74$1=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$)).inspect$28$62.symtab.LB[0]].curmeaning;
                            //INSPECT inspect$389$74
                            if(inspect$389$74$1 instanceof Common$macro) // WHEN Common$macro DO 
                            // JavaLine 255 <== SourceLine 391
                            {
                                new Common$TRACE(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.GETSYMB"),391,CONC(new TXT$("MACRO="),new Common$edSymbol(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$)).inspect$28$62.hash$1).RESULT$));
                                ;
                                // JavaLine 259 <== SourceLine 392
                                if(VALUE$((((Common$macro)(inspect$389$74$1)).msc$3!=(null)))) {
                                    // JavaLine 261 <== SourceLine 393
                                    call(((Common$macro)(inspect$389$74$1)).msc$3);
                                } else
                                new Pass1$SubBlock32$macro_scan(((Pass1$SubBlock32)(CUR$.SL$)),new TXT$("***macro***"),((Common$macro)inspect$389$74$1)).START$();
                                ;
                            }
                            else if(inspect$389$74$1 instanceof Common$mnemonic) // WHEN Common$mnemonic DO 
                            // JavaLine 268 <== SourceLine 396
                            {
                                new Common$TRACE(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.GETSYMB"),396,CONC(new TXT$("MNEMONIC="),new Common$edSymbol(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$)).inspect$28$62.hash$1).RESULT$));
                                ;
                                // JavaLine 272 <== SourceLine 397
                                {
                                    // BEGIN INSPECTION 
                                    inspect$397$75$1=((Common$macro_symbol)(((Common$mnemonic)inspect$389$74$1).first()));
                                    if(inspect$397$75$1!=null) // INSPECT inspect$397$75
                                    // JavaLine 277 <== SourceLine 398
                                    {
                                        ((Pass1$SubBlock32)(CUR$.SL$)).curval=inspect$397$75$1.p2$v;
                                        ;
                                        ((Pass1$SubBlock32)(CUR$.SL$)).symbol=inspect$397$75$1.p2$s;
                                        ;
                                        // JavaLine 283 <== SourceLine 399
                                        ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.hash$1=inspect$397$75$1.p2$box.id;
                                        ;
                                    }
                                }
                                ;
                            }
                            else // OTHERWISE 
                            // JavaLine 291 <== SourceLine 403
                            {
                                ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_IDENT$1;
                                ;
                                // JavaLine 295 <== SourceLine 404
                                ((Pass1$SubBlock32)(CUR$.SL$)).curval=TXT$.sub(inim$1,startpos$1,Math.subtractExact(impos$1,startpos$1));
                                ;
                                // JavaLine 298 <== SourceLine 405
                                new Common$TRACE(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.GETSYMB"),405,CONC(new TXT$("IDENTIFIER="),((Pass1$SubBlock32)(CUR$.SL$)).curval));
                                ;
                            }
                        }
                        ;
                    }
                } else
                // JavaLine 306 <== SourceLine 408
                {
                    ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.hash$1;
                    ;
                    // JavaLine 310 <== SourceLine 409
                    new Common$TRACE(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.GETSYMB"),409,CONC(new TXT$("KEYWORD="),new Common$edSymbol(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,((Pass1$SubBlock32)(CUR$.SL$)).symbol).RESULT$));
                    ;
                }
                ;
                // JavaLine 315 <== SourceLine 411
                impos$1=Math.subtractExact(impos$1,1);
                ;
            }
            break;
            case 38: 
            // JavaLine 321 <== SourceLine 416
            {
                startpos$1=impos$1;
                ;
                GOTO$(LEXP); // GOTO EVALUATED LABEL
                ;
            }
            break;
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 54: 
            case 55: 
            case 56: 
            case 57: 
            // JavaLine 339 <== SourceLine 419
            {
                startpos$1=impos$1;
                ;
                // JavaLine 343 <== SourceLine 420
                LABEL$(5,"DIG1");
                c$1=loadChar(inim$1,impos$1);
                ;
                impos$1=Math.addExact(impos$1,1);
                ;
                // JavaLine 349 <== SourceLine 421
                if(VALUE$(digit(c$1))) {
                    GOTO$(DIG1); // GOTO EVALUATED LABEL
                }
                ;
                // JavaLine 354 <== SourceLine 422
                if(VALUE$((c$1==('.')))) {
                    // JavaLine 356 <== SourceLine 423
                    {
                        c$1=loadChar(inim$1,impos$1);
                        ;
                        impos$1=Math.addExact(impos$1,1);
                        ;
                        // JavaLine 362 <== SourceLine 424
                        if(VALUE$(digit(c$1))) {
                            // JavaLine 364 <== SourceLine 425
                            {
                                while(digit(c$1)) {
                                    // JavaLine 367 <== SourceLine 426
                                    {
                                        LABEL$(6,"NUMDOT");
                                        c$1=loadChar(inim$1,impos$1);
                                        ;
                                        impos$1=Math.addExact(impos$1,1);
                                        ;
                                    }
                                }
                                ;
                            }
                        } else
                        // JavaLine 379 <== SourceLine 428
                        new Common$ERROR(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,new TXT$("No digit after dot"));
                        ;
                        // JavaLine 382 <== SourceLine 429
                        ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_REALVAL$1;
                        ;
                        // JavaLine 385 <== SourceLine 430
                        if(VALUE$((c$1==('&')))) {
                            // JavaLine 387 <== SourceLine 431
                            {
                                LABEL$(7,"LEXP");
                                ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_REALVAL$1;
                                ;
                                // JavaLine 392 <== SourceLine 432
                                c$1=loadChar(inim$1,impos$1);
                                ;
                                impos$1=Math.addExact(impos$1,1);
                                ;
                                // JavaLine 397 <== SourceLine 433
                                if(VALUE$((c$1==('&')))) {
                                    // JavaLine 399 <== SourceLine 434
                                    {
                                        ampos$1=Math.subtractExact(impos$1,startpos$1);
                                        ;
                                        // JavaLine 403 <== SourceLine 435
                                        c$1=loadChar(inim$1,impos$1);
                                        ;
                                        impos$1=Math.addExact(impos$1,1);
                                        ;
                                        // JavaLine 408 <== SourceLine 436
                                        ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_LREALVAL$1;
                                    }
                                }
                                ;
                                // JavaLine 413 <== SourceLine 438
                                if(VALUE$(((c$1==('+'))|((c$1==('-')))))) {
                                    // JavaLine 415 <== SourceLine 439
                                    {
                                        c$1=loadChar(inim$1,impos$1);
                                        ;
                                        impos$1=Math.addExact(impos$1,1);
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 424 <== SourceLine 441
                                if(VALUE$(digit(c$1))) {
                                    {
                                        while(digit(c$1)) {
                                            // JavaLine 428 <== SourceLine 442
                                            {
                                                c$1=loadChar(inim$1,impos$1);
                                                ;
                                                impos$1=Math.addExact(impos$1,1);
                                                ;
                                            }
                                        }
                                    }
                                } else
                                // JavaLine 438 <== SourceLine 444
                                new Common$ERROR(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,new TXT$("No digit after ampersand"));
                                ;
                            }
                        }
                        ;
                    }
                } else
                // JavaLine 446 <== SourceLine 447
                if(VALUE$((c$1==('&')))) {
                    // JavaLine 448 <== SourceLine 448
                    GOTO$(LEXP); // GOTO EVALUATED LABEL
                } else
                ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_INTVAL$1;
                ;
                // JavaLine 453 <== SourceLine 449
                lng$1=Math.subtractExact(impos$1,startpos$1);
                ;
                // JavaLine 456 <== SourceLine 450
                ((Pass1$SubBlock32)(CUR$.SL$)).curval=copy(copy(TXT$.sub(inim$1,startpos$1,lng$1)));
                ;
                // JavaLine 459 <== SourceLine 451
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_LREALVAL$1)))) {
                    // JavaLine 461 <== SourceLine 453
                    {
                        ASGTXT$(TXT$.sub(((Pass1$SubBlock32)(CUR$.SL$)).curval,ampos$1,Math.subtractExact(lng$1,ampos$1)),TXT$.sub(((Pass1$SubBlock32)(CUR$.SL$)).curval,Math.addExact(ampos$1,1),Math.subtractExact(lng$1,ampos$1)));
                        ;
                        // JavaLine 465 <== SourceLine 455
                        ((Pass1$SubBlock32)(CUR$.SL$)).curval=TXT$.sub(((Pass1$SubBlock32)(CUR$.SL$)).curval,1,Math.subtractExact(lng$1,1));
                        ;
                    }
                }
                ;
                // JavaLine 471 <== SourceLine 457
                impos$1=Math.subtractExact(impos$1,1);
                ;
            }
            break;
            case 34: 
            // JavaLine 477 <== SourceLine 462
            {
                new Pass1$SubBlock32$getsymb$instringval(((Pass1$SubBlock32$getsymb)(CUR$)),'"');
                ;
                ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_STRING$1;
                ;
            }
            break;
            case 39: 
            // JavaLine 486 <== SourceLine 467
            {
                new Pass1$SubBlock32$getsymb$instringval(((Pass1$SubBlock32$getsymb)(CUR$)),((char)39));
                ;
                ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_CHARS$1;
                ;
            }
            break;
            case 37: 
            // JavaLine 495 <== SourceLine 471
            ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_PERCENT$1;
            break;
            case 40: 
            // JavaLine 499 <== SourceLine 473
            ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_LPAR$1;
            break;
            case 41: 
            // JavaLine 503 <== SourceLine 474
            ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_RPAR$1;
            break;
            case 43: 
            // JavaLine 507 <== SourceLine 475
            ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_ADD$1;
            break;
            case 44: 
            // JavaLine 511 <== SourceLine 476
            ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_COMMA$1;
            break;
            case 47: 
            // JavaLine 515 <== SourceLine 477
            ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_DIV$1;
            break;
            case 61: 
            // JavaLine 519 <== SourceLine 478
            ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_EQ$1;
            break;
            case 64: 
            // JavaLine 523 <== SourceLine 479
            ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_ADDRESS$1;
            break;
            case 45: 
            // JavaLine 527 <== SourceLine 482
            {
                if(VALUE$((loadChar(inim$1,impos$1)==('-')))) {
                    GOTO$(LEOL); // GOTO EVALUATED LABEL
                }
                ;
                // JavaLine 533 <== SourceLine 483
                ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_SUB$1;
                ;
            }
            break;
            case 46: 
            // JavaLine 539 <== SourceLine 487
            {
                if(VALUE$(digit(loadChar(inim$1,impos$1)))) {
                    GOTO$(NUMDOT); // GOTO EVALUATED LABEL
                }
                ;
                // JavaLine 545 <== SourceLine 488
                ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_DOT$1;
                ;
            }
            break;
            case 58: 
            // JavaLine 551 <== SourceLine 492
            {
                if(VALUE$((loadChar(inim$1,impos$1)==('=')))) {
                    // JavaLine 554 <== SourceLine 493
                    {
                        ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_ASSIGN$1;
                        ;
                        impos$1=Math.addExact(impos$1,1);
                    }
                } else
                // JavaLine 561 <== SourceLine 494
                ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_COLON$1;
                ;
            }
            break;
            case 42: 
            // JavaLine 567 <== SourceLine 498
            {
                if(VALUE$((loadChar(inim$1,impos$1)==('/')))) {
                    // JavaLine 570 <== SourceLine 500
                    {
                        ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_PERCENT$1;
                        ;
                        impos$1=Math.addExact(impos$1,1);
                    }
                } else
                // JavaLine 577 <== SourceLine 501
                ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_MULT$1;
                ;
            }
            break;
            case 60: 
            // JavaLine 583 <== SourceLine 505
            {
                c$1=loadChar(inim$1,impos$1);
                ;
                // JavaLine 587 <== SourceLine 506
                if(VALUE$((c$1==('>')))) {
                    // JavaLine 589 <== SourceLine 507
                    {
                        ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_NE$1;
                        ;
                        impos$1=Math.addExact(impos$1,1);
                    }
                } else
                // JavaLine 596 <== SourceLine 508
                if(VALUE$((c$1==('=')))) {
                    // JavaLine 598 <== SourceLine 509
                    {
                        ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_LE$1;
                        ;
                        impos$1=Math.addExact(impos$1,1);
                    }
                } else
                // JavaLine 605 <== SourceLine 510
                if(VALUE$((((Pass1)(CUR$.SL$.SL$)).inspect$28$62.SportOk$1&&((c$1==('<')))))) {
                    // JavaLine 607 <== SourceLine 511
                    {
                        ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_LSHIFTL$1;
                        ;
                        impos$1=Math.addExact(impos$1,1);
                    }
                } else
                // JavaLine 614 <== SourceLine 512
                if(VALUE$(((((Pass1)(CUR$.SL$.SL$)).inspect$28$62.SportOk$1&&((c$1==('-'))))&&((loadChar(inim$1,Math.addExact(impos$1,1))==('<')))))) {
                    // JavaLine 616 <== SourceLine 515
                    {
                        ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_LSHIFTA$1;
                        ;
                        impos$1=Math.addExact(impos$1,2);
                    }
                } else
                // JavaLine 623 <== SourceLine 516
                ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_LT$1;
                ;
            }
            break;
            case 62: 
            // JavaLine 629 <== SourceLine 520
            {
                c$1=loadChar(inim$1,impos$1);
                ;
                // JavaLine 633 <== SourceLine 521
                if(VALUE$((c$1==('=')))) {
                    // JavaLine 635 <== SourceLine 522
                    {
                        ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_GE$1;
                        ;
                        impos$1=Math.addExact(impos$1,1);
                    }
                } else
                // JavaLine 642 <== SourceLine 523
                if(VALUE$((((Pass1)(CUR$.SL$.SL$)).inspect$28$62.SportOk$1&&((c$1==('>')))))) {
                    // JavaLine 644 <== SourceLine 524
                    {
                        ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_RSHIFTL$1;
                        ;
                        impos$1=Math.addExact(impos$1,1);
                    }
                } else
                // JavaLine 651 <== SourceLine 525
                if(VALUE$(((((Pass1)(CUR$.SL$.SL$)).inspect$28$62.SportOk$1&&((c$1==('-'))))&&((loadChar(inim$1,Math.addExact(impos$1,1))==('>')))))) {
                    // JavaLine 653 <== SourceLine 528
                    {
                        ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_RSHIFTA$1;
                        ;
                        impos$1=Math.addExact(impos$1,2);
                    }
                } else
                // JavaLine 660 <== SourceLine 529
                ((Pass1$SubBlock32)(CUR$.SL$)).symbol=((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_GT$1;
                ;
            }
            break;
            case 30: 
            // JavaLine 666 <== SourceLine 533
            {
                LABEL$(8,"LEOL");
                new Pass1$SubBlock32$getsymb$inline(((Pass1$SubBlock32$getsymb)(CUR$)));
                ;
                GOTO$(LOOP); // GOTO EVALUATED LABEL
                ;
            }
            break;
            case 0: 
            case 127: 
            case 59: 
            case 32: 
            case 9: 
            // JavaLine 680 <== SourceLine 535
            GOTO$(LOOP); // GOTO EVALUATED LABEL
            break;
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 31: 
            case 33: 
            case 35: 
            case 36: 
            case 63: 
            case 91: 
            case 92: 
            case 93: 
            case 94: 
            case 95: 
            case 96: 
            case 123: 
            case 124: 
            case 125: 
            case 126: 
            // JavaLine 721 <== SourceLine 539
            {
                // JavaLine 723 <== SourceLine 540
                new Common$ERROR(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,CONC(new TXT$("Illegal character - ignored: "),new Common$leftint(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,rank(c$1)).RESULT$));
                ;
                // JavaLine 726 <== SourceLine 541
                GOTO$(LOOP); // GOTO EVALUATED LABEL
                ;
            }
            break;
        } // END SWITCH STATEMENT
        ;
        // JavaLine 733 <== SourceLine 545
        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).input_trace>(1)))) {
            {
                // BEGIN INSPECTION 
                inspect$545$76$1=sysout();
                if(inspect$545$76$1!=null) // INSPECT inspect$545$76
                // JavaLine 739 <== SourceLine 546
                {
                    inspect$545$76$1.outtext(new TXT$("Line"));
                    ;
                    inspect$545$76$1.outint(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.curline$1,6);
                    ;
                    inspect$545$76$1.outtext(new TXT$("   "));
                    ;
                    // JavaLine 747 <== SourceLine 547
                    inspect$545$76$1.outtext(new TXT$("Symbol=#"));
                    ;
                    inspect$545$76$1.outtext(new Common$leftint(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,((Pass1$SubBlock32)(CUR$.SL$)).symbol).RESULT$);
                    ;
                    // JavaLine 752 <== SourceLine 548
                    inspect$545$76$1.outtext(CONC(new TXT$(":"),new Common$edSymbol(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,((Pass1$SubBlock32)(CUR$.SL$)).symbol).RESULT$));
                    ;
                    // JavaLine 755 <== SourceLine 549
                    if(VALUE$(TRF_NE(((Pass1$SubBlock32)(CUR$.SL$)).curval,null))) {
                        // JavaLine 757 <== SourceLine 550
                        {
                            inspect$545$76$1.setpos(50);
                            ;
                            inspect$545$76$1.outtext(CONC(CONC(new TXT$("Value: \""),((Pass1$SubBlock32)(CUR$.SL$)).curval),new TXT$("\"")));
                            ;
                        }
                    }
                    ;
                    // JavaLine 766 <== SourceLine 552
                    inspect$545$76$1.outimage();
                    ;
                }
            }
        }
        ;
        // JavaLine 773 <== SourceLine 554
        GOTO$(REPT); // GOTO EVALUATED LABEL
        ;
        // JavaLine 776 <== SourceLine 356
        // Class getsymb: Code after inner
        break LOOP$;
    }
    catch(LABQNT$ q) {
        CUR$=THIS$;
        if(q.SL$!=CUR$) {
            if(RT.Option.GOTO_TRACING) TRACE_GOTO("getsymb:NON-LOCAL",q);
            CUR$.STATE$=OperationalState.terminated;
            if(RT.Option.GOTO_TRACING) TRACE_GOTO("getsymb:RE-THROW",q);
            throw(q);
        }
        if(RT.Option.GOTO_TRACING) TRACE_GOTO("getsymb:LOCAL",q);
        JTX$=q.index; continue LOOP$; // EG. GOTO Lx
    }
}
EBLK();
return(this);
} // End of Class Statements
public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Class getsymb",1,91,11,359,13,361,15,363,17,384,19,420,21,426,23,431,25,533,28,92,30,93,32,94,34,95,41,96,44,97,46,98,49,390,51,397,53,545,68,356,74,359,78,361,84,363,90,367,144,370,148,371,150,372,156,374,224,379,236,384,240,386,243,387,246,388,248,389,255,391,259,392,261,393,268,396,272,397,277,398,283,399,291,403,295,404,298,405,306,408,310,409,315,411,321,416,339,419,343,420,349,421,354,422,356,423,362,424,364,425,367,426,379,428,382,429,385,430,387,431,392,432,397,433,399,434,403,435,408,436,413,438,415,439,424,441,428,442,438,444,446,447,448,448,453,449,456,450,459,451,461,453,465,455,471,457,477,462,486,467,495,471,499,473,503,474,507,475,511,476,515,477,519,478,523,479,527,482,533,483,539,487,545,488,551,492,554,493,561,494,567,498,570,500,577,501,583,505,587,506,589,507,596,508,598,509,605,510,607,511,614,512,616,515,623,516,629,520,633,521,635,522,642,523,644,524,651,525,653,528,660,529,666,533,680,535,721,539,723,540,726,541,733,545,739,546,747,547,752,548,755,549,757,550,766,552,773,554,776,356,794,556);
} // End of Class
