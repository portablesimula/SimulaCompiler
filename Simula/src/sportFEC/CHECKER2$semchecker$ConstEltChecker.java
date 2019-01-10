// JavaLine 1 ==> SourceLine 333
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 12:01:21 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER2$semchecker$ConstEltChecker extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=0, firstLine=333, lastLine=384, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 342
    final LABQNT$ REP=new LABQNT$(this,0,1); // Local Label #1=REP
    // JavaLine 14 ==> SourceLine 381
    final LABQNT$ EXIT=new LABQNT$(this,0,2); // Local Label #2=EXIT
    // Declare locals as attributes
    // JavaLine 17 ==> SourceLine 334
    public COMMON$quantity meaning=null;
    // JavaLine 19 ==> SourceLine 336
    public char type=0;
    // JavaLine 21 ==> SourceLine 337
    public char etype=0;
    // JavaLine 23 ==> SourceLine 366
    public COMMON$brecord inspect$366$11=null;
    // Normal Constructor
    public CHECKER2$semchecker$ConstEltChecker(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("ConstEltChecker",366);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("ConstEltChecker",366,inner);
                CHECKER2$semchecker$ConstEltChecker THIS$=(CHECKER2$semchecker$ConstEltChecker)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 40 ==> SourceLine 382
                        LABEL$(1); // REP
                        // JavaLine 42 ==> SourceLine 342
                        while(true) {
                            // JavaLine 44 ==> SourceLine 343
                            {
                                TRACE_BEGIN_STM$("CompoundStatement343",343);
                                detach();
                                // JavaLine 48 ==> SourceLine 346
                                meaning=new BUILDER1$meaningof(((CHECKER2)(CUR$.SL$.SL$)),((CHECKER2$semchecker)(CUR$.SL$)).opdSymb).RESULT$;
                                type=meaning.type;
                                // JavaLine 51 ==> SourceLine 350
                                detach();
                                // JavaLine 53 ==> SourceLine 353
                                if((((CHECKER2$semchecker)(CUR$.SL$)).exptop.p$ch!=(((CHECKER2)(CUR$.SL$.SL$)).ICONS))) {
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement353",353);
                                        new CHECKER2$semchecker$ConstEltChecker$Cerror(((CHECKER2$semchecker$ConstEltChecker)CUR$),170);
                                        GOTO$(EXIT); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement353",353);
                                    }
                                }
                                // JavaLine 62 ==> SourceLine 354
                                etype=((CHECKER2$semchecker)(CUR$.SL$)).exptop.type;
                                // JavaLine 64 ==> SourceLine 355
                                if((type!=(etype))) {
                                    // JavaLine 66 ==> SourceLine 356
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement356",356);
                                        if(((type==(((CHECKER2)(CUR$.SL$.SL$)).ISHOR))&((etype==(((CHECKER2)(CUR$.SL$.SL$)).IINTG))))) {
                                        } else
                                        // JavaLine 71 ==> SourceLine 362
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement362",362);
                                            new CHECKER2$semchecker$ConstEltChecker$Cerror(((CHECKER2$semchecker$ConstEltChecker)CUR$),255);
                                            GOTO$(EXIT); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement362",362);
                                        }
                                        TRACE_END_STM$("CompoundStatement356",362);
                                    }
                                }
                                // JavaLine 81 ==> SourceLine 365
                                meaning.special=((char)2);
                                // JavaLine 83 ==> SourceLine 366
                                {
                                    // BEGIN INSPECTION 
                                    inspect$366$11=new COMMON$brecord(((CHECKER2)(CUR$.SL$.SL$))).STM$();
                                    if(inspect$366$11!=null) //INSPECT inspect$366$11
                                    // JavaLine 88 ==> SourceLine 367
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement367",367);
                                        meaning.descr=((COMMON$brecord)inspect$366$11);
                                        inspect$366$11.declquant=meaning;
                                        // JavaLine 93 ==> SourceLine 368
                                        inspect$366$11.blnohi=((CHECKER1$semchecker1$const$)(((CHECKER2$semchecker)(CUR$.SL$)).exptop)).ixhi;
                                        // JavaLine 95 ==> SourceLine 369
                                        inspect$366$11.blnolo=((CHECKER1$semchecker1$const$)(((CHECKER2$semchecker)(CUR$.SL$)).exptop)).ixlo;
                                        TRACE_END_STM$("CompoundStatement367",369);
                                    }
                                }
                                // JavaLine 100 ==> SourceLine 371
                                if((type==(((CHECKER2)(CUR$.SL$.SL$)).ITEXT))) {
                                    // JavaLine 102 ==> SourceLine 372
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement372",372);
                                        if((((CHECKER1$semchecker1$const$)(((CHECKER2$semchecker)(CUR$.SL$)).exptop)).ixhi!=(((CHECKER2)(CUR$.SL$.SL$)).NUL))) {
                                            // JavaLine 106 ==> SourceLine 374
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement374",374);
                                                ((CHECKER2$semchecker)(CUR$.SL$)).opihi=((CHECKER1$semchecker1$const$)(((CHECKER2$semchecker)(CUR$.SL$)).exptop)).ixhi;
                                                // JavaLine 110 ==> SourceLine 375
                                                ((CHECKER2$semchecker)(CUR$.SL$)).opilo=((CHECKER1$semchecker1$const$)(((CHECKER2$semchecker)(CUR$.SL$)).exptop)).ixlo;
                                                // JavaLine 112 ==> SourceLine 376
                                                ((CHECKER2$semchecker)(CUR$.SL$)).opc=((CHECKER2)(CUR$.SL$.SL$)).INEW;
                                                ((CHECKER2)(CUR$.SL$.SL$)).coder.opq=meaning;
                                                call(((CHECKER2)(CUR$.SL$.SL$)).coder);
                                                TRACE_END_STM$("CompoundStatement374",376);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement372",376);
                                    }
                                }
                                // JavaLine 122 ==> SourceLine 381
                                LABEL$(2); // EXIT
                                new CHECKER1$semchecker1$popExpStack(((CHECKER2$semchecker)(CUR$.SL$)));
                                TRACE_END_STM$("CompoundStatement343",381);
                            }
                               if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                        }
                        // JavaLine 129 ==> SourceLine 342
                        if(inner!=null) {
                            inner.STM$();
                            TRACE_BEGIN_STM_AFTER_INNER$("ConstEltChecker",342);
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
                TRACE_END_STM$("ConstEltChecker",342);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public CHECKER2$semchecker$ConstEltChecker STM$() { return((CHECKER2$semchecker$ConstEltChecker)CODE$.EXEC$()); }
    public CHECKER2$semchecker$ConstEltChecker START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Class ConstEltChecker",1,333,12,342,14,381,17,334,19,336,21,337,23,366,40,382,42,342,44,343,48,346,51,350,53,353,62,354,64,355,66,356,71,362,81,365,83,366,88,367,93,368,95,369,100,371,102,372,106,374,110,375,112,376,122,381,129,342,154,384);
}
