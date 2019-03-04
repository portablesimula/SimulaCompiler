// JavaLine 1 ==> SourceLine 146
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 04 20:15:38 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$tekstverdi$les_tegn extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=146, lastLine=156, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public char RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public char p$forrige_tegn;
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 148
    char c=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$tekstverdi$les_tegn setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$tekstverdi$les_tegn.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$forrige_tegn=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HegnaNRK$PBLK21$tekstverdi$les_tegn(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$tekstverdi$les_tegn(RTObject$ SL$,char sp$forrige_tegn) {
        super(SL$);
        // Parameter assignment to locals
        this.p$forrige_tegn = sp$forrige_tegn;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("les_tegn",148);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$tekstverdi$les_tegn STM$() {
        TRACE_BEGIN_STM$("les_tegn",148);
        // JavaLine 46 ==> SourceLine 149
        c=p$forrige_tegn;
        // JavaLine 48 ==> SourceLine 150
        if(VALUE$((c==(((char)32))))) {
            // JavaLine 50 ==> SourceLine 151
            while((c==(((char)32)))) {
                c=sysin().inchar();
            }
        } else
        // JavaLine 55 ==> SourceLine 153
        if(VALUE$((!(TXT$.more(sysin().image))))) {
            c=((char)32);
        } else
        // JavaLine 59 ==> SourceLine 154
        c=sysin().inchar();
        // JavaLine 61 ==> SourceLine 155
        RESULT$=c;
        TRACE_END_STM$("les_tegn",155);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure les_tegn",1,146,15,148,46,149,48,150,50,151,55,153,59,154,61,155,66,156);
}
