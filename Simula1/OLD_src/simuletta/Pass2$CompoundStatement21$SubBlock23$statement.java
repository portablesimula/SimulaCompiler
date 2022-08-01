// JavaLine 1 <== SourceLine 483
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$statement extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=483, lastLine=759, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$term;
    // Declare local labels
    // JavaLine 14 <== SourceLine 665
    final LABQNT$ RBODY=new LABQNT$(this,1,"RBODY"); // Local Label #1=RBODY
    // Declare locals as attributes
    // JavaLine 17 <== SourceLine 486
    int xtype=0;
    int tp=0;
    int cond=0;
    // JavaLine 21 <== SourceLine 487
    int nassign=0;
    // JavaLine 23 <== SourceLine 488
    int pt=0;
    int bt=0;
    int hilo=0;
    // JavaLine 27 <== SourceLine 489
    int first=0;
    // JavaLine 29 <== SourceLine 490
    int i=0;
    // JavaLine 31 <== SourceLine 491
    Pass2$CompoundStatement21$SubBlock23$program_point els_lab=null;
    // JavaLine 33 <== SourceLine 492
    Pass2$CompoundStatement21$SubBlock23$program_point beg_lab=null;
    // JavaLine 35 <== SourceLine 493
    Common$displnotice x=null;
    // JavaLine 37 <== SourceLine 494
    Common$parspec spc=null;
    Head$ locdecl=null;
    // JavaLine 40 <== SourceLine 495
    Common$profile prf=null;
    Common$descr d=null;
    // JavaLine 43 <== SourceLine 496
    Linkage$ dentry=null;
    // JavaLine 45 <== SourceLine 497
    TXT$ tempt=null;
    // JavaLine 47 <== SourceLine 566
    PrintFile$ inspect$565$176=null;
    // JavaLine 49 <== SourceLine 620
    Pass2$CompoundStatement21$SubBlock23$program_point inspect$620$177=null;
    // JavaLine 51 <== SourceLine 648
    Pass2$CompoundStatement21$SubBlock23$program_point inspect$648$178=null;
    // JavaLine 53 <== SourceLine 665
    Common$routine inspect$665$179=null;
    // JavaLine 55 <== SourceLine 669
    Common$profile inspect$669$180=null;
    // JavaLine 57 <== SourceLine 681
    Common$peculiar inspect$681$181=null;
    // JavaLine 59 <== SourceLine 682
    Common$parspec inspect$682$182=null;
    // JavaLine 61 <== SourceLine 696
    Head$ inspect$696$183=null;
    // JavaLine 63 <== SourceLine 708
    Pass2$CompoundStatement21$SubBlock23$program_point inspect$708$184=null;
    // JavaLine 65 <== SourceLine 734
    Common$dest_descr inspect$734$185=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$statement setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$statement.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$term=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$statement(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$statement(RTObject$ SL$,int sp$term) {
        super(SL$);
        // Parameter assignment to locals
        this.p$term = sp$term;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$statement STM$() {
        Pass2$CompoundStatement21$SubBlock23$statement THIS$=(Pass2$CompoundStatement21$SubBlock23$statement)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 98 <== SourceLine 553
                RESULT$=true;
                ;
                // JavaLine 101 <== SourceLine 554
                while((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$!=(p$term))) {
                    // JavaLine 103 <== SourceLine 555
                    {
                        switch(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$) { // BEGIN SWITCH STATEMENT
                        case 127: 
                        // JavaLine 107 <== SourceLine 557
                        new Pass2$CompoundStatement21$SubBlock23$out_S_line(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)));
                        break;
                        case 126: 
                        // JavaLine 111 <== SourceLine 560
                        {
                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_INFO$1);
                            ;
                            tempt=new InptFile$instring(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                            ;
                            new OuptFile$outstring(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,tempt);
                        }
                        break;
                        case 202: 
                        // JavaLine 121 <== SourceLine 581
                        new Pass2$CompoundStatement21$SubBlock23$statement$CompoundStatement555$SubBlock563((CUR$)).STM$();
                        break;
                        case 94: 
                        // JavaLine 125 <== SourceLine 584
                        {
                            tp=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                            ;
                            // JavaLine 129 <== SourceLine 585
                            if(VALUE$((tp==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_DEST$1)))) {
                                // JavaLine 131 <== SourceLine 586
                                new Pass2$CompoundStatement21$SubBlock23$program_point$go_to(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).dest_tab.Elt[((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).curdest-((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).dest_tab.LB[0]]);
                            } else
                            // JavaLine 134 <== SourceLine 587
                            {
                                if(VALUE$((tp!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_LABEL$1)))) {
                                    // JavaLine 137 <== SourceLine 588
                                    new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Illegal type - goto"));
                                }
                                ;
                                // JavaLine 141 <== SourceLine 589
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_GOTO$1);
                                ;
                                // JavaLine 144 <== SourceLine 590
                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                }
                                ;
                            }
                            ;
                            // JavaLine 151 <== SourceLine 592
                            RESULT$=false;
                            ;
                        }
                        break;
                        case 111: 
                        // JavaLine 157 <== SourceLine 596
                        {
                            RESULT$=true;
                            ;
                            // JavaLine 161 <== SourceLine 597
                            nassign=new InptFile$inbyt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                            ;
                            // JavaLine 164 <== SourceLine 598
                            xtype=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                            ;
                            // JavaLine 167 <== SourceLine 599
                            while((nassign!=(0))) {
                                // JavaLine 169 <== SourceLine 600
                                {
                                    nassign=Math.subtractExact(nassign,1);
                                    ;
                                    // JavaLine 173 <== SourceLine 601
                                    if(VALUE$((new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_VAR$1)))) {
                                        // JavaLine 175 <== SourceLine 602
                                        {
                                            tp=new Pass2$CompoundStatement21$SubBlock23$invariable(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),true).RESULT$;
                                            ;
                                            // JavaLine 179 <== SourceLine 603
                                            if(VALUE$((xtype!=(tp)))) {
                                                // JavaLine 181 <== SourceLine 604
                                                new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),xtype,tp);
                                            }
                                        }
                                    } else
                                    new Common$IERR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141);
                                    ;
                                    // JavaLine 188 <== SourceLine 605
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_RUPDATE$1);
                                    ;
                                    // JavaLine 191 <== SourceLine 606
                                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                    }
                                    ;
                                }
                            }
                            ;
                            // JavaLine 199 <== SourceLine 608
                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_POP$1);
                            ;
                            // JavaLine 202 <== SourceLine 609
                            if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                            }
                            ;
                        }
                        break;
                        case 63: 
                        // JavaLine 210 <== SourceLine 613
                        {
                            RESULT$=true;
                            ;
                            // JavaLine 214 <== SourceLine 614
                            els_lab=new Pass2$CompoundStatement21$SubBlock23$program_point(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$))).STM$();
                            ;
                            // JavaLine 217 <== SourceLine 615
                            cond=new Pass2$CompoundStatement21$SubBlock23$condition(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                            ;
                            // JavaLine 220 <== SourceLine 616
                            new Pass2$CompoundStatement21$SubBlock23$program_point$jumpif(els_lab,Math.subtractExact(10,cond));
                            ;
                            // JavaLine 223 <== SourceLine 617
                            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                            ;
                            new Pass2$CompoundStatement21$SubBlock23$statement(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ELSE$1);
                            ;
                            // JavaLine 228 <== SourceLine 618
                            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                            ;
                            // JavaLine 231 <== SourceLine 619
                            if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ENDIF$1)))) {
                                // JavaLine 233 <== SourceLine 620
                                new Pass2$CompoundStatement21$SubBlock23$program_point$define(els_lab);
                            } else
                            {
                                // BEGIN INSPECTION 
                                inspect$620$177=new Pass2$CompoundStatement21$SubBlock23$program_point(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$))).STM$();
                                if(inspect$620$177!=null) // INSPECT inspect$620$177
                                // JavaLine 240 <== SourceLine 621
                                {
                                    new Pass2$CompoundStatement21$SubBlock23$program_point$go_to(inspect$620$177);
                                    ;
                                    // JavaLine 244 <== SourceLine 622
                                    new Pass2$CompoundStatement21$SubBlock23$program_point$define(els_lab);
                                    ;
                                    new Pass2$CompoundStatement21$SubBlock23$statement(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ENDIF$1);
                                    ;
                                    // JavaLine 249 <== SourceLine 623
                                    new Pass2$CompoundStatement21$SubBlock23$program_point$define(inspect$620$177);
                                    ;
                                }
                            }
                            ;
                        }
                        break;
                        case 61: 
                        // JavaLine 258 <== SourceLine 628
                        {
                            RESULT$=true;
                            ;
                            // JavaLine 262 <== SourceLine 629
                            cond=new Pass2$CompoundStatement21$SubBlock23$condition(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                            ;
                            // JavaLine 265 <== SourceLine 630
                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_SKIPIF$1);
                            ;
                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).condinstr.Elt[cond-((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).condinstr.LB[0]]);
                            ;
                            // JavaLine 270 <== SourceLine 631
                            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                            ;
                            new Pass2$CompoundStatement21$SubBlock23$statement(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ENDSKIP$1);
                            ;
                            // JavaLine 275 <== SourceLine 632
                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ENDSKIP$1);
                            ;
                        }
                        break;
                        case 70: 
                        // JavaLine 281 <== SourceLine 636
                        {
                            RESULT$=true;
                            ;
                            // JavaLine 285 <== SourceLine 637
                            if(VALUE$((new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$!=(0)))) {
                                // JavaLine 287 <== SourceLine 638
                                {
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_POP$1);
                                    ;
                                    // JavaLine 291 <== SourceLine 639
                                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                    }
                                    ;
                                }
                            }
                        }
                        break;
                        case 177: 
                        // JavaLine 301 <== SourceLine 643
                        {
                            RESULT$=true;
                            ;
                            // JavaLine 305 <== SourceLine 644
                            beg_lab=new Pass2$CompoundStatement21$SubBlock23$program_point(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$))).STM$();
                            ;
                            new Pass2$CompoundStatement21$SubBlock23$program_point$define(beg_lab);
                            ;
                            // JavaLine 310 <== SourceLine 645
                            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                            ;
                            new Pass2$CompoundStatement21$SubBlock23$statement(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_WHILE$1);
                            ;
                            // JavaLine 315 <== SourceLine 646
                            cond=new Pass2$CompoundStatement21$SubBlock23$condition(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                            ;
                            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                            ;
                            // JavaLine 320 <== SourceLine 647
                            if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ENDREPEAT$1)))) {
                                // JavaLine 322 <== SourceLine 648
                                new Pass2$CompoundStatement21$SubBlock23$program_point$jumpif(beg_lab,cond);
                            } else
                            {
                                // BEGIN INSPECTION 
                                inspect$648$178=new Pass2$CompoundStatement21$SubBlock23$program_point(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$))).STM$();
                                if(inspect$648$178!=null) // INSPECT inspect$648$178
                                // JavaLine 329 <== SourceLine 649
                                {
                                    new Pass2$CompoundStatement21$SubBlock23$program_point$jumpif(inspect$648$178,Math.subtractExact(10,cond));
                                    ;
                                    // JavaLine 333 <== SourceLine 650
                                    new Pass2$CompoundStatement21$SubBlock23$statement(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ENDREPEAT$1);
                                    ;
                                    new Pass2$CompoundStatement21$SubBlock23$program_point$go_to(beg_lab);
                                    ;
                                    // JavaLine 338 <== SourceLine 651
                                    new Pass2$CompoundStatement21$SubBlock23$program_point$define(inspect$648$178);
                                    ;
                                }
                            }
                            ;
                        }
                        break;
                        case 183: 
                        // JavaLine 347 <== SourceLine 656
                        {
                            RESULT$=true;
                            ;
                            new Pass2$CompoundStatement21$SubBlock23$statement$casestmt(((Pass2$CompoundStatement21$SubBlock23$statement)(CUR$)));
                            ;
                        }
                        break;
                        case 45: 
                        // JavaLine 356 <== SourceLine 659
                        {
                            RESULT$=true;
                            ;
                            // JavaLine 360 <== SourceLine 660
                            ((Pass2)(CUR$.SL$.SL$)).inspect$20$141.rutlev$1=Math.addExact(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.rutlev$1,1);
                            ;
                            // JavaLine 363 <== SourceLine 661
                            ((Pass2)(CUR$.SL$.SL$)).inspect$20$141.redeclset$1=new Head$(((Pass2)(CUR$.SL$.SL$)).inspect$20$141).STM$();
                            ;
                            // JavaLine 366 <== SourceLine 662
                            hilo=new InptFile$in2byt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                            ;
                            // JavaLine 369 <== SourceLine 663
                            dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[i-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                            ;
                            // JavaLine 372 <== SourceLine 664
                            if(VALUE$(IS$(dentry,Common$routine.class))) {
                                // JavaLine 374 <== SourceLine 665
                                {
                                    // JavaLine 376 <== SourceLine 680
                                    LABEL$(1,"RBODY");
                                    // JavaLine 378 <== SourceLine 665
                                    {
                                        // BEGIN INSPECTION 
                                        inspect$665$179=((Common$routine)(dentry));
                                        if(inspect$665$179!=null) // INSPECT inspect$665$179
                                        // JavaLine 383 <== SourceLine 666
                                        {
                                            dentry=inspect$665$179.profbox$3.curmeaning;
                                            ;
                                            // JavaLine 387 <== SourceLine 667
                                            if(VALUE$((!(IS$(dentry,Common$profile.class))))) {
                                                // JavaLine 389 <== SourceLine 668
                                                dentry=new Pass2$CompoundStatement21$SubBlock23$get_prf(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),inspect$665$179.profbox$3.id).RESULT$;
                                            }
                                            ;
                                            // JavaLine 393 <== SourceLine 669
                                            {
                                                // BEGIN INSPECTION 
                                                inspect$669$180=((Common$profile)(dentry));
                                                if(inspect$669$180!=null) // INSPECT inspect$669$180
                                                // JavaLine 398 <== SourceLine 670
                                                {
                                                    pt=inspect$669$180.tag$2;
                                                    ;
                                                    // JavaLine 402 <== SourceLine 671
                                                    new Common$update_display(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,inspect$669$180.spec$3.import$);
                                                    ;
                                                    // JavaLine 405 <== SourceLine 672
                                                    new Common$displ(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,inspect$669$180.spec$3.export);
                                                    ;
                                                    new Common$displ(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,inspect$669$180.spec$3.exit);
                                                    ;
                                                }
                                            }
                                            ;
                                            // JavaLine 413 <== SourceLine 673
                                            new Common$update_display(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,inspect$665$179.local$3);
                                            ;
                                            locdecl=inspect$665$179.local$3;
                                            ;
                                            // JavaLine 418 <== SourceLine 674
                                            if(VALUE$((inspect$665$179.tag$2==(0)))) {
                                                // JavaLine 420 <== SourceLine 675
                                                new Common$deftag(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$descr)inspect$665$179));
                                            }
                                            ;
                                            // JavaLine 424 <== SourceLine 676
                                            bt=inspect$665$179.tag$2;
                                            ;
                                            // JavaLine 427 <== SourceLine 677
                                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ROUTINE$1);
                                            ;
                                            // JavaLine 430 <== SourceLine 678
                                            new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,bt);
                                            ;
                                            new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,pt);
                                            ;
                                        }
                                    }
                                }
                            } else
                            // JavaLine 439 <== SourceLine 680
                            if(VALUE$(IS$(dentry,Common$peculiar.class))) {
                                // JavaLine 441 <== SourceLine 681
                                {
                                    {
                                        // BEGIN INSPECTION 
                                        inspect$681$181=((Common$peculiar)(dentry));
                                        if(inspect$681$181!=null) // INSPECT inspect$681$181
                                        // JavaLine 447 <== SourceLine 682
                                        {
                                            {
                                                // BEGIN INSPECTION 
                                                inspect$682$182=inspect$681$181.spec$3;
                                                if(inspect$682$182!=null) // INSPECT inspect$682$182
                                                // JavaLine 453 <== SourceLine 683
                                                {
                                                    new Common$update_display(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,inspect$682$182.import$);
                                                    ;
                                                    // JavaLine 457 <== SourceLine 684
                                                    new Common$displ(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,inspect$682$182.export);
                                                    ;
                                                    new Common$displ(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,inspect$682$182.exit);
                                                    ;
                                                }
                                            }
                                            ;
                                            // JavaLine 465 <== SourceLine 685
                                            new Common$update_display(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,inspect$681$181.local$4);
                                            ;
                                            locdecl=inspect$681$181.local$4;
                                            ;
                                            // JavaLine 470 <== SourceLine 686
                                            if(VALUE$((inspect$681$181.body$4==(0)))) {
                                                // JavaLine 472 <== SourceLine 687
                                                {
                                                    new Common$newtag(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,inspect$681$181.symb$2);
                                                    ;
                                                    inspect$681$181.body$4=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.ntag$1;
                                                    ;
                                                }
                                            }
                                            ;
                                            // JavaLine 481 <== SourceLine 689
                                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ROUTINE$1);
                                            ;
                                            new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$681$181.body$4);
                                            ;
                                            // JavaLine 486 <== SourceLine 690
                                            if(VALUE$(inspect$681$181.libProc$3)) {
                                                // JavaLine 488 <== SourceLine 691
                                                new OuptFile$outentry(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$681$181.tag$2);
                                            } else
                                            new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$681$181.tag$2);
                                            ;
                                        }
                                    }
                                }
                            } else
                            // JavaLine 497 <== SourceLine 693
                            {
                                dentry=new Pass2$CompoundStatement21$SubBlock23$get_ent(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),hilo).RESULT$;
                                ;
                                GOTO$(RBODY); // GOTO EVALUATED LABEL
                            }
                            ;
                            // JavaLine 504 <== SourceLine 694
                            if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                            }
                            ;
                            // JavaLine 509 <== SourceLine 695
                            first=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.ntag$1;
                            ;
                            // JavaLine 512 <== SourceLine 696
                            {
                                // BEGIN INSPECTION 
                                inspect$696$183=locdecl;
                                if(inspect$696$183!=null) // INSPECT inspect$696$183
                                // JavaLine 517 <== SourceLine 697
                                {
                                    if(VALUE$((!(inspect$696$183.empty())))) {
                                        // JavaLine 520 <== SourceLine 698
                                        {
                                            for(boolean CB$698:new ForList(
                                                new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){d=(Common$descr)x$; return(x$);};  public Link$ get(){return((Link$)d); }	},new NAME$<Link$>() { public Link$ get(){return(inspect$696$183.first()); }})
                                               ,new WhileElt<Common$descr>(new NAME$<Common$descr>(){ public Common$descr put(Common$descr x$){d=x$; return(x$);};  public Common$descr get(){return((Common$descr)d); }	},new NAME$<Common$descr>() { public Common$descr get(){return(((Common$descr)(d.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((d!=(null))); }})
                                               )) { if(!CB$698) continue;
                                            // JavaLine 526 <== SourceLine 699
                                            new Pass2$CompoundStatement21$SubBlock23$out_descr(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),d);
                                        }
                                        ;
                                    }
                                }
                                ;
                            }
                        }
                        ;
                        // JavaLine 536 <== SourceLine 702
                        ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                        ;
                        new Pass2$CompoundStatement21$SubBlock23$statement(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_END$1);
                        ;
                        // JavaLine 541 <== SourceLine 703
                        if(VALUE$((!(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.redeclset$1.empty())))) {
                            // JavaLine 543 <== SourceLine 704
                            {
                                for(boolean CB$704:new ForList(
                                    new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){x=(Common$displnotice)x$; return(x$);};  public Link$ get(){return((Link$)x); }	},new NAME$<Link$>() { public Link$ get(){return(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.redeclset$1.first()); }})
                                   ,new WhileElt<Common$displnotice>(new NAME$<Common$displnotice>(){ public Common$displnotice put(Common$displnotice x$){x=x$; return(x$);};  public Common$displnotice get(){return((Common$displnotice)x); }	},new NAME$<Common$displnotice>() { public Common$displnotice get(){return(((Common$displnotice)(x.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((x!=(null))); }})
                                   )) { if(!CB$704) continue;
                                // JavaLine 549 <== SourceLine 705
                                x.p2$d.symb$2.curmeaning=x.p2$old;
                            }
                            ;
                        }
                    }
                    ;
                    // JavaLine 556 <== SourceLine 707
                    while((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).ndest!=(0))) {
                        // JavaLine 558 <== SourceLine 708
                        {
                            {
                                // BEGIN INSPECTION 
                                inspect$708$184=((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).dest_tab.Elt[((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).ndest-((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).dest_tab.LB[0]];
                                if(inspect$708$184!=null) // INSPECT inspect$708$184
                                // JavaLine 564 <== SourceLine 709
                                {
                                    if(VALUE$((inspect$708$184.kind!=(3)))) {
                                        // JavaLine 567 <== SourceLine 710
                                        new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,CONC(new TXT$("Illegal use of label "),new Common$edSymbol(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,inspect$708$184.p).RESULT$));
                                    }
                                    ;
                                    // JavaLine 571 <== SourceLine 711
                                    inspect$708$184.index=inspect$708$184.kind=0;
                                    ;
                                }
                            }
                            ;
                            // JavaLine 577 <== SourceLine 713
                            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).ndest=Math.subtractExact(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).ndest,1);
                            ;
                        }
                    }
                    ;
                    // JavaLine 583 <== SourceLine 715
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ENDROUTINE$1);
                    ;
                    // JavaLine 586 <== SourceLine 716
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                    }
                    ;
                    // JavaLine 591 <== SourceLine 717
                    ((Pass2)(CUR$.SL$.SL$)).inspect$20$141.redeclset$1=null;
                    ;
                    ((Pass2)(CUR$.SL$.SL$)).inspect$20$141.rutlev$1=Math.subtractExact(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.rutlev$1,1);
                    ;
                }
                break;
                case 211: 
                // JavaLine 599 <== SourceLine 721
                {
                    RESULT$=true;
                    ;
                    // JavaLine 603 <== SourceLine 722
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.rutlev$1>(0)))) {
                        // JavaLine 605 <== SourceLine 743
                        new Pass2$CompoundStatement21$SubBlock23$statement$CompoundStatement555$CompoundStatement721$SubBlock723((CUR$)).STM$();
                    } else
                    // JavaLine 608 <== SourceLine 744
                    {
                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_LABEL$1);
                        ;
                        // JavaLine 612 <== SourceLine 745
                        hilo=new InptFile$in2byt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                        ;
                        // JavaLine 615 <== SourceLine 746
                        dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[i-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                        ;
                        // JavaLine 618 <== SourceLine 747
                        if(VALUE$((!(IS$(dentry,Common$label_descr.class))))) {
                            // JavaLine 620 <== SourceLine 748
                            dentry=new Pass2$CompoundStatement21$SubBlock23$get_lab(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),hilo).RESULT$;
                        }
                        ;
                        // JavaLine 624 <== SourceLine 749
                        new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$label_descr)(dentry)).tag$2);
                        ;
                        // JavaLine 627 <== SourceLine 750
                        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                        }
                        ;
                    }
                    ;
                }
                break;
                default:
                // JavaLine 637 <== SourceLine 754
                new Common$IERR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141);
                break;
            } // END SWITCH STATEMENT
            ;
            // JavaLine 642 <== SourceLine 757
            ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
            ;
        }
    }
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
public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure statement",1,483,14,665,17,486,21,487,23,488,27,489,29,490,31,491,33,492,35,493,37,494,40,495,43,496,45,497,47,566,49,620,51,648,53,665,55,669,57,681,59,682,61,696,63,708,65,734,98,553,101,554,103,555,107,557,111,560,121,581,125,584,129,585,131,586,134,587,137,588,141,589,144,590,151,592,157,596,161,597,164,598,167,599,169,600,173,601,175,602,179,603,181,604,188,605,191,606,199,608,202,609,210,613,214,614,217,615,220,616,223,617,228,618,231,619,233,620,240,621,244,622,249,623,258,628,262,629,265,630,270,631,275,632,281,636,285,637,287,638,291,639,301,643,305,644,310,645,315,646,320,647,322,648,329,649,333,650,338,651,347,656,356,659,360,660,363,661,366,662,369,663,372,664,374,665,376,680,378,665,383,666,387,667,389,668,393,669,398,670,402,671,405,672,413,673,418,674,420,675,424,676,427,677,430,678,439,680,441,681,447,682,453,683,457,684,465,685,470,686,472,687,481,689,486,690,488,691,497,693,504,694,509,695,512,696,517,697,520,698,526,699,536,702,541,703,543,704,549,705,556,707,558,708,564,709,567,710,571,711,577,713,583,715,586,716,591,717,599,721,603,722,605,743,608,744,612,745,615,746,618,747,620,748,624,749,627,750,637,754,642,757,663,759);
} // End of Procedure
