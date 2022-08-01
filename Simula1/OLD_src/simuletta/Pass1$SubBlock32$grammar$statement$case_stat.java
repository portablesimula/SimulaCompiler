// JavaLine 1 <== SourceLine 1173
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$statement$case_stat extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=5, firstLine=1173, lastLine=1229, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 10 <== SourceLine 1201
    final LABQNT$ M=new LABQNT$(this,1,"M"); // Local Label #1=M
    // JavaLine 12 <== SourceLine 1214
    final LABQNT$ WXIT=new LABQNT$(this,2,"WXIT"); // Local Label #2=WXIT
    // Declare locals as attributes
    // JavaLine 15 <== SourceLine 1174
    int l=0;
    int u=0;
    int whichx=0;
    char type=0;
    // JavaLine 20 <== SourceLine 1175
    int n=0;
    public ARRAY$<int[]>which=null;
    // Normal Constructor
    public Pass1$SubBlock32$grammar$statement$case_stat(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        // JavaLine 29 <== SourceLine 1175
        int[] which$LB=new int[1]; int[] which$UB=new int[1];
        which$LB[0]=0; which$UB[0]=255;
        BOUND_CHECK$(which$LB[0],which$UB[0]);
        which=new ARRAY$<int[]>(new int[which$UB[0]-which$LB[0]+1],which$LB,which$UB);
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$grammar$statement$case_stat STM$() {
        Pass1$SubBlock32$grammar$statement$case_stat THIS$=(Pass1$SubBlock32$grammar$statement$case_stat)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 42 <== SourceLine 1187
                new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_CASE$1);
                ;
                // JavaLine 45 <== SourceLine 1188
                l=new Pass1$SubBlock32$grammar$statement$case_stat$caseindex(((Pass1$SubBlock32$grammar$statement$case_stat)(CUR$))).RESULT$;
                ;
                // JavaLine 48 <== SourceLine 1189
                ((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)).detach();
                ;
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_COLON$1)))) {
                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)),1189,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_COLON$1);
                }
                ;
                // JavaLine 55 <== SourceLine 1190
                u=new Pass1$SubBlock32$grammar$statement$case_stat$caseindex(((Pass1$SubBlock32$grammar$statement$case_stat)(CUR$))).RESULT$;
                ;
                // JavaLine 58 <== SourceLine 1191
                if(VALUE$((l<(0)))) {
                    {
                        l=0;
                        ;
                        new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Negative Range Bound"));
                    }
                }
                ;
                // JavaLine 67 <== SourceLine 1192
                if(VALUE$((u<(l)))) {
                    // JavaLine 69 <== SourceLine 1193
                    {
                        u=l;
                        ;
                        new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Inconsistent case bounds"));
                    }
                }
                ;
                // JavaLine 77 <== SourceLine 1194
                ((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)).detach();
                ;
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)),1194,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                }
                ;
                // JavaLine 84 <== SourceLine 1195
                ((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63.out2byte(l);
                ;
                ((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63.out2byte(u);
                ;
                // JavaLine 89 <== SourceLine 1196
                if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                    new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63);
                }
                ;
                // JavaLine 94 <== SourceLine 1197
                ((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)).detach();
                ;
                new Pass1$SubBlock32$grammar$outexpr(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)),new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$))).RESULT$).RESULT$);
                ;
                // JavaLine 99 <== SourceLine 1198
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)),1198,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                }
                ;
                // JavaLine 104 <== SourceLine 1199
                ((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)).detach();
                ;
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_WHEN$1)))) {
                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)),1199,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_WHEN$1);
                }
                ;
                // JavaLine 111 <== SourceLine 1200
                while((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_WHEN$1))) {
                    // JavaLine 113 <== SourceLine 1201
                    {
                        LABEL$(1,"M");
                        which.Elt[n-which.LB[0]]=whichx=new Pass1$SubBlock32$grammar$statement$case_stat$caseindex(((Pass1$SubBlock32$grammar$statement$case_stat)(CUR$))).RESULT$;
                        ;
                        // JavaLine 118 <== SourceLine 1202
                        if(VALUE$(((whichx<(l))|((whichx>(u)))))) {
                            // JavaLine 120 <== SourceLine 1203
                            new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Illegal when-index"));
                        }
                        ;
                        // JavaLine 124 <== SourceLine 1204
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)).detach();
                        ;
                        // JavaLine 127 <== SourceLine 1205
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_COMMA$1)))) {
                            // JavaLine 129 <== SourceLine 1206
                            {
                                if(VALUE$((n<(255)))) {
                                    n=Math.addExact(n,1);
                                } else
                                new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Too many when-indexes"));
                                ;
                                // JavaLine 136 <== SourceLine 1207
                                GOTO$(M); // GOTO EVALUATED LABEL
                            }
                        }
                        ;
                        // JavaLine 141 <== SourceLine 1208
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_COLON$1)))) {
                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)),1208,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_COLON$1);
                        }
                        ;
                        // JavaLine 146 <== SourceLine 1209
                        new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_WHEN$1);
                        ;
                        ((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63.out2byte(Math.addExact(n,1));
                        ;
                        // JavaLine 151 <== SourceLine 1210
                        while(true) {
                            // JavaLine 153 <== SourceLine 1211
                            {
                                ((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63.out2byte(which.Elt[n-which.LB[0]]);
                                ;
                                // JavaLine 157 <== SourceLine 1212
                                if(VALUE$((n==(0)))) {
                                    GOTO$(WXIT); // GOTO EVALUATED LABEL
                                }
                                ;
                                n=Math.subtractExact(n,1);
                                ;
                            }
                            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                        }
                        ;
                        // JavaLine 168 <== SourceLine 1214
                        LABEL$(2,"WXIT");
                        if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                            new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63);
                        }
                        ;
                        // JavaLine 174 <== SourceLine 1215
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)).detach();
                        ;
                        // JavaLine 177 <== SourceLine 1216
                        new Pass1$SubBlock32$grammar$statement(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)));
                        ;
                        // JavaLine 180 <== SourceLine 1217
                        new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_ENDWHEN$1);
                        ;
                        // JavaLine 183 <== SourceLine 1218
                        if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                            new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63);
                        }
                        ;
                    }
                }
                ;
                // JavaLine 191 <== SourceLine 1220
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_OTHERWISE$1)))) {
                    // JavaLine 193 <== SourceLine 1221
                    {
                        new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_OTHERWISE$1);
                        ;
                        // JavaLine 197 <== SourceLine 1222
                        if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                            new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63);
                        }
                        ;
                        // JavaLine 202 <== SourceLine 1223
                        ((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)).detach();
                        ;
                        // JavaLine 205 <== SourceLine 1224
                        new Pass1$SubBlock32$grammar$statement(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)));
                    }
                }
                ;
                // JavaLine 210 <== SourceLine 1225
                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_ENDCASE$1)))) {
                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)),1225,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_ENDCASE$1);
                }
                ;
                // JavaLine 215 <== SourceLine 1226
                new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$28$62.S_ENDCASE$1);
                ;
                // JavaLine 218 <== SourceLine 1227
                if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                    new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$.SL$)).inspect$29$63);
                }
                ;
                // JavaLine 223 <== SourceLine 1228
                ((Pass1$SubBlock32$grammar)(CUR$.SL$.SL$)).detach();
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("case_stat:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("case_stat:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("case_stat:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure case_stat",1,1173,10,1201,12,1214,15,1174,20,1175,29,1175,42,1187,45,1188,48,1189,55,1190,58,1191,67,1192,69,1193,77,1194,84,1195,89,1196,94,1197,99,1198,104,1199,111,1200,113,1201,118,1202,120,1203,124,1204,127,1205,129,1206,136,1207,141,1208,146,1209,151,1210,153,1211,157,1212,168,1214,174,1215,177,1216,180,1217,183,1218,191,1220,193,1221,197,1222,202,1223,205,1224,210,1225,215,1226,218,1227,223,1228,242,1229);
} // End of Procedure
