// JavaLine 1 <== SourceLine 1362
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$outconst extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=1362, lastLine=1480, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public Common$const$ p$c;
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 1363
    int cnstype=0;
    // JavaLine 16 <== SourceLine 1364
    Common$quant q=null;
    // JavaLine 18 <== SourceLine 1365
    int fixrep=0;
    // JavaLine 20 <== SourceLine 1366
    Common$const$ e=null;
    int t=0;
    int t1=0;
    // JavaLine 24 <== SourceLine 1367
    Common$routine r=null;
    Linkage$ dentry=null;
    // JavaLine 27 <== SourceLine 1370
    PrintFile$ inspect$1369$206=null;
    // JavaLine 29 <== SourceLine 1372
    Common$const$ inspect$1372$207=null;
    // JavaLine 31 <== SourceLine 1391
    Common$quant inspect$1390$208=null;
    // JavaLine 33 <== SourceLine 1408
    Common$quant inspect$1408$209=null;
    // JavaLine 35 <== SourceLine 1411
    Common$TypeNotice inspect$1410$210=null;
    // JavaLine 37 <== SourceLine 1418
    Common$quant inspect$1418$211=null;
    // JavaLine 39 <== SourceLine 1435
    Common$routine inspect$1435$212=null;
    // JavaLine 41 <== SourceLine 1476
    PrintFile$ inspect$1475$213=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$outconst setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$outconst.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$c=(Common$const$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$outconst(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$outconst(RTObject$ SL$,Common$const$ sp$c) {
        super(SL$);
        // Parameter assignment to locals
        this.p$c = sp$c;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$outconst STM$() {
        // JavaLine 70 <== SourceLine 1369
        if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).tracemode>(2)))) {
            {
                // BEGIN INSPECTION 
                inspect$1369$206=sysout();
                if(inspect$1369$206!=null) // INSPECT inspect$1369$206
                // JavaLine 76 <== SourceLine 1370
                {
                    inspect$1369$206.outtext(new TXT$("Outconst: "));
                    ;
                    new Common$prt(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,p$c,5);
                    ;
                    inspect$1369$206.outimage();
                }
            }
        }
        ;
        // JavaLine 87 <== SourceLine 1372
        {
            // BEGIN INSPECTION 
            inspect$1372$207=p$c;
            //INSPECT inspect$1372$207
            if(inspect$1372$207 instanceof Common$val_const) // WHEN Common$val_const DO 
            // JavaLine 93 <== SourceLine 1373
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$val_const)(inspect$1372$207)).p3$instr);
                ;
                // JavaLine 97 <== SourceLine 1374
                if(VALUE$((((Common$val_const)(inspect$1372$207)).p3$instr==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_CHAR$1)))) {
                    // JavaLine 99 <== SourceLine 1375
                    {
                        cnstype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_CHAR$1;
                        ;
                        // JavaLine 103 <== SourceLine 1376
                        new OuptFile$outbyt(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,rank(TXT$.getchar(((Common$val_const)(inspect$1372$207)).p4$v)));
                    }
                } else
                if(VALUE$((((Common$val_const)(inspect$1372$207)).p3$instr==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_TEXT$1)))) {
                    // JavaLine 108 <== SourceLine 1377
                    {
                        cnstype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_CHAR$1;
                        ;
                        // JavaLine 112 <== SourceLine 1378
                        new OuptFile$outlongstring(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$val_const)(inspect$1372$207)).p4$v);
                    }
                } else
                {
                    new OuptFile$outstring(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$val_const)(inspect$1372$207)).p4$v);
                    ;
                    // JavaLine 119 <== SourceLine 1379
                    cnstype=(((((Common$val_const)(inspect$1372$207)).p3$instr==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_INT$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_INT$1):((((((Common$val_const)(inspect$1372$207)).p3$instr==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_REAL$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REAL$1):((((((Common$val_const)(inspect$1372$207)).p3$instr==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_LREAL$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_LREAL$1):(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_UNDEF$1))))));
                    ;
                }
                ;
            }
            else if(inspect$1372$207 instanceof Common$offset_const) // WHEN Common$offset_const DO 
            // JavaLine 126 <== SourceLine 1386
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$offset_const)(inspect$1372$207)).p3$instr);
                ;
                // JavaLine 130 <== SourceLine 1387
                dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[((Common$offset_const)(inspect$1372$207)).of$4-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                ;
                // JavaLine 133 <== SourceLine 1388
                if(VALUE$((!(IS$(dentry,Common$record.class))))) {
                    // JavaLine 135 <== SourceLine 1389
                    dentry=new Pass2$CompoundStatement21$SubBlock23$get_rec(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$offset_const)(inspect$1372$207)).of$4).RESULT$;
                }
                ;
                // JavaLine 139 <== SourceLine 1390
                {
                    // BEGIN INSPECTION 
                    inspect$1390$208=new Common$rec_atr(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$record)(dentry)),((Common$offset_const)(inspect$1372$207)).q.Elt[1-((Common$offset_const)(inspect$1372$207)).q.LB[0]]).RESULT$;
                    if(inspect$1390$208!=null) // INSPECT inspect$1390$208
                    // JavaLine 144 <== SourceLine 1392
                    {
                        new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$1390$208.tag$2);
                        ;
                        // JavaLine 148 <== SourceLine 1393
                        cnstype=new Common$defType(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.fieldTypes$1,inspect$1390$208.p3$type,0,0).RESULT$;
                        ;
                    }
                }
                ;
            }
            else if(inspect$1372$207 instanceof Common$idn_const) // WHEN Common$idn_const DO 
            // JavaLine 156 <== SourceLine 1397
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$idn_const)(inspect$1372$207)).p3$instr);
                ;
                // JavaLine 160 <== SourceLine 1398
                if(VALUE$((((Common$idn_const)(inspect$1372$207)).p3$instr==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_SIZE$1)))) {
                    // JavaLine 162 <== SourceLine 1399
                    {
                        dentry=((Common$idn_const)(inspect$1372$207)).p4$ibox.curmeaning;
                        ;
                        // JavaLine 166 <== SourceLine 1400
                        if(VALUE$((!(IS$(dentry,Common$record.class))))) {
                            // JavaLine 168 <== SourceLine 1401
                            dentry=new Pass2$CompoundStatement21$SubBlock23$get_rec(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$idn_const)(inspect$1372$207)).p4$ibox.id).RESULT$;
                        }
                        ;
                        // JavaLine 172 <== SourceLine 1402
                        new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$record)(dentry)).tag$2);
                        ;
                        // JavaLine 175 <== SourceLine 1403
                        cnstype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_SIZE$1;
                    }
                } else
                // JavaLine 179 <== SourceLine 1404
                if(VALUE$((((Common$idn_const)(inspect$1372$207)).p3$instr==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_OADDR$1)))) {
                    // JavaLine 181 <== SourceLine 1405
                    {
                        dentry=((Common$idn_const)(inspect$1372$207)).p4$ibox.curmeaning;
                        ;
                        // JavaLine 185 <== SourceLine 1406
                        if(VALUE$((!(IS$(dentry,Common$quant.class))))) {
                            // JavaLine 187 <== SourceLine 1407
                            dentry=new Pass2$CompoundStatement21$SubBlock23$get_qnt(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$idn_const)(inspect$1372$207)).p4$ibox.id).RESULT$;
                        }
                        ;
                        // JavaLine 191 <== SourceLine 1408
                        {
                            // BEGIN INSPECTION 
                            inspect$1408$209=((Common$quant)(dentry));
                            if(inspect$1408$209!=null) // INSPECT inspect$1408$209
                            // JavaLine 196 <== SourceLine 1409
                            {
                                new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$1408$209.tag$2);
                                ;
                                // JavaLine 200 <== SourceLine 1410
                                {
                                    // BEGIN INSPECTION 
                                    inspect$1410$210=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[inspect$1408$209.p3$type-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]];
                                    if(inspect$1410$210!=null) // INSPECT inspect$1410$210
                                    // JavaLine 205 <== SourceLine 1411
                                    cnstype=new Common$defType(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.refTypes$1,inspect$1410$210.p2$qual,0,0).RESULT$;
                                }
                                ;
                            }
                        }
                        ;
                    }
                } else
                // JavaLine 214 <== SourceLine 1414
                if(VALUE$((((Common$idn_const)(inspect$1372$207)).p3$instr==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_GADDR$1)))) {
                    // JavaLine 216 <== SourceLine 1415
                    {
                        dentry=((Common$idn_const)(inspect$1372$207)).p4$ibox.curmeaning;
                        ;
                        // JavaLine 220 <== SourceLine 1416
                        if(VALUE$((!(IS$(dentry,Common$quant.class))))) {
                            // JavaLine 222 <== SourceLine 1417
                            dentry=new Pass2$CompoundStatement21$SubBlock23$get_qnt(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$idn_const)(inspect$1372$207)).p4$ibox.id).RESULT$;
                        }
                        ;
                        // JavaLine 226 <== SourceLine 1418
                        {
                            // BEGIN INSPECTION 
                            inspect$1418$211=((Common$quant)(dentry));
                            if(inspect$1418$211!=null) // INSPECT inspect$1418$211
                            // JavaLine 231 <== SourceLine 1419
                            {
                                new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$1418$211.tag$2);
                                ;
                                // JavaLine 235 <== SourceLine 1420
                                cnstype=new Common$defType(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.nameTypes$1,inspect$1418$211.p3$type,0,0).RESULT$;
                                ;
                                // JavaLine 238 <== SourceLine 1421
                                if(VALUE$((inspect$1418$211.global$2||(inspect$1418$211.read_only$3)))) {
                                    ;
                                } else
                                // JavaLine 242 <== SourceLine 1422
                                new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Local variable in name(..) constant"));
                                ;
                            }
                        }
                        ;
                    }
                } else
                // JavaLine 250 <== SourceLine 1425
                if(VALUE$((((Common$idn_const)(inspect$1372$207)).p3$instr==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_PADDR$1)))) {
                    // JavaLine 252 <== SourceLine 1426
                    {
                        dentry=((Common$idn_const)(inspect$1372$207)).p4$ibox.curmeaning;
                        ;
                        // JavaLine 256 <== SourceLine 1427
                        if(VALUE$((!(IS$(dentry,Common$label_descr.class))))) {
                            // JavaLine 258 <== SourceLine 1428
                            dentry=new Pass2$CompoundStatement21$SubBlock23$get_lab(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$idn_const)(inspect$1372$207)).p4$ibox.id).RESULT$;
                        }
                        ;
                        // JavaLine 262 <== SourceLine 1429
                        new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$label_descr)(dentry)).tag$2);
                        ;
                        // JavaLine 265 <== SourceLine 1430
                        cnstype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_LABEL$1;
                    }
                } else
                // JavaLine 269 <== SourceLine 1431
                if(VALUE$((((Common$idn_const)(inspect$1372$207)).p3$instr==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_RADDR$1)))) {
                    // JavaLine 271 <== SourceLine 1432
                    {
                        dentry=((Common$idn_const)(inspect$1372$207)).p4$ibox.curmeaning;
                        ;
                        // JavaLine 275 <== SourceLine 1433
                        if(VALUE$((!(IS$(dentry,Common$routine.class))))) {
                            // JavaLine 277 <== SourceLine 1434
                            dentry=new Pass2$CompoundStatement21$SubBlock23$get_ent(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$idn_const)(inspect$1372$207)).p4$ibox.id).RESULT$;
                        }
                        ;
                        // JavaLine 281 <== SourceLine 1435
                        {
                            // BEGIN INSPECTION 
                            inspect$1435$212=((Common$routine)(dentry));
                            if(inspect$1435$212!=null) // INSPECT inspect$1435$212
                            // JavaLine 286 <== SourceLine 1436
                            {
                                new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$1435$212.tag$2);
                                ;
                                // JavaLine 290 <== SourceLine 1437
                                cnstype=new Common$defType(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.entTypes$1,inspect$1435$212.profbox$3.id,0,0).RESULT$;
                                ;
                            }
                        }
                        ;
                    }
                }
                ;
            }
            else if(inspect$1372$207 instanceof Common$structured_const) // WHEN Common$structured_const DO 
            // JavaLine 301 <== SourceLine 1442
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$structured_const)(inspect$1372$207)).p3$instr);
                ;
                // JavaLine 305 <== SourceLine 1443
                dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[((Common$structured_const)(inspect$1372$207)).str$4-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                ;
                // JavaLine 308 <== SourceLine 1444
                if(VALUE$((!(IS$(dentry,Common$record.class))))) {
                    // JavaLine 310 <== SourceLine 1445
                    dentry=new Pass2$CompoundStatement21$SubBlock23$get_rec(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$structured_const)(inspect$1372$207)).str$4).RESULT$;
                }
                ;
                // JavaLine 314 <== SourceLine 1446
                new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$record)(dentry)).tag$2);
                ;
                // JavaLine 317 <== SourceLine 1447
                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                }
                ;
                // JavaLine 322 <== SourceLine 1448
                fixrep=new Pass2$CompoundStatement21$SubBlock23$outstruct(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$record)(dentry)),((Common$structured_const)(inspect$1372$207)).elt_set$4).RESULT$;
                ;
                // JavaLine 325 <== SourceLine 1449
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ENDRECORD$1);
                ;
                // JavaLine 328 <== SourceLine 1450
                if(VALUE$((!(((Common$structured_const)(inspect$1372$207)).elt_set$4.empty())))) {
                    // JavaLine 330 <== SourceLine 1451
                    new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Extra unmatched element(s) in constant"));
                }
                ;
                // JavaLine 334 <== SourceLine 1452
                cnstype=new Common$defType(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.structTypes$1,((Common$structured_const)(inspect$1372$207)).str$4,fixrep,0).RESULT$;
                ;
            }
            else if(inspect$1372$207 instanceof Common$repeated_const) // WHEN Common$repeated_const DO 
            // JavaLine 339 <== SourceLine 1455
            {
                e=((Common$const$)(((Common$repeated_const)(inspect$1372$207)).elt_set$4.first()));
                ;
                cnstype=t=new Pass2$CompoundStatement21$SubBlock23$outconst(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),e).RESULT$;
                ;
                e=((Common$const$)(e.suc()));
                while((e!=(null))) {
                    // JavaLine 347 <== SourceLine 1457
                    {
                        t1=new Pass2$CompoundStatement21$SubBlock23$outconst(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),e).RESULT$;
                        ;
                        // JavaLine 351 <== SourceLine 1458
                        if(VALUE$(((t1!=(t))&&((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[t-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[t1-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set)))))) {
                            // JavaLine 353 <== SourceLine 1459
                            new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Different types in repeated constant"));
                        }
                        ;
                    }
                    e=((Common$const$)(e.suc()));
                }
                ;
            }
            else // OTHERWISE 
            // JavaLine 363 <== SourceLine 1463
            {
                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,p$c.p3$instr);
                ;
                // JavaLine 367 <== SourceLine 1464
                cnstype=((((p$c.p3$instr==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_TRUE$1))||((p$c.p3$instr==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_FALSE$1)))))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_BOOL$1):((((p$c.p3$instr==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ONONE$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REF$1):((((p$c.p3$instr==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ANONE$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_FIELD$1):((((p$c.p3$instr==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_GNONE$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_NAME$1):((((p$c.p3$instr==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_NOSIZE$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_SIZE$1):((((p$c.p3$instr==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_NOWHERE$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_LABEL$1):((((p$c.p3$instr==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_NOBODY$1)))?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_ENT$1):(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_UNDEF$1))))))))))))));
                ;
            }
        }
        ;
        // JavaLine 373 <== SourceLine 1474
        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
        }
        ;
        // JavaLine 378 <== SourceLine 1475
        if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).tracemode>(2)))) {
            {
                // BEGIN INSPECTION 
                inspect$1475$213=sysout();
                if(inspect$1475$213!=null) // INSPECT inspect$1475$213
                // JavaLine 384 <== SourceLine 1476
                {
                    inspect$1475$213.outtext(CONC(new TXT$("Outconst type: "),new Common$edtype(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,cnstype).RESULT$));
                    ;
                    // JavaLine 388 <== SourceLine 1477
                    inspect$1475$213.outimage();
                    ;
                }
            }
        }
        ;
        // JavaLine 395 <== SourceLine 1479
        RESULT$=cnstype;
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure outconst",1,1362,14,1363,16,1364,18,1365,20,1366,24,1367,27,1370,29,1372,31,1391,33,1408,35,1411,37,1418,39,1435,41,1476,70,1369,76,1370,87,1372,93,1373,97,1374,99,1375,103,1376,108,1377,112,1378,119,1379,126,1386,130,1387,133,1388,135,1389,139,1390,144,1392,148,1393,156,1397,160,1398,162,1399,166,1400,168,1401,172,1402,175,1403,179,1404,181,1405,185,1406,187,1407,191,1408,196,1409,200,1410,205,1411,214,1414,216,1415,220,1416,222,1417,226,1418,231,1419,235,1420,238,1421,242,1422,250,1425,252,1426,256,1427,258,1428,262,1429,265,1430,269,1431,271,1432,275,1433,277,1434,281,1435,286,1436,290,1437,301,1442,305,1443,308,1444,310,1445,314,1446,317,1447,322,1448,325,1449,328,1450,330,1451,334,1452,339,1455,347,1457,351,1458,353,1459,363,1463,367,1464,373,1474,378,1475,384,1476,388,1477,395,1479,400,1480);
} // End of Procedure
