// JavaLine 1 ==> SourceLine 780
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:59:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$recompattrfile$outquantwlist extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=780, lastLine=936, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$quantity p$q;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 920
    final LABQNT$ UTP=new LABQNT$(this,0,1); // Local Label #1=UTP
    // JavaLine 14 ==> SourceLine 914
    final LABQNT$ UTQ=new LABQNT$(this,0,2); // Local Label #2=UTQ
    // Declare locals as attributes
    // JavaLine 17 ==> SourceLine 805
    COMMON$quantity qq=null;
    TXT$ u=null;
    int k=0;
    int l=0;
    // JavaLine 22 ==> SourceLine 806
    COMMON$idpack cvis=null;
    COMMON$idpack pvis=null;
    COMMON$idpack xvis=null;
    // JavaLine 26 ==> SourceLine 812
    COMMON$quantity inspect$812$76=null;
    // JavaLine 28 ==> SourceLine 863
    COMMON$extbrecord inspect$863$77=null;
    // JavaLine 30 ==> SourceLine 871
    COMMON$brecord inspect$871$78=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER2$recompattrfile$outquantwlist setPar(Object param) {
        //Util.BREAK("CALL BUILDER2$recompattrfile$outquantwlist.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$q=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER2$recompattrfile$outquantwlist(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER2$recompattrfile$outquantwlist(RTObject$ SL$,COMMON$quantity sp$q) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q = sp$q;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("outquantwlist",871);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$recompattrfile$outquantwlist STM$() {
        TRACE_BEGIN_STM$("outquantwlist",871);
        BUILDER2$recompattrfile$outquantwlist THIS$=(BUILDER2$recompattrfile$outquantwlist)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 65 ==> SourceLine 812
                {
                    // BEGIN INSPECTION 
                    inspect$812$76=p$q;
                    if(inspect$812$76!=null) //INSPECT inspect$812$76
                    // JavaLine 70 ==> SourceLine 813
                    {
                        TRACE_BEGIN_STM$("CompoundStatement813",813);
                        k=new BUILDER1$exttag(((BUILDER2)(CUR$.SL$.SL$)),((COMMON$quantity)inspect$812$76)).RESULT$;
                        // JavaLine 74 ==> SourceLine 814
                        if((k>((-(2))))) {
                            // JavaLine 76 ==> SourceLine 817
                            {
                                TRACE_BEGIN_STM$("CompoundStatement817",817);
                                if((((BUILDER2$recompattrfile)(CUR$.SL$)).key>=(((BUILDER2$recompattrfile)(CUR$.SL$)).lowKey))) {
                                    new BUILDER2$recompattrfile$outquantwlist$recomperr(((BUILDER2$recompattrfile$outquantwlist)CUR$),370);
                                }
                                // JavaLine 82 ==> SourceLine 819
                                new COMMON$attrfile$fetchquant(((BUILDER2$recompattrfile)(CUR$.SL$)));
                                // JavaLine 84 ==> SourceLine 821
                                if(((inspect$812$76.symb!=(((BUILDER2$recompattrfile)(CUR$.SL$)).xident))&&(((inspect$812$76.encl.kind!=(((BUILDER2)(CUR$.SL$.SL$)).K_proc))||((inspect$812$76.categ>=(((BUILDER2)(CUR$.SL$.SL$)).C_local))))))) {
                                    // JavaLine 86 ==> SourceLine 822
                                    l=388;
                                } else
                                // JavaLine 89 ==> SourceLine 823
                                if((((BUILDER2$recompattrfile)(CUR$.SL$)).xprotect!=(inspect$812$76.protect))) {
                                    l=385;
                                } else
                                // JavaLine 93 ==> SourceLine 824
                                if((((BUILDER2$recompattrfile)(CUR$.SL$)).xtype!=(inspect$812$76.type))) {
                                    l=371;
                                } else
                                // JavaLine 97 ==> SourceLine 825
                                if((((BUILDER2$recompattrfile)(CUR$.SL$)).xkind!=(inspect$812$76.kind))) {
                                    l=372;
                                } else
                                // JavaLine 101 ==> SourceLine 826
                                if((((BUILDER2$recompattrfile)(CUR$.SL$)).xcateg!=(inspect$812$76.categ))) {
                                    l=373;
                                } else
                                // JavaLine 105 ==> SourceLine 827
                                if((((BUILDER2$recompattrfile)(CUR$.SL$)).xclf!=(((IS$(((COMMON$quantity)inspect$812$76),COMMON$extquantity.class))?(((COMMON$extquantity)(((COMMON$quantity)inspect$812$76))).clf):(((BUILDER2)(CUR$.SL$.SL$)).Clf000))))) {
                                    // JavaLine 107 ==> SourceLine 829
                                    l=378;
                                } else
                                // JavaLine 110 ==> SourceLine 830
                                if((k!=(((BUILDER2$recompattrfile)(CUR$.SL$)).xftag))) {
                                    l=379;
                                } else
                                // JavaLine 114 ==> SourceLine 831
                                l=0;
                                // JavaLine 116 ==> SourceLine 832
                                if((l!=(0))) {
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement832",832);
                                        new BUILDER2$recompattrfile$outquantwlist$recomperr(((BUILDER2$recompattrfile$outquantwlist)CUR$),l);
                                        l=0;
                                        TRACE_END_STM$("CompoundStatement832",832);
                                    }
                                }
                                // JavaLine 125 ==> SourceLine 835
                                if((inspect$812$76.categ!=(((BUILDER2)(CUR$.SL$.SL$)).C_extnal))) {
                                    // JavaLine 127 ==> SourceLine 836
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement836",836);
                                        if(((((BUILDER2$recompattrfile)(CUR$.SL$)).xdim!=(inspect$812$76.dim))&&((inspect$812$76.dim>=(0))))) {
                                            // JavaLine 131 ==> SourceLine 837
                                            new ERRMSG$error1id(((BUILDER2)(CUR$.SL$.SL$)),375,inspect$812$76.symb);
                                        }
                                        TRACE_END_STM$("CompoundStatement836",837);
                                    }
                                }
                                // JavaLine 137 ==> SourceLine 846
                                if((((inspect$812$76.prefqual!=(null)))?((((inspect$812$76.kind!=(((BUILDER2)(CUR$.SL$.SL$)).K_class))||((inspect$812$76.plev>(((BUILDER2)(CUR$.SL$.SL$)).one))))&&((inspect$812$76.prefqual.symb!=(new COMMON$boxof(((BUILDER2)(CUR$.SL$.SL$)),((BUILDER2$recompattrfile)(CUR$.SL$)).xprefqhi,((BUILDER2$recompattrfile)(CUR$.SL$)).xprefqlo).RESULT$))))):(((((BUILDER2$recompattrfile)(CUR$.SL$)).xprefqhi!=(((BUILDER2)(CUR$.SL$.SL$)).NUL))||((((BUILDER2$recompattrfile)(CUR$.SL$)).xprefqlo!=(((BUILDER2)(CUR$.SL$.SL$)).NUL))))))) {
                                    // JavaLine 139 ==> SourceLine 851
                                    new ERRMSG$error1id(((BUILDER2)(CUR$.SL$.SL$)),374,inspect$812$76.symb);
                                }
                                // JavaLine 142 ==> SourceLine 853
                                if(((((BUILDER2$recompattrfile)(CUR$.SL$)).xspecial!=(inspect$812$76.special))||(((inspect$812$76.special!=(((BUILDER2)(CUR$.SL$.SL$)).NUL))&&(((((BUILDER2$recompattrfile)(CUR$.SL$)).xarrhi!=(inspect$812$76.descr.blnohi))||((((BUILDER2$recompattrfile)(CUR$.SL$)).xarrlo!=(inspect$812$76.descr.blnolo))))))))) {
                                    // JavaLine 144 ==> SourceLine 856
                                    new ERRMSG$error1id(((BUILDER2)(CUR$.SL$.SL$)),384,inspect$812$76.symb);
                                }
                                // JavaLine 147 ==> SourceLine 858
                                if((inspect$812$76.categ==(((BUILDER2)(CUR$.SL$.SL$)).C_extnal))) {
                                    // JavaLine 149 ==> SourceLine 859
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement859",859);
                                        if((((BUILDER2$recompattrfile)(CUR$.SL$)).xlanguage!=(inspect$812$76.dim))) {
                                            new BUILDER2$recompattrfile$outquantwlist$recompwarn(((BUILDER2$recompattrfile$outquantwlist)CUR$),389);
                                        }
                                        // JavaLine 155 ==> SourceLine 860
                                        if((((BUILDER2$recompattrfile)(CUR$.SL$)).xextident!=(inspect$812$76.virtno))) {
                                            new BUILDER2$recompattrfile$outquantwlist$recompwarn(((BUILDER2$recompattrfile$outquantwlist)CUR$),390);
                                        }
                                        // JavaLine 159 ==> SourceLine 861
                                        if(IS$(inspect$812$76.descr,COMMON$extbrecord.class)) {
                                            // JavaLine 161 ==> SourceLine 863
                                            {
                                                // BEGIN INSPECTION 
                                                inspect$863$77=((COMMON$extbrecord)(inspect$812$76.descr));
                                                if(inspect$863$77!=null) //INSPECT inspect$863$77
                                                // JavaLine 166 ==> SourceLine 864
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement864",864);
                                                    if(((((BUILDER2$recompattrfile)(CUR$.SL$)).xmodulhi!=(inspect$863$77.modulhi))||((((BUILDER2$recompattrfile)(CUR$.SL$)).xmodullo!=(inspect$863$77.modullo))))) {
                                                        // JavaLine 170 ==> SourceLine 865
                                                        new BUILDER2$recompattrfile$outquantwlist$recompwarn(((BUILDER2$recompattrfile$outquantwlist)CUR$),391);
                                                    }
                                                    // JavaLine 173 ==> SourceLine 866
                                                    if(((((BUILDER2$recompattrfile)(CUR$.SL$)).xchecklo!=(inspect$863$77.checklo))||((((BUILDER2$recompattrfile)(CUR$.SL$)).xcheckhi!=(inspect$863$77.checkhi))))) {
                                                        // JavaLine 175 ==> SourceLine 867
                                                        new BUILDER2$recompattrfile$outquantwlist$recomperr(((BUILDER2$recompattrfile$outquantwlist)CUR$),377);
                                                    }
                                                    TRACE_END_STM$("CompoundStatement864",867);
                                                }
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement859",867);
                                    }
                                }
                                // JavaLine 185 ==> SourceLine 871
                                {
                                    // BEGIN INSPECTION 
                                    inspect$871$78=inspect$812$76.descr;
                                    if(inspect$871$78!=null) //INSPECT inspect$871$78
                                    // JavaLine 190 ==> SourceLine 872
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement872",872);
                                        if((inspect$871$78.thisused&&((!(((BUILDER2$recompattrfile)(CUR$.SL$)).xthisused))))) {
                                            new BUILDER2$recompattrfile$outquantwlist$recomperr(((BUILDER2$recompattrfile$outquantwlist)CUR$),376);
                                        }
                                        // JavaLine 196 ==> SourceLine 874
                                        if((((BUILDER2$recompattrfile)(CUR$.SL$)).xconnests!=(char$(inspect$871$78.connests)))) {
                                            new BUILDER2$recompattrfile$outquantwlist$recomperr(((BUILDER2$recompattrfile$outquantwlist)CUR$),387);
                                        }
                                        // JavaLine 200 ==> SourceLine 878
                                        if((inspect$871$78.hidlist==(null))) {
                                            // JavaLine 202 ==> SourceLine 879
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement879",879);
                                                if((((BUILDER2$recompattrfile)(CUR$.SL$)).xhidlist!=(null))) {
                                                    // JavaLine 206 ==> SourceLine 895
                                                    new BUILDER2$recompattrfile$outquantwlist$recompwarn(((BUILDER2$recompattrfile$outquantwlist)CUR$),385);
                                                }
                                                TRACE_END_STM$("CompoundStatement879",895);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement872",895);
                                    }
                                }
                                // JavaLine 215 ==> SourceLine 898
                                if(((inspect$812$76.special==(((BUILDER2)(CUR$.SL$.SL$)).NUL))&&(IS$(inspect$812$76.descr,COMMON$brecord.class)))) {
                                    // JavaLine 217 ==> SourceLine 899
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement899",899);
                                        l=k=0;
                                        // JavaLine 221 ==> SourceLine 900
                                        if(((inspect$812$76.categ==(((BUILDER2)(CUR$.SL$.SL$)).C_virt))&&((inspect$812$76.kind==(((BUILDER2)(CUR$.SL$.SL$)).K_proc))))) {
                                            // JavaLine 223 ==> SourceLine 902
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement902",902);
                                                qq=inspect$812$76.descr.fpar;
                                                // JavaLine 227 ==> SourceLine 904
                                                k=1;
                                                GOTO$(UTP); // GOTO EVALUATED LABEL
                                                TRACE_END_STM$("CompoundStatement902",904);
                                            }
                                        } else
                                        // JavaLine 233 ==> SourceLine 913
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement913",913);
                                            qq=inspect$812$76.descr.favirt;
                                            // JavaLine 237 ==> SourceLine 924
                                            LABEL$(2); // UTQ
                                            // JavaLine 239 ==> SourceLine 914
                                            while((qq!=(null))) {
                                                // JavaLine 241 ==> SourceLine 915
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement915",915);
                                                    if((((k==(0)))?((qq.dim!=(0))):(((IS$(qq.descr,COMMON$extbrecord.class))?((((COMMON$extbrecord)(qq.descr)).status==('S'))):(true))))) {
                                                        // JavaLine 245 ==> SourceLine 920
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement920",920);
                                                            LABEL$(1); // UTP
                                                            if((l==(0))) {
                                                                {
                                                                    TRACE_BEGIN_STM$("CompoundStatement920",920);
                                                                    new COMMON$attrfile$nextKey(((BUILDER2$recompattrfile)(CUR$.SL$)));
                                                                    l=1;
                                                                    TRACE_END_STM$("CompoundStatement920",920);
                                                                }
                                                            }
                                                            // JavaLine 257 ==> SourceLine 921
                                                            new BUILDER2$recompattrfile$outquantwlist(((BUILDER2$recompattrfile)(CUR$.SL$)),qq);
                                                            TRACE_END_STM$("CompoundStatement920",921);
                                                        }
                                                    }
                                                    // JavaLine 262 ==> SourceLine 923
                                                    if((qq!=(null))) {
                                                        qq=((COMMON$quantity)(qq.next));
                                                    }
                                                    TRACE_END_STM$("CompoundStatement915",923);
                                                }
                                            }
                                            // JavaLine 269 ==> SourceLine 925
                                            if((k==(0))) {
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement925",925);
                                                    qq=inspect$812$76.descr.fpar;
                                                    k=1;
                                                    GOTO$(UTQ); // GOTO EVALUATED LABEL
                                                    TRACE_END_STM$("CompoundStatement925",925);
                                                }
                                            }
                                            // JavaLine 279 ==> SourceLine 926
                                            if((l!=(0))) {
                                                // JavaLine 281 ==> SourceLine 928
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement928",928);
                                                    if((((BUILDER2$recompattrfile)(CUR$.SL$)).key!=(((BUILDER2$recompattrfile)(CUR$.SL$)).endlist))) {
                                                        // JavaLine 285 ==> SourceLine 929
                                                        new BUILDER2$recompattrfile$outquantwlist$recompwarn(((BUILDER2$recompattrfile$outquantwlist)CUR$),370);
                                                    } else
                                                    new COMMON$attrfile$nextKey(((BUILDER2$recompattrfile)(CUR$.SL$)));
                                                    TRACE_END_STM$("CompoundStatement928",929);
                                                }
                                            }
                                            TRACE_END_STM$("CompoundStatement913",929);
                                        }
                                        TRACE_END_STM$("CompoundStatement899",929);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement817",929);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement813",929);
                    }
                }
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$ || q.prefixLevel!=0) {
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("outquantwlist",929);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure outquantwlist",1,780,12,920,14,914,17,805,22,806,26,812,28,863,30,871,65,812,70,813,74,814,76,817,82,819,84,821,86,822,89,823,93,824,97,825,101,826,105,827,107,829,110,830,114,831,116,832,125,835,127,836,131,837,137,846,139,851,142,853,144,856,147,858,149,859,155,860,159,861,161,863,166,864,170,865,173,866,175,867,185,871,190,872,196,874,200,878,202,879,206,895,215,898,217,899,221,900,223,902,227,904,233,913,237,924,239,914,241,915,245,920,257,921,262,923,269,925,279,926,281,928,285,929,319,936);
}
