// JavaLine 1 ==> SourceLine 243
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Feb 19 13:53:23 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Dates$Easter extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=243, lastLine=260, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public Dates$Date RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$Y;
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 246
    int G=0;
    int C=0;
    int X=0;
    int Z=0;
    int D=0;
    int E=0;
    int N=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Dates$Easter setPar(Object param) {
        //Util.BREAK("CALL Dates$Easter.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$Y=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Dates$Easter(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Dates$Easter(RTObject$ SL$,int sp$Y) {
        super(SL$);
        // Parameter assignment to locals
        this.p$Y = sp$Y;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Easter",246);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Dates$Easter STM$() {
        TRACE_BEGIN_STM$("Easter",246);
        // JavaLine 52 ==> SourceLine 248
        G=(mod(p$Y,19)+(1));
        // JavaLine 54 ==> SourceLine 249
        C=((p$Y/(100))+(1));
        // JavaLine 56 ==> SourceLine 250
        X=(((3*(C))/(4))-(12));
        // JavaLine 58 ==> SourceLine 251
        Z=((((8*(C))+(5))/(25))-(5));
        // JavaLine 60 ==> SourceLine 252
        D=((((5*(p$Y))/(4))-(X))-(10));
        // JavaLine 62 ==> SourceLine 253
        E=mod(((((11*(G))+(20))+(Z))-(X)),30);
        // JavaLine 64 ==> SourceLine 254
        if(VALUE$((((E==(25))&((G>(11))))|((E==(24)))))) {
            E=(E+(1));
        }
        // JavaLine 68 ==> SourceLine 255
        N=(44-(E));
        // JavaLine 70 ==> SourceLine 256
        if(VALUE$((N<(21)))) {
            N=(N+(30));
        }
        // JavaLine 74 ==> SourceLine 257
        N=((N+(7))-(mod((D+(N)),7)));
        // JavaLine 76 ==> SourceLine 259
        RESULT$=new Dates$Date(((Dates)(CUR$.SL$)),N,3,p$Y).STM$();
        TRACE_END_STM$("Easter",259);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("dates.sim","Procedure Easter",1,243,15,246,52,248,54,249,56,250,58,251,60,252,62,253,64,254,68,255,70,256,74,257,76,259,81,260);
}
