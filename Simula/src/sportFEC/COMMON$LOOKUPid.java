// JavaLine 1 ==> SourceLine 138
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:41:36 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class COMMON$LOOKUPid extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=2, firstLine=138, lastLine=159, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare return value as attribute
    public boolean RESULT$;
    public Object RESULT$() { return(RESULT$); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 14 ==> SourceLine 157
    final LABQNT$ F=new LABQNT$(this,0,1); // Local Label #1=F
    // Declare locals as attributes
    // JavaLine 17 ==> SourceLine 139
    char idlen=0;
    COMMON$symbolbox cursym=null;
    // Normal Constructor
    public COMMON$LOOKUPid(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("LOOKUPid",139);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public COMMON$LOOKUPid STM$() {
        TRACE_BEGIN_STM$("LOOKUPid",139);
        COMMON$LOOKUPid THIS$=(COMMON$LOOKUPid)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 36 ==> SourceLine 140
                if(TRF_EQ(((COMMON)(CUR$.SL$)).simsymbol,null)) {
                    // JavaLine 38 ==> SourceLine 141
                    {
                        TRACE_BEGIN_STM$("CompoundStatement141",141);
                        RESULT$=true;
                        ((COMMON)(CUR$.SL$)).hashhi=((COMMON)(CUR$.SL$)).hashlo=((COMMON)(CUR$.SL$)).NUL;
                        TRACE_END_STM$("CompoundStatement141",141);
                    }
                } else
                // JavaLine 46 ==> SourceLine 145
                {
                    TRACE_BEGIN_STM$("CompoundStatement145",145);
                    ((COMMON)(CUR$.SL$)).hashlo=char$(hash(lowcase(((COMMON)(CUR$.SL$)).simsymbol)));
                    // JavaLine 50 ==> SourceLine 146
                    cursym=((COMMON)(CUR$.SL$)).hashtab.Elt[rank(((COMMON)(CUR$.SL$)).hashlo)-((COMMON)(CUR$.SL$)).hashtab.LB[0]];
                    // JavaLine 52 ==> SourceLine 147
                    if((cursym!=(null))) {
                        // JavaLine 54 ==> SourceLine 148
                        {
                            TRACE_BEGIN_STM$("CompoundStatement148",148);
                            // JavaLine 57 ==> SourceLine 149
                            while(TXTREL$NE(cursym.symbol,((COMMON)(CUR$.SL$)).simsymbol)) {
                                // JavaLine 59 ==> SourceLine 151
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement151",151);
                                    if((cursym.next==(null))) {
                                        GOTO$(F); // GOTO EVALUATED LABEL
                                    }
                                    // JavaLine 65 ==> SourceLine 152
                                    cursym=cursym.next;
                                    TRACE_END_STM$("CompoundStatement151",152);
                                }
                            }
                            // JavaLine 70 ==> SourceLine 154
                            ((COMMON)(CUR$.SL$)).hashhi=cursym.idhi;
                            ((COMMON)(CUR$.SL$)).hashlo=cursym.idlo;
                            // JavaLine 73 ==> SourceLine 155
                            RESULT$=true;
                            TRACE_END_STM$("CompoundStatement148",155);
                        }
                    } else
                    // JavaLine 78 ==> SourceLine 157
                    LABEL$(1); // F
                    {
                        TRACE_BEGIN_STM$("CompoundStatement157",157);
                        ((COMMON)(CUR$.SL$)).hashhi=((COMMON)(CUR$.SL$)).NUL;
                        RESULT$=false;
                        TRACE_END_STM$("CompoundStatement157",157);
                    }
                    TRACE_END_STM$("CompoundStatement145",157);
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
        TRACE_END_STM$("LOOKUPid",157);
        EBLK();
        return(this);
    } // End of Procedure BODY
    public static PROGINFO$ INFO$=new PROGINFO$("COMMON.DEF","Procedure LOOKUPid",1,138,14,157,17,139,36,140,38,141,46,145,50,146,52,147,54,148,57,149,59,151,65,152,70,154,73,155,78,157,104,159);
}
