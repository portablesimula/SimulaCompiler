// JavaLine 1 ==> SourceLine 25
package simulaTestBatch;
// Simula-Beta-0.3 Compiled at Sun Feb 17 13:27:18 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class simtst85$SubBlock23$check extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=25, lastLine=38, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$txt;
    public TXT$ p$title;
    public int p$lngth;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public simtst85$SubBlock23$check setPar(Object param) {
        //Util.BREAK("CALL simtst85$SubBlock23$check.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$txt=(TXT$)objectValue(param); break;
                case 1: p$title=(TXT$)objectValue(param); break;
                case 2: p$lngth=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public simtst85$SubBlock23$check(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public simtst85$SubBlock23$check(RTObject$ SL$,TXT$ sp$txt,TXT$ sp$title,int sp$lngth) {
        super(SL$);
        // Parameter assignment to locals
        this.p$txt = sp$txt;
        this.p$title = sp$title;
        this.p$lngth = sp$lngth;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("check",25);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public simtst85$SubBlock23$check STM$() {
        TRACE_BEGIN_STM$("check",25);
        // JavaLine 47 ==> SourceLine 27
        if(VALUE$(TXTREL$NE(TXT$.sub(sysout().image,1,p$lngth),p$txt))) {
            // JavaLine 49 ==> SourceLine 29
            {
                TRACE_BEGIN_STM$("CompoundStatement29",29);
                sysout().outtext(new TXT$(" <-- was result"));
                sysout().outimage();
                // JavaLine 54 ==> SourceLine 30
                sysout().outtext(p$txt);
                // JavaLine 56 ==> SourceLine 31
                sysout().outtext(new TXT$(" <-- was expected"));
                sysout().outimage();
                // JavaLine 59 ==> SourceLine 32
                sysout().outtext(new TXT$("*** Error in test of: "));
                // JavaLine 61 ==> SourceLine 33
                sysout().outtext(p$title);
                sysout().outimage();
                sysout().outimage();
                // JavaLine 65 ==> SourceLine 34
                ((simtst85)(CUR$.SL$.SL$)).errorfound=true;
                TRACE_END_STM$("CompoundStatement29",34);
            }
        }
        // JavaLine 70 ==> SourceLine 36
        ASGTXT$(sysout().image,null);
        TXT$.setpos(sysout().image,1);
        // JavaLine 73 ==> SourceLine 37
        ASGTXT$(((simtst85)(CUR$.SL$.SL$)).inspect$21$0.image,null);
        TXT$.setpos(((simtst85)(CUR$.SL$.SL$)).inspect$21$0.image,1);
        TRACE_END_STM$("check",37);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("simtst85.sim","Procedure check",1,25,47,27,49,29,54,30,56,31,59,32,61,33,65,34,70,36,73,37,79,38);
}
