// JavaLine 1 <== SourceLine 142
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:52 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class UtModule$SubBlock19$outspec extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=142, lastLine=156, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$parspec p$s;
    // Declare local labels
    // JavaLine 11 <== SourceLine 150
    final LABQNT$ IMPX=new LABQNT$(this,1,"IMPX"); // Local Label #1=IMPX
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 143
    Common$quant q=null;
    // JavaLine 16 <== SourceLine 144
    Common$parspec inspect$144$125=null;
    // JavaLine 18 <== SourceLine 147
    Common$quant inspect$147$126=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public UtModule$SubBlock19$outspec setPar(Object param) {
        //Util.BREAK("CALL UtModule$SubBlock19$outspec.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$s=(Common$parspec)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public UtModule$SubBlock19$outspec(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public UtModule$SubBlock19$outspec(RTObject$ SL$,Common$parspec sp$s) {
        super(SL$);
        // Parameter assignment to locals
        this.p$s = sp$s;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public UtModule$SubBlock19$outspec STM$() {
        UtModule$SubBlock19$outspec THIS$=(UtModule$SubBlock19$outspec)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 51 <== SourceLine 144
                {
                    // BEGIN INSPECTION 
                    inspect$144$125=p$s;
                    if(inspect$144$125!=null) // INSPECT inspect$144$125
                    // JavaLine 56 <== SourceLine 145
                    {
                        if(VALUE$((inspect$144$125.import$!=(null)))) {
                            // JavaLine 59 <== SourceLine 146
                            {
                                q=((Common$quant)(inspect$144$125.import$.first()));
                                ;
                                // JavaLine 63 <== SourceLine 147
                                while(true) {
                                    {
                                        // BEGIN INSPECTION 
                                        inspect$147$126=q;
                                        if(inspect$147$126!=null) // INSPECT inspect$147$126
                                        // JavaLine 69 <== SourceLine 148
                                        {
                                            new UtModule$SubBlock19$outpar(((UtModule$SubBlock19)(CUR$.SL$)),((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_IMPORT$1,((Common$quant)inspect$147$126));
                                            ;
                                            q=((Common$quant)(inspect$147$126.suc()));
                                        }
                                        else // OTHERWISE 
                                        // JavaLine 76 <== SourceLine 149
                                        GOTO$(IMPX); // GOTO EVALUATED LABEL
                                    }
                                    if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                                }
                                ;
                                // JavaLine 82 <== SourceLine 150
                                LABEL$(1,"IMPX");
                                ;
                            }
                        }
                        ;
                        // JavaLine 88 <== SourceLine 151
                        if(VALUE$((inspect$144$125.export!=(null)))) {
                            // JavaLine 90 <== SourceLine 152
                            new UtModule$SubBlock19$outpar(((UtModule$SubBlock19)(CUR$.SL$)),((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_EXPORT$1,inspect$144$125.export);
                        } else
                        if(VALUE$((inspect$144$125.exit!=(null)))) {
                            new UtModule$SubBlock19$outpar(((UtModule$SubBlock19)(CUR$.SL$)),((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_EXIT$1,inspect$144$125.exit);
                        }
                        ;
                        // JavaLine 97 <== SourceLine 153
                        new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_END$1);
                        ;
                        // JavaLine 100 <== SourceLine 154
                        if(VALUE$((((UtModule)(CUR$.SL$.SL$)).inspect$17$115.output_trace$3>(0)))) {
                            new OuptFile$outcode(((UtModule)(CUR$.SL$.SL$)).inspect$17$115);
                        }
                        ;
                    }
                }
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("outspec:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("outspec:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("outspec:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("UTMODULE.sim","Procedure outspec",1,142,11,150,14,143,16,144,18,147,51,144,56,145,59,146,63,147,69,148,76,149,82,150,88,151,90,152,97,153,100,154,123,156);
} // End of Procedure
