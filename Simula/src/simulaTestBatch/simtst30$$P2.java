package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 15 21:51:46 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst30$$P2 extends PROC$ {
    public NAME$<Boolean> p$bf;
    public NAME$<Character> p$cf;
    public NAME$<Integer> p$jf;
    public NAME$<Float> p$rf;
    public NAME$<TXT$> p$tf;
    public NAME$<simtst30$$A> p$raf;
    public NAME$<simtst30$$B> p$rbf;
    public simtst30$$P2 setPar(Object param) {
        try {
            switch($nParLeft--) {
                case 7: p$bf=(NAME$<Boolean>)param; break;
                case 6: p$cf=(NAME$<Character>)param; break;
                case 5: p$jf=(NAME$<Integer>)param; break;
                case 4: p$rf=(NAME$<Float>)param; break;
                case 3: p$tf=(NAME$<TXT$>)param; break;
                case 2: p$raf=(NAME$<simtst30$$A>)param; break;
                case 1: p$rbf=(NAME$<simtst30$$B>)param; break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    public simtst30$$P2(RTObject$ SL$) {
        super(SL$,7);
    }
    public simtst30$$P2(RTObject$ SL$,NAME$<Boolean> sp$bf,NAME$<Character> sp$cf,NAME$<Integer> sp$jf,NAME$<Float> sp$rf,NAME$<TXT$> sp$tf,NAME$<simtst30$$A> sp$raf,NAME$<simtst30$$B> sp$rbf) {
        super(SL$);
        this.p$bf = sp$bf;
        this.p$cf = sp$cf;
        this.p$jf = sp$jf;
        this.p$rf = sp$rf;
        this.p$tf = sp$tf;
        this.p$raf = sp$raf;
        this.p$rbf = sp$rbf;
        BBLK();
        STM$();
    }
    public simtst30$$P2 STM$() {
        p$bf.put(false);
        p$cf.put('X');
        p$jf.put(99);
        p$rf.put(99.0f);
        ASGSTR$(p$tf.get(),"tf");
        ASGSTR$(p$raf.get().p$t,"raf");
        ASGSTR$(p$rbf.get().p$t,"rbf");
        new simtst30$$testvalue(((simtst30$)(CUR$.SL$)),new NAME$<Boolean>(){ public Boolean get() { return(((simtst30$)(CUR$.SL$)).rav.bv); } public Boolean put(Boolean x$) { return(((simtst30$)(CUR$.SL$)).rav.bv=(boolean)x$); } },new NAME$<Character>(){ public Character get() { return(((simtst30$)(CUR$.SL$)).rav.cv); } public Character put(Character x$) { return(((simtst30$)(CUR$.SL$)).rav.cv=(char)x$); } },new NAME$<Integer>(){ public Integer get() { return(((simtst30$)(CUR$.SL$)).rav.iv); } public Integer put(Integer x$) { return(((simtst30$)(CUR$.SL$)).rav.iv=(int)x$); } },new NAME$<Float>(){ public Float get() { return(((simtst30$)(CUR$.SL$)).rav.rv); } public Float put(Float x$) { return(((simtst30$)(CUR$.SL$)).rav.rv=(float)x$); } },new NAME$<TXT$>(){ public TXT$ get() { return(((simtst30$)(CUR$.SL$)).rav.tv); } public TXT$ put(TXT$ x$) { return(((simtst30$)(CUR$.SL$)).rav.tv=(TXT$)x$); } },new NAME$<simtst30$$A>(){ public simtst30$$A get() { return(((simtst30$)(CUR$.SL$)).rav.rav); } public simtst30$$A put(simtst30$$A x$) { return(((simtst30$)(CUR$.SL$)).rav.rav=(simtst30$$A)x$); } },new NAME$<simtst30$$B>(){ public simtst30$$B get() { return(((simtst30$)(CUR$.SL$)).rav.rbv); } public simtst30$$B put(simtst30$$B x$) { return(((simtst30$)(CUR$.SL$)).rav.rbv=(simtst30$$B)x$); } },false,'X',99,99.0f,p$tf.get(),p$raf.get(),p$rbf.get(),1);
        p$tf.put(copy(copy(new TXT$("REFCD BY tf"))));
        p$raf.put(new simtst30$$A(((simtst30$)(CUR$.SL$)),copy(new TXT$("REFCD BY raf"))).STM$());
        p$rbf.put(new simtst30$$B(((simtst30$)(CUR$.SL$)),copy(new TXT$("REFCD BY rbf"))).STM$());
        new simtst30$$testreference(((simtst30$)(CUR$.SL$)),((simtst30$)(CUR$.SL$)).rav.tv,((simtst30$)(CUR$.SL$)).rav.rav,((simtst30$)(CUR$.SL$)).rav.rbv,p$tf.get(),p$raf.get(),p$rbf.get(),2);
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst30.sim","Procedure P2",1,225,46,236,48,237,50,238,52,239,54,240,56,241,58,242,60,245,62,247,64,248,66,249,68,251,72,253);
}
