// JavaLine 1 <== SourceLine 148
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$SetSelectors extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=148, lastLine=157, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public TXT$ p$t;
    public int p$val;
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 149
    int i=0;
    boolean b=false;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$SetSelectors setPar(Object param) {
        //Util.BREAK("CALL Common$SetSelectors.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 2: p$t=(TXT$)objectValue(param); break;
                case 1: p$val=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$SetSelectors(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public Common$SetSelectors(RTObject$ SL$,TXT$ sp$t,int sp$val) {
        super(SL$);
        // Parameter assignment to locals
        this.p$t = sp$t;
        this.p$val = sp$val;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$SetSelectors STM$() {
        // JavaLine 44 <== SourceLine 150
        if(VALUE$((p$val==(0)))) {
            for(i=47;i<=127;i++) {
                // JavaLine 47 <== SourceLine 151
                ((Common)(CUR$.SL$)).Selector.Elt[i-((Common)(CUR$.SL$)).Selector.LB[0]]=false;
            }
        }
        ;
        // JavaLine 52 <== SourceLine 152
        b=(p$val!=(2));
        ;
        TXT$.setpos(p$t,1);
        ;
        // JavaLine 57 <== SourceLine 153
        while(TXT$.more(p$t)) {
            // JavaLine 59 <== SourceLine 154
            {
                i=rank(TXT$.getchar(p$t));
                ;
                if(VALUE$((i>(127)))) {
                    i=Math.subtractExact(i,128);
                }
                ;
                // JavaLine 67 <== SourceLine 155
                if(VALUE$((i>(47)))) {
                    ((Common)(CUR$.SL$)).Selector.Elt[i-((Common)(CUR$.SL$)).Selector.LB[0]]=b;
                }
                ;
            }
        }
        ;
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure SetSelectors",1,148,12,149,44,150,47,151,52,152,57,153,59,154,67,155,77,157);
} // End of Procedure
