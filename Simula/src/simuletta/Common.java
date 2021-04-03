// JavaLine 1 <== SourceLine 2
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class Common extends Simset$ {
    // ClassDeclaration: Kind=Class, BlockLevel=1, PrefixLevel=1, firstLine=2, lastLine=1403, hasLocalClasses=true, System=false, detachUsed=false
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 10 <== SourceLine 14
    public final TXT$ sportid$1=(TXT$)(new TXT$("S-PORT SYSTEM"));
    // JavaLine 12 <== SourceLine 15
    public int DO_TRACING$1=0;
    // JavaLine 14 <== SourceLine 20
    public final char NUL$1=(char)(((char)0));
    // JavaLine 16 <== SourceLine 22
    public int identx$1=0;
    public int constx$1=0;
    // JavaLine 19 <== SourceLine 23
    public int hash$1=0;
    // JavaLine 21 <== SourceLine 24
    public TXT$ simsymbol$1=null;
    // JavaLine 23 <== SourceLine 27
    public final int MAX_SYMB$1=(int)(5000);
    // JavaLine 25 <== SourceLine 28
    public ARRAY$<Common$symbolbox[]>symtab=null;
    // JavaLine 27 <== SourceLine 29
    public int nSymb$1=0;
    // JavaLine 29 <== SourceLine 31
    public Common$identsymbol dummyBox$1=null;
    // JavaLine 31 <== SourceLine 93
    public ARRAY$<int[]>option=null;
    // JavaLine 33 <== SourceLine 99
    public boolean SportOk$1=false;
    // JavaLine 35 <== SourceLine 100
    public boolean recomp$1=false;
    // JavaLine 37 <== SourceLine 101
    public boolean GiveNotes$1=false;
    // JavaLine 39 <== SourceLine 102
    public boolean listingon$1=false;
    // JavaLine 41 <== SourceLine 103
    public boolean global_module$1=false;
    // JavaLine 43 <== SourceLine 104
    public boolean simob_descr$1=false;
    public boolean simob_entity$1=false;
    public boolean simob_const$1=false;
    // JavaLine 47 <== SourceLine 105
    public boolean GenerateScode$1=false;
    // JavaLine 49 <== SourceLine 106
    public int ntag$1=0;
    // JavaLine 51 <== SourceLine 107
    public int mxtag$1=0;
    // JavaLine 53 <== SourceLine 108
    public int termstatus$1=0;
    // JavaLine 55 <== SourceLine 109
    public int currentpass$1=0;
    // JavaLine 57 <== SourceLine 110
    public int string$1=0;
    // JavaLine 59 <== SourceLine 111
    public int simob_level$1=0;
    // JavaLine 61 <== SourceLine 112
    public int curline$1=0;
    // JavaLine 63 <== SourceLine 113
    public int nerr$1=0;
    // JavaLine 65 <== SourceLine 114
    public int maxerrno$1=0;
    // JavaLine 67 <== SourceLine 115
    public int rutlev$1=0;
    // JavaLine 69 <== SourceLine 116
    public int listlength$1=0;
    // JavaLine 71 <== SourceLine 117
    public int module_trace$1=0;
    // JavaLine 73 <== SourceLine 118
    public Common$identsymbol chradrBox$1=null;
    public Common$identsymbol nchrBox$1=null;
    // JavaLine 76 <== SourceLine 119
    public PrintFile$ ListFile$1=null;
    // JavaLine 78 <== SourceLine 120
    public Head$ modset$1=null;
    // JavaLine 80 <== SourceLine 121
    public Head$ qntset$1=null;
    // JavaLine 82 <== SourceLine 123
    public Head$ vislist$1=null;
    // JavaLine 84 <== SourceLine 124
    public Head$ constlist$1=null;
    // JavaLine 86 <== SourceLine 125
    public Head$ localdecl$1=null;
    // JavaLine 88 <== SourceLine 127
    public Head$ redeclset$1=null;
    // JavaLine 90 <== SourceLine 128
    public Head$ structset$1=null;
    // JavaLine 92 <== SourceLine 129
    public Head$ caseset$1=null;
    // JavaLine 94 <== SourceLine 130
    public Common$caseDescr curcase$1=null;
    // JavaLine 96 <== SourceLine 131
    public Head$ TRC_info$1=null;
    // JavaLine 98 <== SourceLine 133
    public Head$ TRC_init$1=null;
    // JavaLine 100 <== SourceLine 134
    public TXT$ module_ident$1=null;
    // JavaLine 102 <== SourceLine 136
    public TXT$ module_code$1=null;
    // JavaLine 104 <== SourceLine 138
    public TXT$ L2name$1=null;
    // JavaLine 106 <== SourceLine 139
    public TXT$ nscodename$1=null;
    // JavaLine 108 <== SourceLine 140
    public TXT$ predefname$1=null;
    // JavaLine 110 <== SourceLine 141
    public TXT$ timestamp$1=null;
    // JavaLine 112 <== SourceLine 142
    public TXT$ leftintbuf$1=null;
    // JavaLine 114 <== SourceLine 143
    public TXT$ leftsintbuf$1=null;
    // JavaLine 116 <== SourceLine 144
    public TXT$ tempt$1=null;
    // JavaLine 118 <== SourceLine 146
    public ARRAY$<boolean[]>Selector=null;
    // JavaLine 120 <== SourceLine 165
    public ARRAY$<Common$symbolbox[]>tagtab=null;
    // JavaLine 122 <== SourceLine 167
    public final int TYP_INFIX$1=(int)(1);
    public final int TYP_INT$1=(int)(2);
    public final int TYP_STRUCT$1=(int)(3);
    // JavaLine 126 <== SourceLine 168
    public final int TYP_FIELD$1=(int)(4);
    public final int TYP_REF$1=(int)(5);
    public final int TYP_NAME$1=(int)(6);
    // JavaLine 130 <== SourceLine 169
    public final int TYP_ENT$1=(int)(7);
    // JavaLine 132 <== SourceLine 170
    public final int TYP_UNDEF$1=(int)(0);
    public final int TYP_MXMX$1=(int)(7);
    // JavaLine 135 <== SourceLine 172
    public final int TAG_BOOL$1=(int)(1);
    public final int TAG_CHAR$1=(int)(2);
    public final int TAG_INT$1=(int)(3);
    // JavaLine 139 <== SourceLine 173
    public final int TAG_SINT$1=(int)(4);
    public final int TAG_REAL$1=(int)(5);
    public final int TAG_LREAL$1=(int)(6);
    // JavaLine 143 <== SourceLine 174
    public final int TAG_AADDR$1=(int)(7);
    public final int TAG_OADDR$1=(int)(8);
    public final int TAG_GADDR$1=(int)(9);
    // JavaLine 147 <== SourceLine 175
    public final int TAG_PADDR$1=(int)(10);
    public final int TAG_RADDR$1=(int)(11);
    public final int TAG_SIZE$1=(int)(12);
    // JavaLine 151 <== SourceLine 177
    public final int T_NULL$1=(int)(0);
    // JavaLine 153 <== SourceLine 178
    public final int T_UNDEF$1=(int)(0);
    public final int T_INT$1=(int)(1);
    public final int T_SINT$1=(int)(2);
    public final int T_REAL$1=(int)(3);
    // JavaLine 158 <== SourceLine 179
    public final int T_LREAL$1=(int)(4);
    public final int T_SIZE$1=(int)(5);
    public final int T_CHAR$1=(int)(6);
    public final int T_BOOL$1=(int)(7);
    // JavaLine 163 <== SourceLine 180
    public final int T_LABEL$1=(int)(8);
    public final int T_ENT$1=(int)(9);
    public final int T_REF$1=(int)(10);
    public final int T_NAME$1=(int)(11);
    // JavaLine 168 <== SourceLine 181
    public final int T_FIELD$1=(int)(12);
    public final int T_DEST$1=(int)(13);
    // JavaLine 171 <== SourceLine 186
    public final int S_NULL$1=(int)(0);
    public final int S_RECORD$1=(int)(1);
    // JavaLine 174 <== SourceLine 187
    public final int S_LSHIFTL$1=(int)(2);
    // JavaLine 176 <== SourceLine 188
    public final int S_PREFIX$1=(int)(3);
    public final int S_ATTR$1=(int)(4);
    // JavaLine 179 <== SourceLine 189
    public final int S_LSHIFTA$1=(int)(5);
    // JavaLine 181 <== SourceLine 190
    public final int S_REP$1=(int)(6);
    // JavaLine 183 <== SourceLine 191
    public final int S_ALT$1=(int)(7);
    public final int S_FIXREP$1=(int)(8);
    public final int S_ENDRECORD$1=(int)(9);
    public final int S_C_RECORD$1=(int)(10);
    // JavaLine 188 <== SourceLine 192
    public final int S_TEXT$1=(int)(11);
    public final int S_C_CHAR$1=(int)(12);
    public final int S_C_INT$1=(int)(13);
    public final int S_C_SIZE$1=(int)(14);
    // JavaLine 193 <== SourceLine 193
    public final int S_C_REAL$1=(int)(15);
    public final int S_C_LREAL$1=(int)(16);
    public final int S_C_AADDR$1=(int)(17);
    public final int S_C_OADDR$1=(int)(18);
    // JavaLine 198 <== SourceLine 194
    public final int S_C_GADDR$1=(int)(19);
    public final int S_C_PADDR$1=(int)(20);
    public final int S_C_DOT$1=(int)(21);
    public final int S_C_RADDR$1=(int)(22);
    // JavaLine 203 <== SourceLine 195
    public final int S_NOBODY$1=(int)(23);
    public final int S_ANONE$1=(int)(24);
    public final int S_ONONE$1=(int)(25);
    public final int S_GNONE$1=(int)(26);
    // JavaLine 208 <== SourceLine 196
    public final int S_NOWHERE$1=(int)(27);
    public final int S_TRUE$1=(int)(28);
    public final int S_FALSE$1=(int)(29);
    public final int S_PROFILE$1=(int)(30);
    // JavaLine 213 <== SourceLine 197
    public final int S_KNOWN$1=(int)(31);
    public final int S_SYSTEM$1=(int)(32);
    public final int S_EXTERNAL$1=(int)(33);
    public final int S_IMPORT$1=(int)(34);
    // JavaLine 218 <== SourceLine 198
    public final int S_EXPORT$1=(int)(35);
    public final int S_EXIT$1=(int)(36);
    public final int S_ENDPROFILE$1=(int)(37);
    public final int S_ROUTINESPEC$1=(int)(38);
    // JavaLine 223 <== SourceLine 199
    public final int S_ROUTINE$1=(int)(39);
    public final int S_LOCAL$1=(int)(40);
    public final int S_ENDROUTINE$1=(int)(41);
    public final int S_MODULE$1=(int)(42);
    // JavaLine 228 <== SourceLine 200
    public final int S_EXISTING$1=(int)(43);
    public final int S_TAG$1=(int)(44);
    public final int S_BODY$1=(int)(45);
    public final int S_ENDMODULE$1=(int)(46);
    // JavaLine 233 <== SourceLine 201
    public final int S_LABELSPEC$1=(int)(47);
    public final int S_LABEL$1=(int)(48);
    public final int S_RANGE$1=(int)(49);
    public final int S_GLOBAL$1=(int)(50);
    // JavaLine 238 <== SourceLine 202
    public final int S_INIT$1=(int)(51);
    public final int S_CONSTSPEC$1=(int)(52);
    public final int S_CONST$1=(int)(53);
    public final int S_DELETE$1=(int)(54);
    // JavaLine 243 <== SourceLine 203
    public final int S_FDEST$1=(int)(55);
    public final int S_BDEST$1=(int)(56);
    public final int S_SAVE$1=(int)(57);
    public final int S_RESTORE$1=(int)(58);
    // JavaLine 248 <== SourceLine 204
    public final int S_BSEG$1=(int)(59);
    public final int S_ESEG$1=(int)(60);
    public final int S_SKIPIF$1=(int)(61);
    public final int S_ENDSKIP$1=(int)(62);
    // JavaLine 253 <== SourceLine 205
    public final int S_IF$1=(int)(63);
    public final int S_ELSE$1=(int)(64);
    public final int S_ENDIF$1=(int)(65);
    // JavaLine 257 <== SourceLine 206
    public final int S_RSHIFTL$1=(int)(66);
    // JavaLine 259 <== SourceLine 207
    public final int S_PRECALL$1=(int)(67);
    public final int S_ASSPAR$1=(int)(68);
    public final int S_ASSREP$1=(int)(69);
    public final int S_CALL$1=(int)(70);
    // JavaLine 264 <== SourceLine 208
    public final int S_FETCH$1=(int)(71);
    public final int S_REFER$1=(int)(72);
    public final int S_DEREF$1=(int)(73);
    public final int S_SELECT$1=(int)(74);
    // JavaLine 269 <== SourceLine 209
    public final int S_REMOTE$1=(int)(75);
    public final int S_LOCATE$1=(int)(76);
    public final int S_INDEX$1=(int)(77);
    public final int S_INCO$1=(int)(78);
    // JavaLine 274 <== SourceLine 210
    public final int S_DECO$1=(int)(79);
    public final int S_PUSH$1=(int)(80);
    public final int S_PUSHC$1=(int)(81);
    public final int S_PUSHLEN$1=(int)(82);
    // JavaLine 279 <== SourceLine 211
    public final int S_DUP$1=(int)(83);
    public final int S_POP$1=(int)(84);
    public final int S_EMPTY$1=(int)(85);
    public final int S_SETOBJ$1=(int)(86);
    // JavaLine 284 <== SourceLine 212
    public final int S_GETOBJ$1=(int)(87);
    public final int S_ACCESS$1=(int)(88);
    public final int S_FJUMP$1=(int)(89);
    public final int S_BJUMP$1=(int)(90);
    // JavaLine 289 <== SourceLine 213
    public final int S_FJUMPIF$1=(int)(91);
    public final int S_BJUMPIF$1=(int)(92);
    public final int S_SWITCH$1=(int)(93);
    public final int S_GOTO$1=(int)(94);
    // JavaLine 294 <== SourceLine 214
    public final int S_T_INITO$1=(int)(95);
    public final int S_T_GETO$1=(int)(96);
    public final int S_T_SETO$1=(int)(97);
    public final int S_ADD$1=(int)(98);
    // JavaLine 299 <== SourceLine 215
    public final int S_SUB$1=(int)(99);
    public final int S_MULT$1=(int)(100);
    public final int S_DIV$1=(int)(101);
    public final int S_REM$1=(int)(102);
    // JavaLine 304 <== SourceLine 216
    public final int S_NEG$1=(int)(103);
    public final int S_AND$1=(int)(104);
    public final int S_OR$1=(int)(105);
    public final int S_XOR$1=(int)(106);
    // JavaLine 309 <== SourceLine 217
    public final int S_IMP$1=(int)(107);
    public final int S_EQV$1=(int)(108);
    public final int S_NOT$1=(int)(109);
    public final int S_DIST$1=(int)(110);
    // JavaLine 314 <== SourceLine 218
    public final int S_ASSIGN$1=(int)(111);
    public final int S_UPDATE$1=(int)(112);
    public final int S_CONVERT$1=(int)(113);
    public final int S_SYSINSERT$1=(int)(114);
    // JavaLine 319 <== SourceLine 219
    public final int S_INSERT$1=(int)(115);
    public final int S_ZEROAREA$1=(int)(116);
    public final int S_INITAREA$1=(int)(117);
    public final int S_COMPARE$1=(int)(118);
    // JavaLine 324 <== SourceLine 220
    public final int S_LT$1=(int)(119);
    public final int S_LE$1=(int)(120);
    public final int S_EQ$1=(int)(121);
    public final int S_GE$1=(int)(122);
    // JavaLine 329 <== SourceLine 221
    public final int S_GT$1=(int)(123);
    public final int S_NE$1=(int)(124);
    public final int S_EVAL$1=(int)(125);
    public final int S_INFO$1=(int)(126);
    // JavaLine 334 <== SourceLine 222
    public final int S_LINE$1=(int)(127);
    public final int S_SETSWITCH$1=(int)(128);
    // JavaLine 337 <== SourceLine 223
    public final int S_RSHIFTA$1=(int)(129);
    // JavaLine 339 <== SourceLine 224
    public final int S_PROGRAM$1=(int)(130);
    public final int S_MAIN$1=(int)(131);
    // JavaLine 342 <== SourceLine 225
    public final int S_ENDPROGRAM$1=(int)(132);
    public final int S_DSIZE$1=(int)(133);
    public final int S_SDEST$1=(int)(134);
    public final int S_RUPDATE$1=(int)(135);
    // JavaLine 347 <== SourceLine 226
    public final int S_ASSCALL$1=(int)(136);
    public final int S_CALL_TOS$1=(int)(137);
    public final int S_DINITAREA$1=(int)(138);
    public final int S_NOSIZE$1=(int)(139);
    // JavaLine 352 <== SourceLine 227
    public final int S_POPALL$1=(int)(140);
    public final int S_REPCALL$1=(int)(141);
    public final int S_INTERFACE$1=(int)(142);
    public final int S_MACRO$1=(int)(143);
    // JavaLine 357 <== SourceLine 228
    public final int S_MARK$1=(int)(144);
    public final int S_MPAR$1=(int)(145);
    public final int S_ENDMACRO$1=(int)(146);
    public final int S_MCALL$1=(int)(147);
    // JavaLine 362 <== SourceLine 229
    public final int S_PUSHV$1=(int)(148);
    public final int S_SELECTV$1=(int)(149);
    public final int S_REMOTEV$1=(int)(150);
    public final int S_INDEXV$1=(int)(151);
    // JavaLine 367 <== SourceLine 230
    public final int S_ACCESSV$1=(int)(152);
    public final int S_DECL$1=(int)(153);
    public final int S_STMT$1=(int)(154);
    // JavaLine 371 <== SourceLine 231
    public final int N_INSTR$1=(int)(154);
    // JavaLine 373 <== SourceLine 235
    public final int S_BEGIN$1=(int)(155);
    public final int S_END$1=(int)(156);
    public final int S_VARIANT$1=(int)(157);
    public final int S_SHORT$1=(int)(158);
    // JavaLine 378 <== SourceLine 236
    public final int S_LONG$1=(int)(159);
    public final int S_INTEGER$1=(int)(160);
    public final int S_SIZE$1=(int)(161);
    public final int S_REAL$1=(int)(162);
    // JavaLine 383 <== SourceLine 237
    public final int S_CHAR$1=(int)(163);
    public final int S_BOOLEAN$1=(int)(164);
    public final int S_REF$1=(int)(165);
    public final int S_NAME$1=(int)(166);
    // JavaLine 388 <== SourceLine 238
    public final int S_FIELD$1=(int)(167);
    public final int S_INFIX$1=(int)(168);
    public final int S_ENTRY$1=(int)(169);
    public final int S_NONE$1=(int)(170);
    // JavaLine 393 <== SourceLine 239
    public final int S_NONAME$1=(int)(171);
    public final int S_NOFIELD$1=(int)(172);
    public final int S_THEN$1=(int)(173);
    public final int S_ELSIF$1=(int)(174);
    // JavaLine 398 <== SourceLine 240
    public final int S_QUA$1=(int)(175);
    public final int S_VAR$1=(int)(176);
    public final int S_REPEAT$1=(int)(177);
    public final int S_WHILE$1=(int)(178);
    // JavaLine 403 <== SourceLine 241
    public final int S_DO$1=(int)(179);
    public final int S_ENDREPEAT$1=(int)(180);
    public final int S_SYSRUT$1=(int)(181);
    public final int S_DEFINE$1=(int)(182);
    // JavaLine 408 <== SourceLine 242
    public final int S_CASE$1=(int)(183);
    public final int S_WHEN$1=(int)(184);
    public final int S_OTHERWISE$1=(int)(185);
    public final int S_ENDCASE$1=(int)(186);
    // JavaLine 413 <== SourceLine 243
    public final int S_VISIBLE$1=(int)(187);
    public final int S_ASSERT$1=(int)(188);
    public final int S_SKIP$1=(int)(189);
    // JavaLine 417 <== SourceLine 244
    public final int N_KEYW$1=(int)(189);
    // JavaLine 419 <== SourceLine 248
    public final int S_INTVAL$1=(int)(190);
    public final int S_REALVAL$1=(int)(191);
    public final int S_LREALVAL$1=(int)(192);
    public final int S_STRING$1=(int)(193);
    // JavaLine 424 <== SourceLine 249
    public final int S_COLON$1=(int)(194);
    public final int S_LPAR$1=(int)(195);
    public final int S_RPAR$1=(int)(196);
    public final int S_COMMA$1=(int)(197);
    // JavaLine 429 <== SourceLine 250
    public final int S_DOT$1=(int)(198);
    public final int S_ADDRESS$1=(int)(199);
    public final int S_CHARS$1=(int)(200);
    public final int S_PERCENT$1=(int)(201);
    // JavaLine 434 <== SourceLine 254
    public final int S_TRACE$1=(int)(202);
    public final int S_NOEXPR$1=(int)(203);
    public final int S_VARID$1=(int)(204);
    public final int S_VAREXPR$1=(int)(205);
    // JavaLine 439 <== SourceLine 255
    public final int S_VARCALL$1=(int)(206);
    public final int S_ARGLIST$1=(int)(207);
    public final int S_ENDVAR$1=(int)(208);
    public final int S_IFEXPR$1=(int)(209);
    // JavaLine 444 <== SourceLine 256
    public final int S_REPEXPR$1=(int)(210);
    public final int S_DEFLAB$1=(int)(211);
    public final int S_STRUCT$1=(int)(212);
    public final int S_ENDWHEN$1=(int)(213);
    // JavaLine 449 <== SourceLine 257
    public final int S_SIMPLE$1=(int)(214);
    public final int S_DOTVAR$1=(int)(215);
    // JavaLine 452 <== SourceLine 258
    public final int S_IDENT$1=(int)(216);
    // JavaLine 454 <== SourceLine 259
    public final int N_SYMB$1=(int)(216);
    // JavaLine 456 <== SourceLine 260
    public final int S_MXMX$1=(int)(216);
    // JavaLine 458 <== SourceLine 264
    public final int M_NULL$1=(int)(0);
    // JavaLine 460 <== SourceLine 265
    public final int M_MODULE$1=(int)(1);
    public final int M_MACRO$1=(int)(2);
    public final int M_MARK$1=(int)(3);
    public final int M_MPAR$1=(int)(4);
    // JavaLine 465 <== SourceLine 266
    public final int M_ENDMACRO$1=(int)(5);
    public final int M_DEFINE$1=(int)(6);
    public final int M_INTEGER$1=(int)(7);
    public final int M_SHORT$1=(int)(8);
    // JavaLine 470 <== SourceLine 267
    public final int M_RANGE$1=(int)(9);
    public final int M_STRUCT$1=(int)(10);
    public final int M_REAL$1=(int)(11);
    public final int M_LONG$1=(int)(12);
    // JavaLine 475 <== SourceLine 268
    public final int M_SIZE$1=(int)(13);
    public final int M_CHAR$1=(int)(14);
    public final int M_BOOL$1=(int)(15);
    public final int M_LABEL$1=(int)(16);
    // JavaLine 480 <== SourceLine 269
    public final int M_REF$1=(int)(17);
    public final int M_ENTRY$1=(int)(18);
    public final int M_FIELD$1=(int)(19);
    public final int M_NAME$1=(int)(20);
    // JavaLine 485 <== SourceLine 270
    public final int M_VAR$1=(int)(21);
    public final int M_LABSPEC$1=(int)(22);
    public final int M_RECORD$1=(int)(23);
    public final int M_ALT$1=(int)(24);
    // JavaLine 490 <== SourceLine 271
    public final int M_ENDRECORD$1=(int)(25);
    public final int M_GLOBAL$1=(int)(26);
    public final int M_PROFILE$1=(int)(27);
    public final int M_IMPORT$1=(int)(28);
    // JavaLine 495 <== SourceLine 272
    public final int M_EXPORT$1=(int)(29);
    public final int M_EXIT$1=(int)(30);
    public final int M_BODY$1=(int)(31);
    public final int M_SYSRUT$1=(int)(32);
    // JavaLine 500 <== SourceLine 273
    public final int M_KNOWN$1=(int)(33);
    public final int M_EXTERNAL$1=(int)(34);
    public final int M_ROUTINE$1=(int)(35);
    public final int M_END$1=(int)(36);
    // JavaLine 505 <== SourceLine 274
    public final int M_MXMX$1=(int)(36);
    // JavaLine 507 <== SourceLine 401
    public final int maxTypes$1=(int)(255);
    // JavaLine 509 <== SourceLine 402
    public ARRAY$<Common$TypeNotice[]>typeTable=null;
    // JavaLine 511 <== SourceLine 404
    public int nTypes$1=0;
    public Common$TypeSet infixTypes$1=null;
    public Common$TypeSet integerTypes$1=null;
    public Common$TypeSet structTypes$1=null;
    // JavaLine 516 <== SourceLine 407
    public Common$TypeSet entTypes$1=null;
    public Common$TypeSet refTypes$1=null;
    public Common$TypeSet fieldTypes$1=null;
    public Common$TypeSet nameTypes$1=null;
    // JavaLine 521 <== SourceLine 571
    public Common$seqtag taglist$1=null;
    // JavaLine 523 <== SourceLine 1083
    public PrintFile$ inspect$1083$19$1=null;
    // Normal Constructor
    public Common(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        // JavaLine 530 <== SourceLine 28
        int[] symtab$LB=new int[1]; int[] symtab$UB=new int[1];
        symtab$LB[0]=0; symtab$UB[0]=MAX_SYMB$1;
        BOUND_CHECK$(symtab$LB[0],symtab$UB[0]);
        symtab=new ARRAY$<Common$symbolbox[]>(new Common$symbolbox[symtab$UB[0]-symtab$LB[0]+1],symtab$LB,symtab$UB);
        // JavaLine 535 <== SourceLine 93
        int[] option$LB=new int[1]; int[] option$UB=new int[1];
        option$LB[0]=0; option$UB[0]=95;
        BOUND_CHECK$(option$LB[0],option$UB[0]);
        option=new ARRAY$<int[]>(new int[option$UB[0]-option$LB[0]+1],option$LB,option$UB);
        // JavaLine 540 <== SourceLine 146
        int[] Selector$LB=new int[1]; int[] Selector$UB=new int[1];
        Selector$LB[0]=0; Selector$UB[0]=127;
        BOUND_CHECK$(Selector$LB[0],Selector$UB[0]);
        Selector=new ARRAY$<boolean[]>(new boolean[Selector$UB[0]-Selector$LB[0]+1],Selector$LB,Selector$UB);
        // JavaLine 545 <== SourceLine 165
        int[] tagtab$LB=new int[1]; int[] tagtab$UB=new int[1];
        tagtab$LB[0]=0; tagtab$UB[0]=2000;
        BOUND_CHECK$(tagtab$LB[0],tagtab$UB[0]);
        tagtab=new ARRAY$<Common$symbolbox[]>(new Common$symbolbox[tagtab$UB[0]-tagtab$LB[0]+1],tagtab$LB,tagtab$UB);
        // JavaLine 550 <== SourceLine 402
        int[] typeTable$LB=new int[1]; int[] typeTable$UB=new int[1];
        typeTable$LB[0]=0; typeTable$UB[0]=maxTypes$1;
        BOUND_CHECK$(typeTable$LB[0],typeTable$UB[0]);
        typeTable=new ARRAY$<Common$TypeNotice[]>(new Common$TypeNotice[typeTable$UB[0]-typeTable$LB[0]+1],typeTable$LB,typeTable$UB);
    }
    // Class Statements
    public Common STM$() {
        // Class Simset: Code before inner
        // JavaLine 559 <== SourceLine 1039
        // Class Common: Code before inner
        // JavaLine 561 <== SourceLine 1402
        new Common$SubBlock1039((CUR$)).STM$();
        // JavaLine 563 <== SourceLine 1398
        ;
        // JavaLine 565 <== SourceLine 1039
        // Class Common: Code after inner
        EBLK();
        return(this);
    } // End of Class Statements
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Class Common",1,2,10,14,12,15,14,20,16,22,19,23,21,24,23,27,25,28,27,29,29,31,31,93,33,99,35,100,37,101,39,102,41,103,43,104,47,105,49,106,51,107,53,108,55,109,57,110,59,111,61,112,63,113,65,114,67,115,69,116,71,117,73,118,76,119,78,120,80,121,82,123,84,124,86,125,88,127,90,128,92,129,94,130,96,131,98,133,100,134,102,136,104,138,106,139,108,140,110,141,112,142,114,143,116,144,118,146,120,165,122,167,126,168,130,169,132,170,135,172,139,173,143,174,147,175,151,177,153,178,158,179,163,180,168,181,171,186,174,187,176,188,179,189,181,190,183,191,188,192,193,193,198,194,203,195,208,196,213,197,218,198,223,199,228,200,233,201,238,202,243,203,248,204,253,205,257,206,259,207,264,208,269,209,274,210,279,211,284,212,289,213,294,214,299,215,304,216,309,217,314,218,319,219,324,220,329,221,334,222,337,223,339,224,342,225,347,226,352,227,357,228,362,229,367,230,371,231,373,235,378,236,383,237,388,238,393,239,398,240,403,241,408,242,413,243,417,244,419,248,424,249,429,250,434,254,439,255,444,256,449,257,452,258,454,259,456,260,458,264,460,265,465,266,470,267,475,268,480,269,485,270,490,271,495,272,500,273,505,274,507,401,509,402,511,404,516,407,521,571,523,1083,530,28,535,93,540,146,545,165,550,402,559,1039,561,1402,563,1398,565,1039,569,1403);
} // End of Class
