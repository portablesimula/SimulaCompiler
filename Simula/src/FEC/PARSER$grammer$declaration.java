// JavaLine 1 ==> SourceLine 768
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PARSER$grammer$declaration extends PARSER$grammer$statement {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=768, lastLine=973, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 827
    final LABQNT$ NoSpec=new LABQNT$(this,1,1); // Local Label #1=NoSpec
    // JavaLine 14 ==> SourceLine 835
    final LABQNT$ REUSE=new LABQNT$(this,1,2); // Local Label #2=REUSE
    // JavaLine 16 ==> SourceLine 843
    final LABQNT$ S0=new LABQNT$(this,1,3); // Local Label #3=S0
    // JavaLine 18 ==> SourceLine 864
    final LABQNT$ PARSE=new LABQNT$(this,1,4); // Local Label #4=PARSE
    // JavaLine 20 ==> SourceLine 870
    final LABQNT$ S1=new LABQNT$(this,1,5); // Local Label #5=S1
    // JavaLine 22 ==> SourceLine 876
    final LABQNT$ C1=new LABQNT$(this,1,6); // Local Label #6=C1
    // JavaLine 24 ==> SourceLine 889
    final LABQNT$ S2=new LABQNT$(this,1,7); // Local Label #7=S2
    // JavaLine 26 ==> SourceLine 905
    final LABQNT$ R1=new LABQNT$(this,1,8); // Local Label #8=R1
    // JavaLine 28 ==> SourceLine 919
    final LABQNT$ S3=new LABQNT$(this,1,9); // Local Label #9=S3
    // Declare locals as attributes
    // JavaLine 31 ==> SourceLine 771
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
                        // JavaLine 49 ==> SourceLine 832
                        detach();
                        // JavaLine 51 ==> SourceLine 838
                        LABEL$(2); // REUSE
                        // JavaLine 53 ==> SourceLine 835
                        if(((!(caller.isblocklike))||((caller.blockstatus==(((PARSER$grammer)(CUR$.SL$)).lastwasstmt))))) {
                            // JavaLine 55 ==> SourceLine 838
                            {
                                TRACE_BEGIN_STM$("CompoundStatement838",838);
                                new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$)),289);
                                caller.blockstatus=((PARSER$grammer)(CUR$.SL$)).stmtnotseen;
                                TRACE_END_STM$("CompoundStatement838",838);
                            }
                        }
                        // JavaLine 63 ==> SourceLine 839
                        caller.stmttype=((PARSER$grammer)(CUR$.SL$)).declunit;
                        // JavaLine 65 ==> SourceLine 952
                        LABEL$(3); // S0
                        // JavaLine 67 ==> SourceLine 843
                        if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IPROC))) {
                            // JavaLine 69 ==> SourceLine 845
                            {
                                TRACE_BEGIN_STM$("CompoundStatement845",845);
                                ((PARSER$grammer)(CUR$.SL$)).blockfound=(((PARSER$grammer)(CUR$.SL$)).blockfound+(1));
                                // JavaLine 73 ==> SourceLine 847
                                if((((PARSER$grammer)(CUR$.SL$)).readtype==(((PARSER)(CUR$.SL$.SL$)).NUL))) {
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement847",847);
                                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).INOTY;
                                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                                        TRACE_END_STM$("CompoundStatement847",847);
                                    }
                                }
                                // JavaLine 82 ==> SourceLine 848
                                ((PARSER$grammer)(CUR$.SL$)).readtype=((PARSER)(CUR$.SL$.SL$)).NUL;
                                // JavaLine 84 ==> SourceLine 849
                                ((PARSER$grammer)(CUR$.SL$)).detach();
                                // JavaLine 86 ==> SourceLine 850
                                if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IIDN))) {
                                    new PARSER$grammer$declaration$declError(((PARSER$grammer$declaration)CUR$),185);
                                }
                                // JavaLine 90 ==> SourceLine 851
                                if((caller.stmtreq==(((PARSER$grammer)(CUR$.SL$)).outermost))) {
                                    new PARSER$grammer$declaration$REGSEPCOMP(((PARSER$grammer$declaration)CUR$));
                                }
                                // JavaLine 94 ==> SourceLine 857
                                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IDCLP;
                                call(((PARSER)(CUR$.SL$.SL$)).coder);
                                // JavaLine 97 ==> SourceLine 858
                                ((PARSER$grammer)(CUR$.SL$)).getopt=false;
                                ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).opt;
                                // JavaLine 100 ==> SourceLine 859
                                if((((PARSER)(CUR$.SL$.SL$)).option.Elt[rank('I')-((PARSER)(CUR$.SL$.SL$)).option.LB[0]]!=(((PARSER)(CUR$.SL$.SL$)).NUL))) {
                                    new PARSER$grammer$lookforstring(((PARSER$grammer)(CUR$.SL$)));
                                }
                                // JavaLine 104 ==> SourceLine 860
                                new PARSER$grammer$readprocpar(((PARSER$grammer)(CUR$.SL$)),((PARSER)(CUR$.SL$.SL$)).IPSPC);
                                // JavaLine 106 ==> SourceLine 861
                                rp=((char)1);
                                stmtreq=((PARSER$grammer)(CUR$.SL$)).procbody;
                                // JavaLine 109 ==> SourceLine 862
                                errorno=2;
                                // JavaLine 111 ==> SourceLine 864
                                LABEL$(4); // PARSE
                                detach();
                                // JavaLine 114 ==> SourceLine 866
                                switch(rp) { // BEGIN SWITCH STATEMENT
                                case 0: 
                                // JavaLine 117 ==> SourceLine 867
                                GOTO$(S0); // GOTO EVALUATED LABEL
                                case 2: 
                                // JavaLine 120 ==> SourceLine 868
                                GOTO$(S2); // GOTO EVALUATED LABEL
                                case 3: 
                                // JavaLine 123 ==> SourceLine 869
                                GOTO$(S3); // GOTO EVALUATED LABEL
                            } // END SWITCH STATEMENT
                            // JavaLine 126 ==> SourceLine 870
                            LABEL$(5); // S1
                            ((PARSER$grammer)(CUR$.SL$)).blockfound=(((PARSER$grammer)(CUR$.SL$)).blockfound-(1));
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IEND;
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            TRACE_END_STM$("CompoundStatement845",870);
                        }
                    } else
                    // JavaLine 134 ==> SourceLine 872
                    if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IIDN))) {
                        // JavaLine 136 ==> SourceLine 873
                        {
                            TRACE_BEGIN_STM$("CompoundStatement873",873);
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).ICPRF;
                            GOTO$((((((PARSER)(CUR$.SL$.SL$)).opt==(((PARSER)(CUR$.SL$.SL$)).ICLAS)))?(C1):(R1))); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement873",873);
                        }
                    } else
                    // JavaLine 144 ==> SourceLine 874
                    if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ICLAS))) {
                        // JavaLine 146 ==> SourceLine 875
                        {
                            TRACE_BEGIN_STM$("CompoundStatement875",875);
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).INOTY;
                            // JavaLine 150 ==> SourceLine 876
                            LABEL$(6); // C1
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            // JavaLine 153 ==> SourceLine 877
                            ((PARSER$grammer)(CUR$.SL$)).detach();
                            // JavaLine 155 ==> SourceLine 879
                            if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IIDN))) {
                                new PARSER$grammer$declaration$declError(((PARSER$grammer$declaration)CUR$),185);
                            }
                            // JavaLine 159 ==> SourceLine 880
                            if((caller.stmtreq==(((PARSER$grammer)(CUR$.SL$)).outermost))) {
                                new PARSER$grammer$declaration$REGSEPCOMP(((PARSER$grammer$declaration)CUR$));
                            }
                            // JavaLine 163 ==> SourceLine 881
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IDCLC;
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            // JavaLine 166 ==> SourceLine 882
                            ((PARSER$grammer)(CUR$.SL$)).getopt=false;
                            ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).opt;
                            // JavaLine 169 ==> SourceLine 883
                            if((((PARSER)(CUR$.SL$.SL$)).option.Elt[rank('I')-((PARSER)(CUR$.SL$.SL$)).option.LB[0]]!=(((PARSER)(CUR$.SL$.SL$)).NUL))) {
                                new PARSER$grammer$lookforstring(((PARSER$grammer)(CUR$.SL$)));
                            }
                            // JavaLine 173 ==> SourceLine 884
                            new PARSER$grammer$readclasspar(((PARSER$grammer)(CUR$.SL$)));
                            // JavaLine 175 ==> SourceLine 885
                            rp=((char)2);
                            stmtreq=((PARSER$grammer)(CUR$.SL$)).classbody;
                            // JavaLine 178 ==> SourceLine 886
                            stmttype=((PARSER$grammer)(CUR$.SL$)).dummystmt;
                            // JavaLine 180 ==> SourceLine 887
                            errorno=2;
                            // JavaLine 182 ==> SourceLine 888
                            GOTO$(PARSE); // GOTO EVALUATED LABEL
                            // JavaLine 184 ==> SourceLine 900
                            LABEL$(7); // S2
                            // JavaLine 186 ==> SourceLine 889
                            if(innerseen) {
                                // JavaLine 188 ==> SourceLine 890
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement890",890);
                                    ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IEND;
                                    ((PARSER)(CUR$.SL$.SL$)).opdlo=((PARSER)(CUR$.SL$.SL$)).NUL;
                                    TRACE_END_STM$("CompoundStatement890",890);
                                }
                            } else
                            // JavaLine 196 ==> SourceLine 893
                            {
                                TRACE_BEGIN_STM$("CompoundStatement893",893);
                                if((blockstatus==(((PARSER$grammer)(CUR$.SL$)).stmtnotseen))) {
                                    // JavaLine 200 ==> SourceLine 894
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement894",894);
                                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IDCLE;
                                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                                        TRACE_END_STM$("CompoundStatement894",894);
                                    }
                                }
                                // JavaLine 208 ==> SourceLine 895
                                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IECWI;
                                // JavaLine 210 ==> SourceLine 896
                                ((PARSER)(CUR$.SL$.SL$)).opdlo=((((stmttype>=(((PARSER$grammer)(CUR$.SL$)).declunit))||(priorseen)))?(((PARSER)(CUR$.SL$.SL$)).NUL):(((char)1)));
                                TRACE_END_STM$("CompoundStatement893",896);
                            }
                            // JavaLine 214 ==> SourceLine 901
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            TRACE_END_STM$("CompoundStatement875",901);
                        }
                    } else
                    // JavaLine 219 ==> SourceLine 903
                    if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IRCRD))) {
                        // JavaLine 221 ==> SourceLine 904
                        {
                            TRACE_BEGIN_STM$("CompoundStatement904",904);
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).INOTY;
                            // JavaLine 225 ==> SourceLine 905
                            LABEL$(8); // R1
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            // JavaLine 228 ==> SourceLine 906
                            ((PARSER$grammer)(CUR$.SL$)).detach();
                            // JavaLine 230 ==> SourceLine 908
                            if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IIDN))) {
                                new PARSER$grammer$declaration$declError(((PARSER$grammer$declaration)CUR$),185);
                            }
                            // JavaLine 234 ==> SourceLine 909
                            if((caller.stmtreq==(((PARSER$grammer)(CUR$.SL$)).outermost))) {
                                new PARSER$grammer$declaration$REGSEPCOMP(((PARSER$grammer$declaration)CUR$));
                            }
                            // JavaLine 238 ==> SourceLine 910
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IREAC;
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            // JavaLine 241 ==> SourceLine 911
                            if((((PARSER)(CUR$.SL$.SL$)).option.Elt[rank('I')-((PARSER)(CUR$.SL$.SL$)).option.LB[0]]!=(((PARSER)(CUR$.SL$.SL$)).NUL))) {
                                new PARSER$grammer$lookforstring(((PARSER$grammer)(CUR$.SL$)));
                            }
                            // JavaLine 245 ==> SourceLine 913
                            if((((PARSER)(CUR$.SL$.SL$)).opt!=(((PARSER)(CUR$.SL$.SL$)).ISMCL))) {
                                new PARSER$grammer$declaration$declError(((PARSER$grammer$declaration)CUR$),286);
                            }
                            // JavaLine 249 ==> SourceLine 914
                            ((PARSER$grammer)(CUR$.SL$)).detach();
                            // JavaLine 251 ==> SourceLine 915
                            rp=((char)3);
                            stmtreq=((PARSER$grammer)(CUR$.SL$)).classbody;
                            // JavaLine 254 ==> SourceLine 916
                            stmttype=((PARSER$grammer)(CUR$.SL$)).dummystmt;
                            // JavaLine 256 ==> SourceLine 917
                            errorno=2;
                            // JavaLine 258 ==> SourceLine 918
                            GOTO$(PARSE); // GOTO EVALUATED LABEL
                            // JavaLine 260 ==> SourceLine 920
                            LABEL$(9); // S3
                            // JavaLine 262 ==> SourceLine 919
                            if((blockstatus==(((PARSER$grammer)(CUR$.SL$)).stmtnotseen))) {
                                // JavaLine 264 ==> SourceLine 920
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement920",920);
                                    ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IDCLE;
                                    call(((PARSER)(CUR$.SL$.SL$)).coder);
                                    TRACE_END_STM$("CompoundStatement920",920);
                                }
                            }
                            // JavaLine 272 ==> SourceLine 921
                            if((priorseen||((stmttype>=(((PARSER$grammer)(CUR$.SL$)).declunit))))) {
                            } else
                            // JavaLine 275 ==> SourceLine 922
                            new PARSER$grammer$declaration$declError(((PARSER$grammer$declaration)CUR$),240);
                            // JavaLine 277 ==> SourceLine 923
                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IAFTR;
                            // JavaLine 279 ==> SourceLine 924
                            call(((PARSER)(CUR$.SL$.SL$)).coder);
                            TRACE_END_STM$("CompoundStatement904",924);
                        }
                    } else
                    // JavaLine 284 ==> SourceLine 926
                    if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IEXTR))) {
                        // JavaLine 286 ==> SourceLine 927
                        {
                            TRACE_BEGIN_STM$("CompoundStatement927",927);
                            ((PARSER$grammer)(CUR$.SL$)).detach();
                            // JavaLine 290 ==> SourceLine 928
                            if(((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ICLAS))||((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IRCRD))))) {
                                // JavaLine 292 ==> SourceLine 929
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement929",929);
                                    ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).INOTY;
                                    call(((PARSER)(CUR$.SL$.SL$)).coder);
                                    ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER$grammer)(CUR$.SL$)).cs;
                                    call(((PARSER)(CUR$.SL$.SL$)).coder);
                                    TRACE_END_STM$("CompoundStatement929",929);
                                }
                            } else
                            // JavaLine 302 ==> SourceLine 931
                            {
                                TRACE_BEGIN_STM$("CompoundStatement931",931);
                                priorseen=true;
                                // JavaLine 306 ==> SourceLine 932
                                if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IIDN))) {
                                    // JavaLine 308 ==> SourceLine 933
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement933",933);
                                        if((caller.stmtreq==(((PARSER$grammer)(CUR$.SL$)).outermost))) {
                                            new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$)),222);
                                        }
                                        // JavaLine 314 ==> SourceLine 935
                                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).ILANG;
                                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                                        // JavaLine 317 ==> SourceLine 936
                                        ((PARSER$grammer)(CUR$.SL$)).getopt=false;
                                        ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).opt;
                                        TRACE_END_STM$("CompoundStatement933",936);
                                    }
                                }
                                // JavaLine 323 ==> SourceLine 938
                                new PARSER$grammer$readtypespec(((PARSER$grammer)(CUR$.SL$)));
                                // JavaLine 325 ==> SourceLine 939
                                if((((PARSER$grammer)(CUR$.SL$)).readtype==(((PARSER)(CUR$.SL$.SL$)).NUL))) {
                                    // JavaLine 327 ==> SourceLine 940
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement940",940);
                                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).INOTY;
                                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                                        TRACE_END_STM$("CompoundStatement940",940);
                                    }
                                }
                                // JavaLine 335 ==> SourceLine 941
                                if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IPROC))) {
                                    new PARSER$grammer$declaration$declError(((PARSER$grammer$declaration)CUR$),192);
                                }
                                // JavaLine 339 ==> SourceLine 942
                                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IPROC;
                                call(((PARSER)(CUR$.SL$.SL$)).coder);
                                TRACE_END_STM$("CompoundStatement931",942);
                            }
                            // JavaLine 344 ==> SourceLine 944
                            new PARSER$grammer$declaration$externalItem(((PARSER$grammer$declaration)CUR$));
                            // JavaLine 346 ==> SourceLine 945
                            if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IIS))) {
                                // JavaLine 348 ==> SourceLine 946
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement946",946);
                                    if((!(priorseen))) {
                                        new PARSER$grammer$declaration$declError(((PARSER$grammer$declaration)CUR$),219);
                                    }
                                    // JavaLine 354 ==> SourceLine 947
                                    if((!(new PARSER$grammer$extbinding(((PARSER$grammer)(CUR$.SL$))).RESULT$))) {
                                        // JavaLine 356 ==> SourceLine 948
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
                            // JavaLine 368 ==> SourceLine 950
                            while((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ICOMA))) {
                                new PARSER$grammer$declaration$externalItem(((PARSER$grammer$declaration)CUR$));
                            }
                            TRACE_END_STM$("CompoundStatement927",950);
                        }
                    } else
                    // JavaLine 375 ==> SourceLine 952
                    new ERRMSG$internerr(((PARSER)(CUR$.SL$.SL$)),((char)4),952);
                    // JavaLine 377 ==> SourceLine 954
                    if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ISMCL))) {
                        // JavaLine 379 ==> SourceLine 956
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                    } else
                    if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IEOP))) {
                        new PARSER$grammer$declaration$declError(((PARSER$grammer$declaration)CUR$),286);
                    }
                    // JavaLine 385 ==> SourceLine 960
                    caller.next=null;
                    ((PARSER$grammer)(CUR$.SL$)).last=caller;
                    // JavaLine 388 ==> SourceLine 961
                    ((PARSER$grammer)(CUR$.SL$)).deList=((PARSER$grammer$statement)CUR$);
                    // JavaLine 390 ==> SourceLine 963
                    detach();
                    // JavaLine 392 ==> SourceLine 966
                    ((PARSER$grammer)(CUR$.SL$)).deList=null;
                    // JavaLine 394 ==> SourceLine 967
                    errorno=0;
                    // JavaLine 396 ==> SourceLine 968
                    priorseen=innerseen=recovered=isblocklike=false;
                    // JavaLine 398 ==> SourceLine 970
                    rp=blockstatus=stmtreq=stmttype=((PARSER)(CUR$.SL$.SL$)).NUL;
                    // JavaLine 400 ==> SourceLine 971
                    GOTO$(REUSE); // GOTO EVALUATED LABEL
                    // JavaLine 402 ==> SourceLine 832
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
public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Class declaration",1,768,12,827,14,835,16,843,18,864,20,870,22,876,24,889,26,905,28,919,31,771,49,832,51,838,53,835,55,838,63,839,65,952,67,843,69,845,73,847,82,848,84,849,86,850,90,851,94,857,97,858,100,859,104,860,106,861,109,862,111,864,114,866,117,867,120,868,123,869,126,870,134,872,136,873,144,874,146,875,150,876,153,877,155,879,159,880,163,881,166,882,169,883,173,884,175,885,178,886,180,887,182,888,184,900,186,889,188,890,196,893,200,894,208,895,210,896,214,901,219,903,221,904,225,905,228,906,230,908,234,909,238,910,241,911,245,913,249,914,251,915,254,916,256,917,258,918,260,920,262,919,264,920,272,921,275,922,277,923,279,924,284,926,286,927,290,928,292,929,302,931,306,932,308,933,314,935,317,936,323,938,325,939,327,940,335,941,339,942,344,944,346,945,348,946,354,947,356,948,368,950,375,952,377,954,379,956,385,960,388,961,390,963,392,966,394,967,396,968,398,970,400,971,402,832,426,973);
}
