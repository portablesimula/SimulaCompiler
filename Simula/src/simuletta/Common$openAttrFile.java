// JavaLine 1 <== SourceLine 358
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$openAttrFile extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=358, lastLine=374, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public ByteFile$ RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public TXT$ p$fnam;
    public boolean p$out;
    // Declare locals as attributes
    // JavaLine 15 <== SourceLine 359
    ByteFile$ f=null;
    // JavaLine 17 <== SourceLine 360
    OutbyteFile$ inspect$360$0=null;
    // JavaLine 19 <== SourceLine 367
    InbyteFile$ inspect$367$1=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$openAttrFile setPar(Object param) {
        //Util.BREAK("CALL Common$openAttrFile.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 2: p$fnam=(TXT$)objectValue(param); break;
                case 1: p$out=(boolean)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$openAttrFile(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public Common$openAttrFile(RTObject$ SL$,TXT$ sp$fnam,boolean sp$out) {
        super(SL$);
        // Parameter assignment to locals
        this.p$fnam = sp$fnam;
        this.p$out = sp$out;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$openAttrFile STM$() {
        // JavaLine 50 <== SourceLine 360
        if(VALUE$(p$out)) {
            {
                // BEGIN INSPECTION 
                inspect$360$0=new OutbyteFile$(((BASICIO$)CTX$),getTextInfo(11)).STM$();
                if(inspect$360$0!=null) // INSPECT inspect$360$0
                // JavaLine 56 <== SourceLine 361
                {
                    f=((ByteFile$)inspect$360$0);
                    ;
                    // JavaLine 60 <== SourceLine 362
                    if(VALUE$((!(inspect$360$0.open())))) {
                        // JavaLine 62 <== SourceLine 363
                        new Common$FATAL_ERROR(((Common)(CUR$.SL$)),CONC(CONC(new TXT$("Cannot open attr.file "),p$fnam),new TXT$(" for output")));
                    }
                    ;
                }
            }
        } else
        // JavaLine 69 <== SourceLine 366
        {
            giveTextInfo(2,p$fnam);
            ;
            // JavaLine 73 <== SourceLine 367
            {
                // BEGIN INSPECTION 
                inspect$367$1=new InbyteFile$(((BASICIO$)CTX$),getTextInfo(12)).STM$();
                if(inspect$367$1!=null) // INSPECT inspect$367$1
                // JavaLine 78 <== SourceLine 368
                {
                    f=((ByteFile$)inspect$367$1);
                    ;
                    // JavaLine 82 <== SourceLine 369
                    if(VALUE$((!(inspect$367$1.open())))) {
                        // JavaLine 84 <== SourceLine 370
                        new Common$FATAL_ERROR(((Common)(CUR$.SL$)),CONC(CONC(new TXT$("Cannot open attr.file "),p$fnam),new TXT$(" for input")));
                    }
                    ;
                }
            }
            ;
        }
        ;
        // JavaLine 93 <== SourceLine 373
        RESULT$=f;
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure openAttrFile",1,358,15,359,17,360,19,367,50,360,56,361,60,362,62,363,69,366,73,367,78,368,82,369,84,370,93,373,98,374);
} // End of Procedure
