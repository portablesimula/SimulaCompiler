// JavaLine 1 ==> SourceLine 1412
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$identifier$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1412, lastLine=1481, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // Normal Constructor
    public CHECKER1$semchecker1$identifier$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",1412);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$identifier$emit STM$() {
        TRACE_BEGIN_STM$("emit",1412);
        // JavaLine 23 ==> SourceLine 1414
        switch(((CHECKER1$semchecker1$identifier)(CUR$.SL$)).cl) { // BEGIN SWITCH STATEMENT
        case 1: 
        // JavaLine 26 ==> SourceLine 1416
        {
            TRACE_BEGIN_STM$("CompoundStatement1416",1416);
            switch(((CHECKER1$semchecker1$identifier)(CUR$.SL$)).p$ch) { // BEGIN SWITCH STATEMENT
            case 93: 
            case 92: 
            // JavaLine 32 ==> SourceLine 1419
            {
                TRACE_BEGIN_STM$("CompoundStatement1419",1419);
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).blockpref=((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning;
                new BUILDER2$prechecker$allocate(((CHECKER1$semchecker1)(CUR$.SL$.SL$)));
                // JavaLine 37 ==> SourceLine 1420
                ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=new COMMON$getBrc(((CHECKER1)(CUR$.SL$.SL$.SL$)),((CHECKER1$semchecker1)(CUR$.SL$.SL$)).lastblhi,((CHECKER1$semchecker1)(CUR$.SL$.SL$)).lastbllo).RESULT$.declquant;
                // JavaLine 39 ==> SourceLine 1421
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IBLKB;
                call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                // JavaLine 42 ==> SourceLine 1422
                if((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).p$ch==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IBPRF))) {
                    // JavaLine 44 ==> SourceLine 1423
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1423",1423);
                        if((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning!=(null))) {
                            // JavaLine 48 ==> SourceLine 1425
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1425",1425);
                                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IBEFO;
                                call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                                TRACE_END_STM$("CompoundStatement1425",1425);
                            }
                        }
                        // JavaLine 56 ==> SourceLine 1427
                        new CHECKER1$semchecker1$enterblock(((CHECKER1$semchecker1)(CUR$.SL$.SL$)));
                        TRACE_END_STM$("CompoundStatement1423",1427);
                    }
                }
                TRACE_END_STM$("CompoundStatement1419",1427);
            }
            case 115: 
            // JavaLine 64 ==> SourceLine 1431
            {
                TRACE_BEGIN_STM$("CompoundStatement1431",1431);
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IDOTP;
                ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning;
                call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                TRACE_END_STM$("CompoundStatement1431",1431);
            }
            case 129: 
            case 134: 
            // JavaLine 74 ==> SourceLine 1433
            {
                TRACE_BEGIN_STM$("CompoundStatement1433",1433);
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDN;
                ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning;
                call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                TRACE_END_STM$("CompoundStatement1433",1433);
            }
            case 34: 
            // JavaLine 83 ==> SourceLine 1435
            {
                TRACE_BEGIN_STM$("CompoundStatement1435",1435);
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDN;
                GOTO$(((CHECKER1$semchecker1$identifier)(CUR$.SL$)).IDNout); // GOTO EVALUATED LABEL
                TRACE_END_STM$("CompoundStatement1435",1435);
            }
            case 90: 
            case 76: 
            // JavaLine 92 ==> SourceLine 1437
            {
                TRACE_BEGIN_STM$("CompoundStatement1437",1437);
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1$semchecker1$identifier)(CUR$.SL$)).p$ch;
                // JavaLine 96 ==> SourceLine 1438
                LABEL$(1); // IDNout
                ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning;
                call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                // JavaLine 100 ==> SourceLine 1439
                switch(((CHECKER1$semchecker1$identifier)(CUR$.SL$)).kind) { // BEGIN SWITCH STATEMENT
                case 1: 
                // JavaLine 103 ==> SourceLine 1441
                {
                    TRACE_BEGIN_STM$("CompoundStatement1441",1441);
                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).lastopc=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc;
                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IPROC;
                    call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                    // JavaLine 109 ==> SourceLine 1442
                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).lastopc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IPROC;
                    // JavaLine 111 ==> SourceLine 1443
                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=(((((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.categ==(((CHECKER1)(CUR$.SL$.SL$.SL$)).C_local))||((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.categ==(((CHECKER1)(CUR$.SL$.SL$.SL$)).C_extnal))))||(((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.categ==(((CHECKER1)(CUR$.SL$.SL$.SL$)).C_virt))&&((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.descr!=(null)))))))?(((CHECKER1)(CUR$.SL$.SL$.SL$)).IEPRM):(((CHECKER1)(CUR$.SL$.SL$.SL$)).IUPLS));
                    // JavaLine 113 ==> SourceLine 1450
                    call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                    TRACE_END_STM$("CompoundStatement1441",1450);
                }
                case 5: 
                // JavaLine 118 ==> SourceLine 1453
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
// JavaLine 133 ==> SourceLine 1460
{
    TRACE_BEGIN_STM$("CompoundStatement1460",1460);
    ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning;
    // JavaLine 137 ==> SourceLine 1461
    if((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).kind==(((CHECKER1)(CUR$.SL$.SL$.SL$)).K_proc))) {
        // JavaLine 139 ==> SourceLine 1462
        {
            TRACE_BEGIN_STM$("CompoundStatement1462",1462);
            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IDCLP;
            // JavaLine 143 ==> SourceLine 1463
            if((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.categ==(((CHECKER1)(CUR$.SL$.SL$.SL$)).C_virt))) {
                // JavaLine 145 ==> SourceLine 1464
                ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.match;
            }
            TRACE_END_STM$("CompoundStatement1462",1464);
        }
    } else
    // JavaLine 151 ==> SourceLine 1467
    {
        TRACE_BEGIN_STM$("CompoundStatement1467",1467);
        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDNP;
        if((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).cl==(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).ITEXTcl))) {
            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=((char)1);
        }
        TRACE_END_STM$("CompoundStatement1467",1467);
    }
    // JavaLine 160 ==> SourceLine 1469
    call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
    TRACE_END_STM$("CompoundStatement1460",1469);
}
case 5: 
// JavaLine 165 ==> SourceLine 1472
{
    TRACE_BEGIN_STM$("CompoundStatement1472",1472);
    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).lastopc=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc;
    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ISSWA;
    ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning;
    // JavaLine 171 ==> SourceLine 1473
    call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
    TRACE_END_STM$("CompoundStatement1472",1473);
}
default:
// JavaLine 176 ==> SourceLine 1476
new ERRMSG$internerr(((CHECKER1)(CUR$.SL$.SL$.SL$)),((char)8),1476);
} // END SWITCH STATEMENT
// JavaLine 179 ==> SourceLine 1479
if(IS$(((CHECKER1$semchecker1$identifier)(CUR$.SL$)),CHECKER1$semchecker1$simpleIdent.class)) {
// JavaLine 181 ==> SourceLine 1480
((CHECKER1$semchecker1)(CUR$.SL$.SL$)).simpleList=((CHECKER1$semchecker1$simpleIdent)(((CHECKER1$semchecker1$identifier)(CUR$.SL$))));
}
TRACE_END_STM$("emit",1480);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,1412,23,1414,26,1416,32,1419,37,1420,39,1421,42,1422,44,1423,48,1425,56,1427,64,1431,74,1433,83,1435,92,1437,96,1438,100,1439,103,1441,109,1442,111,1443,113,1450,118,1453,133,1460,137,1461,139,1462,143,1463,145,1464,151,1467,160,1469,165,1472,171,1473,176,1476,179,1479,181,1480,187,1481);
}
