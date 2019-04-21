package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Apr 13 09:06:41 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst98$PBLK358 extends simtst98$a {
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    public simtst98$PBLK358(RTObject$ staticLink) {
        super(staticLink);
    }
    public simtst98$PBLK358 STM$() {
        simtst98$PBLK358 THIS$=(simtst98$PBLK358)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                ai=i;
                aj=j=13;
                ident='a';
                new simtst98$a$outa(((simtst98$a)CUR$),93);
                ((simtst98)(CUR$.SL$)).ablock=true;
                new simtst98$outattr(((simtst98)(CUR$.SL$)),359,new TXT$("a BEGIN: i (protected const):"),i,ai);
                new simtst98$outattr(((simtst98)(CUR$.SL$)),360,new TXT$("         j (protected attr): "),j,aj);
                new simtst98$outim(((simtst98)(CUR$.SL$)));
                ((simtst98)(CUR$.SL$)).ablock=false;
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst98.sim","PrefixedBlock simtst98$PBLK358",1,358,17,93,22,358,24,359,26,360,28,361,30,362,32,95,34,97,38,99,42,100,45,101,47,102,49,109,51,103,53,104,55,106,57,107,59,108,65,362,79,363);
}
