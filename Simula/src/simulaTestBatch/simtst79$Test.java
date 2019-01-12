// JavaLine 1 ==> SourceLine 34
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Jan 12 12:23:27 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst79$Test extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=34, lastLine=52, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$line;
    public boolean p$open;
    public boolean p$B;
    public int p$nr;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst79$Test setPar(Object param) {
        //Util.BREAK("CALL simtst79$Test.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$line=intValue(param); break;
                case 1: p$open=(boolean)objectValue(param); break;
                case 2: p$B=(boolean)objectValue(param); break;
                case 3: p$nr=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst79$Test(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simtst79$Test(RTObject$ SL$,int sp$line,boolean sp$open,boolean sp$B,int sp$nr) {
        super(SL$);
        // Parameter assignment to locals
        this.p$line = sp$line;
        this.p$open = sp$open;
        this.p$B = sp$B;
        this.p$nr = sp$nr;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Test",34);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst79$Test STM$() {
        TRACE_BEGIN_STM$("Test",34);
        // JavaLine 50 ==> SourceLine 35
        if((((!(p$open))) == (p$B))) {
            // JavaLine 52 ==> SourceLine 36
            {
                TRACE_BEGIN_STM$("CompoundStatement36",36);
                sysout().outtext(new TXT$("Line "));
                sysout().outint(p$line,0);
                sysout().outtext(new TXT$(": *** error : Attribute 'IsOpen' of "));
                // JavaLine 58 ==> SourceLine 37
                if(((simtst79)(CUR$.SL$)).xf instanceof InFile$) {
                    // JavaLine 60 ==> SourceLine 38
                    sysout().outtext(new TXT$("infile"));
                } else
                if(IS$(((simtst79)(CUR$.SL$)).xf,OutFile$.class)) {
                    // JavaLine 64 ==> SourceLine 39
                    sysout().outtext(new TXT$("outfile"));
                } else
                if(((simtst79)(CUR$.SL$)).xf instanceof PrintFile$) {
                    // JavaLine 68 ==> SourceLine 40
                    sysout().outtext(new TXT$("printfile"));
                } else
                if(IS$(((simtst79)(CUR$.SL$)).xf,DirectFile$.class)) {
                    // JavaLine 72 ==> SourceLine 41
                    sysout().outtext(new TXT$("directfile"));
                } else
                if(((simtst79)(CUR$.SL$)).xf instanceof InbyteFile$) {
                    // JavaLine 76 ==> SourceLine 42
                    sysout().outtext(new TXT$("inbytefile"));
                } else
                if(IS$(((simtst79)(CUR$.SL$)).xf,OutbyteFile$.class)) {
                    // JavaLine 80 ==> SourceLine 43
                    sysout().outtext(new TXT$("outbytefile"));
                } else
                if(IS$(((simtst79)(CUR$.SL$)).xf,DirectByteFile$.class)) {
                    // JavaLine 84 ==> SourceLine 44
                    sysout().outtext(new TXT$("directbytefile"));
                } else
                sysout().outtext(new TXT$("??"));
                // JavaLine 88 ==> SourceLine 46
                sysout().outtext(new TXT$(" ("));
                sysout().outint(p$nr,(((p$nr<(10)))?(1):(2)));
                // JavaLine 91 ==> SourceLine 47
                sysout().outtext(new TXT$(") should no be "));
                // JavaLine 93 ==> SourceLine 48
                sysout().outtext(((p$open)?(new TXT$("true")):(new TXT$("false"))));
                // JavaLine 95 ==> SourceLine 49
                sysout().outimage();
                // JavaLine 97 ==> SourceLine 50
                ((simtst79)(CUR$.SL$)).found_error=true;
                TRACE_END_STM$("CompoundStatement36",50);
            }
        }
        TRACE_END_STM$("Test",50);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst79.sim","Procedure Test",1,34,50,35,52,36,58,37,60,38,64,39,68,40,72,41,76,42,80,43,84,44,88,46,91,47,93,48,95,49,97,50,105,52);
}
