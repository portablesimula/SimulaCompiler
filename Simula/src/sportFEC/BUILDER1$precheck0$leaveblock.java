// JavaLine 1 ==> SourceLine 365
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:26 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$precheck0$leaveblock extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=365, lastLine=392, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 380
    final LABQNT$ enter=new LABQNT$(this,0,1); // Local Label #1=enter
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 367
    COMMON$quantity q=null;
    COMMON$quantity visq=null;
    // JavaLine 17 ==> SourceLine 368
    int insp=0;
    int lowpl=0;
    // JavaLine 20 ==> SourceLine 370
    boolean invirts=false;
    // JavaLine 22 ==> SourceLine 373
    COMMON$brecord inspect$373$8=null;
    // Normal Constructor
    public BUILDER1$precheck0$leaveblock(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("leaveblock",373);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$precheck0$leaveblock STM$() {
        TRACE_BEGIN_STM$("leaveblock",373);
        BUILDER1$precheck0$leaveblock THIS$=(BUILDER1$precheck0$leaveblock)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                {
                    // BEGIN INSPECTION 
                    inspect$373$8=((BUILDER1)(CUR$.SL$.SL$)).display.Elt[rank(((BUILDER1)(CUR$.SL$.SL$)).cblev)-((BUILDER1)(CUR$.SL$.SL$)).display.LB[0]];
                    if(inspect$373$8!=null) //INSPECT inspect$373$8
                    // JavaLine 44 ==> SourceLine 374
                    {
                        TRACE_BEGIN_STM$("CompoundStatement374",374);
                        q=inspect$373$8.declquant;
                        // JavaLine 48 ==> SourceLine 375
                        if((q.kind==(((BUILDER1)(CUR$.SL$.SL$)).K_class))) {
                            lowpl=((BUILDER1)(CUR$.SL$.SL$)).zero;
                        } else
                        // JavaLine 52 ==> SourceLine 376
                        if((q.kind==(((BUILDER1)(CUR$.SL$.SL$)).K_prefbl))) {
                            lowpl=((BUILDER1)(CUR$.SL$.SL$)).zero;
                        } else
                        lowpl=((BUILDER1)(CUR$.SL$.SL$)).one;
                        // JavaLine 57 ==> SourceLine 377
                        ((BUILDER1)(CUR$.SL$.SL$)).crtblev=char$((rank(((BUILDER1)(CUR$.SL$.SL$)).crtblev)-(1)));
                        // JavaLine 59 ==> SourceLine 378
                        invirts=true;
                        visq=inspect$373$8.favirt;
                        // JavaLine 62 ==> SourceLine 380
                        LABEL$(1); // enter
                        new BUILDER1$precheck0$invischain(((BUILDER1$precheck0)(CUR$.SL$)),visq);
                        // JavaLine 65 ==> SourceLine 381
                        if(invirts) {
                            // JavaLine 67 ==> SourceLine 382
                            {
                                TRACE_BEGIN_STM$("CompoundStatement382",382);
                                invirts=false;
                                visq=inspect$373$8.fpar;
                                GOTO$(enter); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement382",382);
                            }
                        }
                        // JavaLine 76 ==> SourceLine 383
                        if((q.plev>(lowpl))) {
                            // JavaLine 78 ==> SourceLine 385
                            {
                                TRACE_BEGIN_STM$("CompoundStatement385",385);
                                q=q.prefqual;
                                visq=q.descr.fpar;
                                GOTO$(enter); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement385",385);
                            }
                        }
                        // JavaLine 87 ==> SourceLine 387
                        if((inspect$373$8.kind==(((BUILDER1)(CUR$.SL$.SL$)).K_class))) {
                            // JavaLine 89 ==> SourceLine 388
                            new BUILDER1$precheck0$protect(((BUILDER1$precheck0)(CUR$.SL$)),inspect$373$8.declquant);
                        } else
                        if((inspect$373$8.kind==(((BUILDER1)(CUR$.SL$.SL$)).K_prefbl))) {
                            new BUILDER1$precheck0$protect(((BUILDER1$precheck0)(CUR$.SL$)),inspect$373$8.declquant.prefqual);
                        }
                        TRACE_END_STM$("CompoundStatement374",388);
                    }
                }
                // JavaLine 98 ==> SourceLine 390
                ((BUILDER1)(CUR$.SL$.SL$)).display.Elt[rank(((BUILDER1)(CUR$.SL$.SL$)).cblev)-((BUILDER1)(CUR$.SL$.SL$)).display.LB[0]]=null;
                ((BUILDER1)(CUR$.SL$.SL$)).cblev=char$((rank(((BUILDER1)(CUR$.SL$.SL$)).cblev)-(1)));
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
        TRACE_END_STM$("leaveblock",390);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure leaveblock",1,365,11,380,14,367,17,368,20,370,22,373,44,374,48,375,52,376,57,377,59,378,62,380,65,381,67,382,76,383,78,385,87,387,89,388,98,390,117,392);
}
