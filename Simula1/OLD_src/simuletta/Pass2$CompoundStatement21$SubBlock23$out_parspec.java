// JavaLine 1 <== SourceLine 121
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:53 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass2$CompoundStatement21$SubBlock23$out_parspec extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=3, firstLine=121, lastLine=146, hasLocalClasses=false, System=false
    // Declare parameters as attributes
    public Common$parspec p$s;
    // Declare local labels
    // JavaLine 11 <== SourceLine 133
    final LABQNT$ XXX=new LABQNT$(this,1,"XXX"); // Local Label #1=XXX
    // Declare locals as attributes
    // JavaLine 14 <== SourceLine 122
    Common$quant q=null;
    // JavaLine 16 <== SourceLine 123
    Common$parspec inspect$123$154=null;
    // JavaLine 18 <== SourceLine 126
    Common$quant inspect$126$155=null;
    // JavaLine 20 <== SourceLine 134
    Common$quant inspect$134$156=null;
    // JavaLine 22 <== SourceLine 140
    Common$quant inspect$140$157=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass2$CompoundStatement21$SubBlock23$out_parspec setPar(Object param) {
        //Util.BREAK("CALL Pass2$CompoundStatement21$SubBlock23$out_parspec.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
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
    public Pass2$CompoundStatement21$SubBlock23$out_parspec(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass2$CompoundStatement21$SubBlock23$out_parspec(RTObject$ SL$,Common$parspec sp$s) {
        super(SL$);
        // Parameter assignment to locals
        this.p$s = sp$s;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass2$CompoundStatement21$SubBlock23$out_parspec STM$() {
        Pass2$CompoundStatement21$SubBlock23$out_parspec THIS$=(Pass2$CompoundStatement21$SubBlock23$out_parspec)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 55 <== SourceLine 123
                {
                    // BEGIN INSPECTION 
                    inspect$123$154=p$s;
                    if(inspect$123$154!=null) // INSPECT inspect$123$154
                    // JavaLine 60 <== SourceLine 124
                    {
                        if(VALUE$((inspect$123$154.import$!=(null)))) {
                            // JavaLine 63 <== SourceLine 125
                            {
                                q=((Common$quant)(inspect$123$154.import$.first()));
                                ;
                                // JavaLine 67 <== SourceLine 126
                                while(true) {
                                    {
                                        // BEGIN INSPECTION 
                                        inspect$126$155=q;
                                        if(inspect$126$155!=null) // INSPECT inspect$126$155
                                        // JavaLine 73 <== SourceLine 127
                                        {
                                            new Common$deftag(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$descr)inspect$126$155));
                                            ;
                                            // JavaLine 77 <== SourceLine 128
                                            new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_IMPORT$1);
                                            ;
                                            new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$126$155.tag$2);
                                            ;
                                            // JavaLine 82 <== SourceLine 129
                                            new Pass2$CompoundStatement21$SubBlock23$outquant(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$quant)inspect$126$155));
                                            ;
                                            // JavaLine 85 <== SourceLine 130
                                            if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                                new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                            }
                                            ;
                                            // JavaLine 90 <== SourceLine 131
                                            q=((Common$quant)(inspect$126$155.suc()));
                                            ;
                                        }
                                        else // OTHERWISE 
                                        // JavaLine 95 <== SourceLine 132
                                        GOTO$(XXX); // GOTO EVALUATED LABEL
                                    }
                                    if(CTX$==null) break; // Ad'Hoc to prevent JAVAC error: 'dead code' and terminate
                                }
                                ;
                                // JavaLine 101 <== SourceLine 133
                                LABEL$(1,"XXX");
                                ;
                            }
                        }
                        ;
                        // JavaLine 107 <== SourceLine 134
                        {
                            // BEGIN INSPECTION 
                            inspect$134$156=inspect$123$154.export;
                            if(inspect$134$156!=null) // INSPECT inspect$134$156
                            // JavaLine 112 <== SourceLine 135
                            {
                                new Common$deftag(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$descr)inspect$134$156));
                                ;
                                // JavaLine 116 <== SourceLine 136
                                new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_EXPORT$1);
                                ;
                                new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$134$156.tag$2);
                                ;
                                // JavaLine 121 <== SourceLine 137
                                new Pass2$CompoundStatement21$SubBlock23$outquant(((Pass2$CompoundStatement21$SubBlock23)(CUR$.SL$)),((Common$quant)inspect$134$156));
                                ;
                                // JavaLine 124 <== SourceLine 138
                                if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                    new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                }
                                ;
                            }
                            else // OTHERWISE 
                            // JavaLine 131 <== SourceLine 140
                            {
                                // BEGIN INSPECTION 
                                inspect$140$157=inspect$123$154.exit;
                                if(inspect$140$157!=null) // INSPECT inspect$140$157
                                // JavaLine 136 <== SourceLine 141
                                {
                                    new Common$deftag(((Pass2)(CUR$.SL$.SL$)).inspect$20$141,((Common$descr)inspect$140$157));
                                    ;
                                    // JavaLine 140 <== SourceLine 142
                                    new OuptFile$outinst(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,((Pass2)(CUR$.SL$.SL$)).inspect$20$141.S_EXIT$1);
                                    ;
                                    new OuptFile$outtagid(((Pass2)(CUR$.SL$.SL$)).inspect$21$143,inspect$140$157.tag$2);
                                    ;
                                    // JavaLine 145 <== SourceLine 143
                                    if(VALUE$((((Pass2)(CUR$.SL$.SL$)).inspect$21$143.output_trace$3>(0)))) {
                                        new OuptFile$outcode(((Pass2)(CUR$.SL$.SL$)).inspect$21$143);
                                    }
                                    ;
                                }
                            }
                        }
                        ;
                    }
                }
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("out_parspec:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("out_parspec:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("out_parspec:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PASS2.sim","Procedure out_parspec",1,121,11,133,14,122,16,123,18,126,20,134,22,140,55,123,60,124,63,125,67,126,73,127,77,128,82,129,85,130,90,131,95,132,101,133,107,134,112,135,116,136,121,137,124,138,131,140,136,141,140,142,145,143,173,146);
} // End of Procedure
