// JavaLine 1 ==> SourceLine 433
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:21 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SCANNER$SourceElt extends SCANNER$input {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=1, firstLine=433, lastLine=500, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    public TXT$ p1$fname;
    // Declare local labels
    // JavaLine 13 ==> SourceLine 467
    final LABQNT$ INRL=new LABQNT$(this,1,1); // Local Label #1=INRL
    // JavaLine 15 ==> SourceLine 465
    final LABQNT$ NEXTIMAGE=new LABQNT$(this,1,2); // Local Label #2=NEXTIMAGE
    // JavaLine 17 ==> SourceLine 498
    final LABQNT$ EXIT=new LABQNT$(this,1,3); // Local Label #3=EXIT
    // Declare locals as attributes
    // JavaLine 20 ==> SourceLine 436
    public InFile$ sf=null;
    // JavaLine 22 ==> SourceLine 437
    public TXT$ newim=null;
    // JavaLine 24 ==> SourceLine 438
    public SCANNER$input inpt=null;
    // JavaLine 26 ==> SourceLine 445
    public SCANNER$recognizer inspect$445$11=null;
    // JavaLine 28 ==> SourceLine 489
    public PrintFile$ inspect$489$12=null;
    public PRCQNT$ close$0() { return(new PRCQNT$(this,SCANNER$SourceElt$close.class)); }
    // Normal Constructor
    public SCANNER$SourceElt(RTObject$ staticLink,boolean sp$inserted,TXT$ sp1$fname) {
        super(staticLink,sp$inserted);
        // Parameter assignment to locals
        this.p1$fname = sp1$fname;
        // Declaration Code
        TRACE_BEGIN_DCL$("SourceElt",489);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("SourceElt",489,inner);
                SCANNER$SourceElt THIS$=(SCANNER$SourceElt)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 46 ==> SourceLine 445
                        {
                            // BEGIN INSPECTION 
                            inspect$445$11=((SCANNER)(CUR$.SL$)).lexScanner;
                            if(inspect$445$11!=null) //INSPECT inspect$445$11
                            // JavaLine 51 ==> SourceLine 447
                            {
                                TRACE_BEGIN_STM$("CompoundStatement447",447);
                                inspect$445$11.atom=((SCANNER)(CUR$.SL$)).EOL;
                                inspect$445$11.linepos=inspect$445$11.linelength;
                                TRACE_END_STM$("CompoundStatement447",447);
                            }
                        }
                        // JavaLine 59 ==> SourceLine 448
                        new SCANNER$input$saveScannerState(((SCANNER$SourceElt)CUR$));
                        // JavaLine 61 ==> SourceLine 449
                        ((SCANNER)(CUR$.SL$)).lexScanner.line=((SCANNER)(CUR$.SL$)).line=blanks(81);
                        // JavaLine 63 ==> SourceLine 450
                        if(TXTREL$NE(lowcase(copy(copy(p1$fname))),new TXT$("sysin"))) {
                            // JavaLine 65 ==> SourceLine 451
                            {
                                TRACE_BEGIN_STM$("CompoundStatement451",451);
                                inpt=prev;
                                // JavaLine 69 ==> SourceLine 452
                                while((inpt!=(null))) {
                                    // JavaLine 71 ==> SourceLine 453
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement453",453);
                                        if((IS$(inpt,SCANNER$SourceElt.class)&&(TXTREL$EQ(((SCANNER$SourceElt)(inpt)).p1$fname,p1$fname)))) {
                                            // JavaLine 75 ==> SourceLine 455
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement455",455);
                                                ((SCANNER)(CUR$.SL$)).diag.Elt[0-((SCANNER)(CUR$.SL$)).diag.LB[0]]=p1$fname;
                                                new ERRMSG$fatal0(((SCANNER)(CUR$.SL$)),237);
                                                TRACE_END_STM$("CompoundStatement455",455);
                                            }
                                        }
                                        // JavaLine 83 ==> SourceLine 456
                                        inpt=inpt.prev;
                                        TRACE_END_STM$("CompoundStatement453",456);
                                    }
                                }
                                // JavaLine 88 ==> SourceLine 458
                                sf=new InFile$(((BASICIO$)CTX$),p1$fname).STM$();
                                sf.image=TXT$.sub(((SCANNER)(CUR$.SL$)).line,1,80);
                                // JavaLine 91 ==> SourceLine 459
                                if((!(sf.open(sf.image)))) {
                                    new ERRMSG$openerror(((SCANNER)(CUR$.SL$)),p1$fname);
                                }
                                TRACE_END_STM$("CompoundStatement451",459);
                            }
                        } else
                        // JavaLine 98 ==> SourceLine 461
                        {
                            TRACE_BEGIN_STM$("CompoundStatement461",461);
                            sf=sysin();
                            sf.image=TXT$.sub(((SCANNER)(CUR$.SL$)).line,1,80);
                            TRACE_END_STM$("CompoundStatement461",461);
                        }
                        // JavaLine 105 ==> SourceLine 463
                        while(true) {
                            // JavaLine 107 ==> SourceLine 464
                            {
                                TRACE_BEGIN_STM$("CompoundStatement464",464);
                                detach();
                                // JavaLine 111 ==> SourceLine 486
                                LABEL$(2); // NEXTIMAGE
                                // JavaLine 113 ==> SourceLine 465
                                if(sf.inrecord()) {
                                    // JavaLine 115 ==> SourceLine 467
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement467",467);
                                        LABEL$(1); // INRL
                                        newim=CONC(newim,sf.image);
                                        sf.image=blanks(10);
                                        // JavaLine 121 ==> SourceLine 468
                                        if(sf.inrecord()) {
                                            GOTO$(INRL); // GOTO EVALUATED LABEL
                                        }
                                        // JavaLine 125 ==> SourceLine 469
                                        t=blanks(1);
                                        t=CONC(TXT$.sub(sf.image,1,(TXT$.pos(sf.image)-(1))),t);
                                        // JavaLine 128 ==> SourceLine 470
                                        ((SCANNER)(CUR$.SL$)).lexScanner.line=CONC(newim,t);
                                        newim=null;
                                        // JavaLine 131 ==> SourceLine 471
                                        ((SCANNER)(CUR$.SL$)).line=((SCANNER)(CUR$.SL$)).lexScanner.line;
                                        // JavaLine 133 ==> SourceLine 472
                                        if((TXT$.length(((SCANNER)(CUR$.SL$)).line)>(256))) {
                                            // JavaLine 135 ==> SourceLine 473
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement473",473);
                                                linlen=255;
                                                new SCANNER$P1warn(((SCANNER)(CUR$.SL$)),277);
                                                // JavaLine 140 ==> SourceLine 474
                                                ((SCANNER)(CUR$.SL$)).lexScanner.line=((SCANNER)(CUR$.SL$)).line=TXT$.sub(((SCANNER)(CUR$.SL$)).line,1,256);
                                                TRACE_END_STM$("CompoundStatement473",474);
                                            }
                                        } else
                                        // JavaLine 145 ==> SourceLine 476
                                        linlen=(TXT$.length(((SCANNER)(CUR$.SL$)).line)-(1));
                                        // JavaLine 147 ==> SourceLine 477
                                        sf.image=TXT$.sub(((SCANNER)(CUR$.SL$)).line,1,linlen);
                                        TRACE_END_STM$("CompoundStatement467",477);
                                    }
                                } else
                                // JavaLine 152 ==> SourceLine 480
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement480",480);
                                    if(sf.endfile()) {
                                        // JavaLine 156 ==> SourceLine 481
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement481",481);
                                            ((SCANNER)(CUR$.SL$)).line=((SCANNER)(CUR$.SL$)).lexScanner.line=new TXT$("%eof");
                                            linlen=4;
                                            // JavaLine 161 ==> SourceLine 483
                                            GOTO$(EXIT); // GOTO EVALUATED LABEL
                                            TRACE_END_STM$("CompoundStatement481",483);
                                        }
                                    }
                                    // JavaLine 166 ==> SourceLine 485
                                    linlen=(TXT$.pos(sf.image)-(1));
                                    TRACE_END_STM$("CompoundStatement480",485);
                                }
                                // JavaLine 170 ==> SourceLine 488
                                if(((SCANNER)(CUR$.SL$)).incrlnr) {
                                    ((SCANNER)(CUR$.SL$)).linenr=(((SCANNER)(CUR$.SL$)).linenr+(1));
                                }
                                // JavaLine 174 ==> SourceLine 489
                                if(((SCANNER)(CUR$.SL$)).listingon) {
                                    {
                                        // BEGIN INSPECTION 
                                        inspect$489$12=((SCANNER)(CUR$.SL$)).listfile;
                                        if(inspect$489$12!=null) //INSPECT inspect$489$12
                                        // JavaLine 180 ==> SourceLine 490
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement490",490);
                                            inspect$489$12.outint(((SCANNER)(CUR$.SL$)).linenr,6);
                                            inspect$489$12.outtext(new TXT$(": "));
                                            // JavaLine 185 ==> SourceLine 492
                                            inspect$489$12.outtext(TXT$.sub(sf.image,1,(((linlen<(((SCANNER)(CUR$.SL$)).listlength)))?(linlen):(((SCANNER)(CUR$.SL$)).listlength))));
                                            // JavaLine 187 ==> SourceLine 493
                                            inspect$489$12.outimage();
                                            TRACE_END_STM$("CompoundStatement490",493);
                                        }
                                    }
                                }
                                // JavaLine 193 ==> SourceLine 495
                                if((linlen==(0))) {
                                    GOTO$(NEXTIMAGE); // GOTO EVALUATED LABEL
                                }
                                // JavaLine 197 ==> SourceLine 496
                                if((linlen>(((SCANNER)(CUR$.SL$)).signiflength))) {
                                    linlen=((SCANNER)(CUR$.SL$)).signiflength;
                                }
                                // JavaLine 201 ==> SourceLine 497
                                storeChar(((SCANNER)(CUR$.SL$)).EOL,((SCANNER)(CUR$.SL$)).line,linlen);
                                // JavaLine 203 ==> SourceLine 498
                                LABEL$(3); // EXIT
                                ((SCANNER)(CUR$.SL$)).lexScanner.linelength=(linlen+(1));
                                TRACE_END_STM$("CompoundStatement464",498);
                            }
                               if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                        }
                        // JavaLine 210 ==> SourceLine 445
                        if(inner!=null) {
                            inner.STM$();
                            TRACE_BEGIN_STM_AFTER_INNER$("SourceElt",445);
                        }
                        break LOOP$;
                    }
                    catch(LABQNT$ q) {
                        CUR$=THIS$;
                        if(q.SL$!=CUR$ || q.prefixLevel!=1) {
                            CUR$.STATE$=OperationalState.terminated;
                            if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                            throw(q);
                        }
                        if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                        JTX$=q.index; continue LOOP$; // EG. GOTO Lx
                    }
                }
                TRACE_END_STM$("SourceElt",445);
            }
        };
    } // End of Constructor
    // Class Statements
    public SCANNER$SourceElt STM$() { return((SCANNER$SourceElt)CODE$.EXEC$()); }
    public SCANNER$SourceElt START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Class SourceElt",1,433,13,467,15,465,17,498,20,436,22,437,24,438,26,445,28,489,46,445,51,447,59,448,61,449,63,450,65,451,69,452,71,453,75,455,83,456,88,458,91,459,98,461,105,463,107,464,111,486,113,465,115,467,121,468,125,469,128,470,131,471,133,472,135,473,140,474,145,476,147,477,152,480,156,481,161,483,166,485,170,488,174,489,180,490,185,492,187,493,193,495,197,496,201,497,203,498,210,445,234,500);
}
