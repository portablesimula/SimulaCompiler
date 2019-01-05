// JavaLine 1 ==> SourceLine 1160
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:59:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$prechecker$allocate$alloc2$checkhid extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=5, firstLine=1160, lastLine=1183, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public COMMON$quantity p$cq;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 1181
    final LABQNT$ NXT=new LABQNT$(this,0,1); // Local Label #1=NXT
    // Declare locals as attributes
    // JavaLine 15 ==> SourceLine 1162
    COMMON$idpack cvis=null;
    // JavaLine 17 ==> SourceLine 1166
    COMMON$brecord inspect$1165$80=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER2$prechecker$allocate$alloc2$checkhid setPar(Object param) {
        //Util.BREAK("CALL BUILDER2$prechecker$allocate$alloc2$checkhid.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$cq=(COMMON$quantity)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER2$prechecker$allocate$alloc2$checkhid(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER2$prechecker$allocate$alloc2$checkhid(RTObject$ SL$,COMMON$quantity sp$cq) {
        super(SL$);
        // Parameter assignment to locals
        this.p$cq = sp$cq;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("checkhid",1166);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$prechecker$allocate$alloc2$checkhid STM$() {
        TRACE_BEGIN_STM$("checkhid",1166);
        BUILDER2$prechecker$allocate$alloc2$checkhid THIS$=(BUILDER2$prechecker$allocate$alloc2$checkhid)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 52 ==> SourceLine 1165
                {
                    // BEGIN INSPECTION 
                    inspect$1165$80=((BUILDER2$prechecker$allocate$alloc2)(CUR$.SL$)).p$brc;
                    if(inspect$1165$80!=null) //INSPECT inspect$1165$80
                    // JavaLine 57 ==> SourceLine 1166
                    while(((inspect$1165$80.hidlist!=(null))&&((p$cq!=(null))))) {
                        // JavaLine 59 ==> SourceLine 1167
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1167",1167);
                            if((p$cq.visible==(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).NUL))) {
                                // JavaLine 63 ==> SourceLine 1168
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1168",1168);
                                    cvis=inspect$1165$80.hidlist;
                                    // JavaLine 67 ==> SourceLine 1169
                                    while((cvis!=(null))) {
                                        // JavaLine 69 ==> SourceLine 1170
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1170",1170);
                                            if((p$cq.symb==(new COMMON$boxof(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)),cvis.idhi,cvis.idlo).RESULT$))) {
                                                // JavaLine 73 ==> SourceLine 1172
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement1172",1172);
                                                    if((cvis.line>(0))) {
                                                        // JavaLine 77 ==> SourceLine 1173
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement1173",1173);
                                                            if((p$cq.protect==(((char)1)))) {
                                                                // JavaLine 81 ==> SourceLine 1174
                                                                {
                                                                    TRACE_BEGIN_STM$("CompoundStatement1174",1174);
                                                                    cvis.line=(-(cvis.line));
                                                                    GOTO$(NXT); // GOTO EVALUATED LABEL
                                                                    TRACE_END_STM$("CompoundStatement1174",1174);
                                                                }
                                                            }
                                                            // JavaLine 89 ==> SourceLine 1177
                                                            new ERRMSG$removeVis(((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)),((COMMON$brecord)inspect$1165$80),cvis,369);
                                                            TRACE_END_STM$("CompoundStatement1173",1177);
                                                        }
                                                    }
                                                    TRACE_END_STM$("CompoundStatement1172",1177);
                                                }
                                            }
                                            // JavaLine 97 ==> SourceLine 1178
                                            cvis=cvis.next;
                                            TRACE_END_STM$("CompoundStatement1170",1178);
                                        }
                                    }
                                    TRACE_END_STM$("CompoundStatement1168",1178);
                                }
                            }
                            // JavaLine 105 ==> SourceLine 1182
                            LABEL$(1); // NXT
                            // JavaLine 107 ==> SourceLine 1181
                            p$cq=((COMMON$quantity)(p$cq.next));
                            TRACE_END_STM$("CompoundStatement1167",1181);
                        }
                    }
                }
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
        TRACE_END_STM$("checkhid",1181);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure checkhid",1,1160,12,1181,15,1162,17,1166,52,1165,57,1166,59,1167,63,1168,67,1169,69,1170,73,1172,77,1173,81,1174,89,1177,97,1178,105,1182,107,1181,129,1183);
}
