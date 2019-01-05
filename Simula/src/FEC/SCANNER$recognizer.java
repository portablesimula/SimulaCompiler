// JavaLine 1 ==> SourceLine 562
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:53 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SCANNER$recognizer extends COMMON$component {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=562, lastLine=1592, hasLocalClasses=true, System=false, detachUsed=true
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 1091
    final LABQNT$ NxtChar=new LABQNT$(this,1,1); // Local Label #1=NxtChar
    // JavaLine 14 ==> SourceLine 1095
    final LABQNT$ ReadPC=new LABQNT$(this,1,2); // Local Label #2=ReadPC
    // JavaLine 16 ==> SourceLine 1097
    final LABQNT$ ParserC=new LABQNT$(this,1,3); // Local Label #3=ParserC
    // JavaLine 18 ==> SourceLine 1108
    final LABQNT$ ASSESS=new LABQNT$(this,1,4); // Local Label #4=ASSESS
    // JavaLine 20 ==> SourceLine 1242
    final LABQNT$ QWARN=new LABQNT$(this,1,5); // Local Label #5=QWARN
    // JavaLine 22 ==> SourceLine 1226
    final LABQNT$ QUOTE=new LABQNT$(this,1,6); // Local Label #6=QUOTE
    // JavaLine 24 ==> SourceLine 1228
    final LABQNT$ QREP1=new LABQNT$(this,1,7); // Local Label #7=QREP1
    // JavaLine 26 ==> SourceLine 1295
    final LABQNT$ ndot=new LABQNT$(this,1,8); // Local Label #8=ndot
    // JavaLine 28 ==> SourceLine 1317
    final LABQNT$ numERR=new LABQNT$(this,1,9); // Local Label #9=numERR
    // JavaLine 30 ==> SourceLine 1302
    final LABQNT$ nampsand=new LABQNT$(this,1,10); // Local Label #10=nampsand
    // JavaLine 32 ==> SourceLine 1291
    final LABQNT$ numr=new LABQNT$(this,1,11); // Local Label #11=numr
    // JavaLine 34 ==> SourceLine 1350
    final LABQNT$ idterm=new LABQNT$(this,1,12); // Local Label #12=idterm
    // JavaLine 36 ==> SourceLine 1397
    final LABQNT$ SAWRID=new LABQNT$(this,1,13); // Local Label #13=SAWRID
    // JavaLine 38 ==> SourceLine 1399
    final LABQNT$ RESKW=new LABQNT$(this,1,14); // Local Label #14=RESKW
    // JavaLine 40 ==> SourceLine 1400
    final LABQNT$ OPERAND=new LABQNT$(this,1,15); // Local Label #15=OPERAND
    // JavaLine 42 ==> SourceLine 1401
    final LABQNT$ OPERAND2=new LABQNT$(this,1,16); // Local Label #16=OPERAND2
    // JavaLine 44 ==> SourceLine 1410
    final LABQNT$ SawComment=new LABQNT$(this,1,17); // Local Label #17=SawComment
    // JavaLine 46 ==> SourceLine 1500
    final LABQNT$ SawSMCL=new LABQNT$(this,1,18); // Local Label #18=SawSMCL
    // JavaLine 48 ==> SourceLine 1499
    final LABQNT$ FindEnd=new LABQNT$(this,1,19); // Local Label #19=FindEnd
    // JavaLine 50 ==> SourceLine 1538
    final LABQNT$ TESTENDCOUNT=new LABQNT$(this,1,20); // Local Label #20=TESTENDCOUNT
    // JavaLine 52 ==> SourceLine 1335
    final LABQNT$ idscan=new LABQNT$(this,1,21); // Local Label #21=idscan
    // JavaLine 54 ==> SourceLine 1338
    final LABQNT$ idloop=new LABQNT$(this,1,22); // Local Label #22=idloop
    // JavaLine 56 ==> SourceLine 1344
    final LABQNT$ Lidi=new LABQNT$(this,1,23); // Local Label #23=Lidi
    // JavaLine 58 ==> SourceLine 1396
    final LABQNT$ IdentifierFound=new LABQNT$(this,1,24); // Local Label #24=IdentifierFound
    // JavaLine 60 ==> SourceLine 1549
    final LABQNT$ SawKeyW=new LABQNT$(this,1,25); // Local Label #25=SawKeyW
    // JavaLine 62 ==> SourceLine 1586
    final LABQNT$ Mill=new LABQNT$(this,1,26); // Local Label #26=Mill
    // Declare locals as attributes
    // JavaLine 65 ==> SourceLine 568
    public boolean skipzeroes=false;
    // JavaLine 67 ==> SourceLine 569
    public char atom=0;
    // JavaLine 69 ==> SourceLine 570
    public char nxtsym=0;
    // JavaLine 71 ==> SourceLine 571
    public char curidhi=0;
    public char curidlo=0;
    // JavaLine 74 ==> SourceLine 572
    public int hashpos=0;
    // JavaLine 76 ==> SourceLine 573
    public int linepos=0;
    // JavaLine 78 ==> SourceLine 574
    public int linelength=0;
    // JavaLine 80 ==> SourceLine 575
    public int opdpos=0;
    // JavaLine 82 ==> SourceLine 576
    public int optpos=0;
    // JavaLine 84 ==> SourceLine 577
    public int ampcount=0;
    // JavaLine 86 ==> SourceLine 578
    public int textpos=0;
    // JavaLine 88 ==> SourceLine 579
    public int eqopt=0;
    // JavaLine 90 ==> SourceLine 580
    public int opdline=0;
    // JavaLine 92 ==> SourceLine 581
    public int i=0;
    // JavaLine 94 ==> SourceLine 582
    public int startpos=0;
    // JavaLine 96 ==> SourceLine 583
    public int startline=0;
    // JavaLine 98 ==> SourceLine 584
    public TXT$ hashbuf=null;
    // JavaLine 100 ==> SourceLine 585
    public TXT$ line=null;
    // JavaLine 102 ==> SourceLine 586
    public TXT$ curtitle=null;
    // JavaLine 104 ==> SourceLine 587
    public TXT$ tempt=null;
    // JavaLine 106 ==> SourceLine 660
    public ARRAY$<char[]>InputClass=null;
    // JavaLine 108 ==> SourceLine 938
    public SCANNER$recognizer$identifierScanner IdScanner=null;
    // JavaLine 110 ==> SourceLine 975
    public SCANNER$recognizer$unsignedInteger unsignedInt=null;
    // JavaLine 112 ==> SourceLine 1097
    public COMMON$component inspect$1097$16=null;
    // JavaLine 114 ==> SourceLine 1487
    public COMMON$component inspect$1487$17=null;
    // JavaLine 116 ==> SourceLine 1560
    public COMMON$component inspect$1560$18=null;
    // Normal Constructor
    public SCANNER$recognizer(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("recognizer",1560);
        // JavaLine 124 ==> SourceLine 660
        int[] InputClass$LB=new int[1]; int[] InputClass$UB=new int[1];
        InputClass$LB[0]=0; InputClass$UB[0]=255;
        BOUND_CHECK$(InputClass$LB[0],InputClass$UB[0]);
        InputClass=new ARRAY$<char[]>(new char[InputClass$UB[0]-InputClass$LB[0]+1],InputClass$LB,InputClass$UB);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("recognizer",660,inner);
                SCANNER$recognizer THIS$=(SCANNER$recognizer)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 137 ==> SourceLine 1089
                        detach();
                        // JavaLine 139 ==> SourceLine 1090
                        new SCANNER$recognizer$nextLine(((SCANNER$recognizer)CUR$));
                        GOTO$(ASSESS); // GOTO EVALUATED LABEL
                        // JavaLine 142 ==> SourceLine 1091
                        LABEL$(1); // NxtChar
                        atom=loadChar(line,linepos);
                        linepos=(linepos+(1));
                        // JavaLine 146 ==> SourceLine 1093
                        GOTO$(ASSESS); // GOTO EVALUATED LABEL
                        // JavaLine 148 ==> SourceLine 1095
                        LABEL$(2); // ReadPC
                        atom=loadChar(line,linepos);
                        linepos=(linepos+(1));
                        // JavaLine 152 ==> SourceLine 1106
                        LABEL$(3); // ParserC
                        // JavaLine 154 ==> SourceLine 1097
                        {
                            // BEGIN INSPECTION 
                            inspect$1097$16=((SCANNER)(CUR$.SL$)).parser;
                            if(inspect$1097$16!=null) //INSPECT inspect$1097$16
                            // JavaLine 159 ==> SourceLine 1098
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1098",1098);
                                inspect$1097$16.getopt=true;
                                // JavaLine 163 ==> SourceLine 1099
                                if((((SCANNER)(CUR$.SL$)).optx==(((SCANNER)(CUR$.SL$)).NUL))) {
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1099",1099);
                                        inspect$1097$16.cs=((SCANNER)(CUR$.SL$)).opt;
                                        inspect$1097$16.getopt=false;
                                        TRACE_END_STM$("CompoundStatement1099",1099);
                                    }
                                }
                                // JavaLine 172 ==> SourceLine 1104
                                call(((COMMON$component)inspect$1097$16));
                                // JavaLine 174 ==> SourceLine 1105
                                ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).optx=((SCANNER)(CUR$.SL$)).opdhi=((SCANNER)(CUR$.SL$)).opdlo=((SCANNER)(CUR$.SL$)).NUL;
                                TRACE_END_STM$("CompoundStatement1098",1105);
                            }
                        }
                        // JavaLine 179 ==> SourceLine 1108
                        LABEL$(4); // ASSESS
                        optpos=linepos;
                        // JavaLine 182 ==> SourceLine 1110
                        switch(atom) { // BEGIN SWITCH STATEMENT
                        case 59: 
                        // JavaLine 185 ==> SourceLine 1113
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1113",1113);
                            ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).ISMCL;
                            GOTO$(ReadPC); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1113",1113);
                        }
                        case 7: 
                        // JavaLine 193 ==> SourceLine 1117
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1117",1117);
                            if((linepos==(linelength))) {
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1117",1117);
                                    new SCANNER$recognizer$nextLine(((SCANNER$recognizer)CUR$));
                                    GOTO$(ASSESS); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1117",1117);
                                }
                            }
                            // JavaLine 204 ==> SourceLine 1118
                            new SCANNER$recognizer$illegalChar(((SCANNER$recognizer)CUR$));
                            GOTO$(NxtChar); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1117",1118);
                        }
                        case 58: 
                        // JavaLine 210 ==> SourceLine 1122
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1122",1122);
                            atom=loadChar(line,linepos);
                            linepos=(linepos+(1));
                            // JavaLine 215 ==> SourceLine 1123
                            if((atom==('='))) {
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1123",1123);
                                    ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IASSG;
                                    GOTO$(ReadPC); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1123",1123);
                                }
                            }
                            // JavaLine 224 ==> SourceLine 1124
                            if((atom==('-'))) {
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1124",1124);
                                    ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IDENO;
                                    GOTO$(ReadPC); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1124",1124);
                                }
                            }
                            // JavaLine 233 ==> SourceLine 1125
                            ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).ICL;
                            GOTO$(ParserC); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1122",1125);
                        }
                        case 44: 
                        // JavaLine 239 ==> SourceLine 1128
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1128",1128);
                            ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).ICOMA;
                            GOTO$(ReadPC); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1128",1128);
                        }
                        case 40: 
                        // JavaLine 247 ==> SourceLine 1131
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1131",1131);
                            ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).ILFPA;
                            GOTO$(ReadPC); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1131",1131);
                        }
                        case 41: 
                        // JavaLine 255 ==> SourceLine 1134
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1134",1134);
                            ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IRGPA;
                            GOTO$(ReadPC); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1134",1134);
                        }
                        case 46: 
                        // JavaLine 263 ==> SourceLine 1137
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1137",1137);
                            new SCANNER$recognizer$scanahead(((SCANNER$recognizer)CUR$));
                            // JavaLine 267 ==> SourceLine 1139
                            if((InputClass.Elt[rank(atom)-InputClass.LB[0]]==(((SCANNER)(CUR$.SL$)).Digit_cl))) {
                                // JavaLine 269 ==> SourceLine 1140
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1140",1140);
                                    if((((SCANNER)(CUR$.SL$)).optx!=(((SCANNER)(CUR$.SL$)).NUL))) {
                                        new SCANNER$recognizer$OperandToParser(((SCANNER$recognizer)CUR$));
                                    }
                                    // JavaLine 275 ==> SourceLine 1141
                                    GOTO$(ndot); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1140",1141);
                                }
                            }
                            // JavaLine 280 ==> SourceLine 1142
                            ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IDOT;
                            GOTO$(ParserC); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1137",1142);
                        }
                        case 33: 
                        // JavaLine 286 ==> SourceLine 1145
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1145",1145);
                            GOTO$(SawComment); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1145",1145);
                        }
                        case 38: 
                        // JavaLine 293 ==> SourceLine 1149
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1149",1149);
                            atom=loadChar(line,linepos);
                            linepos=(linepos+(1));
                            // JavaLine 298 ==> SourceLine 1150
                            if(((((InputClass.Elt[rank(atom)-InputClass.LB[0]]==(((SCANNER)(CUR$.SL$)).Digit_cl))||((atom==('&'))))||((atom==('-'))))||((atom==('+'))))) {
                                // JavaLine 300 ==> SourceLine 1153
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1153",1153);
                                    if((((SCANNER)(CUR$.SL$)).optx!=(((SCANNER)(CUR$.SL$)).NUL))) {
                                        new SCANNER$recognizer$OperandToParser(((SCANNER$recognizer)CUR$));
                                    }
                                    // JavaLine 306 ==> SourceLine 1154
                                    GOTO$(nampsand); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1153",1154);
                                }
                            }
                            // JavaLine 311 ==> SourceLine 1155
                            ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).ICONC;
                            GOTO$(ParserC); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1149",1155);
                        }
                        case 42: 
                        // JavaLine 317 ==> SourceLine 1158
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1158",1158);
                            new SCANNER$recognizer$scanahead(((SCANNER$recognizer)CUR$));
                            // JavaLine 321 ==> SourceLine 1160
                            if((atom==('*'))) {
                                ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IPOWE;
                            } else
                            // JavaLine 325 ==> SourceLine 1161
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1161",1161);
                                ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IMULT;
                                GOTO$(ParserC); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1161",1161);
                            }
                            TRACE_END_STM$("CompoundStatement1158",1161);
                        }
                        case 43: 
                        // JavaLine 335 ==> SourceLine 1166
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1166",1166);
                            ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IPLUS;
                            TRACE_END_STM$("CompoundStatement1166",1166);
                        }
                        case 45: 
                        // JavaLine 342 ==> SourceLine 1170
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1170",1170);
                            ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IMINU;
                            // JavaLine 346 ==> SourceLine 1171
                            new SCANNER$recognizer$scanahead(((SCANNER$recognizer)CUR$));
                            // JavaLine 348 ==> SourceLine 1173
                            if((atom==('-'))) {
                                // JavaLine 350 ==> SourceLine 1174
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1174",1174);
                                    if((!(((SCANNER)(CUR$.SL$)).SportOK))) {
                                        new SCANNER$P1warn(((SCANNER)(CUR$.SL$)),233);
                                    }
                                    // JavaLine 356 ==> SourceLine 1175
                                    new SCANNER$recognizer$nextLine(((SCANNER$recognizer)CUR$));
                                    GOTO$(ASSESS); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1174",1175);
                                }
                            }
                            // JavaLine 362 ==> SourceLine 1177
                            GOTO$(ParserC); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1170",1177);
                        }
                        case 47: 
                        // JavaLine 367 ==> SourceLine 1181
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1181",1181);
                            new SCANNER$recognizer$scanahead(((SCANNER$recognizer)CUR$));
                            // JavaLine 371 ==> SourceLine 1183
                            if((atom!=('/'))) {
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1183",1183);
                                    ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).ISLAS;
                                    GOTO$(ParserC); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1183",1183);
                                }
                            }
                            // JavaLine 380 ==> SourceLine 1184
                            ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IIDIV;
                            TRACE_END_STM$("CompoundStatement1181",1184);
                        }
                        case 60: 
                        // JavaLine 385 ==> SourceLine 1189
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1189",1189);
                            atom=loadChar(line,linepos);
                            linepos=(linepos+(1));
                            // JavaLine 390 ==> SourceLine 1190
                            if((atom==('>'))) {
                                ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).INE;
                            } else
                            // JavaLine 394 ==> SourceLine 1191
                            if((atom!=('='))) {
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1191",1191);
                                    ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).ILT;
                                    GOTO$(ParserC); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1191",1191);
                                }
                            } else
                            // JavaLine 403 ==> SourceLine 1192
                            ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).ILE;
                            TRACE_END_STM$("CompoundStatement1189",1192);
                        }
                        case 61: 
                        // JavaLine 408 ==> SourceLine 1196
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1196",1196);
                            atom=loadChar(line,linepos);
                            linepos=(linepos+(1));
                            // JavaLine 413 ==> SourceLine 1198
                            if((atom==('='))) {
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1198",1198);
                                    ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IRFEQ;
                                    GOTO$(ReadPC); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1198",1198);
                                }
                            }
                            // JavaLine 422 ==> SourceLine 1199
                            if((atom!=('/'))) {
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1199",1199);
                                    ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IEQ;
                                    GOTO$(ParserC); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1199",1199);
                                }
                            }
                            // JavaLine 431 ==> SourceLine 1200
                            ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IRFNE;
                            // JavaLine 433 ==> SourceLine 1202
                            atom=loadChar(line,linepos);
                            linepos=(linepos+(1));
                            // JavaLine 436 ==> SourceLine 1203
                            if((atom!=('='))) {
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1203",1203);
                                    new SCANNER$P1warn(((SCANNER)(CUR$.SL$)),273);
                                    GOTO$(ParserC); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1203",1203);
                                }
                            }
                            TRACE_END_STM$("CompoundStatement1196",1203);
                        }
                        case 62: 
                        // JavaLine 448 ==> SourceLine 1208
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1208",1208);
                            atom=loadChar(line,linepos);
                            linepos=(linepos+(1));
                            // JavaLine 453 ==> SourceLine 1209
                            if((atom!=('='))) {
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1209",1209);
                                    ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IGT;
                                    GOTO$(ParserC); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1209",1209);
                                }
                            }
                            // JavaLine 462 ==> SourceLine 1210
                            ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IGE;
                            TRACE_END_STM$("CompoundStatement1208",1210);
                        }
                        case 0: 
                        case 127: 
                        case 8: 
                        case 9: 
                        case 10: 
                        case 11: 
                        case 12: 
                        case 13: 
                        case 32: 
                        // JavaLine 475 ==> SourceLine 1219
                        GOTO$(NxtChar); // GOTO EVALUATED LABEL
                        case 34: 
                        // JavaLine 478 ==> SourceLine 1224
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1224",1224);
                            if((((SCANNER)(CUR$.SL$)).optx!=(((SCANNER)(CUR$.SL$)).NUL))) {
                                new SCANNER$recognizer$OperandToParser(((SCANNER$recognizer)CUR$));
                            }
                            // JavaLine 484 ==> SourceLine 1225
                            opdline=((SCANNER)(CUR$.SL$)).linenr;
                            textpos=0;
                            // JavaLine 487 ==> SourceLine 1226
                            LABEL$(6); // QUOTE
                            startpos=linepos;
                            i=textpos;
                            // JavaLine 491 ==> SourceLine 1228
                            LABEL$(7); // QREP1
                            atom=loadChar(line,linepos);
                            linepos=(linepos+(1));
                            // JavaLine 495 ==> SourceLine 1229
                            if((atom!=('"'))) {
                                // JavaLine 497 ==> SourceLine 1230
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1230",1230);
                                    if(((atom!=(((SCANNER)(CUR$.SL$)).EOL))||((linepos<(linelength))))) {
                                        // JavaLine 501 ==> SourceLine 1231
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1231",1231);
                                            if((atom==('!'))) {
                                                new SCANNER$recognizer$ISOcode(((SCANNER$recognizer)CUR$));
                                            }
                                            // JavaLine 507 ==> SourceLine 1232
                                            storeChar(atom,hashbuf,textpos);
                                            textpos=(textpos+(1));
                                            // JavaLine 510 ==> SourceLine 1234
                                            GOTO$(QREP1); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement1231",1234);
                                        }
                                    }
                                    // JavaLine 515 ==> SourceLine 1236
                                    linepos=startpos;
                                    textpos=i;
                                    // JavaLine 518 ==> SourceLine 1237
                                    while((linepos<(linelength))) {
                                        // JavaLine 520 ==> SourceLine 1238
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1238",1238);
                                            atom=loadChar(line,linepos);
                                            linepos=(linepos+(1));
                                            // JavaLine 525 ==> SourceLine 1239
                                            if(((atom==(')'))|((atom==(';'))))) {
                                                GOTO$(QWARN); // GOTO EVALUATED LABEL
                                            }
                                            // JavaLine 529 ==> SourceLine 1240
                                            textpos=(textpos+(1));
                                            TRACE_END_STM$("CompoundStatement1238",1240);
                                        }
                                    }
                                    // JavaLine 534 ==> SourceLine 1242
                                    LABEL$(5); // QWARN
                                    new SCANNER$P1warn(((SCANNER)(CUR$.SL$)),275);
                                    TRACE_END_STM$("CompoundStatement1230",1242);
                                }
                            } else
                            // JavaLine 540 ==> SourceLine 1245
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1245",1245);
                                new SCANNER$recognizer$scanahead(((SCANNER$recognizer)CUR$));
                                // JavaLine 544 ==> SourceLine 1247
                                if((atom==('"'))) {
                                    // JavaLine 546 ==> SourceLine 1248
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1248",1248);
                                        storeChar(atom,hashbuf,textpos);
                                        textpos=(textpos+(1));
                                        // JavaLine 551 ==> SourceLine 1249
                                        GOTO$(QUOTE); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1248",1249);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement1245",1249);
                            }
                            // JavaLine 558 ==> SourceLine 1251
                            new SCANNER$recognizer$ScanPastFormat(((SCANNER$recognizer)CUR$));
                            // JavaLine 560 ==> SourceLine 1252
                            if((atom==('"'))) {
                                // JavaLine 562 ==> SourceLine 1253
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1253",1253);
                                    if(((TXT$.length(hashbuf)-(textpos))<(80))) {
                                        // JavaLine 566 ==> SourceLine 1255
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1255",1255);
                                            tempt=blanks(80);
                                            hashbuf=CONC(hashbuf,tempt);
                                            TRACE_END_STM$("CompoundStatement1255",1255);
                                        }
                                    }
                                    // JavaLine 574 ==> SourceLine 1256
                                    GOTO$(QUOTE); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1253",1256);
                                }
                            }
                            // JavaLine 579 ==> SourceLine 1258
                            ((SCANNER)(CUR$.SL$)).optx=((SCANNER)(CUR$.SL$)).ITEXT;
                            ((SCANNER)(CUR$.SL$)).parser.cs=((SCANNER)(CUR$.SL$)).ICONS;
                            // JavaLine 582 ==> SourceLine 1259
                            if((textpos==(0))) {
                                ((SCANNER)(CUR$.SL$)).opdlo=((SCANNER)(CUR$.SL$)).INOTE;
                            } else
                            // JavaLine 586 ==> SourceLine 1261
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1261",1261);
                                ((SCANNER)(CUR$.SL$)).simsymbol=TXT$.sub(hashbuf,1,textpos);
                                // JavaLine 590 ==> SourceLine 1262
                                new COMMON$DEFCONST(((SCANNER)(CUR$.SL$)));
                                // JavaLine 592 ==> SourceLine 1263
                                ((SCANNER)(CUR$.SL$)).opdhi=((SCANNER)(CUR$.SL$)).hashhi;
                                ((SCANNER)(CUR$.SL$)).opdlo=((SCANNER)(CUR$.SL$)).hashlo;
                                // JavaLine 595 ==> SourceLine 1264
                                if((TXT$.length(hashbuf)>(80))) {
                                    hashbuf=blanks(80);
                                }
                                TRACE_END_STM$("CompoundStatement1261",1264);
                            }
                            // JavaLine 601 ==> SourceLine 1267
                            GOTO$(OPERAND2); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1224",1267);
                        }
                        case 39: 
                        // JavaLine 606 ==> SourceLine 1270
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1270",1270);
                            if((((SCANNER)(CUR$.SL$)).optx!=(((SCANNER)(CUR$.SL$)).NUL))) {
                                new SCANNER$recognizer$OperandToParser(((SCANNER$recognizer)CUR$));
                            }
                            // JavaLine 612 ==> SourceLine 1271
                            new SCANNER$recognizer$scanahead(((SCANNER$recognizer)CUR$));
                            // JavaLine 614 ==> SourceLine 1273
                            if((atom==(((SCANNER)(CUR$.SL$)).EOL))) {
                                // JavaLine 616 ==> SourceLine 1274
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1274",1274);
                                    new SCANNER$P1error(((SCANNER)(CUR$.SL$)),182);
                                    new SCANNER$recognizer$nextLine(((SCANNER$recognizer)CUR$));
                                    GOTO$(ASSESS); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1274",1274);
                                }
                            }
                            // JavaLine 625 ==> SourceLine 1275
                            if((atom==('!'))) {
                                new SCANNER$recognizer$ISOcode(((SCANNER$recognizer)CUR$));
                            }
                            // JavaLine 629 ==> SourceLine 1276
                            ((SCANNER)(CUR$.SL$)).opdlo=atom;
                            ((SCANNER)(CUR$.SL$)).optx=((SCANNER)(CUR$.SL$)).ICHAR;
                            ((SCANNER)(CUR$.SL$)).parser.cs=((SCANNER)(CUR$.SL$)).ICONS;
                            // JavaLine 633 ==> SourceLine 1277
                            new SCANNER$recognizer$scanahead(((SCANNER$recognizer)CUR$));
                            // JavaLine 635 ==> SourceLine 1279
                            if((atom==(((char)39)))) {
                                // JavaLine 637 ==> SourceLine 1280
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1280",1280);
                                    new SCANNER$recognizer$scanahead(((SCANNER$recognizer)CUR$));
                                    TRACE_END_STM$("CompoundStatement1280",1280);
                                }
                            } else
                            // JavaLine 644 ==> SourceLine 1284
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1284",1284);
                                new SCANNER$P1warn(((SCANNER)(CUR$.SL$)),274);
                                if((atom==('!'))) {
                                    new SCANNER$recognizer$scanahead(((SCANNER$recognizer)CUR$));
                                }
                                TRACE_END_STM$("CompoundStatement1284",1284);
                            }
                            // JavaLine 653 ==> SourceLine 1286
                            GOTO$(OPERAND); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1270",1286);
                        }
                        case 48: 
                        case 49: 
                        case 50: 
                        case 51: 
                        case 52: 
                        case 53: 
                        case 54: 
                        case 55: 
                        case 56: 
                        case 57: 
                        // JavaLine 667 ==> SourceLine 1291
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1291",1291);
                            LABEL$(11); // numr
                            if((((SCANNER)(CUR$.SL$)).optx!=(((SCANNER)(CUR$.SL$)).NUL))) {
                                new SCANNER$recognizer$OperandToParser(((SCANNER$recognizer)CUR$));
                            }
                            // JavaLine 674 ==> SourceLine 1292
                            skipzeroes=(atom==('0'));
                            call(unsignedInt);
                            ((SCANNER)(CUR$.SL$)).optx=((SCANNER)(CUR$.SL$)).IINTG;
                            // JavaLine 678 ==> SourceLine 1293
                            if((atom==('.'))) {
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1293",1293);
                                    new SCANNER$recognizer$scanahead(((SCANNER$recognizer)CUR$));
                                    // JavaLine 683 ==> SourceLine 1295
                                    LABEL$(8); // ndot
                                    ((SCANNER)(CUR$.SL$)).optx=((SCANNER)(CUR$.SL$)).IREAL;
                                    // JavaLine 686 ==> SourceLine 1296
                                    storeChar('.',hashbuf,hashpos);
                                    hashpos=(hashpos+(1));
                                    // JavaLine 689 ==> SourceLine 1297
                                    if((InputClass.Elt[rank(atom)-InputClass.LB[0]]!=(((SCANNER)(CUR$.SL$)).Digit_cl))) {
                                        GOTO$(numERR); // GOTO EVALUATED LABEL
                                    }
                                    // JavaLine 693 ==> SourceLine 1298
                                    call(unsignedInt);
                                    TRACE_END_STM$("CompoundStatement1293",1298);
                                }
                            }
                            // JavaLine 698 ==> SourceLine 1300
                            if((atom==('&'))) {
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1300",1300);
                                    new SCANNER$recognizer$scanahead(((SCANNER$recognizer)CUR$));
                                    // JavaLine 703 ==> SourceLine 1302
                                    LABEL$(10); // nampsand
                                    ((SCANNER)(CUR$.SL$)).optx=((SCANNER)(CUR$.SL$)).IREAL;
                                    // JavaLine 706 ==> SourceLine 1303
                                    storeChar('&',hashbuf,hashpos);
                                    hashpos=(hashpos+(1));
                                    // JavaLine 709 ==> SourceLine 1304
                                    if((atom==('&'))) {
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1304",1304);
                                            ((SCANNER)(CUR$.SL$)).optx=((SCANNER)(CUR$.SL$)).ILONG;
                                            new SCANNER$recognizer$scanahead(((SCANNER$recognizer)CUR$));
                                            TRACE_END_STM$("CompoundStatement1304",1304);
                                        }
                                    }
                                    // JavaLine 718 ==> SourceLine 1307
                                    if((atom==('+'))) {
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1307",1307);
                                            new SCANNER$recognizer$scanahead(((SCANNER$recognizer)CUR$));
                                            TRACE_END_STM$("CompoundStatement1307",1307);
                                        }
                                    } else
                                    // JavaLine 726 ==> SourceLine 1310
                                    if((atom==('-'))) {
                                        // JavaLine 728 ==> SourceLine 1311
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1311",1311);
                                            storeChar(atom,hashbuf,hashpos);
                                            hashpos=(hashpos+(1));
                                            // JavaLine 733 ==> SourceLine 1313
                                            new SCANNER$recognizer$scanahead(((SCANNER$recognizer)CUR$));
                                            TRACE_END_STM$("CompoundStatement1311",1313);
                                        }
                                    }
                                    // JavaLine 738 ==> SourceLine 1314
                                    if((InputClass.Elt[rank(atom)-InputClass.LB[0]]==(((SCANNER)(CUR$.SL$)).Digit_cl))) {
                                        // JavaLine 740 ==> SourceLine 1315
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1315",1315);
                                            skipzeroes=(atom==('0'));
                                            // JavaLine 744 ==> SourceLine 1316
                                            call(unsignedInt);
                                            TRACE_END_STM$("CompoundStatement1315",1316);
                                        }
                                    } else
                                    // JavaLine 749 ==> SourceLine 1317
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1317",1317);
                                        LABEL$(9); // numERR
                                        storeChar('0',hashbuf,hashpos);
                                        hashpos=(hashpos+(1));
                                        // JavaLine 755 ==> SourceLine 1318
                                        new SCANNER$P1error(((SCANNER)(CUR$.SL$)),181);
                                        // JavaLine 757 ==> SourceLine 1319
                                        while((((InputClass.Elt[rank(atom)-InputClass.LB[0]]==(((SCANNER)(CUR$.SL$)).Digit_cl))||((atom==('&'))))||((atom==('.'))))) {
                                            // JavaLine 759 ==> SourceLine 1321
                                            new SCANNER$recognizer$scanahead(((SCANNER$recognizer)CUR$));
                                        }
                                        TRACE_END_STM$("CompoundStatement1317",1321);
                                    }
                                    TRACE_END_STM$("CompoundStatement1300",1321);
                                }
                            }
                            // JavaLine 767 ==> SourceLine 1324
                            ((SCANNER)(CUR$.SL$)).simsymbol=TXT$.sub(hashbuf,1,hashpos);
                            hashpos=0;
                            // JavaLine 770 ==> SourceLine 1325
                            new COMMON$DEFCONST(((SCANNER)(CUR$.SL$)));
                            ((SCANNER)(CUR$.SL$)).opdhi=((SCANNER)(CUR$.SL$)).hashhi;
                            ((SCANNER)(CUR$.SL$)).opdlo=((SCANNER)(CUR$.SL$)).hashlo;
                            // JavaLine 774 ==> SourceLine 1326
                            ((SCANNER)(CUR$.SL$)).parser.cs=((SCANNER)(CUR$.SL$)).ICONS;
                            GOTO$(OPERAND); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1291",1326);
                        }
                        case 95: 
                        // JavaLine 780 ==> SourceLine 1331
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1331",1331);
                            if((((SCANNER)(CUR$.SL$)).option.Elt[rank('X')-((SCANNER)(CUR$.SL$)).option.LB[0]]!=(((SCANNER)(CUR$.SL$)).NUL))) {
                                GOTO$(idscan); // GOTO EVALUATED LABEL
                            }
                            // JavaLine 786 ==> SourceLine 1332
                            new SCANNER$recognizer$illegalChar(((SCANNER$recognizer)CUR$));
                            GOTO$(NxtChar); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1331",1332);
                        }
                        case 65: 
                        case 66: 
                        case 67: 
                        case 68: 
                        case 69: 
                        case 70: 
                        case 71: 
                        case 72: 
                        case 73: 
                        case 74: 
                        case 75: 
                        case 76: 
                        case 77: 
                        case 78: 
                        case 79: 
                        case 80: 
                        case 81: 
                        case 82: 
                        case 83: 
                        case 84: 
                        case 85: 
                        case 86: 
                        case 87: 
                        case 88: 
                        case 89: 
                        case 90: 
                        case 97: 
                        case 98: 
                        case 99: 
                        case 100: 
                        case 101: 
                        case 102: 
                        case 103: 
                        case 104: 
                        case 105: 
                        case 106: 
                        case 107: 
                        case 108: 
                        case 109: 
                        case 110: 
                        case 111: 
                        case 112: 
                        case 113: 
                        case 114: 
                        case 115: 
                        case 116: 
                        case 117: 
                        case 118: 
                        case 119: 
                        case 120: 
                        case 121: 
                        case 122: 
                        // JavaLine 843 ==> SourceLine 1335
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1335",1335);
                            LABEL$(21); // idscan
                            i=linepos;
                            // JavaLine 848 ==> SourceLine 1354
                            LABEL$(22); // idloop
                            // JavaLine 850 ==> SourceLine 1338
                            switch(loadChar(line,linepos)) { // BEGIN SWITCH STATEMENT
                            case 48: 
                            case 49: 
                            case 50: 
                            case 51: 
                            case 52: 
                            case 53: 
                            case 54: 
                            case 55: 
                            case 56: 
                            case 57: 
                            case 97: 
                            case 98: 
                            case 99: 
                            case 100: 
                            case 101: 
                            case 102: 
                            case 103: 
                            case 104: 
                            case 105: 
                            case 106: 
                            case 107: 
                            case 108: 
                            case 109: 
                            case 110: 
                            case 111: 
                            case 112: 
                            case 113: 
                            case 114: 
                            case 115: 
                            case 116: 
                            case 117: 
                            case 118: 
                            case 119: 
                            case 120: 
                            case 121: 
                            case 122: 
                            case 65: 
                            case 66: 
                            case 67: 
                            case 68: 
                            case 69: 
                            case 70: 
                            case 71: 
                            case 72: 
                            case 73: 
                            case 74: 
                            case 75: 
                            case 76: 
                            case 77: 
                            case 78: 
                            case 79: 
                            case 80: 
                            case 81: 
                            case 82: 
                            case 83: 
                            case 84: 
                            case 85: 
                            case 86: 
                            case 87: 
                            case 88: 
                            case 89: 
                            case 90: 
                            case 95: 
                            // JavaLine 915 ==> SourceLine 1341
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1341",1341);
                                linepos=(linepos+(1));
                                GOTO$(idloop); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1341",1341);
                            }
                            case 0: 
                            case 1: 
                            case 2: 
                            case 3: 
                            case 4: 
                            case 5: 
                            case 6: 
                            case 14: 
                            case 15: 
                            case 16: 
                            case 17: 
                            case 18: 
                            case 19: 
                            case 20: 
                            case 21: 
                            case 22: 
                            case 23: 
                            case 24: 
                            case 25: 
                            case 26: 
                            case 27: 
                            case 28: 
                            case 29: 
                            case 30: 
                            case 31: 
                            case 35: 
                            case 36: 
                            case 37: 
                            case 63: 
                            case 64: 
                            case 91: 
                            case 92: 
                            case 93: 
                            case 94: 
                            case 96: 
                            case 123: 
                            case 124: 
                            case 125: 
                            case 126: 
                            case 127: 
                            case 128: 
                            case 129: 
                            case 130: 
                            case 131: 
                            case 132: 
                            case 133: 
                            case 134: 
                            case 135: 
                            case 136: 
                            case 137: 
                            case 138: 
                            case 139: 
                            case 140: 
                            case 141: 
                            case 142: 
                            case 143: 
                            case 144: 
                            case 145: 
                            case 146: 
                            case 147: 
                            case 148: 
                            case 149: 
                            case 150: 
                            case 151: 
                            case 152: 
                            case 153: 
                            case 154: 
                            case 155: 
                            case 156: 
                            case 157: 
                            case 158: 
                            case 159: 
                            case 160: 
                            case 161: 
                            case 162: 
                            case 163: 
                            case 164: 
                            case 165: 
                            case 166: 
                            case 167: 
                            case 168: 
                            case 169: 
                            case 170: 
                            case 171: 
                            case 172: 
                            case 173: 
                            case 174: 
                            case 175: 
                            case 176: 
                            case 177: 
                            case 178: 
                            case 179: 
                            case 180: 
                            case 181: 
                            case 182: 
                            case 183: 
                            case 184: 
                            case 185: 
                            case 186: 
                            case 187: 
                            case 188: 
                            case 189: 
                            case 190: 
                            case 191: 
                            case 192: 
                            case 193: 
                            case 194: 
                            case 195: 
                            case 196: 
                            case 197: 
                            case 198: 
                            case 199: 
                            case 200: 
                            case 201: 
                            case 202: 
                            case 203: 
                            case 204: 
                            case 205: 
                            case 206: 
                            case 207: 
                            case 208: 
                            case 209: 
                            case 210: 
                            case 211: 
                            case 212: 
                            case 213: 
                            case 214: 
                            case 215: 
                            case 216: 
                            case 217: 
                            case 218: 
                            case 219: 
                            case 220: 
                            case 221: 
                            case 222: 
                            case 223: 
                            case 224: 
                            case 225: 
                            case 226: 
                            case 227: 
                            case 228: 
                            case 229: 
                            case 230: 
                            case 231: 
                            case 232: 
                            case 233: 
                            case 234: 
                            case 235: 
                            case 236: 
                            case 237: 
                            case 238: 
                            case 239: 
                            case 240: 
                            case 241: 
                            case 242: 
                            case 243: 
                            case 244: 
                            case 245: 
                            case 246: 
                            case 247: 
                            case 248: 
                            case 249: 
                            case 250: 
                            case 251: 
                            case 252: 
                            case 253: 
                            case 254: 
                            case 255: 
                            // JavaLine 1090 ==> SourceLine 1345
                            LABEL$(23); // Lidi
                            // JavaLine 1092 ==> SourceLine 1344
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1344",1344);
                                linepos=i;
                                // JavaLine 1096 ==> SourceLine 1345
                                call(IdScanner);
                                TRACE_END_STM$("CompoundStatement1344",1345);
                            }
                            case 7: 
                            // JavaLine 1101 ==> SourceLine 1347
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1347",1347);
                                if((linepos!=((linelength-(1))))) {
                                    GOTO$(Lidi); // GOTO EVALUATED LABEL
                                }
                                // JavaLine 1107 ==> SourceLine 1348
                                GOTO$(idterm); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1347",1348);
                            }
                            default:
                            // JavaLine 1112 ==> SourceLine 1350
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1350",1350);
                                LABEL$(12); // idterm
                                atom=loadChar(line,linepos);
                                linepos=(linepos+(1));
                                // JavaLine 1118 ==> SourceLine 1351
                                ((SCANNER)(CUR$.SL$)).simsymbol=TXT$.sub(line,i,(linepos-(i)));
                                TRACE_END_STM$("CompoundStatement1350",1351);
                            }
                        } // END SWITCH STATEMENT
                        // JavaLine 1123 ==> SourceLine 1356
                        new COMMON$DEFIDENT(((SCANNER)(CUR$.SL$)));
                        // JavaLine 1125 ==> SourceLine 1357
                        curidhi=((SCANNER)(CUR$.SL$)).hashhi;
                        curidlo=((SCANNER)(CUR$.SL$)).hashlo;
                        // JavaLine 1128 ==> SourceLine 1402
                        LABEL$(24); // IdentifierFound
                        // JavaLine 1130 ==> SourceLine 1396
                        if(((curidhi!=(((SCANNER)(CUR$.SL$)).NUL))||((curidlo>(((SCANNER)(CUR$.SL$)).IFALS))))) {
                            // JavaLine 1132 ==> SourceLine 1397
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1397",1397);
                                LABEL$(13); // SAWRID
                                if((((SCANNER)(CUR$.SL$)).optx!=(((SCANNER)(CUR$.SL$)).NUL))) {
                                    new SCANNER$recognizer$OperandToParser(((SCANNER$recognizer)CUR$));
                                }
                                // JavaLine 1139 ==> SourceLine 1398
                                ((SCANNER)(CUR$.SL$)).optx=((SCANNER)(CUR$.SL$)).INOTY;
                                ((SCANNER)(CUR$.SL$)).parser.cs=((SCANNER)(CUR$.SL$)).IIDN;
                                // JavaLine 1142 ==> SourceLine 1399
                                LABEL$(14); // RESKW
                                ((SCANNER)(CUR$.SL$)).opdhi=curidhi;
                                ((SCANNER)(CUR$.SL$)).opdlo=curidlo;
                                // JavaLine 1146 ==> SourceLine 1400
                                LABEL$(15); // OPERAND
                                opdline=((SCANNER)(CUR$.SL$)).linenr;
                                // JavaLine 1149 ==> SourceLine 1401
                                LABEL$(16); // OPERAND2
                                opdpos=optpos;
                                GOTO$(ASSESS); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1397",1401);
                            }
                        }
                        // JavaLine 1156 ==> SourceLine 1406
                        ((SCANNER)(CUR$.SL$)).opt=curidlo;
                        // JavaLine 1158 ==> SourceLine 1407
                        switch(curidlo) { // BEGIN SWITCH STATEMENT
                        case 63: 
                        // JavaLine 1161 ==> SourceLine 1410
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1410",1410);
                            // JavaLine 1164 ==> SourceLine 1415
                            LABEL$(17); // SawComment
                            // JavaLine 1166 ==> SourceLine 1410
                            while((atom!=(';'))) {
                                // JavaLine 1168 ==> SourceLine 1411
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1411",1411);
                                    if((linepos<(linelength))) {
                                        // JavaLine 1172 ==> SourceLine 1412
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1412",1412);
                                            atom=loadChar(line,linepos);
                                            // JavaLine 1176 ==> SourceLine 1413
                                            linepos=(linepos+(1));
                                            TRACE_END_STM$("CompoundStatement1412",1413);
                                        }
                                    } else
                                    // JavaLine 1181 ==> SourceLine 1414
                                    new SCANNER$recognizer$nextLine(((SCANNER$recognizer)CUR$));
                                    TRACE_END_STM$("CompoundStatement1411",1414);
                                }
                            }
                            // JavaLine 1186 ==> SourceLine 1416
                            GOTO$(NxtChar); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1410",1416);
                        }
                        case 45: 
                        // JavaLine 1191 ==> SourceLine 1419
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1419",1419);
                            nxtsym=((SCANNER)(CUR$.SL$)).ITHEN;
                            eqopt=rank(((SCANNER)(CUR$.SL$)).ICAND);
                            TRACE_END_STM$("CompoundStatement1419",1419);
                        }
                        case 47: 
                        // JavaLine 1199 ==> SourceLine 1422
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1422",1422);
                            if(((SCANNER)(CUR$.SL$)).SportOK) {
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1422",1422);
                                    new SCANNER$recognizer$ScanPastFormat(((SCANNER$recognizer)CUR$));
                                    // JavaLine 1206 ==> SourceLine 1423
                                    if((atom==('('))) {
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1423",1423);
                                            ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).ICASE;
                                            GOTO$(ReadPC); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement1423",1423);
                                        }
                                    }
                                    TRACE_END_STM$("CompoundStatement1422",1423);
                                }
                            }
                            // JavaLine 1218 ==> SourceLine 1425
                            GOTO$(ParserC); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1422",1425);
                        }
                        case 55: 
                        // JavaLine 1223 ==> SourceLine 1428
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1428",1428);
                            if(((SCANNER)(CUR$.SL$)).SportOK) {
                                // JavaLine 1227 ==> SourceLine 1429
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1429",1429);
                                    nxtsym=((SCANNER)(CUR$.SL$)).INONE;
                                    eqopt=rank(((SCANNER)(CUR$.SL$)).IUPLS);
                                    GOTO$(SawKeyW); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1429",1429);
                                }
                            }
                            // JavaLine 1236 ==> SourceLine 1431
                            GOTO$(ParserC); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1428",1431);
                        }
                        case 20: 
                        // JavaLine 1241 ==> SourceLine 1434
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1434",1434);
                            nxtsym=((SCANNER)(CUR$.SL$)).ITO;
                            eqopt=(-(284));
                            ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IGOTO;
                            TRACE_END_STM$("CompoundStatement1434",1434);
                        }
                        case 22: 
                        // JavaLine 1250 ==> SourceLine 1437
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1437",1437);
                            nxtsym=((SCANNER)(CUR$.SL$)).IPRTC;
                            eqopt=rank(((SCANNER)(CUR$.SL$)).ITO);
                            TRACE_END_STM$("CompoundStatement1437",1437);
                        }
                        case 6: 
                        // JavaLine 1258 ==> SourceLine 1440
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1440",1440);
                            nxtsym=((SCANNER)(CUR$.SL$)).IREAL;
                            eqopt=(-(281));
                            TRACE_END_STM$("CompoundStatement1440",1440);
                        }
                        case 36: 
                        // JavaLine 1266 ==> SourceLine 1443
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1443",1443);
                            nxtsym=((SCANNER)(CUR$.SL$)).IELSE;
                            eqopt=rank(((SCANNER)(CUR$.SL$)).ICOR);
                            TRACE_END_STM$("CompoundStatement1443",1443);
                        }
                        case 40: 
                        // JavaLine 1274 ==> SourceLine 1446
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1446",1446);
                            nxtsym=((SCANNER)(CUR$.SL$)).IHIDD;
                            eqopt=rank(((SCANNER)(CUR$.SL$)).ITO);
                            TRACE_END_STM$("CompoundStatement1446",1446);
                        }
                        case 3: 
                        // JavaLine 1282 ==> SourceLine 1449
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1449",1449);
                            nxtsym=((SCANNER)(CUR$.SL$)).IINTG;
                            eqopt=(-(280));
                            TRACE_END_STM$("CompoundStatement1449",1449);
                        }
                        case 51: 
                        // JavaLine 1290 ==> SourceLine 1452
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1452",1452);
                            new SCANNER$P1warn(((SCANNER)(CUR$.SL$)),279);
                            ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IGOTO;
                            GOTO$(ParserC); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1452",1452);
                        }
                        case 31: 
                        // JavaLine 1299 ==> SourceLine 1455
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1455",1455);
                            if(((SCANNER)(CUR$.SL$)).Simuletta) {
                                GOTO$(ParserC); // GOTO EVALUATED LABEL
                            }
                            // JavaLine 1305 ==> SourceLine 1456
                            ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).NUL;
                            curidlo=((SCANNER)(CUR$.SL$)).recordindex;
                            GOTO$(SAWRID); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1455",1456);
                        }
                        case 54: 
                        // JavaLine 1312 ==> SourceLine 1459
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1459",1459);
                            new SCANNER$recognizer$ScanPastFormat(((SCANNER$recognizer)CUR$));
                            if((atom!=(':'))) {
                                // JavaLine 1317 ==> SourceLine 1460
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1460",1460);
                                    new SCANNER$P1warn(((SCANNER)(CUR$.SL$)),283);
                                    GOTO$(ParserC); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1460",1460);
                                }
                            }
                            // JavaLine 1325 ==> SourceLine 1461
                            GOTO$(ReadPC); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1459",1461);
                        }
                        case 64: 
                        case 65: 
                        case 66: 
                        case 67: 
                        // JavaLine 1333 ==> SourceLine 1465
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1465",1465);
                            if((((SCANNER)(CUR$.SL$)).optx!=(((SCANNER)(CUR$.SL$)).NUL))) {
                                new SCANNER$recognizer$OperandToParser(((SCANNER$recognizer)CUR$));
                            }
                            // JavaLine 1339 ==> SourceLine 1466
                            ((SCANNER)(CUR$.SL$)).parser.cs=((SCANNER)(CUR$.SL$)).ICONS;
                            // JavaLine 1341 ==> SourceLine 1467
                            ((SCANNER)(CUR$.SL$)).optx=(((curidlo==(((SCANNER)(CUR$.SL$)).INOTE)))?(((SCANNER)(CUR$.SL$)).ITEXT):((((curidlo==(((SCANNER)(CUR$.SL$)).INONE)))?(((SCANNER)(CUR$.SL$)).IREF):(((SCANNER)(CUR$.SL$)).IBOOL))));
                            // JavaLine 1343 ==> SourceLine 1475
                            GOTO$(RESKW); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1465",1475);
                        }
                        case 32: 
                        // JavaLine 1348 ==> SourceLine 1481
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1481",1481);
                            ((SCANNER)(CUR$.SL$)).maxnumoftags=(((SCANNER)(CUR$.SL$)).maxnumoftags+(1));
                            // JavaLine 1352 ==> SourceLine 1482
                            GOTO$(ParserC); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1481",1482);
                        }
                        case 16: 
                        // JavaLine 1357 ==> SourceLine 1485
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1485",1485);
                            while((((SCANNER)(CUR$.SL$)).opt==(((SCANNER)(CUR$.SL$)).IEND))) {
                                // JavaLine 1361 ==> SourceLine 1486
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1486",1486);
                                    ((SCANNER)(CUR$.SL$)).maxnumoftags=(((SCANNER)(CUR$.SL$)).maxnumoftags-(1));
                                    // JavaLine 1365 ==> SourceLine 1487
                                    {
                                        // BEGIN INSPECTION 
                                        inspect$1487$17=((SCANNER)(CUR$.SL$)).parser;
                                        if(inspect$1487$17!=null) //INSPECT inspect$1487$17
                                        // JavaLine 1370 ==> SourceLine 1488
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1488",1488);
                                            inspect$1487$17.getopt=true;
                                            // JavaLine 1374 ==> SourceLine 1489
                                            if((((SCANNER)(CUR$.SL$)).optx==(((SCANNER)(CUR$.SL$)).NUL))) {
                                                // JavaLine 1376 ==> SourceLine 1490
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement1490",1490);
                                                    inspect$1487$17.cs=((SCANNER)(CUR$.SL$)).opt;
                                                    inspect$1487$17.getopt=false;
                                                    TRACE_END_STM$("CompoundStatement1490",1490);
                                                }
                                            }
                                            // JavaLine 1384 ==> SourceLine 1495
                                            call(((COMMON$component)inspect$1487$17));
                                            // JavaLine 1386 ==> SourceLine 1496
                                            inspect$1487$17.cs=((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).optx=((SCANNER)(CUR$.SL$)).opdhi=((SCANNER)(CUR$.SL$)).opdlo=((SCANNER)(CUR$.SL$)).NUL;
                                            TRACE_END_STM$("CompoundStatement1488",1496);
                                        }
                                    }
                                    // JavaLine 1391 ==> SourceLine 1537
                                    LABEL$(19); // FindEnd
                                    // JavaLine 1393 ==> SourceLine 1499
                                    if((atom==(';'))) {
                                        // JavaLine 1395 ==> SourceLine 1500
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1500",1500);
                                            LABEL$(18); // SawSMCL
                                            ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).ISMCL;
                                            optpos=linepos;
                                            // JavaLine 1401 ==> SourceLine 1501
                                            atom=loadChar(line,linepos);
                                            // JavaLine 1403 ==> SourceLine 1502
                                            linepos=(linepos+(1));
                                            TRACE_END_STM$("CompoundStatement1500",1502);
                                        }
                                    } else
                                    // JavaLine 1408 ==> SourceLine 1507
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1507",1507);
                                        while((InputClass.Elt[rank(atom)-InputClass.LB[0]]>(((SCANNER)(CUR$.SL$)).LetterC_cl))) {
                                            // JavaLine 1412 ==> SourceLine 1510
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1510",1510);
                                                if((atom==(((SCANNER)(CUR$.SL$)).EOL))) {
                                                    // JavaLine 1416 ==> SourceLine 1511
                                                    new SCANNER$recognizer$nextLine(((SCANNER$recognizer)CUR$));
                                                } else
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement1511",1511);
                                                    atom=loadChar(line,linepos);
                                                    // JavaLine 1422 ==> SourceLine 1512
                                                    linepos=(linepos+(1));
                                                    TRACE_END_STM$("CompoundStatement1511",1512);
                                                }
                                                // JavaLine 1426 ==> SourceLine 1514
                                                if((atom==(';'))) {
                                                    GOTO$(SawSMCL); // GOTO EVALUATED LABEL
                                                }
                                                TRACE_END_STM$("CompoundStatement1510",1514);
                                            }
                                        }
                                        // JavaLine 1433 ==> SourceLine 1517
                                        if(((((((atom==('e'))||((atom==('w'))))||((atom==('o'))))||((atom==('E'))))||((atom==('W'))))||((atom==('O'))))) {
                                            // JavaLine 1435 ==> SourceLine 1521
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1521",1521);
                                                call(IdScanner);
                                                // JavaLine 1439 ==> SourceLine 1523
                                                if(TXTREL$EQ(((SCANNER)(CUR$.SL$)).simsymbol,new TXT$("end"))) {
                                                    ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IEND;
                                                } else
                                                // JavaLine 1443 ==> SourceLine 1524
                                                if(TXTREL$EQ(((SCANNER)(CUR$.SL$)).simsymbol,new TXT$("else"))) {
                                                    ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IELSE;
                                                } else
                                                // JavaLine 1447 ==> SourceLine 1525
                                                if(TXTREL$EQ(((SCANNER)(CUR$.SL$)).simsymbol,new TXT$("when"))) {
                                                    ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IWHEN;
                                                } else
                                                // JavaLine 1451 ==> SourceLine 1526
                                                if(TXTREL$EQ(((SCANNER)(CUR$.SL$)).simsymbol,new TXT$("otherwise"))) {
                                                    ((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).IOTHW;
                                                } else
                                                // JavaLine 1455 ==> SourceLine 1527
                                                GOTO$(FindEnd); // GOTO EVALUATED LABEL
                                                TRACE_END_STM$("CompoundStatement1521",1527);
                                            }
                                        } else
                                        // JavaLine 1460 ==> SourceLine 1530
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1530",1530);
                                            while((InputClass.Elt[rank(atom)-InputClass.LB[0]]<=(((SCANNER)(CUR$.SL$)).Uscore_cl))) {
                                                // JavaLine 1464 ==> SourceLine 1532
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement1532",1532);
                                                    atom=loadChar(line,linepos);
                                                    // JavaLine 1468 ==> SourceLine 1533
                                                    linepos=(linepos+(1));
                                                    TRACE_END_STM$("CompoundStatement1532",1533);
                                                }
                                            }
                                            // JavaLine 1473 ==> SourceLine 1535
                                            GOTO$(FindEnd); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement1530",1535);
                                        }
                                        TRACE_END_STM$("CompoundStatement1507",1535);
                                    }
                                    // JavaLine 1479 ==> SourceLine 1543
                                    LABEL$(20); // TESTENDCOUNT
                                    // JavaLine 1481 ==> SourceLine 1538
                                    if((((SCANNER)(CUR$.SL$)).maxnumoftags==(0))) {
                                        // JavaLine 1483 ==> SourceLine 1539
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1539",1539);
                                            if((((SCANNER)(CUR$.SL$)).opt==(((SCANNER)(CUR$.SL$)).ISMCL))) {
                                                new SCANNER$recognizer$ScanPastFormat(((SCANNER$recognizer)CUR$));
                                            }
                                            // JavaLine 1489 ==> SourceLine 1541
                                            if((atom!=(((char)26)))) {
                                                new SCANNER$P1warn(((SCANNER)(CUR$.SL$)),288);
                                            }
                                            // JavaLine 1493 ==> SourceLine 1542
                                            while(true) {
                                                detach();
                                                   if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                                            }
                                            TRACE_END_STM$("CompoundStatement1539",1542);
                                        }
                                    }
                                    TRACE_END_STM$("CompoundStatement1486",1542);
                                }
                            }
                            // JavaLine 1504 ==> SourceLine 1545
                            GOTO$(ParserC); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1485",1545);
                        }
                        default:
                        // JavaLine 1509 ==> SourceLine 1547
                        GOTO$(ParserC); // GOTO EVALUATED LABEL
                    } // END SWITCH STATEMENT
                    // JavaLine 1512 ==> SourceLine 1549
                    LABEL$(25); // SawKeyW
                    curidhi=curidlo=((SCANNER)(CUR$.SL$)).NUL;
                    // JavaLine 1515 ==> SourceLine 1550
                    new SCANNER$recognizer$ScanPastFormat(((SCANNER$recognizer)CUR$));
                    startpos=linepos;
                    // JavaLine 1518 ==> SourceLine 1551
                    if((InputClass.Elt[rank(atom)-InputClass.LB[0]]<(((SCANNER)(CUR$.SL$)).Digit_cl))) {
                        // JavaLine 1520 ==> SourceLine 1552
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1552",1552);
                            call(IdScanner);
                            new COMMON$DEFIDENT(((SCANNER)(CUR$.SL$)));
                            // JavaLine 1525 ==> SourceLine 1553
                            if(((((SCANNER)(CUR$.SL$)).hashlo==(nxtsym))&&((((SCANNER)(CUR$.SL$)).hashhi==(((SCANNER)(CUR$.SL$)).NUL))))) {
                                // JavaLine 1527 ==> SourceLine 1554
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1554",1554);
                                    if((eqopt>(0))) {
                                        ((SCANNER)(CUR$.SL$)).opt=char$(eqopt);
                                    }
                                    GOTO$(ParserC); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement1554",1554);
                                }
                            }
                            // JavaLine 1537 ==> SourceLine 1556
                            curidhi=((SCANNER)(CUR$.SL$)).hashhi;
                            curidlo=((SCANNER)(CUR$.SL$)).hashlo;
                            TRACE_END_STM$("CompoundStatement1552",1556);
                        }
                    }
                    // JavaLine 1543 ==> SourceLine 1558
                    if((eqopt<(0))) {
                        new SCANNER$P1warn(((SCANNER)(CUR$.SL$)),(-(eqopt)));
                    }
                    // JavaLine 1547 ==> SourceLine 1559
                    if(((curidlo!=(((SCANNER)(CUR$.SL$)).NUL))||((curidhi!=(((SCANNER)(CUR$.SL$)).NUL))))) {
                        // JavaLine 1549 ==> SourceLine 1560
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1560",1560);
                            {
                                // BEGIN INSPECTION 
                                inspect$1560$18=((SCANNER)(CUR$.SL$)).parser;
                                if(inspect$1560$18!=null) //INSPECT inspect$1560$18
                                // JavaLine 1556 ==> SourceLine 1561
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1561",1561);
                                    inspect$1560$18.getopt=true;
                                    // JavaLine 1560 ==> SourceLine 1562
                                    if((((SCANNER)(CUR$.SL$)).optx==(((SCANNER)(CUR$.SL$)).NUL))) {
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1562",1562);
                                            inspect$1560$18.cs=((SCANNER)(CUR$.SL$)).opt;
                                            inspect$1560$18.getopt=false;
                                            TRACE_END_STM$("CompoundStatement1562",1562);
                                        }
                                    }
                                    // JavaLine 1569 ==> SourceLine 1567
                                    call(((COMMON$component)inspect$1560$18));
                                    // JavaLine 1571 ==> SourceLine 1568
                                    inspect$1560$18.cs=((SCANNER)(CUR$.SL$)).opt=((SCANNER)(CUR$.SL$)).optx=((SCANNER)(CUR$.SL$)).opdhi=((SCANNER)(CUR$.SL$)).opdlo=((SCANNER)(CUR$.SL$)).NUL;
                                    TRACE_END_STM$("CompoundStatement1561",1568);
                                }
                            }
                            // JavaLine 1576 ==> SourceLine 1570
                            optpos=startpos;
                            GOTO$(IdentifierFound); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1560",1570);
                        }
                    }
                    // JavaLine 1582 ==> SourceLine 1581
                    GOTO$(ParserC); // GOTO EVALUATED LABEL
                    TRACE_END_STM$("CompoundStatement1335",1581);
                }
                default:
                // JavaLine 1587 ==> SourceLine 1586
                {
                    TRACE_BEGIN_STM$("CompoundStatement1586",1586);
                    LABEL$(26); // Mill
                    new SCANNER$recognizer$illegalChar(((SCANNER$recognizer)CUR$));
                    GOTO$(NxtChar); // GOTO EVALUATED LABEL
                    TRACE_END_STM$("CompoundStatement1586",1586);
                }
            } // END SWITCH STATEMENT
            // JavaLine 1596 ==> SourceLine 1590
            GOTO$(ReadPC); // GOTO EVALUATED LABEL
            // JavaLine 1598 ==> SourceLine 1089
            if(inner!=null) {
                inner.STM$();
                TRACE_BEGIN_STM_AFTER_INNER$("recognizer",1089);
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
    TRACE_END_STM$("recognizer",1089);
}
};
} // End of Constructor
// Class Statements
public SCANNER$recognizer STM$() { return((SCANNER$recognizer)CODE$.EXEC$()); }
public SCANNER$recognizer START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Class recognizer",1,562,12,1091,14,1095,16,1097,18,1108,20,1242,22,1226,24,1228,26,1295,28,1317,30,1302,32,1291,34,1350,36,1397,38,1399,40,1400,42,1401,44,1410,46,1500,48,1499,50,1538,52,1335,54,1338,56,1344,58,1396,60,1549,62,1586,65,568,67,569,69,570,71,571,74,572,76,573,78,574,80,575,82,576,84,577,86,578,88,579,90,580,92,581,94,582,96,583,98,584,100,585,102,586,104,587,106,660,108,938,110,975,112,1097,114,1487,116,1560,124,660,137,1089,139,1090,142,1091,146,1093,148,1095,152,1106,154,1097,159,1098,163,1099,172,1104,174,1105,179,1108,182,1110,185,1113,193,1117,204,1118,210,1122,215,1123,224,1124,233,1125,239,1128,247,1131,255,1134,263,1137,267,1139,269,1140,275,1141,280,1142,286,1145,293,1149,298,1150,300,1153,306,1154,311,1155,317,1158,321,1160,325,1161,335,1166,342,1170,346,1171,348,1173,350,1174,356,1175,362,1177,367,1181,371,1183,380,1184,385,1189,390,1190,394,1191,403,1192,408,1196,413,1198,422,1199,431,1200,433,1202,436,1203,448,1208,453,1209,462,1210,475,1219,478,1224,484,1225,487,1226,491,1228,495,1229,497,1230,501,1231,507,1232,510,1234,515,1236,518,1237,520,1238,525,1239,529,1240,534,1242,540,1245,544,1247,546,1248,551,1249,558,1251,560,1252,562,1253,566,1255,574,1256,579,1258,582,1259,586,1261,590,1262,592,1263,595,1264,601,1267,606,1270,612,1271,614,1273,616,1274,625,1275,629,1276,633,1277,635,1279,637,1280,644,1284,653,1286,667,1291,674,1292,678,1293,683,1295,686,1296,689,1297,693,1298,698,1300,703,1302,706,1303,709,1304,718,1307,726,1310,728,1311,733,1313,738,1314,740,1315,744,1316,749,1317,755,1318,757,1319,759,1321,767,1324,770,1325,774,1326,780,1331,786,1332,843,1335,848,1354,850,1338,915,1341,1090,1345,1092,1344,1096,1345,1101,1347,1107,1348,1112,1350,1118,1351,1123,1356,1125,1357,1128,1402,1130,1396,1132,1397,1139,1398,1142,1399,1146,1400,1149,1401,1156,1406,1158,1407,1161,1410,1164,1415,1166,1410,1168,1411,1172,1412,1176,1413,1181,1414,1186,1416,1191,1419,1199,1422,1206,1423,1218,1425,1223,1428,1227,1429,1236,1431,1241,1434,1250,1437,1258,1440,1266,1443,1274,1446,1282,1449,1290,1452,1299,1455,1305,1456,1312,1459,1317,1460,1325,1461,1333,1465,1339,1466,1341,1467,1343,1475,1348,1481,1352,1482,1357,1485,1361,1486,1365,1487,1370,1488,1374,1489,1376,1490,1384,1495,1386,1496,1391,1537,1393,1499,1395,1500,1401,1501,1403,1502,1408,1507,1412,1510,1416,1511,1422,1512,1426,1514,1433,1517,1435,1521,1439,1523,1443,1524,1447,1525,1451,1526,1455,1527,1460,1530,1464,1532,1468,1533,1473,1535,1479,1543,1481,1538,1483,1539,1489,1541,1493,1542,1504,1545,1509,1547,1512,1549,1515,1550,1518,1551,1520,1552,1525,1553,1527,1554,1537,1556,1543,1558,1547,1559,1549,1560,1556,1561,1560,1562,1569,1567,1571,1568,1576,1570,1582,1581,1587,1586,1596,1590,1598,1089,1622,1592);
}
