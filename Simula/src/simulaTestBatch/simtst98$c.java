package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Apr 13 09:06:30 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst98$c extends simtst98$b {
    public int prefixLevel() { return(2); }
    public boolean isDetachUsed() { return(true); }
    public int ci$2=0;
    public int cj$2=0;
    public int ck$2=0;
    public simtst98$a inspect$178$1$2=null;
    public simtst98$c(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("c",178);
    }
    public simtst98$c STM$() {
        simtst98$c THIS$=(simtst98$c)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                ai=i;
                aj=j=13;
                ident='a';
                new simtst98$a$outa(((simtst98$a)CUR$),93);
                bi$1=ai;
                bj$1=aj;
                bk$1=k$1=14;
                ident='b';
                new simtst98$b$outb(((simtst98$b)CUR$),138);
                ci$2=((simtst98)(CUR$.SL$)).globali;
                cj$2=bj$1;
                ck$2=((simtst98)(CUR$.SL$)).globalk;
                ident='c';
                new simtst98$c$outc(((simtst98$c)CUR$),174);
                new simtst98$c$virtproc(((simtst98$c)CUR$),176,new TXT$("c.virtproc"),new TXT$("***VIRTPROC***"));
                {
                    inspect$178$1$2=((simtst98$a)CUR$);
                    if(inspect$178$1$2!=null)
                    inspect$178$1$2.virtproc$0().CPF().setPar(new NAME$<Integer>(){ public Integer get() { return(178); } }).setPar(new NAME$<TXT$>(){ public TXT$ get() { return(new TXT$("b.virtproc")); } }).setPar(new NAME$<TXT$>(){ public TXT$ get() { return(new TXT$("***INSP THIS A*c*")); } }).ENT$();
                }
                new simtst98$a$avirt(((simtst98$c)CUR$),179,new TXT$("b.virtproc"),new TXT$("***AVIRT FROM c***"));
                new simtst98$b$bvirt(((simtst98$c)CUR$),180,new TXT$("b.virtproc"),new TXT$("***BVIRT FROM c***"));
                if(VALUE$(IS$(((simtst98$b)CUR$),simtst98$b.class))) {
                    ((simtst98$b)CUR$).virtproc$0().CPF().setPar(new NAME$<Integer>(){ public Integer get() { return(141); } }).setPar(new NAME$<TXT$>(){ public TXT$ get() { return(new TXT$("b.virtproc")); } }).setPar(new NAME$<TXT$>(){ public TXT$ get() { return(new TXT$("***THIS B IS B*** ")); } }).ENT$();
                }
                {
                    inspect$142$0$1=((simtst98$a)CUR$);
                    if(inspect$142$0$1!=null)
                    {
                        inspect$142$0$1.virtproc$0().CPF().setPar(new NAME$<Integer>(){ public Integer get() { return(143); } }).setPar(new NAME$<TXT$>(){ public TXT$ get() { return(new TXT$("b.virtproc")); } }).setPar(new NAME$<TXT$>(){ public TXT$ get() { return(new TXT$("***INSP THIS A*a*")); } }).ENT$();
                        new simtst98$outattr(((simtst98)(CUR$.SL$)),144,new TXT$("in b: (insp. this a).k="),k$1,bk$1);
                    }
                }
                new simtst98$a$avirt(((simtst98$b)CUR$),146,new TXT$("b.virtproc"),new TXT$("***AVIRT FROM a***"));
                new simtst98$b$bvirt(((simtst98$b)CUR$),147,new TXT$("b.virtproc"),new TXT$("***BVIRT FROM b***"));
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst98.sim","Class c",1,150,9,151,13,178,24,93,29,138,35,173,40,174,42,176,44,178,50,179,52,180,54,140,56,141,59,142,63,143,66,144,70,146,72,147,74,95,76,97,80,99,84,100,87,101,89,102,91,109,93,103,95,104,97,106,99,107,101,108,107,180,121,181);
}
