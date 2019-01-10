// JavaLine 1 ==> SourceLine 1487
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$simpleIdent extends CHECKER1$semchecker1$identifier {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=1487, lastLine=1559, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(2); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare locals as attributes
    public PRCQNT$ sameAs$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$simpleIdent$sameAs.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$simpleIdent(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch) {
        super(staticLink,sp$pred,sp$ch);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("simpleIdent",1493);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("simpleIdent",1493,inner);
                // JavaLine 23 ==> SourceLine 1496
                ctype=((CHECKER1)(CUR$.SL$.SL$)).IIDN;
                // JavaLine 25 ==> SourceLine 1497
                while(true) {
                    // JavaLine 27 ==> SourceLine 1499
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1499",1499);
                        ((CHECKER1$semchecker1)(CUR$.SL$)).exptop=((CHECKER1$semchecker1$identifier)CUR$);
                        // JavaLine 31 ==> SourceLine 1500
                        meaning=new BUILDER1$meaningof(((CHECKER1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb).RESULT$;
                        // JavaLine 33 ==> SourceLine 1502
                        if((meaning==(null))) {
                            // JavaLine 35 ==> SourceLine 1503
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1503",1503);
                                meaning=new ERRMSG$newnotseen(((CHECKER1)(CUR$.SL$.SL$)),((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb).RESULT$;
                                // JavaLine 39 ==> SourceLine 1504
                                type=((CHECKER1)(CUR$.SL$.SL$)).IELSE;
                                kind=((CHECKER1)(CUR$.SL$.SL$)).K_error;
                                // JavaLine 42 ==> SourceLine 1506
                                new ERRMSG$error1id(((CHECKER1)(CUR$.SL$.SL$)),337,((CHECKER1$semchecker1)(CUR$.SL$)).opdSymb);
                                meaning.dim=2;
                                // JavaLine 45 ==> SourceLine 1507
                                qual=null;
                                issimple=0;
                                TRACE_END_STM$("CompoundStatement1503",1507);
                            }
                        } else
                        // JavaLine 51 ==> SourceLine 1510
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1510",1510);
                            type=meaning.type;
                            kind=meaning.kind;
                            // JavaLine 56 ==> SourceLine 1511
                            qual=(((type==(((CHECKER1)(CUR$.SL$.SL$)).ITEXT)))?(((CHECKER1$semchecker1)(CUR$.SL$)).textclass):(meaning.prefqual));
                            // JavaLine 58 ==> SourceLine 1515
                            issimple=1;
                            // JavaLine 60 ==> SourceLine 1516
                            switch(meaning.categ) { // BEGIN SWITCH STATEMENT
                            case 3: 
                            case 4: 
                            // JavaLine 64 ==> SourceLine 1518
                            if((meaning.special>(((char)1)))) {
                                // JavaLine 66 ==> SourceLine 1522
                                new CHECKER1$semchecker1$identifier$NamedConstant(((CHECKER1$semchecker1$simpleIdent)CUR$));
                            } else
                            if(((CHECKER1$semchecker1)(CUR$.SL$)).inarraybound) {
                                // JavaLine 70 ==> SourceLine 1523
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1523",1523);
                                    if((meaning.encl.rtblev==(((CHECKER1)(CUR$.SL$.SL$)).cblev))) {
                                        // JavaLine 74 ==> SourceLine 1525
                                        new ERRMSG$errQT(((CHECKER1)(CUR$.SL$.SL$)),meaning,316);
                                    }
                                    TRACE_END_STM$("CompoundStatement1523",1525);
                                }
                            }
                            case 2: 
                            // JavaLine 81 ==> SourceLine 1526
                            issimple=0;
                            case 6: 
                            // JavaLine 84 ==> SourceLine 1528
                            if(((CHECKER1$semchecker1)(CUR$.SL$)).inarraybound) {
                                new ERRMSG$errQT(((CHECKER1)(CUR$.SL$.SL$)),meaning,312);
                            }
                        } // END SWITCH STATEMENT
                        TRACE_END_STM$("CompoundStatement1510",1528);
                    }
                    // JavaLine 91 ==> SourceLine 1543
                    switch(kind) { // BEGIN SWITCH STATEMENT
                    case 0: 
                    case 3: 
                    // JavaLine 95 ==> SourceLine 1545
                    if((p$ch==(((CHECKER1)(CUR$.SL$.SL$)).IIDNP))) {
                        new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$simpleIdent)CUR$),357);
                    }
                    case 5: 
                    // JavaLine 100 ==> SourceLine 1547
                    if((((CHECKER1$semchecker1)(CUR$.SL$)).opttop!=(0))) {
                        // JavaLine 102 ==> SourceLine 1548
                        {
                            TRACE_BEGIN_STM$("CompoundStatement1548",1548);
                            new CHECKER1$semchecker1$identifier$identError(((CHECKER1$semchecker1$simpleIdent)CUR$),334);
                            type=((CHECKER1)(CUR$.SL$.SL$)).IREF;
                            qual=meaning;
                            // JavaLine 108 ==> SourceLine 1549
                            p$ch=((CHECKER1)(CUR$.SL$.SL$)).INEW;
                            TRACE_END_STM$("CompoundStatement1548",1549);
                        }
                    }
                } // END SWITCH STATEMENT
                // JavaLine 114 ==> SourceLine 1554
                detach();
                // JavaLine 116 ==> SourceLine 1556
                ((CHECKER1$semchecker1)(CUR$.SL$)).simpleList=null;
                cl=((CHECKER1)(CUR$.SL$.SL$)).NUL;
                p$pred=((CHECKER1$semchecker1)(CUR$.SL$)).exptop;
                TRACE_END_STM$("CompoundStatement1499",1556);
            }
               if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
        }
        // JavaLine 124 ==> SourceLine 1496
        if(inner!=null) {
            inner.STM$();
            TRACE_BEGIN_STM_AFTER_INNER$("simpleIdent",1496);
        }
        TRACE_END_STM$("simpleIdent",1496);
    }
};
} // End of Constructor
// Class Statements
public CHECKER1$semchecker1$simpleIdent STM$() { return((CHECKER1$semchecker1$simpleIdent)CODE$.EXEC$()); }
public CHECKER1$semchecker1$simpleIdent START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class simpleIdent",1,1487,23,1496,25,1497,27,1499,31,1500,33,1502,35,1503,39,1504,42,1506,45,1507,51,1510,56,1511,58,1515,60,1516,64,1518,66,1522,70,1523,74,1525,81,1526,84,1528,91,1543,95,1545,100,1547,102,1548,108,1549,114,1554,116,1556,124,1496,135,1559);
}
