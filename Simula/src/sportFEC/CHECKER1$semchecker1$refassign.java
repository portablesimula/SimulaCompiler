// JavaLine 1 ==> SourceLine 916
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$refassign extends CHECKER1$semchecker1$exp {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=916, lastLine=1085, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public CHECKER1$semchecker1$exp p1$target;
    public CHECKER1$semchecker1$exp p1$source;
    // Declare local labels
    // JavaLine 14 ==> SourceLine 1021
    final LABQNT$ QE=new LABQNT$(this,1,1); // Local Label #1=QE
    // JavaLine 16 ==> SourceLine 1078
    final LABQNT$ EXIT=new LABQNT$(this,1,2); // Local Label #2=EXIT
    // Declare locals as attributes
    // JavaLine 19 ==> SourceLine 923
    public boolean implqua=false;
    // JavaLine 21 ==> SourceLine 1062
    public CHECKER1$semchecker1$argumented inspect$1062$94=null;
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$refassign$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$refassign(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$exp sp1$target,CHECKER1$semchecker1$exp sp1$source) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        this.p1$target = sp1$target;
        this.p1$source = sp1$source;
        // Declaration Code
        TRACE_BEGIN_DCL$("refassign",1062);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("refassign",1062,inner);
                CHECKER1$semchecker1$refassign THIS$=(CHECKER1$semchecker1$refassign)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 40 ==> SourceLine 992
                        while(true) {
                            // JavaLine 42 ==> SourceLine 995
                            {
                                TRACE_BEGIN_STM$("CompoundStatement995",995);
                                type=p1$target.type;
                                // JavaLine 46 ==> SourceLine 997
                                switch(type) { // BEGIN SWITCH STATEMENT
                                case 1: 
                                case 2: 
                                case 3: 
                                case 4: 
                                case 5: 
                                case 6: 
                                // JavaLine 54 ==> SourceLine 999
                                if((type==(p1$source.type))) {
                                    // JavaLine 56 ==> SourceLine 1000
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1000",1000);
                                        new ERRMSG$error0(((CHECKER1)(CUR$.SL$.SL$)),-159);
                                        // JavaLine 60 ==> SourceLine 1001
                                        if((((CHECKER1$semchecker1)(CUR$.SL$)).valassList==(null))) {
                                            // JavaLine 62 ==> SourceLine 1003
                                            new CHECKER1$semchecker1$valassign(((CHECKER1$semchecker1)(CUR$.SL$)),p$pred,((CHECKER1)(CUR$.SL$.SL$)).IASSG,p1$target,p1$source).START();
                                        } else
                                        call(((CHECKER1$semchecker1)(CUR$.SL$)).valassList);
                                        // JavaLine 66 ==> SourceLine 1004
                                        ((CHECKER1$semchecker1)(CUR$.SL$)).refassList=((CHECKER1$semchecker1$refassign)CUR$);
                                        // JavaLine 68 ==> SourceLine 1005
                                        GOTO$(EXIT); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement1000",1005);
                                    }
                                } else
                                // JavaLine 73 ==> SourceLine 1006
                                if(((p1$source.type==(((CHECKER1)(CUR$.SL$.SL$)).IREF))||((p1$source.type==(((CHECKER1)(CUR$.SL$.SL$)).ITEXT))))) {
                                    // JavaLine 75 ==> SourceLine 1007
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1007",1007);
                                        new CHECKER1$semchecker1$exp$typeError(((CHECKER1$semchecker1$refassign)CUR$),304);
                                        type=p1$source.type;
                                        TRACE_END_STM$("CompoundStatement1007",1007);
                                    }
                                } else
                                // JavaLine 83 ==> SourceLine 1008
                                new CHECKER1$semchecker1$exp$incompTypes(((CHECKER1$semchecker1$refassign)CUR$),type,p1$source.type);
                                case 7: 
                                case 8: 
                                case 9: 
                                // JavaLine 88 ==> SourceLine 1010
                                if((type==(p1$source.type))) {
                                    // JavaLine 90 ==> SourceLine 1011
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1011",1011);
                                        if((p1$target.qual==(null))) {
                                            qual=p1$source.qual;
                                        } else
                                        // JavaLine 96 ==> SourceLine 1013
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1013",1013);
                                            qual=p1$target.qual;
                                            // JavaLine 100 ==> SourceLine 1014
                                            if((p1$source.qual==(null))) {
                                            } else
                                            // JavaLine 103 ==> SourceLine 1015
                                            if(new BUILDER1$precheck0$subclass(((CHECKER1$semchecker1)(CUR$.SL$)),p1$source.qual,qual).RESULT$) {
                                            } else
                                            // JavaLine 106 ==> SourceLine 1016
                                            if(new BUILDER1$precheck0$subclass(((CHECKER1$semchecker1)(CUR$.SL$)),qual,p1$source.qual).RESULT$) {
                                                // JavaLine 108 ==> SourceLine 1018
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement1018",1018);
                                                    if(IS$(p1$source,CHECKER1$semchecker1$newIdent.class)) {
                                                        GOTO$(QE); // GOTO EVALUATED LABEL
                                                    }
                                                    // JavaLine 114 ==> SourceLine 1019
                                                    implqua=(((CHECKER1)(CUR$.SL$.SL$)).QuaCheck&&((qual.kind==(((CHECKER1)(CUR$.SL$.SL$)).K_class))));
                                                    TRACE_END_STM$("CompoundStatement1018",1019);
                                                }
                                            } else
                                            // JavaLine 119 ==> SourceLine 1021
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1021",1021);
                                                LABEL$(1); // QE
                                                new ERRMSG$error2quants(((CHECKER1)(CUR$.SL$.SL$)),403,qual,p1$source.qual);
                                                TRACE_END_STM$("CompoundStatement1021",1021);
                                            }
                                            TRACE_END_STM$("CompoundStatement1013",1021);
                                        }
                                        TRACE_END_STM$("CompoundStatement1011",1021);
                                    }
                                } else
                                // JavaLine 131 ==> SourceLine 1024
                                new CHECKER1$semchecker1$exp$typeError(p1$source,305);
                                case 15: 
                                // JavaLine 134 ==> SourceLine 1026
                                type=p1$source.type;
                            } // END SWITCH STATEMENT
                            // JavaLine 137 ==> SourceLine 1029
                            if((p1$source.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN))) {
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1029",1029);
                                    if((p1$source.kind!=(((CHECKER1)(CUR$.SL$.SL$)).K_ident))) {
                                        // JavaLine 142 ==> SourceLine 1030
                                        new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p1$source)));
                                    }
                                    TRACE_END_STM$("CompoundStatement1029",1030);
                                }
                            }
                            // JavaLine 148 ==> SourceLine 1033
                            if((p1$target.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN))) {
                                // JavaLine 150 ==> SourceLine 1034
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1034",1034);
                                    switch(p1$target.kind) { // BEGIN SWITCH STATEMENT
                                    case 0: 
                                    case 10: 
                                    // JavaLine 156 ==> SourceLine 1036
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1036",1036);
                                        issimple=p1$target.issimple;
                                        // JavaLine 160 ==> SourceLine 1037
                                        if((p1$target.meaning.protect==(((char)2)))) {
                                            // JavaLine 162 ==> SourceLine 1038
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1038",1038);
                                                if((((CHECKER1$semchecker1)(CUR$.SL$)).readonly==(p1$target.meaning))) {
                                                    ((CHECKER1$semchecker1)(CUR$.SL$)).readonly=null;
                                                } else
                                                // JavaLine 168 ==> SourceLine 1039
                                                new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(p1$target)),253);
                                                TRACE_END_STM$("CompoundStatement1038",1039);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement1036",1039);
                                    }
                                    case 2: 
                                    case 6: 
                                    // JavaLine 177 ==> SourceLine 1043
                                    new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(p1$target)),347);
                                    case 3: 
                                    // JavaLine 180 ==> SourceLine 1045
                                    new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(p1$target)),348);
                                    case 4: 
                                    // JavaLine 183 ==> SourceLine 1047
                                    new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(p1$target)),349);
                                    case 5: 
                                    case 7: 
                                    // JavaLine 187 ==> SourceLine 1049
                                    new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(p1$target)),350);
                                    case 1: 
                                    // JavaLine 190 ==> SourceLine 1051
                                    if(new CHECKER1$semchecker1$identifier$result(((CHECKER1$semchecker1$identifier)(p1$target))).RESULT$) {
                                        // JavaLine 192 ==> SourceLine 1052
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1052",1052);
                                            issimple=1;
                                            // JavaLine 196 ==> SourceLine 1053
                                            if((p1$target.type==(((CHECKER1)(CUR$.SL$.SL$)).INOTY))) {
                                                // JavaLine 198 ==> SourceLine 1055
                                                new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(p1$target)),345);
                                            }
                                            TRACE_END_STM$("CompoundStatement1052",1055);
                                        }
                                    } else
                                    new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(p1$target)),346);
                                    default:
                                    // JavaLine 206 ==> SourceLine 1056
                                    new ERRMSG$internerr(((CHECKER1)(CUR$.SL$.SL$)),((char)8),1056);
                                } // END SWITCH STATEMENT
                                TRACE_END_STM$("CompoundStatement1034",1056);
                            }
                        } else
                        // JavaLine 212 ==> SourceLine 1060
                        if((p1$target.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDNP))) {
                            // JavaLine 214 ==> SourceLine 1062
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1062",1062);
                                {
                                    // BEGIN INSPECTION 
                                    inspect$1062$94=((CHECKER1$semchecker1$argumented)(p1$target));
                                    if(inspect$1062$94!=null) //INSPECT inspect$1062$94
                                    // JavaLine 221 ==> SourceLine 1063
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1063",1063);
                                        ((CHECKER1$semchecker1$refassign)CUR$).issimple=inspect$1062$94.p1$ident.issimple;
                                        // JavaLine 225 ==> SourceLine 1064
                                        switch(inspect$1062$94.p1$ident.kind) { // BEGIN SWITCH STATEMENT
                                        case 10: 
                                        case 2: 
                                        case 6: 
                                        // JavaLine 230 ==> SourceLine 1066
                                        if((inspect$1062$94.p1$ident.meaning.protect==(((char)2)))) {
                                            // JavaLine 232 ==> SourceLine 1067
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1067",1067);
                                                if((((CHECKER1$semchecker1)(CUR$.SL$)).readonly==(inspect$1062$94.p1$ident.meaning))) {
                                                    ((CHECKER1$semchecker1)(CUR$.SL$)).readonly=null;
                                                } else
                                                // JavaLine 238 ==> SourceLine 1068
                                                new CHECKER1$semchecker1$identifier$identError(inspect$1062$94.p1$ident,253);
                                                TRACE_END_STM$("CompoundStatement1067",1068);
                                            }
                                        }
                                        default:
                                        // JavaLine 244 ==> SourceLine 1070
                                        new CHECKER1$semchecker1$identifier$identError(inspect$1062$94.p1$ident,351);
                                    } // END SWITCH STATEMENT
                                    TRACE_END_STM$("CompoundStatement1063",1070);
                                }
                            }
                            TRACE_END_STM$("CompoundStatement1062",1070);
                        }
                    } else
                    // JavaLine 253 ==> SourceLine 1074
                    new ERRMSG$error0(((CHECKER1)(CUR$.SL$.SL$)),160);
                    // JavaLine 255 ==> SourceLine 1075
                    ((CHECKER1$semchecker1)(CUR$.SL$)).exptop=((CHECKER1$semchecker1$refassign)CUR$);
                    // JavaLine 257 ==> SourceLine 1078
                    LABEL$(2); // EXIT
                    detach();
                    // JavaLine 260 ==> SourceLine 1080
                    ((CHECKER1$semchecker1)(CUR$.SL$)).refassList=null;
                    // JavaLine 262 ==> SourceLine 1082
                    p1$source=((CHECKER1$semchecker1)(CUR$.SL$)).exptop;
                    p1$target=p1$source.p$pred;
                    p$pred=p1$target.p$pred;
                    // JavaLine 266 ==> SourceLine 1083
                    cl=ctype=kind=((CHECKER1)(CUR$.SL$.SL$)).NUL;
                    issimple=0;
                    implqua=false;
                    TRACE_END_STM$("CompoundStatement995",1083);
                }
                   if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
            }
            // JavaLine 274 ==> SourceLine 992
            if(inner!=null) {
                inner.STM$();
                TRACE_BEGIN_STM_AFTER_INNER$("refassign",992);
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
    TRACE_END_STM$("refassign",992);
}
};
} // End of Constructor
// Class Statements
public CHECKER1$semchecker1$refassign STM$() { return((CHECKER1$semchecker1$refassign)CODE$.EXEC$()); }
public CHECKER1$semchecker1$refassign START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class refassign",1,916,14,1021,16,1078,19,923,21,1062,40,992,42,995,46,997,54,999,56,1000,60,1001,62,1003,66,1004,68,1005,73,1006,75,1007,83,1008,88,1010,90,1011,96,1013,100,1014,103,1015,106,1016,108,1018,114,1019,119,1021,131,1024,134,1026,137,1029,142,1030,148,1033,150,1034,156,1036,160,1037,162,1038,168,1039,177,1043,180,1045,183,1047,187,1049,190,1051,192,1052,196,1053,198,1055,206,1056,212,1060,214,1062,221,1063,225,1064,230,1066,232,1067,238,1068,244,1070,253,1074,255,1075,257,1078,260,1080,262,1082,266,1083,274,992,298,1085);
}
