// JavaLine 1 ==> SourceLine 1354
package sportFEC;
// Simula-Beta-0.3 Compiled at Sun Feb 10 10:47:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public final class CHECKER1$semchecker1$identifier$NamedConstant extends BASICIO$ {
    // ProcedureDeclaration: BlockKind=Procedure, BlockLevel=4, firstLine=1354, lastLine=1386, hasLocalClasses=false, System=false
    public int prefixLevel() { return(0); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 1383
    final LABQNT$ NOTDEF=new LABQNT$(this,0,1); // Local Label #1=NOTDEF
    // Declare locals as attributes
    // JavaLine 14 ==> SourceLine 1356
    CHECKER1$semchecker1$const$ Nconst=null;
    // JavaLine 16 ==> SourceLine 1358
    COMMON$brecord inspect$1358$11=null;
    // Normal Constructor
    public CHECKER1$semchecker1$identifier$NamedConstant(RTObject$ SL$) {
        super(SL$);
        // Parameter assignment to locals
        BBLK();
        // Declaration Code
        TRACE_BEGIN_DCL$("NamedConstant",1358);
        STM$();
    } // End of Constructor
    // Procedure Statements
    public CHECKER1$semchecker1$identifier$NamedConstant STM$() {
        TRACE_BEGIN_STM$("NamedConstant",1358);
        CHECKER1$semchecker1$identifier$NamedConstant THIS$=(CHECKER1$semchecker1$identifier$NamedConstant)CUR$;
        LOOP$:while(JTX$>=0) {
            try {
                JUMPTABLE$(JTX$); // For ByteCode Engineering
                // JavaLine 34 ==> SourceLine 1357
                if(VALUE$((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.special==(((char)2))))) {
                    // JavaLine 36 ==> SourceLine 1358
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1358",1358);
                        {
                            // BEGIN INSPECTION 
                            inspect$1358$11=((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.descr;
                            if(inspect$1358$11!=null) //INSPECT inspect$1358$11
                            // JavaLine 43 ==> SourceLine 1360
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1360",1360);
                                switch(((CHECKER1$semchecker1$identifier)(CUR$.SL$)).type) { // BEGIN SWITCH STATEMENT
                                case 1: 
                                // JavaLine 48 ==> SourceLine 1362
                                Nconst=new CHECKER1$semchecker1$boolconst(((CHECKER1$semchecker1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$identifier)(CUR$.SL$)).p$pred,((CHECKER1)(CUR$.SL$.SL$.SL$)).ICONS).STM$();
                                case 2: 
                                // JavaLine 51 ==> SourceLine 1364
                                Nconst=new CHECKER1$semchecker1$charconst(((CHECKER1$semchecker1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$identifier)(CUR$.SL$)).p$pred,((CHECKER1)(CUR$.SL$.SL$.SL$)).ICONS).STM$();
                                case 3: 
                                case 4: 
                                case 5: 
                                case 6: 
                                // JavaLine 57 ==> SourceLine 1367
                                Nconst=new CHECKER1$semchecker1$arithconst(((CHECKER1$semchecker1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$identifier)(CUR$.SL$)).p$pred,((CHECKER1)(CUR$.SL$.SL$.SL$)).ICONS).STM$();
                                case 7: 
                                // JavaLine 60 ==> SourceLine 1369
                                Nconst=new CHECKER1$semchecker1$refconst(((CHECKER1$semchecker1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$identifier)(CUR$.SL$)).p$pred,((CHECKER1)(CUR$.SL$.SL$.SL$)).ICONS).STM$();
                                case 8: 
                                // JavaLine 63 ==> SourceLine 1371
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1371",1371);
                                    Nconst=new CHECKER1$semchecker1$textconst(((CHECKER1$semchecker1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1$identifier)(CUR$.SL$)).p$pred,((CHECKER1)(CUR$.SL$.SL$.SL$)).ICONS).STM$();
                                    // JavaLine 67 ==> SourceLine 1372
                                    Nconst.qual=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).textclass;
                                    // JavaLine 69 ==> SourceLine 1373
                                    ((CHECKER1$semchecker1$textconst)(Nconst)).id=((CHECKER1$semchecker1$identifier)(CUR$.SL$));
                                    TRACE_END_STM$("CompoundStatement1371",1373);
                                }
                            } // END SWITCH STATEMENT
                            // JavaLine 74 ==> SourceLine 1375
                            Nconst.ixhi=inspect$1358$11.blnohi;
                            Nconst.ixlo=inspect$1358$11.blnolo;
                            // JavaLine 77 ==> SourceLine 1376
                            Nconst.type=Nconst.ctype=((CHECKER1$semchecker1$identifier)(CUR$.SL$)).type;
                            Nconst.cl=((CHECKER1$semchecker1)(CUR$.SL$.SL$)).IEEXPcl;
                            // JavaLine 80 ==> SourceLine 1377
                            ((CHECKER1$semchecker1$identifier)(CUR$.SL$)).p$pred=null;
                            ((CHECKER1$semchecker1)(CUR$.SL$.SL$)).exptop=Nconst;
                            TRACE_END_STM$("CompoundStatement1360",1377);
                        }
                        else // OTHERWISE 
                        // JavaLine 86 ==> SourceLine 1379
                        GOTO$(NOTDEF); // GOTO EVALUATED LABEL
                    }
                    TRACE_END_STM$("CompoundStatement1358",1379);
                }
            } else
            // JavaLine 92 ==> SourceLine 1381
            if(VALUE$((((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.special==(((char)3))))) {
                // JavaLine 94 ==> SourceLine 1383
                {
                    TRACE_BEGIN_STM$("CompoundStatement1383",1383);
                    LABEL$(1,"NOTDEF");
                    new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$identifier)(CUR$.SL$)),332);
                    // JavaLine 99 ==> SourceLine 1384
                    ((CHECKER1$semchecker1$identifier)(CUR$.SL$)).meaning.special=((CHECKER1)(CUR$.SL$.SL$.SL$)).NUL;
                    TRACE_END_STM$("CompoundStatement1383",1384);
                }
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
    TRACE_END_STM$("NamedConstant",1384);
    EBLK();
    return(this);
} // End of Procedure BODY
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Procedure NamedConstant",1,1354,11,1383,14,1356,16,1358,34,1357,36,1358,43,1360,48,1362,51,1364,57,1367,60,1369,63,1371,67,1372,69,1373,74,1375,77,1376,80,1377,86,1379,92,1381,94,1383,99,1384,120,1386);
}
