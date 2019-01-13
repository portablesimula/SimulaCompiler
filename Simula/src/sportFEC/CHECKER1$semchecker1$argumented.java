// JavaLine 1 ==> SourceLine 1785
package sportFEC;
// Simula-Beta-0.3 Compiled at Sat Jan 12 20:08:42 CET 2019
import simula.runtime.*;
@SuppressWarnings("unchecked")
public class CHECKER1$semchecker1$argumented extends CHECKER1$semchecker1$pre_argumented {
    // ClassDeclaration: BlockKind=Class, BlockLevel=3, PrefixLevel=2, firstLine=1785, lastLine=1951, hasLocalClasses=false, System=false, detachUsed=false
    public int prefixLevel() { return(2); }
    // Declare parameters as attributes
    // Declare local labels
    // JavaLine 11 ==> SourceLine 1852
    final LABQNT$ SEARCH2=new LABQNT$(this,2,1); // Local Label #1=SEARCH2
    // JavaLine 13 ==> SourceLine 1865
    final LABQNT$ OL=new LABQNT$(this,2,2); // Local Label #2=OL
    // JavaLine 15 ==> SourceLine 1882
    final LABQNT$ TYPCHK=new LABQNT$(this,2,3); // Local Label #3=TYPCHK
    // Declare locals as attributes
    // JavaLine 18 ==> SourceLine 1787
    public int i=0;
    public char searched=0;
    public char atype=0;
    public char ftype=0;
    // JavaLine 23 ==> SourceLine 1788
    public COMMON$symbolbox symx=null;
    public COMMON$extquantity q=null;
    public CHECKER1$semchecker1$parameter p=null;
    // JavaLine 27 ==> SourceLine 1834
    public COMMON$extquantity inspect$1834$99=null;
    // JavaLine 29 ==> SourceLine 1933
    public COMMON$quantity inspect$1933$100=null;
    public PRCQNT$ sameAs$0() { return(new PRCQNT$(this,CHECKER1$semchecker1$argumented$sameAs.class)); }
    // Normal Constructor
    public CHECKER1$semchecker1$argumented(RTObject$ staticLink,CHECKER1$semchecker1$exp sp$pred,char sp$ch,CHECKER1$semchecker1$identifier sp1$ident,CHECKER1$semchecker1$argument sp1$arguments,int sp1$noofexpargs,int sp1$noofactargs) {
        super(staticLink,sp$pred,sp$ch,sp1$ident,sp1$arguments,sp1$noofexpargs,sp1$noofactargs);
        // Parameter assignment to locals
        // Declaration Code
        TRACE_BEGIN_DCL$("argumented",1933);
        // Create Class Body
        CODE$=new ClassBody(CODE$,this,2) {
            public void STM$() {
                TRACE_BEGIN_STM$("argumented",1933,inner);
                CHECKER1$semchecker1$argumented THIS$=(CHECKER1$semchecker1$argumented)CUR$;
                LOOP$:while(JTX$>=0) {
                    try {
                        JUMPTABLE$(JTX$); // For ByteCode Engineering
                        // JavaLine 46 ==> SourceLine 1818
                        type=p1$ident.type;
                        qual=p1$ident.qual;
                        meaning=p1$ident.meaning;
                        // JavaLine 50 ==> SourceLine 1819
                        ctype=((CHECKER1)(CUR$.SL$.SL$)).IIDNP;
                        // JavaLine 52 ==> SourceLine 1820
                        if((p$ch==(((CHECKER1)(CUR$.SL$.SL$)).IBPRF))) {
                            // JavaLine 54 ==> SourceLine 1823
                            {
                                TRACE_BEGIN_STM$("CompoundStatement1823",1823);
                                if((p1$ident.kind!=(((CHECKER1)(CUR$.SL$.SL$)).K_class))) {
                                    {
                                        TRACE_BEGIN_STM$("CompoundStatement1823",1823);
                                        if((p1$ident.kind!=(((CHECKER1)(CUR$.SL$.SL$)).K_error))) {
                                            // JavaLine 61 ==> SourceLine 1825
                                            {
                                                TRACE_BEGIN_STM$("CompoundStatement1825",1825);
                                                new CHECKER1$semchecker1$identifier$identError(p1$ident,333);
                                                // JavaLine 65 ==> SourceLine 1826
                                                meaning=p1$ident.meaning=null;
                                                TRACE_END_STM$("CompoundStatement1825",1826);
                                            }
                                        }
                                        TRACE_END_STM$("CompoundStatement1823",1826);
                                    }
                                }
                                // JavaLine 73 ==> SourceLine 1828
                                p1$ident.p$ch=((CHECKER1)(CUR$.SL$.SL$)).IBLKB;
                                TRACE_END_STM$("CompoundStatement1823",1828);
                            }
                        } else
                        // JavaLine 78 ==> SourceLine 1832
                        if(IS$(meaning,COMMON$extquantity.class)) {
                            // JavaLine 80 ==> SourceLine 1834
                            {
                                // BEGIN INSPECTION 
                                inspect$1834$99=((COMMON$extquantity)(meaning));
                                if(inspect$1834$99!=null) //INSPECT inspect$1834$99
                                // JavaLine 85 ==> SourceLine 1844
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1844",1844);
                                    if((inspect$1834$99.longindic!=(((CHECKER1)(CUR$.SL$.SL$)).NUL))) {
                                        // JavaLine 89 ==> SourceLine 1845
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1845",1845);
                                            i=rank(inspect$1834$99.longindic);
                                            p=((CHECKER1$semchecker1$parameter)(p1$arguments));
                                            q=((COMMON$extquantity)(((COMMON$quantity)inspect$1834$99)));
                                            // JavaLine 95 ==> SourceLine 1846
                                            searched=p.p$actual.type;
                                            symx=inspect$1834$99.symb;
                                            // JavaLine 98 ==> SourceLine 1847
                                            if((searched==(((CHECKER1)(CUR$.SL$.SL$)).ISHOR))) {
                                                searched=((CHECKER1)(CUR$.SL$.SL$)).IINTG;
                                            }
                                            // JavaLine 102 ==> SourceLine 1848
                                            if((i>(20))) {
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement1848",1848);
                                                    i=(i-(20));
                                                    GOTO$(SEARCH2); // GOTO EVALUATED LABEL
                                                    TRACE_END_STM$("CompoundStatement1848",1848);
                                                }
                                            } else
                                            // JavaLine 111 ==> SourceLine 1849
                                            if((i>(10))) {
                                                // JavaLine 113 ==> SourceLine 1850
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement1850",1850);
                                                    i=(i-(10));
                                                    // JavaLine 117 ==> SourceLine 1851
                                                    if((p.nextarg.p$actual.type>(searched))) {
                                                        // JavaLine 119 ==> SourceLine 1852
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement1852",1852);
                                                            LABEL$(1); // SEARCH2
                                                            searched=p.nextarg.p$actual.type;
                                                            // JavaLine 124 ==> SourceLine 1853
                                                            if((searched==(((CHECKER1)(CUR$.SL$.SL$)).ISHOR))) {
                                                                searched=((CHECKER1)(CUR$.SL$.SL$)).IINTG;
                                                            }
                                                            TRACE_END_STM$("CompoundStatement1852",1853);
                                                        }
                                                    }
                                                    // JavaLine 131 ==> SourceLine 1855
                                                    while((i>=(0))) {
                                                        // JavaLine 133 ==> SourceLine 1856
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement1856",1856);
                                                            if((((COMMON$quantity)(q.descr.fpar.next)).type>=(searched))) {
                                                                // JavaLine 137 ==> SourceLine 1857
                                                                GOTO$(OL); // GOTO EVALUATED LABEL
                                                            }
                                                            // JavaLine 140 ==> SourceLine 1858
                                                            q=((COMMON$extquantity)(q.next));
                                                            i=(i-(1));
                                                            TRACE_END_STM$("CompoundStatement1856",1858);
                                                        }
                                                    }
                                                    TRACE_END_STM$("CompoundStatement1850",1858);
                                                }
                                            } else
                                            // JavaLine 149 ==> SourceLine 1861
                                            if((i>(0))) {
                                                // JavaLine 151 ==> SourceLine 1862
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement1862",1862);
                                                    while((i>=(0))) {
                                                        // JavaLine 155 ==> SourceLine 1863
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement1863",1863);
                                                            if((q.descr.fpar.type>=(searched))) {
                                                                // JavaLine 159 ==> SourceLine 1865
                                                                {
                                                                    TRACE_BEGIN_STM$("CompoundStatement1865",1865);
                                                                    LABEL$(2); // OL
                                                                    ((CHECKER1$semchecker1$argumented)CUR$).p1$ident.meaning=q;
                                                                    // JavaLine 164 ==> SourceLine 1866
                                                                    ((CHECKER1$semchecker1$argumented)CUR$).p1$ident.type=((CHECKER1$semchecker1$exp)CUR$).type=q.type;
                                                                    // JavaLine 166 ==> SourceLine 1868
                                                                    q.symb=symx;
                                                                    // JavaLine 168 ==> SourceLine 1869
                                                                    q=((COMMON$extquantity)(q.descr.fpar));
                                                                    // JavaLine 170 ==> SourceLine 1870
                                                                    while(((q!=(null))&&((p!=(null))))) {
                                                                        // JavaLine 172 ==> SourceLine 1871
                                                                        {
                                                                            TRACE_BEGIN_STM$("CompoundStatement1871",1871);
                                                                            p.p1$formal=q;
                                                                            q=((COMMON$extquantity)(q.next));
                                                                            p=((CHECKER1$semchecker1$parameter)(p.nextarg));
                                                                            TRACE_END_STM$("CompoundStatement1871",1871);
                                                                        }
                                                                    }
                                                                    // JavaLine 181 ==> SourceLine 1873
                                                                    GOTO$(TYPCHK); // GOTO EVALUATED LABEL
                                                                    TRACE_END_STM$("CompoundStatement1865",1873);
                                                                }
                                                            }
                                                            // JavaLine 186 ==> SourceLine 1875
                                                            if((q.clf==(((CHECKER1)(CUR$.SL$.SL$)).Clf005))) {
                                                                q=((COMMON$extquantity)(q.next));
                                                            }
                                                            // JavaLine 190 ==> SourceLine 1877
                                                            q=((COMMON$extquantity)(q.next));
                                                            i=(i-(1));
                                                            TRACE_END_STM$("CompoundStatement1863",1877);
                                                        }
                                                    }
                                                    TRACE_END_STM$("CompoundStatement1862",1877);
                                                }
                                            }
                                            // JavaLine 199 ==> SourceLine 1882
                                            LABEL$(3); // TYPCHK
                                            p=((CHECKER1$semchecker1$parameter)(p1$arguments));
                                            // JavaLine 202 ==> SourceLine 1883
                                            while((p!=(null))) {
                                                // JavaLine 204 ==> SourceLine 1884
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement1884",1884);
                                                    ftype=p.p1$formal.type;
                                                    // JavaLine 208 ==> SourceLine 1885
                                                    if((ftype!=(p.p$actual.type))) {
                                                        // JavaLine 210 ==> SourceLine 1887
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement1887",1887);
                                                            switch(p.p$actual.type) { // BEGIN SWITCH STATEMENT
                                                            case 2: 
                                                            case 3: 
                                                            case 4: 
                                                            case 5: 
                                                            case 6: 
                                                            // JavaLine 219 ==> SourceLine 1890
                                                            switch(ftype) { // BEGIN SWITCH STATEMENT
                                                            case 1: 
                                                            case 7: 
                                                            case 9: 
                                                            case 8: 
                                                            case 14: 
                                                            // JavaLine 226 ==> SourceLine 1893
                                                            new CHECKER1$semchecker1$argument$errARG(p,426);
                                                        } // END SWITCH STATEMENT
                                                        case 15: 
                                                        default:
                                                        // JavaLine 231 ==> SourceLine 1897
                                                        if((ftype<(((CHECKER1)(CUR$.SL$.SL$)).INOTY))) {
                                                            new CHECKER1$semchecker1$argument$errARG(p,426);
                                                        }
                                                    } // END SWITCH STATEMENT
                                                    TRACE_END_STM$("CompoundStatement1887",1897);
                                                }
                                            }
                                            // JavaLine 239 ==> SourceLine 1900
                                            p=((CHECKER1$semchecker1$parameter)(p.nextarg));
                                            TRACE_END_STM$("CompoundStatement1884",1900);
                                        }
                                    }
                                    TRACE_END_STM$("CompoundStatement1845",1900);
                                }
                            }
                            // JavaLine 247 ==> SourceLine 1929
                            if(IS$(p1$arguments,CHECKER1$semchecker1$parameter.class)) {
                                // JavaLine 249 ==> SourceLine 1930
                                {
                                    TRACE_BEGIN_STM$("CompoundStatement1930",1930);
                                    if(((inspect$1834$99.clf==(((CHECKER1)(CUR$.SL$.SL$)).Clf010))|((inspect$1834$99.clf==(((CHECKER1)(CUR$.SL$.SL$)).Clf007))))) {
                                        // JavaLine 253 ==> SourceLine 1931
                                        {
                                            TRACE_BEGIN_STM$("CompoundStatement1931",1931);
                                            p=((CHECKER1$semchecker1$parameter)(p1$arguments));
                                            // JavaLine 257 ==> SourceLine 1932
                                            while((p!=(null))) {
                                                // JavaLine 259 ==> SourceLine 1933
                                                {
                                                    TRACE_BEGIN_STM$("CompoundStatement1933",1933);
                                                    {
                                                        // BEGIN INSPECTION 
                                                        inspect$1933$100=p.p1$formal;
                                                        if(inspect$1933$100!=null) //INSPECT inspect$1933$100
                                                        // JavaLine 266 ==> SourceLine 1934
                                                        {
                                                            TRACE_BEGIN_STM$("CompoundStatement1934",1934);
                                                            if((inspect$1933$100.categ==(((CHECKER1)(CUR$.SL$.SL$)).C_name))) {
                                                                // JavaLine 270 ==> SourceLine 1935
                                                                {
                                                                    TRACE_BEGIN_STM$("CompoundStatement1935",1935);
                                                                    if((p.p$actual.ctype!=(((CHECKER1)(CUR$.SL$.SL$)).IIDN))) {
                                                                        new CHECKER1$semchecker1$argument$errARG(p,433);
                                                                    }
                                                                    // JavaLine 276 ==> SourceLine 1936
                                                                    if((p.p$actual.type!=(inspect$1933$100.type))) {
                                                                        new CHECKER1$semchecker1$argument$errARG(p,434);
                                                                    }
                                                                    TRACE_END_STM$("CompoundStatement1935",1936);
                                                                }
                                                            }
                                                            TRACE_END_STM$("CompoundStatement1934",1936);
                                                        }
                                                    }
                                                    // JavaLine 286 ==> SourceLine 1939
                                                    p=((CHECKER1$semchecker1$parameter)(p.nextarg));
                                                    TRACE_END_STM$("CompoundStatement1933",1939);
                                                }
                                            }
                                            TRACE_END_STM$("CompoundStatement1931",1939);
                                        }
                                    }
                                    TRACE_END_STM$("CompoundStatement1930",1939);
                                }
                            }
                            TRACE_END_STM$("CompoundStatement1844",1939);
                        }
                    }
                }
                // JavaLine 301 ==> SourceLine 1945
                if((p1$noofexpargs!=(p1$noofactargs))) {
                    // JavaLine 303 ==> SourceLine 1946
                    {
                        TRACE_BEGIN_STM$("CompoundStatement1946",1946);
                        ((CHECKER1$semchecker1)(CUR$.SL$)).etxt1=new ERRMSG$qlin(((CHECKER1)(CUR$.SL$.SL$)),p1$ident.meaning).RESULT$;
                        ((CHECKER1$semchecker1)(CUR$.SL$)).etxt2=new COMMON$leftint(((CHECKER1)(CUR$.SL$.SL$)),p1$noofexpargs).RESULT$;
                        // JavaLine 308 ==> SourceLine 1948
                        new ERRMSG$error2(((CHECKER1)(CUR$.SL$.SL$)),(((p1$noofactargs>(p1$noofexpargs)))?(407):(408)),((CHECKER1$semchecker1)(CUR$.SL$)).etxt1,((CHECKER1$semchecker1)(CUR$.SL$)).etxt2);
                        TRACE_END_STM$("CompoundStatement1946",1948);
                    }
                }
                // JavaLine 313 ==> SourceLine 1818
                if(inner!=null) {
                    inner.STM$();
                    TRACE_BEGIN_STM_AFTER_INNER$("argumented",1818);
                }
                break LOOP$;
            }
            catch(LABQNT$ q) {
                CUR$=THIS$;
                if(q.SL$!=CUR$ || q.prefixLevel!=2) {
                    CUR$.STATE$=OperationalState.terminated;
                    if(RT.Option.GOTO_TRACING) TRACE_GOTO("NON-LOCAL",q);
                    throw(q);
                }
                if(RT.Option.GOTO_TRACING) TRACE_GOTO("LOCAL",q);
                JTX$=q.index; continue LOOP$; // EG. GOTO Lx
            }
        }
        TRACE_END_STM$("argumented",1818);
    }
};
} // End of Constructor
// Class Statements
public CHECKER1$semchecker1$argumented STM$() { return((CHECKER1$semchecker1$argumented)CODE$.EXEC$()); }
public CHECKER1$semchecker1$argumented START() { START(this); return(this); }
public static PROGINFO$ INFO$=new PROGINFO$("CHECKER1.DEF","Class argumented",1,1785,11,1852,13,1865,15,1882,18,1787,23,1788,27,1834,29,1933,46,1818,50,1819,52,1820,54,1823,61,1825,65,1826,73,1828,78,1832,80,1834,85,1844,89,1845,95,1846,98,1847,102,1848,111,1849,113,1850,117,1851,119,1852,124,1853,131,1855,133,1856,137,1857,140,1858,149,1861,151,1862,155,1863,159,1865,164,1866,166,1868,168,1869,170,1870,172,1871,181,1873,186,1875,190,1877,199,1882,202,1883,204,1884,208,1885,210,1887,219,1890,226,1893,231,1897,239,1900,247,1929,249,1930,253,1931,257,1932,259,1933,266,1934,270,1935,276,1936,286,1939,301,1945,303,1946,308,1948,313,1818,337,1951);
}
