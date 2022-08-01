// JavaLine 1 <== SourceLine 4
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:47 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class InModule extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=1, firstLine=4, lastLine=296, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common p$comn;
    public TXT$ p$afile;
    public TXT$ p$modid;
    // Declare locals as attributes
    // JavaLine 13 <== SourceLine 22
    Common inspect$22$42=null;
    InptFile inspect$22$43=null;
    // JavaLine 16 <== SourceLine 23
    Common$module inspect$23$44=null;
    // JavaLine 18 <== SourceLine 155
    PrintFile$ inspect$155$50=null;
    // JavaLine 20 <== SourceLine 176
    Common$quant inspect$176$51=null;
    // JavaLine 22 <== SourceLine 182
    Common$label_descr inspect$182$52=null;
    // JavaLine 24 <== SourceLine 188
    Common$record inspect$188$53=null;
    // JavaLine 26 <== SourceLine 197
    Common$variant inspect$197$54=null;
    // JavaLine 28 <== SourceLine 210
    Common$profile inspect$210$55=null;
    // JavaLine 30 <== SourceLine 216
    Common$profile inspect$216$56=null;
    // JavaLine 32 <== SourceLine 222
    Common$routine inspect$222$57=null;
    // JavaLine 34 <== SourceLine 236
    Common$peculiar inspect$236$58=null;
    // JavaLine 36 <== SourceLine 254
    Common$symbolbox inspect$253$59=null;
    // JavaLine 38 <== SourceLine 264
    Common$symbolbox inspect$263$60=null;
    // JavaLine 40 <== SourceLine 286
    PrintFile$ inspect$285$61=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public InModule setPar(Object param) {
        //Util.BREAK("CALL InModule.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 3: p$comn=(Common)objectValue(param); break;
                case 2: p$afile=(TXT$)objectValue(param); break;
                case 1: p$modid=(TXT$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public InModule(RTObject$ SL$) {
        super(SL$,3); // Expecting 3 parameters
    }
    // Normal Constructor
    public InModule(RTObject$ SL$,Common sp$comn,TXT$ sp$afile,TXT$ sp$modid) {
        super(SL$);
        // Parameter assignment to locals
        this.p$comn = sp$comn;
        this.p$afile = sp$afile;
        this.p$modid = sp$modid;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public InModule STM$() {
        // JavaLine 73 <== SourceLine 22
        {
            // BEGIN INSPECTION 
            inspect$22$42=p$comn;
            if(inspect$22$42!=null) // INSPECT inspect$22$42
            {
                // BEGIN INSPECTION 
                inspect$22$43=new InptFile(((BASICIO$)CTX$),p$afile,p$comn).STM$();
                if(inspect$22$43!=null) // INSPECT inspect$22$43
                // JavaLine 82 <== SourceLine 23
                {
                    {
                        // BEGIN INSPECTION 
                        inspect$23$44=new Common$module(inspect$22$42,copy(p$modid)).STM$();
                        if(inspect$23$44!=null) // INSPECT inspect$23$44
                        // JavaLine 88 <== SourceLine 295
                        new InModule$CompoundStatement23$SubBlock27((CUR$)).STM$();
                    }
                    ;
                }
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("INMODULE.sim","Procedure InModule",1,4,13,22,16,23,18,155,20,176,22,182,24,188,26,197,28,210,30,216,32,222,34,236,36,254,38,264,40,286,73,22,82,23,88,295,97,296);
} // End of Procedure
