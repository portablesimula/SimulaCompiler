// JavaLine 1 <== SourceLine 1723
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$indesignator extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=1723, lastLine=1796, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public Common$expr RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 13 <== SourceLine 1730
    final LABQNT$ NXTID=new LABQNT$(this,1,"NXTID"); // Local Label #1=NXTID
    // JavaLine 15 <== SourceLine 1733
    final LABQNT$ L1=new LABQNT$(this,2,"L1"); // Local Label #2=L1
    // JavaLine 17 <== SourceLine 1752
    final LABQNT$ L2=new LABQNT$(this,3,"L2"); // Local Label #3=L2
    // JavaLine 19 <== SourceLine 1771
    final LABQNT$ L3=new LABQNT$(this,4,"L3"); // Local Label #4=L3
    // Declare locals as attributes
    // JavaLine 22 <== SourceLine 1724
    Common$expr x=null;
    Common$expr vx=null;
    Head$ varset=null;
    Head$ argset=null;
    // JavaLine 27 <== SourceLine 1725
    int type=0;
    Common$variable varvar=null;
    int hi=0;
    // JavaLine 31 <== SourceLine 1726
    Common$symbolbox cbox=null;
    // Normal Constructor
    public Pass1$SubBlock32$grammar$indesignator(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$grammar$indesignator STM$() {
        Pass1$SubBlock32$grammar$indesignator THIS$=(Pass1$SubBlock32$grammar$indesignator)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 47 <== SourceLine 1727
                varset=new Head$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                ;
                x=new Common$designator(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,varset).STM$();
                ;
                // JavaLine 52 <== SourceLine 1728
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                    // JavaLine 54 <== SourceLine 1730
                    {
                        LABEL$(1,"NXTID");
                        cbox=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.LB[0]];
                        ;
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                        ;
                        argset=null;
                        ;
                        // JavaLine 63 <== SourceLine 1731
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                            // JavaLine 65 <== SourceLine 1732
                            {
                                argset=new Head$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                                ;
                                // JavaLine 69 <== SourceLine 1733
                                LABEL$(2,"L1");
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                                new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$.into(argset);
                                ;
                                // JavaLine 75 <== SourceLine 1734
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COMMA$1)))) {
                                    GOTO$(L1); // GOTO EVALUATED LABEL
                                }
                                ;
                                // JavaLine 80 <== SourceLine 1735
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                                    // JavaLine 82 <== SourceLine 1736
                                    new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1736,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                                } else
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                            }
                        }
                        ;
                        // JavaLine 90 <== SourceLine 1738
                        varvar=new Common$variable(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                        ;
                        // JavaLine 93 <== SourceLine 1739
                        varvar.argset$2=argset;
                        ;
                        // JavaLine 96 <== SourceLine 1740
                        varvar.varbox$2=cbox;
                        ;
                        varvar.argset$2=argset;
                        ;
                        // JavaLine 101 <== SourceLine 1741
                        varvar.into(varset);
                        ;
                    }
                } else
                // JavaLine 106 <== SourceLine 1743
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_VAR$1)))) {
                    // JavaLine 108 <== SourceLine 1744
                    {
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                        ;
                        // JavaLine 112 <== SourceLine 1745
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                            // JavaLine 114 <== SourceLine 1746
                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1746,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                        } else
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                        ;
                        // JavaLine 119 <== SourceLine 1747
                        vx=new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$;
                        ;
                        // JavaLine 122 <== SourceLine 1748
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                            // JavaLine 124 <== SourceLine 1749
                            new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1749,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                        } else
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                        ;
                        // JavaLine 129 <== SourceLine 1750
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                            // JavaLine 131 <== SourceLine 1751
                            {
                                argset=new Head$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                                ;
                                // JavaLine 135 <== SourceLine 1752
                                LABEL$(3,"L2");
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                                new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$.into(argset);
                                ;
                                // JavaLine 141 <== SourceLine 1753
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COMMA$1)))) {
                                    GOTO$(L2); // GOTO EVALUATED LABEL
                                }
                                ;
                                // JavaLine 146 <== SourceLine 1754
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                                    // JavaLine 148 <== SourceLine 1755
                                    new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1755,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                                } else
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                            }
                        }
                        ;
                        // JavaLine 156 <== SourceLine 1757
                        new Common$varexpr(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,vx,argset).STM$().into(varset);
                        ;
                    }
                } else
                // JavaLine 161 <== SourceLine 1759
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_CALL$1)))) {
                    // JavaLine 163 <== SourceLine 1760
                    {
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                        ;
                        // JavaLine 167 <== SourceLine 1761
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1761,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                        }
                        ;
                        // JavaLine 172 <== SourceLine 1762
                        hi=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1;
                        ;
                        // JavaLine 175 <== SourceLine 1763
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                        ;
                        // JavaLine 178 <== SourceLine 1764
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1764,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                        }
                        ;
                        // JavaLine 183 <== SourceLine 1765
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                        ;
                        // JavaLine 186 <== SourceLine 1766
                        vx=new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$;
                        ;
                        // JavaLine 189 <== SourceLine 1767
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                            // JavaLine 191 <== SourceLine 1768
                            new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1768,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                        } else
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                        ;
                        // JavaLine 196 <== SourceLine 1769
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                            // JavaLine 198 <== SourceLine 1770
                            {
                                argset=new Head$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                                ;
                                // JavaLine 202 <== SourceLine 1771
                                LABEL$(4,"L3");
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                                new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$.into(argset);
                                ;
                                // JavaLine 208 <== SourceLine 1772
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COMMA$1)))) {
                                    GOTO$(L3); // GOTO EVALUATED LABEL
                                }
                                ;
                                // JavaLine 213 <== SourceLine 1773
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                                    // JavaLine 215 <== SourceLine 1774
                                    new Pass1$SubBlock32$grammar$chckWrn(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1774,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                                } else
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                            }
                        }
                        ;
                        // JavaLine 223 <== SourceLine 1776
                        new Common$varcall(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,vx,argset,hi).STM$().into(varset);
                        ;
                    }
                } else
                // JavaLine 228 <== SourceLine 1778
                new Common$IERR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62);
                ;
                // JavaLine 231 <== SourceLine 1779
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_DOT$1)))) {
                    // JavaLine 233 <== SourceLine 1780
                    {
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                        ;
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1780,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                        }
                        ;
                        // JavaLine 241 <== SourceLine 1781
                        GOTO$(NXTID); // GOTO EVALUATED LABEL
                    }
                }
                ;
                // JavaLine 246 <== SourceLine 1782
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_QUA$1)))) {
                    // JavaLine 248 <== SourceLine 1783
                    {
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                        ;
                        type=new Pass1$SubBlock32$grammar$intype(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$;
                        ;
                        // JavaLine 254 <== SourceLine 1784
                        if(VALUE$(((type==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_NULL$1))&&((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))))) {
                            // JavaLine 256 <== SourceLine 1786
                            {
                                type=new Common$defType(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.refTypes$1,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1,0,0).RESULT$;
                                ;
                                // JavaLine 260 <== SourceLine 1787
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                            }
                        }
                        ;
                        // JavaLine 266 <== SourceLine 1788
                        if(VALUE$((type==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_NULL$1)))) {
                            new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Illegal syntax after qua"));
                        }
                        ;
                        // JavaLine 271 <== SourceLine 1789
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_DOT$1)))) {
                            // JavaLine 273 <== SourceLine 1790
                            {
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1790,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                                }
                                ;
                                // JavaLine 281 <== SourceLine 1791
                                new Common$qualification(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,type).STM$().into(varset);
                                ;
                                GOTO$(NXTID); // GOTO EVALUATED LABEL
                                ;
                            }
                        }
                        ;
                        // JavaLine 289 <== SourceLine 1793
                        x=new Common$quaopr(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,x,type).STM$();
                        ;
                    }
                }
                ;
                // JavaLine 295 <== SourceLine 1795
                RESULT$=x;
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("indesignator:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("indesignator:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("indesignator:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure indesignator",1,1723,13,1730,15,1733,17,1752,19,1771,22,1724,27,1725,31,1726,47,1727,52,1728,54,1730,63,1731,65,1732,69,1733,75,1734,80,1735,82,1736,90,1738,93,1739,96,1740,101,1741,106,1743,108,1744,112,1745,114,1746,119,1747,122,1748,124,1749,129,1750,131,1751,135,1752,141,1753,146,1754,148,1755,156,1757,161,1759,163,1760,167,1761,172,1762,175,1763,178,1764,183,1765,186,1766,189,1767,191,1768,196,1769,198,1770,202,1771,208,1772,213,1773,215,1774,223,1776,228,1778,231,1779,233,1780,241,1781,246,1782,248,1783,254,1784,256,1786,260,1787,266,1788,271,1789,273,1790,281,1791,289,1793,295,1795,314,1796);
} // End of Procedure
