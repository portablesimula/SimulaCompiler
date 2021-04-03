// JavaLine 1 <== SourceLine 6
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:53 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2 extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=1, firstLine=6, lastLine=2127, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common p$comn;
    // Declare locals as attributes
    // JavaLine 11 <== SourceLine 20
    Common inspect$20$141=null;
    InptFile inspect$20$142=null;
    // JavaLine 14 <== SourceLine 21
    OuptFile inspect$21$143=null;
    // JavaLine 16 <== SourceLine 1943
    Link$ inspect$1943$225=null;
    // JavaLine 18 <== SourceLine 1945
    PrintFile$ inspect$1944$226=null;
    // JavaLine 20 <== SourceLine 1997
    Common$module inspect$1997$227=null;
    // JavaLine 22 <== SourceLine 2010
    Common$descr inspect$2010$228=null;
    // JavaLine 24 <== SourceLine 2032
    Common$quant inspect$2031$229=null;
    // JavaLine 26 <== SourceLine 2049
    Common$descr inspect$2049$230=null;
    // JavaLine 28 <== SourceLine 2052
    PrintFile$ inspect$2052$231=null;
    // JavaLine 30 <== SourceLine 2056
    Common$TypeNotice inspect$2055$232=null;
    // JavaLine 32 <== SourceLine 2062
    Common$record inspect$2061$233=null;
    // JavaLine 34 <== SourceLine 2069
    PrintFile$ inspect$2069$234=null;
    // JavaLine 36 <== SourceLine 2082
    Common$quant inspect$2082$235=null;
    // JavaLine 38 <== SourceLine 2097
    Common$descr inspect$2097$236=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2 setPar(Object param) {
        //Util.BREAK("CALL Pass2.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$comn=(Common)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2(RTObject$ SL$,Common sp$comn) {
        super(SL$);
        // Parameter assignment to locals
        this.p$comn = sp$comn;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2 STM$() {
        // JavaLine 67 <== SourceLine 20
        {
            // BEGIN INSPECTION 
            inspect$20$141=p$comn;
            if(inspect$20$141!=null) // INSPECT inspect$20$141
            {
                // BEGIN INSPECTION 
                inspect$20$142=new InptFile(((BASICIO$)CTX$),inspect$20$141.L2name$1,p$comn).STM$();
                if(inspect$20$142!=null) // INSPECT inspect$20$142
                // JavaLine 76 <== SourceLine 21
                {
                    {
                        // BEGIN INSPECTION 
                        inspect$21$143=new OuptFile(((BASICIO$)CTX$),inspect$20$141.nscodename$1,inspect$20$142.p3$comn).STM$();
                        if(inspect$21$143!=null) // INSPECT inspect$21$143
                        // JavaLine 82 <== SourceLine 2125
                        new Pass2$CompoundStatement21$SubBlock23((CUR$)).STM$();
                    }
                    ;
                }
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure Pass2",1,6,11,20,14,21,16,1943,18,1945,20,1997,22,2010,24,2032,26,2049,28,2052,30,2056,32,2062,34,2069,36,2082,38,2097,67,20,76,21,82,2125,91,2127);
} // End of Procedure
