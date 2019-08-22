package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 15 21:51:46 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst30$ extends BASICIO$ {
    public boolean isQPSystemBlock() { return(true); }
    boolean found_error=false;
    final boolean verbose=(boolean)(false);
    boolean bv=false;
    char cv=0;
    int iv=0;
    float rv=0.0f;
    TXT$ tv=null;
    simtst30$$A rav=null;
    simtst30$$B rbv=null;
    public ARRAY$<boolean[]>bva1=null;
    public ARRAY$<char[]>cva1=null;
    public ARRAY$<int[]>iva1=null;
    public ARRAY$<float[]>rva1=null;
    public ARRAY$<TXT$[]>tva1=null;
    public ARRAY$<simtst30$$A[]>rava1=null;
    public ARRAY$<simtst30$$B[]>rbva1=null;
    public simtst30$(RTObject$ staticLink) {
        super(staticLink);
        BBLK();
        BPRG("simtst30$");
        int[] bva1$LB=new int[1]; int[] bva1$UB=new int[1];
        bva1$LB[0]=0; bva1$UB[0]=0;
        BOUND_CHECK$(bva1$LB[0],bva1$UB[0]);
        bva1=new ARRAY$<boolean[]>(new boolean[bva1$UB[0]-bva1$LB[0]+1],bva1$LB,bva1$UB);
        int[] cva1$LB=new int[1]; int[] cva1$UB=new int[1];
        cva1$LB[0]=0; cva1$UB[0]=0;
        BOUND_CHECK$(cva1$LB[0],cva1$UB[0]);
        cva1=new ARRAY$<char[]>(new char[cva1$UB[0]-cva1$LB[0]+1],cva1$LB,cva1$UB);
        int[] iva1$LB=new int[1]; int[] iva1$UB=new int[1];
        iva1$LB[0]=0; iva1$UB[0]=0;
        BOUND_CHECK$(iva1$LB[0],iva1$UB[0]);
        iva1=new ARRAY$<int[]>(new int[iva1$UB[0]-iva1$LB[0]+1],iva1$LB,iva1$UB);
        int[] rva1$LB=new int[1]; int[] rva1$UB=new int[1];
        rva1$LB[0]=0; rva1$UB[0]=0;
        BOUND_CHECK$(rva1$LB[0],rva1$UB[0]);
        rva1=new ARRAY$<float[]>(new float[rva1$UB[0]-rva1$LB[0]+1],rva1$LB,rva1$UB);
        int[] tva1$LB=new int[1]; int[] tva1$UB=new int[1];
        tva1$LB[0]=0; tva1$UB[0]=0;
        BOUND_CHECK$(tva1$LB[0],tva1$UB[0]);
        tva1=new ARRAY$<TXT$[]>(new TXT$[tva1$UB[0]-tva1$LB[0]+1],tva1$LB,tva1$UB);
        int[] rava1$LB=new int[1]; int[] rava1$UB=new int[1];
        rava1$LB[0]=0; rava1$UB[0]=0;
        BOUND_CHECK$(rava1$LB[0],rava1$UB[0]);
        rava1=new ARRAY$<simtst30$$A[]>(new simtst30$$A[rava1$UB[0]-rava1$LB[0]+1],rava1$LB,rava1$UB);
        int[] rbva1$LB=new int[1]; int[] rbva1$UB=new int[1];
        rbva1$LB[0]=0; rbva1$UB[0]=0;
        BOUND_CHECK$(rbva1$LB[0],rbva1$UB[0]);
        rbva1=new ARRAY$<simtst30$$B[]>(new simtst30$$B[rbva1$UB[0]-rbva1$LB[0]+1],rbva1$LB,rbva1$UB);
    }
    public RTObject$ STM$() {
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- START Simula a.s. TEST 30"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- Test transmission by name - value types, text, object"));
                sysout().outimage();
                sysout().outtext(new TXT$("--- reference type and arrays of these types."));
                sysout().outimage();
                sysout().outimage();
            }
        }
        new simtst30$$Setvariables(((simtst30$)(CUR$)));
        new simtst30$$P(((simtst30$)(CUR$)),new NAME$<Boolean>(){ public Boolean get() { return(bv); } public Boolean put(Boolean x$) { return(bv=(boolean)x$); } },new NAME$<Character>(){ public Character get() { return(cv); } public Character put(Character x$) { return(cv=(char)x$); } },new NAME$<Integer>(){ public Integer get() { return(iv); } public Integer put(Integer x$) { return(iv=(int)x$); } },new NAME$<Float>(){ public Float get() { return(rv); } public Float put(Float x$) { return(rv=(float)x$); } },new NAME$<TXT$>(){ public TXT$ get() { return(tv); } public TXT$ put(TXT$ x$) { return(tv=(TXT$)x$); } },new NAME$<simtst30$$A>(){ public simtst30$$A get() { return(rav); } public simtst30$$A put(simtst30$$A x$) { return(rav=(simtst30$$A)x$); } },new NAME$<simtst30$$B>(){ public simtst30$$B get() { return(rbv); } public simtst30$$B put(simtst30$$B x$) { return(rbv=(simtst30$$B)x$); } });
        new simtst30$$Q(((simtst30$)(CUR$)),new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(bva1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(cva1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(iva1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(rva1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(tva1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(rava1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(rbva1); } });
        new simtst30$$A$Setvariables(rav);
        new simtst30$$P2(((simtst30$)(CUR$)),new NAME$<Boolean>(){ public Boolean get() { return(rav.bv); } public Boolean put(Boolean x$) { return(rav.bv=(boolean)x$); } },new NAME$<Character>(){ public Character get() { return(rav.cv); } public Character put(Character x$) { return(rav.cv=(char)x$); } },new NAME$<Integer>(){ public Integer get() { return(rav.iv); } public Integer put(Integer x$) { return(rav.iv=(int)x$); } },new NAME$<Float>(){ public Float get() { return(rav.rv); } public Float put(Float x$) { return(rav.rv=(float)x$); } },new NAME$<TXT$>(){ public TXT$ get() { return(rav.tv); } public TXT$ put(TXT$ x$) { return(rav.tv=(TXT$)x$); } },new NAME$<simtst30$$A>(){ public simtst30$$A get() { return(rav.rav); } public simtst30$$A put(simtst30$$A x$) { return(rav.rav=(simtst30$$A)x$); } },new NAME$<simtst30$$B>(){ public simtst30$$B get() { return(rav.rbv); } public simtst30$$B put(simtst30$$B x$) { return(rav.rbv=(simtst30$$B)x$); } });
        new simtst30$$Q2(((simtst30$)(CUR$)),new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(rav.bva1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(rav.cva1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(rav.iva1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(rav.rva1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(rav.tva1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(rav.rava1); } },new NAME$<ARRAY$<?>>(){ public ARRAY$<?> get() { return(rav.rbva1); } });
        if(VALUE$(found_error)) {
        } else
        {
            sysout().outtext(new TXT$("--- NO ERRORS FOUND IN TEST 30"));
        }
        if(VALUE$(verbose)) {
            {
                sysout().outtext(new TXT$("--- END Simula a.s. TEST 30"));
                sysout().outimage();
            }
        }
        EBLK();
        return(this);
    }
    
    public static void main(String[] args) {
        RT.setRuntimeOptions(args);
        new simtst30$(CTX$).STM$();
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst30.sim","SimulaProgram simtst30$",1,11,9,12,11,386,13,387,15,388,17,389,19,390,21,391,23,392,25,393,27,394,29,395,31,396,33,397,35,398,37,399,43,393,48,394,53,395,58,396,63,397,68,398,73,399,80,402,82,403,85,404,87,405,89,406,91,407,93,408,98,411,100,413,102,415,104,418,106,420,108,423,110,427,113,430,117,433,119,434,122,438,133,438);
}
