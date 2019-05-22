// JavaLine 1 <== SourceLine 3
package simulaTestPrograms;
// Simula-1.0 Compiled at Wed May 22 10:22:23 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Collatz$Collatz extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=3, lastLine=17, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$i;
    // Declare locals as attributes
    // JavaLine 15 <== SourceLine 5
    int j=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public Collatz$Collatz setPar(Object param) {
        //Util.BREAK("CALL Collatz$Collatz.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$i=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Collatz$Collatz(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public Collatz$Collatz(RTObject$ SL$,int sp$i) {
        super(SL$);
        // Parameter assignment to locals
        this.p$i = sp$i;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("Collatz",5);
        STM$();
    }
    // Procedure Statements
    public Collatz$Collatz STM$() {
        TRACE_BEGIN_STM$("Collatz",5);
        // JavaLine 46 <== SourceLine 7
        while((p$i>(1))) {
            // JavaLine 48 <== SourceLine 9
            {
                TRACE_BEGIN_STM$("CompoundStatement9",9);
                if(VALUE$((mod(p$i,2)==(0)))) {
                    p$i=(p$i/(2));
                } else
                // JavaLine 54 <== SourceLine 12
                {
                    TRACE_BEGIN_STM$("CompoundStatement12",12);
                    
                    try { p$i=Math.multiplyExact(p$i,3); }
                    catch(Exception e) {
                    	System.out.println("     i="+p$i);
                    	System.out.println("MaxInt="+Integer.MAX_VALUE);
                    	System.out.println("   i*3="+(p$i*3));
                    	e.printStackTrace(); System.exit(-1);
                    }
                    
                    p$i=Math.addExact(p$i,1);
                    TRACE_END_STM$("CompoundStatement12",12);
                }
                // JavaLine 61 <== SourceLine 14
                j=Math.addExact(j,1);
                TRACE_END_STM$("CompoundStatement9",14);
            }
        }
        // JavaLine 66 <== SourceLine 16
        RESULT$=j;
        TRACE_END_STM$("Collatz",16);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("Collatz.sim","Procedure Collatz",1,3,15,5,46,7,48,9,54,12,61,14,66,16,71,17);
} // End of Procedure
