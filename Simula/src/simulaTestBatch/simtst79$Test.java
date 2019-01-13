// JavaLine 1 ==> SourceLine 42
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sat Jan 12 15:27:27 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst79$Test extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=42, lastLine=60, hasLocalClasses=false, System=false
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
        TRACE_BEGIN_DCL$("Test",42);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst79$Test STM$() {
        TRACE_BEGIN_STM$("Test",42);
        // JavaLine 50 ==> SourceLine 43
        if((((!(p$open))) == (p$B))) {
            // JavaLine 52 ==> SourceLine 44
            {
                TRACE_BEGIN_STM$("CompoundStatement44",44);
                sysout().outtext(new TXT$("Line "));
                sysout().outint(p$line,0);
                sysout().outtext(new TXT$(": *** error : Attribute 'IsOpen' of "));
                // JavaLine 58 ==> SourceLine 45
                if(((simtst79)(CUR$.SL$)).xf instanceof InFile$) {
                    // JavaLine 60 ==> SourceLine 46
                    sysout().outtext(new TXT$("infile"));
                } else
                if(IS$(((simtst79)(CUR$.SL$)).xf,OutFile$.class)) {
                    // JavaLine 64 ==> SourceLine 47
                    sysout().outtext(new TXT$("outfile"));
                } else
                if(((simtst79)(CUR$.SL$)).xf instanceof PrintFile$) {
                    // JavaLine 68 ==> SourceLine 48
                    sysout().outtext(new TXT$("printfile"));
                } else
                if(IS$(((simtst79)(CUR$.SL$)).xf,DirectFile$.class)) {
                    // JavaLine 72 ==> SourceLine 49
                    sysout().outtext(new TXT$("directfile"));
                } else
                if(((simtst79)(CUR$.SL$)).xf instanceof InbyteFile$) {
                    // JavaLine 76 ==> SourceLine 50
                    sysout().outtext(new TXT$("inbytefile"));
                } else
                if(IS$(((simtst79)(CUR$.SL$)).xf,OutbyteFile$.class)) {
                    // JavaLine 80 ==> SourceLine 51
                    sysout().outtext(new TXT$("outbytefile"));
                } else
                if(IS$(((simtst79)(CUR$.SL$)).xf,DirectByteFile$.class)) {
                    // JavaLine 84 ==> SourceLine 52
                    sysout().outtext(new TXT$("directbytefile"));
                } else
                sysout().outtext(new TXT$("??"));
                // JavaLine 88 ==> SourceLine 54
                sysout().outtext(new TXT$(" ("));
                sysout().outint(p$nr,(((p$nr<(10)))?(1):(2)));
                // JavaLine 91 ==> SourceLine 55
                sysout().outtext(new TXT$(") should no be "));
                // JavaLine 93 ==> SourceLine 56
                sysout().outtext(((p$open)?(new TXT$("true")):(new TXT$("false"))));
                // JavaLine 95 ==> SourceLine 57
                sysout().outimage();
                // JavaLine 97 ==> SourceLine 58
                ((simtst79)(CUR$.SL$)).found_error=true;
                TRACE_END_STM$("CompoundStatement44",58);
            }
        }
        TRACE_END_STM$("Test",58);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst79.sim","Procedure Test",1,42,50,43,52,44,58,45,60,46,64,47,68,48,72,49,76,50,80,51,84,52,88,54,91,55,93,56,95,57,97,58,105,60);
}
