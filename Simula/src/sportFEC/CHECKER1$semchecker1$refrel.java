// JavaLine 1 ==> SourceLine 273
package sportFEC;
// Release-Beta-0.3 Compiled at Mon Jan 07 11:55:47 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$refrel extends CHECKER1$semchecker1$relation {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=3, firstLine=273, lastLine=340, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(3); }
    // Declare parameters as attributes
    // Declare locals as attributes
    public PRCQNT$ emit$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$refrel$emit.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$refrel(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$exp sp1$left,CHECKER1$semchecker1$exp sp1$right) {
        super(staticLink,sp$pred,sp$ch,sp1$left,sp1$right);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("refrel",308);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,3) {
            public void STM$() {
                TRACE_BEGIN_STM$("refrel",308,inner);
                // JavaLine 22 ==> SourceLine 312
                if((p1$left==(null))) {
                    opttype=((CHECKER1)(CUR$.SL$.SL$)).ITEXT;
                } else
                // JavaLine 26 ==> SourceLine 314
                {
                    TRACE_BEGIN_STM$("CompoundStatement314",314);
                    opttype=p1$left.type;
                    // JavaLine 30 ==> SourceLine 315
                    if((p1$left.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN))) {
                        new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p1$left)));
                    }
                    TRACE_END_STM$("CompoundStatement314",315);
                }
                // JavaLine 36 ==> SourceLine 317
                if((p1$right.ctype==(((CHECKER1)(CUR$.SL$.SL$)).IIDN))) {
                    new CHECKER1$semchecker1$checkasexp(((CHECKER1$semchecker1)(CUR$.SL$)),((CHECKER1$semchecker1$identifier)(p1$right)));
                }
                // JavaLine 40 ==> SourceLine 318
                cl=((CHECKER1$semchecker1)(CUR$.SL$)).IEEXPcl;
                // JavaLine 42 ==> SourceLine 319
                ctype=((CHECKER1)(CUR$.SL$.SL$)).IEQ;
                // JavaLine 44 ==> SourceLine 321
                switch(opttype) { // BEGIN SWITCH STATEMENT
                case 7: 
                case 8: 
                // JavaLine 48 ==> SourceLine 323
                if((opttype!=(p1$right.type))) {
                    // JavaLine 50 ==> SourceLine 324
                    {
                        TRACE_BEGIN_STM$("CompoundStatement324",324);
                        if(((p1$right.type!=(((CHECKER1)(CUR$.SL$.SL$)).IREF))&&((p1$right.type!=(((CHECKER1)(CUR$.SL$.SL$)).ITEXT))))) {
                            // JavaLine 54 ==> SourceLine 326
                            new ERRMSG$error2xx(((CHECKER1)(CUR$.SL$.SL$)),432,p1$right.type,p$ch);
                        } else
                        new CHECKER1$semchecker1$exp$incompTypes(((CHECKER1$semchecker1$refrel)CUR$),opttype,p1$right.type);
                        TRACE_END_STM$("CompoundStatement324",326);
                    }
                }
                case 9: 
                // JavaLine 62 ==> SourceLine 330
                {
                    TRACE_BEGIN_STM$("CompoundStatement330",330);
                    if((opttype!=(p1$right.type))) {
                        // JavaLine 66 ==> SourceLine 331
                        {
                            TRACE_BEGIN_STM$("CompoundStatement331",331);
                            if((p1$right.type!=(((CHECKER1)(CUR$.SL$.SL$)).IREF))) {
                                // JavaLine 70 ==> SourceLine 332
                                new CHECKER1$semchecker1$exp$incompTypes(((CHECKER1$semchecker1$refrel)CUR$),opttype,p1$right.type);
                            }
                            TRACE_END_STM$("CompoundStatement331",332);
                        }
                    }
                    TRACE_END_STM$("CompoundStatement330",332);
                }
                case 15: 
                default:
                // JavaLine 80 ==> SourceLine 336
                {
                    TRACE_BEGIN_STM$("CompoundStatement336",336);
                    new ERRMSG$error2xx(((CHECKER1)(CUR$.SL$.SL$)),431,opttype,p$ch);
                    opttype=((CHECKER1)(CUR$.SL$.SL$)).IELSE;
                    TRACE_END_STM$("CompoundStatement336",336);
                }
            } // END SWITCH STATEMENT
            // JavaLine 88 ==> SourceLine 339
            type=((CHECKER1)(CUR$.SL$.SL$)).IBOOL;
            // JavaLine 90 ==> SourceLine 312
            if(inner!=null) {
                inner.STM$();
                TRACE_BEGIN_STM_AFTER_INNER$("refrel",312);
            }
            TRACE_END_STM$("refrel",312);
        }
    };
} // End of Constructor
// Class Statements
public CHECKER1$semchecker1$refrel STM$() { return((CHECKER1$semchecker1$refrel)CODE$.EXEC$()); }
public CHECKER1$semchecker1$refrel START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class refrel",1,273,22,312,26,314,30,315,36,317,40,318,42,319,44,321,48,323,50,324,54,326,62,330,66,331,70,332,80,336,88,339,90,312,101,340);
}
