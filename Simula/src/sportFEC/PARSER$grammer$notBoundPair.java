// JavaLine 1 ==> SourceLine 582
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$notBoundPair extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=582, lastLine=599, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public char p$colon;
    // Declare local labels
    // JavaLine 15 ==> SourceLine 599
    final LABQNT$ EXIT=new LABQNT$(this,0,1); // Local Label #1=EXIT
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public PARSER$grammer$notBoundPair setPar(Object param) {
        //Util.BREAK("CALL PARSER$grammer$notBoundPair.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$colon=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public PARSER$grammer$notBoundPair(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public PARSER$grammer$notBoundPair(RTObject$ SL$,char sp$colon) {
        super(SL$);
        // Parameter assignment to locals
        this.p$colon = sp$colon;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("notBoundPair",599);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$notBoundPair STM$() {
        TRACE_BEGIN_STM$("notBoundPair",599);
        PARSER$grammer$notBoundPair THIS$=(PARSER$grammer$notBoundPair)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 51 ==> SourceLine 584
                ((PARSER$grammer)(CUR$.SL$)).detach();
                RESULT$=0;
                // JavaLine 54 ==> SourceLine 586
                call(((PARSER$grammer)(CUR$.SL$)).ex);
                // JavaLine 56 ==> SourceLine 587
                if(VALUE$(((PARSER$grammer)(CUR$.SL$)).ex.wasNotexpr)) {
                    // JavaLine 58 ==> SourceLine 588
                    {
                        TRACE_BEGIN_STM$("CompoundStatement588",588);
                        RESULT$=4;
                        new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$)),188);
                        GOTO$(EXIT); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement588",588);
                    }
                }
                // JavaLine 67 ==> SourceLine 589
                if(VALUE$(((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).ICL))&&((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IDENO)))))) {
                    // JavaLine 69 ==> SourceLine 590
                    {
                        TRACE_BEGIN_STM$("CompoundStatement590",590);
                        RESULT$=4;
                        new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$)),189);
                        GOTO$(EXIT); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement590",590);
                    }
                }
                // JavaLine 78 ==> SourceLine 591
                ((PARSER)(CUR$.SL$.SL$)).opn=p$colon;
                // JavaLine 80 ==> SourceLine 592
                if(VALUE$((p$colon==(((PARSER)(CUR$.SL$.SL$)).IPSPC)))) {
                    {
                        TRACE_BEGIN_STM$("CompoundStatement592",592);
                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).ICASE;
                        ((PARSER)(CUR$.SL$.SL$)).opdlo=((PARSER)(CUR$.SL$.SL$)).IPSPC;
                        TRACE_END_STM$("CompoundStatement592",592);
                    }
                }
                // JavaLine 89 ==> SourceLine 593
                call(((PARSER)(CUR$.SL$.SL$)).coder);
                // JavaLine 91 ==> SourceLine 594
                if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IDENO)))) {
                    ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).IMINU;
                } else
                // JavaLine 95 ==> SourceLine 595
                ((PARSER$grammer)(CUR$.SL$)).detach();
                // JavaLine 97 ==> SourceLine 596
                call(((PARSER$grammer)(CUR$.SL$)).ex);
                // JavaLine 99 ==> SourceLine 597
                if(VALUE$(((PARSER$grammer)(CUR$.SL$)).ex.wasNotexpr)) {
                    // JavaLine 101 ==> SourceLine 598
                    {
                        TRACE_BEGIN_STM$("CompoundStatement598",598);
                        RESULT$=5;
                        new PARSER$grammer$syntaxerror(((PARSER$grammer)(CUR$.SL$)),188);
                        TRACE_END_STM$("CompoundStatement598",598);
                    }
                }
                // JavaLine 109 ==> SourceLine 599
                LABEL$(1,"EXIT");
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
        TRACE_END_STM$("notBoundPair",599);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure notBoundPair",1,582,15,599,51,584,54,586,56,587,58,588,67,589,69,590,78,591,80,592,89,593,91,594,95,595,97,596,99,597,101,598,109,599,127,599);
}
