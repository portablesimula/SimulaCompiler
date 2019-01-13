// JavaLine 1 ==> SourceLine 349
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:24 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$readprocpar extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=349, lastLine=431, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    public char p$speckind;
    // Declare local labels
    // JavaLine 12 ==> SourceLine 409
    final LABQNT$ P3=new LABQNT$(this,0,1); // Local Label #1=P3
    // JavaLine 14 ==> SourceLine 410
    final LABQNT$ P2=new LABQNT$(this,0,2); // Local Label #2=P2
    // JavaLine 16 ==> SourceLine 396
    final LABQNT$ P1=new LABQNT$(this,0,3); // Local Label #3=P1
    // JavaLine 18 ==> SourceLine 404
    final LABQNT$ checksemic=new LABQNT$(this,0,4); // Local Label #4=checksemic
    // JavaLine 20 ==> SourceLine 406
    final LABQNT$ namevaluepart=new LABQNT$(this,0,5); // Local Label #5=namevaluepart
    // JavaLine 22 ==> SourceLine 421
    final LABQNT$ specification=new LABQNT$(this,0,6); // Local Label #6=specification
    // JavaLine 24 ==> SourceLine 428
    final LABQNT$ readprocparexit=new LABQNT$(this,0,7); // Local Label #7=readprocparexit
    // Declare locals as attributes
    // JavaLine 27 ==> SourceLine 352
    char opx=0;
    // JavaLine 29 ==> SourceLine 353
    boolean namefound=false;
    boolean valuefound=false;
    // Parameter Transmission in case of Formal/Virtual Procedure Call
    private int $npar=0; // Number of actual parameters transmitted.
    public PARSER$grammer$readprocpar setPar(Object param) {
        //Util.BREAK("CALL PARSER$grammer$readprocpar.setPar: param="+param+", qual="+param.getClass().getSimpleName()+", npar="+$npar+", staticLink="+SL$);
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
    public PARSER$grammer$readprocpar(RTObject$ SL$)
    { super(SL$); }
    // Normal Constructor
    public PARSER$grammer$readprocpar(RTObject$ SL$,char sp$speckind) {
        super(SL$);
        // Parameter assignment to locals
        this.p$speckind = sp$speckind;
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("readprocpar",387);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$readprocpar STM$() {
        TRACE_BEGIN_STM$("readprocpar",387);
        PARSER$grammer$readprocpar THIS$=(PARSER$grammer$readprocpar)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 65 ==> SourceLine 394
                new PARSER$grammer$readprocpar$setrecsymb(((PARSER$grammer$readprocpar)CUR$),true);
                // JavaLine 67 ==> SourceLine 395
                if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ILFPA))) {
                    // JavaLine 69 ==> SourceLine 396
                    {
                        TRACE_BEGIN_STM$("CompoundStatement396",396);
                        LABEL$(3); // P1
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        // JavaLine 74 ==> SourceLine 397
                        if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IIDN))) {
                            new PARSER$grammer$readprocpar$procparerror(((PARSER$grammer$readprocpar)CUR$),185);
                        }
                        // JavaLine 78 ==> SourceLine 398
                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IFRMP;
                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                        // JavaLine 81 ==> SourceLine 399
                        ((PARSER$grammer)(CUR$.SL$)).getopt=false;
                        ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).opt;
                        // JavaLine 84 ==> SourceLine 400
                        if((((PARSER)(CUR$.SL$.SL$)).option.Elt[rank('I')-((PARSER)(CUR$.SL$.SL$)).option.LB[0]]!=(((PARSER)(CUR$.SL$.SL$)).NUL))) {
                            new PARSER$grammer$lookforstring(((PARSER$grammer)(CUR$.SL$)));
                        }
                        // JavaLine 88 ==> SourceLine 401
                        if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ICOMA))) {
                            GOTO$(P1); // GOTO EVALUATED LABEL
                        }
                        // JavaLine 92 ==> SourceLine 402
                        if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IRGPA))) {
                            new PARSER$grammer$readprocpar$procparerror(((PARSER$grammer$readprocpar)CUR$),186);
                        }
                        // JavaLine 96 ==> SourceLine 403
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        // JavaLine 98 ==> SourceLine 405
                        LABEL$(4); // checksemic
                        // JavaLine 100 ==> SourceLine 404
                        if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).ISMCL))) {
                            // JavaLine 102 ==> SourceLine 405
                            new PARSER$grammer$ParsWarn(((PARSER$grammer)(CUR$.SL$)),300);
                        } else
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        // JavaLine 106 ==> SourceLine 415
                        LABEL$(5); // namevaluepart
                        // JavaLine 108 ==> SourceLine 406
                        if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IVALU))) {
                            // JavaLine 110 ==> SourceLine 407
                            {
                                TRACE_BEGIN_STM$("CompoundStatement407",407);
                                if(valuefound) {
                                    new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$)),196);
                                }
                                // JavaLine 116 ==> SourceLine 408
                                valuefound=true;
                                // JavaLine 118 ==> SourceLine 409
                                LABEL$(1); // P3
                                opx=((PARSER$grammer)(CUR$.SL$)).cs;
                                // JavaLine 121 ==> SourceLine 410
                                LABEL$(2); // P2
                                ((PARSER$grammer)(CUR$.SL$)).detach();
                                // JavaLine 124 ==> SourceLine 411
                                if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IIDN))) {
                                    new PARSER$grammer$readprocpar$procparerror(((PARSER$grammer$readprocpar)CUR$),185);
                                }
                                // JavaLine 128 ==> SourceLine 412
                                ((PARSER)(CUR$.SL$.SL$)).opn=opx;
                                call(((PARSER)(CUR$.SL$.SL$)).coder);
                                // JavaLine 131 ==> SourceLine 413
                                ((PARSER$grammer)(CUR$.SL$)).getopt=false;
                                ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).opt;
                                // JavaLine 134 ==> SourceLine 414
                                if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ICOMA))) {
                                    GOTO$(P2); // GOTO EVALUATED LABEL
                                }
                                GOTO$(checksemic); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement407",414);
                            }
                        }
                        // JavaLine 142 ==> SourceLine 416
                        if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).INAME))) {
                            // JavaLine 144 ==> SourceLine 417
                            {
                                TRACE_BEGIN_STM$("CompoundStatement417",417);
                                if((p$speckind==(((PARSER)(CUR$.SL$.SL$)).ICSPC))) {
                                    // JavaLine 148 ==> SourceLine 418
                                    new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$)),194);
                                } else
                                if(namefound) {
                                    new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$)),195);
                                }
                                // JavaLine 154 ==> SourceLine 419
                                namefound=true;
                                GOTO$(P3); // GOTO EVALUATED LABEL
                                TRACE_END_STM$("CompoundStatement417",419);
                            }
                        }
                        // JavaLine 160 ==> SourceLine 421
                        LABEL$(6); // specification
                        new PARSER$grammer$readspecification(((PARSER$grammer)(CUR$.SL$)),p$speckind);
                        // JavaLine 163 ==> SourceLine 422
                        if(((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).INAME))||((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IVALU))))) {
                            new PARSER$grammer$readprocpar$procparerror(((PARSER$grammer$readprocpar)CUR$),217);
                        }
                        TRACE_END_STM$("CompoundStatement396",422);
                    }
                } else
                // JavaLine 170 ==> SourceLine 424
                {
                    TRACE_BEGIN_STM$("CompoundStatement424",424);
                    if((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).ISMCL))) {
                        // JavaLine 174 ==> SourceLine 425
                        new PARSER$grammer$ParsWarn(((PARSER$grammer)(CUR$.SL$)),286);
                    } else
                    ((PARSER$grammer)(CUR$.SL$)).detach();
                    TRACE_END_STM$("CompoundStatement424",425);
                }
                // JavaLine 180 ==> SourceLine 429
                LABEL$(7); // readprocparexit
                // JavaLine 182 ==> SourceLine 428
                if(((PARSER$grammer)(CUR$.SL$)).specofvirtual) {
                } else
                // JavaLine 185 ==> SourceLine 429
                {
                    TRACE_BEGIN_STM$("CompoundStatement429",429);
                    ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IEPRM;
                    call(((PARSER)(CUR$.SL$.SL$)).coder);
                    TRACE_END_STM$("CompoundStatement429",429);
                }
                // JavaLine 192 ==> SourceLine 430
                new PARSER$grammer$readprocpar$setrecsymb(((PARSER$grammer$readprocpar)CUR$),false);
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
        TRACE_END_STM$("readprocpar",430);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure readprocpar",1,349,12,409,14,410,16,396,18,404,20,406,22,421,24,428,27,352,29,353,65,394,67,395,69,396,74,397,78,398,81,399,84,400,88,401,92,402,96,403,98,405,100,404,102,405,106,415,108,406,110,407,116,408,118,409,121,410,124,411,128,412,131,413,134,414,142,416,144,417,148,418,154,419,160,421,163,422,170,424,174,425,180,429,182,428,185,429,192,430,210,431);
}
