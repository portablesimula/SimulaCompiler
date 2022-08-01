// JavaLine 1 <== SourceLine 17
package simulaTestPrograms;
// Simula-2.0 Compiled at Fri Sep 10 10:56:34 CEST 2021
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class issue42$$GOTO_ERROR extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=17, lastLine=26, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public int p$n;
    // Declare local labels
    // JavaLine 14 <== SourceLine 23
    final LABQNT$ LABEL$ERR=new LABQNT$(this,1,"ERR"); // Local Label #1=ERR
    final LABQNT$ LABEL$LLL=new LABQNT$(this,2,"LLL"); // Local Label #2=LLL
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public issue42$$GOTO_ERROR setPar(Object param) {
        //Util.BREAK("CALL issue42$$GOTO_ERROR.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$n=intValue(param); break;
                default: throw new SimulaRuntimeError("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new SimulaRuntimeError("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public issue42$$GOTO_ERROR(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public issue42$$GOTO_ERROR(RTObject$ SL$,int sp$n) {
        super(SL$);
        // Parameter assignment to locals
        this.p$n = sp$n;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public issue42$$GOTO_ERROR STM$() {
        issue42$$GOTO_ERROR THIS$=(issue42$$GOTO_ERROR)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 49 <== SourceLine 18
                if(VALUE$((p$n>(4)))) {
                    // JavaLine 51 <== SourceLine 19
                    {
                        RESULT$=44444444;
                        ;
                        // JavaLine 55 <== SourceLine 20
                        if(VALUE$((p$n>(5)))) {
                            GOTO$(LABEL$ERR); // GOTO EVALUATED LABEL
                        }
                        ;
                        // JavaLine 60 <== SourceLine 21
                        new issue42$$trace(((issue42$)(CUR$.SL$)),new TXT$("No else brance"));
                        ;
                    }
                } else
                // JavaLine 65 <== SourceLine 25
                {
                    // JavaLine 67 <== SourceLine 24
                    {
                        LABEL$(1,"ERR");
                        LABEL$(2,"LLL");
                        RESULT$=88888888;
                        ;
                    }
                }
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("GOTO_ERROR:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("GOTO_ERROR:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("GOTO_ERROR:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("issue42.sim","Procedure GOTO_ERROR",1,17,14,23,49,18,51,19,55,20,60,21,65,25,67,24,92,26);
} // End of Procedure
