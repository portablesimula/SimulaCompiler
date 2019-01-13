// JavaLine 1 ==> SourceLine 52
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Jan 12 15:31:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst100$testputget$err extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=52, lastLine=84, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$messt;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 75
    final LABQNT$ PRINT=new LABQNT$(this,0,1); // Local Label #1=PRINT
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 53
    TXT$ t1=null;
    TXT$ t2=null;
    double diff=0.0d;
    int ndigits=0;
    // JavaLine 20 ==> SourceLine 54
    boolean ident=false;
    // JavaLine 22 ==> SourceLine 75
    OutFile$ inspect$75$0=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst100$testputget$err setPar(Object param) {
        //Util.BREAK("CALL simtst100$testputget$err.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$messt=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst100$testputget$err(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simtst100$testputget$err(RTObject$ SL$,TXT$ sp$messt) {
        super(SL$);
        // Parameter assignment to locals
        this.p$messt = sp$messt;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("err",75);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst100$testputget$err STM$() {
        TRACE_BEGIN_STM$("err",75);
        simtst100$testputget$err THIS$=(simtst100$testputget$err)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 57 ==> SourceLine 55
                ident=TRF_EQ(p$messt,((simtst100)(CUR$.SL$.SL$)).putgetput);
                // JavaLine 59 ==> SourceLine 56
                t1=((ident)?(((simtst100)(CUR$.SL$.SL$)).st):(((simtst100)(CUR$.SL$.SL$)).prevt));
                // JavaLine 61 ==> SourceLine 57
                t2=((simtst100)(CUR$.SL$.SL$)).t;
                TXT$.setpos(t1,1);
                TXT$.setpos(t2,1);
                // JavaLine 65 ==> SourceLine 58
                if(TXTREL$EQ(t1,t2)) {
                    GOTO$(PRINT); // GOTO EVALUATED LABEL
                }
                // JavaLine 69 ==> SourceLine 59
                while((TXT$.getchar(t1)!=('.'))) {
                    TXT$.getchar(t2);
                }
                // JavaLine 73 ==> SourceLine 60
                TXT$.setpos(t2,(TXT$.pos(t2)+(1)));
                // JavaLine 75 ==> SourceLine 61
                ndigits=16;
                // JavaLine 77 ==> SourceLine 62
                if((TXT$.getchar(t1)!=(TXT$.getchar(t2)))) {
                    // JavaLine 79 ==> SourceLine 64
                    {
                        TRACE_BEGIN_STM$("CompoundStatement64",64);
                        while(((rank(TXT$.getchar(t1))+(rank(TXT$.getchar(t2))))==(((simtst100$testputget)(CUR$.SL$)).ten))) {
                            // JavaLine 83 ==> SourceLine 65
                            ndigits=(ndigits-(1));
                        }
                        TRACE_END_STM$("CompoundStatement64",65);
                    }
                } else
                // JavaLine 89 ==> SourceLine 66
                while((TXT$.getchar(t1)==(TXT$.getchar(t2)))) {
                    // JavaLine 91 ==> SourceLine 67
                    ndigits=(ndigits-(1));
                }
                // JavaLine 94 ==> SourceLine 68
                diff=abs(((double)((TXT$.getint(TXT$.sub(t1,(TXT$.pos(t1)-(1)),ndigits))-(TXT$.getint(TXT$.sub(t2,(TXT$.pos(t2)-(1)),ndigits)))))));
                // JavaLine 96 ==> SourceLine 70
                while(((diff/(Math.pow(10.0d,((double)(ndigits)))))<=(((double)(0.47f))))) {
                    // JavaLine 98 ==> SourceLine 71
                    ndigits=(ndigits-(1));
                }
                // JavaLine 101 ==> SourceLine 72
                if((ndigits>(0))) {
                    ndigits=(ndigits-(1));
                }
                // JavaLine 105 ==> SourceLine 73
                if(((((simtst100)(CUR$.SL$.SL$)).signpos-(ndigits))<(((simtst100$testputget)(CUR$.SL$)).significance))) {
                    // JavaLine 107 ==> SourceLine 74
                    {
                        TRACE_BEGIN_STM$("CompoundStatement74",74);
                        ((simtst100$testputget)(CUR$.SL$)).significance=(((simtst100)(CUR$.SL$.SL$)).signpos-(ndigits));
                        // JavaLine 111 ==> SourceLine 82
                        LABEL$(1); // PRINT
                        // JavaLine 113 ==> SourceLine 75
                        {
                            // BEGIN INSPECTION 
                            inspect$75$0=((simtst100)(CUR$.SL$.SL$)).putget;
                            if(inspect$75$0!=null) //INSPECT inspect$75$0
                            // JavaLine 118 ==> SourceLine 76
                            {
                                TRACE_BEGIN_STM$("CompoundStatement76",76);
                                inspect$75$0.outimage();
                                // JavaLine 122 ==> SourceLine 77
                                inspect$75$0.outtext(t1);
                                inspect$75$0.outtext(((simtst100)(CUR$.SL$.SL$)).heading);
                                inspect$75$0.outimage();
                                // JavaLine 126 ==> SourceLine 78
                                inspect$75$0.outtext(t2);
                                inspect$75$0.outtext(new TXT$("   "));
                                inspect$75$0.outtext(p$messt);
                                // JavaLine 130 ==> SourceLine 79
                                inspect$75$0.outtext(new TXT$(", i="));
                                inspect$75$0.outint(((simtst100$testputget)(CUR$.SL$)).stepi,4);
                                inspect$75$0.outimage();
                                TRACE_END_STM$("CompoundStatement76",79);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement74",79);
                    }
                } else
                // JavaLine 140 ==> SourceLine 82
                if(ident) {
                    GOTO$(PRINT); // GOTO EVALUATED LABEL
                }
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$ || q.prefixLevel!=0) {
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("err",82);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst100.sim","Procedure err",1,52,12,75,15,53,20,54,22,75,57,55,59,56,61,57,65,58,69,59,73,60,75,61,77,62,79,64,83,65,89,66,91,67,94,68,96,70,98,71,101,72,105,73,107,74,111,82,113,75,118,76,122,77,126,78,130,79,140,82,160,84);
}
