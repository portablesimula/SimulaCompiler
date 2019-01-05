// JavaLine 1 ==> SourceLine 1951
package sportFEC;
// Release-Beta-0.3 Compiled at Sat Jan 05 11:46:13 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class PARSER$grammer$expression extends CLASS$ {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=0, firstLine=1951, lastLine=2235, hasLocalClasses=false, System=false, detachUsed=true
    public int prefixLevel() { return(0); }
    public boolean isDetachUsed() { return(true); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 12 ==> SourceLine 2203
    final LABQNT$ restart=new LABQNT$(this,0,1); // Local Label #1=restart
    // JavaLine 14 ==> SourceLine 2227
    final LABQNT$ EXCALL=new LABQNT$(this,0,2); // Local Label #2=EXCALL
    // Declare locals as attributes
    // JavaLine 17 ==> SourceLine 1953
    public boolean wasNotexpr=false;
    public boolean startexprstmt=false;
    // JavaLine 20 ==> SourceLine 1954
    public boolean NOTblockprefix=false;
    public boolean NOTdesig=false;
    public boolean NOTlhsassig=false;
    public boolean NOTrefexpr=false;
    // JavaLine 25 ==> SourceLine 1962
    public char operatortype=0;
    // JavaLine 27 ==> SourceLine 1963
    public char opnx=0;
    // JavaLine 29 ==> SourceLine 1964
    public char lastsymb=0;
    // JavaLine 31 ==> SourceLine 1966
    public PARSER$grammer$expression ex=null;
    // Normal Constructor
    public PARSER$grammer$expression(RTObject$ staticLink) {
        super(staticLink);
        // Parameter assignment to locals
        BBLK(); // Iff no prefix
        // Declaration Code
        TRACE_BEGIN_DCL$("expression",2200);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,0) {
            public void STM$() {
                TRACE_BEGIN_STM$("expression",2200,inner);
                PARSER$grammer$expression THIS$=(PARSER$grammer$expression)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 48 ==> SourceLine 2202
                        detach();
                        // JavaLine 50 ==> SourceLine 2233
                        LABEL$(1); // restart
                        // JavaLine 52 ==> SourceLine 2203
                        while(true) {
                            // JavaLine 54 ==> SourceLine 2205
                            {
                                TRACE_BEGIN_STM$("CompoundStatement2205",2205);
                                NOTblockprefix=NOTdesig=NOTlhsassig=NOTrefexpr=wasNotexpr=false;
                                // JavaLine 58 ==> SourceLine 2208
                                if(((((PARSER$grammer)(CUR$.SL$)).symboltype.Elt[rank(((PARSER)(CUR$.SL$.SL$)).opt)-((PARSER$grammer)(CUR$.SL$)).symboltype.LB[0]]==(((PARSER$grammer)(CUR$.SL$)).exprtermin))||((startexprstmt&&((((PARSER$grammer)(CUR$.SL$)).symboltype.Elt[rank(((PARSER)(CUR$.SL$.SL$)).opt)-((PARSER$grammer)(CUR$.SL$)).symboltype.LB[0]]==(((PARSER$grammer)(CUR$.SL$)).relop))))))) {
                                    // JavaLine 60 ==> SourceLine 2211
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement2211",2211);
                                        if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).IIDN))) {
                                            ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).ISIDN;
                                        } else
                                        // JavaLine 66 ==> SourceLine 2212
                                        if((((PARSER$grammer)(CUR$.SL$)).cs==(((PARSER)(CUR$.SL$.SL$)).ICONS))) {
                                            // JavaLine 68 ==> SourceLine 2213
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement2213",2213);
                                                NOTblockprefix=NOTdesig=true;
                                                // JavaLine 72 ==> SourceLine 2214
                                                NOTlhsassig=NOTrefexpr=((((PARSER)(CUR$.SL$.SL$)).opdhi!=(((PARSER)(CUR$.SL$.SL$)).NUL))||((((PARSER)(CUR$.SL$.SL$)).opdlo!=(((PARSER)(CUR$.SL$.SL$)).INOTE))));
                                                // JavaLine 74 ==> SourceLine 2216
                                                ((PARSER)(CUR$.SL$.SL$)).opn=((PARSER)(CUR$.SL$.SL$)).ISCST;
                                                TRACE_END_STM$("CompoundStatement2213",2216);
                                            }
                                        } else
                                        // JavaLine 79 ==> SourceLine 2217
                                        GOTO$(EXCALL); // GOTO EVALUATED LABEL
                                        // JavaLine 81 ==> SourceLine 2218
                                        call(((PARSER)(CUR$.SL$.SL$)).coder);
                                        // JavaLine 83 ==> SourceLine 2219
                                        ((PARSER$grammer)(CUR$.SL$)).getopt=false;
                                        ((PARSER$grammer)(CUR$.SL$)).cs=((PARSER)(CUR$.SL$.SL$)).opt;
                                        // JavaLine 86 ==> SourceLine 2221
                                        detach();
                                        // JavaLine 88 ==> SourceLine 2223
                                        GOTO$(restart); // GOTO EVALUATED LABEL
                                        TRACE_END_STM$("CompoundStatement2211",2223);
                                    }
                                }
                                // JavaLine 93 ==> SourceLine 2227
                                LABEL$(2); // EXCALL
                                new PARSER$grammer$expression$exp(((PARSER$grammer$expression)CUR$),false);
                                // JavaLine 96 ==> SourceLine 2228
                                if((lastsymb==(((PARSER)(CUR$.SL$.SL$)).IRGPA))) {
                                    NOTrefexpr=true;
                                } else
                                // JavaLine 100 ==> SourceLine 2229
                                if((lastsymb==(((PARSER)(CUR$.SL$.SL$)).IQUA))) {
                                    NOTlhsassig=NOTrefexpr=true;
                                }
                                // JavaLine 104 ==> SourceLine 2231
                                detach();
                                TRACE_END_STM$("CompoundStatement2205",2231);
                            }
                               if(CODE$==null) break; // Ad'Hoc to prevent JAVAC error'terminate
                        }
                        // JavaLine 110 ==> SourceLine 2202
                        if(inner!=null) {
                            inner.STM$();
                            TRACE_BEGIN_STM_AFTER_INNER$("expression",2202);
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
                TRACE_END_STM$("expression",2202);
                EBLK(); // Iff no prefix
            }
        };
    } // End of Constructor
    // Class Statements
    public PARSER$grammer$expression STM$() { return((PARSER$grammer$expression)CODE$.EXEC$()); }
    public PARSER$grammer$expression START() { START(this); return(this); }
    public static PROGINFO$ INFO$=new PROGINFO$("PARSER.DEF","Class expression",1,1951,12,2203,14,2227,17,1953,20,1954,25,1962,27,1963,29,1964,31,1966,48,2202,50,2233,52,2203,54,2205,58,2208,60,2211,66,2212,68,2213,72,2214,74,2216,79,2217,81,2218,83,2219,86,2221,88,2223,93,2227,96,2228,100,2229,104,2231,110,2202,135,2235);
}
