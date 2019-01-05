// JavaLine 1 ==> SourceLine 1023
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:48:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class BUILDER2$prechecker$allocate$alloc1$allocDescriptor extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=5, firstLine=1023, lastLine=1034, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare locals as attributes
    // JavaLine 11 ==> SourceLine 1027
    COMMON$brecord inspect$1025$12=null;
    // Normal Constructor
    public BUILDER2$prechecker$allocate$alloc1$allocDescriptor(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("allocDescriptor",1027);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public BUILDER2$prechecker$allocate$alloc1$allocDescriptor STM$() {
        TRACE_BEGIN_STM$("allocDescriptor",1027);
        // JavaLine 25 ==> SourceLine 1025
        {
            // BEGIN INSPECTION 
            inspect$1025$12=(((((BUILDER2$prechecker$allocate$alloc1)(CUR$.SL$)).Q.descr==(null)))?(((ARRAY$<COMMON$brecord[]>)((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).brctab.Elt[0-((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).brctab.LB[0]].val).Elt[0-((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).brctab.Elt[0-((BUILDER2)(CUR$.SL$.SL$.SL$.SL$)).brctab.LB[0]].val.LB[0]]):(((BUILDER2$prechecker$allocate$alloc1)(CUR$.SL$)).Q.descr));
            if(inspect$1025$12!=null) //INSPECT inspect$1025$12
            // JavaLine 30 ==> SourceLine 1028
            {
                TRACE_BEGIN_STM$("CompoundStatement1028",1028);
                ((BUILDER2$prechecker$allocate$alloc1)(CUR$.SL$)).QN.descr=((COMMON$brecord)inspect$1025$12);
                inspect$1025$12.declquant=((BUILDER2$prechecker$allocate$alloc1)(CUR$.SL$)).QN;
                // JavaLine 35 ==> SourceLine 1029
                inspect$1025$12.blev=char$((rank(((BUILDER2$prechecker$allocate$alloc1)(CUR$.SL$)).p$brc.blev)+(1)));
                // JavaLine 37 ==> SourceLine 1030
                inspect$1025$12.rtblev=char$((rank(((BUILDER2$prechecker$allocate$alloc1)(CUR$.SL$)).p$brc.rtblev)+(1)));
                // JavaLine 39 ==> SourceLine 1032
                new BUILDER2$prechecker$allocate$alloc1(((BUILDER2$prechecker$allocate)(CUR$.SL$.SL$)),((COMMON$brecord)inspect$1025$12));
                TRACE_END_STM$("CompoundStatement1028",1032);
            }
        }
        TRACE_END_STM$("allocDescriptor",1032);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("BUILDER2.DEF","Procedure allocDescriptor",1,1023,11,1027,25,1025,30,1028,35,1029,37,1030,39,1032,47,1034);
}
