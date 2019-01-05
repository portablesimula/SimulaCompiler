// JavaLine 1 ==> SourceLine 189
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 15:03:20 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$DEFIDENT extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=189, lastLine=225, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 204
    final LABQNT$ F=new LABQNT$(this,0,1); // Local Label #1=F
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 190
    COMMON$symbolgroup symhi=null;
    int i=0;
    // JavaLine 17 ==> SourceLine 191
    COMMON$symbolbox cursym=null;
    // JavaLine 19 ==> SourceLine 204
    COMMON$identsymbol inspect$204$0=null;
    // Normal Constructor
    public COMMON$DEFIDENT(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("DEFIDENT",204);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public COMMON$DEFIDENT STM$() {
        TRACE_BEGIN_STM$("DEFIDENT",204);
        COMMON$DEFIDENT THIS$=(COMMON$DEFIDENT)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 37 ==> SourceLine 192
                if(TRF_EQ(((COMMON)(CUR$.SL$)).simsymbol,null)) {
                    ((COMMON)(CUR$.SL$)).hashhi=((COMMON)(CUR$.SL$)).hashlo=((COMMON)(CUR$.SL$)).NUL;
                } else
                // JavaLine 41 ==> SourceLine 194
                {
                    TRACE_BEGIN_STM$("CompoundStatement194",194);
                    ((COMMON)(CUR$.SL$)).hashlo=char$(hash(lowcase(((COMMON)(CUR$.SL$)).simsymbol)));
                    // JavaLine 45 ==> SourceLine 195
                    cursym=((COMMON)(CUR$.SL$)).hashtab.Elt[rank(((COMMON)(CUR$.SL$)).hashlo)-((COMMON)(CUR$.SL$)).hashtab.LB[0]];
                    // JavaLine 47 ==> SourceLine 196
                    if((cursym!=(null))) {
                        // JavaLine 49 ==> SourceLine 197
                        {
                            TRACE_BEGIN_STM$("CompoundStatement197",197);
                            while(TXTREL$NE(cursym.symbol,((COMMON)(CUR$.SL$)).simsymbol)) {
                                // JavaLine 53 ==> SourceLine 199
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement199",199);
                                    if((cursym.next==(null))) {
                                        GOTO$(F); // GOTO EVALUATED LABEL
                                    }
                                    // JavaLine 59 ==> SourceLine 200
                                    cursym=cursym.next;
                                    TRACE_END_STM$("CompoundStatement199",200);
                                }
                            }
                            // JavaLine 64 ==> SourceLine 202
                            ((COMMON)(CUR$.SL$)).hashhi=cursym.idhi;
                            ((COMMON)(CUR$.SL$)).hashlo=cursym.idlo;
                            TRACE_END_STM$("CompoundStatement197",202);
                        }
                    } else
                    // JavaLine 70 ==> SourceLine 223
                    LABEL$(1); // F
                    // JavaLine 72 ==> SourceLine 204
                    {
                        // BEGIN INSPECTION 
                        inspect$204$0=new COMMON$identsymbol(((COMMON)(CUR$.SL$))).STM$();
                        if(inspect$204$0!=null) //INSPECT inspect$204$0
                        // JavaLine 77 ==> SourceLine 205
                        {
                            TRACE_BEGIN_STM$("CompoundStatement205",205);
                            inspect$204$0.symbol=copy(copy(((COMMON)(CUR$.SL$)).simsymbol));
                            // JavaLine 81 ==> SourceLine 206
                            inspect$204$0.next=((COMMON)(CUR$.SL$)).hashtab.Elt[rank(((COMMON)(CUR$.SL$)).hashlo)-((COMMON)(CUR$.SL$)).hashtab.LB[0]];
                            // JavaLine 83 ==> SourceLine 207
                            ((COMMON)(CUR$.SL$)).hashtab.Elt[rank(((COMMON)(CUR$.SL$)).hashlo)-((COMMON)(CUR$.SL$)).hashtab.LB[0]]=((COMMON$symbolbox)inspect$204$0);
                            // JavaLine 85 ==> SourceLine 208
                            if((((COMMON)(CUR$.SL$)).identlo==(((char)255)))) {
                                // JavaLine 87 ==> SourceLine 209
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement209",209);
                                    inspect$204$0.idlo=((COMMON)(CUR$.SL$)).identlo=((COMMON)(CUR$.SL$)).hashlo=((COMMON)(CUR$.SL$)).NUL;
                                    // JavaLine 91 ==> SourceLine 210
                                    inspect$204$0.idhi=((COMMON)(CUR$.SL$)).hashhi=((COMMON)(CUR$.SL$)).identhi=char$((rank(((COMMON)(CUR$.SL$)).identhi)+(1)));
                                    TRACE_END_STM$("CompoundStatement209",210);
                                }
                            } else
                            // JavaLine 96 ==> SourceLine 212
                            {
                                TRACE_BEGIN_STM$("CompoundStatement212",212);
                                inspect$204$0.idlo=((COMMON)(CUR$.SL$)).hashlo=((COMMON)(CUR$.SL$)).identlo=char$((rank(((COMMON)(CUR$.SL$)).identlo)+(1)));
                                // JavaLine 100 ==> SourceLine 213
                                inspect$204$0.idhi=((COMMON)(CUR$.SL$)).hashhi=((COMMON)(CUR$.SL$)).identhi;
                                TRACE_END_STM$("CompoundStatement212",213);
                            }
                            // JavaLine 104 ==> SourceLine 214
                            if(((inspect$204$0.idhi==(((COMMON)(CUR$.SL$)).consthi))&&((inspect$204$0.idlo>=(((COMMON)(CUR$.SL$)).constlo))))) {
                                // JavaLine 106 ==> SourceLine 216
                                ((COMMON)(CUR$.SL$)).COMMONerror$0().CPF().setPar(297).ENT$();
                            }
                            // JavaLine 109 ==> SourceLine 217
                            symhi=((COMMON)(CUR$.SL$)).symtab.Elt[rank(inspect$204$0.idhi)-((COMMON)(CUR$.SL$)).symtab.LB[0]];
                            // JavaLine 111 ==> SourceLine 218
                            if((symhi==(((COMMON)(CUR$.SL$)).dummyGroup))) {
                                // JavaLine 113 ==> SourceLine 219
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement219",219);
                                    symhi=new COMMON$symbolgroup(((COMMON)(CUR$.SL$))).STM$();
                                    // JavaLine 117 ==> SourceLine 220
                                    for(boolean CB$220:new ForList(
                                        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(0); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(255); }})
                                       )) { if(!CB$220) continue;
                                    ((ARRAY$<COMMON$symbolbox[]>)symhi.val).Elt[i-symhi.val.LB[0]]=((COMMON)(CUR$.SL$)).dummyBox;
                                }
                                // JavaLine 123 ==> SourceLine 221
                                ((COMMON)(CUR$.SL$)).symtab.Elt[rank(inspect$204$0.idhi)-((COMMON)(CUR$.SL$)).symtab.LB[0]]=symhi;
                                TRACE_END_STM$("CompoundStatement219",221);
                            }
                        }
                        // JavaLine 128 ==> SourceLine 222
                        ((ARRAY$<COMMON$symbolbox[]>)symhi.val).Elt[rank(inspect$204$0.idlo)-symhi.val.LB[0]]=((COMMON$symbolbox)inspect$204$0);
                        TRACE_END_STM$("CompoundStatement205",222);
                    }
                }
                TRACE_END_STM$("CompoundStatement194",222);
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
    TRACE_END_STM$("DEFIDENT",222);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure DEFIDENT",1,189,11,204,14,190,17,191,19,204,37,192,41,194,45,195,47,196,49,197,53,199,59,200,64,202,70,223,72,204,77,205,81,206,83,207,85,208,87,209,91,210,96,212,100,213,104,214,106,216,109,217,111,218,113,219,117,220,123,221,128,222,151,225);
}
