// JavaLine 1 ==> SourceLine 2168
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$parameter extends CHECKER1$semchecker1$argument {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=2168, lastLine=2525, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(1); }
    // Declare parameters as attributes
    public COMMON$quantity p1$formal;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 2452
    final LABQNT$ ERRchk=new LABQNT$(this,1,1); // Local Label #1=ERRchk
    // JavaLine 14 ==> SourceLine 2511
    final LABQNT$ ER4=new LABQNT$(this,1,2); // Local Label #2=ER4
    // JavaLine 16 ==> SourceLine 2525
    final LABQNT$ parameterexit=new LABQNT$(this,1,3); // Local Label #3=parameterexit
    // Declare locals as attributes
    // JavaLine 19 ==> SourceLine 2169
    public boolean implqua=false;
    // JavaLine 21 ==> SourceLine 2170
    public char clf=0;
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$parameter$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$parameter(RTObject$ staticLink,int sp$argno,CHECKER1$semchecker1$exp sp$actual,COMMON$quantity sp1$formal) {
        super(staticLink,sp$argno,sp$actual);
        // Parameter assignment to locals
        this.p1$formal = sp1$formal;
        // Declaration Code
        TRACE_BEGIN_DCL$("parameter",2277);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("parameter",2277,inner);
                CHECKER1$semchecker1$parameter THIS$=(CHECKER1$semchecker1$parameter)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 39 ==> SourceLine 2307
                        if(VALUE$((p1$formal==(null)))) {
                            // JavaLine 41 ==> SourceLine 2308
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2308",2308);
                                if(VALUE$((p$actual.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN)))) {
                                    // JavaLine 45 ==> SourceLine 2309
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement2309",2309);
                                        ((CHECKER1$semchecker1)(CUR$.SL$)).cquant=p$actual.meaning;
                                        // JavaLine 49 ==> SourceLine 2310
                                        if(VALUE$((((CHECKER1$semchecker1)(CUR$.SL$)).cquant.kind==(((CHECKER1)(CUR$.SL$.SL$)).K_class)))) {
                                            // JavaLine 51 ==> SourceLine 2311
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement2311",2311);
                                                new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p$actual)));
                                                // JavaLine 55 ==> SourceLine 2312
                                                p$actual.cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                                                TRACE_END_STM$("CompoundStatement2311",2312);
                                            }
                                        } else
                                        // JavaLine 60 ==> SourceLine 2313
                                        if(VALUE$((((CHECKER1$semchecker1)(CUR$.SL$)).cquant.kind==(((CHECKER1)(CUR$.SL$.SL$)).K_proc)))) {
                                            // JavaLine 62 ==> SourceLine 2315
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement2315",2315);
                                                if(VALUE$((IS$(((CHECKER1$semchecker1)(CUR$.SL$)).cquant,COMMON$extquantity.class)&&((((COMMON$extquantity)(((CHECKER1$semchecker1)(CUR$.SL$)).cquant)).clf>(((CHECKER1)(CUR$.SL$.SL$)).Clf001)))))) {
                                                    // JavaLine 66 ==> SourceLine 2319
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement2319",2319);
                                                        if(VALUE$(((((CHECKER1$semchecker1)(CUR$.SL$)).cquant.type!=(((CHECKER1)(CUR$.SL$.SL$)).INOTY))&&((((CHECKER1$semchecker1)(CUR$.SL$)).cquant.descr.npar==(0)))))) {
                                                            // JavaLine 70 ==> SourceLine 2322
                                                            {
                                                                TRACE_BEGIN_STM$("CompoundStatement2322",2322);
                                                                if(VALUE$(((CHECKER1)(CUR$.SL$.SL$)).GiveNotes)) {
                                                                    new ERRMSG$note0(((CHECKER1)(CUR$.SL$.SL$)),294);
                                                                }
                                                                // JavaLine 76 ==> SourceLine 2323
                                                                p$actual.cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                                                                TRACE_END_STM$("CompoundStatement2322",2323);
                                                            }
                                                        } else
                                                        // JavaLine 81 ==> SourceLine 2324
                                                        new CHECKER1$semchecker1$argument$errARG(((CHECKER1$semchecker1$parameter)CUR$),420);
                                                        TRACE_END_STM$("CompoundStatement2319",2324);
                                                    }
                                                } else
                                                // JavaLine 86 ==> SourceLine 2325
                                                p$actual.cl=((CHECKER1$semchecker1)(CUR$.SL$)).IACTEcl;
                                                TRACE_END_STM$("CompoundStatement2315",2325);
                                            }
                                        } else
                                        // JavaLine 91 ==> SourceLine 2327
                                        p$actual.cl=((CHECKER1$semchecker1)(CUR$.SL$)).IACTEcl;
                                        TRACE_END_STM$("CompoundStatement2309",2327);
                                    }
                                } else
                                // JavaLine 96 ==> SourceLine 2329
                                if(VALUE$((p$actual.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDNP)))) {
                                    // JavaLine 98 ==> SourceLine 2330
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement2330",2330);
                                        p$actual.cl=(((((((CHECKER1$semchecker1$argumented)(p$actual)).p1$ident.kind==(((CHECKER1)(CUR$.SL$.SL$)).K_array))||((((CHECKER1$semchecker1$argumented)(p$actual)).p1$ident.kind==(((CHECKER1)(CUR$.SL$.SL$)).K_rep))))||((((CHECKER1$semchecker1$argumented)(p$actual)).p1$ident.kind==(((CHECKER1)(CUR$.SL$.SL$)).K_switch)))))?(((CHECKER1$semchecker1)(CUR$.SL$)).IACTEcl):(((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl));
                                        TRACE_END_STM$("CompoundStatement2330",2330);
                                    }
                                } else
                                // JavaLine 105 ==> SourceLine 2336
                                p$actual.cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                                TRACE_END_STM$("CompoundStatement2308",2336);
                            }
                        } else
                        // JavaLine 110 ==> SourceLine 2340
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2340",2340);
                            ((CHECKER1$semchecker1)(CUR$.SL$)).ftype=p1$formal.type;
                            ((CHECKER1$semchecker1)(CUR$.SL$)).fkind=p1$formal.kind;
                            // JavaLine 115 ==> SourceLine 2342
                            clf=((IS$(p1$formal,COMMON$extquantity.class))?(((COMMON$extquantity)(p1$formal)).clf):(((CHECKER1)(CUR$.SL$.SL$)).Clf003));
                            // JavaLine 117 ==> SourceLine 2345
                            if(VALUE$(((((CHECKER1$semchecker1)(CUR$.SL$)).fkind==(((CHECKER1)(CUR$.SL$.SL$)).K_error))|((p$actual.type==(((CHECKER1)(CUR$.SL$.SL$)).IELSE)))))) {
                            } else
                            // JavaLine 120 ==> SourceLine 2347
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2347",2347);
                                if(VALUE$((p$actual.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN)))) {
                                    // JavaLine 124 ==> SourceLine 2348
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement2348",2348);
                                        ((CHECKER1$semchecker1)(CUR$.SL$)).cquant=p$actual.meaning;
                                        // JavaLine 128 ==> SourceLine 2349
                                        ((CHECKER1$semchecker1)(CUR$.SL$)).actualkind=((CHECKER1$semchecker1)(CUR$.SL$)).cquant.kind;
                                        // JavaLine 130 ==> SourceLine 2350
                                        switch(((CHECKER1$semchecker1)(CUR$.SL$)).fkind) { // BEGIN SWITCH STATEMENT
                                        case 0: 
                                        case 3: 
                                        // JavaLine 134 ==> SourceLine 2352
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2352",2352);
                                            if(VALUE$(((((CHECKER1$semchecker1)(CUR$.SL$)).actualkind==(((CHECKER1)(CUR$.SL$.SL$)).K_ident))||((((CHECKER1$semchecker1)(CUR$.SL$)).actualkind==(((CHECKER1)(CUR$.SL$.SL$)).K_label)))))) {
                                                // JavaLine 138 ==> SourceLine 2354
                                                p$actual.cl=(((p1$formal.categ==(((CHECKER1)(CUR$.SL$.SL$)).C_name)))?(((CHECKER1$semchecker1)(CUR$.SL$)).IACTEcl):(((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl));
                                            } else
                                            // JavaLine 141 ==> SourceLine 2357
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement2357",2357);
                                                new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p$actual)));
                                                // JavaLine 145 ==> SourceLine 2358
                                                if(VALUE$((((((CHECKER1$semchecker1)(CUR$.SL$)).actualkind==(((CHECKER1)(CUR$.SL$.SL$)).K_proc))&&((p$actual.type!=(((CHECKER1)(CUR$.SL$.SL$)).INOTY))))||((((CHECKER1$semchecker1)(CUR$.SL$)).actualkind==(((CHECKER1)(CUR$.SL$.SL$)).K_class)))))) {
                                                    // JavaLine 147 ==> SourceLine 2362
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement2362",2362);
                                                        ((CHECKER1$semchecker1)(CUR$.SL$)).actualkind=((CHECKER1)(CUR$.SL$.SL$)).K_ident;
                                                        p$actual.cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                                                        TRACE_END_STM$("CompoundStatement2362",2362);
                                                    }
                                                }
                                                TRACE_END_STM$("CompoundStatement2357",2362);
                                            }
                                            TRACE_END_STM$("CompoundStatement2352",2362);
                                        }
                                        case 1: 
                                        // JavaLine 160 ==> SourceLine 2367
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2367",2367);
                                            if(VALUE$((((CHECKER1$semchecker1)(CUR$.SL$)).actualkind==(((CHECKER1$semchecker1)(CUR$.SL$)).fkind)))) {
                                                // JavaLine 164 ==> SourceLine 2369
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement2369",2369);
                                                    if(VALUE$((IS$(((CHECKER1$semchecker1)(CUR$.SL$)).cquant,COMMON$extquantity.class)&&((((COMMON$extquantity)(((CHECKER1$semchecker1)(CUR$.SL$)).cquant)).clf>(((CHECKER1)(CUR$.SL$.SL$)).Clf001)))))) {
                                                        // JavaLine 168 ==> SourceLine 2372
                                                        new CHECKER1$semchecker1$argument$errARG(((CHECKER1$semchecker1$parameter)CUR$),420);
                                                    } else
                                                    p$actual.cl=((CHECKER1$semchecker1)(CUR$.SL$)).IACTEcl;
                                                    TRACE_END_STM$("CompoundStatement2369",2372);
                                                }
                                            }
                                            TRACE_END_STM$("CompoundStatement2367",2372);
                                        }
                                        case 2: 
                                        case 6: 
                                        case 4: 
                                        // JavaLine 180 ==> SourceLine 2376
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2376",2376);
                                            if(VALUE$((((CHECKER1$semchecker1)(CUR$.SL$)).actualkind==(((CHECKER1$semchecker1)(CUR$.SL$)).fkind)))) {
                                                p$actual.cl=((CHECKER1$semchecker1)(CUR$.SL$)).IACTEcl;
                                            }
                                            TRACE_END_STM$("CompoundStatement2376",2376);
                                        }
                                        default:
                                        // JavaLine 189 ==> SourceLine 2378
                                        p$actual.cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                                    } // END SWITCH STATEMENT
                                    TRACE_END_STM$("CompoundStatement2348",2378);
                                }
                            } else
                            // JavaLine 195 ==> SourceLine 2381
                            if(VALUE$((p$actual.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDNP)))) {
                                // JavaLine 197 ==> SourceLine 2382
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement2382",2382);
                                    ((CHECKER1$semchecker1)(CUR$.SL$)).actualkind=((CHECKER1$semchecker1$argumented)(p$actual)).p1$ident.kind;
                                    // JavaLine 201 ==> SourceLine 2384
                                    p$actual.cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                                    // JavaLine 203 ==> SourceLine 2385
                                    if(VALUE$((((CHECKER1$semchecker1)(CUR$.SL$)).fkind==(((CHECKER1)(CUR$.SL$.SL$)).K_ident)))) {
                                        // JavaLine 205 ==> SourceLine 2386
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2386",2386);
                                            if(VALUE$(((((CHECKER1$semchecker1)(CUR$.SL$)).actualkind==(((CHECKER1)(CUR$.SL$.SL$)).K_proc))||((((CHECKER1$semchecker1)(CUR$.SL$)).actualkind==(((CHECKER1)(CUR$.SL$.SL$)).K_class)))))) {
                                                // JavaLine 209 ==> SourceLine 2388
                                                ((CHECKER1$semchecker1)(CUR$.SL$)).actualkind=((CHECKER1)(CUR$.SL$.SL$)).K_ident;
                                            } else
                                            // JavaLine 212 ==> SourceLine 2390
                                            if(VALUE$(((((CHECKER1$semchecker1)(CUR$.SL$)).actualkind==(((CHECKER1)(CUR$.SL$.SL$)).K_array))|((((CHECKER1$semchecker1)(CUR$.SL$)).actualkind==(((CHECKER1)(CUR$.SL$.SL$)).K_rep)))))) {
                                                // JavaLine 214 ==> SourceLine 2393
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement2393",2393);
                                                    p$actual.cl=(((p1$formal.categ==(((CHECKER1)(CUR$.SL$.SL$)).C_name)))?(((CHECKER1$semchecker1)(CUR$.SL$)).IACTEcl):(((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl));
                                                    // JavaLine 218 ==> SourceLine 2395
                                                    ((CHECKER1$semchecker1)(CUR$.SL$)).actualkind=((CHECKER1)(CUR$.SL$.SL$)).K_ident;
                                                    TRACE_END_STM$("CompoundStatement2393",2395);
                                                }
                                            }
                                            TRACE_END_STM$("CompoundStatement2386",2395);
                                        }
                                    } else
                                    // JavaLine 226 ==> SourceLine 2398
                                    if(VALUE$((((CHECKER1$semchecker1)(CUR$.SL$)).fkind==(((CHECKER1)(CUR$.SL$.SL$)).K_label)))) {
                                        // JavaLine 228 ==> SourceLine 2399
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2399",2399);
                                            if(VALUE$((((CHECKER1$semchecker1)(CUR$.SL$)).actualkind==(((CHECKER1)(CUR$.SL$.SL$)).K_switch)))) {
                                                // JavaLine 232 ==> SourceLine 2400
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement2400",2400);
                                                    p$actual.cl=(((p1$formal.categ==(((CHECKER1)(CUR$.SL$.SL$)).C_name)))?(((CHECKER1$semchecker1)(CUR$.SL$)).IACTEcl):(((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl));
                                                    // JavaLine 236 ==> SourceLine 2402
                                                    ((CHECKER1$semchecker1)(CUR$.SL$)).actualkind=((CHECKER1)(CUR$.SL$.SL$)).K_label;
                                                    TRACE_END_STM$("CompoundStatement2400",2402);
                                                }
                                            }
                                            TRACE_END_STM$("CompoundStatement2399",2402);
                                        }
                                    } else
                                    // JavaLine 244 ==> SourceLine 2405
                                    if(VALUE$((((CHECKER1$semchecker1)(CUR$.SL$)).actualkind!=(((CHECKER1)(CUR$.SL$.SL$)).K_error)))) {
                                        ((CHECKER1$semchecker1)(CUR$.SL$)).actualkind=((CHECKER1)(CUR$.SL$.SL$)).K_ident;
                                    }
                                    TRACE_END_STM$("CompoundStatement2382",2405);
                                }
                            } else
                            // JavaLine 251 ==> SourceLine 2407
                            if(VALUE$((p$actual.p$ch==(((CHECKER1)(CUR$.SL$.SL$)).ICONS)))) {
                                ((CHECKER1$semchecker1)(CUR$.SL$)).actualkind=((CHECKER1)(CUR$.SL$.SL$)).K_ident;
                            } else
                            // JavaLine 255 ==> SourceLine 2410
                            if(VALUE$(p$actual instanceof CHECKER1$semchecker1$operation)) {
                                // JavaLine 257 ==> SourceLine 2411
                                ((CHECKER1$semchecker1)(CUR$.SL$)).actualkind=(((p$actual.type==(((CHECKER1)(CUR$.SL$.SL$)).ILABE)))?(((CHECKER1)(CUR$.SL$.SL$)).K_label):(((CHECKER1)(CUR$.SL$.SL$)).K_ident));
                            } else
                            // JavaLine 260 ==> SourceLine 2414
                            if(VALUE$((p$actual.p$ch==(((CHECKER1)(CUR$.SL$.SL$)).ICONC)))) {
                                // JavaLine 262 ==> SourceLine 2415
                                ((CHECKER1$semchecker1)(CUR$.SL$)).actualkind=((CHECKER1)(CUR$.SL$.SL$)).K_ident;
                            }
                            TRACE_END_STM$("CompoundStatement2347",2415);
                        }
                        // JavaLine 267 ==> SourceLine 2418
                        if(VALUE$((((CHECKER1$semchecker1)(CUR$.SL$)).fkind==(((CHECKER1$semchecker1)(CUR$.SL$)).actualkind)))) {
                            // JavaLine 269 ==> SourceLine 2419
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2419",2419);
                                switch(((CHECKER1$semchecker1)(CUR$.SL$)).fkind) { // BEGIN SWITCH STATEMENT
                                case 10: 
                                case 2: 
                                // JavaLine 275 ==> SourceLine 2422
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement2422",2422);
                                    if(VALUE$((!((p$actual.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN)))))) {
                                        // JavaLine 279 ==> SourceLine 2423
                                        new ERRMSG$internerr(((CHECKER1)(CUR$.SL$.SL$)),((char)8),2423);
                                    }
                                    // JavaLine 282 ==> SourceLine 2424
                                    if(VALUE$((((((CHECKER1$semchecker1)(CUR$.SL$)).ftype!=(p$actual.type))||(((((CHECKER1$semchecker1)(CUR$.SL$)).ftype==(((CHECKER1)(CUR$.SL$.SL$)).IREF))&&((p$actual.meaning.prefqual!=(p1$formal.prefqual))))))&&((clf!=(((CHECKER1)(CUR$.SL$.SL$)).Clf017)))))) {
                                        // JavaLine 284 ==> SourceLine 2429
                                        new CHECKER1$semchecker1$argument$errARG(((CHECKER1$semchecker1$parameter)CUR$),422);
                                    }
                                    TRACE_END_STM$("CompoundStatement2422",2429);
                                }
                                case 1: 
                                // JavaLine 290 ==> SourceLine 2432
                                if(VALUE$((p1$formal.categ==(((CHECKER1)(CUR$.SL$.SL$)).C_unspec)))) {
                                    // JavaLine 292 ==> SourceLine 2433
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement2433",2433);
                                        if(VALUE$((!((p$actual.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN)))))) {
                                            // JavaLine 296 ==> SourceLine 2434
                                            new ERRMSG$internerr(((CHECKER1)(CUR$.SL$.SL$)),((char)8),2434);
                                        }
                                        // JavaLine 299 ==> SourceLine 2435
                                        if(VALUE$((!(new BUILDER1$precheck0$subordinate(((CHECKER1$semchecker1)(CUR$.SL$)),p$actual.meaning,p1$formal).RESULT$)))) {
                                            // JavaLine 301 ==> SourceLine 2437
                                            new CHECKER1$semchecker1$argument$errARG(((CHECKER1$semchecker1$parameter)CUR$),423);
                                        }
                                        TRACE_END_STM$("CompoundStatement2433",2437);
                                    }
                                }
                                default:
                                // JavaLine 308 ==> SourceLine 2440
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement2440",2440);
                                    if(VALUE$((p$actual.type!=(((CHECKER1$semchecker1)(CUR$.SL$)).ftype)))) {
                                        // JavaLine 312 ==> SourceLine 2441
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement2441",2441);
                                            switch(p$actual.type) { // BEGIN SWITCH STATEMENT
                                            case 2: 
                                            case 3: 
                                            case 4: 
                                            case 5: 
                                            case 6: 
                                            // JavaLine 321 ==> SourceLine 2444
                                            switch(((CHECKER1$semchecker1)(CUR$.SL$)).ftype) { // BEGIN SWITCH STATEMENT
                                            case 2: 
                                            case 3: 
                                            case 4: 
                                            case 5: 
                                            case 6: 
                                            default:
                                            // JavaLine 329 ==> SourceLine 2447
                                            GOTO$(ERRchk); // GOTO EVALUATED LABEL
                                        } // END SWITCH STATEMENT
                                        case 14: 
                                        // JavaLine 333 ==> SourceLine 2449
                                        new CHECKER1$semchecker1$argument$errARG(((CHECKER1$semchecker1$parameter)CUR$),424);
                                        case 1: 
                                        case 7: 
                                        case 8: 
                                        // JavaLine 338 ==> SourceLine 2459
                                        LABEL$(1,"ERRchk");
                                        // JavaLine 340 ==> SourceLine 2452
                                        if(VALUE$((((CHECKER1$semchecker1)(CUR$.SL$)).ftype==(((CHECKER1)(CUR$.SL$.SL$)).IELSE)))) {
                                        } else
                                        // JavaLine 343 ==> SourceLine 2453
                                        if(VALUE$((((CHECKER1$semchecker1)(CUR$.SL$)).ftype==(((CHECKER1)(CUR$.SL$.SL$)).INOTY)))) {
                                            // JavaLine 345 ==> SourceLine 2454
                                            new CHECKER1$semchecker1$argument$errARG(((CHECKER1$semchecker1$parameter)CUR$),425);
                                        } else
                                        if(VALUE$(((clf!=(((CHECKER1)(CUR$.SL$.SL$)).Clf016))&&((clf!=(((CHECKER1)(CUR$.SL$.SL$)).Clf018)))))) {
                                            // JavaLine 349 ==> SourceLine 2456
                                            new CHECKER1$semchecker1$argument$errARG(((CHECKER1$semchecker1$parameter)CUR$),426);
                                        } else
                                        // JavaLine 352 ==> SourceLine 2457
                                        if(VALUE$((((COMMON$extquantity)(p1$formal.encl.declquant)).longindic==(((CHECKER1)(CUR$.SL$.SL$)).NUL)))) {
                                            // JavaLine 354 ==> SourceLine 2459
                                            new CHECKER1$semchecker1$argument$errARG(((CHECKER1$semchecker1$parameter)CUR$),426);
                                        }
                                    } // END SWITCH STATEMENT
                                    TRACE_END_STM$("CompoundStatement2441",2459);
                                }
                            } else
                            // JavaLine 361 ==> SourceLine 2462
                            if(VALUE$(((((CHECKER1$semchecker1)(CUR$.SL$)).ftype==(((CHECKER1)(CUR$.SL$.SL$)).IREF))||((((CHECKER1$semchecker1)(CUR$.SL$)).ftype==(((CHECKER1)(CUR$.SL$.SL$)).IPTR)))))) {
                                // JavaLine 363 ==> SourceLine 2488
                                new CHECKER1$semchecker1$parameter$CompoundStatement2340$CompoundStatement2419$CompoundStatement2440$SubBlock2465(CUR$).STM$();
                            }
                            TRACE_END_STM$("CompoundStatement2440",2486);
                        }
                    } // END SWITCH STATEMENT
                    TRACE_END_STM$("CompoundStatement2419",2486);
                }
            } else
            // JavaLine 372 ==> SourceLine 2492
            if(VALUE$((((((CHECKER1$semchecker1)(CUR$.SL$)).actualkind==(((CHECKER1)(CUR$.SL$.SL$)).K_error))|((p$actual.type==(((CHECKER1)(CUR$.SL$.SL$)).IELSE))))|((((CHECKER1$semchecker1)(CUR$.SL$)).fkind==(((CHECKER1)(CUR$.SL$.SL$)).K_error)))))) {
            } else
            // JavaLine 375 ==> SourceLine 2494
            new CHECKER1$semchecker1$argument$errARG(((CHECKER1$semchecker1$parameter)CUR$),421);
            // JavaLine 377 ==> SourceLine 2499
            if(VALUE$((clf==(((CHECKER1)(CUR$.SL$.SL$)).Clf002)))) {
                // JavaLine 379 ==> SourceLine 2500
                {
                    TRACE_BEGIN_STM$("CompoundStatement2500",2500);
                    if(VALUE$((p1$formal.categ==(((CHECKER1)(CUR$.SL$.SL$)).C_name)))) {
                        // JavaLine 383 ==> SourceLine 2501
                        {
                            TRACE_BEGIN_STM$("CompoundStatement2501",2501);
                            if(VALUE$((p$actual.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN)))) {
                            } else
                            // JavaLine 388 ==> SourceLine 2502
                            if(VALUE$((p$actual.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDNP)))) {
                                // JavaLine 390 ==> SourceLine 2503
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement2503",2503);
                                    if(VALUE$((((CHECKER1$semchecker1$argumented)(p$actual)).p1$ident.meaning.kind==(((CHECKER1)(CUR$.SL$.SL$)).K_array)))) {
                                    } else
                                    // JavaLine 395 ==> SourceLine 2504
                                    GOTO$(ER4); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement2503",2504);
                                }
                            } else
                            // JavaLine 400 ==> SourceLine 2505
                            if(VALUE$((p$actual.p$ch==(((CHECKER1)(CUR$.SL$.SL$)).ICONS)))) {
                                // JavaLine 402 ==> SourceLine 2506
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement2506",2506);
                                    if(VALUE$((p$actual.type==(((CHECKER1)(CUR$.SL$.SL$)).ITEXT)))) {
                                        // JavaLine 406 ==> SourceLine 2508
                                        new CHECKER1$semchecker1$argument$errARG(((CHECKER1$semchecker1$parameter)CUR$),-245);
                                    } else
                                    if(VALUE$((p$actual.type!=(((CHECKER1)(CUR$.SL$.SL$)).IREF)))) {
                                        GOTO$(ER4); // GOTO EVALUATED LABEL
                                    }
                                    TRACE_END_STM$("CompoundStatement2506",2508);
                                }
                            } else
                            // JavaLine 415 ==> SourceLine 2511
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2511",2511);
                                // JavaLine 418 ==> SourceLine 2512
                                LABEL$(2,"ER4");
                                new ERRMSG$error0(((CHECKER1)(CUR$.SL$.SL$)),(((p$actual.p$ch==(((CHECKER1)(CUR$.SL$.SL$)).ICONS)))?(178):(179)));
                                new BUILDER1$StopScode(((CHECKER1)(CUR$.SL$.SL$)));
                                TRACE_END_STM$("CompoundStatement2511",2512);
                            }
                            TRACE_END_STM$("CompoundStatement2501",2512);
                        }
                    }
                    TRACE_END_STM$("CompoundStatement2500",2512);
                }
            }
            TRACE_END_STM$("CompoundStatement2340",2512);
        }
        // JavaLine 432 ==> SourceLine 2525
        LABEL$(3,"parameterexit");
        // JavaLine 434 ==> SourceLine 2307
        if(inner!=null) {
            inner.STM$();
            TRACE_BEGIN_STM_AFTER_INNER$("parameter",2307);
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
TRACE_END_STM$("parameter",2307);
}
};
} // End of Constructor
// Class Statements
public CHECKER1$semchecker1$parameter STM$() { return((CHECKER1$semchecker1$parameter)CODE$.EXEC$()); }
public CHECKER1$semchecker1$parameter START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class parameter",1,2168,12,2452,14,2511,16,2525,19,2169,21,2170,39,2307,41,2308,45,2309,49,2310,51,2311,55,2312,60,2313,62,2315,66,2319,70,2322,76,2323,81,2324,86,2325,91,2327,96,2329,98,2330,105,2336,110,2340,115,2342,117,2345,120,2347,124,2348,128,2349,130,2350,134,2352,138,2354,141,2357,145,2358,147,2362,160,2367,164,2369,168,2372,180,2376,189,2378,195,2381,197,2382,201,2384,203,2385,205,2386,209,2388,212,2390,214,2393,218,2395,226,2398,228,2399,232,2400,236,2402,244,2405,251,2407,255,2410,257,2411,260,2414,262,2415,267,2418,269,2419,275,2422,279,2423,282,2424,284,2429,290,2432,292,2433,296,2434,299,2435,301,2437,308,2440,312,2441,321,2444,329,2447,333,2449,338,2459,340,2452,343,2453,345,2454,349,2456,352,2457,354,2459,361,2462,363,2488,372,2492,375,2494,377,2499,379,2500,383,2501,388,2502,390,2503,395,2504,400,2505,402,2506,406,2508,415,2511,418,2512,432,2525,434,2307,458,2525);
}
