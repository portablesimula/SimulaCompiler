// JavaLine 1 ==> SourceLine 1141
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:46:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PARSER$grammer$whilstat extends PARSER$grammer$statement {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=1141, lastLine=1200, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 1157
    final LABQNT$ REUSE=new LABQNT$(this,1,1); // Local Label #1=REUSE
    final LABQNT$ S0=new LABQNT$(this,1,2); // Local Label #2=S0
    // JavaLine 15 ==> SourceLine 1169
    final LABQNT$ recover1=new LABQNT$(this,1,3); // Local Label #3=recover1
    // JavaLine 17 ==> SourceLine 1174
    final LABQNT$ PARSE=new LABQNT$(this,1,4); // Local Label #4=PARSE
    // Declare locals as attributes
    public PRCQNT$ recover$0() { return(new PRCQNT$(this,PARSER$grammer$whilstat$recover.class)); }
    public PRCQNT$ recoversetting$0() { return(new PRCQNT$(this,PARSER$grammer$whilstat$recoversetting.class)); }
    // Normal Constructor
    public PARSER$grammer$whilstat(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("whilstat",1151);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("whilstat",1151,inner);
                PARSER$grammer$whilstat THIS$=(PARSER$grammer$whilstat)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 36 ==> SourceLine 1153
                        detach();
                        // JavaLine 38 ==> SourceLine 1157
                        LABEL$(1); // REUSE
                        LABEL$(2); // S0
                        caller.stmttype=((PARSER$grammer)(CUR$.SL$)).openstmt;
                        // JavaLine 42 ==> SourceLine 1158
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        // JavaLine 44 ==> SourceLine 1159
                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).ITRUE;
                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                        // JavaLine 47 ==> SourceLine 1160
                        if(((((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ICONS))&&((((PARSER)(CUR$.SL$.SL$)).opdhi==(((PARSER)(CUR$.SL$.SL$)).NUL))))&&((((PARSER)(CUR$.SL$.SL$)).opdlo==(((PARSER)(CUR$.SL$.SL$)).ITRUE))))&&((((PARSER)(CUR$.SL$.SL$)).opt==(((PARSER)(CUR$.SL$.SL$)).IDO))))) {
                            // JavaLine 49 ==> SourceLine 1162
                            rp=((char)3);
                        } else
                        // JavaLine 52 ==> SourceLine 1164
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1164",1164);
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IIFSB;
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            // JavaLine 57 ==> SourceLine 1165
                            call(((PARSER$grammer)(CUR$.SL$)).ex);
                            // JavaLine 59 ==> SourceLine 1166
                            if((((PARSER$grammer)(CUR$.SL$)).ex.wasNotexpr||((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IDO))))) {
                                // JavaLine 61 ==> SourceLine 1167
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1167",1167);
                                    new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$)),(((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IDO)))?(206):(205)));
                                    // JavaLine 65 ==> SourceLine 1168
                                    GOTO$(PARSE); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1167",1168);
                                }
                            }
                            // JavaLine 70 ==> SourceLine 1169
                            LABEL$(3); // recover1
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).ITHSB;
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            // JavaLine 74 ==> SourceLine 1170
                            rp=((char)1);
                            TRACE_END_STM$("CompoundStatement1164",1170);
                        }
                        // JavaLine 78 ==> SourceLine 1172
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        // JavaLine 80 ==> SourceLine 1174
                        LABEL$(4); // PARSE
                        detach();
                        // JavaLine 83 ==> SourceLine 1176
                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IFALS;
                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                        // JavaLine 86 ==> SourceLine 1177
                        switch(rp) { // BEGIN SWITCH STATEMENT
                        case 0: 
                        // JavaLine 89 ==> SourceLine 1179
                        GOTO$(S0); // GOTO EVALUATED LABEL
                        case 2: 
                        // JavaLine 92 ==> SourceLine 1181
                        GOTO$(recover1); // GOTO EVALUATED LABEL
                        case 1: 
                        // JavaLine 95 ==> SourceLine 1183
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1183",1183);
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IIFSE;
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            TRACE_END_STM$("CompoundStatement1183",1183);
                        }
                    } // END SWITCH STATEMENT
                    // JavaLine 103 ==> SourceLine 1188
                    caller.next=null;
                    ((PARSER$grammer)(CUR$.SL$)).last=caller;
                    // JavaLine 106 ==> SourceLine 1189
                    ((PARSER$grammer)(CUR$.SL$)).whList=((PARSER$grammer$statement)CUR$);
                    // JavaLine 108 ==> SourceLine 1191
                    detach();
                    // JavaLine 110 ==> SourceLine 1194
                    ((PARSER$grammer)(CUR$.SL$)).whList=null;
                    // JavaLine 112 ==> SourceLine 1195
                    errorno=0;
                    // JavaLine 114 ==> SourceLine 1196
                    recovered=isblocklike=false;
                    // JavaLine 116 ==> SourceLine 1197
                    rp=blockstatus=stmtreq=stmttype=((PARSER)(CUR$.SL$.SL$)).NUL;
                    // JavaLine 118 ==> SourceLine 1198
                    GOTO$(REUSE); // GOTO EVALUATED LABEL
                    // JavaLine 120 ==> SourceLine 1153
                    if(inner!=null) {
                        inner.STM$();
                        TRACE_BEGIN_STM_AFTER_INNER$("whilstat",1153);
                    }
                    break LOOP$;
                }
                catch(LABQNT$ q) {
                    CUR$=THIS$;
                    if(q.SL$!=CUR$ || q.prefixLevel!=1) {
                        CUR$.STATE$=OperationalState.terminated;
                        if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                        throw(q);
                    }
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                    JTX$=q.index; continue LOOP$; // EG. GOTO Lx
                }
            }
            TRACE_END_STM$("whilstat",1153);
        }
    };
} // End of Constructor
// Class Statements
public PARSER$grammer$whilstat STM$() { return((PARSER$grammer$whilstat)CODE$.EXEC$()); }
public PARSER$grammer$whilstat START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Class whilstat",1,1141,12,1157,15,1169,17,1174,36,1153,38,1157,42,1158,44,1159,47,1160,49,1162,52,1164,57,1165,59,1166,61,1167,65,1168,70,1169,74,1170,78,1172,80,1174,83,1176,86,1177,89,1179,92,1181,95,1183,103,1188,106,1189,108,1191,110,1194,112,1195,114,1196,116,1197,118,1198,120,1153,144,1200);
}
