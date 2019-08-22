package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 15 21:51:46 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst30$$test1arrayvalue extends PROC$ {
    public NAME$<ARRAY$<?>> p$b;
    public NAME$<ARRAY$<?>> p$c;
    public NAME$<ARRAY$<?>> p$i;
    public NAME$<ARRAY$<?>> p$r;
    public NAME$<ARRAY$<?>> p$t;
    public NAME$<ARRAY$<?>> p$ra;
    public NAME$<ARRAY$<?>> p$rb;
    public boolean p$bv;
    public char p$cv;
    public int p$iv;
    public float p$rv;
    public TXT$ p$tv;
    public simtst30$$A p$rav;
    public simtst30$$B p$rbv;
    public int p$errnr;
    public simtst30$$test1arrayvalue setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 15: p$b=(NAME$<ARRAY$<?>>)param; break;
                case 14: p$c=(NAME$<ARRAY$<?>>)param; break;
                case 13: p$i=(NAME$<ARRAY$<?>>)param; break;
                case 12: p$r=(NAME$<ARRAY$<?>>)param; break;
                case 11: p$t=(NAME$<ARRAY$<?>>)param; break;
                case 10: p$ra=(NAME$<ARRAY$<?>>)param; break;
                case 9: p$rb=(NAME$<ARRAY$<?>>)param; break;
                case 8: p$bv=(boolean)objectValue(param); break;
                case 7: p$cv=(char)objectValue(param); break;
                case 6: p$iv=intValue(param); break;
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
    public simtst30$$test1arrayvalue(RTObject$ SL$) {
        super(SL$,15);
    }
    public simtst30$$test1arrayvalue(RTObject$ SL$,NAME$<ARRAY$<?>> sp$b,NAME$<ARRAY$<?>> sp$c,NAME$<ARRAY$<?>> sp$i,NAME$<ARRAY$<?>> sp$r,NAME$<ARRAY$<?>> sp$t,NAME$<ARRAY$<?>> sp$ra,NAME$<ARRAY$<?>> sp$rb,boolean sp$bv,char sp$cv,int sp$iv,float sp$rv,TXT$ sp$tv,simtst30$$A sp$rav,simtst30$$B sp$rbv,int sp$errnr) {
        super(SL$);
        this.p$b = sp$b;
        this.p$c = sp$c;
        this.p$i = sp$i;
        this.p$r = sp$r;
        this.p$t = sp$t;
        this.p$ra = sp$ra;
        this.p$rb = sp$rb;
        this.p$bv = sp$bv;
        this.p$cv = sp$cv;
        this.p$iv = sp$iv;
        this.p$rv = sp$rv;
        this.p$tv = sp$tv;
        this.p$rav = sp$rav;
        this.p$rbv = sp$rbv;
        this.p$errnr = sp$errnr;
        BBLK();
        STM$();
    }
    public simtst30$$test1arrayvalue STM$() {
        if(VALUE$(((((ARRAY$<boolean[]>)p$b.get()).Elt[0-p$b.get().LB[0]]) == ((((((p$bv&((((ARRAY$<char[]>)p$c.get()).Elt[0-p$c.get().LB[0]]==(p$cv))))&((((ARRAY$<int[]>)p$i.get()).Elt[0-p$i.get().LB[0]]==(p$iv))))&((((ARRAY$<float[]>)p$r.get()).Elt[0-p$r.get().LB[0]]==(p$rv))))&(TXTREL$EQ(((ARRAY$<simtst30$$A[]>)p$ra.get()).Elt[0-p$ra.get().LB[0]].p$t,p$rav.p$t)))&(TXTREL$EQ(((ARRAY$<simtst30$$B[]>)p$rb.get()).Elt[0-p$rb.get().LB[0]].p$t,p$rbv.p$t))))))) {
        } else
        {
            sysout().outtext(new TXT$("*** error : Array values ("));
            sysout().outint(p$errnr,(((p$errnr<(10)))?(1):(2)));
            sysout().outtext(new TXT$(")."));
            sysout().outimage();
            sysout().outtext(new TXT$("            Erroneus values : "));
            sysout().outimage();
            sysout().outtext(new TXT$("            "));
            sysout().outtext(((((ARRAY$<boolean[]>)p$b.get()).Elt[0-p$b.get().LB[0]])?(new TXT$("true ")):(new TXT$("false "))));
            sysout().outchar(((ARRAY$<char[]>)p$c.get()).Elt[0-p$c.get().LB[0]]);
            sysout().outint(((ARRAY$<int[]>)p$i.get()).Elt[0-p$i.get().LB[0]],6);
            sysout().outreal(((ARRAY$<float[]>)p$r.get()).Elt[0-p$r.get().LB[0]],5,12);
            sysout().outimage();
            sysout().outtext(new TXT$("            "));
            sysout().outtext(((ARRAY$<TXT$[]>)p$t.get()).Elt[0-p$t.get().LB[0]]);
            sysout().outtext(new TXT$("   "));
            sysout().outtext(((ARRAY$<simtst30$$A[]>)p$ra.get()).Elt[0-p$ra.get().LB[0]].p$t);
            sysout().outtext(new TXT$("   "));
            sysout().outtext(((ARRAY$<simtst30$$B[]>)p$rb.get()).Elt[0-p$rb.get().LB[0]].p$t);
            sysout().outimage();
            ((simtst30$)(CUR$.SL$)).found_error=true;
        }
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst30.sim","Procedure test1arrayvalue",1,86,70,99,73,107,76,108,78,109,80,110,82,111,84,112,86,113,88,114,90,115,92,116,94,117,96,118,98,119,100,120,102,121,104,122,106,123,108,124,110,125,112,126,117,128);
}
