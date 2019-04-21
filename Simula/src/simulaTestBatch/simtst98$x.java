package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Apr 13 09:06:30 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst98$x extends simtst98$c {
    public int prefixLevel() { return(3); }
    public boolean isDetachUsed() { return(true); }
    final LABQNT$ L=new LABQNT$(this,2,"L");
    public PRCQNT$ virtproc$3() { return(new PRCQNT$(this,simtst98$x$virtproc.class)); }
    public simtst98$x(RTObject$ staticLink) {
        super(staticLink);
        TRACE_BEGIN_DCL$("x",234);
    }
    public simtst98$x STM$() {
        simtst98$x THIS$=(simtst98$x)CUR$;
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
                if(VALUE$(IS$(((simtst98$x)CUR$),simtst98$x.class))) {
                    new simtst98$x$xvirt(((simtst98$x)CUR$),239,new TXT$("x.virtproc"),new TXT$("***XVIRT FROM this x is x***"));
                } else
                if(VALUE$(IS$(((simtst98$x)CUR$),simtst98$y.class))) {
                    new simtst98$x$xvirt(((simtst98$x)CUR$),241,new TXT$("y.virtproc"),new TXT$("***XVIRT FROM this x is y***"));
                } else
                if(VALUE$(((simtst98$x)CUR$) instanceof simtst98$z)) {
                    new simtst98$x$xvirt(((simtst98$x)CUR$),242,new TXT$("y.virtproc"),new TXT$("***XVIRT FROM this x in z***"));
                }
                detach();
                goto_OK=true;
                LABEL$(2,"L");
                if(VALUE$((((simtst98)(CUR$.SL$)).trace|((!(goto_OK)))))) {
                    {
                        sysout().outtext(((goto_OK)?(new TXT$("OK: detach is dummy for X-pref.block")):(new TXT$(" !!! at L in X (goto remote label)"))));
                        sysout().outimage();
                        if(VALUE$((!(goto_OK)))) {
                            ((simtst98)(CUR$.SL$)).errorFound=true;
                        }
                    }
                }
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
    public static PROGINFO$ INFO$=new PROGINFO$("simtst98.sim","Class x",1,219,9,246,21,93,26,138,32,173,37,174,39,237,41,239,45,241,49,242,52,244,54,245,56,252,58,246,60,247,62,249,64,250,66,251,72,176,74,178,80,179,82,180,84,140,86,141,89,142,93,143,96,144,100,146,102,147,104,95,106,97,110,99,114,100,117,101,119,102,121,109,123,103,125,104,127,106,129,107,131,108,137,251,151,253);
}
