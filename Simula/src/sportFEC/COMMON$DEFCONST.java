package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:36 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$DEFCONST extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final LABQNT$ F=new LABQNT$(this,1,"F");
    int i=0;
    COMMON$symbolgroup symhi=null;
    COMMON$symbolbox cursym=null;
    COMMON$constsymbol inspect$246$1=null;
    public COMMON$DEFCONST(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public COMMON$DEFCONST STM$() {
        COMMON$DEFCONST THIS$=(COMMON$DEFCONST)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                if(VALUE$(TRF_EQ(((COMMON)(CUR$.SL$)).simsymbol,null))) {
                    ((COMMON)(CUR$.SL$)).hashhi=((COMMON)(CUR$.SL$)).hashlo=((COMMON)(CUR$.SL$)).NUL;
                } else
                {
                    ((COMMON)(CUR$.SL$)).hashlo=char$(hash(((COMMON)(CUR$.SL$)).simsymbol));
                    ((COMMON)(CUR$.SL$)).hashlo=(((((COMMON)(CUR$.SL$)).hashlo>=(((char)203))))?(char$((rank(((COMMON)(CUR$.SL$)).hashlo)-(203)))):(char$((rank(((COMMON)(CUR$.SL$)).hashlo)+(53)))));
                    cursym=((COMMON)(CUR$.SL$)).hashtab.Elt[rank(((COMMON)(CUR$.SL$)).hashlo)-((COMMON)(CUR$.SL$)).hashtab.LB[0]];
                    if(VALUE$((cursym!=(null)))) {
                        {
                            while(TXTREL$NE(cursym.symbol,((COMMON)(CUR$.SL$)).simsymbol)) {
                                {
                                    if(VALUE$((cursym.next==(null)))) {
                                        GOTO$(F);
                                    }
                                    cursym=cursym.next;
                                }
                            }
                            ((COMMON)(CUR$.SL$)).hashhi=cursym.idhi;
                            ((COMMON)(CUR$.SL$)).hashlo=cursym.idlo;
                        }
                    } else
                    LABEL$(1,"F");
                    {
                        inspect$246$1=new COMMON$constsymbol(((COMMON)(CUR$.SL$))).STM$();
                        if(inspect$246$1!=null)
                        {
                            inspect$246$1.symbol=copy(copy(((COMMON)(CUR$.SL$)).simsymbol));
                            inspect$246$1.next=((COMMON)(CUR$.SL$)).hashtab.Elt[rank(((COMMON)(CUR$.SL$)).hashlo)-((COMMON)(CUR$.SL$)).hashtab.LB[0]];
                            ((COMMON)(CUR$.SL$)).hashtab.Elt[rank(((COMMON)(CUR$.SL$)).hashlo)-((COMMON)(CUR$.SL$)).hashtab.LB[0]]=((COMMON$symbolbox)inspect$246$1);
                            if(VALUE$((((COMMON)(CUR$.SL$)).constlo==(((COMMON)(CUR$.SL$)).NUL)))) {
                                {
                                    inspect$246$1.idlo=((COMMON)(CUR$.SL$)).hashlo=((COMMON)(CUR$.SL$)).constlo=((char)255);
                                    inspect$246$1.idhi=((COMMON)(CUR$.SL$)).hashhi=((COMMON)(CUR$.SL$)).consthi=char$((rank(((COMMON)(CUR$.SL$)).consthi)-(1)));
                                }
                            } else
                            {
                                inspect$246$1.idlo=((COMMON)(CUR$.SL$)).hashlo=((COMMON)(CUR$.SL$)).constlo=char$((rank(((COMMON)(CUR$.SL$)).constlo)-(1)));
                                inspect$246$1.idhi=((COMMON)(CUR$.SL$)).hashhi=((COMMON)(CUR$.SL$)).consthi;
                            }
                            if(VALUE$(((inspect$246$1.idhi==(((COMMON)(CUR$.SL$)).identhi))&&((inspect$246$1.idlo<=(((COMMON)(CUR$.SL$)).identlo)))))) {
                                ((COMMON)(CUR$.SL$)).COMMONerror$0().CPF().setPar(297).ENT$();
                            }
                            symhi=((COMMON)(CUR$.SL$)).symtab.Elt[rank(inspect$246$1.idhi)-((COMMON)(CUR$.SL$)).symtab.LB[0]];
                            if(VALUE$((symhi==(((COMMON)(CUR$.SL$)).dummyGroup)))) {
                                {
                                    symhi=new COMMON$symbolgroup(((COMMON)(CUR$.SL$))).STM$();
                                    for(boolean CB$262:new ForList(
                                        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(0); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(255); }})
                                       )) { if(!CB$262) continue;
                                    ((ARRAY$<COMMON$symbolbox[]>)symhi.val).Elt[i-symhi.val.LB[0]]=((COMMON)(CUR$.SL$)).dummyBox;
                                }
                                ((COMMON)(CUR$.SL$)).symtab.Elt[rank(inspect$246$1.idhi)-((COMMON)(CUR$.SL$)).symtab.LB[0]]=symhi;
                            }
                        }
                        ((ARRAY$<COMMON$symbolbox[]>)symhi.val).Elt[rank(inspect$246$1.idlo)-symhi.val.LB[0]]=((COMMON$symbolbox)inspect$246$1);
                    }
                }
            }
            break LOOP$;
        }
        catch(LABQNT$ q) {
            CUR$=THIS$;
            if(q.SL$!=CUR$) {
                CUR$.STATE$=OperationalState.terminated;
                throw(q);
            }
            JTX$=q.index; continue LOOP$;
        }
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure DEFCONST",1,229,8,246,10,230,13,231,15,246,27,232,31,234,34,235,36,237,38,238,40,239,43,241,48,242,52,244,57,265,59,246,63,247,66,248,68,249,70,250,72,251,75,252,79,254,82,255,85,256,87,258,90,259,92,260,94,261,97,262,103,263,107,264,125,267);
}
