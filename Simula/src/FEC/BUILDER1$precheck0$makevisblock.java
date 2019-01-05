// JavaLine 1 ==> SourceLine 306
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:59:08 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$precheck0$makevisblock extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=306, lastLine=351, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$brecord p$brc;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 319
    final LABQNT$ enter=new LABQNT$(this,0,1); // Local Label #1=enter
    // JavaLine 14 ==> SourceLine 337
    final LABQNT$ STACK=new LABQNT$(this,0,2); // Local Label #2=STACK
    // Declare locals as attributes
    // JavaLine 17 ==> SourceLine 309
    COMMON$quantity qz=null;
    COMMON$quantity q=null;
    // JavaLine 20 ==> SourceLine 310
    int lowpl=0;
    // JavaLine 22 ==> SourceLine 312
    char qblev=0;
    // JavaLine 24 ==> SourceLine 322
    COMMON$identsymbol inspect$321$61=null;
    // JavaLine 26 ==> SourceLine 337
    COMMON$sembox inspect$337$62=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$precheck0$makevisblock setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$precheck0$makevisblock.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public BUILDER1$precheck0$makevisblock(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$precheck0$makevisblock(RTObject$ SL$,COMMON$brecord sp$brc) {
        super(SL$);
        // Parameter assignment to locals
        this.p$brc = sp$brc;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("makevisblock",337);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$precheck0$makevisblock STM$() {
        TRACE_BEGIN_STM$("makevisblock",337);
        BUILDER1$precheck0$makevisblock THIS$=(BUILDER1$precheck0$makevisblock)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 61 ==> SourceLine 314
                ((BUILDER1)(CUR$.SL$.SL$)).display.Elt[rank(((BUILDER1)(CUR$.SL$.SL$)).cblev)-((BUILDER1)(CUR$.SL$.SL$)).display.LB[0]]=p$brc;
                // JavaLine 63 ==> SourceLine 315
                q=p$brc.declquant;
                qblev=p$brc.blev;
                // JavaLine 66 ==> SourceLine 316
                if((q.kind==(((BUILDER1)(CUR$.SL$.SL$)).K_class))) {
                    lowpl=((BUILDER1)(CUR$.SL$.SL$)).zero;
                } else
                // JavaLine 70 ==> SourceLine 317
                if((q.kind==(((BUILDER1)(CUR$.SL$.SL$)).K_prefbl))) {
                    lowpl=((BUILDER1)(CUR$.SL$.SL$)).zero;
                } else
                lowpl=((BUILDER1)(CUR$.SL$.SL$)).one;
                // JavaLine 75 ==> SourceLine 318
                new BUILDER1$precheck0$vischain(((BUILDER1$precheck0)(CUR$.SL$)),p$brc.favirt,qz);
                // JavaLine 77 ==> SourceLine 319
                LABEL$(1); // enter
                qz=q.descr.fpar;
                // JavaLine 80 ==> SourceLine 320
                while((qz!=(null))) {
                    // JavaLine 82 ==> SourceLine 321
                    {
                        TRACE_BEGIN_STM$("CompoundStatement321",321);
                        if((qz.visible==(((BUILDER1)(CUR$.SL$.SL$)).NUL))) {
                            {
                                // BEGIN INSPECTION 
                                inspect$321$61=((COMMON$identsymbol)(qz.symb));
                                if(inspect$321$61!=null) //INSPECT inspect$321$61
                                // JavaLine 90 ==> SourceLine 323
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement323",323);
                                    if((inspect$321$61.curmeaning==(null))) {
                                        // JavaLine 94 ==> SourceLine 324
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement324",324);
                                            inspect$321$61.curmeaning=qz;
                                            TRACE_END_STM$("CompoundStatement324",324);
                                        }
                                    } else
                                    // JavaLine 101 ==> SourceLine 327
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement327",327);
                                        if(((((COMMON$quantity)(inspect$321$61.curmeaning)).encl.blev!=(qblev))||((inspect$321$61.curmeaning==(qz))))) {
                                            // JavaLine 105 ==> SourceLine 337
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement337",337);
                                                // JavaLine 108 ==> SourceLine 341
                                                LABEL$(2); // STACK
                                                // JavaLine 110 ==> SourceLine 337
                                                {
                                                    // BEGIN INSPECTION 
                                                    inspect$337$62=new COMMON$sembox(((BUILDER1)(CUR$.SL$.SL$))).STM$();
                                                    if(inspect$337$62!=null) //INSPECT inspect$337$62
                                                    // JavaLine 115 ==> SourceLine 338
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement338",338);
                                                        inspect$337$62.prevmeaning=qz.prevmeaning;
                                                        // JavaLine 119 ==> SourceLine 339
                                                        inspect$337$62.next=inspect$321$61.curmeaning;
                                                        // JavaLine 121 ==> SourceLine 340
                                                        qz.prevmeaning=((COMMON$sembox)inspect$337$62);
                                                        TRACE_END_STM$("CompoundStatement338",340);
                                                    }
                                                }
                                                // JavaLine 126 ==> SourceLine 342
                                                inspect$321$61.curmeaning=qz;
                                                TRACE_END_STM$("CompoundStatement337",342);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement327",342);
                                    }
                                    TRACE_END_STM$("CompoundStatement323",342);
                                }
                            }
                        }
                        // JavaLine 137 ==> SourceLine 346
                        qz=((COMMON$quantity)(qz.next));
                        TRACE_END_STM$("CompoundStatement321",346);
                    }
                }
                // JavaLine 142 ==> SourceLine 348
                if((q.plev>(lowpl))) {
                    // JavaLine 144 ==> SourceLine 349
                    {
                        TRACE_BEGIN_STM$("CompoundStatement349",349);
                        q=q.prefqual;
                        GOTO$(enter); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement349",349);
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
        TRACE_END_STM$("makevisblock",349);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure makevisblock",1,306,12,319,14,337,17,309,20,310,22,312,24,322,26,337,61,314,63,315,66,316,70,317,75,318,77,319,80,320,82,321,90,323,94,324,101,327,105,337,108,341,110,337,115,338,119,339,121,340,126,342,137,346,142,348,144,349,168,351);
}
