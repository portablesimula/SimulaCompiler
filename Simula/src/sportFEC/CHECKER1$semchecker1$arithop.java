// JavaLine 1 ==> SourceLine 424
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$arithop extends CHECKER1$semchecker1$operation {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=424, lastLine=477, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 464
    final LABQNT$ CHKcomp=new LABQNT$(this,2,1); // Local Label #1=CHKcomp
    // Declare locals as attributes
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$arithop$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$arithop(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$exp sp1$left,CHECKER1$semchecker1$exp sp1$right) {
        super(staticLink,sp$pred,sp$ch,sp1$left,sp1$right);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("arithop",442);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("arithop",442,inner);
                CHECKER1$semchecker1$arithop THIS$=(CHECKER1$semchecker1$arithop)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 29 ==> SourceLine 446
                        if((p1$right.kind!=(((CHECKER1)(CUR$.SL$.SL$)).K_ident))) {
                            {
                                TRACE_BEGIN_STM$("CompoundStatement446",446);
                                if((p1$right.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN))) {
                                    // JavaLine 34 ==> SourceLine 447
                                    new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p1$right)));
                                }
                                TRACE_END_STM$("CompoundStatement446",447);
                            }
                        }
                        // JavaLine 40 ==> SourceLine 448
                        if((p1$left.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN))) {
                            // JavaLine 42 ==> SourceLine 449
                            {
                                TRACE_BEGIN_STM$("CompoundStatement449",449);
                                if((p1$left.kind!=(((CHECKER1)(CUR$.SL$.SL$)).K_ident))) {
                                    // JavaLine 46 ==> SourceLine 451
                                    new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p1$left)));
                                }
                                TRACE_END_STM$("CompoundStatement449",451);
                            }
                        } else
                        if((p1$left.p$ch==(((CHECKER1)(CUR$.SL$.SL$)).ICONS))) {
                            // JavaLine 53 ==> SourceLine 452
                            {
                                TRACE_BEGIN_STM$("CompoundStatement452",452);
                                if(((p$ch==(((CHECKER1)(CUR$.SL$.SL$)).IPLUS))||((p$ch==(((CHECKER1)(CUR$.SL$.SL$)).IMULT))))) {
                                    // JavaLine 57 ==> SourceLine 453
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement453",453);
                                        ((CHECKER1$semchecker1)(CUR$.SL$)).expv=p1$left;
                                        p1$left=p1$right;
                                        p1$right=((CHECKER1$semchecker1)(CUR$.SL$)).expv;
                                        TRACE_END_STM$("CompoundStatement453",453);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement452",453);
                            }
                        }
                        // JavaLine 69 ==> SourceLine 455
                        type=((CHECKER1)(CUR$.SL$.SL$)).rtype=p1$right.type;
                        // JavaLine 71 ==> SourceLine 456
                        ((CHECKER1)(CUR$.SL$.SL$)).ltype=p1$left.type;
                        // JavaLine 73 ==> SourceLine 457
                        cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                        ctype=((CHECKER1)(CUR$.SL$.SL$)).IUPLS;
                        // JavaLine 76 ==> SourceLine 459
                        switch(type) { // BEGIN SWITCH STATEMENT
                        case 2: 
                        case 3: 
                        // JavaLine 80 ==> SourceLine 462
                        {
                            TRACE_BEGIN_STM$("CompoundStatement462",462);
                            type=((CHECKER1)(CUR$.SL$.SL$)).IINTG;
                            GOTO$(CHKcomp); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement462",462);
                        }
                        case 4: 
                        case 5: 
                        case 6: 
                        // JavaLine 90 ==> SourceLine 471
                        LABEL$(1); // CHKcomp
                        // JavaLine 92 ==> SourceLine 464
                        switch(p1$left.type) { // BEGIN SWITCH STATEMENT
                        case 2: 
                        case 3: 
                        case 4: 
                        case 5: 
                        case 6: 
                        // JavaLine 99 ==> SourceLine 468
                        if((type<(p1$left.type))) {
                            type=p1$left.type;
                        }
                        default:
                        // JavaLine 104 ==> SourceLine 470
                        {
                            TRACE_BEGIN_STM$("CompoundStatement470",470);
                            ((CHECKER1)(CUR$.SL$.SL$)).ltype=((CHECKER1)(CUR$.SL$.SL$)).IINTG;
                            new ERRMSG$error2xx(((CHECKER1)(CUR$.SL$.SL$)),429,p1$left.type,p$ch);
                            TRACE_END_STM$("CompoundStatement470",470);
                        }
                    } // END SWITCH STATEMENT
                    default:
                    // JavaLine 113 ==> SourceLine 473
                    {
                        TRACE_BEGIN_STM$("CompoundStatement473",473);
                        ((CHECKER1)(CUR$.SL$.SL$)).ltype=((CHECKER1)(CUR$.SL$.SL$)).rtype=((CHECKER1)(CUR$.SL$.SL$)).IINTG;
                        // JavaLine 117 ==> SourceLine 474
                        new ERRMSG$error2xx(((CHECKER1)(CUR$.SL$.SL$)),430,type,p$ch);
                        type=((CHECKER1)(CUR$.SL$.SL$)).IELSE;
                        TRACE_END_STM$("CompoundStatement473",474);
                    }
                } // END SWITCH STATEMENT
                // JavaLine 123 ==> SourceLine 446
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("arithop",446);
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
        TRACE_END_STM$("arithop",446);
    }
};
} // End of Constructor
// Class Statements
public CHECKER1$semchecker1$arithop STM$() { return((CHECKER1$semchecker1$arithop)CODE$.EXEC$()); }
public CHECKER1$semchecker1$arithop START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class arithop",1,424,11,464,29,446,34,447,40,448,42,449,46,451,53,452,57,453,69,455,71,456,73,457,76,459,80,462,90,471,92,464,99,468,104,470,113,473,117,474,123,446,147,477);
}
