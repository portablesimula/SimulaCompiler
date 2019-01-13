// JavaLine 1 ==> SourceLine 205
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:49 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER2$semchecker$leaveConn extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=205, lastLine=276, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 206
    COMMON$quantity q=null;
    COMMON$quantity qz=null;
    COMMON$stackedi chain=null;
    // JavaLine 15 ==> SourceLine 208
    int opi=0;
    int opimax=0;
    // JavaLine 18 ==> SourceLine 212
    COMMON$brecord inspect$212$111=null;
    // JavaLine 20 ==> SourceLine 216
    COMMON$brecord inspect$216$112=null;
    // JavaLine 22 ==> SourceLine 221
    COMMON$stackedb inspect$221$113=null;
    // JavaLine 24 ==> SourceLine 238
    COMMON$brecord inspect$238$114=null;
    // Normal Constructor
    public CHECKER2$semchecker$leaveConn(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("leaveConn",238);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER2$semchecker$leaveConn STM$() {
        TRACE_BEGIN_STM$("leaveConn",238);
        // JavaLine 38 ==> SourceLine 212
        {
            // BEGIN INSPECTION 
            inspect$212$111=((CHECKER2)(CUR$.SL$.SL$)).display.Elt[rank(((CHECKER2)(CUR$.SL$.SL$)).cblev)-((CHECKER2)(CUR$.SL$.SL$)).display.LB[0]];
            if(inspect$212$111!=null) //INSPECT inspect$212$111
            // JavaLine 43 ==> SourceLine 213
            {
                TRACE_BEGIN_STM$("CompoundStatement213",213);
                q=inspect$212$111.fpar;
                new BUILDER1$precheck0$invischain(((CHECKER2$semchecker)(CUR$.SL$)),q);
                // JavaLine 48 ==> SourceLine 214
                if((inspect$212$111.declquant.prefqual!=(null))) {
                    // JavaLine 50 ==> SourceLine 216
                    {
                        TRACE_BEGIN_STM$("CompoundStatement216",216);
                        {
                            // BEGIN INSPECTION 
                            inspect$216$112=inspect$212$111.declquant.prefqual.descr;
                            if(inspect$216$112!=null) //INSPECT inspect$216$112
                            // JavaLine 57 ==> SourceLine 217
                            {
                                TRACE_BEGIN_STM$("CompoundStatement217",217);
                                if((inspect$216$112.kind==(((CHECKER2)(CUR$.SL$.SL$)).K_subbl))) {
                                    // JavaLine 61 ==> SourceLine 218
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement218",218);
                                        new BUILDER1$precheck0$leaveblock(((CHECKER2$semchecker)(CUR$.SL$)));
                                        TRACE_END_STM$("CompoundStatement218",218);
                                    }
                                } else
                                // JavaLine 68 ==> SourceLine 221
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement221",221);
                                    {
                                        // BEGIN INSPECTION 
                                        inspect$221$113=inspect$216$112.preinsp;
                                        if(inspect$221$113!=null) //INSPECT inspect$221$113
                                        // JavaLine 75 ==> SourceLine 222
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement222",222);
                                            chain=inspect$221$113.redeclChain;
                                            // JavaLine 79 ==> SourceLine 223
                                            while((chain!=(null))) {
                                                // JavaLine 81 ==> SourceLine 224
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement224",224);
                                                    // JavaLine 84 ==> SourceLine 225
                                                    ((COMMON$identsymbol)(new COMMON$boxof(((CHECKER2)(CUR$.SL$.SL$)),chain.p1$rehi,chain.p1$relo).RESULT$)).curmeaning=chain.prevmeaning;
                                                    // JavaLine 86 ==> SourceLine 226
                                                    chain=((COMMON$stackedi)(chain.next));
                                                    TRACE_END_STM$("CompoundStatement224",226);
                                                }
                                            }
                                            TRACE_END_STM$("CompoundStatement222",226);
                                        }
                                    }
                                    // JavaLine 94 ==> SourceLine 229
                                    ((CHECKER2)(CUR$.SL$.SL$)).prefixchain.Elt[1-((CHECKER2)(CUR$.SL$.SL$)).prefixchain.LB[0]]=q=inspect$216$112.declquant;
                                    opimax=((CHECKER2)(CUR$.SL$.SL$)).one;
                                    // JavaLine 97 ==> SourceLine 230
                                    while((opimax<(inspect$216$112.declquant.plev))) {
                                        // JavaLine 99 ==> SourceLine 231
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement231",231);
                                            opimax=(opimax+(1));
                                            // JavaLine 103 ==> SourceLine 232
                                            ((CHECKER2)(CUR$.SL$.SL$)).prefixchain.Elt[opimax-((CHECKER2)(CUR$.SL$.SL$)).prefixchain.LB[0]]=q=q.prefqual;
                                            TRACE_END_STM$("CompoundStatement231",232);
                                        }
                                    }
                                    // JavaLine 108 ==> SourceLine 234
                                    q=inspect$216$112.declquant;
                                    // JavaLine 110 ==> SourceLine 235
                                    while((q!=(null))) {
                                        // JavaLine 112 ==> SourceLine 238
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement238",238);
                                            {
                                                // BEGIN INSPECTION 
                                                inspect$238$114=q.descr;
                                                if(inspect$238$114!=null) //INSPECT inspect$238$114
                                                if((inspect$238$114.preinsp!=(null))) {
                                                    // JavaLine 120 ==> SourceLine 239
                                                    {
                                                        TRACE_BEGIN_STM$("CompoundStatement239",239);
                                                        inspect$238$114.blev=inspect$238$114.preinsp.p$oldblev;
                                                        // JavaLine 124 ==> SourceLine 240
                                                        inspect$238$114.rtblev=inspect$238$114.preinsp.p$oldrtblev;
                                                        // JavaLine 126 ==> SourceLine 241
                                                        inspect$238$114.connests=inspect$238$114.preinsp.p$oldconnests;
                                                        // JavaLine 128 ==> SourceLine 242
                                                        inspect$238$114.inspected=inspect$238$114.preinsp.p$oldinsp;
                                                        // JavaLine 130 ==> SourceLine 243
                                                        inspect$238$114.preinsp=inspect$238$114.preinsp.p$prev;
                                                        TRACE_END_STM$("CompoundStatement239",243);
                                                    }
                                                }
                                            }
                                            // JavaLine 136 ==> SourceLine 245
                                            q=q.prefqual;
                                            TRACE_END_STM$("CompoundStatement238",245);
                                        }
                                    }
                                    // JavaLine 141 ==> SourceLine 249
                                    opi=opimax;
                                    // JavaLine 143 ==> SourceLine 250
                                    while((opi!=(((CHECKER2)(CUR$.SL$.SL$)).zero))) {
                                        // JavaLine 145 ==> SourceLine 251
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement251",251);
                                            q=((CHECKER2)(CUR$.SL$.SL$)).prefixchain.Elt[opi-((CHECKER2)(CUR$.SL$.SL$)).prefixchain.LB[0]];
                                            ((CHECKER2)(CUR$.SL$.SL$)).prefixchain.Elt[opi-((CHECKER2)(CUR$.SL$.SL$)).prefixchain.LB[0]]=null;
                                            // JavaLine 150 ==> SourceLine 252
                                            qz=q.descr.favirt;
                                            // JavaLine 152 ==> SourceLine 253
                                            while((qz!=(null))) {
                                                // JavaLine 154 ==> SourceLine 254
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement254",254);
                                                    if((qz.protect==(((char)1)))) {
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement254",254);
                                                            if((qz.visible!=(((CHECKER2)(CUR$.SL$.SL$)).NUL))) {
                                                                // JavaLine 161 ==> SourceLine 256
                                                                {
                                                                    TRACE_BEGIN_STM$("CompoundStatement256",256);
                                                                    qz.visible=char$((rank(qz.visible)-(1)));
                                                                    // JavaLine 165 ==> SourceLine 257
                                                                    if((qz.match!=(null))) {
                                                                        // JavaLine 167 ==> SourceLine 258
                                                                        qz.match.visible=char$((rank(qz.match.visible)-(1)));
                                                                    }
                                                                    TRACE_END_STM$("CompoundStatement256",258);
                                                                }
                                                            }
                                                            TRACE_END_STM$("CompoundStatement254",258);
                                                        }
                                                    }
                                                    // JavaLine 176 ==> SourceLine 261
                                                    qz=((COMMON$quantity)(qz.next));
                                                    TRACE_END_STM$("CompoundStatement254",261);
                                                }
                                            }
                                            // JavaLine 181 ==> SourceLine 263
                                            qz=q.descr.fpar;
                                            // JavaLine 183 ==> SourceLine 264
                                            while((qz!=(null))) {
                                                // JavaLine 185 ==> SourceLine 265
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement265",265);
                                                    if((qz.protect==(((char)1)))) {
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement265",265);
                                                            if((qz.visible!=(((CHECKER2)(CUR$.SL$.SL$)).NUL))) {
                                                                // JavaLine 192 ==> SourceLine 266
                                                                qz.visible=char$((rank(qz.visible)-(1)));
                                                            }
                                                            TRACE_END_STM$("CompoundStatement265",266);
                                                        }
                                                    }
                                                    // JavaLine 198 ==> SourceLine 267
                                                    qz=((COMMON$quantity)(qz.next));
                                                    TRACE_END_STM$("CompoundStatement265",267);
                                                }
                                            }
                                            // JavaLine 203 ==> SourceLine 269
                                            opi=(opi-(1));
                                            TRACE_END_STM$("CompoundStatement251",269);
                                        }
                                    }
                                    // JavaLine 208 ==> SourceLine 271
                                    ((CHECKER2)(CUR$.SL$.SL$)).display.Elt[rank(((CHECKER2)(CUR$.SL$.SL$)).cblev)-((CHECKER2)(CUR$.SL$.SL$)).display.LB[0]]=null;
                                    // JavaLine 210 ==> SourceLine 272
                                    ((CHECKER2)(CUR$.SL$.SL$)).cblev=char$((rank(((CHECKER2)(CUR$.SL$.SL$)).cblev)-(1)));
                                    TRACE_END_STM$("CompoundStatement221",272);
                                }
                                TRACE_END_STM$("CompoundStatement217",272);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement216",272);
                    }
                }
                TRACE_END_STM$("CompoundStatement213",272);
            }
        }
        TRACE_END_STM$("leaveConn",272);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER2.DEF","Procedure leaveConn",1,205,11,206,15,208,18,212,20,216,22,221,24,238,38,212,43,213,48,214,50,216,57,217,61,218,68,221,75,222,79,223,81,224,84,225,86,226,94,229,97,230,99,231,103,232,108,234,110,235,112,238,120,239,124,240,126,241,128,242,130,243,136,245,141,249,143,250,145,251,150,252,152,253,154,254,161,256,165,257,167,258,176,261,181,263,183,264,185,265,192,266,198,267,203,269,208,271,210,272,226,276);
}
