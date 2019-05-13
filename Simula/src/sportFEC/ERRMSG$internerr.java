package sportFEC;
// Simula-Beta-0.3 Compiled at Sat May 11 14:14:38 CEST 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class ERRMSG$internerr extends BASICIO$ {
    public int prefixLevel() { return(0); }
    public char p$module;
    public int p$lnr;
    TXT$ modname=null;
    PrintFile$ inspect$326$8=null;
    private int $npar=0; // Number of actual parameters transmitted.
    public ERRMSG$internerr setPar(Object param) {
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
    public ERRMSG$internerr(RTObject$ SL$)
    { super(SL$); }
    public ERRMSG$internerr(RTObject$ SL$,char sp$module,int sp$lnr) {
        super(SL$);
        this.p$module = sp$module;
        this.p$lnr = sp$lnr;
        BBLK();
        STM$();
    }
    public ERRMSG$internerr STM$() {
        if(VALUE$((((ERRMSG)(CUR$.SL$)).numerrfound==(0)))) {
            {
                inspect$326$8=sysout();
                if(inspect$326$8!=null)
                {
                    inspect$326$8.outimage();
                    switch(p$module) { // BEGIN SWITCH STATEMENT
                    case 0: 
                    modname=new TXT$("COMMON");
                    case 1: 
                    modname=new TXT$("ERRMSG");
                    case 2: 
                    modname=new TXT$("SCANNER");
                    case 3: 
                    modname=new TXT$("SCANINP");
                    case 4: 
                    modname=new TXT$("PARSER");
                    case 5: 
                    modname=new TXT$("PAS1INIT");
                    case 6: 
                    modname=new TXT$("BUILDER1");
                    case 7: 
                    modname=new TXT$("BUILDER2");
                    case 8: 
                    modname=new TXT$("CHECKER1");
                    case 9: 
                    modname=new TXT$("CHECKER2");
                    case 10: 
                    modname=new TXT$("SCODER0");
                    case 11: 
                    modname=new TXT$("SCODER1");
                    case 12: 
                    modname=new TXT$("SCODER1E");
                    case 13: 
                    modname=new TXT$("SCODER2");
                    case 14: 
                    modname=new TXT$("SCODER3");
                    case 15: 
                    modname=new TXT$("SCODER4");
                    case 16: 
                    modname=new TXT$("PAS2INIT");
                    case 17: 
                    modname=new TXT$("SCODMAIN");
                    case 18: 
                    modname=new TXT$("FECMAIN");
                } // END SWITCH STATEMENT
                modname=CONC(CONC(new TXT$("*** Internal error in "),modname),new TXT$(", line "));
                inspect$326$8.outtext(modname);
                inspect$326$8.outint(p$lnr,0);
                inspect$326$8.outtext(new TXT$(", compiling source line "));
                inspect$326$8.outint(((ERRMSG)(CUR$.SL$)).linenr,0);
                inspect$326$8.outimage();
            }
        }
    }
    new ERRMSG$AbortCompilation(((ERRMSG)(CUR$.SL$)));
    EBLK();
    return(this);
}
public static PROGINFO$ INFO$=new PROGINFO$("ERRMSG.DEF","Procedure internerr",1,323,10,325,12,326,40,327,43,328,46,329,49,330,52,331,55,332,58,333,61,334,64,335,67,336,70,337,73,338,76,339,79,340,82,341,85,342,88,343,91,344,94,345,97,346,100,347,103,349,105,350,108,351,111,352,116,354,120,355);
}
