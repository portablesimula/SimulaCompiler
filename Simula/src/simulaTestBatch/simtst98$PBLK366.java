package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Apr 13 09:06:43 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst98$PBLK366 extends simtst98$d {
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    public simtst98$PBLK366(RTObject$ staticLink) {
        super(staticLink);
    }
    public simtst98$PBLK366 STM$() {
        simtst98$PBLK366 THIS$=(simtst98$PBLK366)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                ai=i;
                aj=j=13;
                ident='a';
                new simtst98$a$outa(((simtst98$a)CUR$),93);
                i$1=di$1=24;
                new simtst98$d$outd(((simtst98$d)CUR$),189);
                ((simtst98)(CUR$.SL$)).ablock=((simtst98)(CUR$.SL$)).dblock=true;
                ((simtst98$PBLK366)CUR$).virtproc$0().CPF().setPar(new NAME$<Integer>(){ public Integer get() { return(367); } }).setPar(new NAME$<TXT$>(){ public TXT$ get() { return(new TXT$("a.virtproc")); } }).setPar(new NAME$<TXT$>(){ public TXT$ get() { return(new TXT$("***D begin VP*** ")); } }).ENT$();
                new simtst98$outattr(((simtst98)(CUR$.SL$)),368,new TXT$("d BEGIN - i:"),i$1,di$1);
                new simtst98$outim(((simtst98)(CUR$.SL$)));
                ((simtst98)(CUR$.SL$)).ablock=((simtst98)(CUR$.SL$)).dblock=false;
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst98.sim","PrefixedBlock simtst98$PBLK366",1,366,17,93,22,189,25,366,27,367,29,368,31,369,33,370,35,95,37,97,41,99,45,100,48,101,50,102,52,109,54,103,56,104,58,106,60,107,62,108,68,370,82,371);
}
