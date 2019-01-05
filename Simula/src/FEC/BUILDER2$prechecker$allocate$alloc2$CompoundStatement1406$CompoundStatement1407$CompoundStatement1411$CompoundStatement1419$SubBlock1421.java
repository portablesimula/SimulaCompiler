// JavaLine 1 ==> SourceLine 1421
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:59:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$prechecker$allocate$alloc2$CompoundStatement1406$CompoundStatement1407$CompoundStatement1411$CompoundStatement1419$SubBlock1421 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=5, firstLine=1421, lastLine=1446, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare local labels
    // JavaLine 10 ==> SourceLine 1445
    final LABQNT$ Actcnt=new LABQNT$(this,0,1); // Local Label #1=Actcnt
    // JavaLine 12 ==> SourceLine 1446
    final LABQNT$ NoMoreChck=new LABQNT$(this,0,2); // Local Label #2=NoMoreChck
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 1421
    COMMON$quantity specPar=null;
    COMMON$quantity actPar=null;
    // Normal Constructor
    public BUILDER2$prechecker$allocate$alloc2$CompoundStatement1406$CompoundStatement1407$CompoundStatement1411$CompoundStatement1419$SubBlock1421(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock1421",1421);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock1421",1421);
        BUILDER2$prechecker$allocate$alloc2$CompoundStatement1406$CompoundStatement1407$CompoundStatement1411$CompoundStatement1419$SubBlock1421 THIS$=(BUILDER2$prechecker$allocate$alloc2$CompoundStatement1406$CompoundStatement1407$CompoundStatement1411$CompoundStatement1419$SubBlock1421)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 32 ==> SourceLine 1422
                if(((((BUILDER2$prechecker$allocate$alloc2)(CUR$.SL$)).inspect$1419$82.declquant.type!=(((BUILDER2$prechecker$allocate$alloc2)(CUR$.SL$)).VA.type))||((((BUILDER2$prechecker$allocate$alloc2)(CUR$.SL$)).inspect$1419$82.declquant.prefqual!=(((BUILDER2$prechecker$allocate$alloc2)(CUR$.SL$)).VA.prefqual))))) {
                    // JavaLine 34 ==> SourceLine 1424
                    new ERRMSG$errQT(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)),((BUILDER2$prechecker$allocate$alloc2)(CUR$.SL$)).VA,445);
                }
                // JavaLine 37 ==> SourceLine 1430
                specPar=((BUILDER2$prechecker$allocate$alloc2)(CUR$.SL$)).inspect$1419$82.fpar;
                actPar=((BUILDER2$prechecker$allocate$alloc2)(CUR$.SL$)).VA.descr.fpar;
                // JavaLine 40 ==> SourceLine 1431
                while((specPar!=(null))) {
                    // JavaLine 42 ==> SourceLine 1432
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1432",1432);
                        if((actPar==(null))) {
                            GOTO$(Actcnt); // GOTO EVALUATED LABEL
                        }
                        // JavaLine 48 ==> SourceLine 1434
                        if(((((specPar.type!=(actPar.type))||((specPar.kind!=(actPar.kind))))||((specPar.categ!=(actPar.categ))))||((specPar.prefqual!=(actPar.prefqual))))) {
                            // JavaLine 50 ==> SourceLine 1438
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1438",1438);
                                new ERRMSG$errQT(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)),actPar,447);
                                // JavaLine 54 ==> SourceLine 1439
                                GOTO$(NoMoreChck); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1438",1439);
                            }
                        }
                        // JavaLine 59 ==> SourceLine 1441
                        specPar=((COMMON$quantity)(specPar.next));
                        // JavaLine 61 ==> SourceLine 1442
                        actPar=((COMMON$quantity)(actPar.next));
                        TRACE_END_STM$("CompoundStatement1432",1442);
                    }
                }
                // JavaLine 66 ==> SourceLine 1444
                if((actPar!=(null))) {
                    // JavaLine 68 ==> SourceLine 1445
                    LABEL$(1); // Actcnt
                    new ERRMSG$errQT(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)),((BUILDER2$prechecker$allocate$alloc2)(CUR$.SL$)).VA,446);
                }
                // JavaLine 72 ==> SourceLine 1446
                LABEL$(2); // NoMoreChck
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
        TRACE_END_STM$("SubBlock1421",1446);
        EBLK();
        return(null);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","SubBlock SubBlock1421",1,1421,10,1445,12,1446,15,1421,32,1422,34,1424,37,1430,40,1431,42,1432,48,1434,50,1438,54,1439,59,1441,61,1442,66,1444,68,1445,72,1446,90,1446);
}
