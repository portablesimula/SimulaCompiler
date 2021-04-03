// JavaLine 1 <== SourceLine 19
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:52 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class UtModule$SubBlock19 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=2, firstLine=19, lastLine=323, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 228
    final LABQNT$ ATRBX=new LABQNT$(this,1,"ATRBX"); // Local Label #1=ATRBX
    // JavaLine 11 <== SourceLine 236
    final LABQNT$ VTRBX=new LABQNT$(this,2,"VTRBX"); // Local Label #2=VTRBX
    // JavaLine 13 <== SourceLine 238
    final LABQNT$ VIANTX=new LABQNT$(this,3,"VIANTX"); // Local Label #3=VIANTX
    // JavaLine 15 <== SourceLine 267
    final LABQNT$ KEEP=new LABQNT$(this,4,"KEEP"); // Local Label #4=KEEP
    // JavaLine 17 <== SourceLine 297
    final LABQNT$ MACX=new LABQNT$(this,5,"MACX"); // Local Label #5=MACX
    // Declare locals as attributes
    // JavaLine 20 <== SourceLine 19
    int nx=0;
    // JavaLine 22 <== SourceLine 20
    int ihi=0;
    int lowlim=0;
    // JavaLine 25 <== SourceLine 21
    int nxtag=0;
    // JavaLine 27 <== SourceLine 22
    int i=0;
    int lb=0;
    int ub=0;
    Common$descr d=null;
    Common$descr dsuc=null;
    // JavaLine 33 <== SourceLine 23
    Common$quant atrb=null;
    Common$variant viant=null;
    // JavaLine 36 <== SourceLine 24
    Link$ xlnk=null;
    // Normal Constructor
    public UtModule$SubBlock19(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        UtModule$SubBlock19 THIS$=(UtModule$SubBlock19)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 50 <== SourceLine 178
                if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$114.option.Elt[rank('Y')-((UtModule)(CUR$.SL$)).inspect$17$114.option.LB[0]]!=(0)))) {
                    {
                        // BEGIN INSPECTION 
                        ((UtModule)(CUR$.SL$)).inspect$178$129=sysout();
                        if(((UtModule)(CUR$.SL$)).inspect$178$129!=null) // INSPECT inspect$178$129
                        // JavaLine 56 <== SourceLine 179
                        {
                            // JavaLine 58 <== SourceLine 180
                            ((UtModule)(CUR$.SL$)).inspect$178$129.outtext(CONC(CONC(CONC(new TXT$("Module: "),((UtModule)(CUR$.SL$)).inspect$17$114.module_ident$1),new TXT$(",  Check-code: ")),((UtModule)(CUR$.SL$)).inspect$17$114.module_code$1));
                            ;
                            // JavaLine 61 <== SourceLine 181
                            ((UtModule)(CUR$.SL$)).inspect$178$129.outimage();
                            ;
                            lb=100;
                            ;
                        }
                    }
                }
                ;
                // JavaLine 70 <== SourceLine 186
                if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$114.module_trace$1>(0)))) {
                    {
                        // BEGIN INSPECTION 
                        ((UtModule)(CUR$.SL$)).inspect$186$130=sysout();
                        if(((UtModule)(CUR$.SL$)).inspect$186$130!=null) // INSPECT inspect$186$130
                        // JavaLine 76 <== SourceLine 187
                        {
                            // JavaLine 78 <== SourceLine 188
                            ((UtModule)(CUR$.SL$)).inspect$186$130.outtext(CONC(CONC(new TXT$("************   Begin  -  Output-module  "),((UtModule)(CUR$.SL$)).p$modid),new TXT$("   ************")));
                            ;
                            ((UtModule)(CUR$.SL$)).inspect$186$130.outimage();
                            ;
                            // JavaLine 83 <== SourceLine 189
                            ((UtModule)(CUR$.SL$)).inspect$17$115.output_trace$3=((UtModule)(CUR$.SL$)).inspect$17$114.module_trace$1;
                            ;
                        }
                    }
                }
                ;
                // JavaLine 90 <== SourceLine 191
                new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.M_MODULE$1);
                ;
                // JavaLine 93 <== SourceLine 192
                ((UtModule)(CUR$.SL$)).inspect$17$114.tempt$1=new TXT$("V2.0");
                ;
                new OuptFile$outstring(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.tempt$1);
                ;
                // JavaLine 98 <== SourceLine 193
                new OuptFile$outstring(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).p$modid);
                ;
                new OuptFile$outstring(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.module_code$1);
                ;
                // JavaLine 103 <== SourceLine 194
                if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                    new OuptFile$outcode(((UtModule)(CUR$.SL$)).inspect$17$115);
                }
                ;
                // JavaLine 108 <== SourceLine 197
                while((((UtModule)(CUR$.SL$)).inspect$17$114.taglist$1!=(null))) {
                    // JavaLine 110 <== SourceLine 198
                    {
                        new UtModule$SubBlock19$setXtag(((UtModule$SubBlock19)(CUR$)),((UtModule)(CUR$.SL$)).inspect$17$114.taglist$1.d.tag$2);
                        ;
                        // JavaLine 114 <== SourceLine 199
                        ((UtModule)(CUR$.SL$)).inspect$17$114.taglist$1.d.xtag$2=nx;
                        ;
                        // JavaLine 117 <== SourceLine 200
                        if(VALUE$(IS$(d,Common$peculiar.class))) {
                            // JavaLine 119 <== SourceLine 201
                            new UtModule$SubBlock19$setXtag(((UtModule$SubBlock19)(CUR$)),((Common$peculiar)(((UtModule)(CUR$.SL$)).inspect$17$114.taglist$1.d)).body$4);
                        }
                        ;
                        // JavaLine 123 <== SourceLine 202
                        ((UtModule)(CUR$.SL$)).inspect$17$114.taglist$1=((UtModule)(CUR$.SL$)).inspect$17$114.taglist$1.next;
                    }
                }
                ;
                // JavaLine 128 <== SourceLine 206
                d=((Common$descr)(((UtModule)(CUR$.SL$)).inspect$17$114.vislist$1.first()));
                ;
                // JavaLine 131 <== SourceLine 207
                while((d!=(null))) {
                    {
                        dsuc=((Common$descr)(d.suc()));
                        ;
                        // JavaLine 136 <== SourceLine 209
                        {
                            // BEGIN INSPECTION 
                            ((UtModule)(CUR$.SL$)).inspect$209$131=d;
                            //INSPECT inspect$209$131
                            if(((UtModule)(CUR$.SL$)).inspect$209$131 instanceof Common$quant) // WHEN Common$quant DO 
                            // JavaLine 142 <== SourceLine 210
                            {
                                new UtModule$SubBlock19$outquant(((UtModule$SubBlock19)(CUR$)),((Common$quant)((UtModule)(CUR$.SL$)).inspect$209$131));
                                ;
                                // JavaLine 146 <== SourceLine 211
                                if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((UtModule)(CUR$.SL$)).inspect$17$115);
                                }
                                ;
                                // JavaLine 151 <== SourceLine 212
                                if(VALUE$(((((Common$quant)(((UtModule)(CUR$.SL$)).inspect$209$131)).read_only$3&&((((Common$quant)(((UtModule)(CUR$.SL$)).inspect$209$131)).initval$3!=(null))))&&((!(((UtModule)(CUR$.SL$)).inspect$17$114.global_module$1)))))) {
                                    // JavaLine 153 <== SourceLine 214
                                    GOTO$(KEEP); // GOTO EVALUATED LABEL
                                }
                                ;
                            }
                            else if(((UtModule)(CUR$.SL$)).inspect$209$131 instanceof Common$label_descr) // WHEN Common$label_descr DO 
                            // JavaLine 159 <== SourceLine 217
                            {
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.M_LABSPEC$1);
                                ;
                                new UtModule$SubBlock19$outXtag(((UtModule$SubBlock19)(CUR$)),((Common$descr)((UtModule)(CUR$.SL$)).inspect$209$131));
                                ;
                                // JavaLine 165 <== SourceLine 218
                                if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((UtModule)(CUR$.SL$)).inspect$17$115);
                                }
                                ;
                            }
                            else if(((UtModule)(CUR$.SL$)).inspect$209$131 instanceof Common$record) // WHEN Common$record DO 
                            // JavaLine 172 <== SourceLine 221
                            {
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.M_RECORD$1);
                                ;
                                new UtModule$SubBlock19$outXtag(((UtModule$SubBlock19)(CUR$)),((Common$descr)((UtModule)(CUR$.SL$)).inspect$209$131));
                                ;
                                // JavaLine 178 <== SourceLine 222
                                new OuptFile$outstring(((UtModule)(CUR$.SL$)).inspect$17$115,(((((Common$record)(((UtModule)(CUR$.SL$)).inspect$209$131)).prefbox$3==(null)))?(null):(((Common$record)(((UtModule)(CUR$.SL$)).inspect$209$131)).prefbox$3.symbol)));
                                ;
                                // JavaLine 181 <== SourceLine 223
                                if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((UtModule)(CUR$.SL$)).inspect$17$115);
                                }
                                ;
                                // JavaLine 186 <== SourceLine 224
                                atrb=((Common$quant)(((Common$record)(((UtModule)(CUR$.SL$)).inspect$209$131)).atrset$3.first()));
                                ;
                                // JavaLine 189 <== SourceLine 225
                                while(true) {
                                    {
                                        // BEGIN INSPECTION 
                                        ((UtModule)(CUR$.SL$)).inspect$225$132=atrb;
                                        if(((UtModule)(CUR$.SL$)).inspect$225$132!=null) // INSPECT inspect$225$132
                                        // JavaLine 195 <== SourceLine 226
                                        {
                                            new UtModule$SubBlock19$outquant(((UtModule$SubBlock19)(CUR$)),((Common$quant)((UtModule)(CUR$.SL$)).inspect$225$132));
                                            ;
                                            atrb=((Common$quant)(((UtModule)(CUR$.SL$)).inspect$225$132.suc()));
                                            ;
                                        }
                                        else // OTHERWISE 
                                        // JavaLine 203 <== SourceLine 227
                                        GOTO$(ATRBX); // GOTO EVALUATED LABEL
                                    }
                                    if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                                }
                                ;
                                // JavaLine 209 <== SourceLine 228
                                LABEL$(1,"ATRBX");
                                viant=((Common$variant)(((Common$record)(((UtModule)(CUR$.SL$)).inspect$209$131)).variantset$3.first()));
                                ;
                                // JavaLine 213 <== SourceLine 229
                                while(true) {
                                    {
                                        // BEGIN INSPECTION 
                                        ((UtModule)(CUR$.SL$)).inspect$229$133=viant;
                                        if(((UtModule)(CUR$.SL$)).inspect$229$133!=null) // INSPECT inspect$229$133
                                        // JavaLine 219 <== SourceLine 230
                                        {
                                            new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.M_ALT$1);
                                            ;
                                            // JavaLine 223 <== SourceLine 231
                                            if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                                                new OuptFile$outcode(((UtModule)(CUR$.SL$)).inspect$17$115);
                                            }
                                            ;
                                            // JavaLine 228 <== SourceLine 232
                                            atrb=((Common$quant)(((UtModule)(CUR$.SL$)).inspect$229$133.atrset$2.first()));
                                            ;
                                            // JavaLine 231 <== SourceLine 233
                                            while(true) {
                                                {
                                                    // BEGIN INSPECTION 
                                                    ((UtModule)(CUR$.SL$)).inspect$233$134=atrb;
                                                    if(((UtModule)(CUR$.SL$)).inspect$233$134!=null) // INSPECT inspect$233$134
                                                    // JavaLine 237 <== SourceLine 234
                                                    {
                                                        new UtModule$SubBlock19$outquant(((UtModule$SubBlock19)(CUR$)),((Common$quant)((UtModule)(CUR$.SL$)).inspect$233$134));
                                                        ;
                                                        atrb=((Common$quant)(((UtModule)(CUR$.SL$)).inspect$233$134.suc()));
                                                        ;
                                                    }
                                                    else // OTHERWISE 
                                                    // JavaLine 245 <== SourceLine 235
                                                    GOTO$(VTRBX); // GOTO EVALUATED LABEL
                                                }
                                                if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                                            }
                                            ;
                                            // JavaLine 251 <== SourceLine 236
                                            LABEL$(2,"VTRBX");
                                            viant=((Common$variant)(((UtModule)(CUR$.SL$)).inspect$229$133.suc()));
                                            ;
                                        }
                                        else // OTHERWISE 
                                        // JavaLine 257 <== SourceLine 237
                                        GOTO$(VIANTX); // GOTO EVALUATED LABEL
                                    }
                                    if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                                }
                                ;
                                // JavaLine 263 <== SourceLine 238
                                LABEL$(3,"VIANTX");
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.M_ENDRECORD$1);
                                ;
                                // JavaLine 267 <== SourceLine 239
                                if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((UtModule)(CUR$.SL$)).inspect$17$115);
                                }
                                ;
                            }
                            else if(((UtModule)(CUR$.SL$)).inspect$209$131 instanceof Common$routine) // WHEN Common$routine DO 
                            // JavaLine 274 <== SourceLine 242
                            {
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.M_BODY$1);
                                ;
                                new UtModule$SubBlock19$outXtag(((UtModule$SubBlock19)(CUR$)),((Common$descr)((UtModule)(CUR$.SL$)).inspect$209$131));
                                ;
                                // JavaLine 280 <== SourceLine 243
                                new OuptFile$outstring(((UtModule)(CUR$.SL$)).inspect$17$115,(((((Common$routine)(((UtModule)(CUR$.SL$)).inspect$209$131)).profbox$3==(null)))?(null):(((Common$routine)(((UtModule)(CUR$.SL$)).inspect$209$131)).profbox$3.symbol)));
                                ;
                                // JavaLine 283 <== SourceLine 244
                                if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((UtModule)(CUR$.SL$)).inspect$17$115);
                                }
                                ;
                            }
                            else if(((UtModule)(CUR$.SL$)).inspect$209$131 instanceof Common$peculiar) // WHEN Common$peculiar DO 
                            // JavaLine 290 <== SourceLine 247
                            {
                                if(VALUE$((((Common$peculiar)(((UtModule)(CUR$.SL$)).inspect$209$131)).p4$kind==(((UtModule)(CUR$.SL$)).inspect$17$114.S_ROUTINE$1)))) {
                                    // JavaLine 293 <== SourceLine 248
                                    new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.M_ROUTINE$1);
                                } else
                                if(VALUE$((((Common$peculiar)(((UtModule)(CUR$.SL$)).inspect$209$131)).p4$kind==(((UtModule)(CUR$.SL$)).inspect$17$114.S_SYSRUT$1)))) {
                                    // JavaLine 297 <== SourceLine 249
                                    new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.M_SYSRUT$1);
                                } else
                                if(VALUE$((((Common$peculiar)(((UtModule)(CUR$.SL$)).inspect$209$131)).p4$kind==(((UtModule)(CUR$.SL$)).inspect$17$114.S_KNOWN$1)))) {
                                    // JavaLine 301 <== SourceLine 250
                                    new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.M_KNOWN$1);
                                } else
                                if(VALUE$((((Common$peculiar)(((UtModule)(CUR$.SL$)).inspect$209$131)).p4$kind==(((UtModule)(CUR$.SL$)).inspect$17$114.S_EXTERNAL$1)))) {
                                    // JavaLine 305 <== SourceLine 251
                                    new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.M_EXTERNAL$1);
                                } else
                                new Common$IERR(((UtModule)(CUR$.SL$)).inspect$17$114);
                                ;
                                // JavaLine 310 <== SourceLine 252
                                new UtModule$SubBlock19$outXpeculiar(((UtModule$SubBlock19)(CUR$)),((Common$peculiar)((UtModule)(CUR$.SL$)).inspect$209$131));
                                ;
                                // JavaLine 313 <== SourceLine 253
                                new OuptFile$outstring(((UtModule)(CUR$.SL$)).inspect$17$115,((Common$peculiar)(((UtModule)(CUR$.SL$)).inspect$209$131)).info$4);
                                ;
                                // JavaLine 316 <== SourceLine 254
                                if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((UtModule)(CUR$.SL$)).inspect$17$115);
                                }
                                ;
                                // JavaLine 321 <== SourceLine 255
                                new UtModule$SubBlock19$outspec(((UtModule$SubBlock19)(CUR$)),((Common$peculiar)(((UtModule)(CUR$.SL$)).inspect$209$131)).spec$3);
                                ;
                            }
                            else if(((UtModule)(CUR$.SL$)).inspect$209$131 instanceof Common$profile) // WHEN Common$profile DO 
                            // JavaLine 326 <== SourceLine 258
                            {
                                new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((((Common$profile)(((UtModule)(CUR$.SL$)).inspect$209$131)).interface$$3)?(((UtModule)(CUR$.SL$)).inspect$17$114.M_GLOBAL$1):(((UtModule)(CUR$.SL$)).inspect$17$114.M_PROFILE$1)));
                                ;
                                // JavaLine 330 <== SourceLine 259
                                new UtModule$SubBlock19$outXtag(((UtModule$SubBlock19)(CUR$)),((Common$descr)((UtModule)(CUR$.SL$)).inspect$209$131));
                                ;
                                // JavaLine 333 <== SourceLine 260
                                if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((UtModule)(CUR$.SL$)).inspect$17$115);
                                }
                                ;
                                // JavaLine 338 <== SourceLine 262
                                if(VALUE$(((Common$profile)(((UtModule)(CUR$.SL$)).inspect$209$131)).interface$$3)) {
                                    new UtModule$SubBlock19$outxspec(((UtModule$SubBlock19)(CUR$)),((Common$profile)(((UtModule)(CUR$.SL$)).inspect$209$131)).spec$3);
                                } else
                                new UtModule$SubBlock19$outspec(((UtModule$SubBlock19)(CUR$)),((Common$profile)(((UtModule)(CUR$.SL$)).inspect$209$131)).spec$3);
                                ;
                            }
                        }
                        ;
                        // JavaLine 347 <== SourceLine 265
                        d.out();
                        ;
                        // JavaLine 350 <== SourceLine 267
                        LABEL$(4,"KEEP");
                        d=dsuc;
                        ;
                    }
                }
                ;
                // JavaLine 357 <== SourceLine 269
                new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.M_END$1);
                ;
                // JavaLine 360 <== SourceLine 270
                if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                    new OuptFile$outcode(((UtModule)(CUR$.SL$)).inspect$17$115);
                }
                ;
                // JavaLine 365 <== SourceLine 273
                ihi=i=((UtModule)(CUR$.SL$)).inspect$17$114.N_SYMB$1;
                ;
                ub=new Common$size(((UtModule)(CUR$.SL$)).inspect$17$114).RESULT$;
                ;
                // JavaLine 370 <== SourceLine 274
                while((i<=(ub))) {
                    {
                        i=Math.addExact(i,1);
                        ;
                        // JavaLine 375 <== SourceLine 275
                        ihi=Math.addExact(ihi,1);
                        ;
                        // JavaLine 378 <== SourceLine 276
                        {
                            // BEGIN INSPECTION 
                            ((UtModule)(CUR$.SL$)).inspect$276$135=((UtModule)(CUR$.SL$)).inspect$17$114.symtab.Elt[ihi-((UtModule)(CUR$.SL$)).inspect$17$114.symtab.LB[0]];
                            if(((UtModule)(CUR$.SL$)).inspect$276$135!=null) // INSPECT inspect$276$135
                            // JavaLine 383 <== SourceLine 278
                            {
                                // BEGIN INSPECTION 
                                ((UtModule)(CUR$.SL$)).inspect$278$136=((UtModule)(CUR$.SL$)).inspect$276$135.curmeaning;
                                //INSPECT inspect$278$136
                                if(((UtModule)(CUR$.SL$)).inspect$278$136 instanceof Common$macro) // WHEN Common$macro DO 
                                if(VALUE$(((Common$macro)(((UtModule)(CUR$.SL$)).inspect$278$136)).p2$visible)) {
                                    // JavaLine 390 <== SourceLine 279
                                    {
                                        new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.M_MACRO$1);
                                        ;
                                        new OuptFile$outstring(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$276$135.symbol);
                                        ;
                                        new OuptFile$outnumber(((UtModule)(CUR$.SL$)).inspect$17$115,((Common$macro)(((UtModule)(CUR$.SL$)).inspect$278$136)).p3$npar);
                                        ;
                                        // JavaLine 398 <== SourceLine 280
                                        if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                                            new OuptFile$outcode(((UtModule)(CUR$.SL$)).inspect$17$115);
                                        }
                                        ;
                                        // JavaLine 403 <== SourceLine 281
                                        xlnk=((Common$macro)((UtModule)(CUR$.SL$)).inspect$278$136).first();
                                        ;
                                        // JavaLine 406 <== SourceLine 282
                                        while(true) {
                                            // JavaLine 408 <== SourceLine 283
                                            {
                                                // JavaLine 410 <== SourceLine 284
                                                {
                                                    // BEGIN INSPECTION 
                                                    ((UtModule)(CUR$.SL$)).inspect$284$137=xlnk;
                                                    //INSPECT inspect$284$137
                                                    if(((UtModule)(CUR$.SL$)).inspect$284$137 instanceof Common$macro_symbol) // WHEN Common$macro_symbol DO 
                                                    // JavaLine 416 <== SourceLine 285
                                                    {
                                                        new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.M_MARK$1);
                                                        ;
                                                        // JavaLine 420 <== SourceLine 286
                                                        new OuptFile$outstring(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.symtab.Elt[((Common$macro_symbol)(((UtModule)(CUR$.SL$)).inspect$284$137)).p2$box.id-((UtModule)(CUR$.SL$)).inspect$17$114.symtab.LB[0]].symbol);
                                                        ;
                                                        // JavaLine 423 <== SourceLine 287
                                                        new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((Common$macro_symbol)(((UtModule)(CUR$.SL$)).inspect$284$137)).p2$s);
                                                        ;
                                                        new OuptFile$outstring(((UtModule)(CUR$.SL$)).inspect$17$115,((Common$macro_symbol)(((UtModule)(CUR$.SL$)).inspect$284$137)).p2$v);
                                                        ;
                                                        // JavaLine 428 <== SourceLine 288
                                                        if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                                                            new OuptFile$outcode(((UtModule)(CUR$.SL$)).inspect$17$115);
                                                        }
                                                        ;
                                                    }
                                                    else if(((UtModule)(CUR$.SL$)).inspect$284$137 instanceof Common$macro_param) // WHEN Common$macro_param DO 
                                                    // JavaLine 435 <== SourceLine 291
                                                    {
                                                        new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.M_MPAR$1);
                                                        ;
                                                        new OuptFile$outnumber(((UtModule)(CUR$.SL$)).inspect$17$115,((Common$macro_param)(((UtModule)(CUR$.SL$)).inspect$284$137)).p2$n);
                                                        ;
                                                        // JavaLine 441 <== SourceLine 292
                                                        if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                                                            new OuptFile$outcode(((UtModule)(CUR$.SL$)).inspect$17$115);
                                                        }
                                                        ;
                                                    }
                                                    else // OTHERWISE 
                                                    // JavaLine 448 <== SourceLine 294
                                                    GOTO$(MACX); // GOTO EVALUATED LABEL
                                                }
                                                ;
                                                // JavaLine 452 <== SourceLine 295
                                                xlnk=xlnk.suc();
                                                ;
                                            }
                                            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                                        }
                                        ;
                                        // JavaLine 459 <== SourceLine 297
                                        LABEL$(5,"MACX");
                                        new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.M_ENDMACRO$1);
                                        ;
                                        // JavaLine 463 <== SourceLine 298
                                        if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                                            new OuptFile$outcode(((UtModule)(CUR$.SL$)).inspect$17$115);
                                        }
                                        ;
                                    }
                                }
                                else if(((UtModule)(CUR$.SL$)).inspect$278$136 instanceof Common$mnemonic) // WHEN Common$mnemonic DO 
                                // JavaLine 471 <== SourceLine 300
                                if(VALUE$(((Common$mnemonic)(((UtModule)(CUR$.SL$)).inspect$278$136)).p2$visible)) {
                                    // JavaLine 473 <== SourceLine 301
                                    {
                                        new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.M_DEFINE$1);
                                        ;
                                        new OuptFile$outstring(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$276$135.symbol);
                                        ;
                                        // JavaLine 479 <== SourceLine 302
                                        {
                                            // BEGIN INSPECTION 
                                            ((UtModule)(CUR$.SL$)).inspect$302$138=((Common$macro_symbol)(((Common$mnemonic)((UtModule)(CUR$.SL$)).inspect$278$136).first()));
                                            if(((UtModule)(CUR$.SL$)).inspect$302$138!=null) // INSPECT inspect$302$138
                                            // JavaLine 484 <== SourceLine 303
                                            {
                                                new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$302$138.p2$s);
                                                ;
                                                new OuptFile$outstring(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$302$138.p2$v);
                                            }
                                        }
                                        ;
                                        // JavaLine 492 <== SourceLine 304
                                        if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                                            new OuptFile$outcode(((UtModule)(CUR$.SL$)).inspect$17$115);
                                        }
                                        ;
                                    }
                                }
                            }
                        }
                        ;
                    }
                }
                ;
                // JavaLine 505 <== SourceLine 308
                new OuptFile$outbyt(((UtModule)(CUR$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$)).inspect$17$114.M_END$1);
                ;
                // JavaLine 508 <== SourceLine 309
                if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                    new OuptFile$outcode(((UtModule)(CUR$.SL$)).inspect$17$115);
                }
                ;
                // JavaLine 513 <== SourceLine 310
                ((OuptFile)((UtModule)(CUR$.SL$)).inspect$17$115).close();
                ;
                // JavaLine 516 <== SourceLine 311
                if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$114.module_trace$1>(0)))) {
                    {
                        // BEGIN INSPECTION 
                        ((UtModule)(CUR$.SL$)).inspect$311$139=sysout();
                        if(((UtModule)(CUR$.SL$)).inspect$311$139!=null) // INSPECT inspect$311$139
                        // JavaLine 522 <== SourceLine 312
                        {
                            // JavaLine 524 <== SourceLine 313
                            ((UtModule)(CUR$.SL$)).inspect$311$139.outtext(CONC(CONC(new TXT$("************  End of  -  Output-module  "),((UtModule)(CUR$.SL$)).p$modid),new TXT$("   ************")));
                            ;
                            ((UtModule)(CUR$.SL$)).inspect$311$139.outimage();
                            ;
                        }
                    }
                }
                ;
                // JavaLine 533 <== SourceLine 317
                if(VALUE$((((UtModule)(CUR$.SL$)).inspect$17$114.option.Elt[rank('Y')-((UtModule)(CUR$.SL$)).inspect$17$114.option.LB[0]]!=(0)))) {
                    {
                        // BEGIN INSPECTION 
                        ((UtModule)(CUR$.SL$)).inspect$317$140=sysout();
                        if(((UtModule)(CUR$.SL$)).inspect$317$140!=null) // INSPECT inspect$317$140
                        // JavaLine 539 <== SourceLine 318
                        {
                            ((UtModule)(CUR$.SL$)).inspect$317$140.outimage();
                            ;
                            ((UtModule)(CUR$.SL$)).inspect$317$140.outimage();
                            ;
                            // JavaLine 545 <== SourceLine 319
                            ((UtModule)(CUR$.SL$)).inspect$317$140.outtext(new TXT$("External tags:"));
                            ;
                            ((UtModule)(CUR$.SL$)).inspect$317$140.outint(nxtag,5);
                            ;
                            // JavaLine 550 <== SourceLine 320
                            ((UtModule)(CUR$.SL$)).inspect$317$140.outimage();
                            ;
                        }
                    }
                }
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock19:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock19:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock19:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of SubBlock Statements
    public static PROGINFO$ INFO$=new PROGINFO$("UTMODULE.sim","SubBlock SubBlock19",1,19,9,228,11,236,13,238,15,267,17,297,20,19,22,20,25,21,27,22,33,23,36,24,50,178,56,179,58,180,61,181,70,186,76,187,78,188,83,189,90,191,93,192,98,193,103,194,108,197,110,198,114,199,117,200,119,201,123,202,128,206,131,207,136,209,142,210,146,211,151,212,153,214,159,217,165,218,172,221,178,222,181,223,186,224,189,225,195,226,203,227,209,228,213,229,219,230,223,231,228,232,231,233,237,234,245,235,251,236,257,237,263,238,267,239,274,242,280,243,283,244,290,247,293,248,297,249,301,250,305,251,310,252,313,253,316,254,321,255,326,258,330,259,333,260,338,262,347,265,350,267,357,269,360,270,365,273,370,274,375,275,378,276,383,278,390,279,398,280,403,281,406,282,408,283,410,284,416,285,420,286,423,287,428,288,435,291,441,292,448,294,452,295,459,297,463,298,471,300,473,301,479,302,484,303,492,304,505,308,508,309,513,310,516,311,522,312,524,313,533,317,539,318,545,319,550,320,573,323);
} // End of SubBlock
