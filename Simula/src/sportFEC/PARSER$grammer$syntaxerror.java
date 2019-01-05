// JavaLine 1 ==> SourceLine 241
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:46:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$syntaxerror extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=241, lastLine=260, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$errorno;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 242
    int c=0;
    PARSER$grammer$statement stmnt=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public PARSER$grammer$syntaxerror setPar(Object param) {
        //Util.BREAK("CALL PARSER$grammer$syntaxerror.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$errorno=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public PARSER$grammer$syntaxerror(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public PARSER$grammer$syntaxerror(RTObject$ SL$,int sp$errorno) {
        super(SL$);
        // Parameter assignment to locals
        this.p$errorno = sp$errorno;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("syntaxerror",242);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$syntaxerror STM$() {
        TRACE_BEGIN_STM$("syntaxerror",242);
        // JavaLine 44 ==> SourceLine 243
        if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IEOP))) {
            {
                TRACE_BEGIN_STM$("CompoundStatement243",243);
                new PARSER$grammer$setCurPos(((PARSER$grammer)(CUR$.SL$)));
                // JavaLine 49 ==> SourceLine 244
                new ERRMSG$parserMessage(((PARSER)(CUR$.SL$.SL$)),((PARSER$grammer)(CUR$.SL$)).currentPos,p$errorno,((PARSER$grammer)(CUR$.SL$)).experrorno);
                TRACE_END_STM$("CompoundStatement243",244);
            }
        }
        // JavaLine 54 ==> SourceLine 245
        ((PARSER$grammer)(CUR$.SL$)).experrorno=0;
        // JavaLine 56 ==> SourceLine 246
        for(boolean CB$246:new ForList(
            new StepUntil(new NAME$<Number>(){ public Number put(Number x$){c=(int)x$; return(x$);};  public Number get(){return((Number)c); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(150); }})
           )) { if(!CB$246) continue;
        ((PARSER$grammer)(CUR$.SL$)).recoversymbol.Elt[c-((PARSER$grammer)(CUR$.SL$)).recoversymbol.LB[0]]=false;
    }
    // JavaLine 62 ==> SourceLine 247
    new PARSER$grammer$setbasicrecovery(((PARSER$grammer)(CUR$.SL$)));
    // JavaLine 64 ==> SourceLine 248
    stmnt=((PARSER$grammer)(CUR$.SL$)).first;
    // JavaLine 66 ==> SourceLine 249
    while((stmnt!=(null))) {
        // JavaLine 68 ==> SourceLine 250
        {
            TRACE_BEGIN_STM$("CompoundStatement250",250);
            stmnt.recoversetting$0().CPF();
            stmnt=stmnt.next;
            TRACE_END_STM$("CompoundStatement250",250);
        }
    }
    // JavaLine 76 ==> SourceLine 251
    new PARSER$grammer$search(((PARSER$grammer)(CUR$.SL$)));
    // JavaLine 78 ==> SourceLine 252
    while((!(((boolean)(((PARSER$grammer)(CUR$.SL$)).last.recover$0().CPF().RESULT$()))))) {
        // JavaLine 80 ==> SourceLine 255
        {
            TRACE_BEGIN_STM$("CompoundStatement255",255);
            ((PARSER$grammer)(CUR$.SL$)).last=((PARSER$grammer)(CUR$.SL$)).last.caller;
            TRACE_END_STM$("CompoundStatement255",255);
        }
    }
    // JavaLine 87 ==> SourceLine 256
    ((PARSER$grammer)(CUR$.SL$)).last.next=null;
    TRACE_END_STM$("syntaxerror",256);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure syntaxerror",1,241,12,242,44,243,49,244,54,245,56,246,62,247,64,248,66,249,68,250,76,251,78,252,80,255,87,256,92,260);
}
