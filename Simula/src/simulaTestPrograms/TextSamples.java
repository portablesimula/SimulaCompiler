package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun Apr 21 18:07:04 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class TextSamples extends BASICIO$ {
    public int prefixLevel() { return(0); }
    TXT$ T=null;
    TXT$ U=null;
    TXT$ amount=null;
    TXT$ price=null;
    TXT$ payment=null;
    int pay=0;
    boolean b=false;
    TXT$ image=null;
    public ARRAY$<TXT$[]>TA=null;
    InFile$ file=null;
    public TextSamples(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("TextSamples");
        int[] TA$LB=new int[1]; int[] TA$UB=new int[1];
        TA$LB[0]=(-(9)); TA$UB[0]=(-(1));
        BOUND_CHECK$(TA$LB[0],TA$UB[0]);
        TA=new ARRAY$<TXT$[]>(new TXT$[TA$UB[0]-TA$LB[0]+1],TA$LB,TA$UB);
    }
    public RTObject$ STM$() {
        T=blanks(20);
        if(VALUE$(TXTREL$EQ(T,U))) {
            TA.Elt[(-(5))-TA.LB[0]]=T;
        }
        b=TXT$.more(T);
        file.setpos(8);
        amount=TXT$.sub(T,20,5);
        price=TXT$.sub(T,30,6);
        payment=TXT$.sub(T,60,10);
        if(VALUE$(TXTREL$EQ(TXT$.strip(T),new TXT$("order")))) {
            {
                pay=(TXT$.getint(amount)*(TXT$.getfrac(price)));
                TXT$.putfrac(payment,pay,2);
            }
        }
        EBLK();
        return(null);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new TextSamples(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("TextSamples.sim","SimulaProgram TextSamples",1,2,13,8,15,9,17,10,19,12,21,13,27,12,34,14,36,15,40,16,42,21,44,23,47,24,49,25,51,26,54,27,65,31);
}
