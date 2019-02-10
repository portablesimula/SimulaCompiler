// JavaLine 1 ==> SourceLine 1643
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$dotIdent$sameAs extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1643, lastLine=1650, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public CHECKER1$semchecker1$exp p$e;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public CHECKER1$semchecker1$dotIdent$sameAs setPar(Object param) {
        //Util.BREAK("CALL CHECKER1$semchecker1$dotIdent$sameAs.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public CHECKER1$semchecker1$dotIdent$sameAs(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public CHECKER1$semchecker1$dotIdent$sameAs(RTObject$ SL$,CHECKER1$semchecker1$exp sp$e) {
        super(SL$);
        // Parameter assignment to locals
        this.p$e = sp$e;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("sameAs",1643);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$dotIdent$sameAs STM$() {
        TRACE_BEGIN_STM$("sameAs",1643);
        // JavaLine 44 ==> SourceLine 1644
        if(VALUE$((((CHECKER1$semchecker1$dotIdent)(CUR$.SL$)).kind!=(((CHECKER1)(CUR$.SL$.SL$.SL$)).K_proc)))) {
            {
                TRACE_BEGIN_STM$("CompoundStatement1644",1644);
                if(VALUE$((((CHECKER1$semchecker1$dotIdent)(CUR$.SL$)).meaning.categ!=(((CHECKER1)(CUR$.SL$.SL$.SL$)).C_name)))) {
                    // JavaLine 49 ==> SourceLine 1645
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1645",1645);
                        if(VALUE$((((CHECKER1$semchecker1$dotIdent)(CUR$.SL$)).p2$dotexp!=(null)))) {
                            // JavaLine 53 ==> SourceLine 1647
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1647",1647);
                                if(VALUE$(IS$(p$e,CHECKER1$semchecker1$dotIdent.class))) {
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1647",1647);
                                        if(VALUE$((p$e.meaning==(((CHECKER1$semchecker1$dotIdent)(CUR$.SL$)).meaning)))) {
                                            // JavaLine 60 ==> SourceLine 1648
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1648",1648);
                                                if(VALUE$((((CHECKER1$semchecker1$dotIdent)(p$e)).p2$dotexp!=(null)))) {
                                                    // JavaLine 64 ==> SourceLine 1649
                                                    RESULT$=((boolean)(((CHECKER1$semchecker1$dotIdent)(CUR$.SL$)).p2$dotexp.sameAs$0().CPF().setPar(((CHECKER1$semchecker1$dotIdent)(p$e)).p2$dotexp).ENT$().RESULT$()));
                                                }
                                                TRACE_END_STM$("CompoundStatement1648",1649);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement1647",1649);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement1647",1649);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement1645",1649);
                    }
                }
                TRACE_END_STM$("CompoundStatement1644",1649);
            }
        }
        TRACE_END_STM$("sameAs",1649);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure sameAs",1,1643,44,1644,49,1645,53,1647,60,1648,64,1649,85,1650);
}
