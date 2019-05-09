package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$trykk_rapport extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$formatnr;
    int i=0;
    int k=0;
    int felt_linje=0;
    boolean funnet=false;
    HegnaNRK$format inspect$1099$5=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$trykk_rapport setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$formatnr=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$trykk_rapport(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$trykk_rapport(RTObject$ SL$,int sp$formatnr) {
        super(SL$);
        this.p$formatnr = sp$formatnr;
        BBLK();
        STM$();
    }
    public HegnaNRK$trykk_rapport STM$() {
        {
            inspect$1099$5=((HegnaNRK)(CUR$.SL$)).format_peker.Elt[p$formatnr-((HegnaNRK)(CUR$.SL$)).format_peker.LB[0]];
            if(inspect$1099$5!=null)
            {
                felt_linje=0;
                for(boolean CB$1102:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(inspect$1099$5.p$antall); }})
                   )) { if(!CB$1102) continue;
                {
                    k=0;
                    funnet=false;
                    while(((!(funnet))&((k<(((HegnaNRK)(CUR$.SL$)).felt_antall$1))))) {
                        {
                            k=(k+(1));
                            funnet=(inspect$1099$5.fnr.Elt[i-inspect$1099$5.fnr.LB[0]]==(((HegnaNRK)(CUR$.SL$)).intern_feltnr.Elt[k-((HegnaNRK)(CUR$.SL$)).intern_feltnr.LB[0]]));
                        }
                    }
                    if(VALUE$(funnet)) {
                        {
                            if(VALUE$((inspect$1099$5.spos.Elt[i-inspect$1099$5.spos.LB[0]]==(0)))) {
                                sysout().outchar(((char)32));
                            } else
                            {
                                if(VALUE$((inspect$1099$5.spos.Elt[i-inspect$1099$5.spos.LB[0]]<(TXT$.pos(sysout().image))))) {
                                    new HegnaNRK$trykk_rapport$skriv_linje(((HegnaNRK$trykk_rapport)CUR$));
                                }
                                TXT$.setpos(sysout().image,inspect$1099$5.spos.Elt[i-inspect$1099$5.spos.LB[0]]);
                            }
                            ((HegnaNRK)(CUR$.SL$)).intern_felt.Elt[k-((HegnaNRK)(CUR$.SL$)).intern_felt.LB[0]].skriv$0().CPF();
                        }
                    }
                }
            }
            new HegnaNRK$trykk_rapport$skriv_linje(((HegnaNRK$trykk_rapport)CUR$));
            while((felt_linje<(inspect$1099$5.ark_lengde))) {
                new HegnaNRK$trykk_rapport$skriv_linje(((HegnaNRK$trykk_rapport)CUR$));
            }
        }
    }
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure trykk_rapport",1,1091,9,1093,14,1099,39,1101,42,1102,46,1104,49,1105,51,1106,53,1108,56,1109,60,1111,62,1113,65,1114,68,1116,73,1117,76,1119,82,1122,84,1123,92,1125);
}
