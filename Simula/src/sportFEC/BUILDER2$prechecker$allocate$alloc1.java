// JavaLine 1 ==> SourceLine 1002
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$prechecker$allocate$alloc1 extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1002, lastLine=1148, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$brecord p$brc;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 1059
    final LABQNT$ copytoext=new LABQNT$(this,0,1); // Local Label #1=copytoext
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 1008
    COMMON$quantity Q=null;
    COMMON$quantity QP=null;
    COMMON$quantity QN=null;
    COMMON$quantity QX=null;
    // JavaLine 20 ==> SourceLine 1009
    COMMON$brctab2 tab2=null;
    // JavaLine 22 ==> SourceLine 1010
    boolean extbinding=false;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER2$prechecker$allocate$alloc1 setPar(Object param) {
        //Util.BREAK("CALL BUILDER2$prechecker$allocate$alloc1.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$brc=(COMMON$brecord)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER2$prechecker$allocate$alloc1(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER2$prechecker$allocate$alloc1(RTObject$ SL$,COMMON$brecord sp$brc) {
        super(SL$);
        // Parameter assignment to locals
        this.p$brc = sp$brc;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("alloc1",1032);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$prechecker$allocate$alloc1 STM$() {
        TRACE_BEGIN_STM$("alloc1",1032);
        BUILDER2$prechecker$allocate$alloc1 THIS$=(BUILDER2$prechecker$allocate$alloc1)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 57 ==> SourceLine 1037
                if((rank(p$brc.blev)>(((BUILDER2)(CUR$.SL$.SL$.SL$)).maxblev))) {
                    new ERRMSG$fatal0(((BUILDER2)(CUR$.SL$.SL$.SL$)),299);
                }
                // JavaLine 61 ==> SourceLine 1038
                extbinding=IS$(p$brc.declquant,COMMON$extquantity.class);
                // JavaLine 63 ==> SourceLine 1039
                Q=p$brc.fpar;
                // JavaLine 65 ==> SourceLine 1040
                while((Q!=(null))) {
                    // JavaLine 67 ==> SourceLine 1041
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1041",1041);
                        if(extbinding) {
                            // JavaLine 71 ==> SourceLine 1043
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1043",1043);
                                QX=new COMMON$extquantity(((BUILDER2)(CUR$.SL$.SL$.SL$)),null).STM$();
                                // JavaLine 75 ==> SourceLine 1044
                                ((COMMON$extquantity)(QX)).clf=((BUILDER2)(CUR$.SL$.SL$.SL$)).Clf002;
                                // JavaLine 77 ==> SourceLine 1045
                                GOTO$(copytoext); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement1043",1045);
                            }
                        }
                        // JavaLine 82 ==> SourceLine 1047
                        if((Q.categ!=(((BUILDER2)(CUR$.SL$.SL$.SL$)).C_extnal))) {
                            QX=Q;
                        } else
                        // JavaLine 86 ==> SourceLine 1048
                        if((Q.descr==(null))) {
                            // JavaLine 88 ==> SourceLine 1050
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1050",1050);
                                QX=new BUILDER1$newextquantbrec(((BUILDER2)(CUR$.SL$.SL$.SL$)),p$brc.blev,p$brc.rtblev,'S',null).RESULT$;
                                // JavaLine 92 ==> SourceLine 1051
                                new BUILDER2$prechecker$copyfromto(((BUILDER2$prechecker)(CUR$.SL$.SL$)),Q,QX);
                                QX.next=Q.next;
                                // JavaLine 95 ==> SourceLine 1052
                                if((QP==(null))) {
                                    QP=p$brc.fpar=QX;
                                } else
                                // JavaLine 99 ==> SourceLine 1053
                                QP.next=QX;
                                TRACE_END_STM$("CompoundStatement1050",1053);
                            }
                        } else
                        // JavaLine 104 ==> SourceLine 1057
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1057",1057);
                            QX=new COMMON$extquantity(((BUILDER2)(CUR$.SL$.SL$.SL$)),null).STM$();
                            // JavaLine 108 ==> SourceLine 1058
                            ((COMMON$extquantity)(QX)).clf=((BUILDER2)(CUR$.SL$.SL$.SL$)).Clf001;
                            // JavaLine 110 ==> SourceLine 1059
                            LABEL$(1); // copytoext
                            new BUILDER2$prechecker$copyfromto(((BUILDER2$prechecker)(CUR$.SL$.SL$)),Q,QX);
                            // JavaLine 113 ==> SourceLine 1060
                            QX.next=Q.next;
                            // JavaLine 115 ==> SourceLine 1061
                            if((QP==(null))) {
                                p$brc.fpar=QX;
                            } else
                            // JavaLine 119 ==> SourceLine 1062
                            QP.next=QX;
                            TRACE_END_STM$("CompoundStatement1057",1062);
                        }
                        // JavaLine 123 ==> SourceLine 1065
                        QN=QX;
                        QX=((COMMON$quantity)(QX.next));
                        // JavaLine 126 ==> SourceLine 1066
                        while((QX!=(null))) {
                            // JavaLine 128 ==> SourceLine 1068
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1068",1068);
                                if((QX.symb==(QN.symb))) {
                                    new ERRMSG$errQTN(((BUILDER2)(CUR$.SL$.SL$.SL$)),QX,411,QN);
                                }
                                // JavaLine 134 ==> SourceLine 1069
                                QX=((COMMON$quantity)(QX.next));
                                TRACE_END_STM$("CompoundStatement1068",1069);
                            }
                        }
                        // JavaLine 139 ==> SourceLine 1071
                        QN.encl=p$brc;
                        // JavaLine 141 ==> SourceLine 1072
                        if((QN.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_unknwn))) {
                            // JavaLine 143 ==> SourceLine 1073
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1073",1073);
                                new ERRMSG$errQT(((BUILDER2)(CUR$.SL$.SL$.SL$)),QN,319);
                                QN.type=((BUILDER2)(CUR$.SL$.SL$.SL$)).IELSE;
                                QN.kind=((BUILDER2)(CUR$.SL$.SL$.SL$)).K_error;
                                TRACE_END_STM$("CompoundStatement1073",1073);
                            }
                        } else
                        // JavaLine 152 ==> SourceLine 1075
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1075",1075);
                            switch(QN.categ) { // BEGIN SWITCH STATEMENT
                            case 3: 
                            // JavaLine 157 ==> SourceLine 1078
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1078",1078);
                                if((Q.descr!=(p$brc))) {
                                    // JavaLine 161 ==> SourceLine 1079
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1079",1079);
                                        if((((QN.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_proc))||((QN.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_class))))||((QN.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_record))))) {
                                            // JavaLine 165 ==> SourceLine 1082
                                            new BUILDER2$prechecker$allocate$alloc1$allocDescriptor(((BUILDER2$prechecker$allocate$alloc1)CUR$));
                                        }
                                        TRACE_END_STM$("CompoundStatement1079",1082);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement1078",1082);
                            }
                            case 0: 
                            // JavaLine 174 ==> SourceLine 1084
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1084",1084);
                                if((p$brc.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_class))) {
                                    // JavaLine 178 ==> SourceLine 1087
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1087",1087);
                                        if(((QN.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_proc))|((QN.type==(((BUILDER2)(CUR$.SL$.SL$.SL$)).ILABE))))) {
                                            // JavaLine 182 ==> SourceLine 1088
                                            new ERRMSG$errQT(((BUILDER2)(CUR$.SL$.SL$.SL$)),QN,320);
                                        }
                                        TRACE_END_STM$("CompoundStatement1087",1088);
                                    }
                                } else
                                // JavaLine 188 ==> SourceLine 1090
                                if(extbinding) {
                                    // JavaLine 190 ==> SourceLine 1091
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1091",1091);
                                        if(((QN.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_proc))|((QN.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_switch))))) {
                                            // JavaLine 194 ==> SourceLine 1093
                                            new ERRMSG$error1id(((BUILDER2)(CUR$.SL$.SL$.SL$)),(-(321)),QN.symb);
                                        }
                                        TRACE_END_STM$("CompoundStatement1091",1093);
                                    }
                                }
                                // JavaLine 200 ==> SourceLine 1095
                                p$brc.npar=(p$brc.npar+(1));
                                TRACE_END_STM$("CompoundStatement1084",1095);
                            }
                            case 1: 
                            // JavaLine 205 ==> SourceLine 1098
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1098",1098);
                                if((((QN.type<=(((BUILDER2)(CUR$.SL$.SL$.SL$)).ILONG))||((QN.type==(((BUILDER2)(CUR$.SL$.SL$.SL$)).IELSE))))&&(((QN.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_ident))||((QN.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_array))))))) {
                                    // JavaLine 209 ==> SourceLine 1101
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1101",1101);
                                        if((QN.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_ident))) {
                                            QN.categ=((BUILDER2)(CUR$.SL$.SL$.SL$)).C_unspec;
                                        }
                                        TRACE_END_STM$("CompoundStatement1101",1101);
                                    }
                                } else
                                // JavaLine 218 ==> SourceLine 1102
                                if(((QN.type!=(((BUILDER2)(CUR$.SL$.SL$.SL$)).ITEXT))||((QN.kind!=(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_ident))))) {
                                    // JavaLine 220 ==> SourceLine 1103
                                    new ERRMSG$errQT(((BUILDER2)(CUR$.SL$.SL$.SL$)),QN,322);
                                }
                                // JavaLine 223 ==> SourceLine 1104
                                p$brc.npar=(p$brc.npar+(1));
                                TRACE_END_STM$("CompoundStatement1098",1104);
                            }
                            case 2: 
                            // JavaLine 228 ==> SourceLine 1107
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1107",1107);
                                if((p$brc.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_class))) {
                                    // JavaLine 232 ==> SourceLine 1110
                                    new ERRMSG$errQT(((BUILDER2)(CUR$.SL$.SL$.SL$)),QN,323);
                                } else
                                if(extbinding) {
                                    // JavaLine 236 ==> SourceLine 1112
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1112",1112);
                                        if((QN.type==(((BUILDER2)(CUR$.SL$.SL$.SL$)).ILABE))) {
                                            // JavaLine 240 ==> SourceLine 1113
                                            new ERRMSG$errQT(((BUILDER2)(CUR$.SL$.SL$.SL$)),QN,321);
                                        }
                                        TRACE_END_STM$("CompoundStatement1112",1113);
                                    }
                                }
                                // JavaLine 246 ==> SourceLine 1114
                                p$brc.npar=(p$brc.npar+(1));
                                TRACE_END_STM$("CompoundStatement1107",1114);
                            }
                            case 4: 
                            // JavaLine 251 ==> SourceLine 1120
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1120",1120);
                                if((Q.descr!=(null))) {
                                    // JavaLine 255 ==> SourceLine 1122
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1122",1122);
                                        if((QN.dim==(0))) {
                                            new ERRMSG$errQT(((BUILDER2)(CUR$.SL$.SL$.SL$)),Q,324);
                                        }
                                        // JavaLine 261 ==> SourceLine 1125
                                        new BUILDER2$prechecker$allocate$alloc1$allocDescriptor(((BUILDER2$prechecker$allocate$alloc1)CUR$));
                                        TRACE_END_STM$("CompoundStatement1122",1125);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement1120",1125);
                            }
                            default:
                            // JavaLine 269 ==> SourceLine 1130
                            new ERRMSG$internerr(((BUILDER2)(CUR$.SL$.SL$.SL$)),((char)7),1130);
                        } // END SWITCH STATEMENT
                        TRACE_END_STM$("CompoundStatement1075",1130);
                    }
                    // JavaLine 274 ==> SourceLine 1133
                    if((QN.kind==(((BUILDER2)(CUR$.SL$.SL$.SL$)).K_class))) {
                        p$brc.localclasses=true;
                    }
                    // JavaLine 278 ==> SourceLine 1134
                    QP=QN;
                    Q=((COMMON$quantity)(Q.next));
                    TRACE_END_STM$("CompoundStatement1041",1134);
                }
            }
            // JavaLine 284 ==> SourceLine 1138
            Q=p$brc.favirt;
            // JavaLine 286 ==> SourceLine 1139
            while((Q!=(null))) {
                // JavaLine 288 ==> SourceLine 1140
                {
                    TRACE_BEGIN_STM$("CompoundStatement1140",1140);
                    Q.encl=p$brc;
                    // JavaLine 292 ==> SourceLine 1141
                    if((Q.descr!=(null))) {
                        // JavaLine 294 ==> SourceLine 1143
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1143",1143);
                            QN=Q;
                            new BUILDER2$prechecker$allocate$alloc1$allocDescriptor(((BUILDER2$prechecker$allocate$alloc1)CUR$));
                            TRACE_END_STM$("CompoundStatement1143",1143);
                        }
                    }
                    // JavaLine 302 ==> SourceLine 1144
                    Q=((COMMON$quantity)(Q.next));
                    TRACE_END_STM$("CompoundStatement1140",1144);
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
    TRACE_END_STM$("alloc1",1144);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure alloc1",1,1002,12,1059,15,1008,20,1009,22,1010,57,1037,61,1038,63,1039,65,1040,67,1041,71,1043,75,1044,77,1045,82,1047,86,1048,88,1050,92,1051,95,1052,99,1053,104,1057,108,1058,110,1059,113,1060,115,1061,119,1062,123,1065,126,1066,128,1068,134,1069,139,1071,141,1072,143,1073,152,1075,157,1078,161,1079,165,1082,174,1084,178,1087,182,1088,188,1090,190,1091,194,1093,200,1095,205,1098,209,1101,218,1102,220,1103,223,1104,228,1107,232,1110,236,1112,240,1113,246,1114,251,1120,255,1122,261,1125,269,1130,274,1133,278,1134,284,1138,286,1139,288,1140,292,1141,294,1143,302,1144,323,1148);
}
