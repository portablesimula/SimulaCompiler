package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Apr 13 09:06:30 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst98 extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public boolean isQPSystemBlock() { return(true); }
    final LABQNT$ L=new LABQNT$(this,1,"L");
    int i=0;
    int j=0;
    int k=0;
    int globali=0;
    int globalj=0;
    int globalk=0;
    boolean trace=false;
    boolean errorFound=false;
    final boolean verbose=(boolean)(false);
    TXT$ programpoint=null;
    boolean ablock=false;
    boolean bblock=false;
    boolean cblock=false;
    boolean dblock=false;
    boolean eblock=false;
    boolean fblock=false;
    simtst98$a xa=null;
    simtst98$b xb=null;
    simtst98$c xc=null;
    simtst98$d xd=null;
    simtst98$e xe=null;
    simtst98$f xf=null;
    simtst98$a inspect$338$4=null;
    simtst98$b inspect$349$5=null;
    simtst98$b inspect$389$6=null;
    simtst98$y inspect$397$7=null;
    simtst98$z inspect$403$8=null;
    public simtst98(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst98");
    }
    public RTObject$ STM$() {
        simtst98 THIS$=(simtst98)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$);
                if(VALUE$(verbose)) {
                    {
                        sysout().outtext(new TXT$("--- START Simula a.s test 98 (attribute protection test)"));
                        sysout().outimage();
                    }
                }
                globali=i=2;
                globalj=j=3;
                globalk=k=4;
                new simtst98$outerout(((simtst98)CUR$));
                new simtst98$outline(((simtst98)CUR$),new TXT$("***   xa:-new z   ***"));
                xa=((simtst98$z)new simtst98$z(((simtst98)CUR$)).START$());
                new simtst98$outline(((simtst98)CUR$),new TXT$("***   xa:-new y   ***"));
                xa=((simtst98$y)new simtst98$y(((simtst98)CUR$)).START$());
                new simtst98$outline(((simtst98)CUR$),new TXT$("***   xa:-new x   ***"));
                xa=((simtst98$x)new simtst98$x(((simtst98)CUR$)).START$());
                new simtst98$outline(((simtst98)CUR$),new TXT$("***   xa:-new f   ***"));
                xa=((simtst98$f)new simtst98$f(((simtst98)CUR$)).START$());
                new simtst98$outline(((simtst98)CUR$),new TXT$("***   xa:-new e   ***"));
                xa=((simtst98$e)new simtst98$e(((simtst98)CUR$)).START$());
                new simtst98$outline(((simtst98)CUR$),new TXT$("***   xa:-new d   ***"));
                xa=((simtst98$d)new simtst98$d(((simtst98)CUR$)).START$());
                new simtst98$outline(((simtst98)CUR$),new TXT$("***   xa:-new a   ***"));
                xa=((simtst98$a)new simtst98$a(((simtst98)CUR$)).START$());
                new simtst98$outline(((simtst98)CUR$),new TXT$("***   xb:-new b   ***"));
                xb=((simtst98$b)new simtst98$b(((simtst98)CUR$)).START$());
                new simtst98$outline(((simtst98)CUR$),new TXT$("***   xc:-new c   ***"));
                xc=((simtst98$c)new simtst98$c(((simtst98)CUR$)).START$());
                new simtst98$outline(((simtst98)CUR$),new TXT$("***   inspect xa  ***"));
                {
                    inspect$338$4=xa;
                    if(inspect$338$4!=null)
                    {
                        new simtst98$virtproc(((simtst98)CUR$),339,new TXT$("global"),new TXT$("***INSP XA DO VP*** "));
                        new simtst98$outattr(((simtst98)CUR$),341,new TXT$("inspect xa: prot. const 'i'="),i,globali);
                        new simtst98$outattr(((simtst98)CUR$),343,new TXT$("            prot. const 'j'="),j,globalj);
                        new simtst98$outim(((simtst98)CUR$));
                        GOTO$(L);
                    }
                }
                LABEL$(1,"L");
                new simtst98$outline(((simtst98)CUR$),new TXT$("***   inspect xb  ***"));
                {
                    inspect$349$5=xb;
                    if(inspect$349$5!=null)
                    {
                        new simtst98$outattr(((simtst98)CUR$),351,new TXT$("inspect xb: hid.prot. const 'i'="),i,globali);
                        new simtst98$outattr(((simtst98)CUR$),353,new TXT$("            hid.prot. attr. 'k'="),k,globalk);
                        new simtst98$outim(((simtst98)CUR$));
                    }
                }
                new simtst98$outline(((simtst98)CUR$),new TXT$("***   block pref. with a   ***"));
                new simtst98$PBLK358(CUR$).START$();
                new simtst98$outline(((simtst98)CUR$),new TXT$("***   block pref. with d   ***"));
                new simtst98$PBLK366(CUR$).START$();
                new simtst98$outline(((simtst98)CUR$),new TXT$("***   block pref. with e   ***"));
                new simtst98$PBLK374(CUR$).START$();
                new simtst98$outline(((simtst98)CUR$),new TXT$("***   block pref. with f   ***"));
                new simtst98$PBLK381(CUR$).START$();
                new simtst98$outline(((simtst98)CUR$),new TXT$("***   inspect new b   ***"));
                {
                    inspect$389$6=((simtst98$b)new simtst98$b(((simtst98)CUR$)).START$());
                    if(inspect$389$6!=null)
                    {
                        new simtst98$virtproc(((simtst98)CUR$),391,new TXT$("global"),new TXT$("***INSP NEW b ... virtproc***"));
                        new simtst98$b$bvirt(inspect$389$6,393,new TXT$("b.virtproc"),new TXT$("***INSP NEW b ... bvirt***"));
                    }
                }
                new simtst98$outline(((simtst98)CUR$),new TXT$("***   inspect new y   ***"));
                {
                    inspect$397$7=((simtst98$y)new simtst98$y(((simtst98)CUR$)).START$());
                    if(inspect$397$7!=null)
                    {
                        new simtst98$c$virtproc(inspect$397$7,398,new TXT$("c.virtproc"),new TXT$("***INSP NEW y ... virtproc***"));
                        new simtst98$y$yvirt(inspect$397$7,399,new TXT$("y.virtproc"),new TXT$("***INSP NEW y ... yvirt***"));
                    }
                }
                new simtst98$outline(((simtst98)CUR$),new TXT$("***   inspect new z   ***"));
                {
                    inspect$403$8=((simtst98$z)new simtst98$z(((simtst98)CUR$)).START$());
                    if(inspect$403$8!=null)
                    {
                        new simtst98$z$virtproc(inspect$403$8,405,new TXT$("z.virtproc"),new TXT$("***INSP NEW z ... virtproc***"));
                        new simtst98$x$xvirt(inspect$403$8,407,new TXT$("y.virtproc"),new TXT$("***INSP NEW y ... xvirt***"));
                        new simtst98$y$yvirt(inspect$403$8,409,new TXT$("y.virtproc"),new TXT$("***INSP NEW y ... yvirt***"));
                        new simtst98$z$zvirt(inspect$403$8,411,new TXT$("z.virtproc"),new TXT$("***INSP NEW z ... zvirt***"));
                    }
                }
                if(VALUE$((!(errorFound)))) {
                    {
                        sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 98"));
                    }
                }
                if(VALUE$((verbose|(errorFound)))) {
                    {
                        sysout().outtext(new TXT$("--- END Simula a.s. TEST 98"));
                        sysout().outimage();
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
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst98(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst98.sim","SimulaProgram simtst98",1,19,9,348,11,19,18,20,20,21,22,22,24,24,26,25,33,306,40,338,42,349,44,389,46,397,48,403,60,316,62,317,64,318,66,319,70,323,75,327,78,328,81,329,84,330,87,331,90,332,93,333,96,334,99,335,102,337,104,338,108,339,111,341,113,343,115,344,120,348,123,349,127,350,129,351,131,353,133,354,137,357,139,363,141,365,143,371,145,373,147,378,149,380,151,386,153,388,155,389,159,390,161,391,163,393,167,396,169,397,173,398,176,399,180,402,182,403,186,404,188,405,190,407,192,409,194,411,198,421,200,422,205,424,207,425,210,426,232,430);
}
