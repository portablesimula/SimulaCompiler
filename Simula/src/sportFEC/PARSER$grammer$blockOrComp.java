// JavaLine 1 ==> SourceLine 976
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PARSER$grammer$blockOrComp extends PARSER$grammer$statement {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=976, lastLine=1128, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 1025
    final LABQNT$ REUSE=new LABQNT$(this,1,1); // Local Label #1=REUSE
    // JavaLine 14 ==> SourceLine 1032
    final LABQNT$ S0=new LABQNT$(this,1,2); // Local Label #2=S0
    // JavaLine 16 ==> SourceLine 1068
    final LABQNT$ unitmore=new LABQNT$(this,1,3); // Local Label #3=unitmore
    // JavaLine 18 ==> SourceLine 1070
    final LABQNT$ PARSE=new LABQNT$(this,1,4); // Local Label #4=PARSE
    // JavaLine 20 ==> SourceLine 1076
    final LABQNT$ recoverfromhere=new LABQNT$(this,1,5); // Local Label #5=recoverfromhere
    final LABQNT$ S1=new LABQNT$(this,1,6); // Local Label #6=S1
    // JavaLine 23 ==> SourceLine 1094
    final LABQNT$ endrecover=new LABQNT$(this,1,7); // Local Label #7=endrecover
    // Declare locals as attributes
    // JavaLine 26 ==> SourceLine 978
    public boolean innerseen=false;
    // JavaLine 28 ==> SourceLine 979
    public boolean labels=false;
    public boolean type=false;
    public boolean unlabbody=false;
    // JavaLine 32 ==> SourceLine 980
    public char blocktype=0;
    // JavaLine 34 ==> SourceLine 983
    public char R=0;
    // JavaLine 36 ==> SourceLine 984
    public int recovernox=0;
    public int recoverno=0;
    public PRCQNT$ recover$0() { return(new PRCQNT$(this,PARSER$grammer$blockOrComp$recover.class)); }
    public PRCQNT$ recoversetting$0() { return(new PRCQNT$(this,PARSER$grammer$blockOrComp$recoversetting.class)); }
    // Normal Constructor
    public PARSER$grammer$blockOrComp(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("blockOrComp",1013);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("blockOrComp",1013,inner);
                PARSER$grammer$blockOrComp THIS$=(PARSER$grammer$blockOrComp)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 55 ==> SourceLine 1022
                        detach();
                        // JavaLine 57 ==> SourceLine 1025
                        LABEL$(1,"REUSE");
                        labels=((PARSER$grammer)(CUR$.SL$)).labelused;
                        // JavaLine 60 ==> SourceLine 1026
                        if(VALUE$((caller.stmtreq==(((PARSER$grammer)(CUR$.SL$)).outermost)))) {
                            // JavaLine 62 ==> SourceLine 1027
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1027",1027);
                                ((PARSER$grammer$module)(caller)).SepOK=true;
                                // JavaLine 66 ==> SourceLine 1029
                                if(VALUE$(IS$(((PARSER)(CUR$.SL$.SL$)).coder,PARSER$codebuffer.class))) {
                                    // JavaLine 68 ==> SourceLine 1030
                                    new PARSER$codebuffer$termModul(((PARSER$codebuffer)(((PARSER)(CUR$.SL$.SL$)).coder)));
                                }
                                TRACE_END_STM$("CompoundStatement1027",1030);
                            }
                        }
                        // JavaLine 74 ==> SourceLine 1043
                        LABEL$(2,"S0");
                        // JavaLine 76 ==> SourceLine 1032
                        if(VALUE$(((PARSER$grammer)(CUR$.SL$)).ex.startexprstmt)) {
                            // JavaLine 78 ==> SourceLine 1033
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1033",1033);
                                ((PARSER$grammer)(CUR$.SL$)).ex.startexprstmt=false;
                                // JavaLine 82 ==> SourceLine 1035
                                ((PARSER)(CUR$.SL$.SL$)).opn=(((((PARSER)(CUR$.SL$.SL$)).optx!=(((PARSER)(CUR$.SL$.SL$)).NUL)))?(((PARSER)(CUR$.SL$.SL$)).IBPRF):(((PARSER)(CUR$.SL$.SL$)).IBEGI));
                                // JavaLine 84 ==> SourceLine 1037
                                call(((PARSER)(CUR$.SL$.SL$)).coder);
                                // JavaLine 86 ==> SourceLine 1038
                                ((PARSER$grammer)(CUR$.SL$)).detach();
                                // JavaLine 88 ==> SourceLine 1039
                                if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ISMCL)))) {
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1039",1039);
                                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IDCLE;
                                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                                        TRACE_END_STM$("CompoundStatement1039",1039);
                                    }
                                }
                                // JavaLine 97 ==> SourceLine 1040
                                isblocklike=true;
                                ((PARSER$grammer)(CUR$.SL$)).blockfound=(((PARSER$grammer)(CUR$.SL$)).blockfound+(1));
                                // JavaLine 100 ==> SourceLine 1041
                                blocktype=((PARSER$grammer)(CUR$.SL$)).prefixblock;
                                blockstatus=((PARSER$grammer)(CUR$.SL$)).stmtnotseen;
                                // JavaLine 103 ==> SourceLine 1042
                                R=((PARSER$grammer)(CUR$.SL$)).allstmt;
                                GOTO$(unitmore); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1033",1042);
                            }
                        }
                        // JavaLine 109 ==> SourceLine 1045
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        // JavaLine 111 ==> SourceLine 1046
                        unlabbody=((!(labels))&&(((caller.stmtreq==(((PARSER$grammer)(CUR$.SL$)).classbody))|((caller.stmtreq==(((PARSER$grammer)(CUR$.SL$)).procbody))))));
                        // JavaLine 113 ==> SourceLine 1048
                        isblocklike=true;
                        // JavaLine 115 ==> SourceLine 1049
                        if(VALUE$(((((PARSER$grammer)(CUR$.SL$)).symboltype.Elt[rank(((PARSER$grammer)(CUR$.SL$)).cs)-((PARSER$grammer)(CUR$.SL$)).symboltype.LB[0]]==(((PARSER$grammer)(CUR$.SL$)).declsymbol))||(((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IIDN))&&(((((PARSER)(CUR$.SL$.SL$)).opt==(((PARSER)(CUR$.SL$.SL$)).ICLAS))||((((PARSER)(CUR$.SL$.SL$)).opt==(((PARSER)(CUR$.SL$.SL$)).IRCRD)))))))))) {
                            // JavaLine 117 ==> SourceLine 1054
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1054",1054);
                                blocktype=((PARSER$grammer)(CUR$.SL$)).usualblock;
                                blockstatus=((PARSER$grammer)(CUR$.SL$)).stmtnotseen;
                                // JavaLine 122 ==> SourceLine 1055
                                if(VALUE$((!(unlabbody)))) {
                                    // JavaLine 124 ==> SourceLine 1056
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1056",1056);
                                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IBLKB;
                                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                                        // JavaLine 129 ==> SourceLine 1057
                                        ((PARSER$grammer)(CUR$.SL$)).blockfound=(((PARSER$grammer)(CUR$.SL$)).blockfound+(1));
                                        TRACE_END_STM$("CompoundStatement1056",1057);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement1054",1057);
                            }
                        } else
                        // JavaLine 137 ==> SourceLine 1061
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1061",1061);
                            blocktype=((PARSER$grammer)(CUR$.SL$)).compstmt;
                            blockstatus=((PARSER$grammer)(CUR$.SL$)).lastwasstmt;
                            // JavaLine 142 ==> SourceLine 1062
                            if(VALUE$(unlabbody)) {
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1062",1062);
                                    ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IDCLE;
                                    call(((PARSER)(CUR$.SL$.SL$)).coder);
                                    TRACE_END_STM$("CompoundStatement1062",1062);
                                }
                            }
                            TRACE_END_STM$("CompoundStatement1061",1062);
                        }
                        // JavaLine 153 ==> SourceLine 1065
                        R=((((caller.stmtreq==(((PARSER$grammer)(CUR$.SL$)).classbody))&&((!(labels)))))?(((PARSER$grammer)(CUR$.SL$)).stmtorinner):(((PARSER$grammer)(CUR$.SL$)).allstmt));
                        // JavaLine 155 ==> SourceLine 1068
                        LABEL$(3,"unitmore");
                        rp=((char)1);
                        stmtreq=R;
                        // JavaLine 159 ==> SourceLine 1070
                        LABEL$(4,"PARSE");
                        detach();
                        // JavaLine 162 ==> SourceLine 1072
                        if(VALUE$((rp==(((PARSER)(CUR$.SL$.SL$)).NUL)))) {
                            GOTO$(S0); // GOTO EVALUATED LABEL
                        }
                        // JavaLine 166 ==> SourceLine 1081
                        LABEL$(5,"recoverfromhere");
                        LABEL$(6,"S1");
                        // JavaLine 169 ==> SourceLine 1076
                        if(VALUE$((stmttype==(((PARSER$grammer)(CUR$.SL$)).declunit)))) {
                            // JavaLine 171 ==> SourceLine 1077
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1077",1077);
                                if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ISMCL)))) {
                                    // JavaLine 175 ==> SourceLine 1078
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1078",1078);
                                        stmttype=((PARSER$grammer)(CUR$.SL$)).dummystmt;
                                        GOTO$(unitmore); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1078",1078);
                                    }
                                }
                                // JavaLine 183 ==> SourceLine 1079
                                if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IEND)))) {
                                    GOTO$(unitmore); // GOTO EVALUATED LABEL
                                }
                                TRACE_END_STM$("CompoundStatement1077",1079);
                            }
                        } else
                        // JavaLine 190 ==> SourceLine 1081
                        if(VALUE$((stmttype!=(((PARSER$grammer)(CUR$.SL$)).dummystmt)))) {
                            blockstatus=((PARSER$grammer)(CUR$.SL$)).lastwasstmt;
                        }
                        // JavaLine 194 ==> SourceLine 1083
                        if(VALUE$((recoverno!=(0)))) {
                            // JavaLine 196 ==> SourceLine 1084
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1084",1084);
                                recovernox=recoverno;
                                recoverno=0;
                                // JavaLine 201 ==> SourceLine 1085
                                if(VALUE$((recovernox==(2)))) {
                                    GOTO$(endrecover); // GOTO EVALUATED LABEL
                                }
                                // JavaLine 205 ==> SourceLine 1086
                                if(VALUE$((recovernox==(3)))) {
                                    GOTO$(unitmore); // GOTO EVALUATED LABEL
                                }
                                TRACE_END_STM$("CompoundStatement1084",1086);
                            }
                        }
                        // JavaLine 212 ==> SourceLine 1089
                        if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IEND)))) {
                            // JavaLine 214 ==> SourceLine 1090
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1090",1090);
                                if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ISMCL)))) {
                                    // JavaLine 218 ==> SourceLine 1091
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1091",1091);
                                        ((PARSER$grammer)(CUR$.SL$)).detach();
                                        GOTO$(unitmore); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1091",1091);
                                    }
                                }
                                // JavaLine 226 ==> SourceLine 1092
                                new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$)),204);
                                GOTO$(PARSE); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1090",1092);
                            }
                        }
                        // JavaLine 232 ==> SourceLine 1102
                        LABEL$(7,"endrecover");
                        // JavaLine 234 ==> SourceLine 1094
                        if(VALUE$(((blocktype==(((PARSER$grammer)(CUR$.SL$)).prefixblock))|(((blocktype==(((PARSER$grammer)(CUR$.SL$)).usualblock))&((!(unlabbody)))))))) {
                            // JavaLine 236 ==> SourceLine 1099
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1099",1099);
                                ((PARSER)(CUR$.SL$.SL$)).opdlo=(((innerseen||((blockstatus!=(((PARSER$grammer)(CUR$.SL$)).lastwasstmt)))))?(((PARSER)(CUR$.SL$.SL$)).NUL):(((char)1)));
                                // JavaLine 240 ==> SourceLine 1101
                                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IEND;
                                call(((PARSER)(CUR$.SL$.SL$)).coder);
                                // JavaLine 243 ==> SourceLine 1102
                                ((PARSER$grammer)(CUR$.SL$)).blockfound=(((PARSER$grammer)(CUR$.SL$)).blockfound-(1));
                                TRACE_END_STM$("CompoundStatement1099",1102);
                            }
                        }
                        // JavaLine 248 ==> SourceLine 1103
                        if(VALUE$((caller.stmtreq==(((PARSER$grammer)(CUR$.SL$)).classbody)))) {
                            // JavaLine 250 ==> SourceLine 1104
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1104",1104);
                                // JavaLine 253 ==> SourceLine 1105
                                if(VALUE$(innerseen)) {
                                    ((PARSER$grammer$declaration)(caller)).innerseen=true;
                                } else
                                // JavaLine 257 ==> SourceLine 1106
                                ((PARSER$grammer$declaration)(caller)).priorseen=(blockstatus!=(((PARSER$grammer)(CUR$.SL$)).lastwasstmt));
                                TRACE_END_STM$("CompoundStatement1104",1106);
                            }
                        }
                        // JavaLine 262 ==> SourceLine 1110
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        // JavaLine 264 ==> SourceLine 1113
                        caller.next=null;
                        ((PARSER$grammer)(CUR$.SL$)).last=caller;
                        // JavaLine 267 ==> SourceLine 1114
                        ((PARSER$grammer)(CUR$.SL$)).exList=((PARSER$grammer$statement)CUR$);
                        // JavaLine 269 ==> SourceLine 1116
                        detach();
                        // JavaLine 271 ==> SourceLine 1119
                        ((PARSER$grammer)(CUR$.SL$)).exList=null;
                        // JavaLine 273 ==> SourceLine 1120
                        recovernox=recoverno=errorno=0;
                        // JavaLine 275 ==> SourceLine 1122
                        innerseen=labels=type=unlabbody=recovered=isblocklike=false;
                        // JavaLine 277 ==> SourceLine 1124
                        blocktype=R=rp=blockstatus=stmtreq=stmttype=((PARSER)(CUR$.SL$.SL$)).NUL;
                        // JavaLine 279 ==> SourceLine 1126
                        GOTO$(REUSE); // GOTO EVALUATED LABEL
                        // JavaLine 281 ==> SourceLine 1022
                        if(inner!=null) {
                            inner.STM$();
                            TRACE_BEGIN_STM_AFTER_INNER$("blockOrComp",1022);
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
                TRACE_END_STM$("blockOrComp",1022);
            }
        };
    } // End of Constructor
    // Class Statements
    public PARSER$grammer$blockOrComp STM$() { return((PARSER$grammer$blockOrComp)CODE$.EXEC$()); }
    public PARSER$grammer$blockOrComp START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Class blockOrComp",1,976,12,1025,14,1032,16,1068,18,1070,20,1076,23,1094,26,978,28,979,32,980,34,983,36,984,55,1022,57,1025,60,1026,62,1027,66,1029,68,1030,74,1043,76,1032,78,1033,82,1035,84,1037,86,1038,88,1039,97,1040,100,1041,103,1042,109,1045,111,1046,113,1048,115,1049,117,1054,122,1055,124,1056,129,1057,137,1061,142,1062,153,1065,155,1068,159,1070,162,1072,166,1081,169,1076,171,1077,175,1078,183,1079,190,1081,194,1083,196,1084,201,1085,205,1086,212,1089,214,1090,218,1091,226,1092,232,1102,234,1094,236,1099,240,1101,243,1102,248,1103,250,1104,253,1105,257,1106,262,1110,264,1113,267,1114,269,1116,271,1119,273,1120,275,1122,277,1124,279,1126,281,1022,305,1128);
}
