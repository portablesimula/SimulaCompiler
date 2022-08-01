// JavaLine 1 <== SourceLine 23
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:53 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23 extends BASICIO$ {
    // SubBlock: Kind=SubBlock, BlockLevel=2, firstLine=23, lastLine=2125, hasLocalClasses=true, System=true
    public boolean isQPSystemBlock() { return(true); }
    // Declare local labels
    // JavaLine 10 <== SourceLine 2022
    final LABQNT$ QNTSV=new LABQNT$(this,1,"QNTSV"); // Local Label #1=QNTSV
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 23
    int typ=0;
    // JavaLine 15 <== SourceLine 24
    int freeindex=0;
    // JavaLine 17 <== SourceLine 25
    int byte$=0;
    // JavaLine 19 <== SourceLine 26
    int curdest=0;
    int ndest=0;
    // JavaLine 22 <== SourceLine 27
    int delhi=0;
    int dello=0;
    // JavaLine 25 <== SourceLine 28
    final int K_TT=(int)(6);
    final int K_FF=(int)(4);
    final int K_EQ=(int)(7);
    final int K_NE=(int)(3);
    final int K_GT=(int)(8);
    final int K_LE=(int)(2);
    final int K_LT=(int)(9);
    final int K_GE=(int)(1);
    // JavaLine 34 <== SourceLine 29
    int n=0;
    // JavaLine 36 <== SourceLine 30
    int tracemode=0;
    // JavaLine 38 <== SourceLine 31
    Common$descr d=null;
    Common$const$ e=null;
    Common$quant_notice qn=null;
    // JavaLine 42 <== SourceLine 32
    TXT$ eltid=null;
    TXT$ attrfile=null;
    // JavaLine 45 <== SourceLine 34
    public ARRAY$<int[]>condinstr=null;
    // JavaLine 47 <== SourceLine 35
    public ARRAY$<int[]>indexUsed=null;
    // JavaLine 49 <== SourceLine 36
    public ARRAY$<int[]>sw=null;
    // JavaLine 51 <== SourceLine 37
    public ARRAY$<Pass2$CompoundStatement21$SubBlock23$program_point[]>dest_tab=null;
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        // Declaration Code
        // JavaLine 58 <== SourceLine 34
        int[] condinstr$LB=new int[1]; int[] condinstr$UB=new int[1];
        condinstr$LB[0]=0; condinstr$UB[0]=9;
        BOUND_CHECK$(condinstr$LB[0],condinstr$UB[0]);
        condinstr=new ARRAY$<int[]>(new int[condinstr$UB[0]-condinstr$LB[0]+1],condinstr$LB,condinstr$UB);
        // JavaLine 63 <== SourceLine 35
        int[] indexUsed$LB=new int[1]; int[] indexUsed$UB=new int[1];
        indexUsed$LB[0]=0; indexUsed$UB[0]=255;
        BOUND_CHECK$(indexUsed$LB[0],indexUsed$UB[0]);
        indexUsed=new ARRAY$<int[]>(new int[indexUsed$UB[0]-indexUsed$LB[0]+1],indexUsed$LB,indexUsed$UB);
        // JavaLine 68 <== SourceLine 36
        int[] sw$LB=new int[1]; int[] sw$UB=new int[1];
        sw$LB[0]=0; sw$UB[0]=10;
        BOUND_CHECK$(sw$LB[0],sw$UB[0]);
        sw=new ARRAY$<int[]>(new int[sw$UB[0]-sw$LB[0]+1],sw$LB,sw$UB);
        // JavaLine 73 <== SourceLine 37
        int[] dest_tab$LB=new int[1]; int[] dest_tab$UB=new int[1];
        dest_tab$LB[0]=0; dest_tab$UB[0]=255;
        BOUND_CHECK$(dest_tab$LB[0],dest_tab$UB[0]);
        dest_tab=new ARRAY$<Pass2$CompoundStatement21$SubBlock23$program_point[]>(new Pass2$CompoundStatement21$SubBlock23$program_point[dest_tab$UB[0]-dest_tab$LB[0]+1],dest_tab$LB,dest_tab$UB);
    }
    // SubBlock Statements
    public RTObject$ STM$() {
        Pass2$CompoundStatement21$SubBlock23 THIS$=(Pass2$CompoundStatement21$SubBlock23)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 85 <== SourceLine 1926
                ((Pass2)(CUR$.SL$)).inspect$20$141.curline$1=255;
                ;
                // JavaLine 88 <== SourceLine 1927
                while((((Pass2)(CUR$.SL$)).inspect$20$141.curline$1!=(0))) {
                    // JavaLine 90 <== SourceLine 1928
                    {
                        dest_tab.Elt[((Pass2)(CUR$.SL$)).inspect$20$141.curline$1-dest_tab.LB[0]]=new Pass2$CompoundStatement21$SubBlock23$program_point(((Pass2$CompoundStatement21$SubBlock23)(CUR$))).STM$();
                        ;
                        // JavaLine 94 <== SourceLine 1929
                        ((Pass2)(CUR$.SL$)).inspect$20$141.curline$1=Math.subtractExact(((Pass2)(CUR$.SL$)).inspect$20$141.curline$1,1);
                        ;
                    }
                }
                ;
                // JavaLine 100 <== SourceLine 1933
                freeindex=255;
                ;
                // JavaLine 103 <== SourceLine 1934
                while((freeindex!=(1))) {
                    // JavaLine 105 <== SourceLine 1935
                    {
                        indexUsed.Elt[Math.subtractExact(freeindex,1)-indexUsed.LB[0]]=freeindex;
                        ;
                        // JavaLine 109 <== SourceLine 1936
                        freeindex=Math.subtractExact(freeindex,1);
                        ;
                    }
                }
                ;
                // JavaLine 115 <== SourceLine 1939
                ((Pass2)(CUR$.SL$)).inspect$20$142.input_trace$3=0;
                ;
                ((Pass2)(CUR$.SL$)).inspect$21$143.output_trace$3=0;
                ;
                // JavaLine 120 <== SourceLine 1940
                ((Pass2)(CUR$.SL$)).inspect$20$141.module_trace$1=0;
                ;
                tracemode=0;
                ;
                // JavaLine 125 <== SourceLine 1942
                while((!(((Pass2)(CUR$.SL$)).inspect$20$141.TRC_init$1.empty()))) {
                    // JavaLine 127 <== SourceLine 1943
                    {
                        {
                            // BEGIN INSPECTION 
                            ((Pass2)(CUR$.SL$)).inspect$1943$225=((Pass2)(CUR$.SL$)).inspect$20$141.TRC_init$1.first();
                            //INSPECT inspect$1943$225
                            if(((Pass2)(CUR$.SL$)).inspect$1943$225 instanceof Common$trace_item) // WHEN Common$trace_item DO 
                            // JavaLine 134 <== SourceLine 1944
                            {
                                if(VALUE$((tracemode>(3)))) {
                                    {
                                        // BEGIN INSPECTION 
                                        ((Pass2)(CUR$.SL$)).inspect$1944$226=sysout();
                                        if(((Pass2)(CUR$.SL$)).inspect$1944$226!=null) // INSPECT inspect$1944$226
                                        // JavaLine 141 <== SourceLine 1945
                                        {
                                            ((Pass2)(CUR$.SL$)).inspect$1944$226.outtext(new TXT$("TRACE"));
                                            ;
                                            ((Pass2)(CUR$.SL$)).inspect$1944$226.outint(((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$s,4);
                                            ;
                                            // JavaLine 147 <== SourceLine 1946
                                            ((Pass2)(CUR$.SL$)).inspect$1944$226.outint(((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$v,4);
                                            ;
                                            ((Pass2)(CUR$.SL$)).inspect$1944$226.outimage();
                                            ;
                                        }
                                    }
                                }
                                ;
                                // JavaLine 156 <== SourceLine 1948
                                if(VALUE$((((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$s==(1)))) {
                                    ((Pass2)(CUR$.SL$)).inspect$20$142.input_trace$3=((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$v;
                                } else
                                // JavaLine 160 <== SourceLine 1949
                                if(VALUE$((((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$s==(2)))) {
                                    ((Pass2)(CUR$.SL$)).inspect$21$143.output_trace$3=((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$v;
                                } else
                                // JavaLine 164 <== SourceLine 1950
                                if(VALUE$((((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$s==(3)))) {
                                    ((Pass2)(CUR$.SL$)).inspect$20$141.module_trace$1=((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$v;
                                } else
                                // JavaLine 168 <== SourceLine 1951
                                if(VALUE$((((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$s==(4)))) {
                                    tracemode=((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$v;
                                } else
                                // JavaLine 172 <== SourceLine 1953
                                {
                                    ((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$s=(((((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$s==(11)))?(1):((((((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$s==(12)))?(4):((((((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$s==(13)))?(3):((((((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$s==(14)))?(2):((((((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$s==(21)))?(5):((((((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$s==(22)))?(5):((((((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$s==(23)))?(9):((((((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$s==(24)))?(5):(9))))))))))))))));
                                    ;
                                    // JavaLine 176 <== SourceLine 1957
                                    sw.Elt[((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$s-sw.LB[0]]=((Common$trace_item)(((Pass2)(CUR$.SL$)).inspect$1943$225)).p2$v;
                                    ;
                                }
                                ;
                            }
                            else // OTHERWISE 
                            // JavaLine 183 <== SourceLine 1959
                            new Common$IERR(((Pass2)(CUR$.SL$)).inspect$20$141);
                        }
                        ;
                        // JavaLine 187 <== SourceLine 1960
                        ((Pass2)(CUR$.SL$)).inspect$20$141.TRC_init$1.first().out();
                        ;
                    }
                }
                ;
                // JavaLine 193 <== SourceLine 1963
                if(VALUE$((((Pass2)(CUR$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                    {
                        sysout().outimage();
                        ;
                        sysout().eject(1);
                        ;
                        sysout().outimage();
                    }
                }
                ;
                // JavaLine 204 <== SourceLine 1964
                new Common$update_display(((Pass2)(CUR$.SL$)).inspect$20$141,((Pass2)(CUR$.SL$)).inspect$20$141.qntset$1);
                ;
                // JavaLine 207 <== SourceLine 1966
                new OuptFile$outinst(((Pass2)(CUR$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$)).inspect$20$141.S_PROGRAM$1);
                ;
                // JavaLine 210 <== SourceLine 1968
                ((Pass2)(CUR$.SL$)).inspect$20$141.tempt$1=datetime();
                ;
                // JavaLine 213 <== SourceLine 1969
                new OuptFile$outstring(((Pass2)(CUR$.SL$)).inspect$21$143,CONC(((Pass2)(CUR$.SL$)).inspect$20$141.tempt$1,new TXT$("'Simuletta'Java")));
                ;
                // JavaLine 216 <== SourceLine 1970
                if(VALUE$((((Pass2)(CUR$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                    new OuptFile$outcode(((Pass2)(CUR$.SL$)).inspect$21$143);
                }
                ;
                // JavaLine 221 <== SourceLine 1972
                condinstr.Elt[K_TT-condinstr.LB[0]]=((Pass2)(CUR$.SL$)).inspect$20$141.S_EQ$1;
                ;
                condinstr.Elt[K_FF-condinstr.LB[0]]=((Pass2)(CUR$.SL$)).inspect$20$141.S_NE$1;
                ;
                // JavaLine 226 <== SourceLine 1973
                condinstr.Elt[K_EQ-condinstr.LB[0]]=((Pass2)(CUR$.SL$)).inspect$20$141.S_EQ$1;
                ;
                condinstr.Elt[K_NE-condinstr.LB[0]]=((Pass2)(CUR$.SL$)).inspect$20$141.S_NE$1;
                ;
                // JavaLine 231 <== SourceLine 1974
                condinstr.Elt[K_GT-condinstr.LB[0]]=((Pass2)(CUR$.SL$)).inspect$20$141.S_GT$1;
                ;
                condinstr.Elt[K_LE-condinstr.LB[0]]=((Pass2)(CUR$.SL$)).inspect$20$141.S_LE$1;
                ;
                // JavaLine 236 <== SourceLine 1975
                condinstr.Elt[K_LT-condinstr.LB[0]]=((Pass2)(CUR$.SL$)).inspect$20$141.S_LT$1;
                ;
                condinstr.Elt[K_GE-condinstr.LB[0]]=((Pass2)(CUR$.SL$)).inspect$20$141.S_GE$1;
                ;
                // JavaLine 241 <== SourceLine 1978
                byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$)).inspect$20$142).RESULT$;
                ;
                if(VALUE$((byte$!=(((Pass2)(CUR$.SL$)).inspect$20$141.S_BEGIN$1)))) {
                    new Common$IERR(((Pass2)(CUR$.SL$)).inspect$20$141);
                }
                ;
                // JavaLine 248 <== SourceLine 1979
                if(VALUE$(TRF_EQ(((Pass2)(CUR$.SL$)).inspect$20$141.module_ident$1,null))) {
                    // JavaLine 250 <== SourceLine 1980
                    {
                        new OuptFile$outinst(((Pass2)(CUR$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$)).inspect$20$141.S_MAIN$1);
                        ;
                        eltid=copy(copy(new TXT$("MAIN")));
                    }
                } else
                // JavaLine 257 <== SourceLine 1982
                {
                    if(VALUE$(((Pass2)(CUR$.SL$)).inspect$20$141.global_module$1)) {
                        new OuptFile$outinst(((Pass2)(CUR$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$)).inspect$20$141.S_GLOBAL$1);
                    }
                    ;
                    // JavaLine 263 <== SourceLine 1983
                    eltid=((Pass2)(CUR$.SL$)).inspect$20$141.module_ident$1;
                    ;
                    // JavaLine 266 <== SourceLine 1984
                    if(VALUE$((TXT$.length(eltid)>(10)))) {
                        eltid=TXT$.sub(eltid,1,10);
                    }
                    ;
                    // JavaLine 271 <== SourceLine 1985
                    new OuptFile$outinst(((Pass2)(CUR$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$)).inspect$20$141.S_MODULE$1);
                    ;
                    // JavaLine 274 <== SourceLine 1986
                    new OuptFile$outstring(((Pass2)(CUR$.SL$)).inspect$21$143,eltid);
                    ;
                    new OuptFile$outstring(((Pass2)(CUR$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$)).inspect$20$141.module_code$1);
                    ;
                }
                ;
                // JavaLine 281 <== SourceLine 1988
                if(VALUE$((((Pass2)(CUR$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                    new OuptFile$outcode(((Pass2)(CUR$.SL$)).inspect$21$143);
                }
                ;
                for(n=1;n<=10;n++) {
                    // JavaLine 287 <== SourceLine 1989
                    if(VALUE$((sw.Elt[n-sw.LB[0]]>(0)))) {
                        // JavaLine 289 <== SourceLine 1990
                        {
                            new OuptFile$outinst(((Pass2)(CUR$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$)).inspect$20$141.S_SETSWITCH$1);
                            ;
                            new OuptFile$outbyt(((Pass2)(CUR$.SL$)).inspect$21$143,n);
                            ;
                            // JavaLine 295 <== SourceLine 1991
                            new OuptFile$outbyt(((Pass2)(CUR$.SL$)).inspect$21$143,sw.Elt[n-sw.LB[0]]);
                            ;
                            // JavaLine 298 <== SourceLine 1992
                            if(VALUE$((((Pass2)(CUR$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                new OuptFile$outcode(((Pass2)(CUR$.SL$)).inspect$21$143);
                            }
                            ;
                        }
                    }
                }
                ;
                // JavaLine 307 <== SourceLine 1994
                if(VALUE$((!(((Pass2)(CUR$.SL$)).inspect$20$141.modset$1.empty())))) {
                    // JavaLine 309 <== SourceLine 2005
                    new Pass2$CompoundStatement21$SubBlock23$SubBlock1995((CUR$)).STM$();
                }
                ;
                // JavaLine 313 <== SourceLine 2007
                ((Pass2)(CUR$.SL$)).inspect$20$141.localdecl$1=new Head$(((Pass2)(CUR$.SL$)).inspect$20$141).STM$();
                ;
                ((Pass2)(CUR$.SL$)).inspect$20$141.vislist$1=new Head$(((Pass2)(CUR$.SL$)).inspect$20$141).STM$();
                ;
                ((Pass2)(CUR$.SL$)).inspect$20$141.constlist$1=new Head$(((Pass2)(CUR$.SL$)).inspect$20$141).STM$();
                ;
                // JavaLine 320 <== SourceLine 2008
                d=((Common$descr)(((Pass2)(CUR$.SL$)).inspect$20$141.qntset$1.first()));
                ;
                // JavaLine 323 <== SourceLine 2009
                new Common$TRACE(((Pass2)(CUR$.SL$)).inspect$20$141,new TXT$("Pass2"),2009,CONC(new TXT$("qntset: "),(((((Pass2)(CUR$.SL$)).inspect$20$141.qntset$1==(null)))?(new TXT$("qntset == NONE")):(new TXT$("qntset =/= NONE")))));
                ;
                // JavaLine 326 <== SourceLine 2010
                while(true) {
                    {
                        // BEGIN INSPECTION 
                        ((Pass2)(CUR$.SL$)).inspect$2010$228=d;
                        if(((Pass2)(CUR$.SL$)).inspect$2010$228!=null) // INSPECT inspect$2010$228
                        {
                            d=((Common$descr)(((Pass2)(CUR$.SL$)).inspect$2010$228.suc()));
                            ;
                            // JavaLine 335 <== SourceLine 2011
                            if(VALUE$((((Pass2)(CUR$.SL$)).inspect$2010$228.visible$2||(((Pass2)(CUR$.SL$)).inspect$20$141.global_module$1)))) {
                                // JavaLine 337 <== SourceLine 2012
                                {
                                    new Pass2$CompoundStatement21$SubBlock23$out_descr(((Pass2$CompoundStatement21$SubBlock23)(CUR$)),((Common$descr)((Pass2)(CUR$.SL$)).inspect$2010$228));
                                    ;
                                    // JavaLine 341 <== SourceLine 2013
                                    ((Pass2)(CUR$.SL$)).inspect$2010$228.into(((Pass2)(CUR$.SL$)).inspect$20$141.vislist$1);
                                }
                            } else
                            if(VALUE$(IS$(((Common$descr)((Pass2)(CUR$.SL$)).inspect$2010$228),Common$record.class))) {
                                // JavaLine 346 <== SourceLine 2014
                                {
                                    new Pass2$CompoundStatement21$SubBlock23$out_descr(((Pass2$CompoundStatement21$SubBlock23)(CUR$)),((Common$descr)((Pass2)(CUR$.SL$)).inspect$2010$228));
                                    ;
                                    // JavaLine 350 <== SourceLine 2015
                                    ((Pass2)(CUR$.SL$)).inspect$2010$228.out();
                                }
                            } else
                            if(VALUE$(((IS$(((Common$descr)((Pass2)(CUR$.SL$)).inspect$2010$228),Common$quant.class)&&(TRF_NE(((Pass2)(CUR$.SL$)).inspect$20$141.module_ident$1,null)))&&(((((Common$quant)(((Common$descr)((Pass2)(CUR$.SL$)).inspect$2010$228))).initval$3==(null))||((!(((Common$quant)(((Common$descr)((Pass2)(CUR$.SL$)).inspect$2010$228))).read_only$3)))))))) {
                                // JavaLine 355 <== SourceLine 2019
                                new Common$quant_notice(((Pass2)(CUR$.SL$)).inspect$20$141,((Common$quant)(((Common$descr)((Pass2)(CUR$.SL$)).inspect$2010$228)))).STM$().into(((Pass2)(CUR$.SL$)).inspect$20$141.localdecl$1);
                            }
                            ;
                        }
                        else // OTHERWISE 
                        // JavaLine 361 <== SourceLine 2020
                        GOTO$(QNTSV); // GOTO EVALUATED LABEL
                    }
                    if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                }
                ;
                // JavaLine 367 <== SourceLine 2044
                LABEL$(1,"QNTSV");
                // JavaLine 369 <== SourceLine 2022
                if(VALUE$(TRF_NE(((Pass2)(CUR$.SL$)).inspect$20$141.module_ident$1,null))) {
                    // JavaLine 371 <== SourceLine 2023
                    {
                        giveTextInfo(2,eltid);
                        ;
                        // JavaLine 375 <== SourceLine 2024
                        attrfile=getTextInfo(12);
                        ;
                        // JavaLine 378 <== SourceLine 2025
                        new UtModule(((BASICIO$)CTX$),((Pass2)(CUR$.SL$)).inspect$21$143.p3$comn,((OuptFile)((Pass2)(CUR$.SL$)).inspect$21$143),attrfile,eltid);
                        ;
                        // JavaLine 381 <== SourceLine 2026
                        new OuptFile$outinst(((Pass2)(CUR$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$)).inspect$20$141.S_BODY$1);
                        ;
                        // JavaLine 384 <== SourceLine 2027
                        if(VALUE$((((Pass2)(CUR$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                            new OuptFile$outcode(((Pass2)(CUR$.SL$)).inspect$21$143);
                        }
                        ;
                        // JavaLine 389 <== SourceLine 2029
                        if(VALUE$((!(((Pass2)(CUR$.SL$)).inspect$20$141.localdecl$1.empty())))) {
                            // JavaLine 391 <== SourceLine 2030
                            {
                                for(boolean CB$2030:new ForList(
                                    new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){qn=(Common$quant_notice)x$; return(x$);};  public Link$ get(){return((Link$)qn); }	},new NAME$<Link$>() { public Link$ get(){return(((Pass2)(CUR$.SL$)).inspect$20$141.localdecl$1.first()); }})
                                   ,new WhileElt<Common$quant_notice>(new NAME$<Common$quant_notice>(){ public Common$quant_notice put(Common$quant_notice x$){qn=x$; return(x$);};  public Common$quant_notice get(){return((Common$quant_notice)qn); }	},new NAME$<Common$quant_notice>() { public Common$quant_notice get(){return(((Common$quant_notice)(qn.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((qn!=(null))); }})
                                   )) { if(!CB$2030) continue;
                                // JavaLine 397 <== SourceLine 2031
                                {
                                    // BEGIN INSPECTION 
                                    ((Pass2)(CUR$.SL$)).inspect$2031$229=qn.p2$q;
                                    if(((Pass2)(CUR$.SL$)).inspect$2031$229!=null) // INSPECT inspect$2031$229
                                    // JavaLine 402 <== SourceLine 2032
                                    {
                                        if(VALUE$((((Pass2)(CUR$.SL$)).inspect$2031$229.initval$3!=(null)))) {
                                            // JavaLine 405 <== SourceLine 2033
                                            new Common$ERROR(((Pass2)(CUR$.SL$)).inspect$20$141,new TXT$("Illegal with initial value"));
                                        }
                                        ;
                                        // JavaLine 409 <== SourceLine 2034
                                        new Common$deftag(((Pass2)(CUR$.SL$)).inspect$20$141,((Common$descr)((Pass2)(CUR$.SL$)).inspect$2031$229));
                                        ;
                                        // JavaLine 412 <== SourceLine 2035
                                        new OuptFile$outinst(((Pass2)(CUR$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$)).inspect$20$141.S_LOCAL$1);
                                        ;
                                        new OuptFile$outtagid(((Pass2)(CUR$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$)).inspect$2031$229.tag$2);
                                        ;
                                        // JavaLine 417 <== SourceLine 2036
                                        new Pass2$CompoundStatement21$SubBlock23$outquant(((Pass2$CompoundStatement21$SubBlock23)(CUR$)),((Common$quant)((Pass2)(CUR$.SL$)).inspect$2031$229));
                                        ;
                                        // JavaLine 420 <== SourceLine 2037
                                        if(VALUE$((((Pass2)(CUR$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                            new OuptFile$outcode(((Pass2)(CUR$.SL$)).inspect$21$143);
                                        }
                                        ;
                                    }
                                }
                            }
                            ;
                            // JavaLine 429 <== SourceLine 2039
                            ((Pass2)(CUR$.SL$)).inspect$20$141.localdecl$1=new Head$(((Pass2)(CUR$.SL$)).inspect$20$141).STM$();
                            ;
                        }
                    }
                    ;
                    // JavaLine 435 <== SourceLine 2041
                    while((!(((Pass2)(CUR$.SL$)).inspect$20$141.vislist$1.empty()))) {
                        // JavaLine 437 <== SourceLine 2042
                        ((Pass2)(CUR$.SL$)).inspect$20$141.vislist$1.first().into(((Pass2)(CUR$.SL$)).inspect$20$141.constlist$1);
                    }
                    ;
                }
            }
            ;
            // JavaLine 444 <== SourceLine 2046
            if(VALUE$((!(((Pass2)(CUR$.SL$)).inspect$20$141.global_module$1)))) {
                // JavaLine 446 <== SourceLine 2047
                {
                    d=((Common$descr)(((Pass2)(CUR$.SL$)).inspect$20$141.qntset$1.first()));
                    ;
                    // JavaLine 450 <== SourceLine 2048
                    while((d!=(null))) {
                        // JavaLine 452 <== SourceLine 2049
                        {
                            {
                                // BEGIN INSPECTION 
                                ((Pass2)(CUR$.SL$)).inspect$2049$230=d;
                                //INSPECT inspect$2049$230
                                if(((Pass2)(CUR$.SL$)).inspect$2049$230 instanceof Common$quant) // WHEN Common$quant DO 
                                {
                                    d=((Common$descr)(((Common$quant)((Pass2)(CUR$.SL$)).inspect$2049$230).suc()));
                                    ;
                                    // JavaLine 462 <== SourceLine 2050
                                    if(VALUE$((((Common$quant)(((Pass2)(CUR$.SL$)).inspect$2049$230)).initval$3!=(null)))) {
                                        // JavaLine 464 <== SourceLine 2051
                                        {
                                            if(VALUE$((((Common$quant)(((Pass2)(CUR$.SL$)).inspect$2049$230)).tag$2==(0)))) {
                                                // JavaLine 467 <== SourceLine 2052
                                                {
                                                    if(VALUE$((tracemode>(3)))) {
                                                        {
                                                            // BEGIN INSPECTION 
                                                            ((Pass2)(CUR$.SL$)).inspect$2052$231=sysout();
                                                            if(((Pass2)(CUR$.SL$)).inspect$2052$231!=null) // INSPECT inspect$2052$231
                                                            // JavaLine 474 <== SourceLine 2053
                                                            {
                                                                ((Pass2)(CUR$.SL$)).inspect$2052$231.outtext(CONC(new TXT$("=> Const-prep "),((Common$quant)(((Pass2)(CUR$.SL$)).inspect$2049$230)).symb$2.symbol));
                                                                ;
                                                                // JavaLine 478 <== SourceLine 2054
                                                                ((Pass2)(CUR$.SL$)).inspect$2052$231.outimage();
                                                            }
                                                        }
                                                    }
                                                    ;
                                                    // JavaLine 484 <== SourceLine 2055
                                                    {
                                                        // BEGIN INSPECTION 
                                                        ((Pass2)(CUR$.SL$)).inspect$2055$232=((Pass2)(CUR$.SL$)).inspect$20$141.typeTable.Elt[((Common$quant)(((Pass2)(CUR$.SL$)).inspect$2049$230)).p3$type-((Pass2)(CUR$.SL$)).inspect$20$141.typeTable.LB[0]];
                                                        if(((Pass2)(CUR$.SL$)).inspect$2055$232!=null) // INSPECT inspect$2055$232
                                                        // JavaLine 489 <== SourceLine 2056
                                                        if(VALUE$((((Pass2)(CUR$.SL$)).inspect$2055$232.p2$set==(((Pass2)(CUR$.SL$)).inspect$20$141.structTypes$1)))) {
                                                            // JavaLine 491 <== SourceLine 2061
                                                            {
                                                                {
                                                                    // BEGIN INSPECTION 
                                                                    ((Pass2)(CUR$.SL$)).inspect$2061$233=((Common$record)(((Pass2)(CUR$.SL$)).inspect$20$141.symtab.Elt[((Pass2)(CUR$.SL$)).inspect$2055$232.p2$qual-((Pass2)(CUR$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning));
                                                                    if(((Pass2)(CUR$.SL$)).inspect$2061$233!=null) // INSPECT inspect$2061$233
                                                                    // JavaLine 497 <== SourceLine 2063
                                                                    {
                                                                        if(VALUE$((((Pass2)(CUR$.SL$)).inspect$2061$233.tag$2==(0)))) {
                                                                            // JavaLine 500 <== SourceLine 2064
                                                                            new Pass2$CompoundStatement21$SubBlock23$out_descr(((Pass2$CompoundStatement21$SubBlock23)(CUR$)),((Common$record)((Pass2)(CUR$.SL$)).inspect$2061$233));
                                                                        }
                                                                        ;
                                                                        // JavaLine 504 <== SourceLine 2065
                                                                        if(VALUE$((((Pass2)(CUR$.SL$)).inspect$2061$233.tag$2==(0)))) {
                                                                            // JavaLine 506 <== SourceLine 2066
                                                                            new Common$ERROR(((Pass2)(CUR$.SL$)).inspect$20$141,new TXT$("Declaration loop"));
                                                                        }
                                                                        ;
                                                                    }
                                                                }
                                                                ;
                                                            }
                                                        }
                                                    }
                                                    ;
                                                    // JavaLine 517 <== SourceLine 2068
                                                    ((Common$quant)(((Pass2)(CUR$.SL$)).inspect$2049$230)).preped$3=true;
                                                    ;
                                                    // JavaLine 520 <== SourceLine 2069
                                                    if(VALUE$((tracemode>(3)))) {
                                                        {
                                                            // BEGIN INSPECTION 
                                                            ((Pass2)(CUR$.SL$)).inspect$2069$234=sysout();
                                                            if(((Pass2)(CUR$.SL$)).inspect$2069$234!=null) // INSPECT inspect$2069$234
                                                            // JavaLine 526 <== SourceLine 2070
                                                            {
                                                                ((Pass2)(CUR$.SL$)).inspect$2069$234.outtext(CONC(new TXT$("<= * "),((Common$quant)(((Pass2)(CUR$.SL$)).inspect$2049$230)).symb$2.symbol));
                                                                ;
                                                                // JavaLine 530 <== SourceLine 2071
                                                                ((Pass2)(CUR$.SL$)).inspect$2069$234.outimage();
                                                            }
                                                        }
                                                    }
                                                    ;
                                                    // JavaLine 536 <== SourceLine 2072
                                                    new Common$deftag(((Pass2)(CUR$.SL$)).inspect$20$141,((Common$descr)((Pass2)(CUR$.SL$)).inspect$2049$230));
                                                    ;
                                                    // JavaLine 539 <== SourceLine 2073
                                                    new OuptFile$outinst(((Pass2)(CUR$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$)).inspect$20$141.S_CONSTSPEC$1);
                                                    ;
                                                    new OuptFile$outtagid(((Pass2)(CUR$.SL$)).inspect$21$143,((Common$quant)(((Pass2)(CUR$.SL$)).inspect$2049$230)).tag$2);
                                                    ;
                                                    // JavaLine 544 <== SourceLine 2074
                                                    new Pass2$CompoundStatement21$SubBlock23$outquant(((Pass2$CompoundStatement21$SubBlock23)(CUR$)),((Common$quant)((Pass2)(CUR$.SL$)).inspect$2049$230));
                                                    ;
                                                    // JavaLine 547 <== SourceLine 2075
                                                    if(VALUE$((((Pass2)(CUR$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                                        new OuptFile$outcode(((Pass2)(CUR$.SL$)).inspect$21$143);
                                                    }
                                                    ;
                                                }
                                            }
                                            ;
                                            // JavaLine 555 <== SourceLine 2077
                                            ((Common$quant)((Pass2)(CUR$.SL$)).inspect$2049$230).into(((Pass2)(CUR$.SL$)).inspect$20$141.constlist$1);
                                            ;
                                        }
                                    } else
                                    // JavaLine 560 <== SourceLine 2078
                                    new Pass2$CompoundStatement21$SubBlock23$out_descr(((Pass2$CompoundStatement21$SubBlock23)(CUR$)),((Common$descr)((Pass2)(CUR$.SL$)).inspect$2049$230));
                                    ;
                                }
                                else // OTHERWISE 
                                // JavaLine 565 <== SourceLine 2079
                                {
                                    new Pass2$CompoundStatement21$SubBlock23$out_descr(((Pass2$CompoundStatement21$SubBlock23)(CUR$)),d);
                                    ;
                                    d=((Common$descr)(d.suc()));
                                }
                            }
                            ;
                        }
                    }
                    ;
                    // JavaLine 576 <== SourceLine 2081
                    d=((Common$descr)(((Pass2)(CUR$.SL$)).inspect$20$141.constlist$1.first()));
                    ;
                    // JavaLine 579 <== SourceLine 2082
                    while((d!=(null))) {
                        {
                            // BEGIN INSPECTION 
                            ((Pass2)(CUR$.SL$)).inspect$2082$235=((Common$quant)(d));
                            if(((Pass2)(CUR$.SL$)).inspect$2082$235!=null) // INSPECT inspect$2082$235
                            {
                                d=((Common$descr)(((Pass2)(CUR$.SL$)).inspect$2082$235.suc()));
                                ;
                                // JavaLine 588 <== SourceLine 2083
                                new OuptFile$outinst(((Pass2)(CUR$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$)).inspect$20$141.S_CONST$1);
                                ;
                                new OuptFile$outtag(((Pass2)(CUR$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$)).inspect$2082$235.tag$2);
                                ;
                                // JavaLine 593 <== SourceLine 2084
                                new Pass2$CompoundStatement21$SubBlock23$outquant(((Pass2$CompoundStatement21$SubBlock23)(CUR$)),((Common$quant)((Pass2)(CUR$.SL$)).inspect$2082$235));
                                ;
                                // JavaLine 596 <== SourceLine 2085
                                if(VALUE$((((Pass2)(CUR$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass2)(CUR$.SL$)).inspect$21$143);
                                }
                                ;
                                // JavaLine 601 <== SourceLine 2086
                                for(boolean CB$2086:new ForList(
                                    new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){e=(Common$const$)x$; return(x$);};  public Link$ get(){return((Link$)e); }	},new NAME$<Link$>() { public Link$ get(){return(((Pass2)(CUR$.SL$)).inspect$2082$235.initval$3.first()); }})
                                   ,new WhileElt<Common$const$>(new NAME$<Common$const$>(){ public Common$const$ put(Common$const$ x$){e=x$; return(x$);};  public Common$const$ get(){return((Common$const$)e); }	},new NAME$<Common$const$>() { public Common$const$ get(){return(((Common$const$)(e.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((e!=(null))); }})
                                   )) { if(!CB$2086) continue;
                                // JavaLine 606 <== SourceLine 2088
                                {
                                    typ=new Pass2$CompoundStatement21$SubBlock23$outconst(((Pass2$CompoundStatement21$SubBlock23)(CUR$)),e).RESULT$;
                                    ;
                                    // JavaLine 610 <== SourceLine 2089
                                    if(VALUE$((typ!=(((Pass2)(CUR$.SL$)).inspect$2082$235.p3$type)))) {
                                        new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$)),typ,((Pass2)(CUR$.SL$)).inspect$2082$235.p3$type);
                                    }
                                    ;
                                }
                            }
                            ;
                        }
                    }
                }
                ;
                // JavaLine 622 <== SourceLine 2092
                byte$=new InptFile$ininstr(((Pass2)(CUR$.SL$)).inspect$20$142).RESULT$;
                ;
                new Pass2$CompoundStatement21$SubBlock23$statement(((Pass2$CompoundStatement21$SubBlock23)(CUR$)),((Pass2)(CUR$.SL$)).inspect$20$141.S_ENDPROGRAM$1);
                ;
            }
        } else
        // JavaLine 629 <== SourceLine 2095
        {
            d=((Common$descr)(((Pass2)(CUR$.SL$)).inspect$20$141.qntset$1.first()));
            ;
            // JavaLine 633 <== SourceLine 2096
            while((d!=(null))) {
                // JavaLine 635 <== SourceLine 2097
                {
                    {
                        // BEGIN INSPECTION 
                        ((Pass2)(CUR$.SL$)).inspect$2097$236=d;
                        //INSPECT inspect$2097$236
                        if(((Pass2)(CUR$.SL$)).inspect$2097$236 instanceof Common$quant) // WHEN Common$quant DO 
                        // JavaLine 642 <== SourceLine 2098
                        {
                            if(VALUE$((((Common$quant)(((Pass2)(CUR$.SL$)).inspect$2097$236)).initval$3!=(null)))) {
                                // JavaLine 645 <== SourceLine 2099
                                {
                                    if(VALUE$((((Common$quant)(((Pass2)(CUR$.SL$)).inspect$2097$236)).tag$2==(0)))) {
                                        // JavaLine 648 <== SourceLine 2100
                                        {
                                            new Common$ERROR(((Pass2)(CUR$.SL$)).inspect$20$141,CONC(new TXT$("INIT on undefined var: "),((Common$quant)(((Pass2)(CUR$.SL$)).inspect$2097$236)).symb$2.symbol));
                                            ;
                                            // JavaLine 652 <== SourceLine 2101
                                            new Common$deftag(((Pass2)(CUR$.SL$)).inspect$20$141,((Common$descr)((Pass2)(CUR$.SL$)).inspect$2097$236));
                                            ;
                                        }
                                    }
                                    ;
                                    // JavaLine 658 <== SourceLine 2103
                                    new Common$WARNING(((Pass2)(CUR$.SL$)).inspect$20$141,new TXT$("INIT may not be def. in BEC!!!"));
                                    ;
                                    // JavaLine 661 <== SourceLine 2104
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$)).inspect$20$141.S_INIT$1);
                                    ;
                                    new OuptFile$outtag(((Pass2)(CUR$.SL$)).inspect$21$143,((Common$quant)(((Pass2)(CUR$.SL$)).inspect$2097$236)).tag$2);
                                    ;
                                    // JavaLine 666 <== SourceLine 2105
                                    new Pass2$CompoundStatement21$SubBlock23$outtype(((Pass2$CompoundStatement21$SubBlock23)(CUR$)),((Common$quant)(((Pass2)(CUR$.SL$)).inspect$2097$236)).p3$type);
                                    ;
                                    // JavaLine 669 <== SourceLine 2106
                                    if(VALUE$((((Pass2)(CUR$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                        new OuptFile$outcode(((Pass2)(CUR$.SL$)).inspect$21$143);
                                    }
                                    ;
                                    // JavaLine 674 <== SourceLine 2107
                                    for(boolean CB$2107:new ForList(
                                        new SingleElt<Link$>(new NAME$<Link$>(){ public Link$ put(Link$ x$){e=(Common$const$)x$; return(x$);};  public Link$ get(){return((Link$)e); }	},new NAME$<Link$>() { public Link$ get(){return(((Common$quant)(((Pass2)(CUR$.SL$)).inspect$2097$236)).initval$3.first()); }})
                                       ,new WhileElt<Common$const$>(new NAME$<Common$const$>(){ public Common$const$ put(Common$const$ x$){e=x$; return(x$);};  public Common$const$ get(){return((Common$const$)e); }	},new NAME$<Common$const$>() { public Common$const$ get(){return(((Common$const$)(e.suc()))); }},new NAME$<Boolean>() { public Boolean get(){return((e!=(null))); }})
                                       )) { if(!CB$2107) continue;
                                    // JavaLine 679 <== SourceLine 2109
                                    {
                                        typ=new Pass2$CompoundStatement21$SubBlock23$outconst(((Pass2$CompoundStatement21$SubBlock23)(CUR$)),e).RESULT$;
                                        ;
                                        // JavaLine 683 <== SourceLine 2110
                                        if(VALUE$((typ!=(((Common$quant)(((Pass2)(CUR$.SL$)).inspect$2097$236)).p3$type)))) {
                                            new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$)),typ,((Common$quant)(((Pass2)(CUR$.SL$)).inspect$2097$236)).p3$type);
                                        }
                                        ;
                                    }
                                }
                                ;
                            }
                        } else
                        // JavaLine 693 <== SourceLine 2111
                        new Pass2$CompoundStatement21$SubBlock23$out_descr(((Pass2$CompoundStatement21$SubBlock23)(CUR$)),d);
                        ;
                    }
                    else // OTHERWISE 
                    // JavaLine 698 <== SourceLine 2112
                    new Pass2$CompoundStatement21$SubBlock23$out_descr(((Pass2$CompoundStatement21$SubBlock23)(CUR$)),d);
                }
                ;
                // JavaLine 702 <== SourceLine 2113
                d=((Common$descr)(d.suc()));
                ;
            }
        }
        ;
    }
    ;
    // JavaLine 710 <== SourceLine 2116
    if(VALUE$(TRF_NE(((Pass2)(CUR$.SL$)).inspect$20$141.module_ident$1,null))) {
        // JavaLine 712 <== SourceLine 2117
        {
            new OuptFile$outinst(((Pass2)(CUR$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$)).inspect$20$141.S_ENDMODULE$1);
            ;
            // JavaLine 716 <== SourceLine 2118
            if(VALUE$((((Pass2)(CUR$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                new OuptFile$outcode(((Pass2)(CUR$.SL$)).inspect$21$143);
            }
            ;
        }
    }
    ;
    // JavaLine 724 <== SourceLine 2121
    new OuptFile$outinst(((Pass2)(CUR$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$)).inspect$20$141.S_ENDPROGRAM$1);
    ;
    // JavaLine 727 <== SourceLine 2122
    if(VALUE$((((Pass2)(CUR$.SL$)).inspect$21$143.output_trace$3>(0)))) {
        new OuptFile$outcode(((Pass2)(CUR$.SL$)).inspect$21$143);
    }
    ;
    // JavaLine 732 <== SourceLine 2123
    ((InptFile)((Pass2)(CUR$.SL$)).inspect$20$142).close();
    ;
    ((OuptFile)((Pass2)(CUR$.SL$)).inspect$21$143).close();
    ;
    break LOOP$;
}
catch(LABQNT$ q) {
    CUR$=THIS$;
    if(q.SL$!=CUR$) {
        if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock23:NON-LOCAL",q);
        CUR$.STATE$=OperationalState.terminated;
        if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock23:RE-THROW",q);
        throw(q);
    }
    if(RT.Option.GOTO_TRACING) TRACE_GOTO("SubBlock23:LOCAL",q);
    JTX$=q.index; continue LOOP$; // EG. GOTO Lx
}
}
EBLK();
return(this);
} // End of SubBlock Statements
public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","SubBlock SubBlock23",1,23,10,2022,13,23,15,24,17,25,19,26,22,27,25,28,34,29,36,30,38,31,42,32,45,34,47,35,49,36,51,37,58,34,63,35,68,36,73,37,85,1926,88,1927,90,1928,94,1929,100,1933,103,1934,105,1935,109,1936,115,1939,120,1940,125,1942,127,1943,134,1944,141,1945,147,1946,156,1948,160,1949,164,1950,168,1951,172,1953,176,1957,183,1959,187,1960,193,1963,204,1964,207,1966,210,1968,213,1969,216,1970,221,1972,226,1973,231,1974,236,1975,241,1978,248,1979,250,1980,257,1982,263,1983,266,1984,271,1985,274,1986,281,1988,287,1989,289,1990,295,1991,298,1992,307,1994,309,2005,313,2007,320,2008,323,2009,326,2010,335,2011,337,2012,341,2013,346,2014,350,2015,355,2019,361,2020,367,2044,369,2022,371,2023,375,2024,378,2025,381,2026,384,2027,389,2029,391,2030,397,2031,402,2032,405,2033,409,2034,412,2035,417,2036,420,2037,429,2039,435,2041,437,2042,444,2046,446,2047,450,2048,452,2049,462,2050,464,2051,467,2052,474,2053,478,2054,484,2055,489,2056,491,2061,497,2063,500,2064,504,2065,506,2066,517,2068,520,2069,526,2070,530,2071,536,2072,539,2073,544,2074,547,2075,555,2077,560,2078,565,2079,576,2081,579,2082,588,2083,593,2084,596,2085,601,2086,606,2088,610,2089,622,2092,629,2095,633,2096,635,2097,642,2098,645,2099,648,2100,652,2101,658,2103,661,2104,666,2105,669,2106,674,2107,679,2109,683,2110,693,2111,698,2112,702,2113,710,2116,712,2117,716,2118,724,2121,727,2122,732,2123,753,2125);
} // End of SubBlock
