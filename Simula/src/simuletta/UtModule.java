// JavaLine 1 <== SourceLine 4
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:52 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class UtModule extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=1, firstLine=4, lastLine=323, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common p$comn;
    public OuptFile p$scode;
    public TXT$ p$afile;
    public TXT$ p$modid;
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 17
    Common inspect$17$114=null;
    OuptFile inspect$17$115=null;
    // JavaLine 17 <== SourceLine 178
    PrintFile$ inspect$178$129=null;
    // JavaLine 19 <== SourceLine 186
    PrintFile$ inspect$186$130=null;
    // JavaLine 21 <== SourceLine 209
    Common$descr inspect$209$131=null;
    // JavaLine 23 <== SourceLine 225
    Common$quant inspect$225$132=null;
    // JavaLine 25 <== SourceLine 229
    Common$variant inspect$229$133=null;
    // JavaLine 27 <== SourceLine 233
    Common$quant inspect$233$134=null;
    // JavaLine 29 <== SourceLine 277
    Common$symbolbox inspect$276$135=null;
    // JavaLine 31 <== SourceLine 278
    Linkage$ inspect$278$136=null;
    // JavaLine 33 <== SourceLine 284
    Link$ inspect$284$137=null;
    // JavaLine 35 <== SourceLine 302
    Common$macro_symbol inspect$302$138=null;
    // JavaLine 37 <== SourceLine 312
    PrintFile$ inspect$311$139=null;
    // JavaLine 39 <== SourceLine 317
    PrintFile$ inspect$317$140=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public UtModule setPar(Object param) {
        //Util.BREAK("CALL UtModule.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 4: p$comn=(Common)objectValue(param); break;
                case 3: p$scode=(OuptFile)objectValue(param); break;
                case 2: p$afile=(TXT$)objectValue(param); break;
                case 1: p$modid=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public UtModule(RTObject$ SL$) {
        super(SL$,4); // Expecting 4 parameters
    }
    // Normal Constructor
    public UtModule(RTObject$ SL$,Common sp$comn,OuptFile sp$scode,TXT$ sp$afile,TXT$ sp$modid) {
        super(SL$);
        // Parameter assignment to locals
        this.p$comn = sp$comn;
        this.p$scode = sp$scode;
        this.p$afile = sp$afile;
        this.p$modid = sp$modid;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public UtModule STM$() {
        // JavaLine 74 <== SourceLine 17
        {
            // BEGIN INSPECTION 
            inspect$17$114=p$comn;
            if(inspect$17$114!=null) // INSPECT inspect$17$114
            {
                // BEGIN INSPECTION 
                inspect$17$115=new OuptFile(((BASICIO$)CTX$),p$afile,p$comn).STM$();
                if(inspect$17$115!=null) // INSPECT inspect$17$115
                // JavaLine 83 <== SourceLine 323
                new UtModule$SubBlock19((CUR$)).STM$();
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("UTMODULE.sim","Procedure UtModule",1,4,14,17,17,178,19,186,21,209,23,225,25,229,27,233,29,277,31,278,33,284,35,302,37,312,39,317,74,17,83,323,89,323);
} // End of Procedure
