// JavaLine 1 <== SourceLine 27
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:47 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InModule$CompoundStatement23$SubBlock27 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=2, firstLine=27, lastLine=295, hasLocalClasses=false, System=false
    // Declare local labels
    // JavaLine 9 <== SourceLine 193
    final LABQNT$ LX1=new LABQNT$(this,1,"LX1"); // Local Label #1=LX1
    // JavaLine 11 <== SourceLine 199
    final LABQNT$ LX2=new LABQNT$(this,2,"LX2"); // Local Label #2=LX2
    // JavaLine 13 <== SourceLine 236
    final LABQNT$ PECUL=new LABQNT$(this,3,"PECUL"); // Local Label #3=PECUL
    // JavaLine 15 <== SourceLine 250
    final LABQNT$ EXDESCR=new LABQNT$(this,4,"EXDESCR"); // Local Label #4=EXDESCR
    // JavaLine 17 <== SourceLine 282
    final LABQNT$ EXMCRO=new LABQNT$(this,5,"EXMCRO"); // Local Label #5=EXMCRO
    // JavaLine 19 <== SourceLine 295
    final LABQNT$ MXX=new LABQNT$(this,6,"MXX"); // Local Label #6=MXX
    // Declare locals as attributes
    // JavaLine 22 <== SourceLine 27
    int i=0;
    // JavaLine 24 <== SourceLine 28
    int istr=0;
    // JavaLine 26 <== SourceLine 30
    Common$quant qnt=null;
    // JavaLine 28 <== SourceLine 31
    Common$peculiar pculiar=null;
    // JavaLine 30 <== SourceLine 32
    Common$mnemonic mnem=null;
    Common$macro mcro=null;
    // Normal Constructor
    public InModule$CompoundStatement23$SubBlock27(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        InModule$CompoundStatement23$SubBlock27 THIS$=(InModule$CompoundStatement23$SubBlock27)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 45 <== SourceLine 155
                if(VALUE$((((InModule)(CUR$.SL$)).inspect$22$42.module_trace$1>(0)))) {
                    {
                        // BEGIN INSPECTION 
                        ((InModule)(CUR$.SL$)).inspect$155$50=sysout();
                        if(((InModule)(CUR$.SL$)).inspect$155$50!=null) // INSPECT inspect$155$50
                        // JavaLine 51 <== SourceLine 156
                        {
                            // JavaLine 53 <== SourceLine 157
                            ((InModule)(CUR$.SL$)).inspect$155$50.outtext(CONC(CONC(new TXT$("*************    Begin  -  Input-module  "),((InModule)(CUR$.SL$)).inspect$23$44.p2$modid),new TXT$("   **************")));
                            ;
                            ((InModule)(CUR$.SL$)).inspect$155$50.outimage();
                            ;
                            // JavaLine 58 <== SourceLine 158
                            ((InModule)(CUR$.SL$)).inspect$22$43.input_trace$3=((InModule)(CUR$.SL$)).inspect$22$42.module_trace$1;
                            ;
                        }
                    }
                }
                ;
                // JavaLine 65 <== SourceLine 160
                istr=new InModule$CompoundStatement23$SubBlock27$inAbyte(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$;
                ;
                // JavaLine 68 <== SourceLine 161
                if(VALUE$((istr!=(((InModule)(CUR$.SL$)).inspect$22$42.M_MODULE$1)))) {
                    // JavaLine 70 <== SourceLine 162
                    new InModule$CompoundStatement23$SubBlock27$MERR(((InModule$CompoundStatement23$SubBlock27)(CUR$)),CONC(new TXT$("M_MODULE:"),new Common$leftint(((InModule)(CUR$.SL$)).inspect$22$42,istr).RESULT$));
                }
                ;
                // JavaLine 74 <== SourceLine 163
                ((InModule)(CUR$.SL$)).inspect$23$44.modcode$2=new InptFile$instring(((InModule)(CUR$.SL$)).inspect$22$43).RESULT$;
                ;
                // JavaLine 77 <== SourceLine 164
                if(VALUE$(TXTREL$NE(((InModule)(CUR$.SL$)).inspect$23$44.modcode$2,new TXT$("V2.0")))) {
                    new InModule$CompoundStatement23$SubBlock27$MERR(((InModule$CompoundStatement23$SubBlock27)(CUR$)),CONC(new TXT$("checkcode:"),((InModule)(CUR$.SL$)).inspect$23$44.modcode$2));
                }
                ;
                // JavaLine 82 <== SourceLine 165
                ((InModule)(CUR$.SL$)).inspect$23$44.modcode$2=new InptFile$instring(((InModule)(CUR$.SL$)).inspect$22$43).RESULT$;
                ;
                // JavaLine 85 <== SourceLine 166
                if(VALUE$(TXTREL$NE(((InModule)(CUR$.SL$)).inspect$23$44.modcode$2,((InModule)(CUR$.SL$)).inspect$23$44.p2$modid))) {
                    new InModule$CompoundStatement23$SubBlock27$MERR(((InModule$CompoundStatement23$SubBlock27)(CUR$)),CONC(new TXT$("modid:"),((InModule)(CUR$.SL$)).inspect$23$44.modcode$2));
                }
                ;
                // JavaLine 90 <== SourceLine 167
                ((InModule)(CUR$.SL$)).inspect$23$44.modcode$2=new InptFile$instring(((InModule)(CUR$.SL$)).inspect$22$43).RESULT$;
                ;
                // JavaLine 93 <== SourceLine 170
                while(true) {
                    // JavaLine 95 <== SourceLine 171
                    {
                        istr=new InModule$CompoundStatement23$SubBlock27$inAbyte(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$;
                        ;
                        // JavaLine 99 <== SourceLine 172
                        switch(istr) { // BEGIN SWITCH STATEMENT
                        case 36: 
                        // JavaLine 102 <== SourceLine 174
                        GOTO$(EXDESCR); // GOTO EVALUATED LABEL
                        break;
                        case 21: 
                        // JavaLine 106 <== SourceLine 176
                        {
                            // BEGIN INSPECTION 
                            ((InModule)(CUR$.SL$)).inspect$176$51=new Common$quant(((InModule)(CUR$.SL$)).inspect$22$42,new InModule$CompoundStatement23$SubBlock27$intype(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$).STM$();
                            if(((InModule)(CUR$.SL$)).inspect$176$51!=null) // INSPECT inspect$176$51
                            // JavaLine 111 <== SourceLine 177
                            {
                                ((InModule)(CUR$.SL$)).inspect$176$51.tag$2=new InModule$CompoundStatement23$SubBlock27$intag(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$;
                                ;
                                ((InModule)(CUR$.SL$)).inspect$176$51.symb$2=((InModule)(CUR$.SL$)).inspect$22$42.symtab.Elt[((InModule)(CUR$.SL$)).inspect$22$42.hash$1-((InModule)(CUR$.SL$)).inspect$22$42.symtab.LB[0]];
                                ;
                                // JavaLine 117 <== SourceLine 178
                                ((InModule)(CUR$.SL$)).inspect$176$51.count$3=new InptFile$innumber(((InModule)(CUR$.SL$)).inspect$22$43).RESULT$;
                                ;
                                ((Common$quant)((InModule)(CUR$.SL$)).inspect$176$51).into(((InModule)(CUR$.SL$)).inspect$23$44.dclset$2);
                                ;
                                // JavaLine 122 <== SourceLine 179
                                if(VALUE$((((InModule)(CUR$.SL$)).inspect$22$42.module_trace$1>(2)))) {
                                    new Common$prt(((InModule)(CUR$.SL$)).inspect$22$42,((Common$descr)((InModule)(CUR$.SL$)).inspect$176$51),20);
                                }
                                ;
                            }
                        }
                        break;
                        case 22: 
                        // JavaLine 131 <== SourceLine 182
                        {
                            // BEGIN INSPECTION 
                            ((InModule)(CUR$.SL$)).inspect$182$52=new Common$label_descr(((InModule)(CUR$.SL$)).inspect$22$42).STM$();
                            if(((InModule)(CUR$.SL$)).inspect$182$52!=null) // INSPECT inspect$182$52
                            // JavaLine 136 <== SourceLine 183
                            {
                                ((InModule)(CUR$.SL$)).inspect$182$52.tag$2=new InModule$CompoundStatement23$SubBlock27$intag(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$;
                                ;
                                ((InModule)(CUR$.SL$)).inspect$182$52.symb$2=((InModule)(CUR$.SL$)).inspect$22$42.symtab.Elt[((InModule)(CUR$.SL$)).inspect$22$42.hash$1-((InModule)(CUR$.SL$)).inspect$22$42.symtab.LB[0]];
                                ;
                                // JavaLine 142 <== SourceLine 184
                                ((Common$label_descr)((InModule)(CUR$.SL$)).inspect$182$52).into(((InModule)(CUR$.SL$)).inspect$23$44.dclset$2);
                                ;
                                // JavaLine 145 <== SourceLine 185
                                if(VALUE$((((InModule)(CUR$.SL$)).inspect$22$42.module_trace$1>(2)))) {
                                    new Common$prt(((InModule)(CUR$.SL$)).inspect$22$42,((Common$descr)((InModule)(CUR$.SL$)).inspect$182$52),20);
                                }
                                ;
                            }
                        }
                        break;
                        case 23: 
                        // JavaLine 154 <== SourceLine 188
                        {
                            // BEGIN INSPECTION 
                            ((InModule)(CUR$.SL$)).inspect$188$53=new Common$record(((InModule)(CUR$.SL$)).inspect$22$42).STM$();
                            if(((InModule)(CUR$.SL$)).inspect$188$53!=null) // INSPECT inspect$188$53
                            // JavaLine 159 <== SourceLine 189
                            {
                                ((InModule)(CUR$.SL$)).inspect$188$53.tag$2=new InModule$CompoundStatement23$SubBlock27$intag(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$;
                                ;
                                ((InModule)(CUR$.SL$)).inspect$188$53.symb$2=((InModule)(CUR$.SL$)).inspect$22$42.symtab.Elt[((InModule)(CUR$.SL$)).inspect$22$42.hash$1-((InModule)(CUR$.SL$)).inspect$22$42.symtab.LB[0]];
                                ;
                                // JavaLine 165 <== SourceLine 190
                                new InptFile$inident(((InModule)(CUR$.SL$)).inspect$22$43);
                                ;
                                if(VALUE$((((InModule)(CUR$.SL$)).inspect$22$42.symtab.Elt[((InModule)(CUR$.SL$)).inspect$22$42.hash$1-((InModule)(CUR$.SL$)).inspect$22$42.symtab.LB[0]]!=(((InModule)(CUR$.SL$)).inspect$22$42.dummyBox$1)))) {
                                    ((InModule)(CUR$.SL$)).inspect$188$53.prefbox$3=((InModule)(CUR$.SL$)).inspect$22$42.symtab.Elt[((InModule)(CUR$.SL$)).inspect$22$42.hash$1-((InModule)(CUR$.SL$)).inspect$22$42.symtab.LB[0]];
                                }
                                ;
                                // JavaLine 172 <== SourceLine 191
                                ((Common$record)((InModule)(CUR$.SL$)).inspect$188$53).into(((InModule)(CUR$.SL$)).inspect$23$44.dclset$2);
                                ;
                                // JavaLine 175 <== SourceLine 192
                                ((InModule)(CUR$.SL$)).inspect$188$53.atrset$3=new Head$(((InModule)(CUR$.SL$)).inspect$22$42).STM$();
                                ;
                                ((InModule)(CUR$.SL$)).inspect$188$53.variantset$3=new Head$(((InModule)(CUR$.SL$)).inspect$22$42).STM$();
                                ;
                                // JavaLine 180 <== SourceLine 193
                                LABEL$(1,"LX1");
                                istr=new InptFile$inbyt(((InModule)(CUR$.SL$)).inspect$22$43).RESULT$;
                                ;
                                // JavaLine 184 <== SourceLine 194
                                if(VALUE$((((InModule)(CUR$.SL$)).inspect$22$43.input_trace$3>(0)))) {
                                    new InptFile$outcode(((InModule)(CUR$.SL$)).inspect$22$43);
                                }
                                ;
                                // JavaLine 189 <== SourceLine 195
                                if(VALUE$((istr==(((InModule)(CUR$.SL$)).inspect$22$42.M_VAR$1)))) {
                                    // JavaLine 191 <== SourceLine 196
                                    {
                                        qnt=new InModule$CompoundStatement23$SubBlock27$inquant(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$;
                                        ;
                                        qnt.into(((InModule)(CUR$.SL$)).inspect$188$53.atrset$3);
                                        ;
                                        GOTO$(LX1); // GOTO EVALUATED LABEL
                                    }
                                }
                                ;
                                // JavaLine 201 <== SourceLine 197
                                while((istr==(((InModule)(CUR$.SL$)).inspect$22$42.M_ALT$1))) {
                                    {
                                        // BEGIN INSPECTION 
                                        ((InModule)(CUR$.SL$)).inspect$197$54=new Common$variant(((InModule)(CUR$.SL$)).inspect$22$42).STM$();
                                        if(((InModule)(CUR$.SL$)).inspect$197$54!=null) // INSPECT inspect$197$54
                                        // JavaLine 207 <== SourceLine 198
                                        {
                                            ((InModule)(CUR$.SL$)).inspect$197$54.into(((InModule)(CUR$.SL$)).inspect$188$53.variantset$3);
                                            ;
                                            ((InModule)(CUR$.SL$)).inspect$197$54.atrset$2=new Head$(((InModule)(CUR$.SL$)).inspect$22$42).STM$();
                                            ;
                                            // JavaLine 213 <== SourceLine 199
                                            LABEL$(2,"LX2");
                                            istr=new InptFile$inbyt(((InModule)(CUR$.SL$)).inspect$22$43).RESULT$;
                                            ;
                                            // JavaLine 217 <== SourceLine 200
                                            if(VALUE$((((InModule)(CUR$.SL$)).inspect$22$43.input_trace$3>(0)))) {
                                                new InptFile$outcode(((InModule)(CUR$.SL$)).inspect$22$43);
                                            }
                                            ;
                                            // JavaLine 222 <== SourceLine 201
                                            if(VALUE$((istr==(((InModule)(CUR$.SL$)).inspect$22$42.M_VAR$1)))) {
                                                // JavaLine 224 <== SourceLine 202
                                                {
                                                    qnt=new InModule$CompoundStatement23$SubBlock27$inquant(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$;
                                                    ;
                                                    qnt.into(((InModule)(CUR$.SL$)).inspect$197$54.atrset$2);
                                                    ;
                                                    GOTO$(LX2); // GOTO EVALUATED LABEL
                                                }
                                            }
                                            ;
                                        }
                                    }
                                }
                                ;
                                // JavaLine 238 <== SourceLine 204
                                if(VALUE$((istr!=(((InModule)(CUR$.SL$)).inspect$22$42.M_ENDRECORD$1)))) {
                                    // JavaLine 240 <== SourceLine 205
                                    new InModule$CompoundStatement23$SubBlock27$MERR(((InModule$CompoundStatement23$SubBlock27)(CUR$)),CONC(new TXT$("M_ENDRECORD:"),new Common$leftint(((InModule)(CUR$.SL$)).inspect$22$42,istr).RESULT$));
                                }
                                ;
                                // JavaLine 244 <== SourceLine 206
                                if(VALUE$((qnt!=(null)))) {
                                    ((InModule)(CUR$.SL$)).inspect$188$53.indefinite$3=(qnt.count$3==(0));
                                }
                                ;
                                // JavaLine 249 <== SourceLine 207
                                if(VALUE$((((InModule)(CUR$.SL$)).inspect$22$42.module_trace$1>(2)))) {
                                    new Common$prt(((InModule)(CUR$.SL$)).inspect$22$42,((Common$descr)((InModule)(CUR$.SL$)).inspect$188$53),20);
                                }
                                ;
                            }
                        }
                        break;
                        case 27: 
                        // JavaLine 258 <== SourceLine 210
                        {
                            // BEGIN INSPECTION 
                            ((InModule)(CUR$.SL$)).inspect$210$55=new Common$profile(((InModule)(CUR$.SL$)).inspect$22$42).STM$();
                            if(((InModule)(CUR$.SL$)).inspect$210$55!=null) // INSPECT inspect$210$55
                            // JavaLine 263 <== SourceLine 211
                            {
                                ((InModule)(CUR$.SL$)).inspect$210$55.tag$2=new InModule$CompoundStatement23$SubBlock27$intag(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$;
                                ;
                                ((InModule)(CUR$.SL$)).inspect$210$55.symb$2=((InModule)(CUR$.SL$)).inspect$22$42.symtab.Elt[((InModule)(CUR$.SL$)).inspect$22$42.hash$1-((InModule)(CUR$.SL$)).inspect$22$42.symtab.LB[0]];
                                ;
                                // JavaLine 269 <== SourceLine 212
                                ((Common$profile)((InModule)(CUR$.SL$)).inspect$210$55).into(((InModule)(CUR$.SL$)).inspect$23$44.dclset$2);
                                ;
                                ((InModule)(CUR$.SL$)).inspect$210$55.spec$3=new InModule$CompoundStatement23$SubBlock27$inparspec(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$;
                                ;
                                // JavaLine 274 <== SourceLine 213
                                if(VALUE$((((InModule)(CUR$.SL$)).inspect$22$42.module_trace$1>(2)))) {
                                    new Common$prt(((InModule)(CUR$.SL$)).inspect$22$42,((Common$descr)((InModule)(CUR$.SL$)).inspect$210$55),20);
                                }
                                ;
                            }
                        }
                        break;
                        case 26: 
                        // JavaLine 283 <== SourceLine 216
                        {
                            // BEGIN INSPECTION 
                            ((InModule)(CUR$.SL$)).inspect$216$56=new Common$profile(((InModule)(CUR$.SL$)).inspect$22$42).STM$();
                            if(((InModule)(CUR$.SL$)).inspect$216$56!=null) // INSPECT inspect$216$56
                            // JavaLine 288 <== SourceLine 217
                            {
                                ((InModule)(CUR$.SL$)).inspect$216$56.tag$2=new InModule$CompoundStatement23$SubBlock27$intag(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$;
                                ;
                                ((InModule)(CUR$.SL$)).inspect$216$56.symb$2=((InModule)(CUR$.SL$)).inspect$22$42.symtab.Elt[((InModule)(CUR$.SL$)).inspect$22$42.hash$1-((InModule)(CUR$.SL$)).inspect$22$42.symtab.LB[0]];
                                ;
                                // JavaLine 294 <== SourceLine 218
                                ((Common$profile)((InModule)(CUR$.SL$)).inspect$216$56).into(((InModule)(CUR$.SL$)).inspect$23$44.dclset$2);
                                ;
                                ((InModule)(CUR$.SL$)).inspect$216$56.spec$3=new InModule$CompoundStatement23$SubBlock27$inxparspec(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$;
                                ;
                                // JavaLine 299 <== SourceLine 219
                                if(VALUE$((((InModule)(CUR$.SL$)).inspect$22$42.module_trace$1>(2)))) {
                                    new Common$prt(((InModule)(CUR$.SL$)).inspect$22$42,((Common$descr)((InModule)(CUR$.SL$)).inspect$216$56),20);
                                }
                                ;
                            }
                        }
                        break;
                        case 31: 
                        // JavaLine 308 <== SourceLine 222
                        {
                            // BEGIN INSPECTION 
                            ((InModule)(CUR$.SL$)).inspect$222$57=new Common$routine(((InModule)(CUR$.SL$)).inspect$22$42).STM$();
                            if(((InModule)(CUR$.SL$)).inspect$222$57!=null) // INSPECT inspect$222$57
                            // JavaLine 313 <== SourceLine 223
                            {
                                ((InModule)(CUR$.SL$)).inspect$222$57.tag$2=new InModule$CompoundStatement23$SubBlock27$intag(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$;
                                ;
                                ((InModule)(CUR$.SL$)).inspect$222$57.symb$2=((InModule)(CUR$.SL$)).inspect$22$42.symtab.Elt[((InModule)(CUR$.SL$)).inspect$22$42.hash$1-((InModule)(CUR$.SL$)).inspect$22$42.symtab.LB[0]];
                                ;
                                // JavaLine 319 <== SourceLine 224
                                new InptFile$inident(((InModule)(CUR$.SL$)).inspect$22$43);
                                ;
                                ((InModule)(CUR$.SL$)).inspect$222$57.profbox$3=((InModule)(CUR$.SL$)).inspect$22$42.symtab.Elt[((InModule)(CUR$.SL$)).inspect$22$42.hash$1-((InModule)(CUR$.SL$)).inspect$22$42.symtab.LB[0]];
                                ;
                                // JavaLine 324 <== SourceLine 225
                                ((Common$routine)((InModule)(CUR$.SL$)).inspect$222$57).into(((InModule)(CUR$.SL$)).inspect$23$44.dclset$2);
                                ;
                                // JavaLine 327 <== SourceLine 226
                                if(VALUE$((((InModule)(CUR$.SL$)).inspect$22$42.module_trace$1>(2)))) {
                                    new Common$prt(((InModule)(CUR$.SL$)).inspect$22$42,((Common$descr)((InModule)(CUR$.SL$)).inspect$222$57),20);
                                }
                                ;
                            }
                        }
                        break;
                        case 32: 
                        // JavaLine 336 <== SourceLine 229
                        {
                            pculiar=new Common$peculiar(((InModule)(CUR$.SL$)).inspect$22$42,((InModule)(CUR$.SL$)).inspect$22$42.S_SYSRUT$1).STM$();
                            ;
                            GOTO$(PECUL); // GOTO EVALUATED LABEL
                        }
                        break;
                        case 33: 
                        // JavaLine 344 <== SourceLine 231
                        {
                            pculiar=new Common$peculiar(((InModule)(CUR$.SL$)).inspect$22$42,((InModule)(CUR$.SL$)).inspect$22$42.S_KNOWN$1).STM$();
                            ;
                            GOTO$(PECUL); // GOTO EVALUATED LABEL
                        }
                        break;
                        case 34: 
                        // JavaLine 352 <== SourceLine 233
                        {
                            pculiar=new Common$peculiar(((InModule)(CUR$.SL$)).inspect$22$42,((InModule)(CUR$.SL$)).inspect$22$42.S_EXTERNAL$1).STM$();
                            ;
                            GOTO$(PECUL); // GOTO EVALUATED LABEL
                        }
                        break;
                        case 35: 
                        // JavaLine 360 <== SourceLine 235
                        {
                            pculiar=new Common$peculiar(((InModule)(CUR$.SL$)).inspect$22$42,((InModule)(CUR$.SL$)).inspect$22$42.S_ROUTINE$1).STM$();
                            ;
                            // JavaLine 364 <== SourceLine 242
                            LABEL$(3,"PECUL");
                            // JavaLine 366 <== SourceLine 236
                            {
                                // BEGIN INSPECTION 
                                ((InModule)(CUR$.SL$)).inspect$236$58=pculiar;
                                if(((InModule)(CUR$.SL$)).inspect$236$58!=null) // INSPECT inspect$236$58
                                // JavaLine 371 <== SourceLine 237
                                {
                                    ((InModule)(CUR$.SL$)).inspect$236$58.tag$2=new InModule$CompoundStatement23$SubBlock27$intag(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$;
                                    ;
                                    ((InModule)(CUR$.SL$)).inspect$236$58.symb$2=((InModule)(CUR$.SL$)).inspect$22$42.symtab.Elt[((InModule)(CUR$.SL$)).inspect$22$42.hash$1-((InModule)(CUR$.SL$)).inspect$22$42.symtab.LB[0]];
                                    ;
                                    // JavaLine 377 <== SourceLine 238
                                    ((InModule)(CUR$.SL$)).inspect$236$58.body$4=new InModule$CompoundStatement23$SubBlock27$intag(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$;
                                    ;
                                    ((InModule)(CUR$.SL$)).inspect$236$58.info$4=new InptFile$instring(((InModule)(CUR$.SL$)).inspect$22$43).RESULT$;
                                    ;
                                    // JavaLine 382 <== SourceLine 239
                                    ((InModule)(CUR$.SL$)).inspect$236$58.into(((InModule)(CUR$.SL$)).inspect$23$44.dclset$2);
                                    ;
                                    // JavaLine 385 <== SourceLine 240
                                    ((InModule)(CUR$.SL$)).inspect$236$58.spec$3=new InModule$CompoundStatement23$SubBlock27$inparspec(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$;
                                    ;
                                    // JavaLine 388 <== SourceLine 241
                                    if(VALUE$((((InModule)(CUR$.SL$)).inspect$22$42.module_trace$1>(2)))) {
                                        new Common$prt(((InModule)(CUR$.SL$)).inspect$22$42,((Common$peculiar)((InModule)(CUR$.SL$)).inspect$236$58),20);
                                    }
                                    ;
                                }
                            }
                            ;
                        }
                        break;
                        default:
                        // JavaLine 399 <== SourceLine 245
                        new InModule$CompoundStatement23$SubBlock27$MERR(((InModule$CompoundStatement23$SubBlock27)(CUR$)),CONC(new TXT$("OutDescr:"),new Common$leftint(((InModule)(CUR$.SL$)).inspect$22$42,istr).RESULT$));
                        break;
                    } // END SWITCH STATEMENT
                    ;
                }
                if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
            }
            ;
            // JavaLine 408 <== SourceLine 278
            LABEL$(4,"EXDESCR");
            // JavaLine 410 <== SourceLine 250
            while(true) {
                {
                    istr=new InModule$CompoundStatement23$SubBlock27$inAbyte(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$;
                    ;
                    // JavaLine 415 <== SourceLine 251
                    if(VALUE$((istr==(((InModule)(CUR$.SL$)).inspect$22$42.M_DEFINE$1)))) {
                        // JavaLine 417 <== SourceLine 252
                        {
                            new InptFile$inident(((InModule)(CUR$.SL$)).inspect$22$43);
                            ;
                            // JavaLine 421 <== SourceLine 253
                            {
                                // BEGIN INSPECTION 
                                ((InModule)(CUR$.SL$)).inspect$253$59=((InModule)(CUR$.SL$)).inspect$22$42.symtab.Elt[((InModule)(CUR$.SL$)).inspect$22$42.hash$1-((InModule)(CUR$.SL$)).inspect$22$42.symtab.LB[0]];
                                if(((InModule)(CUR$.SL$)).inspect$253$59!=null) // INSPECT inspect$253$59
                                // JavaLine 426 <== SourceLine 254
                                {
                                    if(VALUE$((((InModule)(CUR$.SL$)).inspect$253$59.curmeaning!=(null)))) {
                                        // JavaLine 429 <== SourceLine 255
                                        new Common$ERROR(((InModule)(CUR$.SL$)).inspect$22$42,new TXT$("Redefinition of mnemonic"));
                                    }
                                    ;
                                    // JavaLine 433 <== SourceLine 256
                                    ((InModule)(CUR$.SL$)).inspect$253$59.curmeaning=mnem=new Common$mnemonic(((InModule)(CUR$.SL$)).inspect$22$42,false).STM$();
                                    ;
                                }
                            }
                            ;
                            // JavaLine 439 <== SourceLine 258
                            new Common$macro_symbol(((InModule)(CUR$.SL$)).inspect$22$42,new InModule$CompoundStatement23$SubBlock27$inAbyte(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$,((InModule)(CUR$.SL$)).inspect$22$42.symtab.Elt[((InModule)(CUR$.SL$)).inspect$22$42.hash$1-((InModule)(CUR$.SL$)).inspect$22$42.symtab.LB[0]],copy(new InptFile$instring(((InModule)(CUR$.SL$)).inspect$22$43).RESULT$)).STM$().into(mnem);
                            ;
                            // JavaLine 442 <== SourceLine 259
                            if(VALUE$((((InModule)(CUR$.SL$)).inspect$22$42.module_trace$1>(2)))) {
                                new Common$prt(((InModule)(CUR$.SL$)).inspect$22$42,mnem,20);
                            }
                            ;
                        }
                    } else
                    // JavaLine 449 <== SourceLine 261
                    if(VALUE$((istr==(((InModule)(CUR$.SL$)).inspect$22$42.M_MACRO$1)))) {
                        // JavaLine 451 <== SourceLine 262
                        {
                            new InptFile$inident(((InModule)(CUR$.SL$)).inspect$22$43);
                            ;
                            // JavaLine 455 <== SourceLine 263
                            {
                                // BEGIN INSPECTION 
                                ((InModule)(CUR$.SL$)).inspect$263$60=((InModule)(CUR$.SL$)).inspect$22$42.symtab.Elt[((InModule)(CUR$.SL$)).inspect$22$42.hash$1-((InModule)(CUR$.SL$)).inspect$22$42.symtab.LB[0]];
                                if(((InModule)(CUR$.SL$)).inspect$263$60!=null) // INSPECT inspect$263$60
                                // JavaLine 460 <== SourceLine 264
                                {
                                    if(VALUE$((((InModule)(CUR$.SL$)).inspect$263$60.curmeaning!=(null)))) {
                                        // JavaLine 463 <== SourceLine 265
                                        new Common$ERROR(((InModule)(CUR$.SL$)).inspect$22$42,new TXT$("Redefinition of mnemonic"));
                                    }
                                    ;
                                    // JavaLine 467 <== SourceLine 266
                                    ((InModule)(CUR$.SL$)).inspect$263$60.curmeaning=mcro=new Common$macro(((InModule)(CUR$.SL$)).inspect$22$42,false,new InptFile$innumber(((InModule)(CUR$.SL$)).inspect$22$43).RESULT$).STM$();
                                    ;
                                }
                            }
                            ;
                            istr=new InModule$CompoundStatement23$SubBlock27$inAbyte(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$;
                            while((istr!=(((InModule)(CUR$.SL$)).inspect$22$42.M_ENDMACRO$1))) {
                                // JavaLine 475 <== SourceLine 269
                                if(VALUE$((istr==(((InModule)(CUR$.SL$)).inspect$22$42.M_MARK$1)))) {
                                    {
                                        new InptFile$inident(((InModule)(CUR$.SL$)).inspect$22$43);
                                        ;
                                        // JavaLine 480 <== SourceLine 271
                                        new Common$macro_symbol(((InModule)(CUR$.SL$)).inspect$22$42,new InModule$CompoundStatement23$SubBlock27$inAbyte(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$,((InModule)(CUR$.SL$)).inspect$22$42.symtab.Elt[((InModule)(CUR$.SL$)).inspect$22$42.hash$1-((InModule)(CUR$.SL$)).inspect$22$42.symtab.LB[0]],copy(new InptFile$instring(((InModule)(CUR$.SL$)).inspect$22$43).RESULT$)).STM$().into(mcro);
                                    }
                                } else
                                if(VALUE$((istr==(((InModule)(CUR$.SL$)).inspect$22$42.M_MPAR$1)))) {
                                    // JavaLine 485 <== SourceLine 273
                                    new Common$macro_param(((InModule)(CUR$.SL$)).inspect$22$42,new InptFile$innumber(((InModule)(CUR$.SL$)).inspect$22$43).RESULT$).STM$().into(mcro);
                                } else
                                new InModule$CompoundStatement23$SubBlock27$MERR(((InModule$CompoundStatement23$SubBlock27)(CUR$)),CONC(new TXT$("M_PAR:"),new Common$leftint(((InModule)(CUR$.SL$)).inspect$22$42,istr).RESULT$));
                                istr=new InModule$CompoundStatement23$SubBlock27$inAbyte(((InModule$CompoundStatement23$SubBlock27)(CUR$))).RESULT$;
                            }
                            ;
                            // JavaLine 492 <== SourceLine 274
                            if(VALUE$((((InModule)(CUR$.SL$)).inspect$22$42.module_trace$1>(2)))) {
                                new Common$prt(((InModule)(CUR$.SL$)).inspect$22$42,mcro,20);
                            }
                            ;
                        }
                    } else
                    // JavaLine 499 <== SourceLine 276
                    if(VALUE$((istr==(((InModule)(CUR$.SL$)).inspect$22$42.M_END$1)))) {
                        // JavaLine 501 <== SourceLine 277
                        GOTO$(EXMCRO); // GOTO EVALUATED LABEL
                    } else
                    new InModule$CompoundStatement23$SubBlock27$MERR(((InModule$CompoundStatement23$SubBlock27)(CUR$)),CONC(new TXT$("MneInput:"),new Common$leftint(((InModule)(CUR$.SL$)).inspect$22$42,istr).RESULT$));
                    ;
                }
                if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
            }
            ;
            // JavaLine 510 <== SourceLine 282
            LABEL$(5,"EXMCRO");
            ((Common$module)((InModule)(CUR$.SL$)).inspect$23$44).bias$2=((InModule)(CUR$.SL$)).inspect$23$44.bias$2;
            ;
            // JavaLine 514 <== SourceLine 283
            ((Common$module)((InModule)(CUR$.SL$)).inspect$23$44).ntag$2=((InModule)(CUR$.SL$)).inspect$23$44.ntag$2;
            ;
            // JavaLine 517 <== SourceLine 284
            ((InptFile)((InModule)(CUR$.SL$)).inspect$22$43).close();
            ;
            // JavaLine 520 <== SourceLine 285
            if(VALUE$((((InModule)(CUR$.SL$)).inspect$22$42.module_trace$1>(0)))) {
                {
                    // BEGIN INSPECTION 
                    ((InModule)(CUR$.SL$)).inspect$285$61=sysout();
                    if(((InModule)(CUR$.SL$)).inspect$285$61!=null) // INSPECT inspect$285$61
                    // JavaLine 526 <== SourceLine 286
                    {
                        // JavaLine 528 <== SourceLine 287
                        ((InModule)(CUR$.SL$)).inspect$285$61.outtext(CONC(CONC(new TXT$("*************   End of  -  Input-module  "),((InModule)(CUR$.SL$)).inspect$23$44.p2$modid),new TXT$("   *************")));
                        ;
                        // JavaLine 531 <== SourceLine 288
                        ((InModule)(CUR$.SL$)).inspect$285$61.outimage();
                        ;
                        // JavaLine 534 <== SourceLine 289
                        if(VALUE$((((InModule)(CUR$.SL$)).inspect$22$42.module_trace$1>(1)))) {
                            new Common$prt(((InModule)(CUR$.SL$)).inspect$22$42,((Common$module)((InModule)(CUR$.SL$)).inspect$23$44),5);
                        }
                        ;
                    }
                }
            }
            ;
            // JavaLine 543 <== SourceLine 291
            if(VALUE$((((InModule)(CUR$.SL$)).inspect$22$43.input_trace$3>(2)))) {
                new Common$prt(((InModule)(CUR$.SL$)).inspect$22$42,((Common$module)((InModule)(CUR$.SL$)).inspect$23$44),20);
            }
            ;
            // JavaLine 548 <== SourceLine 292
            new Common$update_display(((InModule)(CUR$.SL$)).inspect$22$42,((InModule)(CUR$.SL$)).inspect$23$44.dclset$2);
            ;
            // JavaLine 551 <== SourceLine 295
            LABEL$(6,"MXX");
            ;
            break LOOP$;
        }
        catch(LABQNT$ q) {
            CUR$=THIS$;
            if(q.SL$!=CUR$) {
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock27:NON-LOCAL",q);
                CUR$.STATE$=OperationalState.terminated;
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock27:RE-THROW",q);
                throw(q);
            }
            if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock27:LOCAL",q);
            JTX$=q.index; continue LOOP$; // EG. GOTO Lx
        }
    }
    EBLK();
    return(this);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("INMODULE.sim","SubBlock SubBlock27",1,27,9,193,11,199,13,236,15,250,17,282,19,295,22,27,24,28,26,30,28,31,30,32,45,155,51,156,53,157,58,158,65,160,68,161,70,162,74,163,77,164,82,165,85,166,90,167,93,170,95,171,99,172,102,174,106,176,111,177,117,178,122,179,131,182,136,183,142,184,145,185,154,188,159,189,165,190,172,191,175,192,180,193,184,194,189,195,191,196,201,197,207,198,213,199,217,200,222,201,224,202,238,204,240,205,244,206,249,207,258,210,263,211,269,212,274,213,283,216,288,217,294,218,299,219,308,222,313,223,319,224,324,225,327,226,336,229,344,231,352,233,360,235,364,242,366,236,371,237,377,238,382,239,385,240,388,241,399,245,408,278,410,250,415,251,417,252,421,253,426,254,429,255,433,256,439,258,442,259,449,261,451,262,455,263,460,264,463,265,467,266,475,269,480,271,485,273,492,274,499,276,501,277,510,282,514,283,517,284,520,285,526,286,528,287,531,288,534,289,543,291,548,292,551,295,570,295);
} // End of SubBlock
