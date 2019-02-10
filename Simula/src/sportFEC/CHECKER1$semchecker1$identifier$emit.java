// JavaLine 1 ==> SourceLine 1412
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$identifier$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1412, lastLine=1481, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 1438
    final LABQNT$ IDNout=new LABQNT$(this,0,1); // Local Label #1=IDNout
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$identifier$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",1438);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$identifier$emit STM$() {
        TRACE_BEGIN_STM$("emit",1438);
        CHECKER1$semchecker1$identifier$emit THIS$=(CHECKER1$semchecker1$identifier$emit)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 30 ==> SourceLine 1414
                switch(((CHECKER1$semchecker1$identifier)(CUR$.SL$)).cl) { // BEGIN SWITCH STATEMENT
                case 1: 
                // JavaLine 33 ==> SourceLine 1416
                {
                    TRACE_BEGIN_STM$("CompoundStatement1416",1416);
                    switch(((CHECKER1$semchecker1$identifier)(CUR$.SL$)).p$ch) { // BEGIN SWITCH STATEMENT
                    case 93: 
                    case 92: 
                    // JavaLine 39 ==> SourceLine 1419
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1419",1419);
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).blockpref=((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning;
                        new BUILDER2$prechecker$allocate(((CHECKER1$semchecker1)(CUR$.SL$.SL$)));
                        // JavaLine 44 ==> SourceLine 1420
                        ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=new COMMON$getBrc(((CHECKER1)(CUR$.SL$.SL$.SL$)),((CHECKER1$semchecker1)(CUR$.SL$.SL$)).lastblhi,((CHECKER1$semchecker1)(CUR$.SL$.SL$)).lastbllo).RESULT$.declquant;
                        // JavaLine 46 ==> SourceLine 1421
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IBLKB;
                        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                        // JavaLine 49 ==> SourceLine 1422
                        if(VALUE$((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).p$ch==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IBPRF)))) {
                            // JavaLine 51 ==> SourceLine 1423
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1423",1423);
                                if(VALUE$((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning!=(null)))) {
                                    // JavaLine 55 ==> SourceLine 1425
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1425",1425);
                                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IBEFO;
                                        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                                        TRACE_END_STM$("CompoundStatement1425",1425);
                                    }
                                }
                                // JavaLine 63 ==> SourceLine 1427
                                new CHECKER1$semchecker1$enterblock(((CHECKER1$semchecker1)(CUR$.SL$.SL$)));
                                TRACE_END_STM$("CompoundStatement1423",1427);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement1419",1427);
                    }
                    case 115: 
                    // JavaLine 71 ==> SourceLine 1431
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1431",1431);
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IDOTP;
                        ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning;
                        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                        TRACE_END_STM$("CompoundStatement1431",1431);
                    }
                    case 129: 
                    case 134: 
                    // JavaLine 81 ==> SourceLine 1433
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1433",1433);
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDN;
                        ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning;
                        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                        TRACE_END_STM$("CompoundStatement1433",1433);
                    }
                    case 34: 
                    // JavaLine 90 ==> SourceLine 1435
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1435",1435);
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDN;
                        GOTO$(IDNout); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement1435",1435);
                    }
                    case 90: 
                    case 76: 
                    // JavaLine 99 ==> SourceLine 1437
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1437",1437);
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1$semchecker1$identifier)(CUR$.SL$)).p$ch;
                        // JavaLine 103 ==> SourceLine 1438
                        LABEL$(1,"IDNout");
                        ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning;
                        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                        // JavaLine 107 ==> SourceLine 1439
                        switch(((CHECKER1$semchecker1$identifier)(CUR$.SL$)).kind) { // BEGIN SWITCH STATEMENT
                        case 1: 
                        // JavaLine 110 ==> SourceLine 1441
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1441",1441);
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).lastopc=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc;
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IPROC;
                            call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                            // JavaLine 116 ==> SourceLine 1442
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).lastopc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IPROC;
                            // JavaLine 118 ==> SourceLine 1443
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=(((((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.categ==(((CHECKER1)(CUR$.SL$.SL$.SL$)).C_local))||((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.categ==(((CHECKER1)(CUR$.SL$.SL$.SL$)).C_extnal))))||(((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.categ==(((CHECKER1)(CUR$.SL$.SL$.SL$)).C_virt))&&((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.descr!=(null)))))))?(((CHECKER1)(CUR$.SL$.SL$.SL$)).IEPRM):(((CHECKER1)(CUR$.SL$.SL$.SL$)).IUPLS));
                            // JavaLine 120 ==> SourceLine 1450
                            call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                            TRACE_END_STM$("CompoundStatement1441",1450);
                        }
                        case 5: 
                        // JavaLine 125 ==> SourceLine 1453
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1453",1453);
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IAT;
                            call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                            TRACE_END_STM$("CompoundStatement1453",1453);
                        }
                    } // END SWITCH STATEMENT
                    TRACE_END_STM$("CompoundStatement1437",1453);
                }
            } // END SWITCH STATEMENT
            TRACE_END_STM$("CompoundStatement1416",1453);
        }
        case 6: 
        case 4: 
        // JavaLine 140 ==> SourceLine 1460
        {
            TRACE_BEGIN_STM$("CompoundStatement1460",1460);
            ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning;
            // JavaLine 144 ==> SourceLine 1461
            if(VALUE$((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).kind==(((CHECKER1)(CUR$.SL$.SL$.SL$)).K_proc)))) {
                // JavaLine 146 ==> SourceLine 1462
                {
                    TRACE_BEGIN_STM$("CompoundStatement1462",1462);
                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IDCLP;
                    // JavaLine 150 ==> SourceLine 1463
                    if(VALUE$((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.categ==(((CHECKER1)(CUR$.SL$.SL$.SL$)).C_virt)))) {
                        // JavaLine 152 ==> SourceLine 1464
                        ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.match;
                    }
                    TRACE_END_STM$("CompoundStatement1462",1464);
                }
            } else
            // JavaLine 158 ==> SourceLine 1467
            {
                TRACE_BEGIN_STM$("CompoundStatement1467",1467);
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDNP;
                if(VALUE$((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).cl==(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).ITEXTcl)))) {
                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=((char)1);
                }
                TRACE_END_STM$("CompoundStatement1467",1467);
            }
            // JavaLine 167 ==> SourceLine 1469
            call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
            TRACE_END_STM$("CompoundStatement1460",1469);
        }
        case 5: 
        // JavaLine 172 ==> SourceLine 1472
        {
            TRACE_BEGIN_STM$("CompoundStatement1472",1472);
            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).lastopc=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc;
            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ISSWA;
            ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning;
            // JavaLine 178 ==> SourceLine 1473
            call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
            TRACE_END_STM$("CompoundStatement1472",1473);
        }
        default:
        // JavaLine 183 ==> SourceLine 1476
        new ERRMSG$internerr(((CHECKER1)(CUR$.SL$.SL$.SL$)),((char)8),1476);
    } // END SWITCH STATEMENT
    // JavaLine 186 ==> SourceLine 1479
    if(VALUE$(IS$(((CHECKER1$semchecker1$identifier)(CUR$.SL$)),CHECKER1$semchecker1$simpleIdent.class))) {
        // JavaLine 188 ==> SourceLine 1480
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).simpleList=((CHECKER1$semchecker1$simpleIdent)(((CHECKER1$semchecker1$identifier)(CUR$.SL$))));
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
TRACE_END_STM$("emit",1480);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,1412,11,1438,30,1414,33,1416,39,1419,44,1420,46,1421,49,1422,51,1423,55,1425,63,1427,71,1431,81,1433,90,1435,99,1437,103,1438,107,1439,110,1441,116,1442,118,1443,120,1450,125,1453,140,1460,144,1461,146,1462,150,1463,152,1464,158,1467,167,1469,172,1472,178,1473,183,1476,186,1479,188,1480,207,1481);
}
