// JavaLine 1 ==> SourceLine 1087
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$ifexp extends CHECKER1$semchecker1$operation {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=1087, lastLine=1169, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    public CHECKER1$semchecker1$exp p2$testexp;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 1142
    final LABQNT$ NONCOMP=new LABQNT$(this,2,1); // Local Label #1=NONCOMP
    // Declare locals as attributes
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$ifexp$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$ifexp(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$exp sp1$left,CHECKER1$semchecker1$exp sp1$right,CHECKER1$semchecker1$exp sp2$testexp) {
        super(staticLink,sp$pred,sp$ch,sp1$left,sp1$right);
        // Parameter assignment to locals
        this.p2$testexp = sp2$testexp;
        // Declaration Code
        TRACE_BEGIN_DCL$("ifexp",1117);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("ifexp",1117,inner);
                CHECKER1$semchecker1$ifexp THIS$=(CHECKER1$semchecker1$ifexp)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 31 ==> SourceLine 1121
                        type=p1$left.type;
                        qual=p1$left.qual;
                        // JavaLine 34 ==> SourceLine 1122
                        if(VALUE$((p1$left.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN)))) {
                            new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p1$left)));
                        }
                        // JavaLine 38 ==> SourceLine 1123
                        if(VALUE$((p1$right.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN)))) {
                            new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p1$right)));
                        }
                        // JavaLine 42 ==> SourceLine 1124
                        cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                        // JavaLine 44 ==> SourceLine 1125
                        if(VALUE$((p2$testexp.type!=(((CHECKER1)(CUR$.SL$.SL$)).IBOOL)))) {
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1125",1125);
                                if(VALUE$((p2$testexp.type!=(((CHECKER1)(CUR$.SL$.SL$)).IELSE)))) {
                                    // JavaLine 49 ==> SourceLine 1126
                                    new ERRMSG$error0(((CHECKER1)(CUR$.SL$.SL$)),161);
                                }
                                TRACE_END_STM$("CompoundStatement1125",1126);
                            }
                        }
                        // JavaLine 55 ==> SourceLine 1127
                        if(VALUE$((p2$testexp.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN)))) {
                            // JavaLine 57 ==> SourceLine 1128
                            new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p2$testexp)));
                        }
                        // JavaLine 60 ==> SourceLine 1131
                        switch(type) { // BEGIN SWITCH STATEMENT
                        case 2: 
                        case 3: 
                        case 4: 
                        case 5: 
                        case 6: 
                        // JavaLine 67 ==> SourceLine 1134
                        switch(p1$right.type) { // BEGIN SWITCH STATEMENT
                        case 2: 
                        case 3: 
                        case 4: 
                        case 5: 
                        case 6: 
                        // JavaLine 74 ==> SourceLine 1137
                        if(VALUE$((type<(p1$right.type)))) {
                            type=p1$right.type;
                        }
                        case 15: 
                        case 1: 
                        case 8: 
                        // JavaLine 81 ==> SourceLine 1141
                        if(VALUE$((type!=(p1$right.type)))) {
                            // JavaLine 83 ==> SourceLine 1142
                            LABEL$(1,"NONCOMP");
                            new CHECKER1$semchecker1$exp$incompTypes(((CHECKER1$semchecker1$ifexp)CUR$),type,p1$right.type);
                        }
                        default:
                        // JavaLine 88 ==> SourceLine 1143
                        GOTO$(NONCOMP); // GOTO EVALUATED LABEL
                    } // END SWITCH STATEMENT
                    case 7: 
                    // JavaLine 92 ==> SourceLine 1146
                    if(VALUE$((p1$right.type==(type)))) {
                        // JavaLine 94 ==> SourceLine 1147
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1147",1147);
                            if(VALUE$((qual!=(p1$right.qual)))) {
                                // JavaLine 98 ==> SourceLine 1148
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1148",1148);
                                    if(VALUE$((qual==(null)))) {
                                        qual=p1$right.qual;
                                    } else
                                    // JavaLine 104 ==> SourceLine 1149
                                    if(VALUE$((p1$right.qual!=(null)))) {
                                        // JavaLine 106 ==> SourceLine 1158
                                        new CHECKER1$semchecker1$ifexp$CompoundStatement1147$CompoundStatement1148$SubBlock1150(CUR$).STM$();
                                    }
                                    TRACE_END_STM$("CompoundStatement1148",1158);
                                }
                            }
                            TRACE_END_STM$("CompoundStatement1147",1158);
                        }
                    } else
                    // JavaLine 115 ==> SourceLine 1161
                    GOTO$(NONCOMP); // GOTO EVALUATED LABEL
                    case 15: 
                    // JavaLine 118 ==> SourceLine 1163
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1163",1163);
                        type=p1$right.type;
                        qual=p1$right.qual;
                        TRACE_END_STM$("CompoundStatement1163",1163);
                    }
                    default:
                    // JavaLine 126 ==> SourceLine 1166
                    if(VALUE$((type!=(p1$right.type)))) {
                        GOTO$(NONCOMP); // GOTO EVALUATED LABEL
                    }
                } // END SWITCH STATEMENT
                // JavaLine 131 ==> SourceLine 1121
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("ifexp",1121);
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
        TRACE_END_STM$("ifexp",1121);
    }
};
} // End of Constructor
// Class Statements
public CHECKER1$semchecker1$ifexp STM$() { return((CHECKER1$semchecker1$ifexp)CODE$.EXEC$()); }
public CHECKER1$semchecker1$ifexp START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class ifexp",1,1087,12,1142,31,1121,34,1122,38,1123,42,1124,44,1125,49,1126,55,1127,57,1128,60,1131,67,1134,74,1137,81,1141,83,1142,88,1143,92,1146,94,1147,98,1148,104,1149,106,1158,115,1161,118,1163,126,1166,131,1121,155,1169);
}
