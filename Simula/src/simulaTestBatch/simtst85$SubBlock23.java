// JavaLine 1 ==> SourceLine 23
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Feb 17 13:27:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst85$SubBlock23 extends BASICIO$ {
    // SubBlock: BlockKind=SubBlock, BlockLevel=2, firstLine=23, lastLine=299, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare locals as attributes
    int i=0;
    int j=0;
    float tmp=0.0f;
    // Normal Constructor
    public simtst85$SubBlock23(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("SubBlock23",37);
    } // End of Constructor
    // SubBlock Statements
    public RTObject$ STM$() {
        TRACE_BEGIN_STM$("SubBlock23",37);
        // JavaLine 23 ==> SourceLine 40
        ((simtst85)(CUR$.SL$)).inspect$21$0.setaccess(new TXT$("CHARSET:UTF-80"));
        // JavaLine 25 ==> SourceLine 41
        ((simtst85)(CUR$.SL$)).inspect$21$0.setaccess(new TXT$("CHARSET:UTF-8"));
        // JavaLine 27 ==> SourceLine 42
        ((simtst85)(CUR$.SL$)).inspect$21$0.setaccess(new TXT$("CREATE"));
        // JavaLine 29 ==> SourceLine 43
        ((simtst85)(CUR$.SL$)).inspect$21$0.open(blanks(12));
        // JavaLine 31 ==> SourceLine 45
        sysout().outint(TXT$.length(((simtst85)(CUR$.SL$)).inspect$21$0.image),3);
        // JavaLine 33 ==> SourceLine 46
        sysout().outint(TXT$.pos(((simtst85)(CUR$.SL$)).inspect$21$0.image),3);
        // JavaLine 35 ==> SourceLine 47
        sysout().outint(((simtst85)(CUR$.SL$)).inspect$21$0.location(),3);
        // JavaLine 37 ==> SourceLine 49
        new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$(" 12  1  1"),new TXT$("IMAGE.LENGTH, IMAGE.POS and LOCATION after OPEN"),9);
        // JavaLine 39 ==> SourceLine 51
        for(boolean CB$51:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(5); }})
           )) { if(!CB$51) continue;
        // JavaLine 43 ==> SourceLine 53
        {
            TRACE_BEGIN_STM$("CompoundStatement53",53);
            ((simtst85)(CUR$.SL$)).inspect$21$0.locate((6-(i)));
            // JavaLine 47 ==> SourceLine 54
            ((simtst85)(CUR$.SL$)).inspect$21$0.setpos(9);
            // JavaLine 49 ==> SourceLine 55
            ((simtst85)(CUR$.SL$)).inspect$21$0.outint(i,4);
            // JavaLine 51 ==> SourceLine 57
            ((simtst85)(CUR$.SL$)).inspect$21$0.outimage();
            TRACE_END_STM$("CompoundStatement53",57);
        }
    }
    // JavaLine 56 ==> SourceLine 59
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(2);
    // JavaLine 58 ==> SourceLine 60
    sysout().outint(((simtst85)(CUR$.SL$)).inspect$21$0.location(),3);
    // JavaLine 60 ==> SourceLine 61
    ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
    // JavaLine 62 ==> SourceLine 62
    sysout().outint(((simtst85)(CUR$.SL$)).inspect$21$0.inint(),3);
    // JavaLine 64 ==> SourceLine 63
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(5);
    // JavaLine 66 ==> SourceLine 64
    sysout().outint(((simtst85)(CUR$.SL$)).inspect$21$0.location(),3);
    // JavaLine 68 ==> SourceLine 65
    ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
    // JavaLine 70 ==> SourceLine 66
    sysout().outint(((simtst85)(CUR$.SL$)).inspect$21$0.inint(),3);
    // JavaLine 72 ==> SourceLine 67
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(3);
    // JavaLine 74 ==> SourceLine 68
    sysout().outint(((simtst85)(CUR$.SL$)).inspect$21$0.location(),3);
    // JavaLine 76 ==> SourceLine 69
    ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
    // JavaLine 78 ==> SourceLine 70
    sysout().outint(((simtst85)(CUR$.SL$)).inspect$21$0.inint(),3);
    // JavaLine 80 ==> SourceLine 72
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$("  2  4  5  1  3  3"),new TXT$("LOCATE, LOCATION and ININT"),18);
    // JavaLine 82 ==> SourceLine 75
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 84 ==> SourceLine 76
    ((simtst85)(CUR$.SL$)).inspect$21$0.setpos(13);
    // JavaLine 86 ==> SourceLine 77
    i=1;
    // JavaLine 88 ==> SourceLine 78
    while((i<=(5))) {
        // JavaLine 90 ==> SourceLine 80
        {
            TRACE_BEGIN_STM$("CompoundStatement80",80);
            sysout().outint(((simtst85)(CUR$.SL$)).inspect$21$0.inint(),5);
            // JavaLine 94 ==> SourceLine 81
            i=(i+(1));
            TRACE_END_STM$("CompoundStatement80",81);
        }
    }
    // JavaLine 99 ==> SourceLine 85
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$("    5    4    3    2    1"),new TXT$("Sequential ININT without INIMAGE"),25);
    // JavaLine 101 ==> SourceLine 87
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 103 ==> SourceLine 88
    ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
    // JavaLine 105 ==> SourceLine 89
    while((!(((simtst85)(CUR$.SL$)).inspect$21$0.lastitem()))) {
        sysout().outreal(((simtst85)(CUR$.SL$)).inspect$21$0.inreal(),1,7);
    }
    // JavaLine 109 ==> SourceLine 91
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$(" 5&+000 4&+000 3&+000 2&+000 1&+000"),new TXT$("INREAL and LASTITEM"),35);
    // JavaLine 111 ==> SourceLine 93
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 113 ==> SourceLine 94
    ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
    // JavaLine 115 ==> SourceLine 95
    while((!(((simtst85)(CUR$.SL$)).inspect$21$0.lastitem()))) {
        sysout().outint(((simtst85)(CUR$.SL$)).inspect$21$0.infrac(),10);
    }
    // JavaLine 119 ==> SourceLine 98
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$("         5         4         3         2         1"),new TXT$("INFRAC and LASTITEM"),50);
    // JavaLine 121 ==> SourceLine 100
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 123 ==> SourceLine 101
    ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
    // JavaLine 125 ==> SourceLine 102
    while((!(((simtst85)(CUR$.SL$)).inspect$21$0.lastitem()))) {
        sysout().outchar(((simtst85)(CUR$.SL$)).inspect$21$0.inchar());
    }
    // JavaLine 129 ==> SourceLine 104
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$("54321"),new TXT$("INCHAR and LASTITEM"),5);
    // JavaLine 131 ==> SourceLine 106
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 133 ==> SourceLine 107
    ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
    // JavaLine 135 ==> SourceLine 108
    while((!(((simtst85)(CUR$.SL$)).inspect$21$0.endfile()))) {
        // JavaLine 137 ==> SourceLine 110
        {
            TRACE_BEGIN_STM$("CompoundStatement110",110);
            sysout().outtext(((simtst85)(CUR$.SL$)).inspect$21$0.intext(12));
            // JavaLine 141 ==> SourceLine 111
            ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
            TRACE_END_STM$("CompoundStatement110",111);
        }
    }
    // JavaLine 146 ==> SourceLine 115
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$("           5           4           3           2           1"),new TXT$("INTEXT and ENDFILE"),60);
    // JavaLine 148 ==> SourceLine 138
    new simtst85$SubBlock23$SubBlock118(CUR$).STM$();
    // JavaLine 150 ==> SourceLine 140
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 152 ==> SourceLine 141
    TXT$.setpos(((simtst85)(CUR$.SL$)).inspect$21$0.image,1);
    // JavaLine 154 ==> SourceLine 142
    while((((simtst85)(CUR$.SL$)).inspect$21$0.location()<=(5))) {
        ((simtst85)(CUR$.SL$)).inspect$21$0.outint(((simtst85)(CUR$.SL$)).inspect$21$0.location(),3);
    }
    // JavaLine 158 ==> SourceLine 144
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 160 ==> SourceLine 145
    ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
    // JavaLine 162 ==> SourceLine 146
    sysout().outtext(((simtst85)(CUR$.SL$)).inspect$21$0.intext(60));
    // JavaLine 164 ==> SourceLine 149
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$("  1  1  1  1  1  2  2  2  2  3  3  3  3  4  4  4  4  5  5  5"),new TXT$("OUTINT and LOCATION"),60);
    // JavaLine 166 ==> SourceLine 151
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 168 ==> SourceLine 152
    TXT$.setpos(((simtst85)(CUR$.SL$)).inspect$21$0.image,1);
    // JavaLine 170 ==> SourceLine 154
    while((((simtst85)(CUR$.SL$)).inspect$21$0.location()<=(5))) {
        {
            TRACE_BEGIN_STM$("CompoundStatement154",154);
            tmp=((float)(((simtst85)(CUR$.SL$)).inspect$21$0.location()));
            ((simtst85)(CUR$.SL$)).inspect$21$0.outreal(tmp,1,6);
            TRACE_END_STM$("CompoundStatement154",154);
        }
    }
    // JavaLine 179 ==> SourceLine 156
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 181 ==> SourceLine 157
    ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
    // JavaLine 183 ==> SourceLine 158
    sysout().outtext(((simtst85)(CUR$.SL$)).inspect$21$0.intext(70));
    // JavaLine 185 ==> SourceLine 161
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$(" 1&+00 1&+00 1&+00 2&+00 2&+00 3&+00 3&+00 4&+00 4&+00 5&+00"),new TXT$("OUTREAL"),60);
    // JavaLine 187 ==> SourceLine 163
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 189 ==> SourceLine 164
    TXT$.setpos(((simtst85)(CUR$.SL$)).inspect$21$0.image,1);
    // JavaLine 191 ==> SourceLine 165
    while((((simtst85)(CUR$.SL$)).inspect$21$0.location()<=(5))) {
        ((simtst85)(CUR$.SL$)).inspect$21$0.outfix(((simtst85)(CUR$.SL$)).inspect$21$0.location(),3,6);
    }
    // JavaLine 195 ==> SourceLine 167
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 197 ==> SourceLine 168
    ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
    // JavaLine 199 ==> SourceLine 169
    sysout().outtext(((simtst85)(CUR$.SL$)).inspect$21$0.intext(60));
    // JavaLine 201 ==> SourceLine 172
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$(" 1.000 1.000 1.000 2.000 2.000 3.000 3.000 4.000 4.000 5.000"),new TXT$("OUTFIX"),60);
    // JavaLine 203 ==> SourceLine 174
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 205 ==> SourceLine 175
    TXT$.setpos(((simtst85)(CUR$.SL$)).inspect$21$0.image,1);
    // JavaLine 207 ==> SourceLine 176
    while((((simtst85)(CUR$.SL$)).inspect$21$0.location()<=(5))) {
        ((simtst85)(CUR$.SL$)).inspect$21$0.outfrac(((simtst85)(CUR$.SL$)).inspect$21$0.location(),4,12);
    }
    // JavaLine 211 ==> SourceLine 178
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 213 ==> SourceLine 179
    ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
    // JavaLine 215 ==> SourceLine 180
    sysout().outtext(((simtst85)(CUR$.SL$)).inspect$21$0.intext(60));
    // JavaLine 217 ==> SourceLine 183
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$("      .000 1      .000 1      .000 2      .000 3      .000 4"),new TXT$("OUTFRAC"),60);
    // JavaLine 219 ==> SourceLine 185
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 221 ==> SourceLine 186
    while((((simtst85)(CUR$.SL$)).inspect$21$0.location()<=(5))) {
        // JavaLine 223 ==> SourceLine 188
        {
            TRACE_BEGIN_STM$("CompoundStatement188",188);
            ((simtst85)(CUR$.SL$)).inspect$21$0.setpos(((simtst85)(CUR$.SL$)).inspect$21$0.location());
            // JavaLine 227 ==> SourceLine 189
            ((simtst85)(CUR$.SL$)).inspect$21$0.outchar('+');
            // JavaLine 229 ==> SourceLine 190
            ((simtst85)(CUR$.SL$)).inspect$21$0.outimage();
            TRACE_END_STM$("CompoundStatement188",190);
        }
    }
    // JavaLine 234 ==> SourceLine 193
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 236 ==> SourceLine 194
    ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
    // JavaLine 238 ==> SourceLine 195
    sysout().outtext(((simtst85)(CUR$.SL$)).inspect$21$0.intext(60));
    // JavaLine 240 ==> SourceLine 198
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$("+            +            +            +            +       "),new TXT$("OUTCHAR"),60);
    // JavaLine 242 ==> SourceLine 200
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 244 ==> SourceLine 201
    while((((simtst85)(CUR$.SL$)).inspect$21$0.location()<=(4))) {
        // JavaLine 246 ==> SourceLine 203
        {
            TRACE_BEGIN_STM$("CompoundStatement203",203);
            ((simtst85)(CUR$.SL$)).inspect$21$0.setpos(9);
            // JavaLine 250 ==> SourceLine 204
            ((simtst85)(CUR$.SL$)).inspect$21$0.outint(((simtst85)(CUR$.SL$)).inspect$21$0.location(),5);
            TRACE_END_STM$("CompoundStatement203",204);
        }
    }
    // JavaLine 255 ==> SourceLine 206
    ((simtst85)(CUR$.SL$)).inspect$21$0.outimage();
    // JavaLine 257 ==> SourceLine 208
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 259 ==> SourceLine 209
    ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
    // JavaLine 261 ==> SourceLine 210
    sysout().outtext(((simtst85)(CUR$.SL$)).inspect$21$0.intext(60));
    // JavaLine 263 ==> SourceLine 213
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$("                1           2           3           4       "),new TXT$("OUTINT with forced OUTIMAGE"),60);
    // JavaLine 265 ==> SourceLine 215
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 267 ==> SourceLine 216
    while((((simtst85)(CUR$.SL$)).inspect$21$0.location()<=(4))) {
        // JavaLine 269 ==> SourceLine 218
        {
            TRACE_BEGIN_STM$("CompoundStatement218",218);
            ((simtst85)(CUR$.SL$)).inspect$21$0.setpos(8);
            // JavaLine 273 ==> SourceLine 219
            ((simtst85)(CUR$.SL$)).inspect$21$0.outreal(((simtst85)(CUR$.SL$)).inspect$21$0.location(),1,6);
            TRACE_END_STM$("CompoundStatement218",219);
        }
    }
    // JavaLine 278 ==> SourceLine 221
    ((simtst85)(CUR$.SL$)).inspect$21$0.outimage();
    // JavaLine 280 ==> SourceLine 223
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 282 ==> SourceLine 224
    ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
    // JavaLine 284 ==> SourceLine 225
    sysout().outtext(((simtst85)(CUR$.SL$)).inspect$21$0.intext(60));
    // JavaLine 286 ==> SourceLine 228
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$("             1&+00       2&+00       3&+00       4&+00      "),new TXT$("OUTREAL with forced OUTIMAGE"),60);
    // JavaLine 288 ==> SourceLine 230
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 290 ==> SourceLine 231
    while((((simtst85)(CUR$.SL$)).inspect$21$0.location()<=(4))) {
        // JavaLine 292 ==> SourceLine 233
        {
            TRACE_BEGIN_STM$("CompoundStatement233",233);
            ((simtst85)(CUR$.SL$)).inspect$21$0.setpos(8);
            // JavaLine 296 ==> SourceLine 234
            ((simtst85)(CUR$.SL$)).inspect$21$0.outfix(((simtst85)(CUR$.SL$)).inspect$21$0.location(),3,6);
            TRACE_END_STM$("CompoundStatement233",234);
        }
    }
    // JavaLine 301 ==> SourceLine 236
    ((simtst85)(CUR$.SL$)).inspect$21$0.outimage();
    // JavaLine 303 ==> SourceLine 238
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 305 ==> SourceLine 239
    ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
    // JavaLine 307 ==> SourceLine 240
    sysout().outtext(((simtst85)(CUR$.SL$)).inspect$21$0.intext(60));
    // JavaLine 309 ==> SourceLine 243
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$("             1.000       2.000       3.000       4.000      "),new TXT$("OUTFIX with forced OUTIMAGE"),60);
    // JavaLine 311 ==> SourceLine 245
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 313 ==> SourceLine 246
    while((((simtst85)(CUR$.SL$)).inspect$21$0.location()<=(4))) {
        // JavaLine 315 ==> SourceLine 248
        {
            TRACE_BEGIN_STM$("CompoundStatement248",248);
            ((simtst85)(CUR$.SL$)).inspect$21$0.setpos(6);
            // JavaLine 319 ==> SourceLine 249
            ((simtst85)(CUR$.SL$)).inspect$21$0.outfrac(((simtst85)(CUR$.SL$)).inspect$21$0.location(),4,8);
            TRACE_END_STM$("CompoundStatement248",249);
        }
    }
    // JavaLine 324 ==> SourceLine 251
    ((simtst85)(CUR$.SL$)).inspect$21$0.outimage();
    // JavaLine 326 ==> SourceLine 253
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 328 ==> SourceLine 254
    ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
    // JavaLine 330 ==> SourceLine 255
    sysout().outtext(((simtst85)(CUR$.SL$)).inspect$21$0.intext(60));
    // JavaLine 332 ==> SourceLine 258
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$("              .000 1      .000 2      .000 3      .000 4    "),new TXT$("OUTFRAC with forced OUTIMAGE"),60);
    // JavaLine 334 ==> SourceLine 260
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 336 ==> SourceLine 261
    while((((simtst85)(CUR$.SL$)).inspect$21$0.location()<=(4))) {
        // JavaLine 338 ==> SourceLine 263
        {
            TRACE_BEGIN_STM$("CompoundStatement263",263);
            ((simtst85)(CUR$.SL$)).inspect$21$0.setpos(13);
            // JavaLine 342 ==> SourceLine 264
            ((simtst85)(CUR$.SL$)).inspect$21$0.outchar('+');
            TRACE_END_STM$("CompoundStatement263",264);
        }
    }
    // JavaLine 347 ==> SourceLine 266
    ((simtst85)(CUR$.SL$)).inspect$21$0.outimage();
    // JavaLine 349 ==> SourceLine 268
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 351 ==> SourceLine 269
    ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
    // JavaLine 353 ==> SourceLine 270
    sysout().outtext(((simtst85)(CUR$.SL$)).inspect$21$0.intext(60));
    // JavaLine 355 ==> SourceLine 273
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$("            +           +           +           +           "),new TXT$("OUTCHAR with forced OUTIMAGE"),60);
    // JavaLine 357 ==> SourceLine 275
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 359 ==> SourceLine 276
    while((((simtst85)(CUR$.SL$)).inspect$21$0.location()<=(4))) {
        // JavaLine 361 ==> SourceLine 278
        {
            TRACE_BEGIN_STM$("CompoundStatement278",278);
            ((simtst85)(CUR$.SL$)).inspect$21$0.setpos(10);
            // JavaLine 365 ==> SourceLine 280
            ((simtst85)(CUR$.SL$)).inspect$21$0.outtext(new TXT$("THIS"));
            TRACE_END_STM$("CompoundStatement278",280);
        }
    }
    // JavaLine 370 ==> SourceLine 281
    ((simtst85)(CUR$.SL$)).inspect$21$0.outimage();
    // JavaLine 372 ==> SourceLine 283
    ((simtst85)(CUR$.SL$)).inspect$21$0.locate(1);
    // JavaLine 374 ==> SourceLine 284
    ((simtst85)(CUR$.SL$)).inspect$21$0.inimage();
    // JavaLine 376 ==> SourceLine 285
    sysout().outtext(((simtst85)(CUR$.SL$)).inspect$21$0.intext(60));
    // JavaLine 378 ==> SourceLine 288
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$("            THIS        THIS        THIS        THIS        "),new TXT$("OUTTEXT with forced OUTIMAGE"),60);
    // JavaLine 380 ==> SourceLine 290
    ((simtst85)(CUR$.SL$)).inspect$21$0.setaccess(new TXT$("PURGE"));
    // JavaLine 382 ==> SourceLine 291
    ((simtst85)(CUR$.SL$)).inspect$21$0.close();
    // JavaLine 384 ==> SourceLine 293
    if(VALUE$(TRF_EQ(((simtst85)(CUR$.SL$)).inspect$21$0.image,null))) {
        // JavaLine 386 ==> SourceLine 294
        sysout().outtext(new TXT$("TRUE"));
    } else
    sysout().outtext(new TXT$("FALSE"));
    // JavaLine 390 ==> SourceLine 296
    new simtst85$SubBlock23$check(((simtst85$SubBlock23)CUR$),new TXT$("TRUE"),new TXT$("IMAGE after CLOSE"),4);
    TRACE_END_STM$("SubBlock23",296);
    EBLK();
    return(null);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("simtst85.sim","SubBlock SubBlock23",1,23,23,40,25,41,27,42,29,43,31,45,33,46,35,47,37,49,39,51,43,53,47,54,49,55,51,57,56,59,58,60,60,61,62,62,64,63,66,64,68,65,70,66,72,67,74,68,76,69,78,70,80,72,82,75,84,76,86,77,88,78,90,80,94,81,99,85,101,87,103,88,105,89,109,91,111,93,113,94,115,95,119,98,121,100,123,101,125,102,129,104,131,106,133,107,135,108,137,110,141,111,146,115,148,138,150,140,152,141,154,142,158,144,160,145,162,146,164,149,166,151,168,152,170,154,179,156,181,157,183,158,185,161,187,163,189,164,191,165,195,167,197,168,199,169,201,172,203,174,205,175,207,176,211,178,213,179,215,180,217,183,219,185,221,186,223,188,227,189,229,190,234,193,236,194,238,195,240,198,242,200,244,201,246,203,250,204,255,206,257,208,259,209,261,210,263,213,265,215,267,216,269,218,273,219,278,221,280,223,282,224,284,225,286,228,288,230,290,231,292,233,296,234,301,236,303,238,305,239,307,240,309,243,311,245,313,246,315,248,319,249,324,251,326,253,328,254,330,255,332,258,334,260,336,261,338,263,342,264,347,266,349,268,351,269,353,270,355,273,357,275,359,276,361,278,365,280,370,281,372,283,374,284,376,285,378,288,380,290,382,291,384,293,386,294,390,296,395,299);
}
