package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 15 21:51:46 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst30$$Q extends PROC$ {
    public NAME$<ARRAY$<?>> p$bfa1;
    public NAME$<ARRAY$<?>> p$cfa1;
    public NAME$<ARRAY$<?>> p$ifa1;
    public NAME$<ARRAY$<?>> p$rfa1;
    public NAME$<ARRAY$<?>> p$tfa1;
    public NAME$<ARRAY$<?>> p$rafa1;
    public NAME$<ARRAY$<?>> p$rbfa1;
    public simtst30$$Q setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 7: p$bfa1=(NAME$<ARRAY$<?>>)param; break;
                case 6: p$cfa1=(NAME$<ARRAY$<?>>)param; break;
                case 5: p$ifa1=(NAME$<ARRAY$<?>>)param; break;
                case 4: p$rfa1=(NAME$<ARRAY$<?>>)param; break;
                case 3: p$tfa1=(NAME$<ARRAY$<?>>)param; break;
                case 2: p$rafa1=(NAME$<ARRAY$<?>>)param; break;
                case 1: p$rbfa1=(NAME$<ARRAY$<?>>)param; break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst30$$Q(RTObject$ SL$) {
        super(SL$,7);
    }
    public simtst30$$Q(RTObject$ SL$,NAME$<ARRAY$<?>> sp$bfa1,NAME$<ARRAY$<?>> sp$cfa1,NAME$<ARRAY$<?>> sp$ifa1,NAME$<ARRAY$<?>> sp$rfa1,NAME$<ARRAY$<?>> sp$tfa1,NAME$<ARRAY$<?>> sp$rafa1,NAME$<ARRAY$<?>> sp$rbfa1) {
        super(SL$);
        this.p$bfa1 = sp$bfa1;
        this.p$cfa1 = sp$cfa1;
        this.p$ifa1 = sp$ifa1;
        this.p$rfa1 = sp$rfa1;
        this.p$tfa1 = sp$tfa1;
        this.p$rafa1 = sp$rafa1;
        this.p$rbfa1 = sp$rbfa1;
        BBLK();
        STM$();
    }
    public simtst30$$Q STM$() {
        ((ARRAY$<boolean[]>)p$bfa1.get()).Elt[0-p$bfa1.get().LB[0]]=false;
        ((ARRAY$<char[]>)p$cfa1.get()).Elt[0-p$cfa1.get().LB[0]]='X';
        ((ARRAY$<int[]>)p$ifa1.get()).Elt[0-p$ifa1.get().LB[0]]=99;
        ((ARRAY$<float[]>)p$rfa1.get()).Elt[0-p$rfa1.get().LB[0]]=99.0f;
        ASGSTR$(((ARRAY$<TXT$[]>)p$tfa1.get()).Elt[0-p$tfa1.get().LB[0]],"tfa");
        ASGSTR$(((ARRAY$<simtst30$$A[]>)p$rafa1.get()).Elt[0-p$rafa1.get().LB[0]].p$t,"rafa1 (0)");
        ASGSTR$(((ARRAY$<simtst30$$B[]>)p$rbfa1.get()).Elt[0-p$rbfa1.get().LB[0]].p$t,"rbfa (0)");
        new simtst30$$test1arrayvalue(((simtst30$)(CUR$.SL$)),new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(((simtst30$)(CUR$.SL$)).bva1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(((simtst30$)(CUR$.SL$)).cva1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(((simtst30$)(CUR$.SL$)).iva1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(((simtst30$)(CUR$.SL$)).rva1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(((simtst30$)(CUR$.SL$)).tva1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(((simtst30$)(CUR$.SL$)).rava1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(((simtst30$)(CUR$.SL$)).rbva1); } },false,'X',99,99.0f,((ARRAY$<TXT$[]>)p$tfa1.get()).Elt[0-p$tfa1.get().LB[0]],((ARRAY$<simtst30$$A[]>)p$rafa1.get()).Elt[0-p$rafa1.get().LB[0]],((ARRAY$<simtst30$$B[]>)p$rbfa1.get()).Elt[0-p$rbfa1.get().LB[0]],3);
        ((ARRAY$<TXT$[]>)p$tfa1.get()).Elt[0-p$tfa1.get().LB[0]]=((simtst30$)(CUR$.SL$)).tv;
        ((ARRAY$<simtst30$$A[]>)p$rafa1.get()).Elt[0-p$rafa1.get().LB[0]]=((simtst30$)(CUR$.SL$)).rav;
        ((ARRAY$<simtst30$$B[]>)p$rbfa1.get()).Elt[0-p$rbfa1.get().LB[0]]=((simtst30$)(CUR$.SL$)).rbv;
        new simtst30$$test1arrayreference(((simtst30$)(CUR$.SL$)),new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(((simtst30$)(CUR$.SL$)).tva1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(((simtst30$)(CUR$.SL$)).rava1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(((simtst30$)(CUR$.SL$)).rbva1); } },p$tfa1.get(),p$rafa1.get(),p$rbfa1.get(),4);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst30.sim","Procedure Q",1,192,46,204,48,205,50,206,52,207,54,208,56,209,58,210,60,213,62,215,64,216,66,217,68,219,72,221);
}
