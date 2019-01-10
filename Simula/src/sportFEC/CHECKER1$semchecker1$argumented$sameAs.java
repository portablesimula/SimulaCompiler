// JavaLine 1 ==> SourceLine 1790
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$argumented$sameAs extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1790, lastLine=1812, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public CHECKER1$semchecker1$exp p$e;
    // Declare local labels
    // JavaLine 15 ==> SourceLine 1812
    final LABQNT$ EX=new LABQNT$(this,0,1); // Local Label #1=EX
    // Declare locals as attributes
    // JavaLine 18 ==> SourceLine 1791
    CHECKER1$semchecker1$argument arg1=null;
    CHECKER1$semchecker1$argument arg2=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public CHECKER1$semchecker1$argumented$sameAs setPar(Object param) {
        //Util.BREAK("CALL CHECKER1$semchecker1$argumented$sameAs.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public CHECKER1$semchecker1$argumented$sameAs(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public CHECKER1$semchecker1$argumented$sameAs(RTObject$ SL$,CHECKER1$semchecker1$exp sp$e) {
        super(SL$);
        // Parameter assignment to locals
        this.p$e = sp$e;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("sameAs",1791);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$argumented$sameAs STM$() {
        TRACE_BEGIN_STM$("sameAs",1791);
        CHECKER1$semchecker1$argumented$sameAs THIS$=(CHECKER1$semchecker1$argumented$sameAs)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 54 ==> SourceLine 1792
                if((p$e.ctype==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDNP))) {
                    // JavaLine 56 ==> SourceLine 1793
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1793",1793);
                        if((p$e.meaning==(((CHECKER1$semchecker1$argumented)(CUR$.SL$)).p1$ident.meaning))) {
                            // JavaLine 60 ==> SourceLine 1794
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1794",1794);
                                if(((boolean)(((CHECKER1$semchecker1$argumented)(CUR$.SL$)).p1$ident.sameAs$0().CPF().setPar(((CHECKER1$semchecker1$argumented)(p$e)).p1$ident).ENT$().RESULT$()))) {
                                    // JavaLine 64 ==> SourceLine 1796
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1796",1796);
                                        arg1=((CHECKER1$semchecker1$argumented)(CUR$.SL$)).p1$arguments;
                                        arg2=((CHECKER1$semchecker1$argumented)(p$e)).p1$arguments;
                                        // JavaLine 69 ==> SourceLine 1797
                                        while((arg1!=(null))) {
                                            // JavaLine 71 ==> SourceLine 1798
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1798",1798);
                                                if((arg2==(null))) {
                                                    GOTO$(EX); // GOTO EVALUATED LABEL
                                                }
                                                // JavaLine 77 ==> SourceLine 1799
                                                if((!(((boolean)(arg1.p$actual.sameAs$0().CPF().setPar(arg2.p$actual).ENT$().RESULT$()))))) {
                                                    // JavaLine 79 ==> SourceLine 1800
                                                    GOTO$(EX); // GOTO EVALUATED LABEL
                                                }
                                                // JavaLine 82 ==> SourceLine 1801
                                                arg1=arg1.nextarg;
                                                arg2=arg2.nextarg;
                                                TRACE_END_STM$("CompoundStatement1798",1801);
                                            }
                                        }
                                        // JavaLine 88 ==> SourceLine 1803
                                        RESULT$=true;
                                        TRACE_END_STM$("CompoundStatement1796",1803);
                                    }
                                }
                                TRACE_END_STM$("CompoundStatement1794",1803);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement1793",1803);
                    }
                }
                // JavaLine 99 ==> SourceLine 1812
                LABEL$(1); // EX
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
        TRACE_END_STM$("sameAs",1812);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure sameAs",1,1790,15,1812,18,1791,54,1792,56,1793,60,1794,64,1796,69,1797,71,1798,77,1799,79,1800,82,1801,88,1803,99,1812,117,1812);
}
