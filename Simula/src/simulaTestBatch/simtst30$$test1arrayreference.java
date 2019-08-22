package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 15 21:51:46 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst30$$test1arrayreference extends PROC$ {
    public NAME$<ARRAY$<?>> p$tt;
    public NAME$<ARRAY$<?>> p$rat;
    public NAME$<ARRAY$<?>> p$rbt;
    public ARRAY$<?> p$tv;
    public ARRAY$<?> p$rav;
    public ARRAY$<?> p$rbv;
    public int p$errnr;
    public simtst30$$test1arrayreference setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 7: p$tt=(NAME$<ARRAY$<?>>)param; break;
                case 6: p$rat=(NAME$<ARRAY$<?>>)param; break;
                case 5: p$rbt=(NAME$<ARRAY$<?>>)param; break;
                case 4: p$tv=arrayValue(param); break;
                case 3: p$rav=arrayValue(param); break;
                case 2: p$rbv=arrayValue(param); break;
                case 1: p$errnr=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst30$$test1arrayreference(RTObject$ SL$) {
        super(SL$,7);
    }
    public simtst30$$test1arrayreference(RTObject$ SL$,NAME$<ARRAY$<?>> sp$tt,NAME$<ARRAY$<?>> sp$rat,NAME$<ARRAY$<?>> sp$rbt,ARRAY$<?> sp$tv,ARRAY$<?> sp$rav,ARRAY$<?> sp$rbv,int sp$errnr) {
        super(SL$);
        this.p$tt = sp$tt;
        this.p$rat = sp$rat;
        this.p$rbt = sp$rbt;
        this.p$tv = sp$tv;
        this.p$rav = sp$rav;
        this.p$rbv = sp$rbv;
        this.p$errnr = sp$errnr;
        BBLK();
        STM$();
    }
    public simtst30$$test1arrayreference STM$() {
        if(VALUE$(((TRF_EQ(((ARRAY$<TXT$[]>)p$tt.get()).Elt[0-p$tt.get().LB[0]],((ARRAY$<TXT$[]>)p$tv).Elt[0-p$tv.LB[0]])&((((ARRAY$<simtst30$$A[]>)p$rat.get()).Elt[0-p$rat.get().LB[0]]==(((ARRAY$<simtst30$$A[]>)p$rav).Elt[0-p$rav.LB[0]]))))&((((ARRAY$<simtst30$$B[]>)p$rbt.get()).Elt[0-p$rbt.get().LB[0]]==(((ARRAY$<simtst30$$B[]>)p$rbv).Elt[0-p$rbv.LB[0]])))))) {
        } else
        {
            sysout().outtext(new TXT$("*** error : Reference ("));
            sysout().outint(p$errnr,(((p$errnr<(10)))?(1):(2)));
            sysout().outtext(new TXT$(")."));
            sysout().outimage();
            sysout().outtext(new TXT$("            Erroneus values : "));
            sysout().outimage();
            sysout().outtext(new TXT$("            "));
            sysout().outtext(((ARRAY$<TXT$[]>)p$tt.get()).Elt[0-p$tt.get().LB[0]]);
            sysout().outtext(new TXT$("   "));
            sysout().outtext(((ARRAY$<simtst30$$A[]>)p$rat.get()).Elt[0-p$rat.get().LB[0]].p$t);
            sysout().outtext(new TXT$("   "));
            sysout().outtext(((ARRAY$<simtst30$$B[]>)p$rbt.get()).Elt[0-p$rbt.get().LB[0]].p$t);
            sysout().outimage();
            ((simtst30$)(CUR$.SL$)).found_error=true;
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst30.sim","Procedure test1arrayreference",1,131,46,138,49,143,52,144,54,145,56,146,58,147,60,148,62,149,64,150,66,151,68,152,70,153,72,154,74,155,76,156,81,158);
}
