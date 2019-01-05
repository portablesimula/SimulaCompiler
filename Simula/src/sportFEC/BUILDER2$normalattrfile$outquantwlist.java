// JavaLine 1 ==> SourceLine 526
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$normalattrfile$outquantwlist extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=526, lastLine=738, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$quantity p$q;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 721
    final LABQNT$ UTP=new LABQNT$(this,0,1); // Local Label #1=UTP
    // JavaLine 14 ==> SourceLine 715
    final LABQNT$ UTQ=new LABQNT$(this,0,2); // Local Label #2=UTQ
    // JavaLine 16 ==> SourceLine 731
    final LABQNT$ SPECX=new LABQNT$(this,0,3); // Local Label #3=SPECX
    // Declare locals as attributes
    // JavaLine 19 ==> SourceLine 528
    char ch=0;
    char clf=0;
    boolean inrflag=false;
    // JavaLine 23 ==> SourceLine 529
    char quallength=0;
    char idlength=0;
    // JavaLine 26 ==> SourceLine 530
    int k=0;
    int l=0;
    int xtag=0;
    int overload=0;
    // JavaLine 31 ==> SourceLine 531
    int basetag=0;
    TXT$ u=null;
    // JavaLine 34 ==> SourceLine 532
    COMMON$quantity qq=null;
    COMMON$idpack cvis=null;
    // JavaLine 37 ==> SourceLine 534
    COMMON$quantity inspect$534$5=null;
    // JavaLine 39 ==> SourceLine 583
    BUILDER1$visiblegenerator inspect$583$6=null;
    // JavaLine 41 ==> SourceLine 625
    COMMON$extbrecord inspect$625$7=null;
    // JavaLine 43 ==> SourceLine 667
    COMMON$brecord inspect$667$8=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER2$normalattrfile$outquantwlist setPar(Object param) {
        //Util.BREAK("CALL BUILDER2$normalattrfile$outquantwlist.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$q=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER2$normalattrfile$outquantwlist(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER2$normalattrfile$outquantwlist(RTObject$ SL$,COMMON$quantity sp$q) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("outquantwlist",667);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$normalattrfile$outquantwlist STM$() {
        TRACE_BEGIN_STM$("outquantwlist",667);
        BUILDER2$normalattrfile$outquantwlist THIS$=(BUILDER2$normalattrfile$outquantwlist)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 78 ==> SourceLine 534
                {
                    // BEGIN INSPECTION 
                    inspect$534$5=p$q;
                    if(inspect$534$5!=null) //INSPECT inspect$534$5
                    // JavaLine 83 ==> SourceLine 535
                    {
                        TRACE_BEGIN_STM$("CompoundStatement535",535);
                        xtag=(new BUILDER1$exttag(((BUILDER2)(CUR$.SL$.SL$)),((COMMON$quantity)inspect$534$5)).RESULT$+(1));
                        // JavaLine 87 ==> SourceLine 537
                        if((xtag>=(0))) {
                            // JavaLine 89 ==> SourceLine 543
                            {
                                TRACE_BEGIN_STM$("CompoundStatement543",543);
                                if(((inspect$534$5.prefqual!=(null))&&(((inspect$534$5.kind!=(((BUILDER2)(CUR$.SL$.SL$)).K_class))||((inspect$534$5.plev>(((BUILDER2)(CUR$.SL$.SL$)).one))))))) {
                                    // JavaLine 93 ==> SourceLine 544
                                    quallength=char$((TXT$.length(inspect$534$5.prefqual.symb.symbol)+(1)));
                                }
                                // JavaLine 96 ==> SourceLine 546
                                if(((inspect$534$5.encl.kind==(((BUILDER2)(CUR$.SL$.SL$)).K_proc))&&((inspect$534$5.categ<(((BUILDER2)(CUR$.SL$.SL$)).C_local))))) {
                                } else
                                // JavaLine 99 ==> SourceLine 548
                                idlength=char$((((((inspect$534$5.kind!=(((BUILDER2)(CUR$.SL$.SL$)).K_class))&&((loadChar(inspect$534$5.symb.symbol,1)!=('_'))))&&((loadChar(inspect$534$5.symb.symbol,0)==('_')))))?(1):((TXT$.length(inspect$534$5.symb.symbol)+(1)))));
                                // JavaLine 101 ==> SourceLine 556
                                if((((((BUILDER2$normalattrfile)(CUR$.SL$)).p+(rank(idlength)))+(rank(quallength)))>((((BUILDER2$normalattrfile)(CUR$.SL$)).bufmax-(5))))) {
                                    // JavaLine 103 ==> SourceLine 557
                                    new BUILDER2$normalattrfile$swapObuffer(((BUILDER2$normalattrfile)(CUR$.SL$)));
                                }
                                // JavaLine 106 ==> SourceLine 561
                                new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),char$(((rank(inspect$534$5.kind)*(8))+(rank(inspect$534$5.categ)))));
                                // JavaLine 108 ==> SourceLine 564
                                if((quallength!=(((BUILDER2)(CUR$.SL$.SL$)).NUL))) {
                                    // JavaLine 110 ==> SourceLine 565
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement565",565);
                                        new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),char$((rank(inspect$534$5.type)+(128))));
                                        // JavaLine 114 ==> SourceLine 567
                                        new BUILDER2$normalattrfile$puttext(((BUILDER2$normalattrfile)(CUR$.SL$)),inspect$534$5.prefqual.symb.symbol);
                                        TRACE_END_STM$("CompoundStatement565",567);
                                    }
                                } else
                                new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),inspect$534$5.type);
                                // JavaLine 120 ==> SourceLine 571
                                if(((((BUILDER2$normalattrfile)(CUR$.SL$)).sysattrfile&&((inspect$534$5.categ!=(((BUILDER2)(CUR$.SL$.SL$)).C_virt))))&&((inspect$534$5.categ!=(((BUILDER2)(CUR$.SL$.SL$)).C_extnal))))) {
                                    // JavaLine 122 ==> SourceLine 574
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement574",574);
                                        ((BUILDER2)(CUR$.SL$.SL$)).permt=new COMMON$nameof(((BUILDER2)(CUR$.SL$.SL$)),char$((inspect$534$5.virtno/(256))),char$(rem(inspect$534$5.virtno,256))).RESULT$;
                                        // JavaLine 126 ==> SourceLine 575
                                        TXT$.setpos(((BUILDER2)(CUR$.SL$.SL$)).permt,1);
                                        // JavaLine 128 ==> SourceLine 576
                                        clf=TXT$.getchar(((BUILDER2)(CUR$.SL$.SL$)).permt);
                                        // JavaLine 130 ==> SourceLine 577
                                        if((idlength==(((BUILDER2)(CUR$.SL$.SL$)).NUL))) {
                                            // JavaLine 132 ==> SourceLine 578
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement578",578);
                                                new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),char$((rank(clf)+(128))));
                                                GOTO$(SPECX); // GOTO EVALUATED LABEL
                                                TRACE_END_STM$("CompoundStatement578",578);
                                            }
                                        }
                                        // JavaLine 140 ==> SourceLine 579
                                        k=TXT$.getint(new COMMON$attrfile$nextitemoft(((BUILDER2$normalattrfile)(CUR$.SL$))).RESULT$);
                                        // JavaLine 142 ==> SourceLine 580
                                        if((k<(0))) {
                                            // JavaLine 144 ==> SourceLine 581
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement581",581);
                                                overload=(-(k));
                                                k=TXT$.getint(new COMMON$attrfile$nextitemoft(((BUILDER2$normalattrfile)(CUR$.SL$))).RESULT$);
                                                TRACE_END_STM$("CompoundStatement581",581);
                                            }
                                        }
                                        // JavaLine 152 ==> SourceLine 582
                                        if((k==(3))) {
                                            inrflag=true;
                                        }
                                        // JavaLine 156 ==> SourceLine 583
                                        {
                                            // BEGIN INSPECTION 
                                            inspect$583$6=((BUILDER1$visiblegenerator)(((BUILDER2)(CUR$.SL$.SL$)).coder));
                                            if(inspect$583$6!=null) //INSPECT inspect$583$6
                                            // JavaLine 161 ==> SourceLine 584
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement584",584);
                                                if((k>(0))) {
                                                    // JavaLine 165 ==> SourceLine 585
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement585",585);
                                                        u=lowcase(new COMMON$attrfile$nextitemoft(((BUILDER2$normalattrfile)(CUR$.SL$))).RESULT$);
                                                        // JavaLine 169 ==> SourceLine 586
                                                        l=((TXTREL$EQ(u,new TXT$("rt")))?(1):(((TXTREL$EQ(u,new TXT$("knwn")))?(2):(((TXTREL$EQ(u,new TXT$("cent")))?(3):(((TXTREL$EQ(u,new TXT$("cint")))?(4):(((TXTREL$EQ(u,new TXT$("arr")))?(5):(((TXTREL$EQ(u,new TXT$("fil")))?(6):(((TXTREL$EQ(u,new TXT$("edit")))?(7):(((TXTREL$EQ(u,new TXT$("form")))?(8):(((TXTREL$EQ(u,new TXT$("libr")))?(9):(((TXTREL$EQ(u,new TXT$("smst")))?(10):(((TXTREL$EQ(u,new TXT$("sml")))?(11):(((TXTREL$EQ(u,new TXT$("mntr")))?(12):(10000))))))))))))))))))))))));
                                                        // JavaLine 171 ==> SourceLine 599
                                                        basetag=inspect$583$6.moduletab.Elt[l-inspect$583$6.moduletab.LB[0]].p$basetag;
                                                        // JavaLine 173 ==> SourceLine 600
                                                        xtag=((basetag+(TXT$.getint(new COMMON$attrfile$nextitemoft(((BUILDER2$normalattrfile)(CUR$.SL$))).RESULT$)))+(1));
                                                        TRACE_END_STM$("CompoundStatement585",600);
                                                    }
                                                } else
                                                // JavaLine 178 ==> SourceLine 601
                                                xtag=1;
                                                TRACE_END_STM$("CompoundStatement584",601);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement574",601);
                                    }
                                } else
                                // JavaLine 186 ==> SourceLine 604
                                clf=((IS$(((COMMON$quantity)inspect$534$5),COMMON$extquantity.class))?(((COMMON$extquantity)(((COMMON$quantity)inspect$534$5))).clf):(((BUILDER2)(CUR$.SL$.SL$)).Clf000));
                                // JavaLine 188 ==> SourceLine 606
                                if((idlength==(((BUILDER2)(CUR$.SL$.SL$)).NUL))) {
                                    // JavaLine 190 ==> SourceLine 607
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement607",607);
                                        new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),char$((rank(clf)+(128))));
                                        new BUILDER2$normalattrfile$putNumber(((BUILDER2$normalattrfile)(CUR$.SL$)),xtag);
                                        // JavaLine 195 ==> SourceLine 608
                                        GOTO$(SPECX); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement607",608);
                                    }
                                }
                                // JavaLine 200 ==> SourceLine 609
                                new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),clf);
                                new BUILDER2$normalattrfile$putNumber(((BUILDER2$normalattrfile)(CUR$.SL$)),xtag);
                                // JavaLine 203 ==> SourceLine 611
                                if((idlength==(((char)1)))) {
                                    // JavaLine 205 ==> SourceLine 612
                                    new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2)(CUR$.SL$.SL$)).NUL);
                                } else
                                new BUILDER2$normalattrfile$puttext(((BUILDER2$normalattrfile)(CUR$.SL$)),inspect$534$5.symb.symbol);
                                // JavaLine 209 ==> SourceLine 615
                                if((overload!=(0))) {
                                    // JavaLine 211 ==> SourceLine 616
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement616",616);
                                        new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).overMark);
                                        new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),char$(overload));
                                        TRACE_END_STM$("CompoundStatement616",616);
                                    }
                                }
                                // JavaLine 219 ==> SourceLine 618
                                if((inspect$534$5.protect!=(((char)0)))) {
                                    // JavaLine 221 ==> SourceLine 619
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement619",619);
                                        new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).protMark);
                                        new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),inspect$534$5.protect);
                                        TRACE_END_STM$("CompoundStatement619",619);
                                    }
                                }
                                // JavaLine 229 ==> SourceLine 621
                                if((inspect$534$5.categ==(((BUILDER2)(CUR$.SL$.SL$)).C_extnal))) {
                                    // JavaLine 231 ==> SourceLine 622
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement622",622);
                                        if(IS$(inspect$534$5.descr,COMMON$extbrecord.class)) {
                                            // JavaLine 235 ==> SourceLine 623
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement623",623);
                                                new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).xMark);
                                                // JavaLine 239 ==> SourceLine 625
                                                {
                                                    // BEGIN INSPECTION 
                                                    inspect$625$7=((COMMON$extbrecord)(inspect$534$5.descr));
                                                    if(inspect$625$7!=null) //INSPECT inspect$625$7
                                                    // JavaLine 244 ==> SourceLine 626
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement626",626);
                                                        new BUILDER2$normalattrfile$putstring(((BUILDER2$normalattrfile)(CUR$.SL$)),inspect$625$7.modulhi,inspect$625$7.modullo);
                                                        // JavaLine 248 ==> SourceLine 627
                                                        new BUILDER2$normalattrfile$putstring(((BUILDER2$normalattrfile)(CUR$.SL$)),inspect$625$7.checkhi,inspect$625$7.checklo);
                                                        TRACE_END_STM$("CompoundStatement626",627);
                                                    }
                                                }
                                                TRACE_END_STM$("CompoundStatement623",627);
                                            }
                                        } else
                                        // JavaLine 256 ==> SourceLine 629
                                        new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).yMark);
                                        // JavaLine 258 ==> SourceLine 631
                                        new BUILDER2$normalattrfile$putstring(((BUILDER2$normalattrfile)(CUR$.SL$)),char$((inspect$534$5.dim/(256))),char$(rem(inspect$534$5.dim,256)));
                                        // JavaLine 260 ==> SourceLine 632
                                        new BUILDER2$normalattrfile$putstring(((BUILDER2$normalattrfile)(CUR$.SL$)),char$((inspect$534$5.virtno/(256))),char$(rem(inspect$534$5.virtno,256)));
                                        TRACE_END_STM$("CompoundStatement622",632);
                                    }
                                } else
                                // JavaLine 265 ==> SourceLine 635
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement635",635);
                                    if(((inspect$534$5.encl!=(null))&&(((inspect$534$5.categ!=(((BUILDER2)(CUR$.SL$.SL$)).C_local))||(((inspect$534$5.match!=(null))&&((inspect$534$5.match.categ==(((BUILDER2)(CUR$.SL$.SL$)).C_virt))))))))) {
                                        // JavaLine 269 ==> SourceLine 638
                                        new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).forcMark);
                                    }
                                    // JavaLine 272 ==> SourceLine 640
                                    if((inspect$534$5.dim>(0))) {
                                        // JavaLine 274 ==> SourceLine 641
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement641",641);
                                            new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).dimMark);
                                            new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),char$(inspect$534$5.dim));
                                            TRACE_END_STM$("CompoundStatement641",641);
                                        }
                                    }
                                    TRACE_END_STM$("CompoundStatement635",641);
                                }
                                // JavaLine 284 ==> SourceLine 644
                                if(((inspect$534$5.special!=(((BUILDER2)(CUR$.SL$.SL$)).NUL))||((inspect$534$5.kind==(((BUILDER2)(CUR$.SL$.SL$)).K_rep))))) {
                                    // JavaLine 286 ==> SourceLine 648
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement648",648);
                                        new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).specMark);
                                        // JavaLine 290 ==> SourceLine 649
                                        if((inspect$534$5.kind==(((BUILDER2)(CUR$.SL$.SL$)).K_rep))) {
                                            // JavaLine 292 ==> SourceLine 650
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement650",650);
                                                new BUILDER2$normalattrfile$putNumber(((BUILDER2$normalattrfile)(CUR$.SL$)),inspect$534$5.descr.line1);
                                                // JavaLine 296 ==> SourceLine 651
                                                new BUILDER2$normalattrfile$putNumber(((BUILDER2$normalattrfile)(CUR$.SL$)),inspect$534$5.descr.npar);
                                                TRACE_END_STM$("CompoundStatement650",651);
                                            }
                                        } else
                                        // JavaLine 301 ==> SourceLine 653
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement653",653);
                                            if((inspect$534$5.descr.blnohi!=(((BUILDER2)(CUR$.SL$.SL$)).NUL))) {
                                                // JavaLine 305 ==> SourceLine 655
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement655",655);
                                                    new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),inspect$534$5.special);
                                                    // JavaLine 309 ==> SourceLine 657
                                                    new BUILDER2$normalattrfile$putstring(((BUILDER2$normalattrfile)(CUR$.SL$)),inspect$534$5.descr.blnohi,inspect$534$5.descr.blnolo);
                                                    TRACE_END_STM$("CompoundStatement655",657);
                                                }
                                            } else
                                            // JavaLine 314 ==> SourceLine 658
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement658",658);
                                                new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),char$((rank(inspect$534$5.special)+(128))));
                                                // JavaLine 318 ==> SourceLine 659
                                                new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),inspect$534$5.descr.blnolo);
                                                TRACE_END_STM$("CompoundStatement658",659);
                                            }
                                            TRACE_END_STM$("CompoundStatement653",659);
                                        }
                                        // JavaLine 324 ==> SourceLine 662
                                        GOTO$(SPECX); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement648",662);
                                    }
                                }
                                // JavaLine 329 ==> SourceLine 665
                                if((!(((BUILDER2$normalattrfile)(CUR$.SL$)).sysattrfile))) {
                                    // JavaLine 331 ==> SourceLine 667
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement667",667);
                                        {
                                            // BEGIN INSPECTION 
                                            inspect$667$8=inspect$534$5.descr;
                                            if(inspect$667$8!=null) //INSPECT inspect$667$8
                                            // JavaLine 338 ==> SourceLine 668
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement668",668);
                                                if((inspect$667$8.connests!=(((BUILDER2)(CUR$.SL$.SL$)).zero))) {
                                                    // JavaLine 342 ==> SourceLine 669
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement669",669);
                                                        new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).nestMark);
                                                        // JavaLine 346 ==> SourceLine 670
                                                        new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),char$(inspect$667$8.connests));
                                                        TRACE_END_STM$("CompoundStatement669",670);
                                                    }
                                                }
                                                // JavaLine 351 ==> SourceLine 673
                                                if(inspect$667$8.thisused) {
                                                    k=64;
                                                } else
                                                k=0;
                                                // JavaLine 356 ==> SourceLine 674
                                                if(inspect$667$8.hasCode) {
                                                    k=(k+(32));
                                                }
                                                // JavaLine 360 ==> SourceLine 676
                                                if((inspect$667$8.inrtag!=(((BUILDER2)(CUR$.SL$.SL$)).NUL))) {
                                                    k=(k+(2));
                                                }
                                                // JavaLine 364 ==> SourceLine 677
                                                if((k!=(0))) {
                                                    // JavaLine 366 ==> SourceLine 678
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement678",678);
                                                        new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).thisMark);
                                                        new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),char$(k));
                                                        TRACE_END_STM$("CompoundStatement678",678);
                                                    }
                                                }
                                                TRACE_END_STM$("CompoundStatement668",678);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement667",678);
                                    }
                                } else
                                // JavaLine 380 ==> SourceLine 681
                                if((((clf==(((BUILDER2)(CUR$.SL$.SL$)).Clf004))||((clf==(((BUILDER2)(CUR$.SL$.SL$)).Clf009))))&&(inrflag))) {
                                    // JavaLine 382 ==> SourceLine 683
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement683",683);
                                        new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).thisMark);
                                        new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((char)2));
                                        TRACE_END_STM$("CompoundStatement683",683);
                                    }
                                }
                                // JavaLine 390 ==> SourceLine 685
                                if(IS$(inspect$534$5.descr,COMMON$brecord.class)) {
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement685",685);
                                        if((inspect$534$5.special==(((BUILDER2)(CUR$.SL$.SL$)).NUL))) {
                                            // JavaLine 395 ==> SourceLine 686
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement686",686);
                                                if((inspect$534$5.descr.kind==(((BUILDER2)(CUR$.SL$.SL$)).K_class))) {
                                                    // JavaLine 399 ==> SourceLine 687
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement687",687);
                                                        cvis=inspect$534$5.descr.hidlist;
                                                        // JavaLine 403 ==> SourceLine 688
                                                        while((cvis!=(null))) {
                                                            // JavaLine 405 ==> SourceLine 689
                                                            {
                                                                TRACE_BEGIN_STM$("CompoundStatement689",689);
                                                                if((cvis.line>(0))) {
                                                                    // JavaLine 409 ==> SourceLine 690
                                                                    {
                                                                        TRACE_BEGIN_STM$("CompoundStatement690",690);
                                                                        new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).hidMark);
                                                                        // JavaLine 413 ==> SourceLine 691
                                                                        new BUILDER2$normalattrfile$putstring(((BUILDER2$normalattrfile)(CUR$.SL$)),cvis.idhi,cvis.idlo);
                                                                        TRACE_END_STM$("CompoundStatement690",691);
                                                                    }
                                                                }
                                                                // JavaLine 418 ==> SourceLine 693
                                                                cvis=cvis.next;
                                                                TRACE_END_STM$("CompoundStatement689",693);
                                                            }
                                                        }
                                                        TRACE_END_STM$("CompoundStatement687",693);
                                                    }
                                                }
                                                // JavaLine 426 ==> SourceLine 698
                                                l=k=0;
                                                // JavaLine 428 ==> SourceLine 699
                                                if(((inspect$534$5.categ==(((BUILDER2)(CUR$.SL$.SL$)).C_virt))&&((inspect$534$5.kind==(((BUILDER2)(CUR$.SL$.SL$)).K_proc))))) {
                                                    // JavaLine 430 ==> SourceLine 702
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement702",702);
                                                        qq=inspect$534$5.descr.fpar;
                                                        // JavaLine 434 ==> SourceLine 703
                                                        if((qq!=(null))) {
                                                            {
                                                                TRACE_BEGIN_STM$("CompoundStatement703",703);
                                                                k=1;
                                                                GOTO$(UTP); // GOTO EVALUATED LABEL
                                                                TRACE_END_STM$("CompoundStatement703",703);
                                                            }
                                                        }
                                                        // JavaLine 443 ==> SourceLine 705
                                                        new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).begList);
                                                        l=1;
                                                        TRACE_END_STM$("CompoundStatement702",705);
                                                    }
                                                } else
                                                // JavaLine 449 ==> SourceLine 714
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement714",714);
                                                    qq=inspect$534$5.descr.favirt;
                                                    // JavaLine 453 ==> SourceLine 726
                                                    LABEL$(2); // UTQ
                                                    // JavaLine 455 ==> SourceLine 715
                                                    while((qq!=(null))) {
                                                        // JavaLine 457 ==> SourceLine 716
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement716",716);
                                                            if((((k==(0)))?((qq.dim>(0))):(((IS$(qq.descr,COMMON$extbrecord.class))?((((COMMON$extbrecord)(qq.descr)).status==('S'))):(true))))) {
                                                                // JavaLine 461 ==> SourceLine 721
                                                                {
                                                                    TRACE_BEGIN_STM$("CompoundStatement721",721);
                                                                    // JavaLine 464 ==> SourceLine 722
                                                                    LABEL$(1); // UTP
                                                                    // JavaLine 466 ==> SourceLine 721
                                                                    if((l==(0))) {
                                                                        // JavaLine 468 ==> SourceLine 722
                                                                        {
                                                                            TRACE_BEGIN_STM$("CompoundStatement722",722);
                                                                            new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).begList);
                                                                            l=1;
                                                                            TRACE_END_STM$("CompoundStatement722",722);
                                                                        }
                                                                    }
                                                                    // JavaLine 476 ==> SourceLine 723
                                                                    new BUILDER2$normalattrfile$outquantwlist(((BUILDER2$normalattrfile)(CUR$.SL$)),qq);
                                                                    TRACE_END_STM$("CompoundStatement721",723);
                                                                }
                                                            }
                                                            // JavaLine 481 ==> SourceLine 725
                                                            if((qq!=(null))) {
                                                                qq=((COMMON$quantity)(qq.next));
                                                            }
                                                            TRACE_END_STM$("CompoundStatement716",725);
                                                        }
                                                    }
                                                    // JavaLine 488 ==> SourceLine 727
                                                    if((k==(0))) {
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement727",727);
                                                            qq=inspect$534$5.descr.fpar;
                                                            k=1;
                                                            GOTO$(UTQ); // GOTO EVALUATED LABEL
                                                            TRACE_END_STM$("CompoundStatement727",727);
                                                        }
                                                    }
                                                    TRACE_END_STM$("CompoundStatement714",727);
                                                }
                                                // JavaLine 500 ==> SourceLine 729
                                                if((l!=(0))) {
                                                    new BUILDER2$normalattrfile$storebyte(((BUILDER2$normalattrfile)(CUR$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).endlist);
                                                }
                                                TRACE_END_STM$("CompoundStatement686",729);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement685",729);
                                    }
                                }
                                // JavaLine 510 ==> SourceLine 731
                                LABEL$(3); // SPECX
                                TRACE_END_STM$("CompoundStatement543",731);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement535",731);
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
        TRACE_END_STM$("outquantwlist",731);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure outquantwlist",1,526,12,721,14,715,16,731,19,528,23,529,26,530,31,531,34,532,37,534,39,583,41,625,43,667,78,534,83,535,87,537,89,543,93,544,96,546,99,548,101,556,103,557,106,561,108,564,110,565,114,567,120,571,122,574,126,575,128,576,130,577,132,578,140,579,142,580,144,581,152,582,156,583,161,584,165,585,169,586,171,599,173,600,178,601,186,604,188,606,190,607,195,608,200,609,203,611,205,612,209,615,211,616,219,618,221,619,229,621,231,622,235,623,239,625,244,626,248,627,256,629,258,631,260,632,265,635,269,638,272,640,274,641,284,644,286,648,290,649,292,650,296,651,301,653,305,655,309,657,314,658,318,659,324,662,329,665,331,667,338,668,342,669,346,670,351,673,356,674,360,676,364,677,366,678,380,681,382,683,390,685,395,686,399,687,403,688,405,689,409,690,413,691,418,693,426,698,428,699,430,702,434,703,443,705,449,714,453,726,455,715,457,716,461,721,464,722,466,721,468,722,476,723,481,725,488,727,500,729,510,731,534,738);
}
