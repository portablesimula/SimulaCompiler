// JavaLine 1 ==> SourceLine 504
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:26 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$precheck0$hide extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=504, lastLine=578, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$quantity p$q;
    public boolean p$attrHide;
    // Declare local labels
    // JavaLine 13 ==> SourceLine 550
    final LABQNT$ SETM=new LABQNT$(this,0,1); // Local Label #1=SETM
    // JavaLine 15 ==> SourceLine 563
    final LABQNT$ NEXTATTR=new LABQNT$(this,0,2); // Local Label #2=NEXTATTR
    // JavaLine 17 ==> SourceLine 531
    final LABQNT$ REP=new LABQNT$(this,0,3); // Local Label #3=REP
    // JavaLine 19 ==> SourceLine 532
    final LABQNT$ SCAN=new LABQNT$(this,0,4); // Local Label #4=SCAN
    // JavaLine 21 ==> SourceLine 572
    final LABQNT$ REMM=new LABQNT$(this,0,5); // Local Label #5=REMM
    // JavaLine 23 ==> SourceLine 576
    final LABQNT$ NXTP=new LABQNT$(this,0,6); // Local Label #6=NXTP
    // Declare locals as attributes
    // JavaLine 26 ==> SourceLine 510
    COMMON$quantity qz=null;
    COMMON$idpack cvis=null;
    COMMON$idpack fvis=null;
    // JavaLine 30 ==> SourceLine 511
    int nhid=0;
    boolean inlocals=false;
    // JavaLine 33 ==> SourceLine 512
    int curplev=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$precheck0$hide setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$precheck0$hide.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$q=(COMMON$quantity)objectValue(param); break;
                case 1: p$attrHide=(boolean)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER1$precheck0$hide(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$precheck0$hide(RTObject$ SL$,COMMON$quantity sp$q,boolean sp$attrHide) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        this.p$attrHide = sp$attrHide;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("hide",512);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$precheck0$hide STM$() {
        TRACE_BEGIN_STM$("hide",512);
        BUILDER1$precheck0$hide THIS$=(BUILDER1$precheck0$hide)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 70 ==> SourceLine 516
                ((BUILDER1)(CUR$.SL$.SL$)).prefixchain.Elt[1-((BUILDER1)(CUR$.SL$.SL$)).prefixchain.LB[0]]=qz=p$q;
                curplev=((BUILDER1)(CUR$.SL$.SL$)).one;
                // JavaLine 73 ==> SourceLine 517
                while((curplev<(p$q.plev))) {
                    // JavaLine 75 ==> SourceLine 518
                    {
                        TRACE_BEGIN_STM$("CompoundStatement518",518);
                        curplev=(curplev+(1));
                        ((BUILDER1)(CUR$.SL$.SL$)).prefixchain.Elt[curplev-((BUILDER1)(CUR$.SL$.SL$)).prefixchain.LB[0]]=qz=qz.prefqual;
                        TRACE_END_STM$("CompoundStatement518",518);
                    }
                }
                // JavaLine 83 ==> SourceLine 521
                while((curplev!=(((BUILDER1)(CUR$.SL$.SL$)).zero))) {
                    // JavaLine 85 ==> SourceLine 522
                    {
                        TRACE_BEGIN_STM$("CompoundStatement522",522);
                        p$q=((BUILDER1)(CUR$.SL$.SL$)).prefixchain.Elt[curplev-((BUILDER1)(CUR$.SL$.SL$)).prefixchain.LB[0]];
                        ((BUILDER1)(CUR$.SL$.SL$)).prefixchain.Elt[curplev-((BUILDER1)(CUR$.SL$.SL$)).prefixchain.LB[0]]=null;
                        // JavaLine 90 ==> SourceLine 523
                        curplev=(curplev-(1));
                        // JavaLine 92 ==> SourceLine 524
                        new BUILDER1$precheck0$unprotect(((BUILDER1$precheck0)(CUR$.SL$)),p$q);
                        // JavaLine 94 ==> SourceLine 525
                        fvis=p$q.descr.hidlist;
                        // JavaLine 96 ==> SourceLine 526
                        if((fvis==(null))) {
                            GOTO$(NXTP); // GOTO EVALUATED LABEL
                        }
                        // JavaLine 100 ==> SourceLine 527
                        cvis=fvis;
                        nhid=0;
                        // JavaLine 103 ==> SourceLine 528
                        while((cvis!=(null))) {
                            // JavaLine 105 ==> SourceLine 529
                            {
                                TRACE_BEGIN_STM$("CompoundStatement529",529);
                                nhid=(nhid+(1));
                                cvis=cvis.next;
                                TRACE_END_STM$("CompoundStatement529",529);
                            }
                        }
                        // JavaLine 113 ==> SourceLine 531
                        LABEL$(3); // REP
                        qz=p$q.descr.fpar;
                        inlocals=true;
                        // JavaLine 117 ==> SourceLine 564
                        LABEL$(4); // SCAN
                        // JavaLine 119 ==> SourceLine 532
                        while((qz!=(null))) {
                            // JavaLine 121 ==> SourceLine 533
                            {
                                TRACE_BEGIN_STM$("CompoundStatement533",533);
                                if((qz.visible==(((BUILDER1)(CUR$.SL$.SL$)).NUL))) {
                                    // JavaLine 125 ==> SourceLine 534
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement534",534);
                                        cvis=fvis;
                                        // JavaLine 129 ==> SourceLine 535
                                        while((cvis!=(null))) {
                                            // JavaLine 131 ==> SourceLine 536
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement536",536);
                                                if((cvis.line>=(0))) {
                                                    // JavaLine 135 ==> SourceLine 538
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement538",538);
                                                        if((new COMMON$boxof(((BUILDER1)(CUR$.SL$.SL$)),cvis.idhi,cvis.idlo).RESULT$==(qz.symb))) {
                                                            // JavaLine 139 ==> SourceLine 540
                                                            {
                                                                TRACE_BEGIN_STM$("CompoundStatement540",540);
                                                                if((p$attrHide&(((qz.categ==(((BUILDER1)(CUR$.SL$.SL$)).C_local))|((qz.categ==(((BUILDER1)(CUR$.SL$.SL$)).C_virt))))))) {
                                                                    // JavaLine 143 ==> SourceLine 543
                                                                    new BUILDER1$precheck0$ignore(((BUILDER1$precheck0)(CUR$.SL$)),cvis,qz).STM$();
                                                                }
                                                                // JavaLine 146 ==> SourceLine 544
                                                                qz.visible=((char)1);
                                                                // JavaLine 148 ==> SourceLine 545
                                                                if(inlocals) {
                                                                    // JavaLine 150 ==> SourceLine 547
                                                                    {
                                                                        TRACE_BEGIN_STM$("CompoundStatement547",547);
                                                                        if(((qz.match==(null))||((qz.match.categ==(((BUILDER1)(CUR$.SL$.SL$)).C_virt))))) {
                                                                            // JavaLine 154 ==> SourceLine 550
                                                                            {
                                                                                TRACE_BEGIN_STM$("CompoundStatement550",550);
                                                                                LABEL$(1); // SETM
                                                                                cvis.line=(-(cvis.line));
                                                                                // JavaLine 159 ==> SourceLine 551
                                                                                nhid=(nhid-(1));
                                                                                // JavaLine 161 ==> SourceLine 552
                                                                                if((nhid==(0))) {
                                                                                    GOTO$(REMM); // GOTO EVALUATED LABEL
                                                                                }
                                                                                TRACE_END_STM$("CompoundStatement550",552);
                                                                            }
                                                                        }
                                                                        TRACE_END_STM$("CompoundStatement547",552);
                                                                    }
                                                                } else
                                                                // JavaLine 171 ==> SourceLine 556
                                                                if((qz.dim==(1))) {
                                                                    GOTO$(SETM); // GOTO EVALUATED LABEL
                                                                }
                                                                // JavaLine 175 ==> SourceLine 557
                                                                GOTO$(NEXTATTR); // GOTO EVALUATED LABEL
                                                                TRACE_END_STM$("CompoundStatement540",557);
                                                            }
                                                        }
                                                        TRACE_END_STM$("CompoundStatement538",557);
                                                    }
                                                }
                                                // JavaLine 183 ==> SourceLine 560
                                                cvis=cvis.next;
                                                TRACE_END_STM$("CompoundStatement536",560);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement534",560);
                                    }
                                }
                                // JavaLine 191 ==> SourceLine 563
                                LABEL$(2); // NEXTATTR
                                qz=((COMMON$quantity)(qz.next));
                                TRACE_END_STM$("CompoundStatement533",563);
                            }
                        }
                        // JavaLine 197 ==> SourceLine 565
                        if(inlocals) {
                            // JavaLine 199 ==> SourceLine 566
                            {
                                TRACE_BEGIN_STM$("CompoundStatement566",566);
                                inlocals=false;
                                qz=p$q.descr.favirt;
                                GOTO$(SCAN); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement566",566);
                            }
                        }
                        // JavaLine 208 ==> SourceLine 568
                        if((p$q.plev>(((BUILDER1)(CUR$.SL$.SL$)).one))) {
                            // JavaLine 210 ==> SourceLine 569
                            {
                                TRACE_BEGIN_STM$("CompoundStatement569",569);
                                p$q=p$q.prefqual;
                                GOTO$(REP); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement569",569);
                            }
                        }
                        // JavaLine 218 ==> SourceLine 572
                        LABEL$(5); // REMM
                        cvis=fvis;
                        // JavaLine 221 ==> SourceLine 573
                        while((cvis!=(null))) {
                            // JavaLine 223 ==> SourceLine 574
                            {
                                TRACE_BEGIN_STM$("CompoundStatement574",574);
                                if((cvis.line<(0))) {
                                    cvis.line=(-(cvis.line));
                                }
                                // JavaLine 229 ==> SourceLine 575
                                cvis=cvis.next;
                                TRACE_END_STM$("CompoundStatement574",575);
                            }
                        }
                        // JavaLine 234 ==> SourceLine 576
                        LABEL$(6); // NXTP
                        TRACE_END_STM$("CompoundStatement522",576);
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
        TRACE_END_STM$("hide",576);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure hide",1,504,13,550,15,563,17,531,19,532,21,572,23,576,26,510,30,511,33,512,70,516,73,517,75,518,83,521,85,522,90,523,92,524,94,525,96,526,100,527,103,528,105,529,113,531,117,564,119,532,121,533,125,534,129,535,131,536,135,538,139,540,143,543,146,544,148,545,150,547,154,550,159,551,161,552,171,556,175,557,183,560,191,563,197,565,199,566,208,568,210,569,218,572,221,573,223,574,229,575,234,576,255,578);
}
