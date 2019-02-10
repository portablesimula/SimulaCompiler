// JavaLine 1 ==> SourceLine 718
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:46:16 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PARSER$grammer$module extends PARSER$grammer$statement {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=1, firstLine=718, lastLine=765, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(1); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 740
    final LABQNT$ S0=new LABQNT$(this,1,1); // Local Label #1=S0
    // JavaLine 14 ==> SourceLine 743
    final LABQNT$ RECOVER3=new LABQNT$(this,1,2); // Local Label #2=RECOVER3
    // JavaLine 16 ==> SourceLine 745
    final LABQNT$ PARSE=new LABQNT$(this,1,3); // Local Label #3=PARSE
    // JavaLine 18 ==> SourceLine 747
    final LABQNT$ S1=new LABQNT$(this,1,4); // Local Label #4=S1
    // JavaLine 20 ==> SourceLine 748
    final LABQNT$ RECOVER1=new LABQNT$(this,1,5); // Local Label #5=RECOVER1
    // JavaLine 22 ==> SourceLine 752
    final LABQNT$ RECOVER2=new LABQNT$(this,1,6); // Local Label #6=RECOVER2
    // JavaLine 24 ==> SourceLine 754
    final LABQNT$ S2=new LABQNT$(this,1,7); // Local Label #7=S2
    // JavaLine 26 ==> SourceLine 755
    final LABQNT$ RECOVER4=new LABQNT$(this,1,8); // Local Label #8=RECOVER4
    // Declare locals as attributes
    // JavaLine 29 ==> SourceLine 720
    public boolean SepOK=false;
    public PRCQNT$ recover$0() { return(new PRCQNT$(this,PARSER$grammer$module$recover.class)); }
    public PRCQNT$ recoversetting$0() { return(new PRCQNT$(this,PARSER$grammer$module$recoversetting.class)); }
    // Normal Constructor
    public PARSER$grammer$module(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("module",735);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,1) {
            public void STM$() {
                TRACE_BEGIN_STM$("module",735,inner);
                PARSER$grammer$module THIS$=(PARSER$grammer$module)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 47 ==> SourceLine 737
                        detach();
                        // JavaLine 49 ==> SourceLine 740
                        LABEL$(1,"S0");
                        isblocklike=true;
                        blockstatus=((PARSER$grammer)(CUR$.SL$)).stmtnotseen;
                        // JavaLine 53 ==> SourceLine 741
                        stmtreq=((PARSER$grammer)(CUR$.SL$)).outermost;
                        // JavaLine 55 ==> SourceLine 742
                        if(VALUE$((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IEXTR)))) {
                            new PARSER$codebuffer(((PARSER)(CUR$.SL$.SL$)),new TXT$("$ext$")).STM$();
                        }
                        // JavaLine 59 ==> SourceLine 748
                        LABEL$(2,"RECOVER3");
                        // JavaLine 61 ==> SourceLine 743
                        while((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IEXTR))) {
                            // JavaLine 63 ==> SourceLine 744
                            {
                                TRACE_BEGIN_STM$("CompoundStatement744",744);
                                rp=((char)1);
                                // JavaLine 67 ==> SourceLine 745
                                LABEL$(3,"PARSE");
                                detach();
                                GOTO$(new PARSER$grammer$module$RPSW(((PARSER$grammer$module)CUR$),(rank(rp)+(1))).RESULT$); // GOTO EVALUATED LABEL
                                // JavaLine 71 ==> SourceLine 748
                                LABEL$(4,"S1");
                                LABEL$(5,"RECOVER1");
                                TRACE_END_STM$("CompoundStatement744",748);
                            }
                        }
                        // JavaLine 77 ==> SourceLine 750
                        if(VALUE$(IS$(((PARSER)(CUR$.SL$.SL$)).coder,PARSER$codebuffer.class))) {
                            new PARSER$codebuffer$termModul(((PARSER$codebuffer)(((PARSER)(CUR$.SL$.SL$)).coder)));
                        }
                        // JavaLine 81 ==> SourceLine 752
                        LABEL$(6,"RECOVER2");
                        rp=((char)2);
                        GOTO$(PARSE); // GOTO EVALUATED LABEL
                        // JavaLine 85 ==> SourceLine 754
                        LABEL$(7,"S2");
                        while((((PARSER$grammer)(CUR$.SL$)).cs!=(((PARSER)(CUR$.SL$.SL$)).IEOP))) {
                            new PARSER$grammer$NEXTSYMBOL(((PARSER$grammer)(CUR$.SL$)));
                        }
                        // JavaLine 90 ==> SourceLine 756
                        LABEL$(8,"RECOVER4");
                        // JavaLine 92 ==> SourceLine 755
                        if(VALUE$((SepOK||(((PARSER)(CUR$.SL$.SL$)).separatecomp)))) {
                        } else
                        // JavaLine 95 ==> SourceLine 756
                        new PARSER$grammer$ParsErr(((PARSER$grammer)(CUR$.SL$)),212);
                        // JavaLine 97 ==> SourceLine 757
                        while((((PARSER$grammer)(CUR$.SL$)).blockfound>(0))) {
                            // JavaLine 99 ==> SourceLine 758
                            {
                                TRACE_BEGIN_STM$("CompoundStatement758",758);
                                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IEND;
                                call(((PARSER)(CUR$.SL$.SL$)).coder);
                                ((PARSER$grammer)(CUR$.SL$)).blockfound=(((PARSER$grammer)(CUR$.SL$)).blockfound-(1));
                                TRACE_END_STM$("CompoundStatement758",758);
                            }
                        }
                        // JavaLine 108 ==> SourceLine 761
                        ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).IEOP;
                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                        // JavaLine 111 ==> SourceLine 762
                        while(true) {
                            new PARSER$grammer$NEXTSYMBOL(((PARSER$grammer)(CUR$.SL$)));
                               if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                        }
                        // JavaLine 116 ==> SourceLine 737
                        if(inner!=null) {
                            inner.STM$();
                            TRACE_BEGIN_STM_AFTER_INNER$("module",737);
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
                TRACE_END_STM$("module",737);
            }
        };
    } // End of Constructor
    // Class Statements
    public PARSER$grammer$module STM$() { return((PARSER$grammer$module)CODE$.EXEC$()); }
    public PARSER$grammer$module START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Class module",1,718,12,740,14,743,16,745,18,747,20,748,22,752,24,754,26,755,29,720,47,737,49,740,53,741,55,742,59,748,61,743,63,744,67,745,71,748,77,750,81,752,85,754,90,756,92,755,95,756,97,757,99,758,108,761,111,762,116,737,140,765);
}
