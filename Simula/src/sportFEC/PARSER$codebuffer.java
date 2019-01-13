// JavaLine 1 ==> SourceLine 43
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:24 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PARSER$codebuffer extends COMMON$outcodefile {
    // ClassDeclaration: BlockKind=Class, BlockLevel=2, PrefixLevel=5, firstLine=43, lastLine=116, hasLocalClasses=true, System=false, detachUsed=false
    public int prefixLevel() { return(5); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 44
    public COMMON$outcodefile prev=null;
    // JavaLine 13 ==> SourceLine 45
    public PARSER$codebuffer$elt curelt=null;
    public PARSER$codebuffer$elt firstelt=null;
    // JavaLine 16 ==> SourceLine 47
    public PARSER$codebuffer$elt cvar=null;
    // JavaLine 18 ==> SourceLine 48
    public PARSER$codebuffer$elt stepexpr=null;
    // JavaLine 20 ==> SourceLine 49
    public PARSER$codebuffer$elt forvar=null;
    // JavaLine 22 ==> SourceLine 50
    public PARSER$codebuffer$elt wheeler=null;
    // JavaLine 24 ==> SourceLine 51
    public PARSER$codebuffer$elt deltavar=null;
    // JavaLine 26 ==> SourceLine 52
    public PARSER$codebuffer$elt statlabel=null;
    // JavaLine 28 ==> SourceLine 107
    public PARSER$codebuffer$elt inspect$107$35=null;
    // Normal Constructor
    public PARSER$codebuffer(RTObject$ staticLink,TXT$ sFILENAME$) {
        super(staticLink,sFILENAME$);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("codebuffer",107);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,5) {
            public void STM$() {
                TRACE_BEGIN_STM$("codebuffer",107,inner);
                // JavaLine 40 ==> SourceLine 102
                prev=((PARSER)(CUR$.SL$)).coder;
                ((PARSER)(CUR$.SL$)).coder=((COMMON$outcodefile)CUR$);
                // JavaLine 43 ==> SourceLine 103
                firstelt=curelt=new PARSER$codebuffer$elt(((PARSER$codebuffer)CUR$)).STM$();
                // JavaLine 45 ==> SourceLine 104
                ((PARSER)(CUR$.SL$)).detach();
                // JavaLine 47 ==> SourceLine 106
                while(true) {
                    // JavaLine 49 ==> SourceLine 107
                    {
                        TRACE_BEGIN_STM$("CompoundStatement107",107);
                        {
                            // BEGIN INSPECTION 
                            inspect$107$35=new PARSER$codebuffer$elt(((PARSER$codebuffer)CUR$)).STM$();
                            if(inspect$107$35!=null) //INSPECT inspect$107$35
                            {
                                TRACE_BEGIN_STM$("CompoundStatement107",107);
                                inspect$107$35.opnn=((PARSER)(CUR$.SL$)).opn;
                                // JavaLine 59 ==> SourceLine 108
                                inspect$107$35.opdhii=((PARSER)(CUR$.SL$)).opdhi;
                                inspect$107$35.opdloo=((PARSER)(CUR$.SL$)).opdlo;
                                inspect$107$35.optxx=((PARSER)(CUR$.SL$)).optx;
                                // JavaLine 63 ==> SourceLine 109
                                inspect$107$35.next=curelt.next;
                                curelt=curelt.next=((PARSER$codebuffer$elt)inspect$107$35);
                                TRACE_END_STM$("CompoundStatement107",109);
                            }
                        }
                        // JavaLine 69 ==> SourceLine 112
                        ((PARSER)(CUR$.SL$)).detach();
                        TRACE_END_STM$("CompoundStatement107",112);
                    }
                       if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                }
                // JavaLine 75 ==> SourceLine 102
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("codebuffer",102);
                }
                TRACE_END_STM$("codebuffer",102);
            }
        };
    } // End of Constructor
    // Class Statements
    public PARSER$codebuffer STM$() { return((PARSER$codebuffer)CODE$.EXEC$()); }
    public PARSER$codebuffer START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Class codebuffer",1,43,11,44,13,45,16,47,18,48,20,49,22,50,24,51,26,52,28,107,40,102,43,103,45,104,47,106,49,107,59,108,63,109,69,112,75,102,86,116);
}
