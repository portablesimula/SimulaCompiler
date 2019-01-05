// JavaLine 1 ==> SourceLine 323
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:51 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$internerr extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=323, lastLine=355, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$module;
    public int p$lnr;
    // Declare locals as attributes
    // JavaLine 13 ==> SourceLine 325
    TXT$ modname=null;
    // JavaLine 15 ==> SourceLine 326
    PrintFile$ inspect$326$8=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$internerr setPar(Object param) {
        //Util.BREAK("CALL ERRMSG$internerr.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$module=(char)objectValue(param); break;
                case 1: p$lnr=intValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public ERRMSG$internerr(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public ERRMSG$internerr(RTObject$ SL$,char sp$module,int sp$lnr) {
        super(SL$);
        // Parameter assignment to locals
        this.p$module = sp$module;
        this.p$lnr = sp$lnr;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("internerr",326);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public ERRMSG$internerr STM$() {
        TRACE_BEGIN_STM$("internerr",326);
        if((((ERRMSG)(CUR$.SL$)).numerrfound==(0))) {
            {
                // BEGIN INSPECTION 
                inspect$326$8=sysout();
                if(inspect$326$8!=null) //INSPECT inspect$326$8
                // JavaLine 53 ==> SourceLine 327
                {
                    TRACE_BEGIN_STM$("CompoundStatement327",327);
                    inspect$326$8.outimage();
                    // JavaLine 57 ==> SourceLine 328
                    switch(p$module) { // BEGIN SWITCH STATEMENT
                    case 0: 
                    // JavaLine 60 ==> SourceLine 329
                    modname=new TXT$("COMMON");
                    case 1: 
                    // JavaLine 63 ==> SourceLine 330
                    modname=new TXT$("ERRMSG");
                    case 2: 
                    // JavaLine 66 ==> SourceLine 331
                    modname=new TXT$("SCANNER");
                    case 3: 
                    // JavaLine 69 ==> SourceLine 332
                    modname=new TXT$("SCANINP");
                    case 4: 
                    // JavaLine 72 ==> SourceLine 333
                    modname=new TXT$("PARSER");
                    case 5: 
                    // JavaLine 75 ==> SourceLine 334
                    modname=new TXT$("PAS1INIT");
                    case 6: 
                    // JavaLine 78 ==> SourceLine 335
                    modname=new TXT$("BUILDER1");
                    case 7: 
                    // JavaLine 81 ==> SourceLine 336
                    modname=new TXT$("BUILDER2");
                    case 8: 
                    // JavaLine 84 ==> SourceLine 337
                    modname=new TXT$("CHECKER1");
                    case 9: 
                    // JavaLine 87 ==> SourceLine 338
                    modname=new TXT$("CHECKER2");
                    case 10: 
                    // JavaLine 90 ==> SourceLine 339
                    modname=new TXT$("SCODER0");
                    case 11: 
                    // JavaLine 93 ==> SourceLine 340
                    modname=new TXT$("SCODER1");
                    case 12: 
                    // JavaLine 96 ==> SourceLine 341
                    modname=new TXT$("SCODER1E");
                    case 13: 
                    // JavaLine 99 ==> SourceLine 342
                    modname=new TXT$("SCODER2");
                    case 14: 
                    // JavaLine 102 ==> SourceLine 343
                    modname=new TXT$("SCODER3");
                    case 15: 
                    // JavaLine 105 ==> SourceLine 344
                    modname=new TXT$("SCODER4");
                    case 16: 
                    // JavaLine 108 ==> SourceLine 345
                    modname=new TXT$("PAS2INIT");
                    case 17: 
                    // JavaLine 111 ==> SourceLine 346
                    modname=new TXT$("SCODMAIN");
                    case 18: 
                    // JavaLine 114 ==> SourceLine 347
                    modname=new TXT$("FECMAIN");
                } // END SWITCH STATEMENT
                // JavaLine 117 ==> SourceLine 349
                modname=CONC(CONC(new TXT$("*** Internal error in "),modname),new TXT$(", line "));
                // JavaLine 119 ==> SourceLine 350
                inspect$326$8.outtext(modname);
                inspect$326$8.outint(p$lnr,0);
                // JavaLine 122 ==> SourceLine 351
                inspect$326$8.outtext(new TXT$(", compiling source line "));
                inspect$326$8.outint(((ERRMSG)(CUR$.SL$)).linenr,0);
                // JavaLine 125 ==> SourceLine 352
                inspect$326$8.outimage();
                TRACE_END_STM$("CompoundStatement327",352);
            }
        }
    }
    // JavaLine 131 ==> SourceLine 354
    new ERRMSG$AbortCompilation(((ERRMSG)(CUR$.SL$)));
    TRACE_END_STM$("internerr",354);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure internerr",1,323,13,325,15,326,53,327,57,328,60,329,63,330,66,331,69,332,72,333,75,334,78,335,81,336,84,337,87,338,90,339,93,340,96,341,99,342,102,343,105,344,108,345,111,346,114,347,117,349,119,350,122,351,125,352,131,354,136,355);
}
