// JavaLine 1 <== SourceLine 1377
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:49 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Pass1$SubBlock32$grammar$scan_expr extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=4, firstLine=1377, lastLine=1404, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public Common$expr RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public Common$expr p$x;
    // Declare local labels
    // JavaLine 14 <== SourceLine 1401
    final LABQNT$ EXT=new LABQNT$(this,1,"EXT"); // Local Label #1=EXT
    // Declare locals as attributes
    // JavaLine 17 <== SourceLine 1378
    int opr=0;
    int type=0;
    // JavaLine 20 <== SourceLine 1403
    PrintFile$ inspect$1402$98=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Pass1$SubBlock32$grammar$scan_expr setPar(Object param) {
        //Util.BREAK("CALL Pass1$SubBlock32$grammar$scan_expr.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 1: p$x=(Common$expr)objectValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Pass1$SubBlock32$grammar$scan_expr(RTObject$ SL$) {
        super(SL$,1); // Expecting 1 parameters
    }
    // Normal Constructor
    public Pass1$SubBlock32$grammar$scan_expr(RTObject$ SL$,Common$expr sp$x) {
        super(SL$);
        // Parameter assignment to locals
        this.p$x = sp$x;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Pass1$SubBlock32$grammar$scan_expr STM$() {
        Pass1$SubBlock32$grammar$scan_expr THIS$=(Pass1$SubBlock32$grammar$scan_expr)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 53 <== SourceLine 1380
                switch(((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol) { // BEGIN SWITCH STATEMENT
                case 98: 
                case 99: 
                case 100: 
                case 101: 
                case 102: 
                case 124: 
                case 121: 
                case 119: 
                case 123: 
                case 120: 
                case 122: 
                case 105: 
                case 106: 
                case 104: 
                case 2: 
                case 5: 
                case 66: 
                case 129: 
                // JavaLine 73 <== SourceLine 1386
                opr=((Pass1$SubBlock32)(CUR$.SL$.SL$)).symbol;
                break;
                case 175: 
                // JavaLine 77 <== SourceLine 1389
                {
                    ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
                    ;
                    type=new Pass1$SubBlock32$grammar$intype(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$;
                    ;
                    // JavaLine 83 <== SourceLine 1390
                    if(VALUE$((type==(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62.T_NULL$1)))) {
                        new Common$ERROR(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("Illegal syntax after qua"));
                    }
                    ;
                    // JavaLine 88 <== SourceLine 1391
                    p$x=new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Common$quaopr(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,p$x,type).STM$()).RESULT$;
                    ;
                    GOTO$(EXT); // GOTO EVALUATED LABEL
                    ;
                }
                break;
                default:
                // JavaLine 96 <== SourceLine 1395
                {
                    if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).tracemode>(0)))) {
                        new Common$WARNING(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,new TXT$("NONE in getprim"));
                    }
                    ;
                    // JavaLine 102 <== SourceLine 1396
                    GOTO$(EXT); // GOTO EVALUATED LABEL
                    ;
                }
                break;
            } // END SWITCH STATEMENT
            ;
            // JavaLine 109 <== SourceLine 1399
            ((Pass1$SubBlock32$grammar)(CUR$.SL$)).detach();
            ;
            // JavaLine 112 <== SourceLine 1400
            p$x=new Pass1$SubBlock32$grammar$scan_expr(((Pass1$SubBlock32$grammar)(CUR$.SL$)),new Common$binopr(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,opr,p$x,new Pass1$SubBlock32$grammar$getprim(((Pass1$SubBlock32$grammar)(CUR$.SL$))).RESULT$).STM$()).RESULT$;
            ;
            // JavaLine 115 <== SourceLine 1401
            LABEL$(1,"EXT");
            RESULT$=p$x;
            ;
            // JavaLine 119 <== SourceLine 1402
            if(VALUE$((((Pass1$SubBlock32)(CUR$.SL$.SL$)).tracemode>(2)))) {
                {
                    // BEGIN INSPECTION 
                    inspect$1402$98=sysout();
                    if(inspect$1402$98!=null) // INSPECT inspect$1402$98
                    // JavaLine 125 <== SourceLine 1403
                    {
                        inspect$1402$98.outtext(new TXT$("Expr: "));
                        ;
                        new Common$prt(((Pass1)(CUR$.SL$.SL$.SL$)).inspect$28$62,p$x,10);
                        ;
                        inspect$1402$98.outimage();
                    }
                }
            }
            ;
            break LOOP$;
        }
        catch(LABQNT$ q) {
            CUR$=THIS$;
            if(q.SL$!=CUR$) {
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("scan_expr:NON-LOCAL",q);
                CUR$.STATE$=OperationalState.terminated;
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("scan_expr:RE-THROW",q);
                throw(q);
            }
            if(RT.Option.GOTO_TRACING) TRACE_GOTO("scan_expr:LOCAL",q);
            JTX$=q.index; continue LOOP$; // EG. GOTO Lx
        }
    }
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("PASS1.sim","Procedure scan_expr",1,1377,14,1401,17,1378,20,1403,53,1380,73,1386,77,1389,83,1390,88,1391,96,1395,102,1396,109,1399,112,1400,115,1401,119,1402,125,1403,152,1404);
} // End of Procedure
