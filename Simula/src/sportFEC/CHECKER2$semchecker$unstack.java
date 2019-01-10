// JavaLine 1 ==> SourceLine 387
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 12:01:21 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER2$semchecker$unstack extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=0, firstLine=387, lastLine=846, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 609
    final LABQNT$ refcom1=new LABQNT$(this,0,1); // Local Label #1=refcom1
    // JavaLine 14 ==> SourceLine 613
    final LABQNT$ refcom2=new LABQNT$(this,0,2); // Local Label #2=refcom2
    // JavaLine 16 ==> SourceLine 639
    final LABQNT$ SETX=new LABQNT$(this,0,3); // Local Label #3=SETX
    // JavaLine 18 ==> SourceLine 646
    final LABQNT$ CONX=new LABQNT$(this,0,4); // Local Label #4=CONX
    // JavaLine 20 ==> SourceLine 633
    final LABQNT$ valcom=new LABQNT$(this,0,5); // Local Label #5=valcom
    // JavaLine 22 ==> SourceLine 678
    final LABQNT$ VALRELX=new LABQNT$(this,0,6); // Local Label #6=VALRELX
    // JavaLine 24 ==> SourceLine 705
    final LABQNT$ GEN=new LABQNT$(this,0,7); // Local Label #7=GEN
    // JavaLine 26 ==> SourceLine 836
    final LABQNT$ popoperator=new LABQNT$(this,0,8); // Local Label #8=popoperator
    // JavaLine 28 ==> SourceLine 841
    final LABQNT$ REPEAT=new LABQNT$(this,0,9); // Local Label #9=REPEAT
    // Declare locals as attributes
    // JavaLine 31 ==> SourceLine 390
    public int lhi=0;
    public int rhi=0;
    // JavaLine 34 ==> SourceLine 391
    public int lhs=0;
    public int rhs=0;
    // JavaLine 37 ==> SourceLine 392
    public TXT$ lht=null;
    public TXT$ rht=null;
    // JavaLine 40 ==> SourceLine 393
    public boolean lhb=false;
    public boolean rhb=false;
    // JavaLine 43 ==> SourceLine 394
    public char lhc=0;
    public char copt=0;
    public char contype=0;
    // JavaLine 47 ==> SourceLine 395
    public CHECKER1$semchecker1$exp sos=null;
    public CHECKER1$semchecker1$exp tos=null;
    public CHECKER1$semchecker1$exp tmp=null;
    // JavaLine 51 ==> SourceLine 397
    public ARRAY$<char[]>optstack=null;
    // JavaLine 53 ==> SourceLine 401
    public ARRAY$<char[]>priority=null;
    // JavaLine 55 ==> SourceLine 402
    public ARRAY$<char[]>comprior=null;
    // JavaLine 57 ==> SourceLine 512
    public CHECKER1$semchecker1$exp inspect$511$12=null;
    // JavaLine 59 ==> SourceLine 648
    public CHECKER1$semchecker1$const$ inspect$648$13=null;
    // JavaLine 61 ==> SourceLine 762
    public CHECKER1$semchecker1$textconc inspect$762$14=null;
    // Normal Constructor
    public CHECKER2$semchecker$unstack(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("unstack",762);
        // JavaLine 70 ==> SourceLine 397
        int[] optstack$LB=new int[1]; int[] optstack$UB=new int[1];
        optstack$LB[0]=0; optstack$UB[0]=((CHECKER2)(CUR$.SL$.SL$)).maxdepth;
        BOUND_CHECK$(optstack$LB[0],optstack$UB[0]);
        optstack=new ARRAY$<char[]>(new char[optstack$UB[0]-optstack$LB[0]+1],optstack$LB,optstack$UB);
        // JavaLine 75 ==> SourceLine 401
        int[] priority$LB=new int[1]; int[] priority$UB=new int[1];
        priority$LB[0]=0; priority$UB[0]=150;
        BOUND_CHECK$(priority$LB[0],priority$UB[0]);
        priority=new ARRAY$<char[]>(new char[priority$UB[0]-priority$LB[0]+1],priority$LB,priority$UB);
        // JavaLine 80 ==> SourceLine 402
        int[] comprior$LB=new int[1]; int[] comprior$UB=new int[1];
        comprior$LB[0]=0; comprior$UB[0]=150;
        BOUND_CHECK$(comprior$LB[0],comprior$UB[0]);
        comprior=new ARRAY$<char[]>(new char[comprior$UB[0]-comprior$LB[0]+1],comprior$LB,comprior$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("unstack",402,inner);
                CHECKER2$semchecker$unstack THIS$=(CHECKER2$semchecker$unstack)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 93 ==> SourceLine 452
                        detach();
                        // JavaLine 95 ==> SourceLine 453
                        while(true) {
                            // JavaLine 97 ==> SourceLine 456
                            {
                                TRACE_BEGIN_STM$("CompoundStatement456",456);
                                copt=optstack.Elt[((CHECKER2$semchecker)(CUR$.SL$)).opttop-optstack.LB[0]];
                                // JavaLine 101 ==> SourceLine 473
                                while((priority.Elt[rank(copt)-priority.LB[0]]>=(comprior.Elt[rank(((CHECKER2)(CUR$.SL$.SL$)).opn)-comprior.LB[0]]))) {
                                    // JavaLine 103 ==> SourceLine 476
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement476",476);
                                        tos=((CHECKER2$semchecker)(CUR$.SL$)).exptop;
                                        sos=tos.p$pred;
                                        // JavaLine 108 ==> SourceLine 484
                                        switch(copt) { // BEGIN SWITCH STATEMENT
                                        case 148: 
                                        // JavaLine 111 ==> SourceLine 488
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement488",488);
                                            new CHECKER2$semchecker$unstack$casePair(((CHECKER2$semchecker$unstack)CUR$));
                                            // JavaLine 115 ==> SourceLine 489
                                            ((CHECKER2$semchecker)(CUR$.SL$)).exptop=new CHECKER2$semchecker$caseexp(((CHECKER2$semchecker)(CUR$.SL$)),((CHECKER2$semchecker)(CUR$.SL$)).exptop,((CHECKER2)(CUR$.SL$.SL$)).ICASE,rhi,lhi,lhc).STM$();
                                            TRACE_END_STM$("CompoundStatement488",489);
                                        }
                                        case 11: 
                                        // JavaLine 120 ==> SourceLine 493
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement493",493);
                                            new CHECKER2$semchecker$unstack$caseSingle(((CHECKER2$semchecker$unstack)CUR$));
                                            // JavaLine 124 ==> SourceLine 495
                                            if((lhc!=(((CHECKER2$semchecker$caseexp)(((CHECKER2$semchecker)(CUR$.SL$)).exptop)).p1$casetype))) {
                                                new ERRMSG$error0(((CHECKER2)(CUR$.SL$.SL$)),443);
                                            }
                                            // JavaLine 128 ==> SourceLine 496
                                            new CHECKER2$semchecker$caseexp$whenvalue(((CHECKER2$semchecker$caseexp)(((CHECKER2$semchecker)(CUR$.SL$)).exptop)),rhi);
                                            // JavaLine 130 ==> SourceLine 497
                                            GOTO$(REPEAT); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement493",497);
                                        }
                                        case 94: 
                                        // JavaLine 135 ==> SourceLine 501
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement501",501);
                                            new CHECKER2$semchecker$unstack$casePair(((CHECKER2$semchecker$unstack)CUR$));
                                            // JavaLine 139 ==> SourceLine 503
                                            if((lhc!=(((CHECKER2$semchecker$caseexp)(((CHECKER2$semchecker)(CUR$.SL$)).exptop)).p1$casetype))) {
                                                new ERRMSG$error0(((CHECKER2)(CUR$.SL$.SL$)),443);
                                            }
                                            // JavaLine 143 ==> SourceLine 504
                                            new CHECKER2$semchecker$caseexp$whenrange(((CHECKER2$semchecker$caseexp)(((CHECKER2$semchecker)(CUR$.SL$)).exptop)),rhi,lhi);
                                            // JavaLine 145 ==> SourceLine 505
                                            GOTO$(REPEAT); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement501",505);
                                        }
                                        case 15: 
                                        case 116: 
                                        // JavaLine 151 ==> SourceLine 511
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement511",511);
                                            {
                                                // BEGIN INSPECTION 
                                                inspect$511$12=sos.p$pred;
                                                if(inspect$511$12!=null) //INSPECT inspect$511$12
                                                // JavaLine 158 ==> SourceLine 512
                                                if((inspect$511$12.ctype==(((CHECKER2)(CUR$.SL$.SL$)).IBOOL))) {
                                                    // JavaLine 160 ==> SourceLine 513
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement513",513);
                                                        if((((CHECKER1$semchecker1$boolconst)(((CHECKER1$semchecker1$exp)inspect$511$12))).ixlo==(((CHECKER2)(CUR$.SL$.SL$)).ITRUE))) {
                                                            // JavaLine 164 ==> SourceLine 514
                                                            ((CHECKER2$semchecker)(CUR$.SL$)).exptop=sos;
                                                        }
                                                        // JavaLine 167 ==> SourceLine 515
                                                        ((CHECKER2$semchecker)(CUR$.SL$)).exptop.p$pred=inspect$511$12.p$pred;
                                                        TRACE_END_STM$("CompoundStatement513",515);
                                                    }
                                                } else
                                                // JavaLine 172 ==> SourceLine 517
                                                ((CHECKER2$semchecker)(CUR$.SL$)).exptop=new CHECKER1$semchecker1$ifexp(((CHECKER2$semchecker)(CUR$.SL$)),inspect$511$12.p$pred,((CHECKER2)(CUR$.SL$.SL$)).IELSE,sos,tos,((CHECKER1$semchecker1$exp)inspect$511$12)).STM$();
                                            }
                                            TRACE_END_STM$("CompoundStatement511",517);
                                        }
                                        case 71: 
                                        case 70: 
                                        case 72: 
                                        // JavaLine 180 ==> SourceLine 522
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement522",522);
                                            if((sos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).IINTG))) {
                                                // JavaLine 184 ==> SourceLine 524
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement524",524);
                                                    if((tos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).IINTG))) {
                                                        // JavaLine 188 ==> SourceLine 525
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement525",525);
                                                            lhs=new BUILDER1$getSAFEint(((CHECKER2)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$arithconst)(sos)).ixhi,((CHECKER1$semchecker1$arithconst)(sos)).ixlo).RESULT$;
                                                            // JavaLine 192 ==> SourceLine 527
                                                            rhs=new BUILDER1$getSAFEint(((CHECKER2)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$arithconst)(tos)).ixhi,((CHECKER1$semchecker1$arithconst)(tos)).ixlo).RESULT$;
                                                            // JavaLine 194 ==> SourceLine 531
                                                            new CHECKER2$semchecker$unstack$ReplaceByConst(((CHECKER2$semchecker$unstack)CUR$),(((copt==(((CHECKER2)(CUR$.SL$.SL$)).IPLUS)))?((lhs+(rhs))):((((copt==(((CHECKER2)(CUR$.SL$.SL$)).IMINU)))?((lhs-(rhs))):((lhs*(rhs)))))));
                                                            // JavaLine 196 ==> SourceLine 532
                                                            GOTO$(popoperator); // GOTO EVALUATED LABEL
                                                            TRACE_END_STM$("CompoundStatement525",532);
                                                        }
                                                    }
                                                    // JavaLine 201 ==> SourceLine 534
                                                    if(((((CHECKER1$semchecker1$const$)(sos)).ixlo==(((CHECKER2)(CUR$.SL$.SL$)).zerolo))&((((CHECKER1$semchecker1$const$)(sos)).ixhi==(((CHECKER2)(CUR$.SL$.SL$)).zerohi))))) {
                                                        // JavaLine 203 ==> SourceLine 537
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement537",537);
                                                            if((copt==(((CHECKER2)(CUR$.SL$.SL$)).IMULT))) {
                                                                ((CHECKER2$semchecker)(CUR$.SL$)).exptop=sos;
                                                            } else
                                                            // JavaLine 209 ==> SourceLine 538
                                                            if((copt==(((CHECKER2)(CUR$.SL$.SL$)).IMINU))) {
                                                                // JavaLine 211 ==> SourceLine 539
                                                                ((CHECKER2$semchecker)(CUR$.SL$)).exptop=new CHECKER1$semchecker1$unary(((CHECKER2$semchecker)(CUR$.SL$)),sos.p$pred,((CHECKER2)(CUR$.SL$.SL$)).IUMNS,tos,tos).STM$();
                                                            } else
                                                            // JavaLine 214 ==> SourceLine 540
                                                            tos.p$pred=sos.p$pred;
                                                            // JavaLine 216 ==> SourceLine 541
                                                            GOTO$(popoperator); // GOTO EVALUATED LABEL
                                                            TRACE_END_STM$("CompoundStatement537",541);
                                                        }
                                                    }
                                                    TRACE_END_STM$("CompoundStatement524",541);
                                                }
                                            } else
                                            // JavaLine 224 ==> SourceLine 544
                                            if((tos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).IINTG))) {
                                                // JavaLine 226 ==> SourceLine 545
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement545",545);
                                                    if((((CHECKER1$semchecker1$const$)(tos)).ixlo==(((CHECKER2)(CUR$.SL$.SL$)).zerolo))) {
                                                        // JavaLine 230 ==> SourceLine 546
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement546",546);
                                                            if((((CHECKER1$semchecker1$const$)(tos)).ixhi==(((CHECKER2)(CUR$.SL$.SL$)).zerohi))) {
                                                                // JavaLine 234 ==> SourceLine 547
                                                                {
                                                                    TRACE_BEGIN_STM$("CompoundStatement547",547);
                                                                    if((copt!=(((CHECKER2)(CUR$.SL$.SL$)).IMULT))) {
                                                                        ((CHECKER2$semchecker)(CUR$.SL$)).exptop=sos;
                                                                    } else
                                                                    // JavaLine 240 ==> SourceLine 548
                                                                    tos.p$pred=sos.p$pred;
                                                                    // JavaLine 242 ==> SourceLine 549
                                                                    GOTO$(popoperator); // GOTO EVALUATED LABEL
                                                                    TRACE_END_STM$("CompoundStatement547",549);
                                                                }
                                                            }
                                                            TRACE_END_STM$("CompoundStatement546",549);
                                                        }
                                                    }
                                                    TRACE_END_STM$("CompoundStatement545",549);
                                                }
                                            }
                                            // JavaLine 253 ==> SourceLine 552
                                            ((CHECKER2$semchecker)(CUR$.SL$)).exptop=new CHECKER1$semchecker1$arithop(((CHECKER2$semchecker)(CUR$.SL$)),sos.p$pred,copt,sos,tos).STM$();
                                            TRACE_END_STM$("CompoundStatement522",552);
                                        }
                                        case 146: 
                                        // JavaLine 258 ==> SourceLine 558
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement558",558);
                                            if(IS$(tos,CHECKER1$semchecker1$arithconst.class)) {
                                                // JavaLine 262 ==> SourceLine 559
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement559",559);
                                                    lht=new COMMON$boxof(((CHECKER2)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$const$)(tos)).ixhi,((CHECKER1$semchecker1$const$)(tos)).ixlo).RESULT$.symbol;
                                                    // JavaLine 266 ==> SourceLine 561
                                                    ((CHECKER2)(CUR$.SL$.SL$)).simsymbol=(((loadChar(lht,0)==('-')))?(TXT$.sub(lht,2,(TXT$.length(lht)-(1)))):(CONC(new TXT$("-"),lht)));
                                                    // JavaLine 268 ==> SourceLine 564
                                                    new COMMON$DEFCONST(((CHECKER2)(CUR$.SL$.SL$)));
                                                    // JavaLine 270 ==> SourceLine 565
                                                    ((CHECKER1$semchecker1$const$)(tos)).ixhi=((CHECKER2)(CUR$.SL$.SL$)).hashhi;
                                                    ((CHECKER1$semchecker1$const$)(tos)).ixlo=((CHECKER2)(CUR$.SL$.SL$)).hashlo;
                                                    TRACE_END_STM$("CompoundStatement559",565);
                                                }
                                            } else
                                            // JavaLine 276 ==> SourceLine 567
                                            ((CHECKER2$semchecker)(CUR$.SL$)).exptop=new CHECKER1$semchecker1$unary(((CHECKER2$semchecker)(CUR$.SL$)),sos,((CHECKER2)(CUR$.SL$.SL$)).IUMNS,tos,tos).STM$();
                                            TRACE_END_STM$("CompoundStatement558",567);
                                        }
                                        case 75: 
                                        // JavaLine 281 ==> SourceLine 572
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement572",572);
                                            if(((sos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).IINTG))&&((tos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).IINTG))))) {
                                                // JavaLine 285 ==> SourceLine 574
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement574",574);
                                                    lhi=new BUILDER1$getSAFEint(((CHECKER2)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$arithconst)(sos)).ixhi,((CHECKER1$semchecker1$arithconst)(sos)).ixlo).RESULT$;
                                                    // JavaLine 289 ==> SourceLine 576
                                                    rhi=new BUILDER1$getSAFEint(((CHECKER2)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$arithconst)(tos)).ixhi,((CHECKER1$semchecker1$arithconst)(tos)).ixlo).RESULT$;
                                                    // JavaLine 291 ==> SourceLine 578
                                                    if((rhi==(0))) {
                                                        // JavaLine 293 ==> SourceLine 579
                                                        new ERRMSG$error0(((CHECKER2)(CUR$.SL$.SL$)),(-(268)));
                                                    } else
                                                    // JavaLine 296 ==> SourceLine 580
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement580",580);
                                                        new CHECKER2$semchecker$unstack$ReplaceByConst(((CHECKER2$semchecker$unstack)CUR$),(lhi/(rhi)));
                                                        GOTO$(popoperator); // GOTO EVALUATED LABEL
                                                        TRACE_END_STM$("CompoundStatement580",580);
                                                    }
                                                    TRACE_END_STM$("CompoundStatement574",580);
                                                }
                                            }
                                            // JavaLine 306 ==> SourceLine 583
                                            ((CHECKER2$semchecker)(CUR$.SL$)).exptop=new CHECKER1$semchecker1$integerdivide(((CHECKER2$semchecker)(CUR$.SL$)),sos.p$pred,((CHECKER2)(CUR$.SL$.SL$)).IIDIV,sos,tos).STM$();
                                            TRACE_END_STM$("CompoundStatement572",583);
                                        }
                                        case 73: 
                                        // JavaLine 311 ==> SourceLine 588
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement588",588);
                                            ((CHECKER2$semchecker)(CUR$.SL$)).exptop=new CHECKER1$semchecker1$divide(((CHECKER2$semchecker)(CUR$.SL$)),sos.p$pred,((CHECKER2)(CUR$.SL$.SL$)).ISLAS,sos,tos).STM$();
                                            TRACE_END_STM$("CompoundStatement588",588);
                                        }
                                        case 74: 
                                        // JavaLine 318 ==> SourceLine 592
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement592",592);
                                            if((sos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).IINTG))) {
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement592",592);
                                                    if((tos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).IINTG))) {
                                                        // JavaLine 325 ==> SourceLine 594
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement594",594);
                                                            lhs=new BUILDER1$getSAFEint(((CHECKER2)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$arithconst)(sos)).ixhi,((CHECKER1$semchecker1$arithconst)(sos)).ixlo).RESULT$;
                                                            // JavaLine 329 ==> SourceLine 596
                                                            rhs=new BUILDER1$getSAFEint(((CHECKER2)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$arithconst)(tos)).ixhi,((CHECKER1$semchecker1$arithconst)(tos)).ixlo).RESULT$;
                                                            // JavaLine 331 ==> SourceLine 598
                                                            if(((rhs<(0))||(((lhs==(0))&((rhs==(0))))))) {
                                                                // JavaLine 333 ==> SourceLine 600
                                                                new ERRMSG$error0(((CHECKER2)(CUR$.SL$.SL$)),(-(198)));
                                                            } else
                                                            // JavaLine 336 ==> SourceLine 601
                                                            {
                                                                TRACE_BEGIN_STM$("CompoundStatement601",601);
                                                                new CHECKER2$semchecker$unstack$ReplaceByConst(((CHECKER2$semchecker$unstack)CUR$),IPOW$(lhs,rhs));
                                                                GOTO$(popoperator); // GOTO EVALUATED LABEL
                                                                TRACE_END_STM$("CompoundStatement601",601);
                                                            }
                                                            TRACE_END_STM$("CompoundStatement594",601);
                                                        }
                                                    }
                                                    TRACE_END_STM$("CompoundStatement592",601);
                                                }
                                            }
                                            // JavaLine 349 ==> SourceLine 603
                                            ((CHECKER2$semchecker)(CUR$.SL$)).exptop=new CHECKER1$semchecker1$power(((CHECKER2$semchecker)(CUR$.SL$)),sos.p$pred,((CHECKER2)(CUR$.SL$.SL$)).IPOWE,sos,tos).STM$();
                                            TRACE_END_STM$("CompoundStatement592",603);
                                        }
                                        case 68: 
                                        case 69: 
                                        // JavaLine 355 ==> SourceLine 607
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement607",607);
                                            if((tos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).ITEXT))) {
                                                // JavaLine 359 ==> SourceLine 608
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement608",608);
                                                    if((((CHECKER1$semchecker1$textconst)(tos)).ixhi==(((CHECKER2)(CUR$.SL$.SL$)).NUL))) {
                                                        // JavaLine 363 ==> SourceLine 609
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement609",609);
                                                            LABEL$(1); // refcom1
                                                            ((CHECKER2$semchecker)(CUR$.SL$)).exptop=new CHECKER1$semchecker1$refrel(((CHECKER2$semchecker)(CUR$.SL$)),sos.p$pred,copt,null,sos).STM$();
                                                            // JavaLine 368 ==> SourceLine 610
                                                            GOTO$(popoperator); // GOTO EVALUATED LABEL
                                                            TRACE_END_STM$("CompoundStatement609",610);
                                                        }
                                                    }
                                                    TRACE_END_STM$("CompoundStatement608",610);
                                                }
                                            }
                                            // JavaLine 376 ==> SourceLine 611
                                            if((sos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).ITEXT))) {
                                                // JavaLine 378 ==> SourceLine 612
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement612",612);
                                                    if((((CHECKER1$semchecker1$textconst)(sos)).ixhi==(((CHECKER2)(CUR$.SL$.SL$)).NUL))) {
                                                        // JavaLine 382 ==> SourceLine 613
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement613",613);
                                                            LABEL$(2); // refcom2
                                                            ((CHECKER2$semchecker)(CUR$.SL$)).exptop=new CHECKER1$semchecker1$refrel(((CHECKER2$semchecker)(CUR$.SL$)),sos.p$pred,copt,null,tos).STM$();
                                                            // JavaLine 387 ==> SourceLine 614
                                                            GOTO$(popoperator); // GOTO EVALUATED LABEL
                                                            TRACE_END_STM$("CompoundStatement613",614);
                                                        }
                                                    }
                                                    TRACE_END_STM$("CompoundStatement612",614);
                                                }
                                            }
                                            // JavaLine 395 ==> SourceLine 615
                                            ((CHECKER2$semchecker)(CUR$.SL$)).exptop=new CHECKER1$semchecker1$refrel(((CHECKER2$semchecker)(CUR$.SL$)),sos.p$pred,copt,sos,tos).STM$();
                                            TRACE_END_STM$("CompoundStatement607",615);
                                        }
                                        case 58: 
                                        case 61: 
                                        // JavaLine 401 ==> SourceLine 620
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement620",620);
                                            if((tos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).ITEXT))) {
                                                // JavaLine 405 ==> SourceLine 621
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement621",621);
                                                    if((((CHECKER1$semchecker1$textconst)(tos)).ixhi==(((CHECKER2)(CUR$.SL$.SL$)).NUL))) {
                                                        // JavaLine 409 ==> SourceLine 622
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement622",622);
                                                            copt=(((copt==(((CHECKER2)(CUR$.SL$.SL$)).IEQ)))?(((CHECKER2)(CUR$.SL$.SL$)).IRFEQ):(((CHECKER2)(CUR$.SL$.SL$)).IRFNE));
                                                            // JavaLine 413 ==> SourceLine 623
                                                            GOTO$(refcom1); // GOTO EVALUATED LABEL
                                                            TRACE_END_STM$("CompoundStatement622",623);
                                                        }
                                                    }
                                                    TRACE_END_STM$("CompoundStatement621",623);
                                                }
                                            }
                                            // JavaLine 421 ==> SourceLine 624
                                            if((sos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).ITEXT))) {
                                                // JavaLine 423 ==> SourceLine 625
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement625",625);
                                                    if((((CHECKER1$semchecker1$textconst)(sos)).ixhi==(((CHECKER2)(CUR$.SL$.SL$)).NUL))) {
                                                        // JavaLine 427 ==> SourceLine 626
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement626",626);
                                                            copt=(((copt==(((CHECKER2)(CUR$.SL$.SL$)).IEQ)))?(((CHECKER2)(CUR$.SL$.SL$)).IRFEQ):(((CHECKER2)(CUR$.SL$.SL$)).IRFNE));
                                                            // JavaLine 431 ==> SourceLine 627
                                                            GOTO$(refcom2); // GOTO EVALUATED LABEL
                                                            TRACE_END_STM$("CompoundStatement626",627);
                                                        }
                                                    }
                                                    TRACE_END_STM$("CompoundStatement625",627);
                                                }
                                            }
                                            // JavaLine 439 ==> SourceLine 628
                                            GOTO$(valcom); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement620",628);
                                        }
                                        case 62: 
                                        case 60: 
                                        case 59: 
                                        case 57: 
                                        // JavaLine 447 ==> SourceLine 632
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement632",632);
                                            // JavaLine 450 ==> SourceLine 680
                                            LABEL$(5); // valcom
                                            // JavaLine 452 ==> SourceLine 633
                                            if(((sos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).IINTG))&&((tos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).IINTG))))) {
                                                // JavaLine 454 ==> SourceLine 635
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement635",635);
                                                    lhs=new BUILDER1$getSAFEint(((CHECKER2)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$arithconst)(sos)).ixhi,((CHECKER1$semchecker1$arithconst)(sos)).ixlo).RESULT$;
                                                    // JavaLine 458 ==> SourceLine 637
                                                    rhs=new BUILDER1$getSAFEint(((CHECKER2)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$arithconst)(tos)).ixhi,((CHECKER1$semchecker1$arithconst)(tos)).ixlo).RESULT$;
                                                    // JavaLine 460 ==> SourceLine 645
                                                    LABEL$(3); // SETX
                                                    // JavaLine 462 ==> SourceLine 639
                                                    lhc=(((((((((copt==(((CHECKER2)(CUR$.SL$.SL$)).IEQ))&&((lhs==(rhs))))||(((copt==(((CHECKER2)(CUR$.SL$.SL$)).INE))&&((lhs!=(rhs))))))||(((copt==(((CHECKER2)(CUR$.SL$.SL$)).ILE))&&((lhs<=(rhs))))))||(((copt==(((CHECKER2)(CUR$.SL$.SL$)).IGE))&&((lhs>=(rhs))))))||(((copt==(((CHECKER2)(CUR$.SL$.SL$)).ILT))&&((lhs<(rhs))))))||(((copt==(((CHECKER2)(CUR$.SL$.SL$)).IGT))&&((lhs>(rhs)))))))?(((CHECKER2)(CUR$.SL$.SL$)).ITRUE):(((CHECKER2)(CUR$.SL$.SL$)).IFALS));
                                                    // JavaLine 464 ==> SourceLine 646
                                                    LABEL$(4); // CONX
                                                    ((CHECKER2$semchecker)(CUR$.SL$)).exptop=new CHECKER1$semchecker1$boolconst(((CHECKER2$semchecker)(CUR$.SL$)),sos.p$pred,((CHECKER2)(CUR$.SL$.SL$)).ICONS).STM$();
                                                    // JavaLine 467 ==> SourceLine 648
                                                    {
                                                        // BEGIN INSPECTION 
                                                        inspect$648$13=((CHECKER1$semchecker1$const$)(((CHECKER2$semchecker)(CUR$.SL$)).exptop));
                                                        if(inspect$648$13!=null) //INSPECT inspect$648$13
                                                        // JavaLine 472 ==> SourceLine 649
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement649",649);
                                                            inspect$648$13.ixhi=((CHECKER2)(CUR$.SL$.SL$)).NUL;
                                                            inspect$648$13.ixlo=lhc;
                                                            inspect$648$13.type=inspect$648$13.ctype=((CHECKER2)(CUR$.SL$.SL$)).IBOOL;
                                                            // JavaLine 478 ==> SourceLine 650
                                                            inspect$648$13.cl=((CHECKER2$semchecker)(CUR$.SL$)).IEEXPcl;
                                                            TRACE_END_STM$("CompoundStatement649",650);
                                                        }
                                                    }
                                                    TRACE_END_STM$("CompoundStatement635",650);
                                                }
                                            } else
                                            // JavaLine 486 ==> SourceLine 653
                                            if(((sos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).ITEXT))&&((tos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).ITEXT))))) {
                                                // JavaLine 488 ==> SourceLine 655
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement655",655);
                                                    lht=(((((CHECKER1$semchecker1$textconst)(sos)).ixhi==(((CHECKER2)(CUR$.SL$.SL$)).NUL)))?(null):(new COMMON$nameof(((CHECKER2)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$textconst)(sos)).ixhi,((CHECKER1$semchecker1$textconst)(sos)).ixlo).RESULT$));
                                                    // JavaLine 492 ==> SourceLine 658
                                                    rht=(((((CHECKER1$semchecker1$textconst)(tos)).ixhi==(((CHECKER2)(CUR$.SL$.SL$)).NUL)))?(null):(new COMMON$nameof(((CHECKER2)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$textconst)(tos)).ixhi,((CHECKER1$semchecker1$textconst)(tos)).ixlo).RESULT$));
                                                    // JavaLine 494 ==> SourceLine 661
                                                    lhc=(((((((((copt==(((CHECKER2)(CUR$.SL$.SL$)).IEQ))&&(TXTREL$EQ(lht,rht)))||(((copt==(((CHECKER2)(CUR$.SL$.SL$)).INE))&&(TXTREL$NE(lht,rht)))))||(((copt==(((CHECKER2)(CUR$.SL$.SL$)).ILE))&&(TXTREL$LE(lht,rht)))))||(((copt==(((CHECKER2)(CUR$.SL$.SL$)).IGE))&&(TXTREL$GE(lht,rht)))))||(((copt==(((CHECKER2)(CUR$.SL$.SL$)).ILT))&&(TXTREL$LT(lht,rht)))))||(((copt==(((CHECKER2)(CUR$.SL$.SL$)).IGT))&&(TXTREL$GT(lht,rht))))))?(((CHECKER2)(CUR$.SL$.SL$)).ITRUE):(((CHECKER2)(CUR$.SL$.SL$)).IFALS));
                                                    // JavaLine 496 ==> SourceLine 669
                                                    GOTO$(CONX); // GOTO EVALUATED LABEL
                                                    TRACE_END_STM$("CompoundStatement655",669);
                                                }
                                            } else
                                            // JavaLine 501 ==> SourceLine 671
                                            if(((sos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).ICHAR))&&((((CHECKER2$semchecker)(CUR$.SL$)).exptop.ctype==(((CHECKER2)(CUR$.SL$.SL$)).ICHAR))))) {
                                                // JavaLine 503 ==> SourceLine 673
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement673",673);
                                                    lhs=rank(((CHECKER1$semchecker1$charconst)(sos)).ixlo);
                                                    // JavaLine 507 ==> SourceLine 674
                                                    rhs=rank(((CHECKER1$semchecker1$charconst)(tos)).ixlo);
                                                    // JavaLine 509 ==> SourceLine 675
                                                    GOTO$(SETX); // GOTO EVALUATED LABEL
                                                    TRACE_END_STM$("CompoundStatement673",675);
                                                }
                                            } else
                                            // JavaLine 514 ==> SourceLine 680
                                            LABEL$(6); // VALRELX
                                            // JavaLine 516 ==> SourceLine 678
                                            if((((CHECKER2$semchecker)(CUR$.SL$)).valrelList==(null))) {
                                                // JavaLine 518 ==> SourceLine 680
                                                new CHECKER1$semchecker1$valuerel(((CHECKER2$semchecker)(CUR$.SL$)),sos.p$pred,copt,sos,tos).START();
                                            } else
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement680",680);
                                                ((CHECKER2$semchecker)(CUR$.SL$)).valrelList.p$ch=copt;
                                                call(((CHECKER2$semchecker)(CUR$.SL$)).valrelList);
                                                TRACE_END_STM$("CompoundStatement680",680);
                                            }
                                            TRACE_END_STM$("CompoundStatement632",680);
                                        }
                                        case 85: 
                                        case 86: 
                                        case 45: 
                                        case 17: 
                                        case 24: 
                                        case 36: 
                                        // JavaLine 535 ==> SourceLine 687
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement687",687);
                                            if((sos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).IBOOL))) {
                                                // JavaLine 539 ==> SourceLine 688
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement688",688);
                                                    lhb=(((CHECKER1$semchecker1$boolconst)(sos)).ixlo==(((CHECKER2)(CUR$.SL$.SL$)).ITRUE));
                                                    // JavaLine 543 ==> SourceLine 689
                                                    if((copt==(((lhb)?(((CHECKER2)(CUR$.SL$.SL$)).ICOR):(((CHECKER2)(CUR$.SL$.SL$)).ICAND))))) {
                                                        // JavaLine 545 ==> SourceLine 690
                                                        ((CHECKER2$semchecker)(CUR$.SL$)).exptop=sos;
                                                    } else
                                                    // JavaLine 548 ==> SourceLine 691
                                                    if((tos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).IBOOL))) {
                                                        // JavaLine 550 ==> SourceLine 692
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement692",692);
                                                            rhb=(((CHECKER1$semchecker1$boolconst)(tos)).ixlo==(((CHECKER2)(CUR$.SL$.SL$)).ITRUE));
                                                            // JavaLine 554 ==> SourceLine 693
                                                            if(((((((((copt==(((CHECKER2)(CUR$.SL$.SL$)).IAND))&&((lhb&(rhb))))||(((copt==(((CHECKER2)(CUR$.SL$.SL$)).IOR))&&((lhb|(rhb))))))||((((copt==(((CHECKER2)(CUR$.SL$.SL$)).ICAND))|((copt==(((CHECKER2)(CUR$.SL$.SL$)).ICOR))))&(rhb))))||(((copt==(((CHECKER2)(CUR$.SL$.SL$)).IEQV))&&(((lhb) == (rhb))))))||(((copt==(((CHECKER2)(CUR$.SL$.SL$)).IIMP))&&(((!lhb) | rhb)))))) == (lhb))) {
                                                                // JavaLine 556 ==> SourceLine 698
                                                                ((CHECKER2$semchecker)(CUR$.SL$)).exptop=sos;
                                                            } else
                                                            // JavaLine 559 ==> SourceLine 700
                                                            {
                                                                TRACE_BEGIN_STM$("CompoundStatement700",700);
                                                                lhc=((rhb)?(((CHECKER2)(CUR$.SL$.SL$)).IFALS):(((CHECKER2)(CUR$.SL$.SL$)).ITRUE));
                                                                // JavaLine 563 ==> SourceLine 701
                                                                GOTO$(CONX); // GOTO EVALUATED LABEL
                                                                TRACE_END_STM$("CompoundStatement700",701);
                                                            }
                                                            TRACE_END_STM$("CompoundStatement692",701);
                                                        }
                                                    } else
                                                    // JavaLine 570 ==> SourceLine 704
                                                    GOTO$(GEN); // GOTO EVALUATED LABEL
                                                    TRACE_END_STM$("CompoundStatement688",704);
                                                }
                                            } else
                                            // JavaLine 575 ==> SourceLine 719
                                            LABEL$(7); // GEN
                                            // JavaLine 577 ==> SourceLine 705
                                            if(((copt==(((CHECKER2)(CUR$.SL$.SL$)).ICOR))||((copt==(((CHECKER2)(CUR$.SL$.SL$)).ICAND))))) {
                                                // JavaLine 579 ==> SourceLine 706
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement706",706);
                                                    tos=new CHECKER1$semchecker1$ifexp(((CHECKER2$semchecker)(CUR$.SL$)),sos.p$pred,((CHECKER2)(CUR$.SL$.SL$)).IELSE,(((copt==(((CHECKER2)(CUR$.SL$.SL$)).ICAND)))?(tos):(((CHECKER2$semchecker)(CUR$.SL$)).true_const)),(((copt==(((CHECKER2)(CUR$.SL$.SL$)).ICAND)))?(((CHECKER2$semchecker)(CUR$.SL$)).false_const):(tos)),sos).STM$();
                                                    // JavaLine 583 ==> SourceLine 710
                                                    ((CHECKER2$semchecker)(CUR$.SL$)).exptop=new CHECKER1$semchecker1$expinparantes(((CHECKER2$semchecker)(CUR$.SL$)),sos.p$pred,((CHECKER2)(CUR$.SL$.SL$)).IRGPA,null,tos).STM$();
                                                    TRACE_END_STM$("CompoundStatement706",710);
                                                }
                                            } else
                                            // JavaLine 588 ==> SourceLine 711
                                            if((copt==(((CHECKER2)(CUR$.SL$.SL$)).IEQV))) {
                                                // JavaLine 590 ==> SourceLine 712
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement712",712);
                                                    if((tos.type!=(((CHECKER2)(CUR$.SL$.SL$)).IBOOL))) {
                                                        // JavaLine 594 ==> SourceLine 713
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement713",713);
                                                            new ERRMSG$error2xx(((CHECKER2)(CUR$.SL$.SL$)),432,tos.type,((CHECKER2)(CUR$.SL$.SL$)).IEQV);
                                                            tos.type=((CHECKER2)(CUR$.SL$.SL$)).IELSE;
                                                            TRACE_END_STM$("CompoundStatement713",713);
                                                        }
                                                    }
                                                    // JavaLine 602 ==> SourceLine 714
                                                    if((sos.type!=(((CHECKER2)(CUR$.SL$.SL$)).IBOOL))) {
                                                        // JavaLine 604 ==> SourceLine 715
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement715",715);
                                                            new ERRMSG$error2xx(((CHECKER2)(CUR$.SL$.SL$)),431,sos.type,((CHECKER2)(CUR$.SL$.SL$)).IEQV);
                                                            // JavaLine 608 ==> SourceLine 716
                                                            tos.type=sos.type=((CHECKER2)(CUR$.SL$.SL$)).IELSE;
                                                            TRACE_END_STM$("CompoundStatement715",716);
                                                        }
                                                    }
                                                    // JavaLine 613 ==> SourceLine 717
                                                    GOTO$(VALRELX); // GOTO EVALUATED LABEL
                                                    TRACE_END_STM$("CompoundStatement712",717);
                                                }
                                            } else
                                            // JavaLine 618 ==> SourceLine 719
                                            ((CHECKER2$semchecker)(CUR$.SL$)).exptop=new CHECKER1$semchecker1$boolop(((CHECKER2$semchecker)(CUR$.SL$)),sos.p$pred,copt,sos,tos).STM$();
                                            TRACE_END_STM$("CompoundStatement687",719);
                                        }
                                        case 35: 
                                        // JavaLine 623 ==> SourceLine 724
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement724",724);
                                            if((tos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).IBOOL))) {
                                                // JavaLine 627 ==> SourceLine 725
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement725",725);
                                                    lhc=(((((CHECKER1$semchecker1$boolconst)(tos)).ixlo==(((CHECKER2)(CUR$.SL$.SL$)).ITRUE)))?(((CHECKER2)(CUR$.SL$.SL$)).IFALS):(((CHECKER2)(CUR$.SL$.SL$)).ITRUE));
                                                    // JavaLine 631 ==> SourceLine 726
                                                    sos=tos;
                                                    GOTO$(CONX); // GOTO EVALUATED LABEL
                                                    TRACE_END_STM$("CompoundStatement725",726);
                                                }
                                            }
                                            // JavaLine 637 ==> SourceLine 728
                                            if((tos.type!=(((CHECKER2)(CUR$.SL$.SL$)).IBOOL))) {
                                                // JavaLine 639 ==> SourceLine 729
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement729",729);
                                                    new ERRMSG$error2xx(((CHECKER2)(CUR$.SL$.SL$)),432,tos.type,copt);
                                                    // JavaLine 643 ==> SourceLine 730
                                                    tos.type=((CHECKER2)(CUR$.SL$.SL$)).IELSE;
                                                    TRACE_END_STM$("CompoundStatement729",730);
                                                }
                                            }
                                            // JavaLine 648 ==> SourceLine 731
                                            new CHECKER1$semchecker1$valuerel(((CHECKER2$semchecker)(CUR$.SL$)),sos,((CHECKER2)(CUR$.SL$.SL$)).IEQV,tos,((CHECKER2$semchecker)(CUR$.SL$)).false_const).START();
                                            TRACE_END_STM$("CompoundStatement724",731);
                                        }
                                        case 84: 
                                        // JavaLine 653 ==> SourceLine 736
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement736",736);
                                            if((sos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).ITEXT))) {
                                                // JavaLine 657 ==> SourceLine 737
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement737",737);
                                                    if((((CHECKER1$semchecker1$textconst)(sos)).ixhi==(((CHECKER2)(CUR$.SL$.SL$)).NUL))) {
                                                        // JavaLine 661 ==> SourceLine 738
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement738",738);
                                                            tos.p$pred=sos.p$pred;
                                                            GOTO$(popoperator); // GOTO EVALUATED LABEL
                                                            TRACE_END_STM$("CompoundStatement738",738);
                                                        }
                                                    }
                                                    // JavaLine 669 ==> SourceLine 739
                                                    if((tos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).ITEXT))) {
                                                        // JavaLine 671 ==> SourceLine 740
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement740",740);
                                                            if((((CHECKER1$semchecker1$textconst)(tos)).ixhi!=(((CHECKER2)(CUR$.SL$.SL$)).NUL))) {
                                                                // JavaLine 675 ==> SourceLine 742
                                                                {
                                                                    TRACE_BEGIN_STM$("CompoundStatement742",742);
                                                                    ((CHECKER2)(CUR$.SL$.SL$)).simsymbol=CONC(new COMMON$nameof(((CHECKER2)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$textconst)(sos)).ixhi,((CHECKER1$semchecker1$textconst)(sos)).ixlo).RESULT$,new COMMON$nameof(((CHECKER2)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$textconst)(tos)).ixhi,((CHECKER1$semchecker1$textconst)(tos)).ixlo).RESULT$);
                                                                    // JavaLine 679 ==> SourceLine 746
                                                                    new COMMON$DEFCONST(((CHECKER2)(CUR$.SL$.SL$)));
                                                                    // JavaLine 681 ==> SourceLine 747
                                                                    ((CHECKER1$semchecker1$textconst)(sos)).ixhi=((CHECKER2)(CUR$.SL$.SL$)).hashhi;
                                                                    // JavaLine 683 ==> SourceLine 748
                                                                    ((CHECKER1$semchecker1$textconst)(sos)).ixlo=((CHECKER2)(CUR$.SL$.SL$)).hashlo;
                                                                    // JavaLine 685 ==> SourceLine 749
                                                                    ((CHECKER1$semchecker1$textconst)(sos)).type=((CHECKER2)(CUR$.SL$.SL$)).ITEXT;
                                                                    // JavaLine 687 ==> SourceLine 750
                                                                    ((CHECKER1$semchecker1$textconst)(sos)).id=null;
                                                                    TRACE_END_STM$("CompoundStatement742",750);
                                                                }
                                                            }
                                                            // JavaLine 692 ==> SourceLine 752
                                                            ((CHECKER2$semchecker)(CUR$.SL$)).exptop=sos;
                                                            GOTO$(popoperator); // GOTO EVALUATED LABEL
                                                            TRACE_END_STM$("CompoundStatement740",752);
                                                        }
                                                    }
                                                    TRACE_END_STM$("CompoundStatement737",752);
                                                }
                                            }
                                            // JavaLine 701 ==> SourceLine 755
                                            if((tos.ctype==(((CHECKER2)(CUR$.SL$.SL$)).ITEXT))) {
                                                // JavaLine 703 ==> SourceLine 756
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement756",756);
                                                    if((((CHECKER1$semchecker1$textconst)(tos)).ixhi==(((CHECKER2)(CUR$.SL$.SL$)).NUL))) {
                                                        // JavaLine 707 ==> SourceLine 757
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement757",757);
                                                            ((CHECKER2$semchecker)(CUR$.SL$)).exptop=sos;
                                                            GOTO$(popoperator); // GOTO EVALUATED LABEL
                                                            TRACE_END_STM$("CompoundStatement757",757);
                                                        }
                                                    }
                                                    TRACE_END_STM$("CompoundStatement756",757);
                                                }
                                            }
                                            // JavaLine 718 ==> SourceLine 759
                                            if(IS$(sos,CHECKER1$semchecker1$textconc.class)) {
                                                // JavaLine 720 ==> SourceLine 760
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement760",760);
                                                    new CHECKER1$semchecker1$textconc$insert(((CHECKER1$semchecker1$textconc)(sos)));
                                                    // JavaLine 724 ==> SourceLine 761
                                                    ((CHECKER2$semchecker)(CUR$.SL$)).exptop=sos;
                                                    GOTO$(popoperator); // GOTO EVALUATED LABEL
                                                    TRACE_END_STM$("CompoundStatement760",761);
                                                }
                                            }
                                            // JavaLine 730 ==> SourceLine 762
                                            {
                                                // BEGIN INSPECTION 
                                                inspect$762$14=new CHECKER1$semchecker1$textconc(((CHECKER2$semchecker)(CUR$.SL$)),sos.p$pred,((CHECKER2)(CUR$.SL$.SL$)).ICONC).STM$();
                                                if(inspect$762$14!=null) //INSPECT inspect$762$14
                                                // JavaLine 735 ==> SourceLine 763
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement763",763);
                                                    inspect$762$14.first=inspect$762$14.last=new CHECKER1$semchecker1$textoperand(((CHECKER2$semchecker)(CUR$.SL$)),sos).STM$();
                                                    // JavaLine 739 ==> SourceLine 764
                                                    inspect$762$14.type=((CHECKER2)(CUR$.SL$.SL$)).ITEXT;
                                                    inspect$762$14.qual=((CHECKER2$semchecker)(CUR$.SL$)).textclass;
                                                    inspect$762$14.ntext=1;
                                                    new CHECKER1$semchecker1$textconc$insert(inspect$762$14);
                                                    // JavaLine 744 ==> SourceLine 765
                                                    ((CHECKER2$semchecker)(CUR$.SL$)).exptop=((CHECKER1$semchecker1$textconc)inspect$762$14);
                                                    TRACE_END_STM$("CompoundStatement763",765);
                                                }
                                            }
                                            TRACE_END_STM$("CompoundStatement736",765);
                                        }
                                        case 82: 
                                        // JavaLine 752 ==> SourceLine 777
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement777",777);
                                            if((((CHECKER2$semchecker)(CUR$.SL$)).valassList==(null))) {
                                                // JavaLine 756 ==> SourceLine 779
                                                new CHECKER1$semchecker1$valassign(((CHECKER2$semchecker)(CUR$.SL$)),sos.p$pred,((CHECKER2)(CUR$.SL$.SL$)).IASSG,sos,tos).START();
                                            } else
                                            call(((CHECKER2$semchecker)(CUR$.SL$)).valassList);
                                            TRACE_END_STM$("CompoundStatement777",779);
                                        }
                                        case 83: 
                                        // JavaLine 763 ==> SourceLine 783
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement783",783);
                                            if((((CHECKER2$semchecker)(CUR$.SL$)).refassList==(null))) {
                                                // JavaLine 767 ==> SourceLine 785
                                                new CHECKER1$semchecker1$refassign(((CHECKER2$semchecker)(CUR$.SL$)),sos.p$pred,((CHECKER2)(CUR$.SL$.SL$)).IDENO,sos,tos).START();
                                            } else
                                            call(((CHECKER2$semchecker)(CUR$.SL$)).refassList);
                                            TRACE_END_STM$("CompoundStatement783",785);
                                        }
                                        case 51: 
                                        // JavaLine 774 ==> SourceLine 795
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement795",795);
                                            call(((CHECKER2$semchecker)(CUR$.SL$)).constantelt);
                                            TRACE_END_STM$("CompoundStatement795",795);
                                        }
                                        default:
                                        // JavaLine 781 ==> SourceLine 828
                                        new ERRMSG$internerr(((CHECKER2)(CUR$.SL$.SL$)),((char)9),828);
                                    } // END SWITCH STATEMENT
                                    // JavaLine 784 ==> SourceLine 838
                                    LABEL$(8); // popoperator
                                    // JavaLine 786 ==> SourceLine 836
                                    if((((CHECKER2$semchecker)(CUR$.SL$)).opttop>(0))) {
                                        // JavaLine 788 ==> SourceLine 837
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement837",837);
                                            ((CHECKER2$semchecker)(CUR$.SL$)).expexptop.Elt[((CHECKER2$semchecker)(CUR$.SL$)).opttop-((CHECKER2$semchecker)(CUR$.SL$)).expexptop.LB[0]]=null;
                                            ((CHECKER2$semchecker)(CUR$.SL$)).opttop=(((CHECKER2$semchecker)(CUR$.SL$)).opttop-(1));
                                            TRACE_END_STM$("CompoundStatement837",837);
                                        }
                                    } else
                                    // JavaLine 796 ==> SourceLine 838
                                    new ERRMSG$internerr(((CHECKER2)(CUR$.SL$.SL$)),((char)9),838);
                                    // JavaLine 798 ==> SourceLine 839
                                    copt=optstack.Elt[((CHECKER2$semchecker)(CUR$.SL$)).opttop-optstack.LB[0]];
                                    TRACE_END_STM$("CompoundStatement476",839);
                                }
                            }
                            // JavaLine 803 ==> SourceLine 841
                            LABEL$(9); // REPEAT
                            tos=sos=null;
                            // JavaLine 806 ==> SourceLine 843
                            detach();
                            TRACE_END_STM$("CompoundStatement456",843);
                        }
                           if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                    }
                    // JavaLine 812 ==> SourceLine 452
                    if(inner!=null) {
                        inner.STM$();
                        TRACE_BEGIN_STM_AFTER_INNER$("unstack",452);
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
            TRACE_END_STM$("unstack",452);
            EBLK(); // Iff no prefix
        }
    };
} // End of Constructor
// Class Statements
public CHECKER2$semchecker$unstack STM$() { return((CHECKER2$semchecker$unstack)CODE$.EXEC$()); }
public CHECKER2$semchecker$unstack START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Class unstack",1,387,12,609,14,613,16,639,18,646,20,633,22,678,24,705,26,836,28,841,31,390,34,391,37,392,40,393,43,394,47,395,51,397,53,401,55,402,57,512,59,648,61,762,70,397,75,401,80,402,93,452,95,453,97,456,101,473,103,476,108,484,111,488,115,489,120,493,124,495,128,496,130,497,135,501,139,503,143,504,145,505,151,511,158,512,160,513,164,514,167,515,172,517,180,522,184,524,188,525,192,527,194,531,196,532,201,534,203,537,209,538,211,539,214,540,216,541,224,544,226,545,230,546,234,547,240,548,242,549,253,552,258,558,262,559,266,561,268,564,270,565,276,567,281,572,285,574,289,576,291,578,293,579,296,580,306,583,311,588,318,592,325,594,329,596,331,598,333,600,336,601,349,603,355,607,359,608,363,609,368,610,376,611,378,612,382,613,387,614,395,615,401,620,405,621,409,622,413,623,421,624,423,625,427,626,431,627,439,628,447,632,450,680,452,633,454,635,458,637,460,645,462,639,464,646,467,648,472,649,478,650,486,653,488,655,492,658,494,661,496,669,501,671,503,673,507,674,509,675,514,680,516,678,518,680,535,687,539,688,543,689,545,690,548,691,550,692,554,693,556,698,559,700,563,701,570,704,575,719,577,705,579,706,583,710,588,711,590,712,594,713,602,714,604,715,608,716,613,717,618,719,623,724,627,725,631,726,637,728,639,729,643,730,648,731,653,736,657,737,661,738,669,739,671,740,675,742,679,746,681,747,683,748,685,749,687,750,692,752,701,755,703,756,707,757,718,759,720,760,724,761,730,762,735,763,739,764,744,765,752,777,756,779,763,783,767,785,774,795,781,828,784,838,786,836,788,837,796,838,798,839,803,841,806,843,812,452,837,846);
}
