// JavaLine 1 <== SourceLine 1615
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$sysfnc extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=1615, lastLine=1756, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public Common$system_descr p$d;
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 1616
    int apar=0;
    int npar=0;
    int recid=0;
    Common$record r=null;
    // JavaLine 19 <== SourceLine 1617
    Linkage$ dentry=null;
    int inx=0;
    // JavaLine 22 <== SourceLine 1654
    Common$system_descr inspect$1654$218=null;
    // JavaLine 24 <== SourceLine 1680
    Common$record inspect$1680$219=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$sysfnc setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$sysfnc.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$d=(Common$system_descr)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$sysfnc(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$sysfnc(RTObject$ SL$,Common$system_descr sp$d) {
        super(SL$);
        // Parameter assignment to locals
        this.p$d = sp$d;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$sysfnc STM$() {
        // JavaLine 53 <== SourceLine 1654
        {
            // BEGIN INSPECTION 
            inspect$1654$218=p$d;
            if(inspect$1654$218!=null) // INSPECT inspect$1654$218
            // JavaLine 58 <== SourceLine 1655
            {
                npar=apar=(((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ARGLIST$1)))?(new InptFile$inbyt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$):(0));
                ;
                // JavaLine 62 <== SourceLine 1656
                switch(inspect$1654$218.instr$3) { // BEGIN SWITCH STATEMENT
                case 127: 
                // JavaLine 65 <== SourceLine 1658
                new Pass2$CompoundStatement21$SubBlock23$out_S_line(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)));
                break;
                case 87: 
                // JavaLine 69 <== SourceLine 1661
                {
                    RESULT$=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REF$1;
                    ;
                    // JavaLine 73 <== SourceLine 1662
                    new Pass2$CompoundStatement21$SubBlock23$sysfnc$invalue(((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_INT$1);
                    ;
                    // JavaLine 76 <== SourceLine 1663
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_GETOBJ$1);
                    ;
                    // JavaLine 79 <== SourceLine 1664
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                    }
                    ;
                }
                break;
                case 86: 
                // JavaLine 87 <== SourceLine 1668
                {
                    new Pass2$CompoundStatement21$SubBlock23$sysfnc$invalue(((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REF$1);
                    ;
                    new Pass2$CompoundStatement21$SubBlock23$sysfnc$invalue(((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_INT$1);
                    ;
                    // JavaLine 93 <== SourceLine 1669
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_SETOBJ$1);
                    ;
                    // JavaLine 96 <== SourceLine 1670
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                    }
                    ;
                }
                break;
                case 133: 
                // JavaLine 104 <== SourceLine 1674
                {
                    RESULT$=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_SIZE$1;
                    ;
                    // JavaLine 108 <== SourceLine 1675
                    new Pass2$CompoundStatement21$SubBlock23$sysfnc$inid(((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$)));
                    ;
                    // JavaLine 111 <== SourceLine 1676
                    dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[inx-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                    ;
                    // JavaLine 114 <== SourceLine 1677
                    if(VALUE$((!(IS$(dentry,Common$record.class))))) {
                        // JavaLine 116 <== SourceLine 1678
                        dentry=new Pass2$CompoundStatement21$SubBlock23$get_rec(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),inx).RESULT$;
                    }
                    ;
                    // JavaLine 120 <== SourceLine 1679
                    new Pass2$CompoundStatement21$SubBlock23$sysfnc$invalue(((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_INT$1);
                    ;
                    // JavaLine 123 <== SourceLine 1680
                    {
                        // BEGIN INSPECTION 
                        inspect$1680$219=((Common$record)(dentry));
                        if(inspect$1680$219!=null) // INSPECT inspect$1680$219
                        // JavaLine 128 <== SourceLine 1681
                        {
                            if(VALUE$((!(inspect$1680$219.indefinite$3)))) {
                                // JavaLine 131 <== SourceLine 1682
                                new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Illegal record in rec_size"));
                            }
                            ;
                            // JavaLine 135 <== SourceLine 1683
                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_DSIZE$1);
                            ;
                            new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$1680$219.tag$2);
                            ;
                            // JavaLine 140 <== SourceLine 1684
                            if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                            }
                            ;
                        }
                    }
                }
                break;
                case 95: 
                // JavaLine 150 <== SourceLine 1688
                {
                    new Pass2$CompoundStatement21$SubBlock23$sysfnc$invalue(((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REF$1);
                    ;
                    // JavaLine 154 <== SourceLine 1689
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_T_INITO$1);
                    ;
                    // JavaLine 157 <== SourceLine 1690
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                    }
                    ;
                }
                break;
                case 96: 
                // JavaLine 165 <== SourceLine 1694
                {
                    RESULT$=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REF$1;
                    ;
                    // JavaLine 169 <== SourceLine 1695
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_T_GETO$1);
                    ;
                    // JavaLine 172 <== SourceLine 1696
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                    }
                    ;
                }
                break;
                case 97: 
                // JavaLine 180 <== SourceLine 1700
                {
                    new Pass2$CompoundStatement21$SubBlock23$sysfnc$invalue(((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REF$1);
                    ;
                    // JavaLine 184 <== SourceLine 1701
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_T_SETO$1);
                    ;
                    // JavaLine 187 <== SourceLine 1702
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                    }
                    ;
                }
                break;
                case 82: 
                // JavaLine 195 <== SourceLine 1706
                {
                    RESULT$=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_SIZE$1;
                    ;
                    // JavaLine 199 <== SourceLine 1707
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHLEN$1);
                    ;
                    // JavaLine 202 <== SourceLine 1708
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                    }
                    ;
                }
                break;
                case 116: 
                // JavaLine 210 <== SourceLine 1712
                {
                    new Pass2$CompoundStatement21$SubBlock23$sysfnc$invalue(((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REF$1);
                    ;
                    new Pass2$CompoundStatement21$SubBlock23$sysfnc$invalue(((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REF$1);
                    ;
                    // JavaLine 216 <== SourceLine 1713
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ZEROAREA$1);
                    ;
                    // JavaLine 219 <== SourceLine 1714
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                    }
                    ;
                    // JavaLine 224 <== SourceLine 1715
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_POP$1);
                    ;
                    // JavaLine 227 <== SourceLine 1716
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                    }
                    ;
                }
                break;
                case 117: 
                // JavaLine 235 <== SourceLine 1720
                {
                    new Pass2$CompoundStatement21$SubBlock23$sysfnc$inid(((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$)));
                    ;
                    new Pass2$CompoundStatement21$SubBlock23$sysfnc$invalue(((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REF$1);
                    ;
                    // JavaLine 241 <== SourceLine 1721
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_INITAREA$1);
                    ;
                    // JavaLine 244 <== SourceLine 1722
                    dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[inx-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                    ;
                    // JavaLine 247 <== SourceLine 1723
                    if(VALUE$((!(IS$(dentry,Common$record.class))))) {
                        // JavaLine 249 <== SourceLine 1724
                        dentry=new Pass2$CompoundStatement21$SubBlock23$get_rec(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),inx).RESULT$;
                    }
                    ;
                    // JavaLine 253 <== SourceLine 1725
                    new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$record)(dentry)).tag$2);
                    ;
                    // JavaLine 256 <== SourceLine 1726
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                    }
                    ;
                }
                break;
                case 165: 
                // JavaLine 264 <== SourceLine 1730
                {
                    RESULT$=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REF$1;
                    ;
                    // JavaLine 268 <== SourceLine 1731
                    new Pass2$CompoundStatement21$SubBlock23$sysfnc$invalue(((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_NAME$1);
                    ;
                    // JavaLine 271 <== SourceLine 1732
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_CONVERT$1);
                    ;
                    new Pass2$CompoundStatement21$SubBlock23$outtype(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REF$1);
                    ;
                    // JavaLine 276 <== SourceLine 1733
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                    }
                    ;
                }
                break;
                case 167: 
                // JavaLine 284 <== SourceLine 1737
                {
                    RESULT$=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_FIELD$1;
                    ;
                    // JavaLine 288 <== SourceLine 1738
                    new Pass2$CompoundStatement21$SubBlock23$sysfnc$invalue(((Pass2$CompoundStatement21$SubBlock23$sysfnc)(CUR$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_NAME$1);
                    ;
                    // JavaLine 291 <== SourceLine 1739
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_CONVERT$1);
                    ;
                    new Pass2$CompoundStatement21$SubBlock23$outtype(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_FIELD$1);
                    ;
                    // JavaLine 296 <== SourceLine 1740
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                    }
                    ;
                }
                break;
                default:
                // JavaLine 304 <== SourceLine 1743
                new Common$IERR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141);
                break;
            } // END SWITCH STATEMENT
            ;
            // JavaLine 309 <== SourceLine 1746
            if(VALUE$((apar!=(0)))) {
                // JavaLine 311 <== SourceLine 1747
                {
                    new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,CONC(new TXT$("Wrong no. of arguments to "),inspect$1654$218.symb$2.symbol));
                    ;
                    apar=Math.subtractExact(apar,1);
                    while((apar>=(0))) {
                        // JavaLine 317 <== SourceLine 1749
                        {
                            new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$);
                            ;
                            // JavaLine 321 <== SourceLine 1750
                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_POP$1);
                            ;
                            // JavaLine 324 <== SourceLine 1751
                            if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                            }
                            ;
                        }
                        apar=Math.subtractExact(apar,1);
                    }
                    ;
                }
            }
            ;
            // JavaLine 336 <== SourceLine 1754
            if(VALUE$((npar>(0)))) {
                ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
            }
            ;
        }
    }
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure sysfnc",1,1615,14,1616,19,1617,22,1654,24,1680,53,1654,58,1655,62,1656,65,1658,69,1661,73,1662,76,1663,79,1664,87,1668,93,1669,96,1670,104,1674,108,1675,111,1676,114,1677,116,1678,120,1679,123,1680,128,1681,131,1682,135,1683,140,1684,150,1688,154,1689,157,1690,165,1694,169,1695,172,1696,180,1700,184,1701,187,1702,195,1706,199,1707,202,1708,210,1712,216,1713,219,1714,224,1715,227,1716,235,1720,241,1721,244,1722,247,1723,249,1724,253,1725,256,1726,264,1730,268,1731,271,1732,276,1733,284,1737,288,1738,291,1739,296,1740,304,1743,309,1746,311,1747,317,1749,321,1750,324,1751,336,1754,345,1756);
} // End of Procedure
