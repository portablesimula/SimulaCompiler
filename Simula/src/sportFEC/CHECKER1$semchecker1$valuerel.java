// JavaLine 1 ==> SourceLine 342
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$valuerel extends CHECKER1$semchecker1$relation {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=3, firstLine=342, lastLine=422, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 410
    final LABQNT$ TypErr=new LABQNT$(this,3,1); // Local Label #1=TypErr
    // Declare locals as attributes
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$valuerel$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$valuerel(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$exp sp1$left,CHECKER1$semchecker1$exp sp1$right) {
        super(staticLink,sp$pred,sp$ch,sp1$left,sp1$right);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("valuerel",373);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("valuerel",373,inner);
                CHECKER1$semchecker1$valuerel THIS$=(CHECKER1$semchecker1$valuerel)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 30 ==> SourceLine 376
                        while(true) {
                            // JavaLine 32 ==> SourceLine 378
                            {
                                TRACE_BEGIN_STM$("CompoundStatement378",378);
                                ((CHECKER1$semchecker1)(CUR$.SL$)).exptop=((CHECKER1$semchecker1$valuerel)CUR$);
                                // JavaLine 36 ==> SourceLine 380
                                opttype=p1$left.type;
                                ctype=((CHECKER1)(CUR$.SL$.SL$)).IEQ;
                                // JavaLine 39 ==> SourceLine 381
                                if(VALUE$((p1$left.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN)))) {
                                    new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p1$left)));
                                }
                                // JavaLine 43 ==> SourceLine 382
                                if(VALUE$((p1$right.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN)))) {
                                    new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p1$right)));
                                }
                                // JavaLine 47 ==> SourceLine 383
                                cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                                // JavaLine 49 ==> SourceLine 385
                                switch(opttype) { // BEGIN SWITCH STATEMENT
                                case 1: 
                                case 7: 
                                // JavaLine 53 ==> SourceLine 387
                                if(VALUE$((p$ch==(((CHECKER1)(CUR$.SL$.SL$)).IEQV)))) {
                                    p$ch=((CHECKER1)(CUR$.SL$.SL$)).IEQ;
                                } else
                                GOTO$(TypErr); // GOTO EVALUATED LABEL
                                case 2: 
                                case 3: 
                                case 4: 
                                case 5: 
                                case 6: 
                                // JavaLine 63 ==> SourceLine 390
                                switch(p1$right.type) { // BEGIN SWITCH STATEMENT
                                case 2: 
                                case 3: 
                                case 4: 
                                case 5: 
                                case 6: 
                                // JavaLine 70 ==> SourceLine 394
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement394",394);
                                    ((CHECKER1)(CUR$.SL$.SL$)).rtype=p1$right.type;
                                    // JavaLine 74 ==> SourceLine 395
                                    if(VALUE$((((opttype<=(((CHECKER1)(CUR$.SL$.SL$)).IINTG))&&((((CHECKER1)(CUR$.SL$.SL$)).rtype==(((CHECKER1)(CUR$.SL$.SL$)).ICHAR))))||(((opttype==(((CHECKER1)(CUR$.SL$.SL$)).ICHAR))&&(((((CHECKER1)(CUR$.SL$.SL$)).rtype==(((CHECKER1)(CUR$.SL$.SL$)).IINTG))|((((CHECKER1)(CUR$.SL$.SL$)).rtype==(((CHECKER1)(CUR$.SL$.SL$)).ISHOR)))))))))) {
                                        // JavaLine 76 ==> SourceLine 398
                                        opttype=((CHECKER1)(CUR$.SL$.SL$)).ICHAR;
                                    } else
                                    // JavaLine 79 ==> SourceLine 399
                                    if(VALUE$((p1$right.type>(opttype)))) {
                                        opttype=p1$right.type;
                                    }
                                    TRACE_END_STM$("CompoundStatement394",399);
                                }
                                case 15: 
                                default:
                                // JavaLine 87 ==> SourceLine 402
                                new ERRMSG$error2xx(((CHECKER1)(CUR$.SL$.SL$)),432,p1$right.type,p$ch);
                            } // END SWITCH STATEMENT
                            case 8: 
                            case 9: 
                            // JavaLine 92 ==> SourceLine 406
                            if(VALUE$((opttype!=(p1$right.type)))) {
                                // JavaLine 94 ==> SourceLine 407
                                new CHECKER1$semchecker1$exp$incompTypes(((CHECKER1$semchecker1$valuerel)CUR$),opttype,p1$right.type);
                            }
                            case 15: 
                            default:
                            // JavaLine 99 ==> SourceLine 410
                            {
                                TRACE_BEGIN_STM$("CompoundStatement410",410);
                                LABEL$(1,"TypErr");
                                new ERRMSG$error2xx(((CHECKER1)(CUR$.SL$.SL$)),431,opttype,p$ch);
                                opttype=((CHECKER1)(CUR$.SL$.SL$)).IELSE;
                                TRACE_END_STM$("CompoundStatement410",410);
                            }
                        } // END SWITCH STATEMENT
                        // JavaLine 108 ==> SourceLine 414
                        type=((CHECKER1)(CUR$.SL$.SL$)).IBOOL;
                        // JavaLine 110 ==> SourceLine 416
                        detach();
                        // JavaLine 112 ==> SourceLine 418
                        ((CHECKER1$semchecker1)(CUR$.SL$)).valrelList=null;
                        // JavaLine 114 ==> SourceLine 419
                        p1$right=((CHECKER1$semchecker1)(CUR$.SL$)).exptop;
                        p1$left=p1$right.p$pred;
                        p$pred=p1$left.p$pred;
                        // JavaLine 118 ==> SourceLine 420
                        issimple=0;
                        TRACE_END_STM$("CompoundStatement378",420);
                    }
                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                }
                // JavaLine 124 ==> SourceLine 376
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("valuerel",376);
                }
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$ || q.prefixLevel!=3) {
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("valuerel",376);
    }
};
} // End of Constructor
// Class Statements
public CHECKER1$semchecker1$valuerel STM$() { return((CHECKER1$semchecker1$valuerel)CODE$.EXEC$()); }
public CHECKER1$semchecker1$valuerel START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class valuerel",1,342,12,410,30,376,32,378,36,380,39,381,43,382,47,383,49,385,53,387,63,390,70,394,74,395,76,398,79,399,87,402,92,406,94,407,99,410,108,414,110,416,112,418,114,419,118,420,124,376,148,422);
}
