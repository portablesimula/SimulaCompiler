// JavaLine 1 ==> SourceLine 22
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sat Mar 16 11:38:03 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class QPSample2$note extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=22, lastLine=28, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public TXT$ p$msg;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public QPSample2$note setPar(Object param) {
        //Util.BREAK("CALL QPSample2$note.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$msg=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public QPSample2$note(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public QPSample2$note(RTObject$ SL$,TXT$ sp$msg) {
        super(SL$);
        // Parameter assignment to locals
        this.p$msg = sp$msg;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("note",22);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public QPSample2$note STM$() {
        TRACE_BEGIN_STM$("note",22);
        // JavaLine 41 ==> SourceLine 23
        ((QPSample2)(CUR$.SL$)).notes.Elt[((QPSample2)(CUR$.SL$)).n-((QPSample2)(CUR$.SL$)).notes.LB[0]]=p$msg;
        // JavaLine 43 ==> SourceLine 24
        if(VALUE$(TXTREL$NE(((QPSample2)(CUR$.SL$)).notes.Elt[((QPSample2)(CUR$.SL$)).n-((QPSample2)(CUR$.SL$)).notes.LB[0]],((QPSample2)(CUR$.SL$)).facit.Elt[((QPSample2)(CUR$.SL$)).n-((QPSample2)(CUR$.SL$)).facit.LB[0]]))) {
            // JavaLine 45 ==> SourceLine 25
            new QPSample2$prt(((QPSample2)(CUR$.SL$)),CONC(CONC(CONC(CONC(new TXT$("*** ERROR: '"),((QPSample2)(CUR$.SL$)).notes.Elt[((QPSample2)(CUR$.SL$)).n-((QPSample2)(CUR$.SL$)).notes.LB[0]]),new TXT$("' NE '")),((QPSample2)(CUR$.SL$)).facit.Elt[((QPSample2)(CUR$.SL$)).n-((QPSample2)(CUR$.SL$)).facit.LB[0]]),new TXT$("'")));
        }
        // JavaLine 48 ==> SourceLine 26
        ((QPSample2)(CUR$.SL$)).n=(((QPSample2)(CUR$.SL$)).n+(1));
        // JavaLine 50 ==> SourceLine 27
        new QPSample2$prt(((QPSample2)(CUR$.SL$)),p$msg);
        TRACE_END_STM$("note",27);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("QPSample2.sim","Procedure note",1,22,41,23,43,24,45,25,48,26,50,27,55,28);
}
