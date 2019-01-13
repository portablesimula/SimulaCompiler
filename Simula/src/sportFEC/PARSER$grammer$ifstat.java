// JavaLine 1 ==> SourceLine 1221
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:25 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PARSER$grammer$ifstat extends PARSER$grammer$statement {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=1221, lastLine=1293, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 1245
    final LABQNT$ REUSE=new LABQNT$(this,1,1); // Local Label #1=REUSE
    final LABQNT$ S0=new LABQNT$(this,1,2); // Local Label #2=S0
    // JavaLine 15 ==> SourceLine 1253
    final LABQNT$ recover1=new LABQNT$(this,1,3); // Local Label #3=recover1
    // JavaLine 17 ==> SourceLine 1260
    final LABQNT$ PARSE=new LABQNT$(this,1,4); // Local Label #4=PARSE
    // JavaLine 19 ==> SourceLine 1269
    final LABQNT$ S1=new LABQNT$(this,1,5); // Local Label #5=S1
    // JavaLine 21 ==> SourceLine 1273
    final LABQNT$ recover2=new LABQNT$(this,1,6); // Local Label #6=recover2
    // JavaLine 23 ==> SourceLine 1278
    final LABQNT$ S2=new LABQNT$(this,1,7); // Local Label #7=S2
    // Declare locals as attributes
    public PRCQNT$ recover$0() { return(new PRCQNT$(this,PARSER$grammer$ifstat$recover.class)); }
    public PRCQNT$ recoversetting$0() { return(new PRCQNT$(this,PARSER$grammer$ifstat$recoversetting.class)); }
    // Normal Constructor
    public PARSER$grammer$ifstat(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("ifstat",1237);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("ifstat",1237,inner);
                PARSER$grammer$ifstat THIS$=(PARSER$grammer$ifstat)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 42 ==> SourceLine 1241
                        detach();
                        // JavaLine 44 ==> SourceLine 1245
                        LABEL$(1); // REUSE
                        LABEL$(2); // S0
                        if((caller.stmtreq==(((PARSER$grammer)(CUR$.SL$)).allbutif))) {
                            new PARSER$grammer$ParsWarn(((PARSER$grammer)(CUR$.SL$)),213);
                        }
                        // JavaLine 50 ==> SourceLine 1246
                        caller.stmttype=((PARSER$grammer)(CUR$.SL$)).openstmt;
                        // JavaLine 52 ==> SourceLine 1247
                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IIFSB;
                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                        // JavaLine 55 ==> SourceLine 1248
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        // JavaLine 57 ==> SourceLine 1249
                        call(((PARSER$grammer)(CUR$.SL$)).ex);
                        // JavaLine 59 ==> SourceLine 1250
                        if(((PARSER$grammer)(CUR$.SL$)).ex.wasNotexpr) {
                            // JavaLine 61 ==> SourceLine 1251
                            new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$)),205);
                        } else
                        // JavaLine 64 ==> SourceLine 1252
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1252",1252);
                            if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ITHEN))) {
                                // JavaLine 68 ==> SourceLine 1253
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1253",1253);
                                    LABEL$(3); // recover1
                                    ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).ITHSB;
                                    call(((PARSER)(CUR$.SL$.SL$)).coder);
                                    // JavaLine 74 ==> SourceLine 1254
                                    ((PARSER$grammer)(CUR$.SL$)).detach();
                                    // JavaLine 76 ==> SourceLine 1255
                                    stmtreq=((PARSER$grammer)(CUR$.SL$)).allbutif;
                                    rp=((char)1);
                                    TRACE_END_STM$("CompoundStatement1253",1255);
                                }
                            } else
                            // JavaLine 82 ==> SourceLine 1257
                            new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$)),207);
                            TRACE_END_STM$("CompoundStatement1252",1257);
                        }
                        // JavaLine 86 ==> SourceLine 1260
                        LABEL$(4); // PARSE
                        detach();
                        // JavaLine 89 ==> SourceLine 1262
                        switch(rp) { // BEGIN SWITCH STATEMENT
                        case 2: 
                        // JavaLine 92 ==> SourceLine 1263
                        GOTO$(S2); // GOTO EVALUATED LABEL
                        case 3: 
                        // JavaLine 95 ==> SourceLine 1264
                        GOTO$(recover1); // GOTO EVALUATED LABEL
                        case 4: 
                        // JavaLine 98 ==> SourceLine 1265
                        GOTO$(recover2); // GOTO EVALUATED LABEL
                        case 0: 
                        // JavaLine 101 ==> SourceLine 1266
                        GOTO$(S0); // GOTO EVALUATED LABEL
                    } // END SWITCH STATEMENT
                    // JavaLine 104 ==> SourceLine 1276
                    LABEL$(5); // S1
                    // JavaLine 106 ==> SourceLine 1269
                    if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IELSE))) {
                        // JavaLine 108 ==> SourceLine 1273
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1273",1273);
                            LABEL$(6); // recover2
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IELSB;
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            // JavaLine 114 ==> SourceLine 1274
                            ((PARSER$grammer)(CUR$.SL$)).detach();
                            // JavaLine 116 ==> SourceLine 1275
                            stmtreq=((PARSER$grammer)(CUR$.SL$)).allstmt;
                            rp=((char)2);
                            GOTO$(PARSE); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1273",1275);
                        }
                    }
                    // JavaLine 123 ==> SourceLine 1278
                    LABEL$(7); // S2
                    ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IIFSE;
                    call(((PARSER)(CUR$.SL$.SL$)).coder);
                    // JavaLine 127 ==> SourceLine 1281
                    caller.next=null;
                    ((PARSER$grammer)(CUR$.SL$)).last=caller;
                    // JavaLine 130 ==> SourceLine 1282
                    ((PARSER$grammer)(CUR$.SL$)).ifList=((PARSER$grammer$statement)CUR$);
                    // JavaLine 132 ==> SourceLine 1284
                    detach();
                    // JavaLine 134 ==> SourceLine 1287
                    ((PARSER$grammer)(CUR$.SL$)).ifList=null;
                    // JavaLine 136 ==> SourceLine 1288
                    errorno=0;
                    // JavaLine 138 ==> SourceLine 1289
                    recovered=isblocklike=false;
                    // JavaLine 140 ==> SourceLine 1290
                    rp=blockstatus=stmtreq=stmttype=((PARSER)(CUR$.SL$.SL$)).NUL;
                    // JavaLine 142 ==> SourceLine 1291
                    GOTO$(REUSE); // GOTO EVALUATED LABEL
                    // JavaLine 144 ==> SourceLine 1241
                    if(inner!=null) {
                        inner.STM$();
                        TRACE_BEGIN_STM_AFTER_INNER$("ifstat",1241);
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
            TRACE_END_STM$("ifstat",1241);
        }
    };
} // End of Constructor
// Class Statements
public PARSER$grammer$ifstat STM$() { return((PARSER$grammer$ifstat)CODE$.EXEC$()); }
public PARSER$grammer$ifstat START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Class ifstat",1,1221,12,1245,15,1253,17,1260,19,1269,21,1273,23,1278,42,1241,44,1245,50,1246,52,1247,55,1248,57,1249,59,1250,61,1251,64,1252,68,1253,74,1254,76,1255,82,1257,86,1260,89,1262,92,1263,95,1264,98,1265,101,1266,104,1276,106,1269,108,1273,114,1274,116,1275,123,1278,127,1281,130,1282,132,1284,134,1287,136,1288,138,1289,140,1290,142,1291,144,1241,168,1293);
}
