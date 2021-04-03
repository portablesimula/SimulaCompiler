// JavaLine 1 <== SourceLine 121
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:45 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class OuptFile$TRC extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=121, lastLine=137, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public TXT$ p$m;
    public TXT$ p$v;
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 122
    Common inspect$122$30=null;
    // JavaLine 14 <== SourceLine 124
    PrintFile$ inspect$124$31=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public OuptFile$TRC setPar(Object param) {
        //Util.BREAK("CALL OuptFile$TRC.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 2: p$m=(TXT$)objectValue(param); break;
                case 1: p$v=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public OuptFile$TRC(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public OuptFile$TRC(RTObject$ SL$,TXT$ sp$m,TXT$ sp$v) {
        super(SL$);
        // Parameter assignment to locals
        this.p$m = sp$m;
        this.p$v = sp$v;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public OuptFile$TRC STM$() {
        // JavaLine 45 <== SourceLine 122
        {
            // BEGIN INSPECTION 
            inspect$122$30=((OuptFile)(CUR$.SL$)).p3$comn;
            if(inspect$122$30!=null) // INSPECT inspect$122$30
            // JavaLine 50 <== SourceLine 137
            new OuptFile$TRC$SubBlock123((CUR$)).STM$();
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("OUPTFILE.sim","Procedure TRC",1,121,12,122,14,124,45,122,50,137,55,137);
} // End of Procedure
