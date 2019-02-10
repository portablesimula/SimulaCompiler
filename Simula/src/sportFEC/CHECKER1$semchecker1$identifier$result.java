// JavaLine 1 ==> SourceLine 1324
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$identifier$result extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1324, lastLine=1352, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 1325
    COMMON$quantity blquant=null;
    // JavaLine 16 ==> SourceLine 1326
    int procblev=0;
    // Normal Constructor
    public CHECKER1$semchecker1$identifier$result(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("result",1326);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$identifier$result STM$() {
        TRACE_BEGIN_STM$("result",1326);
        // JavaLine 30 ==> SourceLine 1328
        RESULT$=false;
        // JavaLine 32 ==> SourceLine 1336
        if(VALUE$((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).p$ch==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IIDN)))) {
            {
                TRACE_BEGIN_STM$("CompoundStatement1336",1336);
                if(VALUE$((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning!=(null)))) {
                    // JavaLine 37 ==> SourceLine 1337
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1337",1337);
                        procblev=(rank(((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.encl.blev)+(1));
                        // JavaLine 41 ==> SourceLine 1341
                        if(VALUE$(((procblev>(5))&((procblev<=(rank(((CHECKER1)(CUR$.SL$.SL$.SL$)).cblev))))))) {
                            // JavaLine 43 ==> SourceLine 1342
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1342",1342);
                                blquant=((CHECKER1)(CUR$.SL$.SL$.SL$)).display.Elt[procblev-((CHECKER1)(CUR$.SL$.SL$.SL$)).display.LB[0]].declquant;
                                // JavaLine 47 ==> SourceLine 1345
                                while((blquant.kind==(((CHECKER1)(CUR$.SL$.SL$.SL$)).K_labbl))) {
                                    // JavaLine 49 ==> SourceLine 1346
                                    blquant=blquant.prefqual;
                                }
                                // JavaLine 52 ==> SourceLine 1347
                                if(VALUE$((blquant.kind==(((CHECKER1)(CUR$.SL$.SL$.SL$)).K_proc)))) {
                                    blquant=blquant.prefqual;
                                }
                                // JavaLine 56 ==> SourceLine 1348
                                RESULT$=((((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.categ==(((CHECKER1)(CUR$.SL$.SL$.SL$)).C_virt)))?(((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.match):(((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning))==(blquant));
                                TRACE_END_STM$("CompoundStatement1342",1348);
                            }
                        }
                        TRACE_END_STM$("CompoundStatement1337",1348);
                    }
                }
                TRACE_END_STM$("CompoundStatement1336",1348);
            }
        }
        TRACE_END_STM$("result",1348);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure result",1,1324,14,1325,16,1326,30,1328,32,1336,37,1337,41,1341,43,1342,47,1345,49,1346,52,1347,56,1348,70,1352);
}
