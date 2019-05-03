package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Fri May 03 22:07:42 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$do_kommando extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int p$kommandonr;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$do_kommando setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$kommandonr=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$PBLK21$do_kommando(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$PBLK21$do_kommando(RTObject$ SL$,int sp$kommandonr) {
        super(SL$);
        this.p$kommandonr = sp$kommandonr;
        BBLK();
        STM$();
    }
    public HegnaNRK$PBLK21$do_kommando STM$() {
        if(VALUE$((p$kommandonr==(1)))) {
            new HegnaNRK$PBLK21$definer(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(2)))) {
            new HegnaNRK$PBLK21$registrer(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(3)))) {
            new HegnaNRK$PBLK21$finn(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(4)))) {
            new HegnaNRK$PBLK21$endre(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(5)))) {
            new HegnaNRK$PBLK21$trykk(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(6)))) {
            new HegnaNRK$PBLK21$fjern(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(7)))) {
            new HegnaNRK$PBLK21$hjelp(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(8)))) {
            new HegnaNRK$PBLK21$list(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(9)))) {
            new HegnaNRK$PBLK21$listdef(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(10)))) {
            new HegnaNRK$PBLK21$neste(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(11)))) {
            new HegnaNRK$PBLK21$hent(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(12)))) {
            new HegnaNRK$PBLK21$datareg(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(13)))) {
            new HegnaNRK$PBLK21$definer_format(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(14)))) {
            new HegnaNRK$PBLK21$rapporter(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(15)))) {
            new HegnaNRK$PBLK21$tainn(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(16)))) {
            new HegnaNRK$PBLK21$leggut(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(17)))) {
            new HegnaNRK$PBLK21$finnmengde(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(18)))) {
            new HegnaNRK$PBLK21$sortermengde(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if(VALUE$((p$kommandonr==(19)))) {
            new HegnaNRK$PBLK21$rapportermengde(((HegnaNRK$PBLK21)(CUR$.SL$)));
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure do_kommando",1,393,29,396,33,397,37,398,41,399,45,400,49,401,53,402,57,403,61,404,65,405,69,406,73,407,77,408,81,409,85,410,89,411,93,412,97,413,101,414,107,416);
}
