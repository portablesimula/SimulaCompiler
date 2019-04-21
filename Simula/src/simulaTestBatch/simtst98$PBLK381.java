package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Apr 13 09:06:47 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst98$PBLK381 extends simtst98$f {
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    public simtst98$PBLK381(RTObject$ staticLink) {
        super(staticLink);
    }
    public simtst98$PBLK381 STM$() {
        simtst98$PBLK381 THIS$=(simtst98$PBLK381)CUR$;
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
                new simtst98$f$outf(((simtst98$f)CUR$),208);
                ((simtst98)(CUR$.SL$)).ablock=((simtst98)(CUR$.SL$)).dblock=((simtst98)(CUR$.SL$)).eblock=((simtst98)(CUR$.SL$)).fblock=true;
                new simtst98$virtproc(((simtst98)(CUR$.SL$)),382,new TXT$("global"),new TXT$("***F begin VP*** "));
                new simtst98$outattr(((simtst98)(CUR$.SL$)),383,new TXT$("f BEGIN - i:"),((simtst98)(CUR$.SL$)).i,((simtst98)(CUR$.SL$)).globali);
                new simtst98$outim(((simtst98)(CUR$.SL$)));
                ((simtst98)(CUR$.SL$)).ablock=((simtst98)(CUR$.SL$)).dblock=((simtst98)(CUR$.SL$)).eblock=((simtst98)(CUR$.SL$)).fblock=false;
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst98.sim","PrefixedBlock simtst98$PBLK381",1,381,17,93,22,189,25,198,27,208,29,381,31,382,33,383,35,384,37,385,39,95,41,97,45,99,49,100,52,101,54,102,56,109,58,103,60,104,62,106,64,107,66,108,72,385,86,386);
}
