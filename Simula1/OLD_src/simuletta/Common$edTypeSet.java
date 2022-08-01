// JavaLine 1 <== SourceLine 408
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$edTypeSet extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=408, lastLine=416, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public TXT$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public Common$TypeSet p$set;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$edTypeSet setPar(Object param) {
        //Util.BREAK("CALL Common$edTypeSet.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$set=(Common$TypeSet)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$edTypeSet(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Common$edTypeSet(RTObject$ SL$,Common$TypeSet sp$set) {
        super(SL$);
        // Parameter assignment to locals
        this.p$set = sp$set;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$edTypeSet STM$() {
        // JavaLine 41 <== SourceLine 409
        if(VALUE$((p$set==(((Common)(CUR$.SL$)).integerTypes$1)))) {
            RESULT$=copy(copy(new TXT$("IntegerTypes")));
        } else
        // JavaLine 45 <== SourceLine 410
        if(VALUE$((p$set==(((Common)(CUR$.SL$)).infixTypes$1)))) {
            RESULT$=copy(copy(new TXT$("InfixTypes")));
        } else
        // JavaLine 49 <== SourceLine 411
        if(VALUE$((p$set==(((Common)(CUR$.SL$)).structTypes$1)))) {
            RESULT$=copy(copy(new TXT$("StructTypes")));
        } else
        // JavaLine 53 <== SourceLine 412
        if(VALUE$((p$set==(((Common)(CUR$.SL$)).entTypes$1)))) {
            RESULT$=copy(copy(new TXT$("EntTypes")));
        } else
        // JavaLine 57 <== SourceLine 413
        if(VALUE$((p$set==(((Common)(CUR$.SL$)).refTypes$1)))) {
            RESULT$=copy(copy(new TXT$("RefTypes")));
        } else
        // JavaLine 61 <== SourceLine 414
        if(VALUE$((p$set==(((Common)(CUR$.SL$)).fieldTypes$1)))) {
            RESULT$=copy(copy(new TXT$("FieldTypes")));
        } else
        // JavaLine 65 <== SourceLine 415
        if(VALUE$((p$set==(((Common)(CUR$.SL$)).nameTypes$1)))) {
            RESULT$=copy(copy(new TXT$("NameTypes")));
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure edTypeSet",1,408,41,409,45,410,49,411,53,412,57,413,61,414,65,415,71,416);
} // End of Procedure
