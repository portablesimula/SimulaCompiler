package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Apr 13 09:06:46 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst98$PBLK374 extends simtst98$e {
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    public simtst98$PBLK374(RTObject$ staticLink) {
        super(staticLink);
    }
    public simtst98$PBLK374 STM$() {
        simtst98$PBLK374 THIS$=(simtst98$PBLK374)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                ai=i;
                aj=j=13;
                ident='a';
                new simtst98$a$outa(((simtst98$a)CUR$),93);
                i$1=di$1=24;
                new simtst98$d$outd(((simtst98$d)CUR$),189);
                new simtst98$e$oute(((simtst98$e)CUR$),198);
                ((simtst98)(CUR$.SL$)).ablock=((simtst98)(CUR$.SL$)).dblock=((simtst98)(CUR$.SL$)).eblock=true;
                new simtst98$outattr(((simtst98)(CUR$.SL$)),375,new TXT$("e BEGIN - i:"),((simtst98$a)CUR$).i,ai);
                new simtst98$outim(((simtst98)(CUR$.SL$)));
                ((simtst98)(CUR$.SL$)).ablock=((simtst98)(CUR$.SL$)).dblock=((simtst98)(CUR$.SL$)).eblock=false;
                if(VALUE$((ident==('a')))) {
                    new simtst98$a$avirt(((simtst98$a)CUR$),97,new TXT$("a.virtproc"),new TXT$("***AVIRT FROM a***"));
                } else
                if(VALUE$((ident==('b')))) {
                    new simtst98$a$avirt(((simtst98$a)CUR$),99,new TXT$("b.virtproc"),new TXT$("***BVIRT FROM this a is b***"));
                } else
                if(VALUE$((ident==('c')))) {
                    new simtst98$a$avirt(((simtst98$a)CUR$),100,new TXT$("b.virtproc"),new TXT$("***BVIRT FROM this a in c***"));
                }
                detach();
                goto_OK=true;
                LABEL$(1,"L");
                if(VALUE$((((simtst98)(CUR$.SL$)).trace|((!(goto_OK)))))) {
                    {
                        sysout().outtext(((goto_OK)?(new TXT$("OK: detach is dummy for pref.block")):(new TXT$(" !!! at L in xa (goto remote label)"))));
                        sysout().outimage();
                        if(VALUE$((!(goto_OK)))) {
                            ((simtst98)(CUR$.SL$)).errorFound=true;
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst98.sim","PrefixedBlock simtst98$PBLK374",1,374,17,93,22,189,25,198,27,374,29,375,31,376,33,377,35,95,37,97,41,99,45,100,48,101,50,102,52,109,54,103,56,104,58,106,60,107,62,108,68,377,82,378);
}
