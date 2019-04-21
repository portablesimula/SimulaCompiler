package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Apr 13 09:06:30 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst98$b extends simtst98$a {
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    public int k$1=0;
    public int bi$1=0;
    public int bj$1=0;
    public int bk$1=0;
    public simtst98$a inspect$142$0$1=null;
    public PRCQNT$ virtproc$0() { return(new PRCQNT$(this,simtst98$b$virtproc.class)); }
    public simtst98$b(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("b",142);
    }
    public simtst98$b STM$() {
        simtst98$b THIS$=(simtst98$b)CUR$;
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst98.sim","Class b",1,112,9,116,14,142,26,93,31,138,37,140,39,141,42,142,46,143,49,144,53,146,55,147,57,95,59,97,63,99,67,100,70,101,72,102,74,109,76,103,78,104,80,106,82,107,84,108,90,147,104,148);
}
