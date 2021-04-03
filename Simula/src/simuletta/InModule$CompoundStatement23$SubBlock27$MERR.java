// JavaLine 1 <== SourceLine 34
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:47 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InModule$CompoundStatement23$SubBlock27$MERR extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=34, lastLine=37, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public TXT$ p$t;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public InModule$CompoundStatement23$SubBlock27$MERR setPar(Object param) {
        //Util.BREAK("CALL InModule$CompoundStatement23$SubBlock27$MERR.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$t=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public InModule$CompoundStatement23$SubBlock27$MERR(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public InModule$CompoundStatement23$SubBlock27$MERR(RTObject$ SL$,TXT$ sp$t) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t = sp$t;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public InModule$CompoundStatement23$SubBlock27$MERR STM$() {
        // JavaLine 38 <== SourceLine 35
        new Common$ERROR(((InModule)(CUR$.SL$.SL$)).inspect$22$42,CONC(CONC(p$t,new TXT$(" Illegal layout of module: ")),((InModule)(CUR$.SL$.SL$)).inspect$23$44.p2$modid));
        ;
        // JavaLine 41 <== SourceLine 36
        GOTO$(((InModule$CompoundStatement23$SubBlock27)(CUR$.SL$)).MXX); // GOTO EVALUATED LABEL
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("INMODULE.sim","Procedure MERR",1,34,38,35,41,36,46,37);
} // End of Procedure
