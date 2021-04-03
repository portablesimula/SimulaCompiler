// JavaLine 1 <== SourceLine 1775
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:54 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$type_check$inprefix extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=1775, lastLine=1790, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public Common$symbolbox p$q1;
    public Common$symbolbox p$q2;
    // Declare local labels
    // JavaLine 15 <== SourceLine 1790
    final LABQNT$ L=new LABQNT$(this,1,"L"); // Local Label #1=L
    // Declare locals as attributes
    // JavaLine 18 <== SourceLine 1776
    Linkage$ dentry=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$type_check$inprefix setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$type_check$inprefix.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 2: p$q1=(Common$symbolbox)objectValue(param); break;
                case 1: p$q2=(Common$symbolbox)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$type_check$inprefix(RTObject$ SL$) {
        super(SL$,2); // Expecting 2 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$type_check$inprefix(RTObject$ SL$,Common$symbolbox sp$q1,Common$symbolbox sp$q2) {
        super(SL$);
        // Parameter assignment to locals
        this.p$q1 = sp$q1;
        this.p$q2 = sp$q2;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$type_check$inprefix STM$() {
        Pass2$CompoundStatement21$SubBlock23$type_check$inprefix THIS$=(Pass2$CompoundStatement21$SubBlock23$type_check$inprefix)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 53 <== SourceLine 1778
                if(VALUE$((p$q2==(((Pass2)(CUR$.SL$.SL$.SL$)).inspect$20$141.dummyBox$1)))) {
                    RESULT$=true;
                } else
                // JavaLine 57 <== SourceLine 1779
                if(VALUE$((IS$(p$q2.curmeaning,Common$record.class)&(IS$(p$q1.curmeaning,Common$record.class))))) {
                    // JavaLine 59 <== SourceLine 1780
                    while(true) {
                        // JavaLine 61 <== SourceLine 1782
                        {
                            dentry=p$q1.curmeaning;
                            ;
                            // JavaLine 65 <== SourceLine 1783
                            if(VALUE$(IS$(dentry,Common$record.class))) {
                                // JavaLine 67 <== SourceLine 1784
                                {
                                    p$q1=((Common$record)(dentry)).prefbox$3;
                                    ;
                                    // JavaLine 71 <== SourceLine 1785
                                    if(VALUE$((p$q1==(p$q2)))) {
                                        // JavaLine 73 <== SourceLine 1786
                                        {
                                            RESULT$=true;
                                            ;
                                            GOTO$(L); // GOTO EVALUATED LABEL
                                        }
                                    }
                                    ;
                                    // JavaLine 81 <== SourceLine 1787
                                    if(VALUE$((p$q1==(null)))) {
                                        GOTO$(L); // GOTO EVALUATED LABEL
                                    }
                                    ;
                                }
                            } else
                            // JavaLine 88 <== SourceLine 1788
                            GOTO$(L); // GOTO EVALUATED LABEL
                            ;
                        }
                        if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                    }
                }
                ;
                // JavaLine 96 <== SourceLine 1790
                LABEL$(1,"L");
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("inprefix:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("inprefix:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("inprefix:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure inprefix",1,1775,15,1790,18,1776,53,1778,57,1779,59,1780,61,1782,65,1783,67,1784,71,1785,73,1786,81,1787,88,1788,96,1790,115,1790);
} // End of Procedure
