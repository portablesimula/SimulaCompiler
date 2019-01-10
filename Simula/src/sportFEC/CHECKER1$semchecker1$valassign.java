// JavaLine 1 ==> SourceLine 730
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$valassign extends CHECKER1$semchecker1$exp {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=730, lastLine=913, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public CHECKER1$semchecker1$exp p1$target;
    public CHECKER1$semchecker1$exp p1$source;
    // Declare local labels
    // JavaLine 14 ==> SourceLine 833
    final LABQNT$ NONCOMP=new LABQNT$(this,1,1); // Local Label #1=NONCOMP
    // JavaLine 16 ==> SourceLine 906
    final LABQNT$ EXIT=new LABQNT$(this,1,2); // Local Label #2=EXIT
    // Declare locals as attributes
    // JavaLine 19 ==> SourceLine 879
    public CHECKER1$semchecker1$argumented inspect$879$8=null;
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$valassign$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$valassign(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$exp sp1$target,CHECKER1$semchecker1$exp sp1$source) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        this.p1$target = sp1$target;
        this.p1$source = sp1$source;
        // Declaration Code
        TRACE_BEGIN_DCL$("valassign",879);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("valassign",879,inner);
                CHECKER1$semchecker1$valassign THIS$=(CHECKER1$semchecker1$valassign)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 38 ==> SourceLine 813
                        while(true) {
                            // JavaLine 40 ==> SourceLine 815
                            {
                                TRACE_BEGIN_STM$("CompoundStatement815",815);
                                type=p1$target.type;
                                // JavaLine 44 ==> SourceLine 818
                                switch(type) { // BEGIN SWITCH STATEMENT
                                case 7: 
                                // JavaLine 47 ==> SourceLine 820
                                if((p1$source.type==(((CHECKER1)(CUR$.SL$.SL$)).IREF))) {
                                    // JavaLine 49 ==> SourceLine 821
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement821",821);
                                        new ERRMSG$error0(((CHECKER1)(CUR$.SL$.SL$)),(-(159)));
                                        // JavaLine 53 ==> SourceLine 822
                                        if((((CHECKER1$semchecker1)(CUR$.SL$)).refassList==(null))) {
                                            // JavaLine 55 ==> SourceLine 824
                                            new CHECKER1$semchecker1$refassign(((CHECKER1$semchecker1)(CUR$.SL$)),p$pred,((CHECKER1)(CUR$.SL$.SL$)).IDENO,p1$target,p1$source).START();
                                        } else
                                        call(((CHECKER1$semchecker1)(CUR$.SL$)).refassList);
                                        // JavaLine 59 ==> SourceLine 825
                                        ((CHECKER1$semchecker1)(CUR$.SL$)).valassList=((CHECKER1$semchecker1$valassign)CUR$);
                                        // JavaLine 61 ==> SourceLine 826
                                        GOTO$(EXIT); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement821",826);
                                    }
                                } else
                                new ERRMSG$error0(((CHECKER1)(CUR$.SL$.SL$)),156);
                                case 15: 
                                case 2: 
                                case 3: 
                                case 4: 
                                case 5: 
                                case 6: 
                                // JavaLine 73 ==> SourceLine 830
                                switch(p1$source.type) { // BEGIN SWITCH STATEMENT
                                case 1: 
                                case 8: 
                                case 14: 
                                // JavaLine 78 ==> SourceLine 833
                                LABEL$(1); // NONCOMP
                                new CHECKER1$semchecker1$exp$incompTypes(((CHECKER1$semchecker1$valassign)CUR$),type,p1$source.type);
                                case 7: 
                                // JavaLine 82 ==> SourceLine 834
                                new ERRMSG$error0(((CHECKER1)(CUR$.SL$.SL$)),157);
                            } // END SWITCH STATEMENT
                            default:
                            // JavaLine 86 ==> SourceLine 837
                            if((type!=(p1$source.type))) {
                                GOTO$(NONCOMP); // GOTO EVALUATED LABEL
                            }
                        } // END SWITCH STATEMENT
                        // JavaLine 91 ==> SourceLine 840
                        if((p1$source.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN))) {
                            {
                                TRACE_BEGIN_STM$("CompoundStatement840",840);
                                if((p1$source.kind!=(((CHECKER1)(CUR$.SL$.SL$)).K_ident))) {
                                    // JavaLine 96 ==> SourceLine 841
                                    new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p1$source)));
                                }
                                TRACE_END_STM$("CompoundStatement840",841);
                            }
                        }
                        // JavaLine 102 ==> SourceLine 844
                        if((p1$target.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN))) {
                            // JavaLine 104 ==> SourceLine 845
                            {
                                TRACE_BEGIN_STM$("CompoundStatement845",845);
                                p1$target.cl=(((((CHECKER1$semchecker1$identifier)(p1$target)).type==(((CHECKER1)(CUR$.SL$.SL$)).ITEXT)))?(((CHECKER1$semchecker1)(CUR$.SL$)).ITEXTcl):(((CHECKER1$semchecker1)(CUR$.SL$)).ITOcl));
                                // JavaLine 108 ==> SourceLine 847
                                switch(p1$target.kind) { // BEGIN SWITCH STATEMENT
                                case 0: 
                                case 10: 
                                // JavaLine 112 ==> SourceLine 849
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement849",849);
                                    issimple=p1$target.issimple;
                                    // JavaLine 116 ==> SourceLine 850
                                    if((p1$target.meaning.protect==(((char)2)))) {
                                        // JavaLine 118 ==> SourceLine 851
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement851",851);
                                            if((((CHECKER1$semchecker1)(CUR$.SL$)).readonly==(p1$target.meaning))) {
                                                ((CHECKER1$semchecker1)(CUR$.SL$)).readonly=null;
                                            } else
                                            // JavaLine 124 ==> SourceLine 852
                                            new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(p1$target)),253);
                                            TRACE_END_STM$("CompoundStatement851",852);
                                        }
                                    }
                                    TRACE_END_STM$("CompoundStatement849",852);
                                }
                                case 6: 
                                // JavaLine 132 ==> SourceLine 855
                                new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(p1$target)),340);
                                case 2: 
                                // JavaLine 135 ==> SourceLine 856
                                new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(p1$target)),340);
                                case 3: 
                                // JavaLine 138 ==> SourceLine 857
                                new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(p1$target)),341);
                                case 4: 
                                // JavaLine 141 ==> SourceLine 858
                                new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(p1$target)),342);
                                case 5: 
                                // JavaLine 144 ==> SourceLine 859
                                new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(p1$target)),343);
                                case 7: 
                                // JavaLine 147 ==> SourceLine 860
                                new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(p1$target)),343);
                                case 1: 
                                // JavaLine 150 ==> SourceLine 864
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement864",864);
                                    if(new CHECKER1$semchecker1$identifier$result(((CHECKER1$semchecker1$identifier)(p1$target))).RESULT$) {
                                        // JavaLine 154 ==> SourceLine 865
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement865",865);
                                            issimple=1;
                                            // JavaLine 158 ==> SourceLine 866
                                            if((p1$target.type==(((CHECKER1)(CUR$.SL$.SL$)).INOTY))) {
                                                // JavaLine 160 ==> SourceLine 868
                                                new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(p1$target)),338);
                                            }
                                            TRACE_END_STM$("CompoundStatement865",868);
                                        }
                                    } else
                                    if((p1$target.type==(((CHECKER1)(CUR$.SL$.SL$)).ITEXT))) {
                                        // JavaLine 167 ==> SourceLine 869
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement869",869);
                                            new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p1$target)));
                                            // JavaLine 171 ==> SourceLine 870
                                            p1$target.cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                                            TRACE_END_STM$("CompoundStatement869",870);
                                        }
                                    } else
                                    // JavaLine 176 ==> SourceLine 871
                                    new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(p1$target)),339);
                                    TRACE_END_STM$("CompoundStatement864",871);
                                }
                                default:
                                // JavaLine 181 ==> SourceLine 873
                                new ERRMSG$internerr(((CHECKER1)(CUR$.SL$.SL$)),((char)8),873);
                            } // END SWITCH STATEMENT
                            TRACE_END_STM$("CompoundStatement845",873);
                        }
                    } else
                    // JavaLine 187 ==> SourceLine 877
                    if((p1$target.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDNP))) {
                        // JavaLine 189 ==> SourceLine 879
                        {
                            TRACE_BEGIN_STM$("CompoundStatement879",879);
                            {
                                // BEGIN INSPECTION 
                                inspect$879$8=((CHECKER1$semchecker1$argumented)(p1$target));
                                if(inspect$879$8!=null) //INSPECT inspect$879$8
                                // JavaLine 196 ==> SourceLine 880
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement880",880);
                                    ((CHECKER1$semchecker1$valassign)CUR$).issimple=inspect$879$8.issimple;
                                    // JavaLine 200 ==> SourceLine 881
                                    inspect$879$8.cl=((CHECKER1$semchecker1)(CUR$.SL$)).ITOcl;
                                    // JavaLine 202 ==> SourceLine 882
                                    switch(inspect$879$8.p1$ident.kind) { // BEGIN SWITCH STATEMENT
                                    case 10: 
                                    case 2: 
                                    case 6: 
                                    // JavaLine 207 ==> SourceLine 884
                                    if((inspect$879$8.p1$ident.meaning.protect==(((char)2)))) {
                                        // JavaLine 209 ==> SourceLine 885
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement885",885);
                                            if((((CHECKER1$semchecker1)(CUR$.SL$)).readonly==(inspect$879$8.p1$ident.meaning))) {
                                                ((CHECKER1$semchecker1)(CUR$.SL$)).readonly=null;
                                            } else
                                            // JavaLine 215 ==> SourceLine 886
                                            new CHECKER1$semchecker1$identifier$identError(inspect$879$8.p1$ident,253);
                                            TRACE_END_STM$("CompoundStatement885",886);
                                        }
                                    }
                                    default:
                                    // JavaLine 221 ==> SourceLine 889
                                    if((inspect$879$8.type==(((CHECKER1)(CUR$.SL$.SL$)).ITEXT))) {
                                        inspect$879$8.cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                                    } else
                                    // JavaLine 225 ==> SourceLine 892
                                    new CHECKER1$semchecker1$identifier$identError(inspect$879$8.p1$ident,344);
                                } // END SWITCH STATEMENT
                                TRACE_END_STM$("CompoundStatement880",892);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement879",892);
                    }
                } else
                // JavaLine 234 ==> SourceLine 896
                if((p1$target.p$ch==(((CHECKER1)(CUR$.SL$.SL$)).IRGPA))) {
                    // JavaLine 236 ==> SourceLine 897
                    {
                        TRACE_BEGIN_STM$("CompoundStatement897",897);
                        p1$target.cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                        // JavaLine 240 ==> SourceLine 898
                        if((p1$target.type!=(((CHECKER1)(CUR$.SL$.SL$)).ITEXT))) {
                            new ERRMSG$error0(((CHECKER1)(CUR$.SL$.SL$)),158);
                        }
                        TRACE_END_STM$("CompoundStatement897",898);
                    }
                } else
                // JavaLine 247 ==> SourceLine 900
                if((p1$target.p$ch==(((CHECKER1)(CUR$.SL$.SL$)).ICONS))) {
                    // JavaLine 249 ==> SourceLine 901
                    {
                        TRACE_BEGIN_STM$("CompoundStatement901",901);
                        p1$target.cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                        // JavaLine 253 ==> SourceLine 902
                        new ERRMSG$error0(((CHECKER1)(CUR$.SL$.SL$)),152);
                        TRACE_END_STM$("CompoundStatement901",902);
                    }
                } else
                new ERRMSG$error0(((CHECKER1)(CUR$.SL$.SL$)),150);
                // JavaLine 259 ==> SourceLine 903
                ((CHECKER1$semchecker1)(CUR$.SL$)).exptop=((CHECKER1$semchecker1$valassign)CUR$);
                // JavaLine 261 ==> SourceLine 906
                LABEL$(2); // EXIT
                detach();
                // JavaLine 264 ==> SourceLine 908
                ((CHECKER1$semchecker1)(CUR$.SL$)).valassList=null;
                // JavaLine 266 ==> SourceLine 910
                p1$source=((CHECKER1$semchecker1)(CUR$.SL$)).exptop;
                p1$target=p1$source.p$pred;
                p$pred=p1$target.p$pred;
                // JavaLine 270 ==> SourceLine 911
                cl=ctype=kind=((CHECKER1)(CUR$.SL$.SL$)).NUL;
                issimple=0;
                TRACE_END_STM$("CompoundStatement815",911);
            }
               if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
        }
        // JavaLine 277 ==> SourceLine 813
        if(inner!=null) {
            inner.STM$();
            TRACE_BEGIN_STM_AFTER_INNER$("valassign",813);
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
TRACE_END_STM$("valassign",813);
}
};
} // End of Constructor
// Class Statements
public CHECKER1$semchecker1$valassign STM$() { return((CHECKER1$semchecker1$valassign)CODE$.EXEC$()); }
public CHECKER1$semchecker1$valassign START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class valassign",1,730,14,833,16,906,19,879,38,813,40,815,44,818,47,820,49,821,53,822,55,824,59,825,61,826,73,830,78,833,82,834,86,837,91,840,96,841,102,844,104,845,108,847,112,849,116,850,118,851,124,852,132,855,135,856,138,857,141,858,144,859,147,860,150,864,154,865,158,866,160,868,167,869,171,870,176,871,181,873,187,877,189,879,196,880,200,881,202,882,207,884,209,885,215,886,221,889,225,892,234,896,236,897,240,898,247,900,249,901,253,902,259,903,261,906,264,908,266,910,270,911,277,813,301,913);
}
