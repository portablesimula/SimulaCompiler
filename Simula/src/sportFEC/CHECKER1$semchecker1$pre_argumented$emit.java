// JavaLine 1 ==> SourceLine 1736
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$pre_argumented$emit extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1736, lastLine=1781, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 1754
    final LABQNT$ LOUT=new LABQNT$(this,0,1); // Local Label #1=LOUT
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 1738
    CHECKER1$semchecker1$identifier inspect$1738$98=null;
    // Normal Constructor
    public CHECKER1$semchecker1$pre_argumented$emit(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("emit",1738);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$pre_argumented$emit STM$() {
        TRACE_BEGIN_STM$("emit",1738);
        CHECKER1$semchecker1$pre_argumented$emit THIS$=(CHECKER1$semchecker1$pre_argumented$emit)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                {
                    // BEGIN INSPECTION 
                    inspect$1738$98=((CHECKER1$semchecker1$pre_argumented)(CUR$.SL$)).p1$ident;
                    if(inspect$1738$98!=null) //INSPECT inspect$1738$98
                    // JavaLine 36 ==> SourceLine 1739
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1739",1739);
                        inspect$1738$98.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
                        inspect$1738$98.emit$0().CPF();
                        // JavaLine 41 ==> SourceLine 1740
                        switch(inspect$1738$98.kind) { // BEGIN SWITCH STATEMENT
                        case 1: 
                        // JavaLine 44 ==> SourceLine 1741
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1741",1741);
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).lastopc=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc;
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IPROC;
                            TRACE_END_STM$("CompoundStatement1741",1741);
                        }
                        case 5: 
                        // JavaLine 52 ==> SourceLine 1743
                        ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=(((((CHECKER1$semchecker1$pre_argumented)(CUR$.SL$)).p$ch==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IBPRF)))?(((CHECKER1)(CUR$.SL$.SL$.SL$)).IBEFO):(((CHECKER1)(CUR$.SL$.SL$.SL$)).IAT));
                        case 6: 
                        // JavaLine 55 ==> SourceLine 1746
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1746",1746);
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ISWEE;
                            TRACE_END_STM$("CompoundStatement1746",1746);
                        }
                        case 2: 
                        // JavaLine 62 ==> SourceLine 1748
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1748",1748);
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ICAPE;
                            TRACE_END_STM$("CompoundStatement1748",1748);
                        }
                        case 4: 
                        // JavaLine 69 ==> SourceLine 1750
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1750",1750);
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).ICAPE;
                            GOTO$(LOUT); // GOTO EVALUATED LABEL
                            TRACE_END_STM$("CompoundStatement1750",1750);
                        }
                        default:
                        // JavaLine 77 ==> SourceLine 1751
                        GOTO$(LOUT); // GOTO EVALUATED LABEL
                    } // END SWITCH STATEMENT
                    // JavaLine 80 ==> SourceLine 1753
                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=char$(((CHECKER1$semchecker1$pre_argumented)(CUR$.SL$)).p1$noofactargs);
                    call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).lastopc=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc;
                    // JavaLine 84 ==> SourceLine 1756
                    LABEL$(1); // LOUT
                    // JavaLine 86 ==> SourceLine 1754
                    if(((inspect$1738$98.meaning!=(null))||((((CHECKER1$semchecker1$pre_argumented)(CUR$.SL$)).p$ch!=(((CHECKER1)(CUR$.SL$.SL$.SL$)).IBPRF))))) {
                        // JavaLine 88 ==> SourceLine 1756
                        ((CHECKER1$semchecker1$pre_argumented)(CUR$.SL$)).p1$arguments.emit$0().CPF();
                    }
                    TRACE_END_STM$("CompoundStatement1739",1756);
                }
            }
            // JavaLine 94 ==> SourceLine 1760
            if((((CHECKER1$semchecker1$pre_argumented)(CUR$.SL$)).p1$ident.kind==(((CHECKER1)(CUR$.SL$.SL$.SL$)).K_error))) {
            } else
            // JavaLine 97 ==> SourceLine 1761
            if((((CHECKER1$semchecker1$pre_argumented)(CUR$.SL$)).p$ch==(((CHECKER1)(CUR$.SL$.SL$.SL$)).IBPRF))) {
                // JavaLine 99 ==> SourceLine 1762
                {
                    TRACE_BEGIN_STM$("CompoundStatement1762",1762);
                    ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IBEGI;
                    call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
                    // JavaLine 104 ==> SourceLine 1763
                    new CHECKER1$semchecker1$enterblock(((CHECKER1$semchecker1)(CUR$.SL$.SL$)));
                    TRACE_END_STM$("CompoundStatement1762",1763);
                }
            } else
            // JavaLine 109 ==> SourceLine 1766
            {
                TRACE_BEGIN_STM$("CompoundStatement1766",1766);
                switch(((CHECKER1$semchecker1$pre_argumented)(CUR$.SL$)).p1$ident.kind) { // BEGIN SWITCH STATEMENT
                case 2: 
                case 6: 
                // JavaLine 115 ==> SourceLine 1768
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=(((((CHECKER1$semchecker1$pre_argumented)(CUR$.SL$)).cl==(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IACTEcl)))?(((CHECKER1)(CUR$.SL$.SL$.SL$)).IARRA):((((((CHECKER1$semchecker1$pre_argumented)(CUR$.SL$)).cl==(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl)))?(((CHECKER1)(CUR$.SL$.SL$.SL$)).IARGE):(((CHECKER1)(CUR$.SL$.SL$.SL$)).INEWP))));
                case 4: 
                // JavaLine 118 ==> SourceLine 1771
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=(((((CHECKER1$semchecker1$pre_argumented)(CUR$.SL$)).cl==(((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IACTEcl)))?(((CHECKER1)(CUR$.SL$.SL$.SL$)).IARRA):(((CHECKER1)(CUR$.SL$.SL$.SL$)).IAFTR));
                case 1: 
                // JavaLine 121 ==> SourceLine 1773
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=(((((CHECKER1$semchecker1$parameter)(((CHECKER1$semchecker1$pre_argumented)(CUR$.SL$)).p1$arguments)).p1$formal==(null)))?(((CHECKER1)(CUR$.SL$.SL$.SL$)).IUPLS):(((CHECKER1)(CUR$.SL$.SL$.SL$)).IEPRM));
                case 5: 
                // JavaLine 124 ==> SourceLine 1775
                ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opc=((CHECKER1)(CUR$.SL$.SL$.SL$)).IACTV;
                default:
                // JavaLine 127 ==> SourceLine 1776
                new ERRMSG$internerr(((CHECKER1)(CUR$.SL$.SL$.SL$)),((char)8),1776);
            } // END SWITCH STATEMENT
            // JavaLine 130 ==> SourceLine 1779
            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).opilo=char$(((CHECKER1$semchecker1$pre_argumented)(CUR$.SL$)).p1$noofactargs);
            call(((CHECKER1)(CUR$.SL$.SL$.SL$)).coder);
            TRACE_END_STM$("CompoundStatement1766",1779);
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
TRACE_END_STM$("emit",1779);
EBLK();
return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure emit",1,1736,11,1754,14,1738,36,1739,41,1740,44,1741,52,1743,55,1746,62,1748,69,1750,77,1751,80,1753,84,1756,86,1754,88,1756,94,1760,97,1761,99,1762,104,1763,109,1766,115,1768,118,1771,121,1773,124,1775,127,1776,130,1779,151,1781);
}
