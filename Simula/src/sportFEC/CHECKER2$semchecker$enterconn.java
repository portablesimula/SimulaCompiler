// JavaLine 1 ==> SourceLine 94
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:52:33 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER2$semchecker$enterconn extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=94, lastLine=200, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$quantity p$classq;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 108
    final LABQNT$ BADBLOCK=new LABQNT$(this,0,1); // Local Label #1=BADBLOCK
    // JavaLine 14 ==> SourceLine 121
    final LABQNT$ REP=new LABQNT$(this,0,2); // Local Label #2=REP
    // JavaLine 16 ==> SourceLine 122
    final LABQNT$ REP1=new LABQNT$(this,0,3); // Local Label #3=REP1
    // JavaLine 18 ==> SourceLine 152
    final LABQNT$ SCANL=new LABQNT$(this,0,4); // Local Label #4=SCANL
    // JavaLine 20 ==> SourceLine 200
    final LABQNT$ copyleave=new LABQNT$(this,0,5); // Local Label #5=copyleave
    // Declare locals as attributes
    // JavaLine 23 ==> SourceLine 95
    boolean inlocals=false;
    COMMON$stackedi chain=null;
    // JavaLine 26 ==> SourceLine 98
    COMMON$quantity qz=null;
    COMMON$quantity q=null;
    COMMON$brecord brc=null;
    // JavaLine 30 ==> SourceLine 118
    COMMON$brecord inspect$118$1=null;
    // JavaLine 32 ==> SourceLine 142
    COMMON$brecord inspect$142$2=null;
    // JavaLine 34 ==> SourceLine 154
    COMMON$identsymbol inspect$154$3=null;
    // JavaLine 36 ==> SourceLine 155
    COMMON$stackedi inspect$155$4=null;
    // JavaLine 38 ==> SourceLine 172
    COMMON$identsymbol inspect$172$5=null;
    // JavaLine 40 ==> SourceLine 184
    COMMON$stackedi inspect$184$6=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public CHECKER2$semchecker$enterconn setPar(Object param) {
        //Util.BREAK("CALL CHECKER2$semchecker$enterconn.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$classq=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public CHECKER2$semchecker$enterconn(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public CHECKER2$semchecker$enterconn(RTObject$ SL$,COMMON$quantity sp$classq) {
        super(SL$);
        // Parameter assignment to locals
        this.p$classq = sp$classq;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("enterconn",184);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER2$semchecker$enterconn STM$() {
        TRACE_BEGIN_STM$("enterconn",184);
        CHECKER2$semchecker$enterconn THIS$=(CHECKER2$semchecker$enterconn)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 75 ==> SourceLine 101
                ((CHECKER2)(CUR$.SL$.SL$)).cblev=char$((rank(((CHECKER2)(CUR$.SL$.SL$)).cblev)+(1)));
                // JavaLine 77 ==> SourceLine 103
                if(VALUE$((rank(((CHECKER2)(CUR$.SL$.SL$)).cblev)>(((CHECKER2)(CUR$.SL$.SL$)).maxblev)))) {
                    new ERRMSG$fatal0(((CHECKER2)(CUR$.SL$.SL$)),299);
                }
                // JavaLine 81 ==> SourceLine 104
                if(VALUE$((p$classq==(null)))) {
                    // JavaLine 83 ==> SourceLine 108
                    {
                        TRACE_BEGIN_STM$("CompoundStatement108",108);
                        LABEL$(1,"BADBLOCK");
                        brc=new COMMON$brecord(((CHECKER2)(CUR$.SL$.SL$))).STM$();
                        // JavaLine 88 ==> SourceLine 109
                        brc.blev=((CHECKER2)(CUR$.SL$.SL$)).cblev;
                        brc.rtblev=((CHECKER2)(CUR$.SL$.SL$)).crtblev;
                        // JavaLine 91 ==> SourceLine 110
                        qz=new COMMON$quantity(((CHECKER2)(CUR$.SL$.SL$))).STM$();
                        qz.plev=((CHECKER2)(CUR$.SL$.SL$)).one;
                        // JavaLine 94 ==> SourceLine 111
                        qz.kind=brc.kind=((CHECKER2)(CUR$.SL$.SL$)).K_subbl;
                        qz.categ=((CHECKER2)(CUR$.SL$.SL$)).C_block;
                        // JavaLine 97 ==> SourceLine 112
                        qz.type=((CHECKER2)(CUR$.SL$.SL$)).INOTY;
                        // JavaLine 99 ==> SourceLine 113
                        brc.declquant=qz;
                        qz.descr=brc;
                        qz.encl=((CHECKER2)(CUR$.SL$.SL$)).unknowns;
                        // JavaLine 103 ==> SourceLine 114
                        new BUILDER1$precheck0$makevisblock(((CHECKER2$semchecker)(CUR$.SL$)),brc);
                        // JavaLine 105 ==> SourceLine 116
                        GOTO$(copyleave); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement108",116);
                    }
                }
                // JavaLine 110 ==> SourceLine 118
                {
                    // BEGIN INSPECTION 
                    inspect$118$1=p$classq.descr;
                    if(inspect$118$1!=null) //INSPECT inspect$118$1
                    // JavaLine 115 ==> SourceLine 120
                    {
                        TRACE_BEGIN_STM$("CompoundStatement120",120);
                        q=inspect$118$1.declquant;
                        // JavaLine 119 ==> SourceLine 121
                        LABEL$(2,"REP");
                        qz=q.descr.fpar;
                        inlocals=true;
                        // JavaLine 123 ==> SourceLine 130
                        LABEL$(3,"REP1");
                        // JavaLine 125 ==> SourceLine 122
                        while((qz!=(null))) {
                            // JavaLine 127 ==> SourceLine 123
                            {
                                TRACE_BEGIN_STM$("CompoundStatement123",123);
                                if(VALUE$((qz.protect==(((char)1))))) {
                                    // JavaLine 131 ==> SourceLine 124
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement124",124);
                                        qz.visible=char$((rank(qz.visible)+(1)));
                                        // JavaLine 135 ==> SourceLine 125
                                        if(VALUE$((!(inlocals)))) {
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement125",125);
                                                if(VALUE$((qz.match!=(null)))) {
                                                    // JavaLine 140 ==> SourceLine 126
                                                    qz.match.visible=char$((rank(qz.match.visible)+(1)));
                                                }
                                                TRACE_END_STM$("CompoundStatement125",126);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement124",126);
                                    }
                                }
                                // JavaLine 149 ==> SourceLine 129
                                qz=((COMMON$quantity)(qz.next));
                                TRACE_END_STM$("CompoundStatement123",129);
                            }
                        }
                        // JavaLine 154 ==> SourceLine 131
                        if(VALUE$(inlocals)) {
                            // JavaLine 156 ==> SourceLine 132
                            {
                                TRACE_BEGIN_STM$("CompoundStatement132",132);
                                inlocals=false;
                                qz=q.descr.favirt;
                                GOTO$(REP1); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement132",132);
                            }
                        }
                        // JavaLine 165 ==> SourceLine 133
                        if(VALUE$((q.plev>(((CHECKER2)(CUR$.SL$.SL$)).one)))) {
                            {
                                TRACE_BEGIN_STM$("CompoundStatement133",133);
                                q=q.prefqual;
                                GOTO$(REP); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement133",133);
                            }
                        }
                        // JavaLine 174 ==> SourceLine 137
                        ((CHECKER2)(CUR$.SL$.SL$)).display.Elt[rank(((CHECKER2)(CUR$.SL$.SL$)).cblev)-((CHECKER2)(CUR$.SL$.SL$)).display.LB[0]]=((COMMON$brecord)inspect$118$1);
                        // JavaLine 176 ==> SourceLine 138
                        q=inspect$118$1.declquant;
                        // JavaLine 178 ==> SourceLine 139
                        while((q!=(null))) {
                            // JavaLine 180 ==> SourceLine 142
                            {
                                TRACE_BEGIN_STM$("CompoundStatement142",142);
                                {
                                    // BEGIN INSPECTION 
                                    inspect$142$2=q.descr;
                                    if(inspect$142$2!=null) //INSPECT inspect$142$2
                                    // JavaLine 187 ==> SourceLine 143
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement143",143);
                                        inspect$142$2.preinsp=new COMMON$stackedb(((CHECKER2)(CUR$.SL$.SL$)),inspect$142$2.blev,inspect$142$2.rtblev,inspect$142$2.connests,inspect$142$2.inspected,inspect$142$2.preinsp).STM$();
                                        // JavaLine 191 ==> SourceLine 145
                                        inspect$142$2.inspected=((CHECKER2)(CUR$.SL$.SL$)).cblev;
                                        // JavaLine 193 ==> SourceLine 146
                                        inspect$142$2.blev=((CHECKER2)(CUR$.SL$.SL$)).cblev;
                                        inspect$142$2.rtblev=((CHECKER2)(CUR$.SL$.SL$)).crtblev;
                                        TRACE_END_STM$("CompoundStatement143",146);
                                    }
                                }
                                // JavaLine 199 ==> SourceLine 148
                                q=q.prefqual;
                                TRACE_END_STM$("CompoundStatement142",148);
                            }
                        }
                        // JavaLine 204 ==> SourceLine 151
                        qz=inspect$118$1.fpar;
                        inlocals=true;
                        // JavaLine 207 ==> SourceLine 162
                        LABEL$(4,"SCANL");
                        // JavaLine 209 ==> SourceLine 152
                        while((qz!=(null))) {
                            // JavaLine 211 ==> SourceLine 153
                            {
                                TRACE_BEGIN_STM$("CompoundStatement153",153);
                                if(VALUE$((qz.visible==(((CHECKER2)(CUR$.SL$.SL$)).NUL)))) {
                                    // JavaLine 215 ==> SourceLine 154
                                    {
                                        // BEGIN INSPECTION 
                                        inspect$154$3=((COMMON$identsymbol)(qz.symb));
                                        if(inspect$154$3!=null) //INSPECT inspect$154$3
                                        // JavaLine 220 ==> SourceLine 155
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement155",155);
                                            {
                                                // BEGIN INSPECTION 
                                                inspect$155$4=new COMMON$stackedi(((CHECKER2)(CUR$.SL$.SL$)),inspect$154$3.idhi,inspect$154$3.idlo).STM$();
                                                if(inspect$155$4!=null) //INSPECT inspect$155$4
                                                // JavaLine 227 ==> SourceLine 156
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement156",156);
                                                    inspect$155$4.prevmeaning=inspect$154$3.curmeaning;
                                                    inspect$155$4.next=chain;
                                                    // JavaLine 232 ==> SourceLine 157
                                                    chain=((COMMON$stackedi)inspect$155$4);
                                                    TRACE_END_STM$("CompoundStatement156",157);
                                                }
                                            }
                                            // JavaLine 237 ==> SourceLine 159
                                            inspect$154$3.curmeaning=qz;
                                            TRACE_END_STM$("CompoundStatement155",159);
                                        }
                                    }
                                }
                                // JavaLine 243 ==> SourceLine 161
                                qz=((COMMON$quantity)(qz.next));
                                TRACE_END_STM$("CompoundStatement153",161);
                            }
                        }
                        // JavaLine 248 ==> SourceLine 163
                        if(VALUE$(inlocals)) {
                            {
                                TRACE_BEGIN_STM$("CompoundStatement163",163);
                                if(VALUE$((inspect$118$1.favirt!=(null)))) {
                                    // JavaLine 253 ==> SourceLine 164
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement164",164);
                                        qz=inspect$118$1.favirt;
                                        inlocals=false;
                                        GOTO$(SCANL); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement164",164);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement163",164);
                            }
                        }
                        // JavaLine 265 ==> SourceLine 167
                        q=inspect$118$1.declquant;
                        // JavaLine 267 ==> SourceLine 168
                        while((q.plev>(((CHECKER2$semchecker)(CUR$.SL$)).lowpl))) {
                            // JavaLine 269 ==> SourceLine 169
                            {
                                TRACE_BEGIN_STM$("CompoundStatement169",169);
                                q=q.prefqual;
                                // JavaLine 273 ==> SourceLine 170
                                qz=q.descr.fpar;
                                // JavaLine 275 ==> SourceLine 171
                                while((qz!=(null))) {
                                    // JavaLine 277 ==> SourceLine 172
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement172",172);
                                        {
                                            // BEGIN INSPECTION 
                                            inspect$172$5=((COMMON$identsymbol)(qz.symb));
                                            if(inspect$172$5!=null) //INSPECT inspect$172$5
                                            // JavaLine 284 ==> SourceLine 173
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement173",173);
                                                if(VALUE$((qz.visible==(((CHECKER2)(CUR$.SL$.SL$)).NUL)))) {
                                                    // JavaLine 288 ==> SourceLine 175
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement175",175);
                                                        if(VALUE$(((inspect$172$5.curmeaning==(null))||(((((COMMON$quantity)(inspect$172$5.curmeaning)).encl.blev!=(inspect$118$1.blev))&((((COMMON$quantity)(inspect$172$5.curmeaning)).encl!=(qz.encl)))))))) {
                                                            // JavaLine 292 ==> SourceLine 184
                                                            {
                                                                TRACE_BEGIN_STM$("CompoundStatement184",184);
                                                                {
                                                                    // BEGIN INSPECTION 
                                                                    inspect$184$6=new COMMON$stackedi(((CHECKER2)(CUR$.SL$.SL$)),inspect$172$5.idhi,inspect$172$5.idlo).STM$();
                                                                    if(inspect$184$6!=null) //INSPECT inspect$184$6
                                                                    // JavaLine 299 ==> SourceLine 185
                                                                    {
                                                                        TRACE_BEGIN_STM$("CompoundStatement185",185);
                                                                        inspect$184$6.prevmeaning=inspect$172$5.curmeaning;
                                                                        inspect$184$6.next=chain;
                                                                        // JavaLine 304 ==> SourceLine 186
                                                                        chain=((COMMON$stackedi)inspect$184$6);
                                                                        TRACE_END_STM$("CompoundStatement185",186);
                                                                    }
                                                                }
                                                                // JavaLine 309 ==> SourceLine 188
                                                                inspect$172$5.curmeaning=qz;
                                                                TRACE_END_STM$("CompoundStatement184",188);
                                                            }
                                                        }
                                                        TRACE_END_STM$("CompoundStatement175",188);
                                                    }
                                                }
                                                TRACE_END_STM$("CompoundStatement173",188);
                                            }
                                        }
                                        // JavaLine 320 ==> SourceLine 192
                                        qz=((COMMON$quantity)(qz.next));
                                        TRACE_END_STM$("CompoundStatement172",192);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement169",192);
                            }
                        }
                        // JavaLine 328 ==> SourceLine 195
                        inspect$118$1.preinsp.redeclChain=chain;
                        TRACE_END_STM$("CompoundStatement120",195);
                    }
                    else // OTHERWISE 
                    // JavaLine 333 ==> SourceLine 198
                    GOTO$(BADBLOCK); // GOTO EVALUATED LABEL
                }
                // JavaLine 336 ==> SourceLine 200
                LABEL$(5,"copyleave");
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
        TRACE_END_STM$("enterconn",200);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Procedure enterconn",1,94,12,108,14,121,16,122,18,152,20,200,23,95,26,98,30,118,32,142,34,154,36,155,38,172,40,184,75,101,77,103,81,104,83,108,88,109,91,110,94,111,97,112,99,113,103,114,105,116,110,118,115,120,119,121,123,130,125,122,127,123,131,124,135,125,140,126,149,129,154,131,156,132,165,133,174,137,176,138,178,139,180,142,187,143,191,145,193,146,199,148,204,151,207,162,209,152,211,153,215,154,220,155,227,156,232,157,237,159,243,161,248,163,253,164,265,167,267,168,269,169,273,170,275,171,277,172,284,173,288,175,292,184,299,185,304,186,309,188,320,192,328,195,333,198,336,200,354,200);
}
