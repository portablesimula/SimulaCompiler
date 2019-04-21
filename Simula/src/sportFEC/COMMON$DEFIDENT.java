package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Apr 14 09:36:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$DEFIDENT extends BASICIO$ {
    public int prefixLevel() { return(0); }
    final LABQNT$ F=new LABQNT$(this,1,"F");
    COMMON$symbolgroup symhi=null;
    int i=0;
    COMMON$symbolbox cursym=null;
    COMMON$identsymbol inspect$204$0=null;
    public COMMON$DEFIDENT(RTObject$ SL$) {
        super(SL$);
        BBLK();
        STM$();
    }
    public COMMON$DEFIDENT STM$() {
        COMMON$DEFIDENT THIS$=(COMMON$DEFIDENT)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                if(VALUE$(TRF_EQ(((COMMON)(CUR$.SL$)).simsymbol,null))) {
                    ((COMMON)(CUR$.SL$)).hashhi=((COMMON)(CUR$.SL$)).hashlo=((COMMON)(CUR$.SL$)).NUL;
                } else
                {
                    ((COMMON)(CUR$.SL$)).hashlo=char$(hash(lowcase(((COMMON)(CUR$.SL$)).simsymbol)));
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
                        inspect$204$0=new COMMON$identsymbol(((COMMON)(CUR$.SL$))).STM$();
                        if(inspect$204$0!=null)
                        {
                            inspect$204$0.symbol=copy(copy(((COMMON)(CUR$.SL$)).simsymbol));
                            inspect$204$0.next=((COMMON)(CUR$.SL$)).hashtab.Elt[rank(((COMMON)(CUR$.SL$)).hashlo)-((COMMON)(CUR$.SL$)).hashtab.LB[0]];
                            ((COMMON)(CUR$.SL$)).hashtab.Elt[rank(((COMMON)(CUR$.SL$)).hashlo)-((COMMON)(CUR$.SL$)).hashtab.LB[0]]=((COMMON$symbolbox)inspect$204$0);
                            if(VALUE$((((COMMON)(CUR$.SL$)).identlo==(((char)255))))) {
                                {
                                    inspect$204$0.idlo=((COMMON)(CUR$.SL$)).identlo=((COMMON)(CUR$.SL$)).hashlo=((COMMON)(CUR$.SL$)).NUL;
                                    inspect$204$0.idhi=((COMMON)(CUR$.SL$)).hashhi=((COMMON)(CUR$.SL$)).identhi=char$((rank(((COMMON)(CUR$.SL$)).identhi)+(1)));
                                }
                            } else
                            {
                                inspect$204$0.idlo=((COMMON)(CUR$.SL$)).hashlo=((COMMON)(CUR$.SL$)).identlo=char$((rank(((COMMON)(CUR$.SL$)).identlo)+(1)));
                                inspect$204$0.idhi=((COMMON)(CUR$.SL$)).hashhi=((COMMON)(CUR$.SL$)).identhi;
                            }
                            if(VALUE$(((inspect$204$0.idhi==(((COMMON)(CUR$.SL$)).consthi))&&((inspect$204$0.idlo>=(((COMMON)(CUR$.SL$)).constlo)))))) {
                                ((COMMON)(CUR$.SL$)).COMMONerror$0().CPF().setPar(297).ENT$();
                            }
                            symhi=((COMMON)(CUR$.SL$)).symtab.Elt[rank(inspect$204$0.idhi)-((COMMON)(CUR$.SL$)).symtab.LB[0]];
                            if(VALUE$((symhi==(((COMMON)(CUR$.SL$)).dummyGroup)))) {
                                {
                                    symhi=new COMMON$symbolgroup(((COMMON)(CUR$.SL$))).STM$();
                                    for(boolean CB$220:new ForList(
                                        new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(0); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(255); }})
                                       )) { if(!CB$220) continue;
                                    ((ARRAY$<COMMON$symbolbox[]>)symhi.val).Elt[i-symhi.val.LB[0]]=((COMMON)(CUR$.SL$)).dummyBox;
                                }
                                ((COMMON)(CUR$.SL$)).symtab.Elt[rank(inspect$204$0.idhi)-((COMMON)(CUR$.SL$)).symtab.LB[0]]=symhi;
                            }
                        }
                        ((ARRAY$<COMMON$symbolbox[]>)symhi.val).Elt[rank(inspect$204$0.idlo)-symhi.val.LB[0]]=((COMMON$symbolbox)inspect$204$0);
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
public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure DEFIDENT",1,189,8,204,10,190,13,191,15,204,27,192,31,194,34,195,36,196,38,197,41,199,46,200,50,202,55,223,57,204,61,205,64,206,66,207,68,208,70,209,73,210,77,212,80,213,83,214,85,216,88,217,90,218,92,219,95,220,101,221,105,222,123,225);
}
