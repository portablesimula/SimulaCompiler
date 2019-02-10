// JavaLine 1 ==> SourceLine 1561
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$dotIdent extends CHECKER1$semchecker1$identifier {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=1561, lastLine=1699, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    public CHECKER1$semchecker1$exp p2$dotexp;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 1664
    final LABQNT$ NQ=new LABQNT$(this,2,1); // Local Label #1=NQ
    // JavaLine 14 ==> SourceLine 1674
    final LABQNT$ newplev=new LABQNT$(this,2,2); // Local Label #2=newplev
    // JavaLine 16 ==> SourceLine 1686
    final LABQNT$ found=new LABQNT$(this,2,3); // Local Label #3=found
    // Declare locals as attributes
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$dotIdent$emit.class)); }
    public PRCQNT$ sameAs$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$dotIdent$sameAs.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$dotIdent(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$exp sp2$dotexp) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        this.p2$dotexp = sp2$dotexp;
        // Declaration Code
        TRACE_BEGIN_DCL$("dotIdent",1649);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("dotIdent",1649,inner);
                CHECKER1$semchecker1$dotIdent THIS$=(CHECKER1$semchecker1$dotIdent)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 36 ==> SourceLine 1652
                        ((CHECKER1$semchecker1)(CUR$.SL$)).exptop=((CHECKER1$semchecker1$identifier)CUR$);
                        // JavaLine 38 ==> SourceLine 1653
                        ctype=((CHECKER1)(CUR$.SL$.SL$)).IIDN;
                        // JavaLine 40 ==> SourceLine 1654
                        if(VALUE$((p2$dotexp.type!=(((CHECKER1)(CUR$.SL$.SL$)).IELSE)))) {
                            // JavaLine 42 ==> SourceLine 1655
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1655",1655);
                                if(VALUE$((p2$dotexp.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN)))) {
                                    // JavaLine 46 ==> SourceLine 1656
                                    new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p2$dotexp)));
                                }
                                // JavaLine 49 ==> SourceLine 1657
                                if(VALUE$((p2$dotexp.qual==(null)))) {
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1657",1657);
                                        new ERRMSG$error0(((CHECKER1)(CUR$.SL$.SL$)),163);
                                        GOTO$(NQ); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1657",1657);
                                    }
                                }
                                // JavaLine 58 ==> SourceLine 1658
                                if(VALUE$((p2$dotexp.type==(((CHECKER1)(CUR$.SL$.SL$)).IREF)))) {
                                } else
                                // JavaLine 61 ==> SourceLine 1659
                                if(VALUE$((p2$dotexp.type==(((CHECKER1)(CUR$.SL$.SL$)).ITEXT)))) {
                                } else
                                // JavaLine 64 ==> SourceLine 1660
                                if(VALUE$((p2$dotexp.type==(((CHECKER1)(CUR$.SL$.SL$)).IPTR)))) {
                                } else
                                // JavaLine 67 ==> SourceLine 1661
                                new ERRMSG$error0(((CHECKER1)(CUR$.SL$.SL$)),162);
                                TRACE_END_STM$("CompoundStatement1655",1661);
                            }
                        } else
                        // JavaLine 72 ==> SourceLine 1664
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1664",1664);
                            LABEL$(1,"NQ");
                            meaning=new ERRMSG$newnotseen(((CHECKER1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb).RESULT$;
                            GOTO$(found); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1664",1664);
                        }
                        // JavaLine 80 ==> SourceLine 1667
                        ((CHECKER1$semchecker1)(CUR$.SL$)).cbrec=p2$dotexp.qual.descr;
                        // JavaLine 82 ==> SourceLine 1668
                        meaning=((CHECKER1$semchecker1)(CUR$.SL$)).cbrec.favirt;
                        // JavaLine 84 ==> SourceLine 1669
                        while((meaning!=(null))) {
                            // JavaLine 86 ==> SourceLine 1670
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1670",1670);
                                if(VALUE$((meaning.symb==(((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb)))) {
                                    // JavaLine 90 ==> SourceLine 1671
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1671",1671);
                                        if(VALUE$((meaning.visible==(((CHECKER1)(CUR$.SL$.SL$)).NUL)))) {
                                            GOTO$(found); // GOTO EVALUATED LABEL
                                        }
                                        TRACE_END_STM$("CompoundStatement1671",1671);
                                    }
                                }
                                // JavaLine 99 ==> SourceLine 1672
                                meaning=((COMMON$quantity)(meaning.next));
                                TRACE_END_STM$("CompoundStatement1670",1672);
                            }
                        }
                        // JavaLine 104 ==> SourceLine 1674
                        LABEL$(2,"newplev");
                        meaning=((CHECKER1$semchecker1)(CUR$.SL$)).cbrec.fpar;
                        // JavaLine 107 ==> SourceLine 1675
                        while((meaning!=(null))) {
                            // JavaLine 109 ==> SourceLine 1676
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1676",1676);
                                if(VALUE$((meaning.symb==(((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb)))) {
                                    // JavaLine 113 ==> SourceLine 1677
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1677",1677);
                                        if(VALUE$((meaning.visible==(((CHECKER1)(CUR$.SL$.SL$)).NUL)))) {
                                            GOTO$(found); // GOTO EVALUATED LABEL
                                        }
                                        TRACE_END_STM$("CompoundStatement1677",1677);
                                    }
                                }
                                // JavaLine 122 ==> SourceLine 1678
                                meaning=((COMMON$quantity)(meaning.next));
                                TRACE_END_STM$("CompoundStatement1676",1678);
                            }
                        }
                        // JavaLine 127 ==> SourceLine 1679
                        if(VALUE$((((CHECKER1$semchecker1)(CUR$.SL$)).cbrec.declquant.plev!=(((CHECKER1)(CUR$.SL$.SL$)).zero)))) {
                            // JavaLine 129 ==> SourceLine 1680
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1680",1680);
                                ((CHECKER1$semchecker1)(CUR$.SL$)).cbrec=((CHECKER1$semchecker1)(CUR$.SL$)).cbrec.declquant.prefqual.descr;
                                GOTO$(newplev); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1680",1680);
                            }
                        }
                        // JavaLine 137 ==> SourceLine 1683
                        meaning=new ERRMSG$newnotseen(((CHECKER1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb).RESULT$;
                        meaning.dim=2;
                        // JavaLine 140 ==> SourceLine 1684
                        new ERRMSG$error2quants(((CHECKER1)(CUR$.SL$.SL$)),405,meaning,p2$dotexp.qual);
                        // JavaLine 142 ==> SourceLine 1686
                        LABEL$(3,"found");
                        type=meaning.type;
                        kind=meaning.kind;
                        // JavaLine 146 ==> SourceLine 1687
                        qual=(((type==(((CHECKER1)(CUR$.SL$.SL$)).ITEXT)))?(((CHECKER1$semchecker1)(CUR$.SL$)).textclass):(meaning.prefqual));
                        // JavaLine 148 ==> SourceLine 1688
                        if(VALUE$((type==(((CHECKER1)(CUR$.SL$.SL$)).ILABE)))) {
                            // JavaLine 150 ==> SourceLine 1689
                            new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$dotIdent)CUR$),(((kind==(((CHECKER1)(CUR$.SL$.SL$)).K_label)))?(354):(355)));
                        }
                        // JavaLine 153 ==> SourceLine 1690
                        if(VALUE$((kind==(((CHECKER1)(CUR$.SL$.SL$)).K_ident)))) {
                            // JavaLine 155 ==> SourceLine 1691
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1691",1691);
                                if(VALUE$((p$ch==(((CHECKER1)(CUR$.SL$.SL$)).IDOTP)))) {
                                    // JavaLine 159 ==> SourceLine 1692
                                    new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$dotIdent)CUR$),357);
                                } else
                                if(VALUE$((meaning.special>(((char)1))))) {
                                    // JavaLine 163 ==> SourceLine 1693
                                    new CHECKER1$semchecker1$identifier$NamedConstant(((CHECKER1$semchecker1$dotIdent)CUR$));
                                } else
                                if(VALUE$((meaning.categ!=(((CHECKER1)(CUR$.SL$.SL$)).C_name)))) {
                                    issimple=1;
                                }
                                TRACE_END_STM$("CompoundStatement1691",1693);
                            }
                        } else
                        // JavaLine 172 ==> SourceLine 1695
                        issimple=p2$dotexp.issimple;
                        // JavaLine 174 ==> SourceLine 1696
                        ((CHECKER1$semchecker1)(CUR$.SL$)).cbrec=null;
                        // JavaLine 176 ==> SourceLine 1652
                        if(inner!=null) {
                            inner.STM$();
                            TRACE_BEGIN_STM_AFTER_INNER$("dotIdent",1652);
                        }
                        break LOOP$;
                    }
                    catch(LABQNT$ q) {
                        CUR$=THIS$;
                        if(q.SL$!=CUR$ || q.prefixLevel!=2) {
                            CUR$.STATE$=OperationalState.terminated;
                            if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                            throw(q);
                        }
                        if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                        JTX$=q.index; continue LOOP$; // EG. GOTO Lx
                    }
                }
                TRACE_END_STM$("dotIdent",1652);
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER1$semchecker1$dotIdent STM$() { return((CHECKER1$semchecker1$dotIdent)CODE$.EXEC$()); }
    public CHECKER1$semchecker1$dotIdent START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class dotIdent",1,1561,12,1664,14,1674,16,1686,36,1652,38,1653,40,1654,42,1655,46,1656,49,1657,58,1658,61,1659,64,1660,67,1661,72,1664,80,1667,82,1668,84,1669,86,1670,90,1671,99,1672,104,1674,107,1675,109,1676,113,1677,122,1678,127,1679,129,1680,137,1683,140,1684,142,1686,146,1687,148,1688,150,1689,153,1690,155,1691,159,1692,163,1693,172,1695,174,1696,176,1652,200,1699);
}
