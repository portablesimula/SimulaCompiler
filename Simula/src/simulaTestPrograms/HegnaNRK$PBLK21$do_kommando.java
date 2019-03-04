// JavaLine 1 ==> SourceLine 393
package simulaTestPrograms;
// Simula-Beta-0.3 Compiled at Mon Mar 04 20:15:38 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class HegnaNRK$PBLK21$do_kommando extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=393, lastLine=416, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public int p$kommandonr;
    // Declare locals as attributes
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public HegnaNRK$PBLK21$do_kommando setPar(Object param) {
        //Util.BREAK("CALL HegnaNRK$PBLK21$do_kommando.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$kommandonr=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public HegnaNRK$PBLK21$do_kommando(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public HegnaNRK$PBLK21$do_kommando(RTObject$ SL$,int sp$kommandonr) {
        super(SL$);
        // Parameter assignment to locals
        this.p$kommandonr = sp$kommandonr;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("do_kommando",393);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public HegnaNRK$PBLK21$do_kommando STM$() {
        TRACE_BEGIN_STM$("do_kommando",393);
        // JavaLine 41 ==> SourceLine 396
        if(VALUE$((p$kommandonr==(1)))) {
            new HegnaNRK$PBLK21$definer(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        // JavaLine 45 ==> SourceLine 397
        if(VALUE$((p$kommandonr==(2)))) {
            new HegnaNRK$PBLK21$registrer(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        // JavaLine 49 ==> SourceLine 398
        if(VALUE$((p$kommandonr==(3)))) {
            new HegnaNRK$PBLK21$finn(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        // JavaLine 53 ==> SourceLine 399
        if(VALUE$((p$kommandonr==(4)))) {
            new HegnaNRK$PBLK21$endre(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        // JavaLine 57 ==> SourceLine 400
        if(VALUE$((p$kommandonr==(5)))) {
            new HegnaNRK$PBLK21$trykk(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        // JavaLine 61 ==> SourceLine 401
        if(VALUE$((p$kommandonr==(6)))) {
            new HegnaNRK$PBLK21$fjern(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        // JavaLine 65 ==> SourceLine 402
        if(VALUE$((p$kommandonr==(7)))) {
            new HegnaNRK$PBLK21$hjelp(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        // JavaLine 69 ==> SourceLine 403
        if(VALUE$((p$kommandonr==(8)))) {
            new HegnaNRK$PBLK21$list(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        // JavaLine 73 ==> SourceLine 404
        if(VALUE$((p$kommandonr==(9)))) {
            new HegnaNRK$PBLK21$listdef(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        // JavaLine 77 ==> SourceLine 405
        if(VALUE$((p$kommandonr==(10)))) {
            new HegnaNRK$PBLK21$neste(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        // JavaLine 81 ==> SourceLine 406
        if(VALUE$((p$kommandonr==(11)))) {
            new HegnaNRK$PBLK21$hent(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        // JavaLine 85 ==> SourceLine 407
        if(VALUE$((p$kommandonr==(12)))) {
            new HegnaNRK$PBLK21$datareg(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        // JavaLine 89 ==> SourceLine 408
        if(VALUE$((p$kommandonr==(13)))) {
            new HegnaNRK$PBLK21$definer_format(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        // JavaLine 93 ==> SourceLine 409
        if(VALUE$((p$kommandonr==(14)))) {
            new HegnaNRK$PBLK21$rapporter(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        // JavaLine 97 ==> SourceLine 410
        if(VALUE$((p$kommandonr==(15)))) {
            new HegnaNRK$PBLK21$tainn(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        // JavaLine 101 ==> SourceLine 411
        if(VALUE$((p$kommandonr==(16)))) {
            new HegnaNRK$PBLK21$leggut(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        // JavaLine 105 ==> SourceLine 412
        if(VALUE$((p$kommandonr==(17)))) {
            new HegnaNRK$PBLK21$finnmengde(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        // JavaLine 109 ==> SourceLine 413
        if(VALUE$((p$kommandonr==(18)))) {
            new HegnaNRK$PBLK21$sortermengde(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        // JavaLine 113 ==> SourceLine 414
        if(VALUE$((p$kommandonr==(19)))) {
            new HegnaNRK$PBLK21$rapportermengde(((HegnaNRK$PBLK21)(CUR$.SL$)));
        }
        TRACE_END_STM$("do_kommando",414);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure do_kommando",1,393,41,396,45,397,49,398,53,399,57,400,61,401,65,402,69,403,73,404,77,405,81,406,85,407,89,408,93,409,97,410,101,411,105,412,109,413,113,414,120,416);
}
