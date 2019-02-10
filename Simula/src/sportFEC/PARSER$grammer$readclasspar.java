// JavaLine 1 ==> SourceLine 434
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class PARSER$grammer$readclasspar extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=434, lastLine=500, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 478
    final LABQNT$ hiddenprotected=new LABQNT$(this,0,1); // Local Label #1=hiddenprotected
    // JavaLine 13 ==> SourceLine 480
    final LABQNT$ PH=new LABQNT$(this,0,2); // Local Label #2=PH
    // JavaLine 15 ==> SourceLine 490
    final LABQNT$ virtualspec=new LABQNT$(this,0,3); // Local Label #3=virtualspec
    // JavaLine 17 ==> SourceLine 492
    final LABQNT$ specification=new LABQNT$(this,0,4); // Local Label #4=specification
    // JavaLine 19 ==> SourceLine 499
    final LABQNT$ readclassparexit=new LABQNT$(this,0,5); // Local Label #5=readclassparexit
    // Declare locals as attributes
    // JavaLine 22 ==> SourceLine 435
    char oph=0;
    // Normal Constructor
    public PARSER$grammer$readclasspar(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("readclasspar",467);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public PARSER$grammer$readclasspar STM$() {
        TRACE_BEGIN_STM$("readclasspar",467);
        PARSER$grammer$readclasspar THIS$=(PARSER$grammer$readclasspar)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 40 ==> SourceLine 475
                new PARSER$grammer$readprocpar(((PARSER$grammer)(CUR$.SL$)),((PARSER)(CUR$.SL$.SL$)).ICSPC);
                // JavaLine 42 ==> SourceLine 476
                new PARSER$grammer$readclasspar$setrecsymb(((PARSER$grammer$readclasspar)CUR$),true);
                // JavaLine 44 ==> SourceLine 487
                LABEL$(1,"hiddenprotected");
                // JavaLine 46 ==> SourceLine 478
                while((((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IHIDD))||((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ITO))))||((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IPRTC))))) {
                    // JavaLine 48 ==> SourceLine 479
                    {
                        TRACE_BEGIN_STM$("CompoundStatement479",479);
                        oph=(((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ITO)))?(((PARSER)(CUR$.SL$.SL$)).IPRHI):(((PARSER$grammer)(CUR$.SL$)).cs));
                        // JavaLine 52 ==> SourceLine 480
                        LABEL$(2,"PH");
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        // JavaLine 55 ==> SourceLine 481
                        if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IIDN)))) {
                            new PARSER$grammer$readclasspar$classparerror(((PARSER$grammer$readclasspar)CUR$),185);
                        }
                        // JavaLine 59 ==> SourceLine 482
                        ((PARSER)(CUR$.SL$.SL$)).opn=oph;
                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                        // JavaLine 62 ==> SourceLine 483
                        ((PARSER$grammer)(CUR$.SL$)).getopt=false;
                        ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).opt;
                        // JavaLine 65 ==> SourceLine 484
                        if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ICOMA)))) {
                            GOTO$(PH); // GOTO EVALUATED LABEL
                        }
                        // JavaLine 69 ==> SourceLine 485
                        if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).ISMCL)))) {
                            // JavaLine 71 ==> SourceLine 486
                            new PARSER$grammer$skip(((PARSER$grammer)(CUR$.SL$)),300);
                        } else
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        TRACE_END_STM$("CompoundStatement479",486);
                    }
                }
                // JavaLine 78 ==> SourceLine 492
                LABEL$(3,"virtualspec");
                // JavaLine 80 ==> SourceLine 490
                if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IVIRT)))) {
                    // JavaLine 82 ==> SourceLine 491
                    {
                        TRACE_BEGIN_STM$("CompoundStatement491",491);
                        ((PARSER$grammer)(CUR$.SL$)).detach();
                        // JavaLine 86 ==> SourceLine 492
                        LABEL$(4,"specification");
                        new PARSER$grammer$readspecification(((PARSER$grammer)(CUR$.SL$)),((PARSER)(CUR$.SL$.SL$)).IVSPC);
                        TRACE_END_STM$("CompoundStatement491",492);
                    }
                }
                // JavaLine 92 ==> SourceLine 493
                if(VALUE$(((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).INAME))||((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IVALU)))))) {
                    // JavaLine 94 ==> SourceLine 494
                    new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$)),217);
                } else
                if(VALUE$((((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IHIDD))||((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ITO))))||((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IPRTC)))))) {
                    // JavaLine 98 ==> SourceLine 495
                    {
                        TRACE_BEGIN_STM$("CompoundStatement495",495);
                        new PARSER$grammer$ParsWarn(((PARSER$grammer)(CUR$.SL$)),291);
                        GOTO$(hiddenprotected); // GOTO EVALUATED LABEL
                        TRACE_END_STM$("CompoundStatement495",495);
                    }
                } else
                // JavaLine 106 ==> SourceLine 496
                if(VALUE$((((PARSER$grammer)(CUR$.SL$)).symboltype.Elt[rank(((PARSER$grammer)(CUR$.SL$)).cs)-((PARSER$grammer)(CUR$.SL$)).symboltype.LB[0]]==(((PARSER$grammer)(CUR$.SL$)).declsymbol)))) {
                    new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$)),218);
                }
                // JavaLine 110 ==> SourceLine 499
                LABEL$(5,"readclassparexit");
                new PARSER$grammer$readclasspar$setrecsymb(((PARSER$grammer$readclasspar)CUR$),false);
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
        TRACE_END_STM$("readclasspar",499);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Procedure readclasspar",1,434,11,478,13,480,15,490,17,492,19,499,22,435,40,475,42,476,44,487,46,478,48,479,52,480,55,481,59,482,62,483,65,484,69,485,71,486,78,492,80,490,82,491,86,492,92,493,94,494,98,495,106,496,110,499,129,500);
}
