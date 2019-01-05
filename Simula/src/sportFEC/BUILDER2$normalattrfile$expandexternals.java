// JavaLine 1 ==> SourceLine 307
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$normalattrfile$expandexternals extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=307, lastLine=482, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$brecord p$b;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 318
    final LABQNT$ restartloop=new LABQNT$(this,0,1); // Local Label #1=restartloop
    // JavaLine 14 ==> SourceLine 357
    final LABQNT$ nextplev=new LABQNT$(this,0,2); // Local Label #2=nextplev
    // JavaLine 16 ==> SourceLine 374
    final LABQNT$ found=new LABQNT$(this,0,3); // Local Label #3=found
    // JavaLine 18 ==> SourceLine 416
    final LABQNT$ addnewnature=new LABQNT$(this,0,4); // Local Label #4=addnewnature
    // JavaLine 20 ==> SourceLine 432
    final LABQNT$ newhead=new LABQNT$(this,0,5); // Local Label #5=newhead
    // JavaLine 22 ==> SourceLine 435
    final LABQNT$ littned=new LABQNT$(this,0,6); // Local Label #6=littned
    // JavaLine 24 ==> SourceLine 438
    final LABQNT$ nonew=new LABQNT$(this,0,7); // Local Label #7=nonew
    // JavaLine 26 ==> SourceLine 468
    final LABQNT$ nextq=new LABQNT$(this,0,8); // Local Label #8=nextq
    // Declare locals as attributes
    // JavaLine 29 ==> SourceLine 309
    COMMON$extbrecord eb=null;
    COMMON$quantity q=null;
    COMMON$quantity qe=null;
    COMMON$quantity qx=null;
    COMMON$quantity qq=null;
    // JavaLine 35 ==> SourceLine 310
    BUILDER1$extmodule currentextmodule=null;
    // JavaLine 37 ==> SourceLine 311
    TXT$ t=null;
    // JavaLine 39 ==> SourceLine 312
    boolean markermade=false;
    // JavaLine 41 ==> SourceLine 313
    boolean generate=false;
    // JavaLine 43 ==> SourceLine 324
    BUILDER1$extmodule inspect$324$1=null;
    // JavaLine 45 ==> SourceLine 404
    COMMON$extbrecord inspect$404$2=null;
    // JavaLine 47 ==> SourceLine 420
    COMMON$brecord inspect$420$3=null;
    // JavaLine 49 ==> SourceLine 459
    PrintFile$ inspect$459$4=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER2$normalattrfile$expandexternals setPar(Object param) {
        //Util.BREAK("CALL BUILDER2$normalattrfile$expandexternals.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$b=(COMMON$brecord)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER2$normalattrfile$expandexternals(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER2$normalattrfile$expandexternals(RTObject$ SL$,COMMON$brecord sp$b) {
        super(SL$);
        // Parameter assignment to locals
        this.p$b = sp$b;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("expandexternals",459);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$normalattrfile$expandexternals STM$() {
        TRACE_BEGIN_STM$("expandexternals",459);
        BUILDER2$normalattrfile$expandexternals THIS$=(BUILDER2$normalattrfile$expandexternals)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 84 ==> SourceLine 316
                q=p$b.fpar;
                // JavaLine 86 ==> SourceLine 469
                LABEL$(1); // restartloop
                // JavaLine 88 ==> SourceLine 318
                while((q!=(null))) {
                    // JavaLine 90 ==> SourceLine 319
                    {
                        TRACE_BEGIN_STM$("CompoundStatement319",319);
                        if(IS$(q.descr,COMMON$extbrecord.class)) {
                            // JavaLine 94 ==> SourceLine 320
                            {
                                TRACE_BEGIN_STM$("CompoundStatement320",320);
                                eb=((COMMON$extbrecord)(q.descr));
                                // JavaLine 98 ==> SourceLine 321
                                if((eb.status!=('M'))) {
                                    // JavaLine 100 ==> SourceLine 323
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement323",323);
                                        new COMMON$attrfile$openattributefile(((BUILDER2$normalattrfile)(CUR$.SL$)),q);
                                        // JavaLine 104 ==> SourceLine 324
                                        if((!(((BUILDER2$normalattrfile)(CUR$.SL$)).sysattrfile))) {
                                            {
                                                // BEGIN INSPECTION 
                                                inspect$324$1=new BUILDER1$extmodule(((BUILDER2)(CUR$.SL$.SL$))).STM$();
                                                if(inspect$324$1!=null) //INSPECT inspect$324$1
                                                // JavaLine 110 ==> SourceLine 325
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement325",325);
                                                    if((((BUILDER2)(CUR$.SL$.SL$)).firstextmodule==(null))) {
                                                        // JavaLine 114 ==> SourceLine 326
                                                        currentextmodule=((BUILDER2)(CUR$.SL$.SL$)).firstextmodule=((BUILDER1$extmodule)inspect$324$1);
                                                    } else
                                                    // JavaLine 117 ==> SourceLine 328
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement328",328);
                                                        currentextmodule=((BUILDER2)(CUR$.SL$.SL$)).firstextmodule;
                                                        // JavaLine 121 ==> SourceLine 329
                                                        while((currentextmodule.next!=(null))) {
                                                            // JavaLine 123 ==> SourceLine 330
                                                            currentextmodule=currentextmodule.next;
                                                        }
                                                        // JavaLine 126 ==> SourceLine 331
                                                        currentextmodule.next=((BUILDER1$extmodule)inspect$324$1);
                                                        TRACE_END_STM$("CompoundStatement328",331);
                                                    }
                                                    // JavaLine 130 ==> SourceLine 333
                                                    ((BUILDER2)(CUR$.SL$.SL$)).noofextmodules=(((BUILDER2)(CUR$.SL$.SL$)).noofextmodules+(1));
                                                    // JavaLine 132 ==> SourceLine 334
                                                    inspect$324$1.qty=q;
                                                    inspect$324$1.checkhi=((BUILDER2$normalattrfile)(CUR$.SL$)).attrckhi;
                                                    inspect$324$1.checklo=((BUILDER2$normalattrfile)(CUR$.SL$)).attrcklo;
                                                    TRACE_END_STM$("CompoundStatement325",334);
                                                }
                                            }
                                        }
                                        // JavaLine 140 ==> SourceLine 337
                                        if((eb.status==('S'))) {
                                            // JavaLine 142 ==> SourceLine 338
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement338",338);
                                                if((eb.checkhi==(((BUILDER2)(CUR$.SL$.SL$)).NUL))) {
                                                    // JavaLine 146 ==> SourceLine 339
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement339",339);
                                                        eb.checkhi=((BUILDER2$normalattrfile)(CUR$.SL$)).attrckhi;
                                                        eb.checklo=((BUILDER2$normalattrfile)(CUR$.SL$)).attrcklo;
                                                        TRACE_END_STM$("CompoundStatement339",339);
                                                    }
                                                } else
                                                // JavaLine 154 ==> SourceLine 340
                                                if(((((BUILDER2$normalattrfile)(CUR$.SL$)).attrcklo!=(eb.checklo))||((((BUILDER2$normalattrfile)(CUR$.SL$)).attrckhi!=(eb.checkhi))))) {
                                                    // JavaLine 156 ==> SourceLine 341
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement341",341);
                                                        ((BUILDER2)(CUR$.SL$.SL$)).messageLinenr=q.line;
                                                        // JavaLine 160 ==> SourceLine 342
                                                        new ERRMSG$error2quants(((BUILDER2)(CUR$.SL$.SL$)),406,q,eb.cause);
                                                        TRACE_END_STM$("CompoundStatement341",342);
                                                    }
                                                }
                                                TRACE_END_STM$("CompoundStatement338",342);
                                            }
                                        } else
                                        // JavaLine 168 ==> SourceLine 344
                                        if(((((BUILDER2$normalattrfile)(CUR$.SL$)).attrcklo!=(eb.checklo))||((((BUILDER2$normalattrfile)(CUR$.SL$)).attrckhi!=(eb.checkhi))))) {
                                            // JavaLine 170 ==> SourceLine 345
                                            new ERRMSG$errQTN(((BUILDER2)(CUR$.SL$.SL$)),q,416,eb.cause);
                                        }
                                        // JavaLine 173 ==> SourceLine 348
                                        new COMMON$attrfile$nextKey(((BUILDER2$normalattrfile)(CUR$.SL$)));
                                        // JavaLine 175 ==> SourceLine 350
                                        while((((BUILDER2$normalattrfile)(CUR$.SL$)).key<(((BUILDER2$normalattrfile)(CUR$.SL$)).lowKey))) {
                                            // JavaLine 177 ==> SourceLine 351
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement351",351);
                                                generate=new COMMON$attrfile$fetchquant(((BUILDER2$normalattrfile)(CUR$.SL$))).RESULT$;
                                                // JavaLine 181 ==> SourceLine 352
                                                if((((BUILDER2$normalattrfile)(CUR$.SL$)).xident==(null))) {
                                                    // JavaLine 183 ==> SourceLine 353
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement353",353);
                                                        ((BUILDER2)(CUR$.SL$.SL$)).simsymbol=((BUILDER2$normalattrfile)(CUR$.SL$)).xidentstring;
                                                        new COMMON$DEFIDENT(((BUILDER2)(CUR$.SL$.SL$)));
                                                        // JavaLine 188 ==> SourceLine 354
                                                        ((BUILDER2$normalattrfile)(CUR$.SL$)).xident=new COMMON$boxof(((BUILDER2)(CUR$.SL$.SL$)),((BUILDER2)(CUR$.SL$.SL$)).hashhi,((BUILDER2)(CUR$.SL$.SL$)).hashlo).RESULT$;
                                                        TRACE_END_STM$("CompoundStatement353",354);
                                                    }
                                                }
                                                // JavaLine 193 ==> SourceLine 356
                                                qx=p$b.declquant;
                                                // JavaLine 195 ==> SourceLine 357
                                                LABEL$(2); // nextplev
                                                qe=qx.descr.fpar;
                                                // JavaLine 198 ==> SourceLine 358
                                                while((qe!=(null))) {
                                                    // JavaLine 200 ==> SourceLine 359
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement359",359);
                                                        if((qe.symb==(((BUILDER2$normalattrfile)(CUR$.SL$)).xident))) {
                                                            GOTO$(found); // GOTO EVALUATED LABEL
                                                        }
                                                        // JavaLine 206 ==> SourceLine 360
                                                        qe=((COMMON$quantity)(qe.next));
                                                        TRACE_END_STM$("CompoundStatement359",360);
                                                    }
                                                }
                                                // JavaLine 211 ==> SourceLine 362
                                                if((qx.plev>(((BUILDER2)(CUR$.SL$.SL$)).one))) {
                                                    // JavaLine 213 ==> SourceLine 363
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement363",363);
                                                        qx=qx.prefqual;
                                                        GOTO$(nextplev); // GOTO EVALUATED LABEL
                                                        TRACE_END_STM$("CompoundStatement363",363);
                                                    }
                                                }
                                                // JavaLine 221 ==> SourceLine 366
                                                if((((BUILDER2$normalattrfile)(CUR$.SL$)).xkind==(((BUILDER2)(CUR$.SL$.SL$)).K_class))) {
                                                    GOTO$(newhead); // GOTO EVALUATED LABEL
                                                }
                                                // JavaLine 225 ==> SourceLine 367
                                                qe=new BUILDER1$meaningof(((BUILDER2)(CUR$.SL$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).xident).RESULT$;
                                                // JavaLine 227 ==> SourceLine 368
                                                if((qe==(null))) {
                                                    // JavaLine 229 ==> SourceLine 369
                                                    qe=new ERRMSG$newnotseen(((BUILDER2)(CUR$.SL$.SL$)),((BUILDER2$normalattrfile)(CUR$.SL$)).xident).RESULT$;
                                                }
                                                // JavaLine 232 ==> SourceLine 370
                                                if((qe.categ==(((BUILDER2)(CUR$.SL$.SL$)).C_unknwn))) {
                                                    // JavaLine 234 ==> SourceLine 371
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement371",371);
                                                        if((((BUILDER2$normalattrfile)(CUR$.SL$)).xclf==(((BUILDER2)(CUR$.SL$.SL$)).Clf001))) {
                                                            GOTO$(addnewnature); // GOTO EVALUATED LABEL
                                                        }
                                                        // JavaLine 240 ==> SourceLine 372
                                                        GOTO$(newhead); // GOTO EVALUATED LABEL
                                                        TRACE_END_STM$("CompoundStatement371",372);
                                                    }
                                                }
                                                // JavaLine 245 ==> SourceLine 383
                                                LABEL$(3); // found
                                                // JavaLine 247 ==> SourceLine 374
                                                if((qe.encl!=(p$b))) {
                                                    // JavaLine 249 ==> SourceLine 375
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement375",375);
                                                        if((((BUILDER2$normalattrfile)(CUR$.SL$)).xclf==(((BUILDER2)(CUR$.SL$.SL$)).Clf001))) {
                                                            GOTO$(addnewnature); // GOTO EVALUATED LABEL
                                                        }
                                                        // JavaLine 255 ==> SourceLine 376
                                                        if((!(IS$(qe.descr,COMMON$extbrecord.class)))) {
                                                            GOTO$(newhead); // GOTO EVALUATED LABEL
                                                        }
                                                        // JavaLine 259 ==> SourceLine 377
                                                        if(((((BUILDER2$normalattrfile)(CUR$.SL$)).xchecklo!=(((COMMON$extbrecord)(qe.descr)).checklo))&&((((BUILDER2$normalattrfile)(CUR$.SL$)).xcheckhi!=(((COMMON$extbrecord)(qe.descr)).checkhi))))) {
                                                            // JavaLine 261 ==> SourceLine 379
                                                            GOTO$(newhead); // GOTO EVALUATED LABEL
                                                        }
                                                        // JavaLine 264 ==> SourceLine 380
                                                        markermade=true;
                                                        // JavaLine 266 ==> SourceLine 381
                                                        qq=new BUILDER1$newextquantbrec(((BUILDER2)(CUR$.SL$.SL$)),p$b.blev,p$b.rtblev,'M',((COMMON$extquantity)(qe))).RESULT$;
                                                        // JavaLine 268 ==> SourceLine 382
                                                        GOTO$(littned); // GOTO EVALUATED LABEL
                                                        TRACE_END_STM$("CompoundStatement375",382);
                                                    }
                                                }
                                                // JavaLine 273 ==> SourceLine 385
                                                if((((BUILDER2$normalattrfile)(CUR$.SL$)).xclf==(((BUILDER2)(CUR$.SL$.SL$)).Clf001))) {
                                                    // JavaLine 275 ==> SourceLine 386
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement386",386);
                                                        if((qe.categ!=(((BUILDER2)(CUR$.SL$.SL$)).C_extnal))) {
                                                            // JavaLine 279 ==> SourceLine 387
                                                            new ERRMSG$errQTN(((BUILDER2)(CUR$.SL$.SL$)),qe,417,q);
                                                        } else
                                                        if((((((COMMON$extquantity)(qe)).clf!=(((BUILDER2)(CUR$.SL$.SL$)).Clf001))||((qe.virtno!=(((BUILDER2$normalattrfile)(CUR$.SL$)).xextident))))||((qe.dim!=(((BUILDER2$normalattrfile)(CUR$.SL$)).xlanguage))))) {
                                                            // JavaLine 283 ==> SourceLine 390
                                                            new ERRMSG$errQTN(((BUILDER2)(CUR$.SL$.SL$)),qe,418,q);
                                                        }
                                                        // JavaLine 286 ==> SourceLine 392
                                                        if((((BUILDER2$normalattrfile)(CUR$.SL$)).key==(((BUILDER2$normalattrfile)(CUR$.SL$)).begList))) {
                                                            // JavaLine 288 ==> SourceLine 393
                                                            {
                                                                TRACE_BEGIN_STM$("CompoundStatement393",393);
                                                                new COMMON$attrfile$nextKey(((BUILDER2$normalattrfile)(CUR$.SL$)));
                                                                // JavaLine 292 ==> SourceLine 395
                                                                while((((BUILDER2$normalattrfile)(CUR$.SL$)).key<(((BUILDER2$normalattrfile)(CUR$.SL$)).lowKey))) {
                                                                    new COMMON$attrfile$fetchquant(((BUILDER2$normalattrfile)(CUR$.SL$)));
                                                                }
                                                                // JavaLine 296 ==> SourceLine 397
                                                                if((((BUILDER2$normalattrfile)(CUR$.SL$)).key!=(((BUILDER2$normalattrfile)(CUR$.SL$)).endlist))) {
                                                                    new BUILDER2$normalattrfile$expxerr(((BUILDER2$normalattrfile)(CUR$.SL$)),'E');
                                                                }
                                                                // JavaLine 300 ==> SourceLine 398
                                                                new COMMON$attrfile$nextKey(((BUILDER2$normalattrfile)(CUR$.SL$)));
                                                                TRACE_END_STM$("CompoundStatement393",398);
                                                            }
                                                        }
                                                        TRACE_END_STM$("CompoundStatement386",398);
                                                    }
                                                } else
                                                // JavaLine 308 ==> SourceLine 401
                                                if((!(IS$(qe.descr,COMMON$extbrecord.class)))) {
                                                    // JavaLine 310 ==> SourceLine 403
                                                    new ERRMSG$errQTN(((BUILDER2)(CUR$.SL$.SL$)),qe,417,q);
                                                } else
                                                // JavaLine 313 ==> SourceLine 404
                                                {
                                                    // BEGIN INSPECTION 
                                                    inspect$404$2=((COMMON$extbrecord)(qe.descr));
                                                    if(inspect$404$2!=null) //INSPECT inspect$404$2
                                                    // JavaLine 318 ==> SourceLine 405
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement405",405);
                                                        if(((inspect$404$2.checkhi!=(((BUILDER2)(CUR$.SL$.SL$)).NUL))&&(((inspect$404$2.checkhi!=(((BUILDER2$normalattrfile)(CUR$.SL$)).xcheckhi))||((inspect$404$2.checklo!=(((BUILDER2$normalattrfile)(CUR$.SL$)).xchecklo))))))) {
                                                            // JavaLine 322 ==> SourceLine 408
                                                            new ERRMSG$errQTN(((BUILDER2)(CUR$.SL$.SL$)),qe,418,q);
                                                        } else
                                                        // JavaLine 325 ==> SourceLine 409
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement409",409);
                                                            inspect$404$2.checkhi=((BUILDER2$normalattrfile)(CUR$.SL$)).xcheckhi;
                                                            inspect$404$2.checklo=((BUILDER2$normalattrfile)(CUR$.SL$)).xchecklo;
                                                            // JavaLine 330 ==> SourceLine 410
                                                            inspect$404$2.cause=((COMMON$extquantity)(q));
                                                            TRACE_END_STM$("CompoundStatement409",410);
                                                        }
                                                        TRACE_END_STM$("CompoundStatement405",410);
                                                    }
                                                }
                                                // JavaLine 337 ==> SourceLine 413
                                                GOTO$(nonew); // GOTO EVALUATED LABEL
                                                // JavaLine 339 ==> SourceLine 425
                                                LABEL$(4); // addnewnature
                                                // JavaLine 341 ==> SourceLine 416
                                                if(generate) {
                                                    // JavaLine 343 ==> SourceLine 417
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement417",417);
                                                        qq=new COMMON$extquantity(((BUILDER2)(CUR$.SL$.SL$)),null).STM$();
                                                        new BUILDER2$normalattrfile$fillextquantity(((BUILDER2$normalattrfile)(CUR$.SL$)),((COMMON$extquantity)(qq)));
                                                        // JavaLine 348 ==> SourceLine 418
                                                        qq.encl=p$b;
                                                        // JavaLine 350 ==> SourceLine 419
                                                        qq.next=q.next;
                                                        q.next=qq;
                                                        // JavaLine 353 ==> SourceLine 420
                                                        {
                                                            // BEGIN INSPECTION 
                                                            inspect$420$3=new COMMON$brecord(((BUILDER2)(CUR$.SL$.SL$))).STM$();
                                                            if(inspect$420$3!=null) //INSPECT inspect$420$3
                                                            // JavaLine 358 ==> SourceLine 421
                                                            {
                                                                TRACE_BEGIN_STM$("CompoundStatement421",421);
                                                                inspect$420$3.blev=char$((rank(p$b.blev)+(1)));
                                                                // JavaLine 362 ==> SourceLine 422
                                                                inspect$420$3.rtblev=char$((rank(p$b.rtblev)+(1)));
                                                                // JavaLine 364 ==> SourceLine 423
                                                                qq.descr=((COMMON$brecord)inspect$420$3);
                                                                inspect$420$3.declquant=qq;
                                                                TRACE_END_STM$("CompoundStatement421",423);
                                                            }
                                                        }
                                                        // JavaLine 370 ==> SourceLine 424
                                                        q.descr.kind=((BUILDER2)(CUR$.SL$.SL$)).K_proc;
                                                        TRACE_END_STM$("CompoundStatement417",424);
                                                    }
                                                }
                                                // JavaLine 375 ==> SourceLine 427
                                                if((((BUILDER2$normalattrfile)(CUR$.SL$)).key==(((BUILDER2$normalattrfile)(CUR$.SL$)).begList))) {
                                                    // JavaLine 377 ==> SourceLine 428
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement428",428);
                                                        if(generate) {
                                                            // JavaLine 381 ==> SourceLine 429
                                                            new BUILDER2$normalattrfile$expandextlist(((BUILDER2$normalattrfile)(CUR$.SL$)),null,qq.descr);
                                                        } else
                                                        new BUILDER2$normalattrfile$skipList(((BUILDER2$normalattrfile)(CUR$.SL$)));
                                                        TRACE_END_STM$("CompoundStatement428",429);
                                                    }
                                                }
                                                // JavaLine 388 ==> SourceLine 430
                                                GOTO$(nonew); // GOTO EVALUATED LABEL
                                                // JavaLine 390 ==> SourceLine 432
                                                LABEL$(5); // newhead
                                                qq=new BUILDER1$newextquantbrec(((BUILDER2)(CUR$.SL$.SL$)),p$b.blev,p$b.rtblev,'H',((COMMON$extquantity)(q))).RESULT$;
                                                // JavaLine 393 ==> SourceLine 434
                                                if((qq.kind==(((BUILDER2)(CUR$.SL$.SL$)).K_class))) {
                                                    p$b.localclasses=true;
                                                }
                                                // JavaLine 397 ==> SourceLine 435
                                                LABEL$(6); // littned
                                                qq.encl=p$b;
                                                // JavaLine 400 ==> SourceLine 436
                                                qq.next=q.next;
                                                q.next=qq;
                                                // JavaLine 403 ==> SourceLine 437
                                                new BUILDER2$normalattrfile$fillextquantity(((BUILDER2$normalattrfile)(CUR$.SL$)),((COMMON$extquantity)(qq)));
                                                // JavaLine 405 ==> SourceLine 438
                                                LABEL$(7); // nonew
                                                TRACE_END_STM$("CompoundStatement351",438);
                                            }
                                        }
                                        // JavaLine 410 ==> SourceLine 442
                                        new COMMON$attrfile$nextKey(((BUILDER2$normalattrfile)(CUR$.SL$)));
                                        // JavaLine 412 ==> SourceLine 444
                                        if((((BUILDER2$normalattrfile)(CUR$.SL$)).key>=(((BUILDER2$normalattrfile)(CUR$.SL$)).lowKey))) {
                                            new BUILDER2$normalattrfile$expxerr(((BUILDER2$normalattrfile)(CUR$.SL$)),'Q');
                                        }
                                        // JavaLine 416 ==> SourceLine 445
                                        generate=new COMMON$attrfile$fetchquant(((BUILDER2$normalattrfile)(CUR$.SL$))).RESULT$;
                                        // JavaLine 418 ==> SourceLine 446
                                        if((q.symb!=(((BUILDER2$normalattrfile)(CUR$.SL$)).xident))) {
                                            new ERRMSG$errQT(((BUILDER2)(CUR$.SL$.SL$)),q,327);
                                        }
                                        // JavaLine 422 ==> SourceLine 447
                                        ((BUILDER2$normalattrfile)(CUR$.SL$)).xextident=q.virtno;
                                        // JavaLine 424 ==> SourceLine 448
                                        ((BUILDER2$normalattrfile)(CUR$.SL$)).xmodulhi=((BUILDER2$normalattrfile)(CUR$.SL$)).attrmodhi;
                                        ((BUILDER2$normalattrfile)(CUR$.SL$)).xmodullo=((BUILDER2$normalattrfile)(CUR$.SL$)).attrmodlo;
                                        // JavaLine 427 ==> SourceLine 449
                                        ((BUILDER2$normalattrfile)(CUR$.SL$)).xcheckhi=((BUILDER2$normalattrfile)(CUR$.SL$)).attrckhi;
                                        ((BUILDER2$normalattrfile)(CUR$.SL$)).xchecklo=((BUILDER2$normalattrfile)(CUR$.SL$)).attrcklo;
                                        // JavaLine 430 ==> SourceLine 450
                                        ((BUILDER2$normalattrfile)(CUR$.SL$)).xcateg=((BUILDER2)(CUR$.SL$.SL$)).C_extnal;
                                        // JavaLine 432 ==> SourceLine 451
                                        new BUILDER2$normalattrfile$fillextquantity(((BUILDER2$normalattrfile)(CUR$.SL$)),((COMMON$extquantity)(q)));
                                        // JavaLine 434 ==> SourceLine 453
                                        if((((BUILDER2$normalattrfile)(CUR$.SL$)).key==(((BUILDER2$normalattrfile)(CUR$.SL$)).begList))) {
                                            new BUILDER2$normalattrfile$expandextlist(((BUILDER2$normalattrfile)(CUR$.SL$)),((COMMON$extbrecord)(q.descr)),q.descr);
                                        }
                                        // JavaLine 438 ==> SourceLine 456
                                        ((BUILDER2$normalattrfile)(CUR$.SL$)).xtagnum=new COMMON$attrfile$nextNumber(((BUILDER2$normalattrfile)(CUR$.SL$))).RESULT$;
                                        // JavaLine 440 ==> SourceLine 457
                                        eb.exttagnum=((BUILDER2$normalattrfile)(CUR$.SL$)).xtagnum;
                                        // JavaLine 442 ==> SourceLine 458
                                        if((((BUILDER2)(CUR$.SL$.SL$)).option.Elt[rank('O')-((BUILDER2)(CUR$.SL$.SL$)).option.LB[0]]!=(((BUILDER2)(CUR$.SL$.SL$)).NUL))) {
                                            // JavaLine 444 ==> SourceLine 459
                                            {
                                                // BEGIN INSPECTION 
                                                inspect$459$4=sysout();
                                                if(inspect$459$4!=null) //INSPECT inspect$459$4
                                                // JavaLine 449 ==> SourceLine 460
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement460",460);
                                                    inspect$459$4.outtext(new TXT$(" - end attr. file "));
                                                    // JavaLine 453 ==> SourceLine 461
                                                    t=((BUILDER2$normalattrfile)(CUR$.SL$)).CURF.filename();
                                                    inspect$459$4.outtext(t);
                                                    // JavaLine 456 ==> SourceLine 464
                                                    inspect$459$4.outimage();
                                                    TRACE_END_STM$("CompoundStatement460",464);
                                                }
                                            }
                                        }
                                        // JavaLine 462 ==> SourceLine 465
                                        ((BUILDER2$normalattrfile)(CUR$.SL$)).CURF.close();
                                        ((BUILDER2$normalattrfile)(CUR$.SL$)).CURF=null;
                                        TRACE_END_STM$("CompoundStatement323",465);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement320",465);
                            }
                        }
                        // JavaLine 471 ==> SourceLine 468
                        LABEL$(8); // nextq
                        q=((COMMON$quantity)(q.next));
                        TRACE_END_STM$("CompoundStatement319",468);
                    }
                }
                // JavaLine 477 ==> SourceLine 472
                if(markermade) {
                    // JavaLine 479 ==> SourceLine 473
                    {
                        TRACE_BEGIN_STM$("CompoundStatement473",473);
                        q=p$b.fpar;
                        qe=((COMMON$quantity)(q.next));
                        // JavaLine 484 ==> SourceLine 474
                        while((qe!=(null))) {
                            // JavaLine 486 ==> SourceLine 476
                            {
                                TRACE_BEGIN_STM$("CompoundStatement476",476);
                                if((IS$(qe.descr,COMMON$extbrecord.class)&&((((COMMON$extbrecord)(qe.descr)).status==('M'))))) {
                                    // JavaLine 490 ==> SourceLine 478
                                    q.next=qe=((COMMON$quantity)(qe.next));
                                } else
                                // JavaLine 493 ==> SourceLine 479
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement479",479);
                                    q=qe;
                                    qe=((COMMON$quantity)(q.next));
                                    TRACE_END_STM$("CompoundStatement479",479);
                                }
                                TRACE_END_STM$("CompoundStatement476",479);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement473",479);
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
        TRACE_END_STM$("expandexternals",479);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure expandexternals",1,307,12,318,14,357,16,374,18,416,20,432,22,435,24,438,26,468,29,309,35,310,37,311,39,312,41,313,43,324,45,404,47,420,49,459,84,316,86,469,88,318,90,319,94,320,98,321,100,323,104,324,110,325,114,326,117,328,121,329,123,330,126,331,130,333,132,334,140,337,142,338,146,339,154,340,156,341,160,342,168,344,170,345,173,348,175,350,177,351,181,352,183,353,188,354,193,356,195,357,198,358,200,359,206,360,211,362,213,363,221,366,225,367,227,368,229,369,232,370,234,371,240,372,245,383,247,374,249,375,255,376,259,377,261,379,264,380,266,381,268,382,273,385,275,386,279,387,283,390,286,392,288,393,292,395,296,397,300,398,308,401,310,403,313,404,318,405,322,408,325,409,330,410,337,413,339,425,341,416,343,417,348,418,350,419,353,420,358,421,362,422,364,423,370,424,375,427,377,428,381,429,388,430,390,432,393,434,397,435,400,436,403,437,405,438,410,442,412,444,416,445,418,446,422,447,424,448,427,449,430,450,432,451,434,453,438,456,440,457,442,458,444,459,449,460,453,461,456,464,462,465,471,468,477,472,479,473,484,474,486,476,490,478,493,479,522,482);
}
