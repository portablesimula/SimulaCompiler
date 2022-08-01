// JavaLine 1 <== SourceLine 158
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:52 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class UtModule$SubBlock19$outxspec extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=158, lastLine=172, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$parspec p$s;
    // Declare local labels
    // JavaLine 11 <== SourceLine 166
    final LABQNT$ IMPX=new LABQNT$(this,1,"IMPX"); // Local Label #1=IMPX
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 159
    Common$quant q=null;
    // JavaLine 16 <== SourceLine 160
    Common$parspec inspect$160$127=null;
    // JavaLine 18 <== SourceLine 163
    Common$quant inspect$163$128=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public UtModule$SubBlock19$outxspec setPar(Object param) {
        //Util.BREAK("CALL UtModule$SubBlock19$outxspec.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public UtModule$SubBlock19$outxspec(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public UtModule$SubBlock19$outxspec(RTObject$ SL$,Common$parspec sp$s) {
        super(SL$);
        // Parameter assignment to locals
        this.p$s = sp$s;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public UtModule$SubBlock19$outxspec STM$() {
        UtModule$SubBlock19$outxspec THIS$=(UtModule$SubBlock19$outxspec)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 51 <== SourceLine 160
                {
                    // BEGIN INSPECTION 
                    inspect$160$127=p$s;
                    if(inspect$160$127!=null) // INSPECT inspect$160$127
                    // JavaLine 56 <== SourceLine 161
                    {
                        if(VALUE$((inspect$160$127.import$!=(null)))) {
                            // JavaLine 59 <== SourceLine 162
                            {
                                q=((Common$quant)(inspect$160$127.import$.first()));
                                ;
                                // JavaLine 63 <== SourceLine 163
                                while(true) {
                                    {
                                        // BEGIN INSPECTION 
                                        inspect$163$128=q;
                                        if(inspect$163$128!=null) // INSPECT inspect$163$128
                                        // JavaLine 69 <== SourceLine 164
                                        {
                                            new UtModule$SubBlock19$outxpar(((UtModule$SubBlock19)(CUR$.SL$)),((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_IMPORT$1,((Common$quant)inspect$163$128));
                                            ;
                                            q=((Common$quant)(inspect$163$128.suc()));
                                        }
                                        else // OTHERWISE 
                                        // JavaLine 76 <== SourceLine 165
                                        GOTO$(IMPX); // GOTO EVALUATED LABEL
                                    }
                                    if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                                }
                                ;
                                // JavaLine 82 <== SourceLine 166
                                LABEL$(1,"IMPX");
                                ;
                            }
                        }
                        ;
                        // JavaLine 88 <== SourceLine 167
                        if(VALUE$((inspect$160$127.export!=(null)))) {
                            // JavaLine 90 <== SourceLine 168
                            new UtModule$SubBlock19$outxpar(((UtModule$SubBlock19)(CUR$.SL$)),((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_EXPORT$1,inspect$160$127.export);
                        } else
                        if(VALUE$((inspect$160$127.exit!=(null)))) {
                            new UtModule$SubBlock19$outxpar(((UtModule$SubBlock19)(CUR$.SL$)),((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_EXIT$1,inspect$160$127.exit);
                        }
                        ;
                        // JavaLine 97 <== SourceLine 169
                        new OuptFile$outbyt(((UtModule)(CUR$.SL$.SL$)).inspect$17$115,((UtModule)(CUR$.SL$.SL$)).inspect$17$114.M_END$1);
                        ;
                        // JavaLine 100 <== SourceLine 170
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
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("outxspec:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("outxspec:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("outxspec:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("UTMODULE.sim","Procedure outxspec",1,158,11,166,14,159,16,160,18,163,51,160,56,161,59,162,63,163,69,164,76,165,82,166,88,167,90,168,97,169,100,170,123,172);
} // End of Procedure
