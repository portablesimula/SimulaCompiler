// JavaLine 1 ==> SourceLine 768
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PARSER$grammer$declaration extends PARSER$grammer$statement {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=768, lastLine=973, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 835
    final LABQNT$ REUSE=new LABQNT$(this,1,1); // Local Label #1=REUSE
    // JavaLine 14 ==> SourceLine 843
    final LABQNT$ S0=new LABQNT$(this,1,2); // Local Label #2=S0
    // JavaLine 16 ==> SourceLine 864
    final LABQNT$ PARSE=new LABQNT$(this,1,3); // Local Label #3=PARSE
    // JavaLine 18 ==> SourceLine 870
    final LABQNT$ S1=new LABQNT$(this,1,4); // Local Label #4=S1
    // JavaLine 20 ==> SourceLine 876
    final LABQNT$ C1=new LABQNT$(this,1,5); // Local Label #5=C1
    // JavaLine 22 ==> SourceLine 889
    final LABQNT$ S2=new LABQNT$(this,1,6); // Local Label #6=S2
    // JavaLine 24 ==> SourceLine 905
    final LABQNT$ R1=new LABQNT$(this,1,7); // Local Label #7=R1
    // JavaLine 26 ==> SourceLine 919
    final LABQNT$ S3=new LABQNT$(this,1,8); // Local Label #8=S3
    // Declare locals as attributes
    // JavaLine 29 ==> SourceLine 771
    public boolean innerseen=false;
    public boolean priorseen=false;
    public PRCQNT$ recover$0() { return(new PRCQNT$(this,PARSER$grammer$declaration$recover.class)); }
    // Normal Constructor
    public PARSER$grammer$declaration(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("declaration",828);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("declaration",828,inner);
                PARSER$grammer$declaration THIS$=(PARSER$grammer$declaration)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 47 ==> SourceLine 832
                        detach();
                        // JavaLine 49 ==> SourceLine 838
                        LABEL$(1,"REUSE");
                        // JavaLine 51 ==> SourceLine 835
                        if(VALUE$(((!(caller.isblocklike))||((caller.blockstatus==(((PARSER$grammer)(CUR$.SL$)).lastwasstmt)))))) {
                            // JavaLine 53 ==> SourceLine 838
                            {
                                TRACE_BEGIN_STM$("CompoundStatement838",838);
                                new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$)),289);
                                caller.blockstatus=((PARSER$grammer)(CUR$.SL$)).stmtnotseen;
                                TRACE_END_STM$("CompoundStatement838",838);
                            }
                        }
                        // JavaLine 61 ==> SourceLine 839
                        caller.stmttype=((PARSER$grammer)(CUR$.SL$)).declunit;
                        // JavaLine 63 ==> SourceLine 952
                        LABEL$(2,"S0");
                        // JavaLine 65 ==> SourceLine 843
                        if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IPROC)))) {
                            // JavaLine 67 ==> SourceLine 845
                            {
                                TRACE_BEGIN_STM$("CompoundStatement845",845);
                                ((PARSER$grammer)(CUR$.SL$)).blockfound=(((PARSER$grammer)(CUR$.SL$)).blockfound+(1));
                                // JavaLine 71 ==> SourceLine 847
                                if(VALUE$((((PARSER$grammer)(CUR$.SL$)).readtype==(((PARSER)(CUR$.SL$.SL$)).NUL)))) {
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement847",847);
                                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).INOTY;
                                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                                        TRACE_END_STM$("CompoundStatement847",847);
                                    }
                                }
                                // JavaLine 80 ==> SourceLine 848
                                ((PARSER$grammer)(CUR$.SL$)).readtype=((PARSER)(CUR$.SL$.SL$)).NUL;
                                // JavaLine 82 ==> SourceLine 849
                                ((PARSER$grammer)(CUR$.SL$)).detach();
                                // JavaLine 84 ==> SourceLine 850
                                if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IIDN)))) {
                                    new PARSER$grammer$declaration$declError(((PARSER$grammer$declaration)CUR$),185);
                                }
                                // JavaLine 88 ==> SourceLine 851
                                if(VALUE$((caller.stmtreq==(((PARSER$grammer)(CUR$.SL$)).outermost)))) {
                                    new PARSER$grammer$declaration$REGSEPCOMP(((PARSER$grammer$declaration)CUR$));
                                }
                                // JavaLine 92 ==> SourceLine 857
                                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IDCLP;
                                call(((PARSER)(CUR$.SL$.SL$)).coder);
                                // JavaLine 95 ==> SourceLine 858
                                ((PARSER$grammer)(CUR$.SL$)).getopt=false;
                                ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).opt;
                                // JavaLine 98 ==> SourceLine 859
                                if(VALUE$((((PARSER)(CUR$.SL$.SL$)).option.Elt[rank('I')-((PARSER)(CUR$.SL$.SL$)).option.LB[0]]!=(((PARSER)(CUR$.SL$.SL$)).NUL)))) {
                                    new PARSER$grammer$lookforstring(((PARSER$grammer)(CUR$.SL$)));
                                }
                                // JavaLine 102 ==> SourceLine 860
                                new PARSER$grammer$readprocpar(((PARSER$grammer)(CUR$.SL$)),((PARSER)(CUR$.SL$.SL$)).IPSPC);
                                // JavaLine 104 ==> SourceLine 861
                                rp=((char)1);
                                stmtreq=((PARSER$grammer)(CUR$.SL$)).procbody;
                                // JavaLine 107 ==> SourceLine 862
                                errorno=2;
                                // JavaLine 109 ==> SourceLine 864
                                LABEL$(3,"PARSE");
                                detach();
                                // JavaLine 112 ==> SourceLine 866
                                switch(rp) { // BEGIN SWITCH STATEMENT
                                case 0: 
                                // JavaLine 115 ==> SourceLine 867
                                GOTO$(S0); // GOTO EVALUATED LABEL
                                case 2: 
                                // JavaLine 118 ==> SourceLine 868
                                GOTO$(S2); // GOTO EVALUATED LABEL
                                case 3: 
                                // JavaLine 121 ==> SourceLine 869
                                GOTO$(S3); // GOTO EVALUATED LABEL
                            } // END SWITCH STATEMENT
                            // JavaLine 124 ==> SourceLine 870
                            LABEL$(4,"S1");
                            ((PARSER$grammer)(CUR$.SL$)).blockfound=(((PARSER$grammer)(CUR$.SL$)).blockfound-(1));
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IEND;
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            TRACE_END_STM$("CompoundStatement845",870);
                        }
                    } else
                    // JavaLine 132 ==> SourceLine 872
                    if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IIDN)))) {
                        // JavaLine 134 ==> SourceLine 873
                        {
                            TRACE_BEGIN_STM$("CompoundStatement873",873);
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).ICPRF;
                            GOTO$((((((PARSER)(CUR$.SL$.SL$)).opt==(((PARSER)(CUR$.SL$.SL$)).ICLAS)))?(C1):(R1))); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement873",873);
                        }
                    } else
                    // JavaLine 142 ==> SourceLine 874
                    if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ICLAS)))) {
                        // JavaLine 144 ==> SourceLine 875
                        {
                            TRACE_BEGIN_STM$("CompoundStatement875",875);
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).INOTY;
                            // JavaLine 148 ==> SourceLine 876
                            LABEL$(5,"C1");
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            // JavaLine 151 ==> SourceLine 877
                            ((PARSER$grammer)(CUR$.SL$)).detach();
                            // JavaLine 153 ==> SourceLine 879
                            if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IIDN)))) {
                                new PARSER$grammer$declaration$declError(((PARSER$grammer$declaration)CUR$),185);
                            }
                            // JavaLine 157 ==> SourceLine 880
                            if(VALUE$((caller.stmtreq==(((PARSER$grammer)(CUR$.SL$)).outermost)))) {
                                new PARSER$grammer$declaration$REGSEPCOMP(((PARSER$grammer$declaration)CUR$));
                            }
                            // JavaLine 161 ==> SourceLine 881
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IDCLC;
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            // JavaLine 164 ==> SourceLine 882
                            ((PARSER$grammer)(CUR$.SL$)).getopt=false;
                            ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).opt;
                            // JavaLine 167 ==> SourceLine 883
                            if(VALUE$((((PARSER)(CUR$.SL$.SL$)).option.Elt[rank('I')-((PARSER)(CUR$.SL$.SL$)).option.LB[0]]!=(((PARSER)(CUR$.SL$.SL$)).NUL)))) {
                                new PARSER$grammer$lookforstring(((PARSER$grammer)(CUR$.SL$)));
                            }
                            // JavaLine 171 ==> SourceLine 884
                            new PARSER$grammer$readclasspar(((PARSER$grammer)(CUR$.SL$)));
                            // JavaLine 173 ==> SourceLine 885
                            rp=((char)2);
                            stmtreq=((PARSER$grammer)(CUR$.SL$)).classbody;
                            // JavaLine 176 ==> SourceLine 886
                            stmttype=((PARSER$grammer)(CUR$.SL$)).dummystmt;
                            // JavaLine 178 ==> SourceLine 887
                            errorno=2;
                            // JavaLine 180 ==> SourceLine 888
                            GOTO$(PARSE); // GOTO EVALUATED LABEL
                            // JavaLine 182 ==> SourceLine 900
                            LABEL$(6,"S2");
                            // JavaLine 184 ==> SourceLine 889
                            if(VALUE$(innerseen)) {
                                // JavaLine 186 ==> SourceLine 890
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement890",890);
                                    ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IEND;
                                    ((PARSER)(CUR$.SL$.SL$)).opdlo=((PARSER)(CUR$.SL$.SL$)).NUL;
                                    TRACE_END_STM$("CompoundStatement890",890);
                                }
                            } else
                            // JavaLine 194 ==> SourceLine 893
                            {
                                TRACE_BEGIN_STM$("CompoundStatement893",893);
                                if(VALUE$((blockstatus==(((PARSER$grammer)(CUR$.SL$)).stmtnotseen)))) {
                                    // JavaLine 198 ==> SourceLine 894
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement894",894);
                                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IDCLE;
                                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                                        TRACE_END_STM$("CompoundStatement894",894);
                                    }
                                }
                                // JavaLine 206 ==> SourceLine 895
                                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IECWI;
                                // JavaLine 208 ==> SourceLine 896
                                ((PARSER)(CUR$.SL$.SL$)).opdlo=((((stmttype>=(((PARSER$grammer)(CUR$.SL$)).declunit))||(priorseen)))?(((PARSER)(CUR$.SL$.SL$)).NUL):(((char)1)));
                                TRACE_END_STM$("CompoundStatement893",896);
                            }
                            // JavaLine 212 ==> SourceLine 901
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            TRACE_END_STM$("CompoundStatement875",901);
                        }
                    } else
                    // JavaLine 217 ==> SourceLine 903
                    if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IRCRD)))) {
                        // JavaLine 219 ==> SourceLine 904
                        {
                            TRACE_BEGIN_STM$("CompoundStatement904",904);
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).INOTY;
                            // JavaLine 223 ==> SourceLine 905
                            LABEL$(7,"R1");
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            // JavaLine 226 ==> SourceLine 906
                            ((PARSER$grammer)(CUR$.SL$)).detach();
                            // JavaLine 228 ==> SourceLine 908
                            if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IIDN)))) {
                                new PARSER$grammer$declaration$declError(((PARSER$grammer$declaration)CUR$),185);
                            }
                            // JavaLine 232 ==> SourceLine 909
                            if(VALUE$((caller.stmtreq==(((PARSER$grammer)(CUR$.SL$)).outermost)))) {
                                new PARSER$grammer$declaration$REGSEPCOMP(((PARSER$grammer$declaration)CUR$));
                            }
                            // JavaLine 236 ==> SourceLine 910
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IREAC;
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            // JavaLine 239 ==> SourceLine 911
                            if(VALUE$((((PARSER)(CUR$.SL$.SL$)).option.Elt[rank('I')-((PARSER)(CUR$.SL$.SL$)).option.LB[0]]!=(((PARSER)(CUR$.SL$.SL$)).NUL)))) {
                                new PARSER$grammer$lookforstring(((PARSER$grammer)(CUR$.SL$)));
                            }
                            // JavaLine 243 ==> SourceLine 913
                            if(VALUE$((((PARSER)(CUR$.SL$.SL$)).opt!=(((PARSER)(CUR$.SL$.SL$)).ISMCL)))) {
                                new PARSER$grammer$declaration$declError(((PARSER$grammer$declaration)CUR$),286);
                            }
                            // JavaLine 247 ==> SourceLine 914
                            ((PARSER$grammer)(CUR$.SL$)).detach();
                            // JavaLine 249 ==> SourceLine 915
                            rp=((char)3);
                            stmtreq=((PARSER$grammer)(CUR$.SL$)).classbody;
                            // JavaLine 252 ==> SourceLine 916
                            stmttype=((PARSER$grammer)(CUR$.SL$)).dummystmt;
                            // JavaLine 254 ==> SourceLine 917
                            errorno=2;
                            // JavaLine 256 ==> SourceLine 918
                            GOTO$(PARSE); // GOTO EVALUATED LABEL
                            // JavaLine 258 ==> SourceLine 920
                            LABEL$(8,"S3");
                            // JavaLine 260 ==> SourceLine 919
                            if(VALUE$((blockstatus==(((PARSER$grammer)(CUR$.SL$)).stmtnotseen)))) {
                                // JavaLine 262 ==> SourceLine 920
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement920",920);
                                    ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IDCLE;
                                    call(((PARSER)(CUR$.SL$.SL$)).coder);
                                    TRACE_END_STM$("CompoundStatement920",920);
                                }
                            }
                            // JavaLine 270 ==> SourceLine 921
                            if(VALUE$((priorseen||((stmttype>=(((PARSER$grammer)(CUR$.SL$)).declunit)))))) {
                            } else
                            // JavaLine 273 ==> SourceLine 922
                            new PARSER$grammer$declaration$declError(((PARSER$grammer$declaration)CUR$),240);
                            // JavaLine 275 ==> SourceLine 923
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IAFTR;
                            // JavaLine 277 ==> SourceLine 924
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            TRACE_END_STM$("CompoundStatement904",924);
                        }
                    } else
                    // JavaLine 282 ==> SourceLine 926
                    if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IEXTR)))) {
                        // JavaLine 284 ==> SourceLine 927
                        {
                            TRACE_BEGIN_STM$("CompoundStatement927",927);
                            ((PARSER$grammer)(CUR$.SL$)).detach();
                            // JavaLine 288 ==> SourceLine 928
                            if(VALUE$(((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ICLAS))||((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IRCRD)))))) {
                                // JavaLine 290 ==> SourceLine 929
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement929",929);
                                    ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).INOTY;
                                    call(((PARSER)(CUR$.SL$.SL$)).coder);
                                    ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER$grammer)(CUR$.SL$)).cs;
                                    call(((PARSER)(CUR$.SL$.SL$)).coder);
                                    TRACE_END_STM$("CompoundStatement929",929);
                                }
                            } else
                            // JavaLine 300 ==> SourceLine 931
                            {
                                TRACE_BEGIN_STM$("CompoundStatement931",931);
                                priorseen=true;
                                // JavaLine 304 ==> SourceLine 932
                                if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IIDN)))) {
                                    // JavaLine 306 ==> SourceLine 933
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement933",933);
                                        if(VALUE$((caller.stmtreq==(((PARSER$grammer)(CUR$.SL$)).outermost)))) {
                                            new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$)),222);
                                        }
                                        // JavaLine 312 ==> SourceLine 935
                                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).ILANG;
                                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                                        // JavaLine 315 ==> SourceLine 936
                                        ((PARSER$grammer)(CUR$.SL$)).getopt=false;
                                        ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).opt;
                                        TRACE_END_STM$("CompoundStatement933",936);
                                    }
                                }
                                // JavaLine 321 ==> SourceLine 938
                                new PARSER$grammer$readtypespec(((PARSER$grammer)(CUR$.SL$)));
                                // JavaLine 323 ==> SourceLine 939
                                if(VALUE$((((PARSER$grammer)(CUR$.SL$)).readtype==(((PARSER)(CUR$.SL$.SL$)).NUL)))) {
                                    // JavaLine 325 ==> SourceLine 940
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement940",940);
                                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).INOTY;
                                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                                        TRACE_END_STM$("CompoundStatement940",940);
                                    }
                                }
                                // JavaLine 333 ==> SourceLine 941
                                if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IPROC)))) {
                                    new PARSER$grammer$declaration$declError(((PARSER$grammer$declaration)CUR$),192);
                                }
                                // JavaLine 337 ==> SourceLine 942
                                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IPROC;
                                call(((PARSER)(CUR$.SL$.SL$)).coder);
                                TRACE_END_STM$("CompoundStatement931",942);
                            }
                            // JavaLine 342 ==> SourceLine 944
                            new PARSER$grammer$declaration$externalItem(((PARSER$grammer$declaration)CUR$));
                            // JavaLine 344 ==> SourceLine 945
                            if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IIS)))) {
                                // JavaLine 346 ==> SourceLine 946
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement946",946);
                                    if(VALUE$((!(priorseen)))) {
                                        new PARSER$grammer$declaration$declError(((PARSER$grammer$declaration)CUR$),219);
                                    }
                                    // JavaLine 352 ==> SourceLine 947
                                    if(VALUE$((!(new PARSER$grammer$extbinding(((PARSER$grammer)(CUR$.SL$))).RESULT$)))) {
                                        // JavaLine 354 ==> SourceLine 948
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement948",948);
                                            errorno=1;
                                            new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$)),220);
                                            GOTO$(PARSE); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement948",948);
                                        }
                                    }
                                    TRACE_END_STM$("CompoundStatement946",948);
                                }
                            } else
                            // JavaLine 366 ==> SourceLine 950
                            while((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ICOMA))) {
                                new PARSER$grammer$declaration$externalItem(((PARSER$grammer$declaration)CUR$));
                            }
                            TRACE_END_STM$("CompoundStatement927",950);
                        }
                    } else
                    // JavaLine 373 ==> SourceLine 952
                    new ERRMSG$internerr(((PARSER)(CUR$.SL$.SL$)),((char)4),952);
                    // JavaLine 375 ==> SourceLine 954
                    if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ISMCL)))) {
                        // JavaLine 377 ==> SourceLine 956
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                    } else
                    if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IEOP)))) {
                        new PARSER$grammer$declaration$declError(((PARSER$grammer$declaration)CUR$),286);
                    }
                    // JavaLine 383 ==> SourceLine 960
                    caller.next=null;
                    ((PARSER$grammer)(CUR$.SL$)).last=caller;
                    // JavaLine 386 ==> SourceLine 961
                    ((PARSER$grammer)(CUR$.SL$)).deList=((PARSER$grammer$statement)CUR$);
                    // JavaLine 388 ==> SourceLine 963
                    detach();
                    // JavaLine 390 ==> SourceLine 966
                    ((PARSER$grammer)(CUR$.SL$)).deList=null;
                    // JavaLine 392 ==> SourceLine 967
                    errorno=0;
                    // JavaLine 394 ==> SourceLine 968
                    priorseen=innerseen=recovered=isblocklike=false;
                    // JavaLine 396 ==> SourceLine 970
                    rp=blockstatus=stmtreq=stmttype=((PARSER)(CUR$.SL$.SL$)).NUL;
                    // JavaLine 398 ==> SourceLine 971
                    GOTO$(REUSE); // GOTO EVALUATED LABEL
                    // JavaLine 400 ==> SourceLine 832
                    if(inner!=null) {
                        inner.STM$();
                        TRACE_BEGIN_STM_AFTER_INNER$("declaration",832);
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
            TRACE_END_STM$("declaration",832);
        }
    };
} // End of Constructor
// Class Statements
public PARSER$grammer$declaration STM$() { return((PARSER$grammer$declaration)CODE$.EXEC$()); }
public PARSER$grammer$declaration START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Class declaration",1,768,12,835,14,843,16,864,18,870,20,876,22,889,24,905,26,919,29,771,47,832,49,838,51,835,53,838,61,839,63,952,65,843,67,845,71,847,80,848,82,849,84,850,88,851,92,857,95,858,98,859,102,860,104,861,107,862,109,864,112,866,115,867,118,868,121,869,124,870,132,872,134,873,142,874,144,875,148,876,151,877,153,879,157,880,161,881,164,882,167,883,171,884,173,885,176,886,178,887,180,888,182,900,184,889,186,890,194,893,198,894,206,895,208,896,212,901,217,903,219,904,223,905,226,906,228,908,232,909,236,910,239,911,243,913,247,914,249,915,252,916,254,917,256,918,258,920,260,919,262,920,270,921,273,922,275,923,277,924,282,926,284,927,288,928,290,929,300,931,304,932,306,933,312,935,315,936,321,938,323,939,325,940,333,941,337,942,342,944,344,945,346,946,352,947,354,948,366,950,373,952,375,954,377,956,383,960,386,961,388,963,390,966,392,967,394,968,396,970,398,971,400,832,424,973);
}
