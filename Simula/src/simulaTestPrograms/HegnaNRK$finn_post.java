package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Thu May 09 12:11:59 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$finn_post extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    public int p$start;
    int i=0;
    int j=0;
    int pnr=0;
    boolean funnet=false;
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$finn_post setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$start=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public HegnaNRK$finn_post(RTObject$ SL$)
    { super(SL$); }
    public HegnaNRK$finn_post(RTObject$ SL$,int sp$start) {
        super(SL$);
        this.p$start = sp$start;
        BBLK();
        STM$();
    }
    public HegnaNRK$finn_post STM$() {
        i=0;
        pnr=p$start;
        funnet=false;
        while((((!(funnet))&((i<(((HegnaNRK)(CUR$.SL$)).antall_poster$1))))&((pnr<(((HegnaNRK)(CUR$.SL$)).max_antall_poster$1))))) {
            {
                i=(i+(1));
                pnr=(pnr+(1));
                while(((((HegnaNRK)(CUR$.SL$)).post_peker.Elt[pnr-((HegnaNRK)(CUR$.SL$)).post_peker.LB[0]]==(null))&((pnr<(((HegnaNRK)(CUR$.SL$)).max_antall_poster$1))))) {
                    pnr=(pnr+(1));
                }
                if(VALUE$((((HegnaNRK)(CUR$.SL$)).post_peker.Elt[pnr-((HegnaNRK)(CUR$.SL$)).post_peker.LB[0]]!=(null)))) {
                    {
                        j=1;
                        if(VALUE$((((HegnaNRK)(CUR$.SL$)).finne_regel_antall$1==(0)))) {
                            funnet=true;
                        } else
                        funnet=new HegnaNRK$finn_post_felt(((HegnaNRK)(CUR$.SL$)),pnr,j).RESULT$;
                        while((funnet&((j<(((HegnaNRK)(CUR$.SL$)).finne_regel_antall$1))))) {
                            {
                                j=(j+(1));
                                funnet=new HegnaNRK$finn_post_felt(((HegnaNRK)(CUR$.SL$)),pnr,j).RESULT$;
                            }
                        }
                    }
                }
            }
        }
        RESULT$=((funnet)?(pnr):(0));
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure finn_post",1,678,11,680,36,681,39,682,41,683,43,686,46,687,48,688,50,689,53,690,55,692,58,693,60,694,63,696,65,697,67,699,70,700,78,704,82,705);
}
