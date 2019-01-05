// JavaLine 1 ==> SourceLine 505
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:59 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$readspecification extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=505, lastLine=560, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$speckind;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 522
    final LABQNT$ spes=new LABQNT$(this,0,1); // Local Label #1=spes
    // JavaLine 14 ==> SourceLine 538
    final LABQNT$ P2=new LABQNT$(this,0,2); // Local Label #2=P2
    // JavaLine 16 ==> SourceLine 539
    final LABQNT$ P3=new LABQNT$(this,0,3); // Local Label #3=P3
    // JavaLine 18 ==> SourceLine 540
    final LABQNT$ P4=new LABQNT$(this,0,4); // Local Label #4=P4
    // JavaLine 20 ==> SourceLine 554
    final LABQNT$ P5=new LABQNT$(this,0,5); // Local Label #5=P5
    // JavaLine 22 ==> SourceLine 559
    final LABQNT$ readspecificationexit=new LABQNT$(this,0,6); // Local Label #6=readspecificationexit
    // Declare locals as attributes
    // JavaLine 25 ==> SourceLine 506
    char opnx=0;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public PARSER$grammer$readspecification setPar(Object param) {
        //Util.BREAK("CALL PARSER$grammer$readspecification.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
        try {
            switch($npar++) {
                case 0: p$speckind=(char)objectValue(param); break;
                default: throw new RuntimeException("Wrong number of parameters");
            }
        }
        catch(ClassCastException e) { throw new RuntimeException("Wrong type of parameter: "+$npar+" "+param,e);}
        return(this);
    }
    // Constructor in case of Formal/Virtual Procedure Call
    public PARSER$grammer$readspecification(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public PARSER$grammer$readspecification(RTObject$ SL$,char sp$speckind) {
        super(SL$);
        // Parameter assignment to locals
        this.p$speckind = sp$speckind;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("readspecification",517);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$readspecification STM$() {
        TRACE_BEGIN_STM$("readspecification",517);
        PARSER$grammer$readspecification THIS$=(PARSER$grammer$readspecification)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 60 ==> SourceLine 521
                ((PARSER$grammer)(CUR$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$)).ICOMA)-((PARSER$grammer)(CUR$.SL$)).recoversymbol.LB[0]]=true;
                // JavaLine 62 ==> SourceLine 553
                LABEL$(1); // spes
                // JavaLine 64 ==> SourceLine 522
                while(true) {
                    // JavaLine 66 ==> SourceLine 523
                    {
                        TRACE_BEGIN_STM$("CompoundStatement523",523);
                        new PARSER$grammer$readtypespec(((PARSER$grammer)(CUR$.SL$)));
                        opnx=((PARSER)(CUR$.SL$.SL$)).NUL;
                        // JavaLine 71 ==> SourceLine 532
                        if((((PARSER$grammer)(CUR$.SL$)).readtype==(((PARSER)(CUR$.SL$.SL$)).NUL))) {
                            // JavaLine 73 ==> SourceLine 533
                            {
                                TRACE_BEGIN_STM$("CompoundStatement533",533);
                                if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IPROC))) {
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement533",533);
                                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).INOTY;
                                        // JavaLine 80 ==> SourceLine 534
                                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                                        TRACE_END_STM$("CompoundStatement533",534);
                                    }
                                } else
                                if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IARRA))) {
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement534",534);
                                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IREAL;
                                        // JavaLine 89 ==> SourceLine 535
                                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                                        TRACE_END_STM$("CompoundStatement534",535);
                                    }
                                } else
                                if(((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).ILABE))&&((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).ISWIT))))) {
                                    GOTO$(P5); // GOTO EVALUATED LABEL
                                }
                                TRACE_END_STM$("CompoundStatement533",535);
                            }
                        } else
                        // JavaLine 100 ==> SourceLine 536
                        if(((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IPROC))&&((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IARRA))))) {
                            GOTO$(P4); // GOTO EVALUATED LABEL
                        }
                        // JavaLine 104 ==> SourceLine 538
                        LABEL$(2); // P2
                        opnx=((PARSER)(CUR$.SL$.SL$)).opn=((PARSER$grammer)(CUR$.SL$)).cs;
                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                        // JavaLine 108 ==> SourceLine 539
                        LABEL$(3); // P3
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        // JavaLine 111 ==> SourceLine 540
                        LABEL$(4); // P4
                        if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IIDN))) {
                            new PARSER$grammer$readspecification$specificationerror(((PARSER$grammer$readspecification)CUR$),185);
                        }
                        // JavaLine 116 ==> SourceLine 541
                        ((PARSER)(CUR$.SL$.SL$)).opn=p$speckind;
                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                        // JavaLine 119 ==> SourceLine 542
                        if((((PARSER)(CUR$.SL$.SL$)).opt==(((PARSER)(CUR$.SL$.SL$)).ICOMA))) {
                            GOTO$(P3); // GOTO EVALUATED LABEL
                        }
                        // JavaLine 123 ==> SourceLine 543
                        ((PARSER$grammer)(CUR$.SL$)).getopt=false;
                        ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).opt;
                        // JavaLine 126 ==> SourceLine 544
                        if((((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IIS))&&((opnx==(((PARSER)(CUR$.SL$.SL$)).IPROC))))&&((p$speckind==(((PARSER)(CUR$.SL$.SL$)).IVSPC))))) {
                            // JavaLine 128 ==> SourceLine 546
                            {
                                TRACE_BEGIN_STM$("CompoundStatement546",546);
                                ((PARSER$grammer)(CUR$.SL$)).specofvirtual=true;
                                // JavaLine 132 ==> SourceLine 547
                                if((!(new PARSER$grammer$extbinding(((PARSER$grammer)(CUR$.SL$))).RESULT$))) {
                                    new PARSER$grammer$readspecification$specificationerror(((PARSER$grammer$readspecification)CUR$),214);
                                }
                                // JavaLine 136 ==> SourceLine 548
                                ((PARSER$grammer)(CUR$.SL$)).specofvirtual=false;
                                // JavaLine 138 ==> SourceLine 549
                                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IEREC;
                                call(((PARSER)(CUR$.SL$.SL$)).coder);
                                TRACE_END_STM$("CompoundStatement546",549);
                            }
                        }
                        // JavaLine 144 ==> SourceLine 551
                        if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).ISMCL))) {
                            // JavaLine 146 ==> SourceLine 552
                            new PARSER$grammer$ParsWarn(((PARSER$grammer)(CUR$.SL$)),300);
                        } else
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        TRACE_END_STM$("CompoundStatement523",552);
                    }
                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                }
                // JavaLine 154 ==> SourceLine 557
                LABEL$(5); // P5
                // JavaLine 156 ==> SourceLine 554
                if((((p$speckind==(((PARSER)(CUR$.SL$.SL$)).IVSPC))&&((opnx==(((PARSER)(CUR$.SL$.SL$)).NUL))))&&((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IIDN))))) {
                    // JavaLine 158 ==> SourceLine 556
                    {
                        TRACE_BEGIN_STM$("CompoundStatement556",556);
                        new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$)),184);
                        ((PARSER)(CUR$.SL$.SL$)).opn=opnx=((PARSER)(CUR$.SL$.SL$)).IPROC;
                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                        // JavaLine 164 ==> SourceLine 557
                        GOTO$(P4); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement556",557);
                    }
                }
                // JavaLine 169 ==> SourceLine 559
                LABEL$(6); // readspecificationexit
                ((PARSER$grammer)(CUR$.SL$)).recoversymbol.Elt[rank(((PARSER)(CUR$.SL$.SL$)).ICOMA)-((PARSER$grammer)(CUR$.SL$)).recoversymbol.LB[0]]=false;
                ((PARSER$grammer)(CUR$.SL$)).readtype=((PARSER)(CUR$.SL$.SL$)).NUL;
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
        TRACE_END_STM$("readspecification",559);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure readspecification",1,505,12,522,14,538,16,539,18,540,20,554,22,559,25,506,60,521,62,553,64,522,66,523,71,532,73,533,80,534,89,535,100,536,104,538,108,539,111,540,116,541,119,542,123,543,126,544,128,546,132,547,136,548,138,549,144,551,146,552,154,557,156,554,158,556,164,557,169,559,189,560);
}
