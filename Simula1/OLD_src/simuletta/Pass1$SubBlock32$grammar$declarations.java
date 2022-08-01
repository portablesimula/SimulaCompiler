// JavaLine 1 <== SourceLine 760
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$declarations extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=760, lastLine=1166, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Head$ p$declset;
    public boolean p$inrec;
    public boolean p$inLocals;
    // Declare local labels
    // JavaLine 13 <== SourceLine 809
    final LABQNT$ NXT=new LABQNT$(this,1,"NXT"); // Local Label #1=NXT
    // JavaLine 15 <== SourceLine 829
    final LABQNT$ strl1=new LABQNT$(this,2,"strl1"); // Local Label #2=strl1
    // JavaLine 17 <== SourceLine 918
    final LABQNT$ strl2=new LABQNT$(this,3,"strl2"); // Local Label #3=strl2
    // JavaLine 19 <== SourceLine 973
    final LABQNT$ LD=new LABQNT$(this,4,"LD"); // Local Label #4=LD
    // JavaLine 21 <== SourceLine 1108
    final LABQNT$ NID=new LABQNT$(this,5,"NID"); // Local Label #5=NID
    // JavaLine 23 <== SourceLine 1109
    final LABQNT$ NID1=new LABQNT$(this,6,"NID1"); // Local Label #6=NID1
    // JavaLine 25 <== SourceLine 1119
    final LABQNT$ strl3=new LABQNT$(this,7,"strl3"); // Local Label #7=strl3
    // JavaLine 27 <== SourceLine 1138
    final LABQNT$ LL=new LABQNT$(this,8,"LL"); // Local Label #8=LL
    // JavaLine 29 <== SourceLine 1165
    final LABQNT$ EXT=new LABQNT$(this,9,"EXT"); // Local Label #9=EXT
    // Declare locals as attributes
    // JavaLine 32 <== SourceLine 762
    int type=0;
    int typ=0;
    int rec=0;
    // JavaLine 36 <== SourceLine 763
    boolean constflag=false;
    boolean visibleflag=false;
    boolean lparseen=false;
    // JavaLine 40 <== SourceLine 764
    int fixrep=0;
    int pno=0;
    // JavaLine 43 <== SourceLine 765
    int l=0;
    int u=0;
    int repcount=0;
    // JavaLine 47 <== SourceLine 766
    Head$ oldset=null;
    // JavaLine 49 <== SourceLine 767
    Common$macro mac=null;
    Common$mnemonic mne=null;
    // JavaLine 52 <== SourceLine 768
    Common$symbolbox cbox=null;
    // JavaLine 54 <== SourceLine 769
    TXT$ symbval=null;
    // JavaLine 56 <== SourceLine 812
    Common$record inspect$812$83=null;
    // JavaLine 58 <== SourceLine 841
    Common$variant inspect$841$84=null;
    // JavaLine 60 <== SourceLine 854
    Common$profile inspect$854$85=null;
    // JavaLine 62 <== SourceLine 875
    Common$routine inspect$875$86=null;
    // JavaLine 64 <== SourceLine 907
    Common$peculiar inspect$907$87=null;
    // JavaLine 66 <== SourceLine 979
    Common$symbolbox inspect$979$88=null;
    // JavaLine 68 <== SourceLine 985
    Common$macro_symbol inspect$984$89=null;
    // JavaLine 70 <== SourceLine 996
    Common$symbolbox inspect$996$90=null;
    // JavaLine 72 <== SourceLine 1109
    Common$quant inspect$1109$91=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass1$SubBlock32$grammar$declarations setPar(Object param) {
        //Util.BREAK("CALL Pass1$SubBlock32$grammar$declarations.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 3: p$declset=(Head$)objectValue(param); break;
                case 2: p$inrec=(boolean)objectValue(param); break;
                case 1: p$inLocals=(boolean)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass1$SubBlock32$grammar$declarations(RTObject$ SL$) {
        super(SL$,3); // Expecting 3 parameters
    }
    // Normal Constructor
    public Pass1$SubBlock32$grammar$declarations(RTObject$ SL$,Head$ sp$declset,boolean sp$inrec,boolean sp$inLocals) {
        super(SL$);
        // Parameter assignment to locals
        this.p$declset = sp$declset;
        this.p$inrec = sp$inrec;
        this.p$inLocals = sp$inLocals;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$grammar$declarations STM$() {
        Pass1$SubBlock32$grammar$declarations THIS$=(Pass1$SubBlock32$grammar$declarations)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 109 <== SourceLine 801
                new Common$TRACE(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.PARSER"),801,new TXT$("declarations"));
                ;
                // JavaLine 112 <== SourceLine 802
                oldset=((Pass1$SubBlock32)(CUR$.SL$.SL$)).currentset;
                ;
                ((Pass1$SubBlock32)(CUR$.SL$.SL$)).currentset=p$declset;
                ;
                // JavaLine 117 <== SourceLine 804
                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                ;
                // JavaLine 120 <== SourceLine 806
                while((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol<=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.N_KEYW$1))) {
                    // JavaLine 122 <== SourceLine 807
                    {
                        visibleflag=((p$inLocals)?(false):(((Pass1$SubBlock32)(CUR$.SL$.SL$)).all_visible));
                        ;
                        // JavaLine 126 <== SourceLine 809
                        LABEL$(1,"NXT");
                        new Common$TRACE(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.PARSER"),809,CONC(new TXT$("NXT SYMBOL="),new Common$edSymbol(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol).RESULT$));
                        ;
                        // JavaLine 130 <== SourceLine 810
                        switch(((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol) { // BEGIN SWITCH STATEMENT
                        case 1: 
                        // JavaLine 133 <== SourceLine 812
                        {
                            // BEGIN INSPECTION 
                            inspect$812$83=new Common$record(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                            if(inspect$812$83!=null) // INSPECT inspect$812$83
                            // JavaLine 138 <== SourceLine 816
                            {
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                                // JavaLine 142 <== SourceLine 817
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),817,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                                }
                                ;
                                // JavaLine 147 <== SourceLine 818
                                inspect$812$83.symb$2=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.LB[0]];
                                ;
                                // JavaLine 150 <== SourceLine 819
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                                // JavaLine 153 <== SourceLine 820
                                inspect$812$83.variantset$3=new Head$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                                ;
                                // JavaLine 156 <== SourceLine 821
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COLON$1)))) {
                                    // JavaLine 158 <== SourceLine 822
                                    {
                                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                        ;
                                        // JavaLine 162 <== SourceLine 823
                                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),823,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                                        }
                                        ;
                                        // JavaLine 167 <== SourceLine 824
                                        inspect$812$83.prefbox$3=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.LB[0]];
                                        ;
                                        // JavaLine 170 <== SourceLine 825
                                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 176 <== SourceLine 826
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INFO$1)))) {
                                    // JavaLine 178 <== SourceLine 827
                                    {
                                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                        ;
                                        // JavaLine 182 <== SourceLine 828
                                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_STRING$1)))) {
                                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),828,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_STRING$1);
                                        }
                                        ;
                                        // JavaLine 187 <== SourceLine 829
                                        symbval=((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval;
                                        ;
                                        LABEL$(2,"strl1");
                                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                        ;
                                        // JavaLine 193 <== SourceLine 830
                                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_STRING$1)))) {
                                            // JavaLine 195 <== SourceLine 831
                                            {
                                                symbval=CONC(symbval,((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval);
                                                ;
                                                GOTO$(strl1); // GOTO EVALUATED LABEL
                                            }
                                        }
                                        ;
                                        // JavaLine 203 <== SourceLine 832
                                        if(VALUE$(TXTREL$EQ(symbval,new TXT$("DYNAMIC")))) {
                                            inspect$812$83.dynamic$3=true;
                                        } else
                                        // JavaLine 207 <== SourceLine 833
                                        if(VALUE$(TXTREL$EQ(symbval,new TXT$("TYPE")))) {
                                            inspect$812$83.used_as_type$3=true;
                                        } else
                                        // JavaLine 211 <== SourceLine 834
                                        if(VALUE$(TXTREL$EQ(symbval,new TXT$("PACKED")))) {
                                            inspect$812$83.packed$3=true;
                                        } else
                                        // JavaLine 215 <== SourceLine 835
                                        new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Unknown INFO-string"));
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 221 <== SourceLine 837
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_BEGIN$1)))) {
                                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),837,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_BEGIN$1);
                                }
                                ;
                                // JavaLine 226 <== SourceLine 838
                                inspect$812$83.atrset$3=new Head$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                                ;
                                // JavaLine 229 <== SourceLine 839
                                new Pass1$SubBlock32$grammar$declarations(((Pass1$SubBlock32$grammar)(CUR$.SL$)),inspect$812$83.atrset$3,true,p$inLocals);
                                ;
                                // JavaLine 232 <== SourceLine 840
                                while((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_VARIANT$1))) {
                                    // JavaLine 234 <== SourceLine 841
                                    {
                                        // BEGIN INSPECTION 
                                        inspect$841$84=new Common$variant(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                                        if(inspect$841$84!=null) // INSPECT inspect$841$84
                                        // JavaLine 239 <== SourceLine 842
                                        {
                                            inspect$841$84.into(inspect$812$83.variantset$3);
                                            ;
                                            inspect$841$84.atrset$2=new Head$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                                            ;
                                            // JavaLine 245 <== SourceLine 843
                                            new Pass1$SubBlock32$grammar$declarations(((Pass1$SubBlock32$grammar)(CUR$.SL$)),inspect$841$84.atrset$2,true,p$inLocals);
                                            ;
                                        }
                                    }
                                }
                                ;
                                // JavaLine 252 <== SourceLine 845
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_END$1)))) {
                                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),845,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_END$1);
                                }
                                ;
                                // JavaLine 257 <== SourceLine 846
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).input_trace>(2)))) {
                                    new Common$prt(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Common$descr)inspect$812$83),20);
                                }
                                ;
                                // JavaLine 262 <== SourceLine 847
                                if(VALUE$(p$inrec)) {
                                    // JavaLine 264 <== SourceLine 848
                                    new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Misplaced record declaration"));
                                } else
                                inspect$812$83.into(p$declset);
                                ;
                                // JavaLine 269 <== SourceLine 849
                                inspect$812$83.visible$2=visibleflag;
                                ;
                                // JavaLine 272 <== SourceLine 850
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                            }
                        }
                        break;
                        case 30: 
                        case 50: 
                        // JavaLine 280 <== SourceLine 854
                        {
                            // BEGIN INSPECTION 
                            inspect$854$85=new Common$profile(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                            if(inspect$854$85!=null) // INSPECT inspect$854$85
                            // JavaLine 285 <== SourceLine 855
                            {
                                new Common$TRACE(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.PARSER"),855,new TXT$("PROFILE"));
                                ;
                                // JavaLine 289 <== SourceLine 856
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_GLOBAL$1)))) {
                                    // JavaLine 291 <== SourceLine 857
                                    {
                                        inspect$854$85.interface$$3=true;
                                        ;
                                        // JavaLine 295 <== SourceLine 858
                                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                        ;
                                        // JavaLine 298 <== SourceLine 859
                                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_PROFILE$1)))) {
                                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),859,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_PROFILE$1);
                                        }
                                    }
                                }
                                ;
                                // JavaLine 305 <== SourceLine 860
                                if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.rutlev$1>(0)))) {
                                    // JavaLine 307 <== SourceLine 861
                                    new Common$FATAL_ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Profile declared within a routine"));
                                }
                                ;
                                // JavaLine 311 <== SourceLine 862
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                                // JavaLine 314 <== SourceLine 863
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),863,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                                }
                                ;
                                // JavaLine 319 <== SourceLine 864
                                inspect$854$85.symb$2=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.LB[0]];
                                ;
                                // JavaLine 322 <== SourceLine 865
                                inspect$854$85.spec$3=new Pass1$SubBlock32$grammar$declarations$read_par(((Pass1$SubBlock32$grammar$declarations)(CUR$))).RESULT$;
                                ;
                                // JavaLine 325 <== SourceLine 866
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_END$1)))) {
                                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),866,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_END$1);
                                }
                                ;
                                // JavaLine 330 <== SourceLine 867
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).input_trace>(2)))) {
                                    new Common$prt(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Common$profile)inspect$854$85),20);
                                }
                                ;
                                // JavaLine 335 <== SourceLine 868
                                if(VALUE$(p$inrec)) {
                                    // JavaLine 337 <== SourceLine 869
                                    new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Misplaced profile declaration"));
                                } else
                                inspect$854$85.into(p$declset);
                                ;
                                // JavaLine 342 <== SourceLine 870
                                inspect$854$85.visible$2=visibleflag;
                                ;
                                // JavaLine 345 <== SourceLine 871
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                            }
                        }
                        break;
                        case 45: 
                        // JavaLine 352 <== SourceLine 875
                        {
                            // BEGIN INSPECTION 
                            inspect$875$86=new Common$routine(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                            if(inspect$875$86!=null) // INSPECT inspect$875$86
                            // JavaLine 357 <== SourceLine 876
                            {
                                new Common$TRACE(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.PARSER"),876,new TXT$("BODY"));
                                ;
                                // JavaLine 361 <== SourceLine 877
                                if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.rutlev$1>(0)))) {
                                    // JavaLine 363 <== SourceLine 878
                                    new Common$FATAL_ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Body declared within a routine"));
                                }
                                ;
                                // JavaLine 367 <== SourceLine 879
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                                // JavaLine 370 <== SourceLine 880
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),880,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                                }
                                ;
                                // JavaLine 375 <== SourceLine 881
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                                // JavaLine 378 <== SourceLine 882
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),882,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                                }
                                ;
                                // JavaLine 383 <== SourceLine 883
                                inspect$875$86.profbox$3=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.LB[0]];
                                ;
                                // JavaLine 386 <== SourceLine 884
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                                // JavaLine 389 <== SourceLine 885
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),885,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                                }
                                ;
                                // JavaLine 394 <== SourceLine 886
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                                // JavaLine 397 <== SourceLine 887
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),887,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                                }
                                ;
                                // JavaLine 402 <== SourceLine 888
                                inspect$875$86.symb$2=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.LB[0]];
                                ;
                                // JavaLine 405 <== SourceLine 889
                                new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_BODY$1);
                                ;
                                new OuptFile$outident(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1);
                                ;
                                // JavaLine 410 <== SourceLine 890
                                if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                                }
                                ;
                                // JavaLine 415 <== SourceLine 891
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_BEGIN$1)))) {
                                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),891,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_BEGIN$1);
                                }
                                ;
                                // JavaLine 422 <== SourceLine 892
                                ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.localdecl$1=inspect$875$86.local$3=new Head$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                                ;
                                // JavaLine 425 <== SourceLine 893
                                ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.rutlev$1=Math.addExact(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.rutlev$1,1);
                                ;
                                // JavaLine 428 <== SourceLine 894
                                new Pass1$SubBlock32$grammar$declarations(((Pass1$SubBlock32$grammar)(CUR$.SL$)),inspect$875$86.local$3,false,true);
                                ;
                                new Pass1$SubBlock32$grammar$statement(((Pass1$SubBlock32$grammar)(CUR$.SL$)));
                                ;
                                // JavaLine 433 <== SourceLine 895
                                ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.rutlev$1=Math.subtractExact(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.rutlev$1,1);
                                ;
                                // JavaLine 436 <== SourceLine 896
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_END$1)))) {
                                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),896,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_END$1);
                                }
                                ;
                                // JavaLine 441 <== SourceLine 897
                                new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_END$1);
                                ;
                                // JavaLine 444 <== SourceLine 898
                                if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                                }
                                ;
                                // JavaLine 449 <== SourceLine 899
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).input_trace>(2)))) {
                                    new Common$prt(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Common$routine)inspect$875$86),20);
                                }
                                ;
                                // JavaLine 454 <== SourceLine 900
                                if(VALUE$(p$inrec)) {
                                    // JavaLine 456 <== SourceLine 901
                                    new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Misplaced routine body"));
                                } else
                                inspect$875$86.into(p$declset);
                                ;
                                // JavaLine 461 <== SourceLine 902
                                inspect$875$86.visible$2=visibleflag;
                                ;
                                // JavaLine 464 <== SourceLine 903
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                            }
                        }
                        break;
                        case 181: 
                        case 31: 
                        case 33: 
                        case 39: 
                        // JavaLine 474 <== SourceLine 907
                        {
                            // BEGIN INSPECTION 
                            inspect$907$87=new Common$peculiar(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol).STM$();
                            if(inspect$907$87!=null) // INSPECT inspect$907$87
                            // JavaLine 479 <== SourceLine 909
                            {
                                ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.DO_TRACING$1=1;
                                ;
                                new Common$TRACE(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.PARSER"),909,new TXT$("when ROUTINE"));
                                ;
                                // JavaLine 485 <== SourceLine 911
                                if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.rutlev$1>(0)))) {
                                    // JavaLine 487 <== SourceLine 912
                                    new Common$FATAL_ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Routine declared inside a routine"));
                                }
                                ;
                                // JavaLine 491 <== SourceLine 913
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                                // JavaLine 494 <== SourceLine 914
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                                    // JavaLine 496 <== SourceLine 915
                                    {
                                        inspect$907$87.libProc$3=(inspect$907$87.p4$kind==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ROUTINE$1));
                                        ;
                                        // JavaLine 500 <== SourceLine 916
                                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                        ;
                                        // JavaLine 503 <== SourceLine 917
                                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_STRING$1)))) {
                                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),917,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_STRING$1);
                                        }
                                        ;
                                        // JavaLine 508 <== SourceLine 918
                                        inspect$907$87.info$4=((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval;
                                        ;
                                        LABEL$(3,"strl2");
                                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                        ;
                                        // JavaLine 514 <== SourceLine 919
                                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_STRING$1)))) {
                                            // JavaLine 516 <== SourceLine 920
                                            {
                                                inspect$907$87.info$4=CONC(inspect$907$87.info$4,((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval);
                                                ;
                                                GOTO$(strl2); // GOTO EVALUATED LABEL
                                            }
                                        }
                                        ;
                                        // JavaLine 524 <== SourceLine 921
                                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                                            // JavaLine 526 <== SourceLine 922
                                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),922,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                                        } else
                                        ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 534 <== SourceLine 924
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),924,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                                }
                                ;
                                // JavaLine 539 <== SourceLine 925
                                inspect$907$87.symb$2=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.LB[0]];
                                ;
                                // JavaLine 542 <== SourceLine 926
                                inspect$907$87.spec$3=new Pass1$SubBlock32$grammar$declarations$read_par(((Pass1$SubBlock32$grammar$declarations)(CUR$))).RESULT$;
                                ;
                                // JavaLine 545 <== SourceLine 928
                                new Common$TRACE(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.PARSER"),928,new TXT$("ROUTINE(2)"));
                                ;
                                new Common$prt(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Common$peculiar)inspect$907$87),20);
                                ;
                                // JavaLine 550 <== SourceLine 930
                                if(VALUE$(((inspect$907$87.p4$kind==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_KNOWN$1))|((inspect$907$87.p4$kind==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ROUTINE$1)))))) {
                                    // JavaLine 552 <== SourceLine 931
                                    {
                                        new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_BODY$1);
                                        ;
                                        new OuptFile$outident(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,inspect$907$87.symb$2.id);
                                        ;
                                        // JavaLine 558 <== SourceLine 932
                                        if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                            new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                                        }
                                        ;
                                        // JavaLine 563 <== SourceLine 933
                                        if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_BEGIN$1)))) {
                                            new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),933,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_BEGIN$1);
                                        }
                                        ;
                                        // JavaLine 568 <== SourceLine 934
                                        ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.localdecl$1=inspect$907$87.local$4=new Head$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                                        ;
                                        // JavaLine 571 <== SourceLine 935
                                        ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.rutlev$1=Math.addExact(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.rutlev$1,1);
                                        ;
                                        // JavaLine 574 <== SourceLine 936
                                        new Pass1$SubBlock32$grammar$declarations(((Pass1$SubBlock32$grammar)(CUR$.SL$)),inspect$907$87.local$4,false,true);
                                        ;
                                        new Pass1$SubBlock32$grammar$statement(((Pass1$SubBlock32$grammar)(CUR$.SL$)));
                                        ;
                                        // JavaLine 579 <== SourceLine 937
                                        ((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.rutlev$1=Math.subtractExact(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.rutlev$1,1);
                                        ;
                                        // JavaLine 582 <== SourceLine 938
                                        new OuptFile$outinst(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_END$1);
                                        ;
                                        // JavaLine 585 <== SourceLine 939
                                        if(VALUE$((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63.output_trace$3>(0)))) {
                                            new OuptFile$outcode(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$29$63);
                                        }
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 593 <== SourceLine 941
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_END$1)))) {
                                    new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),941,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_END$1);
                                }
                                ;
                                // JavaLine 598 <== SourceLine 942
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).input_trace>(2)))) {
                                    new Common$prt(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Common$peculiar)inspect$907$87),20);
                                }
                                ;
                                // JavaLine 603 <== SourceLine 943
                                if(VALUE$(p$inrec)) {
                                    // JavaLine 605 <== SourceLine 945
                                    new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Misplaced peculiar routine declaration"));
                                } else
                                inspect$907$87.into(p$declset);
                                ;
                                // JavaLine 610 <== SourceLine 946
                                inspect$907$87.visible$2=visibleflag;
                                ;
                                // JavaLine 613 <== SourceLine 947
                                ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                ;
                            }
                        }
                        break;
                        case 115: 
                        case 114: 
                        // JavaLine 621 <== SourceLine 962
                        new Pass1$SubBlock32$grammar$declarations$CompoundStatement807$SubBlock951((CUR$)).STM$();
                        break;
                        case 53: 
                        // JavaLine 625 <== SourceLine 965
                        {
                            constflag=true;
                            ;
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            GOTO$(NXT); // GOTO EVALUATED LABEL
                        }
                        break;
                        case 187: 
                        // JavaLine 635 <== SourceLine 968
                        {
                            if(VALUE$(p$inLocals)) {
                                // JavaLine 638 <== SourceLine 969
                                new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Visible illegal in routine"));
                            } else
                            visibleflag=TRF_NE(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.module_ident$1,null);
                            ;
                            // JavaLine 643 <== SourceLine 970
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            GOTO$(NXT); // GOTO EVALUATED LABEL
                        }
                        break;
                        case 182: 
                        // JavaLine 650 <== SourceLine 973
                        {
                            LABEL$(4,"LD");
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 655 <== SourceLine 974
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),974,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                            }
                            ;
                            // JavaLine 660 <== SourceLine 975
                            cbox=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.LB[0]];
                            ;
                            // JavaLine 663 <== SourceLine 976
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 666 <== SourceLine 977
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_EQ$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),977,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_EQ$1);
                            }
                            ;
                            // JavaLine 671 <== SourceLine 978
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 674 <== SourceLine 979
                            {
                                // BEGIN INSPECTION 
                                inspect$979$88=cbox;
                                if(inspect$979$88!=null) // INSPECT inspect$979$88
                                // JavaLine 679 <== SourceLine 980
                                {
                                    if(VALUE$((inspect$979$88.curmeaning!=(null)))) {
                                        // JavaLine 682 <== SourceLine 981
                                        new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Redefinition of mnemonic"));
                                    }
                                    ;
                                    // JavaLine 686 <== SourceLine 982
                                    inspect$979$88.curmeaning=mne=new Common$mnemonic(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,visibleflag).STM$();
                                    ;
                                }
                            }
                            ;
                            // JavaLine 692 <== SourceLine 984
                            {
                                // BEGIN INSPECTION 
                                inspect$984$89=new Common$macro_symbol(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol,cbox,copy(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval)).STM$();
                                if(inspect$984$89!=null) // INSPECT inspect$984$89
                                // JavaLine 697 <== SourceLine 985
                                {
                                    inspect$984$89.into(mne);
                                    ;
                                    // JavaLine 701 <== SourceLine 986
                                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).input_trace>(1)))) {
                                        new Common$macro_symbol$dump(inspect$984$89);
                                    }
                                    ;
                                }
                            }
                            ;
                            // JavaLine 709 <== SourceLine 988
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 712 <== SourceLine 989
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COMMA$1)))) {
                                GOTO$(LD); // GOTO EVALUATED LABEL
                            }
                            ;
                        }
                        break;
                        case 143: 
                        // JavaLine 720 <== SourceLine 993
                        {
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 724 <== SourceLine 994
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),994,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                            }
                            ;
                            // JavaLine 729 <== SourceLine 995
                            cbox=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.LB[0]];
                            ;
                            // JavaLine 732 <== SourceLine 996
                            {
                                // BEGIN INSPECTION 
                                inspect$996$90=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.LB[0]];
                                if(inspect$996$90!=null) // INSPECT inspect$996$90
                                // JavaLine 737 <== SourceLine 997
                                {
                                    if(VALUE$((inspect$996$90.curmeaning!=(null)))) {
                                        // JavaLine 740 <== SourceLine 998
                                        new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Redefinition of mnemonic"));
                                    }
                                    ;
                                    // JavaLine 744 <== SourceLine 999
                                    inspect$996$90.curmeaning=mac=new Common$macro(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,visibleflag,0).STM$();
                                    ;
                                }
                            }
                            ;
                            // JavaLine 750 <== SourceLine 1001
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 753 <== SourceLine 1002
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                                {
                                    lparseen=true;
                                    ;
                                    // JavaLine 758 <== SourceLine 1003
                                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                    ;
                                    // JavaLine 761 <== SourceLine 1004
                                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1)))) {
                                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1004,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1);
                                    }
                                    ;
                                    // JavaLine 766 <== SourceLine 1005
                                    mac.p3$npar=TXT$.getint(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval);
                                    ;
                                    // JavaLine 769 <== SourceLine 1006
                                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                    ;
                                    // JavaLine 772 <== SourceLine 1007
                                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1007,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                                    }
                                    ;
                                    // JavaLine 777 <== SourceLine 1008
                                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                    ;
                                    // JavaLine 780 <== SourceLine 1009
                                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_BEGIN$1)))) {
                                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1009,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_BEGIN$1);
                                    }
                                    ;
                                }
                            } else
                            // JavaLine 787 <== SourceLine 1012
                            {
                                if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COLON$1)))) {
                                    // JavaLine 790 <== SourceLine 1013
                                    new Common$WARNING(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Missing leftpar or colon"));
                                }
                                ;
                            }
                            ;
                            // JavaLine 796 <== SourceLine 1015
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 799 <== SourceLine 1016
                            while((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_ENDMACRO$1))) {
                                // JavaLine 801 <== SourceLine 1017
                                {
                                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_PERCENT$1)))) {
                                        // JavaLine 804 <== SourceLine 1018
                                        {
                                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                            ;
                                            // JavaLine 808 <== SourceLine 1019
                                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1)))) {
                                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1019,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1);
                                            }
                                            ;
                                            // JavaLine 813 <== SourceLine 1020
                                            pno=TXT$.getint(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval);
                                            ;
                                            // JavaLine 816 <== SourceLine 1021
                                            if(VALUE$((pno>(mac.p3$npar)))) {
                                                // JavaLine 818 <== SourceLine 1022
                                                {
                                                    // JavaLine 820 <== SourceLine 1023
                                                    if(VALUE$(lparseen)) {
                                                        new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Too large macro param index"));
                                                    }
                                                    ;
                                                    // JavaLine 825 <== SourceLine 1024
                                                    mac.p3$npar=pno;
                                                    ;
                                                }
                                            }
                                            ;
                                            // JavaLine 831 <== SourceLine 1026
                                            new Common$macro_param(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,pno).STM$().into(mac);
                                            ;
                                        }
                                    } else
                                    // JavaLine 836 <== SourceLine 1029
                                    new Common$macro_symbol(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.LB[0]],copy(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval)).STM$().into(mac);
                                    ;
                                    // JavaLine 839 <== SourceLine 1030
                                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                    ;
                                }
                            }
                            ;
                            // JavaLine 845 <== SourceLine 1032
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).input_trace>(1)))) {
                                new Common$macro$dump(mac,cbox);
                            }
                            ;
                            // JavaLine 850 <== SourceLine 1033
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                        }
                        break;
                        case 166: 
                        case 167: 
                        // JavaLine 857 <== SourceLine 1040
                        {
                            type=new Pass1$SubBlock32$grammar$intype(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$;
                            ;
                            GOTO$(NID1); // GOTO EVALUATED LABEL
                        }
                        break;
                        case 160: 
                        // JavaLine 865 <== SourceLine 1042
                        {
                            type=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_INT$1;
                            ;
                            GOTO$(NID); // GOTO EVALUATED LABEL
                        }
                        break;
                        case 158: 
                        // JavaLine 873 <== SourceLine 1044
                        {
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 877 <== SourceLine 1045
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTEGER$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1045,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTEGER$1);
                            }
                            ;
                            // JavaLine 882 <== SourceLine 1046
                            type=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_SINT$1;
                            ;
                            GOTO$(NID); // GOTO EVALUATED LABEL
                        }
                        break;
                        case 49: 
                        // JavaLine 889 <== SourceLine 1048
                        {
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 893 <== SourceLine 1049
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1049,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                            }
                            ;
                            // JavaLine 898 <== SourceLine 1050
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 901 <== SourceLine 1051
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1051,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1);
                            }
                            ;
                            // JavaLine 906 <== SourceLine 1052
                            l=TXT$.getint(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval);
                            ;
                            // JavaLine 909 <== SourceLine 1053
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 912 <== SourceLine 1054
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COLON$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1054,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COLON$1);
                            }
                            ;
                            // JavaLine 917 <== SourceLine 1055
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 920 <== SourceLine 1056
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1056,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1);
                            }
                            ;
                            // JavaLine 925 <== SourceLine 1057
                            u=TXT$.getint(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval);
                            ;
                            // JavaLine 928 <== SourceLine 1058
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 931 <== SourceLine 1059
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1059,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                            }
                            ;
                            // JavaLine 936 <== SourceLine 1060
                            type=new Common$defType(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.integerTypes$1,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RANGE$1,l,u).RESULT$;
                            ;
                            // JavaLine 939 <== SourceLine 1061
                            GOTO$(NID); // GOTO EVALUATED LABEL
                        }
                        break;
                        case 162: 
                        // JavaLine 944 <== SourceLine 1063
                        {
                            type=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_REAL$1;
                            ;
                            GOTO$(NID); // GOTO EVALUATED LABEL
                        }
                        break;
                        case 159: 
                        // JavaLine 952 <== SourceLine 1065
                        {
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_REAL$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1065,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_REAL$1);
                            }
                            ;
                            // JavaLine 960 <== SourceLine 1066
                            type=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_LREAL$1;
                            ;
                            GOTO$(NID); // GOTO EVALUATED LABEL
                        }
                        break;
                        case 161: 
                        // JavaLine 967 <== SourceLine 1068
                        {
                            type=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_SIZE$1;
                            ;
                            GOTO$(NID); // GOTO EVALUATED LABEL
                        }
                        break;
                        case 164: 
                        // JavaLine 975 <== SourceLine 1070
                        {
                            type=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_BOOL$1;
                            ;
                            GOTO$(NID); // GOTO EVALUATED LABEL
                        }
                        break;
                        case 48: 
                        // JavaLine 983 <== SourceLine 1072
                        {
                            type=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_LABEL$1;
                            ;
                            GOTO$(NID); // GOTO EVALUATED LABEL
                        }
                        break;
                        case 163: 
                        // JavaLine 991 <== SourceLine 1074
                        {
                            type=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_CHAR$1;
                            ;
                            GOTO$(NID); // GOTO EVALUATED LABEL
                        }
                        break;
                        case 169: 
                        // JavaLine 999 <== SourceLine 1076
                        {
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 1003 <== SourceLine 1077
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1077,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                            }
                            ;
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 1010 <== SourceLine 1078
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                                // JavaLine 1012 <== SourceLine 1079
                                {
                                    type=new Common$defType(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.entTypes$1,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1,0,0).RESULT$;
                                    ;
                                    // JavaLine 1016 <== SourceLine 1080
                                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                    ;
                                }
                            } else
                            // JavaLine 1021 <== SourceLine 1081
                            type=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_ENT$1;
                            ;
                            // JavaLine 1024 <== SourceLine 1082
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1082,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                            }
                            ;
                            GOTO$(NID); // GOTO EVALUATED LABEL
                        }
                        break;
                        case 165: 
                        // JavaLine 1033 <== SourceLine 1084
                        {
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 1037 <== SourceLine 1085
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1085,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                            }
                            ;
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 1044 <== SourceLine 1086
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                                // JavaLine 1046 <== SourceLine 1087
                                {
                                    type=new Common$defType(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.refTypes$1,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1,0,0).RESULT$;
                                    ;
                                    // JavaLine 1050 <== SourceLine 1088
                                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                    ;
                                }
                            } else
                            // JavaLine 1055 <== SourceLine 1089
                            type=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_REF$1;
                            ;
                            // JavaLine 1058 <== SourceLine 1090
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1090,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                            }
                            ;
                            GOTO$(NID); // GOTO EVALUATED LABEL
                        }
                        break;
                        case 168: 
                        // JavaLine 1067 <== SourceLine 1092
                        {
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 1071 <== SourceLine 1093
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1093,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1);
                            }
                            ;
                            // JavaLine 1076 <== SourceLine 1094
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 1079 <== SourceLine 1095
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1095,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                            }
                            ;
                            // JavaLine 1084 <== SourceLine 1096
                            rec=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1;
                            ;
                            // JavaLine 1087 <== SourceLine 1097
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 1090 <== SourceLine 1098
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COLON$1)))) {
                                // JavaLine 1092 <== SourceLine 1099
                                {
                                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                    ;
                                    // JavaLine 1096 <== SourceLine 1100
                                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1)))) {
                                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1100,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1);
                                    }
                                    ;
                                    // JavaLine 1101 <== SourceLine 1101
                                    fixrep=Math.addExact(TXT$.getint(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval),1);
                                    ;
                                    // JavaLine 1104 <== SourceLine 1102
                                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                    ;
                                }
                            } else
                            // JavaLine 1109 <== SourceLine 1103
                            fixrep=0;
                            ;
                            // JavaLine 1112 <== SourceLine 1104
                            new Common$TRACE(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.PARSER"),1104,CONC(new TXT$("INFIX: "),(((((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.structTypes$1==(null)))?(new TXT$("NONE")):(new TXT$("IKKE")))));
                            ;
                            // JavaLine 1115 <== SourceLine 1105
                            type=new Common$defType(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.structTypes$1,rec,fixrep,0).RESULT$;
                            ;
                            // JavaLine 1118 <== SourceLine 1106
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1106,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                            }
                            ;
                            // JavaLine 1123 <== SourceLine 1108
                            LABEL$(5,"NID");
                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                            ;
                            // JavaLine 1127 <== SourceLine 1154
                            LABEL$(6,"NID1");
                            // JavaLine 1129 <== SourceLine 1109
                            {
                                // BEGIN INSPECTION 
                                inspect$1109$91=new Common$quant(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,type).STM$();
                                if(inspect$1109$91!=null) // INSPECT inspect$1109$91
                                // JavaLine 1134 <== SourceLine 1110
                                {
                                    new Common$TRACE(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.PARSER"),1110,CONC(CONC(CONC(new TXT$("BEGIN NEW QUANT: "),new Common$edtype(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,inspect$1109$91.p3$type).RESULT$),new TXT$(" ")),new Common$edSymbol(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1).RESULT$));
                                    ;
                                    // JavaLine 1138 <== SourceLine 1111
                                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1)))) {
                                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1111,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_IDENT$1);
                                    }
                                    ;
                                    // JavaLine 1143 <== SourceLine 1112
                                    inspect$1109$91.symb$2=((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.Elt[((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1-((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.symtab.LB[0]];
                                    ;
                                    // JavaLine 1146 <== SourceLine 1113
                                    inspect$1109$91.count$3=1;
                                    ;
                                    // JavaLine 1149 <== SourceLine 1114
                                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                    ;
                                    // JavaLine 1152 <== SourceLine 1115
                                    new Common$TRACE(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.PARSER"),1115,CONC(CONC(CONC(new TXT$("BEGIN +++++++++++++++++++++++++++++++++++ NEW QUANT(0): "),new Common$edSymbol(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol).RESULT$),new TXT$("  ")),((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval));
                                    ;
                                    // JavaLine 1155 <== SourceLine 1116
                                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_SYSTEM$1)))) {
                                        // JavaLine 1157 <== SourceLine 1117
                                        {
                                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                            ;
                                            // JavaLine 1161 <== SourceLine 1118
                                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_STRING$1)))) {
                                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1118,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_STRING$1);
                                            }
                                            ;
                                            // JavaLine 1166 <== SourceLine 1119
                                            inspect$1109$91.sysid$3=((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval;
                                            ;
                                            LABEL$(7,"strl3");
                                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                            ;
                                            // JavaLine 1172 <== SourceLine 1120
                                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_STRING$1)))) {
                                                // JavaLine 1174 <== SourceLine 1121
                                                {
                                                    inspect$1109$91.sysid$3=CONC(inspect$1109$91.sysid$3,((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval);
                                                    ;
                                                    GOTO$(strl3); // GOTO EVALUATED LABEL
                                                }
                                            }
                                            ;
                                        }
                                    }
                                    ;
                                    // JavaLine 1185 <== SourceLine 1123
                                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                                        // JavaLine 1187 <== SourceLine 1124
                                        {
                                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                            ;
                                            // JavaLine 1191 <== SourceLine 1125
                                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1)))) {
                                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1125,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_INTVAL$1);
                                            }
                                            ;
                                            // JavaLine 1196 <== SourceLine 1126
                                            inspect$1109$91.count$3=TXT$.getint(((Pass1$SubBlock32)(CUR$.SL$.SL$)).curval);
                                            ;
                                            // JavaLine 1199 <== SourceLine 1127
                                            new Common$TRACE(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.PARSER"),1127,CONC(CONC(CONC(new TXT$("NEW QUANT(1): "),new Common$edSymbol(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1).RESULT$),new TXT$(", count=")),new Common$leftint(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,inspect$1109$91.count$3).RESULT$));
                                            ;
                                            new Common$prt(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Common$quant)inspect$1109$91),0);
                                            ;
                                            // JavaLine 1204 <== SourceLine 1128
                                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                            ;
                                            // JavaLine 1207 <== SourceLine 1129
                                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                                                new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1129,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                                            }
                                            ;
                                            // JavaLine 1212 <== SourceLine 1130
                                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                            ;
                                        }
                                    }
                                    ;
                                    // JavaLine 1218 <== SourceLine 1132
                                    new Common$TRACE(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.PARSER"),1132,CONC(new TXT$("NEW QUANT(2): "),new Common$edSymbol(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1).RESULT$));
                                    ;
                                    new Common$prt(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Common$quant)inspect$1109$91),0);
                                    ;
                                    // JavaLine 1223 <== SourceLine 1133
                                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_EQ$1)))) {
                                        // JavaLine 1225 <== SourceLine 1134
                                        {
                                            inspect$1109$91.initval$3=new Head$(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62).STM$();
                                            ;
                                            repcount=inspect$1109$91.count$3;
                                            ;
                                            // JavaLine 1231 <== SourceLine 1135
                                            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                            ;
                                            // JavaLine 1234 <== SourceLine 1136
                                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_LPAR$1)))) {
                                                // JavaLine 1236 <== SourceLine 1138
                                                {
                                                    LABEL$(8,"LL");
                                                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                                    ;
                                                    // JavaLine 1241 <== SourceLine 1139
                                                    new Pass1$SubBlock32$grammar$make_const(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$.into(inspect$1109$91.initval$3);
                                                    ;
                                                    // JavaLine 1244 <== SourceLine 1140
                                                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COMMA$1)))) {
                                                        // JavaLine 1246 <== SourceLine 1141
                                                        {
                                                            if(VALUE$((repcount==(0)))) {
                                                                // JavaLine 1249 <== SourceLine 1142
                                                                new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Too many elts in repetition"));
                                                            }
                                                            ;
                                                            // JavaLine 1253 <== SourceLine 1143
                                                            repcount=Math.subtractExact(repcount,1);
                                                            ;
                                                            GOTO$(LL); // GOTO EVALUATED LABEL
                                                            ;
                                                        }
                                                    }
                                                    ;
                                                    // JavaLine 1261 <== SourceLine 1146
                                                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol!=(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1)))) {
                                                        // JavaLine 1263 <== SourceLine 1147
                                                        new Pass1$SubBlock32$grammar$chckErr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),1147,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_RPAR$1);
                                                    } else
                                                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                                                    ;
                                                }
                                            } else
                                            // JavaLine 1270 <== SourceLine 1149
                                            new Pass1$SubBlock32$grammar$make_const(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).RESULT$.into(inspect$1109$91.initval$3);
                                            ;
                                        }
                                    }
                                    ;
                                    // JavaLine 1276 <== SourceLine 1151
                                    inspect$1109$91.visible$2=visibleflag;
                                    ;
                                    // JavaLine 1279 <== SourceLine 1152
                                    inspect$1109$91.read_only$3=constflag;
                                    ;
                                    inspect$1109$91.into(p$declset);
                                    ;
                                    // JavaLine 1284 <== SourceLine 1153
                                    new Common$TRACE(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Pass1.PARSER"),1153,CONC(new TXT$("ENDOF NEW QUANT: "),new Common$edSymbol(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.hash$1).RESULT$));
                                    ;
                                    new Common$prt(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,((Common$quant)inspect$1109$91),0);
                                    ;
                                }
                            }
                            ;
                            // JavaLine 1292 <== SourceLine 1155
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.S_COMMA$1)))) {
                                GOTO$(NID); // GOTO EVALUATED LABEL
                            }
                            ;
                        }
                        break;
                        default:
                        // JavaLine 1300 <== SourceLine 1158
                        {
                            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).tracemode>(0)))) {
                                new Common$WARNING(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("NONE in declarations"));
                            }
                            ;
                            // JavaLine 1306 <== SourceLine 1159
                            GOTO$(EXT); // GOTO EVALUATED LABEL
                            ;
                        }
                        break;
                    } // END SWITCH STATEMENT
                    ;
                    // JavaLine 1313 <== SourceLine 1162
                    constflag=false;
                    ;
                }
            }
            ;
            // JavaLine 1319 <== SourceLine 1165
            LABEL$(9,"EXT");
            ((Pass1$SubBlock32)(CUR$.SL$.SL$)).currentset=oldset;
            ;
            break LOOP$;
        }
        catch(LABQNT$ q) {
            CUR$=THIS$;
            if(q.SL$!=CUR$) {
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("declarations:NON-LOCAL",q);
                CUR$.STATE$=OperationalState.terminated;
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("declarations:RE-THROW",q);
                throw(q);
            }
            if(RT.Option.GOTO_TRACING) TRACE_GOTO("declarations:LOCAL",q);
            JTX$=q.index; continue LOOP$; // EG. GOTO Lx
        }
    }
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure declarations",1,760,13,809,15,829,17,918,19,973,21,1108,23,1109,25,1119,27,1138,29,1165,32,762,36,763,40,764,43,765,47,766,49,767,52,768,54,769,56,812,58,841,60,854,62,875,64,907,66,979,68,985,70,996,72,1109,109,801,112,802,117,804,120,806,122,807,126,809,130,810,133,812,138,816,142,817,147,818,150,819,153,820,156,821,158,822,162,823,167,824,170,825,176,826,178,827,182,828,187,829,193,830,195,831,203,832,207,833,211,834,215,835,221,837,226,838,229,839,232,840,234,841,239,842,245,843,252,845,257,846,262,847,264,848,269,849,272,850,280,854,285,855,289,856,291,857,295,858,298,859,305,860,307,861,311,862,314,863,319,864,322,865,325,866,330,867,335,868,337,869,342,870,345,871,352,875,357,876,361,877,363,878,367,879,370,880,375,881,378,882,383,883,386,884,389,885,394,886,397,887,402,888,405,889,410,890,415,891,422,892,425,893,428,894,433,895,436,896,441,897,444,898,449,899,454,900,456,901,461,902,464,903,474,907,479,909,485,911,487,912,491,913,494,914,496,915,500,916,503,917,508,918,514,919,516,920,524,921,526,922,534,924,539,925,542,926,545,928,550,930,552,931,558,932,563,933,568,934,571,935,574,936,579,937,582,938,585,939,593,941,598,942,603,943,605,945,610,946,613,947,621,962,625,965,635,968,638,969,643,970,650,973,655,974,660,975,663,976,666,977,671,978,674,979,679,980,682,981,686,982,692,984,697,985,701,986,709,988,712,989,720,993,724,994,729,995,732,996,737,997,740,998,744,999,750,1001,753,1002,758,1003,761,1004,766,1005,769,1006,772,1007,777,1008,780,1009,787,1012,790,1013,796,1015,799,1016,801,1017,804,1018,808,1019,813,1020,816,1021,818,1022,820,1023,825,1024,831,1026,836,1029,839,1030,845,1032,850,1033,857,1040,865,1042,873,1044,877,1045,882,1046,889,1048,893,1049,898,1050,901,1051,906,1052,909,1053,912,1054,917,1055,920,1056,925,1057,928,1058,931,1059,936,1060,939,1061,944,1063,952,1065,960,1066,967,1068,975,1070,983,1072,991,1074,999,1076,1003,1077,1010,1078,1012,1079,1016,1080,1021,1081,1024,1082,1033,1084,1037,1085,1044,1086,1046,1087,1050,1088,1055,1089,1058,1090,1067,1092,1071,1093,1076,1094,1079,1095,1084,1096,1087,1097,1090,1098,1092,1099,1096,1100,1101,1101,1104,1102,1109,1103,1112,1104,1115,1105,1118,1106,1123,1108,1127,1154,1129,1109,1134,1110,1138,1111,1143,1112,1146,1113,1149,1114,1152,1115,1155,1116,1157,1117,1161,1118,1166,1119,1172,1120,1174,1121,1185,1123,1187,1124,1191,1125,1196,1126,1199,1127,1204,1128,1207,1129,1212,1130,1218,1132,1223,1133,1225,1134,1231,1135,1234,1136,1236,1138,1241,1139,1244,1140,1246,1141,1249,1142,1253,1143,1261,1146,1263,1147,1270,1149,1276,1151,1279,1152,1284,1153,1292,1155,1300,1158,1306,1159,1313,1162,1319,1165,1339,1166);
} // End of Procedure
