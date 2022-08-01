// JavaLine 1 <== SourceLine 12
package simulaTestPrograms;
// Simula-2.0 Compiled at Tue Jan 18 09:46:00 CET 2022
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class IBMQuine$$WRITE extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=12, lastLine=17, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public TXT$ p$HEAD;
    public TXT$ p$TAIL;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public IBMQuine$$WRITE setPar(Object param) {
        //Util.BREAK("CALL IBMQuine$$WRITE.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 2: p$HEAD=(TXT$)objectValue(param); break;
                case 1: p$TAIL=(TXT$)objectValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public IBMQuine$$WRITE(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public IBMQuine$$WRITE(RTObject$ SL$,TXT$ sp$HEAD,TXT$ sp$TAIL) {
        super(SL$);
        // Parameter assignment to locals
        this.p$HEAD = sp$HEAD;
        this.p$TAIL = sp$TAIL;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public IBMQuine$$WRITE STM$() {
        // JavaLine 41 <== SourceLine 13
        new IBMQuine$$OUTEXT(((IBMQuine$)(CUR$.SL$)),p$HEAD);
        ;
        new IBMQuine$$OUTQUOTE(((IBMQuine$)(CUR$.SL$)));
        ;
        new IBMQuine$$OUTEXT(((IBMQuine$)(CUR$.SL$)),p$HEAD);
        ;
        // JavaLine 48 <== SourceLine 14
        new IBMQuine$$OUTQUOTE(((IBMQuine$)(CUR$.SL$)));
        ;
        sysout().outimage();
        ;
        sysout().setpos(13);
        ;
        // JavaLine 55 <== SourceLine 15
        sysout().outchar(',');
        ;
        sysout().setpos(72);
        ;
        new IBMQuine$$OUTQUOTE(((IBMQuine$)(CUR$.SL$)));
        ;
        // JavaLine 62 <== SourceLine 16
        new IBMQuine$$OUTEXT(((IBMQuine$)(CUR$.SL$)),p$TAIL);
        ;
        new IBMQuine$$OUTQUOTE(((IBMQuine$)(CUR$.SL$)));
        ;
        new IBMQuine$$OUTEXT(((IBMQuine$)(CUR$.SL$)),p$TAIL);
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("IBMQuine.sim","Procedure WRITE",1,12,41,13,48,14,55,15,62,16,71,17);
} // End of Procedure
