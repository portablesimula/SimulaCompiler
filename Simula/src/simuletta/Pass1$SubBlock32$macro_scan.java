// JavaLine 1 <== SourceLine 560
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Pass1$SubBlock32$macro_scan extends FILE$ {
    // ClassDeclaration: Kind=Class, BlockLevel=3, PrefixLevel=1, firstLine=560, lastLine=649, hasLocalClasses=false, System=false, detachUsed=true
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public Common$macro p1$mac;
    // Declare local labels
    // JavaLine 12 <== SourceLine 571
    final LABQNT$ INIT=new LABQNT$(this,1,"INIT"); // Local Label #1=INIT
    // JavaLine 14 <== SourceLine 580
    final LABQNT$ NXTPAR=new LABQNT$(this,2,"NXTPAR"); // Local Label #2=NXTPAR
    // JavaLine 16 <== SourceLine 605
    final LABQNT$ SWAP=new LABQNT$(this,3,"SWAP"); // Local Label #3=SWAP
    // JavaLine 18 <== SourceLine 611
    final LABQNT$ PARA=new LABQNT$(this,4,"PARA"); // Local Label #4=PARA
    // JavaLine 20 <== SourceLine 640
    final LABQNT$ SYNCH=new LABQNT$(this,5,"SYNCH"); // Local Label #5=SYNCH
    // JavaLine 22 <== SourceLine 643
    final LABQNT$ QUIT=new LABQNT$(this,6,"QUIT"); // Local Label #6=QUIT
    // Declare locals as attributes
    // JavaLine 25 <== SourceLine 562
    public int paramcount$1=0;
    public int bracecount$1=0;
    public int n$1=0;
    // JavaLine 29 <== SourceLine 563
    public boolean mpercent$1=false;
    // JavaLine 31 <== SourceLine 564
    public Link$ save$1=null;
    public Link$ symb$1=null;
    public Common$macro_symbol mSymb$1=null;
    // JavaLine 35 <== SourceLine 565
    public FILE$ prev$1=null;
    // JavaLine 37 <== SourceLine 566
    public ARRAY$<Head$[]>par=null;
    // JavaLine 39 <== SourceLine 567
    public Head$ curpar$1=null;
    // JavaLine 41 <== SourceLine 622
    public Linkage$ inspect$621$77$1=null;
    // JavaLine 43 <== SourceLine 630
    public PrintFile$ inspect$630$78$1=null;
    // JavaLine 45 <== SourceLine 644
    public PrintFile$ inspect$644$79$1=null;
    // Normal Constructor
    public Pass1$SubBlock32$macro_scan(RTObject$ staticLink,TXT$ sFILENAME$,Common$macro sp1$mac) {
        super(staticLink,sFILENAME$);
        // Parameter assignment to locals
        this.p1$mac = sp1$mac;
        // Declaration Code
        // JavaLine 53 <== SourceLine 566
        int[] par$LB=new int[1]; int[] par$UB=new int[1];
        par$LB[0]=0; par$UB[0]=p1$mac.p3$npar;
        BOUND_CHECK$(par$LB[0],par$UB[0]);
        par=new ARRAY$<Head$[]>(new Head$[par$UB[0]-par$LB[0]+1],par$LB,par$UB);
    }
    // Class Statements
    public Pass1$SubBlock32$macro_scan STM$() {
        Pass1$SubBlock32$macro_scan THIS$=(Pass1$SubBlock32$macro_scan)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // Class FILE: Code before inner
                // JavaLine 66 <== SourceLine 569
                // Class macro_scan: Code before inner
                p1$mac.msc$3=((FILE$)(CUR$));
                ;
                // JavaLine 70 <== SourceLine 571
                LABEL$(1,"INIT");
                prev$1=((Pass1$SubBlock32)(CUR$.SL$)).parser;
                ;
                ((Pass1$SubBlock32)(CUR$.SL$)).parser=((FILE$)(CUR$));
                ;
                // JavaLine 76 <== SourceLine 572
                symb$1=p1$mac.first();
                ;
                paramcount$1=p1$mac.p3$npar;
                ;
                // JavaLine 81 <== SourceLine 573
                detach();
                ;
                // JavaLine 84 <== SourceLine 574
                if(VALUE$((paramcount$1>(0)))) {
                    // JavaLine 86 <== SourceLine 575
                    {
                        while((paramcount$1!=(0))) {
                            // JavaLine 89 <== SourceLine 576
                            {
                                par.Elt[paramcount$1-par.LB[0]]=new Head$(((Pass1)(CUR$.SL$.SL$)).inspect$28$62).STM$();
                                ;
                                paramcount$1=Math.subtractExact(paramcount$1,1);
                                ;
                            }
                        }
                        ;
                        // JavaLine 98 <== SourceLine 578
                        detach();
                        ;
                        // JavaLine 101 <== SourceLine 579
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                            new Common$ERROR(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,new TXT$("Expected ( in macro call"));
                        }
                        ;
                        // JavaLine 106 <== SourceLine 580
                        LABEL$(2,"NXTPAR");
                        detach();
                        ;
                        // JavaLine 110 <== SourceLine 581
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_PERCENT$1)))) {
                            // JavaLine 112 <== SourceLine 582
                            {
                                mpercent$1=true;
                                ;
                                detach();
                            }
                        }
                        ;
                        // JavaLine 120 <== SourceLine 583
                        paramcount$1=Math.addExact(paramcount$1,1);
                        ;
                        // JavaLine 123 <== SourceLine 584
                        if(VALUE$((paramcount$1>(p1$mac.p3$npar)))) {
                            curpar$1=new Head$(((Pass1)(CUR$.SL$.SL$)).inspect$28$62).STM$();
                        } else
                        // JavaLine 127 <== SourceLine 585
                        curpar$1=par.Elt[paramcount$1-par.LB[0]];
                        ;
                        // JavaLine 130 <== SourceLine 586
                        while(true) {
                            // JavaLine 132 <== SourceLine 587
                            {
                                if(VALUE$(mpercent$1)) {
                                    // JavaLine 135 <== SourceLine 588
                                    {
                                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_PERCENT$1)))) {
                                            // JavaLine 138 <== SourceLine 589
                                            {
                                                mpercent$1=false;
                                                ;
                                                detach();
                                                ;
                                                // JavaLine 144 <== SourceLine 590
                                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_COMMA$1)))) {
                                                    GOTO$(NXTPAR); // GOTO EVALUATED LABEL
                                                }
                                                ;
                                                // JavaLine 149 <== SourceLine 591
                                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                                                    new Common$ERROR(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,new TXT$("Expected )"));
                                                }
                                                ;
                                                // JavaLine 154 <== SourceLine 592
                                                GOTO$(SWAP); // GOTO EVALUATED LABEL
                                                ;
                                            }
                                        }
                                    }
                                } else
                                // JavaLine 161 <== SourceLine 595
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_COMMA$1)))) {
                                    // JavaLine 163 <== SourceLine 596
                                    GOTO$(NXTPAR); // GOTO EVALUATED LABEL
                                } else
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                                    bracecount$1=Math.addExact(bracecount$1,1);
                                } else
                                // JavaLine 169 <== SourceLine 597
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                                    // JavaLine 171 <== SourceLine 598
                                    {
                                        if(VALUE$((bracecount$1>(0)))) {
                                            bracecount$1=Math.subtractExact(bracecount$1,1);
                                        } else
                                        // JavaLine 176 <== SourceLine 599
                                        GOTO$(SWAP); // GOTO EVALUATED LABEL
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 182 <== SourceLine 601
                                new Common$macro_symbol(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,((Pass1$SubBlock32)(CUR$.SL$)).symbol,((Pass1)(CUR$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$)).inspect$28$62.symtab.LB[0]],copy(((Pass1$SubBlock32)(CUR$.SL$)).curval)).STM$().into(curpar$1);
                                ;
                                // JavaLine 185 <== SourceLine 602
                                detach();
                                ;
                            }
                            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                        }
                        ;
                    }
                }
                ;
                // JavaLine 195 <== SourceLine 606
                LABEL$(3,"SWAP");
                // JavaLine 197 <== SourceLine 605
                if(VALUE$((paramcount$1>(p1$mac.p3$npar)))) {
                    // JavaLine 199 <== SourceLine 606
                    new Common$ERROR(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,new TXT$("Too many macro parameters"));
                }
                ;
                // JavaLine 203 <== SourceLine 607
                curpar$1=null;
                ;
                // JavaLine 206 <== SourceLine 608
                ((Pass1$SubBlock32)(CUR$.SL$)).parser=prev$1;
                ;
                prev$1=((Pass1$SubBlock32)(CUR$.SL$)).scanner;
                ;
                ((Pass1$SubBlock32)(CUR$.SL$)).scanner=((FILE$)(CUR$));
                ;
                // JavaLine 213 <== SourceLine 609
                while(true) {
                    // JavaLine 215 <== SourceLine 610
                    {
                        ((Pass1$SubBlock32)(CUR$.SL$)).curval=null;
                        ;
                        ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.hash$1=0;
                        ;
                        // JavaLine 221 <== SourceLine 614
                        LABEL$(4,"PARA");
                        // JavaLine 223 <== SourceLine 611
                        if(VALUE$(IS$(symb$1,Common$macro_param.class))) {
                            // JavaLine 225 <== SourceLine 612
                            {
                                save$1=symb$1.suc();
                                ;
                                n$1=((Common$macro_param)(symb$1)).p2$n;
                                ;
                                // JavaLine 231 <== SourceLine 613
                                symb$1=(((par.Elt[n$1-par.LB[0]]!=(null)))?(par.Elt[n$1-par.LB[0]].first()):(null));
                                ;
                            }
                        }
                        ;
                        // JavaLine 237 <== SourceLine 615
                        if(VALUE$((symb$1==(null)))) {
                            // JavaLine 239 <== SourceLine 616
                            {
                                if(VALUE$((save$1==(null)))) {
                                    GOTO$(QUIT); // GOTO EVALUATED LABEL
                                }
                                ;
                                // JavaLine 245 <== SourceLine 617
                                symb$1=save$1;
                                ;
                                save$1=null;
                                ;
                                GOTO$(PARA); // GOTO EVALUATED LABEL
                                ;
                            }
                        }
                        ;
                        // JavaLine 255 <== SourceLine 619
                        if(VALUE$((symb$1!=(null)))) {
                            // JavaLine 257 <== SourceLine 620
                            {
                                mSymb$1=((Common$macro_symbol)(symb$1));
                                ;
                                symb$1=symb$1.suc();
                                ;
                                // JavaLine 263 <== SourceLine 621
                                {
                                    // BEGIN INSPECTION 
                                    inspect$621$77$1=mSymb$1.p2$box.curmeaning;
                                    //INSPECT inspect$621$77
                                    if(inspect$621$77$1 instanceof Common$macro) // WHEN Common$macro DO 
                                    // JavaLine 269 <== SourceLine 623
                                    {
                                        if(VALUE$((((Common$macro)(inspect$621$77$1)).msc$3!=(null)))) {
                                            // JavaLine 272 <== SourceLine 624
                                            call(((Common$macro)(inspect$621$77$1)).msc$3);
                                        } else
                                        new Pass1$SubBlock32$macro_scan(((Pass1$SubBlock32)(CUR$.SL$)),new TXT$("***macro***"),((Common$macro)inspect$621$77$1)).START$();
                                        ;
                                        // JavaLine 277 <== SourceLine 625
                                        GOTO$(SYNCH); // GOTO EVALUATED LABEL
                                    }
                                    else if(inspect$621$77$1 instanceof Common$mnemonic) // WHEN Common$mnemonic DO 
                                    // JavaLine 281 <== SourceLine 626
                                    mSymb$1=((Common$macro_symbol)(((Common$mnemonic)inspect$621$77$1).first()));
                                }
                                ;
                                // JavaLine 285 <== SourceLine 627
                                ((Pass1$SubBlock32)(CUR$.SL$)).symbol=mSymb$1.p2$s;
                                ;
                                ((Pass1$SubBlock32)(CUR$.SL$)).curval=mSymb$1.p2$v;
                                ;
                                // JavaLine 290 <== SourceLine 628
                                ((Pass1)(CUR$.SL$.SL$)).inspect$28$62.hash$1=mSymb$1.p2$box.id;
                                ;
                            }
                        }
                        ;
                        // JavaLine 296 <== SourceLine 630
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).input_trace>(1)))) {
                            {
                                // BEGIN INSPECTION 
                                inspect$630$78$1=sysout();
                                if(inspect$630$78$1!=null) // INSPECT inspect$630$78
                                // JavaLine 302 <== SourceLine 631
                                {
                                    inspect$630$78$1.outtext(new TXT$("Line"));
                                    ;
                                    inspect$630$78$1.outint(((Pass1)(CUR$.SL$.SL$)).inspect$28$62.curline$1,6);
                                    ;
                                    inspect$630$78$1.outtext(new TXT$("   "));
                                    ;
                                    // JavaLine 310 <== SourceLine 632
                                    inspect$630$78$1.outtext(new TXT$("Macro Scan "));
                                    ;
                                    // JavaLine 313 <== SourceLine 633
                                    inspect$630$78$1.outtext(new TXT$("Symbol=#"));
                                    ;
                                    inspect$630$78$1.outtext(new Common$leftint(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,((Pass1$SubBlock32)(CUR$.SL$)).symbol).RESULT$);
                                    ;
                                    // JavaLine 318 <== SourceLine 634
                                    inspect$630$78$1.outtext(CONC(new TXT$(":"),new Common$edSymbol(((Pass1)(CUR$.SL$.SL$)).inspect$28$62,((Pass1$SubBlock32)(CUR$.SL$)).symbol).RESULT$));
                                    ;
                                    // JavaLine 321 <== SourceLine 635
                                    if(VALUE$(TRF_NE(((Pass1$SubBlock32)(CUR$.SL$)).curval,null))) {
                                        // JavaLine 323 <== SourceLine 636
                                        {
                                            inspect$630$78$1.setpos(50);
                                            ;
                                            inspect$630$78$1.outtext(CONC(CONC(new TXT$("=\""),((Pass1$SubBlock32)(CUR$.SL$)).curval),new TXT$("\"")));
                                            ;
                                        }
                                    }
                                    ;
                                    // JavaLine 332 <== SourceLine 638
                                    inspect$630$78$1.outimage();
                                    ;
                                }
                            }
                        }
                        ;
                        // JavaLine 339 <== SourceLine 640
                        LABEL$(5,"SYNCH");
                        call(((Pass1$SubBlock32)(CUR$.SL$)).parser);
                        ;
                    }
                    if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                }
                ;
                // JavaLine 347 <== SourceLine 643
                LABEL$(6,"QUIT");
                ((Pass1$SubBlock32)(CUR$.SL$)).scanner=prev$1;
                ;
                prev$1=null;
                ;
                // JavaLine 353 <== SourceLine 644
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$)).input_trace>(1)))) {
                    {
                        // BEGIN INSPECTION 
                        inspect$644$79$1=sysout();
                        if(inspect$644$79$1!=null) // INSPECT inspect$644$79
                        // JavaLine 359 <== SourceLine 645
                        {
                            inspect$644$79$1.outtext(new TXT$("Macro Scan terminated!"));
                            ;
                            // JavaLine 363 <== SourceLine 646
                            inspect$644$79$1.outimage();
                            ;
                        }
                    }
                }
                ;
                // JavaLine 370 <== SourceLine 648
                detach();
                ;
                GOTO$(INIT); // GOTO EVALUATED LABEL
                ;
                // JavaLine 375 <== SourceLine 569
                // Class macro_scan: Code after inner
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("macro_scan:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("macro_scan:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("macro_scan:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Class macro_scan",1,560,12,571,14,580,16,605,18,611,20,640,22,643,25,562,29,563,31,564,35,565,37,566,39,567,41,622,43,630,45,644,53,566,66,569,70,571,76,572,81,573,84,574,86,575,89,576,98,578,101,579,106,580,110,581,112,582,120,583,123,584,127,585,130,586,132,587,135,588,138,589,144,590,149,591,154,592,161,595,163,596,169,597,171,598,176,599,182,601,185,602,195,606,197,605,199,606,203,607,206,608,213,609,215,610,221,614,223,611,225,612,231,613,237,615,239,616,245,617,255,619,257,620,263,621,269,623,272,624,277,625,281,626,285,627,290,628,296,630,302,631,310,632,313,633,318,634,321,635,323,636,332,638,339,640,347,643,353,644,359,645,363,646,370,648,375,569,393,649);
} // End of Class
