// JavaLine 1 ==> SourceLine 1565
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$dotIdent$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1565, lastLine=1641, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 1567
    CHECKER1$semchecker1$exp inspect$1567$12=null;
    // JavaLine 13 ==> SourceLine 1585
    CHECKER1$semchecker1$exp inspect$1585$13=null;
    // Normal Constructor
    public CHECKER1$semchecker1$dotIdent$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",1585);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$dotIdent$emit STM$() {
        TRACE_BEGIN_STM$("emit",1585);
        // JavaLine 27 ==> SourceLine 1567
        {
            // BEGIN INSPECTION 
            inspect$1567$12=((CHECKER1$semchecker1$dotIdent)(CUR$.SL$)).p2$dotexp;
            if(inspect$1567$12!=null) //INSPECT inspect$1567$12
            // JavaLine 32 ==> SourceLine 1568
            {
                TRACE_BEGIN_STM$("CompoundStatement1568",1568);
                inspect$1567$12.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
                // JavaLine 36 ==> SourceLine 1569
                if(VALUE$((inspect$1567$12.type==(((CHECKER1)(CUR$.SL$.SL$.SL$)).ITEXT)))) {
                    // JavaLine 38 ==> SourceLine 1570
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1570",1570);
                        if(VALUE$((inspect$1567$12.ctype==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDNP)))) {
                            // JavaLine 42 ==> SourceLine 1571
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1571",1571);
                                if(VALUE$(((((CHECKER1$semchecker1$argumented)(((CHECKER1$semchecker1$exp)inspect$1567$12))).p1$ident.kind==(((CHECKER1)(CUR$.SL$.SL$.SL$)).K_array))|((((CHECKER1$semchecker1$argumented)(((CHECKER1$semchecker1$exp)inspect$1567$12))).p1$ident.kind==(((CHECKER1)(CUR$.SL$.SL$.SL$)).K_rep)))))) {
                                    // JavaLine 46 ==> SourceLine 1573
                                    inspect$1567$12.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).ITOcl;
                                }
                                TRACE_END_STM$("CompoundStatement1571",1573);
                            }
                        } else
                        // JavaLine 52 ==> SourceLine 1575
                        if(VALUE$((inspect$1567$12.ctype==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDN)))) {
                            // JavaLine 54 ==> SourceLine 1576
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1576",1576);
                                if(VALUE$((inspect$1567$12.kind!=(((CHECKER1)(CUR$.SL$.SL$.SL$)).K_proc)))) {
                                    // JavaLine 58 ==> SourceLine 1577
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1577",1577);
                                        inspect$1567$12.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).ITEXTcl;
                                        ((CHECKER1$semchecker1$dotIdent)(CUR$.SL$)).cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
                                        TRACE_END_STM$("CompoundStatement1577",1577);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement1576",1577);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement1570",1577);
                    }
                }
                // JavaLine 72 ==> SourceLine 1581
                inspect$1567$12.emit$0().CPF();
                TRACE_END_STM$("CompoundStatement1568",1581);
            }
        }
        // JavaLine 77 ==> SourceLine 1584
        if(VALUE$((((CHECKER1$semchecker1$dotIdent)(CUR$.SL$)).cl==(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl)))) {
            // JavaLine 79 ==> SourceLine 1585
            {
                TRACE_BEGIN_STM$("CompoundStatement1585",1585);
                {
                    // BEGIN INSPECTION 
                    inspect$1585$13=((CHECKER1$semchecker1$dotIdent)(CUR$.SL$)).p2$dotexp;
                    if(inspect$1585$13!=null) //INSPECT inspect$1585$13
                    // JavaLine 86 ==> SourceLine 1587
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1587",1587);
                        if(VALUE$((inspect$1585$13.type==(((CHECKER1)(CUR$.SL$.SL$.SL$)).ITEXT)))) {
                            // JavaLine 90 ==> SourceLine 1588
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((((inspect$1585$13.cl==(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).ITOcl))||((inspect$1585$13.cl==(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).ITEXTcl)))))?(((CHECKER1)(CUR$.SL$.SL$.SL$)).INOTY):(((CHECKER1)(CUR$.SL$.SL$.SL$)).INOTE));
                        } else
                        // JavaLine 93 ==> SourceLine 1593
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1593",1593);
                            if(VALUE$((((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc!=(((CHECKER1)(CUR$.SL$.SL$.SL$)).IQUA)))) {
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1593",1593);
                                    // JavaLine 99 ==> SourceLine 1594
                                    if(VALUE$(((CHECKER1)(CUR$.SL$.SL$.SL$)).NoneCheck)) {
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1594",1594);
                                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IQUA;
                                            call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                                            TRACE_END_STM$("CompoundStatement1594",1594);
                                        }
                                    }
                                    TRACE_END_STM$("CompoundStatement1593",1594);
                                }
                            }
                            // JavaLine 111 ==> SourceLine 1595
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IDOT;
                            TRACE_END_STM$("CompoundStatement1593",1595);
                        }
                        // JavaLine 115 ==> SourceLine 1597
                        ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$dotIdent)(CUR$.SL$)).meaning;
                        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                        TRACE_END_STM$("CompoundStatement1587",1597);
                    }
                }
                // JavaLine 121 ==> SourceLine 1599
                if(VALUE$((((CHECKER1$semchecker1$dotIdent)(CUR$.SL$)).p$ch==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IDOT)))) {
                    // JavaLine 123 ==> SourceLine 1601
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1601",1601);
                        switch(((CHECKER1$semchecker1$dotIdent)(CUR$.SL$)).kind) { // BEGIN SWITCH STATEMENT
                        case 1: 
                        // JavaLine 128 ==> SourceLine 1603
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1603",1603);
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).lastopc=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc;
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IPROC;
                            call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                            // JavaLine 134 ==> SourceLine 1604
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).lastopc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IPROC;
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IEPRM;
                            // JavaLine 137 ==> SourceLine 1605
                            switch(((CHECKER1$semchecker1$dotIdent)(CUR$.SL$)).meaning.categ) { // BEGIN SWITCH STATEMENT
                            case 3: 
                            case 4: 
                            case 6: 
                            // JavaLine 142 ==> SourceLine 1608
                            if(VALUE$((((CHECKER1$semchecker1$dotIdent)(CUR$.SL$)).meaning.descr==(null)))) {
                                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IUPLS;
                            }
                            default:
                            // JavaLine 147 ==> SourceLine 1609
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IUPLS;
                        } // END SWITCH STATEMENT
                        // JavaLine 150 ==> SourceLine 1618
                        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                        TRACE_END_STM$("CompoundStatement1603",1618);
                    }
                    case 5: 
                    // JavaLine 155 ==> SourceLine 1622
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1622",1622);
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IAT;
                        call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                        TRACE_END_STM$("CompoundStatement1622",1622);
                    }
                } // END SWITCH STATEMENT
                TRACE_END_STM$("CompoundStatement1601",1622);
            }
        }
        TRACE_END_STM$("CompoundStatement1585",1622);
    }
} else
// JavaLine 169 ==> SourceLine 1628
{
    TRACE_BEGIN_STM$("CompoundStatement1628",1628);
    if(VALUE$((((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc!=(((CHECKER1)(CUR$.SL$.SL$.SL$)).IQUA)))) {
        {
            TRACE_BEGIN_STM$("CompoundStatement1628",1628);
            // JavaLine 175 ==> SourceLine 1629
            if(VALUE$(((CHECKER1)(CUR$.SL$.SL$.SL$)).NoneCheck)) {
                {
                    TRACE_BEGIN_STM$("CompoundStatement1629",1629);
                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IQUA;
                    call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                    TRACE_END_STM$("CompoundStatement1629",1629);
                }
            }
            TRACE_END_STM$("CompoundStatement1628",1629);
        }
    }
    // JavaLine 187 ==> SourceLine 1630
    ((CHECKER1)(CUR$.SL$.SL$.SL$)).coder.opq=((CHECKER1$semchecker1$dotIdent)(CUR$.SL$)).meaning;
    // JavaLine 189 ==> SourceLine 1631
    if(VALUE$(((((CHECKER1$semchecker1$dotIdent)(CUR$.SL$)).cl==(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).ITEXTcl))||((((CHECKER1$semchecker1$dotIdent)(CUR$.SL$)).cl==(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).ITOcl)))))) {
        // JavaLine 191 ==> SourceLine 1633
        {
            TRACE_BEGIN_STM$("CompoundStatement1633",1633);
            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IDOTP;
            TRACE_END_STM$("CompoundStatement1633",1633);
        }
    } else
    // JavaLine 198 ==> SourceLine 1635
    if(VALUE$((((CHECKER1$semchecker1$dotIdent)(CUR$.SL$)).cl==(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IACTEcl)))) {
        // JavaLine 200 ==> SourceLine 1636
        {
            TRACE_BEGIN_STM$("CompoundStatement1636",1636);
            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ILFPA;
            TRACE_END_STM$("CompoundStatement1636",1636);
        }
    } else
    // JavaLine 207 ==> SourceLine 1638
    new ERRMSG$internerr(((CHECKER1)(CUR$.SL$.SL$.SL$)),((char)8),1638);
    // JavaLine 209 ==> SourceLine 1639
    call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
    TRACE_END_STM$("CompoundStatement1628",1639);
}
TRACE_END_STM$("emit",1639);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,1565,11,1567,13,1585,27,1567,32,1568,36,1569,38,1570,42,1571,46,1573,52,1575,54,1576,58,1577,72,1581,77,1584,79,1585,86,1587,90,1588,93,1593,99,1594,111,1595,115,1597,121,1599,123,1601,128,1603,134,1604,137,1605,142,1608,147,1609,150,1618,155,1622,169,1628,175,1629,187,1630,189,1631,191,1633,198,1635,200,1636,207,1638,209,1639,216,1641);
}
