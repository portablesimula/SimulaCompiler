// JavaLine 1 ==> SourceLine 262
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:26 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER1$precheck0$getClass extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=262, lastLine=302, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public COMMON$quantity RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public COMMON$quantity p$qty;
    public char p$foundblev;
    // Declare local labels
    // JavaLine 16 ==> SourceLine 282
    final LABQNT$ LOOP=new LABQNT$(this,0,1); // Local Label #1=LOOP
    // JavaLine 18 ==> SourceLine 298
    final LABQNT$ nextbl=new LABQNT$(this,0,2); // Local Label #2=nextbl
    // Declare locals as attributes
    // JavaLine 21 ==> SourceLine 267
    COMMON$quantity cqt=null;
    // JavaLine 23 ==> SourceLine 268
    char bl=0;
    // JavaLine 25 ==> SourceLine 275
    COMMON$brecord inspect$275$5=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public BUILDER1$precheck0$getClass setPar(Object param) {
        //Util.BREAK("CALL BUILDER1$precheck0$getClass.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$qty=(COMMON$quantity)objectValue(param); break;
                case 1: p$foundblev=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public BUILDER1$precheck0$getClass(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public BUILDER1$precheck0$getClass(RTObject$ SL$,COMMON$quantity sp$qty,char sp$foundblev) {
        super(SL$);
        // Parameter assignment to locals
        this.p$qty = sp$qty;
        this.p$foundblev = sp$foundblev;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("getClass",275);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER1$precheck0$getClass STM$() {
        TRACE_BEGIN_STM$("getClass",275);
        BUILDER1$precheck0$getClass THIS$=(BUILDER1$precheck0$getClass)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 62 ==> SourceLine 272
                bl=((BUILDER1)(CUR$.SL$.SL$)).cblev;
                // JavaLine 64 ==> SourceLine 273
                while((bl>=(p$foundblev))) {
                    // JavaLine 66 ==> SourceLine 275
                    {
                        TRACE_BEGIN_STM$("CompoundStatement275",275);
                        {
                            // BEGIN INSPECTION 
                            inspect$275$5=((BUILDER1)(CUR$.SL$.SL$)).display.Elt[rank(bl)-((BUILDER1)(CUR$.SL$.SL$)).display.LB[0]];
                            if(inspect$275$5!=null) //INSPECT inspect$275$5
                            // JavaLine 73 ==> SourceLine 276
                            {
                                TRACE_BEGIN_STM$("CompoundStatement276",276);
                                if((inspect$275$5.kind==(((BUILDER1)(CUR$.SL$.SL$)).K_proc))) {
                                } else
                                if((inspect$275$5.kind==(((BUILDER1)(CUR$.SL$.SL$)).K_subbl))) {
                                } else
                                // JavaLine 80 ==> SourceLine 279
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement279",279);
                                    cqt=inspect$275$5.declquant;
                                    // JavaLine 84 ==> SourceLine 286
                                    LABEL$(1); // LOOP
                                    // JavaLine 86 ==> SourceLine 282
                                    if((cqt.symb!=(p$qty.symb))) {
                                        // JavaLine 88 ==> SourceLine 283
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement283",283);
                                            if((cqt.plev>(((BUILDER1)(CUR$.SL$.SL$)).one))) {
                                                // JavaLine 92 ==> SourceLine 284
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement284",284);
                                                    cqt=cqt.prefqual;
                                                    GOTO$(LOOP); // GOTO EVALUATED LABEL
                                                    TRACE_END_STM$("CompoundStatement284",284);
                                                }
                                            }
                                            // JavaLine 100 ==> SourceLine 285
                                            GOTO$(nextbl); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement283",285);
                                        }
                                    }
                                    // JavaLine 105 ==> SourceLine 287
                                    RESULT$=cqt;
                                    // JavaLine 107 ==> SourceLine 295
                                    ((BUILDER1$precheck0)(CUR$.SL$)).enclLevel=inspect$275$5.rtblev;
                                    // JavaLine 109 ==> SourceLine 296
                                    bl=p$foundblev;
                                    TRACE_END_STM$("CompoundStatement279",296);
                                }
                                // JavaLine 113 ==> SourceLine 298
                                LABEL$(2); // nextbl
                                TRACE_END_STM$("CompoundStatement276",298);
                            }
                        }
                        // JavaLine 118 ==> SourceLine 299
                        bl=char$((rank(bl)-(1)));
                        TRACE_END_STM$("CompoundStatement275",299);
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
        TRACE_END_STM$("getClass",299);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER1.DEF","Procedure getClass",1,262,16,282,18,298,21,267,23,268,25,275,62,272,64,273,66,275,73,276,80,279,84,286,86,282,88,283,92,284,100,285,105,287,107,295,109,296,113,298,118,299,139,302);
}
