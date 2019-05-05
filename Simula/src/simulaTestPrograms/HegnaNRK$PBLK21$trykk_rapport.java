// JavaLine 1 <== SourceLine 1091
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Sun May 05 10:24:02 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$trykk_rapport extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1091, lastLine=1125, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$formatnr;
    // Declare locals as attributes
    // JavaLine 12 <== SourceLine 1093
    int i=0;
    int k=0;
    int felt_linje=0;
    boolean funnet=false;
    // JavaLine 17 <== SourceLine 1099
    HegnaNRK$PBLK21$format inspect$1099$6=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$trykk_rapport setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$trykk_rapport.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$formatnr=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HegnaNRK$PBLK21$trykk_rapport(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$trykk_rapport(RTObject$ SL$,int sp$formatnr) {
        super(SL$);
        // Parameter assignment to locals
        this.p$formatnr = sp$formatnr;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("trykk_rapport",1099);
        STM$();
    }
    // Procedure Statements
    public HegnaNRK$PBLK21$trykk_rapport STM$() {
        TRACE_BEGIN_STM$("trykk_rapport",1099);
        {
            // BEGIN INSPECTION 
            inspect$1099$6=((HegnaNRK$PBLK21)(CUR$.SL$)).format_peker.Elt[p$formatnr-((HegnaNRK$PBLK21)(CUR$.SL$)).format_peker.LB[0]];
            if(inspect$1099$6!=null) // INSPECT inspect$1099$6
            // JavaLine 52 <== SourceLine 1101
            {
                TRACE_BEGIN_STM$("CompoundStatement1101",1101);
                felt_linje=0;
                // JavaLine 56 <== SourceLine 1102
                for(boolean CB$1102:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(inspect$1099$6.p$antall); }})
                   )) { if(!CB$1102) continue;
                // JavaLine 60 <== SourceLine 1104
                {
                    TRACE_BEGIN_STM$("CompoundStatement1104",1104);
                    k=0;
                    // JavaLine 64 <== SourceLine 1105
                    funnet=false;
                    // JavaLine 66 <== SourceLine 1106
                    while(((!(funnet))&((k<(((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall$1))))) {
                        // JavaLine 68 <== SourceLine 1108
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1108",1108);
                            k=(k+(1));
                            // JavaLine 72 <== SourceLine 1109
                            funnet=(inspect$1099$6.fnr.Elt[i-inspect$1099$6.fnr.LB[0]]==(((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.Elt[k-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.LB[0]]));
                            TRACE_END_STM$("CompoundStatement1108",1109);
                        }
                    }
                    // JavaLine 77 <== SourceLine 1111
                    if(VALUE$(funnet)) {
                        // JavaLine 79 <== SourceLine 1113
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1113",1113);
                            if(VALUE$((inspect$1099$6.spos.Elt[i-inspect$1099$6.spos.LB[0]]==(0)))) {
                                // JavaLine 83 <== SourceLine 1114
                                sysout().outchar(((char)32));
                            } else
                            // JavaLine 86 <== SourceLine 1116
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1116",1116);
                                if(VALUE$((inspect$1099$6.spos.Elt[i-inspect$1099$6.spos.LB[0]]<(TXT$.pos(sysout().image))))) {
                                    new HegnaNRK$PBLK21$trykk_rapport$skriv_linje(((HegnaNRK$PBLK21$trykk_rapport)CUR$));
                                }
                                // JavaLine 92 <== SourceLine 1117
                                TXT$.setpos(sysout().image,inspect$1099$6.spos.Elt[i-inspect$1099$6.spos.LB[0]]);
                                TRACE_END_STM$("CompoundStatement1116",1117);
                            }
                            // JavaLine 96 <== SourceLine 1119
                            ((HegnaNRK$PBLK21)(CUR$.SL$)).intern_felt.Elt[k-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_felt.LB[0]].skriv$0().CPF();
                            TRACE_END_STM$("CompoundStatement1113",1119);
                        }
                    }
                    TRACE_END_STM$("CompoundStatement1104",1119);
                }
            }
            // JavaLine 104 <== SourceLine 1122
            new HegnaNRK$PBLK21$trykk_rapport$skriv_linje(((HegnaNRK$PBLK21$trykk_rapport)CUR$));
            // JavaLine 106 <== SourceLine 1123
            while((felt_linje<(inspect$1099$6.ark_lengde))) {
                new HegnaNRK$PBLK21$trykk_rapport$skriv_linje(((HegnaNRK$PBLK21$trykk_rapport)CUR$));
            }
            TRACE_END_STM$("CompoundStatement1101",1123);
        }
    }
    TRACE_END_STM$("trykk_rapport",1123);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure trykk_rapport",1,1091,12,1093,17,1099,52,1101,56,1102,60,1104,64,1105,66,1106,68,1108,72,1109,77,1111,79,1113,83,1114,86,1116,92,1117,96,1119,104,1122,106,1123,116,1125);
} // End of Procedure
