// JavaLine 1 <== SourceLine 1537
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$outstruct$out_atrset extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=1537, lastLine=1549, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Head$ p$S;
    // Declare local labels
    // JavaLine 11 <== SourceLine 1549
    final LABQNT$ XIT=new LABQNT$(this,1,"XIT"); // Local Label #1=XIT
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 1538
    Common$quant q=null;
    int t2=0;
    // JavaLine 17 <== SourceLine 1540
    Common$quant inspect$1540$215=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$outstruct$out_atrset setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$outstruct$out_atrset.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$S=(Head$)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$outstruct$out_atrset(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$outstruct$out_atrset(RTObject$ SL$,Head$ sp$S) {
        super(SL$);
        // Parameter assignment to locals
        this.p$S = sp$S;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$outstruct$out_atrset STM$() {
        Pass2$CompoundStatement21$SubBlock23$outstruct$out_atrset THIS$=(Pass2$CompoundStatement21$SubBlock23$outstruct$out_atrset)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 50 <== SourceLine 1539
                q=((Common$quant)(p$S.first()));
                ;
                // JavaLine 53 <== SourceLine 1540
                while(true) {
                    {
                        // BEGIN INSPECTION 
                        inspect$1540$215=q;
                        if(inspect$1540$215!=null) // INSPECT inspect$1540$215
                        {
                            q=((Common$quant)(inspect$1540$215.suc()));
                            ;
                            // JavaLine 62 <== SourceLine 1541
                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.S_ATTR$1);
                            ;
                            new OuptFile$outtag(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$21$143,inspect$1540$215.tag$2);
                            ;
                            // JavaLine 67 <== SourceLine 1542
                            new Pass2$CompoundStatement21$SubBlock23$outtype(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),inspect$1540$215.p3$type);
                            ;
                            // JavaLine 70 <== SourceLine 1543
                            ((Pass2$CompoundStatement21$SubBlock23$outstruct)(CUR$.SL$)).n=new Pass2$CompoundStatement21$SubBlock23$outstruct$get_elt(((Pass2$CompoundStatement21$SubBlock23$outstruct)(CUR$.SL$)),inspect$1540$215.symb$2).RESULT$;
                            ;
                            // JavaLine 73 <== SourceLine 1544
                            if(VALUE$((((Pass2$CompoundStatement21$SubBlock23$outstruct)(CUR$.SL$)).n==(null)))) {
                                // JavaLine 75 <== SourceLine 1545
                                new Pass2$CompoundStatement21$SubBlock23$outdefault(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),inspect$1540$215.p3$type);
                            } else
                            // JavaLine 78 <== SourceLine 1546
                            {
                                t2=new Pass2$CompoundStatement21$SubBlock23$outconst(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),((Pass2$CompoundStatement21$SubBlock23$outstruct)(CUR$.SL$)).n.p2$elt).RESULT$;
                                ;
                                // JavaLine 82 <== SourceLine 1547
                                if(VALUE$((t2!=(inspect$1540$215.p3$type)))) {
                                    new Pass2$CompoundStatement21$SubBlock23$tstconv(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$.SL$)),t2,inspect$1540$215.p3$type);
                                }
                                ;
                                ((Pass2$CompoundStatement21$SubBlock23$outstruct)(CUR$.SL$)).n.out();
                            }
                            ;
                        }
                        else // OTHERWISE 
                        // JavaLine 92 <== SourceLine 1548
                        GOTO$(XIT); // GOTO EVALUATED LABEL
                    }
                    if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                }
                ;
                // JavaLine 98 <== SourceLine 1549
                LABEL$(1,"XIT");
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("out_atrset:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("out_atrset:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("out_atrset:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure out_atrset",1,1537,11,1549,14,1538,17,1540,50,1539,53,1540,62,1541,67,1542,70,1543,73,1544,75,1545,78,1546,82,1547,92,1548,98,1549,117,1549);
} // End of Procedure
