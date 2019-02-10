// JavaLine 1 ==> SourceLine 208
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
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
    // Declare local labels
    // JavaLine 15 ==> SourceLine 216
    final LABQNT$ CR=new LABQNT$(this,0,1); // Local Label #1=CR
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
        TRACE_BEGIN_DCL$("sameAs",216);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$operation$sameAs STM$() {
        TRACE_BEGIN_STM$("sameAs",216);
        CHECKER1$semchecker1$operation$sameAs THIS$=(CHECKER1$semchecker1$operation$sameAs)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 51 ==> SourceLine 211
                if(VALUE$(p$e instanceof CHECKER1$semchecker1$operation)) {
                    // JavaLine 53 ==> SourceLine 212
                    {
                        TRACE_BEGIN_STM$("CompoundStatement212",212);
                        if(VALUE$((((CHECKER1$semchecker1$operation)(CUR$.SL$)).p1$left==(null)))) {
                            // JavaLine 57 ==> SourceLine 213
                            {
                                TRACE_BEGIN_STM$("CompoundStatement213",213);
                                if(VALUE$((((CHECKER1$semchecker1$operation)(p$e)).p1$left==(null)))) {
                                    GOTO$(CR); // GOTO EVALUATED LABEL
                                }
                                TRACE_END_STM$("CompoundStatement213",213);
                            }
                        } else
                        // JavaLine 66 ==> SourceLine 214
                        if(VALUE$((((CHECKER1$semchecker1$operation)(p$e)).p1$left!=(null)))) {
                            // JavaLine 68 ==> SourceLine 215
                            {
                                TRACE_BEGIN_STM$("CompoundStatement215",215);
                                if(VALUE$(((boolean)(((CHECKER1$semchecker1$operation)(CUR$.SL$)).p1$left.sameAs$0().CPF().setPar(((CHECKER1$semchecker1$operation)(p$e)).p1$left).ENT$().RESULT$())))) {
                                    // JavaLine 72 ==> SourceLine 216
                                    LABEL$(1,"CR");
                                    RESULT$=((boolean)(((CHECKER1$semchecker1$operation)(CUR$.SL$)).p1$right.sameAs$0().CPF().setPar(((CHECKER1$semchecker1$operation)(p$e)).p1$right).ENT$().RESULT$()));
                                }
                                TRACE_END_STM$("CompoundStatement215",216);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement212",216);
                    }
                }
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$ || q.prefixLevel!=0) {
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("sameAs",216);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure sameAs",1,208,15,216,51,211,53,212,57,213,66,214,68,215,72,216,98,219);
}
