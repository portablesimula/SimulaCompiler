// JavaLine 1 ==> SourceLine 1462
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:46:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$forstat$terminateForelt extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1462, lastLine=1499, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 1476
    final LABQNT$ termIF=new LABQNT$(this,0,1); // Local Label #1=termIF
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 1464
    PARSER$codebuffer inspect$1464$3=null;
    // Normal Constructor
    public PARSER$grammer$forstat$terminateForelt(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("terminateForelt",1464);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$forstat$terminateForelt STM$() {
        TRACE_BEGIN_STM$("terminateForelt",1464);
        PARSER$grammer$forstat$terminateForelt THIS$=(PARSER$grammer$forstat$terminateForelt)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                {
                    // BEGIN INSPECTION 
                    inspect$1464$3=((PARSER$grammer$forstat)(CUR$.SL$)).forcoder;
                    if(inspect$1464$3!=null) //INSPECT inspect$1464$3
                    // JavaLine 36 ==> SourceLine 1465
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1465",1465);
                        switch(((PARSER$grammer$forstat)(CUR$.SL$)).ftype) { // BEGIN SWITCH STATEMENT
                        case 1: 
                        // JavaLine 41 ==> SourceLine 1467
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1467",1467);
                            new PARSER$codebuffer$elt$emit(inspect$1464$3.cvar);
                            // JavaLine 45 ==> SourceLine 1468
                            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IASSG;
                            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                            // JavaLine 48 ==> SourceLine 1469
                            new PARSER$codebuffer$elt$emit(inspect$1464$3.cvar);
                            // JavaLine 50 ==> SourceLine 1470
                            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IPLUS;
                            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                            // JavaLine 53 ==> SourceLine 1471
                            new PARSER$codebuffer$elt$emit(inspect$1464$3.stepexpr);
                            // JavaLine 55 ==> SourceLine 1472
                            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IASGE;
                            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                            // JavaLine 58 ==> SourceLine 1473
                            GOTO$(termIF); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1467",1473);
                        }
                        case 2: 
                        // JavaLine 63 ==> SourceLine 1476
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1476",1476);
                            LABEL$(1); // termIF
                            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IFALS;
                            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                            // JavaLine 69 ==> SourceLine 1477
                            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IIFSE;
                            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                            TRACE_END_STM$("CompoundStatement1476",1477);
                        }
                        case 4: 
                        // JavaLine 75 ==> SourceLine 1482
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1482",1482);
                            new PARSER$codebuffer$elt$emit(inspect$1464$3.deltavar);
                            // JavaLine 79 ==> SourceLine 1483
                            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IASSG;
                            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                            // JavaLine 82 ==> SourceLine 1484
                            new PARSER$codebuffer$copyexpr(inspect$1464$3,inspect$1464$3.stepexpr);
                            // JavaLine 84 ==> SourceLine 1486
                            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).ISTEP;
                            ((PARSER)(CUR$.SL$.SL$.SL$)).opdhi=inspect$1464$3.deltavar.opdhii;
                            // JavaLine 87 ==> SourceLine 1487
                            ((PARSER)(CUR$.SL$.SL$.SL$)).opdlo=inspect$1464$3.deltavar.opdloo;
                            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                            // JavaLine 90 ==> SourceLine 1488
                            new PARSER$codebuffer$elt$emit(inspect$1464$3.cvar);
                            // JavaLine 92 ==> SourceLine 1489
                            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IASSG;
                            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                            // JavaLine 95 ==> SourceLine 1490
                            new PARSER$codebuffer$elt$emit(inspect$1464$3.cvar);
                            // JavaLine 97 ==> SourceLine 1491
                            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IPLUS;
                            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                            // JavaLine 100 ==> SourceLine 1492
                            new PARSER$codebuffer$elt$emit(inspect$1464$3.deltavar);
                            // JavaLine 102 ==> SourceLine 1493
                            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IASGE;
                            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                            // JavaLine 105 ==> SourceLine 1494
                            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IFALS;
                            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                            // JavaLine 108 ==> SourceLine 1495
                            ((PARSER)(CUR$.SL$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$.SL$)).IIFSE;
                            call(((PARSER)(CUR$.SL$.SL$.SL$)).coder);
                            TRACE_END_STM$("CompoundStatement1482",1495);
                        }
                    } // END SWITCH STATEMENT
                    // JavaLine 114 ==> SourceLine 1498
                    inspect$1464$3.stepexpr=null;
                    TRACE_END_STM$("CompoundStatement1465",1498);
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
    TRACE_END_STM$("terminateForelt",1498);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure terminateForelt",1,1462,11,1476,14,1464,36,1465,41,1467,45,1468,48,1469,50,1470,53,1471,55,1472,58,1473,63,1476,69,1477,75,1482,79,1483,82,1484,84,1486,87,1487,90,1488,92,1489,95,1490,97,1491,100,1492,102,1493,105,1494,108,1495,114,1498,135,1499);
}
