// JavaLine 1 ==> SourceLine 393
package simulaTestPrograms;
// Release-Beta-0.3 Compiled at Sat Jan 05 17:29:59 CET 2019
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
        if((p$kommandonr==(1))) {
            // JavaLine 43 ==> SourceLine 397
            new HegnaNRK$PBLK21$definer(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if((p$kommandonr==(2))) {
            // JavaLine 47 ==> SourceLine 398
            new HegnaNRK$PBLK21$registrer(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if((p$kommandonr==(3))) {
            // JavaLine 51 ==> SourceLine 399
            new HegnaNRK$PBLK21$finn(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if((p$kommandonr==(4))) {
            // JavaLine 55 ==> SourceLine 400
            new HegnaNRK$PBLK21$endre(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if((p$kommandonr==(5))) {
            // JavaLine 59 ==> SourceLine 401
            new HegnaNRK$PBLK21$trykk(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if((p$kommandonr==(6))) {
            // JavaLine 63 ==> SourceLine 402
            new HegnaNRK$PBLK21$fjern(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if((p$kommandonr==(7))) {
            // JavaLine 67 ==> SourceLine 403
            new HegnaNRK$PBLK21$hjelp(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if((p$kommandonr==(8))) {
            // JavaLine 71 ==> SourceLine 404
            new HegnaNRK$PBLK21$list(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if((p$kommandonr==(9))) {
            // JavaLine 75 ==> SourceLine 405
            new HegnaNRK$PBLK21$listdef(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if((p$kommandonr==(10))) {
            // JavaLine 79 ==> SourceLine 406
            new HegnaNRK$PBLK21$neste(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if((p$kommandonr==(11))) {
            // JavaLine 83 ==> SourceLine 407
            new HegnaNRK$PBLK21$hent(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if((p$kommandonr==(12))) {
            // JavaLine 87 ==> SourceLine 408
            new HegnaNRK$PBLK21$datareg(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if((p$kommandonr==(13))) {
            // JavaLine 91 ==> SourceLine 409
            new HegnaNRK$PBLK21$definer_format(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if((p$kommandonr==(14))) {
            // JavaLine 95 ==> SourceLine 410
            new HegnaNRK$PBLK21$rapporter(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if((p$kommandonr==(15))) {
            // JavaLine 99 ==> SourceLine 411
            new HegnaNRK$PBLK21$tainn(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if((p$kommandonr==(16))) {
            // JavaLine 103 ==> SourceLine 412
            new HegnaNRK$PBLK21$leggut(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if((p$kommandonr==(17))) {
            // JavaLine 107 ==> SourceLine 413
            new HegnaNRK$PBLK21$finnmengde(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if((p$kommandonr==(18))) {
            // JavaLine 111 ==> SourceLine 414
            new HegnaNRK$PBLK21$sortermengde(((HegnaNRK$PBLK21)(CUR$.SL$)));
        } else
        if((p$kommandonr==(19))) {
            new HegnaNRK$PBLK21$rapportermengde(((HegnaNRK$PBLK21)(CUR$.SL$)));
        }
        TRACE_END_STM$("do_kommando",414);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("HegnaNRK.sim","Procedure do_kommando",1,393,41,396,43,397,47,398,51,399,55,400,59,401,63,402,67,403,71,404,75,405,79,406,83,407,87,408,91,409,95,410,99,411,103,412,107,413,111,414,120,416);
}
