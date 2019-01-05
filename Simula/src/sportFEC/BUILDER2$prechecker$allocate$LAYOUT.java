// JavaLine 1 ==> SourceLine 1513
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$prechecker$allocate$LAYOUT extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1513, lastLine=1620, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$brecord p$brc;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 1565
    final LABQNT$ SIMOBTAG=new LABQNT$(this,0,1); // Local Label #1=SIMOBTAG
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 1540
    COMMON$quantity q=null;
    COMMON$extquantity exq=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER2$prechecker$allocate$LAYOUT setPar(Object param) {
        //Util.BREAK("CALL BUILDER2$prechecker$allocate$LAYOUT.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$brc=(COMMON$brecord)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER2$prechecker$allocate$LAYOUT(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER2$prechecker$allocate$LAYOUT(RTObject$ SL$,COMMON$brecord sp$brc) {
        super(SL$);
        // Parameter assignment to locals
        this.p$brc = sp$brc;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("LAYOUT",1540);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$prechecker$allocate$LAYOUT STM$() {
        TRACE_BEGIN_STM$("LAYOUT",1540);
        BUILDER2$prechecker$allocate$LAYOUT THIS$=(BUILDER2$prechecker$allocate$LAYOUT)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 51 ==> SourceLine 1542
                if((p$brc.kind!=(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_labbl))) {
                    // JavaLine 53 ==> SourceLine 1543
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1543",1543);
                        if((p$brc.kind!=(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_extnal))) {
                            // JavaLine 57 ==> SourceLine 1545
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1545",1545);
                                if(IS$(p$brc.declquant,COMMON$quantity.class)) {
                                    // JavaLine 61 ==> SourceLine 1546
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1546",1546);
                                        p$brc.declquant.ftag=new BUILDER1$newTag(((BUILDER2)(CUR$.SL$.SL$.SL$))).RESULT$;
                                        // JavaLine 65 ==> SourceLine 1551
                                        if(((p$brc.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_proc))&&((p$brc.declquant.plev==(2))))) {
                                        } else
                                        // JavaLine 68 ==> SourceLine 1553
                                        if((((p$brc.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_class))||((p$brc.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_prefbl))))||((p$brc.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_record))))) {
                                            // JavaLine 70 ==> SourceLine 1556
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1556",1556);
                                                // JavaLine 73 ==> SourceLine 1559
                                                new BUILDER1$newTags(((BUILDER2)(CUR$.SL$.SL$.SL$)),(((p$brc.inrtag!=(((BUILDER2)(CUR$.SL$.SL$.SL$)).NUL)))?(isorank(p$brc.inrtag)):((((p$brc.stmtag!=(((BUILDER2)(CUR$.SL$.SL$.SL$)).NUL)))?(isorank(p$brc.stmtag)):((((p$brc.dcltag!=(((BUILDER2)(CUR$.SL$.SL$.SL$)).NUL)))?(isorank(p$brc.dcltag)):(1)))))));
                                                // JavaLine 75 ==> SourceLine 1560
                                                GOTO$(SIMOBTAG); // GOTO EVALUATED LABEL
                                                TRACE_END_STM$("CompoundStatement1556",1560);
                                            }
                                        } else
                                        // JavaLine 80 ==> SourceLine 1563
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1563",1563);
                                            if(((p$brc.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_subbl))||((p$brc.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_proc))))) {
                                                // JavaLine 84 ==> SourceLine 1564
                                                new BUILDER1$newTags(((BUILDER2)(CUR$.SL$.SL$.SL$)),2);
                                            }
                                            // JavaLine 87 ==> SourceLine 1575
                                            LABEL$(1); // SIMOBTAG
                                            // JavaLine 89 ==> SourceLine 1565
                                            if(((BUILDER2)(CUR$.SL$.SL$.SL$)).simob_descr) {
                                                // JavaLine 91 ==> SourceLine 1566
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement1566",1566);
                                                    if(((p$brc.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_class))||((p$brc.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_proc))))) {
                                                        // JavaLine 95 ==> SourceLine 1568
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement1568",1568);
                                                            new BUILDER1$newTag(((BUILDER2)(CUR$.SL$.SL$.SL$)));
                                                            // JavaLine 99 ==> SourceLine 1570
                                                            p$brc.declquant.ftag=(p$brc.declquant.ftag+(1));
                                                            TRACE_END_STM$("CompoundStatement1568",1570);
                                                        }
                                                    }
                                                    TRACE_END_STM$("CompoundStatement1566",1570);
                                                }
                                            }
                                            TRACE_END_STM$("CompoundStatement1563",1570);
                                        }
                                        // JavaLine 109 ==> SourceLine 1576
                                        new BUILDER1$newTags(((BUILDER2)(CUR$.SL$.SL$.SL$)),p$brc.connests);
                                        TRACE_END_STM$("CompoundStatement1546",1576);
                                    }
                                } else
                                // JavaLine 114 ==> SourceLine 1578
                                if((((COMMON$extquantity)(p$brc.declquant)).p2$module==(null))) {
                                    // JavaLine 116 ==> SourceLine 1580
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1580",1580);
                                        p$brc.declquant.ftag=(((BUILDER2)(CUR$.SL$.SL$.SL$)).lastusedtag+(1));
                                        // JavaLine 120 ==> SourceLine 1581
                                        new BUILDER1$newTags(((BUILDER2)(CUR$.SL$.SL$.SL$)),(((p$brc.declquant.type!=(((BUILDER2)(CUR$.SL$.SL$.SL$)).INOTY)))?(4):(3)));
                                        TRACE_END_STM$("CompoundStatement1580",1581);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement1545",1581);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement1543",1581);
                    }
                }
                // JavaLine 131 ==> SourceLine 1587
                q=p$brc.fpar;
                // JavaLine 133 ==> SourceLine 1588
                while((q!=(null))) {
                    // JavaLine 135 ==> SourceLine 1590
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1590",1590);
                        if(IS$(q,COMMON$extquantity.class)) {
                            // JavaLine 139 ==> SourceLine 1591
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1591",1591);
                                if((((COMMON$extquantity)(q)).clf<=(((BUILDER2)(CUR$.SL$.SL$.SL$)).Clf002))) {
                                    // JavaLine 143 ==> SourceLine 1592
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1592",1592);
                                        if(IS$(q.descr,COMMON$extbrecord.class)) {
                                            // JavaLine 147 ==> SourceLine 1594
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1594",1594);
                                                ((COMMON$extbrecord)(q.descr)).ftag=(((BUILDER2)(CUR$.SL$.SL$.SL$)).lastusedtag+(1));
                                                // JavaLine 151 ==> SourceLine 1595
                                                new BUILDER1$newTags(((BUILDER2)(CUR$.SL$.SL$.SL$)),((COMMON$extbrecord)(q.descr)).exttagnum);
                                                TRACE_END_STM$("CompoundStatement1594",1595);
                                            }
                                        }
                                        // JavaLine 156 ==> SourceLine 1597
                                        if((((COMMON$extquantity)(q)).p2$module!=(null))) {
                                            // JavaLine 158 ==> SourceLine 1600
                                            q.ftag=(q.ftag+(((COMMON$extquantity)(q)).p2$module.ftag));
                                        } else
                                        // JavaLine 161 ==> SourceLine 1602
                                        if((((COMMON$extquantity)(q)).clf==(((BUILDER2)(CUR$.SL$.SL$.SL$)).Clf002))) {
                                            // JavaLine 163 ==> SourceLine 1603
                                            q.ftag=new BUILDER1$newTag(((BUILDER2)(CUR$.SL$.SL$.SL$))).RESULT$;
                                        }
                                        // JavaLine 166 ==> SourceLine 1604
                                        if((q.special==(((BUILDER2)(CUR$.SL$.SL$.SL$)).NUL))) {
                                            // JavaLine 168 ==> SourceLine 1605
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1605",1605);
                                                if((q.descr!=(null))) {
                                                    new BUILDER2$prechecker$allocate$LAYOUT(((BUILDER2$prechecker$allocate)(CUR$.SL$)),q.descr);
                                                }
                                                TRACE_END_STM$("CompoundStatement1605",1605);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement1592",1605);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement1591",1605);
                            }
                        } else
                        // JavaLine 183 ==> SourceLine 1608
                        if((((((q.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_proc))&&((q.categ==(((BUILDER2)(CUR$.SL$.SL$.SL$)).C_local))))||((q.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_rep))))||((q.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_class))))||((q.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_record))))) {
                            // JavaLine 185 ==> SourceLine 1613
                            new BUILDER2$prechecker$allocate$LAYOUT(((BUILDER2$prechecker$allocate)(CUR$.SL$)),q.descr);
                        } else
                        if(((q.special>(((char)1)))&&((q.type!=(((BUILDER2)(CUR$.SL$.SL$.SL$)).ITEXT))))) {
                        } else
                        // JavaLine 190 ==> SourceLine 1615
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1615",1615);
                            q.ftag=new BUILDER1$newTag(((BUILDER2)(CUR$.SL$.SL$.SL$))).RESULT$;
                            // JavaLine 194 ==> SourceLine 1616
                            if((q.categ==(((BUILDER2)(CUR$.SL$.SL$.SL$)).C_name))) {
                                new BUILDER1$newTag(((BUILDER2)(CUR$.SL$.SL$.SL$)));
                            }
                            TRACE_END_STM$("CompoundStatement1615",1616);
                        }
                        // JavaLine 200 ==> SourceLine 1618
                        q=((COMMON$quantity)(q.next));
                        TRACE_END_STM$("CompoundStatement1590",1618);
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
        TRACE_END_STM$("LAYOUT",1618);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure LAYOUT",1,1513,12,1565,15,1540,51,1542,53,1543,57,1545,61,1546,65,1551,68,1553,70,1556,73,1559,75,1560,80,1563,84,1564,87,1575,89,1565,91,1566,95,1568,99,1570,109,1576,114,1578,116,1580,120,1581,131,1587,133,1588,135,1590,139,1591,143,1592,147,1594,151,1595,156,1597,158,1600,161,1602,163,1603,166,1604,168,1605,183,1608,185,1613,190,1615,194,1616,200,1618,221,1620);
}
