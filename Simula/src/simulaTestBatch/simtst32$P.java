package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Fri Apr 19 09:17:54 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst32$P extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public PRCQNT$ p$F;
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst32$P setPar(Object param) {
        try {
            switch($npar++) {
                case 0: p$F=procValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    public simtst32$P(RTObject$ SL$)
    { super(SL$); }
    public simtst32$P(RTObject$ SL$,PRCQNT$ sp$F) {
        super(SL$);
        this.p$F = sp$F;
        BBLK();
        STM$();
    }
    public simtst32$P STM$() {
        p$F.CPF().setPar(new NAME$<Integer>(){ public Integer get() { return(1); } }).setPar(new NAME$<Float>(){ public Float get() { return(1.2f); } }).setPar(new NAME$<Boolean>(){ public Boolean get() { return(true); } }).setPar(new NAME$<Character>(){ public Character get() { return('c'); } }).setPar(new NAME$<RTObject$>(){ public RTObject$ get() { return(null); } }).setPar(new NAME$<TXT$>(){ public TXT$ get() { return(null); } }).ENT$();
        if(VALUE$(((((((((simtst32)(CUR$.SL$)).gi==(1))&((abs(((double)((((simtst32)(CUR$.SL$)).gr-(1.2f)))))<(((double)(1.0E-4f))))))&(((simtst32)(CUR$.SL$)).gbool))&((((simtst32)(CUR$.SL$)).gch==('c'))))&((((simtst32)(CUR$.SL$)).gra==(null))))&(TXTREL$EQ(((simtst32)(CUR$.SL$)).gtext,null))))) {
        } else
        {
            sysout().outtext(new TXT$("*** error : Value of global variables (1)."));
            sysout().outimage();
            sysout().outtext(new TXT$("            Erroneus values : gi = "));
            sysout().outint(((simtst32)(CUR$.SL$)).gi,5);
            sysout().outimage();
            sysout().outtext(new TXT$("                              gr = "));
            sysout().outreal(((simtst32)(CUR$.SL$)).gr,5,12);
            sysout().outimage();
            sysout().outtext(new TXT$("                           gbool = "));
            sysout().outtext(((((simtst32)(CUR$.SL$)).gbool)?(new TXT$("true")):(new TXT$("false"))));
            sysout().outimage();
            sysout().outtext(new TXT$("                             gch = "));
            sysout().outchar(((simtst32)(CUR$.SL$)).gch);
            sysout().outimage();
            sysout().outtext(new TXT$("                             gra == "));
            sysout().outtext((((((simtst32)(CUR$.SL$)).gra==(null)))?(new TXT$("notext")):(((IS$(((simtst32)(CUR$.SL$)).gra,simtst32$A.class))?(new TXT$("object of A")):(((IS$(((simtst32)(CUR$.SL$)).gra,simtst32$B.class))?(new TXT$("object of B")):(new TXT$("object of C"))))))));
            sysout().outimage();
            sysout().outtext(new TXT$("                           gtext = "));
            sysout().outtext(((TXTREL$EQ(((simtst32)(CUR$.SL$)).gtext,null))?(new TXT$("notext")):(((simtst32)(CUR$.SL$)).gtext)));
            sysout().outimage();
            sysout().outimage();
            ((simtst32)(CUR$.SL$)).found_error=true;
        }
        p$F.CPF().setPar(new NAME$<PRCQNT$>(){ public PRCQNT$ get() { return(new PRCQNT$(((simtst32)(CUR$.SL$)),simtst32$ip.class)); } }).setPar(new NAME$<Integer>(){ public Integer get() { return((new simtst32$ip(((simtst32)(CUR$.SL$))).RESULT$+(1))); } }).setPar(new NAME$<Boolean>(){ public Boolean get() { return(false); } }).setPar(new NAME$<Character>(){ public Character get() { return(((true)?('t'):('f'))); } }).setPar(new NAME$<PRCQNT$>(){ public PRCQNT$ get() { return(new PRCQNT$(((simtst32)(CUR$.SL$)),simtst32$Rap.class)); } }).setPar(new NAME$<TXT$>(){ public TXT$ get() { return(copy(copy(new TXT$("abc")))); } }).ENT$();
        if(VALUE$(((((((((simtst32)(CUR$.SL$)).gi==(11))&((abs(((double)((((simtst32)(CUR$.SL$)).gr-(((float)(12)))))))<(((double)(1.0E-4f))))))&((!(((simtst32)(CUR$.SL$)).gbool))))&((((simtst32)(CUR$.SL$)).gch==('t'))))&((((simtst32)(CUR$.SL$)).gra!=(null))))&(TXTREL$EQ(((simtst32)(CUR$.SL$)).gtext,new TXT$("abc")))))) {
        } else
        {
            sysout().outtext(new TXT$("*** error : Value of global variables (2)."));
            sysout().outimage();
            sysout().outtext(new TXT$("            Erroneus values : gi = "));
            sysout().outint(((simtst32)(CUR$.SL$)).gi,5);
            sysout().outimage();
            sysout().outtext(new TXT$("                              gr = "));
            sysout().outreal(((simtst32)(CUR$.SL$)).gr,5,12);
            sysout().outimage();
            sysout().outtext(new TXT$("                           gbool = "));
            sysout().outtext(((((simtst32)(CUR$.SL$)).gbool)?(new TXT$("true")):(new TXT$("false"))));
            sysout().outimage();
            sysout().outtext(new TXT$("                             gch = "));
            sysout().outchar(((simtst32)(CUR$.SL$)).gch);
            sysout().outimage();
            sysout().outtext(new TXT$("                             gra == "));
            sysout().outtext((((((simtst32)(CUR$.SL$)).gra==(null)))?(new TXT$("notext")):(((IS$(((simtst32)(CUR$.SL$)).gra,simtst32$A.class))?(new TXT$("object of A")):(((IS$(((simtst32)(CUR$.SL$)).gra,simtst32$B.class))?(new TXT$("object of B")):(new TXT$("object of C"))))))));
            sysout().outimage();
            sysout().outtext(new TXT$("                           gtext = "));
            sysout().outtext(((TXTREL$EQ(((simtst32)(CUR$.SL$)).gtext,null))?(new TXT$("notext")):(((simtst32)(CUR$.SL$)).gtext)));
            sysout().outimage();
            sysout().outimage();
            ((simtst32)(CUR$.SL$)).found_error=true;
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst32.sim","Procedure P",1,63,29,65,31,67,34,78,37,79,39,80,41,81,43,82,45,83,47,84,49,85,51,86,53,87,55,88,57,89,59,90,61,91,63,92,65,96,67,97,69,98,71,99,73,100,76,101,79,104,81,106,84,115,87,116,89,117,91,118,93,119,95,120,97,121,99,122,101,123,103,124,105,125,107,126,109,127,111,128,113,129,115,133,117,134,119,135,121,136,123,137,126,138,131,141);
}
