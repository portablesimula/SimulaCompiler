// JavaLine 1 <== SourceLine 159
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$getsymb$inline extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=159, lastLine=354, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 10 <== SourceLine 204
    final LABQNT$ NEWL=new LABQNT$(this,1,"NEWL"); // Local Label #1=NEWL
    // JavaLine 12 <== SourceLine 206
    final LABQNT$ NEWR=new LABQNT$(this,2,"NEWR"); // Local Label #2=NEWR
    // JavaLine 14 <== SourceLine 244
    final LABQNT$ REPPCT=new LABQNT$(this,3,"REPPCT"); // Local Label #3=REPPCT
    // JavaLine 16 <== SourceLine 248
    final LABQNT$ REP1=new LABQNT$(this,4,"REP1"); // Local Label #4=REP1
    // JavaLine 18 <== SourceLine 251
    final LABQNT$ PCTCHK=new LABQNT$(this,5,"PCTCHK"); // Local Label #5=PCTCHK
    // JavaLine 20 <== SourceLine 260
    final LABQNT$ REP2=new LABQNT$(this,6,"REP2"); // Local Label #6=REP2
    // JavaLine 22 <== SourceLine 269
    final LABQNT$ DIR=new LABQNT$(this,7,"DIR"); // Local Label #7=DIR
    // JavaLine 24 <== SourceLine 354
    final LABQNT$ NXT=new LABQNT$(this,8,"NXT"); // Local Label #8=NXT
    // Declare locals as attributes
    // JavaLine 27 <== SourceLine 160
    char ch=0;
    // JavaLine 29 <== SourceLine 161
    int startpos=0;
    // JavaLine 31 <== SourceLine 162
    int n=0;
    int s=0;
    int v=0;
    TXT$ id=null;
    // JavaLine 36 <== SourceLine 208
    Pass1$SubBlock32$sourceElt inspect$208$65=null;
    // JavaLine 38 <== SourceLine 218
    PrintFile$ inspect$218$66=null;
    // JavaLine 40 <== SourceLine 229
    PrintFile$ inspect$229$67=null;
    // JavaLine 42 <== SourceLine 269
    PrintFile$ inspect$269$68=null;
    // JavaLine 44 <== SourceLine 279
    PrintFile$ inspect$279$69=null;
    // JavaLine 46 <== SourceLine 311
    Pass1$SubBlock32$sourceElt inspect$311$70=null;
    // JavaLine 48 <== SourceLine 312
    Pass1$SubBlock32$sourceElt inspect$312$71=null;
    // JavaLine 50 <== SourceLine 341
    PrintFile$ inspect$340$72=null;
    // JavaLine 52 <== SourceLine 349
    PrintFile$ inspect$349$73=null;
    // Normal Constructor
    public Pass1$SubBlock32$getsymb$inline(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$getsymb$inline STM$() {
        Pass1$SubBlock32$getsymb$inline THIS$=(Pass1$SubBlock32$getsymb$inline)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 68 <== SourceLine 204
                LABEL$(1,"NEWL");
                ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).imlen$1=((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1=0;
                ;
                // JavaLine 72 <== SourceLine 205
                while((((Pass1$SubBlock32$getsymb)(CUR$.SL$)).imlen$1==(0))) {
                    // JavaLine 74 <== SourceLine 206
                    {
                        LABEL$(2,"NEWR");
                        ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inpt$1.inrecord();
                        ;
                        // JavaLine 79 <== SourceLine 207
                        if(VALUE$(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inpt$1.endfile())) {
                            // JavaLine 81 <== SourceLine 208
                            {
                                {
                                    // BEGIN INSPECTION 
                                    inspect$208$65=((Pass1$SubBlock32)(CUR$.SL$.SL$)).cursource;
                                    if(inspect$208$65!=null) // INSPECT inspect$208$65
                                    new Pass1$SubBlock32$sourceElt$close(inspect$208$65);
                                }
                                ;
                                // JavaLine 90 <== SourceLine 209
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).cursource==(null)))) {
                                    // JavaLine 92 <== SourceLine 210
                                    {
                                        new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Missing END"));
                                        ;
                                        ASGSTR$(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1,"END; ");
                                        ;
                                        // JavaLine 98 <== SourceLine 211
                                        TXT$.setpos(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1,0);
                                        ;
                                    }
                                } else
                                // JavaLine 103 <== SourceLine 213
                                {
                                    ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inpt$1=((Pass1$SubBlock32)(CUR$.SL$.SL$)).cursource.inptf;
                                    ;
                                    // JavaLine 107 <== SourceLine 214
                                    ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1=((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inpt$1.image;
                                    ;
                                    GOTO$(NEWR); // GOTO EVALUATED LABEL
                                }
                                ;
                            }
                        }
                        ;
                        // JavaLine 116 <== SourceLine 216
                        ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.curline$1=Math.addExact(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.curline$1,1);
                        ;
                        // JavaLine 119 <== SourceLine 217
                        ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).imlen$1=Math.subtractExact(TXT$.pos(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inpt$1.image),1);
                        ;
                        // JavaLine 122 <== SourceLine 218
                        {
                            // BEGIN INSPECTION 
                            inspect$218$66=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.ListFile$1;
                            if(inspect$218$66!=null) // INSPECT inspect$218$66
                            // JavaLine 127 <== SourceLine 219
                            {
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).inserted!=(0)))) {
                                    // JavaLine 130 <== SourceLine 220
                                    {
                                        inspect$218$66.outchar('>');
                                        ;
                                        inspect$218$66.outint(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.curline$1,6);
                                        ;
                                        // JavaLine 136 <== SourceLine 221
                                        inspect$218$66.outtext(CONC(new TXT$(" "),TXT$.sub(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1,1,((Pass1$SubBlock32$getsymb)(CUR$.SL$)).imlen$1)));
                                        ;
                                    }
                                } else
                                // JavaLine 141 <== SourceLine 224
                                {
                                    inspect$218$66.outint(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.curline$1,6);
                                    ;
                                    // JavaLine 145 <== SourceLine 225
                                    inspect$218$66.outtext(CONC(new TXT$("* "),TXT$.sub(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1,1,((Pass1$SubBlock32$getsymb)(CUR$.SL$)).imlen$1)));
                                    ;
                                }
                                ;
                                // JavaLine 150 <== SourceLine 227
                                inspect$218$66.outimage();
                                ;
                            }
                        }
                        ;
                        // JavaLine 156 <== SourceLine 229
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).input_trace>(0)))) {
                            {
                                // BEGIN INSPECTION 
                                inspect$229$67=sysout();
                                if(inspect$229$67!=null) // INSPECT inspect$229$67
                                // JavaLine 162 <== SourceLine 230
                                {
                                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).inserted!=(0)))) {
                                        // JavaLine 165 <== SourceLine 231
                                        {
                                            inspect$229$67.outchar('>');
                                            ;
                                            inspect$229$67.outint(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.curline$1,6);
                                            ;
                                            // JavaLine 171 <== SourceLine 232
                                            inspect$229$67.outtext(CONC(new TXT$(" "),TXT$.sub(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1,1,((Pass1$SubBlock32$getsymb)(CUR$.SL$)).imlen$1)));
                                            ;
                                        }
                                    } else
                                    // JavaLine 176 <== SourceLine 235
                                    {
                                        inspect$229$67.outint(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.curline$1,6);
                                        ;
                                        // JavaLine 180 <== SourceLine 236
                                        inspect$229$67.outtext(CONC(new TXT$("* "),TXT$.sub(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1,1,((Pass1$SubBlock32$getsymb)(CUR$.SL$)).imlen$1)));
                                        ;
                                    }
                                    ;
                                    // JavaLine 185 <== SourceLine 238
                                    inspect$229$67.outimage();
                                    ;
                                }
                            }
                        }
                        ;
                    }
                }
                ;
                // JavaLine 195 <== SourceLine 241
                storeChar(((char)30),((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$)).imlen$1);
                ;
                // JavaLine 198 <== SourceLine 242
                if(VALUE$((loadChar(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1)==('%')))) {
                    // JavaLine 200 <== SourceLine 243
                    {
                        ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1=Math.addExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1,1);
                        ;
                        // JavaLine 204 <== SourceLine 244
                        LABEL$(3,"REPPCT");
                        ch=loadChar(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1);
                        ;
                        startpos=((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1;
                        ;
                        // JavaLine 210 <== SourceLine 245
                        ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1=Math.addExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1,1);
                        ;
                        id=null;
                        ;
                        // JavaLine 215 <== SourceLine 246
                        if(VALUE$(((ch==(((char)32)))||((ch==(((char)30))))))) {
                            GOTO$(NEWL); // GOTO EVALUATED LABEL
                        }
                        ;
                        // JavaLine 220 <== SourceLine 247
                        if(VALUE$((ch==('+')))) {
                            // JavaLine 222 <== SourceLine 248
                            {
                                LABEL$(4,"REP1");
                                ch=loadChar(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1);
                                ;
                                ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1=Math.addExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1,1);
                                ;
                                // JavaLine 229 <== SourceLine 249
                                if(VALUE$(letter(ch))) {
                                    // JavaLine 231 <== SourceLine 250
                                    GOTO$(((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.Selector.Elt[rank(ch)-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.Selector.LB[0]])?(REP1):(DIR))); // GOTO EVALUATED LABEL
                                }
                                ;
                                // JavaLine 235 <== SourceLine 251
                                LABEL$(5,"PCTCHK");
                                if(VALUE$((ch==('+')))) {
                                    GOTO$(REP1); // GOTO EVALUATED LABEL
                                }
                                ;
                                // JavaLine 241 <== SourceLine 252
                                if(VALUE$((ch==('-')))) {
                                    GOTO$(REP2); // GOTO EVALUATED LABEL
                                }
                                ;
                                // JavaLine 246 <== SourceLine 253
                                if(VALUE$((ch==(((char)32))))) {
                                    // JavaLine 248 <== SourceLine 254
                                    {
                                        ch=loadChar(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1);
                                        ;
                                        ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1=Math.addExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1,1);
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 257 <== SourceLine 255
                                if(VALUE$((ch==('%')))) {
                                    GOTO$(REPPCT); // GOTO EVALUATED LABEL
                                }
                                ;
                                // JavaLine 262 <== SourceLine 256
                                ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1=Math.subtractExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1,1);
                                ;
                                GOTO$(NXT); // GOTO EVALUATED LABEL
                                ;
                            }
                        }
                        ;
                        // JavaLine 270 <== SourceLine 259
                        if(VALUE$((ch==('-')))) {
                            // JavaLine 272 <== SourceLine 260
                            {
                                LABEL$(6,"REP2");
                                ch=loadChar(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1);
                                ;
                                ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1=Math.addExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1,1);
                                ;
                                // JavaLine 279 <== SourceLine 261
                                if(VALUE$(letter(ch))) {
                                    // JavaLine 281 <== SourceLine 262
                                    GOTO$(((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.Selector.Elt[rank(ch)-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.Selector.LB[0]])?(DIR):(REP2))); // GOTO EVALUATED LABEL
                                }
                                ;
                                // JavaLine 285 <== SourceLine 263
                                GOTO$(PCTCHK); // GOTO EVALUATED LABEL
                                ;
                            }
                        }
                        ;
                        // JavaLine 291 <== SourceLine 266
                        ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1=Math.subtractExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1,1);
                        ;
                        // JavaLine 294 <== SourceLine 267
                        new Pass1$SubBlock32$getsymb$inline$getBasic(((Pass1$SubBlock32$getsymb$inline)(CUR$)));
                        ;
                        id=((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval;
                        ;
                        // JavaLine 299 <== SourceLine 273
                        LABEL$(7,"DIR");
                        // JavaLine 301 <== SourceLine 269
                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).input_trace>(3)))) {
                            {
                                // BEGIN INSPECTION 
                                inspect$269$68=sysout();
                                if(inspect$269$68!=null) // INSPECT inspect$269$68
                                // JavaLine 307 <== SourceLine 270
                                {
                                    if(VALUE$(TRF_EQ(id,null))) {
                                        // JavaLine 310 <== SourceLine 271
                                        inspect$269$68.outtext(new TXT$("%DIR=notext"));
                                    } else
                                    {
                                        inspect$269$68.outtext(CONC(new TXT$("%DIR="),id));
                                        ;
                                        inspect$269$68.outchar('.');
                                    }
                                    ;
                                    // JavaLine 319 <== SourceLine 272
                                    inspect$269$68.outimage();
                                    ;
                                }
                            }
                        }
                        ;
                        // JavaLine 326 <== SourceLine 275
                        if(VALUE$(TRF_EQ(id,null))) {
                            ;
                        } else
                        // JavaLine 330 <== SourceLine 276
                        if(VALUE$(((TXTREL$EQ(id,new TXT$("define"))|(TXTREL$EQ(id,new TXT$("macro"))))|(TXTREL$EQ(id,new TXT$("endmacro")))))) {
                            // JavaLine 332 <== SourceLine 277
                            {
                                ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1=startpos;
                                ;
                                GOTO$(NXT); // GOTO EVALUATED LABEL
                            }
                        } else
                        // JavaLine 339 <== SourceLine 278
                        if(VALUE$((TXTREL$EQ(id,new TXT$("page"))|(TXTREL$EQ(id,new TXT$("title")))))) {
                            // JavaLine 341 <== SourceLine 279
                            {
                                {
                                    // BEGIN INSPECTION 
                                    inspect$279$69=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.ListFile$1;
                                    if(inspect$279$69!=null) // INSPECT inspect$279$69
                                    inspect$279$69.eject(1);
                                }
                                ;
                                // JavaLine 350 <== SourceLine 280
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).input_trace>(0)))) {
                                    sysout().eject(1);
                                }
                                ;
                            }
                        } else
                        // JavaLine 357 <== SourceLine 282
                        if(VALUE$(TXTREL$EQ(id,new TXT$("visible")))) {
                            // JavaLine 359 <== SourceLine 283
                            ((Pass1$SubBlock32)(CUR$.SL$.SL$)).all_visible=TRF_NE(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.module_ident$1,null);
                        } else
                        // JavaLine 362 <== SourceLine 284
                        if(VALUE$(TXTREL$EQ(id,new TXT$("hidden")))) {
                            ((Pass1$SubBlock32)(CUR$.SL$.SL$)).all_visible=false;
                        } else
                        // JavaLine 366 <== SourceLine 285
                        if(VALUE$(TXTREL$EQ(id,new TXT$("insert")))) {
                            // JavaLine 368 <== SourceLine 286
                            {
                                while((loadChar(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1)==(((char)32)))) {
                                    ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1=Math.addExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1,1);
                                }
                                ;
                                // JavaLine 374 <== SourceLine 287
                                ((Pass1$SubBlock32)(CUR$.SL$.SL$)).source_file=TXT$.strip(TXT$.sub(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1,Math.addExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1,1),Math.subtractExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).imlen$1,((Pass1$SubBlock32$getsymb)(CUR$.SL$)).impos$1)));
                                ;
                                // JavaLine 377 <== SourceLine 288
                                ((Pass1$SubBlock32)(CUR$.SL$.SL$)).cursource=new Pass1$SubBlock32$sourceElt(((Pass1$SubBlock32)(CUR$.SL$.SL$))).STM$();
                                ;
                                // JavaLine 380 <== SourceLine 289
                                ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inpt$1=((Pass1$SubBlock32)(CUR$.SL$.SL$)).cursource.inptf;
                                ;
                                ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1=((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inpt$1.image;
                                ;
                            }
                        } else
                        // JavaLine 387 <== SourceLine 291
                        if(VALUE$(TXTREL$EQ(id,new TXT$("tag")))) {
                            // JavaLine 389 <== SourceLine 292
                            {
                                if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.rutlev$1==(0)))) {
                                    // JavaLine 392 <== SourceLine 293
                                    {
                                        new Pass1$SubBlock32$getsymb$inline$getBasic(((Pass1$SubBlock32$getsymb$inline)(CUR$)));
                                        ;
                                        // JavaLine 396 <== SourceLine 294
                                        if(VALUE$((ch!=('(')))) {
                                            new Pass1$SubBlock32$getsymb$inline$percenterr(((Pass1$SubBlock32$getsymb$inline)(CUR$)));
                                        }
                                        ;
                                        // JavaLine 401 <== SourceLine 295
                                        ch=',';
                                        ;
                                        // JavaLine 404 <== SourceLine 296
                                        while((ch==(','))) {
                                            // JavaLine 406 <== SourceLine 297
                                            {
                                                new Pass1$SubBlock32$getsymb$inline$getBasic(((Pass1$SubBlock32$getsymb$inline)(CUR$)));
                                                ;
                                                // JavaLine 410 <== SourceLine 298
                                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                                                    new Pass1$SubBlock32$getsymb$inline$percenterr(((Pass1$SubBlock32$getsymb$inline)(CUR$)));
                                                }
                                                ;
                                                // JavaLine 415 <== SourceLine 299
                                                ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.simsymbol$1=((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval;
                                                ;
                                                new Common$DEFIDENT(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62);
                                                ;
                                                // JavaLine 420 <== SourceLine 300
                                                ((Pass1$SubBlock32)(CUR$.SL$.SL$)).taglast=((Pass1$SubBlock32)(CUR$.SL$.SL$)).taglast.next=new Common$seqtag(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.LB[0]]).STM$();
                                                ;
                                                // JavaLine 423 <== SourceLine 302
                                                new Pass1$SubBlock32$getsymb$inline$getBasic(((Pass1$SubBlock32$getsymb$inline)(CUR$)));
                                                ;
                                            }
                                        }
                                        ;
                                        // JavaLine 429 <== SourceLine 304
                                        if(VALUE$((ch!=(')')))) {
                                            new Pass1$SubBlock32$getsymb$inline$percenterr(((Pass1$SubBlock32$getsymb$inline)(CUR$)));
                                        }
                                        ;
                                    }
                                } else
                                // JavaLine 436 <== SourceLine 305
                                new Pass1$SubBlock32$getsymb$inline$percenterr(((Pass1$SubBlock32$getsymb$inline)(CUR$)));
                                ;
                            }
                        } else
                        // JavaLine 441 <== SourceLine 307
                        if(VALUE$(TXTREL$EQ(id,new TXT$("sport")))) {
                            {
                                new Pass1$SubBlock32$getsymb$inline$getBasic(((Pass1$SubBlock32$getsymb$inline)(CUR$)));
                                ;
                                // JavaLine 446 <== SourceLine 308
                                ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.SportOk$1=TXTREL$EQ(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval,new TXT$("on"));
                                ;
                            }
                        } else
                        // JavaLine 451 <== SourceLine 310
                        if(VALUE$(TXTREL$EQ(id,new TXT$("eof")))) {
                            // JavaLine 453 <== SourceLine 311
                            {
                                {
                                    // BEGIN INSPECTION 
                                    inspect$311$70=((Pass1$SubBlock32)(CUR$.SL$.SL$)).cursource;
                                    if(inspect$311$70!=null) // INSPECT inspect$311$70
                                    new Pass1$SubBlock32$sourceElt$close(inspect$311$70);
                                }
                                ;
                                // JavaLine 462 <== SourceLine 312
                                {
                                    // BEGIN INSPECTION 
                                    inspect$312$71=((Pass1$SubBlock32)(CUR$.SL$.SL$)).cursource;
                                    if(inspect$312$71!=null) // INSPECT inspect$312$71
                                    // JavaLine 467 <== SourceLine 313
                                    {
                                        ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inpt$1=inspect$312$71.inptf;
                                        ;
                                        ((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1=((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inpt$1.image;
                                    }
                                    else // OTHERWISE 
                                    ;
                                }
                            }
                        } else
                        // JavaLine 478 <== SourceLine 316
                        if(VALUE$(TXTREL$EQ(id,new TXT$("pass")))) {
                            // JavaLine 480 <== SourceLine 317
                            {
                                new Pass1$SubBlock32$getsymb$inline$getBasic(((Pass1$SubBlock32$getsymb$inline)(CUR$)));
                                ;
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1)))) {
                                    new Pass1$SubBlock32$getsymb$inline$percenterr(((Pass1$SubBlock32$getsymb$inline)(CUR$)));
                                }
                                ;
                                // JavaLine 488 <== SourceLine 318
                                n=TXT$.getint(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval);
                                ;
                                // JavaLine 491 <== SourceLine 319
                                new Pass1$SubBlock32$getsymb$inline$getBasic(((Pass1$SubBlock32$getsymb$inline)(CUR$)));
                                ;
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                                    new Pass1$SubBlock32$getsymb$inline$percenterr(((Pass1$SubBlock32$getsymb$inline)(CUR$)));
                                }
                                ;
                                // JavaLine 498 <== SourceLine 320
                                if(VALUE$(TXTREL$EQ(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval,new TXT$("input")))) {
                                    s=1;
                                } else
                                // JavaLine 502 <== SourceLine 321
                                if(VALUE$(TXTREL$EQ(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval,new TXT$("output")))) {
                                    s=2;
                                } else
                                // JavaLine 506 <== SourceLine 322
                                if(VALUE$(TXTREL$EQ(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval,new TXT$("modtrc")))) {
                                    s=3;
                                } else
                                // JavaLine 510 <== SourceLine 323
                                if(VALUE$(TXTREL$EQ(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval,new TXT$("trace")))) {
                                    s=4;
                                } else
                                // JavaLine 514 <== SourceLine 324
                                if(VALUE$(TXTREL$EQ(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval,new TXT$("dotracing")))) {
                                    s=5;
                                } else
                                new Pass1$SubBlock32$getsymb$inline$percenterr(((Pass1$SubBlock32$getsymb$inline)(CUR$)));
                                ;
                                // JavaLine 520 <== SourceLine 325
                                new Pass1$SubBlock32$getsymb$inline$getBasic(((Pass1$SubBlock32$getsymb$inline)(CUR$)));
                                ;
                                if(VALUE$((ch!=('=')))) {
                                    new Pass1$SubBlock32$getsymb$inline$percenterr(((Pass1$SubBlock32$getsymb$inline)(CUR$)));
                                }
                                ;
                                // JavaLine 527 <== SourceLine 326
                                new Pass1$SubBlock32$getsymb$inline$getBasic(((Pass1$SubBlock32$getsymb$inline)(CUR$)));
                                ;
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1)))) {
                                    new Pass1$SubBlock32$getsymb$inline$percenterr(((Pass1$SubBlock32$getsymb$inline)(CUR$)));
                                }
                                ;
                                // JavaLine 534 <== SourceLine 327
                                v=TXT$.getint(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval);
                                ;
                                // JavaLine 537 <== SourceLine 328
                                if(VALUE$((n==(1)))) {
                                    // JavaLine 539 <== SourceLine 329
                                    {
                                        if(VALUE$((s==(1)))) {
                                            ((Pass1$SubBlock32)(CUR$.SL$.SL$)).input_trace=v;
                                        } else
                                        // JavaLine 544 <== SourceLine 330
                                        if(VALUE$((s==(2)))) {
                                            // JavaLine 546 <== SourceLine 331
                                            {
                                                if(VALUE$(IS$(((Pass1$SubBlock32)(CUR$.SL$.SL$)).parser,Pass1$SubBlock32$grammar.class))) {
                                                    // JavaLine 549 <== SourceLine 334
                                                    new Pass1$SubBlock32$grammar$settrace(((Pass1$SubBlock32$grammar)(((Pass1$SubBlock32)(CUR$.SL$.SL$)).parser)),v);
                                                }
                                            }
                                        } else
                                        if(VALUE$((s==(3)))) {
                                            ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.module_trace$1=v;
                                        } else
                                        // JavaLine 557 <== SourceLine 335
                                        if(VALUE$((s==(4)))) {
                                            ((Pass1$SubBlock32)(CUR$.SL$.SL$)).tracemode=v;
                                        } else
                                        // JavaLine 561 <== SourceLine 336
                                        if(VALUE$((s==(5)))) {
                                            ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.DO_TRACING$1=v;
                                        }
                                        ;
                                    }
                                } else
                                // JavaLine 568 <== SourceLine 338
                                {
                                    s=Math.addExact(Math.multiplyExact(Math.subtractExact(n,2),10),s);
                                    ;
                                    // JavaLine 572 <== SourceLine 339
                                    new Common$trace_item(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,s,v).STM$().into(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.TRC_info$1);
                                    ;
                                    // JavaLine 575 <== SourceLine 340
                                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).tracemode>(3)))) {
                                        {
                                            // BEGIN INSPECTION 
                                            inspect$340$72=sysout();
                                            if(inspect$340$72!=null) // INSPECT inspect$340$72
                                            // JavaLine 581 <== SourceLine 341
                                            {
                                                inspect$340$72.outtext(new TXT$("TRACE"));
                                                ;
                                                inspect$340$72.outint(s,4);
                                                ;
                                                // JavaLine 587 <== SourceLine 342
                                                inspect$340$72.outint(v,4);
                                                ;
                                                inspect$340$72.outimage();
                                                ;
                                            }
                                        }
                                    }
                                    ;
                                }
                                ;
                            }
                        } else
                        // JavaLine 600 <== SourceLine 347
                        {
                            id=TXT$.sub(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).inim$1,Math.addExact(startpos,1),Math.subtractExact(((Pass1$SubBlock32$getsymb)(CUR$.SL$)).imlen$1,startpos));
                            ;
                            // JavaLine 604 <== SourceLine 348
                            new Common$info_item(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,copy(copy(id))).STM$().into(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.TRC_info$1);
                            ;
                            // JavaLine 607 <== SourceLine 349
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).tracemode>(3)))) {
                                {
                                    // BEGIN INSPECTION 
                                    inspect$349$73=sysout();
                                    if(inspect$349$73!=null) // INSPECT inspect$349$73
                                    // JavaLine 613 <== SourceLine 350
                                    {
                                        inspect$349$73.outtext(new TXT$("INFO "));
                                        ;
                                        inspect$349$73.outtext(id);
                                        ;
                                        inspect$349$73.outimage();
                                    }
                                }
                            }
                            ;
                        }
                        ;
                        // JavaLine 626 <== SourceLine 352
                        GOTO$(NEWL); // GOTO EVALUATED LABEL
                        ;
                    }
                }
                ;
                // JavaLine 632 <== SourceLine 354
                LABEL$(8,"NXT");
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("inline:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("inline:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("inline:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure inline",1,159,10,204,12,206,14,244,16,248,18,251,20,260,22,269,24,354,27,160,29,161,31,162,36,208,38,218,40,229,42,269,44,279,46,311,48,312,50,341,52,349,68,204,72,205,74,206,79,207,81,208,90,209,92,210,98,211,103,213,107,214,116,216,119,217,122,218,127,219,130,220,136,221,141,224,145,225,150,227,156,229,162,230,165,231,171,232,176,235,180,236,185,238,195,241,198,242,200,243,204,244,210,245,215,246,220,247,222,248,229,249,231,250,235,251,241,252,246,253,248,254,257,255,262,256,270,259,272,260,279,261,281,262,285,263,291,266,294,267,299,273,301,269,307,270,310,271,319,272,326,275,330,276,332,277,339,278,341,279,350,280,357,282,359,283,362,284,366,285,368,286,374,287,377,288,380,289,387,291,389,292,392,293,396,294,401,295,404,296,406,297,410,298,415,299,420,300,423,302,429,304,436,305,441,307,446,308,451,310,453,311,462,312,467,313,478,316,480,317,488,318,491,319,498,320,502,321,506,322,510,323,514,324,520,325,527,326,534,327,537,328,539,329,544,330,546,331,549,334,557,335,561,336,568,338,572,339,575,340,581,341,587,342,600,347,604,348,607,349,613,350,626,352,632,354,651,354);
} // End of Procedure
