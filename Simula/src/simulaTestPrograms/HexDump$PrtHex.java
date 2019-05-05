// JavaLine 1 <== SourceLine 31
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:22:58 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HexDump$PrtHex extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=31, lastLine=37, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$i;
    public int p$n;
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 32
    TXT$ t=null;
    int h=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HexDump$PrtHex setPar(Object param) {
        //Util.BREAK("CALL HexDump$PrtHex.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                case 1: p$n=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HexDump$PrtHex(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HexDump$PrtHex(RTObject$ SL$,int sp$i,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("PrtHex",32);
        STM$();
    }
    // Procedure Statements
    public HexDump$PrtHex STM$() {
        TRACE_BEGIN_STM$("PrtHex",32);
        t=blanks(p$n);
        // JavaLine 48 <== SourceLine 33
        while((p$n>(0))) {
            // JavaLine 50 <== SourceLine 34
            {
                TRACE_BEGIN_STM$("CompoundStatement34",34);
                h=(mod(p$i,16)+(48));
                p$i=(p$i/(16));
                if(VALUE$((h>(57)))) {
                    h=(h+(7));
                }
                // JavaLine 58 <== SourceLine 35
                TXT$.setpos(t,p$n);
                TXT$.putchar(t,char$(h));
                p$n=(p$n-(1));
                TRACE_END_STM$("CompoundStatement34",35);
            }
        }
        // JavaLine 65 <== SourceLine 36
        sysout().outtext(t);
        TRACE_END_STM$("PrtHex",36);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HexDump.sim","Procedure PrtHex",1,31,13,32,48,33,50,34,58,35,65,36,70,37);
} // End of Procedure
