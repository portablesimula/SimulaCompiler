// JavaLine 1 ==> SourceLine 882
package FEC;
// Release-Beta-0.3 Compiled at Fri Jan 04 14:58:53 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class SCANNER$recognizer$scanahead extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=3, firstLine=882, lastLine=896, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 896
    final LABQNT$ EXIT=new LABQNT$(this,0,1); // Local Label #1=EXIT
    // Declare locals as attributes
    // Normal Constructor
    public SCANNER$recognizer$scanahead(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("scanahead",896);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public SCANNER$recognizer$scanahead STM$() {
        TRACE_BEGIN_STM$("scanahead",896);
        SCANNER$recognizer$scanahead THIS$=(SCANNER$recognizer$scanahead)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 30 ==> SourceLine 884
                while(true) {
                    // JavaLine 32 ==> SourceLine 885
                    {
                        TRACE_BEGIN_STM$("CompoundStatement885",885);
                        ((SCANNER$recognizer)(CUR$.SL$)).atom=loadChar(((SCANNER$recognizer)(CUR$.SL$)).line,((SCANNER$recognizer)(CUR$.SL$)).linepos);
                        ((SCANNER$recognizer)(CUR$.SL$)).linepos=(((SCANNER$recognizer)(CUR$.SL$)).linepos+(1));
                        // JavaLine 37 ==> SourceLine 887
                        switch(((SCANNER$recognizer)(CUR$.SL$)).InputClass.Elt[rank(((SCANNER$recognizer)(CUR$.SL$)).atom)-((SCANNER$recognizer)(CUR$.SL$)).InputClass.LB[0]]) { // BEGIN SWITCH STATEMENT
                        case 9: 
                        case 4: 
                        case 0: 
                        case 2: 
                        case 5: 
                        case 6: 
                        case 1: 
                        case 3: 
                        case 7: 
                        // JavaLine 48 ==> SourceLine 890
                        GOTO$(EXIT); // GOTO EVALUATED LABEL
                        case 8: 
                        // JavaLine 51 ==> SourceLine 892
                        {
                            TRACE_BEGIN_STM$("CompoundStatement892",892);
                            if((((SCANNER$recognizer)(CUR$.SL$)).atom==(((SCANNER)(CUR$.SL$.SL$)).EOL))) {
                                GOTO$(EXIT); // GOTO EVALUATED LABEL
                            }
                            // JavaLine 57 ==> SourceLine 893
                            new SCANNER$recognizer$illegalChar(((SCANNER$recognizer)(CUR$.SL$)));
                            TRACE_END_STM$("CompoundStatement892",893);
                        }
                    } // END SWITCH STATEMENT
                    TRACE_END_STM$("CompoundStatement885",893);
                }
                   if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
            }
            // JavaLine 66 ==> SourceLine 896
            LABEL$(1); // EXIT
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
    TRACE_END_STM$("scanahead",896);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("SCANNER.DEF","Procedure scanahead",1,882,11,896,30,884,32,885,37,887,48,890,51,892,57,893,66,896,84,896);
}
