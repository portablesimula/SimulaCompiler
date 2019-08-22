package simulaTestBatch;
// Simula-1.0 Compiled at Thu Aug 15 21:51:46 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class simtst30$$A extends CLASS$ {
    public TXT$ p$t;
    public boolean bv=false;
    public char cv=0;
    public int iv=0;
    public float rv=0.0f;
    public TXT$ tv=null;
    public simtst30$$A rav=null;
    public simtst30$$B rbv=null;
    public ARRAY$<boolean[]>bva1=null;
    public ARRAY$<char[]>cva1=null;
    public ARRAY$<int[]>iva1=null;
    public ARRAY$<float[]>rva1=null;
    public ARRAY$<TXT$[]>tva1=null;
    public ARRAY$<simtst30$$A[]>rava1=null;
    public ARRAY$<simtst30$$B[]>rbva1=null;
    public simtst30$$A(RTObject$ staticLink,TXT$ sp$t) {
        super(staticLink);
        this.p$t = sp$t;
        BBLK(); // Iff no prefix
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
    public simtst30$$A STM$() {
        EBLK();
        return(this);
    }
    public static PROGINFO$ INFO$=new PROGINFO$("simtst30.sim","Class A",1,291,8,328,10,329,12,330,14,331,16,332,18,333,20,334,22,335,24,336,26,337,28,338,30,339,32,340,34,341,40,335,45,336,50,337,55,338,60,339,65,340,70,341,77,343,80,343);
}
