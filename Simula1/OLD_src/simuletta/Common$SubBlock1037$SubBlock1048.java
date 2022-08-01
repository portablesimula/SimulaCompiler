// JavaLine 1 <== SourceLine 1048
package simuletta;
// Simula-1.0 Compiled at Sun Apr 12 14:50:34 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$SubBlock1037$SubBlock1048 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=3, firstLine=1048, lastLine=1398, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 1097
    final LABQNT$ SETem=new LABQNT$(this,1,"SETem"); // Local Label #1=SETem
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 1048
    int i=0;
    char cs=0;
    TXT$ t=null;
    TXT$ listname=null;
    TXT$ feoptions=null;
    // Normal Constructor
    public Common$SubBlock1037$SubBlock1048(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Common$SubBlock1037$SubBlock1048 THIS$=(Common$SubBlock1037$SubBlock1048)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 30 <== SourceLine 1050
                ((Common)(CUR$.SL$.SL$)).TRC_info$1=new Head$(((Common)(CUR$.SL$.SL$))).STM$();
                ;
                ;
                // JavaLine 34 <== SourceLine 1052
                ((Common)(CUR$.SL$.SL$)).TRC_init$1=new Head$(((Common)(CUR$.SL$.SL$))).STM$();
                ;
                // JavaLine 37 <== SourceLine 1056
                ((Common)(CUR$.SL$.SL$)).modset$1=new Head$(((Common)(CUR$.SL$.SL$))).STM$();
                ;
                // JavaLine 40 <== SourceLine 1057
                ((Common)(CUR$.SL$.SL$)).qntset$1=new Head$(((Common)(CUR$.SL$.SL$))).STM$();
                ;
                // JavaLine 43 <== SourceLine 1062
                ((Common)(CUR$.SL$.SL$)).L2name$1=getTextInfo(7);
                ;
                // JavaLine 46 <== SourceLine 1063
                ((Common)(CUR$.SL$.SL$)).nscodename$1=getTextInfo(4);
                ;
                // JavaLine 49 <== SourceLine 1065
                ((Common)(CUR$.SL$.SL$)).recomp$1=(getIntInfo(22)==(1));
                ;
                // JavaLine 52 <== SourceLine 1066
                ((Common)(CUR$.SL$.SL$)).GenerateScode$1=(getIntInfo(1)==(1));
                ;
                // JavaLine 55 <== SourceLine 1068
                ((Common)(CUR$.SL$.SL$)).timestamp$1=datetime();
                ;
                // JavaLine 58 <== SourceLine 1069
                ((Common)(CUR$.SL$.SL$)).maxerrno$1=getIntInfo(4);
                ;
                // JavaLine 61 <== SourceLine 1070
                ((Common)(CUR$.SL$.SL$)).GiveNotes$1=(getIntInfo(5)==(0));
                ;
                // JavaLine 64 <== SourceLine 1071
                ((Common)(CUR$.SL$.SL$)).simob_level$1=getIntInfo(30);
                ;
                // JavaLine 67 <== SourceLine 1072
                ((Common)(CUR$.SL$.SL$)).simob_descr$1=(((Common)(CUR$.SL$.SL$)).simob_level$1>(0));
                ;
                // JavaLine 70 <== SourceLine 1073
                ((Common)(CUR$.SL$.SL$)).simob_entity$1=(((Common)(CUR$.SL$.SL$)).simob_level$1>=(2));
                ;
                ((Common)(CUR$.SL$.SL$)).simob_const$1=(((Common)(CUR$.SL$.SL$)).simob_level$1>=(3));
                ;
                // JavaLine 75 <== SourceLine 1077
                listname=getTextInfo(2);
                ;
                ((Common)(CUR$.SL$.SL$)).listlength$1=TXT$.length(sysout().image);
                ;
                // JavaLine 80 <== SourceLine 1078
                if(VALUE$(TRF_NE(listname,null))) {
                    // JavaLine 82 <== SourceLine 1079
                    {
                        t=copy(copy(listname));
                        ;
                        t=lowcase(t);
                        ;
                        // JavaLine 88 <== SourceLine 1080
                        if(VALUE$(TXTREL$EQ(t,new TXT$("sysout")))) {
                            ((Common)(CUR$.SL$.SL$)).ListFile$1=sysout();
                        } else
                        // JavaLine 92 <== SourceLine 1081
                        {
                            // BEGIN INSPECTION 
                            ((Common)(CUR$.SL$.SL$)).inspect$1081$19$1=new PrintFile$(((BASICIO$)CTX$),listname).STM$();
                            if(((Common)(CUR$.SL$.SL$)).inspect$1081$19$1!=null) // INSPECT inspect$1081$19
                            // JavaLine 97 <== SourceLine 1082
                            {
                                ((Common)(CUR$.SL$.SL$)).listlength$1=getIntInfo(7);
                                ;
                                t=blanks(((Common)(CUR$.SL$.SL$)).listlength$1);
                                ;
                                // JavaLine 103 <== SourceLine 1083
                                if(VALUE$((!(((Common)(CUR$.SL$.SL$)).inspect$1081$19$1.open(t))))) {
                                    // JavaLine 105 <== SourceLine 1084
                                    {
                                        ((Common)(CUR$.SL$.SL$)).listlength$1=0;
                                        ;
                                        // JavaLine 109 <== SourceLine 1085
                                        new Common$error1(((Common)(CUR$.SL$.SL$)),(-(366)),listname);
                                    }
                                } else
                                ((Common)(CUR$.SL$.SL$)).ListFile$1=((PrintFile$)((Common)(CUR$.SL$.SL$)).inspect$1081$19$1);
                                ;
                            }
                        }
                        ;
                    }
                }
                ;
                // JavaLine 121 <== SourceLine 1088
                ((Common)(CUR$.SL$.SL$)).listingon$1=(((Common)(CUR$.SL$.SL$)).ListFile$1!=(null));
                ;
                // JavaLine 124 <== SourceLine 1092
                t=getTextInfo(16);
                ;
                // JavaLine 127 <== SourceLine 1093
                while(TXT$.more(t)) {
                    if(VALUE$((TXT$.getchar(t)==(':')))) {
                        // JavaLine 130 <== SourceLine 1094
                        {
                            if(VALUE$(TXT$.more(t))) {
                                feoptions=copy(copy(TXT$.sub(t,TXT$.pos(t),Math.addExact(Math.subtractExact(TXT$.length(t),TXT$.pos(t)),1))));
                            }
                            ;
                            // JavaLine 136 <== SourceLine 1095
                            t=TXT$.sub(t,1,Math.subtractExact(TXT$.pos(t),2));
                            ;
                            GOTO$(SETem); // GOTO EVALUATED LABEL
                            ;
                        }
                    }
                }
                ;
                // JavaLine 145 <== SourceLine 1097
                LABEL$(1,"SETem");
                new Common$SetSelectors(((Common)(CUR$.SL$.SL$)),t,0);
                ;
                // JavaLine 149 <== SourceLine 1098
                while(TXT$.more(feoptions)) {
                    new Common$setopt(((Common)(CUR$.SL$.SL$)),TXT$.getchar(feoptions),1);
                }
                ;
                // JavaLine 154 <== SourceLine 1100
                ((Common)(CUR$.SL$.SL$)).termstatus$1=3;
                ;
                // JavaLine 157 <== SourceLine 1101
                ((Common)(CUR$.SL$.SL$)).currentpass$1=1;
                ;
                // JavaLine 160 <== SourceLine 1104
                ((Common)(CUR$.SL$.SL$)).leftintbuf$1=blanks(12);
                ;
                // JavaLine 163 <== SourceLine 1105
                ((Common)(CUR$.SL$.SL$)).leftsintbuf$1=blanks(7);
                ;
                // JavaLine 166 <== SourceLine 1107
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_NULL$1,new TXT$("NULL"));
                ;
                // JavaLine 169 <== SourceLine 1108
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_RECORD$1,new TXT$("RECORD"));
                ;
                // JavaLine 172 <== SourceLine 1109
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_LSHIFTL$1,new TXT$("LSHIFTL"));
                ;
                // JavaLine 175 <== SourceLine 1110
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_PREFIX$1,new TXT$("PREFIX"));
                ;
                // JavaLine 178 <== SourceLine 1111
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ATTR$1,new TXT$("ATTR"));
                ;
                // JavaLine 181 <== SourceLine 1112
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_LSHIFTA$1,new TXT$("LSHIFTA"));
                ;
                // JavaLine 184 <== SourceLine 1113
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_REP$1,new TXT$("REP"));
                ;
                // JavaLine 187 <== SourceLine 1114
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ALT$1,new TXT$("ALT"));
                ;
                // JavaLine 190 <== SourceLine 1115
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_FIXREP$1,new TXT$("FIXREP"));
                ;
                // JavaLine 193 <== SourceLine 1116
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ENDRECORD$1,new TXT$("ENDRECORD"));
                ;
                // JavaLine 196 <== SourceLine 1117
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_C_RECORD$1,new TXT$("C_RECORD"));
                ;
                // JavaLine 199 <== SourceLine 1118
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_TEXT$1,new TXT$("TEXT"));
                ;
                // JavaLine 202 <== SourceLine 1119
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_C_CHAR$1,new TXT$("C_CHAR"));
                ;
                // JavaLine 205 <== SourceLine 1120
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_C_INT$1,new TXT$("C_INT"));
                ;
                // JavaLine 208 <== SourceLine 1121
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_C_SIZE$1,new TXT$("C_SIZE"));
                ;
                // JavaLine 211 <== SourceLine 1123
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_C_REAL$1,new TXT$("C_REAL"));
                ;
                // JavaLine 214 <== SourceLine 1124
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_C_LREAL$1,new TXT$("C_LREAL"));
                ;
                // JavaLine 217 <== SourceLine 1125
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_C_AADDR$1,new TXT$("C_AADDR"));
                ;
                // JavaLine 220 <== SourceLine 1126
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_C_OADDR$1,new TXT$("C_OADDR"));
                ;
                // JavaLine 223 <== SourceLine 1128
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_C_GADDR$1,new TXT$("C_GADDR"));
                ;
                // JavaLine 226 <== SourceLine 1129
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_C_PADDR$1,new TXT$("C_PADDR"));
                ;
                // JavaLine 229 <== SourceLine 1130
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_C_DOT$1,new TXT$("C_DOT"));
                ;
                // JavaLine 232 <== SourceLine 1131
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_C_RADDR$1,new TXT$("C_RADDR"));
                ;
                // JavaLine 235 <== SourceLine 1133
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_NOBODY$1,new TXT$("NOBODY"));
                ;
                // JavaLine 238 <== SourceLine 1134
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ANONE$1,new TXT$("ANONE"));
                ;
                // JavaLine 241 <== SourceLine 1135
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ONONE$1,new TXT$("ONONE"));
                ;
                // JavaLine 244 <== SourceLine 1136
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_GNONE$1,new TXT$("GNONE"));
                ;
                // JavaLine 247 <== SourceLine 1138
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_NOWHERE$1,new TXT$("NOWHERE"));
                ;
                // JavaLine 250 <== SourceLine 1139
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_TRUE$1,new TXT$("TRUE"));
                ;
                // JavaLine 253 <== SourceLine 1140
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_FALSE$1,new TXT$("FALSE"));
                ;
                // JavaLine 256 <== SourceLine 1141
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_PROFILE$1,new TXT$("PROFILE"));
                ;
                // JavaLine 259 <== SourceLine 1143
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_KNOWN$1,new TXT$("KNOWN"));
                ;
                // JavaLine 262 <== SourceLine 1144
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_SYSTEM$1,new TXT$("SYSTEM"));
                ;
                // JavaLine 265 <== SourceLine 1145
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_EXTERNAL$1,new TXT$("EXTERNAL"));
                ;
                // JavaLine 268 <== SourceLine 1146
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_IMPORT$1,new TXT$("IMPORT"));
                ;
                // JavaLine 271 <== SourceLine 1148
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_EXPORT$1,new TXT$("EXPORT"));
                ;
                // JavaLine 274 <== SourceLine 1149
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_EXIT$1,new TXT$("EXIT"));
                ;
                // JavaLine 277 <== SourceLine 1150
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ENDPROFILE$1,new TXT$("ENDPROFILE"));
                ;
                // JavaLine 280 <== SourceLine 1151
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ROUTINESPEC$1,new TXT$("ROUTINESPEC"));
                ;
                // JavaLine 283 <== SourceLine 1153
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ROUTINE$1,new TXT$("ROUTINE"));
                ;
                // JavaLine 286 <== SourceLine 1154
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_LOCAL$1,new TXT$("LOCAL"));
                ;
                // JavaLine 289 <== SourceLine 1155
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ENDROUTINE$1,new TXT$("ENDROUTINE"));
                ;
                // JavaLine 292 <== SourceLine 1156
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_MODULE$1,new TXT$("MODULE"));
                ;
                // JavaLine 295 <== SourceLine 1158
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_EXISTING$1,new TXT$("EXISTING"));
                ;
                // JavaLine 298 <== SourceLine 1159
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_TAG$1,new TXT$("TAG"));
                ;
                // JavaLine 301 <== SourceLine 1160
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_BODY$1,new TXT$("BODY"));
                ;
                // JavaLine 304 <== SourceLine 1161
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ENDMODULE$1,new TXT$("ENDMODULE"));
                ;
                // JavaLine 307 <== SourceLine 1163
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_LABELSPEC$1,new TXT$("LABELSPEC"));
                ;
                // JavaLine 310 <== SourceLine 1164
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_LABEL$1,new TXT$("LABEL"));
                ;
                // JavaLine 313 <== SourceLine 1165
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_RANGE$1,new TXT$("RANGE"));
                ;
                // JavaLine 316 <== SourceLine 1166
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_GLOBAL$1,new TXT$("GLOBAL"));
                ;
                // JavaLine 319 <== SourceLine 1168
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_INIT$1,new TXT$("INIT"));
                ;
                // JavaLine 322 <== SourceLine 1169
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_CONSTSPEC$1,new TXT$("CONSTSPEC"));
                ;
                // JavaLine 325 <== SourceLine 1170
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_CONST$1,new TXT$("CONST"));
                ;
                // JavaLine 328 <== SourceLine 1171
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_DELETE$1,new TXT$("DELETE"));
                ;
                // JavaLine 331 <== SourceLine 1173
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_FDEST$1,new TXT$("FDEST"));
                ;
                // JavaLine 334 <== SourceLine 1174
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_BDEST$1,new TXT$("BDEST"));
                ;
                // JavaLine 337 <== SourceLine 1175
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_SAVE$1,new TXT$("SAVE"));
                ;
                // JavaLine 340 <== SourceLine 1176
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_RESTORE$1,new TXT$("RESTORE"));
                ;
                // JavaLine 343 <== SourceLine 1178
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_BSEG$1,new TXT$("BSEG"));
                ;
                // JavaLine 346 <== SourceLine 1179
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ESEG$1,new TXT$("ESEG"));
                ;
                // JavaLine 349 <== SourceLine 1180
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_SKIPIF$1,new TXT$("SKIPIF"));
                ;
                // JavaLine 352 <== SourceLine 1181
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ENDSKIP$1,new TXT$("ENDSKIP"));
                ;
                // JavaLine 355 <== SourceLine 1183
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_IF$1,new TXT$("IF"));
                ;
                // JavaLine 358 <== SourceLine 1184
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ELSE$1,new TXT$("ELSE"));
                ;
                // JavaLine 361 <== SourceLine 1185
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ENDIF$1,new TXT$("ENDIF"));
                ;
                // JavaLine 364 <== SourceLine 1187
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_RSHIFTL$1,new TXT$("RSHIFTL"));
                ;
                // JavaLine 367 <== SourceLine 1189
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_PRECALL$1,new TXT$("PRECALL"));
                ;
                // JavaLine 370 <== SourceLine 1190
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ASSPAR$1,new TXT$("ASSPAR"));
                ;
                // JavaLine 373 <== SourceLine 1191
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ASSREP$1,new TXT$("ASSREP"));
                ;
                // JavaLine 376 <== SourceLine 1192
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_CALL$1,new TXT$("CALL"));
                ;
                // JavaLine 379 <== SourceLine 1194
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_FETCH$1,new TXT$("FETCH"));
                ;
                // JavaLine 382 <== SourceLine 1195
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_REFER$1,new TXT$("REFER"));
                ;
                // JavaLine 385 <== SourceLine 1196
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_DEREF$1,new TXT$("DEREF"));
                ;
                // JavaLine 388 <== SourceLine 1197
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_SELECT$1,new TXT$("SELECT"));
                ;
                // JavaLine 391 <== SourceLine 1199
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_REMOTE$1,new TXT$("REMOTE"));
                ;
                // JavaLine 394 <== SourceLine 1200
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_LOCATE$1,new TXT$("LOCATE"));
                ;
                // JavaLine 397 <== SourceLine 1201
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_INDEX$1,new TXT$("INDEX"));
                ;
                // JavaLine 400 <== SourceLine 1202
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_INCO$1,new TXT$("INCO"));
                ;
                // JavaLine 403 <== SourceLine 1204
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_DECO$1,new TXT$("DECO"));
                ;
                // JavaLine 406 <== SourceLine 1205
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_PUSH$1,new TXT$("PUSH"));
                ;
                // JavaLine 409 <== SourceLine 1206
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_PUSHC$1,new TXT$("PUSHC"));
                ;
                // JavaLine 412 <== SourceLine 1207
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_PUSHLEN$1,new TXT$("PUSHLEN"));
                ;
                // JavaLine 415 <== SourceLine 1209
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_DUP$1,new TXT$("DUP"));
                ;
                // JavaLine 418 <== SourceLine 1210
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_POP$1,new TXT$("POP"));
                ;
                // JavaLine 421 <== SourceLine 1211
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_EMPTY$1,new TXT$("EMPTY"));
                ;
                // JavaLine 424 <== SourceLine 1212
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_SETOBJ$1,new TXT$("SETOBJ"));
                ;
                // JavaLine 427 <== SourceLine 1214
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_GETOBJ$1,new TXT$("GETOBJ"));
                ;
                // JavaLine 430 <== SourceLine 1215
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ACCESS$1,new TXT$("ACCESS"));
                ;
                // JavaLine 433 <== SourceLine 1216
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_FJUMP$1,new TXT$("FJUMP"));
                ;
                // JavaLine 436 <== SourceLine 1217
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_BJUMP$1,new TXT$("BJUMP"));
                ;
                // JavaLine 439 <== SourceLine 1219
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_FJUMPIF$1,new TXT$("FJUMPIF"));
                ;
                // JavaLine 442 <== SourceLine 1220
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_BJUMPIF$1,new TXT$("BJUMPIF"));
                ;
                // JavaLine 445 <== SourceLine 1221
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_SWITCH$1,new TXT$("SWITCH"));
                ;
                // JavaLine 448 <== SourceLine 1222
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_GOTO$1,new TXT$("GOTO"));
                ;
                // JavaLine 451 <== SourceLine 1224
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_T_INITO$1,new TXT$("T_INITO"));
                ;
                // JavaLine 454 <== SourceLine 1225
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_T_GETO$1,new TXT$("T_GETO"));
                ;
                // JavaLine 457 <== SourceLine 1226
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_T_SETO$1,new TXT$("T_SETO"));
                ;
                // JavaLine 460 <== SourceLine 1227
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ADD$1,new TXT$("ADD"));
                ;
                // JavaLine 463 <== SourceLine 1229
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_SUB$1,new TXT$("SUB"));
                ;
                // JavaLine 466 <== SourceLine 1230
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_MULT$1,new TXT$("MULT"));
                ;
                // JavaLine 469 <== SourceLine 1231
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_DIV$1,new TXT$("DIV"));
                ;
                // JavaLine 472 <== SourceLine 1232
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_REM$1,new TXT$("REM"));
                ;
                // JavaLine 475 <== SourceLine 1234
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_NEG$1,new TXT$("NEG"));
                ;
                // JavaLine 478 <== SourceLine 1235
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_AND$1,new TXT$("AND"));
                ;
                // JavaLine 481 <== SourceLine 1236
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_OR$1,new TXT$("OR"));
                ;
                // JavaLine 484 <== SourceLine 1237
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_XOR$1,new TXT$("XOR"));
                ;
                // JavaLine 487 <== SourceLine 1239
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_IMP$1,new TXT$("IMP"));
                ;
                // JavaLine 490 <== SourceLine 1240
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_EQV$1,new TXT$("EQV"));
                ;
                // JavaLine 493 <== SourceLine 1241
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_NOT$1,new TXT$("NOT"));
                ;
                // JavaLine 496 <== SourceLine 1242
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_DIST$1,new TXT$("DIST"));
                ;
                // JavaLine 499 <== SourceLine 1244
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ASSIGN$1,new TXT$("ASSIGN"));
                ;
                // JavaLine 502 <== SourceLine 1245
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_UPDATE$1,new TXT$("UPDATE"));
                ;
                // JavaLine 505 <== SourceLine 1246
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_CONVERT$1,new TXT$("CONVERT"));
                ;
                // JavaLine 508 <== SourceLine 1247
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_SYSINSERT$1,new TXT$("SYSINSERT"));
                ;
                // JavaLine 511 <== SourceLine 1249
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_INSERT$1,new TXT$("INSERT"));
                ;
                // JavaLine 514 <== SourceLine 1250
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ZEROAREA$1,new TXT$("ZEROAREA"));
                ;
                // JavaLine 517 <== SourceLine 1251
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_INITAREA$1,new TXT$("INITAREA"));
                ;
                // JavaLine 520 <== SourceLine 1252
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_COMPARE$1,new TXT$("COMPARE"));
                ;
                // JavaLine 523 <== SourceLine 1254
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_LT$1,new TXT$("LT"));
                ;
                // JavaLine 526 <== SourceLine 1255
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_LE$1,new TXT$("LE"));
                ;
                // JavaLine 529 <== SourceLine 1256
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_EQ$1,new TXT$("EQ"));
                ;
                // JavaLine 532 <== SourceLine 1257
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_GE$1,new TXT$("GE"));
                ;
                // JavaLine 535 <== SourceLine 1259
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_GT$1,new TXT$("GT"));
                ;
                // JavaLine 538 <== SourceLine 1260
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_NE$1,new TXT$("NE"));
                ;
                // JavaLine 541 <== SourceLine 1261
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_EVAL$1,new TXT$("EVAL"));
                ;
                // JavaLine 544 <== SourceLine 1262
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_INFO$1,new TXT$("INFO"));
                ;
                // JavaLine 547 <== SourceLine 1264
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_LINE$1,new TXT$("LINE"));
                ;
                // JavaLine 550 <== SourceLine 1265
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_SETSWITCH$1,new TXT$("SETSWITCH"));
                ;
                // JavaLine 553 <== SourceLine 1267
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_RSHIFTA$1,new TXT$("RSHIFTA"));
                ;
                // JavaLine 556 <== SourceLine 1269
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_PROGRAM$1,new TXT$("PROGRAM"));
                ;
                // JavaLine 559 <== SourceLine 1270
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_MAIN$1,new TXT$("MAIN"));
                ;
                // JavaLine 562 <== SourceLine 1272
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ENDPROGRAM$1,new TXT$("ENDPROGRAM"));
                ;
                // JavaLine 565 <== SourceLine 1273
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_DSIZE$1,new TXT$("DSIZE"));
                ;
                // JavaLine 568 <== SourceLine 1274
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_SDEST$1,new TXT$("SDEST"));
                ;
                // JavaLine 571 <== SourceLine 1275
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_RUPDATE$1,new TXT$("RUPDATE"));
                ;
                // JavaLine 574 <== SourceLine 1277
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ASSCALL$1,new TXT$("ASSCALL"));
                ;
                // JavaLine 577 <== SourceLine 1278
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_CALL_TOS$1,new TXT$("CALL_TOS"));
                ;
                // JavaLine 580 <== SourceLine 1279
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_DINITAREA$1,new TXT$("DINITAREA"));
                ;
                // JavaLine 583 <== SourceLine 1280
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_NOSIZE$1,new TXT$("NOSIZE"));
                ;
                // JavaLine 586 <== SourceLine 1282
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_POPALL$1,new TXT$("POPALL"));
                ;
                // JavaLine 589 <== SourceLine 1283
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_REPCALL$1,new TXT$("REPCALL"));
                ;
                // JavaLine 592 <== SourceLine 1284
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_INTERFACE$1,new TXT$("INTERFACE"));
                ;
                // JavaLine 595 <== SourceLine 1285
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_MACRO$1,new TXT$("MACRO"));
                ;
                // JavaLine 598 <== SourceLine 1287
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_MARK$1,new TXT$("MARK"));
                ;
                // JavaLine 601 <== SourceLine 1288
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_MPAR$1,new TXT$("MPAR"));
                ;
                // JavaLine 604 <== SourceLine 1289
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ENDMACRO$1,new TXT$("ENDMACRO"));
                ;
                // JavaLine 607 <== SourceLine 1290
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_MCALL$1,new TXT$("MCALL"));
                ;
                // JavaLine 610 <== SourceLine 1292
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_PUSHV$1,new TXT$("PUSHV"));
                ;
                // JavaLine 613 <== SourceLine 1293
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_SELECTV$1,new TXT$("SELECTV"));
                ;
                // JavaLine 616 <== SourceLine 1294
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_REMOTEV$1,new TXT$("REMOTEV"));
                ;
                // JavaLine 619 <== SourceLine 1295
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_INDEXV$1,new TXT$("INDEXV"));
                ;
                // JavaLine 622 <== SourceLine 1297
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ACCESSV$1,new TXT$("ACCESSV"));
                ;
                // JavaLine 625 <== SourceLine 1298
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_DECL$1,new TXT$("DECL"));
                ;
                // JavaLine 628 <== SourceLine 1299
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_STMT$1,new TXT$("STMT"));
                ;
                // JavaLine 631 <== SourceLine 1305
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_BEGIN$1,new TXT$("BEGIN"));
                ;
                // JavaLine 634 <== SourceLine 1306
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_END$1,new TXT$("END"));
                ;
                // JavaLine 637 <== SourceLine 1307
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_VARIANT$1,new TXT$("VARIANT"));
                ;
                // JavaLine 640 <== SourceLine 1308
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_SHORT$1,new TXT$("SHORT"));
                ;
                // JavaLine 643 <== SourceLine 1310
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_LONG$1,new TXT$("LONG"));
                ;
                // JavaLine 646 <== SourceLine 1311
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_INTEGER$1,new TXT$("INTEGER"));
                ;
                // JavaLine 649 <== SourceLine 1312
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_SIZE$1,new TXT$("SIZE"));
                ;
                // JavaLine 652 <== SourceLine 1313
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_REAL$1,new TXT$("REAL"));
                ;
                // JavaLine 655 <== SourceLine 1315
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_CHAR$1,new TXT$("CHAR"));
                ;
                // JavaLine 658 <== SourceLine 1316
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_BOOLEAN$1,new TXT$("BOOLEAN"));
                ;
                // JavaLine 661 <== SourceLine 1317
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_REF$1,new TXT$("REF"));
                ;
                // JavaLine 664 <== SourceLine 1318
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_NAME$1,new TXT$("NAME"));
                ;
                // JavaLine 667 <== SourceLine 1320
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_FIELD$1,new TXT$("FIELD"));
                ;
                // JavaLine 670 <== SourceLine 1321
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_INFIX$1,new TXT$("INFIX"));
                ;
                // JavaLine 673 <== SourceLine 1322
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ENTRY$1,new TXT$("ENTRY"));
                ;
                // JavaLine 676 <== SourceLine 1323
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_NONE$1,new TXT$("NONE"));
                ;
                // JavaLine 679 <== SourceLine 1325
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_NONAME$1,new TXT$("NONAME"));
                ;
                // JavaLine 682 <== SourceLine 1326
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_NOFIELD$1,new TXT$("NOFIELD"));
                ;
                // JavaLine 685 <== SourceLine 1327
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_THEN$1,new TXT$("THEN"));
                ;
                // JavaLine 688 <== SourceLine 1328
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ELSIF$1,new TXT$("ELSIF"));
                ;
                // JavaLine 691 <== SourceLine 1330
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_QUA$1,new TXT$("QUA"));
                ;
                // JavaLine 694 <== SourceLine 1331
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_VAR$1,new TXT$("VAR"));
                ;
                // JavaLine 697 <== SourceLine 1332
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_REPEAT$1,new TXT$("REPEAT"));
                ;
                // JavaLine 700 <== SourceLine 1333
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_WHILE$1,new TXT$("WHILE"));
                ;
                // JavaLine 703 <== SourceLine 1335
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_DO$1,new TXT$("DO"));
                ;
                // JavaLine 706 <== SourceLine 1336
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ENDREPEAT$1,new TXT$("ENDREPEAT"));
                ;
                // JavaLine 709 <== SourceLine 1337
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_SYSRUT$1,new TXT$("SYSROUTINE"));
                ;
                // JavaLine 712 <== SourceLine 1338
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_DEFINE$1,new TXT$("DEFINE"));
                ;
                // JavaLine 715 <== SourceLine 1340
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_CASE$1,new TXT$("CASE"));
                ;
                // JavaLine 718 <== SourceLine 1341
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_WHEN$1,new TXT$("WHEN"));
                ;
                // JavaLine 721 <== SourceLine 1342
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_OTHERWISE$1,new TXT$("OTHERWISE"));
                ;
                // JavaLine 724 <== SourceLine 1343
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ENDCASE$1,new TXT$("ENDCASE"));
                ;
                // JavaLine 727 <== SourceLine 1345
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_VISIBLE$1,new TXT$("VISIBLE"));
                ;
                // JavaLine 730 <== SourceLine 1346
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ASSERT$1,new TXT$("ASSERT"));
                ;
                // JavaLine 733 <== SourceLine 1347
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_SKIP$1,new TXT$("SKIP"));
                ;
                // JavaLine 736 <== SourceLine 1353
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_INTVAL$1,new TXT$("INTVAL"));
                ;
                // JavaLine 739 <== SourceLine 1354
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_REALVAL$1,new TXT$("REALVAL"));
                ;
                // JavaLine 742 <== SourceLine 1355
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_LREALVAL$1,new TXT$("LREALVAL"));
                ;
                // JavaLine 745 <== SourceLine 1356
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_STRING$1,new TXT$("STRING"));
                ;
                // JavaLine 748 <== SourceLine 1358
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_COLON$1,new TXT$("COLON"));
                ;
                // JavaLine 751 <== SourceLine 1359
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_LPAR$1,new TXT$("LPAR"));
                ;
                // JavaLine 754 <== SourceLine 1360
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_RPAR$1,new TXT$("RPAR"));
                ;
                // JavaLine 757 <== SourceLine 1361
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_COMMA$1,new TXT$("COMMA"));
                ;
                // JavaLine 760 <== SourceLine 1363
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_DOT$1,new TXT$("DOT"));
                ;
                // JavaLine 763 <== SourceLine 1364
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ADDRESS$1,new TXT$("ADDRESS"));
                ;
                // JavaLine 766 <== SourceLine 1365
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_CHARS$1,new TXT$("CHARS"));
                ;
                // JavaLine 769 <== SourceLine 1366
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_PERCENT$1,new TXT$("PERCENT"));
                ;
                // JavaLine 772 <== SourceLine 1371
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_TRACE$1,new TXT$("TRACE"));
                ;
                // JavaLine 775 <== SourceLine 1372
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_NOEXPR$1,new TXT$("NOEXPR"));
                ;
                // JavaLine 778 <== SourceLine 1373
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_VARID$1,new TXT$("VARID"));
                ;
                // JavaLine 781 <== SourceLine 1374
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_VAREXPR$1,new TXT$("VAREXPR"));
                ;
                // JavaLine 784 <== SourceLine 1376
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_VARCALL$1,new TXT$("VARCALL"));
                ;
                // JavaLine 787 <== SourceLine 1377
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ARGLIST$1,new TXT$("ARGLIST"));
                ;
                // JavaLine 790 <== SourceLine 1378
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ENDVAR$1,new TXT$("ENDVAR"));
                ;
                // JavaLine 793 <== SourceLine 1379
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_IFEXPR$1,new TXT$("IFEXPR"));
                ;
                // JavaLine 796 <== SourceLine 1381
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_REPEXPR$1,new TXT$("REPEXPR"));
                ;
                // JavaLine 799 <== SourceLine 1382
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_DEFLAB$1,new TXT$("DEFLAB"));
                ;
                // JavaLine 802 <== SourceLine 1383
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_STRUCT$1,new TXT$("STRUCT"));
                ;
                // JavaLine 805 <== SourceLine 1384
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_ENDWHEN$1,new TXT$("ENDWHEN"));
                ;
                // JavaLine 808 <== SourceLine 1386
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_SIMPLE$1,new TXT$("SIMPLE"));
                ;
                // JavaLine 811 <== SourceLine 1387
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_DOTVAR$1,new TXT$("DOTVAR"));
                ;
                // JavaLine 814 <== SourceLine 1389
                new Common$DEFKEYWORD(((Common)(CUR$.SL$.SL$)),((Common)(CUR$.SL$.SL$)).S_IDENT$1,new TXT$("IDENT"));
                ;
                // JavaLine 817 <== SourceLine 1394
                ((Common)(CUR$.SL$.SL$)).nSymb$1=((Common)(CUR$.SL$.SL$)).S_MXMX$1;
                ;
                // JavaLine 820 <== SourceLine 1396
                new Common$initTypeTable(((Common)(CUR$.SL$.SL$)));
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1048:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1048:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock1048:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","SubBlock SubBlock1048",1,1048,9,1097,12,1048,30,1050,34,1052,37,1056,40,1057,43,1062,46,1063,49,1065,52,1066,55,1068,58,1069,61,1070,64,1071,67,1072,70,1073,75,1077,80,1078,82,1079,88,1080,92,1081,97,1082,103,1083,105,1084,109,1085,121,1088,124,1092,127,1093,130,1094,136,1095,145,1097,149,1098,154,1100,157,1101,160,1104,163,1105,166,1107,169,1108,172,1109,175,1110,178,1111,181,1112,184,1113,187,1114,190,1115,193,1116,196,1117,199,1118,202,1119,205,1120,208,1121,211,1123,214,1124,217,1125,220,1126,223,1128,226,1129,229,1130,232,1131,235,1133,238,1134,241,1135,244,1136,247,1138,250,1139,253,1140,256,1141,259,1143,262,1144,265,1145,268,1146,271,1148,274,1149,277,1150,280,1151,283,1153,286,1154,289,1155,292,1156,295,1158,298,1159,301,1160,304,1161,307,1163,310,1164,313,1165,316,1166,319,1168,322,1169,325,1170,328,1171,331,1173,334,1174,337,1175,340,1176,343,1178,346,1179,349,1180,352,1181,355,1183,358,1184,361,1185,364,1187,367,1189,370,1190,373,1191,376,1192,379,1194,382,1195,385,1196,388,1197,391,1199,394,1200,397,1201,400,1202,403,1204,406,1205,409,1206,412,1207,415,1209,418,1210,421,1211,424,1212,427,1214,430,1215,433,1216,436,1217,439,1219,442,1220,445,1221,448,1222,451,1224,454,1225,457,1226,460,1227,463,1229,466,1230,469,1231,472,1232,475,1234,478,1235,481,1236,484,1237,487,1239,490,1240,493,1241,496,1242,499,1244,502,1245,505,1246,508,1247,511,1249,514,1250,517,1251,520,1252,523,1254,526,1255,529,1256,532,1257,535,1259,538,1260,541,1261,544,1262,547,1264,550,1265,553,1267,556,1269,559,1270,562,1272,565,1273,568,1274,571,1275,574,1277,577,1278,580,1279,583,1280,586,1282,589,1283,592,1284,595,1285,598,1287,601,1288,604,1289,607,1290,610,1292,613,1293,616,1294,619,1295,622,1297,625,1298,628,1299,631,1305,634,1306,637,1307,640,1308,643,1310,646,1311,649,1312,652,1313,655,1315,658,1316,661,1317,664,1318,667,1320,670,1321,673,1322,676,1323,679,1325,682,1326,685,1327,688,1328,691,1330,694,1331,697,1332,700,1333,703,1335,706,1336,709,1337,712,1338,715,1340,718,1341,721,1342,724,1343,727,1345,730,1346,733,1347,736,1353,739,1354,742,1355,745,1356,748,1358,751,1359,754,1360,757,1361,760,1363,763,1364,766,1365,769,1366,772,1371,775,1372,778,1373,781,1374,784,1376,787,1377,790,1378,793,1379,796,1381,799,1382,802,1383,805,1384,808,1386,811,1387,814,1389,817,1394,820,1396,839,1398);
} // End of SubBlock
