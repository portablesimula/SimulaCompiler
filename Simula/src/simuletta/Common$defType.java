// JavaLine 1 <== SourceLine 465
package simuletta;
// Simula-1.0 Compiled at Mon Apr 13 09:56:42 CEST 2020
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class Common$defType extends PROC$ {
    // ProcedureDeclaration: Kind=Procedure, BlockLevel=2, firstLine=465, lastLine=477, hasLocalClasses=false, System=false
    // Declare return value as attribute
    public int RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    public Common$TypeSet p$set;
    public int p$q;
    public int p$inf1;
    public int p$inf2;
    // Declare local labels
    // JavaLine 17 <== SourceLine 477
    final LABQNT$ E=new LABQNT$(this,1,"E"); // Local Label #1=E
    // Declare locals as attributes
    // JavaLine 20 <== SourceLine 467
    Common$TypeNotice x=null;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    public Common$defType setPar(Object param) {
        //Util.BREAK("CALL Common$defType.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$nParLeft+", staticLink="+SL$);
        try {
            switch($nParLeft--) {
                case 4: p$set=(Common$TypeSet)objectValue(param); break;
                case 3: p$q=intValue(param); break;
                case 2: p$inf1=intValue(param); break;
                case 1: p$inf2=intValue(param); break;
                default: throw new RuntimeException("Too many parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public Common$defType(RTObject$ SL$) {
        super(SL$,4); // Expecting 4 parameters
    }
    // Normal Constructor
    public Common$defType(RTObject$ SL$,Common$TypeSet sp$set,int sp$q,int sp$inf1,int sp$inf2) {
        super(SL$);
        // Parameter assignment to locals
        this.p$set = sp$set;
        this.p$q = sp$q;
        this.p$inf1 = sp$inf1;
        this.p$inf2 = sp$inf2;
        BBLK();
        // Declaration Code
        STM$();
    }
    // Procedure Statements
    public Common$defType STM$() {
        Common$defType THIS$=(Common$defType)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 59 <== SourceLine 468
                new Common$TRACE(((Common)(CUR$.SL$)),new TXT$("COMMON.defType"),468,CONC(CONC(CONC(new TXT$("BEGIN: set="),new Common$edTypeSet(((Common)(CUR$.SL$)),p$set).RESULT$),new TXT$(", q=")),new Common$edSymbol(((Common)(CUR$.SL$)),p$q).RESULT$));
                ;
                // JavaLine 62 <== SourceLine 469
                x=((Common$TypeNotice)(p$set.first()));
                ;
                // JavaLine 65 <== SourceLine 470
                while((x!=(null))) {
                    // JavaLine 67 <== SourceLine 471
                    {
                        if(VALUE$((x.p2$qual==(p$q)))) {
                            // JavaLine 70 <== SourceLine 472
                            {
                                if(VALUE$((x.p2$info1==(p$inf1)))) {
                                    {
                                        if(VALUE$((x.p2$info2==(p$inf2)))) {
                                            // JavaLine 75 <== SourceLine 473
                                            {
                                                RESULT$=x.code$2;
                                                ;
                                                GOTO$(E); // GOTO EVALUATED LABEL
                                            }
                                        }
                                        ;
                                    }
                                }
                            }
                        }
                        ;
                        // JavaLine 88 <== SourceLine 474
                        x=((Common$TypeNotice)(x.suc()));
                        ;
                    }
                }
                ;
                // JavaLine 94 <== SourceLine 476
                RESULT$=new Common$TypeNotice(((Common)(CUR$.SL$)),p$set,p$q,p$inf1,p$inf2).STM$().code$2;
                ;
                // JavaLine 97 <== SourceLine 477
                LABEL$(1,"E");
                ;
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$) {
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("defType:NON-LOCAL",q);
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("defType:RE-THROW",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("defType:LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.sim","Procedure defType",1,465,17,477,20,467,59,468,62,469,65,470,67,471,70,472,75,473,88,474,94,476,97,477,116,477);
} // End of Procedure
