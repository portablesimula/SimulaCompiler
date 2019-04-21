package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Apr 13 09:06:30 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst98$f extends simtst98$e {
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    public simtst98$f(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("f",206);
    }
    public simtst98$f STM$() {
        simtst98$f THIS$=(simtst98$f)CUR$;
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst98.sim","Class f",1,201,18,93,23,189,26,198,29,95,31,97,35,99,39,100,42,101,44,102,46,109,48,103,50,104,52,106,54,107,56,108,62,208,76,209);
}
