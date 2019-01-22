// JavaLine 1 ==> SourceLine 5
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Tue Jan 22 17:05:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Queens2$Setpos extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=5, lastLine=13, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$Line;
    public int p$Pos;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Queens2$Setpos setPar(Object param) {
        //Util.BREAK("CALL Queens2$Setpos.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$Line=intValue(param); break;
                case 1: p$Pos=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Queens2$Setpos(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Queens2$Setpos(RTObject$ SL$,int sp$Line,int sp$Pos) {
        super(SL$);
        // Parameter assignment to locals
        this.p$Line = sp$Line;
        this.p$Pos = sp$Pos;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Setpos",5);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public Queens2$Setpos STM$() {
        TRACE_BEGIN_STM$("Setpos",5);
        // JavaLine 44 ==> SourceLine 6
        if((p$Line<(10))) {
            // JavaLine 46 ==> SourceLine 7
            {
                TRACE_BEGIN_STM$("CompoundStatement7",7);
                TXT$.putint(TXT$.sub(((Queens2)(CUR$.SL$)).OUTPOS,4,1),p$Line);
                ASGSTR$(TXT$.sub(((Queens2)(CUR$.SL$)).OUTPOS,3,1),"0");
                TRACE_END_STM$("CompoundStatement7",7);
            }
        } else
        // JavaLine 54 ==> SourceLine 8
        TXT$.putint(TXT$.sub(((Queens2)(CUR$.SL$)).OUTPOS,3,2),p$Line);
        // JavaLine 56 ==> SourceLine 9
        if((p$Pos<(10))) {
            // JavaLine 58 ==> SourceLine 10
            {
                TRACE_BEGIN_STM$("CompoundStatement10",10);
                TXT$.putint(TXT$.sub(((Queens2)(CUR$.SL$)).OUTPOS,7,1),p$Pos);
                ASGSTR$(TXT$.sub(((Queens2)(CUR$.SL$)).OUTPOS,6,1),"0");
                TRACE_END_STM$("CompoundStatement10",10);
            }
        } else
        // JavaLine 66 ==> SourceLine 11
        TXT$.putint(TXT$.sub(((Queens2)(CUR$.SL$)).OUTPOS,6,2),p$Pos);
        // JavaLine 68 ==> SourceLine 12
        sysout().outtext(((Queens2)(CUR$.SL$)).OUTPOS);
        sysout().breakoutimage();
        TRACE_END_STM$("Setpos",12);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Queens2.sim","Procedure Setpos",1,5,44,6,46,7,54,8,56,9,58,10,66,11,68,12,74,13);
}
