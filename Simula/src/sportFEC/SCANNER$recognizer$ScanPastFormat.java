// JavaLine 1 ==> SourceLine 846
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:44:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$recognizer$ScanPastFormat extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=846, lastLine=878, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 850
    final LABQNT$ SCN1=new LABQNT$(this,0,1); // Local Label #1=SCN1
    // JavaLine 13 ==> SourceLine 865
    final LABQNT$ L1=new LABQNT$(this,0,2); // Local Label #2=L1
    // JavaLine 15 ==> SourceLine 872
    final LABQNT$ SCAN=new LABQNT$(this,0,3); // Local Label #3=SCAN
    // JavaLine 17 ==> SourceLine 878
    final LABQNT$ EXIT=new LABQNT$(this,0,4); // Local Label #4=EXIT
    // Declare locals as attributes
    // JavaLine 20 ==> SourceLine 848
    int startpos=0;
    // Normal Constructor
    public SCANNER$recognizer$ScanPastFormat(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("ScanPastFormat",848);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$recognizer$ScanPastFormat STM$() {
        TRACE_BEGIN_STM$("ScanPastFormat",848);
        SCANNER$recognizer$ScanPastFormat THIS$=(SCANNER$recognizer$ScanPastFormat)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 38 ==> SourceLine 877
                LABEL$(1); // SCN1
                // JavaLine 40 ==> SourceLine 850
                switch(((SCANNER$recognizer)(CUR$.SL$)).InputClass.Elt[rank(((SCANNER$recognizer)(CUR$.SL$)).atom)-((SCANNER$recognizer)(CUR$.SL$)).InputClass.LB[0]]) { // BEGIN SWITCH STATEMENT
                case 7: 
                case 8: 
                // JavaLine 44 ==> SourceLine 853
                {
                    TRACE_BEGIN_STM$("CompoundStatement853",853);
                    // JavaLine 47 ==> SourceLine 854
                    if((((SCANNER$recognizer)(CUR$.SL$)).linepos==(((SCANNER$recognizer)(CUR$.SL$)).linelength))) {
                        // JavaLine 49 ==> SourceLine 855
                        {
                            TRACE_BEGIN_STM$("CompoundStatement855",855);
                            new SCANNER$recognizer$nextLine(((SCANNER$recognizer)(CUR$.SL$)));
                            GOTO$(SCN1); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement855",855);
                        }
                    }
                    // JavaLine 57 ==> SourceLine 856
                    if((((SCANNER)(CUR$.SL$.SL$)).maxnumoftags>(0))) {
                        new SCANNER$recognizer$illegalChar(((SCANNER$recognizer)(CUR$.SL$)));
                    }
                    // JavaLine 61 ==> SourceLine 858
                    GOTO$(SCAN); // GOTO EVALUATED LABEL
                    TRACE_END_STM$("CompoundStatement853",858);
                }
                case 1: 
                // JavaLine 66 ==> SourceLine 860
                {
                    TRACE_BEGIN_STM$("CompoundStatement860",860);
                    startpos=((SCANNER$recognizer)(CUR$.SL$)).linepos;
                    call(((SCANNER$recognizer)(CUR$.SL$)).IdScanner);
                    // JavaLine 71 ==> SourceLine 861
                    if(TXTREL$NE(((SCANNER)(CUR$.SL$.SL$)).simsymbol,new TXT$("comment"))) {
                        // JavaLine 73 ==> SourceLine 862
                        {
                            TRACE_BEGIN_STM$("CompoundStatement862",862);
                            ((SCANNER$recognizer)(CUR$.SL$)).linepos=startpos;
                            ((SCANNER$recognizer)(CUR$.SL$)).atom='c';
                            GOTO$(EXIT); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement862",862);
                        }
                    }
                    // JavaLine 82 ==> SourceLine 863
                    GOTO$(L1); // GOTO EVALUATED LABEL
                    TRACE_END_STM$("CompoundStatement860",863);
                }
                case 5: 
                // JavaLine 87 ==> SourceLine 864
                {
                    TRACE_BEGIN_STM$("CompoundStatement864",864);
                    // JavaLine 90 ==> SourceLine 869
                    LABEL$(2); // L1
                    // JavaLine 92 ==> SourceLine 865
                    while((((SCANNER$recognizer)(CUR$.SL$)).atom!=(';'))) {
                        // JavaLine 94 ==> SourceLine 866
                        {
                            TRACE_BEGIN_STM$("CompoundStatement866",866);
                            if((((SCANNER$recognizer)(CUR$.SL$)).linepos<(((SCANNER$recognizer)(CUR$.SL$)).linelength))) {
                                // JavaLine 98 ==> SourceLine 867
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement867",867);
                                    ((SCANNER$recognizer)(CUR$.SL$)).atom=loadChar(((SCANNER$recognizer)(CUR$.SL$)).line,((SCANNER$recognizer)(CUR$.SL$)).linepos);
                                    ((SCANNER$recognizer)(CUR$.SL$)).linepos=(((SCANNER$recognizer)(CUR$.SL$)).linepos+(1));
                                    TRACE_END_STM$("CompoundStatement867",867);
                                }
                            } else
                            // JavaLine 106 ==> SourceLine 868
                            new SCANNER$recognizer$nextLine(((SCANNER$recognizer)(CUR$.SL$)));
                            TRACE_END_STM$("CompoundStatement866",868);
                        }
                    }
                    // JavaLine 111 ==> SourceLine 870
                    GOTO$(SCAN); // GOTO EVALUATED LABEL
                    TRACE_END_STM$("CompoundStatement864",870);
                }
                case 9: 
                case 6: 
                // JavaLine 117 ==> SourceLine 872
                {
                    TRACE_BEGIN_STM$("CompoundStatement872",872);
                    LABEL$(3); // SCAN
                    ((SCANNER$recognizer)(CUR$.SL$)).atom=loadChar(((SCANNER$recognizer)(CUR$.SL$)).line,((SCANNER$recognizer)(CUR$.SL$)).linepos);
                    ((SCANNER$recognizer)(CUR$.SL$)).linepos=(((SCANNER$recognizer)(CUR$.SL$)).linepos+(1));
                    // JavaLine 123 ==> SourceLine 875
                    GOTO$(SCN1); // GOTO EVALUATED LABEL
                    TRACE_END_STM$("CompoundStatement872",875);
                }
            } // END SWITCH STATEMENT
            // JavaLine 128 ==> SourceLine 878
            LABEL$(4); // EXIT
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
    TRACE_END_STM$("ScanPastFormat",878);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure ScanPastFormat",1,846,11,850,13,865,15,872,17,878,20,848,38,877,40,850,44,853,47,854,49,855,57,856,61,858,66,860,71,861,73,862,82,863,87,864,90,869,92,865,94,866,98,867,106,868,111,870,117,872,123,875,128,878,146,878);
}
