// JavaLine 1 <== SourceLine 159
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:53 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$out_descr extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=159, lastLine=398, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$descr p$d;
    // Declare local labels
    // JavaLine 11 <== SourceLine 232
    final LABQNT$ ATRX=new LABQNT$(this,1,"ATRX"); // Local Label #1=ATRX
    // JavaLine 13 <== SourceLine 241
    final LABQNT$ VTRX=new LABQNT$(this,2,"VTRX"); // Local Label #2=VTRX
    // JavaLine 15 <== SourceLine 242
    final LABQNT$ VREX=new LABQNT$(this,3,"VREX"); // Local Label #3=VREX
    // JavaLine 17 <== SourceLine 264
    final LABQNT$ ATREX=new LABQNT$(this,4,"ATREX"); // Local Label #4=ATREX
    // JavaLine 19 <== SourceLine 272
    final LABQNT$ VATRX=new LABQNT$(this,5,"VATRX"); // Local Label #5=VATRX
    // JavaLine 21 <== SourceLine 274
    final LABQNT$ VAREX=new LABQNT$(this,6,"VAREX"); // Local Label #6=VAREX
    // Declare locals as attributes
    // JavaLine 24 <== SourceLine 160
    Common$quant a=null;
    Common$record p=null;
    Common$variant v=null;
    // JavaLine 28 <== SourceLine 161
    Common$profile profil=null;
    Linkage$ dentry=null;
    // JavaLine 31 <== SourceLine 162
    boolean vx=false;
    int typ=0;
    // JavaLine 34 <== SourceLine 203
    Common$descr inspect$203$165=null;
    // JavaLine 36 <== SourceLine 209
    PrintFile$ inspect$208$166=null;
    // JavaLine 38 <== SourceLine 214
    Linkage$ inspect$213$167=null;
    // JavaLine 40 <== SourceLine 226
    Common$quant inspect$226$168=null;
    // JavaLine 42 <== SourceLine 233
    Common$variant inspect$233$169=null;
    // JavaLine 44 <== SourceLine 235
    Common$quant inspect$235$170=null;
    // JavaLine 46 <== SourceLine 257
    Linkage$ inspect$257$171=null;
    // JavaLine 48 <== SourceLine 261
    Common$quant inspect$261$172=null;
    // JavaLine 50 <== SourceLine 265
    Common$variant inspect$265$173=null;
    // JavaLine 52 <== SourceLine 269
    Common$quant inspect$269$174=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$out_descr setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$out_descr.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$d=(Common$descr)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$out_descr(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$out_descr(RTObject$ SL$,Common$descr sp$d) {
        super(SL$);
        // Parameter assignment to locals
        this.p$d = sp$d;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$out_descr STM$() {
        Pass2$CompoundStatement21$SubBlock23$out_descr THIS$=(Pass2$CompoundStatement21$SubBlock23$out_descr)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 85 <== SourceLine 203
                {
                    // BEGIN INSPECTION 
                    inspect$203$165=p$d;
                    //INSPECT inspect$203$165
                    if(inspect$203$165 instanceof Common$record) // WHEN Common$record DO 
                    // JavaLine 91 <== SourceLine 204
                    if(VALUE$((((Common$record)(inspect$203$165)).tag$2==(0)))) {
                        // JavaLine 93 <== SourceLine 208
                        {
                            if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).tracemode>(3)))) {
                                {
                                    // BEGIN INSPECTION 
                                    inspect$208$166=sysout();
                                    if(inspect$208$166!=null) // INSPECT inspect$208$166
                                    // JavaLine 100 <== SourceLine 209
                                    {
                                        inspect$208$166.outtext(CONC(new TXT$("Begin prepare "),((Common$record)(inspect$203$165)).symb$2.symbol));
                                        ;
                                        // JavaLine 104 <== SourceLine 210
                                        inspect$208$166.outimage();
                                        ;
                                    }
                                }
                            }
                            ;
                            // JavaLine 111 <== SourceLine 212
                            if(VALUE$((((Common$record)(inspect$203$165)).prefbox$3!=(null)))) {
                                // JavaLine 113 <== SourceLine 213
                                {
                                    {
                                        // BEGIN INSPECTION 
                                        inspect$213$167=((Common$record)(inspect$203$165)).prefbox$3.curmeaning;
                                        //INSPECT inspect$213$167
                                        if(inspect$213$167 instanceof Common$record) // WHEN Common$record DO 
                                        // JavaLine 120 <== SourceLine 215
                                        {
                                            if(VALUE$((((Common$record)(inspect$213$167)).tag$2==(0)))) {
                                                // JavaLine 123 <== SourceLine 216
                                                new Pass2$CompoundStatement21$SubBlock23$out_descr(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$record)inspect$213$167));
                                            }
                                            ;
                                            // JavaLine 127 <== SourceLine 218
                                            ((Common$record)(p$d)).indefinite$3=((Common$record)(inspect$213$167)).indefinite$3;
                                            ;
                                        }
                                        else // OTHERWISE 
                                        // JavaLine 132 <== SourceLine 221
                                        {
                                            new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Can't find prefix record"));
                                            ;
                                            // JavaLine 136 <== SourceLine 222
                                            ((Common$record)(inspect$203$165)).prefbox$3=null;
                                            ;
                                        }
                                    }
                                    ;
                                }
                            }
                            ;
                            // JavaLine 145 <== SourceLine 225
                            a=((Common$quant)(((Common$record)(inspect$203$165)).atrset$3.first()));
                            ;
                            // JavaLine 148 <== SourceLine 226
                            while(true) {
                                {
                                    // BEGIN INSPECTION 
                                    inspect$226$168=a;
                                    if(inspect$226$168!=null) // INSPECT inspect$226$168
                                    {
                                        a=((Common$quant)(inspect$226$168.suc()));
                                        ;
                                        // JavaLine 157 <== SourceLine 227
                                        if(VALUE$(((Common$record)(inspect$203$165)).indefinite$3)) {
                                            // JavaLine 159 <== SourceLine 228
                                            new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Indefinite rep is not last attr."));
                                        }
                                        ;
                                        // JavaLine 163 <== SourceLine 229
                                        new Pass2$CompoundStatement21$SubBlock23$out_descr$prepare_quant(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$)),((Common$quant)inspect$226$168));
                                        ;
                                        // JavaLine 166 <== SourceLine 230
                                        ((Common$record)(inspect$203$165)).indefinite$3=(inspect$226$168.count$3==(0));
                                        ;
                                    }
                                    else // OTHERWISE 
                                    // JavaLine 171 <== SourceLine 231
                                    GOTO$(ATRX); // GOTO EVALUATED LABEL
                                }
                                if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                            }
                            ;
                            // JavaLine 177 <== SourceLine 232
                            LABEL$(1,"ATRX");
                            v=((Common$variant)(((Common$record)(inspect$203$165)).variantset$3.first()));
                            ;
                            // JavaLine 181 <== SourceLine 233
                            while(true) {
                                {
                                    // BEGIN INSPECTION 
                                    inspect$233$169=v;
                                    if(inspect$233$169!=null) // INSPECT inspect$233$169
                                    {
                                        v=((Common$variant)(inspect$233$169.suc()));
                                        ;
                                        // JavaLine 190 <== SourceLine 234
                                        a=((Common$quant)(inspect$233$169.atrset$2.first()));
                                        ;
                                        // JavaLine 193 <== SourceLine 235
                                        while(true) {
                                            {
                                                // BEGIN INSPECTION 
                                                inspect$235$170=a;
                                                if(inspect$235$170!=null) // INSPECT inspect$235$170
                                                {
                                                    a=((Common$quant)(inspect$235$170.suc()));
                                                    ;
                                                    // JavaLine 202 <== SourceLine 236
                                                    if(VALUE$(((Common$record)(inspect$203$165)).indefinite$3)) {
                                                        // JavaLine 204 <== SourceLine 237
                                                        new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Indefinite rep is not last attr."));
                                                    }
                                                    ;
                                                    // JavaLine 208 <== SourceLine 238
                                                    new Pass2$CompoundStatement21$SubBlock23$out_descr$prepare_quant(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$)),((Common$quant)inspect$235$170));
                                                    ;
                                                    // JavaLine 211 <== SourceLine 239
                                                    ((Common$record)(inspect$203$165)).indefinite$3=(inspect$235$170.count$3==(0));
                                                    ;
                                                }
                                                else // OTHERWISE 
                                                // JavaLine 216 <== SourceLine 240
                                                GOTO$(VTRX); // GOTO EVALUATED LABEL
                                            }
                                            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                                        }
                                        ;
                                        // JavaLine 222 <== SourceLine 241
                                        LABEL$(2,"VTRX");
                                        ;
                                    }
                                    else // OTHERWISE 
                                    GOTO$(VREX); // GOTO EVALUATED LABEL
                                }
                                if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                            }
                            ;
                            // JavaLine 232 <== SourceLine 242
                            LABEL$(3,"VREX");
                            new Common$deftag(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$descr)inspect$203$165));
                            ;
                            // JavaLine 236 <== SourceLine 243
                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_RECORD$1);
                            ;
                            new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$record)(inspect$203$165)).tag$2);
                            ;
                            // JavaLine 241 <== SourceLine 244
                            if(VALUE$(((Common$record)(inspect$203$165)).used_as_type$3)) {
                                // JavaLine 243 <== SourceLine 245
                                {
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_INFO$1);
                                    ;
                                    ((Pass2)(CUR$.SL$.SL$)).inspect$21$143.outtext(new TXT$("TYPE"));
                                    ;
                                    // JavaLine 249 <== SourceLine 246
                                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                    }
                                    ;
                                }
                            } else
                            // JavaLine 256 <== SourceLine 248
                            if(VALUE$(((Common$record)(inspect$203$165)).packed$3)) {
                                // JavaLine 258 <== SourceLine 249
                                {
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_INFO$1);
                                    ;
                                    ((Pass2)(CUR$.SL$.SL$)).inspect$21$143.outtext(new TXT$("PACKED"));
                                    ;
                                    // JavaLine 264 <== SourceLine 250
                                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                    }
                                    ;
                                }
                            }
                            ;
                            // JavaLine 272 <== SourceLine 252
                            if(VALUE$(((Common$record)(inspect$203$165)).dynamic$3)) {
                                // JavaLine 274 <== SourceLine 253
                                {
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_INFO$1);
                                    ;
                                    ((Pass2)(CUR$.SL$.SL$)).inspect$21$143.outtext(new TXT$("DYNAMIC"));
                                    ;
                                    // JavaLine 280 <== SourceLine 254
                                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                    }
                                    ;
                                }
                            }
                            ;
                            // JavaLine 288 <== SourceLine 256
                            if(VALUE$((((Common$record)(inspect$203$165)).prefbox$3!=(null)))) {
                                // JavaLine 290 <== SourceLine 257
                                {
                                    // BEGIN INSPECTION 
                                    inspect$257$171=((Common$record)(inspect$203$165)).prefbox$3.curmeaning;
                                    //INSPECT inspect$257$171
                                    if(inspect$257$171 instanceof Common$record) // WHEN Common$record DO 
                                    // JavaLine 296 <== SourceLine 258
                                    {
                                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PREFIX$1);
                                        ;
                                        new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$record)(inspect$257$171)).tag$2);
                                    }
                                }
                            }
                            ;
                            // JavaLine 305 <== SourceLine 259
                            if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                            }
                            ;
                            // JavaLine 310 <== SourceLine 260
                            a=((Common$quant)(((Common$record)(inspect$203$165)).atrset$3.first()));
                            ;
                            // JavaLine 313 <== SourceLine 261
                            while(true) {
                                {
                                    // BEGIN INSPECTION 
                                    inspect$261$172=a;
                                    if(inspect$261$172!=null) // INSPECT inspect$261$172
                                    // JavaLine 319 <== SourceLine 262
                                    {
                                        new Pass2$CompoundStatement21$SubBlock23$out_attr(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$quant)inspect$261$172));
                                        ;
                                        a=((Common$quant)(inspect$261$172.suc()));
                                        ;
                                    }
                                    else // OTHERWISE 
                                    // JavaLine 327 <== SourceLine 263
                                    GOTO$(ATREX); // GOTO EVALUATED LABEL
                                }
                                if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                            }
                            ;
                            // JavaLine 333 <== SourceLine 264
                            LABEL$(4,"ATREX");
                            v=((Common$variant)(((Common$record)(inspect$203$165)).variantset$3.first()));
                            ;
                            // JavaLine 337 <== SourceLine 265
                            while(true) {
                                {
                                    // BEGIN INSPECTION 
                                    inspect$265$173=v;
                                    if(inspect$265$173!=null) // INSPECT inspect$265$173
                                    // JavaLine 343 <== SourceLine 266
                                    {
                                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ALT$1);
                                        ;
                                        vx=true;
                                        ;
                                        // JavaLine 349 <== SourceLine 267
                                        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                        }
                                        ;
                                        // JavaLine 354 <== SourceLine 268
                                        a=((Common$quant)(inspect$265$173.atrset$2.first()));
                                        ;
                                        // JavaLine 357 <== SourceLine 269
                                        while(true) {
                                            {
                                                // BEGIN INSPECTION 
                                                inspect$269$174=a;
                                                if(inspect$269$174!=null) // INSPECT inspect$269$174
                                                // JavaLine 363 <== SourceLine 270
                                                {
                                                    new Pass2$CompoundStatement21$SubBlock23$out_attr(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),a);
                                                    ;
                                                    a=((Common$quant)(inspect$269$174.suc()));
                                                    ;
                                                }
                                                else // OTHERWISE 
                                                // JavaLine 371 <== SourceLine 271
                                                GOTO$(VATRX); // GOTO EVALUATED LABEL
                                            }
                                            if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                                        }
                                        ;
                                        // JavaLine 377 <== SourceLine 272
                                        LABEL$(5,"VATRX");
                                        v=((Common$variant)(inspect$265$173.suc()));
                                        ;
                                    }
                                    else // OTHERWISE 
                                    // JavaLine 383 <== SourceLine 273
                                    GOTO$(VAREX); // GOTO EVALUATED LABEL
                                }
                                if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                            }
                            ;
                            // JavaLine 389 <== SourceLine 274
                            LABEL$(6,"VAREX");
                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ENDRECORD$1);
                            ;
                            // JavaLine 393 <== SourceLine 275
                            if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                            }
                            ;
                        }
                    }
                    else if(inspect$203$165 instanceof Common$peculiar) // WHEN Common$peculiar DO 
                    // JavaLine 401 <== SourceLine 279
                    {
                        new Pass2$CompoundStatement21$SubBlock23$out_descr$prep_parspec(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$)),((Common$peculiar)(inspect$203$165)).spec$3);
                        ;
                        // JavaLine 405 <== SourceLine 280
                        new Common$defpeculiar(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$peculiar)inspect$203$165));
                        ;
                        // JavaLine 408 <== SourceLine 281
                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PROFILE$1);
                        ;
                        new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$peculiar)(inspect$203$165)).tag$2);
                        ;
                        // JavaLine 413 <== SourceLine 282
                        if(VALUE$((((Common$peculiar)(inspect$203$165)).p4$kind==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_KNOWN$1)))) {
                            // JavaLine 415 <== SourceLine 283
                            {
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_KNOWN$1);
                                ;
                                new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$peculiar)(inspect$203$165)).body$4);
                                ;
                                // JavaLine 421 <== SourceLine 285
                                new OuptFile$outstring(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$peculiar)(inspect$203$165)).info$4);
                            }
                        } else
                        if(VALUE$((((Common$peculiar)(inspect$203$165)).p4$kind==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_SYSRUT$1)))) {
                            // JavaLine 426 <== SourceLine 286
                            {
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_SYSTEM$1);
                                ;
                                new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$peculiar)(inspect$203$165)).body$4);
                                ;
                                // JavaLine 432 <== SourceLine 288
                                new OuptFile$outstring(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$peculiar)(inspect$203$165)).info$4);
                            }
                        } else
                        if(VALUE$((((Common$peculiar)(inspect$203$165)).p4$kind==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_EXTERNAL$1)))) {
                            // JavaLine 437 <== SourceLine 289
                            {
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_EXTERNAL$1);
                                ;
                                new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$peculiar)(inspect$203$165)).body$4);
                                ;
                                // JavaLine 443 <== SourceLine 290
                                new OuptFile$outstring(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$peculiar)(inspect$203$165)).info$4);
                                ;
                                // JavaLine 446 <== SourceLine 291
                                new OuptFile$outstring(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$peculiar)(inspect$203$165)).symb$2.symbol);
                                ;
                            }
                        }
                        ;
                        // JavaLine 452 <== SourceLine 293
                        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                        }
                        ;
                        // JavaLine 457 <== SourceLine 294
                        new Pass2$CompoundStatement21$SubBlock23$out_parspec(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$peculiar)(inspect$203$165)).spec$3);
                        ;
                        // JavaLine 460 <== SourceLine 295
                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ENDPROFILE$1);
                        ;
                        // JavaLine 463 <== SourceLine 296
                        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                        }
                        ;
                        // JavaLine 468 <== SourceLine 297
                        if(VALUE$((((Common$peculiar)(inspect$203$165)).p4$kind==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ROUTINE$1)))) {
                            // JavaLine 470 <== SourceLine 298
                            {
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ROUTINESPEC$1);
                                ;
                                new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$peculiar)(inspect$203$165)).body$4);
                                ;
                                // JavaLine 476 <== SourceLine 299
                                if(VALUE$(((Common$peculiar)(inspect$203$165)).libProc$3)) {
                                    // JavaLine 478 <== SourceLine 300
                                    new OuptFile$outentry(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$peculiar)(inspect$203$165)).tag$2);
                                } else
                                new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$peculiar)(inspect$203$165)).tag$2);
                                ;
                                // JavaLine 483 <== SourceLine 301
                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                }
                                ;
                            }
                        }
                        ;
                    }
                    else if(inspect$203$165 instanceof Common$profile) // WHEN Common$profile DO 
                    // JavaLine 493 <== SourceLine 306
                    {
                        new Pass2$CompoundStatement21$SubBlock23$out_descr$prep_parspec(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$)),((Common$profile)(inspect$203$165)).spec$3);
                        ;
                        // JavaLine 497 <== SourceLine 307
                        new Common$deftag(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$descr)inspect$203$165));
                        ;
                        // JavaLine 500 <== SourceLine 308
                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PROFILE$1);
                        ;
                        new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$profile)(inspect$203$165)).tag$2);
                        ;
                        // JavaLine 505 <== SourceLine 309
                        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                        }
                        ;
                        // JavaLine 510 <== SourceLine 310
                        if(VALUE$(((Common$profile)(inspect$203$165)).interface$$3)) {
                            // JavaLine 512 <== SourceLine 311
                            {
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_INTERFACE$1);
                                ;
                                ((Pass2)(CUR$.SL$.SL$)).inspect$21$143.outtext(new TXT$("INTRHA"));
                                ;
                                // JavaLine 518 <== SourceLine 312
                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                }
                                ;
                            }
                        }
                        ;
                        // JavaLine 526 <== SourceLine 314
                        new Pass2$CompoundStatement21$SubBlock23$out_parspec(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$profile)(inspect$203$165)).spec$3);
                        ;
                        // JavaLine 529 <== SourceLine 315
                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ENDPROFILE$1);
                        ;
                        // JavaLine 532 <== SourceLine 316
                        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                        }
                        ;
                    }
                    else if(inspect$203$165 instanceof Common$routine) // WHEN Common$routine DO 
                    // JavaLine 539 <== SourceLine 319
                    {
                        new Common$deftag(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$descr)inspect$203$165));
                        ;
                        // JavaLine 543 <== SourceLine 320
                        dentry=((Common$routine)(inspect$203$165)).profbox$3.curmeaning;
                        ;
                        // JavaLine 546 <== SourceLine 321
                        if(VALUE$((!(IS$(dentry,Common$profile.class))))) {
                            // JavaLine 548 <== SourceLine 322
                            dentry=new Pass2$CompoundStatement21$SubBlock23$get_prf(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$routine)(inspect$203$165)).profbox$3.id).RESULT$;
                        }
                        ;
                        // JavaLine 552 <== SourceLine 323
                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ROUTINESPEC$1);
                        ;
                        new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$routine)(inspect$203$165)).tag$2);
                        ;
                        // JavaLine 557 <== SourceLine 324
                        new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$profile)(dentry)).tag$2);
                        ;
                        // JavaLine 560 <== SourceLine 325
                        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                        }
                        ;
                    }
                    else if(inspect$203$165 instanceof Common$label_descr) // WHEN Common$label_descr DO 
                    // JavaLine 567 <== SourceLine 329
                    {
                        new Common$deftag(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$descr)inspect$203$165));
                        ;
                        // JavaLine 571 <== SourceLine 330
                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_LABELSPEC$1);
                        ;
                        new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$label_descr)(inspect$203$165)).tag$2);
                        ;
                        // JavaLine 576 <== SourceLine 331
                        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                        }
                        ;
                    }
                    else if(inspect$203$165 instanceof Common$quant) // WHEN Common$quant DO 
                    // JavaLine 583 <== SourceLine 334
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.rutlev$1>(0)))) {
                        // JavaLine 585 <== SourceLine 336
                        {
                            if(VALUE$((!(((Common$quant)(inspect$203$165)).preped$3)))) {
                                new Pass2$CompoundStatement21$SubBlock23$out_descr$prepare_quant(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$)),((Common$quant)inspect$203$165));
                            }
                            ;
                            // JavaLine 591 <== SourceLine 337
                            new Common$deftag(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$descr)inspect$203$165));
                            ;
                            // JavaLine 594 <== SourceLine 338
                            if(VALUE$(((((Common$quant)(inspect$203$165)).initval$3!=(null))|(((Common$quant)(inspect$203$165)).read_only$3)))) {
                                // JavaLine 596 <== SourceLine 339
                                new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,CONC(new TXT$("Illegal declaration of "),((Common$quant)(inspect$203$165)).symb$2.symbol));
                            }
                            ;
                            // JavaLine 600 <== SourceLine 340
                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_LOCAL$1);
                            ;
                            new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$quant)(inspect$203$165)).tag$2);
                            ;
                            // JavaLine 605 <== SourceLine 341
                            new Pass2$CompoundStatement21$SubBlock23$outquant(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$quant)inspect$203$165));
                            ;
                            // JavaLine 608 <== SourceLine 342
                            if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                            }
                            ;
                        }
                    } else
                    // JavaLine 615 <== SourceLine 344
                    if(VALUE$(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.global_module$1)) {
                        // JavaLine 617 <== SourceLine 346
                        {
                            if(VALUE$((!(((Common$quant)(inspect$203$165)).preped$3)))) {
                                new Pass2$CompoundStatement21$SubBlock23$out_descr$prepare_quant(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$)),((Common$quant)inspect$203$165));
                            }
                            ;
                            // JavaLine 623 <== SourceLine 347
                            new Common$deftag(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$descr)inspect$203$165));
                            ;
                            // JavaLine 626 <== SourceLine 348
                            if(VALUE$(((Common$quant)(inspect$203$165)).read_only$3)) {
                                // JavaLine 628 <== SourceLine 360
                                new Pass2$CompoundStatement21$SubBlock23$out_descr$CompoundStatement346$SubBlock349((CUR$)).STM$();
                            } else
                            // JavaLine 631 <== SourceLine 361
                            {
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_GLOBAL$1);
                                ;
                                new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$quant)(inspect$203$165)).tag$2);
                                ;
                                // JavaLine 637 <== SourceLine 362
                                new Pass2$CompoundStatement21$SubBlock23$outquant(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$quant)inspect$203$165));
                                ;
                            }
                            ;
                            // JavaLine 642 <== SourceLine 364
                            if(VALUE$(TXTREL$NE(((Common$quant)(inspect$203$165)).sysid$3,null))) {
                                // JavaLine 644 <== SourceLine 365
                                {
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_SYSTEM$1);
                                    ;
                                    new OuptFile$outstring(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$quant)(inspect$203$165)).sysid$3);
                                }
                            }
                            ;
                            // JavaLine 652 <== SourceLine 366
                            if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                            }
                            ;
                        }
                    } else
                    // JavaLine 659 <== SourceLine 370
                    {
                        if(VALUE$(((((Common$quant)(inspect$203$165)).initval$3!=(null))&(((Common$quant)(inspect$203$165)).read_only$3)))) {
                            // JavaLine 662 <== SourceLine 371
                            {
                                if(VALUE$((!(((Common$quant)(inspect$203$165)).preped$3)))) {
                                    new Pass2$CompoundStatement21$SubBlock23$out_descr$prepare_quant(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$)),((Common$quant)inspect$203$165));
                                }
                                ;
                                // JavaLine 668 <== SourceLine 372
                                new Common$deftag(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$descr)inspect$203$165));
                                ;
                                // JavaLine 671 <== SourceLine 373
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_CONSTSPEC$1);
                                ;
                                new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$quant)(inspect$203$165)).tag$2);
                                ;
                                // JavaLine 676 <== SourceLine 374
                                new Pass2$CompoundStatement21$SubBlock23$outquant(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$quant)inspect$203$165));
                                ;
                                // JavaLine 679 <== SourceLine 375
                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                }
                                ;
                            }
                        } else
                        // JavaLine 686 <== SourceLine 377
                        if(VALUE$((!(((Common$quant)(inspect$203$165)).visible$2)))) {
                            // JavaLine 688 <== SourceLine 378
                            {
                                if(VALUE$(TRF_EQ(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.module_ident$1,null))) {
                                    // JavaLine 691 <== SourceLine 379
                                    {
                                        if(VALUE$((!(((Common$quant)(inspect$203$165)).preped$3)))) {
                                            new Pass2$CompoundStatement21$SubBlock23$out_descr$prepare_quant(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$)),((Common$quant)inspect$203$165));
                                        }
                                        ;
                                        // JavaLine 697 <== SourceLine 380
                                        new Common$deftag(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$descr)inspect$203$165));
                                        ;
                                        // JavaLine 700 <== SourceLine 381
                                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_LOCAL$1);
                                        ;
                                        new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$quant)(inspect$203$165)).tag$2);
                                        ;
                                        // JavaLine 705 <== SourceLine 382
                                        new Pass2$CompoundStatement21$SubBlock23$outquant(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$quant)inspect$203$165));
                                        ;
                                        // JavaLine 708 <== SourceLine 383
                                        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                        }
                                        ;
                                    }
                                } else
                                // JavaLine 715 <== SourceLine 387
                                new Common$quant_notice(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$quant)inspect$203$165)).STM$().into(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.localdecl$1);
                            }
                        } else
                        // JavaLine 719 <== SourceLine 388
                        {
                            if(VALUE$((!(((Common$quant)(inspect$203$165)).preped$3)))) {
                                new Pass2$CompoundStatement21$SubBlock23$out_descr$prepare_quant(((Pass2$CompoundStatement21$SubBlock23$out_descr)(CUR$)),((Common$quant)inspect$203$165));
                            }
                            ;
                            // JavaLine 725 <== SourceLine 389
                            new Common$deftag(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$descr)inspect$203$165));
                            ;
                            // JavaLine 728 <== SourceLine 390
                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_GLOBAL$1);
                            ;
                            // JavaLine 731 <== SourceLine 392
                            new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,CONC(new TXT$("Illegal global declaration of "),((Common$quant)(inspect$203$165)).symb$2.symbol));
                            ;
                            // JavaLine 734 <== SourceLine 393
                            new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$quant)(inspect$203$165)).tag$2);
                            ;
                            new Pass2$CompoundStatement21$SubBlock23$outquant(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$quant)inspect$203$165));
                            ;
                            // JavaLine 739 <== SourceLine 394
                            if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                            }
                            ;
                        }
                        ;
                    }
                    else // OTHERWISE 
                    // JavaLine 748 <== SourceLine 397
                    if(VALUE$((!(IS$(p$d,Common$dest_descr.class))))) {
                        new Common$IERR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141);
                    }
                }
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("out_descr:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("out_descr:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("out_descr:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure out_descr",1,159,11,232,13,241,15,242,17,264,19,272,21,274,24,160,28,161,31,162,34,203,36,209,38,214,40,226,42,233,44,235,46,257,48,261,50,265,52,269,85,203,91,204,93,208,100,209,104,210,111,212,113,213,120,215,123,216,127,218,132,221,136,222,145,225,148,226,157,227,159,228,163,229,166,230,171,231,177,232,181,233,190,234,193,235,202,236,204,237,208,238,211,239,216,240,222,241,232,242,236,243,241,244,243,245,249,246,256,248,258,249,264,250,272,252,274,253,280,254,288,256,290,257,296,258,305,259,310,260,313,261,319,262,327,263,333,264,337,265,343,266,349,267,354,268,357,269,363,270,371,271,377,272,383,273,389,274,393,275,401,279,405,280,408,281,413,282,415,283,421,285,426,286,432,288,437,289,443,290,446,291,452,293,457,294,460,295,463,296,468,297,470,298,476,299,478,300,483,301,493,306,497,307,500,308,505,309,510,310,512,311,518,312,526,314,529,315,532,316,539,319,543,320,546,321,548,322,552,323,557,324,560,325,567,329,571,330,576,331,583,334,585,336,591,337,594,338,596,339,600,340,605,341,608,342,615,344,617,346,623,347,626,348,628,360,631,361,637,362,642,364,644,365,652,366,659,370,662,371,668,372,671,373,676,374,679,375,686,377,688,378,691,379,697,380,700,381,705,382,708,383,715,387,719,388,725,389,728,390,731,392,734,393,739,394,748,397,770,398);
} // End of Procedure
