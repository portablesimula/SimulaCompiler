package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$do_kommando extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$kommandonr;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$do_kommando setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$kommandonr=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$do_kommando(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$do_kommando(RTObject$ SL$,int sp$kommandonr) {
        super(SL$);
        this.p$kommandonr = sp$kommandonr;
        BBLK();
        STM$();
    }
    public HegnaNRK$do_kommando STM$() {
        if(VALUE$((p$kommandonr==(1)))) {
            new HegnaNRK$definer(((HegnaNRK)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(2)))) {
            new HegnaNRK$registrer(((HegnaNRK)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(3)))) {
            new HegnaNRK$finn(((HegnaNRK)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(4)))) {
            new HegnaNRK$endre(((HegnaNRK)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(5)))) {
            new HegnaNRK$trykk(((HegnaNRK)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(6)))) {
            new HegnaNRK$fjern(((HegnaNRK)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(7)))) {
            new HegnaNRK$hjelp(((HegnaNRK)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(8)))) {
            new HegnaNRK$list(((HegnaNRK)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(9)))) {
            new HegnaNRK$listdef(((HegnaNRK)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(10)))) {
            new HegnaNRK$neste(((HegnaNRK)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(11)))) {
            new HegnaNRK$hent(((HegnaNRK)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(12)))) {
            new HegnaNRK$datareg(((HegnaNRK)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(13)))) {
            new HegnaNRK$definer_format(((HegnaNRK)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(14)))) {
            new HegnaNRK$rapporter(((HegnaNRK)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(15)))) {
            new HegnaNRK$tainn(((HegnaNRK)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(16)))) {
            new HegnaNRK$leggut(((HegnaNRK)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(17)))) {
            new HegnaNRK$finnmengde(((HegnaNRK)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(18)))) {
            new HegnaNRK$sortermengde(((HegnaNRK)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(19)))) {
            new HegnaNRK$rapportermengde(((HegnaNRK)(CUR$.SL$)));
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure do_kommando",1,393,29,396,33,397,37,398,41,399,45,400,49,401,53,402,57,403,61,404,65,405,69,406,73,407,77,408,81,409,85,410,89,411,93,412,97,413,101,414,107,416);
}
