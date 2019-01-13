// JavaLine 1 ==> SourceLine 984
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:35 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$prechecker$allocate extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=984, lastLine=1701, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 999
    COMMON$brecord B1=null;
    COMMON$quantity Q=null;
    COMMON$quantity TUchain=null;
    COMMON$brecord brc=null;
    // JavaLine 16 ==> SourceLine 1641
    COMMON$brecord inspect$1641$83=null;
    // Normal Constructor
    public BUILDER2$prechecker$allocate(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("allocate",1641);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$prechecker$allocate STM$() {
        TRACE_BEGIN_STM$("allocate",1641);
        // JavaLine 30 ==> SourceLine 1624
        brc=new COMMON$getBrc(((BUILDER2)(CUR$.SL$.SL$)),((BUILDER2$prechecker)(CUR$.SL$)).lastblhi,((BUILDER2$prechecker)(CUR$.SL$)).lastbllo).RESULT$;
        // JavaLine 32 ==> SourceLine 1625
        if((brc.kind==(((BUILDER2)(CUR$.SL$.SL$)).K_labbl))) {
            // JavaLine 34 ==> SourceLine 1626
            {
                TRACE_BEGIN_STM$("CompoundStatement1626",1626);
                brc.blev=((BUILDER2)(CUR$.SL$.SL$)).cblev;
                brc.rtblev=((BUILDER2)(CUR$.SL$.SL$)).crtblev;
                TRACE_END_STM$("CompoundStatement1626",1626);
            }
        } else
        // JavaLine 42 ==> SourceLine 1628
        {
            TRACE_BEGIN_STM$("CompoundStatement1628",1628);
            brc.blev=char$((rank(((BUILDER2)(CUR$.SL$.SL$)).cblev)+(1)));
            // JavaLine 46 ==> SourceLine 1629
            brc.rtblev=char$((rank(((BUILDER2)(CUR$.SL$.SL$)).crtblev)+(1)));
            TRACE_END_STM$("CompoundStatement1628",1629);
        }
        // JavaLine 50 ==> SourceLine 1631
        new BUILDER2$prechecker$allocate$alloc1(((BUILDER2$prechecker$allocate)CUR$),brc);
        // JavaLine 52 ==> SourceLine 1633
        Q=brc.declquant=new COMMON$quantity(((BUILDER2)(CUR$.SL$.SL$))).STM$();
        Q.descr=brc;
        // JavaLine 55 ==> SourceLine 1634
        Q.kind=brc.kind;
        Q.line=brc.line1;
        Q.plev=((BUILDER2)(CUR$.SL$.SL$)).one;
        // JavaLine 59 ==> SourceLine 1635
        Q.encl=((BUILDER2)(CUR$.SL$.SL$)).unknowns;
        // JavaLine 61 ==> SourceLine 1638
        switch(brc.kind) { // BEGIN SWITCH STATEMENT
        case 9: 
        // JavaLine 64 ==> SourceLine 1640
        {
            TRACE_BEGIN_STM$("CompoundStatement1640",1640);
            if((((BUILDER2$prechecker)(CUR$.SL$)).blockpref==(null))) {
                brc.kind=Q.kind=((BUILDER2)(CUR$.SL$.SL$)).K_subbl;
            } else
            // JavaLine 70 ==> SourceLine 1641
            {
                // BEGIN INSPECTION 
                inspect$1641$83=((BUILDER2$prechecker)(CUR$.SL$)).blockpref.descr;
                if(inspect$1641$83!=null) //INSPECT inspect$1641$83
                // JavaLine 75 ==> SourceLine 1642
                {
                    TRACE_BEGIN_STM$("CompoundStatement1642",1642);
                    TUchain=inspect$1641$83.declquant;
                    // JavaLine 79 ==> SourceLine 1643
                    while((TUchain.plev>(((BUILDER2)(CUR$.SL$.SL$)).one))) {
                        // JavaLine 81 ==> SourceLine 1644
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1644",1644);
                            if(TUchain.descr.thisused) {
                                new ERRMSG$error0(((BUILDER2)(CUR$.SL$.SL$)),151);
                            }
                            // JavaLine 87 ==> SourceLine 1645
                            TUchain=TUchain.prefqual;
                            TRACE_END_STM$("CompoundStatement1644",1645);
                        }
                    }
                    // JavaLine 92 ==> SourceLine 1647
                    if((inspect$1641$83.blev!=(brc.blev))) {
                        // JavaLine 94 ==> SourceLine 1650
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1650",1650);
                            if((IS$(((BUILDER2$prechecker)(CUR$.SL$)).blockpref,COMMON$extquantity.class)&&((((COMMON$extquantity)(((BUILDER2$prechecker)(CUR$.SL$)).blockpref)).clf==(((BUILDER2)(CUR$.SL$.SL$)).Clf004))))) {
                            } else
                            // JavaLine 99 ==> SourceLine 1652
                            new ERRMSG$error1qlin(((BUILDER2)(CUR$.SL$.SL$)),331,((BUILDER2$prechecker)(CUR$.SL$)).blockpref);
                            TRACE_END_STM$("CompoundStatement1650",1652);
                        }
                    }
                    // JavaLine 104 ==> SourceLine 1654
                    Q.prefqual=((BUILDER2$prechecker)(CUR$.SL$)).blockpref;
                    Q.plev=(((BUILDER2$prechecker)(CUR$.SL$)).blockpref.plev+(1));
                    // JavaLine 107 ==> SourceLine 1655
                    ((BUILDER2$prechecker)(CUR$.SL$)).blockpref=null;
                    // JavaLine 109 ==> SourceLine 1656
                    brc.npar=inspect$1641$83.npar;
                    // JavaLine 111 ==> SourceLine 1658
                    if(inspect$1641$83.localclasses) {
                        brc.localclasses=true;
                    }
                    TRACE_END_STM$("CompoundStatement1642",1658);
                }
            }
            TRACE_END_STM$("CompoundStatement1640",1658);
        }
        case 1: 
        // JavaLine 121 ==> SourceLine 1664
        {
            TRACE_BEGIN_STM$("CompoundStatement1664",1664);
            Q.prefqual=new COMMON$getBrc(((BUILDER2)(CUR$.SL$.SL$)),brc.hidlist.idhi,brc.hidlist.idlo).RESULT$.declquant;
            // JavaLine 125 ==> SourceLine 1666
            brc.hidlist=null;
            // JavaLine 127 ==> SourceLine 1667
            Q.plev=2;
            // JavaLine 129 ==> SourceLine 1668
            Q.symb=Q.prefqual.symb;
            // JavaLine 131 ==> SourceLine 1669
            Q.type=Q.prefqual.type;
            Q.categ=Q.prefqual.categ;
            // JavaLine 134 ==> SourceLine 1670
            brc.npar=Q.prefqual.descr.npar;
            TRACE_END_STM$("CompoundStatement1664",1670);
        }
        case 11: 
        // JavaLine 139 ==> SourceLine 1678
        {
            TRACE_BEGIN_STM$("CompoundStatement1678",1678);
            B1=((BUILDER2)(CUR$.SL$.SL$)).display.Elt[rank(((BUILDER2)(CUR$.SL$.SL$)).cblev)-((BUILDER2)(CUR$.SL$.SL$)).display.LB[0]];
            // JavaLine 143 ==> SourceLine 1679
            Q.prefqual=B1.declquant;
            Q.plev=(Q.prefqual.plev+(1));
            // JavaLine 146 ==> SourceLine 1680
            Q.categ=((BUILDER2)(CUR$.SL$.SL$)).C_block;
            Q.type=((BUILDER2)(CUR$.SL$.SL$)).INOTY;
            // JavaLine 149 ==> SourceLine 1681
            brc.npar=B1.npar;
            // JavaLine 151 ==> SourceLine 1684
            Q=Q.prefqual;
            // JavaLine 153 ==> SourceLine 1685
            if((Q.descr.inspected!=(((BUILDER2)(CUR$.SL$.SL$)).NUL))) {
                // JavaLine 155 ==> SourceLine 1686
                {
                    TRACE_BEGIN_STM$("CompoundStatement1686",1686);
                    Q.descr.connests=brc.connests;
                    // JavaLine 159 ==> SourceLine 1687
                    while((Q.plev!=(((BUILDER2)(CUR$.SL$.SL$)).zero))) {
                        // JavaLine 161 ==> SourceLine 1688
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1688",1688);
                            Q=Q.prefqual;
                            Q.descr.connests=brc.connests;
                            TRACE_END_STM$("CompoundStatement1688",1688);
                        }
                    }
                    TRACE_END_STM$("CompoundStatement1686",1688);
                }
            }
            TRACE_END_STM$("CompoundStatement1678",1688);
        }
    } // END SWITCH STATEMENT
    // JavaLine 175 ==> SourceLine 1695
    new BUILDER2$prechecker$allocate$alloc2(((BUILDER2$prechecker$allocate)CUR$),brc);
    // JavaLine 177 ==> SourceLine 1699
    new BUILDER2$prechecker$allocate$LAYOUT(((BUILDER2$prechecker$allocate)CUR$),brc);
    TRACE_END_STM$("allocate",1699);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure allocate",1,984,11,999,16,1641,30,1624,32,1625,34,1626,42,1628,46,1629,50,1631,52,1633,55,1634,59,1635,61,1638,64,1640,70,1641,75,1642,79,1643,81,1644,87,1645,92,1647,94,1650,99,1652,104,1654,107,1655,109,1656,111,1658,121,1664,125,1666,127,1667,129,1668,131,1669,134,1670,139,1678,143,1679,146,1680,149,1681,151,1684,153,1685,155,1686,159,1687,161,1688,175,1695,177,1699,182,1701);
}
