// JavaLine 1 ==> SourceLine 1091
package simulaTestPrograms;
// Release-Beta-0.3 Compiled at Sat Jan 05 17:29:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$trykk_rapport extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=1091, lastLine=1125, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$formatnr;
    // Declare locals as attributes
    // JavaLine 12 ==> SourceLine 1093
    int i=0;
    int k=0;
    int felt_linje=0;
    boolean funnet=false;
    // JavaLine 17 ==> SourceLine 1100
    HegnaNRK$PBLK21$format inspect$1099$5=null;
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
        TRACE_BEGIN_DCL$("trykk_rapport",1100);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$trykk_rapport STM$() {
        TRACE_BEGIN_STM$("trykk_rapport",1100);
        // JavaLine 48 ==> SourceLine 1099
        {
            // BEGIN INSPECTION 
            inspect$1099$5=((HegnaNRK$PBLK21)(CUR$.SL$)).format_peker.Elt[p$formatnr-((HegnaNRK$PBLK21)(CUR$.SL$)).format_peker.LB[0]];
            if(inspect$1099$5!=null) //INSPECT inspect$1099$5
            // JavaLine 53 ==> SourceLine 1101
            {
                TRACE_BEGIN_STM$("CompoundStatement1101",1101);
                felt_linje=0;
                // JavaLine 57 ==> SourceLine 1102
                for(boolean CB$1102:new ForList(
                    new StepUntil(new NAME$<Number>(){ public Number put(Number x$){i=(int)x$; return(x$);};  public Number get(){return((Number)i); }	},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(1); }},new NAME$<Number>() { public Number get(){return(inspect$1099$5.p$antall); }})
                   )) { if(!CB$1102) continue;
                // JavaLine 61 ==> SourceLine 1104
                {
                    TRACE_BEGIN_STM$("CompoundStatement1104",1104);
                    k=0;
                    // JavaLine 65 ==> SourceLine 1105
                    funnet=false;
                    // JavaLine 67 ==> SourceLine 1106
                    while(((!(funnet))&((k<(((HegnaNRK$PBLK21)(CUR$.SL$)).felt_antall))))) {
                        // JavaLine 69 ==> SourceLine 1108
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1108",1108);
                            k=(k+(1));
                            // JavaLine 73 ==> SourceLine 1109
                            funnet=(inspect$1099$5.fnr.Elt[i-inspect$1099$5.fnr.LB[0]]==(((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.Elt[k-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_feltnr.LB[0]]));
                            TRACE_END_STM$("CompoundStatement1108",1109);
                        }
                    }
                    // JavaLine 78 ==> SourceLine 1111
                    if(funnet) {
                        // JavaLine 80 ==> SourceLine 1113
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1113",1113);
                            if((inspect$1099$5.spos.Elt[i-inspect$1099$5.spos.LB[0]]==(0))) {
                                // JavaLine 84 ==> SourceLine 1115
                                sysout().outchar(((char)32));
                            } else
                            // JavaLine 87 ==> SourceLine 1116
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1116",1116);
                                if((inspect$1099$5.spos.Elt[i-inspect$1099$5.spos.LB[0]]<(TXT$.pos(sysout().image)))) {
                                    new HegnaNRK$PBLK21$trykk_rapport$skriv_linje(((HegnaNRK$PBLK21$trykk_rapport)CUR$));
                                }
                                // JavaLine 93 ==> SourceLine 1117
                                TXT$.setpos(sysout().image,inspect$1099$5.spos.Elt[i-inspect$1099$5.spos.LB[0]]);
                                TRACE_END_STM$("CompoundStatement1116",1117);
                            }
                            // JavaLine 97 ==> SourceLine 1119
                            ((HegnaNRK$PBLK21)(CUR$.SL$)).intern_felt.Elt[k-((HegnaNRK$PBLK21)(CUR$.SL$)).intern_felt.LB[0]].skriv$0().CPF();
                            TRACE_END_STM$("CompoundStatement1113",1119);
                        }
                    }
                    TRACE_END_STM$("CompoundStatement1104",1119);
                }
            }
            // JavaLine 105 ==> SourceLine 1122
            new HegnaNRK$PBLK21$trykk_rapport$skriv_linje(((HegnaNRK$PBLK21$trykk_rapport)CUR$));
            // JavaLine 107 ==> SourceLine 1123
            while((felt_linje<(inspect$1099$5.ark_lengde))) {
                new HegnaNRK$PBLK21$trykk_rapport$skriv_linje(((HegnaNRK$PBLK21$trykk_rapport)CUR$));
            }
            TRACE_END_STM$("CompoundStatement1101",1123);
        }
    }
    TRACE_END_STM$("trykk_rapport",1123);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure trykk_rapport",1,1091,12,1093,17,1100,48,1099,53,1101,57,1102,61,1104,65,1105,67,1106,69,1108,73,1109,78,1111,80,1113,84,1115,87,1116,93,1117,97,1119,105,1122,107,1123,117,1125);
}
