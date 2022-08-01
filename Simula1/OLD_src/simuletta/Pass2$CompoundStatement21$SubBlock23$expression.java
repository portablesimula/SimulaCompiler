// JavaLine 1 <== SourceLine 1035
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$expression extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=1035, lastLine=1359, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$b;
    // Declare local labels
    // JavaLine 14 <== SourceLine 1224
    final LABQNT$ RADDX=new LABQNT$(this,1,"RADDX"); // Local Label #1=RADDX
    // Declare locals as attributes
    // JavaLine 17 <== SourceLine 1036
    int xtype=0;
    int t2=0;
    int opr=0;
    int c=0;
    int hilo=0;
    // JavaLine 23 <== SourceLine 1037
    Common$record r=null;
    Linkage$ dentry=null;
    // JavaLine 26 <== SourceLine 1038
    Common$quant q=null;
    // JavaLine 28 <== SourceLine 1039
    int rid=0;
    int n=0;
    int displx=0;
    // JavaLine 32 <== SourceLine 1059
    Common$record inspect$1059$194=null;
    // JavaLine 34 <== SourceLine 1164
    Common$quant inspect$1164$195=null;
    // JavaLine 36 <== SourceLine 1166
    Common$TypeNotice inspect$1165$196=null;
    // JavaLine 38 <== SourceLine 1180
    Common$quant inspect$1179$197=null;
    // JavaLine 40 <== SourceLine 1189
    Common$quant inspect$1188$198=null;
    // JavaLine 42 <== SourceLine 1200
    Common$quant inspect$1200$199=null;
    // JavaLine 44 <== SourceLine 1224
    Common$routine inspect$1224$200=null;
    // JavaLine 46 <== SourceLine 1230
    Common$peculiar inspect$1230$201=null;
    // JavaLine 48 <== SourceLine 1245
    Common$structured_const inspect$1245$202=null;
    // JavaLine 50 <== SourceLine 1281
    Common$TypeNotice inspect$1281$203=null;
    // JavaLine 52 <== SourceLine 1294
    Common$TypeNotice inspect$1294$204=null;
    // JavaLine 54 <== SourceLine 1356
    PrintFile$ inspect$1355$205=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$expression setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$expression.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$b=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$expression(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$expression(RTObject$ SL$,int sp$b) {
        super(SL$);
        // Parameter assignment to locals
        this.p$b = sp$b;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$expression STM$() {
        Pass2$CompoundStatement21$SubBlock23$expression THIS$=(Pass2$CompoundStatement21$SubBlock23$expression)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 87 <== SourceLine 1041
                switch(p$b) { // BEGIN SWITCH STATEMENT
                case 127: 
                // JavaLine 90 <== SourceLine 1043
                new Pass2$CompoundStatement21$SubBlock23$out_S_line(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)));
                break;
                case 176: 
                // JavaLine 94 <== SourceLine 1046
                xtype=new Pass2$CompoundStatement21$SubBlock23$invariable(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),false).RESULT$;
                break;
                case 175: 
                // JavaLine 98 <== SourceLine 1049
                {
                    t2=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                    ;
                    xtype=new InptFile$inbyt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                    ;
                    // JavaLine 104 <== SourceLine 1050
                    if(VALUE$((t2!=(xtype)))) {
                        new Pass2$CompoundStatement21$SubBlock23$convert(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),t2,xtype);
                    }
                }
                break;
                case 133: 
                // JavaLine 111 <== SourceLine 1053
                {
                    hilo=new InptFile$in2byt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                    ;
                    // JavaLine 115 <== SourceLine 1054
                    t2=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                    ;
                    // JavaLine 118 <== SourceLine 1055
                    if(VALUE$((t2!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_INT$1)))) {
                        new Pass2$CompoundStatement21$SubBlock23$convert(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),t2,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_INT$1);
                    }
                    ;
                    // JavaLine 123 <== SourceLine 1056
                    dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[hilo-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                    ;
                    // JavaLine 126 <== SourceLine 1057
                    if(VALUE$((!(IS$(dentry,Common$record.class))))) {
                        // JavaLine 128 <== SourceLine 1058
                        dentry=new Pass2$CompoundStatement21$SubBlock23$get_rec(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),hilo).RESULT$;
                    }
                    ;
                    // JavaLine 132 <== SourceLine 1059
                    {
                        // BEGIN INSPECTION 
                        inspect$1059$194=((Common$record)(dentry));
                        if(inspect$1059$194!=null) // INSPECT inspect$1059$194
                        // JavaLine 137 <== SourceLine 1060
                        {
                            if(VALUE$((!(inspect$1059$194.indefinite$3)))) {
                                // JavaLine 140 <== SourceLine 1061
                                new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Illegal record in size(r:x)"));
                            }
                            ;
                            // JavaLine 144 <== SourceLine 1062
                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_DSIZE$1);
                            ;
                            new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$1059$194.tag$2);
                            ;
                        }
                    }
                    ;
                    // JavaLine 152 <== SourceLine 1064
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                    }
                    ;
                    // JavaLine 157 <== SourceLine 1065
                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_SIZE$1;
                    ;
                }
                break;
                case 209: 
                // JavaLine 163 <== SourceLine 1068
                {
                    c=new Pass2$CompoundStatement21$SubBlock23$condition(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                    ;
                    // JavaLine 167 <== SourceLine 1069
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_IF$1);
                    ;
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).condinstr.Elt[c-((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).condinstr.LB[0]]);
                    ;
                    // JavaLine 172 <== SourceLine 1070
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                    }
                    ;
                    // JavaLine 177 <== SourceLine 1071
                    xtype=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                    ;
                    // JavaLine 180 <== SourceLine 1072
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ELSE$1);
                    ;
                    // JavaLine 183 <== SourceLine 1073
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                    }
                    ;
                    // JavaLine 188 <== SourceLine 1074
                    t2=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                    ;
                    // JavaLine 191 <== SourceLine 1075
                    if(VALUE$((xtype!=(t2)))) {
                        new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),xtype,t2);
                    }
                    ;
                    // JavaLine 196 <== SourceLine 1076
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ENDIF$1);
                    ;
                    // JavaLine 199 <== SourceLine 1077
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                    }
                    ;
                }
                break;
                case 210: 
                // JavaLine 207 <== SourceLine 1081
                {
                    n=new InptFile$innumber(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                    ;
                    // JavaLine 211 <== SourceLine 1082
                    if(VALUE$((n>(1)))) {
                        // JavaLine 213 <== SourceLine 1083
                        {
                            new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Repeated expression out of context"));
                            ;
                            n=Math.subtractExact(n,1);
                            while((n>(0))) {
                                // JavaLine 219 <== SourceLine 1085
                                {
                                    new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$);
                                    ;
                                    // JavaLine 223 <== SourceLine 1086
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_POP$1);
                                    ;
                                    // JavaLine 226 <== SourceLine 1087
                                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                    }
                                    ;
                                }
                                n=Math.subtractExact(n,1);
                            }
                            ;
                        }
                    }
                    ;
                    // JavaLine 238 <== SourceLine 1090
                    xtype=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                    ;
                }
                break;
                case 13: 
                // JavaLine 244 <== SourceLine 1094
                {
                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_INT$1;
                    ;
                    // JavaLine 248 <== SourceLine 1095
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                    ;
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_INT$1);
                    ;
                    // JavaLine 253 <== SourceLine 1096
                    ((Pass2)(CUR$.SL$.SL$)).inspect$20$141.tempt$1=new InptFile$instring(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                    ;
                    new OuptFile$outstring(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.tempt$1);
                }
                break;
                case 15: 
                // JavaLine 260 <== SourceLine 1099
                {
                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REAL$1;
                    ;
                    // JavaLine 264 <== SourceLine 1100
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                    ;
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_REAL$1);
                    ;
                    // JavaLine 269 <== SourceLine 1101
                    ((Pass2)(CUR$.SL$.SL$)).inspect$20$141.tempt$1=new InptFile$instring(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                    ;
                    new OuptFile$outstring(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.tempt$1);
                }
                break;
                case 16: 
                // JavaLine 276 <== SourceLine 1104
                {
                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_LREAL$1;
                    ;
                    // JavaLine 280 <== SourceLine 1105
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                    ;
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_LREAL$1);
                    ;
                    // JavaLine 285 <== SourceLine 1106
                    ((Pass2)(CUR$.SL$.SL$)).inspect$20$141.tempt$1=new InptFile$instring(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                    ;
                    new OuptFile$outstring(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.tempt$1);
                }
                break;
                case 12: 
                // JavaLine 292 <== SourceLine 1109
                {
                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_CHAR$1;
                    ;
                    // JavaLine 296 <== SourceLine 1110
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                    ;
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_CHAR$1);
                    ;
                    // JavaLine 301 <== SourceLine 1111
                    new OuptFile$outbyt(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,new InptFile$inbyt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$);
                    ;
                }
                break;
                case 11: 
                // JavaLine 307 <== SourceLine 1114
                {
                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_CHAR$1;
                    ;
                    // JavaLine 311 <== SourceLine 1115
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                    ;
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_TEXT$1);
                    ;
                    // JavaLine 316 <== SourceLine 1116
                    ((Pass2)(CUR$.SL$.SL$)).inspect$20$141.tempt$1=new InptFile$inlongstring(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                    ;
                    new OuptFile$outlongstring(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.tempt$1);
                }
                break;
                case 28: 
                // JavaLine 323 <== SourceLine 1119
                {
                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_BOOL$1;
                    ;
                    // JavaLine 327 <== SourceLine 1120
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                    ;
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_TRUE$1);
                    ;
                }
                break;
                case 29: 
                // JavaLine 335 <== SourceLine 1123
                {
                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_BOOL$1;
                    ;
                    // JavaLine 339 <== SourceLine 1124
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                    ;
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_FALSE$1);
                    ;
                }
                break;
                case 25: 
                // JavaLine 347 <== SourceLine 1127
                {
                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REF$1;
                    ;
                    // JavaLine 351 <== SourceLine 1128
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                    ;
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ONONE$1);
                    ;
                }
                break;
                case 24: 
                // JavaLine 359 <== SourceLine 1131
                {
                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_FIELD$1;
                    ;
                    // JavaLine 363 <== SourceLine 1132
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                    ;
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ANONE$1);
                    ;
                }
                break;
                case 26: 
                // JavaLine 371 <== SourceLine 1135
                {
                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_NAME$1;
                    ;
                    // JavaLine 375 <== SourceLine 1136
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                    ;
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_GNONE$1);
                    ;
                }
                break;
                case 139: 
                // JavaLine 383 <== SourceLine 1139
                {
                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_SIZE$1;
                    ;
                    // JavaLine 387 <== SourceLine 1140
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                    ;
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_NOSIZE$1);
                    ;
                }
                break;
                case 27: 
                // JavaLine 395 <== SourceLine 1143
                {
                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_LABEL$1;
                    ;
                    // JavaLine 399 <== SourceLine 1144
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                    ;
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_NOWHERE$1);
                    ;
                }
                break;
                case 23: 
                // JavaLine 407 <== SourceLine 1147
                {
                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_ENT$1;
                    ;
                    // JavaLine 411 <== SourceLine 1148
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                    ;
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_NOBODY$1);
                    ;
                }
                break;
                case 14: 
                // JavaLine 419 <== SourceLine 1151
                {
                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_SIZE$1;
                    ;
                    // JavaLine 423 <== SourceLine 1152
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                    ;
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_SIZE$1);
                    ;
                    // JavaLine 428 <== SourceLine 1153
                    hilo=new InptFile$in2byt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                    ;
                    // JavaLine 431 <== SourceLine 1154
                    dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[hilo-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                    ;
                    // JavaLine 434 <== SourceLine 1155
                    if(VALUE$((!(IS$(dentry,Common$record.class))))) {
                        // JavaLine 436 <== SourceLine 1156
                        dentry=new Pass2$CompoundStatement21$SubBlock23$get_rec(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),hilo).RESULT$;
                    }
                    ;
                    // JavaLine 440 <== SourceLine 1157
                    new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$record)(dentry)).tag$2);
                    ;
                }
                break;
                case 18: 
                // JavaLine 446 <== SourceLine 1160
                {
                    hilo=new InptFile$in2byt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                    ;
                    // JavaLine 450 <== SourceLine 1161
                    dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[hilo-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                    ;
                    // JavaLine 453 <== SourceLine 1162
                    if(VALUE$(IS$(dentry,Common$quant.class))) {
                        q=((Common$quant)(dentry));
                    } else
                    // JavaLine 457 <== SourceLine 1163
                    q=new Pass2$CompoundStatement21$SubBlock23$get_qnt(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),hilo).RESULT$;
                    ;
                    // JavaLine 460 <== SourceLine 1164
                    {
                        // BEGIN INSPECTION 
                        inspect$1164$195=q;
                        if(inspect$1164$195!=null) // INSPECT inspect$1164$195
                        // JavaLine 465 <== SourceLine 1165
                        {
                            {
                                // BEGIN INSPECTION 
                                inspect$1165$196=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[inspect$1164$195.p3$type-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]];
                                if(inspect$1165$196!=null) // INSPECT inspect$1165$196
                                // JavaLine 471 <== SourceLine 1166
                                xtype=new Common$defType(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.refTypes$1,inspect$1165$196.p2$qual,0,0).RESULT$;
                            }
                            ;
                            // JavaLine 475 <== SourceLine 1167
                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                            ;
                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_OADDR$1);
                            ;
                            // JavaLine 480 <== SourceLine 1168
                            new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$1164$195.tag$2);
                            ;
                        }
                    }
                }
                break;
                case 17: 
                // JavaLine 488 <== SourceLine 1172
                {
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                    ;
                    // JavaLine 492 <== SourceLine 1173
                    hilo=new InptFile$in2byt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                    ;
                    // JavaLine 495 <== SourceLine 1174
                    n=new InptFile$innumber(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                    ;
                    n=Math.subtractExact(n,1);
                    while((n>(0))) {
                        // JavaLine 500 <== SourceLine 1176
                        {
                            dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[hilo-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                            ;
                            // JavaLine 504 <== SourceLine 1177
                            if(VALUE$((!(IS$(dentry,Common$record.class))))) {
                                // JavaLine 506 <== SourceLine 1178
                                dentry=new Pass2$CompoundStatement21$SubBlock23$get_rec(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),hilo).RESULT$;
                            }
                            ;
                            // JavaLine 510 <== SourceLine 1179
                            {
                                // BEGIN INSPECTION 
                                inspect$1179$197=new Common$rec_atr(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$record)(dentry)),new InptFile$in2byt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                                if(inspect$1179$197!=null) // INSPECT inspect$1179$197
                                // JavaLine 515 <== SourceLine 1181
                                {
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_DOT$1);
                                    ;
                                    new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$1179$197.tag$2);
                                    ;
                                    // JavaLine 521 <== SourceLine 1182
                                    hilo=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[inspect$1179$197.p3$type-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$qual;
                                    ;
                                }
                            }
                            ;
                        }
                        n=Math.subtractExact(n,1);
                    }
                    ;
                    // JavaLine 531 <== SourceLine 1185
                    dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[hilo-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                    ;
                    // JavaLine 534 <== SourceLine 1186
                    if(VALUE$((!(IS$(dentry,Common$record.class))))) {
                        // JavaLine 536 <== SourceLine 1187
                        dentry=new Pass2$CompoundStatement21$SubBlock23$get_rec(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),hilo).RESULT$;
                    }
                    ;
                    // JavaLine 540 <== SourceLine 1188
                    {
                        // BEGIN INSPECTION 
                        inspect$1188$198=new Common$rec_atr(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$record)(dentry)),new InptFile$in2byt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                        if(inspect$1188$198!=null) // INSPECT inspect$1188$198
                        // JavaLine 545 <== SourceLine 1190
                        {
                            xtype=new Common$defType(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.fieldTypes$1,inspect$1188$198.p3$type,0,0).RESULT$;
                            ;
                            // JavaLine 549 <== SourceLine 1191
                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_AADDR$1);
                            ;
                            // JavaLine 552 <== SourceLine 1192
                            new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$1188$198.tag$2);
                            ;
                        }
                    }
                }
                break;
                case 19: 
                // JavaLine 560 <== SourceLine 1196
                {
                    hilo=new InptFile$in2byt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                    ;
                    // JavaLine 564 <== SourceLine 1197
                    dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[hilo-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                    ;
                    // JavaLine 567 <== SourceLine 1198
                    q=((IS$(dentry,Common$quant.class))?(((Common$quant)(dentry))):(new Pass2$CompoundStatement21$SubBlock23$get_qnt(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),hilo).RESULT$));
                    ;
                    // JavaLine 570 <== SourceLine 1200
                    {
                        // BEGIN INSPECTION 
                        inspect$1200$199=q;
                        if(inspect$1200$199!=null) // INSPECT inspect$1200$199
                        // JavaLine 575 <== SourceLine 1201
                        {
                            xtype=new Common$defType(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.nameTypes$1,inspect$1200$199.p3$type,0,0).RESULT$;
                            ;
                            // JavaLine 579 <== SourceLine 1202
                            if(VALUE$((inspect$1200$199.global$2||(inspect$1200$199.read_only$3)))) {
                                // JavaLine 581 <== SourceLine 1203
                                {
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                                    ;
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_GADDR$1);
                                    ;
                                    // JavaLine 587 <== SourceLine 1204
                                    new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$1200$199.tag$2);
                                    ;
                                }
                            } else
                            // JavaLine 592 <== SourceLine 1206
                            {
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSH$1);
                                ;
                                new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$1200$199.tag$2);
                                ;
                                // JavaLine 598 <== SourceLine 1207
                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                }
                                ;
                                // JavaLine 603 <== SourceLine 1208
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_DEREF$1);
                                ;
                            }
                            ;
                        }
                    }
                    ;
                }
                break;
                case 20: 
                // JavaLine 614 <== SourceLine 1212
                {
                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_LABEL$1;
                    ;
                    // JavaLine 618 <== SourceLine 1213
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                    ;
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_PADDR$1);
                    ;
                    // JavaLine 623 <== SourceLine 1214
                    hilo=new InptFile$in2byt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                    ;
                    // JavaLine 626 <== SourceLine 1215
                    dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[hilo-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                    ;
                    // JavaLine 629 <== SourceLine 1216
                    if(VALUE$((!(IS$(dentry,Common$label_descr.class))))) {
                        // JavaLine 631 <== SourceLine 1217
                        dentry=new Pass2$CompoundStatement21$SubBlock23$get_lab(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),hilo).RESULT$;
                    }
                    ;
                    // JavaLine 635 <== SourceLine 1218
                    new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Common$label_descr)(dentry)).tag$2);
                    ;
                }
                break;
                case 22: 
                // JavaLine 641 <== SourceLine 1221
                {
                    hilo=new InptFile$in2byt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                    ;
                    // JavaLine 645 <== SourceLine 1222
                    dentry=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.Elt[hilo-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.symtab.LB[0]].curmeaning;
                    ;
                    // JavaLine 648 <== SourceLine 1223
                    if(VALUE$(IS$(dentry,Common$routine.class))) {
                        // JavaLine 650 <== SourceLine 1224
                        {
                            // JavaLine 652 <== SourceLine 1229
                            LABEL$(1,"RADDX");
                            // JavaLine 654 <== SourceLine 1224
                            {
                                // BEGIN INSPECTION 
                                inspect$1224$200=((Common$routine)(dentry));
                                if(inspect$1224$200!=null) // INSPECT inspect$1224$200
                                // JavaLine 659 <== SourceLine 1225
                                {
                                    xtype=new Common$defType(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.entTypes$1,inspect$1224$200.profbox$3.id,0,0).RESULT$;
                                    ;
                                    // JavaLine 663 <== SourceLine 1226
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                                    ;
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_RADDR$1);
                                    ;
                                    // JavaLine 668 <== SourceLine 1227
                                    new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$1224$200.tag$2);
                                    ;
                                }
                            }
                        }
                    } else
                    // JavaLine 675 <== SourceLine 1229
                    if(VALUE$(IS$(dentry,Common$peculiar.class))) {
                        // JavaLine 677 <== SourceLine 1230
                        {
                            {
                                // BEGIN INSPECTION 
                                inspect$1230$201=((Common$peculiar)(dentry));
                                if(inspect$1230$201!=null) // INSPECT inspect$1230$201
                                // JavaLine 683 <== SourceLine 1231
                                {
                                    if(VALUE$((inspect$1230$201.p4$kind!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ROUTINE$1)))) {
                                        // JavaLine 686 <== SourceLine 1232
                                        new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("entry(x) -- x is a peculiar routine"));
                                    }
                                    ;
                                    // JavaLine 690 <== SourceLine 1233
                                    xtype=new Common$defType(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.entTypes$1,inspect$1230$201.symb$2.id,0,0).RESULT$;
                                    ;
                                    // JavaLine 693 <== SourceLine 1234
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                                    ;
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_C_RADDR$1);
                                    ;
                                    // JavaLine 698 <== SourceLine 1235
                                    new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$1230$201.body$4);
                                    ;
                                }
                            }
                        }
                    } else
                    // JavaLine 705 <== SourceLine 1237
                    {
                        dentry=new Pass2$CompoundStatement21$SubBlock23$get_ent(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),hilo).RESULT$;
                        ;
                        // JavaLine 709 <== SourceLine 1238
                        GOTO$(RADDX); // GOTO EVALUATED LABEL
                    }
                    ;
                }
                break;
                case 10: 
                // JavaLine 716 <== SourceLine 1242
                {
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_PUSHC$1);
                    ;
                    // JavaLine 720 <== SourceLine 1243
                    hilo=new InptFile$in2byt(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$;
                    ;
                    // JavaLine 723 <== SourceLine 1244
                    xtype=new Common$defType(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.structTypes$1,hilo,0,0).RESULT$;
                    ;
                    // JavaLine 726 <== SourceLine 1245
                    {
                        // BEGIN INSPECTION 
                        inspect$1245$202=((Common$structured_const)(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.structset$1.first()));
                        if(inspect$1245$202!=null) // INSPECT inspect$1245$202
                        // JavaLine 731 <== SourceLine 1246
                        {
                            if(VALUE$((inspect$1245$202.str$4!=(hilo)))) {
                                new Common$IERR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141);
                            }
                            ;
                            // JavaLine 737 <== SourceLine 1247
                            inspect$1245$202.out();
                            ;
                            new Pass2$CompoundStatement21$SubBlock23$outconst(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$structured_const)inspect$1245$202));
                            ;
                        }
                    }
                    ;
                }
                break;
                case 166: 
                // JavaLine 748 <== SourceLine 1251
                {
                    if(VALUE$((new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_VAR$1)))) {
                        new Common$IERR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141);
                    }
                    ;
                    // JavaLine 754 <== SourceLine 1252
                    rid=new Pass2$CompoundStatement21$SubBlock23$invariable(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),true).RESULT$;
                    ;
                    // JavaLine 757 <== SourceLine 1253
                    xtype=new Common$defType(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.nameTypes$1,rid,0,0).RESULT$;
                    ;
                    // JavaLine 760 <== SourceLine 1254
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_DEREF$1);
                    ;
                }
                break;
                case 109: 
                // JavaLine 766 <== SourceLine 1257
                {
                    xtype=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                    ;
                    // JavaLine 770 <== SourceLine 1258
                    if(VALUE$(((!(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.SportOk$1))&&((xtype!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_BOOL$1)))))) {
                        // JavaLine 772 <== SourceLine 1259
                        {
                            new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),xtype,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_BOOL$1);
                            ;
                            xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_BOOL$1;
                            ;
                        }
                    }
                    ;
                    // JavaLine 781 <== SourceLine 1260
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_NOT$1);
                }
                break;
                case 103: 
                // JavaLine 786 <== SourceLine 1263
                {
                    xtype=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                    ;
                    // JavaLine 790 <== SourceLine 1264
                    xtype=new Pass2$CompoundStatement21$SubBlock23$arith_type(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),xtype).RESULT$;
                    ;
                    // JavaLine 793 <== SourceLine 1265
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_NEG$1);
                }
                break;
                case 104: 
                case 105: 
                case 106: 
                // JavaLine 800 <== SourceLine 1268
                {
                    xtype=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                    ;
                    // JavaLine 804 <== SourceLine 1269
                    t2=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                    ;
                    // JavaLine 807 <== SourceLine 1270
                    if(VALUE$(((!(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.SportOk$1))||((xtype!=(t2)))))) {
                        // JavaLine 809 <== SourceLine 1271
                        {
                            if(VALUE$((xtype!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_BOOL$1)))) {
                                new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),xtype,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_BOOL$1);
                            }
                            ;
                            // JavaLine 815 <== SourceLine 1272
                            if(VALUE$((t2!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_BOOL$1)))) {
                                new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),t2,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_BOOL$1);
                            }
                            ;
                            // JavaLine 820 <== SourceLine 1273
                            xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_BOOL$1;
                            ;
                        }
                    }
                    ;
                    // JavaLine 826 <== SourceLine 1275
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,p$b);
                    ;
                }
                break;
                case 98: 
                // JavaLine 832 <== SourceLine 1278
                {
                    xtype=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                    ;
                    // JavaLine 836 <== SourceLine 1279
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[xtype-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.refTypes$1)))) {
                        // JavaLine 838 <== SourceLine 1280
                        {
                            t2=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                            ;
                            // JavaLine 842 <== SourceLine 1281
                            {
                                // BEGIN INSPECTION 
                                inspect$1281$203=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[t2-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]];
                                if(inspect$1281$203!=null) // INSPECT inspect$1281$203
                                // JavaLine 847 <== SourceLine 1282
                                {
                                    if(VALUE$((inspect$1281$203.p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.fieldTypes$1)))) {
                                        // JavaLine 850 <== SourceLine 1283
                                        {
                                            xtype=new Common$defType(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.nameTypes$1,inspect$1281$203.p2$qual,0,0).RESULT$;
                                            ;
                                            // JavaLine 854 <== SourceLine 1284
                                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_LOCATE$1);
                                            ;
                                        }
                                    } else
                                    // JavaLine 859 <== SourceLine 1287
                                    {
                                        if(VALUE$((t2!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_SIZE$1)))) {
                                            new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),t2,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_SIZE$1);
                                        }
                                        ;
                                        // JavaLine 865 <== SourceLine 1288
                                        xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REF$1;
                                        ;
                                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_INCO$1);
                                        ;
                                    }
                                    ;
                                }
                            }
                        }
                    } else
                    // JavaLine 876 <== SourceLine 1292
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[xtype-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.nameTypes$1)))) {
                        // JavaLine 878 <== SourceLine 1293
                        {
                            t2=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                            ;
                            // JavaLine 882 <== SourceLine 1294
                            {
                                // BEGIN INSPECTION 
                                inspect$1294$204=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[t2-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]];
                                if(inspect$1294$204!=null) // INSPECT inspect$1294$204
                                // JavaLine 887 <== SourceLine 1295
                                {
                                    if(VALUE$((inspect$1294$204.p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.fieldTypes$1)))) {
                                        // JavaLine 890 <== SourceLine 1296
                                        {
                                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_LOCATE$1);
                                            ;
                                            // JavaLine 894 <== SourceLine 1297
                                            if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                                new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                            }
                                            ;
                                            // JavaLine 899 <== SourceLine 1298
                                            xtype=new Common$defType(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.nameTypes$1,inspect$1294$204.p2$qual,0,0).RESULT$;
                                            ;
                                        }
                                    } else
                                    // JavaLine 904 <== SourceLine 1299
                                    new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Illegal type after +"));
                                    ;
                                }
                            }
                        }
                    } else
                    // JavaLine 911 <== SourceLine 1303
                    {
                        xtype=new Pass2$CompoundStatement21$SubBlock23$arith_type(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),xtype).RESULT$;
                        ;
                        t2=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                        ;
                        // JavaLine 917 <== SourceLine 1304
                        if(VALUE$((t2!=(xtype)))) {
                            new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),t2,xtype);
                        }
                        ;
                        // JavaLine 922 <== SourceLine 1305
                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_ADD$1);
                        ;
                    }
                    ;
                }
                break;
                case 99: 
                // JavaLine 930 <== SourceLine 1309
                {
                    xtype=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                    ;
                    // JavaLine 934 <== SourceLine 1310
                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[xtype-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.refTypes$1)))) {
                        // JavaLine 936 <== SourceLine 1311
                        {
                            t2=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                            ;
                            // JavaLine 940 <== SourceLine 1312
                            if(VALUE$((t2==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_SIZE$1)))) {
                                // JavaLine 942 <== SourceLine 1313
                                {
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_DECO$1);
                                    ;
                                    // JavaLine 946 <== SourceLine 1314
                                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                    }
                                    ;
                                    // JavaLine 951 <== SourceLine 1315
                                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_REF$1;
                                }
                            } else
                            // JavaLine 955 <== SourceLine 1316
                            if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.Elt[t2-((Pass2)(CUR$.SL$.SL$)).inspect$20$141.typeTable.LB[0]].p2$set==(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.refTypes$1)))) {
                                // JavaLine 957 <== SourceLine 1317
                                {
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_DIST$1);
                                    ;
                                    // JavaLine 961 <== SourceLine 1318
                                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                    }
                                    ;
                                    // JavaLine 966 <== SourceLine 1319
                                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_SIZE$1;
                                }
                            } else
                            // JavaLine 970 <== SourceLine 1320
                            new Common$ERROR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,new TXT$("Illegal type following -"));
                            ;
                        }
                    } else
                    // JavaLine 975 <== SourceLine 1323
                    {
                        xtype=new Pass2$CompoundStatement21$SubBlock23$arith_type(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),xtype).RESULT$;
                        ;
                        t2=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                        ;
                        // JavaLine 981 <== SourceLine 1324
                        if(VALUE$((t2!=(xtype)))) {
                            new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),t2,xtype);
                        }
                        ;
                        // JavaLine 986 <== SourceLine 1325
                        new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_SUB$1);
                        ;
                    }
                    ;
                }
                break;
                case 100: 
                case 101: 
                case 2: 
                case 66: 
                case 5: 
                case 129: 
                // JavaLine 999 <== SourceLine 1330
                {
                    t2=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                    ;
                    xtype=new Pass2$CompoundStatement21$SubBlock23$arith_type(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),t2).RESULT$;
                    ;
                    // JavaLine 1005 <== SourceLine 1331
                    t2=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                    ;
                    // JavaLine 1008 <== SourceLine 1332
                    if(VALUE$((t2!=(xtype)))) {
                        new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),t2,xtype);
                    }
                    ;
                    // JavaLine 1013 <== SourceLine 1333
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,p$b);
                    ;
                }
                break;
                case 102: 
                // JavaLine 1019 <== SourceLine 1337
                {
                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_INT$1;
                    ;
                    // JavaLine 1023 <== SourceLine 1338
                    t2=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                    ;
                    // JavaLine 1026 <== SourceLine 1339
                    if(VALUE$((t2!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_INT$1)))) {
                        new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),t2,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_INT$1);
                    }
                    ;
                    // JavaLine 1031 <== SourceLine 1340
                    t2=new Pass2$CompoundStatement21$SubBlock23$expression(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),new InptFile$ininstr(((Pass2)(CUR$.SL$.SL$)).inspect$20$142).RESULT$).RESULT$;
                    ;
                    // JavaLine 1034 <== SourceLine 1341
                    if(VALUE$((t2!=(((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_INT$1)))) {
                        new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),t2,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_INT$1);
                    }
                    ;
                    // JavaLine 1039 <== SourceLine 1342
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_REM$1);
                    ;
                }
                break;
                default:
                // JavaLine 1045 <== SourceLine 1345
                {
                    opr=new Pass2$CompoundStatement21$SubBlock23$relation(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),p$b).RESULT$;
                    ;
                    // JavaLine 1049 <== SourceLine 1346
                    if(VALUE$(((opr==(0))|((opr==(10)))))) {
                        new Common$IERR(((Pass2)(CUR$.SL$.SL$)).inspect$20$141);
                    }
                    ;
                    // JavaLine 1054 <== SourceLine 1347
                    xtype=((Pass2)(CUR$.SL$.SL$)).inspect$20$141.T_BOOL$1;
                    ;
                    new Pass2$CompoundStatement21$SubBlock23$condition(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),p$b);
                    ;
                    // JavaLine 1059 <== SourceLine 1348
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_COMPARE$1);
                    ;
                    // JavaLine 1062 <== SourceLine 1349
                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).condinstr.Elt[opr-((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).condinstr.LB[0]]);
                    ;
                }
                break;
            } // END SWITCH STATEMENT
            ;
            // JavaLine 1069 <== SourceLine 1353
            if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
            }
            ;
            // JavaLine 1074 <== SourceLine 1354
            RESULT$=xtype;
            ;
            // JavaLine 1077 <== SourceLine 1355
            if(VALUE$((((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)).tracemode>(2)))) {
                {
                    {
                        // BEGIN INSPECTION 
                        inspect$1355$205=sysout();
                        if(inspect$1355$205!=null) // INSPECT inspect$1355$205
                        // JavaLine 1084 <== SourceLine 1356
                        inspect$1355$205.setpos(20);
                    }
                    ;
                    ((Pass2)(CUR$.SL$.SL$)).inspect$21$143.outtext(CONC(new TXT$("Expression type: "),new Common$edtype(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,xtype).RESULT$));
                    ;
                    // JavaLine 1090 <== SourceLine 1357
                    sysout().outimage();
                    ;
                }
            }
            ;
            break LOOP$;
        }
        catch(LABQNT$ q) {
            CUR$=THIS$;
            if(q.SL$!=CUR$) {
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("expression:NON-LOCAL",q);
                CUR$.STATE$=OperationalState.terminated;
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("expression:RE-THROW",q);
                throw(q);
            }
            if(RT.Option.GOTO_TRACING) TRACE_GOTO("expression:LOCAL",q);
            JTX$=q.index; continue LOOP$; // EG. GOTO Lx
        }
    }
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure expression",1,1035,14,1224,17,1036,23,1037,26,1038,28,1039,32,1059,34,1164,36,1166,38,1180,40,1189,42,1200,44,1224,46,1230,48,1245,50,1281,52,1294,54,1356,87,1041,90,1043,94,1046,98,1049,104,1050,111,1053,115,1054,118,1055,123,1056,126,1057,128,1058,132,1059,137,1060,140,1061,144,1062,152,1064,157,1065,163,1068,167,1069,172,1070,177,1071,180,1072,183,1073,188,1074,191,1075,196,1076,199,1077,207,1081,211,1082,213,1083,219,1085,223,1086,226,1087,238,1090,244,1094,248,1095,253,1096,260,1099,264,1100,269,1101,276,1104,280,1105,285,1106,292,1109,296,1110,301,1111,307,1114,311,1115,316,1116,323,1119,327,1120,335,1123,339,1124,347,1127,351,1128,359,1131,363,1132,371,1135,375,1136,383,1139,387,1140,395,1143,399,1144,407,1147,411,1148,419,1151,423,1152,428,1153,431,1154,434,1155,436,1156,440,1157,446,1160,450,1161,453,1162,457,1163,460,1164,465,1165,471,1166,475,1167,480,1168,488,1172,492,1173,495,1174,500,1176,504,1177,506,1178,510,1179,515,1181,521,1182,531,1185,534,1186,536,1187,540,1188,545,1190,549,1191,552,1192,560,1196,564,1197,567,1198,570,1200,575,1201,579,1202,581,1203,587,1204,592,1206,598,1207,603,1208,614,1212,618,1213,623,1214,626,1215,629,1216,631,1217,635,1218,641,1221,645,1222,648,1223,650,1224,652,1229,654,1224,659,1225,663,1226,668,1227,675,1229,677,1230,683,1231,686,1232,690,1233,693,1234,698,1235,705,1237,709,1238,716,1242,720,1243,723,1244,726,1245,731,1246,737,1247,748,1251,754,1252,757,1253,760,1254,766,1257,770,1258,772,1259,781,1260,786,1263,790,1264,793,1265,800,1268,804,1269,807,1270,809,1271,815,1272,820,1273,826,1275,832,1278,836,1279,838,1280,842,1281,847,1282,850,1283,854,1284,859,1287,865,1288,876,1292,878,1293,882,1294,887,1295,890,1296,894,1297,899,1298,904,1299,911,1303,917,1304,922,1305,930,1309,934,1310,936,1311,940,1312,942,1313,946,1314,951,1315,955,1316,957,1317,961,1318,966,1319,970,1320,975,1323,981,1324,986,1325,999,1330,1005,1331,1008,1332,1013,1333,1019,1337,1023,1338,1026,1339,1031,1340,1034,1341,1039,1342,1045,1345,1049,1346,1054,1347,1059,1348,1062,1349,1069,1353,1074,1354,1077,1355,1084,1356,1090,1357,1112,1359);
} // End of Procedure
