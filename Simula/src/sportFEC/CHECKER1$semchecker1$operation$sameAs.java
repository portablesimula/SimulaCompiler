// JavaLine 1 ==> SourceLine 208
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:41 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$operation$sameAs extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=208, lastLine=219, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public CHECKER1$semchecker1$exp p$e;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public CHECKER1$semchecker1$operation$sameAs setPar(Object param) {
        //Util.BREAK("CALL CHECKER1$semchecker1$operation$sameAs.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$e=(CHECKER1$semchecker1$exp)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public CHECKER1$semchecker1$operation$sameAs(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public CHECKER1$semchecker1$operation$sameAs(RTObject$ SL$,CHECKER1$semchecker1$exp sp$e) {
        super(SL$);
        // Parameter assignment to locals
        this.p$e = sp$e;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("sameAs",208);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$operation$sameAs STM$() {
        TRACE_BEGIN_STM$("sameAs",208);
        // JavaLine 44 ==> SourceLine 211
        if(p$e instanceof CHECKER1$semchecker1$operation) {
            // JavaLine 46 ==> SourceLine 212
            {
                TRACE_BEGIN_STM$("CompoundStatement212",212);
                if((((CHECKER1$semchecker1$operation)(CUR$.SL$)).p1$left==(null))) {
                    // JavaLine 50 ==> SourceLine 213
                    {
                        TRACE_BEGIN_STM$("CompoundStatement213",213);
                        if((((CHECKER1$semchecker1$operation)(p$e)).p1$left==(null))) {
                            GOTO$(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).CR); // GOTO EVALUATED LABEL
                        }
                        TRACE_END_STM$("CompoundStatement213",213);
                    }
                } else
                // JavaLine 59 ==> SourceLine 214
                if((((CHECKER1$semchecker1$operation)(p$e)).p1$left!=(null))) {
                    // JavaLine 61 ==> SourceLine 215
                    {
                        TRACE_BEGIN_STM$("CompoundStatement215",215);
                        if(((boolean)(((CHECKER1$semchecker1$operation)(CUR$.SL$)).p1$left.sameAs$0().CPF().setPar(((CHECKER1$semchecker1$operation)(p$e)).p1$left).ENT$().RESULT$()))) {
                            // JavaLine 65 ==> SourceLine 216
                            LABEL$(1); // CR
                            RESULT$=((boolean)(((CHECKER1$semchecker1$operation)(CUR$.SL$)).p1$right.sameAs$0().CPF().setPar(((CHECKER1$semchecker1$operation)(p$e)).p1$right).ENT$().RESULT$()));
                        }
                        TRACE_END_STM$("CompoundStatement215",216);
                    }
                }
                TRACE_END_STM$("CompoundStatement212",216);
            }
        }
        TRACE_END_STM$("sameAs",216);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure sameAs",1,208,44,211,46,212,50,213,59,214,61,215,65,216,78,219);
}
