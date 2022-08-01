// JavaLine 1 <== SourceLine 762
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$invariable extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=762, lastLine=1023, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public boolean p$target;
    // Declare local labels
    // JavaLine 14 <== SourceLine 1021
    final LABQNT$ EXT=new LABQNT$(this,1,"EXT"); // Local Label #1=EXT
    // Declare locals as attributes
    // JavaLine 17 <== SourceLine 763
    boolean simple=false;
    boolean vmode=false;
    Common$record remqual=null;
    int n=0;
    // JavaLine 22 <== SourceLine 764
    int vartype=0;
    int r=0;
    int v=0;
    int typ=0;
    int hilo=0;
    // JavaLine 28 <== SourceLine 765
    int t=0;
    int q=0;
    Common$quant a=null;
    // JavaLine 32 <== SourceLine 766
    Linkage$ dentry=null;
    // JavaLine 34 <== SourceLine 826
    Common$TypeNotice inspect$825$187=null;
    // JavaLine 36 <== SourceLine 861
    Common$profile inspect$861$188=null;
    // JavaLine 38 <== SourceLine 876
    Linkage$ inspect$875$189=null;
    // JavaLine 40 <== SourceLine 928
    Common$quant inspect$928$190=null;
    // JavaLine 42 <== SourceLine 960
    PrintFile$ inspect$959$191=null;
    // JavaLine 44 <== SourceLine 984
    Common$TypeSet inspect$983$192=null;
    // JavaLine 46 <== SourceLine 996
    PrintFile$ inspect$995$193=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$invariable setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$invariable.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$target=(boolean)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$invariable(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$invariable(RTObject$ SL$,boolean sp$target) {
        super(SL$);
        // Parameter assignment to locals
        this.p$target = sp$target;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$invariable STM$() {
        Pass2$CompoundStatement21$SubBlock23$invariable THIS$=(Pass2$CompoundStatement21$SubBlock23$invariable)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 79 <== SourceLine 818
                ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                ;
                // JavaLine 82 <== SourceLine 819
                if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_SIMPLE$1)))) {
                    simple=true;
                } else
                // JavaLine 86 <== SourceLine 820
                if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_DOTVAR$1)))) {
                    simple=false;
                } else
                new Common$IERR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141);
                ;
                // JavaLine 92 <== SourceLine 821
                ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                ;
                // JavaLine 95 <== SourceLine 823
                if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_VAREXPR$1)))) {
                    // JavaLine 97 <== SourceLine 824
                    {
                        vartype=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                        ;
                        // JavaLine 101 <== SourceLine 825
                        {
                            // BEGIN INSPECTION 
                            inspect$825$187=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[vartype-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]];
                            if(inspect$825$187!=null) // INSPECT inspect$825$187
                            // JavaLine 106 <== SourceLine 826
                            if(VALUE$((inspect$825$187.p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.nameTypes$1)))) {
                                // JavaLine 108 <== SourceLine 827
                                {
                                    vartype=inspect$825$187.p2$qual;
                                    ;
                                    // JavaLine 112 <== SourceLine 828
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_REFER$1);
                                    ;
                                    new Pass2$CompoundStatement21$SubBlock23$outtype(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),vartype);
                                    ;
                                    // JavaLine 117 <== SourceLine 829
                                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                    }
                                    ;
                                }
                            } else
                            // JavaLine 124 <== SourceLine 830
                            new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("var(-- not name --)"));
                        }
                        ;
                        // JavaLine 128 <== SourceLine 831
                        ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                        ;
                        // JavaLine 131 <== SourceLine 832
                        vmode=((simple)?((!(p$target))):((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[vartype-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.refTypes$1))));
                        ;
                        // JavaLine 134 <== SourceLine 835
                        if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ARGLIST$1)))) {
                            // JavaLine 136 <== SourceLine 836
                            {
                                n=new InptFile$inbyt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                                ;
                                // JavaLine 140 <== SourceLine 837
                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.integerTypes$1)))) {
                                    new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Index is not integer"));
                                }
                                ;
                                // JavaLine 145 <== SourceLine 838
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((vmode)?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_INDEXV$1):(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_INDEX$1)));
                                ;
                                // JavaLine 148 <== SourceLine 839
                                if(VALUE$((n>(1)))) {
                                    // JavaLine 150 <== SourceLine 840
                                    {
                                        new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Only one index allowed"));
                                        ;
                                        n=Math.subtractExact(n,1);
                                        while((n>(0))) {
                                            // JavaLine 156 <== SourceLine 842
                                            {
                                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                                }
                                                ;
                                                // JavaLine 162 <== SourceLine 843
                                                new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$);
                                                ;
                                                // JavaLine 165 <== SourceLine 844
                                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_POP$1);
                                                ;
                                            }
                                            n=Math.subtractExact(n,1);
                                        }
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 175 <== SourceLine 847
                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                }
                                ;
                                // JavaLine 180 <== SourceLine 848
                                ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                                ;
                            }
                        } else
                        // JavaLine 185 <== SourceLine 850
                        if(VALUE$(vmode)) {
                            // JavaLine 187 <== SourceLine 851
                            {
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_FETCH$1);
                                ;
                                // JavaLine 191 <== SourceLine 852
                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                }
                                ;
                            }
                        }
                        ;
                    }
                } else
                // JavaLine 201 <== SourceLine 855
                if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_VARCALL$1)))) {
                    // JavaLine 203 <== SourceLine 856
                    {
                        hilo=new InptFile$in2byt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                        ;
                        // JavaLine 207 <== SourceLine 857
                        dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[hilo-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                        ;
                        // JavaLine 210 <== SourceLine 858
                        ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                        ;
                        // JavaLine 213 <== SourceLine 859
                        if(VALUE$((!(IS$(dentry,Common$profile.class))))) {
                            // JavaLine 215 <== SourceLine 860
                            dentry=new Pass2$CompoundStatement21$SubBlock23$get_prf(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),hilo).RESULT$;
                        }
                        ;
                        // JavaLine 219 <== SourceLine 861
                        {
                            // BEGIN INSPECTION 
                            inspect$861$188=((Common$profile)(dentry));
                            if(inspect$861$188!=null) // INSPECT inspect$861$188
                            // JavaLine 224 <== SourceLine 862
                            {
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PRECALL$1);
                                ;
                                new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$861$188.tag$2);
                                ;
                                // JavaLine 230 <== SourceLine 863
                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                }
                                ;
                                // JavaLine 235 <== SourceLine 864
                                new Pass2$CompoundStatement21$SubBlock23$invariable$rutcall(((Pass2$CompoundStatement21$SubBlock23$invariable)(CUR$)),inspect$861$188.spec$3);
                                ;
                                // JavaLine 238 <== SourceLine 865
                                typ=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$).RESULT$;
                                ;
                                // JavaLine 241 <== SourceLine 866
                                ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new Common$defType(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.entTypes$1,hilo,0,0).RESULT$;
                                ;
                                // JavaLine 244 <== SourceLine 867
                                if(VALUE$((typ!=(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$)))) {
                                    new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),typ,((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$);
                                }
                                ;
                            }
                        }
                        ;
                        // JavaLine 252 <== SourceLine 869
                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_CALL_TOS$1);
                        ;
                        // JavaLine 255 <== SourceLine 870
                        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                        }
                        ;
                        // JavaLine 260 <== SourceLine 871
                        ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                        ;
                    }
                } else
                // JavaLine 265 <== SourceLine 873
                if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_VARID$1)))) {
                    // JavaLine 267 <== SourceLine 874
                    {
                        hilo=new InptFile$in2byt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                        ;
                        ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                        ;
                        // JavaLine 273 <== SourceLine 875
                        {
                            // BEGIN INSPECTION 
                            inspect$875$189=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[hilo-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                            //INSPECT inspect$875$189
                            if(inspect$875$189 instanceof Common$system_descr) // WHEN Common$system_descr DO 
                            // JavaLine 279 <== SourceLine 876
                            vartype=new Pass2$CompoundStatement21$SubBlock23$sysfnc(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$system_descr)inspect$875$189)).RESULT$;
                            else if(inspect$875$189 instanceof Common$label_descr) // WHEN Common$label_descr DO 
                            // JavaLine 282 <== SourceLine 878
                            {
                                vartype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_LABEL$1;
                                ;
                                // JavaLine 286 <== SourceLine 879
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                                ;
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_PADDR$1);
                                ;
                                // JavaLine 291 <== SourceLine 880
                                new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$label_descr)(inspect$875$189)).tag$2);
                                ;
                                // JavaLine 294 <== SourceLine 881
                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                }
                                ;
                            }
                            else if(inspect$875$189 instanceof Common$dest_descr) // WHEN Common$dest_descr DO 
                            // JavaLine 301 <== SourceLine 884
                            {
                                if(VALUE$((((Common$dest_descr)(inspect$875$189)).dx$3==(0)))) {
                                    // JavaLine 304 <== SourceLine 885
                                    {
                                        if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).ndest==(255)))) {
                                            new Common$FATAL_ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Too many labels"));
                                        }
                                        ;
                                        // JavaLine 310 <== SourceLine 886
                                        ((Common$dest_descr)(inspect$875$189)).dx$3=((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).ndest=Math.addExact(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).ndest,1);
                                        ;
                                        // JavaLine 313 <== SourceLine 887
                                        ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).dest_tab.Elt[((Common$dest_descr)(inspect$875$189)).dx$3-((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).dest_tab.LB[0]].p=hilo;
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 319 <== SourceLine 889
                                ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).curdest=((Common$dest_descr)(inspect$875$189)).dx$3;
                                ;
                                vartype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_DEST$1;
                                ;
                            }
                            else if(inspect$875$189 instanceof Common$peculiar) // WHEN Common$peculiar DO 
                            // JavaLine 326 <== SourceLine 892
                            {
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PRECALL$1);
                                ;
                                new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$peculiar)(inspect$875$189)).tag$2);
                                ;
                                // JavaLine 332 <== SourceLine 893
                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                }
                                ;
                                // JavaLine 337 <== SourceLine 894
                                new Pass2$CompoundStatement21$SubBlock23$invariable$rutcall(((Pass2$CompoundStatement21$SubBlock23$invariable)(CUR$)),((Common$peculiar)(inspect$875$189)).spec$3);
                                ;
                                // JavaLine 340 <== SourceLine 895
                                if(VALUE$((((Common$peculiar)(inspect$875$189)).body$4==(0)))) {
                                    // JavaLine 342 <== SourceLine 896
                                    {
                                        new Common$newtag(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$peculiar)(inspect$875$189)).symb$2);
                                        ;
                                        // JavaLine 346 <== SourceLine 897
                                        ((Common$peculiar)(inspect$875$189)).body$4=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.ntag$1;
                                        ;
                                        // JavaLine 349 <== SourceLine 898
                                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ROUTINESPEC$1);
                                        ;
                                        // JavaLine 352 <== SourceLine 899
                                        new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$peculiar)(inspect$875$189)).body$4);
                                        ;
                                        // JavaLine 355 <== SourceLine 900
                                        new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$peculiar)(inspect$875$189)).tag$2);
                                        ;
                                        // JavaLine 358 <== SourceLine 901
                                        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                        }
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 366 <== SourceLine 903
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_CALL$1);
                                ;
                                new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$peculiar)(inspect$875$189)).body$4);
                                ;
                                // JavaLine 371 <== SourceLine 904
                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                }
                                ;
                            }
                            else if(inspect$875$189 instanceof Common$routine) // WHEN Common$routine DO 
                            // JavaLine 378 <== SourceLine 907
                            {
                                dentry=((Common$routine)(inspect$875$189)).profbox$3.curmeaning;
                                ;
                                // JavaLine 382 <== SourceLine 908
                                if(VALUE$((!(IS$(dentry,Common$profile.class))))) {
                                    // JavaLine 384 <== SourceLine 909
                                    dentry=new Pass2$CompoundStatement21$SubBlock23$get_prf(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$routine)(inspect$875$189)).profbox$3.id).RESULT$;
                                }
                                ;
                                // JavaLine 388 <== SourceLine 910
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PRECALL$1);
                                ;
                                // JavaLine 391 <== SourceLine 911
                                new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$profile)(dentry)).tag$2);
                                ;
                                // JavaLine 394 <== SourceLine 912
                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                }
                                ;
                                // JavaLine 399 <== SourceLine 913
                                new Pass2$CompoundStatement21$SubBlock23$invariable$rutcall(((Pass2$CompoundStatement21$SubBlock23$invariable)(CUR$)),((Common$profile)(dentry)).spec$3);
                                ;
                                // JavaLine 402 <== SourceLine 914
                                if(VALUE$((((Common$routine)(inspect$875$189)).tag$2==(0)))) {
                                    // JavaLine 404 <== SourceLine 915
                                    {
                                        new Common$deftag(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$descr)inspect$875$189));
                                        ;
                                        // JavaLine 408 <== SourceLine 916
                                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ROUTINESPEC$1);
                                        ;
                                        // JavaLine 411 <== SourceLine 917
                                        new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$routine)(inspect$875$189)).tag$2);
                                        ;
                                        // JavaLine 414 <== SourceLine 918
                                        new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$profile)(dentry)).tag$2);
                                        ;
                                        // JavaLine 417 <== SourceLine 919
                                        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                        }
                                        ;
                                    }
                                }
                                ;
                                // JavaLine 425 <== SourceLine 921
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_CALL$1);
                                ;
                                new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$routine)(inspect$875$189)).tag$2);
                                ;
                                // JavaLine 430 <== SourceLine 922
                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                }
                                ;
                            }
                            else // OTHERWISE 
                            // JavaLine 437 <== SourceLine 925
                            {
                                dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[hilo-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                                ;
                                // JavaLine 441 <== SourceLine 926
                                if(VALUE$((!(IS$(dentry,Common$quant.class))))) {
                                    // JavaLine 443 <== SourceLine 927
                                    dentry=new Pass2$CompoundStatement21$SubBlock23$get_qnt(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),hilo).RESULT$;
                                }
                                ;
                                // JavaLine 447 <== SourceLine 928
                                {
                                    // BEGIN INSPECTION 
                                    inspect$928$190=((Common$quant)(dentry));
                                    if(inspect$928$190!=null) // INSPECT inspect$928$190
                                    // JavaLine 452 <== SourceLine 929
                                    {
                                        vartype=inspect$928$190.p3$type;
                                        ;
                                        // JavaLine 456 <== SourceLine 930
                                        vmode=((simple)?((!(p$target))):((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[inspect$928$190.p3$type-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.refTypes$1))));
                                        ;
                                        // JavaLine 459 <== SourceLine 933
                                        if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ARGLIST$1)))) {
                                            // JavaLine 461 <== SourceLine 934
                                            {
                                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSH$1);
                                                ;
                                                new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$928$190.tag$2);
                                                ;
                                                // JavaLine 467 <== SourceLine 935
                                                n=new InptFile$inbyt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                                                ;
                                                // JavaLine 470 <== SourceLine 936
                                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.integerTypes$1)))) {
                                                    new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Index is not integer"));
                                                }
                                                ;
                                                // JavaLine 475 <== SourceLine 937
                                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((vmode)?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_INDEXV$1):(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_INDEX$1)));
                                                ;
                                                // JavaLine 478 <== SourceLine 938
                                                if(VALUE$((n>(1)))) {
                                                    // JavaLine 480 <== SourceLine 939
                                                    {
                                                        new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Only one index allowed"));
                                                        ;
                                                        n=Math.subtractExact(n,1);
                                                        while((n>(0))) {
                                                            // JavaLine 486 <== SourceLine 941
                                                            {
                                                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                                                }
                                                                ;
                                                                // JavaLine 492 <== SourceLine 942
                                                                new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$);
                                                                ;
                                                                // JavaLine 495 <== SourceLine 943
                                                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_POP$1);
                                                                ;
                                                            }
                                                            n=Math.subtractExact(n,1);
                                                        }
                                                        ;
                                                    }
                                                }
                                                ;
                                                // JavaLine 505 <== SourceLine 946
                                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                                }
                                                ;
                                                // JavaLine 510 <== SourceLine 947
                                                ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                                                ;
                                            }
                                        } else
                                        // JavaLine 515 <== SourceLine 950
                                        {
                                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((vmode)?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHV$1):(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSH$1)));
                                            ;
                                            // JavaLine 519 <== SourceLine 951
                                            new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$928$190.tag$2);
                                            ;
                                            // JavaLine 522 <== SourceLine 952
                                            if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                                new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                            }
                                            ;
                                        }
                                        ;
                                    }
                                }
                                ;
                            }
                        }
                        ;
                    }
                } else
                // JavaLine 537 <== SourceLine 957
                new Common$IERR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141);
                ;
                // JavaLine 540 <== SourceLine 959
                if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).tracemode>(2)))) {
                    {
                        // BEGIN INSPECTION 
                        inspect$959$191=sysout();
                        if(inspect$959$191!=null) // INSPECT inspect$959$191
                        // JavaLine 546 <== SourceLine 960
                        {
                            inspect$959$191.setpos(22);
                            ;
                            inspect$959$191.outtext(new TXT$("Variable type: "));
                            ;
                            // JavaLine 552 <== SourceLine 961
                            inspect$959$191.outtext((((vartype==(0)))?(new TXT$("no-type")):(new Common$edtype(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,vartype).RESULT$)));
                            ;
                            // JavaLine 555 <== SourceLine 962
                            inspect$959$191.outimage();
                            ;
                        }
                    }
                }
                ;
                // JavaLine 562 <== SourceLine 964
                while((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ENDVAR$1))) {
                    // JavaLine 564 <== SourceLine 965
                    {
                        if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_QUA$1)))) {
                            // JavaLine 567 <== SourceLine 966
                            {
                                typ=new InptFile$inbyt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                                ;
                                // JavaLine 571 <== SourceLine 967
                                if(VALUE$((vartype!=(typ)))) {
                                    // JavaLine 573 <== SourceLine 968
                                    {
                                        new Pass2$CompoundStatement21$SubBlock23$convert(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),vartype,typ);
                                        ;
                                        vartype=typ;
                                    }
                                }
                                ;
                            }
                        } else
                        // JavaLine 583 <== SourceLine 970
                        if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_DOT$1)))) {
                            new Common$IERR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141);
                        }
                        ;
                        // JavaLine 588 <== SourceLine 971
                        hilo=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[vartype-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$qual;
                        ;
                        // JavaLine 591 <== SourceLine 972
                        if(VALUE$((hilo==(0)))) {
                            new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Missing qua in remote access"));
                        }
                        ;
                        // JavaLine 596 <== SourceLine 973
                        remqual=((Common$record)(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[hilo-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning));
                        ;
                        // JavaLine 599 <== SourceLine 974
                        if(VALUE$((!(IS$(remqual,Common$record.class))))) {
                            remqual=new Pass2$CompoundStatement21$SubBlock23$get_rec(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),hilo).RESULT$;
                        }
                        ;
                        // JavaLine 604 <== SourceLine 975
                        if(VALUE$((new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_VAR$1)))) {
                            new Common$IERR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141);
                        }
                        ;
                        // JavaLine 609 <== SourceLine 976
                        ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                        ;
                        // JavaLine 612 <== SourceLine 977
                        if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_SIMPLE$1)))) {
                            simple=true;
                        } else
                        // JavaLine 616 <== SourceLine 978
                        if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_DOTVAR$1)))) {
                            simple=false;
                        } else
                        new Common$IERR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141);
                        ;
                        // JavaLine 622 <== SourceLine 979
                        if(VALUE$((new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_VARID$1)))) {
                            new Common$IERR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141);
                        }
                        ;
                        // JavaLine 627 <== SourceLine 980
                        hilo=new InptFile$in2byt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                        ;
                        // JavaLine 630 <== SourceLine 981
                        ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                        ;
                        // JavaLine 633 <== SourceLine 982
                        a=new Common$rec_atr(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,remqual,hilo).RESULT$;
                        ;
                        // JavaLine 636 <== SourceLine 983
                        {
                            // BEGIN INSPECTION 
                            inspect$983$192=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[vartype-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set;
                            if(inspect$983$192!=null) // INSPECT inspect$983$192
                            // JavaLine 641 <== SourceLine 984
                            if(VALUE$((inspect$983$192.p2$type==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TYP_REF$1)))) {
                                // JavaLine 643 <== SourceLine 985
                                {
                                    r=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_REMOTE$1;
                                    ;
                                    v=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_REMOTEV$1;
                                }
                            } else
                            // JavaLine 650 <== SourceLine 986
                            if(VALUE$((inspect$983$192.p2$type==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.TYP_STRUCT$1)))) {
                                // JavaLine 652 <== SourceLine 987
                                {
                                    r=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_SELECT$1;
                                    ;
                                    v=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_SELECTV$1;
                                }
                            } else
                            // JavaLine 659 <== SourceLine 988
                            {
                                new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Remote access through non-ref variable"));
                                ;
                                // JavaLine 663 <== SourceLine 989
                                GOTO$(EXT); // GOTO EVALUATED LABEL
                                ;
                            }
                        }
                        ;
                        // JavaLine 669 <== SourceLine 991
                        if(VALUE$((a!=(null)))) {
                            // JavaLine 671 <== SourceLine 992
                            {
                                vartype=a.p3$type;
                                ;
                                // JavaLine 675 <== SourceLine 993
                                vmode=((simple)?((!(p$target))):((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[a.p3$type-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.refTypes$1))));
                                ;
                                // JavaLine 678 <== SourceLine 995
                                if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).tracemode>(2)))) {
                                    {
                                        // BEGIN INSPECTION 
                                        inspect$995$193=sysout();
                                        if(inspect$995$193!=null) // INSPECT inspect$995$193
                                        // JavaLine 684 <== SourceLine 996
                                        {
                                            inspect$995$193.setpos(21);
                                            ;
                                            inspect$995$193.outtext(new TXT$("Attribute type: "));
                                            ;
                                            // JavaLine 690 <== SourceLine 997
                                            inspect$995$193.outtext(new Common$edtype(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,vartype).RESULT$);
                                            ;
                                            inspect$995$193.outimage();
                                            ;
                                        }
                                    }
                                }
                                ;
                                // JavaLine 699 <== SourceLine 999
                                if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ARGLIST$1)))) {
                                    // JavaLine 701 <== SourceLine 1000
                                    {
                                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,r);
                                        ;
                                        new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,a.tag$2);
                                        ;
                                        // JavaLine 707 <== SourceLine 1001
                                        n=new InptFile$inbyt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                                        ;
                                        // JavaLine 710 <== SourceLine 1002
                                        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.integerTypes$1)))) {
                                            new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Index is not integer"));
                                        }
                                        ;
                                        // JavaLine 715 <== SourceLine 1003
                                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((vmode)?(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_INDEXV$1):(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_INDEX$1)));
                                        ;
                                        // JavaLine 718 <== SourceLine 1004
                                        if(VALUE$((n>(1)))) {
                                            // JavaLine 720 <== SourceLine 1005
                                            {
                                                new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Only one index allowed"));
                                                ;
                                                n=Math.subtractExact(n,1);
                                                while((n>(0))) {
                                                    // JavaLine 726 <== SourceLine 1007
                                                    {
                                                        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                                            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                                        }
                                                        ;
                                                        // JavaLine 732 <== SourceLine 1008
                                                        new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$);
                                                        ;
                                                        // JavaLine 735 <== SourceLine 1010
                                                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_POP$1);
                                                    }
                                                    n=Math.subtractExact(n,1);
                                                }
                                                ;
                                            }
                                        }
                                        ;
                                        // JavaLine 744 <== SourceLine 1012
                                        if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                            new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                        }
                                        ;
                                        // JavaLine 749 <== SourceLine 1013
                                        ((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                                        ;
                                    }
                                } else
                                // JavaLine 754 <== SourceLine 1016
                                {
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((vmode)?(v):(r)));
                                    ;
                                    // JavaLine 758 <== SourceLine 1017
                                    new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,a.tag$2);
                                    ;
                                    // JavaLine 761 <== SourceLine 1018
                                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                    }
                                    ;
                                }
                                ;
                            }
                        }
                        ;
                        // JavaLine 771 <== SourceLine 1021
                        LABEL$(1,"EXT");
                        ;
                    }
                }
                ;
                // JavaLine 777 <== SourceLine 1022
                RESULT$=vartype;
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("invariable:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("invariable:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("invariable:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure invariable",1,762,14,1021,17,763,22,764,28,765,32,766,34,826,36,861,38,876,40,928,42,960,44,984,46,996,79,818,82,819,86,820,92,821,95,823,97,824,101,825,106,826,108,827,112,828,117,829,124,830,128,831,131,832,134,835,136,836,140,837,145,838,148,839,150,840,156,842,162,843,165,844,175,847,180,848,185,850,187,851,191,852,201,855,203,856,207,857,210,858,213,859,215,860,219,861,224,862,230,863,235,864,238,865,241,866,244,867,252,869,255,870,260,871,265,873,267,874,273,875,279,876,282,878,286,879,291,880,294,881,301,884,304,885,310,886,313,887,319,889,326,892,332,893,337,894,340,895,342,896,346,897,349,898,352,899,355,900,358,901,366,903,371,904,378,907,382,908,384,909,388,910,391,911,394,912,399,913,402,914,404,915,408,916,411,917,414,918,417,919,425,921,430,922,437,925,441,926,443,927,447,928,452,929,456,930,459,933,461,934,467,935,470,936,475,937,478,938,480,939,486,941,492,942,495,943,505,946,510,947,515,950,519,951,522,952,537,957,540,959,546,960,552,961,555,962,562,964,564,965,567,966,571,967,573,968,583,970,588,971,591,972,596,973,599,974,604,975,609,976,612,977,616,978,622,979,627,980,630,981,633,982,636,983,641,984,643,985,650,986,652,987,659,988,663,989,669,991,671,992,675,993,678,995,684,996,690,997,699,999,701,1000,707,1001,710,1002,715,1003,718,1004,720,1005,726,1007,732,1008,735,1010,744,1012,749,1013,754,1016,758,1017,761,1018,771,1021,777,1022,796,1023);
} // End of Procedure
