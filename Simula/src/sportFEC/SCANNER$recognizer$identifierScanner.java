// JavaLine 1 ==> SourceLine 940
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:44:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class SCANNER$recognizer$identifierScanner extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=0, firstLine=940, lastLine=972, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 955
    final LABQNT$ SCAN=new LABQNT$(this,0,1); // Local Label #1=SCAN
    // JavaLine 14 ==> SourceLine 952
    final LABQNT$ TEST=new LABQNT$(this,0,2); // Local Label #2=TEST
    // JavaLine 16 ==> SourceLine 966
    final LABQNT$ idterm=new LABQNT$(this,0,3); // Local Label #3=idterm
    // Declare locals as attributes
    // JavaLine 19 ==> SourceLine 943
    public char atomcl=0;
    // JavaLine 21 ==> SourceLine 944
    public int hashpos=0;
    // JavaLine 23 ==> SourceLine 945
    public TXT$ hashbuf=null;
    // Normal Constructor
    public SCANNER$recognizer$identifierScanner(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("identifierScanner",945);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("identifierScanner",945,inner);
                SCANNER$recognizer$identifierScanner THIS$=(SCANNER$recognizer$identifierScanner)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 40 ==> SourceLine 947
                        hashbuf=blanks(72);
                        detach();
                        // JavaLine 43 ==> SourceLine 948
                        while(true) {
                            // JavaLine 45 ==> SourceLine 949
                            {
                                TRACE_BEGIN_STM$("CompoundStatement949",949);
                                hashpos=0;
                                // JavaLine 49 ==> SourceLine 964
                                LABEL$(2); // TEST
                                // JavaLine 51 ==> SourceLine 952
                                switch(((SCANNER$recognizer)(CUR$.SL$)).InputClass.Elt[rank(((SCANNER$recognizer)(CUR$.SL$)).atom)-((SCANNER$recognizer)(CUR$.SL$)).InputClass.LB[0]]) { // BEGIN SWITCH STATEMENT
                                case 0: 
                                case 1: 
                                case 3: 
                                case 2: 
                                // JavaLine 57 ==> SourceLine 954
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement954",954);
                                    storeChar(((SCANNER$recognizer)(CUR$.SL$)).atom,hashbuf,hashpos);
                                    hashpos=(hashpos+(1));
                                    // JavaLine 62 ==> SourceLine 955
                                    LABEL$(1); // SCAN
                                    ((SCANNER$recognizer)(CUR$.SL$)).atom=loadChar(((SCANNER$recognizer)(CUR$.SL$)).line,((SCANNER$recognizer)(CUR$.SL$)).linepos);
                                    ((SCANNER$recognizer)(CUR$.SL$)).linepos=(((SCANNER$recognizer)(CUR$.SL$)).linepos+(1));
                                    // JavaLine 66 ==> SourceLine 957
                                    GOTO$(TEST); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement954",957);
                                }
                                case 7: 
                                case 8: 
                                // JavaLine 72 ==> SourceLine 960
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement960",960);
                                    if((((SCANNER$recognizer)(CUR$.SL$)).linepos==(((SCANNER$recognizer)(CUR$.SL$)).linelength))) {
                                        GOTO$(idterm); // GOTO EVALUATED LABEL
                                    }
                                    // JavaLine 78 ==> SourceLine 961
                                    new SCANNER$recognizer$illegalChar(((SCANNER$recognizer)(CUR$.SL$)));
                                    GOTO$(SCAN); // GOTO EVALUATED LABEL
                                    TRACE_END_STM$("CompoundStatement960",961);
                                }
                                case 5: 
                                case 4: 
                                case 6: 
                                // JavaLine 86 ==> SourceLine 962
                                GOTO$(idterm); // GOTO EVALUATED LABEL
                                default:
                                // JavaLine 89 ==> SourceLine 963
                                GOTO$(SCAN); // GOTO EVALUATED LABEL
                            } // END SWITCH STATEMENT
                            // JavaLine 92 ==> SourceLine 966
                            LABEL$(3); // idterm
                            ((SCANNER)(CUR$.SL$.SL$)).simsymbol=lowcase(TXT$.sub(hashbuf,1,hashpos));
                            // JavaLine 95 ==> SourceLine 968
                            detach();
                            TRACE_END_STM$("CompoundStatement949",968);
                        }
                           if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                    }
                    // JavaLine 101 ==> SourceLine 947
                    if(inner!=null) {
                        inner.STM$();
                        TRACE_BEGIN_STM_AFTER_INNER$("identifierScanner",947);
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
            TRACE_END_STM$("identifierScanner",947);
            EBLK(); // Iff no prefix
        }
    };
} // End of Constructor
// Class Statements
public SCANNER$recognizer$identifierScanner STM$() { return((SCANNER$recognizer$identifierScanner)CODE$.EXEC$()); }
public SCANNER$recognizer$identifierScanner START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Class identifierScanner",1,940,12,955,14,952,16,966,19,943,21,944,23,945,40,947,43,948,45,949,49,964,51,952,57,954,62,955,66,957,72,960,78,961,86,962,89,963,92,966,95,968,101,947,126,972);
}
