package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 15 21:51:46 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst30$$testvalue extends PROC$ {
    public NAME$<Boolean> p$bt;
    public NAME$<Character> p$ct;
    public NAME$<Integer> p$jt;
    public NAME$<Float> p$rt;
    public NAME$<TXT$> p$tt;
    public NAME$<simtst30$$A> p$rat;
    public NAME$<simtst30$$B> p$rbt;
    public boolean p$bv;
    public char p$cv;
    public int p$jv;
    public float p$rv;
    public TXT$ p$tv;
    public simtst30$$A p$rav;
    public simtst30$$B p$rbv;
    public int p$errnr;
    public simtst30$$testvalue setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 15: p$bt=(NAME$<Boolean>)param; break;
                case 14: p$ct=(NAME$<Character>)param; break;
                case 13: p$jt=(NAME$<Integer>)param; break;
                case 12: p$rt=(NAME$<Float>)param; break;
                case 11: p$tt=(NAME$<TXT$>)param; break;
                case 10: p$rat=(NAME$<simtst30$$A>)param; break;
                case 9: p$rbt=(NAME$<simtst30$$B>)param; break;
                case 8: p$bv=(boolean)objectValue(param); break;
                case 7: p$cv=(char)objectValue(param); break;
                case 6: p$jv=intValue(param); break;
                case 5: p$rv=floatValue(param); break;
                case 4: p$tv=(TXT$)objectValue(param); break;
                case 3: p$rav=(simtst30$$A)objectValue(param); break;
                case 2: p$rbv=(simtst30$$B)objectValue(param); break;
                case 1: p$errnr=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst30$$testvalue(RTObject$ SL$) {
        super(SL$,15);
    }
    public simtst30$$testvalue(RTObject$ SL$,NAME$<Boolean> sp$bt,NAME$<Character> sp$ct,NAME$<Integer> sp$jt,NAME$<Float> sp$rt,NAME$<TXT$> sp$tt,NAME$<simtst30$$A> sp$rat,NAME$<simtst30$$B> sp$rbt,boolean sp$bv,char sp$cv,int sp$jv,float sp$rv,TXT$ sp$tv,simtst30$$A sp$rav,simtst30$$B sp$rbv,int sp$errnr) {
        super(SL$);
        this.p$bt = sp$bt;
        this.p$ct = sp$ct;
        this.p$jt = sp$jt;
        this.p$rt = sp$rt;
        this.p$tt = sp$tt;
        this.p$rat = sp$rat;
        this.p$rbt = sp$rbt;
        this.p$bv = sp$bv;
        this.p$cv = sp$cv;
        this.p$jv = sp$jv;
        this.p$rv = sp$rv;
        this.p$tv = sp$tv;
        this.p$rav = sp$rav;
        this.p$rbv = sp$rbv;
        this.p$errnr = sp$errnr;
        BBLK();
        STM$();
    }
    public simtst30$$testvalue STM$() {
        if(VALUE$(((p$bt.get()) == (((((((p$bv&((p$ct.get()==(p$cv))))&((p$jt.get()==(p$jv))))&((p$rt.get()==(p$rv))))&(TXTREL$EQ(p$tt.get(),p$tv)))&(TXTREL$EQ(p$rat.get().p$t,p$rav.p$t)))&(TXTREL$EQ(p$rbt.get().p$t,p$rbv.p$t))))))) {
        } else
        {
            sysout().outtext(new TXT$("*** error : Value of variables ("));
            sysout().outint(p$errnr,(((p$errnr<(10)))?(1):(2)));
            sysout().outtext(new TXT$(")."));
            sysout().outimage();
            sysout().outtext(new TXT$("            Erroneus values :"));
            sysout().outtext(((p$bt.get())?(new TXT$(" true ")):(new TXT$(" false "))));
            sysout().outchar(p$ct.get());
            sysout().outint(p$jt.get(),4);
            sysout().outimage();
            sysout().outtext(new TXT$("            "));
            sysout().outreal(p$rt.get(),5,12);
            sysout().outtext(new TXT$("   "));
            sysout().outtext(p$tt.get());
            sysout().outtext(new TXT$("   "));
            sysout().outtext(p$rat.get().p$t);
            sysout().outtext(new TXT$("   "));
            sysout().outtext(p$rbt.get().p$t);
            sysout().outimage();
            ((simtst30$)(CUR$.SL$)).found_error=true;
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst30.sim","Procedure testvalue",1,14,70,26,73,35,76,36,78,37,80,38,82,39,84,40,86,41,88,42,90,43,92,44,94,45,96,46,98,47,100,48,102,49,104,50,106,51,108,52,110,53,115,55);
}
