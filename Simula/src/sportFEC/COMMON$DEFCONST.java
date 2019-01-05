// JavaLine 1 ==> SourceLine 229
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:41:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$DEFCONST extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=229, lastLine=267, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 246
    final LABQNT$ F=new LABQNT$(this,0,1); // Local Label #1=F
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 230
    int i=0;
    COMMON$symbolgroup symhi=null;
    // JavaLine 17 ==> SourceLine 231
    COMMON$symbolbox cursym=null;
    // JavaLine 19 ==> SourceLine 246
    COMMON$constsymbol inspect$246$1=null;
    // Normal Constructor
    public COMMON$DEFCONST(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("DEFCONST",246);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public COMMON$DEFCONST STM$() {
        TRACE_BEGIN_STM$("DEFCONST",246);
        COMMON$DEFCONST THIS$=(COMMON$DEFCONST)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 37 ==> SourceLine 232
                if(TRF_EQ(((COMMON)(CUR$.SL$)).simsymbol,null)) {
                    ((COMMON)(CUR$.SL$)).hashhi=((COMMON)(CUR$.SL$)).hashlo=((COMMON)(CUR$.SL$)).NUL;
                } else
                // JavaLine 41 ==> SourceLine 234
                {
                    TRACE_BEGIN_STM$("CompoundStatement234",234);
                    ((COMMON)(CUR$.SL$)).hashlo=char$(hash(((COMMON)(CUR$.SL$)).simsymbol));
                    // JavaLine 45 ==> SourceLine 235
                    ((COMMON)(CUR$.SL$)).hashlo=(((((COMMON)(CUR$.SL$)).hashlo>=(((char)203))))?(char$((rank(((COMMON)(CUR$.SL$)).hashlo)-(203)))):(char$((rank(((COMMON)(CUR$.SL$)).hashlo)+(53)))));
                    // JavaLine 47 ==> SourceLine 237
                    cursym=((COMMON)(CUR$.SL$)).hashtab.Elt[rank(((COMMON)(CUR$.SL$)).hashlo)-((COMMON)(CUR$.SL$)).hashtab.LB[0]];
                    // JavaLine 49 ==> SourceLine 238
                    if((cursym!=(null))) {
                        // JavaLine 51 ==> SourceLine 239
                        {
                            TRACE_BEGIN_STM$("CompoundStatement239",239);
                            while(TXTREL$NE(cursym.symbol,((COMMON)(CUR$.SL$)).simsymbol)) {
                                // JavaLine 55 ==> SourceLine 241
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement241",241);
                                    if((cursym.next==(null))) {
                                        GOTO$(F); // GOTO EVALUATED LABEL
                                    }
                                    // JavaLine 61 ==> SourceLine 242
                                    cursym=cursym.next;
                                    TRACE_END_STM$("CompoundStatement241",242);
                                }
                            }
                            // JavaLine 66 ==> SourceLine 244
                            ((COMMON)(CUR$.SL$)).hashhi=cursym.idhi;
                            ((COMMON)(CUR$.SL$)).hashlo=cursym.idlo;
                            TRACE_END_STM$("CompoundStatement239",244);
                        }
                    } else
                    // JavaLine 72 ==> SourceLine 265
                    LABEL$(1); // F
                    // JavaLine 74 ==> SourceLine 246
                    {
                        // BEGIN INSPECTION 
                        inspect$246$1=new COMMON$constsymbol(((COMMON)(CUR$.SL$))).STM$();
                        if(inspect$246$1!=null) //INSPECT inspect$246$1
                        // JavaLine 79 ==> SourceLine 247
                        {
                            TRACE_BEGIN_STM$("CompoundStatement247",247);
                            inspect$246$1.symbol=copy(copy(((COMMON)(CUR$.SL$)).simsymbol));
                            // JavaLine 83 ==> SourceLine 248
                            inspect$246$1.next=((COMMON)(CUR$.SL$)).hashtab.Elt[rank(((COMMON)(CUR$.SL$)).hashlo)-((COMMON)(CUR$.SL$)).hashtab.LB[0]];
                            // JavaLine 85 ==> SourceLine 249
                            ((COMMON)(CUR$.SL$)).hashtab.Elt[rank(((COMMON)(CUR$.SL$)).hashlo)-((COMMON)(CUR$.SL$)).hashtab.LB[0]]=((COMMON$symbolbox)inspect$246$1);
                            // JavaLine 87 ==> SourceLine 250
                            if((((COMMON)(CUR$.SL$)).constlo==(((COMMON)(CUR$.SL$)).NUL))) {
                                // JavaLine 89 ==> SourceLine 251
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement251",251);
                                    inspect$246$1.idlo=((COMMON)(CUR$.SL$)).hashlo=((COMMON)(CUR$.SL$)).constlo=((char)255);
                                    // JavaLine 93 ==> SourceLine 252
                                    inspect$246$1.idhi=((COMMON)(CUR$.SL$)).hashhi=((COMMON)(CUR$.SL$)).consthi=char$((rank(((COMMON)(CUR$.SL$)).consthi)-(1)));
                                    TRACE_END_STM$("CompoundStatement251",252);
                                }
                            } else
                            // JavaLine 98 ==> SourceLine 254
                            {
                                TRACE_BEGIN_STM$("CompoundStatement254",254);
                                inspect$246$1.idlo=((COMMON)(CUR$.SL$)).hashlo=((COMMON)(CUR$.SL$)).constlo=char$((rank(((COMMON)(CUR$.SL$)).constlo)-(1)));
                                // JavaLine 102 ==> SourceLine 255
                                inspect$246$1.idhi=((COMMON)(CUR$.SL$)).hashhi=((COMMON)(CUR$.SL$)).consthi;
                                TRACE_END_STM$("CompoundStatement254",255);
                            }
                            // JavaLine 106 ==> SourceLine 256
                            if(((inspect$246$1.idhi==(((COMMON)(CUR$.SL$)).identhi))&&((inspect$246$1.idlo<=(((COMMON)(CUR$.SL$)).identlo))))) {
                                // JavaLine 108 ==> SourceLine 258
                                ((COMMON)(CUR$.SL$)).COMMONerror$0().CPF().setPar(297).ENT$();
                            }
                            // JavaLine 111 ==> SourceLine 259
                            symhi=((COMMON)(CUR$.SL$)).symtab.Elt[rank(inspect$246$1.idhi)-((COMMON)(CUR$.SL$)).symtab.LB[0]];
                            // JavaLine 113 ==> SourceLine 260
                            if((symhi==(((COMMON)(CUR$.SL$)).dummyGroup))) {
                                // JavaLine 115 ==> SourceLine 261
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement261",261);
                                    symhi=new COMMON$symbolgroup(((COMMON)(CUR$.SL$))).STM$();
                                    // JavaLine 119 ==> SourceLine 262
                                    for(boolean CB$262:new ForList(
                                        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(0); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(255); }})
                                       )) { if(!CB$262) continue;
                                    ((ARRAY$<COMMON$symbolbox[]>)symhi.val).Elt[i-symhi.val.LB[0]]=((COMMON)(CUR$.SL$)).dummyBox;
                                }
                                // JavaLine 125 ==> SourceLine 263
                                ((COMMON)(CUR$.SL$)).symtab.Elt[rank(inspect$246$1.idhi)-((COMMON)(CUR$.SL$)).symtab.LB[0]]=symhi;
                                TRACE_END_STM$("CompoundStatement261",263);
                            }
                        }
                        // JavaLine 130 ==> SourceLine 264
                        ((ARRAY$<COMMON$symbolbox[]>)symhi.val).Elt[rank(inspect$246$1.idlo)-symhi.val.LB[0]]=((COMMON$symbolbox)inspect$246$1);
                        TRACE_END_STM$("CompoundStatement247",264);
                    }
                }
                TRACE_END_STM$("CompoundStatement234",264);
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
    TRACE_END_STM$("DEFCONST",264);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure DEFCONST",1,229,11,246,14,230,17,231,19,246,37,232,41,234,45,235,47,237,49,238,51,239,55,241,61,242,66,244,72,265,74,246,79,247,83,248,85,249,87,250,89,251,93,252,98,254,102,255,106,256,108,258,111,259,113,260,115,261,119,262,125,263,130,264,153,267);
}
