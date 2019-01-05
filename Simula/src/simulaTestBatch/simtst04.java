// JavaLine 1 ==> SourceLine 29
package simulaTestBatch;
// Release-Beta-0.3 Compiled at Fri Jan 04 18:19:54 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst04 extends BASICIO$ {
    // SubBlock: BlockKind=SimulaProgram, BlockLevel=1, firstLine=29, lastLine=402, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int found_error=0;
    // JavaLine 11 ==> SourceLine 30
    boolean verbose=false;
    // JavaLine 13 ==> SourceLine 32
    TXT$ txt=null;
    // JavaLine 15 ==> SourceLine 35
    int intr=0;
    // JavaLine 17 ==> SourceLine 36
    int sho=0;
    // JavaLine 19 ==> SourceLine 37
    float rea=0.0f;
    // JavaLine 21 ==> SourceLine 38
    double lon=0.0d;
    // JavaLine 23 ==> SourceLine 40
    int realprecision=0;
    // JavaLine 25 ==> SourceLine 41
    int longprecision=0;
    // Normal Constructor
    public simtst04(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst04");
        // Declaration Code
        TRACE_BEGIN_DCL$("simtst04",56);
    } // End of Constructor
    // SimulaProgram Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("simtst04",56);
        // JavaLine 38 ==> SourceLine 61
        if(verbose) {
            // JavaLine 40 ==> SourceLine 62
            {
                TRACE_BEGIN_STM$("CompoundStatement62",62);
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 4"));
                // JavaLine 44 ==> SourceLine 63
                sysout().outimage();
                // JavaLine 46 ==> SourceLine 64
                sysout().outtext(new TXT$("--- Test reading numbers from source text"));
                // JavaLine 48 ==> SourceLine 65
                sysout().outimage();
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement62",65);
            }
        }
        // JavaLine 54 ==> SourceLine 68
        txt=blanks(30);
        // JavaLine 56 ==> SourceLine 70
        realprecision=7;
        // JavaLine 58 ==> SourceLine 73
        longprecision=16;
        // JavaLine 60 ==> SourceLine 75
        TXT$.putint(txt,realprecision);
        // JavaLine 62 ==> SourceLine 76
        new simtst04$test(((simtst04)CUR$),new TXT$("integer operation (1)."),txt,new TXT$("                             7"));
        // JavaLine 64 ==> SourceLine 78
        TXT$.putint(txt,longprecision);
        // JavaLine 66 ==> SourceLine 80
        new simtst04$test(((simtst04)CUR$),new TXT$("integer operation (2)."),txt,new TXT$("                            16"));
        // JavaLine 68 ==> SourceLine 85
        intr=123456;
        // JavaLine 70 ==> SourceLine 86
        TXT$.putint(txt,intr);
        // JavaLine 72 ==> SourceLine 87
        new simtst04$test(((simtst04)CUR$),new TXT$("integer operation (3)."),txt,new TXT$("                        123456"));
        // JavaLine 74 ==> SourceLine 89
        intr=((ENVIRONMENT$)CTX$).maxint;
        // JavaLine 76 ==> SourceLine 90
        TXT$.putint(txt,intr);
        // JavaLine 78 ==> SourceLine 91
        new simtst04$test(((simtst04)CUR$),new TXT$("integer operation (4)."),txt,new TXT$("                    2147483647"));
        // JavaLine 80 ==> SourceLine 93
        TXT$.putint(txt,(+(0)));
        // JavaLine 82 ==> SourceLine 94
        new simtst04$test(((simtst04)CUR$),new TXT$("integer operation (6)."),txt,new TXT$("                             0"));
        // JavaLine 84 ==> SourceLine 96
        intr=((ENVIRONMENT$)CTX$).minint;
        // JavaLine 86 ==> SourceLine 97
        TXT$.putint(txt,intr);
        // JavaLine 88 ==> SourceLine 98
        new simtst04$test(((simtst04)CUR$),new TXT$("integer operation (7)."),txt,new TXT$("                   -2147483648"));
        // JavaLine 90 ==> SourceLine 100
        TXT$.putint(txt,(-(0)));
        // JavaLine 92 ==> SourceLine 101
        new simtst04$test(((simtst04)CUR$),new TXT$("integer operation (8)."),txt,new TXT$("                             0"));
        // JavaLine 94 ==> SourceLine 107
        TXT$.putint(txt,sho);
        // JavaLine 96 ==> SourceLine 108
        new simtst04$test(((simtst04)CUR$),new TXT$("short integer operation (1)."),txt,new TXT$("                             0"));
        // JavaLine 98 ==> SourceLine 110
        sho=32767;
        // JavaLine 100 ==> SourceLine 111
        TXT$.putint(txt,sho);
        // JavaLine 102 ==> SourceLine 114
        new simtst04$test(((simtst04)CUR$),new TXT$("short integer operation (2)."),txt,new TXT$("                         32767"));
        // JavaLine 104 ==> SourceLine 116
        sho=(+(13));
        // JavaLine 106 ==> SourceLine 117
        TXT$.putint(txt,sho);
        // JavaLine 108 ==> SourceLine 118
        new simtst04$test(((simtst04)CUR$),new TXT$("short integer operation (4)."),txt,new TXT$("                            13"));
        // JavaLine 110 ==> SourceLine 120
        sho=(-(32768));
        // JavaLine 112 ==> SourceLine 121
        TXT$.putint(txt,sho);
        // JavaLine 114 ==> SourceLine 123
        new simtst04$test(((simtst04)CUR$),new TXT$("short integer operation (5)."),txt,new TXT$("                        -32768"));
        // JavaLine 116 ==> SourceLine 129
        rea=((float)(123456));
        // JavaLine 118 ==> SourceLine 130
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 120 ==> SourceLine 131
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (1)."),txt,new TXT$("                  1.234560&+05"));
        // JavaLine 122 ==> SourceLine 138
        rea=3.4028235E38f;
        // JavaLine 124 ==> SourceLine 141
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 126 ==> SourceLine 142
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (2)."),txt,new TXT$("                  3.402823&+38"));
        // JavaLine 128 ==> SourceLine 144
        rea=((float)((-(3))));
        // JavaLine 130 ==> SourceLine 145
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 132 ==> SourceLine 146
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (3)."),txt,new TXT$("                 -3.000000&+00"));
        // JavaLine 134 ==> SourceLine 148
        rea=0.8888889f;
        // JavaLine 136 ==> SourceLine 149
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 138 ==> SourceLine 150
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (4)."),txt,new TXT$("                  8.888889&-01"));
        // JavaLine 140 ==> SourceLine 152
        rea=(+(0.0f));
        // JavaLine 142 ==> SourceLine 153
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 144 ==> SourceLine 154
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (5)."),txt,new TXT$("                  0.000000&+00"));
        // JavaLine 146 ==> SourceLine 161
        rea=(-(1.192093E-7f));
        // JavaLine 148 ==> SourceLine 164
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 150 ==> SourceLine 165
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (6)."),txt,new TXT$("                 -1.192093&-07"));
        // JavaLine 152 ==> SourceLine 167
        rea=0.0f;
        // JavaLine 154 ==> SourceLine 168
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 156 ==> SourceLine 169
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (7)."),txt,new TXT$("                  0.000000&+00"));
        // JavaLine 158 ==> SourceLine 171
        rea=(+(1235.0f));
        // JavaLine 160 ==> SourceLine 172
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 162 ==> SourceLine 173
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (8)."),txt,new TXT$("                  1.235000&+03"));
        // JavaLine 164 ==> SourceLine 180
        rea=(-(3.4028235E38f));
        // JavaLine 166 ==> SourceLine 183
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 168 ==> SourceLine 184
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (9)."),txt,new TXT$("                 -3.402823&+38"));
        // JavaLine 170 ==> SourceLine 186
        rea=1000.0f;
        // JavaLine 172 ==> SourceLine 187
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 174 ==> SourceLine 188
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (10)."),txt,new TXT$("                  1.000000&+03"));
        // JavaLine 176 ==> SourceLine 190
        TXT$.putreal(txt,1.0E20f,realprecision);
        // JavaLine 178 ==> SourceLine 191
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (11)."),txt,new TXT$("                  1.000000&+20"));
        // JavaLine 180 ==> SourceLine 193
        rea=1.0f;
        // JavaLine 182 ==> SourceLine 194
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 184 ==> SourceLine 195
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (12)."),txt,new TXT$("                  1.000000&+00"));
        // JavaLine 186 ==> SourceLine 197
        TXT$.putreal(txt,(+(1000000.0f)),realprecision);
        // JavaLine 188 ==> SourceLine 198
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (13)."),txt,new TXT$("                  1.000000&+06"));
        // JavaLine 190 ==> SourceLine 200
        rea=(+(10.0f));
        // JavaLine 192 ==> SourceLine 201
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 194 ==> SourceLine 202
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (14)."),txt,new TXT$("                  1.000000&+01"));
        // JavaLine 196 ==> SourceLine 204
        TXT$.putreal(txt,(+(1.0E-37f)),realprecision);
        // JavaLine 198 ==> SourceLine 205
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (15)."),txt,new TXT$("                  1.000000&-37"));
        // JavaLine 200 ==> SourceLine 207
        rea=(-(100.0f));
        // JavaLine 202 ==> SourceLine 208
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 204 ==> SourceLine 209
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (16)."),txt,new TXT$("                 -1.000000&+02"));
        // JavaLine 206 ==> SourceLine 211
        rea=(-(1.0E35f));
        // JavaLine 208 ==> SourceLine 212
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 210 ==> SourceLine 213
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (17)."),txt,new TXT$("                 -1.000000&+35"));
        // JavaLine 212 ==> SourceLine 215
        rea=(-(0.01f));
        // JavaLine 214 ==> SourceLine 216
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 216 ==> SourceLine 217
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (18)."),txt,new TXT$("                 -1.000000&-02"));
        // JavaLine 218 ==> SourceLine 223
        TXT$.putreal(txt,3.4028235E38f,realprecision);
        // JavaLine 220 ==> SourceLine 224
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (19)."),txt,new TXT$("                  3.402823&+38"));
        // JavaLine 222 ==> SourceLine 226
        rea=1.23456794E9f;
        // JavaLine 224 ==> SourceLine 227
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 226 ==> SourceLine 228
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (20)."),txt,new TXT$("                  1.234568&+09"));
        // JavaLine 228 ==> SourceLine 230
        rea=3.333E-5f;
        // JavaLine 230 ==> SourceLine 231
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 232 ==> SourceLine 232
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (21)."),txt,new TXT$("                  3.333000&-05"));
        // JavaLine 234 ==> SourceLine 234
        rea=(+(2.2222223E-38f));
        // JavaLine 236 ==> SourceLine 235
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 238 ==> SourceLine 236
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (22)."),txt,new TXT$("                  2.222222&-38"));
        // JavaLine 240 ==> SourceLine 238
        rea=(+(5.5555556E7f));
        // JavaLine 242 ==> SourceLine 239
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 244 ==> SourceLine 240
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (23)."),txt,new TXT$("                  5.555556&+07"));
        // JavaLine 246 ==> SourceLine 242
        rea=(-(1.0E12f));
        // JavaLine 248 ==> SourceLine 243
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 250 ==> SourceLine 244
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (24)."),txt,new TXT$("                 -1.000000&+12"));
        // JavaLine 252 ==> SourceLine 246
        rea=(-(0.0f));
        // JavaLine 254 ==> SourceLine 247
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 256 ==> SourceLine 248
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (25)."),txt,new TXT$("                  0.000000&+00"));
        // JavaLine 258 ==> SourceLine 250
        rea=3333333.2f;
        // JavaLine 260 ==> SourceLine 251
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 262 ==> SourceLine 252
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (26)."),txt,new TXT$("                  3.333333&+06"));
        // JavaLine 264 ==> SourceLine 254
        rea=7.777778E-11f;
        // JavaLine 266 ==> SourceLine 255
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 268 ==> SourceLine 256
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (27)."),txt,new TXT$("                  7.777778&-11"));
        // JavaLine 270 ==> SourceLine 258
        rea=(+(1.1111111E-5f));
        // JavaLine 272 ==> SourceLine 259
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 274 ==> SourceLine 260
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (28)."),txt,new TXT$("                  1.111111&-05"));
        // JavaLine 276 ==> SourceLine 262
        rea=(-(0.6666667f));
        // JavaLine 278 ==> SourceLine 263
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 280 ==> SourceLine 264
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (29)."),txt,new TXT$("                 -6.666667&-01"));
        // JavaLine 282 ==> SourceLine 272
        rea=1.192093E-9f;
        // JavaLine 284 ==> SourceLine 273
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 286 ==> SourceLine 274
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (30)."),txt,new TXT$("                  1.192093&-09"));
        // JavaLine 288 ==> SourceLine 276
        rea=0.0f;
        // JavaLine 290 ==> SourceLine 277
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 292 ==> SourceLine 278
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (31)."),txt,new TXT$("                  0.000000&+00"));
        // JavaLine 294 ==> SourceLine 280
        rea=1.2345678E32f;
        // JavaLine 296 ==> SourceLine 281
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 298 ==> SourceLine 282
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (32)."),txt,new TXT$("                  1.234568&+32"));
        // JavaLine 300 ==> SourceLine 284
        rea=(+(1.1111112f));
        // JavaLine 302 ==> SourceLine 285
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 304 ==> SourceLine 286
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (33)."),txt,new TXT$("                  1.111111&+00"));
        // JavaLine 306 ==> SourceLine 288
        rea=(+(1.2345679E-6f));
        // JavaLine 308 ==> SourceLine 289
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 310 ==> SourceLine 290
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (34)."),txt,new TXT$("                  1.234568&-06"));
        // JavaLine 312 ==> SourceLine 297
        rea=(-(3.4028235E38f));
        // JavaLine 314 ==> SourceLine 298
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 316 ==> SourceLine 299
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (35)."),txt,new TXT$("                 -3.402823&+38"));
        // JavaLine 318 ==> SourceLine 301
        rea=(-(300000.0f));
        // JavaLine 320 ==> SourceLine 302
        TXT$.putreal(txt,rea,realprecision);
        // JavaLine 322 ==> SourceLine 303
        new simtst04$test(((simtst04)CUR$),new TXT$("real operation (36)."),txt,new TXT$("                 -3.000000&+05"));
        // JavaLine 324 ==> SourceLine 308
        lon=1.2345678912345678E16d;
        // JavaLine 326 ==> SourceLine 309
        TXT$.putreal(txt,lon,longprecision);
        // JavaLine 328 ==> SourceLine 310
        new simtst04$test(((simtst04)CUR$),new TXT$("long real operation (1)."),txt,new TXT$("        1.234567891234568&+016"));
        // JavaLine 330 ==> SourceLine 317
        lon=1.797693134862315E308d;
        // JavaLine 332 ==> SourceLine 320
        TXT$.putreal(txt,lon,longprecision);
        // JavaLine 334 ==> SourceLine 321
        new simtst04$test(((simtst04)CUR$),new TXT$("long real operation (2)."),txt,new TXT$("        1.797693134862315&+308"));
        // JavaLine 336 ==> SourceLine 323
        TXT$.putreal(txt,0.8888888888888888d,longprecision);
        // JavaLine 338 ==> SourceLine 324
        new simtst04$test(((simtst04)CUR$),new TXT$("long real operation (3)."),txt,new TXT$("        8.888888888888888&-001"));
        // JavaLine 340 ==> SourceLine 326
        lon=((double)(0));
        // JavaLine 342 ==> SourceLine 327
        TXT$.putreal(txt,lon,longprecision);
        // JavaLine 344 ==> SourceLine 328
        new simtst04$test(((simtst04)CUR$),new TXT$("long real operation (4)."),txt,new TXT$("        0.000000000000000&+000"));
        // JavaLine 346 ==> SourceLine 335
        lon=(-(2.220446049250313E-18d));
        // JavaLine 348 ==> SourceLine 338
        TXT$.putreal(txt,lon,longprecision);
        // JavaLine 350 ==> SourceLine 339
        new simtst04$test(((simtst04)CUR$),new TXT$("long real operation (5)."),txt,new TXT$("       -2.220446049250313&-018"));
        // JavaLine 352 ==> SourceLine 341
        lon=(+(1234.999999991111d));
        // JavaLine 354 ==> SourceLine 342
        TXT$.putreal(txt,lon,longprecision);
        // JavaLine 356 ==> SourceLine 343
        new simtst04$test(((simtst04)CUR$),new TXT$("long real operation (6)."),txt,new TXT$("        1.234999999991111&+003"));
        // JavaLine 358 ==> SourceLine 345
        lon=1000.0d;
        // JavaLine 360 ==> SourceLine 346
        TXT$.putreal(txt,lon,longprecision);
        // JavaLine 362 ==> SourceLine 347
        new simtst04$test(((simtst04)CUR$),new TXT$("long real operation (7)."),txt,new TXT$("        1.000000000000000&+003"));
        // JavaLine 364 ==> SourceLine 349
        TXT$.putreal(txt,(+(1.0d)),longprecision);
        // JavaLine 366 ==> SourceLine 350
        new simtst04$test(((simtst04)CUR$),new TXT$("long real operation (8)."),txt,new TXT$("        1.000000000000000&+000"));
        // JavaLine 368 ==> SourceLine 352
        lon=(+(10.0d));
        // JavaLine 370 ==> SourceLine 353
        TXT$.putreal(txt,lon,longprecision);
        // JavaLine 372 ==> SourceLine 354
        new simtst04$test(((simtst04)CUR$),new TXT$("long real operation (9)."),txt,new TXT$("        1.000000000000000&+001"));
        // JavaLine 374 ==> SourceLine 362
        TXT$.putreal(txt,1.797693134862315E308d,longprecision);
        // JavaLine 376 ==> SourceLine 363
        new simtst04$test(((simtst04)CUR$),new TXT$("long real operation (10)."),txt,new TXT$("        1.797693134862315&+308"));
        // JavaLine 378 ==> SourceLine 365
        lon=1.23456789123456794E18d;
        // JavaLine 380 ==> SourceLine 366
        TXT$.putreal(txt,lon,longprecision);
        // JavaLine 382 ==> SourceLine 367
        new simtst04$test(((simtst04)CUR$),new TXT$("long real operation (11)."),txt,new TXT$("        1.234567891234568&+018"));
        // JavaLine 384 ==> SourceLine 369
        lon=(-(1.0E22d));
        // JavaLine 386 ==> SourceLine 370
        TXT$.putreal(txt,lon,longprecision);
        // JavaLine 388 ==> SourceLine 371
        new simtst04$test(((simtst04)CUR$),new TXT$("long real operation (12)."),txt,new TXT$("       -1.000000000000000&+022"));
        // JavaLine 390 ==> SourceLine 373
        lon=7.0E-11d;
        // JavaLine 392 ==> SourceLine 374
        TXT$.putreal(txt,lon,longprecision);
        // JavaLine 394 ==> SourceLine 375
        new simtst04$test(((simtst04)CUR$),new TXT$("long real operation (13)."),txt,new TXT$("        7.000000000000000&-011"));
        // JavaLine 396 ==> SourceLine 377
        lon=(+(1.1111111111111112E-5d));
        // JavaLine 398 ==> SourceLine 378
        TXT$.putreal(txt,lon,longprecision);
        // JavaLine 400 ==> SourceLine 379
        new simtst04$test(((simtst04)CUR$),new TXT$("long real operation (14)."),txt,new TXT$("        1.111111111111111&-005"));
        // JavaLine 402 ==> SourceLine 381
        lon=1.234567891111111E32d;
        // JavaLine 404 ==> SourceLine 382
        TXT$.putreal(txt,lon,longprecision);
        // JavaLine 406 ==> SourceLine 383
        new simtst04$test(((simtst04)CUR$),new TXT$("long real operation (15)."),txt,new TXT$("        1.234567891111111&+032"));
        // JavaLine 408 ==> SourceLine 390
        lon=(-(1.797693134862315E308d));
        // JavaLine 410 ==> SourceLine 391
        TXT$.putreal(txt,lon,longprecision);
        // JavaLine 412 ==> SourceLine 392
        new simtst04$test(((simtst04)CUR$),new TXT$("long real operation (16)."),txt,new TXT$("       -1.797693134862315&+308"));
        // JavaLine 414 ==> SourceLine 395
        if((found_error>(0))) {
            sysout().outint(found_error,4);
        } else
        sysout().outtext(new TXT$("--- NO"));
        // JavaLine 419 ==> SourceLine 396
        sysout().outtext(new TXT$(" ERRORS FOUND IN TEST 4"));
        // JavaLine 421 ==> SourceLine 397
        if(verbose) {
            // JavaLine 423 ==> SourceLine 398
            {
                TRACE_BEGIN_STM$("CompoundStatement398",398);
                sysout().outtext(new TXT$("--- END Simula a.s. TEST 4"));
                // JavaLine 427 ==> SourceLine 399
                sysout().outimage();
                TRACE_END_STM$("CompoundStatement398",399);
            }
        }
        TRACE_END_STM$("simtst04",399);
        EBLK();
        return(null);
    } // End of SimulaProgram Statements
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst04(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst04.sim","SimulaProgram simtst04",1,29,11,30,13,32,15,35,17,36,19,37,21,38,23,40,25,41,38,61,40,62,44,63,46,64,48,65,54,68,56,70,58,73,60,75,62,76,64,78,66,80,68,85,70,86,72,87,74,89,76,90,78,91,80,93,82,94,84,96,86,97,88,98,90,100,92,101,94,107,96,108,98,110,100,111,102,114,104,116,106,117,108,118,110,120,112,121,114,123,116,129,118,130,120,131,122,138,124,141,126,142,128,144,130,145,132,146,134,148,136,149,138,150,140,152,142,153,144,154,146,161,148,164,150,165,152,167,154,168,156,169,158,171,160,172,162,173,164,180,166,183,168,184,170,186,172,187,174,188,176,190,178,191,180,193,182,194,184,195,186,197,188,198,190,200,192,201,194,202,196,204,198,205,200,207,202,208,204,209,206,211,208,212,210,213,212,215,214,216,216,217,218,223,220,224,222,226,224,227,226,228,228,230,230,231,232,232,234,234,236,235,238,236,240,238,242,239,244,240,246,242,248,243,250,244,252,246,254,247,256,248,258,250,260,251,262,252,264,254,266,255,268,256,270,258,272,259,274,260,276,262,278,263,280,264,282,272,284,273,286,274,288,276,290,277,292,278,294,280,296,281,298,282,300,284,302,285,304,286,306,288,308,289,310,290,312,297,314,298,316,299,318,301,320,302,322,303,324,308,326,309,328,310,330,317,332,320,334,321,336,323,338,324,340,326,342,327,344,328,346,335,348,338,350,339,352,341,354,342,356,343,358,345,360,346,362,347,364,349,366,350,368,352,370,353,372,354,374,362,376,363,378,365,380,366,382,367,384,369,386,370,388,371,390,373,392,374,394,375,396,377,398,378,400,379,402,381,404,382,406,383,408,390,410,391,412,392,414,395,419,396,421,397,423,398,427,399,440,402);
}
